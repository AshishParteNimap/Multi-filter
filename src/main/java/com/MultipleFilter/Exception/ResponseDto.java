package com.MultipleFilter.Exception;

public class ResponseDto {

	String message;
	String msgKey;

	public ResponseDto() {
		super();
	}

	public ResponseDto(String message, String msgKey) {
		super();
		this.message = message;
		this.msgKey = msgKey;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

}
