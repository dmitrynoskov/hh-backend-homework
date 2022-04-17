package ru.hh.school.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.hh.nab.common.properties.FileSettings;

import javax.inject.Inject;
import java.io.Serializable;

public class GenericDao {
  private final SessionFactory sessionFactory;
  protected final Integer popularityLimit;

  @Inject
  public GenericDao(SessionFactory sessionFactory, FileSettings fileSettings) {
    this.sessionFactory = sessionFactory;
    popularityLimit = fileSettings.getInteger("popularity.limit");
  }

  public <T> T get(Class<T> clazz, Serializable id) {
    return getSession().get(clazz, id);
  }

  public void save(Object object) {
    if (object == null) {
      return;
    }
    getSession().save(object);
  }

  public void delete(Object object) {
    if (object == null) {
      return;
    }
    getSession().remove(object);
  }

  public void update(Object object) {
    if (object == null) {
      return;
    }
    getSession().update(object);
  }

  public void saveOrUpdate(Object object) {
    if (object == null) {
      return;
    }
    getSession().saveOrUpdate(object);
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }
}
