package myspring.web.tester.chat.room;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @GetMapping
    public String showChatRooms(Model model) {
        List<ChatRoom> chatRooms = chatRoomService.getAllRooms();
        model.addAttribute("chatRooms", chatRooms);
        return "chat/chat-rooms";
    }

    @PostMapping("/create")
    public String createRoom(@RequestParam String name) {
        chatRoomService.createRoom(name);
        return "redirect:/chat";
    }

    @GetMapping("/{roomId}")
    public String enterChatRoom(@PathVariable String roomId, Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");

        if (username == null) {
            model.addAttribute("roomId", roomId);
            return "chat/chat-enter"; // 사용자 이름을 입력하는 페이지로 이동
        }

        model.addAttribute("roomId", roomId);
        model.addAttribute("username", username);
        return "chat/chatroom"; // 채팅방으로 이동
    }

    @PostMapping("/{roomId}/join")
    public String joinChatRoom(@PathVariable String roomId, @RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
        return "redirect:/chat/" + roomId;
    }
}
