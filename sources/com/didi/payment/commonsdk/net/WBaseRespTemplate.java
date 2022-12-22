package com.didi.payment.commonsdk.net;

import com.didi.payment.commonsdk.net.IValidator;

public class WBaseRespTemplate<T extends IValidator> extends WBaseResp {
    public T data;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValid() {
        /*
            r1 = this;
            int r0 = r1.errno
            if (r0 != 0) goto L_0x0010
            T r0 = r1.data
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.valid()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.commonsdk.net.WBaseRespTemplate.isValid():boolean");
    }
}
