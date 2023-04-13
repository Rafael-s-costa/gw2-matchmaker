package algorithm;

import to.PlayerTO;

import java.util.ArrayList;
import java.util.List;

public class MatchMakingQueue implements IQueue {

    List<PlayerTO> players = new ArrayList<>();
    MatchmakingAlgorithm algorythm = new MatchmakingAlgorithm();

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
        algorythm.matchMake(players);
    }
}
