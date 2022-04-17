package ru.hh.school.mapper;

import ru.hh.school.dto.Popularity;
import ru.hh.school.dto.employer.EmployerShortResponseDto;
import ru.hh.school.dto.vacancy.FavouriteVacancyResponseDto;
import ru.hh.school.dto.vacancy.HhVacancyResponseDto;
import ru.hh.school.dto.vacancy.SalaryDto;
import ru.hh.school.dto.vacancy.VacancyResponseDto;
import ru.hh.school.entity.FavouriteVacancy;

public class VacancyMapper extends CommonMapper {

  public static VacancyResponseDto toResponse(HhVacancyResponseDto hhVacancyResponseDto) {
    return new VacancyResponseDto(
      hhVacancyResponseDto.getId(),
      hhVacancyResponseDto.getName(),
      hhVacancyResponseDto.getArea(),
      hhVacancyResponseDto.getSalary(),
      hhVacancyResponseDto.getCreatedAt(),
      EmployerMapper.toShortResponse(hhVacancyResponseDto.getEmployer())
    );
  }

  public static FavouriteVacancy toVacancyEntity(VacancyResponseDto vacancyResponseDto, String comment) {
    return new FavouriteVacancy(
      vacancyResponseDto.getId(),
      vacancyResponseDto.getName(),
      vacancyResponseDto.getCreatedAt(),
      toAreaEntity(vacancyResponseDto.getArea()),
      vacancyResponseDto.getSalary().getFrom(),
      vacancyResponseDto.getSalary().getTo(),
      vacancyResponseDto.getSalary().getCurrency(),
      vacancyResponseDto.getSalary().getGross(),
      getFormattedTime(),
      vacancyResponseDto.getEmployer().getId(),
      vacancyResponseDto.getEmployer().getName(),
      Popularity.REGULAR,
      0,
      comment
    );
  }

  public static FavouriteVacancyResponseDto toFavouriteResponse(FavouriteVacancy favouriteVacancy) {
    return new FavouriteVacancyResponseDto(
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

  private static EmployerShortResponseDto toEmployerShortResponse(FavouriteVacancy favouriteVacancy) {
    return new EmployerShortResponseDto(favouriteVacancy.getEmployerId(), favouriteVacancy.getEmployerName());
  }

}
