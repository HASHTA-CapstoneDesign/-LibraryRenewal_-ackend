package hallym.hashtag.domain.chatBot;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/chatbot")
public class ChatBotController {

    @GetMapping
    public Map<String, String> ChatBot(@RequestParam(name = "message") String message) throws IOException {
        String result = Jsoup.connect("http://localhost:5000/chatbot/?input="+message).get().text();;
        return Map.of("result", result);
    }
}

