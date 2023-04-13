package enums;

public enum EnumRaid {
    SPIRIT_VALE("Spirit Vale"),
    SALVATION_PASS("Salvation Pass"),
    STRONGHOLD_OF_THE_FAITHFUL("Stronghold of the Faithful"),
    BASTION_OF_THE_PENITENT("Bastion of the Penitent"),
    HALL_OF_CHAINS("Hall of Chains"),
    MYTHWRIGHT_GAMBIT("Mythwright Gambit"),
    THE_KEY_OF_AHDASHIM("The Key of Ahdashim");

    private String name;

    private EnumRaid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
