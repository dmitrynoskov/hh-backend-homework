package ru.hh.school.client;

import ru.hh.nab.common.properties.FileSettings;
import ru.hh.school.dto.employer.HhEmployerResponseDto;
import ru.hh.school.dto.employer.HhListEmployerResponseDto;
import ru.hh.school.dto.vacancy.HhListVacancyResponseDto;
import ru.hh.school.dto.vacancy.HhVacancyResponseDto;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

@Singleton
public class HhApiClient {

  private final String EMPLOYER_ENDPOINT;
  private final String VACANCY_ENDPOINT;
  private final String AGENT_HEADER;
  private final String AGENT_VALUE;

  private final Client client;

  @Inject
  public HhApiClient(Client client, FileSettings fileSettings) {
    this.client = client;
    EMPLOYER_ENDPOINT = fileSettings.getString("hh.api.employer");
    VACANCY_ENDPOINT = fileSettings.getString("hh.api.vacancy");
    AGENT_HEADER = fileSettings.getString("hh.api.header");
    AGENT_VALUE = fileSettings.getString("hh.api.agent");
  }

  public HhEmployerResponseDto getEmployer(Long id) {
    return client.target(EMPLOYER_ENDPOINT)
      .path("/" + id)
      .request(MediaType.APPLICATION_JSON)
      .get(HhEmployerResponseDto.class);
  }

  public HhListEmployerResponseDto getEmployerList(String text, Integer page, Integer perPage) {
    return client.target(EMPLOYER_ENDPOINT)
      .queryParam("text", text)
      .queryParam("page", page.toString())
      .queryParam("per_page", perPage.toString())
      .request(MediaType.APPLICATION_JSON)
      .get(HhListEmployerResponseDto.class);
  }

  public HhVacancyResponseDto getVacancy(Long id) {
    return client.target(VACANCY_ENDPOINT)
      .path("/" + id)
      .request(MediaType.APPLICATION_JSON)
      .header(AGENT_HEADER, AGENT_VALUE)
      .get(HhVacancyResponseDto.class);
  }

  public HhListVacancyResponseDto getVacancyList(String text, Integer page, Integer perPage) {
    return client.target(VACANCY_ENDPOINT)
      .queryParam("text", text)
      .queryParam("page", page.toString())
      .queryParam("per_page", perPage.toString())
      .request(MediaType.APPLICATION_JSON)
      .header(AGENT_HEADER, AGENT_VALUE)
      .get(HhListVacancyResponseDto.class);
  }

}
