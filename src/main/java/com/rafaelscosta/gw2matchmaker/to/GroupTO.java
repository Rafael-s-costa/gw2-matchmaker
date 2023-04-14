package com.rafaelscosta.gw2matchmaker.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupTO {

    public List<PlayerTO> players;
    public String activityName;
}
