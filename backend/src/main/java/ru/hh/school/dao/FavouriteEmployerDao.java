/*
package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import ru.hh.school.entity.FavouriteEmployer;

import javax.inject.Inject;
import java.util.List;

public class FavouriteEmployerDao extends GenericDao {

  public FavouriteEmployerDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public void delete(Long id) {
    if (id == null) {
      return;
    }
    FavouriteEmployer favouriteEmployer = getSession().find(FavouriteEmployer.class, id);
    getSession().remove(favouriteEmployer);
  }

  public List<FavouriteEmployer> getListSorted(int offset, int limit) {
    return getSession()
      .createQuery("select employer from FavouriteEmployer employer join fetch employer.area order by employer.id", FavouriteEmployer.class)
      .setFirstResult(offset)
      .setMaxResults(limit)
      .list();
  }

}
*/
