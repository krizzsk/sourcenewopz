package com.didi.map.global.flow.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.dimina.container.secondparty.trace.TraceActionServiceImpl;
import com.didi.map.global.flow.scene.vamos.sctx.driver.omega.VamosDriverSctxOmegaUtil;
import com.didi.map.global.flow.toolkit.nav.VamosNavModel;
import com.didi.map.global.flow.toolkit.nav.VamosNavSelectActivity;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VamosNavUtils {

    /* renamed from: a */
    private static final String f27276a = (VamosNavUtils.class.getSimpleName() + "||");

    /* renamed from: b */
    private static String f27277b = "";

    /* renamed from: c */
    private static String f27278c = "";

    /* renamed from: d */
    private static String f27279d = "";

    /* renamed from: e */
    private static Map<String, String> f27280e = new HashMap();

    /* renamed from: f */
    private static boolean f27281f = false;

    /* renamed from: g */
    private static double f27282g;

    /* renamed from: h */
    private static double f27283h;
    public static String sCurChoice = "";

    static {
        m19278a();
        m19282b();
    }

    public static void checkAndStartNavigation(Context context, double d, double d2) {
        if (context == null) {
            trackEventOpenNavAppFailed();
            return;
        }
        f27282g = d;
        f27283h = d2;
        if (!TextUtils.isEmpty(sCurChoice) && !m19281a(context, sCurChoice)) {
            sCurChoice = "";
        }
        if (TextUtils.isEmpty(sCurChoice)) {
            m19279a(context);
            return;
        }
        startNavDirectly(context);
        trackEventClickNavBtn(1);
    }

    /* renamed from: a */
    private static void m19279a(Context context) {
        Intent intent = new Intent(context, VamosNavSelectActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void startNavDirectly(Context context) {
        if (f27277b.equals(sCurChoice)) {
            m19280a(context, f27282g, f27283h);
        } else if (f27278c.equals(sCurChoice)) {
            m19283b(context, f27282g, f27283h);
        }
    }

    public static List<VamosNavModel> getCurNavAppList(Context context) {
        ArrayList arrayList = new ArrayList();
        Map<String, String> map = f27280e;
        if (map == null) {
            return arrayList;
        }
        if (map.containsKey(f27277b)) {
            String str = f27277b;
            arrayList.add(new VamosNavModel("Google Maps", str, m19281a(context, str)));
        }
        if (f27280e.containsKey(f27278c)) {
            String str2 = f27278c;
            arrayList.add(new VamosNavModel("Waze", str2, m19281a(context, str2)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m19281a(Context context, String str) {
        Intent intent;
        if (context.getPackageManager() == null) {
            return false;
        }
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e) {
            String str2 = f27276a;
            DLog.m7384d(str2, "PMS ex:" + e.getMessage(), new Object[0]);
            intent = null;
        }
        if (intent != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m19280a(Context context, double d, double d2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + d + "," + d2 + "&travelmode=driving&dir_action=navigate"));
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            trackEventOpenNavAppFailed();
            String str = f27276a;
            DLog.m7384d(str, "google nav failed:" + e.getMessage(), new Object[0]);
        }
    }

    /* renamed from: b */
    private static void m19283b(Context context, double d, double d2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("waze://?ll=" + d + "," + d2 + "&navigate=yes"));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            trackEventOpenNavAppFailed();
            String str = f27276a;
            DLog.m7384d(str, "waze nav failed:" + e.getMessage(), new Object[0]);
        }
    }

    public static void goToGooglePlay(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + str));
            intent.setPackage(f27279d);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            if (intent2.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent2);
            } else {
                DLog.m7384d(f27276a, "google play launch failed, no browser no store", new Object[0]);
            }
        } catch (Exception e) {
            String str2 = f27276a;
            DLog.m7384d(str2, "google play launch failed:" + e.getMessage(), new Object[0]);
        }
    }

    /* renamed from: a */
    private static void m19278a() {
        if (TextUtils.isEmpty(f27277b) || TextUtils.isEmpty(f27278c) || TextUtils.isEmpty(f27279d)) {
            IToggle toggle = Apollo.getToggle("global_map_nav_pkg_name");
            if (toggle.allow()) {
                String str = (String) toggle.getExperiment().getParam(TraceActionServiceImpl.PKG, "");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        f27277b = jSONObject.getString("pkgGoogleMap");
                        f27278c = jSONObject.getString("pkgWazeMap");
                        f27279d = jSONObject.getString("pkgPlayStore");
                    } catch (Exception e) {
                        DLog.m7384d(f27276a, e.toString(), new Object[0]);
                    }
                }
            }
            if (TextUtils.isEmpty(f27277b) || TextUtils.isEmpty(f27278c) || TextUtils.isEmpty(f27279d)) {
                f27277b = "com.google.android.apps.maps";
                f27278c = "com.waze";
                f27279d = "com.android.vending";
            }
        }
    }

    /* renamed from: b */
    private static void m19282b() {
        f27280e.put(f27277b, "1");
        f27280e.put(f27278c, "2");
        String navFilter = MapFlowApolloUtils.getNavFilter();
        if (!TextUtils.isEmpty(navFilter)) {
            try {
                JSONArray jSONArray = new JSONArray(navFilter);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("navi_type");
                        String a = m19277a(optString);
                        if (!f27281f && !"unknown".equals(a)) {
                            f27280e.clear();
                            f27281f = true;
                        }
                        f27280e.put(a, optString);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m19277a(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 49
            r2 = 1
            if (r0 == r1) goto L_0x0018
            r1 = 50
            if (r0 == r1) goto L_0x000e
            goto L_0x0022
        L_0x000e:
            java.lang.String r0 = "2"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0022
            r3 = 1
            goto L_0x0023
        L_0x0018:
            java.lang.String r0 = "1"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0022
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = -1
        L_0x0023:
            if (r3 == 0) goto L_0x002d
            if (r3 == r2) goto L_0x002a
            java.lang.String r3 = "unknown"
            return r3
        L_0x002a:
            java.lang.String r3 = f27278c
            return r3
        L_0x002d:
            java.lang.String r3 = f27277b
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.utils.VamosNavUtils.m19277a(java.lang.String):java.lang.String");
    }

    public static void trackEventOpenNavAppFailed() {
        VamosDriverSctxOmegaUtil.onOpenNavAppFail();
    }

    public static void trackEventClickNavBtn(int i) {
        int i2;
        if (f27277b.equals(sCurChoice)) {
            i2 = 1;
        } else {
            i2 = f27278c.equals(sCurChoice) ? 2 : -1;
        }
        VamosDriverSctxOmegaUtil.onNavBtnClick(i2, i);
    }

    public static void clearChoiceCache() {
        sCurChoice = "";
    }
}
