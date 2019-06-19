package br.com.developer.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.developer.dto.BotDTO;
import br.com.developer.model.Bot;
import br.com.developer.service.BotServices;

@RestController
@RequestMapping("/bots")
public class BotController {
	
	@Autowired
	private BotServices services;

	@PostMapping
	public ResponseEntity<BotDTO> bots(@RequestBody @Valid BotDTO element, UriComponentsBuilder uriBuilder) {
		Bot bot = element.converter();
		
		services.createBot(bot);
		URI uri = uriBuilder.path("/bots/{id}").buildAndExpand(bot.getId()).toUri();
		return ResponseEntity.created(uri).body(new BotDTO(bot.getId(), bot.getName()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BotDTO> bots(@PathVariable("id") String id) {
		if(services.returnBot(id) == null) {
			return new ResponseEntity<BotDTO>(HttpStatus.NOT_FOUND);
		}else {
			Bot bot = services.returnBot(id);
			BotDTO botDTO = new BotDTO(bot.getId(), bot.getName());
			return new ResponseEntity<BotDTO>(botDTO, HttpStatus.OK);
		}
	}
	
	@PutMapping
	public void bots(@RequestBody BotDTO element){
		Bot bot = element.converter();
		services.updateBot(bot);
	}
	
	@DeleteMapping
	public void bot(@RequestBody BotDTO element) {
		Bot bot = element.converter();
		services.deleteBot(bot);
	}
	
}
