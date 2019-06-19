package br.com.developer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Bot {

	@Id
	@Length(max=50)
	private String id;
	
	@Length(max=50)
	private String name;
	
	@Deprecated
	public Bot() {}
	
	public Bot(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
