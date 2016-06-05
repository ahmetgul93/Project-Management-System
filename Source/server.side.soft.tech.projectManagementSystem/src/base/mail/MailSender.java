package base.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import base.util.DbUtil;

/**
 * This class sends a confirmation mail to students which have been sent to group information. Uses
 * 'smtp' protocol.
 *
 * @author anıl öztürk
 * @author ahmet gül
 * @author asım zorlu
 */
public class MailSender {

  public static void send(final Address[] to) {
    // Sender's email ID needs to be mentioned
    final String from = DbUtil.USER;
    final String password = DbUtil.PASS;// change accordingly

    // Assuming you are sending email through smtp.gmail.com
    final String host = "smtp.gmail.com";
    final String port = "465";

    final Properties props = System.getProperties();
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", port);
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.debug", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.socketFactory.port", port);
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");

    // Get the Session object.
    final Session session = Session.getDefaultInstance(props);
    session.setDebug(true);

    try {
      // Create a default MimeMessage object.
      final Message message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.setRecipients(Message.RecipientType.TO, to);

      // Set Subject: header field
      message.setSubject("Sunucu Yazılım Dersi Projesi Hk.");

      // Now set the actual message
      message.setText("Yolladığınız grup bilgileri alınmıştır.\nBu bir otomatik maildir.");

      // Send message
      final Transport transport = session.getTransport("smtps");
      transport.connect(host, 465, from, password);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();

      System.out.println("Sent message successfully....");

    } catch (final MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}
