package ru.hh.school.dto.employer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.hh.school.dto.AreaDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HhShortEmployerResponse {
  private Long id;
  private String name;

  public HhShortEmployerResponse() {
  }

  public HhShortEmployerResponse(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
