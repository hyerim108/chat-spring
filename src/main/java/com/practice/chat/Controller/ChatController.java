package com.practice.chat.Controller;

import com.practice.chat.DTO.ChatRoomDTO;
import com.practice.chat.domain.ChatRoom;
import com.practice.chat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    @PostMapping
    public void createRoom(@RequestBody ChatRoomDTO chatRoomDTO)
    {
        String randomId = UUID.randomUUID().toString();
        System.out.println("roomId >>>> "+randomId);
        ChatRoomDTO roomDTO = new ChatRoomDTO(randomId,chatRoomDTO.getName());
        chatService.createRoom(roomDTO);
    }
    @GetMapping
    public List<ChatRoomDTO> findAllRoom(){
        return chatService.findAllRoom();
    }
}
