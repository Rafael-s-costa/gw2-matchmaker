package com.rafaelscosta.gw2matchmaker.service;

import com.rafaelscosta.gw2matchmaker.algorithm.MatchMakingQueue;
import com.rafaelscosta.gw2matchmaker.to.PlayerTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchMakingService {

    private List<PlayerTO> players;
    private MatchMakingQueue matchMakingQueue;

    public void matchMake(PlayerTO player) {
        matchMakingQueue.matchMake(players);
    }
}
