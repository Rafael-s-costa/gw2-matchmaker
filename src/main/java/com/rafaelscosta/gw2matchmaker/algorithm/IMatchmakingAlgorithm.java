package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.to.PlayerTO;

import java.util.List;

public interface IMatchmakingAlgorithm {

    public void matchMake(List<PlayerTO> players);
}
