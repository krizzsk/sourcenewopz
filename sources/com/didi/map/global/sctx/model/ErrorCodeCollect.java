package com.didi.map.global.sctx.model;

import android.text.TextUtils;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.HashMap;

public class ErrorCodeCollect {

    /* renamed from: a */
    private String f27637a;

    /* renamed from: b */
    private int f27638b = 0;

    /* renamed from: c */
    private int f27639c = 0;

    public interface SctxError {
        public static final int SCTXError_DriverAnno = 4;
        public static final int SCTXError_DriverLoc = 3;
        public static final int SCTXError_NoRoute = 5;
        public static final int SCTXError_Normal = 0;
        public static final int SCTXError_ReqFail = 1;
        public static final int SCTXError_Stage = 2;
        public static final int SCTXError_Unknow = 999;
    }

    public void setDriverError(int i) {
        this.f27638b = i;
    }

    public void setOraError(int i) {
        this.f27637a = String.valueOf(i);
    }

    public void setOraErrorStr(String str) {
        this.f27637a = str;
    }

    public void setRouteError(int i) {
        this.f27639c = i;
    }

    /* renamed from: a */
    private boolean m19833a() {
        return !TextUtils.isEmpty(this.f27637a);
    }

    public String getDriverError() {
        if (m19833a()) {
            return m19835c();
        }
        return m19834b() != 0 ? String.valueOf(m19834b()) : "";
    }

    /* renamed from: b */
    private int m19834b() {
        return this.f27638b;
    }

    /* renamed from: c */
    private String m19835c() {
        return this.f27637a;
    }

    public String getRouteError() {
        if (m19833a()) {
            return m19835c();
        }
        return m19836d() != 0 ? String.valueOf(m19836d()) : "";
    }

    /* renamed from: d */
    private int m19836d() {
        return this.f27639c;
    }

    public void reset() {
        this.f27638b = 0;
        this.f27637a = null;
        this.f27639c = 0;
    }

    public static void trackSctxShowError(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("driver_anno_error", str);
        hashMap.put("route_error", str2);
        hashMap.put("cur_version", str3);
        GlobalOmegaTracker.trackEvent("tech_global_sctx_error", hashMap);
    }
}
