package com.potato.external.mail.impl;

import com.potato.external.mail.MailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.mail.*;
import java.util.Arrays;

@Slf4j
@Component
public class MainSenderImpl implements MailSender {

	public void sendMail(Message message) throws MessagingException {
		Transport.send(message);
		log.info(String.format("메일이 전송되었습니다. (%s)", Arrays.toString(message.getAllRecipients())));
	}

}
