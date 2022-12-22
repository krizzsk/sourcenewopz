package com.didi.map.sdk.sharetrack.google.inner.handler;

import com.didi.common.map.util.DLog;
import com.didi.map.sdk.sharetrack.google.inner.apollo.PushEdaApollo;

public class PushEdaHandler {

    /* renamed from: a */
    private static final String f28817a = "PushEdaHandler";

    /* renamed from: b */
    private boolean f28818b = false;

    /* renamed from: c */
    private boolean f28819c = false;

    /* renamed from: d */
    private PushEdaApollo f28820d;

    public PushEdaHandler() {
        PushEdaApollo pushEdaApollo = new PushEdaApollo();
        this.f28820d = pushEdaApollo;
        pushEdaApollo.init();
    }

    public boolean dispatchEvent(int i) {
        int i2;
        if (this.f28819c && this.f28818b) {
            return false;
        }
        PushEdaApollo pushEdaApollo = this.f28820d;
        int i3 = -1;
        if (pushEdaApollo != null) {
            i3 = pushEdaApollo.getShortEda();
            i2 = this.f28820d.getLongEda();
        } else {
            i2 = -1;
        }
        DLog.m7384d(f28817a, "当前eda=%d ,edaShort=%d ,edaLong=%d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2));
        if (i <= i2 && !this.f28819c) {
            this.f28819c = true;
            DLog.m7384d(f28817a, "eda长距离条件触发 当前eda %d 触发阈值 %d", Integer.valueOf(i), Integer.valueOf(i2));
            return true;
        } else if (i > i3 || this.f28818b) {
            return false;
        } else {
            this.f28818b = true;
            DLog.m7384d(f28817a, "eda短距离条件触发 当前eda %d 触发阈值 %d", Integer.valueOf(i), Integer.valueOf(i3));
            return true;
        }
    }
}
