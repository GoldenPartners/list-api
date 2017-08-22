package dev.jpp.listapi.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class SendRegristrationMailTest {

	@Test
	public void sendMailTest() {
		String username = "data.listapp@gmail.com";
		String password = "goldenpartners";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			}
		);
		
		String url = "http://localhost:4200";
		String content = "<p>You have been registered in List App!</p>"
				+ "<p>Username: <strong>" + "juanpablopetrozzi@gmail.com" + "</strong><br>"
				+ "Password: <strong>" + password + "</strong></p>"
				+ "<p>Remember to enter <a href=\"" + url + "\">List Application</a> to change your password to a more secure one.</p>"
				+ "<p>Best regards. <br>List Team.</p>";

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("juanpablopetrozzi@gmail.com"));
			message.setSubject("Testing Subject");
			message.setContent(content, "text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
