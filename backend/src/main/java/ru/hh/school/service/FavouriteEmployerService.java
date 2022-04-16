/*
package ru.hh.school.service;

import ru.hh.school.client.HhApiClient;
import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.FavouriteEmployerDao;
import ru.hh.school.dto.employer.EmployerResponse;
import ru.hh.school.dto.employer.FavouriteEmployerResponse;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.FavouriteEmployer;
import ru.hh.school.mapper.EmployerMapper;
import ru.hh.school.util.TransactionHelper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class FavouriteEmployerService {

  private final HhApiClient hhApiClient;
  private final EmployerService employerService;
  private final AreaDao areaDao;
  private final FavouriteEmployerDao favouriteEmployerDao;
  private final TransactionHelper transactionHelper;

  @Inject
  public FavouriteEmployerService(HhApiClient hhApiClient,
                                  EmployerService employerService,
                                  AreaDao areaDao,
                                  FavouriteEmployerDao favouriteEmployerDao,
                                  TransactionHelper transactionHelper) {
    this.hhApiClient = hhApiClient;
    this.employerService = employerService;
    this.areaDao = areaDao;
    this.favouriteEmployerDao = favouriteEmployerDao;
    this.transactionHelper = transactionHelper;
  }
    //todo viewCount, popularity
  public boolean addEmployer(Long employerId, String comment) {
    //todo - that's all?
    EmployerResponse employerResponse = employerService.getEmployerById(employerId);
    FavouriteEmployer favouriteEmployer = EmployerMapper.toEmployerEntity(employerResponse);
    Area area = favouriteEmployer.getArea();
    transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(area);
      favouriteEmployerDao.saveOrUpdate(favouriteEmployer);
    });
    return true;
  }

  public List<FavouriteEmployerResponse> getEmployers(Integer page, Integer perPage) {
    List<FavouriteEmployer> employersList = transactionHelper.
      inTransaction(() -> favouriteEmployerDao.getListSorted(page * page, perPage));
    return employersList.stream()
      .map(EmployerMapper::toFavouriteResponse)
      .collect(Collectors.toList());
  }

  public boolean updateComment(Long employerId, String comment) {
    transactionHelper.inTransaction(() -> {
      FavouriteEmployer favouriteEmployer = favouriteEmployerDao.get(FavouriteEmployer.class, employerId);
      favouriteEmployer.setComment(comment);
      favouriteEmployerDao.update(favouriteEmployer);
    });
    return true;
  }

  public boolean delete(Long employerId) {
    //todo ??
    transactionHelper.inTransaction(() -> {
      favouriteEmployerDao.delete(employerId);
    });
    return true;
  }

  public boolean refresh(Long employerId) {
    //todo ??
    EmployerResponse employerResponse = employerService.getEmployerById(employerId);
    FavouriteEmployer freshEmployer = EmployerMapper.toEmployerEntity(employerResponse);
    Area freshArea = freshEmployer.getArea();
    transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(freshArea);
      FavouriteEmployer oldEmployer = favouriteEmployerDao.get(FavouriteEmployer.class, freshEmployer.getId());
      oldEmployer.setName(freshEmployer.getName());
      oldEmployer.setDescription(freshEmployer.getDescription());
      oldEmployer.setCreationDate(freshEmployer.getCreationDate());
      oldEmployer.setArea(freshArea);
      favouriteEmployerDao.update(oldEmployer);
    });
    return true;
  }

}
*/
