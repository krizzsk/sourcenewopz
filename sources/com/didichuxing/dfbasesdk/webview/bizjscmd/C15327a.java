package com.didichuxing.dfbasesdk.webview.bizjscmd;

import com.didichuxing.dfbasesdk.ottoevent.H5AppealCancelEvent;
import com.didichuxing.dfbasesdk.ottoevent.H5AppealDoneEvent;
import com.didichuxing.dfbasesdk.utils.BusUtils;

/* renamed from: com.didichuxing.dfbasesdk.webview.bizjscmd.a */
/* compiled from: AppealJsCmdHandler */
class C15327a implements IBizJsCmdHandler {

    /* renamed from: a */
    private final String f46951a;

    /* renamed from: b */
    private final int f46952b;

    /* renamed from: c */
    private int f46953c;

    C15327a(String str, int i) {
        this.f46951a = str;
        this.f46952b = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleJsCmd(java.lang.String r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1437318780(0xffffffffaa544184, float:-1.8852113E-13)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x002c
            r1 = 797673415(0x2f8b87c7, float:2.5380428E-10)
            if (r0 == r1) goto L_0x0021
            r1 = 1492713171(0x58f8fed3, float:2.19018676E15)
            if (r0 == r1) goto L_0x0017
            goto L_0x0036
        L_0x0017:
            java.lang.String r0 = "getAppealInfo"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x0021:
            java.lang.String r0 = "submitAppeal"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0037
        L_0x002c:
            java.lang.String r0 = "noticeAppealResult"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0036
            r0 = 2
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            if (r0 == 0) goto L_0x007a
            java.lang.String r1 = "appealCode"
            if (r0 == r4) goto L_0x0067
            if (r0 == r3) goto L_0x0040
            return r2
        L_0x0040:
            int r0 = r7.optInt(r1)
            java.lang.String r1 = "message"
            java.lang.String r7 = r7.optString(r1)
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r1 = new com.didichuxing.dfbasesdk.webview.JsCallbackEvent
            r1.<init>(r6)
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r6 = r1.build()
            com.didichuxing.dfbasesdk.utils.BusUtils.post(r6)
            com.didichuxing.dfbasesdk.ottoevent.H5AppealDoneEvent r6 = new com.didichuxing.dfbasesdk.ottoevent.H5AppealDoneEvent
            r6.<init>(r0, r7)
            com.didichuxing.dfbasesdk.utils.BusUtils.post(r6)
            com.didichuxing.dfbasesdk.webview.CloseWebviewEvent r6 = new com.didichuxing.dfbasesdk.webview.CloseWebviewEvent
            r6.<init>()
            com.didichuxing.dfbasesdk.utils.BusUtils.post(r6)
            return r4
        L_0x0067:
            int r7 = r7.optInt(r1)
            r5.f46953c = r7
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r7 = new com.didichuxing.dfbasesdk.webview.JsCallbackEvent
            r7.<init>(r6)
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r6 = r7.build()
            com.didichuxing.dfbasesdk.utils.BusUtils.post(r6)
            return r4
        L_0x007a:
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r7 = new com.didichuxing.dfbasesdk.webview.JsCallbackEvent
            r7.<init>(r6)
            java.lang.String r6 = r5.f46951a
            java.lang.String r0 = "appealId"
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r6 = r7.append(r0, r6)
            int r7 = r5.f46952b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r0 = "appealState"
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r6 = r6.append(r0, r7)
            com.didichuxing.dfbasesdk.webview.JsCallbackEvent r6 = r6.build()
            com.didichuxing.dfbasesdk.utils.BusUtils.post(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.webview.bizjscmd.C15327a.handleJsCmd(java.lang.String, org.json.JSONObject):boolean");
    }

    public void onUserCancel() {
        int i = this.f46953c;
        if (i == 0) {
            BusUtils.post(new H5AppealCancelEvent());
        } else {
            BusUtils.post(new H5AppealDoneEvent(i, ""));
        }
    }
}
