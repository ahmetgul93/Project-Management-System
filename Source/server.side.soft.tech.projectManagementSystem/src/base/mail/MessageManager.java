package base.mail;

import java.util.ArrayList;
import java.util.List;

public class MessageManager {

  private static List<String> messages = new ArrayList<String>();

  public static void addMessage(final String message) {
    messages.add(message);
  }

  public static List<String> getMessages() {
    return messages;
  }

  public static int numberOfMessages() {
    return messages.size();
  }
}
