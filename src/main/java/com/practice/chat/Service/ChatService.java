package com.practice.chat.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.chat.DTO.ChatRoomDTO;
import com.practice.chat.domain.ChatRoom;
import com.practice.chat.domain.ChatRoomRepo;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
    private final ObjectMapper objectMapper;
    private final ChatRoomRepo chatRoomRepo;
    @Transactional
    public void createRoom(ChatRoomDTO roomDTO){ //생성된 룸 저장
        chatRoomRepo.save(roomDTO.toEntity());
    }
    @Transactional
    public List<ChatRoomDTO> findAllRoom(){ //룸 전체 리스트 반환
        return chatRoomRepo.findAll().stream()
                .map(ChatRoomDTO::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public String findRoomById(String roomId){
        return chatRoomRepo.findById(roomId).get().getRoomId();
    }
}
