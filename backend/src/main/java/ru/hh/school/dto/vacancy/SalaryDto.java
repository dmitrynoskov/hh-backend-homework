package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalaryDto {
  private Integer to;
  private Integer from;
  private String currency;
  private boolean gross;

  public SalaryDto() {
  }

  public SalaryDto(Integer to, Integer from, String currency, Boolean gross) {
    this.to = to;
    this.from = from;
    this.currency = currency;
    this.gross = gross;
  }

  public Integer getTo() {
    return to;
  }

  public void setTo(Integer to) {
    this.to = to;
  }

  public Integer getFrom() {
    return from;
  }

  public void setFrom(Integer from) {
    this.from = from;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Boolean getGross() {
    return gross;
  }

  public void setGross(Boolean gross) {
    this.gross = gross;
  }
}
