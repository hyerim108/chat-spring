package com.practice.chat.Service;

import com.practice.chat.domain.ChatMessage;
import com.practice.chat.domain.ChatMessageRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatMessageService {
    private final ChatMessageRepo chatMessageRepo;
    @Transactional
    public void save(ChatMessage chatMessage){
        chatMessageRepo.save(chatMessage);
    }
}
