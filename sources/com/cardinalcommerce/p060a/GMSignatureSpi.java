package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GMCipherSpi;
import java.security.spec.KeySpec;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* renamed from: com.cardinalcommerce.a.GMSignatureSpi */
public final class GMSignatureSpi extends getThreeDSRequestorAppURL {
    public DSASigner.stdDSA Cardinal;
    public PrivateKeyInfo CardinalError;
    public GMCipherSpi.SM2withSha224 CardinalUiType;

    /* renamed from: a */
    private setThreeDSRequestorAppURL f2438a;
    public setProxyAddress cca_continue;
    public PrivateKeyInfo cleanup;
    public DSASigner.dsaSha3_224 configure;
    public GMCipherSpi.SM2withSha512 getInstance;
    public GMCipherSpi.SM2withSha512 getSDKVersion;
    public SubjectPublicKeyInfo getWarnings;
    public setProxyAddress init;
    public DSASigner.dsaSha3_224 values;

    /* renamed from: com.cardinalcommerce.a.GMSignatureSpi$sm3WithSM2 */
    public final class sm3WithSM2 extends PrivateKeyInfo {
        public sm3WithSM2(PrivateKeyInfo privateKeyInfo) {
            super(privateKeyInfo.getInstance(), privateKeyInfo.cleanup());
        }
    }

    public final setLocationDataConsentGiven values() {
        return this.f2438a;
    }

    /* renamed from: com.cardinalcommerce.a.GMSignatureSpi$sha256WithSM2 */
    public final class sha256WithSM2 extends getThreeDSRequestorAppURL {
        public GMCipherSpi.SM2withSha512 Cardinal;
        public setProxyAddress cca_continue;
        public GMCipherSpi.SM2withSha224 cleanup;
        public GMCipherSpi.SM2withSha512 configure;
        public DSASigner.dsaSha3_224 getInstance;
        setThreeDSRequestorAppURL getSDKVersion;
        public DSASigner.stdDSA init;

        /* renamed from: com.cardinalcommerce.a.GMSignatureSpi$sha256WithSM2$Cardinal */
        public class Cardinal implements KeySpec, Enumeration {
            private Cardinal() {
            }

            /* synthetic */ Cardinal(sha256WithSM2 sha256withsm2) {
                this();
            }

            public final boolean hasMoreElements() {
                return false;
            }

            public final Object nextElement() {
                throw new NoSuchElementException("Empty Enumeration");
            }
        }

        /* renamed from: com.cardinalcommerce.a.GMSignatureSpi$sha256WithSM2$configure */
        public static class C1945configure extends getThreeDSRequestorAppURL {
            private GMCipherSpi.SM2withSha224 Cardinal;
            public setThreeDSRequestorAppURL configure;

            public C1945configure(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
                if (setthreedsrequestorappurl.getInstance() < 2 || setthreedsrequestorappurl.getInstance() > 3) {
                    StringBuilder sb = new StringBuilder("Bad sequence size: ");
                    sb.append(setthreedsrequestorappurl.getInstance());
                    throw new IllegalArgumentException(sb.toString());
                }
                this.configure = setthreedsrequestorappurl;
            }

            public final boolean Cardinal() {
                return this.configure.getInstance() == 3;
            }

            public final setLocationDataConsentGiven values() {
                return this.configure;
            }

            public final GMCipherSpi.SM2withSha224 configure() {
                if (this.Cardinal == null && this.configure.getInstance() == 3) {
                    getProxyAddress Cardinal2 = this.configure.Cardinal(2);
                    this.Cardinal = Cardinal2 instanceof GMCipherSpi.SM2withSha224 ? (GMCipherSpi.SM2withSha224) Cardinal2 : Cardinal2 != null ? new GMCipherSpi.SM2withSha224(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null;
                }
                return this.Cardinal;
            }
        }

        /* renamed from: com.cardinalcommerce.a.GMSignatureSpi$sha256WithSM2$getInstance */
        class getInstance implements Enumeration {
            private final Enumeration Cardinal;

