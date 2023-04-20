package com.rafaelscosta.gw2matchmaker.pojo;

import com.rafaelscosta.gw2matchmaker.enums.EnumPlayerRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private String                   accountName;
    private String                   apiKey;
    private HashSet<EnumPlayerRole>  selectedRoles;
    private EnumPlayerRole           currentRole;
}
