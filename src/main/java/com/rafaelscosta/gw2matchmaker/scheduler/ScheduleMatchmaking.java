package com.rafaelscosta.gw2matchmaker.scheduler;

import com.rafaelscosta.gw2matchmaker.service.MatchMakingService;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleMatchmaking {

    MatchMakingService matchMakingService;

    private final int MATCHMAKING_INTERVAL = 30000;

    @Scheduled(fixedDelay = MATCHMAKING_INTERVAL)
    public void runMatchmaking() {
        //matchMakingService.matchMake();
    }
}
