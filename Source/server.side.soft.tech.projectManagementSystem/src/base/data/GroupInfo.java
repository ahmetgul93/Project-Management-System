package base.data;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GroupInfo {

  private static int groupNo = 0;

  private final ArrayList<Student> students;

  public GroupInfo() {
    this.students = new ArrayList<Student>();
    groupNo++;
  }

  public void addStudent(final Student s) {
    this.students.add(s);
  }

  public int getGroupNo() {
    return GroupInfo.groupNo;
  }

  public ArrayList<Student> getStudents() {
    return this.students;
  }

  public void setGroupNo(final int groupNo) {
    GroupInfo.groupNo = groupNo;
  }
}
