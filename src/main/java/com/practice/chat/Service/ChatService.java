package com.practice.chat.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.chat.DTO.ChatRoom;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRoomMap;
    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();
    }
    public List<ChatRoom> findAllRoom(){
        return new ArrayList<>(chatRoomMap.values());
    }
    public ChatRoom findRoomById(String roomId){
        return chatRoomMap.get(roomId);
    }
    public ChatRoom createRoom(String name){
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(randomId)
                .name(name)
                .build();
        chatRoomMap.put(randomId,chatRoom);
        return chatRoom;
    }
    public <T> void sendMessage(WebSocketSession webSocketSession, T message){
        try{
            webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        }catch(IOException e){
            log.error(e.getMessage(),e);
        }
    }
}
