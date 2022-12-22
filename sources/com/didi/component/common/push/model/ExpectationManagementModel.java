package com.didi.component.common.push.model;

import java.io.Serializable;

public class ExpectationManagementModel implements Serializable {
    public static final long BIT_EPIDEMIC = 1;
    public String did;
    public int driver_num;
    public int duse_status;
    public double lat;
    public double lng;
    public String oid;
    public String oid_base64;
    public long order_feature;
    public String pmsg;
    public int scene;
    public int scene_countdown_time;
    public int showtime;
    public int use_pmsg;
    public int wait_time = -1;

    public boolean isEpidemic() {
        return (this.order_feature & 1) != 0;
    }
}
