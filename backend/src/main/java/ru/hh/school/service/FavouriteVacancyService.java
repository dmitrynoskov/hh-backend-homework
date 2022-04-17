package ru.hh.school.service;

import ru.hh.school.Popularity;
import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.FavouriteEmployerDao;
import ru.hh.school.dao.FavouriteVacancyDao;
import ru.hh.school.dto.vacancy.FavouriteVacancyResponse;
import ru.hh.school.dto.vacancy.VacancyResponse;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.FavouriteVacancy;
import ru.hh.school.mapper.VacancyMapper;
import ru.hh.school.util.TransactionHelper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class FavouriteVacancyService {

  private final VacancyService vacancyService;
  private final AreaDao areaDao;
  private final FavouriteVacancyDao favouriteVacancyDao;
  private final FavouriteEmployerDao favouriteEmployerDao;
  private final TransactionHelper transactionHelper;

  @Inject
  public FavouriteVacancyService(VacancyService vacancyService,
                                 AreaDao areaDao,
                                 FavouriteVacancyDao favouriteVacancyDao,
                                 FavouriteEmployerDao favouriteEmployerDao,
                                 TransactionHelper transactionHelper) {
    this.vacancyService = vacancyService;
    this.areaDao = areaDao;
    this.favouriteVacancyDao = favouriteVacancyDao;
    this.favouriteEmployerDao = favouriteEmployerDao;
    this.transactionHelper = transactionHelper;
  }

  public boolean addVacancy(Long vacancyId, String comment) {
    VacancyResponse vacancyResponse = vacancyService.getVacancyById(vacancyId);
    FavouriteVacancy favouriteVacancy = VacancyMapper.toVacancyEntity(vacancyResponse, comment);
    Area area = favouriteVacancy.getArea();
    transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(area);
      favouriteVacancyDao.save(favouriteVacancy);
    });
    return true;
  }

  public List<FavouriteVacancyResponse> getVacancies(Integer page, Integer perPage) {
    List<FavouriteVacancy> vacancyList = transactionHelper.
      inTransaction(() -> {
        List<FavouriteVacancy> vacancies = favouriteVacancyDao.getListSorted(page * page, perPage);
        vacancies.forEach(vacancy -> {
          favouriteVacancyDao.updateViewsCount(vacancy);
          favouriteEmployerDao.updateViewsCountIfExists(vacancy.getEmployerId());
        });
        return vacancies;
      });
    return vacancyList.stream()
      .map(VacancyMapper::toFavouriteResponse)
      .collect(Collectors.toList());
  }

  public boolean updateComment(Long vacancyId, String comment) {
    transactionHelper.inTransaction(() -> {
      FavouriteVacancy favouriteVacancy = favouriteVacancyDao.get(FavouriteVacancy.class, vacancyId);
      favouriteVacancy.setComment(comment);
      favouriteVacancyDao.update(favouriteVacancy);
    });
    return true;
  }

  public boolean delete(Long vacancyId) {
    transactionHelper.inTransaction(() -> {
      favouriteVacancyDao.delete(vacancyId);
    });
    return true;
  }

  public boolean refresh(Long vacancyId) {
    VacancyResponse vacancyResponse = vacancyService.getVacancyById(vacancyId);
    FavouriteVacancy freshVacancy = VacancyMapper.toVacancyEntity(vacancyResponse, "");
    Area freshArea = freshVacancy.getArea();
    transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(freshArea);
      FavouriteVacancy oldVacancy = favouriteVacancyDao.get(FavouriteVacancy.class, freshVacancy.getId());
      oldVacancy.setName(freshVacancy.getName());
      oldVacancy.setDateCreation(freshVacancy.getDateCreation());
      oldVacancy.setArea(freshArea);
      oldVacancy.setSalaryFrom(freshVacancy.getSalaryFrom());
      oldVacancy.setSalaryTo(freshVacancy.getSalaryTo());
      oldVacancy.setSalaryCurrency(freshVacancy.getSalaryCurrency());
      oldVacancy.setSalaryGross(freshVacancy.getSalaryGross());
      oldVacancy.setEmployerId(freshVacancy.getEmployerId());
      oldVacancy.setEmployerName(freshVacancy.getEmployerName());
      favouriteVacancyDao.update(oldVacancy);
    });
    return true;
  }

}
