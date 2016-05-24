package mail;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import util.DbUtil;

/**
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 *
 *         This class aims to listen given gmail account and take received mails from there.
 */
public class MailListener implements Runnable {

  private static final String host = "pop.gmail.com";

  private static final String port = "995";

  public static void main(String[] args) {
    try {
      // create properties field
      final Properties properties = new Properties();

      properties.put("mail.store.protocol", "imaps");
      final Session emailSession = Session.getDefaultInstance(properties);

      // create the POP3 store object and connect with the pop server
      final Store store = emailSession.getStore();

      store.connect(host, DbUtil.USER, DbUtil.PASS);

      // create the folder object and open it
      final Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_WRITE);

      final Flags seen = new Flags(Flags.Flag.SEEN);
      final FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
      final Message[] messages = emailFolder.search(unseenFlagTerm);

      System.out.println("messages.length---" + messages.length);

      for (int i = 0, n = messages.length; i < n; i++) {
        final Message message = messages[i];
        System.out.println("---------------------------------");
        System.out.println("Email Number " + (i + 1));
        System.out.println("Subject: " + message.getSubject());
        System.out.println("From: " + message.getFrom()[0]);
        System.out.println("Text: " + message.getContent().toString());
        // message.setFlag(Flag.SEEN, true); This code signs the message as seen
      }

      // close the store and folder objects
      emailFolder.close(false);
      store.close();

    } catch (final NoSuchProviderException e) {
      e.printStackTrace();
    } catch (final MessagingException e) {
      e.printStackTrace();
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    try {
      // create properties field
      final Properties properties = new Properties();

      properties.put("mail.store.protocol", "imaps");
      final Session emailSession = Session.getDefaultInstance(properties);

      // create the POP3 store object and connect with the pop server
      final Store store = emailSession.getStore();

      store.connect(host, DbUtil.USER, DbUtil.PASS);

      // create the folder object and open it
      final Folder emailFolder = store.getFolder("INBOX");
      emailFolder.open(Folder.READ_WRITE);

      final Flags seen = new Flags(Flags.Flag.SEEN);
      final FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
      final Message[] messages = emailFolder.search(unseenFlagTerm);

      System.out.println("messages.length---" + messages.length);

      for (int i = 0, n = messages.length; i < n; i++) {
        final Message message = messages[i];
        System.out.println("---------------------------------");
        System.out.println("Email Number " + (i + 1));
        System.out.println("Subject: " + message.getSubject());
        System.out.println("From: " + message.getFrom()[0]);
        System.out.println("Text: " + message.getContent().toString());
      }

      // close the store and folder objects
      emailFolder.close(false);
      store.close();

    } catch (final NoSuchProviderException e) {
      e.printStackTrace();
    } catch (final MessagingException e) {
      e.printStackTrace();
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }
}
