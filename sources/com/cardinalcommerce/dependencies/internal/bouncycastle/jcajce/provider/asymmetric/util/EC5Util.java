package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.BCECGOST3410_2012PublicKey;
import com.cardinalcommerce.p060a.BCRSAPublicKey;
import com.cardinalcommerce.p060a.Base64URL;
import com.cardinalcommerce.p060a.ChallengeParameters;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.EncryptedJWT;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.NHKeyFactorySpi;
import com.cardinalcommerce.p060a.getDeviceData;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.setAccessibilityPaneTitle;
import com.cardinalcommerce.p060a.setContentCaptureSession;
import com.cardinalcommerce.p060a.setContentDescription;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class EC5Util {

    /* renamed from: a */
    private static Map f3218a = new HashMap();

    public static getSDKAppID Cardinal(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            getSDKAppID.C2008init init = new getSDKAppID.C2008init(((ECFieldFp) field).getP(), a, b);
            return f3218a.containsKey(init) ? (getSDKAppID) f3218a.get(init) : init;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] a2 = ECUtil.m2208a(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new getSDKAppID.cca_continue(m, a2[0], a2[1], a2[2], a, b);
    }

    /* renamed from: a */
    private static ECField m2206a(setAccessibilityPaneTitle setaccessibilitypanetitle) {
        if (getDeviceData.init(setaccessibilitypanetitle)) {
            return new ECFieldFp(setaccessibilitypanetitle.Cardinal());
        }
        setContentDescription configure = ((setContentCaptureSession) setaccessibilitypanetitle).configure();
        int[] cca_continue = configure.cca_continue();
        return new ECFieldF2m(configure.configure(), setForegroundTintBlendMode.init(setForegroundTintBlendMode.getInstance(cca_continue, cca_continue.length - 1)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.cardinalcommerce.a.KeyAgreementSpi$DH} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.p060a.getSDKAppID getInstance(com.cardinalcommerce.p060a.NHKeyFactorySpi r2, com.cardinalcommerce.p060a.KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo r3) {
        /*
            java.util.Set r0 = r2.configure()
            boolean r1 = r3.Cardinal()
            if (r1 == 0) goto L_0x0039
            com.cardinalcommerce.a.setLocationDataConsentGiven r3 = r3.configure
            com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier r3 = com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r3)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0025
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x001d
            goto L_0x0025
        L_0x001d:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "named curve not acceptable"
            r2.<init>(r3)
            throw r2
        L_0x0025:
            com.cardinalcommerce.a.KeyAgreementSpi$DH r0 = com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.init((com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier) r3)
            if (r0 != 0) goto L_0x0036
            java.util.Map r2 = r2.Cardinal()
            java.lang.Object r2 = r2.get(r3)
            r0 = r2
            com.cardinalcommerce.a.KeyAgreementSpi$DH r0 = (com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH) r0
        L_0x0036:
            com.cardinalcommerce.a.getSDKAppID r2 = r0.cca_continue
            goto L_0x0054
        L_0x0039:
            boolean r1 = r3.cca_continue()
            if (r1 == 0) goto L_0x0046
            com.cardinalcommerce.a.Container r2 = r2.cca_continue()
            com.cardinalcommerce.a.getSDKAppID r2 = r2.init
            goto L_0x0054
        L_0x0046:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0055
            com.cardinalcommerce.a.setLocationDataConsentGiven r2 = r3.configure
            com.cardinalcommerce.a.KeyAgreementSpi$DH r2 = com.cardinalcommerce.p060a.KeyAgreementSpi.C1970DH.configure(r2)
            com.cardinalcommerce.a.getSDKAppID r2 = r2.cca_continue
        L_0x0054:
            return r2
        L_0x0055:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "encoded parameters not acceptable"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getInstance(com.cardinalcommerce.a.NHKeyFactorySpi, com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo):com.cardinalcommerce.a.getSDKAppID");
    }

    public static BCRSAPublicKey Cardinal(NHKeyFactorySpi nHKeyFactorySpi, ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec != null) {
            return ECUtil.getInstance(nHKeyFactorySpi, cca_continue(eCParameterSpec));
        }
        Container cca_continue = nHKeyFactorySpi.cca_continue();
        return new BCRSAPublicKey(cca_continue.init, cca_continue.Cardinal, cca_continue.getInstance, cca_continue.cca_continue, cca_continue.getInstance());
    }

    public static ECParameterSpec init(KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo cDHwithSHA512KDFAndSharedInfo, getSDKAppID getsdkappid) {
        ECParameterSpec eCParameterSpec;
        if (cDHwithSHA512KDFAndSharedInfo.Cardinal()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) cDHwithSHA512KDFAndSharedInfo.configure;
            KeyAgreementSpi.C1970DH init = ECUtil.init(aSN1ObjectIdentifier);
            if (init == null) {
                Map Cardinal = JWK.getInstance.Cardinal();
                if (!Cardinal.isEmpty()) {
                    init = (KeyAgreementSpi.C1970DH) Cardinal.get(aSN1ObjectIdentifier);
                }
            }
            init.init();
            EllipticCurve instance = getInstance(getsdkappid);
            String instance2 = ECUtil.getInstance(aSN1ObjectIdentifier);
            ChallengeParameters CardinalRenderType = init.getInstance.cca_continue().CardinalRenderType();
            BigInteger Cardinal2 = CardinalRenderType.getSDKVersion().Cardinal();
            if (CardinalRenderType.CardinalEnvironment()) {
                return new Base64URL(instance2, instance, new ECPoint(Cardinal2, CardinalRenderType.CardinalError().Cardinal()), init.Cardinal, init.init);
            }
            throw new IllegalStateException("point not in normal form");
        } else if (cDHwithSHA512KDFAndSharedInfo.cca_continue()) {
            return null;
        } else {
            KeyAgreementSpi.C1970DH configure = KeyAgreementSpi.C1970DH.configure(cDHwithSHA512KDFAndSharedInfo.configure);
            configure.init();
            EllipticCurve instance3 = getInstance(getsdkappid);
            if (configure.init != null) {
                ChallengeParameters CardinalRenderType2 = configure.getInstance.cca_continue().CardinalRenderType();
                BigInteger Cardinal3 = CardinalRenderType2.getSDKVersion().Cardinal();
                if (CardinalRenderType2.CardinalEnvironment()) {
                    eCParameterSpec = new ECParameterSpec(instance3, new ECPoint(Cardinal3, CardinalRenderType2.CardinalError().Cardinal()), configure.Cardinal, configure.init.intValue());
                } else {
                    throw new IllegalStateException("point not in normal form");
                }
            } else {
                ChallengeParameters CardinalRenderType3 = configure.getInstance.cca_continue().CardinalRenderType();
                BigInteger Cardinal4 = CardinalRenderType3.getSDKVersion().Cardinal();
                if (CardinalRenderType3.CardinalEnvironment()) {
                    eCParameterSpec = new ECParameterSpec(instance3, new ECPoint(Cardinal4, CardinalRenderType3.CardinalError().Cardinal()), configure.Cardinal, 1);
                } else {
                    throw new IllegalStateException("point not in normal form");
                }
            }
            return eCParameterSpec;
        }
    }

    public static ECParameterSpec cca_continue(KeyAgreementSpi.C1970DH dh) {
        EllipticCurve instance = getInstance(dh.cca_continue);
        ChallengeParameters CardinalRenderType = dh.getInstance.cca_continue().CardinalRenderType();
        BigInteger Cardinal = CardinalRenderType.getSDKVersion().Cardinal();
        if (CardinalRenderType.CardinalEnvironment()) {
            return new ECParameterSpec(instance, new ECPoint(Cardinal, CardinalRenderType.CardinalError().Cardinal()), dh.Cardinal, dh.init.intValue());
        }
        throw new IllegalStateException("point not in normal form");
    }

    public static EllipticCurve getInstance(getSDKAppID getsdkappid) {
        return new EllipticCurve(m2206a(getsdkappid.configure), getsdkappid.cleanup().Cardinal(), getsdkappid.getWarnings().Cardinal(), (byte[]) null);
    }

    public static ECParameterSpec Cardinal(EllipticCurve ellipticCurve, Container container) {
        if (container instanceof EncryptedJWT) {
            String str = ((EncryptedJWT) container).configure;
            ChallengeParameters CardinalRenderType = container.Cardinal.CardinalRenderType();
            BigInteger Cardinal = CardinalRenderType.getSDKVersion().Cardinal();
            if (CardinalRenderType.CardinalEnvironment()) {
                return new Base64URL(str, ellipticCurve, new ECPoint(Cardinal, CardinalRenderType.CardinalError().Cardinal()), container.getInstance, container.cca_continue);
            }
            throw new IllegalStateException("point not in normal form");
        }
        ChallengeParameters CardinalRenderType2 = container.Cardinal.CardinalRenderType();
        BigInteger Cardinal2 = CardinalRenderType2.getSDKVersion().Cardinal();
        if (CardinalRenderType2.CardinalEnvironment()) {
            return new ECParameterSpec(ellipticCurve, new ECPoint(Cardinal2, CardinalRenderType2.CardinalError().Cardinal()), container.getInstance, container.cca_continue.intValue());
        }
        throw new IllegalStateException("point not in normal form");
    }

    public static Container cca_continue(ECParameterSpec eCParameterSpec) {
        getSDKAppID Cardinal = Cardinal(eCParameterSpec.getCurve());
        if (eCParameterSpec instanceof Base64URL) {
            String str = ((Base64URL) eCParameterSpec).getInstance;
            ECPoint generator = eCParameterSpec.getGenerator();
            return new EncryptedJWT(str, Cardinal, Cardinal.Cardinal(generator.getAffineX(), generator.getAffineY(), false), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
        }
        ECPoint generator2 = eCParameterSpec.getGenerator();
        return new Container(Cardinal, Cardinal.Cardinal(generator2.getAffineX(), generator2.getAffineY(), false), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static ChallengeParameters configure(ECParameterSpec eCParameterSpec, ECPoint eCPoint) {
        return Cardinal(eCParameterSpec.getCurve()).Cardinal(eCPoint.getAffineX(), eCPoint.getAffineY(), false);
    }

    public static ChallengeParameters init(getSDKAppID getsdkappid, ECPoint eCPoint) {
        return getsdkappid.Cardinal(eCPoint.getAffineX(), eCPoint.getAffineY(), false);
    }

    public static ECPoint init(ChallengeParameters challengeParameters) {
        ChallengeParameters CardinalRenderType = challengeParameters.CardinalRenderType();
        BigInteger Cardinal = CardinalRenderType.getSDKVersion().Cardinal();
        if (CardinalRenderType.CardinalEnvironment()) {
            return new ECPoint(Cardinal, CardinalRenderType.CardinalError().Cardinal());
        }
        throw new IllegalStateException("point not in normal form");
    }

    static {
        Enumeration cca_continue = BCECGOST3410_2012PublicKey.cca_continue();
        while (cca_continue.hasMoreElements()) {
            String str = (String) cca_continue.nextElement();
            KeyAgreementSpi.C1970DH configure = IESCipher.ECIESwithCipher.configure(str);
            if (configure != null) {
                f3218a.put(configure.cca_continue, BCECGOST3410_2012PublicKey.init(str).cca_continue);
            }
        }
        getSDKAppID getsdkappid = BCECGOST3410_2012PublicKey.init("Curve25519").cca_continue;
        f3218a.put(new getSDKAppID.C2008init(getsdkappid.configure.Cardinal(), getsdkappid.cleanup().Cardinal(), getsdkappid.getWarnings().Cardinal(), getsdkappid.values(), getsdkappid.CardinalError()), getsdkappid);
    }
}
