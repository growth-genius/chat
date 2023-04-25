package com.yedeveloper.chat.modules.chat.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ChatRoomForm {

    @JsonProperty( "travel_group_id" )
    private Long travelGroupId;
    @JsonProperty( "account_id" )
    private Long accountId;

    public ChatRoomForm ( long travelGroupId, long accountId ) {
        this.travelGroupId = travelGroupId;
        this.accountId = accountId;
    }

    public static ChatRoomForm createFormByTest () {
        return new ChatRoomForm( 1L, 1L );
    }

}
