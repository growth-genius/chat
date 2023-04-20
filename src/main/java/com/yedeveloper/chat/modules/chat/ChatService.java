package com.yedeveloper.chat.modules.chat;

import com.yedeveloper.chat.modules.chat.dto.ChatClientDTO;
import com.yedeveloper.chat.modules.chat.dto.ChatMessageDTO;
import com.yedeveloper.chat.modules.common.annotation.BaseServiceAnnotation;

@BaseServiceAnnotation
public class ChatService {

    public ChatMessageDTO sendMessage ( Long chatRoomId, ChatClientDTO message ) {

        return new ChatMessageDTO();
    }
    
}
