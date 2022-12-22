package com.didi.map.global.flow.scene.minibus.scene.service;

public enum MiniBusTripSceneState {
    STATE_ETA_OVER_25("state_eta_over_25"),
    STATE_ETA_BELOW_25("state_eta_below_25"),
    STATE_PICKUP("state_pick"),
    STATE_WAITING_FOR_DRIVING("state_waiting_for_driving"),
    STATE_DRIVE_OFF("state_drive_off");

    private MiniBusTripSceneState(String str) {
    }
}
