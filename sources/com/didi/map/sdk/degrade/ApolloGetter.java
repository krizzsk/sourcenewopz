package com.didi.map.sdk.degrade;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloGetter {
    public int crash_count;
    public int down_dmap_mode;
    public String down_dmap_vendor;
    public int down_gmap_mode;
    public String down_gmap_vendor;
    public String key;
    public int time_range;
    public int valid_time;

    public static ApolloGetter get() {
        IToggle toggle = Apollo.getToggle("global_android_map_degradation_toggle");
        if (toggle == null || !toggle.allow()) {
            return null;
        }
        ApolloGetter apolloGetter = new ApolloGetter();
        apolloGetter.crash_count = ((Integer) toggle.getExperiment().getParam("crash_count", 0)).intValue();
        apolloGetter.time_range = ((Integer) toggle.getExperiment().getParam("time_range", 0)).intValue();
        apolloGetter.valid_time = ((Integer) toggle.getExperiment().getParam("valid_time", 0)).intValue();
        apolloGetter.key = (String) toggle.getExperiment().getParam("key", "");
        apolloGetter.down_gmap_mode = ((Integer) toggle.getExperiment().getParam("down_gmap_mode", 0)).intValue();
        apolloGetter.down_gmap_vendor = (String) toggle.getExperiment().getParam("down_gmap_vendor", "");
        apolloGetter.down_dmap_mode = ((Integer) toggle.getExperiment().getParam("down_dmap_mode", 0)).intValue();
        apolloGetter.down_dmap_vendor = (String) toggle.getExperiment().getParam("down_dmap_vendor", "");
        return apolloGetter;
    }

    public String toString() {
        return "crash_count:" + this.crash_count + ",time_range:" + this.time_range + ",valid_time:" + this.valid_time + ",key:" + this.key + ",down_gmap_mode:" + this.down_gmap_mode + ",down_gmap_vendor:" + this.down_gmap_vendor + ",down_dmap_mode:" + this.down_dmap_mode + ",down_dmap_vendor:" + this.down_dmap_vendor;
    }
}
