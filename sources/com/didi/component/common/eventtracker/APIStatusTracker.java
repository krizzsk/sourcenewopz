package com.didi.component.common.eventtracker;

public class APIStatusTracker {

    /* renamed from: a */
    private static APIStatusTracker f11598a = new APIStatusTracker();

    public static APIStatusTracker getInstance() {
        return f11598a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (r7.equals(r9) != false) goto L_0x0063;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[SYNTHETIC, Splitter:B:20:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackWhen101(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r4 = this;
            java.lang.String r0 = "try_recheck_token_validate"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "url"
            r1.put(r2, r5)     // Catch:{ Exception -> 0x008d }
            java.lang.String r5 = "rid"
            r1.put(r5, r6)     // Catch:{ Exception -> 0x008d }
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x008d }
            if (r5 != 0) goto L_0x001d
            java.lang.String r5 = "UTF-8"
            java.lang.String r8 = java.net.URLDecoder.decode(r8, r5)     // Catch:{ Exception -> 0x008d }
        L_0x001d:
            java.lang.String r5 = "tokenFromSDK"
            r1.put(r5, r7)     // Catch:{ Exception -> 0x008d }
            java.lang.String r5 = "tokenFromUrl"
            r1.put(r5, r8)     // Catch:{ Exception -> 0x008d }
            java.lang.String r5 = "tokenFromBody"
            r1.put(r5, r9)     // Catch:{ Exception -> 0x008d }
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x008d }
            r6 = 1
            r2 = 0
            java.lang.String r3 = "input_token_not_same"
            if (r5 != 0) goto L_0x004a
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x008d }
            if (r5 != 0) goto L_0x004a
            boolean r5 = r8.equals(r9)     // Catch:{ Exception -> 0x008d }
            if (r5 != 0) goto L_0x004a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008d }
            r1.put(r3, r5)     // Catch:{ Exception -> 0x008d }
            goto L_0x0051
        L_0x004a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x008d }
            r1.put(r3, r5)     // Catch:{ Exception -> 0x008d }
        L_0x0051:
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x008d }
            if (r5 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r9 = r8
        L_0x0059:
            java.lang.String r5 = "token_not_same"
            if (r7 == 0) goto L_0x0063
            boolean r8 = r7.equals(r9)     // Catch:{ Exception -> 0x008d }
            if (r8 == 0) goto L_0x006b
        L_0x0063:
            if (r9 == 0) goto L_0x0073
            boolean r7 = r9.equals(r7)     // Catch:{ Exception -> 0x008d }
            if (r7 != 0) goto L_0x0073
        L_0x006b:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x008d }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x008d }
            goto L_0x007a
        L_0x0073:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x008d }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x008d }
        L_0x007a:
            com.didi.unifylogin.api.ILoginFunctionApi r5 = com.didi.unifylogin.api.OneLoginFacade.getFunction()     // Catch:{ Exception -> 0x008d }
            android.app.Application r6 = com.didi.sdk.app.DIDIBaseApplication.getAppContext()     // Catch:{ Exception -> 0x008d }
            com.didi.component.common.eventtracker.APIStatusTracker$1 r7 = new com.didi.component.common.eventtracker.APIStatusTracker$1     // Catch:{ Exception -> 0x008d }
            r7.<init>(r1)     // Catch:{ Exception -> 0x008d }
            r5.validate(r6, r7)     // Catch:{ Exception -> 0x008d }
            goto L_0x00ab
        L_0x008b:
            r5 = move-exception
            goto L_0x00af
        L_0x008d:
            r5 = move-exception
            java.lang.String r6 = "APIStatusTracker"
            java.lang.String r7 = "trackWhen101 error"
            com.didi.component.common.util.GLog.m7969e(r6, r7, r5)     // Catch:{ all -> 0x008b }
            java.lang.String r6 = "ex"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r7.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r8 = ""
            r7.append(r8)     // Catch:{ all -> 0x008b }
            r7.append(r5)     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x008b }
            r1.put(r6, r5)     // Catch:{ all -> 0x008b }
        L_0x00ab:
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r1)
            return
        L_0x00af:
            com.didi.component.business.util.GlobalOmegaUtils.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.eventtracker.APIStatusTracker.trackWhen101(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
