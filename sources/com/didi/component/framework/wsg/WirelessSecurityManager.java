package com.didi.component.framework.wsg;

import com.didi.security.wireless.adapter.SecurityWrapper;
import java.util.Map;

public class WirelessSecurityManager {

    /* renamed from: a */
    private static final String f14003a = "wsg_sig_toggle_v5";

    /* renamed from: b */
    private static final String f14004b = "wsg_report_toggle_v5";

    /* renamed from: c */
    private static boolean f14005c = false;

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init() {
        /*
            java.lang.Class<com.didi.component.framework.wsg.WirelessSecurityManager> r0 = com.didi.component.framework.wsg.WirelessSecurityManager.class
            monitor-enter(r0)
            boolean r1 = f14005c     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            java.lang.String r1 = "wsg_sig_toggle_v5"
            r2 = 1
            com.didichuxing.apollo.sdk.IToggle r1 = com.didichuxing.apollo.sdk.Apollo.getToggle(r1, r2)     // Catch:{ all -> 0x006a }
            boolean r1 = r1.allow()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = "wsg_report_toggle_v5"
            com.didichuxing.apollo.sdk.IToggle r1 = com.didichuxing.apollo.sdk.Apollo.getToggle(r1, r2)     // Catch:{ all -> 0x006a }
            boolean r1 = r1.allow()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0066
            java.lang.String r1 = com.didi.security.wireless.SecurityManager.getHost()     // Catch:{ all -> 0x006a }
            android.app.Application r3 = com.didi.sdk.app.DIDIApplication.getAppContext()     // Catch:{ all -> 0x006a }
            boolean r3 = com.didiglobal.domainservice.utils.DomainUtil.isSupportDomainSwitch(r3)     // Catch:{ all -> 0x006a }
            if (r3 == 0) goto L_0x0054
            com.didiglobal.domainservice.DomainServiceManager r3 = com.didiglobal.domainservice.DomainServiceManager.getInstance()     // Catch:{ all -> 0x006a }
            android.app.Application r4 = com.didi.sdk.app.DIDIApplication.getAppContext()     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.getDomainSuffix(r4)     // Catch:{ all -> 0x006a }
            java.lang.String r1 = com.didiglobal.domainservice.utils.DomainUtil.rebuildHost(r1, r3)     // Catch:{ all -> 0x006a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r3.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r4 = "rebuild wsg host to new: "
            r3.append(r4)     // Catch:{ all -> 0x006a }
            r3.append(r1)     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006a }
            com.didiglobal.domainservice.utils.ELog.log(r3)     // Catch:{ all -> 0x006a }
        L_0x0054:
            com.didi.security.wireless.SecurityManager.setHost(r1)     // Catch:{ all -> 0x006a }
            android.app.Application r1 = com.didi.sdk.app.DIDIBaseApplication.getAppContext()     // Catch:{ all -> 0x006a }
            com.didi.component.framework.wsg.WirelessSecurityManager$1 r3 = new com.didi.component.framework.wsg.WirelessSecurityManager$1     // Catch:{ all -> 0x006a }
            r3.<init>()     // Catch:{ all -> 0x006a }
            com.didi.security.wireless.adapter.SecurityWrapper.doInit((android.content.Context) r1, (com.didi.security.wireless.adapter.ISecurityInfo) r3)     // Catch:{ all -> 0x006a }
            com.didi.security.wireless.adapter.SecurityWrapper.triggerInit()     // Catch:{ all -> 0x006a }
        L_0x0066:
            f14005c = r2     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r0)
            return
        L_0x006a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.wsg.WirelessSecurityManager.init():void");
    }

    public static String sign(Map<String, String> map) {
        init();
        return null;
    }

    public static void reportAuto(String str, int i, String str2, String str3) {
        SecurityWrapper.doReport(str + ":" + str2, str3);
    }

    public static void reportAlways(String str, int i, String str2, String str3) {
        SecurityWrapper.doReport(str + ":" + str2, str3);
    }
}
