package dev.jpp.listapi.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailManager {
//	private static EmailManager instance;
	private final String APP_EMAIL_ADDRESS;
	private final String APP_EMAIL_PASSWORD;
		
	public EmailManager() {
		APP_EMAIL_ADDRESS = "data.listapp@gmail.com";
		APP_EMAIL_PASSWORD = "goldenpartners";
	}
	
//	public static EmailManager getInstance() {
//		if (instance == null) {
//			instance = new EmailManager();
//		}
//		
//		return instance;
//	}
	
	public void sendEmail(String subject, String content, String... recipients) {
		StringBuilder sb = new StringBuilder();
		if (recipients != null && recipients.length > 0) {
			for (int i = 0; i < recipients.length; i++) {
				sb.append(recipients[i].trim())
				.append(",");
			}
		} else {
			return;
		}
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
			
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(APP_EMAIL_ADDRESS, APP_EMAIL_PASSWORD);
				}
			}
		);
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(APP_EMAIL_ADDRESS));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sb.toString()));
			message.setSubject(subject);
			message.setContent(content, "text/html");

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Value("${app.url}")
	private String url;
	
	public void sendRegistrationEmail(String email, String password) {
		String subject = "Registration Data";
		String content = "<p>You have been registered in List App!</p>"
				+ "<p>Username: <strong>" + email + "</strong><br>"
				+ "Password: <strong>" + password + "</strong></p>"
				+ "<p>Remember to enter <a href=\"" + url + "\">List Application</a> to change your password to a more secure one.</p>"
				+ "<p>Best regards. <br>List Team.</p>";
		
		this.sendEmail(subject, content, email);
	}
}
