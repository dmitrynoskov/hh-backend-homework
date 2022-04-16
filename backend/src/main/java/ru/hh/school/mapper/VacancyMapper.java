package ru.hh.school.mapper;

import ru.hh.school.dto.vacancy.HhVacancyResponse;
import ru.hh.school.dto.vacancy.VacancyResponse;

public class VacancyMapper {

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
}
