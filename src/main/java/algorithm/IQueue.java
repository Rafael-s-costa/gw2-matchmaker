package algorithm;

import to.PlayerTO;

import java.util.List;

public interface IQueue {

    public void addToQueue(PlayerTO player);

    public void removeFromQueue(PlayerTO player);

    public void matchMake(List<PlayerTO> players);
}
