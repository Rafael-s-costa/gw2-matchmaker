package com.rafaelscosta.gw2matchmaker.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MatchmakerController {

    @MessageMapping("/matchmaking")
    public String enterMatchmaking() {
        return "matchmaking";
    }
}
