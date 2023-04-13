package algorithm;

import enums.EnumPlayerRole;
import to.MatchResultTO;
import to.PlayerTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchmakingAlgorithm implements IMatchmakingAlgorithm {

    List<MatchResultTO> groups = new ArrayList<>();

    /*
        Matchmaking algorithm to match 10 PlayerTO into teams.
        Each team must contain in any distribution the following
        2 Healers, 2 Alactrity, 2 Quickness, the rest just DPS.
     */
    @Override
    public void matchMake(List<PlayerTO> players) {
        Map<String, List<PlayerTO>> playersByRole = new HashMap<>();
        for (PlayerTO player : players) {
            for (EnumPlayerRole role : player.getRoles()) {
                playersByRole.get(role).add(player);
            }
        }


    }

    @Override
    public void fillHealers(List<PlayerTO> players) {

    }

    @Override
    public void findQuicknessAlacrityPairs(List<PlayerTO> players) {

    }

    @Override
    public void fillDps(List<PlayerTO> players) {

    }
}
