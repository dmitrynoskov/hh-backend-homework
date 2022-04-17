package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VacancyAddRequest {
  @JsonProperty("vacancy_id")
  private Long id;
  private String comment;

  public VacancyAddRequest(Long id, String comment) {
    this.id = id;
    this.comment = comment;
  }

  public VacancyAddRequest() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
