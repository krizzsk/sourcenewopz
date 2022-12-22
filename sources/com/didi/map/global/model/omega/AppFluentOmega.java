package com.didi.map.global.model.omega;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import didihttpdns.toolbox.AppUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

public class AppFluentOmega {

    /* renamed from: f */
    private static AppFluentOmega f27340f;

    /* renamed from: a */
    private Map<Integer, Integer> f27341a = new HashMap();

    /* renamed from: b */
    private Map<Integer, Long> f27342b = new HashMap();

    /* renamed from: c */
    private String f27343c = "map_pax_loading_sw";

    /* renamed from: d */
    private String f27344d = "global_passenger_map_app_loadingTime";

    /* renamed from: e */
    private String f27345e = "AppFluentOmegaUtil";

    @Retention(RetentionPolicy.CLASS)
    public @interface PageType {
        public static final int TYPE_BUBBLE_LINE = 6;
        public static final int TYPE_CAR_SLIDING = 1;
        public static final int TYPE_CONFIRM_PIN = 8;
        public static final int TYPE_MAIN_PAGE_LOC = 3;
        public static final int TYPE_MAP_LOADING = 2;
        public static final int TYPE_SUG_REC_LIST = 5;
        public static final int TYPE_SUG_START_FILL = 4;
        public static final int TYPE_TRIP_ORA_RESULT = 7;
    }

    /* renamed from: a */
    private void m19310a(String str) {
    }

    public static AppFluentOmega getInstance() {
        if (f27340f == null) {
            f27340f = new AppFluentOmega();
        }
        return f27340f;
    }

    private AppFluentOmega() {
    }

    public void startCalculateTime(int... iArr) {
        if (this.f27342b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (iArr != null) {
                for (int valueOf : iArr) {
                    this.f27342b.put(Integer.valueOf(valueOf), Long.valueOf(currentTimeMillis));
                    m19310a("startCalculateTime  type=" + iArr + "--> " + currentTimeMillis);
                }
            }
        }
    }

    public void stopCalculateTime(Context context, com.didi.common.map.Map map, int i, HashMap<String, Object> hashMap) {
        Map<Integer, Long> map2 = this.f27342b;
        if (map2 == null || map2.containsKey(Integer.valueOf(i))) {
            m19309a(context, map, i, hashMap);
        }
    }

    public void removeOmega(int... iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                Map<Integer, Integer> map = this.f27341a;
                if (map != null) {
                    map.remove(Integer.valueOf(i));
                }
                Map<Integer, Long> map2 = this.f27342b;
                if (map2 != null) {
                    map2.remove(Integer.valueOf(i));
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m19311a(int i) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(this.f27344d);
        if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
            String str = (String) experiment.getParam("enable", "");
            if (!TextUtils.isEmpty(str) && str.contains(",")) {
                m19310a("enableContent--->" + str);
                String[] split = str.split(",");
                if (!CollectionUtil.isEmpty((Object[]) split)) {
                    for (String str2 : split) {
                        m19310a("singleEnable--->" + str2);
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.contains(",")) {
                                str2 = str2.replaceAll(",", "");
                            }
                            m19310a("enable_match--->type" + i + "var" + str2);
                            if (str2.equals(i + "")) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m19309a(Context context, com.didi.common.map.Map map, int i, HashMap<String, Object> hashMap) {
        Map<Integer, Integer> map2 = this.f27341a;
        if (map2 == null) {
            return;
        }
        if ((map2.get(Integer.valueOf(i)) == null || this.f27341a.get(Integer.valueOf(i)).intValue() <= 0) && m19311a(i)) {
            int i2 = 1;
            this.f27341a.put(Integer.valueOf(i), 1);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            hashMap2.put("product_id", PaxEnvironment.getInstance().getProductId());
            hashMap2.put("passenger_id", PaxEnvironment.getInstance().getUid());
            hashMap2.put("page", PaxEnvironment.getInstance().getPage().toString());
            hashMap2.put("entrance", PaxEnvironment.getInstance().getEntrance().toString());
            hashMap2.put("country_code", PaxEnvironment.getInstance().getCountryCode());
            hashMap2.put("os_type", "android");
            hashMap2.put("app_version", AppUtils.getVersionName(context));
            if (map != null) {
                int i3 = C97731.$SwitchMap$com$didi$common$map$MapVendor[map.getMapVendor().ordinal()];
                if (i3 != 1) {
                    i2 = i3 != 2 ? 0 : 2;
                }
                hashMap2.put("map_type", Integer.valueOf(i2));
            }
            Map<Integer, Long> map3 = this.f27342b;
            if (map3 != null && map3.containsKey(Integer.valueOf(i))) {
                Long l = this.f27342b.get(Integer.valueOf(i));
                if (l.longValue() > 0) {
                    hashMap2.put("loading_time", Double.valueOf(((double) (System.currentTimeMillis() - l.longValue())) / 1000.0d));
                }
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                hashMap2.putAll(hashMap);
            }
            hashMap2.put("type", Integer.valueOf(i));
            m19310a("startCalculateTime  type=" + i + "param--> " + hashMap2.toString());
            OmegaSDKAdapter.trackEvent(this.f27343c, (Map<String, Object>) hashMap2);
        }
    }

    /* renamed from: com.didi.map.global.model.omega.AppFluentOmega$1 */
    static /* synthetic */ class C97731 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.common.map.MapVendor[] r0 = com.didi.common.map.MapVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$MapVendor = r0
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.DIDI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.HUAWEI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.model.omega.AppFluentOmega.C97731.<clinit>():void");
        }
    }
}
