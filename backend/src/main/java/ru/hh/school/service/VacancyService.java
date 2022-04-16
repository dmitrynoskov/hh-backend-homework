package ru.hh.school.service;

import ru.hh.school.client.HhApiClient;
import ru.hh.school.dto.employer.EmployerResponse;
import ru.hh.school.dto.vacancy.HhVacancyResponse;
import ru.hh.school.dto.vacancy.VacancyResponse;
import ru.hh.school.mapper.VacancyMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class VacancyService {

  private final HhApiClient hhApiClient;

  @Inject
  public VacancyService(HhApiClient hhApiClient) {
    this.hhApiClient = hhApiClient;
  }

  public List<VacancyResponse> getVacancies(String text, Integer page, Integer perPage) {
    return hhApiClient
      .getVacancyList(text, page, perPage)
      .getItems()
      .stream()
      .map(VacancyMapper::toResponse)
      .collect(Collectors.toList());
  }

  public VacancyResponse getVacancyById(Long id) {
    return VacancyMapper.toResponse(hhApiClient.getVacancy(id));
  }

}
