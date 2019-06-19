package br.com.developer.dto;

import java.util.Calendar;

public class MessageDTO {

	private String conversationId;
	private String from;
	private String to;
	private String text;
	private Calendar timestamp;
	
	@Deprecated
	public MessageDTO() {}

	public MessageDTO(String conversationId, String from, String to, String text, Calendar timestamp) {
		this.conversationId = conversationId;
		this.from = from;
		this.to = to;
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public MessageDTO(String text) {
		this.text = text;
	}

	public String getConversationId() {
		return conversationId;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getText() {
		return text;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

}
