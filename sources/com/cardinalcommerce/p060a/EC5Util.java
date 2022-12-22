package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.EC5Util */
public final class EC5Util {

    /* renamed from: a */
    private static byte[] f2399a = setAnimation.configure("openssh-key-v1\u0000");

    /* renamed from: a */
    private static boolean m1802a(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        for (int i = 0; i < setthreedsrequestorappurl.getInstance(); i++) {
            if (!(setthreedsrequestorappurl.Cardinal(i) instanceof setProxyAddress)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] Cardinal(setKeyboardNavigationCluster setkeyboardnavigationcluster) throws IOException {
        if (setkeyboardnavigationcluster instanceof PSSSignatureSpi.SHA224withRSA) {
            return setLocationDataConsentGiven.getInstance(DSAEncoder.configure(setkeyboardnavigationcluster).init.cca_continue()).values().getEncoded();
        }
        if (setkeyboardnavigationcluster instanceof DigestSignatureSpi.MD2) {
            return setLocationDataConsentGiven.getInstance(DSAEncoder.configure(setkeyboardnavigationcluster).init.cca_continue()).values().getEncoded();
        }
        if (setkeyboardnavigationcluster instanceof AlgorithmParametersSpi.PSS) {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(0));
            AlgorithmParametersSpi.PSS pss = (AlgorithmParametersSpi.PSS) setkeyboardnavigationcluster;
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(pss.Cardinal.init));
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(pss.Cardinal.getInstance));
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(pss.Cardinal.cca_continue));
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(pss.Cardinal.cca_continue.modPow(pss.init, pss.Cardinal.init)));
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(pss.init));
            try {
                return new GOST(setforegroundtintblendmode).getEncoded();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("unable to encode DSAPrivateKeyParameters ");
                sb.append(e.getMessage());
                throw new IllegalStateException(sb.toString());
            }
        } else if (setkeyboardnavigationcluster instanceof DigestSignatureSpi.MD5) {
            PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl = new PKCS12BagAttributeCarrierImpl();
            try {
                pKCS12BagAttributeCarrierImpl.configure.write(f2399a);
                byte[] configure = setAnimation.configure("none");
                pKCS12BagAttributeCarrierImpl.init((long) configure.length);
                try {
                    pKCS12BagAttributeCarrierImpl.configure.write(configure);
                    byte[] configure2 = setAnimation.configure("none");
                    pKCS12BagAttributeCarrierImpl.init((long) configure2.length);
                    try {
                        pKCS12BagAttributeCarrierImpl.configure.write(configure2);
                        pKCS12BagAttributeCarrierImpl.init(0);
                        pKCS12BagAttributeCarrierImpl.init(1);
                        DigestSignatureSpi.MD5 md5 = (DigestSignatureSpi.MD5) setkeyboardnavigationcluster;
                        byte[] bArr = new byte[32];
                        setImportantForAutofill.cca_continue(md5.Cardinal, bArr);
                        byte[] configure3 = DSASigner.dsaSha3_384.configure((setKeyboardNavigationCluster) new DigestSignatureSpi.RIPEMD256(bArr, 0));
                        pKCS12BagAttributeCarrierImpl.init((long) configure3.length);
                        try {
                            pKCS12BagAttributeCarrierImpl.configure.write(configure3);
                            PKCS12BagAttributeCarrierImpl pKCS12BagAttributeCarrierImpl2 = new PKCS12BagAttributeCarrierImpl();
                            pKCS12BagAttributeCarrierImpl2.init(16711935);
                            pKCS12BagAttributeCarrierImpl2.init(16711935);
                            byte[] configure4 = setAnimation.configure("ssh-ed25519");
                            pKCS12BagAttributeCarrierImpl2.init((long) configure4.length);
                            try {
                                pKCS12BagAttributeCarrierImpl2.configure.write(configure4);
                                byte[] bArr2 = new byte[32];
                                setImportantForAutofill.cca_continue(md5.Cardinal, bArr2);
                                byte[] encoded = new DigestSignatureSpi.RIPEMD256(bArr2, 0).getEncoded();
                                pKCS12BagAttributeCarrierImpl2.init((long) encoded.length);
                                try {
                                    pKCS12BagAttributeCarrierImpl2.configure.write(encoded);
                                    byte[] cca_continue = setForegroundTintBlendMode.cca_continue(md5.getEncoded(), encoded);
                                    pKCS12BagAttributeCarrierImpl2.init((long) cca_continue.length);
                                    try {
                                        pKCS12BagAttributeCarrierImpl2.configure.write(cca_continue);
                                        pKCS12BagAttributeCarrierImpl2.init(0);
                                        byte[] Cardinal = pKCS12BagAttributeCarrierImpl2.Cardinal();
                                        pKCS12BagAttributeCarrierImpl.init((long) Cardinal.length);
                                        try {
                                            pKCS12BagAttributeCarrierImpl.configure.write(Cardinal);
                                            return pKCS12BagAttributeCarrierImpl.Cardinal();
                                        } catch (IOException e2) {
                                            throw new IllegalStateException(e2.getMessage(), e2);
                                        }
                                    } catch (IOException e3) {
                                        throw new IllegalStateException(e3.getMessage(), e3);
                                    }
                                } catch (IOException e4) {
                                    throw new IllegalStateException(e4.getMessage(), e4);
                                }
                            } catch (IOException e5) {
                                throw new IllegalStateException(e5.getMessage(), e5);
                            }
                        } catch (IOException e6) {
                            throw new IllegalStateException(e6.getMessage(), e6);
                        }
                    } catch (IOException e7) {
                        throw new IllegalStateException(e7.getMessage(), e7);
                    }
                } catch (IOException e8) {
                    throw new IllegalStateException(e8.getMessage(), e8);
                }
            } catch (IOException e9) {
                throw new IllegalStateException(e9.getMessage(), e9);
            }
        } else {
            StringBuilder sb2 = new StringBuilder("unable to convert ");
            sb2.append(setkeyboardnavigationcluster.getClass().getName());
            sb2.append(" to openssh private key");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.cardinalcommerce.a.DigestSignatureSpi$MD5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.cardinalcommerce.a.DSASigner$detDSASha3_256} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.cardinalcommerce.a.DSASigner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: com.cardinalcommerce.a.AlgorithmParametersSpi$PSS} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.p060a.setKeyboardNavigationCluster Cardinal(byte[] r15) {
        /*
            r0 = 0
            byte r1 = r15[r0]
            r2 = 48
            if (r1 != r2) goto L_0x0114
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r15 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r15)
            int r1 = r15.getInstance()
            r2 = 6
            r3 = 2
            r4 = 3
            r5 = 0
            r6 = 1
            if (r1 != r2) goto L_0x0072
            boolean r1 = m1802a(r15)
            if (r1 == 0) goto L_0x0112
            com.cardinalcommerce.a.getProxyAddress r0 = r15.Cardinal((int) r0)
            com.cardinalcommerce.a.setProxyAddress r0 = (com.cardinalcommerce.p060a.setProxyAddress) r0
            java.math.BigInteger r1 = new java.math.BigInteger
            byte[] r0 = r0.Cardinal
            r1.<init>(r6, r0)
            java.math.BigInteger r0 = com.cardinalcommerce.p060a.setSelected.getInstance
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0112
            com.cardinalcommerce.a.AlgorithmParametersSpi$PSS r0 = new com.cardinalcommerce.a.AlgorithmParametersSpi$PSS
            r1 = 5
            com.cardinalcommerce.a.getProxyAddress r1 = r15.Cardinal((int) r1)
            com.cardinalcommerce.a.setProxyAddress r1 = (com.cardinalcommerce.p060a.setProxyAddress) r1
            java.math.BigInteger r2 = new java.math.BigInteger
            byte[] r1 = r1.Cardinal
            r2.<init>(r6, r1)
            com.cardinalcommerce.a.BCGOST3410PublicKey r1 = new com.cardinalcommerce.a.BCGOST3410PublicKey
            com.cardinalcommerce.a.getProxyAddress r5 = r15.Cardinal((int) r6)
            com.cardinalcommerce.a.setProxyAddress r5 = (com.cardinalcommerce.p060a.setProxyAddress) r5
            java.math.BigInteger r7 = new java.math.BigInteger
            byte[] r5 = r5.Cardinal
            r7.<init>(r6, r5)
            com.cardinalcommerce.a.getProxyAddress r3 = r15.Cardinal((int) r3)
            com.cardinalcommerce.a.setProxyAddress r3 = (com.cardinalcommerce.p060a.setProxyAddress) r3
            java.math.BigInteger r5 = new java.math.BigInteger
            byte[] r3 = r3.Cardinal
            r5.<init>(r6, r3)
            com.cardinalcommerce.a.getProxyAddress r15 = r15.Cardinal((int) r4)
            com.cardinalcommerce.a.setProxyAddress r15 = (com.cardinalcommerce.p060a.setProxyAddress) r15
            java.math.BigInteger r3 = new java.math.BigInteger
            byte[] r15 = r15.Cardinal
            r3.<init>(r6, r15)
            r1.<init>(r7, r5, r3)
            r0.<init>(r2, r1)
            goto L_0x0175
        L_0x0072:
            int r1 = r15.getInstance()
            r2 = 9
            if (r1 != r2) goto L_0x00b8
            boolean r1 = m1802a(r15)
            if (r1 == 0) goto L_0x0112
            com.cardinalcommerce.a.getProxyAddress r0 = r15.Cardinal((int) r0)
            com.cardinalcommerce.a.setProxyAddress r0 = (com.cardinalcommerce.p060a.setProxyAddress) r0
            java.math.BigInteger r1 = new java.math.BigInteger
            byte[] r0 = r0.Cardinal
            r1.<init>(r6, r0)
            java.math.BigInteger r0 = com.cardinalcommerce.p060a.setSelected.getInstance
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0112
            if (r15 == 0) goto L_0x00a0
            com.cardinalcommerce.a.DSASigner r5 = new com.cardinalcommerce.a.DSASigner
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r15 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r15)
            r5.<init>(r15)
        L_0x00a0:
            com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA r0 = new com.cardinalcommerce.a.PSSSignatureSpi$SHA224withRSA
            java.math.BigInteger r7 = r5.cca_continue
            java.math.BigInteger r8 = r5.configure
            java.math.BigInteger r9 = r5.getInstance
            java.math.BigInteger r10 = r5.init
            java.math.BigInteger r11 = r5.Cardinal
            java.math.BigInteger r12 = r5.cleanup
            java.math.BigInteger r13 = r5.values
            java.math.BigInteger r14 = r5.CardinalError
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0175
        L_0x00b8:
            int r0 = r15.getInstance()
            r1 = 4
            if (r0 != r1) goto L_0x0112
            com.cardinalcommerce.a.getProxyAddress r0 = r15.Cardinal((int) r4)
            boolean r0 = r0 instanceof com.cardinalcommerce.p060a.RSA
            if (r0 == 0) goto L_0x0112
            com.cardinalcommerce.a.getProxyAddress r0 = r15.Cardinal((int) r3)
            boolean r0 = r0 instanceof com.cardinalcommerce.p060a.RSA
            if (r0 == 0) goto L_0x0112
            if (r15 == 0) goto L_0x00da
            com.cardinalcommerce.a.DSASigner$detDSASha3_256 r5 = new com.cardinalcommerce.a.DSASigner$detDSASha3_256
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r15 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r15)
            r5.<init>(r15)
        L_0x00da:
            com.cardinalcommerce.a.setLocationDataConsentGiven r15 = r5.init()
            r8 = r15
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r8 = (com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r8
            com.cardinalcommerce.a.KeyAgreementSpi$DH r15 = com.cardinalcommerce.p060a.IESCipher.ECIESwithCipher.configure((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r8)
            com.cardinalcommerce.a.DigestSignatureSpi$MD2 r0 = new com.cardinalcommerce.a.DigestSignatureSpi$MD2
            com.cardinalcommerce.a.setThreeDSRequestorAppURL r1 = r5.init
            com.cardinalcommerce.a.getProxyAddress r1 = r1.Cardinal((int) r6)
            com.cardinalcommerce.a.isEnableDFSync r1 = (com.cardinalcommerce.p060a.isEnableDFSync) r1
            java.math.BigInteger r2 = new java.math.BigInteger
            byte[] r1 = r1.cca_continue()
            r2.<init>(r6, r1)
            com.cardinalcommerce.a.CipherSpi$PKCS1v1_5Padding_PublicOnly r1 = new com.cardinalcommerce.a.CipherSpi$PKCS1v1_5Padding_PublicOnly
            com.cardinalcommerce.a.getSDKAppID r9 = r15.cca_continue
            com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo r3 = r15.getInstance
            com.cardinalcommerce.a.ChallengeParameters r10 = r3.cca_continue()
            java.math.BigInteger r11 = r15.Cardinal
            java.math.BigInteger r12 = r15.init
            byte[] r13 = r15.init()
            r7 = r1
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r0.<init>(r2, r1)
            r5 = r0
        L_0x0112:
            r0 = r5
            goto L_0x0175
        L_0x0114:
            com.cardinalcommerce.a.DSABase r1 = new com.cardinalcommerce.a.DSABase
            byte[] r2 = f2399a
            r1.<init>(r2, r15)
            byte[] r15 = r1.configure()
            java.lang.String r15 = com.cardinalcommerce.p060a.setAnimation.cca_continue(r15)
            java.lang.String r2 = "none"
            boolean r15 = r2.equals(r15)
            if (r15 == 0) goto L_0x0199
            r1.configure()
            r1.configure()
            int r15 = r1.Cardinal()
            long r2 = (long) r15
        L_0x0136:
            long r4 = (long) r0
            int r15 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r15 == 0) goto L_0x0145
            byte[] r15 = r1.configure()
            com.cardinalcommerce.p060a.DSASigner.dsaSha3_384.cca_continue((byte[]) r15)
            int r0 = r0 + 1
            goto L_0x0136
        L_0x0145:
            com.cardinalcommerce.a.DSABase r15 = new com.cardinalcommerce.a.DSABase
            byte[] r0 = r1.getInstance()
            r15.<init>(r0)
            int r0 = r15.Cardinal()
            int r1 = r15.Cardinal()
            if (r0 != r1) goto L_0x0191
            byte[] r0 = r15.configure()
            java.lang.String r0 = com.cardinalcommerce.p060a.setAnimation.cca_continue(r0)
            java.lang.String r1 = "ssh-ed25519"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0181
            r15.configure()
            byte[] r15 = r15.configure()
            com.cardinalcommerce.a.DigestSignatureSpi$MD5 r0 = new com.cardinalcommerce.a.DigestSignatureSpi$MD5
            r0.<init>((byte[]) r15)
        L_0x0175:
            if (r0 == 0) goto L_0x0178
            return r0
        L_0x0178:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "unable to parse key"
            r15.<init>(r0)
            throw r15
        L_0x0181:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "can not parse private key of type "
            java.lang.String r0 = r1.concat(r0)
            r15.<init>(r0)
            throw r15
        L_0x0191:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "private key check values are not the same"
            r15.<init>(r0)
            throw r15
        L_0x0199:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "encrypted keys not supported"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.EC5Util.Cardinal(byte[]):com.cardinalcommerce.a.setKeyboardNavigationCluster");
    }
}
