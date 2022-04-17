package ru.hh.school.service;

import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.FavouriteEmployerDao;
import ru.hh.school.dto.employer.EmployerResponseDto;
import ru.hh.school.dto.employer.FavouriteEmployerResponseDto;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.FavouriteEmployer;
import ru.hh.school.mapper.EmployerMapper;
import ru.hh.school.util.TransactionHelper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class FavouriteEmployerService {

  private final EmployerService employerService;
  private final AreaDao areaDao;
  private final FavouriteEmployerDao favouriteEmployerDao;
  private final TransactionHelper transactionHelper;

  @Inject
  public FavouriteEmployerService(EmployerService employerService,
                                  AreaDao areaDao,
                                  FavouriteEmployerDao favouriteEmployerDao,
                                  TransactionHelper transactionHelper) {
    this.employerService = employerService;
    this.areaDao = areaDao;
    this.favouriteEmployerDao = favouriteEmployerDao;
    this.transactionHelper = transactionHelper;
  }

  public boolean addEmployer(Long employerId, String comment) {
    EmployerResponseDto employerResponseDto = employerService.getEmployerById(employerId);
    FavouriteEmployer favouriteEmployer = EmployerMapper.toEmployerEntity(employerResponseDto, comment);
    Area area = favouriteEmployer.getArea();
    return transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(area);
      if (favouriteEmployerDao.get(FavouriteEmployer.class, favouriteEmployer.getId()) != null) {
        return false;
      }
      favouriteEmployerDao.save(favouriteEmployer);
      return true;
    });
  }

  public List<FavouriteEmployerResponseDto> getEmployers(Integer page, Integer perPage) {
    List<FavouriteEmployer> employersList = transactionHelper.
      inTransaction(() -> {
        List<FavouriteEmployer> employers = favouriteEmployerDao.getListSorted(page * page, perPage);
        employers.forEach(favouriteEmployerDao::updateViewsCount);
        return employers;
      });
    return employersList.stream()
      .map(EmployerMapper::toFavouriteResponse)
      .collect(Collectors.toList());
  }

  public boolean updateComment(Long employerId, String comment) {
    return transactionHelper.inTransaction(() -> {
      FavouriteEmployer favouriteEmployer = favouriteEmployerDao.get(FavouriteEmployer.class, employerId);
      if (favouriteEmployer != null) {
        favouriteEmployer.setComment(comment);
        favouriteEmployerDao.update(favouriteEmployer);
        return true;
      }
      return false;
    });
  }

  public boolean delete(Long employerId) {
    return transactionHelper.inTransaction(() -> {
      FavouriteEmployer favouriteEmployer = favouriteEmployerDao.get(FavouriteEmployer.class, employerId);
      if (favouriteEmployer != null) {
        favouriteEmployerDao.delete(favouriteEmployer);
        return true;
      }
      return false;
    });
  }

  public boolean refresh(Long employerId) {
    EmployerResponseDto employerResponseDto = employerService.getEmployerById(employerId);
    FavouriteEmployer freshEmployer = EmployerMapper.toEmployerEntity(employerResponseDto, "");
    Area freshArea = freshEmployer.getArea();
    return transactionHelper.inTransaction(() -> {
      areaDao.saveOrUpdate(freshArea);
      FavouriteEmployer oldEmployer = favouriteEmployerDao.get(FavouriteEmployer.class, freshEmployer.getId());
      if (oldEmployer != null) {
        oldEmployer.setName(freshEmployer.getName());
        oldEmployer.setDescription(freshEmployer.getDescription());
        oldEmployer.setCreationDate(freshEmployer.getCreationDate());
        oldEmployer.setArea(freshArea);
        favouriteEmployerDao.update(oldEmployer);
        return true;
      }
      return false;
    });
  }

}
