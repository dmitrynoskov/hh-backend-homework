package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.school.Popularity;
import ru.hh.school.entity.FavouriteEmployer;

import java.util.List;

@Repository
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

  public void updateViewsCountIfExists(Long id) {
    FavouriteEmployer favouriteEmployer = getSession().find(FavouriteEmployer.class, id);
    if (favouriteEmployer == null) {
      return;
    }
    updateViewsCount(favouriteEmployer);
  }

  public void updateViewsCount(FavouriteEmployer favouriteEmployer) {
    favouriteEmployer.setViewsCount(favouriteEmployer.getViewsCount() + 1);
    if (favouriteEmployer.getViewsCount() > 50) {
      favouriteEmployer.setPopularity(Popularity.POPULAR);
    }
    update(favouriteEmployer);
  }

  public List<FavouriteEmployer> getListSorted(int offset, int limit) {
    return getSession()
      .createQuery("select employer from FavouriteEmployer employer join fetch employer.area order by employer.name", FavouriteEmployer.class)
      .setFirstResult(offset)
      .setMaxResults(limit)
      .list();
  }

}
