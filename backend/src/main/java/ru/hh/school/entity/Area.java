package ru.hh.school.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area {
  @Id
  @Column(name = "area_id")
  private Long id;

  @Column(name = "area_name")
  private String name;

  public Area() {
  }

  public Area(Long id, String name) {
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
