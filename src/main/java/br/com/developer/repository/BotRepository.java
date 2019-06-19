package br.com.developer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.developer.model.Bot;

@Repository
public interface BotRepository extends CrudRepository<Bot, String>{

}
