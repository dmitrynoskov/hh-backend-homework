package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HhListVacancyResponseDto {
  private List<HhVacancyResponseDto> items;

  public HhListVacancyResponseDto() {
  }

  public HhListVacancyResponseDto(List<HhVacancyResponseDto> items) {
    this.items = items;
  }

  public List<HhVacancyResponseDto> getItems() {
    return items;
  }

  public void setItems(List<HhVacancyResponseDto> items) {
    this.items = items;
  }
}
