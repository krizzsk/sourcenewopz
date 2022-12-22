package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.io.InputStream;

/* renamed from: com.cardinalcommerce.a.a */
final class C1986a extends InputStream {

    /* renamed from: a */
    private final DSASigner.dsaSha3_384 f2504a;

    /* renamed from: b */
    private boolean f2505b = true;

    /* renamed from: c */
    private InputStream f2506c;

    C1986a(DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2504a = dsasha3_384;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int read() throws java.io.IOException {
        /*
            r3 = this;
            java.io.InputStream r0 = r3.f2506c
            r1 = -1
            if (r0 != 0) goto L_0x0019
            boolean r0 = r3.f2505b
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.cardinalcommerce.a.DSASigner$dsaSha3_384 r0 = r3.f2504a
            com.cardinalcommerce.a.getProxyAddress r0 = r0.Cardinal()
            com.cardinalcommerce.a.getUICustomization r0 = (com.cardinalcommerce.p060a.getUICustomization) r0
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            r2 = 0
            r3.f2505b = r2
            goto L_0x0030
        L_0x0019:
            java.io.InputStream r0 = r3.f2506c
            int r0 = r0.read()
            if (r0 < 0) goto L_0x0022
            return r0
        L_0x0022:
            com.cardinalcommerce.a.DSASigner$dsaSha3_384 r0 = r3.f2504a
            com.cardinalcommerce.a.getProxyAddress r0 = r0.Cardinal()
            com.cardinalcommerce.a.getUICustomization r0 = (com.cardinalcommerce.p060a.getUICustomization) r0
            if (r0 != 0) goto L_0x0030
            r0 = 0
            r3.f2506c = r0
            return r1
        L_0x0030:
            java.io.InputStream r0 = r0.init()
            r3.f2506c = r0
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C1986a.read():int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e A[EDGE_INSN: B:21:0x002e->B:15:0x002e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002d A[SYNTHETIC] */
    public final int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            java.io.InputStream r0 = r5.f2506c
            r1 = 0
            r2 = -1
            if (r0 != 0) goto L_0x001e
            boolean r0 = r5.f2505b
            if (r0 != 0) goto L_0x000b
            return r2
        L_0x000b:
            com.cardinalcommerce.a.DSASigner$dsaSha3_384 r0 = r5.f2504a
            com.cardinalcommerce.a.getProxyAddress r0 = r0.Cardinal()
            com.cardinalcommerce.a.getUICustomization r0 = (com.cardinalcommerce.p060a.getUICustomization) r0
            if (r0 != 0) goto L_0x0016
            return r2
        L_0x0016:
            r5.f2505b = r1
        L_0x0018:
            java.io.InputStream r0 = r0.init()
            r5.f2506c = r0
        L_0x001e:
            java.io.InputStream r0 = r5.f2506c
            int r3 = r7 + r1
            int r4 = r8 - r1
            int r0 = r0.read(r6, r3, r4)
            if (r0 < 0) goto L_0x002e
            int r1 = r1 + r0
            if (r1 != r8) goto L_0x001e
            return r1
        L_0x002e:
            com.cardinalcommerce.a.DSASigner$dsaSha3_384 r0 = r5.f2504a
            com.cardinalcommerce.a.getProxyAddress r0 = r0.Cardinal()
            com.cardinalcommerce.a.getUICustomization r0 = (com.cardinalcommerce.p060a.getUICustomization) r0
            if (r0 != 0) goto L_0x0018
            r6 = 0
            r5.f2506c = r6
            if (r1 > 0) goto L_0x003e
            return r2
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C1986a.read(byte[], int, int):int");
    }
}
