package com.potato.external.mail;

import javax.mail.Message;
import javax.mail.MessagingException;

public interface MailSender {

	void sendMail(Message message) throws MessagingException;

}
