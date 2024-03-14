package com.practice.chat.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.chat.Service.ChatMessageService;
import com.practice.chat.domain.ChatMessage;
import com.practice.chat.domain.ChatRoom;
import com.practice.chat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
/**
 * socket 통신은 서버와 클라이언트가 1:n으로 관계를 맺는다. 한서버에 여러 클라이언트 접속가능
 * 서버에는 여러 클라이언트가 발송한 메세지를 받아 처리해줄 handler가 필요하다
 * textwebsocketHandler를 상속받아 handler작성
 * client로 받은 메세지를 출력하고 환영메세지를 보내줌
 **/
@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    //클라이언트가 작성한 메세지를 받아서 처리해줄 핸들러
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //받은 메세지를 console log에 payload에 담아 출력
        String payload = message.getPayload();
        log.info("payload {}", payload);
        //환영메세지를 보내줌
//        TextMessage textMessage = new TextMessage("Welcome Chat Server");
//        session.sendMessage(textMessage);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//        String chatRoom = chatService.findRoomById(chatMessage.getRoomId());
        chatMessageService.save(chatMessage);
    }
}
