package com.didi.dimina.container.jsengine.method;

import com.didi.dimina.container.DMMina;

public class NativeLog implements JSCallback {
    public static final String TAG_JS_ENGINE = "tag_engine";

    /* renamed from: a */
    DMMina f16840a;

    public NativeLog(DMMina dMMina) {
        this.f16840a = dMMina;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object callback(com.didi.dimina.container.jsengine.JSArray r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.Object r0 = r6.get(r0)     // Catch:{ Exception -> 0x000e }
            java.lang.Object r3 = r6.get(r1)     // Catch:{ Exception -> 0x000c }
            goto L_0x0014
        L_0x000c:
            r3 = move-exception
            goto L_0x0010
        L_0x000e:
            r3 = move-exception
            r0 = r2
        L_0x0010:
            r3.printStackTrace()
            r3 = r2
        L_0x0014:
            if (r6 == 0) goto L_0x00b6
            int r6 = r6.length()
            r4 = 2
            if (r6 < r4) goto L_0x00b6
            boolean r6 = r0 instanceof java.lang.Number
            if (r6 == 0) goto L_0x00b6
            boolean r6 = r3 instanceof java.lang.String
            if (r6 != 0) goto L_0x0027
            goto L_0x00b6
        L_0x0027:
            java.lang.Number r0 = (java.lang.Number) r0
            int r6 = r0.intValue()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0038
            return r2
        L_0x0038:
            java.lang.String r3 = "tag_engine | "
            if (r6 == 0) goto L_0x007e
            if (r6 == r1) goto L_0x006b
            if (r6 == r4) goto L_0x0058
            r1 = 3
            if (r6 == r1) goto L_0x0045
            goto L_0x0090
        L_0x0045:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.didi.dimina.container.util.LogUtil.m13409e(r1)
            goto L_0x0090
        L_0x0058:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.didi.dimina.container.util.LogUtil.m13413w(r1)
            goto L_0x0090
        L_0x006b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.didi.dimina.container.util.LogUtil.m13407d(r1)
            goto L_0x0090
        L_0x007e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.didi.dimina.container.util.LogUtil.m13411i(r1)
        L_0x0090:
            com.didi.dimina.container.DMMina r1 = r5.f16840a
            com.didi.dimina.container.debug.IWebSocketMsgSender r1 = r1.getWebSocketMsgSender()
            if (r1 == 0) goto L_0x00a3
            com.didi.dimina.container.DMMina r1 = r5.f16840a
            com.didi.dimina.container.debug.IWebSocketMsgSender r1 = r1.getWebSocketMsgSender()
            java.lang.String r3 = "log"
            r1.sendMsgToIDE(r3, r0)
        L_0x00a3:
            com.didi.dimina.container.DMMina r1 = r5.f16840a
            com.didi.dimina.container.mina.IDMVConsole r1 = r1.getVConsoleManager()
            r1.recordVConsole(r6, r0)
            com.didi.dimina.container.DMMina r6 = r5.f16840a
            com.didi.dimina.container.mina.IDMVConsole r6 = r6.getVConsoleManager()
            r6.notifyVConsole()
            return r2
        L_0x00b6:
            java.lang.String r6 = "console.log(Number type,String message) only accept two parameters"
            com.didi.dimina.container.util.LogUtil.m13411i(r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.jsengine.method.NativeLog.callback(com.didi.dimina.container.jsengine.JSArray):java.lang.Object");
    }
}
