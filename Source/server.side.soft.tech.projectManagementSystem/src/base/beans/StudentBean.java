package base.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import base.controller.StudentController;
import base.data.Student;
import base.mail.MailListener;

/**
 * This class is responsible for holding the given input from project.xhtml view and transmit those
 * data to controller.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
@Component
@SessionScoped
public class StudentBean {

  @Autowired
  private StudentController controller;

  private List<Student> students;

  private Student selectedStudent;

  private Student newStudent = new Student();

  public void addStudents(final List<Student> newStudents) {
    this.controller.addStudents(newStudents);
    this.students.addAll(newStudents);
  }

  public void doAdd() {
    // System.out.println("Add");
    this.controller.addStudent(this.newStudent);
    this.students.add(this.newStudent);
    this.newStudent = new Student();
  }

  public void doDelete() {
    // System.out.println("Delete");
    this.controller.deleteStudent(this.selectedStudent);
    this.students.remove(this.selectedStudent);
    this.selectedStudent = null;
  }

  public void doSave() {
    // System.out.println("Save");
    this.controller.updateStudent(this.selectedStudent);
    this.students.set(this.students.indexOf(this.selectedStudent), this.selectedStudent);
    this.selectedStudent = null;
  }

  public Student getNewStudent() {
    return this.newStudent;
  }

  public Student getSelectedStudent() {
    return this.selectedStudent;
  }

  public List<Student> getStudents() {
    return this.students;
  }

  /**
   * This method will be call just once to trigger the mail listener thread and load table from
   * database.
   *
   */
  @PostConstruct
  public void init() {
    // we start to listen mail at here, every 2 minutes it will run.
    final ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    exec.scheduleAtFixedRate(new MailListener(this), 0, 2, TimeUnit.MINUTES);

    this.students = new ArrayList<Student>();
    this.students.addAll(this.controller.getStudents());
    // System.out.println("Students have been initialized.");
  }

  public void setNewStudent(final Student newStudent) {
    this.newStudent = newStudent;
  }

  public void setSelectedStudent(final Student selectedStudent) {
    this.selectedStudent = selectedStudent;
  }

  public void setStudents(final List<Student> students) {
    this.students = students;
  }
}