            getInstance(Enumeration enumeration) {
                this.Cardinal = enumeration;
            }

            public final boolean hasMoreElements() {
                return this.Cardinal.hasMoreElements();
            }

            public final Object nextElement() {
                Object nextElement = this.Cardinal.nextElement();
                if (nextElement instanceof C1945configure) {
                    return (C1945configure) nextElement;
                }
                if (nextElement != null) {
                    return new C1945configure(setThreeDSRequestorAppURL.cca_continue(nextElement));
                }
                return null;
            }
        }

        public sha256WithSM2(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            if (setthreedsrequestorappurl.getInstance() < 3 || setthreedsrequestorappurl.getInstance() > 7) {
                StringBuilder sb = new StringBuilder("Bad sequence size: ");
                sb.append(setthreedsrequestorappurl.getInstance());
                throw new IllegalArgumentException(sb.toString());
            }
            int i = 0;
            GMCipherSpi.SM2withSha224 sM2withSha224 = null;
            if (setthreedsrequestorappurl.Cardinal(0) instanceof setProxyAddress) {
                this.cca_continue = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0));
                i = 1;
            } else {
                this.cca_continue = null;
            }
            int i2 = i + 1;
            getProxyAddress Cardinal2 = setthreedsrequestorappurl.Cardinal(i);
            this.init = Cardinal2 instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) Cardinal2 : Cardinal2 != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null;
            int i3 = i2 + 1;
            this.getInstance = DSASigner.dsaSha3_224.getInstance(setthreedsrequestorappurl.Cardinal(i2));
            int i4 = i3 + 1;
            this.configure = GMCipherSpi.SM2withSha512.init(setthreedsrequestorappurl.Cardinal(i3));
            if (i4 < setthreedsrequestorappurl.getInstance() && ((setthreedsrequestorappurl.Cardinal(i4) instanceof Payment) || (setthreedsrequestorappurl.Cardinal(i4) instanceof setRenderType) || (setthreedsrequestorappurl.Cardinal(i4) instanceof GMCipherSpi.SM2withSha512))) {
                this.Cardinal = GMCipherSpi.SM2withSha512.init(setthreedsrequestorappurl.Cardinal(i4));
                i4++;
            }
            if (i4 < setthreedsrequestorappurl.getInstance() && !(setthreedsrequestorappurl.Cardinal(i4) instanceof getType)) {
                this.getSDKVersion = setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl.Cardinal(i4));
                i4++;
            }
            if (i4 < setthreedsrequestorappurl.getInstance() && (setthreedsrequestorappurl.Cardinal(i4) instanceof getType)) {
                setThreeDSRequestorAppURL configure2 = setThreeDSRequestorAppURL.configure((getType) setthreedsrequestorappurl.Cardinal(i4), true);
                this.cleanup = configure2 != null ? new GMCipherSpi.SM2withSha224(setThreeDSRequestorAppURL.cca_continue((Object) configure2)) : sM2withSha224;
            }
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setProxyAddress setproxyaddress = this.cca_continue;
            if (setproxyaddress != null) {
                setforegroundtintblendmode.cca_continue.addElement(setproxyaddress);
            }
            setforegroundtintblendmode.cca_continue.addElement(this.init);
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            setforegroundtintblendmode.cca_continue.addElement(this.configure);
            GMCipherSpi.SM2withSha512 sM2withSha512 = this.Cardinal;
            if (sM2withSha512 != null) {
                setforegroundtintblendmode.cca_continue.addElement(sM2withSha512);
            }
            setThreeDSRequestorAppURL setthreedsrequestorappurl = this.getSDKVersion;
            if (setthreedsrequestorappurl != null) {
                setforegroundtintblendmode.cca_continue.addElement(setthreedsrequestorappurl);
            }
            GMCipherSpi.SM2withSha224 sM2withSha224 = this.cleanup;
            if (sM2withSha224 != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(sM2withSha224));
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    GMSignatureSpi(com.cardinalcommerce.p060a.setThreeDSRequestorAppURL r9) {
        /*
            r8 = this;
            r8.<init>()
            r8.f2438a = r9
            r0 = 0
            com.cardinalcommerce.a.getProxyAddress r1 = r9.Cardinal((int) r0)
            boolean r1 = r1 instanceof com.cardinalcommerce.p060a.getType
            r2 = 0
            r4 = 0
            if (r1 == 0) goto L_0x002b
            com.cardinalcommerce.a.getProxyAddress r1 = r9.Cardinal((int) r0)
            com.cardinalcommerce.a.getType r1 = (com.cardinalcommerce.p060a.getType) r1
            com.cardinalcommerce.a.getProxyAddress r5 = r1.getInstance
            if (r5 == 0) goto L_0x0022
            com.cardinalcommerce.a.getProxyAddress r1 = r1.getInstance
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = r1.values()
            goto L_0x0023
        L_0x0022:
            r1 = r4
        L_0x0023:
            com.cardinalcommerce.a.setProxyAddress r1 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r1)
            r8.init = r1
            r1 = 0
            goto L_0x0033
        L_0x002b:
            com.cardinalcommerce.a.setProxyAddress r1 = new com.cardinalcommerce.a.setProxyAddress
            r1.<init>((long) r2)
            r8.init = r1
            r1 = -1
        L_0x0033:
            com.cardinalcommerce.a.setProxyAddress r5 = r8.init
            java.math.BigInteger r6 = new java.math.BigInteger
            byte[] r5 = r5.Cardinal
            r6.<init>(r5)
            java.math.BigInteger r2 = java.math.BigInteger.valueOf(r2)
            boolean r2 = r6.equals(r2)
            r3 = 1
            if (r2 == 0) goto L_0x004a
            r2 = 1
        L_0x0048:
            r5 = 0
            goto L_0x0079
        L_0x004a:
            com.cardinalcommerce.a.setProxyAddress r2 = r8.init
            java.math.BigInteger r5 = new java.math.BigInteger
            byte[] r2 = r2.Cardinal
            r5.<init>(r2)
            r6 = 1
            java.math.BigInteger r2 = java.math.BigInteger.valueOf(r6)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0062
            r2 = 0
            r5 = 1
            goto L_0x0079
        L_0x0062:
            com.cardinalcommerce.a.setProxyAddress r2 = r8.init
            java.math.BigInteger r5 = new java.math.BigInteger
            byte[] r2 = r2.Cardinal
            r5.<init>(r2)
            r6 = 2
            java.math.BigInteger r2 = java.math.BigInteger.valueOf(r6)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x014e
            r2 = 0
            goto L_0x0048
        L_0x0079:
            int r6 = r1 + 1
            com.cardinalcommerce.a.getProxyAddress r6 = r9.Cardinal((int) r6)
            com.cardinalcommerce.a.setProxyAddress r6 = com.cardinalcommerce.p060a.setProxyAddress.Cardinal((java.lang.Object) r6)
            r8.cca_continue = r6
            int r6 = r1 + 2
            com.cardinalcommerce.a.getProxyAddress r6 = r9.Cardinal((int) r6)
            boolean r7 = r6 instanceof com.cardinalcommerce.p060a.DSASigner.stdDSA
            if (r7 == 0) goto L_0x0092
            com.cardinalcommerce.a.DSASigner$stdDSA r6 = (com.cardinalcommerce.p060a.DSASigner.stdDSA) r6
            goto L_0x00a0
        L_0x0092:
            if (r6 == 0) goto L_0x009f
            com.cardinalcommerce.a.DSASigner$stdDSA r7 = new com.cardinalcommerce.a.DSASigner$stdDSA
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r6 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r6)
            r7.<init>((com.cardinalcommerce.p060a.setThreeDSRequestorAppURL) r6)
            r6 = r7
            goto L_0x00a0
        L_0x009f:
            r6 = r4
        L_0x00a0:
            r8.Cardinal = r6
            int r6 = r1 + 3
            com.cardinalcommerce.a.getProxyAddress r6 = r9.Cardinal((int) r6)
            com.cardinalcommerce.a.DSASigner$dsaSha3_224 r6 = com.cardinalcommerce.p060a.DSASigner.dsaSha3_224.getInstance(r6)
            r8.configure = r6
            int r6 = r1 + 4
            com.cardinalcommerce.a.getProxyAddress r6 = r9.Cardinal((int) r6)
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r6 = (com.cardinalcommerce.p060a.setThreeDSRequestorAppURL) r6
            com.cardinalcommerce.a.getProxyAddress r0 = r6.Cardinal((int) r0)
            com.cardinalcommerce.a.GMCipherSpi$SM2withSha512 r0 = com.cardinalcommerce.p060a.GMCipherSpi.SM2withSha512.init(r0)
            r8.getInstance = r0
            com.cardinalcommerce.a.getProxyAddress r0 = r6.Cardinal((int) r3)
            com.cardinalcommerce.a.GMCipherSpi$SM2withSha512 r0 = com.cardinalcommerce.p060a.GMCipherSpi.SM2withSha512.init(r0)
            r8.getSDKVersion = r0
            int r0 = r1 + 5
            com.cardinalcommerce.a.getProxyAddress r0 = r9.Cardinal((int) r0)
            com.cardinalcommerce.a.DSASigner$dsaSha3_224 r0 = com.cardinalcommerce.p060a.DSASigner.dsaSha3_224.getInstance(r0)
            r8.values = r0
            int r1 = r1 + 6
            com.cardinalcommerce.a.getProxyAddress r0 = r9.Cardinal((int) r1)
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo.init(r0)
            r8.getWarnings = r0
            int r0 = r9.getInstance()
            int r0 = r0 - r1
            int r0 = r0 - r3
            if (r0 == 0) goto L_0x00f5
            if (r2 != 0) goto L_0x00ed
            goto L_0x00f5
        L_0x00ed:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version 1 certificate contains extra data"
            r9.<init>(r0)
            throw r9
        L_0x00f5:
            if (r0 <= 0) goto L_0x014d
            int r2 = r1 + r0
            com.cardinalcommerce.a.getProxyAddress r2 = r9.Cardinal((int) r2)
            com.cardinalcommerce.a.getType r2 = (com.cardinalcommerce.p060a.getType) r2
            int r6 = r2.Cardinal
            if (r6 == r3) goto L_0x0144
            r7 = 2
            if (r6 == r7) goto L_0x013d
            r7 = 3
            if (r6 != r7) goto L_0x0127
            if (r5 != 0) goto L_0x011f
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r2 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.configure(r2, r3)
            if (r2 == 0) goto L_0x011b
            com.cardinalcommerce.a.GMCipherSpi$SM2withSha224 r6 = new com.cardinalcommerce.a.GMCipherSpi$SM2withSha224
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r2 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r2)
            r6.<init>(r2)
            goto L_0x011c
        L_0x011b:
            r6 = r4
        L_0x011c:
            r8.CardinalUiType = r6
            goto L_0x014a
        L_0x011f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version 2 certificate cannot contain extensions"
            r9.<init>(r0)
            throw r9
        L_0x0127:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown tag encountered in structure: "
            r0.<init>(r1)
            int r1 = r2.Cardinal
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x013d:
            com.cardinalcommerce.a.PrivateKeyInfo r2 = com.cardinalcommerce.p060a.PrivateKeyInfo.getInstance(r2)
            r8.CardinalError = r2
            goto L_0x014a
        L_0x0144:
            com.cardinalcommerce.a.PrivateKeyInfo r2 = com.cardinalcommerce.p060a.PrivateKeyInfo.getInstance(r2)
            r8.cleanup = r2
        L_0x014a:
            int r0 = r0 + -1
            goto L_0x00f5
        L_0x014d:
            return
        L_0x014e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version number not recognised"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.GMSignatureSpi.<init>(com.cardinalcommerce.a.setThreeDSRequestorAppURL):void");
    }
}
