package model;

import java.util.ArrayList;

public class GroupInfo implements java.io.Serializable {

  private static final long serialVersionUID = 4811109125723501690L;

  private final ArrayList<Student> group;

  private int groupNo;

  public GroupInfo() {
    this.group = new ArrayList<Student>();
  }

  public void addStudent(Student s) {
    this.group.add(s);
  }

  public ArrayList<Student> getGroup() {
    return this.group;
  }

  public int getGroupNo() {
    return this.groupNo;
  }

  public void setGroupNo(int groupNo) {
    this.groupNo = groupNo;
  }
}
