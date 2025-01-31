package com.LearnSpring.SpringBootFirstApp.job;

public class Job {
  private long id;
  private String title;

  private String description;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setMinSalary(String minSalary) {
    this.minSalary = minSalary;
  }

  public void setMaxSalary(String maxSalary) {
    this.maxSalary = maxSalary;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getMinSalary() {
    return minSalary;
  }

  public String getMaxSalary() {
    return maxSalary;
  }

  public String getLocation() {
    return location;
  }

  public Job(long id, String title, String description, String minSalary, String maxSalary, String location) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.minSalary = minSalary;
    this.maxSalary = maxSalary;
    this.location = location;
  }

  private String minSalary;
  private String maxSalary;
  private String location;
}
