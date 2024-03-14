package com.practice.chat.domain;
//
//import com.practice.chat.Service.ChatService;
//import com.practice.chat.domain.ChatMessage;
import com.practice.chat.Service.ChatService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
/**
 * 채팅방 구현
 */
@Getter
@NoArgsConstructor
@Entity
public class ChatRoom {
    @Id
    private String roomId;
    @Column
    private String name;
//    private Set<WebSocketSession> sessions = new HashSet<>();
    @Builder
    public ChatRoom(String roomId, String name){
        this.roomId = roomId;
        this.name = name;
    }
}
