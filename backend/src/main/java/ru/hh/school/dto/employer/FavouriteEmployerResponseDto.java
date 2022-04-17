package ru.hh.school.dto.employer;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.hh.school.dto.Popularity;
import ru.hh.school.dto.AreaDto;

public class FavouriteEmployerResponseDto {
  private Long id;
  private String name;
  @JsonProperty("date_create")
  private String dateCreation;
  private String description;
  private AreaDto area;
  private String comment;
  private Popularity popularity;
  @JsonProperty("views_count")
  private Integer viewsCount;

  public FavouriteEmployerResponseDto() {
  }

  public FavouriteEmployerResponseDto(Long id, String name, String dateCreation, String description, AreaDto area, String comment, Popularity popularity, Integer viewsCount) {
    this.id = id;
    this.name = name;
    this.dateCreation = dateCreation;
    this.description = description;
    this.area = area;
    this.comment = comment;
    this.popularity = popularity;
    this.viewsCount = viewsCount;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public AreaDto getArea() {
    return area;
  }

  public void setArea(AreaDto area) {
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
