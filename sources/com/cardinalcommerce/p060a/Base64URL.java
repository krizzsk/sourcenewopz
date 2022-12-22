package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* renamed from: com.cardinalcommerce.a.Base64URL */
public final class Base64URL extends ECParameterSpec {
    public String getInstance;

    public Base64URL(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.getInstance = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Base64URL(java.lang.String r4, com.cardinalcommerce.p060a.getSDKAppID r5, com.cardinalcommerce.p060a.ChallengeParameters r6, java.math.BigInteger r7, java.math.BigInteger r8, byte[] r9) {
        /*
            r3 = this;
            com.cardinalcommerce.a.setAccessibilityPaneTitle r0 = r5.configure
            boolean r1 = com.cardinalcommerce.p060a.getDeviceData.init(r0)
            if (r1 == 0) goto L_0x0012
            java.security.spec.ECFieldFp r1 = new java.security.spec.ECFieldFp
            java.math.BigInteger r0 = r0.Cardinal()
            r1.<init>(r0)
            goto L_0x0031
        L_0x0012:
            com.cardinalcommerce.a.setContentCaptureSession r0 = (com.cardinalcommerce.p060a.setContentCaptureSession) r0
            com.cardinalcommerce.a.setContentDescription r0 = r0.configure()
            int[] r1 = r0.cca_continue()
            int r2 = r1.length
            int r2 = r2 + -1
            int[] r1 = com.cardinalcommerce.p060a.setForegroundTintBlendMode.getInstance((int[]) r1, (int) r2)
            int[] r1 = com.cardinalcommerce.p060a.setForegroundTintBlendMode.init((int[]) r1)
            java.security.spec.ECFieldF2m r2 = new java.security.spec.ECFieldF2m
            int r0 = r0.configure()
            r2.<init>(r0, r1)
            r1 = r2
        L_0x0031:
            com.cardinalcommerce.a.getAcsTransactionID r0 = r5.cleanup()
            java.math.BigInteger r0 = r0.Cardinal()
            com.cardinalcommerce.a.getAcsTransactionID r5 = r5.getWarnings()
            java.math.BigInteger r5 = r5.Cardinal()
            java.security.spec.EllipticCurve r2 = new java.security.spec.EllipticCurve
            r2.<init>(r1, r0, r5, r9)
            java.security.spec.ECPoint r5 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.init(r6)
            int r6 = r8.intValue()
            r3.<init>(r2, r5, r7, r6)
            r3.getInstance = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.Base64URL.<init>(java.lang.String, com.cardinalcommerce.a.getSDKAppID, com.cardinalcommerce.a.ChallengeParameters, java.math.BigInteger, java.math.BigInteger, byte[]):void");
    }
}
