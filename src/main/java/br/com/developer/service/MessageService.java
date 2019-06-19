package br.com.developer.service;

import static br.com.developer.util.ProjectUtil.convert;
import static br.com.developer.util.ProjectUtil.returnTextByConversationId;
import static br.com.developer.util.ProjectUtil.revert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.developer.dto.MessageDTO;
import br.com.developer.model.Messages;
import br.com.developer.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;

	public void createMessage(MessageDTO element) {
		Messages msg = convert(element);
		messageRepository.save(msg);
	}
	
	public MessageDTO returnAMessage(Integer id) {
		@SuppressWarnings("deprecation")
		Messages msg = new Messages();
		
		if(messageRepository.findById(id).isPresent()) {
			msg = messageRepository.findById(id).orElse(null);
		}
		
		return revert(msg);
	}

	public List<MessageDTO> returnMessage(String conversationId) {
		List<MessageDTO> listMessage = new ArrayList<MessageDTO>();
		
		messageRepository.findByConversationId(conversationId).forEach( msg -> {
			listMessage.add(revert(msg));
		});
		
		return listMessage;
	}
}
