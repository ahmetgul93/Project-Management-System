package model;

import java.io.Serializable;

public class Student implements Serializable {

  private static final long serialVersionUID = -7123463976331110419L;

  private long studentNumber;

  private String name;

  private String surname;

  private float mark;

  public Student() {}

  public float getMark() {
    return this.mark;
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

  public void setMark(float mark) {
    this.mark = mark;
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
