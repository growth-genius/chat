package com.yedeveloper.chat.modules.chat;

import com.yedeveloper.chat.modules.chat.entity.ChatRoom;
import lombok.Data;

@Data
public class ChatRoomDTO {

    private Long chatRoomId;

    public ChatRoomDTO ( ChatRoom chatRoom ) {
        this.chatRoomId = chatRoom.getChatRoomId();
    }

    public static ChatRoomDTO from ( ChatRoom chatRoom ) {
        return new ChatRoomDTO( chatRoom );
    }

}
