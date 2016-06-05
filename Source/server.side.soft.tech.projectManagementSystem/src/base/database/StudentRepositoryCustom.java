package base.database;

import java.util.List;

import base.data.Student;

/**
 * To enrich a repository with custom functionality.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public interface StudentRepositoryCustom {

  public void addStudents(List<Student> students);

  public Student getStudentByNameSurname(String name, String surname);

  public List<Student> getStudentsByGroupNo(int groupNo);

  public void updateStudent(Student updated);
}
