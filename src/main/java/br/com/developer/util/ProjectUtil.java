package br.com.developer.util;

import br.com.developer.dto.MessageDTO;
import br.com.developer.model.Messages;

public class ProjectUtil {

	public static Messages convert(MessageDTO element) {
		return new Messages(element.getConversationId(), 
								element.getFrom(), 
								element.getTo(), 
								element.getText(),
								element.getTimestamp());
	}
	
	public static MessageDTO revert(Messages element) {
		return new MessageDTO(element.getConversationId(), 
								element.get_from(), 
								element.get_to(), 
								element.get_text(),
								element.getTimestamp());
	}
	
	public static MessageDTO returnTextByConversationId(Messages element) {
		return new MessageDTO(element.get_text());
	}
	
	

}
