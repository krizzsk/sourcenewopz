package com.didi.dimina.container.jsengine.method;

import com.didi.dimina.container.DMMina;

public class VConsoleLog implements JSCallback {
    public static final String TAG_JS_ENGINE = "tag_engine";

    /* renamed from: a */
    DMMina f16842a;

    public VConsoleLog(DMMina dMMina) {
        this.f16842a = dMMina;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007d  */
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
            if (r6 == 0) goto L_0x007d
            int r6 = r6.length()
            r4 = 2
            if (r6 < r4) goto L_0x007d
            boolean r6 = r0 instanceof java.lang.Number
            if (r6 == 0) goto L_0x007d
            boolean r6 = r3 instanceof java.lang.String
            if (r6 != 0) goto L_0x0026
            goto L_0x007d
        L_0x0026:
            java.lang.Number r0 = (java.lang.Number) r0
            int r6 = r0.intValue()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0037
            return r2
        L_0x0037:
            java.lang.String r3 = "tag_engine"
            if (r6 == 0) goto L_0x0054
            if (r6 == r1) goto L_0x0050
            if (r6 == r4) goto L_0x004c
            r1 = 3
            if (r6 == r1) goto L_0x0043
            goto L_0x0057
        L_0x0043:
            com.didi.dimina.container.util.LogUtil.eRelease(r3, r0)
            java.io.PrintStream r1 = java.lang.System.err
            r1.println(r0)
            goto L_0x0057
        L_0x004c:
            com.didi.dimina.container.util.LogUtil.wRelease(r3, r0)
            goto L_0x0057
        L_0x0050:
            com.didi.dimina.container.util.LogUtil.dRelease(r3, r0)
            goto L_0x0057
        L_0x0054:
            com.didi.dimina.container.util.LogUtil.iRelease(r3, r0)
        L_0x0057:
            com.didi.dimina.container.DMMina r1 = r5.f16842a
            com.didi.dimina.container.debug.IWebSocketMsgSender r1 = r1.getWebSocketMsgSender()
            if (r1 == 0) goto L_0x006a
            com.didi.dimina.container.DMMina r1 = r5.f16842a
            com.didi.dimina.container.debug.IWebSocketMsgSender r1 = r1.getWebSocketMsgSender()
            java.lang.String r3 = "log"
            r1.sendMsgToIDE(r3, r0)
        L_0x006a:
            com.didi.dimina.container.DMMina r1 = r5.f16842a
            com.didi.dimina.container.mina.IDMVConsole r1 = r1.getVConsoleManager()
            r1.recordVConsole(r6, r0)
            com.didi.dimina.container.DMMina r6 = r5.f16842a
            com.didi.dimina.container.mina.IDMVConsole r6 = r6.getVConsoleManager()
            r6.notifyVConsole()
            return r2
        L_0x007d:
            java.lang.String r6 = "console.log(Number type,String message) only accept two parameters"
            com.didi.dimina.container.util.LogUtil.m13409e(r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.jsengine.method.VConsoleLog.callback(com.didi.dimina.container.jsengine.JSArray):java.lang.Object");
    }
}
