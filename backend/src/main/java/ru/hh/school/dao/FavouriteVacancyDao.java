package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.school.Popularity;
import ru.hh.school.entity.FavouriteVacancy;

import java.util.List;

@Repository
public class FavouriteVacancyDao extends GenericDao {

  public FavouriteVacancyDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public void delete(Long id) {
    if (id == null) {
      return;
    }
    FavouriteVacancy favouriteVacancy = getSession().find(FavouriteVacancy.class, id);
    getSession().remove(favouriteVacancy);
  }

  public void updateViewsCount(FavouriteVacancy favouriteVacancy) {
    favouriteVacancy.setViewsCount(favouriteVacancy.getViewsCount() + 1);
    if (favouriteVacancy.getViewsCount() > 50) {
      favouriteVacancy.setPopularity(Popularity.POPULAR);
    }
    update(favouriteVacancy);
  }

  public List<FavouriteVacancy> getListSorted(int offset, int limit) {
    return getSession()
      .createQuery("select vacancy from FavouriteVacancy vacancy join fetch vacancy.area order by vacancy.name", FavouriteVacancy.class)
      .setFirstResult(offset)
      .setMaxResults(limit)
      .list();
  }

}
