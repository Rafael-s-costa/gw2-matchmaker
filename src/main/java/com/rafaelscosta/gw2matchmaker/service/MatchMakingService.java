package com.rafaelscosta.gw2matchmaker.service;

import com.rafaelscosta.gw2matchmaker.algorithm.MatchMakingQueue;
import com.rafaelscosta.gw2matchmaker.pojo.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchMakingService {

    private List<Player> players;
    private MatchMakingQueue matchMakingQueue;

    public void matchMake(Player player) {
        matchMakingQueue.matchMake(players);
    }
}
