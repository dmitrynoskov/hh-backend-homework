package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.hh.school.dto.Popularity;
import ru.hh.school.dto.AreaDto;
import ru.hh.school.dto.employer.EmployerShortResponseDto;

public class FavouriteVacancyResponseDto {

  private Long id;
  private String name;
  @JsonProperty("date_create")
  private String dateCreation;
  private AreaDto area;
  private SalaryDto salary;
  @JsonProperty("created_at")
  private String createdAt;
  private EmployerShortResponseDto employer;
  private Popularity popularity;
  @JsonProperty("views_count")
  private Integer viewsCount;
  private String comment;

  public FavouriteVacancyResponseDto() {
  }

  public FavouriteVacancyResponseDto(Long id,
                                     String name,
                                     String dateCreation,
                                     AreaDto area,
                                     SalaryDto salary,
                                     String createdAt,
                                     EmployerShortResponseDto employer,
                                     Popularity popularity,
                                     Integer viewsCount,
                                     String comment) {
    this.id = id;
    this.name = name;
    this.dateCreation = dateCreation;
    this.area = area;
    this.salary = salary;
    this.createdAt = createdAt;
    this.employer = employer;
    this.popularity = popularity;
    this.viewsCount = viewsCount;
    this.comment = comment;
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

  public String getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(String dateCreation) {
    this.dateCreation = dateCreation;
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

  public EmployerShortResponseDto getEmployer() {
    return employer;
  }

  public void setEmployer(EmployerShortResponseDto employer) {
    this.employer = employer;
  }

  public Popularity getPopularity() {
    return popularity;
  }

  public void setPopularity(Popularity popularity) {
    this.popularity = popularity;
  }

  public Integer getViewsCount() {
    return viewsCount;
  }

  public void setViewsCount(Integer viewsCount) {
    this.viewsCount = viewsCount;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
