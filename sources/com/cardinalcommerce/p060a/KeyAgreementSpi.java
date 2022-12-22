package com.cardinalcommerce.p060a;

import androidx.room.RoomMasterTable;
import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.AlgorithmParametersSpi;
import com.cardinalcommerce.p060a.CipherSpi;
import com.cardinalcommerce.p060a.DSA;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.PSSSignatureSpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.didi.beatles.p099im.IMGD;
import com.didi.travel.psnger.model.response.ScarShareReportModel;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.Key;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* renamed from: com.cardinalcommerce.a.KeyAgreementSpi */
public final class KeyAgreementSpi {

    /* renamed from: a */
    private static final long f2453a = Runtime.getRuntime().maxMemory();

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA512KDFAndSharedInfo */
    public final class CDHwithSHA512KDFAndSharedInfo extends getThreeDSRequestorAppURL implements setEnvironment {
        public setLocationDataConsentGiven configure = null;

        public CDHwithSHA512KDFAndSharedInfo(C1970DH dh) {
            this.configure = dh.values();
        }

        private CDHwithSHA512KDFAndSharedInfo(setLocationDataConsentGiven setlocationdataconsentgiven) {
            this.configure = setlocationdataconsentgiven;
        }

        public CDHwithSHA512KDFAndSharedInfo(setUiType setuitype) {
            this.configure = setuitype;
        }

        public CDHwithSHA512KDFAndSharedInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            this.configure = aSN1ObjectIdentifier;
        }

        public static CDHwithSHA512KDFAndSharedInfo init(Object obj) {
            if (obj == null || (obj instanceof CDHwithSHA512KDFAndSharedInfo)) {
                return (CDHwithSHA512KDFAndSharedInfo) obj;
            }
            if (obj instanceof setLocationDataConsentGiven) {
                return new CDHwithSHA512KDFAndSharedInfo((setLocationDataConsentGiven) obj);
            }
            if (obj instanceof byte[]) {
                try {
                    return new CDHwithSHA512KDFAndSharedInfo(setLocationDataConsentGiven.getInstance((byte[]) obj));
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("unable to parse encoded data: ");
                    sb.append(e.getMessage());
                    throw new IllegalArgumentException(sb.toString());
                }
            } else {
                throw new IllegalArgumentException("unknown object in getInstance()");
            }
        }

        public final boolean Cardinal() {
            return this.configure instanceof ASN1ObjectIdentifier;
        }

        public final boolean cca_continue() {
            return this.configure instanceof setUiType;
        }

