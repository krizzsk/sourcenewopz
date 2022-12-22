package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import android.media.AudioRecord;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;

/* renamed from: com.didi.dimina.container.secondparty.permission.checker.d */
/* compiled from: RecordAudioTest */
class C7591d implements PermissionTest {

    /* renamed from: a */
    private static final int[] f17354a = {8000, 11025, 22050, ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR};

    /* renamed from: b */
    private final Context f17355b;

    C7591d(Context context) {
        this.f17355b = context;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0023 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[DONT_GENERATE] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo55894a() throws java.lang.Throwable {
        /*
            r3 = this;
            android.media.AudioRecord r0 = m12897b()
            r1 = 1
            if (r0 == 0) goto L_0x0013
            r0.startRecording()     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0012
            r0.stop()
            r0.release()
        L_0x0012:
            return r1
        L_0x0013:
            android.content.Context r2 = r3.f17355b     // Catch:{ all -> 0x0023 }
            boolean r2 = m12896a(r2)     // Catch:{ all -> 0x0023 }
            r1 = r1 ^ r2
            if (r0 == 0) goto L_0x0022
            r0.stop()
            r0.release()
        L_0x0022:
            return r1
        L_0x0023:
            android.content.Context r2 = r3.f17355b     // Catch:{ all -> 0x0033 }
            boolean r2 = m12896a(r2)     // Catch:{ all -> 0x0033 }
            r1 = r1 ^ r2
            if (r0 == 0) goto L_0x0032
            r0.stop()
            r0.release()
        L_0x0032:
            return r1
        L_0x0033:
            r1 = move-exception
            if (r0 == 0) goto L_0x003c
            r0.stop()
            r0.release()
        L_0x003c:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.permission.checker.C7591d.mo55894a():boolean");
    }

    /* renamed from: a */
    private static boolean m12896a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    /* renamed from: b */
    private static AudioRecord m12897b() {
        int i;
        for (int i2 : f17354a) {
            short[] sArr = {3, 2};
            for (int i3 = 0; i3 < 2; i3++) {
                short s = sArr[i3];
                short[] sArr2 = {16, 12};
                int i4 = 0;
                while (i4 < 2) {
                    short s2 = sArr2[i4];
                    int minBufferSize = AudioRecord.getMinBufferSize(i2, s2, s);
                    if (minBufferSize != -2) {
                        i = i4;
                        AudioRecord audioRecord = new AudioRecord(1, i2, s2, s, minBufferSize);
                        if (audioRecord.getState() == 1) {
                            return audioRecord;
                        }
                    } else {
                        i = i4;
                    }
                    i4 = i + 1;
                }
            }
        }
        return null;
    }
}
