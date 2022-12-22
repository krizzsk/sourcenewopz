package com.didi.component.config;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PageConfig {

    /* renamed from: d */
    static final int f12600d = Integer.MAX_VALUE;

    /* renamed from: e */
    private static List<PageIdConverter> f12601e = null;

    /* renamed from: f */
    private static final String f12602f = "global";

    /* renamed from: g */
    private static final String f12603g = "none";

    /* renamed from: h */
    private static final String f12604h = "home";

    /* renamed from: i */
    private static final String f12605i = "wait";

    /* renamed from: j */
    private static final String f12606j = "inservice";

    /* renamed from: k */
    private static final String f12607k = "endservice";

    /* renamed from: l */
    private static final String f12608l = "cancel";

    /* renamed from: m */
    private static final String f12609m = "confirm";

    /* renamed from: n */
    private static final String f12610n = "bookingresult";

    /* renamed from: o */
    private static final String f12611o = "updatepickup";

    /* renamed from: p */
    private static final String f12612p = "trip";

    /* renamed from: q */
    private static final String f12613q = "lockscreen";

    /* renamed from: a */
    int f12614a;

    /* renamed from: b */
    String f12615b;

    /* renamed from: c */
    final Map<String, ComponentConfig> f12616c = new LinkedHashMap();

    public interface PageIdConverter {
        int pageNameToId(String str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo47937a() {
        return this.f12614a > 0 && !TextUtils.isEmpty(this.f12615b) && this.f12616c.size() > 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("pageId:");
        sb.append(this.f12614a);
        sb.append(", ");
        sb.append("pageName:");
        sb.append(this.f12615b);
        for (Map.Entry<String, ComponentConfig> value : this.f12616c.entrySet()) {
            sb.append("\n");
            sb.append(value.getValue());
        }
        sb.append("\n}");
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r0 <= 0) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[LOOP:0: B:12:0x0026->B:15:0x0036, LOOP_START, PHI: r0 
      PHI: (r0v7 int) = (r0v2 int), (r0v11 int) binds: [B:11:0x0020, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.didi.component.config.PageConfig m8588a(java.lang.String r5, org.json.JSONArray r6) throws org.json.JSONException {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x006e
            if (r6 == 0) goto L_0x006e
            int r0 = r6.length()
            if (r0 != 0) goto L_0x0010
            goto L_0x006e
        L_0x0010:
            int r0 = m8587a(r5)
            if (r0 > 0) goto L_0x003b
            java.util.List<com.didi.component.config.PageConfig$PageIdConverter> r2 = f12601e
            if (r2 == 0) goto L_0x003a
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x003a
            java.util.List<com.didi.component.config.PageConfig$PageIdConverter> r2 = f12601e
            java.util.Iterator r2 = r2.iterator()
        L_0x0026:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0038
            java.lang.Object r0 = r2.next()
            com.didi.component.config.PageConfig$PageIdConverter r0 = (com.didi.component.config.PageConfig.PageIdConverter) r0
            int r0 = r0.pageNameToId(r5)
            if (r0 <= 0) goto L_0x0026
        L_0x0038:
            if (r0 > 0) goto L_0x003b
        L_0x003a:
            return r1
        L_0x003b:
            com.didi.component.config.PageConfig r2 = new com.didi.component.config.PageConfig
            r2.<init>()
            r2.f12614a = r0
            r2.f12615b = r5
            r5 = 0
        L_0x0045:
            int r0 = r6.length()
            if (r5 >= r0) goto L_0x0067
            org.json.JSONObject r0 = r6.getJSONObject(r5)
            com.didi.component.config.ComponentConfig r0 = com.didi.component.config.ComponentConfig.m8567a(r0)
            if (r0 == 0) goto L_0x0064
            boolean r3 = r0.valid()
            if (r3 == 0) goto L_0x0064
            java.util.Map<java.lang.String, com.didi.component.config.ComponentConfig> r3 = r2.f12616c
            java.lang.String r4 = r0.type()
            r3.put(r4, r0)
        L_0x0064:
            int r5 = r5 + 1
            goto L_0x0045
        L_0x0067:
            boolean r5 = r2.mo47937a()
            if (r5 == 0) goto L_0x006e
            r1 = r2
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.config.PageConfig.m8588a(java.lang.String, org.json.JSONArray):com.didi.component.config.PageConfig");
    }

    /* renamed from: a */
    private static int m8587a(String str) {
        if (TextUtils.equals(str, "global")) {
            return Integer.MAX_VALUE;
        }
        if (TextUtils.equals(str, "none")) {
            return 900;
        }
        if (TextUtils.equals(str, "home")) {
            return 1001;
        }
        if (TextUtils.equals(str, "wait")) {
            return 1005;
        }
        if (TextUtils.equals(str, f12606j)) {
            return 1010;
        }
        if (TextUtils.equals(str, f12607k)) {
            return 1015;
        }
        if (TextUtils.equals(str, "cancel")) {
            return 1020;
        }
        if (TextUtils.equals(str, "confirm")) {
            return 1030;
        }
        if (TextUtils.equals(str, f12610n)) {
            return 1025;
        }
        if (TextUtils.equals(str, f12611o)) {
            return 1035;
        }
        if (TextUtils.equals(str, "trip")) {
            return 1040;
        }
        return TextUtils.equals(str, f12613q) ? 1045 : -1;
    }

    public static void addExtraPageIdList(PageIdConverter pageIdConverter) {
        if (f12601e == null) {
            f12601e = new ArrayList();
        }
        f12601e.add(pageIdConverter);
    }
}
