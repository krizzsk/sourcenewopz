package com.didi.soda.customer.foundation.tracker.performance;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class ConversionOmegaHelper {

    /* renamed from: a */
    private static boolean f41108a = true;

    /* renamed from: b */
    private static Long f41109b = 0L;

    /* renamed from: c */
    private static String f41110c = "0";

    /* renamed from: d */
    private static long f41111d = 0;

    /* renamed from: e */
    private static AtomicInteger f41112e = new AtomicInteger(0);

    /* renamed from: f */
    private static long f41113f = 0;

    public static String getLifeId() {
        if (f41109b.longValue() == 0) {
            f41109b = Long.valueOf(System.currentTimeMillis());
        }
        return String.valueOf(f41109b);
    }

    public static String getDuration() {
        return String.valueOf(System.currentTimeMillis() - f41109b.longValue());
    }

    public static String getSession() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f41111d < currentTimeMillis) {
            f41110c = String.valueOf(currentTimeMillis);
            f41111d = currentTimeMillis + 1800000;
        }
        return f41110c;
    }

    public static String getTrackIntervalTime() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f41113f == 0) {
            f41113f = currentTimeMillis;
        }
        f41113f = currentTimeMillis;
        return String.valueOf(currentTimeMillis - f41113f);
    }

    public static String getSequenceId() {
        int incrementAndGet = f41112e.incrementAndGet();
        if (Integer.MAX_VALUE - incrementAndGet < 100) {
            f41112e.set(0);
        }
        return String.valueOf(incrementAndGet);
    }

    public static void trackLocation(LatLng latLng) {
        double d;
        double d2;
        if (f41108a) {
            boolean z = false;
            f41108a = false;
            if (latLng != null) {
                d2 = latLng.latitude;
                d = latLng.longitude;
            } else {
                d2 = 0.0d;
                d = 0.0d;
            }
            if (!(d2 == 0.0d || d == 0.0d)) {
                z = true;
            }
            m29180a(d2, d);
            m29182a(z);
        }
    }

    public static void trackAppStart() {
        if (!GlobalContext.isEmbed()) {
            OmegaTracker.Builder.create(EventConst.Conversion.START_APP).build().track();
        }
    }

    public static void trackAppEnter(String str, boolean z, String str2) {
        trackAppEnter(str, z, str2, (String) null, (String) null);
    }

    public static void trackAppEnter(String str, boolean z, String str2, String str3, String str4) {
        if (!GlobalContext.isEmbed()) {
            if (z) {
                OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Conversion.ENTER_APP);
                if (!TextUtils.isEmpty(str)) {
                    create.addEventParam("url", str);
                }
                m29181a(create);
                create.addEventParam(ParamConst.PARAM_PERFORMANCE_APM_ENABLED, Boolean.valueOf(FallbackController.getFallbackInfo().isOpen));
                create.addEventParam("from", str2).build().track();
            }
            if (!TextUtils.equals(str2, "3")) {
                OmegaTracker.Builder create2 = OmegaTracker.Builder.create(EventConst.Conversion.ENTER_APP_WITH_URL);
                create2.addEventParam("campaign", str3);
                create2.addEventParam("deferredlink_data", str4);
                if (!TextUtils.isEmpty(str)) {
                    create2.addEventParam("from", str2).addEventParam("url", str).build().track();
                } else {
                    create2.addEventParam("from", str2).addEventParam("url", "").build().track();
                }
            }
        }
    }

    /* renamed from: a */
    private static void m29181a(OmegaTracker.Builder builder) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        } else {
            locale = Resources.getSystem().getConfiguration().locale;
        }
        if (locale == null) {
            RecordTracker.Builder.create().setTag(m29179a()).setLogModule("m-home|").setMessage("上报系统语言：locale == null").setLogCategory("c-data|").build().info();
            return;
        }
        builder.addEventParam("system_language", locale.getLanguage() + "_" + locale.getCountry());
    }

    public static void trackWithPageName(String str, String str2, boolean z) {
        if (!z || !GlobalContext.isEmbed()) {
            String a = m29179a();
            OmegaTracker.Builder create = OmegaTracker.Builder.create(str);
            if (!TextUtils.isEmpty(a)) {
                create.addEventParam("page", a);
            }
            if (!TextUtils.isEmpty(str2)) {
                create.addEventParam("channel", str2);
            }
            create.build().track();
        }
    }

    public static void track(String str) {
        if (!GlobalContext.isEmbed()) {
            OmegaTracker.Builder.create(str).build().track();
        }
    }

    public static void trackStartLoc() {
        if (!GlobalContext.isEmbed()) {
            OmegaTracker.Builder.create(EventConst.Conversion.START_LOC).build().track();
        }
    }

    /* renamed from: a */
    private static void m29180a(double d, double d2) {
        if (!GlobalContext.isEmbed()) {
            OmegaTracker.Builder.create(EventConst.Conversion.END_LOC).addEventParam("lat", Double.valueOf(d)).addEventParam("lng", Double.valueOf(d2)).build().track();
        }
    }

    public static void trackCheckPermission(int i, int i2) {
        OmegaTracker.Builder.create(EventConst.Conversion.CHECK_APP_PERMISSION).addEventParam(ParamConst.PARAM_HAS_LOCATION_PERMISSION, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_HAS_PHONE_STATE_PERMISSION, Integer.valueOf(i2)).build().track();
    }

    /* renamed from: a */
    private static void m29182a(boolean z) {
        OmegaTracker.Builder.create(EventConst.Conversion.START_GET_POSITION).addEventParam(ParamConst.PARAM_HAS_LOCATION_PERMISSION, Integer.valueOf(z ? 1 : 0)).build().track();
    }

    public static void trackTabIn(Bundle bundle) {
        String str;
        String channel = getChannel();
        String str2 = "";
        if (bundle != null) {
            str2 = bundle.getString("action_type");
            str = bundle.getString("from_tab");
        } else {
            str = str2;
        }
        OmegaTracker.Builder.create(EventConst.Conversion.TAB_IN_CK).addEventParam("page", str2).addEventParam("channel", channel).addEventParam("from", str).build().track();
    }

    public static void trackTabOut() {
        String a = m29179a();
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Conversion.TAB_OUT_CK);
        if (!TextUtils.isEmpty(a)) {
            create.addEventParam("page", a);
        }
        create.build().track();
    }

    public static void trackTabInByUrl(Uri uri) {
        OmegaTracker.Builder.create(EventConst.Conversion.TAB_IN_BY_URL).addEventParam("url", uri != null ? uri.toString() : "").addEventParam("page", "link").addEventParam("channel", getChannel()).build().track();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r0.f61861router.getBackstack();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m29179a() {
        /*
            com.didi.app.nova.skeleton.PageInstrument r0 = com.didi.soda.customer.app.GlobalContext.getPageInstrument()
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper.m29179a():java.lang.String");
    }

    public static String getChannel() {
        if (GlobalContext.isEmbed()) {
            return GlobalContext.isSuperApp() ? "superApp" : "ride";
        }
        return "";
    }

    public static void trackLocaleEmb(String str, String str2, String str3, String str4, String str5) {
        OmegaTracker.Builder.create(EventConst.Conversion.LOCALE_EMB).addEventParam("ibt_locale", str).addEventParam("ibt_lang", str2).addEventParam("phone_locale", str3).addEventParam("r_lang", str4).addEventParam("r_locale", str5).build().track();
    }
}
