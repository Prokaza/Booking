package sfirat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("springMailSender")
public class SpringMailSender {

    @Autowired
    private SimpleMailMessage emailTemplate;

    public void setEmailTemplate(SimpleMailMessage emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String to, String user, String login, String password, String signature) {

        String fromEmail = emailTemplate.getFrom();
        String emailSubject = emailTemplate.getSubject();
        String emailBody = String.format(emailTemplate.getText(), user, login, password, signature);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(emailSubject);
            helper.setText(emailBody);
			/*
			  uncomment the following lines for attachment FileSystemResource
			  file = new FileSystemResource("attachment.jpg");
			  helper.addAttachment(file.getFilename(), file);
			 */
            javaMailSender.send(mimeMessage);
            System.out.println("Mail sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}