package com.didi.map.sdk.nav.inertia;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloCache {

    /* renamed from: a */
    private static final String f28418a = "ApolloCache";

    /* renamed from: b */
    private int f28419b = 6;

    /* renamed from: c */
    private int f28420c = 20;

    /* renamed from: d */
    private int f28421d = 2;

    /* renamed from: e */
    private int f28422e = 150;

    /* renamed from: f */
    private int f28423f = 1;

    /* renamed from: g */
    private int f28424g = 4;

    /* renamed from: h */
    private int f28425h = 3;

    /* renamed from: i */
    private int f28426i = 2;

    /* renamed from: j */
    private int f28427j = 300;

    /* renamed from: k */
    private int f28428k = 4;

    /* renamed from: l */
    private boolean f28429l = false;

    /* renamed from: m */
    private IToggle f28430m;

    /* renamed from: n */
    private IExperiment f28431n;

    public ApolloCache() {
        IToggle toggle = Apollo.getToggle("global_inertia_simulate_param_toggle_all");
        this.f28430m = toggle;
        if (toggle != null && toggle.allow()) {
            this.f28431n = this.f28430m.getExperiment();
        }
        this.f28419b = m20121a("listsize", this.f28419b);
        this.f28420c = m20121a("maxspeed", this.f28420c);
        this.f28421d = m20121a("minspeed", this.f28421d);
        this.f28422e = m20121a("allow_dis", this.f28422e);
        this.f28423f = m20121a("standstill_speed", this.f28423f);
        this.f28424g = m20121a("coefficient", this.f28424g);
        this.f28425h = m20121a("failbinding_slowspeed", this.f28425h);
        this.f28426i = m20121a("catchspeed", this.f28426i);
        this.f28427j = m20121a("catch_dis", this.f28427j);
        this.f28428k = m20121a("netpoint_speed", this.f28428k);
        this.f28429l = isEvaluateEnabled();
        DLog.m7384d(f28418a, "listSize = %s ,maxSpeed= %s, minSpeed=%s, allow_dis=%s, standstill_speed=%s, coefficient=%s,failbinding_slowspeed=%s , catchspeed=%s, catch_dis=%s, netpoint_speed=%s, isEvaluate=%b", Integer.valueOf(this.f28419b), Integer.valueOf(this.f28420c), Integer.valueOf(this.f28421d), Integer.valueOf(this.f28422e), Integer.valueOf(this.f28423f), Integer.valueOf(this.f28424g), Integer.valueOf(this.f28425h), Integer.valueOf(this.f28426i), Integer.valueOf(this.f28427j), Integer.valueOf(this.f28428k), Boolean.valueOf(this.f28429l));
    }

    public int getListSize() {
        return this.f28419b;
    }

    public int getMaxSpeed() {
        return this.f28420c;
    }

    public int getMinSpeed() {
        return this.f28421d;
    }

    public int getAllow_dis() {
        return this.f28422e;
    }

    public int getStandstill_speed() {
        return this.f28423f;
    }

    public float getCoefficient() {
        return ((float) this.f28424g) * 0.1f;
    }

    public int getFailbinding_slowspeed() {
        return this.f28425h;
    }

    public int getCatchspeed() {
        return this.f28426i;
    }

    public int getCatch_dis() {
        return this.f28427j;
    }

    public int getNetpoint_speed() {
        return this.f28428k;
    }

    public boolean isEvaluate() {
        return this.f28429l;
    }

    public boolean isEvaluateEnabled() {
        IToggle toggle = Apollo.getToggle("global_sctx_mock_online_evaluate");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private int m20121a(String str, int i) {
        IExperiment iExperiment = this.f28431n;
        return iExperiment != null ? ((Integer) iExperiment.getParam(str, Integer.valueOf(i))).intValue() : i;
    }
}
