package com.potato.external.mail.impl;

import com.potato.external.mail.MailCreator;
import com.potato.external.mail.impl.dto.MailSenderComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RequiredArgsConstructor
@Component
public class GMailCreatorImpl implements MailCreator {

	private final MailSenderComponent mailSenderComponent;

	@Override
	public Message createMessage() throws MessagingException {
		Message message = new MimeMessage(getSession());
		message.setFrom(new InternetAddress(mailSenderComponent.getSender()));
		return message;
	}

	private Session getSession() {
		return Session.getDefaultInstance(createProperties(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailSenderComponent.getSender(), mailSenderComponent.getPassword());
			}
		});
	}

	private Properties createProperties() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return prop;
	}

}