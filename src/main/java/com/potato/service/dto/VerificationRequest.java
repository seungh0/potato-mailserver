package com.potato.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
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

	public void validate() {
		if (receiver == null || receiver.trim().equals("")) {
			throw new IllegalArgumentException("receiver가 입력되지 않았습니다.");
		}
		if (code == null || code.trim().equals("")) {
			throw new IllegalArgumentException("code가 입력되지 않았습니다.");
		}
	}

}
