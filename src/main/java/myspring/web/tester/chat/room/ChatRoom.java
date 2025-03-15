package myspring.web.tester.chat.room;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ChatRoom {
    private String id;
    private String name;

    public ChatRoom() {
    }

    public ChatRoom(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

}
