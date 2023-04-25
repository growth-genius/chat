package com.yedeveloper.chat.modules.chat.repository;

import com.yedeveloper.chat.modules.chat.entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom, Long> {}
