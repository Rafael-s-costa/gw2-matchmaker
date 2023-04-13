package algorithm;

import to.PlayerTO;

import java.util.List;

public interface IMatchmakingAlgorithm {

    public void matchMake(List<PlayerTO> players);

    public void fillHealers(List<PlayerTO> players);

    public void findQuicknessAlacrityPairs(List<PlayerTO> players);

    public void fillDps(List<PlayerTO> players);
}
