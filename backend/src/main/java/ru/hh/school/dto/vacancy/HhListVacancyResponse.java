package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HhListVacancyResponse {
  private List<HhVacancyResponse> items;

  public HhListVacancyResponse() {
  }

  public HhListVacancyResponse(List<HhVacancyResponse> items) {
    this.items = items;
  }

  public List<HhVacancyResponse> getItems() {
    return items;
  }

  public void setItems(List<HhVacancyResponse> items) {
    this.items = items;
  }
}
