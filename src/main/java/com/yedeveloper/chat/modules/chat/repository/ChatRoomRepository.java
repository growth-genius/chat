package com.yedeveloper.chat.modules.chat.repository;

import com.yedeveloper.chat.modules.chat.entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, Long> {}
