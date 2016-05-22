package model;

public class Student {

  private long studentNumber;

  private String name;

  private String surname;

  private float grade;

  public float getGrade() {
    return this.grade;
  }

  public String getName() {
    return this.name;
  }

  public long getstudentNumber() {
    return this.studentNumber;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setGrade(float grade) {
    this.grade = grade;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setstudentNumber(long studentNumber) {
    this.studentNumber = studentNumber;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}
