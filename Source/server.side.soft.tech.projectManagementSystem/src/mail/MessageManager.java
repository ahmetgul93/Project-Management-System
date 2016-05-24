package mail;

import java.util.List;

public class MessageManager {

  private static List<StringBuilder> messages;

  public static void addMessage(StringBuilder message) {
    messages.add(message);
  }

  public static List<StringBuilder> getMessages() {
    return messages;
  }

  public static int numberOfMessages() {
    return messages.size();
  }
}
