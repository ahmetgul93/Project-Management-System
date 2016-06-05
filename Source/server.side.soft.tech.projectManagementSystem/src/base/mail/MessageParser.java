package base.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import base.data.Student;

/**
 * This class parses mails and construct Student data structure from them.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public class MessageParser {

  private static int counter = 0; // it will be used as group no

  private static Student createStudent(final String[] info) {
    final Student student = new Student();
    student.setStudentNumber(Long.valueOf(info[0]));
    final String[] names = info[1].split(" ");
    student.setName(names[0].trim());
    student.setSurname(names[1].trim());
    student.setGroupNo(counter);

    return student;
  }

  public static List<Student> parse() {
    final List<Student> students = new ArrayList<Student>();
    final List<String> messages = MessageManager.getMessages();
    for (final String message : messages) {
      counter++;
      final Pattern pattern = Pattern.compile("[0-9]+-[\\p{L}]+\\s+[\\p{L}]+");
      final Matcher matcher = pattern.matcher(message);
      final ArrayList<String> matches = new ArrayList<String>();
      while (matcher.find()) {
        matches.add(matcher.group());
      }

      for (final String match : matches) {
        final String[] info = match.split("-");
        students.add(createStudent(info));
      }
    }
    MessageManager.clear();

    return students;
  }
}
