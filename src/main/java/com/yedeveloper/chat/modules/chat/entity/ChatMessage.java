package com.yedeveloper.chat.modules.chat.entity;

import com.yedeveloper.chat.modules.chat.dto.ChatClientDTO;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document( collation = "chat_message" )
public class ChatMessage {

    @Id
    private String id;

    private String chatRoomId;

    private String accountId;

    private String content;

    private LocalDateTime messageTime;

    ChatMessage ( String chatRoomId, ChatClientDTO chatClientDTO ) {
        this.chatRoomId = chatRoomId;
        this.content = chatClientDTO.getContent();
        this.accountId = chatClientDTO.getAccountId();
        messageTime = LocalDateTime.now();
    }

    public static ChatMessage of ( String chatRoomId, ChatClientDTO chatMessageDTO ) {
        return new ChatMessage( chatRoomId, chatMessageDTO );
    }
}
