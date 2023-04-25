package com.yedeveloper.chat.modules.chat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.yedeveloper.chat.modules.chat.dto.ChatClientDTO;
import com.yedeveloper.chat.modules.chat.dto.ChatMessageDTO;
import com.yedeveloper.chat.modules.chat.form.ChatRoomForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatServiceTest {

    @Autowired
    private ChatService chatService;

    @Test
    @DisplayName( "채팅 방 개설하기" )
    void test_case_1 () {

        ChatRoomDTO chatRoomDTO = chatService.createChatRoom( ChatRoomForm.createFormByTest() );

        assertNotNull( chatRoomDTO.getChatRoomId() );

    }

    @Test
    @DisplayName( "메세지 보내기" )
    void 메세지보내기 () {

        long chatRoomId = 1L;
        ChatMessageDTO chatMessageDTO = chatService.sendMessage( chatRoomId, ChatClientDTO.createDTOByTest() );
        assertEquals( "안녕", chatMessageDTO.getContent() );

    }

}