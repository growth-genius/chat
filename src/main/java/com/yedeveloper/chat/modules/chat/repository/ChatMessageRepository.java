package com.yedeveloper.chat.modules.chat.repository;

import com.yedeveloper.chat.modules.chat.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {}
