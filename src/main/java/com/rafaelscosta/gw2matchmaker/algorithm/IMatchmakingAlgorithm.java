package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.pojo.Player;

import java.util.List;

public interface IMatchmakingAlgorithm {

    public void matchMake(List<Player> players);
}
