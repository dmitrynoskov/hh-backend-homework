package ru.hh.school.dto.employer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployerAddRequestDto {
  @JsonProperty("employer_id")
  private Long id;
  private String comment;

  public EmployerAddRequestDto(Long id, String comment) {
    this.id = id;
    this.comment = comment;
  }

  public EmployerAddRequestDto() {
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
