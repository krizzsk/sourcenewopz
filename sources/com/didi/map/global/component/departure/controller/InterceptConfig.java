package com.didi.map.global.component.departure.controller;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class InterceptConfig {

    /* renamed from: a */
    private static InterceptConfig f25045a;
    public String allow_loc_acc_level = "";
    public String allow_loc_acc_level_bad = "";
    public boolean enable = false;
    public int filter_loc_speed = 3;
    public int filter_rec_start_loc_dist = 300;
    public int filter_sel_max_start_loc_dist = 500;
    public int filter_sel_min_start_loc_dist = 200;
    public int filter_start_end_dist = 300;
    public int time_limit = 10;

    public static InterceptConfig getInstance() {
        if (f25045a == null) {
            synchronized (InterceptConfig.class) {
                if (f25045a == null) {
                    f25045a = new InterceptConfig();
                }
            }
        }
        return f25045a;
    }

    private InterceptConfig() {
        IToggle toggle = Apollo.getToggle("global_pickup_intercept_config_1111");
        if (toggle != null && toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            this.enable = ((Integer) experiment.getParam("enable", 0)).intValue() != 1 ? false : true;
            this.filter_start_end_dist = ((Integer) experiment.getParam("filter_start_end_dist", 300)).intValue();
            this.filter_sel_min_start_loc_dist = ((Integer) experiment.getParam("filter_sel_min_start_loc_dist", 200)).intValue();
            this.filter_sel_max_start_loc_dist = ((Integer) experiment.getParam("filter_sel_max_start_loc_dist", 500)).intValue();
            this.filter_rec_start_loc_dist = ((Integer) experiment.getParam("filter_rec_start_loc_dist", 300)).intValue();
            this.allow_loc_acc_level = (String) experiment.getParam("allow_loc_acc_level", "");
            this.allow_loc_acc_level_bad = (String) experiment.getParam("allow_loc_acc_level_bad", "");
            this.filter_loc_speed = ((Integer) experiment.getParam("filter_loc_speed", 3)).intValue();
            this.time_limit = ((Integer) experiment.getParam("time_limit", 10)).intValue();
        }
        DLog.m7384d("ccc", "InterceptConfig------enable:" + this.enable + ",filter_start_end_dist =" + this.filter_start_end_dist + ",filter_sel_min_start_loc_dist =" + this.filter_sel_min_start_loc_dist + ",filter_sel_max_start_loc_dist =" + this.filter_sel_max_start_loc_dist + ",filter_rec_start_loc_dist =" + this.filter_rec_start_loc_dist + ",allow_loc_acc_level =" + this.allow_loc_acc_level + ",allow_loc_acc_level_bad =" + this.allow_loc_acc_level_bad + ",filter_loc_speed =" + this.allow_loc_acc_level + ",time_limit =" + this.time_limit, new Object[0]);
    }
}
