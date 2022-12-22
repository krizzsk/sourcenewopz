package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DSA;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GMSignatureSpi;
import com.cardinalcommerce.p060a.IESCipher;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.SimpleTimeZone;
import java.util.Vector;

/* renamed from: com.cardinalcommerce.a.GMCipherSpi */
public final class GMCipherSpi extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private BigInteger f2437a;

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withSha256 */
    public final class SM2withSha256 extends getThreeDSRequestorAppURL {
        public final SM2withRMD[] cca_continue;

        public SM2withSha256(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.cca_continue = new SM2withRMD[setthreedsrequestorappurl.getInstance()];
            for (int i = 0; i != setthreedsrequestorappurl.getInstance(); i++) {
                this.cca_continue[i] = SM2withRMD.Cardinal(setthreedsrequestorappurl.Cardinal(i));
            }
        }

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            String instance = setAnimation.getInstance();
            stringBuffer.append("GeneralNames:");
            stringBuffer.append(instance);
            for (int i = 0; i != this.cca_continue.length; i++) {
                stringBuffer.append("    ");
                stringBuffer.append(this.cca_continue[i]);
                stringBuffer.append(instance);
            }
            return stringBuffer.toString();
        }

        public final setLocationDataConsentGiven values() {
            return new GOST((getProxyAddress[]) this.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withWhirlpool */
    public final class SM2withWhirlpool extends getThreeDSRequestorAppURL {
        private PrivateKeyInfo cca_continue;

        public SM2withWhirlpool(PrivateKeyInfo privateKeyInfo) {
            this.cca_continue = privateKeyInfo;
        }

        public final String toString() {
            StringBuilder sb;
            byte b;
            byte[] instance = this.cca_continue.getInstance();
            if (instance.length == 1) {
                sb = new StringBuilder("KeyUsage: 0x");
                b = instance[0] & 255;
            } else {
                sb = new StringBuilder("KeyUsage: 0x");
                b = (instance[0] & 255) | ((instance[1] & 255) << 8);
            }
            sb.append(Integer.toHexString(b));
            return sb.toString();
        }

        public final setLocationDataConsentGiven values() {
            return this.cca_continue;
        }
    }

    public GMCipherSpi(BigInteger bigInteger) {
        this.f2437a = bigInteger;
    }

    public final setLocationDataConsentGiven values() {
        return new setProxyAddress(this.f2437a);
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$ErasableOutputStream */
    public final class ErasableOutputStream extends getThreeDSRequestorAppURL implements setEnvironment {
        private getProxyAddress configure;
        private int init;

        public static ErasableOutputStream getInstance(Object obj) {
            if (obj == null) {
                return (ErasableOutputStream) obj;
            }
            if (obj instanceof getType) {
                return new ErasableOutputStream((getType) obj);
            }
            StringBuilder sb = new StringBuilder("unknown object in factory: ");
            sb.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }

        private static void init(StringBuffer stringBuffer, String str, String str2, String str3) {
            stringBuffer.append("    ");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str);
            stringBuffer.append("    ");
            stringBuffer.append("    ");
            stringBuffer.append(str3);
            stringBuffer.append(str);
        }

        public final String toString() {
            String str;
            String str2;
            String instance = setAnimation.getInstance();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DistributionPointName: [");
            stringBuffer.append(instance);
            if (this.init == 0) {
                str2 = this.configure.toString();
                str = "fullName";
            } else {
                str2 = this.configure.toString();
                str = "nameRelativeToCRLIssuer";
            }
            init(stringBuffer, instance, str, str2);
            stringBuffer.append(Const.jaRight);
            stringBuffer.append(instance);
            return stringBuffer.toString();
        }

        public final setLocationDataConsentGiven values() {
            return new RSA(false, this.init, this.configure);
        }

        private ErasableOutputStream(getType gettype) {
            int i = gettype.Cardinal;
            this.init = i;
            if (i == 0) {
                setThreeDSRequestorAppURL configure2 = setThreeDSRequestorAppURL.configure(gettype, false);
                this.configure = configure2 != null ? new SM2withSha256(setThreeDSRequestorAppURL.cca_continue((Object) configure2)) : null;
                return;
            }
            this.configure = isEnableLogging.cca_continue(gettype);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2 */
    public final class SM2 extends getThreeDSRequestorAppURL {
        private DSASigner.stdDSA getInstance;
        private byte[] init;

        public SM2(DSASigner.stdDSA stddsa, byte[] bArr) {
            this.init = setForegroundTintBlendMode.cca_continue(bArr);
            this.getInstance = stddsa;
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            setforegroundtintblendmode.cca_continue.addElement(new EdEC(this.init));
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withBlake2b */
    public final class SM2withBlake2b extends getThreeDSRequestorAppURL {
        private int Cardinal;
        public GMSignatureSpi.sha256WithSM2 cca_continue;
        public DSASigner.stdDSA configure;
        public PrivateKeyInfo getInstance;
        private boolean init = false;

        public final int hashCode() {
            if (!this.init) {
                this.Cardinal = super.hashCode();
                this.init = true;
            }
            return this.Cardinal;
        }

        public SM2withBlake2b(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            if (setthreedsrequestorappurl.getInstance() == 3) {
                getProxyAddress Cardinal2 = setthreedsrequestorappurl.Cardinal(0);
                DSASigner.stdDSA stddsa = null;
                this.cca_continue = Cardinal2 instanceof GMSignatureSpi.sha256WithSM2 ? (GMSignatureSpi.sha256WithSM2) Cardinal2 : Cardinal2 != null ? new GMSignatureSpi.sha256WithSM2(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null;
                getProxyAddress Cardinal3 = setthreedsrequestorappurl.Cardinal(1);
                if (Cardinal3 instanceof DSASigner.stdDSA) {
                    stddsa = (DSASigner.stdDSA) Cardinal3;
                } else if (Cardinal3 != null) {
                    stddsa = new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal3));
                }
                this.configure = stddsa;
                this.getInstance = PrivateKeyInfo.Cardinal(setthreedsrequestorappurl.Cardinal(2));
                return;
            }
            throw new IllegalArgumentException("sequence wrong size for CertificateList");
        }

        public final Enumeration init() {
            GMSignatureSpi.sha256WithSM2 sha256withsm2 = this.cca_continue;
            return sha256withsm2.getSDKVersion == null ? new GMSignatureSpi.sha256WithSM2.Cardinal(sha256withsm2) : new GMSignatureSpi.sha256WithSM2.getInstance(sha256withsm2.getSDKVersion.cca_continue());
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.cca_continue);
            setforegroundtintblendmode.cca_continue.addElement(this.configure);
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withBlake2s */
    public final class SM2withBlake2s extends getThreeDSRequestorAppURL {
        public setProxyAddress cca_continue;
        public setProxyAddress configure;
        public setProxyAddress init;

        public SM2withBlake2s(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            if (setthreedsrequestorappurl.getInstance() == 3) {
                Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
                this.configure = setProxyAddress.Cardinal(cca_continue2.nextElement());
                this.cca_continue = setProxyAddress.Cardinal(cca_continue2.nextElement());
                this.init = setProxyAddress.Cardinal(cca_continue2.nextElement());
                return;
            }
            StringBuilder sb = new StringBuilder("Bad sequence size: ");
            sb.append(setthreedsrequestorappurl.getInstance());
            throw new IllegalArgumentException(sb.toString());
        }

        public SM2withBlake2s(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.configure = new setProxyAddress(bigInteger);
            this.cca_continue = new setProxyAddress(bigInteger2);
            this.init = new setProxyAddress(bigInteger3);
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.configure);
            setforegroundtintblendmode.cca_continue.addElement(this.cca_continue);
            setforegroundtintblendmode.cca_continue.addElement(this.init);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withMD5 */
    public final class SM2withMD5 extends getThreeDSRequestorAppURL {
        private GMSignatureSpi.sm3WithSM2 cca_continue;
        private SM2withSha256 getInstance;
        private ErasableOutputStream init;

        private static void getInstance(StringBuffer stringBuffer, String str, String str2, String str3) {
            stringBuffer.append("    ");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str);
            stringBuffer.append("    ");
            stringBuffer.append("    ");
            stringBuffer.append(str3);
            stringBuffer.append(str);
        }

        public final String toString() {
            String instance = setAnimation.getInstance();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("DistributionPoint: [");
            stringBuffer.append(instance);
            ErasableOutputStream erasableOutputStream = this.init;
            if (erasableOutputStream != null) {
                getInstance(stringBuffer, instance, "distributionPoint", erasableOutputStream.toString());
            }
            GMSignatureSpi.sm3WithSM2 sm3withsm2 = this.cca_continue;
            if (sm3withsm2 != null) {
                getInstance(stringBuffer, instance, "reasons", sm3withsm2.toString());
            }
            SM2withSha256 sM2withSha256 = this.getInstance;
            if (sM2withSha256 != null) {
                getInstance(stringBuffer, instance, "cRLIssuer", sM2withSha256.toString());
            }
            stringBuffer.append(Const.jaRight);
            stringBuffer.append(instance);
            return stringBuffer.toString();
        }

        /* JADX WARNING: type inference failed for: r4v3, types: [com.cardinalcommerce.a.setLocationDataConsentGiven] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SM2withMD5(com.cardinalcommerce.p060a.setThreeDSRequestorAppURL r7) {
            /*
                r6 = this;
                r6.<init>()
                r0 = 0
                r1 = 0
            L_0x0005:
                int r2 = r7.getInstance()
                if (r1 == r2) goto L_0x0067
                com.cardinalcommerce.a.getProxyAddress r2 = r7.Cardinal((int) r1)
                com.cardinalcommerce.a.getType r2 = com.cardinalcommerce.p060a.getType.cca_continue((java.lang.Object) r2)
                int r3 = r2.Cardinal
                r4 = 0
                if (r3 == 0) goto L_0x0052
                r5 = 1
                if (r3 == r5) goto L_0x0046
                r5 = 2
                if (r3 != r5) goto L_0x0030
                com.cardinalcommerce.a.setThreeDSRequestorAppURL r2 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.configure(r2, r0)
                if (r2 == 0) goto L_0x002d
                com.cardinalcommerce.a.GMCipherSpi$SM2withSha256 r4 = new com.cardinalcommerce.a.GMCipherSpi$SM2withSha256
                com.cardinalcommerce.a.setThreeDSRequestorAppURL r2 = com.cardinalcommerce.p060a.setThreeDSRequestorAppURL.cca_continue((java.lang.Object) r2)
                r4.<init>(r2)
            L_0x002d:
                r6.getInstance = r4
                goto L_0x0064
            L_0x0030:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Unknown tag encountered in structure: "
                r0.<init>(r1)
                int r1 = r2.Cardinal
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            L_0x0046:
                com.cardinalcommerce.a.GMSignatureSpi$sm3WithSM2 r3 = new com.cardinalcommerce.a.GMSignatureSpi$sm3WithSM2
                com.cardinalcommerce.a.PrivateKeyInfo r2 = com.cardinalcommerce.p060a.PrivateKeyInfo.getInstance(r2)
                r3.<init>(r2)
                r6.cca_continue = r3
                goto L_0x0064
            L_0x0052:
                com.cardinalcommerce.a.getProxyAddress r3 = r2.getInstance
                if (r3 == 0) goto L_0x005c
                com.cardinalcommerce.a.getProxyAddress r2 = r2.getInstance
                com.cardinalcommerce.a.setLocationDataConsentGiven r4 = r2.values()
            L_0x005c:
                com.cardinalcommerce.a.getType r4 = (com.cardinalcommerce.p060a.getType) r4
                com.cardinalcommerce.a.GMCipherSpi$ErasableOutputStream r2 = com.cardinalcommerce.p060a.GMCipherSpi.ErasableOutputStream.getInstance(r4)
                r6.init = r2
            L_0x0064:
                int r1 = r1 + 1
                goto L_0x0005
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.GMCipherSpi.SM2withMD5.<init>(com.cardinalcommerce.a.setThreeDSRequestorAppURL):void");
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            ErasableOutputStream erasableOutputStream = this.init;
            if (erasableOutputStream != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(erasableOutputStream));
            }
            GMSignatureSpi.sm3WithSM2 sm3withsm2 = this.cca_continue;
            if (sm3withsm2 != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 1, sm3withsm2));
            }
            SM2withSha256 sM2withSha256 = this.getInstance;
            if (sM2withSha256 != null) {
                setforegroundtintblendmode.cca_continue.addElement(new RSA(false, 2, sM2withSha256));
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withRMD */
    public final class SM2withRMD extends getThreeDSRequestorAppURL implements setEnvironment {
        public getProxyAddress Cardinal;
        public int init;

        private SM2withRMD(int i, getProxyAddress getproxyaddress) {
            this.Cardinal = getproxyaddress;
            this.init = i;
        }

        public final String toString() {
            String str;
            Object instance;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.init);
            stringBuffer.append(": ");
            int i = this.init;
            if (!(i == 1 || i == 2)) {
                if (i == 4) {
                    instance = DSASigner.dsaSha3_224.getInstance(this.Cardinal);
                } else if (i != 6) {
                    instance = this.Cardinal;
                }
                str = instance.toString();
                stringBuffer.append(str);
                return stringBuffer.toString();
            }
            str = DSA.Mappings.init(this.Cardinal).init();
            stringBuffer.append(str);
            return stringBuffer.toString();
        }

        public final setLocationDataConsentGiven values() {
            int i = this.init;
            return i == 4 ? new RSA(true, i, this.Cardinal) : new RSA(false, i, this.Cardinal);
        }

        public static SM2withRMD Cardinal(Object obj) {
            if (obj == null || (obj instanceof SM2withRMD)) {
                return (SM2withRMD) obj;
            }
            if (obj instanceof getType) {
                getType gettype = (getType) obj;
                int i = gettype.Cardinal;
                switch (i) {
                    case 0:
                        return new SM2withRMD(i, setThreeDSRequestorAppURL.configure(gettype, false));
                    case 1:
                        return new SM2withRMD(i, DSA.Mappings.Cardinal(gettype));
                    case 2:
                        return new SM2withRMD(i, DSA.Mappings.Cardinal(gettype));
                    case 3:
                        throw new IllegalArgumentException("unknown tag: ".concat(String.valueOf(i)));
                    case 4:
                        return new SM2withRMD(i, DSASigner.dsaSha3_224.init(gettype));
                    case 5:
                        return new SM2withRMD(i, setThreeDSRequestorAppURL.configure(gettype, false));
                    case 6:
                        return new SM2withRMD(i, DSA.Mappings.Cardinal(gettype));
                    case 7:
                        return new SM2withRMD(i, isEnableDFSync.getInstance(gettype, false));
                    case 8:
                        return new SM2withRMD(i, ASN1ObjectIdentifier.init(gettype));
                }
            }
            if (obj instanceof byte[]) {
                try {
                    return Cardinal(setLocationDataConsentGiven.getInstance((byte[]) obj));
                } catch (IOException unused) {
                    throw new IllegalArgumentException("unable to parse encoded general name");
                }
            } else {
                StringBuilder sb = new StringBuilder("unknown object in getInstance: ");
                sb.append(obj.getClass().getName());
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withSha1 */
    public final class SM2withSha1 extends getThreeDSRequestorAppURL {
        private boolean Cardinal;
        private boolean cca_continue;
        private setThreeDSRequestorAppURL cleanup;
        private ErasableOutputStream configure;
        private GMSignatureSpi.sm3WithSM2 getInstance;
        private boolean getSDKVersion;
        private boolean init;

        private static void cca_continue(StringBuffer stringBuffer, String str, String str2, String str3) {
            stringBuffer.append("    ");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str);
            stringBuffer.append("    ");
            stringBuffer.append("    ");
            stringBuffer.append(str3);
            stringBuffer.append(str);
        }

        public final boolean Cardinal() {
            return this.cca_continue;
        }

        public final setLocationDataConsentGiven values() {
            return this.cleanup;
        }

        public SM2withSha1(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.cleanup = setthreedsrequestorappurl;
            for (int i = 0; i != setthreedsrequestorappurl.getInstance(); i++) {
                getType cca_continue2 = getType.cca_continue((Object) setthreedsrequestorappurl.Cardinal(i));
                int i2 = cca_continue2.Cardinal;
                if (i2 == 0) {
                    this.configure = ErasableOutputStream.getInstance((getType) (cca_continue2.getInstance != null ? cca_continue2.getInstance.values() : null));
                } else if (i2 == 1) {
                    this.init = setChallengeTimeout.cca_continue(cca_continue2).init();
                } else if (i2 == 2) {
                    this.Cardinal = setChallengeTimeout.cca_continue(cca_continue2).init();
                } else if (i2 == 3) {
                    this.getInstance = new GMSignatureSpi.sm3WithSM2(GMSignatureSpi.sm3WithSM2.getInstance(cca_continue2));
                } else if (i2 == 4) {
                    this.cca_continue = setChallengeTimeout.cca_continue(cca_continue2).init();
                } else if (i2 == 5) {
                    this.getSDKVersion = setChallengeTimeout.cca_continue(cca_continue2).init();
                } else {
                    throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
            }
        }

        public final String toString() {
            String instance = setAnimation.getInstance();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("IssuingDistributionPoint: [");
            stringBuffer.append(instance);
            ErasableOutputStream erasableOutputStream = this.configure;
            if (erasableOutputStream != null) {
                cca_continue(stringBuffer, instance, "distributionPoint", erasableOutputStream.toString());
            }
            boolean z = this.init;
            String str = "true";
            if (z) {
                cca_continue(stringBuffer, instance, "onlyContainsUserCerts", z ? str : SDKConsts.BOOLEAN_FALSE);
            }
            boolean z2 = this.Cardinal;
            if (z2) {
                cca_continue(stringBuffer, instance, "onlyContainsCACerts", z2 ? str : SDKConsts.BOOLEAN_FALSE);
            }
            GMSignatureSpi.sm3WithSM2 sm3withsm2 = this.getInstance;
            if (sm3withsm2 != null) {
                cca_continue(stringBuffer, instance, "onlySomeReasons", sm3withsm2.toString());
            }
            boolean z3 = this.getSDKVersion;
            if (z3) {
                cca_continue(stringBuffer, instance, "onlyContainsAttributeCerts", z3 ? str : SDKConsts.BOOLEAN_FALSE);
            }
            boolean z4 = this.cca_continue;
            if (z4) {
                if (!z4) {
                    str = SDKConsts.BOOLEAN_FALSE;
                }
                cca_continue(stringBuffer, instance, "indirectCRL", str);
            }
            stringBuffer.append(Const.jaRight);
            stringBuffer.append(instance);
            return stringBuffer.toString();
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withSha224 */
    public final class SM2withSha224 extends getThreeDSRequestorAppURL {
        public Hashtable cca_continue = new Hashtable();
        public Vector configure = new Vector();

        SM2withSha224(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
            while (cca_continue2.hasMoreElements()) {
                SM2withSha384 configure2 = SM2withSha384.configure(cca_continue2.nextElement());
                if (!this.cca_continue.containsKey(configure2.CardinalConfigurationParameters)) {
                    this.cca_continue.put(configure2.CardinalConfigurationParameters, configure2);
                    this.configure.addElement(configure2.CardinalConfigurationParameters);
                } else {
                    StringBuilder sb = new StringBuilder("repeated extension found: ");
                    sb.append(configure2.CardinalConfigurationParameters);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            Enumeration elements = this.configure.elements();
            while (elements.hasMoreElements()) {
                Hashtable hashtable = this.cca_continue;
                setforegroundtintblendmode.cca_continue.addElement((SM2withSha384) hashtable.get((ASN1ObjectIdentifier) elements.nextElement()));
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withSha384 */
    public final class SM2withSha384 extends getThreeDSRequestorAppURL {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier("2.5.29.15").getInstance();
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier("2.5.29.46").getInstance();
        public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier("2.5.29.33").getInstance();
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier("2.5.29.30").getInstance();
        public static final ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier("2.5.29.32").getInstance();
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier("2.5.29.36").getInstance();
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier("2.5.29.19").getInstance();
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier("2.5.29.27").getInstance();
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier("2.5.29.17").getInstance();
        public static final ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier("2.5.29.20").getInstance();
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier("2.5.29.28").getInstance();
        public static final ASN1ObjectIdentifier getString = new ASN1ObjectIdentifier("2.5.29.54").getInstance();
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier("2.5.29.29").getInstance();
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier("2.5.29.18").getInstance();
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier("2.5.29.31").getInstance();
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier("2.5.29.21").getInstance();
        ASN1ObjectIdentifier CardinalConfigurationParameters;
        private boolean getActionCode;
        public isEnableDFSync getRequestTimeout;

        static {
            new ASN1ObjectIdentifier("2.5.29.9").getInstance();
            new ASN1ObjectIdentifier("2.5.29.14").getInstance();
            new ASN1ObjectIdentifier("2.5.29.16").getInstance();
            new ASN1ObjectIdentifier("2.5.29.23").getInstance();
            new ASN1ObjectIdentifier("2.5.29.24").getInstance();
            new ASN1ObjectIdentifier("2.5.29.35").getInstance();
            new ASN1ObjectIdentifier("2.5.29.37").getInstance();
            new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1").getInstance();
            new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11").getInstance();
            new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12").getInstance();
            new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2").getInstance();
            new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3").getInstance();
            new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4").getInstance();
            new ASN1ObjectIdentifier("2.5.29.56").getInstance();
            new ASN1ObjectIdentifier("2.5.29.55").getInstance();
            new ASN1ObjectIdentifier("2.5.29.60").getInstance();
        }

        private SM2withSha384(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            getProxyAddress Cardinal2;
            if (setthreedsrequestorappurl.getInstance() == 2) {
                this.CardinalConfigurationParameters = ASN1ObjectIdentifier.getInstance(setthreedsrequestorappurl.Cardinal(0));
                this.getActionCode = false;
                Cardinal2 = setthreedsrequestorappurl.Cardinal(1);
            } else if (setthreedsrequestorappurl.getInstance() == 3) {
                this.CardinalConfigurationParameters = ASN1ObjectIdentifier.getInstance(setthreedsrequestorappurl.Cardinal(0));
                this.getActionCode = setChallengeTimeout.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1)).init();
                Cardinal2 = setthreedsrequestorappurl.Cardinal(2);
            } else {
                StringBuilder sb = new StringBuilder("Bad sequence size: ");
                sb.append(setthreedsrequestorappurl.getInstance());
                throw new IllegalArgumentException(sb.toString());
            }
            this.getRequestTimeout = isEnableDFSync.init(Cardinal2);
        }

        public static SM2withSha384 configure(Object obj) {
            if (obj instanceof SM2withSha384) {
                return (SM2withSha384) obj;
            }
            if (obj != null) {
                return new SM2withSha384(setThreeDSRequestorAppURL.cca_continue(obj));
            }
            return null;
        }

        public final boolean init() {
            return this.getActionCode;
        }

        public final int hashCode() {
            if (init()) {
                return this.getRequestTimeout.hashCode() ^ this.CardinalConfigurationParameters.hashCode();
            }
            return ~(this.getRequestTimeout.hashCode() ^ this.CardinalConfigurationParameters.hashCode());
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SM2withSha384)) {
                return false;
            }
            SM2withSha384 sM2withSha384 = (SM2withSha384) obj;
            if (!sM2withSha384.CardinalConfigurationParameters.equals(this.CardinalConfigurationParameters) || !sM2withSha384.getRequestTimeout.equals(this.getRequestTimeout) || sM2withSha384.init() != init()) {
                return false;
            }
            return true;
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.CardinalConfigurationParameters);
            if (this.getActionCode) {
                setforegroundtintblendmode.cca_continue.addElement(setChallengeTimeout.cca_continue(true));
            }
            setforegroundtintblendmode.cca_continue.addElement(this.getRequestTimeout);
            return new GOST(setforegroundtintblendmode);
        }

        public static setLocationDataConsentGiven cca_continue(SM2withSha384 sM2withSha384) throws IllegalArgumentException {
            try {
                return setLocationDataConsentGiven.getInstance(sM2withSha384.getRequestTimeout.cca_continue());
            } catch (IOException e) {
                throw new IllegalArgumentException("can't convert extension: ".concat(String.valueOf(e)));
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.GMCipherSpi$SM2withSha512 */
    public final class SM2withSha512 extends getThreeDSRequestorAppURL implements setEnvironment {
        public setLocationDataConsentGiven configure;

        private SM2withSha512(setLocationDataConsentGiven setlocationdataconsentgiven) {
            if ((setlocationdataconsentgiven instanceof Payment) || (setlocationdataconsentgiven instanceof setRenderType)) {
                this.configure = setlocationdataconsentgiven;
                return;
            }
            throw new IllegalArgumentException("unknown object passed to Time");
        }

        public static SM2withSha512 init(Object obj) {
            if (obj == null || (obj instanceof SM2withSha512)) {
                return (SM2withSha512) obj;
            }
            if (obj instanceof Payment) {
                return new SM2withSha512((Payment) obj);
            }
            if (obj instanceof setRenderType) {
                return new SM2withSha512((setRenderType) obj);
            }
            StringBuilder sb = new StringBuilder("unknown object in factory: ");
            sb.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }

        public final setLocationDataConsentGiven values() {
            return this.configure;
        }

        public final Date configure() {
            try {
                if (!(this.configure instanceof Payment)) {
                    return ((setRenderType) this.configure).init();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
                simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
                return IESCipher.IES.getInstance(simpleDateFormat.parse(((Payment) this.configure).init()));
            } catch (ParseException e) {
                StringBuilder sb = new StringBuilder("invalid date string: ");
                sb.append(e.getMessage());
                throw new IllegalStateException(sb.toString());
            }
        }

        public final String toString() {
            setLocationDataConsentGiven setlocationdataconsentgiven = this.configure;
            return setlocationdataconsentgiven instanceof Payment ? ((Payment) setlocationdataconsentgiven).init() : ((setRenderType) setlocationdataconsentgiven).getInstance();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CRLNumber: ");
        sb.append(this.f2437a);
        return sb.toString();
    }
}
