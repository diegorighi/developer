package br.com.developer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.developer.model.Bot;
import br.com.developer.repository.BotRepository;

@Service
public class BotServices {

	@Autowired
	private BotRepository botRepository;
	
	public void createBot(Bot element) {
		botRepository.save(element);
	}
	
	public Bot returnBot(String id) {
		Bot bot = null;
		if(botRepository.findById(id).isPresent()) {
			bot = botRepository.findById(id).orElse(null);
		}
		return bot;
	}
	
	public void updateBot(Bot element) {
		Bot bot = returnBot(element.getId());
		if(bot != null) {
			bot = element;
			botRepository.save(bot);
		}
	}
	
	public void deleteBot(Bot element) {
		Bot bot = returnBot(element.getId());
		if(bot != null) {
			bot = element;
			botRepository.delete(bot);
		}
	}
}
