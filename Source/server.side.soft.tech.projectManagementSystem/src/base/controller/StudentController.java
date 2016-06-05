package base.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.data.Student;
import base.database.StudentRepository;

/**
 * This class is responsible for communication with student repository.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
@Service
public class StudentController {

  @Autowired
  private StudentRepository repository;

  public void addStudent(final Student student) {
    // System.out.println("Student added.");
    this.repository.save(student);
  }

  public void addStudents(final List<Student> students) {
    // System.out.println("Students added.");
    this.repository.addStudents(students);
  }

  public void deleteStudent(final Student student) {
    this.repository.delete(student);
  }

  public Student getStudentByNameAndSurname(final Student student) {
    return this.repository.getStudentByNameSurname(student.getName(), student.getSurname());
  }

  public List<Student> getStudents() {
    final List<Student> students = new ArrayList<Student>();
    final Iterator<Student> iterator = this.repository.findAll().iterator();
    while (iterator.hasNext()) {
      final Student student = iterator.next();
      students.add(student);
    }

    return students;
  }

  public List<Student> getStudentsByGroupNo(final int groupNo) {
    return this.repository.getStudentsByGroupNo(groupNo);
  }

  public void updateStudent(final Student newlyUpdatedStudent) {
    this.repository.delete(newlyUpdatedStudent.getId());
    this.repository.save(newlyUpdatedStudent);
  }
}
