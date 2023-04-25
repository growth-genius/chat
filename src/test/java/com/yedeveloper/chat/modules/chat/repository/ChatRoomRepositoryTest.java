package com.yedeveloper.chat.modules.chat.repository;

import com.yedeveloper.chat.modules.chat.entity.ChatRoom;
import com.yedeveloper.chat.modules.chat.form.ChatRoomForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName( "채팅 레포지토리 테스트" )
class ChatRoomRepositoryTest {

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Test
    @DisplayName( "채팅 저장 확인 - 테스트케이스1" )
    void test_case_1 () {
        ChatRoomForm formByTest = ChatRoomForm.createFormByTest();

        ChatRoom chatRoom = ChatRoom.from( formByTest );
        chatRoomRepository.save( chatRoom );

    }

}