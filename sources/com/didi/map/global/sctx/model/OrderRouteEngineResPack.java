package com.didi.map.global.sctx.model;

import android.text.TextUtils;
import com.didi.map.google.util.DLog;
import com.didi.map.google.util.JsonParseHelper;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;

public class OrderRouteEngineResPack {

    /* renamed from: a */
    private static final String f27643a = OrderRouteEngineResPack.class.getSimpleName();

    /* renamed from: b */
    private static final String f27644b = "&";

    /* renamed from: c */
    private static final String f27645c = "SuggestOpenJourney";

    /* renamed from: d */
    private static final String f27646d = "DriverSyncMsg";

    /* renamed from: e */
    private static final String f27647e = "ServerStage";

    /* renamed from: f */
    private static final String f27648f = "ChooseFSrctag";

    /* renamed from: g */
    private static final String f27649g = "ChooseTSrctag";
    public String chooseFSrctag;
    public String chooseTSrctag;
    public boolean lineVisible = true;
    public int mDistance = -1;
    public int mEta = -1;
    public int serverStage = -1;
    public boolean suggestOpenJourney;

    /* renamed from: a */
    private String m19837a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("=");
        if (indexOf <= -1 || indexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(indexOf + 1);
    }

    public void parseFrom(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
        if (mapPassengeOrderRouteRes == null || mapPassengeOrderRouteRes.routeEngineResPack == null) {
            reset();
            return;
        }
        String utf8 = mapPassengeOrderRouteRes.routeEngineResPack.utf8();
        if (TextUtils.isEmpty(utf8)) {
            reset();
            return;
        }
        String[] split = utf8.split("&");
        if (split != null && split.length != 0) {
            for (int i = 0; i < split.length; i++) {
                String a = m19837a(split[i]);
                if (!TextUtils.isEmpty(a)) {
                    if (split[i].contains(f27646d)) {
                        try {
                            Object parse = JsonParseHelper.parse(a, "line_visible", true);
                            if (parse instanceof Integer) {
                                this.lineVisible = ((Integer) parse).intValue() != 0;
                            } else if (parse instanceof String) {
                                this.lineVisible = Integer.valueOf((String) parse).intValue() != 0;
                            }
                        } catch (NumberFormatException unused) {
                            this.lineVisible = true;
                        }
                        String str = f27643a;
                        DLog.m19914d(str, "lineVisible:" + this.lineVisible, new Object[0]);
                        try {
                            Object parse2 = JsonParseHelper.parse(a, "eta", true);
                            if (parse2 instanceof Integer) {
                                this.mEta = ((Integer) parse2).intValue();
                            } else if (parse2 instanceof String) {
                                this.mEta = Integer.valueOf((String) parse2).intValue();
                            }
                        } catch (Exception unused2) {
                            this.mEta = -1;
                        }
                        String str2 = f27643a;
                        DLog.m19914d(str2, "eta:" + this.mEta, new Object[0]);
                        try {
                            Object parse3 = JsonParseHelper.parse(a, "distance", true);
                            if (parse3 instanceof Integer) {
                                this.mDistance = ((Integer) parse3).intValue();
                            } else if (parse3 instanceof String) {
                                this.mDistance = Integer.valueOf((String) parse3).intValue();
                            }
                        } catch (Exception unused3) {
                            this.mDistance = -1;
                        }
                        String str3 = f27643a;
                        DLog.m19914d(str3, "distance:" + this.mDistance, new Object[0]);
                    } else if (split[i].contains(f27645c)) {
                        try {
                            this.suggestOpenJourney = Boolean.parseBoolean(a);
                        } catch (NumberFormatException unused4) {
                            this.suggestOpenJourney = false;
                        }
                    } else if (split[i].contains(f27647e)) {
                        try {
                            this.serverStage = Integer.parseInt(a);
                        } catch (NumberFormatException unused5) {
                            this.serverStage = -1;
                        }
                    } else if (split[i].contains(f27648f)) {
                        this.chooseFSrctag = a;
                    } else if (split[i].contains(f27649g)) {
                        this.chooseTSrctag = a;
                    }
                }
            }
        }
    }

    public void reset() {
        this.serverStage = -1;
        this.lineVisible = true;
        this.suggestOpenJourney = false;
        this.chooseFSrctag = "";
        this.chooseTSrctag = "";
    }

    public String toString() {
        return "OrderRouteEngineResPack{serverStage=" + this.serverStage + ", lineVisible=" + this.lineVisible + ", suggestOpenJourney=" + this.suggestOpenJourney + '}';
    }
}
