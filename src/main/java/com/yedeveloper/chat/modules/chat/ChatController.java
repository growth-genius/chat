package com.yedeveloper.chat.modules.chat;

import com.yedeveloper.chat.modules.chat.dto.ChatClientDTO;
import com.yedeveloper.chat.modules.chat.dto.ChatMessageDTO;
import com.yedeveloper.chat.modules.common.annotation.BaseControllerAnnotation;
import com.yedeveloper.chat.modules.utils.ApiUtil;
import com.yedeveloper.chat.modules.utils.ApiUtil.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@BaseControllerAnnotation
@RequiredArgsConstructor
@RequestMapping( "/chat" )
public class ChatController {

    private final ChatService chatService;

    @MessageMapping( "/chatroom/{chatroom_id}/message" )
    @SendTo( "/chatroom" )
    public ApiResult<ChatMessageDTO> chat ( @RequestParam Long chatRoomId, ChatClientDTO message ) throws Exception {
        Thread.sleep( 1000 ); // simulated delay
        return ApiUtil.success( chatService.sendMessage( chatRoomId, message ) );
    }


}
