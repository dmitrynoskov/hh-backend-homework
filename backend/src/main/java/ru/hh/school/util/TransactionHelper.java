package ru.hh.school.util;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.function.Supplier;

@Singleton
public class TransactionHelper {
  private final SessionFactory sessionFactory;

  @Inject
  public TransactionHelper(SessionFactory sessionFactory){
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public <T> T inTransaction(Supplier<T> supplier) {
    Optional<Transaction> transaction = beginTransaction();
    try {
      T result = supplier.get();
      transaction.ifPresent(Transaction::commit);
      return result;
    } catch (RuntimeException e) {
      transaction
        .filter(Transaction::isActive)
        .ifPresent(Transaction::rollback);
      throw e;
    }
  }

  @Transactional
  public void inTransaction(Runnable runnable) {
    inTransaction(() -> {
      runnable.run();
      return null;
    });
  }

  private Optional<Transaction> beginTransaction() {
    Transaction transaction = sessionFactory.getCurrentSession().getTransaction();
    if (transaction.isActive()) {
      return Optional.empty();
    }
    transaction.begin();
    return Optional.of(transaction);
  }

}
