package com.yedeveloper.chat.modules.chat.entity;

import com.yedeveloper.chat.modules.chat.form.ChatRoomForm;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document( collation = "chat_room" )
public class ChatRoom {

    @Id
    private Long chatRoomId;
    private Long accountId;

    private LocalDateTime createdTime;

    ChatRoom ( ChatRoomForm chatRoomForm ) {
        this.chatRoomId = chatRoomForm.getTravelGroupId();
        this.accountId = chatRoomForm.getAccountId();
        this.createdTime = LocalDateTime.now();
    }

    public static ChatRoom from ( ChatRoomForm chatRoomForm ) {
        return new ChatRoom( chatRoomForm );
    }
}
