package com.didi.travel.psnger.p170v2.host;

import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.rpc.IRpcDynamicHostCallback;

/* renamed from: com.didi.travel.psnger.v2.host.ExpressRpcDynamicHostCallback */
public class ExpressRpcDynamicHostCallback implements IRpcDynamicHostCallback {
    public String getSharePath(Api api, String str, String str2) {
        return str2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getHost(com.didi.travel.p171v2.biz.api.Api r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            int r4 = r5.hashCode()
            r6 = 4
            r0 = 3
            r1 = 2
            r2 = 1
            switch(r4) {
                case -1818378079: goto L_0x0034;
                case -145852516: goto L_0x002a;
                case -47452690: goto L_0x0020;
                case 1364141644: goto L_0x0016;
                case 1584606866: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r4 = "host_key_route"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x003e
            r4 = 3
            goto L_0x003f
        L_0x0016:
            java.lang.String r4 = "host_key_car_sliding"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x003e
            r4 = 1
            goto L_0x003f
        L_0x0020:
            java.lang.String r4 = "host_key_resources"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x003e
            r4 = 2
            goto L_0x003f
        L_0x002a:
            java.lang.String r4 = "host_key_biz"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x003e
            r4 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r4 = "host_key_enterprise_pay"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x003e
            r4 = 4
            goto L_0x003f
        L_0x003e:
            r4 = -1
        L_0x003f:
            if (r4 == 0) goto L_0x005f
            if (r4 == r2) goto L_0x005a
            if (r4 == r1) goto L_0x0055
            if (r4 == r0) goto L_0x0050
            if (r4 == r6) goto L_0x004b
            r4 = 0
            return r4
        L_0x004b:
            java.lang.String r4 = com.didi.travel.psnger.p170v2.host.HostManager.getEnterprisePayHost()
            return r4
        L_0x0050:
            java.lang.String r4 = com.didi.travel.psnger.p170v2.host.HostManager.getRouteHost()
            return r4
        L_0x0055:
            java.lang.String r4 = com.didi.travel.psnger.p170v2.host.HostManager.getResourcesHost()
            return r4
        L_0x005a:
            java.lang.String r4 = com.didi.travel.psnger.p170v2.host.HostManager.getCarSlidingHost()
            return r4
        L_0x005f:
            java.lang.String r4 = com.didi.travel.psnger.p170v2.host.HostManager.getBizHost()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.p170v2.host.ExpressRpcDynamicHostCallback.getHost(com.didi.travel.v2.biz.api.Api, java.lang.String, java.lang.String):java.lang.String");
    }
}
