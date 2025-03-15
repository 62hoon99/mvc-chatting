package myspring.web.tester.chat.room;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoom> getAllRooms() {
        return chatRoomRepository.findAllRooms();
    }

    public ChatRoom createRoom(String name) {
        return chatRoomRepository.createRoom(name);
    }

    public ChatRoom getRoomById(String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }
}
