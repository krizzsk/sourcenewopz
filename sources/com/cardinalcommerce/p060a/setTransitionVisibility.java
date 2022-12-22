package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;

/* renamed from: com.cardinalcommerce.a.setTransitionVisibility */
public final class setTransitionVisibility implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public BCElGamalPublicKey Cardinal;
    public CipherSpi.PKCS1v1_5Padding cca_continue;
    public BCElGamalPublicKey init;

    public setTransitionVisibility() {
    }

    private static short[] cca_continue(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i != length; i++) {
            sArr[i] = setMinimumWidth.init(bArr, i << 1);
        }
        return sArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.cardinalcommerce.a.setHapticFeedbackEnabled} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.cardinalcommerce.a.setHapticFeedbackEnabled} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: com.cardinalcommerce.a.setSoundEffectsEnabled} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.p060a.setKeyboardNavigationCluster cca_continue(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo r8) throws java.io.IOException {
        /*
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r8.cca_continue
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r0.init
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHUwithSHA384KDF.setUiType
            boolean r1 = r0.cca_continue((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r1)
            if (r1 == 0) goto L_0x002a
            com.cardinalcommerce.a.isEnableDFSync r0 = r8.init
            byte[] r0 = r0.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r0 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r0)
            com.cardinalcommerce.a.isEnableDFSync r0 = com.cardinalcommerce.p060a.isEnableDFSync.init(r0)
            com.cardinalcommerce.a.setSaveEnabled r1 = new com.cardinalcommerce.a.setSaveEnabled
            com.cardinalcommerce.a.DSASigner$stdDSA r8 = r8.cca_continue
            int r8 = com.cardinalcommerce.p060a.setScrollY.m2087a((com.cardinalcommerce.p060a.DSASigner.stdDSA) r8)
            byte[] r0 = r0.cca_continue()
            r1.<init>(r8, r0)
            return r1
        L_0x002a:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHUwithSHA384KDF.getSDKVersion
            boolean r1 = r0.equals(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0066
            com.cardinalcommerce.a.setFocusedByDefault r0 = new com.cardinalcommerce.a.setFocusedByDefault
            com.cardinalcommerce.a.isEnableDFSync r1 = r8.init
            byte[] r1 = r1.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r1 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r1)
            com.cardinalcommerce.a.isEnableDFSync r1 = com.cardinalcommerce.p060a.isEnableDFSync.init(r1)
            byte[] r1 = r1.cca_continue()
            com.cardinalcommerce.a.DSASigner$stdDSA r8 = r8.cca_continue
            com.cardinalcommerce.a.getProxyAddress r8 = r8.cca_continue
            boolean r3 = r8 instanceof com.cardinalcommerce.p060a.setSoundEffectsEnabled
            if (r3 == 0) goto L_0x0053
            r2 = r8
            com.cardinalcommerce.a.setSoundEffectsEnabled r2 = (com.cardinalcommerce.p060a.setSoundEffectsEnabled) r2
            goto L_0x005e
        L_0x0053:
            if (r8 == 0) goto L_0x005e
            com.cardinalcommerce.a.setSoundEffectsEnabled r2 = new com.cardinalcommerce.a.setSoundEffectsEnabled
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r8 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r8)
            r2.<init>((com.cardinalcommerce.p060a.setThreeDSRequestorAppURL) r8)
        L_0x005e:
            java.lang.String r8 = com.cardinalcommerce.p060a.setScrollY.m2089a((com.cardinalcommerce.p060a.setSoundEffectsEnabled) r2)
            r0.<init>(r1, r8)
            return r0
        L_0x0066:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHUwithSHA384KDF.setThreeDSRequestorAppURL
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x008a
            com.cardinalcommerce.a.setFilterTouchesWhenObscured r0 = new com.cardinalcommerce.a.setFilterTouchesWhenObscured
            com.cardinalcommerce.a.isEnableDFSync r8 = r8.init
            byte[] r8 = r8.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r8 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r8)
            com.cardinalcommerce.a.isEnableDFSync r8 = com.cardinalcommerce.p060a.isEnableDFSync.init(r8)
            byte[] r8 = r8.cca_continue()
            short[] r8 = cca_continue((byte[]) r8)
            r0.<init>(r8)
            return r0
        L_0x008a:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.cardinalcommerce.p060a.KeyAgreementSpi.DHUwithSHA384KDF.valueOf
            boolean r1 = r0.equals(r1)
            r3 = 0
            java.lang.String r4 = "ClassNotFoundException processing BDS state: "
            if (r1 == 0) goto L_0x013d
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r8.cca_continue
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.setHasTransientState
            if (r1 == 0) goto L_0x00a0
            com.cardinalcommerce.a.setHasTransientState r0 = (com.cardinalcommerce.p060a.setHasTransientState) r0
            goto L_0x00ae
        L_0x00a0:
            if (r0 == 0) goto L_0x00ad
            com.cardinalcommerce.a.setHasTransientState r1 = new com.cardinalcommerce.a.setHasTransientState
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r0 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r0)
            r1.<init>(r0)
            r0 = r1
            goto L_0x00ae
        L_0x00ad:
            r0 = r2
        L_0x00ae:
            com.cardinalcommerce.a.DSASigner$stdDSA r1 = r0.getInstance
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r1.init
            com.cardinalcommerce.a.isEnableDFSync r8 = r8.init
            byte[] r8 = r8.cca_continue()
            com.cardinalcommerce.a.setLocationDataConsentGiven r8 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r8)
            if (r8 == 0) goto L_0x00c7
            com.cardinalcommerce.a.setHapticFeedbackEnabled r2 = new com.cardinalcommerce.a.setHapticFeedbackEnabled
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r8 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r8)
            r2.<init>(r8)
        L_0x00c7:
            com.cardinalcommerce.a.setTranslationZ$getInstance r8 = new com.cardinalcommerce.a.setTranslationZ$getInstance     // Catch:{ ClassNotFoundException -> 0x0126 }
            com.cardinalcommerce.a.setStateListAnimator r5 = new com.cardinalcommerce.a.setStateListAnimator     // Catch:{ ClassNotFoundException -> 0x0126 }
            int r0 = r0.configure     // Catch:{ ClassNotFoundException -> 0x0126 }
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo r6 = com.cardinalcommerce.p060a.setScrollY.m2088a((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r1)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r5.<init>(r0, r6)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r8.<init>(r5)     // Catch:{ ClassNotFoundException -> 0x0126 }
            int r0 = r2.init     // Catch:{ ClassNotFoundException -> 0x0126 }
            r8.configure = r0     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = r2.init()     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r8.Cardinal = r0     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = r2.getInstance()     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r8.cca_continue = r0     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = r2.configure()     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r8.getInstance = r0     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = r2.Cardinal()     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r8.getWarnings = r0     // Catch:{ ClassNotFoundException -> 0x0126 }
            byte[] r0 = r2.cca_continue()     // Catch:{ ClassNotFoundException -> 0x0126 }
            if (r0 == 0) goto L_0x0120
            byte[] r0 = r2.cca_continue()     // Catch:{ ClassNotFoundException -> 0x0126 }
            java.lang.Class<com.cardinalcommerce.a.setTouchDelegate> r2 = com.cardinalcommerce.p060a.setTouchDelegate.class
            java.lang.Object r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.Cardinal((byte[]) r0, (java.lang.Class) r2)     // Catch:{ ClassNotFoundException -> 0x0126 }
            com.cardinalcommerce.a.setTouchDelegate r0 = (com.cardinalcommerce.p060a.setTouchDelegate) r0     // Catch:{ ClassNotFoundException -> 0x0126 }
            com.cardinalcommerce.a.setTouchDelegate r2 = new com.cardinalcommerce.a.setTouchDelegate     // Catch:{ ClassNotFoundException -> 0x0126 }
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo r1 = com.cardinalcommerce.p060a.setCameraDistance.Cardinal(r1)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r2.<init>((com.cardinalcommerce.p060a.setTouchDelegate) r0, (com.cardinalcommerce.p060a.KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo) r1)     // Catch:{ ClassNotFoundException -> 0x0126 }
            r8.cleanup = r2     // Catch:{ ClassNotFoundException -> 0x0126 }
        L_0x0120:
            com.cardinalcommerce.a.setTranslationZ r0 = new com.cardinalcommerce.a.setTranslationZ     // Catch:{ ClassNotFoundException -> 0x0126 }
            r0.<init>(r8, r3)     // Catch:{ ClassNotFoundException -> 0x0126 }
            return r0
        L_0x0126:
            r8 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r8 = r8.getMessage()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x013d:
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers.getWarnings
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01eb
            com.cardinalcommerce.a.DSASigner$stdDSA r0 = r8.cca_continue
            com.cardinalcommerce.a.getProxyAddress r0 = r0.cca_continue
            boolean r1 = r0 instanceof com.cardinalcommerce.p060a.setWillNotCacheDrawing
            if (r1 == 0) goto L_0x0150
            com.cardinalcommerce.a.setWillNotCacheDrawing r0 = (com.cardinalcommerce.p060a.setWillNotCacheDrawing) r0
            goto L_0x015e
        L_0x0150:
            if (r0 == 0) goto L_0x015d
            com.cardinalcommerce.a.setWillNotCacheDrawing r1 = new com.cardinalcommerce.a.setWillNotCacheDrawing
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r0 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r0)
            r1.<init>(r0)
            r0 = r1
            goto L_0x015e
        L_0x015d:
            r0 = r2
        L_0x015e:
            com.cardinalcommerce.a.DSASigner$stdDSA r1 = r0.Cardinal
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r1.init
            com.cardinalcommerce.a.isEnableDFSync r8 = r8.init     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r8 = r8.cca_continue()     // Catch:{ ClassNotFoundException -> 0x01d4 }
            com.cardinalcommerce.a.setLocationDataConsentGiven r8 = com.cardinalcommerce.p060a.setLocationDataConsentGiven.getInstance(r8)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            if (r8 == 0) goto L_0x0177
            com.cardinalcommerce.a.setHapticFeedbackEnabled r2 = new com.cardinalcommerce.a.setHapticFeedbackEnabled     // Catch:{ ClassNotFoundException -> 0x01d4 }
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r8 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r8)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r2.<init>(r8)     // Catch:{ ClassNotFoundException -> 0x01d4 }
        L_0x0177:
            com.cardinalcommerce.a.setTranslationX$getInstance r8 = new com.cardinalcommerce.a.setTranslationX$getInstance     // Catch:{ ClassNotFoundException -> 0x01d4 }
            com.cardinalcommerce.a.setTranslationY r5 = new com.cardinalcommerce.a.setTranslationY     // Catch:{ ClassNotFoundException -> 0x01d4 }
            int r6 = r0.cca_continue     // Catch:{ ClassNotFoundException -> 0x01d4 }
            int r0 = r0.configure     // Catch:{ ClassNotFoundException -> 0x01d4 }
            com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo r7 = com.cardinalcommerce.p060a.setScrollY.m2088a((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r1)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r5.<init>(r6, r0, r7)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r8.<init>(r5)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            int r0 = r2.init     // Catch:{ ClassNotFoundException -> 0x01d4 }
            long r5 = (long) r0     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r8.init = r5     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = r2.init()     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r8.getInstance = r0     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = r2.getInstance()     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r8.cca_continue = r0     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = r2.configure()     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r8.Cardinal = r0     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = r2.Cardinal()     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.cca_continue((byte[]) r0)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r8.values = r0     // Catch:{ ClassNotFoundException -> 0x01d4 }
            byte[] r0 = r2.cca_continue()     // Catch:{ ClassNotFoundException -> 0x01d4 }
            if (r0 == 0) goto L_0x01ce
            byte[] r0 = r2.cca_continue()     // Catch:{ ClassNotFoundException -> 0x01d4 }
            java.lang.Class<com.cardinalcommerce.a.setRotationX> r2 = com.cardinalcommerce.p060a.setRotationX.class
            java.lang.Object r0 = com.cardinalcommerce.p060a.setVerticalFadingEdgeEnabled.Cardinal((byte[]) r0, (java.lang.Class) r2)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            com.cardinalcommerce.a.setRotationX r0 = (com.cardinalcommerce.p060a.setRotationX) r0     // Catch:{ ClassNotFoundException -> 0x01d4 }
            com.cardinalcommerce.a.setRotationX r0 = r0.cca_continue(r1)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r8.getSDKVersion = r0     // Catch:{ ClassNotFoundException -> 0x01d4 }
        L_0x01ce:
            com.cardinalcommerce.a.setTranslationX r0 = new com.cardinalcommerce.a.setTranslationX     // Catch:{ ClassNotFoundException -> 0x01d4 }
            r0.<init>(r8, r3)     // Catch:{ ClassNotFoundException -> 0x01d4 }
            return r0
        L_0x01d4:
            r8 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r8 = r8.getMessage()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x01eb:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "algorithm identifier in private key not recognised"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTransitionVisibility.cca_continue(com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo):com.cardinalcommerce.a.setKeyboardNavigationCluster");
    }

    public setTransitionVisibility(BCElGamalPublicKey bCElGamalPublicKey, BCElGamalPublicKey bCElGamalPublicKey2) {
        this(bCElGamalPublicKey, bCElGamalPublicKey2, (CipherSpi.PKCS1v1_5Padding) null);
    }

    private setTransitionVisibility(BCElGamalPublicKey bCElGamalPublicKey, BCElGamalPublicKey bCElGamalPublicKey2, CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding) {
        if (bCElGamalPublicKey == null) {
            throw new NullPointerException("staticPrivateKey cannot be null");
        } else if (bCElGamalPublicKey2 != null) {
            CipherSpi cipherSpi = bCElGamalPublicKey.configure;
            if (cipherSpi.equals(bCElGamalPublicKey2.configure)) {
                CipherSpi.PKCS1v1_5Padding pKCS1v1_5Padding2 = new CipherSpi.PKCS1v1_5Padding(cipherSpi.configure.multiply(bCElGamalPublicKey2.Cardinal), cipherSpi);
                this.init = bCElGamalPublicKey;
                this.Cardinal = bCElGamalPublicKey2;
                this.cca_continue = pKCS1v1_5Padding2;
                return;
            }
            throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
        } else {
            throw new NullPointerException("ephemeralPrivateKey cannot be null");
        }
    }
}
