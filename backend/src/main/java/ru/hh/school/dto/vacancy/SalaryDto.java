package ru.hh.school.dto.vacancy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalaryDto {
  private Long to;
  private Long from;
  private String currency;
  private Boolean gross;

  public SalaryDto() {
  }

  public SalaryDto(Long to, Long from, String currency, Boolean gross) {
    this.to = to;
    this.from = from;
    this.currency = currency;
    this.gross = gross;
  }

  public Long getTo() {
    return to;
  }

  public void setTo(Long to) {
    this.to = to;
  }

  public Long getFrom() {
    return from;
  }

  public void setFrom(Long from) {
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
