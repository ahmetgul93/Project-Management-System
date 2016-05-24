package mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;

import util.DbUtil;

public class MailListener implements Runnable {

  private static final String host = "imap.gmail.com";

  public static void main(String[] args) {
    try {
      // create properties field
      final Properties properties = new Properties();

      properties.put("mail.store.protocol", "imaps");
      final Session emailSession = Session.getDefaultInstance(properties);

      // create the POP3 store object and connect with the pop server
      final Store store = emailSession.getStore("imaps");

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

        final StringBuilder builder = new StringBuilder();
        if (message.getContentType().contains("TEXT/PLAIN")) {
          final Object content = message.getContent();
          if (content != null) {
            builder.append(content);
            // System.out.println(content.toString());
          }
        } else if (message.getContentType().contains("multipart")) {
          final Multipart mp = (Multipart) message.getContent();
          final int numParts = mp.getCount();
          for (int count = 0; count < numParts; count++) {
            final MimeBodyPart part = (MimeBodyPart) mp.getBodyPart(count);

            final String content = part.getContent().toString();
            if (part.getContentType().contains("TEXT/PLAIN")) {
              builder.append(content);
            }
          }
          // System.out.println(builder.toString());
        }

        MessageManager.addMessage(builder);
      }

      // close the store and folder objects
      emailFolder.close(false);
      store.close();

    } catch (final MessagingException | IOException e) {
      e.printStackTrace();
    }

    MessageParser.parse();
  }

  @Override
  public void run() {
    try {
      // create properties field
      final Properties properties = new Properties();

      properties.put("mail.store.protocol", "imaps");
      final Session emailSession = Session.getDefaultInstance(properties);

      // create the POP3 store object and connect with the pop server
      final Store store = emailSession.getStore("imaps");

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

        final StringBuilder builder = new StringBuilder();
        if (message.getContentType().contains("TEXT/PLAIN")) {
          final Object content = message.getContent();
          if (content != null) {
            builder.append(content);
            // System.out.println(content.toString());
          }
        } else if (message.getContentType().contains("multipart")) {
          final Multipart mp = (Multipart) message.getContent();
          final int numParts = mp.getCount();
          for (int count = 0; count < numParts; count++) {
            final MimeBodyPart part = (MimeBodyPart) mp.getBodyPart(count);

            final String content = part.getContent().toString();
            if (part.getContentType().contains("TEXT/PLAIN")) {
              builder.append(content);
            }
          }
          // System.out.println(builder.toString());
        }

        MessageManager.addMessage(builder);
      }

      // close the store and folder objects
      emailFolder.close(false);
      store.close();

    } catch (final MessagingException | IOException e) {
      e.printStackTrace();
    }

    MessageParser.parse();
  }
}
