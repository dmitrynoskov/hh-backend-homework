package ru.hh.school.client;

import ru.hh.school.dto.employer.HhEmployerResponse;
import ru.hh.school.dto.employer.HhListEmployerResponse;
import ru.hh.school.dto.vacancy.HhListVacancyResponse;
import ru.hh.school.dto.vacancy.HhVacancyResponse;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@Singleton
public class HhApiClient {

  private static final String HH_API_URI = "https://api.hh.ru";
  private static final String EMPLOYER_ENDPOINT = "employers";
  private static final String VACANCY_ENDPOINT = "vacancies";
  private static final String AGENT_HEADER = "User-Agent";
  private static final String AGENT_VALUE = "Dmitry Noskov";

  private Client client = ClientBuilder.newClient();

  public HhEmployerResponse getEmployer(Long id) {
    return client.target(HH_API_URI)
      .path(EMPLOYER_ENDPOINT)
      .path("/" + id)
      .request(MediaType.APPLICATION_JSON)
      .get(HhEmployerResponse.class);
  }

  public HhListEmployerResponse getEmployerList(String text, Integer page, Integer perPage) {
    return client.target(HH_API_URI)
      .path(EMPLOYER_ENDPOINT)
      .queryParam("text", text)
      .queryParam("page", page.toString())
      .queryParam("per_page", perPage.toString())
      .request(MediaType.APPLICATION_JSON)
      .get(HhListEmployerResponse.class);
  }

  public HhVacancyResponse getVacancy(Long id) {
    return client.target(HH_API_URI + "/" + VACANCY_ENDPOINT + "/" + id)
      //.path(VACANCY_ENDPOINT)
      //.path("/" + id)
      .request(MediaType.APPLICATION_JSON)
      .header(AGENT_HEADER, AGENT_VALUE)
      .get(HhVacancyResponse.class);
  }

  public HhListVacancyResponse getVacancyList(String text, Integer page, Integer perPage) {
    return client.target(HH_API_URI)
      .path(VACANCY_ENDPOINT)
      .queryParam("text", text)
      .queryParam("page", page.toString())
      .queryParam("per_page", perPage.toString())
      .request(MediaType.APPLICATION_JSON)
      .header(AGENT_HEADER, AGENT_VALUE)
      .get(HhListVacancyResponse.class);
  }

}
