package com.rafaelscosta.gw2matchmaker.algorithm;

import com.rafaelscosta.gw2matchmaker.enums.EnumPlayerRole;
import com.rafaelscosta.gw2matchmaker.to.PlayerTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MatchmakingAlgorithmTest {

    @Autowired
    public MatchmakingAlgorithm matchmakingAlgorithm;

    @Test
    void matchMake() {
        List<PlayerTO> pool = new ArrayList<>();
        pool.add(new PlayerTO("PlayerTO1","aaaa", List.of(EnumPlayerRole.QUICKNESS_DPS, EnumPlayerRole.HEALER)));
        pool.add(new PlayerTO("PlayerTO2", "aaaa", List.of(EnumPlayerRole.ALACRITY_DPS, EnumPlayerRole.HEALER)));
        pool.add(new PlayerTO("PlayerTO3", "aaaa", List.of(EnumPlayerRole.ALACRITY_HEALER)));
        pool.add(new PlayerTO("PlayerTO4", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO5", "aaaa", List.of(EnumPlayerRole.QUICKNESS_HEALER)));
        pool.add(new PlayerTO("PlayerTO6", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO7", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO8", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO9", "aaaa", List.of(EnumPlayerRole.HEALER, EnumPlayerRole.ALACRITY_HEALER)));
        pool.add(new PlayerTO("PlayerTO10", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO11", "aaaa", List.of(EnumPlayerRole.HEALER)));
        pool.add(new PlayerTO("PlayerTO12", "aaaa", List.of(EnumPlayerRole.HEALER, EnumPlayerRole.ALACRITY_HEALER)));
        pool.add(new PlayerTO("PlayerTO13", "aaaa", List.of(EnumPlayerRole.DPS)));
        pool.add(new PlayerTO("PlayerTO14", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO15", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO16", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO17", "aaaa", List.of(EnumPlayerRole.QUICKNESS_HEALER)));
        pool.add(new PlayerTO("PlayerTO18", "aaaa", List.of(EnumPlayerRole.HEALER)));
        pool.add(new PlayerTO("PlayerTO19", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO20", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
    }

    @Test
    void test_empty_queue() {

    }

    @Test
    void test_queue_with_one_player() {

    }

    @Test
    void test_queue_with_no_healers() {
        List<PlayerTO> pool = new ArrayList<>();
        pool.add(new PlayerTO("PlayerTO1","aaaa", List.of(EnumPlayerRole.QUICKNESS_DPS, EnumPlayerRole.DPS)));
        pool.add(new PlayerTO("PlayerTO2", "aaaa", List.of(EnumPlayerRole.ALACRITY_DPS, EnumPlayerRole.DPS)));
        pool.add(new PlayerTO("PlayerTO3", "aaaa", List.of(EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO4", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO5", "aaaa", List.of(EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO6", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO7", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO8", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO9", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO10", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.QUICKNESS_DPS)));
        pool.add(new PlayerTO("PlayerTO11", "aaaa", List.of(EnumPlayerRole.DPS)));
        pool.add(new PlayerTO("PlayerTO12", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));
        pool.add(new PlayerTO("PlayerTO13", "aaaa", List.of(EnumPlayerRole.DPS)));
        pool.add(new PlayerTO("PlayerTO14", "aaaa", List.of(EnumPlayerRole.DPS, EnumPlayerRole.ALACRITY_DPS)));

        matchmakingAlgorithm.matchMake(pool);
    }
}