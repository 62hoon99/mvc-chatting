package myspring.web.tester.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        String roomId = chatMessage.getRoomId(); // ChatMessage 안에 있는 roomId 가져오기
        messagingTemplate.convertAndSend("/topic/chat/" + roomId, chatMessage);
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        String roomId = chatMessage.getRoomId(); // ChatMessage 안에 있는 roomId 가져오기
        messagingTemplate.convertAndSend("/topic/chat/" + roomId, chatMessage, headerAccessor.toMap());
    }

}
