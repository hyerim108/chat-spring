package com.practice.chat.Controller;

import com.practice.chat.DTO.ChatRoomDTO;
import com.practice.chat.Service.ChatService;
import com.practice.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class mainController {
    private final ChatService chatService;
    @GetMapping("/")
    public String chatGET(Model model){
        model.addAttribute("chats",chatService.findAllRoom());
        return "chat";
    }
    @GetMapping("/room")
    public String room(){
        return "room";
    }
}
