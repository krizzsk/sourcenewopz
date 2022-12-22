package com.didi.entrega.customer.foundation.tracker.performance;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import java.util.concurrent.atomic.AtomicInteger;

public class ConversionOmegaHelper {

    /* renamed from: a */
    private static Long f20054a = 0L;

    /* renamed from: b */
    private static String f20055b = "0";

    /* renamed from: c */
    private static long f20056c = 0;

    /* renamed from: d */
    private static AtomicInteger f20057d = new AtomicInteger(0);

    /* renamed from: e */
    private static long f20058e = 0;

    public static String getLifeId() {
        if (f20054a.longValue() == 0) {
            f20054a = Long.valueOf(System.currentTimeMillis());
        }
        return String.valueOf(f20054a);
    }

    public static String getDuration() {
        return String.valueOf(System.currentTimeMillis() - f20054a.longValue());
    }

    public static String getSession() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f20056c < currentTimeMillis) {
            f20055b = String.valueOf(currentTimeMillis);
            f20056c = currentTimeMillis + 1800000;
        }
        return f20055b;
    }

    public static String getTrackIntervalTime() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f20058e == 0) {
            f20058e = currentTimeMillis;
        }
        f20058e = currentTimeMillis;
        return String.valueOf(currentTimeMillis - f20058e);
    }

    public static String getSequenceId() {
        int incrementAndGet = f20057d.incrementAndGet();
        if (Integer.MAX_VALUE - incrementAndGet < 100) {
            f20057d.set(0);
        }
        return String.valueOf(incrementAndGet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r0.f61861router.getBackstack();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m14809a() {
        /*
            com.didi.app.nova.skeleton.PageInstrument r0 = com.didi.entrega.customer.app.GlobalContext.getPageInstrument()
            boolean r1 = r0 instanceof com.didi.app.nova.skeleton.internal.page.PageInstrumentImpl
            if (r1 == 0) goto L_0x0027
            com.didi.app.nova.skeleton.internal.page.PageInstrumentImpl r0 = (com.didi.app.nova.skeleton.internal.page.PageInstrumentImpl) r0
            com.didi.app.nova.skeleton.conductor.Router r1 = r0.f61861router
            if (r1 == 0) goto L_0x0027
            com.didi.app.nova.skeleton.conductor.Router r0 = r0.f61861router
            java.util.List r0 = r0.getBackstack()
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x0027
            int r1 = r1 + -1
            java.lang.Object r0 = r0.get(r1)
            com.didi.app.nova.skeleton.conductor.RouterTransaction r0 = (com.didi.app.nova.skeleton.conductor.RouterTransaction) r0
            java.lang.String r0 = r0.pageName()
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.tracker.performance.ConversionOmegaHelper.m14809a():java.lang.String");
    }

    public static void trackLocaleEmb(String str, String str2, String str3, String str4, String str5) {
        OmegaTracker.Builder.create(EventConst.Conversion.LOCALE_EMB).addEventParam("ibt_locale", str).addEventParam("ibt_lang", str2).addEventParam("phone_locale", str3).addEventParam("r_lang", str4).addEventParam("r_locale", str5).build().track();
    }
}
