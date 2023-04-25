package com.yedeveloper.chat.modules.chat;

import com.yedeveloper.chat.modules.chat.dto.ChatClientDTO;
import com.yedeveloper.chat.modules.chat.dto.ChatMessageDTO;
import com.yedeveloper.chat.modules.chat.form.ChatRoomForm;
import com.yedeveloper.chat.modules.common.annotation.BaseControllerAnnotation;
import com.yedeveloper.chat.modules.utils.ApiUtil;
import com.yedeveloper.chat.modules.utils.ApiUtil.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@BaseControllerAnnotation
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping( "/chatroom" )
    public ApiResult<ChatRoomDTO> createChatRoom ( @RequestBody ChatRoomForm chatRoomForm ) {
        return ApiUtil.success( chatService.createChatRoom( chatRoomForm ) );
    }

    @MessageMapping( "/chatroom/{chatroom_id}/message" )
    @SendTo( "/app/chat/message" )
    public ApiResult<ChatMessageDTO> chat ( @RequestParam String chatRoomId, ChatClientDTO message ) throws Exception {
        Thread.sleep( 1000 ); // simulated delay
        return ApiUtil.success( chatService.sendMessage( chatRoomId, message ) );
    }


}
