package base.data;

/**
 * Defines Student data structure.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public class Student {

  private String id;

  private long studentNumber;

  private String name;

  private String surname;

  private int groupNo;

  private float grade;

  public float getGrade() {
    return this.grade;
  }

  public int getGroupNo() {
    return this.groupNo;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public long getStudentNumber() {
    return this.studentNumber;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setGrade(final float grade) {
    this.grade = grade;
  }

  public void setGroupNo(final int groupNo) {
    this.groupNo = groupNo;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setStudentNumber(final long studentNumber) {
    this.studentNumber = studentNumber;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }
}
