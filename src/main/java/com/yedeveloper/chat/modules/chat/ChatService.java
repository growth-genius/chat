package com.yedeveloper.chat.modules.chat;

import com.yedeveloper.chat.modules.chat.dto.ChatClientDTO;
import com.yedeveloper.chat.modules.chat.dto.ChatMessageDTO;
import com.yedeveloper.chat.modules.chat.entity.ChatMessage;
import com.yedeveloper.chat.modules.chat.entity.ChatRoom;
import com.yedeveloper.chat.modules.chat.form.ChatRoomForm;
import com.yedeveloper.chat.modules.chat.repository.ChatMessageRepository;
import com.yedeveloper.chat.modules.chat.repository.ChatRoomRepository;
import com.yedeveloper.chat.modules.common.annotation.BaseServiceAnnotation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@BaseServiceAnnotation
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageDTO sendMessage ( String chatRoomId, ChatClientDTO message ) {
        ChatMessage chatMessage = ChatMessage.of( chatRoomId, message );
        chatMessageRepository.save( chatMessage );

        return ChatMessageDTO.from( chatMessage );
    }

    public ChatRoomDTO createChatRoom ( ChatRoomForm chatRoomForm ) {
        ChatRoom chatRoom = chatRoomRepository.findById( chatRoomForm.getTravelGroupId() ).orElse(
            chatRoomRepository.save( ChatRoom.from( chatRoomForm ) ) );
        return ChatRoomDTO.from( chatRoom );
    }
}
