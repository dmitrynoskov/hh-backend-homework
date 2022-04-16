package ru.hh.school.dto.employer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployerAddRequest {
  @JsonProperty("employer_id")
  private Long id;
  private String comment;

  public EmployerAddRequest(Long id, String comment) {
    this.id = id;
    this.comment = comment;
  }

  public EmployerAddRequest() {
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
