package br.com.developer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.developer.model.Messages;

@Repository
public interface MessageRepository extends CrudRepository<Messages, Integer> {

	public Iterable<Messages> findByConversationId(String conversationId);
}
