package utilities.email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.*;

public class EmailAttachmentsSender {

    public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
                                                String[] toAddress, String subject, String message, String... attachFiles)
            throws MessagingException {

        Properties properties = new Properties();
        // SMTP Settings (Outgoing Mail)
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port); // Using SSL port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true"); // SSL enabled for port 465
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

//        // creates a new e-mail message
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress(userName));
//
//        InternetAddress[] addressTo = new InternetAddress[toAddress.length];
//        for (int i = 0; i < toAddress.length; i++)
//            addressTo[i] = new InternetAddress(toAddress[i]);
//        msg.setRecipients(Message.RecipientType.TO, addressTo);
//
//        msg.setSubject(subject);
//        msg.setSentDate(new Date());
//
//        // creates message part
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent(message, "text/html");
//
//        // creates multi-part
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//
//        // adds attachments
//        if (attachFiles != null && attachFiles.length > 0) {
//            for (String filePath : attachFiles) {
//                MimeBodyPart attachPart = new MimeBodyPart();
//
//                try {
//                    attachPart.attachFile(filePath);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//
//                multipart.addBodyPart(attachPart);
//            }
//        }
//
//        // sets the multi-part as e-mail's content
//        msg.setContent(multipart);
//
//        // sends the e-mail
//        Transport.send(msg);
//    }
//}
        try {
            // Create message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(userName));

            List<InternetAddress> validRecipients = new ArrayList<>();

            // Validate recipient emails
            for (String email : toAddress) {
                try {
                    validRecipients.add(new InternetAddress(email, true));
                } catch (AddressException ex) {
                    System.err.println("Invalid email address skipped: " + email);
                }
            }

            if (validRecipients.isEmpty()) {
                System.err.println("No valid recipient addresses. Email not sent.");
                return;
            }

            msg.setRecipients(Message.RecipientType.TO, validRecipients.toArray(new InternetAddress[0]));
            msg.setSubject(subject);
            msg.setSentDate(new Date());

            // Create message body part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(message, "text/html");

            // Create multipart for attachments
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attach files
            if (attachFiles != null && attachFiles.length > 0) {
                for (String filePath : attachFiles) {
                    MimeBodyPart attachPart = new MimeBodyPart();
                    try {
                        attachPart.attachFile(filePath);
                        multipart.addBodyPart(attachPart);
                    } catch (IOException ex) {
                        System.err.println("Attachment failed: " + filePath);
                    }
                }
            }

            // Set content
            msg.setContent(multipart);

            // Attempt to send the email
            try {
                Transport.send(msg);
                System.out.println("Email successfully sent to: " + Arrays.toString(validRecipients.toArray()));
            } catch (SendFailedException e) {
                System.err.println("Failed to send email. Checking for invalid addresses...");

                if (e.getInvalidAddresses() != null) {
                    for (Address invalidAddress : e.getInvalidAddresses()) {
                        System.err.println("Invalid recipient: " + invalidAddress.toString());
                    }
                }
                if (e.getValidUnsentAddresses() != null) {
                    for (Address unsentAddress : e.getValidUnsentAddresses()) {
                        System.err.println("Temporarily failed: " + unsentAddress.toString());
                    }
                }
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
