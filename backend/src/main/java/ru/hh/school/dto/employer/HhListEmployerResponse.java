package ru.hh.school.dto.employer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HhListEmployerResponse {
  private List<HhEmployerResponse> items;

  public HhListEmployerResponse() {
  }

  public HhListEmployerResponse(List<HhEmployerResponse> hhEmployerResponses) {
    this.items = hhEmployerResponses;
  }

  public List<HhEmployerResponse> getItems() {
    return items;
  }

  public void setItems(List<HhEmployerResponse> items) {
    this.items = items;
  }
}
