package br.com.developer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.developer.dto.MessageDTO;
import br.com.developer.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@PostMapping
	public void mensagem(@RequestBody @Valid MessageDTO element) {
		messageService.createMessage(element);
	}
	
	@GetMapping("/{id}")
	public MessageDTO returnAllMessagesById(@PathVariable Integer id) {
		return messageService.returnAMessage(id);
	}
	
	@GetMapping
	public List<MessageDTO> returnTextByConverssationId(@RequestParam(required = true) String conversationId) {
		return messageService.returnMessage(conversationId);
	}
	
}
