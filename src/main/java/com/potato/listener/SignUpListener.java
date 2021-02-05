package com.potato.listener;

import com.potato.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpListener {

	private final MailService mailService;

	@SqsListener("${cloud.aws.sqs.queue.url}")
	public void receiveSignUpEvent(String receiver) {
		mailService.sendVerificationEmail(receiver);
	}

}
