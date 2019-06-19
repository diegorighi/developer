package br.com.developer.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.developer.model.Bot;

public class BotDTO implements Serializable{

	private static final long serialVersionUID = 7713482716659934068L;

	@NotNull 
	@Length(min=2, max=50)
	private String name = null;
	
	@Deprecated
	public BotDTO() {}
	
	public BotDTO(String id, String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Bot converter() {
		return new Bot(this.name);
	}
	
}
