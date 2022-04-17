package ru.hh.school.dto.employer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.hh.school.dto.AreaDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HhEmployerResponseDto {
  private Long id;
  private String name;
  private String description;
  private AreaDto area;

  public HhEmployerResponseDto() {
  }

  public HhEmployerResponseDto(Long id, String name, String description, AreaDto area) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.area = area;
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
}
