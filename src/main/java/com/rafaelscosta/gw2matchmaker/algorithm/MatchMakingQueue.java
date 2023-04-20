package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.pojo.Player;

import java.util.ArrayList;
import java.util.List;

public class MatchMakingQueue implements IQueue {

    List<Player> players = new ArrayList<>();
    MatchmakingAlgorithm algorithm;

    @Override
    public void addToQueue(Player player) {
        players.add(player);
    }

    @Override
    public void removeFromQueue(Player player) {
        players.remove(player);
    }

    @Override
    public void matchMake(List<Player> players) {
        algorithm.matchMake(players);
    }
}
