package mail;

import java.util.List;

public class MessageManager {

  private static List<String> messages;

  public static void addMessage(String message) {
    messages.add(message);
  }

  public static List<String> getMessages() {
    return messages;
  }

  public static int numberOfMessages() {
    return messages.size();
  }
}
