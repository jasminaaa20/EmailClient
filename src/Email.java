import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Properties;

public class Email implements Serializable {
    private final String email;
    private final String subject;
    private final String content;
    private final LocalDate date;
    @Serial
    private static final long serialVersionUID = 1234567L;
    public Email(String email, String subject, String content) {
        this.email = email;
        this.subject = subject;
        this.content = content;
        this.date = LocalDate.now();
    }
    public void sendEmail() {

        final String username = "akmalalitestjava@gmail.com";
        final String password = "vaxahsxyioochqcr";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication
                    getPasswordAuthentication() {
                        return new
                                PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse
                            (email)
            );
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        Deserialize.sentMail.add(this);
    }
    public String getEmail() {
        return email;
    }
    public String getSubject() {
        return subject;
    }
    public LocalDate getDate() {
        return date;
    }
}
