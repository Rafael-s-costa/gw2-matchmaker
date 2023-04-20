package com.rafaelscosta.gw2matchmaker.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    private HashMap<String, Player> players;
    private String activityName;
}
