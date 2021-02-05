package com.potato.service;

import com.potato.external.mail.MailSender;
import com.potato.external.mail.MailCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

@RequiredArgsConstructor
@Component
public class MailService {

	private final MailCreator mailCreator;
	private final MailSender mailSender;

	public void sendVerificationEmail(String receiver) {
		try {
			Message message = mailCreator.createMessage();
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject("Verify SignUp");
			message.setText("인증메일입니다.");
			mailSender.sendMail(message);
		} catch (MessagingException e) {
			throw new IllegalArgumentException(String.format("이메일 전송중 에러가 발생하였습니다 (%s)", e));
		}
	}

}
