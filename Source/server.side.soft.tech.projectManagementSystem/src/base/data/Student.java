package base.data;

import javax.faces.bean.ManagedBean;

@ManagedBean
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

  public void setGrade(final float grade) {
    this.grade = grade;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setstudentNumber(final long studentNumber) {
    this.studentNumber = studentNumber;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }
}
