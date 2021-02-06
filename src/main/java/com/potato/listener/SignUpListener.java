package com.potato.listener;

import com.potato.service.MailService;
import com.potato.service.dto.VerificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class SignUpListener {

	private final MailService mailService;

	@SqsListener(value = "${cloud.aws.sqs.queue.url}", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
	public void receiveSignUpEvent(@Payload VerificationRequest request, @Headers Map<String, String> headers) {
		log.info("SQS Message payload={} headers={}", request, headers);
		request.validate();
		mailService.sendVerificationEmail(request);
	}

}
