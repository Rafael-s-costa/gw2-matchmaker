package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.pojo.Player;

import java.util.List;

public interface IQueue {

    public void addToQueue(Player player);

    public void removeFromQueue(Player player);

    public void matchMake(List<Player> players);
}
