//package EmailPackage;
//
//import javax.mail.*;
//import javax.mail.internet.*;
//
//import com.mysql.cj.Session;
//
//import java.net.Authenticator;
//import java.util.Properties;
//
//public class SendEmail {
//
//    public static void sendEmail(String to, String subject, String content) throws MessagingException {
//        final String username = "umuhirelise22@gmail.com"; // Your email
//        final String password = "your_password_here"; // Your password
//
//        // Email properties
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        // Create a Session object
//        Session session = Session.getInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        })
//
//        try {
//            // Create a MimeMessage object
//            Message message = new MimeMessage(session);
//
//            // Set From: header field
//            message.setFrom(new InternetAddress(username));
//
//            // Set To: header field
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//
//            // Set Subject: header field
//            message.setSubject(subject);
//
//            // Set email content
//            message.setText(content);
//
//            // Send message
//            Transport.send(message);
//
//            System.out.println("Email sent successfully to " + to);
//        } catch (MessagingException e) {
//            throw new MessagingException("Error sending email: " + e.getMessage());
//        }
//    }
//}
