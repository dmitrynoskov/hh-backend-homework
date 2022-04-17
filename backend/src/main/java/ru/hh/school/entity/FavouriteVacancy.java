package ru.hh.school.entity;

import org.hibernate.annotations.Type;
import ru.hh.school.Popularity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "favourite_vacancy")
public class FavouriteVacancy {

  @Id
  @Column(name = "vacancy_id")
  private Long id;

  @NotNull
  @Column(name = "vacancy_name")
  private String name;

  @NotNull
  @Column(name = "date_creation")
  private String dateCreation;

  @JoinColumn(name = "area_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Area area;

  @Column(name = "salary_from")
  private Integer salaryFrom;

  @Column(name = "salary_to")
  private Integer salaryTo;

  @NotNull
  @Column(name = "salary_currency")
  private String salaryCurrency;

  @NotNull
  @Column(name = "salary_gross")
  private Boolean salaryGross;

  @NotNull
  @Column(name = "created_at")
  private String createdAt;

  @Column(name = "employer_id")
  private Long employerId;

  @Column(name = "employer_name")
  private String employerName;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Type(type = "ru.hh.school.PostgreSQLEnumType")
  private Popularity popularity;

  @NotNull
  @Column(name = "views_count")
  private Integer viewsCount;

  private String comment;

  public FavouriteVacancy() {
  }

  public FavouriteVacancy(Long id,
                          String name,
                          String dateCreation,
                          Area area,
                          Integer salaryFrom,
                          Integer salaryTo,
                          String salaryCurrency,
                          Boolean salaryGross,
                          String createdAt,
                          Long employerId,
                          String employerName,
                          Popularity popularity,
                          Integer viewsCount,
                          String comment) {
    this.id = id;
    this.name = name;
    this.dateCreation = dateCreation;
    this.area = area;
    this.salaryFrom = salaryFrom;
    this.salaryTo = salaryTo;
    this.salaryCurrency = salaryCurrency;
    this.salaryGross = salaryGross;
    this.createdAt = createdAt;
    this.employerId = employerId;
    this.employerName = employerName;
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

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public Integer getSalaryFrom() {
    return salaryFrom;
  }

  public void setSalaryFrom(Integer salaryFrom) {
    this.salaryFrom = salaryFrom;
  }

  public Integer getSalaryTo() {
    return salaryTo;
  }

  public void setSalaryTo(Integer salaryTo) {
    this.salaryTo = salaryTo;
  }

  public String getSalaryCurrency() {
    return salaryCurrency;
  }

  public void setSalaryCurrency(String salaryCurrency) {
    this.salaryCurrency = salaryCurrency;
  }

  public Boolean getSalaryGross() {
    return salaryGross;
  }

  public void setSalaryGross(Boolean salaryGross) {
    this.salaryGross = salaryGross;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Long getEmployerId() {
    return employerId;
  }

  public void setEmployerId(Long employerId) {
    this.employerId = employerId;
  }

  public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
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
