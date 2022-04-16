package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.hh.school.dto.AreaDto;
import ru.hh.school.dto.employer.HhEmployerResponse;
import ru.hh.school.dto.employer.HhShortEmployerResponse;

import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HhVacancyResponse {
  private Long id;
  private String name;
  private AreaDto area;
  private SalaryDto salary;
  @JsonProperty("created_at")
  private String createdAt;
  private HhShortEmployerResponse employer;

  public HhVacancyResponse() {
  }

  public HhVacancyResponse(Long id, String name, AreaDto area, SalaryDto salary, String createdAt, HhShortEmployerResponse employer) {
    this.id = id;
    this.name = name;
    this.area = area;
    this.salary = salary;
    this.createdAt = createdAt;
    this.employer = employer;
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

  public AreaDto getArea() {
    return area;
  }

  public void setArea(AreaDto area) {
    this.area = area;
  }

  public SalaryDto getSalary() {
    return salary;
  }

  public void setSalary(SalaryDto salary) {
    this.salary = salary;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public HhShortEmployerResponse getEmployer() {
    return employer;
  }

  public void setEmployer(HhShortEmployerResponse employer) {
    this.employer = employer;
  }
}
