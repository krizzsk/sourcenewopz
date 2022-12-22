package com.dmap.navigation.engine.p207a;

import android.content.Context;
import com.didi.hawaii.utils.Md5Util;
import com.didichuxing.omega.sdk.Omega;
import com.dmap.navigation.api.http.ISession;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.ctx.INaviOption;
import com.dmap.navigation.base.ctx.IOrderInfo;
import com.dmap.navigation.base.ctx.IUserInfo;
import com.dmap.navigation.jni.sub.NaviOptionNative;
import com.dmap.navigation.jni.sub.OrderInfoNative;
import com.dmap.navigation.jni.sub.UserInfoNative;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.dmap.navigation.engine.a.n */
/* compiled from: NaviContextImpl */
public final class C17401n implements ISession, INaviContext {

    /* renamed from: a */
    private final Context f51826a;

    /* renamed from: aL */
    public final UserInfoNative f51827aL = new UserInfoNative();

    /* renamed from: aM */
    public final OrderInfoNative f51828aM = new OrderInfoNative();

    /* renamed from: aN */
    public final NaviOptionNative f51829aN = new NaviOptionNative();

    /* renamed from: b */
    private final AtomicInteger f51830b = new AtomicInteger(0);

    /* renamed from: c */
    private String f51831c;

    /* renamed from: d */
    private String f51832d;

    public C17401n(Context context) {
        this.f51826a = context;
        String omegaId = Omega.getOmegaId();
        this.f51827aL.setDeviceId(omegaId == null ? "unknown" : omegaId);
        this.f51829aN.setNgFlag(4);
        this.f51829aN.setNgVersion(5001);
        this.f51829aN.setDiaUpgrade(C17399l.m37034c());
        this.f51829aN.setCameraDisplay(C17399l.m37037f() ? 1 : 0);
        this.f51829aN.setFbRoadName(C17399l.isOpenFbRoadName() ? 1 : 0);
        this.f51829aN.setFishbone(C17399l.m37035d());
        this.f51829aN.setMultiRouteEnable(C17399l.m37036e());
        this.f51829aN.setYawVersion(2);
        this.f51829aN.setVector(C17399l.m37038g() ? 1 : 0);
        this.f51829aN.setNeedTrafficEvent(C17399l.isTrafficEventOpen());
        this.f51829aN.setNeedmission(C17399l.m37033b());
        this.f51829aN.setNeedmjo(true);
        this.f51829aN.setNeedTraffic(true);
        this.f51829aN.setNoNeedRainbow(false);
    }

    public final Context getAndroidContext() {
        return this.f51826a;
    }

    /* renamed from: a */
    private static String m37042a(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 20);
        sb.append(str);
        String l = Long.toString(System.currentTimeMillis());
        int length = l.length();
        sb.append(l.substring(length - 10, length));
        sb.append((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E9d));
        return Md5Util.getMD5(sb.toString());
    }

    public final synchronized String getSessionId() {
        if (this.f51831c == null) {
            this.f51831c = m37042a(this.f51827aL.getImei());
        }
        return this.f51831c;
    }

    public final int getSeq() {
        return this.f51830b.incrementAndGet();
    }

    public final synchronized String getTripId() {
        if (this.f51832d == null) {
            this.f51832d = m37042a(this.f51827aL.getImei());
        }
        return this.f51832d;
    }

    public final /* bridge */ /* synthetic */ INaviOption getNaviOption() {
        return this.f51829aN;
    }

    public final /* bridge */ /* synthetic */ IOrderInfo getOrderInfo() {
        return this.f51828aM;
    }

    public final /* bridge */ /* synthetic */ IUserInfo getUserInfo() {
        return this.f51827aL;
    }
}
