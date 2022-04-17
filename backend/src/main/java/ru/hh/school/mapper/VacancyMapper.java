package ru.hh.school.mapper;

import ru.hh.school.Popularity;
import ru.hh.school.dto.employer.EmployerShortResponse;
import ru.hh.school.dto.vacancy.FavouriteVacancyResponse;
import ru.hh.school.dto.vacancy.HhVacancyResponse;
import ru.hh.school.dto.vacancy.SalaryDto;
import ru.hh.school.dto.vacancy.VacancyResponse;
import ru.hh.school.entity.FavouriteVacancy;

public class VacancyMapper extends CommonMapper {

  public static VacancyResponse toResponse(HhVacancyResponse hhVacancyResponse) {
    return new VacancyResponse(
      hhVacancyResponse.getId(),
      hhVacancyResponse.getName(),
      hhVacancyResponse.getArea(),
      hhVacancyResponse.getSalary(),
      hhVacancyResponse.getCreatedAt(),
      EmployerMapper.toShortResponse(hhVacancyResponse.getEmployer())
    );
  }

  public static FavouriteVacancy toVacancyEntity(VacancyResponse vacancyResponse, String comment) {
    return new FavouriteVacancy(
      vacancyResponse.getId(),
      vacancyResponse.getName(),
      vacancyResponse.getCreatedAt(),
      toAreaEntity(vacancyResponse.getArea()),
      vacancyResponse.getSalary().getFrom(),
      vacancyResponse.getSalary().getTo(),
      vacancyResponse.getSalary().getCurrency(),
      vacancyResponse.getSalary().getGross(),
      getFormattedTime(),
      vacancyResponse.getEmployer().getId(),
      vacancyResponse.getEmployer().getName(),
      Popularity.REGULAR,
      0,
      comment
    );
  }

  public static FavouriteVacancyResponse toFavouriteResponse(FavouriteVacancy favouriteVacancy) {
    return new FavouriteVacancyResponse(
      favouriteVacancy.getId(),
      favouriteVacancy.getName(),
      favouriteVacancy.getDateCreation(),
      toAreaDto(favouriteVacancy.getArea()),
      toSalaryDto(favouriteVacancy),
      favouriteVacancy.getCreatedAt(),
      toEmployerShortResponse(favouriteVacancy),
      favouriteVacancy.getPopularity(),
      favouriteVacancy.getViewsCount(),
      favouriteVacancy.getComment()
    );
  }

  private static SalaryDto toSalaryDto(FavouriteVacancy favouriteVacancy) {
    return new SalaryDto(
      favouriteVacancy.getSalaryTo(),
      favouriteVacancy.getSalaryFrom(),
      favouriteVacancy.getSalaryCurrency(),
      favouriteVacancy.getSalaryGross()
    );
  }

  private static EmployerShortResponse toEmployerShortResponse(FavouriteVacancy favouriteVacancy) {
    return new EmployerShortResponse(favouriteVacancy.getEmployerId(), favouriteVacancy.getEmployerName());
  }

}
