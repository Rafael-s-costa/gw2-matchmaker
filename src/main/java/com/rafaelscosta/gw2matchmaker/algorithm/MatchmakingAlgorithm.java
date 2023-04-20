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
        List<Player> playersClone = new ArrayList<>(players);
        List<Group> groups = new ArrayList<>();

        if (players.size() < 10) {
            throw new IllegalArgumentException("Not enough players to matchmake.");
        }

        fillHealers(playersClone);
        findQuicknessAlacrityPairs(playersClone);
        fillDps(playersClone);

        removeGroupsNotFull(groups);

        removeGroupedPlayers(players, groups);
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

            players.remove(healer1);
            players.remove(healer2);
        }
    }

    /*
        Find pairs of opposite dps support type from the healers, for each team.
     */
    private void findQuicknessAlacrityPairs(List<Player> players) {
        for (Group group: groups) {
            Player healer1 = group.getPlayers().get("healer_1");
            Player healer2 = group.getPlayers().get("healer_2");

            List<Player> supportDpsList = players.stream()
                    .filter(player -> player.getSelectedRoles().containsAll(Arrays.asList(EnumPlayerRole.QUICKNESS_DPS, EnumPlayerRole.ALACRITY_DPS)))
                    .toList();

            for (int i = 0; i < supportDpsList.size(); i = i + 2) {
                Player dps1 = supportDpsList.get(i);
                Player dps2 = supportDpsList.get(i + 1);

                if (healer1.getCurrentRole().equals(EnumPlayerRole.QUICKNESS_HEALER) && healer2.getCurrentRole().equals(EnumPlayerRole.QUICKNESS_HEALER)) {
                    dps1.setCurrentRole(EnumPlayerRole.ALACRITY_DPS);
                    dps2.setCurrentRole(EnumPlayerRole.ALACRITY_DPS);
                } else if (healer1.getCurrentRole().equals(EnumPlayerRole.ALACRITY_HEALER) && healer2.getCurrentRole().equals(EnumPlayerRole.ALACRITY_HEALER)) {
                    dps1.setCurrentRole(EnumPlayerRole.QUICKNESS_DPS);
                    dps2.setCurrentRole(EnumPlayerRole.QUICKNESS_DPS);
                } else {
                    dps1.setCurrentRole(EnumPlayerRole.QUICKNESS_DPS);
                    dps2.setCurrentRole(EnumPlayerRole.ALACRITY_DPS);
                }

                group.getPlayers().put("support_dps_1", dps1);
                group.getPlayers().put("support_dps_2", dps2);

                players.remove(dps1);
                players.remove(dps2);
            }
        }
    }

    /*
        Fill the teams with the rest of the players, DPS.
     */
    private void fillDps(List<Player> players) {
        List<Player> dpsList = players.stream()
                .filter(player -> player.getSelectedRoles().contains(EnumPlayerRole.DPS))
                .toList();

        for (Group group: groups) {
            int batchSize = 6;
            int numBatches = (dpsList.size() + batchSize - 1) / batchSize; // round up to the nearest integer
            for (int batchIndex = 0; batchIndex < numBatches; batchIndex++) {
                int fromIndex = batchIndex * batchSize;
                int toIndex = Math.min(fromIndex + batchSize, dpsList.size());
                List<Player> dpsBatch = dpsList.subList(fromIndex, toIndex);

                if (dpsBatch.size() < 6) {
                    continue;
                }

                for (int i = 0; i < dpsBatch.size(); i++) {
                    Player dps = dpsBatch.get(i);
                    group.getPlayers().put("dps_" + (i + 1), dps);
                    players.remove(dps);
                }
            }
        }
    }

    private void removeGroupsNotFull(List<Group> groups) {
        groups.removeIf(group -> group.getPlayers().size() < 10);
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
