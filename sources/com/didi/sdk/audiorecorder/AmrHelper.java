package com.didi.sdk.audiorecorder;

import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.IAmrHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.IOException;

public final class AmrHelper implements IAmrHelper {

    /* renamed from: a */
    private static final String f35272a = "AmrHelper -> ";

    /* renamed from: b */
    private long f35273b = GsmAmrEncoderNew();

    /* renamed from: c */
    private Supporter.AmrConsumer f35274c;

    private static native void GsmAmrEncoderCleanup(long j);

    private static native void GsmAmrEncoderDelete(long j);

    private static native int GsmAmrEncoderEncode(long j, byte[] bArr, int i, byte[] bArr2, int i2) throws IOException;

    private static native void GsmAmrEncoderInitialize(long j);

    private static native long GsmAmrEncoderNew();

    public void start() {
    }

    static {
        System.loadLibrary("didi_amr");
        LogUtil.log(f35272a, "Succeed in loading amr encode lib.");
    }

    public AmrHelper() {
        LogUtil.log(f35272a, "Succeed in creating gsm-amr Encoder.");
        GsmAmrEncoderInitialize(this.f35273b);
        LogUtil.log(f35272a, "Succeed in init gsm-amr Encoder");
    }

    /* renamed from: a */
    private int m24970a(byte[] bArr, byte[] bArr2) throws IOException {
        long j = this.f35273b;
        if (j != 0) {
            return GsmAmrEncoderEncode(j, bArr, 0, bArr2, 0);
        }
        throw new IllegalStateException("not open");
    }

    public void close() throws IOException {
        this.f35274c = null;
        try {
            if (this.f35273b != 0) {
                GsmAmrEncoderCleanup(this.f35273b);
            }
            try {
                if (this.f35273b != 0) {
                    GsmAmrEncoderDelete(this.f35273b);
                }
            } finally {
                this.f35273b = 0;
            }
        } catch (Throwable th) {
            if (this.f35273b != 0) {
                GsmAmrEncoderDelete(this.f35273b);
            }
            throw th;
        } finally {
            this.f35273b = 0;
        }
    }

    public void setAmrConsumer(Supporter.AmrConsumer amrConsumer) {
        this.f35274c = amrConsumer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleFrame(byte[] r5) {
        /*
            r4 = this;
            int r0 = r5.length
            byte[] r0 = com.didi.sdk.audiorecorder.utils.ByteArrayAllocator.allocate(r0)
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            r1 = 0
            boolean r2 = r4.isClosed()     // Catch:{ all -> 0x0014 }
            if (r2 != 0) goto L_0x001a
            int r5 = r4.m24970a(r5, r0)     // Catch:{ all -> 0x0014 }
            goto L_0x001b
        L_0x0014:
            r5 = move-exception
            java.lang.String r2 = "AmrHelper -> handleFrame -> Failed to convert pcm to amr."
            com.didi.sdk.audiorecorder.utils.LogUtil.log(r2, r5)
        L_0x001a:
            r5 = 0
        L_0x001b:
            if (r5 > 0) goto L_0x003c
            r0 = 2
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r2 = "AmrHelper -> "
            r0[r1] = r2
            r1 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "handleFrame -> illegal encodedLength : "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r0[r1] = r5
            com.didi.sdk.audiorecorder.utils.LogUtil.log((java.lang.String[]) r0)
            return
        L_0x003c:
            com.didi.sdk.audiorecorder.helper.recorder.Supporter$AmrConsumer r1 = r4.f35274c
            if (r1 == 0) goto L_0x0043
            r1.onAmrFeed(r0, r5)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.AmrHelper.handleFrame(byte[]):void");
    }

    public boolean isClosed() {
        return this.f35273b == 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (this.f35273b != 0) {
            close();
            throw new IllegalStateException("someone forgot to close AmrInputStream");
        }
    }
}
