package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilterHelper */
public class AccTimeFilterHelper {

    /* renamed from: j */
    private static final String f45961j = "AccTimeFilterHelper ";

    /* renamed from: a */
    float f45962a;

    /* renamed from: b */
    float f45963b;

    /* renamed from: c */
    float f45964c;

    /* renamed from: d */
    float f45965d;

    /* renamed from: e */
    float f45966e;

    /* renamed from: f */
    float f45967f;

    /* renamed from: g */
    float f45968g;

    /* renamed from: h */
    int f45969h;

    /* renamed from: i */
    int f45970i;

    /* renamed from: k */
    private int f45971k;
    public boolean shouldUseAccTimeFilter;
    public boolean shouldUseAccTimeFilterAB;

    public void setCurrentSatelliteNum(int i) {
        DLog.m32737d("AccTimeFilterHelper update satelliteNum: " + i);
        this.f45971k = i;
    }

    public boolean isFewSatellite() {
        return this.f45971k < this.f45969h;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilterHelper$Holder */
    private static class Holder {
        static AccTimeFilterHelper instance = new AccTimeFilterHelper();

        private Holder() {
        }
    }

    public static AccTimeFilterHelper getInstance() {
        return Holder.instance;
    }

    private AccTimeFilterHelper() {
        this.f45971k = 100;
        boolean z = false;
        this.shouldUseAccTimeFilter = false;
        this.shouldUseAccTimeFilterAB = false;
        Float valueOf = Float.valueOf(1.0f);
        this.f45962a = 1.0f;
        this.f45963b = 1.0f;
        Float valueOf2 = Float.valueOf(0.5f);
        this.f45964c = 0.5f;
        this.f45965d = 0.3f;
        this.f45966e = 0.5f;
        this.f45967f = 0.5f;
        this.f45968g = 0.3f;
        this.f45969h = 2;
        this.f45970i = 0;
        IToggle toggle = Apollo.getToggle("map_loc_acc_time_strategy_toggle");
        if (toggle == null || !toggle.allow()) {
            this.shouldUseAccTimeFilter = false;
            DLog.m32737d("AccTimeFilterHelper map_loc_acc_time_strategy_toggle not allow");
        } else if (toggle.getExperiment() != null) {
            this.shouldUseAccTimeFilter = true;
            this.f45962a = ((Float) toggle.getExperiment().getParam("score_init_flp", valueOf)).floatValue();
            this.f45963b = ((Float) toggle.getExperiment().getParam("score_init_gps", valueOf)).floatValue();
            this.f45964c = ((Float) toggle.getExperiment().getParam("score_init_nlp", valueOf2)).floatValue();
            this.f45965d = ((Float) toggle.getExperiment().getParam("score_init_last_gps", Float.valueOf(0.3f))).floatValue();
            this.f45966e = ((Float) toggle.getExperiment().getParam("weight_acc", valueOf2)).floatValue();
            this.f45967f = ((Float) toggle.getExperiment().getParam("weight_time", valueOf2)).floatValue();
            this.f45968g = ((Float) toggle.getExperiment().getParam("score_delta_gps", Float.valueOf(0.2f))).floatValue();
            this.f45969h = ((Integer) toggle.getExperiment().getParam("adjust_satellite_num", 2)).intValue();
            this.f45970i = ((Integer) toggle.getExperiment().getParam("should_track", 1)).intValue();
            DLog.m32737d("AccTimeFilterHelper map_loc_acc_time_strategy_toggle allow and param: " + getInfo());
        } else {
            DLog.m32737d("AccTimeFilterHelper map_loc_acc_time_strategy_toggle allow but with error");
        }
        IToggle toggle2 = Apollo.getToggle("global_map_loc_benefit_AB");
        if (toggle2 == null || !toggle2.allow()) {
            this.shouldUseAccTimeFilterAB = false;
            DLog.m32737d("AccTimeFilterHelper global_map_loc_benefit_AB not allow");
        } else if (toggle2.getExperiment() != null) {
            z = ((Integer) toggle2.getExperiment().getParam("enable", 0)).intValue() == 1 ? true : z;
            this.shouldUseAccTimeFilterAB = z;
            if (z) {
                DLog.m32737d("AccTimeFilterHelper global_map_loc_benefit_AB exp allow");
            } else {
                DLog.m32737d("AccTimeFilterHelper global_map_loc_benefit_AB exp not allow");
            }
        } else {
            DLog.m32737d("AccTimeFilterHelper global_map_loc_benefit_AB allow but null exp");
        }
    }

    public boolean shouldUseThisFilter() {
        return this.shouldUseAccTimeFilter && this.shouldUseAccTimeFilterAB;
    }

    public boolean shouldTrack() {
        return this.f45970i == 1;
    }

    public String getInfo() {
        return "AccTimeFilterHelper{score_init_flp=" + this.f45962a + ", score_init_gps=" + this.f45963b + ", score_init_nlp=" + this.f45964c + ", score_init_last_gps=" + this.f45965d + ", weight_acc=" + this.f45966e + ", weight_time=" + this.f45967f + ", score_delta_gps=" + this.f45968g + ", adjust_satellite_num=" + this.f45969h + ", should_track=" + this.f45970i + '}';
    }
}
