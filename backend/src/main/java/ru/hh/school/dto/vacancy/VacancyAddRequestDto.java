package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VacancyAddRequestDto {
  @JsonProperty("vacancy_id")
  private Long id;
  private String comment;

  public VacancyAddRequestDto(Long id, String comment) {
    this.id = id;
    this.comment = comment;
  }

  public VacancyAddRequestDto() {
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
