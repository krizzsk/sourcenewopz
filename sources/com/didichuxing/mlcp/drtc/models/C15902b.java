package com.didichuxing.mlcp.drtc.models;

import com.didichuxing.mlcp.drtc.enums.DrtcEnvType;
import com.didichuxing.mlcp.drtc.utils.ApiServer;

/* renamed from: com.didichuxing.mlcp.drtc.models.b */
/* compiled from: DrtcSDKConfig */
public class C15902b {

    /* renamed from: a */
    public int f48334a;

    /* renamed from: b */
    public String f48335b;

    /* renamed from: c */
    public String f48336c;

    /* renamed from: d */
    public String f48337d;

    /* renamed from: e */
    public String f48338e;

    /* renamed from: f */
    public String f48339f;

    /* renamed from: g */
    public String f48340g;

    /* renamed from: h */
    public DrtcEnvType f48341h;

    /* renamed from: i */
    private SessionConnInfo f48342i;

    /* renamed from: j */
    private String f48343j;

    public C15902b() {
        mo118990a(DrtcEnvType.ENV_GLOBAL);
    }

    /* renamed from: a */
    public C15902b mo118990a(DrtcEnvType drtcEnvType) {
        if (drtcEnvType.equals(DrtcEnvType.ENV_GLOBAL)) {
            this.f48335b = m34560a("drtc-api.didiglobal.com");
            this.f48338e = "43.135.216.69";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_PROD_US)) {
            this.f48335b = m34560a("drtc-api.didiglobal.com");
            this.f48338e = "43.135.216.69";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_TEST_CN)) {
            this.f48335b = m34560a("drtc-api.didiglobal.com");
            this.f48338e = "43.135.216.69";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_TEST_US)) {
            this.f48335b = m34560a("43.130.116.113:8188");
            this.f48338e = "43.130.119.78";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_TEST_BR)) {
            this.f48335b = m34560a("43.135.216.69:8188");
            this.f48338e = "43.130.119.78";
        }
        this.f48334a = 1234;
        this.f48337d = "janus-protocol";
        this.f48336c = "janus";
        this.f48339f = "itsolar";
        this.f48340g = "didichuxing01";
        this.f48341h = drtcEnvType;
        return this;
    }

    public C15902b(String str) {
        this.f48343j = str;
        this.f48342i = null;
        this.f48341h = DrtcEnvType.ENV_CUSTOM;
    }

    /* renamed from: a */
    public boolean mo118991a(int i) {
        this.f48334a = i;
        if (this.f48341h == DrtcEnvType.ENV_CUSTOM) {
            return m34561a();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m34561a() {
        SessionConnInfo sessionConnInfo = ApiServer.getInstance().getSessionConnInfo(this.f48343j, String.valueOf(this.f48334a));
        this.f48342i = sessionConnInfo;
        if (sessionConnInfo == null) {
            return false;
        }
        if (sessionConnInfo.mo118972a() == null) {
            this.f48335b = "drtc-api.didiglobal.com";
        } else {
            this.f48335b = "wss://" + this.f48342i.mo118972a() + "/" + "janus";
        }
        this.f48336c = "janus";
        this.f48337d = "janus-protocol";
        this.f48338e = this.f48342i.mo118974c();
        this.f48339f = this.f48342i.mo118975d();
        this.f48340g = this.f48342i.mo118973b();
        return true;
    }

    /* renamed from: a */
    private String m34560a(String str) {
        return String.format("wss://%s/janus", new Object[]{str});
    }
}
