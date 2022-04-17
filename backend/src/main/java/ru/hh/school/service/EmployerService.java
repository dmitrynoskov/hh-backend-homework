package ru.hh.school.service;

import ru.hh.school.client.HhApiClient;
import ru.hh.school.dto.employer.EmployerResponseDto;
import ru.hh.school.dto.employer.EmployerShortResponseDto;
import ru.hh.school.mapper.EmployerMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class EmployerService {

  private final HhApiClient hhApiClient;

  @Inject
  public EmployerService(HhApiClient hhApiClient) {
    this.hhApiClient = hhApiClient;
  }

  public List<EmployerShortResponseDto> getEmployers(String text, Integer page, Integer perPage) {
    return hhApiClient
      .getEmployerList(text, page, perPage)
      .getItems()
      .stream()
      .map(EmployerMapper::toShortResponse)
      .collect(Collectors.toList());
  }

  public EmployerResponseDto getEmployerById(Long id) {
    return EmployerMapper.toResponse(hhApiClient.getEmployer(id));
  }

}
