package ru.hh.school.dto.employer;

public class EmployerShortResponse {
  private Long id;
  private String name;

  public EmployerShortResponse() {
  }

  public EmployerShortResponse(Long id, String name) {
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
