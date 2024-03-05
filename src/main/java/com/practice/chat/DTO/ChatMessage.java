package com.practice.chat.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 채팅 메세지 구현
 * 메세지타입 : 입장, 채팅
 */
@Getter
@Setter
public class ChatMessage {
    public enum MessageType{
        ENTER,TALK
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
