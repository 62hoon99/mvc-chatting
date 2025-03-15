package myspring.web.tester.chat;

import lombok.Getter;

@Getter
public class ChatMessage {
    private String type;  // 메시지 타입 (ENTER, CHAT, LEAVE)
    private String sender;
    private String content;
    private String roomId;

    public ChatMessage() {}

    public ChatMessage(String type, String sender, String content, String roomId) {
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.roomId = roomId;
    }

}
