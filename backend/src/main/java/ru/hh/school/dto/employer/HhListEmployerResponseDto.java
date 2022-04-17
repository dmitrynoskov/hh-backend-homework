package ru.hh.school.dto.employer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HhListEmployerResponseDto {
  private List<HhEmployerResponseDto> items;

  public HhListEmployerResponseDto() {
  }

  public HhListEmployerResponseDto(List<HhEmployerResponseDto> hhEmployerResponsDtos) {
    this.items = hhEmployerResponsDtos;
  }

  public List<HhEmployerResponseDto> getItems() {
    return items;
  }

  public void setItems(List<HhEmployerResponseDto> items) {
    this.items = items;
  }
}
