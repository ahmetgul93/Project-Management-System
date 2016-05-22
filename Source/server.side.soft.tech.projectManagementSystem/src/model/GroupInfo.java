package model;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GroupInfo {

  private final ArrayList<Student> students;

  private int groupNo;

  public GroupInfo() {
    this.students = new ArrayList<Student>();
  }

  public void addStudent(Student s) {
    this.students.add(s);
  }

  public int getGroupNo() {
    return this.groupNo;
  }

  public ArrayList<Student> getStudents() {
    return this.students;
  }

  public void setGroupNo(int groupNo) {
    this.groupNo = groupNo;
  }
}
