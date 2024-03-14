package com.practice.chat.DTO;

import com.practice.chat.domain.ChatRoom;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class ChatRoomDTO {
        @Id
        private String roomId;
        private String name;
        //    private Set<WebSocketSession> sessions = new HashSet<>();
        public ChatRoomDTO(ChatRoom chatRoom){
            this.roomId = chatRoom.getRoomId();
            this.name = chatRoom.getName();
        }
        @Builder
        public ChatRoomDTO(String roomId, String name){
            this.roomId = roomId;
            this.name = name;
        }
        public ChatRoom toEntity(){
            return ChatRoom.builder()
                    .roomId(this.roomId)
                    .name(this.name)
                    .build();
        }
}
