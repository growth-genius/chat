package com.yedeveloper.chat.modules.chat.dto;

import com.yedeveloper.chat.modules.chat.entity.ChatMessage;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ChatMessageDTO {

    private String content;

    private LocalDateTime meesageTime;

    ChatMessageDTO ( ChatMessage chatMessage ) {
        this.content = chatMessage.getContent();
        this.meesageTime = chatMessage.getMessageTime();
    }

    public static ChatMessageDTO from ( ChatMessage chatMessage ) {
        return new ChatMessageDTO( chatMessage );
    }

}
