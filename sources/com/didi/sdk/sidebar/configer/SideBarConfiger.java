package com.didi.sdk.sidebar.configer;

public enum SideBarConfiger implements Configer {
    CONFIG_VERSION("config_version", 0),
    inviteItemVersion("invite_item_version"),
    Red_invite_red_point("invite_redpoint", 0),
    OLD_invite_red_point("invite_red_point"),
    GAME_game_id("game_id"),
    GAME_game_id_local("game_id_local"),
    OLD_game_show_redpoint("game_show_redpoint"),
    DIDI_PASS_DATA(DidiPassSp.DIDI_PASS_DATA_GET_PROFILE, (int) ""),
    Passenger_Sidebar("Passenger_Sidebar", (int) "");
    
    private String defaultValue;
    private String name;

    private SideBarConfiger(String str) {
        this.name = null;
        this.defaultValue = null;
        this.name = str;
        this.defaultValue = "";
    }

    private SideBarConfiger(String str, boolean z) {
        this.name = null;
        this.defaultValue = null;
        this.name = str;
        this.defaultValue = z ? "1" : "0";
    }

    private SideBarConfiger(String str, int i) {
        this.name = null;
        this.defaultValue = null;
        this.name = str;
        this.defaultValue = String.valueOf(i);
    }

    private SideBarConfiger(String str, String str2) {
        this.name = null;
        this.defaultValue = null;
        this.name = str;
        this.defaultValue = str2;
    }

    private SideBarConfiger(String str, long j) {
        this.name = null;
        this.defaultValue = null;
        this.name = str;
        this.defaultValue = String.valueOf(j);
    }

    public String getName() {
        return this.name;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }
}
