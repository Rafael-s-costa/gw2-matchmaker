package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.to.PlayerTO;

import java.util.List;

public interface IQueue {

    public void addToQueue(PlayerTO player);

    public void removeFromQueue(PlayerTO player);

    public void matchMake(List<PlayerTO> players);
}
