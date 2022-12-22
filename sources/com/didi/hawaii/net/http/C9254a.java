package com.didi.hawaii.net.http;

import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.net.http.exception.NetUnavailableException;
import java.io.IOException;

/* renamed from: com.didi.hawaii.net.http.a */
/* compiled from: HttpRetryControl */
class C9254a {
    C9254a() {
    }

    /* renamed from: a */
    public static HttpResponse m17258a(boolean z, String str, String str2, byte[] bArr, boolean z2) throws NetUnavailableException, Exception {
        return m17259a(z, str, str2, bArr, z2, 3);
    }

    /* renamed from: a */
    private static HttpResponse m17259a(boolean z, String str, String str2, byte[] bArr, boolean z2, int i) throws NetUnavailableException, Exception {
        int i2;
        String str3 = str;
        int i3 = i;
        int i4 = 0;
        while (i4 < i3) {
            if (str3 != null) {
                try {
                    HWLog.m16758d(1, "netcheck", "begin download:" + str);
                } catch (NetUnavailableException e) {
                    throw e;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e3) {
                        InterruptedException interruptedException = e3;
                        Thread.currentThread().interrupt();
                        interruptedException.printStackTrace();
                    }
                    i4++;
                }
            }
            HttpResponse doGetOrPost = HttpExecutor.doGetOrPost(z, str, str2, (String) null, bArr, z2, i4 == 0);
            if (str3 != null) {
                if (doGetOrPost != null) {
                    if (doGetOrPost.data != null) {
                        i2 = doGetOrPost.data.length;
                        HWLog.m16758d(1, "netcheck", "after download: size:" + i2 + ":" + str);
                    }
                }
                i2 = 0;
                HWLog.m16758d(1, "netcheck", "after download: size:" + i2 + ":" + str);
            }
            return doGetOrPost;
        }
        throw new IOException("doDnsVisit HttpResponse = null");
    }
}
