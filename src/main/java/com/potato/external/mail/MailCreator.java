package com.potato.external.mail;

import javax.mail.Message;
import javax.mail.MessagingException;

public interface MailCreator {

	Message createMessage() throws MessagingException;

}
