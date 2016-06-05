package base.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * This class like a container for messages. It holds the messages and give them for use.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public class MessageManager {

  private static List<String> messages = new ArrayList<String>();

  public static void addMessage(final String message) {
    messages.add(message);
  }

  public static void clear() {
    messages = new ArrayList<String>();
  }

  public static List<String> getMessages() {
    return messages;
  }

  public static int numberOfMessages() {
    return messages.size();
  }
}
