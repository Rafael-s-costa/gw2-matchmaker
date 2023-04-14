package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.to.PlayerTO;

import java.util.ArrayList;
import java.util.List;

public class MatchMakingQueue implements IQueue {

    List<PlayerTO> players = new ArrayList<>();
    MatchmakingAlgorithm algorithm;

    @Override
    public void addToQueue(PlayerTO player) {
        players.add(player);
    }

    @Override
    public void removeFromQueue(PlayerTO player) {
        players.remove(player);
    }

    @Override
    public void matchMake(List<PlayerTO> players) {
        algorithm.matchMake(players);
    }
}
