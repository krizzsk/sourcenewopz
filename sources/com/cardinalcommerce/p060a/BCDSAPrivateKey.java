package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.BCDSAPrivateKey */
public final class BCDSAPrivateKey extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private static DSASigner.stdDSA f2173a = new DSASigner.stdDSA(KeyAgreementSpi.MQVwithSHA512KDF.CardinalError, ECGOST.Mappings.Cardinal);

    /* renamed from: b */
    private static DSASigner.stdDSA f2174b = new DSASigner.stdDSA(KeyFactorySpi.CardinalError, f2173a);

    /* renamed from: c */
    private static setProxyAddress f2175c = new setProxyAddress(20);

    /* renamed from: d */
    private static setProxyAddress f2176d = new setProxyAddress(1);
    public DSASigner.stdDSA cca_continue;
    public setProxyAddress configure;
    public setProxyAddress getInstance;
    public DSASigner.stdDSA init;

    public BCDSAPrivateKey() {
        this.init = f2173a;
        this.cca_continue = f2174b;
        this.getInstance = f2175c;
        this.configure = f2176d;
    }

    public BCDSAPrivateKey(DSASigner.stdDSA stddsa, DSASigner.stdDSA stddsa2, setProxyAddress setproxyaddress, setProxyAddress setproxyaddress2) {
        this.init = stddsa;
        this.cca_continue = stddsa2;
        this.getInstance = setproxyaddress;
        this.configure = setproxyaddress2;
    }

    public static BCDSAPrivateKey Cardinal(Object obj) {
        if (obj instanceof BCDSAPrivateKey) {
            return (BCDSAPrivateKey) obj;
        }
        if (obj != null) {
            return new BCDSAPrivateKey(setThreeDSRequestorAppURL.cca_continue(obj));
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [com.cardinalcommerce.a.setLocationDataConsentGiven] */
    /* JADX WARNING: type inference failed for: r3v8, types: [com.cardinalcommerce.a.setLocationDataConsentGiven] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BCDSAPrivateKey(com.cardinalcommerce.p060a.setThreeDSRequestorAppURL r6) {
        /*
            r5 = this;
            r5.<init>()
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = f2173a
            r5.init = r0
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = f2174b
            r5.cca_continue = r0
            com.cardinalcommerce.a.setProxyAddress r0 = f2175c
            r5.getInstance = r0
            com.cardinalcommerce.a.setProxyAddress r0 = f2176d
            r5.configure = r0
            r0 = 0
        L_0x0014:
            int r1 = r6.getInstance()
            if (r0 == r1) goto L_0x007e
            com.cardinalcommerce.a.getProxyAddress r1 = r6.Cardinal((int) r0)
            com.cardinalcommerce.a.getType r1 = (com.cardinalcommerce.p060a.getType) r1
            int r2 = r1.Cardinal
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x006a
            if (r2 == r4) goto L_0x0058
            r4 = 2
            if (r2 == r4) goto L_0x0047
            r4 = 3
            if (r2 != r4) goto L_0x003f
            com.cardinalcommerce.a.getProxyAddress r2 = r1.getInstance
            if (r2 == 0) goto L_0x0038
            com.cardinalcommerce.a.getProxyAddress r1 = r1.getInstance
            com.cardinalcommerce.a.setLocationDataConsentGiven r3 = r1.values()
        L_0x0038:
            com.cardinalcommerce.a.setProxyAddress r1 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r3)
            r5.configure = r1
            goto L_0x007b
        L_0x003f:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "unknown tag"
            r6.<init>(r0)
            throw r6
        L_0x0047:
            com.cardinalcommerce.a.getProxyAddress r2 = r1.getInstance
            if (r2 == 0) goto L_0x0051
            com.cardinalcommerce.a.getProxyAddress r1 = r1.getInstance
            com.cardinalcommerce.a.setLocationDataConsentGiven r3 = r1.values()
        L_0x0051:
            com.cardinalcommerce.a.setProxyAddress r1 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r3)
            r5.getInstance = r1
            goto L_0x007b
        L_0x0058:
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.configure(r1, r4)
            if (r1 == 0) goto L_0x0067
            com.cardinalcommerce.a.DSASigner$stdDSA r3 = new com.cardinalcommerce.a.DSASigner$stdDSA
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r1)
            r3.<init>((com.cardinalcommerce.p060a.setThreeDSRequestorAppURL) r1)
        L_0x0067:
            r5.cca_continue = r3
            goto L_0x007b
        L_0x006a:
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.configure(r1, r4)
            if (r1 == 0) goto L_0x0079
            com.cardinalcommerce.a.DSASigner$stdDSA r3 = new com.cardinalcommerce.a.DSASigner$stdDSA
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r1)
            r3.<init>((com.cardinalcommerce.p060a.setThreeDSRequestorAppURL) r1)
        L_0x0079:
            r5.init = r3
        L_0x007b:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.BCDSAPrivateKey.<init>(com.cardinalcommerce.a.setThreeDSRequestorAppURL):void");
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        if (!this.init.equals(f2173a)) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 0, this.init));
        }
        if (!this.cca_continue.equals(f2174b)) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 1, this.cca_continue));
        }
        if (!this.getInstance.equals(f2175c)) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 2, this.getInstance));
        }
        if (!this.configure.equals(f2176d)) {
            setforegroundtintblendmode.cca_continue.addElement(new RSA(true, 3, this.configure));
        }
        return new GOST(setforegroundtintblendmode);
    }
}
