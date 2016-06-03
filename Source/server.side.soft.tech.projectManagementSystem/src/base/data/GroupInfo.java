package base.data;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import org.springframework.data.annotation.Id;

@ManagedBean
public class GroupInfo {

  private static int groupNo = 0;

  @Id
  private String id;

  private final ArrayList<Student> students;

  public GroupInfo() {
    this.students = new ArrayList<Student>();
  }

  public void addStudent(final Student s) {
    this.students.add(s);
  }

  public int getGroupNo() {
    return GroupInfo.groupNo;
  }

  public String getId() {
    return this.id;
  }

  public ArrayList<Student> getStudents() {
    return this.students;
  }

  public void setGroupNo() {
    groupNo++;
  }

  public void setId(final String id) {
    this.id = id;
  }
}
