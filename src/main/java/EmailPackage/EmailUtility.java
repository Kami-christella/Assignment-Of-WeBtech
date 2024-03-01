package EmailPackage;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailUtility {

    private static final String USERNAME = "kamichristella@gmail.com"; 
    private static final String PASSWORD = "Bell@1214"; // Your email password

    public static void sendEmail(String to, String subject, String content) throws MessagingException {
        // Email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a Session object
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);

            System.out.println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            throw new MessagingException("Error sending email: " + e.getMessage());
        }
    }
}
