package com.tedmyoung.resttemplateweatherexample;

public class WeatherResponse {
  private String location;
  private String updated;
  private Float temp;
  private String condition;

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public Float getTemp() {
    return temp;
  }

  public void setTemp(Float temp) {
    this.temp = temp;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  @Override
  public String toString() {
    return "WeatherResponse:\n" +
        "  location='" + location + "'\n" +
        "  updated='" + updated + "'\n" +
        "  temp=" + temp + "\n" +
        "  condition='" + condition + "'";
  }
}