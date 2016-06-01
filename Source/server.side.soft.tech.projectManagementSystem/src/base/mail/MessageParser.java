package base.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import base.data.GroupInfo;
import base.data.Student;

public class MessageParser {

  private static GroupInfo createGroup(final List<Student> students) {
    final GroupInfo group = new GroupInfo();
    for (final Student student : students) {
      group.addStudent(student);
    }

    return group;
  }

  private static Student createStudent(final String[] info) {
    final Student student = new Student();
    student.setstudentNumber(Long.valueOf(info[0]));
    final String[] names = info[1].split(" ");
    student.setName(names[0].trim());
    student.setSurname(names[1].trim());

    return student;
  }

  public static List<GroupInfo> parse() {
    final List<GroupInfo> groups = new ArrayList<GroupInfo>();
    final List<String> messages = MessageManager.getMessages();
    for (final String message : messages) {
      final Pattern pattern = Pattern.compile("[0-9]+-[\\p{L}]+\\s+[\\p{L}]+");
      final Matcher matcher = pattern.matcher(message);
      final ArrayList<String> matches = new ArrayList<String>();
      while (matcher.find()) {
        matches.add(matcher.group());
      }

      final List<Student> students = new ArrayList<Student>();
      for (final String match : matches) {
        final String[] info = match.split("-");
        students.add(createStudent(info));
      }
      groups.add(createGroup(students));
    }

    return groups;
  }
}
