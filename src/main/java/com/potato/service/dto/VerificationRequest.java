package com.potato.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VerificationRequest {

	private String receiver;
	private String code;

	public VerificationRequest(String receiver, String code) {
		this.receiver = receiver;
		this.code = code;
	}

	public static VerificationRequest testInstance(String receiver, String code) {
		return new VerificationRequest(receiver, code);
	}

}
