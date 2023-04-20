package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.enums.EnumPlayerRole;
import com.rafaelscosta.gw2matchmaker.pojo.Group;
import com.rafaelscosta.gw2matchmaker.pojo.Player;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MatchmakingAlgorithm implements IMatchmakingAlgorithm {

    List<Group> groups = new ArrayList<>();

    /*
        Matchmaking algorithm to match 10 PlayerTO into teams.
        Each team must contain in any distribution the following
        2 Healers, 2 Alacrity, 2 Quickness, the rest just DPS.
     */
    @Override
    public void matchMake(List<Player> players) {
        Map<String, List<Player>> playersByRole = new HashMap<>();
        List<Group> groups = new ArrayList<>();

        if (players.size() < 10) {
            throw new IllegalArgumentException("Not enough players to matchmake.");
        }

        setPlayersByRole(players, playersByRole);

        fillHealers(players);
        findQuicknessAlacrityPairs(players);
        fillDps(players);

        removeGroupedPlayers(players, groups);
    }

    /*
        Collects all players into a map, separating by each preferred role.
     */
    private void setPlayersByRole(List<Player> players, Map<String, List<Player>> playersByRole) {
        for (Player player : players) {
            for (EnumPlayerRole role : player.getSelectedRoles()) {
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
    private void fillHealers(List<Player> players) {
        List<Player> healersList = players.stream()
                .filter(player -> player.getSelectedRoles().containsAll(Arrays.asList(EnumPlayerRole.QUICKNESS_HEALER, EnumPlayerRole.ALACRITY_HEALER)))
                .toList();

        for (int i = 0; i < healersList.size(); i = i + 2) {
            Player healer1 = healersList.get(i);
            Player healer2 = healersList.get(i + 1);

            healer1.setCurrentRole(healer1.getSelectedRoles().stream().filter(role -> role.equals(EnumPlayerRole.QUICKNESS_HEALER) || role.equals(EnumPlayerRole.ALACRITY_HEALER)).findAny().orElseThrow());
            healer2.setCurrentRole(healer2.getSelectedRoles().stream().filter(role -> role.equals(EnumPlayerRole.QUICKNESS_HEALER) || role.equals(EnumPlayerRole.ALACRITY_HEALER)).findAny().orElseThrow());

            Group group = new Group();
            group.setPlayers((HashMap<String, Player>) Map.of("healer_1", healer1, "healer_2", healer2));
            group.setActivityName("Healers");
            groups.add(group);
        }
    }

    /*
        Find pairs of opposite support type from the healers, for each team.
     */
    private void findQuicknessAlacrityPairs(List<Player> players) {

    }

    /*
        Fill the teams with the rest of the players, DPS.
     */
    private void fillDps(List<Player> players) {
        Queue<Player> dpsQueue = new LinkedList<>(players);
    }

    /*
        Remove all players that were grouped, from the matchmaking pool.
     */
    private void removeGroupedPlayers(List<Player> players, List<Group> groups) {
        for (Group group : groups) {
            players.removeAll(group.getPlayers().values());
        }
    }
}
