package myspring.web.tester.chat.room;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ChatRoomRepository {
    private final Map<String, ChatRoom> chatRoomMap = new ConcurrentHashMap<>();

    public List<ChatRoom> findAllRooms() {
        return new ArrayList<>(chatRoomMap.values());
    }

    public ChatRoom findRoomById(String id) {
        return chatRoomMap.get(id);
    }

    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = new ChatRoom(name);
        chatRoomMap.put(chatRoom.getId(), chatRoom);
        return chatRoom;
    }
}
