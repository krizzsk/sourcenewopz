package com.didi.map.google.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.google.util.ApolloUtils;
import com.didi.map.sdk.nav.inertia.ApolloParamsSctxPrediction;
import com.didi.map.sdk.nav.inertia.MatchPointType;

public class PageCachedApolloValue {

    /* renamed from: a */
    private int f27794a;

    /* renamed from: b */
    private int f27795b;

    /* renamed from: c */
    private long f27796c;

    /* renamed from: d */
    private long f27797d;

    /* renamed from: e */
    private boolean f27798e;

    /* renamed from: f */
    private boolean f27799f;

    /* renamed from: g */
    private int f27800g;

    /* renamed from: h */
    private long f27801h;

    /* renamed from: i */
    private String f27802i;

    /* renamed from: j */
    private ApolloParamsSctxPrediction f27803j;

    public int getMaxMockDistance(MatchPointType matchPointType) {
        if (matchPointType == MatchPointType.WIFI || matchPointType == MatchPointType.MOBILE_STATION) {
            if (this.f27795b < 1) {
                this.f27795b = ApolloUtils.getMaxMockDistance(matchPointType);
            }
            return this.f27795b;
        }
        if (this.f27794a < 1) {
            this.f27794a = ApolloUtils.getMaxMockDistance(matchPointType);
        }
        return this.f27794a;
    }

    public long getMaxMockTime(MatchPointType matchPointType) {
        if (matchPointType == MatchPointType.WIFI || matchPointType == MatchPointType.MOBILE_STATION) {
            if (this.f27797d < 1) {
                this.f27797d = ApolloUtils.getMaxMockTime(matchPointType);
            }
            return this.f27797d;
        }
        if (this.f27796c < 1) {
            this.f27796c = ApolloUtils.getMaxMockTime(matchPointType);
        }
        return this.f27796c;
    }

    public boolean getSimulateMotionEnable() {
        if (this.f27799f) {
            return this.f27798e;
        }
        this.f27798e = ApolloUtils.isSimulateMotionOpened();
        DLog.m7384d("SimulateApollo", "is Simulate Motion Enable:" + this.f27798e, new Object[0]);
        this.f27799f = true;
        return this.f27798e;
    }

    public long getAllowETA() {
        if (this.f27801h < 1) {
            this.f27801h = ApolloUtils.getAllowETA();
        }
        return this.f27801h;
    }

    public int getAllowEDA() {
        if (this.f27800g < 1) {
            this.f27800g = ApolloUtils.getAllowEDA();
        }
        return this.f27800g;
    }

    public String getOraRequestUrl(Context context) {
        if (TextUtils.isEmpty(this.f27802i)) {
            this.f27802i = ApolloUtils.getOraRequestUrl(context);
        }
        return this.f27802i;
    }

    public ApolloParamsSctxPrediction getSctxPredictionParams() {
        if (this.f27803j == null) {
            this.f27803j = ApolloUtils.getSctxPredictionParams();
        }
        return this.f27803j;
    }

    public boolean getSctxPredictionEnable() {
        if (this.f27803j == null) {
            ApolloParamsSctxPrediction sctxPredictionParams = ApolloUtils.getSctxPredictionParams();
            this.f27803j = sctxPredictionParams;
            if (sctxPredictionParams == null) {
                return false;
            }
        }
        return this.f27803j.isPredictionEnabled();
    }
}
