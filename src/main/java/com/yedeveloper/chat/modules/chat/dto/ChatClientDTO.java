package com.yedeveloper.chat.modules.chat.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.validation.constraints.Max;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@JsonAutoDetect
@RequiredArgsConstructor
public class ChatClientDTO {

    @Max( value = 1000 )
    private String content;

    private String accountId;

    ChatClientDTO ( String content ) {
        this.content = content;
    }

    public static ChatClientDTO createDTOByTest () {
        return new ChatClientDTO( "안녕" );
    }

}
