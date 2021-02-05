package com.potato.external.mail.impl.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ToString
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "mail.google")
public class MailSenderComponent {

	private String sender;

	private String password;

}