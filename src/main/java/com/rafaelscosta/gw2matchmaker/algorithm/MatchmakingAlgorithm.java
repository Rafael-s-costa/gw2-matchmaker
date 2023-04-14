package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.enums.EnumPlayerRole;
import com.rafaelscosta.gw2matchmaker.to.GroupTO;
import com.rafaelscosta.gw2matchmaker.to.PlayerTO;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MatchmakingAlgorithm implements IMatchmakingAlgorithm {

    List<GroupTO> groups = new ArrayList<>();

    /*
        Matchmaking algorithm to match 10 PlayerTO into teams.
        Each team must contain in any distribution the following
        2 Healers, 2 Alacrity, 2 Quickness, the rest just DPS.
     */
    @Override
    public void matchMake(List<PlayerTO> players) {
        Map<String, List<PlayerTO>> playersByRole = new HashMap<>();
        List<GroupTO> groups = new ArrayList<>();

        setPlayersByRole(players, playersByRole);

        fillHealers(players);
        findQuicknessAlacrityPairs(players);
        fillDps(players);

        removeGroupedPlayers(players, groups);
    }

    /*
        Collects all players into a map, separating by each preferred role.
     */
    private void setPlayersByRole(List<PlayerTO> players, Map<String, List<PlayerTO>> playersByRole) {
        for (PlayerTO player : players) {
            for (EnumPlayerRole role : player.getRoles()) {
                if (!playersByRole.containsKey(role.toString())) {
                    playersByRole.put(role.toString(), new ArrayList<>());
                }

                playersByRole.get(role.toString()).add(player);
            }
        }
    }

    /*
        Fill the teams with 2 Healers, of any type.
     */
    private void fillHealers(List<PlayerTO> players) {

    }

    /*
        Find pairs of opposite support type from the healers, for each team.
     */
    private void findQuicknessAlacrityPairs(List<PlayerTO> players) {

    }

    /*
        Fill the teams with the rest of the players, DPS.
     */
    private void fillDps(List<PlayerTO> players) {
        Queue<PlayerTO> dpsQueue = new LinkedList<>(players);
    }

    private void removeGroupedPlayers(List<PlayerTO> players, List<GroupTO> groups) {
        for (GroupTO group : groups) {
            players.removeAll(group.getPlayers());
        }
    }
}