        public final setLocationDataConsentGiven values() {
            return this.configure;
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHC */
    public abstract class DHC {
        private C1970DH cca_continue;

        public final synchronized C1970DH cca_continue() {
            if (this.cca_continue == null) {
                this.cca_continue = init();
            }
            return this.cca_continue;
        }

        /* access modifiers changed from: protected */
        public abstract C1970DH init();
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA1CKDF */
    public interface DHUwithSHA1CKDF {
        setLocationDataConsentGiven getInstance() throws IOException;
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA224CKDF */
    public final class DHUwithSHA224CKDF extends DHUwithSHA1KDF {
        private int Cardinal;
        public boolean cca_continue = true;
        private boolean configure = false;
        private int init;

        public DHUwithSHA224CKDF(InputStream inputStream, int i) throws IOException {
            super(inputStream, i);
            this.Cardinal = inputStream.read();
            int read = inputStream.read();
            this.init = read;
            if (read >= 0) {
                init();
                return;
            }
            throw new EOFException();
        }

        public final boolean init() {
            if (!this.configure && this.cca_continue && this.Cardinal == 0 && this.init == 0) {
                this.configure = true;
                cca_continue();
            }
            return this.configure;
        }

        public final int read() throws IOException {
            if (init()) {
                return -1;
            }
            int read = this.getInstance.read();
            if (read >= 0) {
                int i = this.Cardinal;
                this.Cardinal = this.init;
                this.init = read;
                return i;
            }
            throw new EOFException();
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.cca_continue || i2 < 3) {
                return super.read(bArr, i, i2);
            }
            if (this.configure) {
                return -1;
            }
            int read = this.getInstance.read(bArr, i + 2, i2 - 2);
            if (read >= 0) {
                bArr[i] = (byte) this.Cardinal;
                bArr[i + 1] = (byte) this.init;
                this.Cardinal = this.getInstance.read();
                int read2 = this.getInstance.read();
                this.init = read2;
                if (read2 >= 0) {
                    return read + 2;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA224KDF */
    public interface DHUwithSHA224KDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier("1.2.250.1.223.101.256.1");
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA256KDF */
    public final class DHUwithSHA256KDF {
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("1.3.6.1.4.1.3029"), "1"), "5"), "1");
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1KDF */
    public final class DHwithSHA1KDF {
        private static DHUwithSHA512KDF Cardinal = new DHUwithSHA512KDF(new BigInteger("142011741597563481196368286022318089743276138395243738762872573441927459393512718973631166078467600360848946623567625795282774719212241929071046134208380636394084512691828894000571524625445295769349356752728956831541775441763139384457191755096847107846595662547942312293338483924514339614727760681880609734239"), new BigInteger("91771529896554605945588149018382750217296858393520724172743325725474374979801"), new BigInteger("133531813272720673433859519948319001217942375967847486899482359599369642528734712461590403327731821410328012529253871914788598993103310567744136196364803064721377826656898686468463277710150809401182608770201615324990468332931294920912776241137878030224355746606283971659376426832674269780880061631528163475887"));
        private static DHUwithSHA512KDF cca_continue = new DHUwithSHA512KDF(new BigInteger("127021248288932417465907042777176443525787653508916535812817507265705031260985098497423188333483401180925999995120988934130659205614996724254121049274349357074920312769561451689224110579311248812610229678534638401693520013288995000362260684222750813532307004517341633685004541062586971416883686778842537820383"), new BigInteger("68363196144955700784444165611827252895102170888761442055095051287550314083023"), new BigInteger("100997906755055304772081815535925224869841082572053457874823515875577147990529272777244152852699298796483356699682842027972896052747173175480590485607134746852141928680912561502802222185647539190902656116367847270145019066794290930185446216399730872221732889830323194097355403213400972588322876850946740663962"));
        private static Hashtable configure = new Hashtable();
        private static Hashtable getInstance = new Hashtable();
        private static DHUwithSHA512KDF init = new DHUwithSHA512KDF(new BigInteger("139454871199115825601409655107690713107041707059928031797758001454375765357722984094124368522288239833039114681648076688236921220737322672160740747771700911134550432053804647694904686120113087816240740184800477047157336662926249423571248823968542221753660143391485680840520336859458494803187341288580489525163"), new BigInteger("79885141663410976897627118935756323747307951916507639758300472692338873533959"), new BigInteger("42941826148615804143873447737955502392672345968607143066798112994089471231420027060385216699563848719957657284814898909770759462613437669456364882730370838934791080835932647976778601915343474400961034231316672578686920482194932878633360203384797092684342247621055760235016132614780652761028509445403338652341"));

        static {
            new Hashtable();
            configure.put(DHUwithSHA512CKDF.CardinalActionCode, cca_continue);
            configure.put(DHUwithSHA512CKDF.CardinalRenderType, init);
            configure.put(DHUwithSHA512CKDF.valueOf, Cardinal);
            getInstance.put("GostR3410-94-CryptoPro-A", DHUwithSHA512CKDF.CardinalActionCode);
            getInstance.put("GostR3410-94-CryptoPro-B", DHUwithSHA512CKDF.CardinalRenderType);
            getInstance.put("GostR3410-94-CryptoPro-XchA", DHUwithSHA512CKDF.valueOf);
        }

        public static ASN1ObjectIdentifier Cardinal(String str) {
            return (ASN1ObjectIdentifier) getInstance.get(str);
        }

        public static DHUwithSHA512KDF configure(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (DHUwithSHA512KDF) configure.get(aSN1ObjectIdentifier);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDFAndSharedInfo */
    public final class DHwithSHA224KDFAndSharedInfo extends getThreeDSRequestorAppURL {
        private ChallengeParameters cca_continue;
        private final isEnableDFSync configure;
        private getSDKAppID init;

        public DHwithSHA224KDFAndSharedInfo(ChallengeParameters challengeParameters) {
            this(challengeParameters, false);
        }

        public DHwithSHA224KDFAndSharedInfo(ChallengeParameters challengeParameters, boolean z) {
            this.cca_continue = challengeParameters.CardinalRenderType();
            this.configure = new EdEC(challengeParameters.configure(false));
        }

        public DHwithSHA224KDFAndSharedInfo(getSDKAppID getsdkappid, isEnableDFSync isenabledfsync) {
            this(getsdkappid, isenabledfsync.cca_continue());
        }

        public DHwithSHA224KDFAndSharedInfo(getSDKAppID getsdkappid, byte[] bArr) {
            this.init = getsdkappid;
            this.configure = new EdEC(setForegroundTintBlendMode.cca_continue(bArr));
        }

        public final synchronized ChallengeParameters cca_continue() {
            if (this.cca_continue == null) {
                this.cca_continue = this.init.configure(this.configure.cca_continue()).CardinalRenderType();
            }
            return this.cca_continue;
        }

        public final setLocationDataConsentGiven values() {
            return this.configure;
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA384KDFAndSharedInfo */
    public interface DHwithSHA384KDFAndSharedInfo {
        void Cardinal(boolean z, ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF);

        byte[] Cardinal(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH;

        int configure();

        int getInstance();
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA512CKDF */
    public interface DHwithSHA512CKDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier("1.2.410.200004.1.4");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier("1.2.410.200004.7.1.1.1");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier("1.2.410.200004.1.7");

        static {
            new ASN1ObjectIdentifier("1.2.410.200004.1.15");
            new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.0.24");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA512KDFAndSharedInfo */
    public interface DHwithSHA512KDFAndSharedInfo {
        String Cardinal();

        void Cardinal(boolean z, ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) throws IllegalArgumentException;

        int cca_continue();

        int init(byte[] bArr, int i, byte[] bArr2, int i2) throws MQVwithSHA512KDFAndSharedInfo, IllegalStateException;

        void init();
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithRIPEMD160KDF */
    public interface ECKAEGwithRIPEMD160KDF {
        void cca_continue(GOST3410Util gOST3410Util);

        ExtendedInvalidKeySpecException init();
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA224KDF */
    public interface ECKAEGwithSHA224KDF {
        BigInteger Cardinal(ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF);

        int cca_continue();

        void configure(ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF);
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA384KDF */
    public final class ECKAEGwithSHA384KDF extends Permission {
        private final Set<String> cca_continue;

        public ECKAEGwithSHA384KDF(String str) {
            super(str);
            HashSet hashSet = new HashSet();
            this.cca_continue = hashSet;
            hashSet.add(str);
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ECKAEGwithSHA384KDF) && this.cca_continue.equals(((ECKAEGwithSHA384KDF) obj).cca_continue);
        }

        public final String getActions() {
            return this.cca_continue.toString();
        }

        public final int hashCode() {
            return this.cca_continue.hashCode();
        }

        public final boolean implies(Permission permission) {
            if (!(permission instanceof ECKAEGwithSHA384KDF)) {
                return false;
            }
            ECKAEGwithSHA384KDF eCKAEGwithSHA384KDF = (ECKAEGwithSHA384KDF) permission;
            return getName().equals(eCKAEGwithSHA384KDF.getName()) || this.cca_continue.containsAll(eCKAEGwithSHA384KDF.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA512KDF */
    public interface ECKAEGwithSHA512KDF extends setHorizontalFadingEdgeEnabled, Iterable, Key, PublicKey {
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECVKO512 */
    public final class ECVKO512 extends BCXDHPrivateKey {
        private int[] cca_continue = null;
        private int[] configure = null;
        private int[] getInstance = null;
        private boolean init;

        public final String Cardinal() {
            return "DESede";
        }

        public final void Cardinal(boolean z, ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.MD5WithRSAEncryption) {
                byte[] instance = ((ISOSignatureSpi.MD5WithRSAEncryption) eCKAEGwithSHA512KDF).getInstance();
                if (instance.length == 24 || instance.length == 16) {
                    this.init = z;
                    byte[] bArr = new byte[8];
                    System.arraycopy(instance, 0, bArr, 0, 8);
                    this.cca_continue = Cardinal(z, bArr);
                    byte[] bArr2 = new byte[8];
                    System.arraycopy(instance, 8, bArr2, 0, 8);
                    this.getInstance = Cardinal(!z, bArr2);
                    if (instance.length == 24) {
                        byte[] bArr3 = new byte[8];
                        System.arraycopy(instance, 16, bArr3, 0, 8);
                        this.configure = Cardinal(z, bArr3);
                        return;
                    }
                    this.configure = this.cca_continue;
                    return;
                }
                throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
            }
            StringBuilder sb = new StringBuilder("invalid parameter passed to DESede init - ");
            sb.append(eCKAEGwithSHA512KDF.getClass().getName());
            throw new IllegalArgumentException(sb.toString());
        }

        public final int cca_continue() {
            return 8;
        }

        public final int init(byte[] bArr, int i, byte[] bArr2, int i2) {
            int[] iArr = this.cca_continue;
            if (iArr == null) {
                throw new IllegalStateException("DESede engine not initialised");
            } else if (i + 8 > bArr.length) {
                throw new MQVwithSHA512KDFAndSharedInfo("input buffer too short");
            } else if (i2 + 8 <= bArr2.length) {
                byte[] bArr3 = new byte[8];
                if (this.init) {
                    getInstance(iArr, bArr, i, bArr3, 0);
                    getInstance(this.getInstance, bArr3, 0, bArr3, 0);
                    getInstance(this.configure, bArr3, 0, bArr2, i2);
                } else {
                    getInstance(this.configure, bArr, i, bArr3, 0);
                    getInstance(this.getInstance, bArr3, 0, bArr3, 0);
                    getInstance(this.cca_continue, bArr3, 0, bArr2, i2);
                }
                return 8;
            } else {
                throw new KeyFactorySpi.ECDSA("output buffer too short");
            }
        }

        public final void init() {
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA1CKDF */
    public final class MQVwithSHA1CKDF extends DSA.Mappings {
        public MQVwithSHA1CKDF(DSA.Mappings mappings) {
            super(mappings.init());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("NetscapeRevocationURL: ");
            sb.append(init());
            return sb.toString();
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA1KDF */
    public final class MQVwithSHA1KDF extends PrivateKeyInfo {
        public MQVwithSHA1KDF(PrivateKeyInfo privateKeyInfo) {
            super(privateKeyInfo.getInstance(), privateKeyInfo.cleanup());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("NetscapeCertType: 0x");
            sb.append(Integer.toHexString(this.cca_continue[0] & 255));
            return sb.toString();
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA1KDFAndSharedInfo */
    public class MQVwithSHA1KDFAndSharedInfo extends Exception {
        private Throwable getInstance;

        public MQVwithSHA1KDFAndSharedInfo() {
        }

        public MQVwithSHA1KDFAndSharedInfo(String str) {
            super(str);
        }

        public MQVwithSHA1KDFAndSharedInfo(String str, Throwable th) {
            super(str);
            this.getInstance = th;
        }

        public Throwable getCause() {
            return this.getInstance;
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA224CKDF */
    public final class MQVwithSHA224CKDF extends DSA.Mappings {
        public MQVwithSHA224CKDF(DSA.Mappings mappings) {
            super(mappings.init());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("VerisignCzagExtension: ");
            sb.append(init());
            return sb.toString();
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA224KDFAndSharedInfo */
    public interface MQVwithSHA224KDFAndSharedInfo {
        void getInstance(ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF);

        int init(byte[] bArr, int i, int i2) throws MQVwithSHA512KDFAndSharedInfo, IllegalArgumentException;
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA256KDF */
    public interface MQVwithSHA256KDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier("1.2.392.200011.61.1.1.1.4");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier("1.2.392.200011.61.1.1.3.2");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier("1.2.392.200011.61.1.1.1.2");
        public static final ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier("1.2.392.200011.61.1.1.1.3");
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier("1.2.392.200011.61.1.1.3.3");
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier("1.2.392.200011.61.1.1.3.4");
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA256KDFAndSharedInfo */
    public interface MQVwithSHA256KDFAndSharedInfo {
        void Cardinal(byte b);

        void cca_continue();

        int configure(byte[] bArr, int i);

        String configure();

        int getInstance();

        void init(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA384KDFAndSharedInfo */
    public interface MQVwithSHA384KDFAndSharedInfo extends MQVwithSHA256KDFAndSharedInfo {
        int Cardinal();
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDF */
    public interface MQVwithSHA512KDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier("1.3.14.3.2.17");
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier("1.3.14.3.2.26");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier("1.3.14.3.2.9");
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier("1.3.14.3.2.29");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier("1.3.14.3.2.7");
        public static final ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier("1.3.14.3.2.8");
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier("1.3.14.3.2.27");
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier("1.3.14.3.2.6");
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier("1.3.14.7.2.1.1");

        static {
            new ASN1ObjectIdentifier("1.3.14.3.2.2");
            new ASN1ObjectIdentifier("1.3.14.3.2.3");
            new ASN1ObjectIdentifier("1.3.14.3.2.4");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512KDFAndSharedInfo */
    public class MQVwithSHA512KDFAndSharedInfo extends KeyPairGeneratorSpi.ECDHC {
        public MQVwithSHA512KDFAndSharedInfo() {
        }

        public MQVwithSHA512KDFAndSharedInfo(String str) {
            super(str);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X448 */
    public final class X448 {
        private static final BigInteger cca_continue = BigInteger.valueOf(2);
        public int Cardinal;
        public int getInstance;
        public SecureRandom init;

        public final CipherSpi Cardinal() {
            BigInteger[] instance = X448UwithSHA512CKDF.getInstance(this.getInstance, this.Cardinal, this.init);
            BigInteger bigInteger = instance[0];
            return new CipherSpi(bigInteger, X448UwithSHA512CKDF.Cardinal(bigInteger, this.init), instance[1], cca_continue, (CipherSpi.NoPadding) null);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X448UwithSHA512CKDF */
    final class X448UwithSHA512CKDF {
        private static final BigInteger cca_continue = BigInteger.valueOf(1);
        private static final BigInteger configure = BigInteger.valueOf(2);

        X448UwithSHA512CKDF() {
        }

        static BigInteger Cardinal(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger modPow;
            BigInteger subtract = bigInteger.subtract(configure);
            do {
                modPow = setSelected.init(configure, subtract, secureRandom).modPow(configure, bigInteger);
            } while (modPow.equals(cca_continue));
            return modPow;
        }

        static BigInteger[] getInstance(int i, int i2, SecureRandom secureRandom) {
            int i3 = i - 1;
            int i4 = i >>> 2;
            while (true) {
                BigInteger configure2 = setSelected.configure(i3, 2, secureRandom);
                BigInteger add = configure2.shiftLeft(1).add(cca_continue);
                if (add.isProbablePrime(i2) && ((i2 <= 2 || configure2.isProbablePrime(i2 - 2)) && createTransaction.cca_continue(add) >= i4)) {
                    return new BigInteger[]{add, configure2};
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$XDH */
    public final class XDH {
        public int Cardinal;
        public SecureRandom configure;
        public int init;

        public final DigestSignatureSpi.SHA224 init() {
            BigInteger bigInteger = X448UwithSHA512CKDF.getInstance(this.Cardinal, this.init, this.configure)[0];
            return new DigestSignatureSpi.SHA224(bigInteger, X448UwithSHA512CKDF.Cardinal(bigInteger, this.configure));
        }
    }

    KeyAgreementSpi() {
    }

    public static int Cardinal(int i) {
        int i2 = 1;
        if (i > 127) {
            int i3 = 1;
            while (true) {
                i >>>= 8;
                if (i == 0) {
                    break;
                }
                i3++;
            }
            for (int i4 = (i3 - 1) << 3; i4 >= 0; i4 -= 8) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    static int m1817a(int i) throws IOException {
        if (i < 31) {
            return 1;
        }
        if (i < 128) {
            return 2;
        }
        byte[] bArr = new byte[5];
        int i2 = 4;
        do {
            i >>= 7;
            i2--;
            bArr[i2] = (byte) ((i & 127) | 128);
        } while (i > 127);
        return 1 + (5 - i2);
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA1KDFAndSharedInfo */
    public final class CDHwithSHA1KDFAndSharedInfo extends getThreeDSRequestorAppURL {
        public final setProxyAddress Cardinal;
        public final setProxyAddress cca_continue;
        public final CDHwithSHA256KDFAndSharedInfo configure;
        public final setProxyAddress getInstance;
        public final setProxyAddress init;

        public CDHwithSHA1KDFAndSharedInfo(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, CDHwithSHA256KDFAndSharedInfo cDHwithSHA256KDFAndSharedInfo) {
            if (bigInteger == null) {
                throw new IllegalArgumentException("'p' cannot be null");
            } else if (bigInteger2 == null) {
                throw new IllegalArgumentException("'g' cannot be null");
            } else if (bigInteger3 != null) {
                this.Cardinal = new setProxyAddress(bigInteger);
                this.cca_continue = new setProxyAddress(bigInteger2);
                this.getInstance = new setProxyAddress(bigInteger3);
                this.init = bigInteger4 != null ? new setProxyAddress(bigInteger4) : null;
                this.configure = cDHwithSHA256KDFAndSharedInfo;
            } else {
                throw new IllegalArgumentException("'q' cannot be null");
            }
        }

        public CDHwithSHA1KDFAndSharedInfo(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            if (setthreedsrequestorappurl.getInstance() < 3 || setthreedsrequestorappurl.getInstance() > 5) {
                StringBuilder sb = new StringBuilder("Bad sequence size: ");
                sb.append(setthreedsrequestorappurl.getInstance());
                throw new IllegalArgumentException(sb.toString());
            }
            Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
            this.Cardinal = setProxyAddress.Cardinal(cca_continue2.nextElement());
            this.cca_continue = setProxyAddress.Cardinal(cca_continue2.nextElement());
            this.getInstance = setProxyAddress.Cardinal(cca_continue2.nextElement());
            CDHwithSHA256KDFAndSharedInfo cDHwithSHA256KDFAndSharedInfo = null;
            getProxyAddress getproxyaddress = cca_continue2.hasMoreElements() ? (getProxyAddress) cca_continue2.nextElement() : null;
            if (getproxyaddress == null || !(getproxyaddress instanceof setProxyAddress)) {
                this.init = null;
            } else {
                this.init = setProxyAddress.Cardinal((Object) getproxyaddress);
                getproxyaddress = cca_continue2.hasMoreElements() ? (getProxyAddress) cca_continue2.nextElement() : null;
            }
            if (getproxyaddress != null) {
                setLocationDataConsentGiven values = getproxyaddress.values();
                this.configure = values != null ? new CDHwithSHA256KDFAndSharedInfo(setThreeDSRequestorAppURL.cca_continue((Object) values)) : cDHwithSHA256KDFAndSharedInfo;
                return;
            }
            this.configure = null;
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.Cardinal);
            setforegroundtintblendmode.cca_continue.addElement(this.cca_continue);
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            setProxyAddress setproxyaddress = this.init;
            if (setproxyaddress != null) {
                setforegroundtintblendmode.cca_continue.addElement(setproxyaddress);
            }
            CDHwithSHA256KDFAndSharedInfo cDHwithSHA256KDFAndSharedInfo = this.configure;
            if (cDHwithSHA256KDFAndSharedInfo != null) {
                setforegroundtintblendmode.cca_continue.addElement(cDHwithSHA256KDFAndSharedInfo);
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA224KDFAndSharedInfo */
    public final class CDHwithSHA224KDFAndSharedInfo extends getThreeDSRequestorAppURL implements ECKAEGwithSHA1KDF {
        getSDKAppID cca_continue;
        private byte[] getInstance;
        private ASN1ObjectIdentifier init = null;

        public final byte[] configure() {
            return setForegroundTintBlendMode.cca_continue(this.getInstance);
        }

        public CDHwithSHA224KDFAndSharedInfo(getSDKAppID getsdkappid, byte[] bArr) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier;
            this.cca_continue = getsdkappid;
            this.getInstance = setForegroundTintBlendMode.cca_continue(bArr);
            if (getDeviceData.getInstance(this.cca_continue)) {
                aSN1ObjectIdentifier = getSDKVersion;
            } else if (getDeviceData.Cardinal(this.cca_continue)) {
                aSN1ObjectIdentifier = CardinalError;
            } else {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            this.init = aSN1ObjectIdentifier;
        }

        public CDHwithSHA224KDFAndSharedInfo(DHUC dhuc, BigInteger bigInteger, BigInteger bigInteger2, setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            int i;
            int i2;
            int i3;
            DHUC dhuc2 = dhuc;
            setThreeDSRequestorAppURL setthreedsrequestorappurl2 = setthreedsrequestorappurl;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = dhuc2.getInstance;
            this.init = aSN1ObjectIdentifier;
            if (aSN1ObjectIdentifier.equals(getSDKVersion)) {
                this.cca_continue = new getSDKAppID.C2008init(new BigInteger(((setProxyAddress) dhuc2.init).Cardinal), new BigInteger(1, isEnableDFSync.init(setthreedsrequestorappurl2.Cardinal(0)).cca_continue()), new BigInteger(1, isEnableDFSync.init(setthreedsrequestorappurl2.Cardinal(1)).cca_continue()), bigInteger, bigInteger2);
            } else if (this.init.equals(CardinalError)) {
                setThreeDSRequestorAppURL cca_continue2 = setThreeDSRequestorAppURL.cca_continue((Object) dhuc2.init);
                int intValue = new BigInteger(((setProxyAddress) cca_continue2.Cardinal(0)).Cardinal).intValue();
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) cca_continue2.Cardinal(1);
                if (aSN1ObjectIdentifier2.equals(cleanup)) {
                    i3 = new BigInteger(setProxyAddress.Cardinal((Object) cca_continue2.Cardinal(2)).Cardinal).intValue();
                    i2 = 0;
                    i = 0;
                } else if (aSN1ObjectIdentifier2.equals(getWarnings)) {
                    setThreeDSRequestorAppURL cca_continue3 = setThreeDSRequestorAppURL.cca_continue((Object) cca_continue2.Cardinal(2));
                    int intValue2 = new BigInteger(setProxyAddress.Cardinal((Object) cca_continue3.Cardinal(0)).Cardinal).intValue();
                    int intValue3 = new BigInteger(setProxyAddress.Cardinal((Object) cca_continue3.Cardinal(1)).Cardinal).intValue();
                    i = new BigInteger(setProxyAddress.Cardinal((Object) cca_continue3.Cardinal(2)).Cardinal).intValue();
                    i3 = intValue2;
                    i2 = intValue3;
                } else {
                    throw new IllegalArgumentException("This type of EC basis is not implemented");
                }
                this.cca_continue = new getSDKAppID.cca_continue(intValue, i3, i2, i, new BigInteger(1, isEnableDFSync.init(setthreedsrequestorappurl2.Cardinal(0)).cca_continue()), new BigInteger(1, isEnableDFSync.init(setthreedsrequestorappurl2.Cardinal(1)).cca_continue()), bigInteger, bigInteger2);
            } else {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            if (setthreedsrequestorappurl.getInstance() == 3) {
                this.getInstance = setForegroundTintBlendMode.cca_continue(((PrivateKeyInfo) setthreedsrequestorappurl2.Cardinal(2)).getInstance());
            }
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            if (this.init.equals(getSDKVersion)) {
                setforegroundtintblendmode.cca_continue.addElement(new DHwithSHA1KDFAndSharedInfo(this.cca_continue.cleanup()).values());
                setforegroundtintblendmode.cca_continue.addElement(new DHwithSHA1KDFAndSharedInfo(this.cca_continue.getWarnings()).values());
            } else if (this.init.equals(CardinalError)) {
                setforegroundtintblendmode.cca_continue.addElement(new DHwithSHA1KDFAndSharedInfo(this.cca_continue.cleanup()).values());
                setforegroundtintblendmode.cca_continue.addElement(new DHwithSHA1KDFAndSharedInfo(this.cca_continue.getWarnings()).values());
            }
            byte[] bArr = this.getInstance;
            if (bArr != null) {
                setforegroundtintblendmode.cca_continue.addElement(new PrivateKeyInfo(bArr));
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA256KDFAndSharedInfo */
    public final class CDHwithSHA256KDFAndSharedInfo extends getThreeDSRequestorAppURL {
        public setProxyAddress getInstance;
        private PrivateKeyInfo init;

        CDHwithSHA256KDFAndSharedInfo(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            if (setthreedsrequestorappurl.getInstance() == 2) {
                this.init = PrivateKeyInfo.Cardinal(setthreedsrequestorappurl.Cardinal(0));
                this.getInstance = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1));
                return;
            }
            StringBuilder sb = new StringBuilder("Bad sequence size: ");
            sb.append(setthreedsrequestorappurl.getInstance());
            throw new IllegalArgumentException(sb.toString());
        }

        public CDHwithSHA256KDFAndSharedInfo(byte[] bArr, int i) {
            if (bArr != null) {
                this.init = new PrivateKeyInfo(bArr);
                this.getInstance = new setProxyAddress((long) i);
                return;
            }
            throw new IllegalArgumentException("'seed' cannot be null");
        }

        public final byte[] cca_continue() {
            return this.init.getInstance();
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.init);
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$CDHwithSHA384KDFAndSharedInfo */
    public final class CDHwithSHA384KDFAndSharedInfo {
        private static DHC Cardinal = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("ffffffffffffffffffffffff99def836146bc9b1b4d22831", 16);
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID.C2008init init = new getSDKAppID.C2008init(new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF", 16), new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16), new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) init, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) init, setTextDirection.getInstance("03188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012")), bigInteger, valueOf, setTextDirection.getInstance("3045AE6FC8422f64ED579528D38120EAE12196D5"));
            }
        };
        private static DHC CardinalActionCode = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("010092537397ECA4F6145799D62B0A19CE06FE26AD", 16);
                BigInteger valueOf = BigInteger.valueOf(65390);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(176, 1, 2, 43, new BigInteger("00E4E6DB2995065C407D9D39B8D0967B96704BA8E9C90B", 16), new BigInteger("005DDA470ABE6414DE8EC133AE28E9BBD7FCEC0AE0FFF2", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("038D16C2866798B600F9F08BB4A8E860F3298CE04A5798")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC CardinalConfigurationParameters = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("0101D556572AABAC800101D556572AABAC8001022D5C91DD173F8FB561DA6899164443051D", 16);
                BigInteger valueOf = BigInteger.valueOf(65070);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(304, 1, 2, 11, new BigInteger("00FD0D693149A118F651E6DCE6802085377E5F882D1B510B44160074C1288078365A0396C8E681", 16), new BigInteger("00BDDB97E555A50A908E43B01C798EA5DAA6788F1EA2794EFCF57166B8C14039601E55827340BE", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("02197B07845E9BE2D96ADB0F5F3C7F2CFFBD7A3EB8B6FEC35C7FD67F26DDF6285A644F740A2614")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC CardinalEnvironment = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("20000000000000000000000050508CB89F652824E06B8173", 16);
                BigInteger valueOf = BigInteger.valueOf(4);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(191, 9, new BigInteger("401028774D7777C7B7666D1366EA432071274F89FF01E718", 16), new BigInteger("0620048D28BCBD03B6249C99182B7C8CD19700C362C46A01", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("023809B2B7CC1B28CC5A87926AAD83FD28789E81E2C9E3BF10")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC CardinalError = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("0400000000000000000001E60FC8821CC74DAEAFC1", 16);
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(163, 1, 2, 8, new BigInteger("072546B5435234A422E0789675F432C89435DE5242", 16), new BigInteger("00C9517D06D5240D3CFF38C74B20B6CD4D6F9DD4D9", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("0307AF69989546103D79329FCC3D74880F33BBE803CB")), bigInteger, valueOf, setTextDirection.getInstance("D2C0FB15760860DEF1EEF4D696E6768756151754"));
            }
        };
        private static DHC CardinalRenderType = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("40000000000000000000000004A20E90C39067C893BBB9A5", 16);
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(191, 9, new BigInteger("2866537B676752636A68F56554E12640276B649EF7526267", 16), new BigInteger("2E45EF571F00786F67B0081B9495A3D95462F5DE0AA185EC", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("0236B3DAF8A23206F9C4F299D7B21A9C369137F2C84AE1AA0D")), bigInteger, valueOf, setTextDirection.getInstance("4E13CA542744D696E67687561517552F279A8C84"));
            }
        };
        private static DHC CardinalUiType = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("155555555555555555555555610C0B196812BFB6288A3EA3", 16);
                BigInteger valueOf = BigInteger.valueOf(6);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(191, 9, new BigInteger("6C01074756099122221056911C77D77E77A777E7E7E77FCB", 16), new BigInteger("71FE1AF926CF847989EFEF8DB459F66394D90F32AD3F15E8", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("03375D4CE24FDE434489DE8746E71786015009E66E38A926DD")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC cca_continue = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("ffffffffffffffffffffffff7a62d031c83f4294f640ec13", 16);
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID.C2008init init = new getSDKAppID.C2008init(new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF", 16), new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16), new BigInteger("22123dc2395a05caa7423daeccc94760a7d462256bd56916", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) init, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) init, setTextDirection.getInstance("027d29778100c65a1da1783716588dce2b8b4aee8e228f1896")), bigInteger, valueOf, setTextDirection.getInstance("c469684435deb378c4b65ca9591e2a5763059a2e"));
            }
        };
        private static DHC cleanup = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("ffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551", 16);
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID.C2008init init = new getSDKAppID.C2008init(new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853951"), new BigInteger("ffffffff00000001000000000000000000000000fffffffffffffffffffffffc", 16), new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) init, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) init, setTextDirection.getInstance("036b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296")), bigInteger, valueOf, setTextDirection.getInstance("c49d360886e704936a6678e1139d26b7819f7e90"));
            }
        };
        private static DHC configure = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("7fffffffffffffffffffffff800000cfa7e8594377d414c03821bc582063", 16);
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID.C2008init init = new getSDKAppID.C2008init(new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"), new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16), new BigInteger("617fab6832576cbbfed50d99f0249c3fee58b94ba0038c7ae84c8c832f2c", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) init, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) init, setTextDirection.getInstance("0238af09d98727705120c921bb5e9e26296a3cdcf2f35757a0eafd87b830e7")), bigInteger, valueOf, setTextDirection.getInstance("e8b4011604095303ca3b8099982be09fcb9ae616"));
            }
        };
        private static DHC getActionCode = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("1555555555555555555555555555553C6F2885259C31E3FCDF154624522D", 16);
                BigInteger valueOf = BigInteger.valueOf(6);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(239, 36, new BigInteger("4230017757A767FAE42398569B746325D45313AF0766266479B75654E65F", 16), new BigInteger("5037EA654196CFF0CD82B2C14A2FCF2E3FF8775285B545722F03EACDB74B", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("0228F9D04E900069C8DC47A08534FE76D2B900B7D7EF31F5709F200C4CA205")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static Hashtable getChallengeTimeout = new Hashtable();
        private static DHC getEnvironment = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("0340340340340340340340340340340340340340340340340340340323C313FAB50589703B5EC68D3587FEC60D161CC149C1AD4A91", 16);
                BigInteger valueOf = BigInteger.valueOf(10080);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(431, 120, new BigInteger("1A827EF00DD6FC0E234CAF046C6A5D8A85395B236CC4AD2CF32A0CADBDC9DDF620B0EB9906D0957F6C6FEACD615468DF104DE296CD8F", 16), new BigInteger("10D9B4A3D9047D8B154359ABFB1B7F5485B04CEB868237DDC9DEDA982A679A5A919B626D4E50A8DD731B107A9962381FB5D807BF2618", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("02120FC05D3C67A99DE161D2F4092622FECA701BE4F50F4758714E8A87BBF2A658EF8C21E7C5EFE965361F6C2999C0C247B0DBD70CE6B7")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC getInstance = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("7fffffffffffffffffffffff7fffff9e5e9a9f5d9071fbd1522688909d0b", 16);
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID.C2008init init = new getSDKAppID.C2008init(new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"), new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16), new BigInteger("6b016c3bdcf18941d0d654921475ca71a9db2fb27d1d37796185c2942c0a", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) init, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) init, setTextDirection.getInstance("020ffa963cdca8816ccc33b8642bedf905c3d358573d3f27fbbd3b3cb9aaaf")), bigInteger, valueOf, setTextDirection.getInstance("e43bb460f0b80cc0c0b075798e948060f8321b7d"));
            }
        };
        private static DHC getProxyAddress = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("010090512DA9AF72B08349D98A5DD4C7B0532ECA51CE03E2D10F3B7AC579BD87E909AE40A6F131E9CFCE5BD967", 16);
                BigInteger valueOf = BigInteger.valueOf(65392);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(368, 1, 2, 85, new BigInteger("00E0D2EE25095206F5E2A4F9ED229F1F256E79A0E2B455970D8D0D865BD94778C576D62F0AB7519CCD2A1A906AE30D", 16), new BigInteger("00FC1217D4320A90452C760A58EDCD30C8DD069B3C34453837A34ED50CB54917E1C2112D84D164F444F8F74786046A", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("021085E2755381DCCCE3C1557AFA10C2F0C0C2825646C5B34A394CBCFA8BC16B22E7E789E927BE216F02E1FB136A5F")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static Hashtable getRenderType = new Hashtable();
        private static DHC getRequestTimeout = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("0CCCCCCCCCCCCCCCCCCCCCCCCCCCCCAC4912D2D9DF903EF9888B8A0E4CFF", 16);
                BigInteger valueOf = BigInteger.valueOf(10);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(239, 36, new BigInteger("01238774666A67766D6676F778E676B66999176666E687666D8766C66A9F", 16), new BigInteger("6A941977BA9F6A435199ACFC51067ED587F519C5ECB541B8E44111DE1D40", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("0370F6E9D04D289C4E89913CE3530BFDE903977D42B146D539BF1BDE4E9C92")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC getSDKVersion = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("03FFFFFFFFFFFFFFFFFFFDF64DE1151ADBB78F10A7", 16);
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(163, 1, 2, 8, new BigInteger("0108B39E77C4B108BED981ED0E890E117C511CF072", 16), new BigInteger("0667ACEB38AF4E488C407433FFAE4F1C811638DF20", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("030024266E4EB5106D0A964D92C4860E2671DB9B6CC5")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC getString = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("2000000000000000000000000000000F4D42FFE1492A4993F1CAD666E447", 16);
                BigInteger valueOf = BigInteger.valueOf(4);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(239, 36, new BigInteger("32010857077C5431123A46B808906756F543423E8D27877578125778AC76", 16), new BigInteger("790408F2EEDAF392B012EDEFB3392F30F4327C0CA3F31FC383C422AA8C16", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("0257927098FA932E7C0A96D3FD5B706EF7E5F5C156E16B7E7C86038552E91D")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC getWarnings = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("7fffffffffffffffffffffff7fffff975deb41b3a6057c3c432146526551", 16);
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID.C2008init init = new getSDKAppID.C2008init(new BigInteger("883423532389192164791648750360308885314476597252960362792450860609699839"), new BigInteger("7fffffffffffffffffffffff7fffffffffff8000000000007ffffffffffc", 16), new BigInteger("255705fa2a306654b1f4cb03d6a750a30c250102d4988717d9ba15ab6d3e", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) init, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) init, setTextDirection.getInstance("036768ae8e18bb92cfcf005c949aa2c6d94853d0e660bbf854b1c9505fe95a")), bigInteger, valueOf, setTextDirection.getInstance("7d7374168ffe3471b60a857686a19475d3bfa2ff"));
            }
        };
        private static DHC init = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("fffffffffffffffffffffffe5fb1a724dc80418648d8dd31", 16);
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID.C2008init init = new getSDKAppID.C2008init(new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF", 16), new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16), new BigInteger("cc22d6dfb95c6b25e49c0d6364a4e5980c393aa21668d953", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) init, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) init, setTextDirection.getInstance("03eea2bae7e1497842f2de7769cfe9c989c072ad696f48034a")), bigInteger, valueOf, setTextDirection.getInstance("31a92ee2029fd10d901b113e990710f0d21ac6b6"));
            }
        };
        private static Hashtable setChallengeTimeout = new Hashtable();
        private static DHC setEnvironment = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("01AF286BCA1AF286BCA1AF286BCA1AF286BCA1AF286BC9FB8F6B85C556892C20A7EB964FE7719E74F490758D3B", 16);
                BigInteger valueOf = BigInteger.valueOf(76);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(359, 68, new BigInteger("5667676A654B20754F356EA92017D946567C46675556F19556A04616B567D223A5E05656FB549016A96656A557", 16), new BigInteger("2472E2D0197C49363F1FE7F5B6DB075D52B6947D135D8CA445805D39BC345626089687742B6329E70680231988", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("033C258EF3047767E7EDE0F1FDAA79DAEE3841366A132E163ACED4ED2401DF9C6BDCDE98E8E707C07A2239B1B097")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC setRequestTimeout = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("0100FAF51354E0E39E4892DF6E319C72C8161603FA45AA7B998A167B8F1E629521", 16);
                BigInteger valueOf = BigInteger.valueOf(65286);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(272, 1, 3, 56, new BigInteger("0091A091F03B5FBA4AB2CCF49C4EDD220FB028712D42BE752B2C40094DBACDB586FB20", 16), new BigInteger("7167EFC92BB2E3CE7C8AAAFF34E12A9C557003D7C73A6FAF003F99F6CC8482E540F7", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("026108BABB2CEEBCF787058A056CBE0CFE622D7723A289E08A07AE13EF0D10D171DD8D")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC valueOf = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("0101BAF95C9723C57B6C21DA2EFF2D5ED588BDD5717E212F9D", 16);
                BigInteger valueOf = BigInteger.valueOf(65096);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(208, 1, 2, 83, new BigInteger("0", 16), new BigInteger("00C8619ED45A62E6212E1160349E2BFA844439FAFC2A3FD1638F9E", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("0289FDFBE4ABE193DF9559ECF07AC0CE78554E2784EB8C1ED1A57A")), bigInteger, valueOf, (byte[]) null);
            }
        };
        private static DHC values = new DHC() {
            /* access modifiers changed from: protected */
            public final C1970DH init() {
                BigInteger bigInteger = new BigInteger("03FFFFFFFFFFFFFFFFFFFE1AEE140F110AFF961309", 16);
                BigInteger valueOf = BigInteger.valueOf(2);
                getSDKAppID.cca_continue cca_continue = new getSDKAppID.cca_continue(163, 1, 2, 8, new BigInteger("07A526C63D3E25A256A007699F5447E32AE456B50E", 16), new BigInteger("03F7061798EB99E238FD6F1BF95B48FEEB4854252B", 16), bigInteger, valueOf);
                return new C1970DH((getSDKAppID) cca_continue, new DHwithSHA224KDFAndSharedInfo((getSDKAppID) cca_continue, setTextDirection.getInstance("0202F9F87B7C574D0BDECF8A22E6524775F98CDEBDCB")), bigInteger, valueOf, (byte[]) null);
            }
        };

        public static String cca_continue(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (String) getRenderType.get(aSN1ObjectIdentifier);
        }

        public static ASN1ObjectIdentifier configure(String str) {
            return (ASN1ObjectIdentifier) getChallengeTimeout.get(setAnimation.getInstance(str));
        }

        public static Enumeration getInstance() {
            return getChallengeTimeout.keys();
        }

        public static C1970DH init(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            DHC dhc = (DHC) setChallengeTimeout.get(aSN1ObjectIdentifier);
            if (dhc != null) {
                return dhc.cca_continue();
            }
            return null;
        }

        public static C1970DH Cardinal(String str) {
            DHC dhc;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) getChallengeTimeout.get(setAnimation.getInstance(str));
            if (aSN1ObjectIdentifier == null || (dhc = (DHC) setChallengeTimeout.get(aSN1ObjectIdentifier)) == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ECKAEGwithSHA1KDF.setEnableLogging;
            DHC dhc = Cardinal;
            getChallengeTimeout.put("prime192v1", aSN1ObjectIdentifier);
            getRenderType.put(aSN1ObjectIdentifier, "prime192v1");
            setChallengeTimeout.put(aSN1ObjectIdentifier, dhc);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = ECKAEGwithSHA1KDF.setLocationDataConsentGiven;
            DHC dhc2 = init;
            getChallengeTimeout.put("prime192v2", aSN1ObjectIdentifier2);
            getRenderType.put(aSN1ObjectIdentifier2, "prime192v2");
            setChallengeTimeout.put(aSN1ObjectIdentifier2, dhc2);
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = ECKAEGwithSHA1KDF.isEnableLogging;
            DHC dhc3 = cca_continue;
            getChallengeTimeout.put("prime192v3", aSN1ObjectIdentifier3);
            getRenderType.put(aSN1ObjectIdentifier3, "prime192v3");
            setChallengeTimeout.put(aSN1ObjectIdentifier3, dhc3);
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = ECKAEGwithSHA1KDF.isLocationDataConsentGiven;
            DHC dhc4 = getInstance;
            getChallengeTimeout.put("prime239v1", aSN1ObjectIdentifier4);
            getRenderType.put(aSN1ObjectIdentifier4, "prime239v1");
            setChallengeTimeout.put(aSN1ObjectIdentifier4, dhc4);
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = ECKAEGwithSHA1KDF.getJSON;
            DHC dhc5 = configure;
            getChallengeTimeout.put("prime239v2", aSN1ObjectIdentifier5);
            getRenderType.put(aSN1ObjectIdentifier5, "prime239v2");
            setChallengeTimeout.put(aSN1ObjectIdentifier5, dhc5);
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = ECKAEGwithSHA1KDF.getProcessorTransactionId;
            DHC dhc6 = getWarnings;
            getChallengeTimeout.put("prime239v3", aSN1ObjectIdentifier6);
            getRenderType.put(aSN1ObjectIdentifier6, "prime239v3");
            setChallengeTimeout.put(aSN1ObjectIdentifier6, dhc6);
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = ECKAEGwithSHA1KDF.getExtendedData;
            DHC dhc7 = cleanup;
            getChallengeTimeout.put("prime256v1", aSN1ObjectIdentifier7);
            getRenderType.put(aSN1ObjectIdentifier7, "prime256v1");
            setChallengeTimeout.put(aSN1ObjectIdentifier7, dhc7);
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = ECKAEGwithSHA1KDF.getString;
            DHC dhc8 = CardinalError;
            getChallengeTimeout.put("c2pnb163v1", aSN1ObjectIdentifier8);
            getRenderType.put(aSN1ObjectIdentifier8, "c2pnb163v1");
            setChallengeTimeout.put(aSN1ObjectIdentifier8, dhc8);
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = ECKAEGwithSHA1KDF.getChallengeTimeout;
            DHC dhc9 = getSDKVersion;
            getChallengeTimeout.put("c2pnb163v2", aSN1ObjectIdentifier9);
            getRenderType.put(aSN1ObjectIdentifier9, "c2pnb163v2");
            setChallengeTimeout.put(aSN1ObjectIdentifier9, dhc9);
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = ECKAEGwithSHA1KDF.getEnvironment;
            DHC dhc10 = values;
            getChallengeTimeout.put("c2pnb163v3", aSN1ObjectIdentifier10);
            getRenderType.put(aSN1ObjectIdentifier10, "c2pnb163v3");
            setChallengeTimeout.put(aSN1ObjectIdentifier10, dhc10);
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = ECKAEGwithSHA1KDF.getProxyAddress;
            DHC dhc11 = CardinalActionCode;
            getChallengeTimeout.put("c2pnb176w1", aSN1ObjectIdentifier11);
            getRenderType.put(aSN1ObjectIdentifier11, "c2pnb176w1");
            setChallengeTimeout.put(aSN1ObjectIdentifier11, dhc11);
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = ECKAEGwithSHA1KDF.setChallengeTimeout;
            DHC dhc12 = CardinalRenderType;
            getChallengeTimeout.put("c2tnb191v1", aSN1ObjectIdentifier12);
            getRenderType.put(aSN1ObjectIdentifier12, "c2tnb191v1");
            setChallengeTimeout.put(aSN1ObjectIdentifier12, dhc12);
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = ECKAEGwithSHA1KDF.setEnvironment;
            DHC dhc13 = CardinalEnvironment;
            getChallengeTimeout.put("c2tnb191v2", aSN1ObjectIdentifier13);
            getRenderType.put(aSN1ObjectIdentifier13, "c2tnb191v2");
            setChallengeTimeout.put(aSN1ObjectIdentifier13, dhc13);
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = ECKAEGwithSHA1KDF.getUiType;
            DHC dhc14 = CardinalUiType;
            getChallengeTimeout.put("c2tnb191v3", aSN1ObjectIdentifier14);
            getRenderType.put(aSN1ObjectIdentifier14, "c2tnb191v3");
            setChallengeTimeout.put(aSN1ObjectIdentifier14, dhc14);
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = ECKAEGwithSHA1KDF.setProxyAddress;
            DHC dhc15 = valueOf;
            getChallengeTimeout.put("c2pnb208w1", aSN1ObjectIdentifier15);
            getRenderType.put(aSN1ObjectIdentifier15, "c2pnb208w1");
            setChallengeTimeout.put(aSN1ObjectIdentifier15, dhc15);
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = ECKAEGwithSHA1KDF.getRenderType;
            DHC dhc16 = getString;
            getChallengeTimeout.put("c2tnb239v1", aSN1ObjectIdentifier16);
            getRenderType.put(aSN1ObjectIdentifier16, "c2tnb239v1");
            setChallengeTimeout.put(aSN1ObjectIdentifier16, dhc16);
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = ECKAEGwithSHA1KDF.setUiType;
            DHC dhc17 = getActionCode;
            getChallengeTimeout.put("c2tnb239v2", aSN1ObjectIdentifier17);
            getRenderType.put(aSN1ObjectIdentifier17, "c2tnb239v2");
            setChallengeTimeout.put(aSN1ObjectIdentifier17, dhc17);
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = ECKAEGwithSHA1KDF.setRenderType;
            DHC dhc18 = getRequestTimeout;
            getChallengeTimeout.put("c2tnb239v3", aSN1ObjectIdentifier18);
            getRenderType.put(aSN1ObjectIdentifier18, "c2tnb239v3");
            setChallengeTimeout.put(aSN1ObjectIdentifier18, dhc18);
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = ECKAEGwithSHA1KDF.setUICustomization;
            DHC dhc19 = setRequestTimeout;
            getChallengeTimeout.put("c2pnb272w1", aSN1ObjectIdentifier19);
            getRenderType.put(aSN1ObjectIdentifier19, "c2pnb272w1");
            setChallengeTimeout.put(aSN1ObjectIdentifier19, dhc19);
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = ECKAEGwithSHA1KDF.getUICustomization;
            DHC dhc20 = CardinalConfigurationParameters;
            getChallengeTimeout.put("c2pnb304w1", aSN1ObjectIdentifier20);
            getRenderType.put(aSN1ObjectIdentifier20, "c2pnb304w1");
            setChallengeTimeout.put(aSN1ObjectIdentifier20, dhc20);
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = ECKAEGwithSHA1KDF.getThreeDSRequestorAppURL;
            DHC dhc21 = setEnvironment;
            getChallengeTimeout.put("c2tnb359v1", aSN1ObjectIdentifier21);
            getRenderType.put(aSN1ObjectIdentifier21, "c2tnb359v1");
            setChallengeTimeout.put(aSN1ObjectIdentifier21, dhc21);
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = ECKAEGwithSHA1KDF.isEnableDFSync;
            DHC dhc22 = getProxyAddress;
            getChallengeTimeout.put("c2pnb368w1", aSN1ObjectIdentifier22);
            getRenderType.put(aSN1ObjectIdentifier22, "c2pnb368w1");
            setChallengeTimeout.put(aSN1ObjectIdentifier22, dhc22);
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = ECKAEGwithSHA1KDF.setEnableDFSync;
            DHC dhc23 = getEnvironment;
            getChallengeTimeout.put("c2tnb431r1", aSN1ObjectIdentifier23);
            getRenderType.put(aSN1ObjectIdentifier23, "c2tnb431r1");
            setChallengeTimeout.put(aSN1ObjectIdentifier23, dhc23);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DH */
    public class C1970DH extends getThreeDSRequestorAppURL implements ECKAEGwithSHA1KDF {
        private static final BigInteger ASN1ObjectIdentifier = BigInteger.valueOf(1);
        public BigInteger Cardinal;
        private byte[] DH$Mappings;
        public getSDKAppID cca_continue;
        public DHwithSHA224KDFAndSharedInfo getInstance;
        public BigInteger init;
        private DHUC onValidated;

        public C1970DH(getSDKAppID getsdkappid, ChallengeParameters challengeParameters, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
            this(getsdkappid, new DHwithSHA224KDFAndSharedInfo(challengeParameters), bigInteger, bigInteger2, bArr);
        }

        public C1970DH(getSDKAppID getsdkappid, DHwithSHA224KDFAndSharedInfo dHwithSHA224KDFAndSharedInfo, BigInteger bigInteger, BigInteger bigInteger2) {
            this(getsdkappid, dHwithSHA224KDFAndSharedInfo, bigInteger, bigInteger2, (byte[]) null);
        }

        public static C1970DH configure(Object obj) {
            if (obj != null) {
                return new C1970DH(setThreeDSRequestorAppURL.cca_continue(obj));
            }
            return null;
        }

        public final byte[] init() {
            return setForegroundTintBlendMode.cca_continue(this.DH$Mappings);
        }

        private C1970DH(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            if (!(setthreedsrequestorappurl.Cardinal(0) instanceof setProxyAddress) || !new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(0)).Cardinal).equals(ASN1ObjectIdentifier)) {
                throw new IllegalArgumentException("bad version in X9ECParameters");
            }
            this.Cardinal = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(4)).Cardinal);
            if (setthreedsrequestorappurl.getInstance() == 6) {
                this.init = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(5)).Cardinal);
            }
            getProxyAddress Cardinal2 = setthreedsrequestorappurl.Cardinal(1);
            CDHwithSHA224KDFAndSharedInfo cDHwithSHA224KDFAndSharedInfo = new CDHwithSHA224KDFAndSharedInfo(Cardinal2 instanceof DHUC ? (DHUC) Cardinal2 : Cardinal2 != null ? new DHUC(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2)) : null, this.Cardinal, this.init, setThreeDSRequestorAppURL.cca_continue((Object) setthreedsrequestorappurl.Cardinal(2)));
            this.cca_continue = cDHwithSHA224KDFAndSharedInfo.cca_continue;
            getProxyAddress Cardinal3 = setthreedsrequestorappurl.Cardinal(3);
            if (Cardinal3 instanceof DHwithSHA224KDFAndSharedInfo) {
                this.getInstance = (DHwithSHA224KDFAndSharedInfo) Cardinal3;
            } else {
                this.getInstance = new DHwithSHA224KDFAndSharedInfo(this.cca_continue, (isEnableDFSync) Cardinal3);
            }
            this.DH$Mappings = cDHwithSHA224KDFAndSharedInfo.configure();
        }

        public C1970DH(getSDKAppID getsdkappid, DHwithSHA224KDFAndSharedInfo dHwithSHA224KDFAndSharedInfo, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
            this.cca_continue = getsdkappid;
            this.getInstance = dHwithSHA224KDFAndSharedInfo;
            this.Cardinal = bigInteger;
            this.init = bigInteger2;
            this.DH$Mappings = setForegroundTintBlendMode.cca_continue(bArr);
            if (getDeviceData.getInstance(getsdkappid)) {
                this.onValidated = new DHUC(getsdkappid.configure.Cardinal());
            } else if (getDeviceData.Cardinal(getsdkappid)) {
                int[] cca_continue2 = ((setContentCaptureSession) getsdkappid.configure).configure().cca_continue();
                if (cca_continue2.length == 3) {
                    this.onValidated = new DHUC(cca_continue2[2], cca_continue2[1]);
                } else if (cca_continue2.length == 5) {
                    this.onValidated = new DHUC(cca_continue2[4], cca_continue2[1], cca_continue2[2], cca_continue2[3]);
                } else {
                    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
                }
            } else {
                throw new IllegalArgumentException("'curve' is of an unsupported type");
            }
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(ASN1ObjectIdentifier));
            setforegroundtintblendmode.cca_continue.addElement(this.onValidated);
            setforegroundtintblendmode.cca_continue.addElement(new CDHwithSHA224KDFAndSharedInfo(this.cca_continue, this.DH$Mappings));
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.Cardinal));
            BigInteger bigInteger = this.init;
            if (bigInteger != null) {
                setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(bigInteger));
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUC */
    public final class DHUC extends getThreeDSRequestorAppURL implements ECKAEGwithSHA1KDF {
        ASN1ObjectIdentifier getInstance;
        setLocationDataConsentGiven init;

        public DHUC(int i, int i2) {
            this(i, i2, 0, 0);
        }

        DHUC(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.getInstance = ASN1ObjectIdentifier.getInstance(setthreedsrequestorappurl.Cardinal(0));
            this.init = setthreedsrequestorappurl.Cardinal(1).values();
        }

        public DHUC(BigInteger bigInteger) {
            this.getInstance = getSDKVersion;
            this.init = new setProxyAddress(bigInteger);
        }

        public DHUC(int i, int i2, int i3, int i4) {
            this.getInstance = CardinalError;
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) i));
            if (i3 == 0) {
                if (i4 == 0) {
                    setforegroundtintblendmode.cca_continue.addElement(cleanup);
                    setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) i2));
                } else {
                    throw new IllegalArgumentException("inconsistent k values");
                }
            } else if (i3 <= i2 || i4 <= i3) {
                throw new IllegalArgumentException("inconsistent k values");
            } else {
                setforegroundtintblendmode.cca_continue.addElement(getWarnings);
                setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) i2));
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) i3));
                setforegroundtintblendmode2.cca_continue.addElement(new setProxyAddress((long) i4));
                setforegroundtintblendmode.cca_continue.addElement(new GOST(setforegroundtintblendmode2));
            }
            this.init = new GOST(setforegroundtintblendmode);
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            setforegroundtintblendmode.cca_continue.addElement(this.init);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA1KDF */
    abstract class DHUwithSHA1KDF extends InputStream {
        private int configure;
        protected final InputStream getInstance;

        DHUwithSHA1KDF(InputStream inputStream, int i) {
            this.getInstance = inputStream;
            this.configure = i;
        }

        /* access modifiers changed from: package-private */
        public int getInstance() {
            return this.configure;
        }

        /* access modifiers changed from: protected */
        public final void cca_continue() {
            InputStream inputStream = this.getInstance;
            if (inputStream instanceof DHUwithSHA224CKDF) {
                DHUwithSHA224CKDF dHUwithSHA224CKDF = (DHUwithSHA224CKDF) inputStream;
                dHUwithSHA224CKDF.cca_continue = true;
                dHUwithSHA224CKDF.init();
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA256CKDF */
    public final class DHUwithSHA256CKDF {
        private static Hashtable Cardinal = new Hashtable();
        private static DHC cca_continue = new DHC() {
            public final C1970DH init() {
                BigInteger init = DHUwithSHA256CKDF.init("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
                BigInteger init2 = DHUwithSHA256CKDF.init("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
                BigInteger init3 = DHUwithSHA256CKDF.init("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
                BigInteger init4 = DHUwithSHA256CKDF.init("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID Cardinal = DHUwithSHA256CKDF.Cardinal(new getSDKAppID.C2008init(init, init2, init3, init4, valueOf));
                return new C1970DH(Cardinal, new DHwithSHA224KDFAndSharedInfo(Cardinal, setTextDirection.getInstance("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), init4, valueOf, (byte[]) null);
            }
        };
        private static Hashtable getInstance = new Hashtable();
        private static Hashtable init = new Hashtable();

        static /* synthetic */ getSDKAppID Cardinal(getSDKAppID getsdkappid) {
            return getsdkappid;
        }

        public static Enumeration Cardinal() {
            return getInstance.elements();
        }

        public static C1970DH configure(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            DHC dhc = (DHC) Cardinal.get(aSN1ObjectIdentifier);
            if (dhc == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        public static ASN1ObjectIdentifier configure(String str) {
            return (ASN1ObjectIdentifier) init.get(setAnimation.getInstance(str));
        }

        public static String getInstance(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (String) getInstance.get(aSN1ObjectIdentifier);
        }

        public static C1970DH getInstance(String str) {
            DHC dhc;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) init.get(setAnimation.getInstance(str));
            if (aSN1ObjectIdentifier == null || (dhc = (DHC) Cardinal.get(aSN1ObjectIdentifier)) == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        static /* synthetic */ BigInteger init(String str) {
            return new BigInteger(1, setTextDirection.getInstance(str));
        }

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = DHUwithSHA224KDF.Cardinal;
            DHC dhc = cca_continue;
            init.put(setAnimation.getInstance("FRP256v1"), aSN1ObjectIdentifier);
            getInstance.put(aSN1ObjectIdentifier, "FRP256v1");
            Cardinal.put(aSN1ObjectIdentifier, dhc);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA384CKDF */
    public interface DHUwithSHA384CKDF {
        public static final ASN1ObjectIdentifier Cardinal;
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(valueOf, "2");
        public static final ASN1ObjectIdentifier CardinalConfigurationParameters;
        public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier(valueOf, "4");
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(Cardinal, "4");
        public static final ASN1ObjectIdentifier CardinalRenderType;
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(valueOf, "3");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(Cardinal, "2");
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(Cardinal, "5");
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier(valueOf, "6");
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(Cardinal, "6");
        public static final ASN1ObjectIdentifier getString = new ASN1ObjectIdentifier(valueOf, "5");
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier(Cardinal, "3");
        public static final ASN1ObjectIdentifier init;
        public static final ASN1ObjectIdentifier valueOf;
        public static final ASN1ObjectIdentifier values;

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
            configure = aSN1ObjectIdentifier;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1.1");
            getInstance = aSN1ObjectIdentifier2;
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "4.1");
            Cardinal = aSN1ObjectIdentifier3;
            init = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
            new ASN1ObjectIdentifier(configure, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(getInstance, "5.1");
            values = aSN1ObjectIdentifier4;
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
            valueOf = aSN1ObjectIdentifier5;
            CardinalRenderType = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(values, "2");
            CardinalConfigurationParameters = aSN1ObjectIdentifier6;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1");
            new ASN1ObjectIdentifier(CardinalConfigurationParameters, "2");
            new ASN1ObjectIdentifier(CardinalConfigurationParameters, "3");
            new ASN1ObjectIdentifier(CardinalConfigurationParameters, "4");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA384KDF */
    public interface DHUwithSHA384KDF {
        public static final ASN1ObjectIdentifier Cardinal;
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(valueOf, "2");
        public static final ASN1ObjectIdentifier CardinalConfigurationParameters = new ASN1ObjectIdentifier(valueOf, "6");
        public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier(getSDKVersion, "3");
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(getSDKVersion, "2");
        public static final ASN1ObjectIdentifier CardinalRenderType;
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(valueOf, "3");
        public static final ASN1ObjectIdentifier cca_continue;
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(configure, "2");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier(getInstance, "2.1");
        public static final ASN1ObjectIdentifier getActionCode = new ASN1ObjectIdentifier(valueOf, "7");
        public static final ASN1ObjectIdentifier getChallengeTimeout;
        public static final ASN1ObjectIdentifier getEnvironment;
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier getProxyAddress = new ASN1ObjectIdentifier(getEnvironment, "3");
        public static final ASN1ObjectIdentifier getRenderType = new ASN1ObjectIdentifier(getEnvironment, "5");
        public static final ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier(valueOf, "4");
        public static final ASN1ObjectIdentifier getSDKVersion;
        public static final ASN1ObjectIdentifier getString = new ASN1ObjectIdentifier(valueOf, "5");
        public static final ASN1ObjectIdentifier getThreeDSRequestorAppURL = new ASN1ObjectIdentifier(setUiType, "3");
        public static final ASN1ObjectIdentifier getUICustomization = new ASN1ObjectIdentifier(setUiType, "2");
        public static final ASN1ObjectIdentifier getUiType = new ASN1ObjectIdentifier(getEnvironment, "7");
        public static final ASN1ObjectIdentifier getWarnings;
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier(Cardinal, "2");
        public static final ASN1ObjectIdentifier isEnableDFSync;
        public static final ASN1ObjectIdentifier setChallengeTimeout = new ASN1ObjectIdentifier(getEnvironment, "2");
        public static final ASN1ObjectIdentifier setEnableDFSync = new ASN1ObjectIdentifier(setUiType, "4");
        public static final ASN1ObjectIdentifier setEnvironment = new ASN1ObjectIdentifier(getEnvironment, "4");
        public static final ASN1ObjectIdentifier setProxyAddress = new ASN1ObjectIdentifier(getEnvironment, "8");
        public static final ASN1ObjectIdentifier setRenderType = new ASN1ObjectIdentifier(getEnvironment, "6");
        public static final ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier(valueOf, "8");
        public static final ASN1ObjectIdentifier setThreeDSRequestorAppURL = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(cca_continue, "3"), "1");
        public static final ASN1ObjectIdentifier setUICustomization = new ASN1ObjectIdentifier(setUiType, "5");
        public static final ASN1ObjectIdentifier setUiType;
        public static final ASN1ObjectIdentifier valueOf;
        public static final ASN1ObjectIdentifier values;

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
            cca_continue = aSN1ObjectIdentifier;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
            getInstance = aSN1ObjectIdentifier2;
            Cardinal = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
            new ASN1ObjectIdentifier(getInstance, "2.2");
            new ASN1ObjectIdentifier(getInstance, "2.3");
            new ASN1ObjectIdentifier(getInstance, "2.4");
            new ASN1ObjectIdentifier(Cardinal, "1");
            new ASN1ObjectIdentifier(configure, "1");
            new ASN1ObjectIdentifier(init, "1.2");
            new ASN1ObjectIdentifier(init, "1.22");
            new ASN1ObjectIdentifier(init, "1.42");
            new ASN1ObjectIdentifier(cleanup, "1.2");
            new ASN1ObjectIdentifier(cleanup, "1.22");
            new ASN1ObjectIdentifier(cleanup, "1.42");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(cca_continue, "2");
            values = aSN1ObjectIdentifier3;
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1");
            getSDKVersion = aSN1ObjectIdentifier4;
            getWarnings = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(values, "2");
            valueOf = aSN1ObjectIdentifier5;
            CardinalRenderType = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(values, "3");
            getEnvironment = aSN1ObjectIdentifier6;
            getChallengeTimeout = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier(values, "4");
            setUiType = aSN1ObjectIdentifier7;
            isEnableDFSync = new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "1");
            new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(cca_continue, "4"), "1");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA512CKDF */
    public interface DHUwithSHA512CKDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier(getInstance, "13.1");
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(getInstance, "32.2");
        public static final ASN1ObjectIdentifier CardinalConfigurationParameters = new ASN1ObjectIdentifier(getInstance, "36.1");
        public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier(getInstance, "35.1");
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(getInstance, "30.1");
        public static final ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier(getInstance, "32.3");
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(getInstance, "35.2");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(getInstance, ScarShareReportModel.CHANNEL_FACEBOOK);
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(getInstance, "3");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier(getInstance, "13.0");
        public static final ASN1ObjectIdentifier getActionCode = new ASN1ObjectIdentifier(getInstance, "36.0");
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier(getInstance, "98");
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(getInstance, DiFaceLogger.EVENT_ID_APPEAL_DIALOG_CANCEL);
        public static final ASN1ObjectIdentifier getString = new ASN1ObjectIdentifier(getInstance, "35.3");
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier(getInstance, "20");
        public static final ASN1ObjectIdentifier init;
        public static final ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier(getInstance, "96");
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(getInstance, "33.1");
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(getInstance, "4");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.643.2.2");
            getInstance = aSN1ObjectIdentifier;
            init = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "9");
            new ASN1ObjectIdentifier(getInstance, "10");
            new ASN1ObjectIdentifier(getInstance, "31.0");
            new ASN1ObjectIdentifier(getInstance, "31.1");
            new ASN1ObjectIdentifier(getInstance, "31.2");
            new ASN1ObjectIdentifier(getInstance, "31.3");
            new ASN1ObjectIdentifier(getInstance, "31.4");
            new ASN1ObjectIdentifier(getInstance, "32.4");
            new ASN1ObjectIdentifier(getInstance, "32.5");
            new ASN1ObjectIdentifier(getInstance, "33.2");
            new ASN1ObjectIdentifier(getInstance, "33.3");
            new ASN1ObjectIdentifier(getInstance, "36.0");
            new ASN1ObjectIdentifier(getInstance, "36.1");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHUwithSHA512KDF */
    public final class DHUwithSHA512KDF extends getThreeDSRequestorAppURL {
        private int Cardinal = 1024;
        public setProxyAddress cca_continue;
        public setProxyAddress configure;
        public setProxyAddress getInstance;

        public DHUwithSHA512KDF(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.cca_continue = new setProxyAddress(bigInteger);
            this.getInstance = new setProxyAddress(bigInteger2);
            this.configure = new setProxyAddress(bigInteger3);
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress((long) this.Cardinal));
            setforegroundtintblendmode.cca_continue.addElement(this.cca_continue);
            setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
            setforegroundtintblendmode.cca_continue.addElement(this.configure);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithRFC2631KDF */
    public final class DHwithRFC2631KDF {
        private static Hashtable Cardinal = new Hashtable();
        private static Hashtable configure = new Hashtable();
        private static Hashtable init = new Hashtable();

        public static String Cardinal(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (String) Cardinal.get(aSN1ObjectIdentifier);
        }

        public static BCRSAPublicKey cca_continue(String str) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) init.get(str);
            if (aSN1ObjectIdentifier != null) {
                return (BCRSAPublicKey) configure.get(aSN1ObjectIdentifier);
            }
            return null;
        }

        public static ASN1ObjectIdentifier configure(String str) {
            return (ASN1ObjectIdentifier) init.get(str);
        }

        public static Enumeration configure() {
            return Cardinal.elements();
        }

        public static BCRSAPublicKey init(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (BCRSAPublicKey) configure.get(aSN1ObjectIdentifier);
        }

        static {
            BigInteger bigInteger = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
            BigInteger bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
            getSDKAppID.C2008init init2 = new getSDKAppID.C2008init(bigInteger, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), bigInteger2, getSDKReferenceNumber.values);
            configure.put(DHUwithSHA512CKDF.CardinalEnvironment, new BCRSAPublicKey(init2, init2.Cardinal(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"), false), bigInteger2, getSDKReferenceNumber.values));
            BigInteger bigInteger3 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
            BigInteger bigInteger4 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
            getSDKAppID.C2008init init3 = new getSDKAppID.C2008init(bigInteger3, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"), bigInteger4, getSDKReferenceNumber.values);
            configure.put(DHUwithSHA512CKDF.getActionCode, new BCRSAPublicKey(init3, init3.Cardinal(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"), false), bigInteger4, getSDKReferenceNumber.values));
            BigInteger bigInteger5 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
            BigInteger bigInteger6 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
            getSDKAppID.C2008init init4 = new getSDKAppID.C2008init(bigInteger5, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"), bigInteger6, getSDKReferenceNumber.values);
            configure.put(DHUwithSHA512CKDF.CardinalUiType, new BCRSAPublicKey(init4, init4.Cardinal(new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124"), false), bigInteger6, getSDKReferenceNumber.values));
            BigInteger bigInteger7 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
            BigInteger bigInteger8 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
            getSDKAppID.C2008init init5 = new getSDKAppID.C2008init(bigInteger7, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger8, getSDKReferenceNumber.values);
            configure.put(DHUwithSHA512CKDF.CardinalConfigurationParameters, new BCRSAPublicKey(init5, init5.Cardinal(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"), false), bigInteger8, getSDKReferenceNumber.values));
            BigInteger bigInteger9 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
            BigInteger bigInteger10 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
            getSDKAppID.C2008init init6 = new getSDKAppID.C2008init(bigInteger9, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"), bigInteger10, getSDKReferenceNumber.values);
            configure.put(DHUwithSHA512CKDF.getString, new BCRSAPublicKey(init6, init6.Cardinal(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"), false), bigInteger10, getSDKReferenceNumber.values));
            BigInteger bigInteger11 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", 16);
            BigInteger bigInteger12 = new BigInteger("400000000000000000000000000000000FD8CDDFC87B6635C115AF556C360C67", 16);
            getSDKAppID.C2008init init7 = new getSDKAppID.C2008init(bigInteger11, new BigInteger("C2173F1513981673AF4892C23035A27CE25E2013BF95AA33B22C656F277E7335", 16), new BigInteger("295F9BAE7428ED9CCC20E7C359A9D41A22FCCD9108E17BF7BA9337A6F8AE9513", 16), bigInteger12, getSDKReferenceNumber.CardinalRenderType);
            configure.put(DSASigner.detDSA224.valueOf, new BCRSAPublicKey(init7, init7.Cardinal(new BigInteger("91E38443A5E82C0D880923425712B2BB658B9196932E02C78B2582FE742DAA28", 16), new BigInteger("32879423AB1A0375895786C4BB46E9565FDE0B5344766740AF268ADB32322E5C", 16), false), bigInteger12, getSDKReferenceNumber.CardinalRenderType));
            BigInteger bigInteger13 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
            BigInteger bigInteger14 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF27E69532F48D89116FF22B8D4E0560609B4B38ABFAD2B85DCACDB1411F10B275", 16);
            getSDKAppID.C2008init init8 = new getSDKAppID.C2008init(bigInteger13, new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC4", 16), new BigInteger("E8C2505DEDFC86DDC1BD0B2B6667F1DA34B82574761CB0E879BD081CFD0B6265EE3CB090F30D27614CB4574010DA90DD862EF9D4EBEE4761503190785A71C760", 16), bigInteger14, getSDKReferenceNumber.values);
            configure.put(DSASigner.detDSA224.CardinalEnvironment, new BCRSAPublicKey(init8, init8.Cardinal(new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003"), new BigInteger("7503CFE87A836AE3A61B8816E25450E6CE5E1C93ACF1ABC1778064FDCBEFA921DF1626BE4FD036E93D75E6A50E3A41E98028FE5FC235F5B889A589CB5215F2A4", 16), false), bigInteger14, getSDKReferenceNumber.values));
            BigInteger bigInteger15 = new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006F", 16);
            BigInteger bigInteger16 = new BigInteger("800000000000000000000000000000000000000000000000000000000000000149A1EC142565A545ACFDB77BD9D40CFA8B996712101BEA0EC6346C54374F25BD", 16);
            getSDKAppID.C2008init init9 = new getSDKAppID.C2008init(bigInteger15, new BigInteger("8000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006C", 16), new BigInteger("687D1B459DC841457E3E06CF6F5E2517B97C7D614AF138BCBF85DC806C4B289F3E965D2DB1416D217F8B276FAD1AB69C50F78BEE1FA3106EFB8CCBC7C5140116", 16), bigInteger16, getSDKReferenceNumber.values);
            configure.put(DSASigner.detDSA224.CardinalActionCode, new BCRSAPublicKey(init9, init9.Cardinal(new BigInteger("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002"), new BigInteger("1A8F7EDA389B094C2C071E3647A8940F3C123B697578C213BE6DD9E6C8EC7335DCB228FD1EDF4A39152CBCAAF8C0398828041055F94CEEEC7E21340780FE41BD", 16), false), bigInteger16, getSDKReferenceNumber.values));
            BigInteger bigInteger17 = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFDC7", 16);
            BigInteger bigInteger18 = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC98CDBA46506AB004C33A9FF5147502CC8EDA9E7A769A12694623CEF47F023ED", 16);
            getSDKAppID.C2008init init10 = new getSDKAppID.C2008init(bigInteger17, new BigInteger("DC9203E514A721875485A529D2C722FB187BC8980EB866644DE41C68E143064546E861C0E2C9EDD92ADE71F46FCF50FF2AD97F951FDA9F2A2EB6546F39689BD3", 16), new BigInteger("B4C4EE28CEBC6C2C8AC12952CF37F16AC7EFB6A9F69F4B57FFDA2E4F0DE5ADE038CBC2FFF719D2C18DE0284B8BFEF3B52B8CC7A5F5BF0A3C8D2319A5312557E1", 16), bigInteger18, getSDKReferenceNumber.CardinalRenderType);
            configure.put(DSASigner.detDSA224.CardinalUiType, new BCRSAPublicKey(init10, init10.Cardinal(new BigInteger("E2E31EDFC23DE7BDEBE241CE593EF5DE2295B7A9CBAEF021D385F7074CEA043AA27272A7AE602BF2A7B9033DB9ED3610C6FB85487EAE97AAC5BC7928C1950148", 16), new BigInteger("F5CE40D95B5EB899ABBCCFF5911CB8577939804D6527378B8C108C3D2090FF9BE18E2D33E3021ED2EF32D85822423B6304F726AA854BAE07D0396E9A9ADDC40F", 16), false), bigInteger18, getSDKReferenceNumber.CardinalRenderType));
            init.put("GostR3410-2001-CryptoPro-A", DHUwithSHA512CKDF.CardinalEnvironment);
            init.put("GostR3410-2001-CryptoPro-B", DHUwithSHA512CKDF.CardinalUiType);
            init.put("GostR3410-2001-CryptoPro-C", DHUwithSHA512CKDF.getString);
            init.put("GostR3410-2001-CryptoPro-XchA", DHUwithSHA512CKDF.getActionCode);
            init.put("GostR3410-2001-CryptoPro-XchB", DHUwithSHA512CKDF.CardinalConfigurationParameters);
            init.put("Tc26-Gost-3410-12-256-paramSetA", DSASigner.detDSA224.valueOf);
            init.put("Tc26-Gost-3410-12-512-paramSetA", DSASigner.detDSA224.CardinalEnvironment);
            init.put("Tc26-Gost-3410-12-512-paramSetB", DSASigner.detDSA224.CardinalActionCode);
            init.put("Tc26-Gost-3410-12-512-paramSetC", DSASigner.detDSA224.CardinalUiType);
            Cardinal.put(DHUwithSHA512CKDF.CardinalEnvironment, "GostR3410-2001-CryptoPro-A");
            Cardinal.put(DHUwithSHA512CKDF.CardinalUiType, "GostR3410-2001-CryptoPro-B");
            Cardinal.put(DHUwithSHA512CKDF.getString, "GostR3410-2001-CryptoPro-C");
            Cardinal.put(DHUwithSHA512CKDF.getActionCode, "GostR3410-2001-CryptoPro-XchA");
            Cardinal.put(DHUwithSHA512CKDF.CardinalConfigurationParameters, "GostR3410-2001-CryptoPro-XchB");
            Cardinal.put(DSASigner.detDSA224.valueOf, "Tc26-Gost-3410-12-256-paramSetA");
            Cardinal.put(DSASigner.detDSA224.CardinalEnvironment, "Tc26-Gost-3410-12-512-paramSetA");
            Cardinal.put(DSASigner.detDSA224.CardinalActionCode, "Tc26-Gost-3410-12-512-paramSetB");
            Cardinal.put(DSASigner.detDSA224.CardinalUiType, "Tc26-Gost-3410-12-512-paramSetC");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1CKDF */
    public final class DHwithSHA1CKDF extends getThreeDSRequestorAppURL {
        public ASN1ObjectIdentifier Cardinal;
        public ASN1ObjectIdentifier cca_continue;
        public ASN1ObjectIdentifier configure;

        public DHwithSHA1CKDF(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            this.cca_continue = (ASN1ObjectIdentifier) setthreedsrequestorappurl.Cardinal(0);
            this.Cardinal = (ASN1ObjectIdentifier) setthreedsrequestorappurl.Cardinal(1);
            if (setthreedsrequestorappurl.getInstance() > 2) {
                this.configure = (ASN1ObjectIdentifier) setthreedsrequestorappurl.Cardinal(2);
            }
        }

        public DHwithSHA1CKDF(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
            this.cca_continue = aSN1ObjectIdentifier;
            this.Cardinal = aSN1ObjectIdentifier2;
            this.configure = null;
        }

        public DHwithSHA1CKDF(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, ASN1ObjectIdentifier aSN1ObjectIdentifier3) {
            this.cca_continue = aSN1ObjectIdentifier;
            this.Cardinal = aSN1ObjectIdentifier2;
            this.configure = aSN1ObjectIdentifier3;
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.cca_continue);
            setforegroundtintblendmode.cca_continue.addElement(this.Cardinal);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = this.configure;
            if (aSN1ObjectIdentifier != null) {
                setforegroundtintblendmode.cca_continue.addElement(aSN1ObjectIdentifier);
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA1KDFAndSharedInfo */
    public final class DHwithSHA1KDFAndSharedInfo extends getThreeDSRequestorAppURL {
        private getAcsTransactionID Cardinal;

        public DHwithSHA1KDFAndSharedInfo(getAcsTransactionID getacstransactionid) {
            this.Cardinal = getacstransactionid;
        }

        public final setLocationDataConsentGiven values() {
            return new EdEC(DHwithSHA256KDFAndSharedInfo.configure(this.Cardinal.Cardinal(), (this.Cardinal.cca_continue() + 7) / 8));
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224CKDF */
    public interface DHwithSHA224CKDF {
        public static final ASN1ObjectIdentifier Cardinal;
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(cleanup, "5");
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(cleanup, "2");
        public static final ASN1ObjectIdentifier cca_continue;
        public static final ASN1ObjectIdentifier cleanup;
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(cleanup, "3");
        public static final ASN1ObjectIdentifier getWarnings;
        public static final ASN1ObjectIdentifier init;
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(cleanup, "4");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
            init = aSN1ObjectIdentifier;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2.2.1");
            Cardinal = aSN1ObjectIdentifier2;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
            new ASN1ObjectIdentifier(Cardinal, "2");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(init, "2.2.3");
            getInstance = aSN1ObjectIdentifier3;
            new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "1"), "1");
            new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(getInstance, "2"), "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(init, "2.2.2");
            cca_continue = aSN1ObjectIdentifier4;
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
            configure = aSN1ObjectIdentifier5;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
            new ASN1ObjectIdentifier(configure, "2");
            new ASN1ObjectIdentifier(configure, "3");
            new ASN1ObjectIdentifier(configure, "4");
            new ASN1ObjectIdentifier(configure, "5");
            new ASN1ObjectIdentifier(configure, "6");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(cca_continue, "2");
            cleanup = aSN1ObjectIdentifier6;
            getWarnings = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "1");
            new ASN1ObjectIdentifier(init, "3.1.2.1");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA224KDF */
    public interface DHwithSHA224KDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier(init, "301.101");
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(configure, "2.9");
        public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier(configure, "2.8");
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(configure, "2.6");
        public static final ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier(configure, "2.7");
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(configure, "2.10");
        public static final ASN1ObjectIdentifier cca_continue = new ASN1ObjectIdentifier(configure, "2.1");
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(configure, "2.5");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier(init, "301.3");
        public static final ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier(init, DiFaceLogger.EVENT_ID_SOURCE_PICTURES);
        public static final ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier(init, "501");
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(configure, "2.3");
        public static final ASN1ObjectIdentifier getString;
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier(configure, "2.2");
        public static final ASN1ObjectIdentifier init;
        public static final ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier(init, "503");
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(configure, IMGD.IM_DATA_VERSION);
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(configure, "2.4");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.156.10197.1");
            init = aSN1ObjectIdentifier;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "101.1");
            new ASN1ObjectIdentifier(init, "101.2");
            new ASN1ObjectIdentifier(init, "101.3");
            new ASN1ObjectIdentifier(init, "101.4");
            new ASN1ObjectIdentifier(init, "102.1");
            new ASN1ObjectIdentifier(init, "102.2");
            new ASN1ObjectIdentifier(init, "102.3");
            new ASN1ObjectIdentifier(init, "102.4");
            new ASN1ObjectIdentifier(init, "102.5");
            new ASN1ObjectIdentifier(init, "102.6");
            new ASN1ObjectIdentifier(init, "103.1");
            new ASN1ObjectIdentifier(init, "103.2");
            new ASN1ObjectIdentifier(init, "103.3");
            new ASN1ObjectIdentifier(init, "103.4");
            new ASN1ObjectIdentifier(init, "103.5");
            new ASN1ObjectIdentifier(init, "103.6");
            new ASN1ObjectIdentifier(init, "104.1");
            new ASN1ObjectIdentifier(init, "104.2");
            new ASN1ObjectIdentifier(init, "104.3");
            new ASN1ObjectIdentifier(init, "104.4");
            new ASN1ObjectIdentifier(init, "104.5");
            new ASN1ObjectIdentifier(init, "104.6");
            new ASN1ObjectIdentifier(init, "104.7");
            new ASN1ObjectIdentifier(init, "104.8");
            new ASN1ObjectIdentifier(init, "104.9");
            new ASN1ObjectIdentifier(init, "104.10");
            new ASN1ObjectIdentifier(init, "104.11");
            new ASN1ObjectIdentifier(init, "104.12");
            new ASN1ObjectIdentifier(init, "104.100");
            new ASN1ObjectIdentifier(init, "201");
            new ASN1ObjectIdentifier(init, "301.1");
            new ASN1ObjectIdentifier(init, "301.2");
            new ASN1ObjectIdentifier(configure, "1");
            new ASN1ObjectIdentifier(configure, "2");
            new ASN1ObjectIdentifier(init, DiFaceLogger.EVENT_ID_UPLOAD_PRE_PICTURES);
            new ASN1ObjectIdentifier(init, "302.1");
            new ASN1ObjectIdentifier(init, "302.2");
            new ASN1ObjectIdentifier(init, "302.3");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(init, "401");
            getString = aSN1ObjectIdentifier2;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2");
            new ASN1ObjectIdentifier(init, "502");
            new ASN1ObjectIdentifier(init, "504");
            new ASN1ObjectIdentifier(init, "505");
            new ASN1ObjectIdentifier(init, "506");
            new ASN1ObjectIdentifier(init, "507");
            new ASN1ObjectIdentifier(init, "520");
            new ASN1ObjectIdentifier(init, "521");
            new ASN1ObjectIdentifier(init, "522");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA256CKDF */
    public interface DHwithSHA256CKDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier(getInstance, "112").getInstance();
        public static final ASN1ObjectIdentifier cca_continue;
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier(getInstance, "111").getInstance();
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier(getInstance, "113").getInstance();

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.101");
            getInstance = aSN1ObjectIdentifier;
            cca_continue = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "110").getInstance();
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA256KDF */
    public final class DHwithSHA256KDF {
        private static Hashtable Cardinal = new Hashtable();
        private static DHC cca_continue = new DHC() {
            public final C1970DH init() {
                BigInteger instance = DHwithSHA256KDF.getInstance("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
                BigInteger instance2 = DHwithSHA256KDF.getInstance("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
                BigInteger instance3 = DHwithSHA256KDF.getInstance("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
                BigInteger instance4 = DHwithSHA256KDF.getInstance("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID configure = DHwithSHA256KDF.configure((getSDKAppID) new getSDKAppID.C2008init(instance, instance2, instance3, instance4, valueOf));
                return new C1970DH(configure, new DHwithSHA224KDFAndSharedInfo(configure, setTextDirection.getInstance("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), instance4, valueOf, (byte[]) null);
            }
        };
        private static Hashtable configure = new Hashtable();
        private static DHC getInstance = new DHC() {
            public final C1970DH init() {
                BigInteger instance = DHwithSHA256KDF.getInstance("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
                BigInteger instance2 = DHwithSHA256KDF.getInstance("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
                BigInteger instance3 = DHwithSHA256KDF.getInstance("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
                BigInteger instance4 = DHwithSHA256KDF.getInstance("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
                BigInteger valueOf = BigInteger.valueOf(1);
                getSDKAppID configure = DHwithSHA256KDF.configure((getSDKAppID) new getSDKAppID.C2008init(instance, instance2, instance3, instance4, valueOf));
                return new C1970DH(configure, new DHwithSHA224KDFAndSharedInfo(configure, setTextDirection.getInstance("044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2")), instance4, valueOf, (byte[]) null);
            }
        };
        private static Hashtable init = new Hashtable();

        public static String cca_continue(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (String) init.get(aSN1ObjectIdentifier);
        }

        static /* synthetic */ getSDKAppID configure(getSDKAppID getsdkappid) {
            return getsdkappid;
        }

        public static C1970DH getInstance(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            DHC dhc = (DHC) Cardinal.get(aSN1ObjectIdentifier);
            if (dhc == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        public static Enumeration getInstance() {
            return init.elements();
        }

        public static ASN1ObjectIdentifier init(String str) {
            return (ASN1ObjectIdentifier) configure.get(setAnimation.getInstance(str));
        }

        public static C1970DH configure(String str) {
            DHC dhc;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) configure.get(setAnimation.getInstance(str));
            if (aSN1ObjectIdentifier == null || (dhc = (DHC) Cardinal.get(aSN1ObjectIdentifier)) == null) {
                return null;
            }
            return dhc.cca_continue();
        }

        static /* synthetic */ BigInteger getInstance(String str) {
            return new BigInteger(1, setTextDirection.getInstance(str));
        }

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = DHwithSHA224KDF.Cardinal;
            DHC dhc = getInstance;
            configure.put(setAnimation.getInstance("wapip192v1"), aSN1ObjectIdentifier);
            init.put(aSN1ObjectIdentifier, "wapip192v1");
            Cardinal.put(aSN1ObjectIdentifier, dhc);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = DHwithSHA224KDF.getInstance;
            DHC dhc2 = cca_continue;
            configure.put(setAnimation.getInstance("sm2p256v1"), aSN1ObjectIdentifier2);
            init.put(aSN1ObjectIdentifier2, "sm2p256v1");
            Cardinal.put(aSN1ObjectIdentifier2, dhc2);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA256KDFAndSharedInfo */
    public class DHwithSHA256KDFAndSharedInfo implements ECKAEGwithSHA512KDF {
        public DigestSignatureSpi configure;
        public DigestSignatureSpi init;

        public DHwithSHA256KDFAndSharedInfo() {
        }

        public static byte[] configure(BigInteger bigInteger, int i) {
            byte[] byteArray = bigInteger.toByteArray();
            if (i < byteArray.length) {
                byte[] bArr = new byte[i];
                System.arraycopy(byteArray, byteArray.length - i, bArr, 0, i);
                return bArr;
            } else if (i <= byteArray.length) {
                return byteArray;
            } else {
                byte[] bArr2 = new byte[i];
                System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
                return bArr2;
            }
        }

        public DHwithSHA256KDFAndSharedInfo(DigestSignatureSpi digestSignatureSpi, DigestSignatureSpi digestSignatureSpi2) {
            if (digestSignatureSpi == null) {
                throw new NullPointerException("staticPublicKey cannot be null");
            } else if (digestSignatureSpi2 == null) {
                throw new NullPointerException("ephemeralPublicKey cannot be null");
            } else if (digestSignatureSpi.init.equals(digestSignatureSpi2.init)) {
                this.init = digestSignatureSpi;
                this.configure = digestSignatureSpi2;
            } else {
                throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA384CKDF */
    public interface DHwithSHA384CKDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.12.2");

        static {
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.1");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2.1");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.2.1.1");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.3");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.12");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.1");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.2");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.3");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.4");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.21");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.22");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.23");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.24");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.41");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.42");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.43");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.13.2.44");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.14");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.14.1");
            new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.15"), "1");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA384KDF */
    public interface DHwithSHA384KDF {
        public static final ASN1ObjectIdentifier Cardinal = new ASN1ObjectIdentifier(cca_continue, "55");
        public static final ASN1ObjectIdentifier cca_continue;
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier(cca_continue, DiFaceLogger.EVENT_ID_BI_DETECT_DONE);
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier init;

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("1.0.10118"), "3.0");
            cca_continue = aSN1ObjectIdentifier;
            init = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, DiFaceLogger.EVENT_ID_EXIT_SDK);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("1.0.18033.2");
            getInstance = aSN1ObjectIdentifier2;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1.2");
            new ASN1ObjectIdentifier(getInstance, "2.4");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$DHwithSHA512KDF */
    public interface DHwithSHA512KDF {
        public static final ASN1ObjectIdentifier Cardinal;
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(getSDKVersion, "1.4");
        public static final ASN1ObjectIdentifier CardinalEnvironment;
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(values, "66.10");
        public static final ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier(getSDKVersion, "1.2");
        public static final ASN1ObjectIdentifier cca_continue;
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier("1.3.6.1.4.1.188.7.1.1.2");
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier getInstance;
        public static final ASN1ObjectIdentifier getSDKVersion;
        public static final ASN1ObjectIdentifier getWarnings;
        public static final ASN1ObjectIdentifier init = new ASN1ObjectIdentifier(cca_continue, "3");
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(getSDKVersion, "1.3");
        public static final ASN1ObjectIdentifier values;

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.113730.1");
            cca_continue = aSN1ObjectIdentifier;
            Cardinal = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
            new ASN1ObjectIdentifier(cca_continue, "2");
            new ASN1ObjectIdentifier(cca_continue, "4");
            new ASN1ObjectIdentifier(cca_continue, "7");
            new ASN1ObjectIdentifier(cca_continue, "8");
            new ASN1ObjectIdentifier(cca_continue, "12");
            new ASN1ObjectIdentifier(cca_continue, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.16.840.1.113733.1");
            getInstance = aSN1ObjectIdentifier2;
            configure = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "6.3");
            new ASN1ObjectIdentifier(getInstance, "6.9");
            new ASN1ObjectIdentifier(getInstance, "6.11");
            new ASN1ObjectIdentifier(getInstance, "6.13");
            new ASN1ObjectIdentifier(getInstance, "6.15");
            new ASN1ObjectIdentifier(getInstance, "8.1");
            new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("2.16.840.1.113719"), "1.9.4.1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("1.2.840.113533.7");
            values = aSN1ObjectIdentifier3;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "65.0");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("1.3.6.1.4.1.3029"), "1");
            getSDKVersion = aSN1ObjectIdentifier4;
            getWarnings = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1.1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("1.3.6.1.4.1.1722.12.2");
            CardinalEnvironment = aSN1ObjectIdentifier5;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1.5");
            new ASN1ObjectIdentifier(CardinalEnvironment, "1.8");
            new ASN1ObjectIdentifier(CardinalEnvironment, "1.12");
            new ASN1ObjectIdentifier(CardinalEnvironment, "1.16");
            new ASN1ObjectIdentifier(CardinalEnvironment, "2.4");
            new ASN1ObjectIdentifier(CardinalEnvironment, "2.5");
            new ASN1ObjectIdentifier(CardinalEnvironment, "2.7");
            new ASN1ObjectIdentifier(CardinalEnvironment, "2.8");
            new ASN1ObjectIdentifier("1.3.6.1.4.1.11591.4.11");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA1KDF */
    public interface ECKAEGwithSHA1KDF {
        public static final ASN1ObjectIdentifier CardinalActionCode;
        public static final ASN1ObjectIdentifier CardinalConfigurationParameters = new ASN1ObjectIdentifier(CardinalActionCode, "3");
        public static final ASN1ObjectIdentifier CardinalEnvironment = new ASN1ObjectIdentifier(CardinalActionCode, "2");
        public static final ASN1ObjectIdentifier CardinalError;
        public static final ASN1ObjectIdentifier CardinalInitService;
        public static final ASN1ObjectIdentifier CardinalRenderType;
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier(configure, "2"), "1");
        public static final ASN1ObjectIdentifier CardinalValidateReceiver;
        public static final ASN1ObjectIdentifier Payment = new ASN1ObjectIdentifier("1.2.840.10040.4.1");
        public static final ASN1ObjectIdentifier ValidateResponse;
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(CardinalError, "3.2");
        public static final ASN1ObjectIdentifier configure;
        public static final ASN1ObjectIdentifier getActionCode = new ASN1ObjectIdentifier(CardinalActionCode, "4");
        public static final ASN1ObjectIdentifier getChallengeTimeout = new ASN1ObjectIdentifier(setRequestTimeout, "2");
        public static final ASN1ObjectIdentifier getEnvironment = new ASN1ObjectIdentifier(setRequestTimeout, "3");
        public static final ASN1ObjectIdentifier getErrorDescription;
        public static final ASN1ObjectIdentifier getErrorNumber = new ASN1ObjectIdentifier(ValidateResponse, "16");
        public static final ASN1ObjectIdentifier getExtendedData = new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "7");
        public static final ASN1ObjectIdentifier getJSON = new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "5");
        public static final ASN1ObjectIdentifier getPayment = new ASN1ObjectIdentifier(ValidateResponse, "3");
        public static final ASN1ObjectIdentifier getProcessorTransactionId = new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "6");
        public static final ASN1ObjectIdentifier getProxyAddress = new ASN1ObjectIdentifier(setRequestTimeout, "4");
        public static final ASN1ObjectIdentifier getRenderType = new ASN1ObjectIdentifier(setRequestTimeout, "11");
        public static final ASN1ObjectIdentifier getRequestTimeout;
        public static final ASN1ObjectIdentifier getSDKVersion;
        public static final ASN1ObjectIdentifier getString;
        public static final ASN1ObjectIdentifier getThreeDSRequestorAppURL = new ASN1ObjectIdentifier(setRequestTimeout, DiFaceLogger.EVENT_ID_ENTER_APPEAL_DIALOG);
        public static final ASN1ObjectIdentifier getType = new ASN1ObjectIdentifier("1.2.840.10040.4.3");
        public static final ASN1ObjectIdentifier getUICustomization = new ASN1ObjectIdentifier(setRequestTimeout, DiFaceLogger.EVENT_ID_BIOASSAY_EXIT);
        public static final ASN1ObjectIdentifier getUiType = new ASN1ObjectIdentifier(setRequestTimeout, "7");
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier(CardinalError, "3.3");
        public static final ASN1ObjectIdentifier isEnableDFSync = new ASN1ObjectIdentifier(setRequestTimeout, DiFaceLogger.EVENT_ID_APPEAL_DIALOG_CANCEL);
        public static final ASN1ObjectIdentifier isEnableLogging = new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "3");
        public static final ASN1ObjectIdentifier isLocationDataConsentGiven = new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "4");
        public static final ASN1ObjectIdentifier isValidated;
        public static final ASN1ObjectIdentifier onSetupCompleted;
        public static final ASN1ObjectIdentifier setChallengeTimeout = new ASN1ObjectIdentifier(setRequestTimeout, "5");
        public static final ASN1ObjectIdentifier setEnableDFSync = new ASN1ObjectIdentifier(setRequestTimeout, "20");
        public static final ASN1ObjectIdentifier setEnableLogging;
        public static final ASN1ObjectIdentifier setEnvironment = new ASN1ObjectIdentifier(setRequestTimeout, "6");
        public static final ASN1ObjectIdentifier setLocationDataConsentGiven = new ASN1ObjectIdentifier(setThreeDSRequestorAppURL, "2");
        public static final ASN1ObjectIdentifier setProxyAddress = new ASN1ObjectIdentifier(setRequestTimeout, "10");
        public static final ASN1ObjectIdentifier setRenderType = new ASN1ObjectIdentifier(setRequestTimeout, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
        public static final ASN1ObjectIdentifier setRequestTimeout;
        public static final ASN1ObjectIdentifier setThreeDSRequestorAppURL;
        public static final ASN1ObjectIdentifier setUICustomization = new ASN1ObjectIdentifier(setRequestTimeout, "16");
        public static final ASN1ObjectIdentifier setUiType = new ASN1ObjectIdentifier(setRequestTimeout, "12");
        public static final ASN1ObjectIdentifier valueOf;
        public static final ASN1ObjectIdentifier values;

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.10045");
            configure = aSN1ObjectIdentifier;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
            values = aSN1ObjectIdentifier2;
            getSDKVersion = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(values, "2");
            CardinalError = aSN1ObjectIdentifier3;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "3.1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(configure, "4");
            CardinalRenderType = aSN1ObjectIdentifier4;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(CardinalRenderType, "3");
            CardinalActionCode = aSN1ObjectIdentifier5;
            valueOf = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(configure, "3");
            getRequestTimeout = aSN1ObjectIdentifier6;
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "0");
            setRequestTimeout = aSN1ObjectIdentifier7;
            getString = new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "1");
            new ASN1ObjectIdentifier(setRequestTimeout, "8");
            new ASN1ObjectIdentifier(setRequestTimeout, "9");
            new ASN1ObjectIdentifier(setRequestTimeout, "14");
            new ASN1ObjectIdentifier(setRequestTimeout, DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier(getRequestTimeout, "1");
            setThreeDSRequestorAppURL = aSN1ObjectIdentifier8;
            setEnableLogging = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("1.3.133.16.840.63.0");
            ValidateResponse = aSN1ObjectIdentifier9;
            getErrorDescription = new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, "2");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("1.2.840.10046");
            isValidated = aSN1ObjectIdentifier10;
            onSetupCompleted = new ASN1ObjectIdentifier(aSN1ObjectIdentifier10, "2.1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier(isValidated, "3");
            CardinalValidateReceiver = aSN1ObjectIdentifier11;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "1");
            new ASN1ObjectIdentifier(CardinalValidateReceiver, "2");
            new ASN1ObjectIdentifier(CardinalValidateReceiver, "3");
            new ASN1ObjectIdentifier(CardinalValidateReceiver, "4");
            new ASN1ObjectIdentifier(CardinalValidateReceiver, "5");
            new ASN1ObjectIdentifier(CardinalValidateReceiver, "6");
            new ASN1ObjectIdentifier(CardinalValidateReceiver, "7");
            new ASN1ObjectIdentifier(CardinalValidateReceiver, "8");
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier(new ASN1ObjectIdentifier("1.3.133.16.840.9.44"), "1");
            CardinalInitService = aSN1ObjectIdentifier12;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "1");
            new ASN1ObjectIdentifier(CardinalInitService, "2");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECKAEGwithSHA256KDF */
    public class ECKAEGwithSHA256KDF {
        public boolean cca_continue;
        public DHwithSHA512KDFAndSharedInfo configure;
        public byte[] getInstance;
        public int init;

        public final void Cardinal() {
            int i = 0;
            while (true) {
                byte[] bArr = this.getInstance;
                if (i < bArr.length) {
                    bArr[i] = 0;
                    i++;
                } else {
                    this.init = 0;
                    this.configure.init();
                    return;
                }
            }
        }

        public final int configure() {
            return this.configure.cca_continue();
        }

        public int getInstance(int i) {
            int i2 = i + this.init;
            return i2 - (i2 % this.getInstance.length);
        }

        /* JADX INFO: finally extract failed */
        public int getInstance(byte[] bArr, int i) throws MQVwithSHA512KDFAndSharedInfo, IllegalStateException, KeyFactorySpi.ECDH {
            try {
                if (i + this.init > bArr.length) {
                    throw new KeyFactorySpi.ECDSA("output buffer too short for doFinal()");
                } else if (this.init == 0) {
                    Cardinal();
                    return 0;
                } else {
                    throw new MQVwithSHA512KDFAndSharedInfo("data not block size aligned");
                }
            } catch (Throwable th) {
                Cardinal();
                throw th;
            }
        }

        public final DHwithSHA512KDFAndSharedInfo getInstance() {
            return this.configure;
        }

        public int init(int i) {
            return i + this.init;
        }

        public void init(boolean z, ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) throws IllegalArgumentException {
            this.cca_continue = z;
            Cardinal();
            this.configure.Cardinal(z, eCKAEGwithSHA512KDF);
        }

        public int getInstance(byte[] bArr, int i, int i2, byte[] bArr2) throws MQVwithSHA512KDFAndSharedInfo, IllegalStateException {
            int i3;
            if (i2 >= 0) {
                int cca_continue2 = this.configure.cca_continue();
                int instance = getInstance(i2);
                if (instance <= 0 || instance <= bArr2.length) {
                    byte[] bArr3 = this.getInstance;
                    int length = bArr3.length;
                    int i4 = this.init;
                    int i5 = length - i4;
                    if (i2 > i5) {
                        System.arraycopy(bArr, i, bArr3, i4, i5);
                        i3 = this.configure.init(this.getInstance, 0, bArr2, 0) + 0;
                        this.init = 0;
                        i2 -= i5;
                        i += i5;
                        while (i2 > this.getInstance.length) {
                            i3 += this.configure.init(bArr, i, bArr2, i3);
                            i2 -= cca_continue2;
                            i += cca_continue2;
                        }
                    } else {
                        i3 = 0;
                    }
                    System.arraycopy(bArr, i, this.getInstance, this.init, i2);
                    int i6 = this.init + i2;
                    this.init = i6;
                    byte[] bArr4 = this.getInstance;
                    if (i6 != bArr4.length) {
                        return i3;
                    }
                    int init2 = i3 + this.configure.init(bArr4, 0, bArr2, i3);
                    this.init = 0;
                    return init2;
                }
                throw new KeyFactorySpi.ECDSA("output buffer too short");
            }
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECVKO */
    public final class ECVKO extends SignatureSpi.ecDSAnone {
        public ECVKO() {
            this(256);
        }

        public final int configure(byte[] bArr, int i) {
            Cardinal(2, 2);
            return super.configure(bArr, i);
        }

        public final String configure() {
            StringBuilder sb = new StringBuilder("SHA3-");
            sb.append(this.configure);
            return sb.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ECVKO(int i) {
            super(i);
            if (i == 224 || i == 256 || i == 384 || i == 512) {
                return;
            }
            StringBuilder sb = new StringBuilder("'bitLength' ");
            sb.append(i);
            sb.append(" not supported for SHA-3");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$ECVKO256 */
    public final class ECVKO256 implements DHwithSHA384KDFAndSharedInfo {
        private boolean Cardinal;
        private int CardinalError = -1;
        private SecureRandom cca_continue;
        private DHwithSHA384KDFAndSharedInfo configure;
        private boolean getInstance;
        private byte[] getWarnings;
        private boolean init;

        public ECVKO256(DHwithSHA384KDFAndSharedInfo dHwithSHA384KDFAndSharedInfo) {
            this.configure = dHwithSHA384KDFAndSharedInfo;
            this.Cardinal = cca_continue();
        }

        private boolean cca_continue() {
            String str = (String) AccessController.doPrivileged(new PrivilegedAction() {
                public final Object run() {
                    return System.getProperty("com.cardinalcommerce.dependencies.internal.bouncycastle.pkcs1.strict");
                }
            });
            String str2 = (String) AccessController.doPrivileged(new PrivilegedAction() {
                public final Object run() {
                    return System.getProperty("com.cardinalcommerce.dependencies.internal.bouncycastle.pkcs1.not_strict");
                }
            });
            return str2 != null ? !str2.equals("true") : str == null || str.equals("true");
        }

        public final byte[] Cardinal(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
            return this.getInstance ? cca_continue(bArr, i, i2) : init(bArr, i, i2);
        }

        public final int configure() {
            int configure2 = this.configure.configure();
            return this.getInstance ? configure2 : configure2 - 10;
        }

        public final int getInstance() {
            int instance = this.configure.getInstance();
            return this.getInstance ? instance - 10 : instance;
        }

        public final void Cardinal(boolean z, ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            setKeyboardNavigationCluster setkeyboardnavigationcluster;
            if (eCKAEGwithSHA512KDF instanceof ISOSignatureSpi.SHA224WithRSAEncryption) {
                ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
                this.cca_continue = sHA224WithRSAEncryption.configure;
                setkeyboardnavigationcluster = (setKeyboardNavigationCluster) sHA224WithRSAEncryption.getInstance;
            } else {
                setkeyboardnavigationcluster = (setKeyboardNavigationCluster) eCKAEGwithSHA512KDF;
                if (!setkeyboardnavigationcluster.getInstance() && z) {
                    this.cca_continue = MQV.cca_continue();
                }
            }
            this.configure.Cardinal(z, eCKAEGwithSHA512KDF);
            this.init = setkeyboardnavigationcluster.getInstance();
            this.getInstance = z;
            this.getWarnings = new byte[this.configure.configure()];
            if (this.CardinalError > 0 && this.cca_continue == null) {
                throw new IllegalArgumentException("encoder requires random");
            }
        }

        private byte[] cca_continue(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
            int instance = this.configure.getInstance();
            if (this.getInstance) {
                instance -= 10;
            }
            if (i2 <= instance) {
                int instance2 = this.configure.getInstance();
                byte[] bArr2 = new byte[instance2];
                if (this.init) {
                    bArr2[0] = 1;
                    for (int i3 = 1; i3 != (instance2 - i2) - 1; i3++) {
                        bArr2[i3] = -1;
                    }
                } else {
                    this.cca_continue.nextBytes(bArr2);
                    bArr2[0] = 2;
                    for (int i4 = 1; i4 != (instance2 - i2) - 1; i4++) {
                        while (bArr2[i4] == 0) {
                            bArr2[i4] = (byte) this.cca_continue.nextInt();
                        }
                    }
                }
                int i5 = instance2 - i2;
                bArr2[i5 - 1] = 0;
                System.arraycopy(bArr, i, bArr2, i5, i2);
                return this.configure.Cardinal(bArr2, 0, instance2);
            }
            throw new IllegalArgumentException("input data too large");
        }

        private byte[] getInstance(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
            if (this.init) {
                byte[] Cardinal2 = this.configure.Cardinal(bArr, i, i2);
                byte[] bArr2 = new byte[this.CardinalError];
                this.cca_continue.nextBytes(bArr2);
                if (this.Cardinal && (Cardinal2.length != this.configure.configure())) {
                    Cardinal2 = this.getWarnings;
                }
                int i3 = this.CardinalError;
                byte b = (Cardinal2[0] ^ 2) | 0;
                int i4 = i3 + 1;
                int length = Cardinal2.length - i4;
                for (int i5 = 1; i5 < length; i5++) {
                    byte b2 = Cardinal2[i5];
                    byte b3 = b2 | (b2 >> 1);
                    byte b4 = b3 | (b3 >> 2);
                    b |= ((b4 | (b4 >> 4)) & 1) - 1;
                }
                byte b5 = Cardinal2[Cardinal2.length - i4] | b;
                byte b6 = b5 | (b5 >> 1);
                byte b7 = b6 | (b6 >> 2);
                int i6 = ~(((b7 | (b7 >> 4)) & 1) - 1);
                byte[] bArr3 = new byte[this.CardinalError];
                int i7 = 0;
                while (true) {
                    int i8 = this.CardinalError;
                    if (i7 >= i8) {
                        break;
                    }
                    bArr3[i7] = (byte) ((Cardinal2[(Cardinal2.length - i8) + i7] & (~i6)) | (bArr2[i7] & i6));
                    i7++;
                }
                for (int i9 = 0; i9 < Cardinal2.length; i9++) {
                    Cardinal2[i9] = 0;
                }
                return bArr3;
            }
            throw new KeyFactorySpi.ECDH("sorry, this method is only for decryption, not for signing");
        }

        private byte[] init(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
            int i3 = -1;
            if (this.CardinalError != -1) {
                return getInstance(bArr, i, i2);
            }
            byte[] Cardinal2 = this.configure.Cardinal(bArr, i, i2);
            boolean z = true;
            boolean z2 = this.Cardinal & (Cardinal2.length != this.configure.configure());
            int length = Cardinal2.length;
            int configure2 = this.configure.configure();
            if (!this.getInstance) {
                configure2 -= 10;
            }
            if (length < configure2) {
                Cardinal2 = this.getWarnings;
            }
            byte b = Cardinal2[0];
            boolean z3 = !this.init ? b != 1 : b != 2;
            boolean z4 = false;
            int i4 = -1;
            for (int i5 = 1; i5 != Cardinal2.length; i5++) {
                byte b2 = Cardinal2[i5];
                if ((b2 == 0) && (i4 < 0)) {
                    i4 = i5;
                }
                z4 |= (b2 != -1) & (b == 1) & (i4 < 0);
            }
            if (!z4) {
                i3 = i4;
            }
            int i6 = i3 + 1;
            if (i6 >= 10) {
                z = false;
            }
            if (z3 || z) {
                for (int i7 = 0; i7 < Cardinal2.length; i7++) {
                    Cardinal2[i7] = 0;
                }
                throw new KeyFactorySpi.ECDH("block incorrect");
            } else if (z2) {
                for (int i8 = 0; i8 < Cardinal2.length; i8++) {
                    Cardinal2[i8] = 0;
                }
                throw new KeyFactorySpi.ECDH("block incorrect size");
            } else {
                int length2 = Cardinal2.length - i6;
                byte[] bArr2 = new byte[length2];
                System.arraycopy(Cardinal2, i6, bArr2, 0, length2);
                return bArr2;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQV */
    public final class MQV {
        private static final Map<String, Object[]> configure = Collections.synchronizedMap(new HashMap());
        private static final ThreadLocal<Map<String, Object[]>> getInstance = new ThreadLocal<>();

        /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQV$configure */
        public static final class C1976configure {
            public static final C1976configure getInstance = new C1976configure("dsaDefaultParams", BCGOST3410PublicKey.class);
            public static final C1976configure init = new C1976configure("dhDefaultParams", CipherSpi.class);
            /* access modifiers changed from: private */
            public final Class Cardinal;
            /* access modifiers changed from: private */
            public final String cca_continue;

            static {
                new C1976configure("ecImplicitlyCA", C1970DH.class);
            }

            private C1976configure(String str, Class cls) {
                this.cca_continue = str;
                this.Cardinal = cls;
            }
        }

        static {
            new ECKAEGwithSHA384KDF(CryptoServicesPermission.GLOBAL_CONFIG);
            new ECKAEGwithSHA384KDF(CryptoServicesPermission.THREAD_LOCAL_CONFIG);
            new ECKAEGwithSHA384KDF(CryptoServicesPermission.DEFAULT_RANDOM);
            BCGOST3410PublicKey bCGOST3410PublicKey = new BCGOST3410PublicKey(new BigInteger("fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151bdc43ee737592e17", 16), new BigInteger("962eddcc369cba8ebb260ee6b6a126d9346e38c5", 16), new BigInteger("678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a6c416e50be794ca4", 16), new CipherSpi.OAEPPadding(setTextDirection.getInstance("b869c82b35d70e1b1ff91b28e37a62ecdc34409b"), 123));
            BCGOST3410PublicKey bCGOST3410PublicKey2 = new BCGOST3410PublicKey(new BigInteger("e9e642599d355f37c97ffd3567120b8e25c9cd43e927b3a9670fbec5d890141922d2c3b3ad2480093799869d1e846aab49fab0ad26d2ce6a22219d470bce7d777d4a21fbe9c270b57f607002f3cef8393694cf45ee3688c11a8c56ab127a3daf", 16), new BigInteger("9cdbd84c9f1ac2f38d0f80f42ab952e7338bf511", 16), new BigInteger("30470ad5a005fb14ce2d9dcd87e38bc7d1b1c5facbaecbe95f190aa7a31d23c4dbbcbe06174544401a5b2c020965d8c2bd2171d3668445771f74ba084d2029d83c1c158547f3a9f1a2715be23d51ae4d3e5a1f6a7064f316933a346d3f529252", 16), new CipherSpi.OAEPPadding(setTextDirection.getInstance("77d0f8c4dad15eb8c4f2f8d6726cefd96d5bb399"), 263));
            BCGOST3410PublicKey bCGOST3410PublicKey3 = new BCGOST3410PublicKey(new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16), new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16), new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16), new CipherSpi.OAEPPadding(setTextDirection.getInstance("8d5155894229d5e689ee01e6018a237e2cae64cd"), 92));
            BCGOST3410PublicKey bCGOST3410PublicKey4 = new BCGOST3410PublicKey(new BigInteger("95475cf5d93e596c3fcd1d902add02f427f5f3c7210313bb45fb4d5bb2e5fe1cbd678cd4bbdd84c9836be1f31c0777725aeb6c2fc38b85f48076fa76bcd8146cc89a6fb2f706dd719898c2083dc8d896f84062e2c9c94d137b054a8d8096adb8d51952398eeca852a0af12df83e475aa65d4ec0c38a9560d5661186ff98b9fc9eb60eee8b030376b236bc73be3acdbd74fd61c1d2475fa3077b8f080467881ff7e1ca56fee066d79506ade51edbb5443a563927dbc4ba520086746175c8885925ebc64c6147906773496990cb714ec667304e261faee33b3cbdf008e0c3fa90650d97d3909c9275bf4ac86ffcb3d03e6dfc8ada5934242dd6d3bcca2a406cb0b", 16), new BigInteger("f8183668ba5fc5bb06b5981e6d8b795d30b8978d43ca0ec572e37e09939a9773", 16), new BigInteger("42debb9da5b3d88cc956e08787ec3f3a09bba5f48b889a74aaf53174aa0fbe7e3c5b8fcd7a53bef563b0e98560328960a9517f4014d3325fc7962bf1e049370d76d1314a76137e792f3f0db859d095e4a5b932024f079ecf2ef09c797452b0770e1350782ed57ddf794979dcef23cb96f183061965c4ebc93c9c71c56b925955a75f94cccf1449ac43d586d0beee43251b0b2287349d68de0d144403f13e802f4146d882e057af19b6f6275c6676c8fa0e3ca2713a3257fd1b27d0639f695e347d8d1cf9ac819a26ca9b04cb0eb9b7b035988d15bbac65212a55239cfc7e58fae38d7250ab9991ffbc97134025fe8ce04c4399ad96569be91a546f4978693c7a", 16), new CipherSpi.OAEPPadding(setTextDirection.getInstance("b0b4417601b59cbc9d8ac8f935cadaec4f5fbb2f23785609ae466748d9b5a536"), 497));
            cca_continue(C1976configure.getInstance, bCGOST3410PublicKey, bCGOST3410PublicKey2, bCGOST3410PublicKey3, bCGOST3410PublicKey4);
            cca_continue(C1976configure.init, init(bCGOST3410PublicKey), init(bCGOST3410PublicKey2), init(bCGOST3410PublicKey3), init(bCGOST3410PublicKey4));
        }

        public static SecureRandom cca_continue() {
            return new SecureRandom();
        }

        public static <T> T init(C1976configure configure2, int i) {
            Map<String, Object[]> map = getInstance.get();
            if (map == null || !map.containsKey(configure2.cca_continue)) {
                map = configure;
            }
            T[] tArr = (Object[]) map.get(configure2.cca_continue);
            if (tArr == null) {
                return null;
            }
            int i2 = 0;
            if (configure2.Cardinal.isAssignableFrom(CipherSpi.class)) {
                while (i2 != tArr.length) {
                    T t = (CipherSpi) tArr[i2];
                    if (t.Cardinal.bitLength() == i) {
                        return t;
                    }
                    i2++;
                }
            } else if (configure2.Cardinal.isAssignableFrom(BCGOST3410PublicKey.class)) {
                while (i2 != tArr.length) {
                    T t2 = (BCGOST3410PublicKey) tArr[i2];
                    if (t2.init.bitLength() == i) {
                        return t2;
                    }
                    i2++;
                }
            }
            return null;
        }

        private static <T> void cca_continue(C1976configure configure2, T... tArr) {
            if (configure2.Cardinal.isAssignableFrom(tArr[0].getClass())) {
                Map map = getInstance.get();
                if (map == null) {
                    map = new HashMap();
                    getInstance.set(map);
                }
                map.put(configure2.cca_continue, tArr);
                configure.put(configure2.cca_continue, tArr);
                return;
            }
            throw new IllegalArgumentException("Bad property value passed");
        }

        private static CipherSpi init(BCGOST3410PublicKey bCGOST3410PublicKey) {
            int bitLength = bCGOST3410PublicKey.init.bitLength();
            return new CipherSpi(bCGOST3410PublicKey.init, bCGOST3410PublicKey.cca_continue, bCGOST3410PublicKey.getInstance, bitLength > 1024 ? bitLength <= 2048 ? 224 : bitLength <= 3072 ? 256 : bitLength <= 7680 ? 384 : 512 : 160, 0, (BigInteger) null, new CipherSpi.NoPadding(bCGOST3410PublicKey.configure.init(), bCGOST3410PublicKey.configure.Cardinal));
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA224KDF */
    public interface MQVwithSHA224KDF {
        public static final ASN1ObjectIdentifier Cardinal;
        public static final ASN1ObjectIdentifier CardinalActionCode = new ASN1ObjectIdentifier(cca_continue, "9");
        public static final ASN1ObjectIdentifier CardinalConfigurationParameters = new ASN1ObjectIdentifier(CardinalEnvironment, "5");
        public static final ASN1ObjectIdentifier CardinalEnvironment;
        public static final ASN1ObjectIdentifier CardinalError = new ASN1ObjectIdentifier(cca_continue, "6");
        public static final ASN1ObjectIdentifier CardinalInitService;
        public static final ASN1ObjectIdentifier CardinalRenderType = new ASN1ObjectIdentifier(cca_continue, "12");
        public static final ASN1ObjectIdentifier CardinalUiType = new ASN1ObjectIdentifier(cca_continue, "10");
        public static final ASN1ObjectIdentifier Payment = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "7");
        public static final ASN1ObjectIdentifier ValidateResponse = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "9");
        public static final ASN1ObjectIdentifier cca_continue;
        public static final ASN1ObjectIdentifier cleanup = new ASN1ObjectIdentifier(cca_continue, "7");
        public static final ASN1ObjectIdentifier configure = new ASN1ObjectIdentifier(cca_continue, "2");
        public static final ASN1ObjectIdentifier getActionCode = new ASN1ObjectIdentifier(CardinalEnvironment, "4");
        public static final ASN1ObjectIdentifier getChallengeTimeout = new ASN1ObjectIdentifier(CardinalEnvironment, "7");
        public static final ASN1ObjectIdentifier getEnvironment = new ASN1ObjectIdentifier(CardinalEnvironment, ScarShareReportModel.CHANNEL_WHATSAPP);
        public static final ASN1ObjectIdentifier getErrorDescription = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "12");
        public static final ASN1ObjectIdentifier getErrorNumber = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "11");
        public static final ASN1ObjectIdentifier getExtendedData = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "4");
        public static final ASN1ObjectIdentifier getInstance = new ASN1ObjectIdentifier(cca_continue, "3");
        public static final ASN1ObjectIdentifier getJSON = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "8");
        public static final ASN1ObjectIdentifier getPayment = new ASN1ObjectIdentifier(setLocationDataConsentGiven, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
        public static final ASN1ObjectIdentifier getProcessorTransactionId = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "6");
        public static final ASN1ObjectIdentifier getProxyAddress = new ASN1ObjectIdentifier(CardinalEnvironment, "6");
        public static final ASN1ObjectIdentifier getRenderType = new ASN1ObjectIdentifier(CardinalEnvironment, ScarShareReportModel.CHANNEL_EMAIL);
        public static final ASN1ObjectIdentifier getRequestTimeout = new ASN1ObjectIdentifier(CardinalEnvironment, "3");
        public static final ASN1ObjectIdentifier getSDKVersion = new ASN1ObjectIdentifier(cca_continue, "4");
        public static final ASN1ObjectIdentifier getString;
        public static final ASN1ObjectIdentifier getThreeDSRequestorAppURL = new ASN1ObjectIdentifier(CardinalEnvironment, "44");
        public static final ASN1ObjectIdentifier getType = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "5");
        public static final ASN1ObjectIdentifier getUICustomization = new ASN1ObjectIdentifier(CardinalEnvironment, RoomMasterTable.DEFAULT_ID);
        public static final ASN1ObjectIdentifier getUiType = new ASN1ObjectIdentifier(CardinalEnvironment, ScarShareReportModel.CHANNEL_LINE);
        public static final ASN1ObjectIdentifier getWarnings = new ASN1ObjectIdentifier(cca_continue, "8");
        public static final ASN1ObjectIdentifier init;
        public static final ASN1ObjectIdentifier isEnableDFSync = new ASN1ObjectIdentifier(CardinalEnvironment, DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CANCEL);
        public static final ASN1ObjectIdentifier isEnableLogging;
        public static final ASN1ObjectIdentifier isLocationDataConsentGiven = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "3");
        public static final ASN1ObjectIdentifier isValidated = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "10");
        public static final ASN1ObjectIdentifier onSetupCompleted = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "16");
        public static final ASN1ObjectIdentifier onValidated = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "14");
        public static final ASN1ObjectIdentifier setChallengeTimeout = new ASN1ObjectIdentifier(CardinalEnvironment, ScarShareReportModel.CHANNEL_FACEBOOK);
        public static final ASN1ObjectIdentifier setEnableDFSync = new ASN1ObjectIdentifier(CardinalEnvironment, "43");
        public static final ASN1ObjectIdentifier setEnableLogging = new ASN1ObjectIdentifier(setLocationDataConsentGiven, "2");
        public static final ASN1ObjectIdentifier setEnvironment = new ASN1ObjectIdentifier(CardinalEnvironment, ScarShareReportModel.CHANNEL_TWITTER);
        public static final ASN1ObjectIdentifier setLocationDataConsentGiven;
        public static final ASN1ObjectIdentifier setProxyAddress = new ASN1ObjectIdentifier(CardinalEnvironment, "27");
        public static final ASN1ObjectIdentifier setRenderType = new ASN1ObjectIdentifier(CardinalEnvironment, ScarShareReportModel.CHANNEL_MESSENGER);
        public static final ASN1ObjectIdentifier setRequestTimeout = new ASN1ObjectIdentifier(CardinalEnvironment, "2");
        public static final ASN1ObjectIdentifier setThreeDSRequestorAppURL = new ASN1ObjectIdentifier(CardinalEnvironment, DiFaceLogger.EVENT_ID_SDK_EXIT_DIALOG_CONFIRM);
        public static final ASN1ObjectIdentifier setUICustomization = new ASN1ObjectIdentifier(CardinalEnvironment, "45");
        public static final ASN1ObjectIdentifier setUiType = new ASN1ObjectIdentifier(CardinalEnvironment, "41");
        public static final ASN1ObjectIdentifier valueOf = new ASN1ObjectIdentifier(cca_continue, "11");
        public static final ASN1ObjectIdentifier values = new ASN1ObjectIdentifier(cca_continue, "5");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.101.3.4");
            init = aSN1ObjectIdentifier;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2");
            cca_continue = aSN1ObjectIdentifier2;
            Cardinal = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "1");
            new ASN1ObjectIdentifier(cca_continue, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
            new ASN1ObjectIdentifier(cca_continue, "14");
            new ASN1ObjectIdentifier(cca_continue, DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = cca_continue;
            String str = DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH;
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "16");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(init, "1");
            CardinalEnvironment = aSN1ObjectIdentifier4;
            getString = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "1");
            new ASN1ObjectIdentifier(CardinalEnvironment, "8");
            new ASN1ObjectIdentifier(CardinalEnvironment, "28");
            new ASN1ObjectIdentifier(CardinalEnvironment, DiFaceLogger.EVENT_ID_PERMISSION_PARTIAL_GRANTED_IN_APPEAL);
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(init, "3");
            setLocationDataConsentGiven = aSN1ObjectIdentifier5;
            isEnableLogging = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "1");
            CardinalInitService = new ASN1ObjectIdentifier(setLocationDataConsentGiven, str);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA256CKDF */
    public final class MQVwithSHA256CKDF extends getThreeDSRequestorAppURL {
        public setProxyAddress Cardinal;
        public setProxyAddress configure;

        public MQVwithSHA256CKDF(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            Enumeration cca_continue = setthreedsrequestorappurl.cca_continue();
            this.configure = (setProxyAddress) cca_continue.nextElement();
            this.Cardinal = (setProxyAddress) cca_continue.nextElement();
        }

        public MQVwithSHA256CKDF(BigInteger bigInteger, BigInteger bigInteger2) {
            this.configure = new setProxyAddress(bigInteger);
            this.Cardinal = new setProxyAddress(bigInteger2);
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.configure);
            setforegroundtintblendmode.cca_continue.addElement(this.Cardinal);
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA384CKDF */
    public final class MQVwithSHA384CKDF {
        private static Hashtable cca_continue = new Hashtable();
        private static Hashtable getInstance = new Hashtable();

        public static String Cardinal(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            return (String) getInstance.get(aSN1ObjectIdentifier);
        }

        public static Enumeration cca_continue() {
            return cca_continue.keys();
        }

        public static ASN1ObjectIdentifier init(String str) {
            return (ASN1ObjectIdentifier) cca_continue.get(setAnimation.Cardinal(str));
        }

        public static C1970DH getInstance(String str) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) cca_continue.get(setAnimation.Cardinal(str));
            if (aSN1ObjectIdentifier != null) {
                return DSASigner.detDSA256.getInstance(aSN1ObjectIdentifier);
            }
            return null;
        }

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = DSASigner.detDSASha3_224.setEnableDFSync;
            cca_continue.put("B-571", aSN1ObjectIdentifier);
            getInstance.put(aSN1ObjectIdentifier, "B-571");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = DSASigner.detDSASha3_224.setUiType;
            cca_continue.put("B-409", aSN1ObjectIdentifier2);
            getInstance.put(aSN1ObjectIdentifier2, "B-409");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = DSASigner.detDSASha3_224.CardinalActionCode;
            cca_continue.put("B-283", aSN1ObjectIdentifier3);
            getInstance.put(aSN1ObjectIdentifier3, "B-283");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = DSASigner.detDSASha3_224.getActionCode;
            cca_continue.put("B-233", aSN1ObjectIdentifier4);
            getInstance.put(aSN1ObjectIdentifier4, "B-233");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = DSASigner.detDSASha3_224.valueOf;
            cca_continue.put("B-163", aSN1ObjectIdentifier5);
            getInstance.put(aSN1ObjectIdentifier5, "B-163");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = DSASigner.detDSASha3_224.getUICustomization;
            cca_continue.put("K-571", aSN1ObjectIdentifier6);
            getInstance.put(aSN1ObjectIdentifier6, "K-571");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = DSASigner.detDSASha3_224.setProxyAddress;
            cca_continue.put("K-409", aSN1ObjectIdentifier7);
            getInstance.put(aSN1ObjectIdentifier7, "K-409");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = DSASigner.detDSASha3_224.CardinalEnvironment;
            cca_continue.put("K-283", aSN1ObjectIdentifier8);
            getInstance.put(aSN1ObjectIdentifier8, "K-283");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = DSASigner.detDSASha3_224.getRequestTimeout;
            cca_continue.put("K-233", aSN1ObjectIdentifier9);
            getInstance.put(aSN1ObjectIdentifier9, "K-233");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = DSASigner.detDSASha3_224.Cardinal;
            cca_continue.put("K-163", aSN1ObjectIdentifier10);
            getInstance.put(aSN1ObjectIdentifier10, "K-163");
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = DSASigner.detDSASha3_224.setRenderType;
            cca_continue.put("P-521", aSN1ObjectIdentifier11);
            getInstance.put(aSN1ObjectIdentifier11, "P-521");
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = DSASigner.detDSASha3_224.getUiType;
            cca_continue.put("P-384", aSN1ObjectIdentifier12);
            getInstance.put(aSN1ObjectIdentifier12, "P-384");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = DSASigner.detDSASha3_224.isEnableDFSync;
            cca_continue.put("P-256", aSN1ObjectIdentifier13);
            getInstance.put(aSN1ObjectIdentifier13, "P-256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = DSASigner.detDSASha3_224.getRenderType;
            cca_continue.put("P-224", aSN1ObjectIdentifier14);
            getInstance.put(aSN1ObjectIdentifier14, "P-224");
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = DSASigner.detDSASha3_224.getThreeDSRequestorAppURL;
            cca_continue.put("P-192", aSN1ObjectIdentifier15);
            getInstance.put(aSN1ObjectIdentifier15, "P-192");
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA384KDF */
    public final class MQVwithSHA384KDF extends getThreeDSRequestorAppURL {
        public setProxyAddress Cardinal;
        public setProxyAddress configure;
        public setProxyAddress init;

        public MQVwithSHA384KDF(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            Enumeration cca_continue = setthreedsrequestorappurl.cca_continue();
            this.init = setProxyAddress.Cardinal(cca_continue.nextElement());
            this.configure = setProxyAddress.Cardinal(cca_continue.nextElement());
            this.Cardinal = cca_continue.hasMoreElements() ? (setProxyAddress) cca_continue.nextElement() : null;
        }

        public MQVwithSHA384KDF(BigInteger bigInteger, BigInteger bigInteger2, int i) {
            this.init = new setProxyAddress(bigInteger);
            this.configure = new setProxyAddress(bigInteger2);
            this.Cardinal = i != 0 ? new setProxyAddress((long) i) : null;
        }

        public final setLocationDataConsentGiven values() {
            BigInteger bigInteger;
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.init);
            setforegroundtintblendmode.cca_continue.addElement(this.configure);
            setProxyAddress setproxyaddress = this.Cardinal;
            if (setproxyaddress == null) {
                bigInteger = null;
            } else {
                bigInteger = new BigInteger(1, setproxyaddress.Cardinal);
            }
            if (bigInteger != null) {
                setforegroundtintblendmode.cca_continue.addElement(this.Cardinal);
            }
            return new GOST(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$MQVwithSHA512CKDF */
    public final class MQVwithSHA512CKDF extends getThreeDSRequestorAppURL implements KeyFactorySpi {
        private getProxyAddress getErrorDescription;
        private ASN1ObjectIdentifier getPayment;
        private boolean onSetupCompleted = true;

        public MQVwithSHA512CKDF(ASN1ObjectIdentifier aSN1ObjectIdentifier, getProxyAddress getproxyaddress) {
            this.getPayment = aSN1ObjectIdentifier;
            this.getErrorDescription = getproxyaddress;
        }

        MQVwithSHA512CKDF(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
            Enumeration cca_continue = setthreedsrequestorappurl.cca_continue();
            this.getPayment = (ASN1ObjectIdentifier) cca_continue.nextElement();
            if (cca_continue.hasMoreElements()) {
                getType gettype = (getType) cca_continue.nextElement();
                this.getErrorDescription = gettype.getInstance != null ? gettype.getInstance.values() : null;
            }
            this.onSetupCompleted = setthreedsrequestorappurl instanceof ValidateResponse;
        }

        public final setLocationDataConsentGiven values() {
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            setforegroundtintblendmode.cca_continue.addElement(this.getPayment);
            getProxyAddress getproxyaddress = this.getErrorDescription;
            if (getproxyaddress != null) {
                setforegroundtintblendmode.cca_continue.addElement(new onValidated(true, 0, getproxyaddress));
            }
            return this.onSetupCompleted ? new ValidateResponse(setforegroundtintblendmode) : new IESCipher.IESwithAESCBC(setforegroundtintblendmode);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519 */
    public final class X25519 implements ECKAEGwithRIPEMD160KDF {
        public SignatureSpi.Ed25519 init;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.init = (SignatureSpi.Ed25519) gOST3410Util;
        }

        public final ExtendedInvalidKeySpecException init() {
            X25519UwithSHA256CKDF x25519UwithSHA256CKDF = X25519UwithSHA256CKDF.init;
            CipherSpi cipherSpi = this.init.init;
            BigInteger init2 = X25519UwithSHA256CKDF.init(cipherSpi, this.init.getInstance);
            return new ExtendedInvalidKeySpecException(new CipherSpi.PKCS1v1_5Padding(X25519UwithSHA256CKDF.getInstance(cipherSpi, init2), cipherSpi), new BCElGamalPublicKey(init2, cipherSpi));
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519UwithSHA256CKDF */
    final class X25519UwithSHA256CKDF {
        private static final BigInteger Cardinal = BigInteger.valueOf(1);
        private static final BigInteger cca_continue = BigInteger.valueOf(2);
        static final X25519UwithSHA256CKDF init = new X25519UwithSHA256CKDF();

        private X25519UwithSHA256CKDF() {
        }

        static BigInteger init(CipherSpi cipherSpi, SecureRandom secureRandom) {
            BigInteger init2;
            BigInteger bit;
            int i = cipherSpi.getSDKVersion;
            if (i != 0) {
                int i2 = i >>> 2;
                do {
                    bit = setSelected.configure(i, secureRandom).setBit(i - 1);
                } while (createTransaction.cca_continue(bit) < i2);
                return bit;
            }
            BigInteger bigInteger = cca_continue;
            int i3 = cipherSpi.init;
            if (i3 != 0) {
                bigInteger = Cardinal.shiftLeft(i3 - 1);
            }
            BigInteger bigInteger2 = cipherSpi.getInstance;
            if (bigInteger2 == null) {
                bigInteger2 = cipherSpi.Cardinal;
            }
            BigInteger subtract = bigInteger2.subtract(cca_continue);
            int bitLength = subtract.bitLength() >>> 2;
            do {
                init2 = setSelected.init(bigInteger, subtract, secureRandom);
            } while (createTransaction.cca_continue(init2) < bitLength);
            return init2;
        }

        static BigInteger getInstance(CipherSpi cipherSpi, BigInteger bigInteger) {
            return cipherSpi.configure.modPow(bigInteger, cipherSpi.Cardinal);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519UwithSHA256KDF */
    public final class X25519UwithSHA256KDF {
        private DigestSignatureSpi.MD4 Cardinal;
        private final C1978configure cca_continue;
        private SecureRandom cleanup;
        public int configure;
        public final MQVwithSHA256KDFAndSharedInfo getInstance;
        private BCRSAPublicKey getWarnings;
        private boolean init;

        /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519UwithSHA256KDF$4 */
        static /* synthetic */ class C19774 {
            static final /* synthetic */ int[] Cardinal;

            static {
                int[] iArr = new int[C1978configure.values().length];
                Cardinal = iArr;
                try {
                    iArr[C1978configure.C1C3C2.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
            }
        }

        /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519UwithSHA256KDF$configure */
        public enum C1978configure {
            C1C2C3,
            C1C3C2
        }

        public X25519UwithSHA256KDF() {
            this(new BCECGOST3410PublicKey());
        }

        public X25519UwithSHA256KDF(MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
            this(mQVwithSHA256KDFAndSharedInfo, C1978configure.C1C2C3);
        }

        private X25519UwithSHA256KDF(MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, C1978configure configure2) {
            if (configure2 != null) {
                this.getInstance = mQVwithSHA256KDFAndSharedInfo;
                this.cca_continue = configure2;
                return;
            }
            throw new IllegalArgumentException("mode cannot be NULL");
        }

        private static boolean getInstance(byte[] bArr, byte[] bArr2, int i) {
            for (int i2 = 0; i2 != bArr.length; i2++) {
                if (bArr[i2] != bArr2[i + i2]) {
                    return false;
                }
            }
            return true;
        }

        public final byte[] cca_continue(byte[] bArr, int i) throws KeyFactorySpi.ECDH {
            return this.init ? init(bArr, 0, i) : configure(bArr, 0, i);
        }

        public final void configure(boolean z, ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF) {
            this.init = z;
            if (z) {
                ISOSignatureSpi.SHA224WithRSAEncryption sHA224WithRSAEncryption = (ISOSignatureSpi.SHA224WithRSAEncryption) eCKAEGwithSHA512KDF;
                DigestSignatureSpi.MD4 md4 = (DigestSignatureSpi.MD4) sHA224WithRSAEncryption.getInstance;
                this.Cardinal = md4;
                this.getWarnings = md4.init;
                if (!((DigestSignatureSpi) this.Cardinal).cca_continue.configure(this.getWarnings.getInstance).valueOf()) {
                    this.cleanup = sHA224WithRSAEncryption.configure;
                } else {
                    throw new IllegalArgumentException("invalid key: [h]Q at infinity");
                }
            } else {
                DigestSignatureSpi.MD4 md42 = (DigestSignatureSpi.MD4) eCKAEGwithSHA512KDF;
                this.Cardinal = md42;
                this.getWarnings = md42.init;
            }
            this.configure = (this.getWarnings.Cardinal.configure() + 7) / 8;
        }

        private byte[] init(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
            BigInteger configure2;
            byte[] configure3;
            ChallengeParameters CardinalRenderType;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            setAcsRefNumber setacsrefnumber = new setAcsRefNumber();
            do {
                int bitLength = this.getWarnings.cca_continue.bitLength();
                while (true) {
                    configure2 = setSelected.configure(bitLength, this.cleanup);
                    if (!configure2.equals(setSelected.getInstance) && configure2.compareTo(this.getWarnings.cca_continue) < 0) {
                        break;
                    }
                }
                configure3 = setacsrefnumber.configure(this.getWarnings.init, configure2).CardinalRenderType().configure(false);
                CardinalRenderType = ((DigestSignatureSpi) this.Cardinal).cca_continue.configure(configure2).CardinalRenderType();
                Cardinal(this.getInstance, CardinalRenderType, bArr2);
            } while (getInstance(bArr2, bArr, 0));
            byte[] bArr3 = new byte[this.getInstance.getInstance()];
            MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
            byte[] Cardinal2 = setSelected.Cardinal(this.configure, CardinalRenderType.getSDKVersion().Cardinal());
            mQVwithSHA256KDFAndSharedInfo.init(Cardinal2, 0, Cardinal2.length);
            this.getInstance.init(bArr, 0, i2);
            MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.getInstance;
            if (CardinalRenderType.CardinalEnvironment()) {
                byte[] Cardinal3 = setSelected.Cardinal(this.configure, CardinalRenderType.CardinalError().Cardinal());
                mQVwithSHA256KDFAndSharedInfo2.init(Cardinal3, 0, Cardinal3.length);
                this.getInstance.configure(bArr3, 0);
                return C19774.Cardinal[this.cca_continue.ordinal()] != 1 ? setForegroundTintBlendMode.init(configure3, bArr2, bArr3) : setForegroundTintBlendMode.init(configure3, bArr3, bArr2);
            }
            throw new IllegalStateException("point not in normal form");
        }

        private byte[] configure(byte[] bArr, int i, int i2) throws KeyFactorySpi.ECDH {
            byte b;
            int i3 = (this.configure << 1) + 1;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            ChallengeParameters configure2 = this.getWarnings.Cardinal.configure(bArr2);
            if (!configure2.configure(this.getWarnings.getInstance).valueOf()) {
                ChallengeParameters CardinalRenderType = configure2.configure(((DigestSignatureSpi.MD2) this.Cardinal).Cardinal).CardinalRenderType();
                int instance = this.getInstance.getInstance();
                int i4 = (i2 - i3) - instance;
                byte[] bArr3 = new byte[i4];
                if (this.cca_continue == C1978configure.C1C3C2) {
                    System.arraycopy(bArr, i3 + 0 + instance, bArr3, 0, i4);
                } else {
                    System.arraycopy(bArr, i3 + 0, bArr3, 0, i4);
                }
                Cardinal(this.getInstance, CardinalRenderType, bArr3);
                int instance2 = this.getInstance.getInstance();
                byte[] bArr4 = new byte[instance2];
                MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.getInstance;
                byte[] Cardinal2 = setSelected.Cardinal(this.configure, CardinalRenderType.getSDKVersion().Cardinal());
                mQVwithSHA256KDFAndSharedInfo.init(Cardinal2, 0, Cardinal2.length);
                this.getInstance.init(bArr3, 0, i4);
                MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.getInstance;
                if (CardinalRenderType.CardinalEnvironment()) {
                    byte[] Cardinal3 = setSelected.Cardinal(this.configure, CardinalRenderType.CardinalError().Cardinal());
                    mQVwithSHA256KDFAndSharedInfo2.init(Cardinal3, 0, Cardinal3.length);
                    this.getInstance.configure(bArr4, 0);
                    if (this.cca_continue == C1978configure.C1C3C2) {
                        b = 0;
                        for (int i5 = 0; i5 != instance2; i5++) {
                            b |= bArr4[i5] ^ bArr[(i3 + 0) + i5];
                        }
                    } else {
                        byte b2 = 0;
                        for (int i6 = 0; i6 != instance2; i6++) {
                            b2 = b | (bArr4[i6] ^ bArr[((i3 + 0) + i4) + i6]);
                        }
                    }
                    for (int i7 = 0; i7 < i3; i7++) {
                        bArr2[i7] = 0;
                    }
                    for (int i8 = 0; i8 < instance2; i8++) {
                        bArr4[i8] = 0;
                    }
                    if (b == 0) {
                        return bArr3;
                    }
                    for (int i9 = 0; i9 < i4; i9++) {
                        bArr3[i9] = 0;
                    }
                    throw new KeyFactorySpi.ECDH("invalid cipher text");
                }
                throw new IllegalStateException("point not in normal form");
            }
            throw new KeyFactorySpi.ECDH("[h]C1 at infinity");
        }

        private void Cardinal(MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, ChallengeParameters challengeParameters, byte[] bArr) {
            setPaddingRelative setpaddingrelative;
            MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = mQVwithSHA256KDFAndSharedInfo;
            byte[] bArr2 = bArr;
            int instance = mQVwithSHA256KDFAndSharedInfo.getInstance();
            byte[] bArr3 = new byte[Math.max(4, instance)];
            setPaddingRelative setpaddingrelative2 = null;
            if (mQVwithSHA256KDFAndSharedInfo2 instanceof setPaddingRelative) {
                byte[] Cardinal2 = setSelected.Cardinal(this.configure, challengeParameters.getSDKVersion().Cardinal());
                mQVwithSHA256KDFAndSharedInfo2.init(Cardinal2, 0, Cardinal2.length);
                if (challengeParameters.CardinalEnvironment()) {
                    byte[] Cardinal3 = setSelected.Cardinal(this.configure, challengeParameters.CardinalError().Cardinal());
                    mQVwithSHA256KDFAndSharedInfo2.init(Cardinal3, 0, Cardinal3.length);
                    setpaddingrelative2 = (setPaddingRelative) mQVwithSHA256KDFAndSharedInfo2;
                    setpaddingrelative = setpaddingrelative2.init();
                } else {
                    throw new IllegalStateException("point not in normal form");
                }
            } else {
                setpaddingrelative = null;
            }
            int i = 0;
            int i2 = 0;
            while (i < bArr2.length) {
                if (setpaddingrelative2 != null) {
                    setpaddingrelative2.cca_continue(setpaddingrelative);
                } else {
                    byte[] Cardinal4 = setSelected.Cardinal(this.configure, challengeParameters.getSDKVersion().Cardinal());
                    mQVwithSHA256KDFAndSharedInfo2.init(Cardinal4, 0, Cardinal4.length);
                    if (challengeParameters.CardinalEnvironment()) {
                        byte[] Cardinal5 = setSelected.Cardinal(this.configure, challengeParameters.CardinalError().Cardinal());
                        mQVwithSHA256KDFAndSharedInfo2.init(Cardinal5, 0, Cardinal5.length);
                    } else {
                        throw new IllegalStateException("point not in normal form");
                    }
                }
                i2++;
                setMinimumWidth.getInstance(i2, bArr3, 0);
                mQVwithSHA256KDFAndSharedInfo2.init(bArr3, 0, 4);
                mQVwithSHA256KDFAndSharedInfo2.configure(bArr3, 0);
                int min = Math.min(instance, bArr2.length - i);
                for (int i3 = 0; i3 != min; i3++) {
                    int i4 = i + i3;
                    bArr2[i4] = (byte) (bArr2[i4] ^ bArr3[i3]);
                }
                i += min;
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA256CKDF */
    final class X25519withSHA256CKDF {
        boolean configure;
        ISOSignatureSpi.WhirlpoolWithRSAEncryption init;

        X25519withSHA256CKDF() {
        }

        public final int init() {
            int bitLength = (this.init.configure.bitLength() + 7) / 8;
            return this.configure ? bitLength - 1 : bitLength;
        }

        public final int Cardinal() {
            int bitLength = (this.init.configure.bitLength() + 7) / 8;
            return this.configure ? bitLength : bitLength - 1;
        }

        public final byte[] configure(BigInteger bigInteger) {
            byte[] bArr;
            byte[] byteArray = bigInteger.toByteArray();
            if (!this.configure) {
                if (byteArray[0] == 0) {
                    int length = byteArray.length - 1;
                    bArr = new byte[length];
                    System.arraycopy(byteArray, 1, bArr, 0, length);
                } else {
                    int length2 = byteArray.length;
                    bArr = new byte[length2];
                    System.arraycopy(byteArray, 0, bArr, 0, length2);
                }
                for (int i = 0; i < byteArray.length; i++) {
                    byteArray[i] = 0;
                }
                return bArr;
            } else if (byteArray[0] == 0 && byteArray.length > Cardinal()) {
                int length3 = byteArray.length - 1;
                byte[] bArr2 = new byte[length3];
                System.arraycopy(byteArray, 1, bArr2, 0, length3);
                return bArr2;
            } else if (byteArray.length >= Cardinal()) {
                return byteArray;
            } else {
                int Cardinal = Cardinal();
                byte[] bArr3 = new byte[Cardinal];
                System.arraycopy(byteArray, 0, bArr3, Cardinal - byteArray.length, byteArray.length);
                return bArr3;
            }
        }

        public final BigInteger cca_continue(BigInteger bigInteger) {
            ISOSignatureSpi.WhirlpoolWithRSAEncryption whirlpoolWithRSAEncryption = this.init;
            if (!(whirlpoolWithRSAEncryption instanceof PSSSignatureSpi.SHA224withRSA)) {
                return bigInteger.modPow(whirlpoolWithRSAEncryption.Cardinal, this.init.configure);
            }
            PSSSignatureSpi.SHA224withRSA sHA224withRSA = (PSSSignatureSpi.SHA224withRSA) whirlpoolWithRSAEncryption;
            BigInteger bigInteger2 = sHA224withRSA.cca_continue;
            BigInteger bigInteger3 = sHA224withRSA.init;
            BigInteger bigInteger4 = sHA224withRSA.values;
            BigInteger bigInteger5 = sHA224withRSA.CardinalError;
            BigInteger bigInteger6 = sHA224withRSA.getSDKVersion;
            BigInteger modPow = bigInteger.remainder(bigInteger2).modPow(bigInteger4, bigInteger2);
            BigInteger modPow2 = bigInteger.remainder(bigInteger3).modPow(bigInteger5, bigInteger3);
            return modPow.subtract(modPow2).multiply(bigInteger6).mod(bigInteger2).multiply(bigInteger3).add(modPow2);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA256KDF */
    public final class X25519withSHA256KDF implements ECKAEGwithRIPEMD160KDF {
        public SignatureSpi.Ed25519 Cardinal;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.Cardinal = (SignatureSpi.Ed25519) gOST3410Util;
        }

        public final ExtendedInvalidKeySpecException init() {
            X25519UwithSHA256CKDF x25519UwithSHA256CKDF = X25519UwithSHA256CKDF.init;
            CipherSpi cipherSpi = this.Cardinal.init;
            BigInteger init = X25519UwithSHA256CKDF.init(cipherSpi, this.Cardinal.getInstance);
            return new ExtendedInvalidKeySpecException(new CipherSpi.PKCS1v1_5Padding(X25519UwithSHA256CKDF.getInstance(cipherSpi, init), cipherSpi), new BCElGamalPublicKey(init, cipherSpi));
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA384CKDF */
    public final class X25519withSHA384CKDF {
        private static final BigInteger Cardinal = BigInteger.valueOf(1);
        private static final BigInteger init = BigInteger.valueOf(2);
        private int cca_continue;
        private SecureRandom cleanup;
        private MQVwithSHA256KDFAndSharedInfo configure;
        private int getInstance;
        private int getSDKVersion;
        private int getWarnings;
        private boolean values;

        static {
            BigInteger.valueOf(0);
        }

        public X25519withSHA384CKDF(MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo) {
            this.configure = mQVwithSHA256KDFAndSharedInfo;
        }

        private static BigInteger Cardinal(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
            BigInteger modPow;
            BigInteger divide = bigInteger.subtract(Cardinal).divide(bigInteger2);
            BigInteger subtract = bigInteger.subtract(init);
            do {
                modPow = setSelected.init(init, subtract, secureRandom).modPow(divide, bigInteger);
            } while (modPow.bitLength() <= 1);
            return modPow;
        }

        private static void configure(byte[] bArr) {
            int length = bArr.length - 1;
            while (length >= 0) {
                byte b = (byte) (bArr[length] + 1);
                bArr[length] = b;
                if (b == 0) {
                    length--;
                } else {
                    return;
                }
            }
        }

        private boolean getInstance(BigInteger bigInteger) {
            return bigInteger.isProbablePrime(this.getSDKVersion);
        }

        public X25519withSHA384CKDF() {
            this(new SignatureSpi.ecNR224());
        }

        public final void Cardinal(int i, int i2, SecureRandom secureRandom) {
            this.cca_continue = i;
            this.getInstance = i > 1024 ? 256 : 160;
            this.getSDKVersion = i2;
            this.cleanup = secureRandom;
            this.values = false;
            this.getWarnings = -1;
        }

        public final void getInstance(setDrawingCacheEnabled setdrawingcacheenabled) {
            int i = setdrawingcacheenabled.configure;
            int i2 = setdrawingcacheenabled.Cardinal;
            if (i < 1024 || i > 3072 || i % 1024 != 0) {
                throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
            } else if (i == 1024 && i2 != 160) {
                throw new IllegalArgumentException("N must be 160 for L = 1024");
            } else if (i == 2048 && i2 != 224 && i2 != 256) {
                throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
            } else if (i == 3072 && i2 != 256) {
                throw new IllegalArgumentException("N must be 256 for L = 3072");
            } else if ((this.configure.getInstance() << 3) >= i2) {
                this.cca_continue = i;
                this.getInstance = i2;
                this.getSDKVersion = setdrawingcacheenabled.cca_continue;
                this.cleanup = setdrawingcacheenabled.getInstance;
                this.values = true;
                this.getWarnings = -1;
            } else {
                throw new IllegalStateException("Digest output size too small for value of N");
            }
        }

        public final BCGOST3410PublicKey configure() {
            BigInteger bit;
            int i;
            BigInteger subtract;
            BigInteger configure2;
            if (!this.values) {
                return Cardinal();
            }
            MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.configure;
            int i2 = this.getInstance / 8;
            byte[] bArr = new byte[i2];
            int i3 = this.cca_continue;
            int instance = (i3 - 1) / (mQVwithSHA256KDFAndSharedInfo.getInstance() << 3);
            int i4 = i3 / 8;
            byte[] bArr2 = new byte[i4];
            int instance2 = mQVwithSHA256KDFAndSharedInfo.getInstance();
            byte[] bArr3 = new byte[instance2];
            loop0:
            while (true) {
                this.cleanup.nextBytes(bArr);
                mQVwithSHA256KDFAndSharedInfo.init(bArr, 0, i2);
                mQVwithSHA256KDFAndSharedInfo.configure(bArr3, 0);
                bit = new BigInteger(1, bArr3).mod(Cardinal.shiftLeft(this.getInstance - 1)).setBit(0).setBit(this.getInstance - 1);
                if (getInstance(bit)) {
                    byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr);
                    int i5 = this.cca_continue * 4;
                    i = 0;
                    while (i < i5) {
                        int i6 = 1;
                        while (i6 <= instance) {
                            configure(cca_continue2);
                            mQVwithSHA256KDFAndSharedInfo.init(cca_continue2, 0, cca_continue2.length);
                            mQVwithSHA256KDFAndSharedInfo.configure(bArr2, i4 - (i6 * instance2));
                            i6++;
                            i2 = i2;
                        }
                        int i7 = i2;
                        int i8 = i4 - (instance * instance2);
                        configure(cca_continue2);
                        mQVwithSHA256KDFAndSharedInfo.init(cca_continue2, 0, cca_continue2.length);
                        mQVwithSHA256KDFAndSharedInfo.configure(bArr3, 0);
                        System.arraycopy(bArr3, instance2 - i8, bArr2, 0, i8);
                        bArr2[0] = (byte) (bArr2[0] | Byte.MIN_VALUE);
                        BigInteger bigInteger = new BigInteger(1, bArr2);
                        subtract = bigInteger.subtract(bigInteger.mod(bit.shiftLeft(1)).subtract(Cardinal));
                        if (subtract.bitLength() == this.cca_continue && getInstance(subtract)) {
                            break loop0;
                        }
                        i++;
                        i2 = i7;
                    }
                    continue;
                }
            }
            int i9 = this.getWarnings;
            if (i9 < 0 || (configure2 = configure(mQVwithSHA256KDFAndSharedInfo, subtract, bit, bArr, i9)) == null) {
                return new BCGOST3410PublicKey(subtract, bit, Cardinal(subtract, bit, this.cleanup), new CipherSpi.OAEPPadding(bArr, i));
            }
            return new BCGOST3410PublicKey(subtract, bit, configure2, new CipherSpi.OAEPPadding(bArr, i, (byte) 0));
        }

        private BCGOST3410PublicKey Cardinal() {
            int i = 20;
            byte[] bArr = new byte[20];
            byte[] bArr2 = new byte[20];
            byte[] bArr3 = new byte[20];
            byte[] bArr4 = new byte[20];
            int i2 = this.cca_continue;
            int i3 = (i2 - 1) / 160;
            int i4 = i2 / 8;
            byte[] bArr5 = new byte[i4];
            if (this.configure instanceof SignatureSpi.ecNR224) {
                while (true) {
                    this.cleanup.nextBytes(bArr);
                    MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo = this.configure;
                    mQVwithSHA256KDFAndSharedInfo.init(bArr, 0, i);
                    mQVwithSHA256KDFAndSharedInfo.configure(bArr2, 0);
                    System.arraycopy(bArr, 0, bArr3, 0, i);
                    configure(bArr3);
                    MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo2 = this.configure;
                    mQVwithSHA256KDFAndSharedInfo2.init(bArr3, 0, i);
                    mQVwithSHA256KDFAndSharedInfo2.configure(bArr3, 0);
                    for (int i5 = 0; i5 != i; i5++) {
                        bArr4[i5] = (byte) (bArr2[i5] ^ bArr3[i5]);
                    }
                    bArr4[0] = (byte) (bArr4[0] | Byte.MIN_VALUE);
                    bArr4[19] = (byte) (bArr4[19] | 1);
                    BigInteger bigInteger = new BigInteger(1, bArr4);
                    if (getInstance(bigInteger)) {
                        byte[] cca_continue2 = setForegroundTintBlendMode.cca_continue(bArr);
                        configure(cca_continue2);
                        int i6 = 0;
                        while (i6 < 4096) {
                            for (int i7 = 1; i7 <= i3; i7++) {
                                configure(cca_continue2);
                                MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo3 = this.configure;
                                mQVwithSHA256KDFAndSharedInfo3.init(cca_continue2, 0, cca_continue2.length);
                                mQVwithSHA256KDFAndSharedInfo3.configure(bArr5, i4 - (i7 * 20));
                            }
                            int i8 = i4 - (i3 * 20);
                            configure(cca_continue2);
                            MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo4 = this.configure;
                            mQVwithSHA256KDFAndSharedInfo4.init(cca_continue2, 0, cca_continue2.length);
                            mQVwithSHA256KDFAndSharedInfo4.configure(bArr2, 0);
                            System.arraycopy(bArr2, 20 - i8, bArr5, 0, i8);
                            bArr5[0] = (byte) (bArr5[0] | Byte.MIN_VALUE);
                            BigInteger bigInteger2 = new BigInteger(1, bArr5);
                            BigInteger subtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(Cardinal));
                            if (subtract.bitLength() == this.cca_continue && getInstance(subtract)) {
                                return new BCGOST3410PublicKey(subtract, bigInteger, Cardinal(subtract, bigInteger, this.cleanup), new CipherSpi.OAEPPadding(bArr, i6));
                            }
                            i6++;
                            i = 20;
                        }
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
            }
        }

        private static BigInteger configure(MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i) {
            BigInteger divide = bigInteger.subtract(Cardinal).divide(bigInteger2);
            byte[] instance = setTextDirection.getInstance("6767656E");
            int length = bArr.length + instance.length + 1 + 2;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(instance, 0, bArr2, bArr.length, instance.length);
            bArr2[length - 3] = (byte) i;
            byte[] bArr3 = new byte[mQVwithSHA256KDFAndSharedInfo.getInstance()];
            for (int i2 = 1; i2 < 65536; i2++) {
                for (int i3 = length - 1; i3 >= 0; i3--) {
                    byte b = (byte) (bArr2[i3] + 1);
                    bArr2[i3] = b;
                    if (b != 0) {
                        break;
                    }
                }
                mQVwithSHA256KDFAndSharedInfo.init(bArr2, 0, length);
                mQVwithSHA256KDFAndSharedInfo.configure(bArr3, 0);
                BigInteger modPow = new BigInteger(1, bArr3).modPow(divide, bigInteger);
                if (modPow.compareTo(init) >= 0) {
                    return modPow;
                }
            }
            return null;
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X25519withSHA512CKDF */
    public final class X25519withSHA512CKDF implements ECKAEGwithRIPEMD160KDF {
        private static final BigInteger cca_continue = BigInteger.valueOf(1);
        public AlgorithmParametersSpi.OAEP configure;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.configure = (AlgorithmParametersSpi.OAEP) gOST3410Util;
        }

        public final ExtendedInvalidKeySpecException init() {
            BigInteger init;
            BCGOST3410PublicKey bCGOST3410PublicKey = this.configure.Cardinal;
            BigInteger bigInteger = bCGOST3410PublicKey.getInstance;
            SecureRandom secureRandom = this.configure.getInstance;
            int bitLength = bigInteger.bitLength() >>> 2;
            do {
                BigInteger bigInteger2 = cca_continue;
                init = setSelected.init(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
            } while (createTransaction.cca_continue(init) < bitLength);
            return new ExtendedInvalidKeySpecException(new BCGOST3410PrivateKey(bCGOST3410PublicKey.cca_continue.modPow(init, bCGOST3410PublicKey.init), bCGOST3410PublicKey), new AlgorithmParametersSpi.PSS(init, bCGOST3410PublicKey));
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X448UwithSHA512KDF */
    public final class X448UwithSHA512KDF extends X448withSHA384CKDF {
        public final ExtendedInvalidKeySpecException init() {
            ExtendedInvalidKeySpecException init = super.init();
            DigestSignatureSpi digestSignatureSpi = (DigestSignatureSpi) init.Cardinal;
            return new ExtendedInvalidKeySpecException(new DigestSignatureSpi(digestSignatureSpi.cca_continue.getString(), digestSignatureSpi.init), (DigestSignatureSpi.MD2) init.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X448withSHA256CKDF */
    public final class X448withSHA256CKDF implements ECKAEGwithRIPEMD160KDF {
        public DigestSignatureSpi.SHA256 configure;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.configure = (DigestSignatureSpi.SHA256) gOST3410Util;
        }

        public final ExtendedInvalidKeySpecException init() {
            X25519UwithSHA256CKDF x25519UwithSHA256CKDF = X25519UwithSHA256CKDF.init;
            DigestSignatureSpi.SHA224 sha224 = this.configure.cca_continue;
            CipherSpi cipherSpi = new CipherSpi(sha224.init, sha224.configure, sha224.cca_continue);
            BigInteger init = X25519UwithSHA256CKDF.init(cipherSpi, this.configure.getInstance);
            return new ExtendedInvalidKeySpecException(new DigestSignatureSpi.SHA384(X25519UwithSHA256CKDF.getInstance(cipherSpi, init), sha224), new DigestSignatureSpi.SHA3_256(init, sha224));
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X448withSHA384CKDF */
    public class X448withSHA384CKDF implements ECKAEGwithRIPEMD160KDF, getSDKReferenceNumber {
        private SecureRandom Cardinal;
        private BCRSAPublicKey configure;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            BCRSAPrivateKey bCRSAPrivateKey = (BCRSAPrivateKey) gOST3410Util;
            this.Cardinal = bCRSAPrivateKey.getInstance;
            this.configure = bCRSAPrivateKey.configure;
            if (this.Cardinal == null) {
                this.Cardinal = MQV.cca_continue();
            }
        }

        public ExtendedInvalidKeySpecException init() {
            BigInteger bigInteger = this.configure.cca_continue;
            int bitLength = bigInteger.bitLength();
            int i = bitLength >>> 2;
            while (true) {
                BigInteger configure2 = setSelected.configure(bitLength, this.Cardinal);
                if (configure2.compareTo(CardinalEnvironment) >= 0 && configure2.compareTo(bigInteger) < 0 && createTransaction.cca_continue(configure2) >= i) {
                    return new ExtendedInvalidKeySpecException(new DigestSignatureSpi(new setAcsRefNumber().configure(this.configure.init, configure2), this.configure), new DigestSignatureSpi.MD2(configure2, this.configure));
                }
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X448withSHA512CKDF */
    public final class X448withSHA512CKDF implements ECKAEGwithRIPEMD160KDF {
        private SecureRandom Cardinal;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.Cardinal = gOST3410Util.getInstance;
        }

        public final ExtendedInvalidKeySpecException init() {
            DigestSignatureSpi.MD5 md5 = new DigestSignatureSpi.MD5(this.Cardinal);
            byte[] bArr = new byte[32];
            setImportantForAutofill.cca_continue(md5.Cardinal, bArr);
            return new ExtendedInvalidKeySpecException(new DigestSignatureSpi.RIPEMD256(bArr, 0), md5);
        }
    }

    /* renamed from: com.cardinalcommerce.a.KeyAgreementSpi$X448withSHA512KDF */
    public final class X448withSHA512KDF implements ECKAEGwithRIPEMD160KDF {
        private SecureRandom configure;

        public final void cca_continue(GOST3410Util gOST3410Util) {
            this.configure = gOST3410Util.getInstance;
        }

        public final ExtendedInvalidKeySpecException init() {
            DigestSignatureSpi.SHA1 sha1 = new DigestSignatureSpi.SHA1(this.configure);
            byte[] bArr = new byte[57];
            setAutofillId.init(sha1.cca_continue, bArr);
            return new ExtendedInvalidKeySpecException(new DigestSignatureSpi.RIPEMD128(bArr, 0), sha1);
        }
    }

    public static int Cardinal(InputStream inputStream) {
        if (inputStream instanceof DHUwithSHA1KDF) {
            return ((DHUwithSHA1KDF) inputStream).getInstance();
        }
        if (inputStream instanceof getUiType) {
            return ((getUiType) inputStream).f2586a;
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j = f2453a;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }
}
