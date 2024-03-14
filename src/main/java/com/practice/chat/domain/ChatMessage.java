package com.practice.chat.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 채팅 메세지 구현
 * 메세지타입 : 입장, 채팅
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ChatMessage {
    public enum MessageType{
        ENTER,TALK
    }
    private MessageType type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;
    @Column
    private String roomId;
    @Column
    private String sender;
    @Column
    private String message;
}
