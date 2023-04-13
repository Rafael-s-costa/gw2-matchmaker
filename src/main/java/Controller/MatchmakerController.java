package Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import to.MatchResultTO;

@Controller
public class MatchmakerController {

    @MessageMapping("/matchmaking")
    public String enterMatchmaking() {
        return "matchmaking";
    }
}
