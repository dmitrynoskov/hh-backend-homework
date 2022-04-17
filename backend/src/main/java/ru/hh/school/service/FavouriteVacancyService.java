package ru.hh.school.service;

import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.FavouriteEmployerDao;
import ru.hh.school.dao.FavouriteVacancyDao;
import ru.hh.school.dto.vacancy.FavouriteVacancyResponseDto;
import ru.hh.school.dto.vacancy.VacancyResponseDto;
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
    VacancyResponseDto vacancyResponseDto = vacancyService.getVacancyById(vacancyId);
    FavouriteVacancy favouriteVacancy = VacancyMapper.toVacancyEntity(vacancyResponseDto, comment);
    Area area = favouriteVacancy.getArea();
    return transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(area);
      if (favouriteVacancyDao.get(FavouriteVacancy.class, vacancyId) != null) {
        return false;
      }
      favouriteVacancyDao.save(favouriteVacancy);
      return true;
    });
  }

  public List<FavouriteVacancyResponseDto> getVacancies(Integer page, Integer perPage) {
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
   return transactionHelper.inTransaction(() -> {
      FavouriteVacancy favouriteVacancy = favouriteVacancyDao.get(FavouriteVacancy.class, vacancyId);
      if (favouriteVacancy != null) {
        favouriteVacancy.setComment(comment);
        favouriteVacancyDao.update(favouriteVacancy);
        return true;
      }
      return false;
    });
  }

  public boolean delete(Long vacancyId) {
    return transactionHelper.inTransaction(() -> {
      FavouriteVacancy favouriteVacancy = favouriteVacancyDao.get(FavouriteVacancy.class, vacancyId);
      if (favouriteVacancy != null) {
        favouriteVacancyDao.delete(favouriteVacancy);
        return true;
      }
      return false;
    });
  }

  public boolean refresh(Long vacancyId) {
    VacancyResponseDto vacancyResponseDto = vacancyService.getVacancyById(vacancyId);
    FavouriteVacancy freshVacancy = VacancyMapper.toVacancyEntity(vacancyResponseDto, "");
    Area freshArea = freshVacancy.getArea();
    return transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(freshArea);
      FavouriteVacancy oldVacancy = favouriteVacancyDao.get(FavouriteVacancy.class, freshVacancy.getId());
      if (oldVacancy != null) {
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
        return true;
      }
      return false;
    });
  }

}
