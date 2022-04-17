package ru.hh.school.entity;

import org.hibernate.annotations.Type;
import ru.hh.school.dto.Popularity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "favourite_employer")
public class FavouriteEmployer {

  @Id
  @Column(name = "employer_id")
  private Long id;

  @NotNull
  @Column(name = "employer_name")
  private String name;

  @NotNull
  @Column(name = "date_creation")
  private String creationDate;

  private String description;

  @NotNull
  @JoinColumn(name = "area_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Area area;

  private String comment;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Type(type = "ru.hh.school.config.PostgreSQLEnumType")
  private Popularity popularity;

  @NotNull
  @Column(name = "views_count")
  private Integer viewsCount;

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

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Area getArea() {
    return area;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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
}
