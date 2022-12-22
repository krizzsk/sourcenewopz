package com.cardinalcommerce.p060a;

import android.util.Base64;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AuthenticatedCipherText;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.X509CertUtils;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* renamed from: com.cardinalcommerce.a.valueOf */
public final class valueOf {

    /* renamed from: e */
    private static int f3105e = 0;

    /* renamed from: f */
    private static int f3106f = 1;
    public ValidateResponse Cardinal;

    /* renamed from: a */
    int f3107a;

    /* renamed from: b */
    String f3108b;

    /* renamed from: c */
    private boolean f3109c;
    public setBaselineAligned configure;

    /* renamed from: d */
    private String f3110d;
    public String init;

    public static byte[] configure(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    valueOf() {
    }

    public valueOf(String str) throws JSONException, UnsupportedOperationException {
        setTextMetricsParams sDKVersion = setTextMetricsParams.getSDKVersion();
        String[] split = str.split("\\.");
        JSONObject jSONObject = new JSONObject(split.length > 1 ? CardinalEnvironment.cca_continue(split[1]) : null);
        String optString = jSONObject.optString("ConsumerSessionId", "");
        String optString2 = jSONObject.optString("Payload", "");
        if (optString2 != null && !optString2.equalsIgnoreCase("")) {
            JSONObject jSONObject2 = new JSONObject(optString2);
            this.f3109c = jSONObject2.optBoolean("Successful", false);
            this.f3107a = jSONObject2.optInt("ErrorNumber", 0);
            this.init = jSONObject2.optString("ErrorDescription", "");
            String optString3 = jSONObject2.optString("CRes", "");
            this.f3110d = optString3;
            if (this.f3109c) {
                String optString4 = jSONObject2.optString("ValidateResponse", "");
                this.f3108b = optString4;
                if (optString4 != null && !optString4.equalsIgnoreCase("")) {
                    this.Cardinal = new ValidateResponse(this.f3108b);
                }
            } else if (optString3 != null && !optString3.equalsIgnoreCase("")) {
                setBaselineAligned setbaselinealigned = new setBaselineAligned(new String(Base64.decode(this.f3110d, 0), StandardCharsets.UTF_8));
                this.configure = setbaselinealigned;
                if (!setbaselinealigned.setRenderType.getInstance()) {
                    sDKVersion.configure("10705", CardinalError.SUBSEQUENT_CRES_VALIDATION_ERROR_MESSAGE, optString);
                    throw new RuntimeException(CardinalError.SUBSEQUENT_CRES_VALIDATION_ERROR_MESSAGE);
                }
            }
        }
    }

    public final boolean Cardinal() {
        boolean z;
        int i = f3106f;
        int i2 = ((i ^ 87) - (~((i & 87) << 1))) - 1;
        f3105e = i2 % 128;
        if ((i2 % 2 != 0 ? '@' : Typography.amp) != '&') {
            z = this.f3109c;
            int i3 = 9 / 0;
        } else {
            z = this.f3109c;
        }
        int i4 = f3105e;
        int i5 = i4 & 43;
        int i6 = -(-(i4 | 43));
        int i7 = (i5 & i6) + (i6 | i5);
        f3106f = i7 % 128;
        if ((i7 % 2 == 0 ? 'E' : 25) == 25) {
            return z;
        }
        int i8 = 28 / 0;
        return z;
    }

    public static Signature getInstance(JWSAlgorithm jWSAlgorithm, Provider provider) throws JOSEException {
        String str = "SHA256withECDSA";
        if (!jWSAlgorithm.equals(JWSAlgorithm.getWarnings) && !jWSAlgorithm.equals(JWSAlgorithm.CardinalError)) {
            if (jWSAlgorithm.equals(JWSAlgorithm.values)) {
                str = "SHA384withECDSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.cleanup)) {
                str = "SHA512withECDSA";
            } else {
                throw new JOSEException(AlgorithmSupportMessage.init(jWSAlgorithm, setCropToPadding.configure));
            }
        }
        if (provider == null) {
            return Signature.getInstance(str);
        }
        try {
            return Signature.getInstance(str, provider);
        } catch (NoSuchAlgorithmException e) {
            StringBuilder sb = new StringBuilder("Unsupported ECDSA algorithm: ");
            sb.append(e.getMessage());
            throw new JOSEException(sb.toString(), e);
        }
    }

    public static byte[] init(byte[] bArr) throws JOSEException {
        byte[] bArr2;
        int length = bArr.length / 2;
        int i = length;
        while (i > 0 && bArr[length - i] == 0) {
            i--;
        }
        int i2 = length - i;
        int i3 = bArr[i2] < 0 ? i + 1 : i;
        int i4 = length;
        while (i4 > 0 && bArr[(length * 2) - i4] == 0) {
            i4--;
        }
        int i5 = (length * 2) - i4;
        int i6 = bArr[i5] < 0 ? i4 + 1 : i4;
        int i7 = i3 + 2 + 2 + i6;
        if (i7 <= 255) {
            int i8 = 1;
            if (i7 < 128) {
                bArr2 = new byte[(i3 + 4 + 2 + i6)];
            } else {
                bArr2 = new byte[(i3 + 5 + 2 + i6)];
                bArr2[1] = -127;
                i8 = 2;
            }
            bArr2[0] = 48;
            int i9 = i8 + 1;
            bArr2[i8] = (byte) i7;
            int i10 = i9 + 1;
            bArr2[i9] = 2;
            bArr2[i10] = (byte) i3;
            int i11 = i10 + 1 + i3;
            System.arraycopy(bArr, i2, bArr2, i11 - i, i);
            int i12 = i11 + 1;
            bArr2[i11] = 2;
            bArr2[i12] = (byte) i6;
            System.arraycopy(bArr, i5, bArr2, ((i12 + 1) + i6) - i4, i4);
            return bArr2;
        }
        throw new JOSEException("Invalid ECDSA signature format");
    }

    /* renamed from: a */
    private static registerForContextMenu m2178a(SecretKey secretKey, boolean z, byte[] bArr, byte[] bArr2) {
        int i;
        BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey = new BCECGOST3410_2012PrivateKey();
        bCECGOST3410_2012PrivateKey.Cardinal(z, new ISOSignatureSpi.MD5WithRSAEncryption(secretKey.getEncoded()));
        registerForContextMenu registerforcontextmenu = new registerForContextMenu(bCECGOST3410_2012PrivateKey, (byte) 0);
        setLabelFor setlabelfor = new setLabelFor(new ISOSignatureSpi.MD5WithRSAEncryption(secretKey.getEncoded()), bArr, bArr2);
        registerforcontextmenu.getInstance = z;
        registerforcontextmenu.valueOf = null;
        registerforcontextmenu.Cardinal = true;
        setLabelFor setlabelfor2 = setlabelfor;
        byte[] Cardinal2 = setlabelfor2.Cardinal();
        registerforcontextmenu.values = setlabelfor2.init();
        int i2 = setlabelfor2.getInstance;
        if (i2 < 32 || i2 > 128 || i2 % 8 != 0) {
            throw new IllegalArgumentException("Invalid value for MAC size: ".concat(String.valueOf(i2)));
        }
        registerforcontextmenu.getWarnings = i2 / 8;
        ISOSignatureSpi.MD5WithRSAEncryption mD5WithRSAEncryption = setlabelfor2.cca_continue;
        if (z) {
            i = 16;
        } else {
            i = registerforcontextmenu.getWarnings + 16;
        }
        registerforcontextmenu.CardinalEnvironment = new byte[i];
        if (Cardinal2 == null || Cardinal2.length <= 0) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z && registerforcontextmenu.cleanup != null && setForegroundTintBlendMode.Cardinal(registerforcontextmenu.cleanup, Cardinal2)) {
            if (mD5WithRSAEncryption == null) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            } else if (registerforcontextmenu.getSDKVersion != null && setForegroundTintBlendMode.Cardinal(registerforcontextmenu.getSDKVersion, mD5WithRSAEncryption.getInstance())) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        registerforcontextmenu.cleanup = Cardinal2;
        if (mD5WithRSAEncryption != null) {
            registerforcontextmenu.getSDKVersion = mD5WithRSAEncryption.getInstance();
        }
        if (mD5WithRSAEncryption != null) {
            registerforcontextmenu.cca_continue.Cardinal(true, mD5WithRSAEncryption);
            registerforcontextmenu.CardinalError = new byte[16];
            registerforcontextmenu.cca_continue.init(registerforcontextmenu.CardinalError, 0, registerforcontextmenu.CardinalError, 0);
            registerforcontextmenu.init.cca_continue(registerforcontextmenu.CardinalError);
            registerforcontextmenu.configure = null;
        } else if (registerforcontextmenu.CardinalError == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        registerforcontextmenu.CardinalUiType = new byte[16];
        if (registerforcontextmenu.cleanup.length == 12) {
            System.arraycopy(registerforcontextmenu.cleanup, 0, registerforcontextmenu.CardinalUiType, 0, registerforcontextmenu.cleanup.length);
            registerforcontextmenu.CardinalUiType[15] = 1;
        } else {
            registerforcontextmenu.Cardinal(registerforcontextmenu.CardinalUiType, registerforcontextmenu.cleanup, registerforcontextmenu.cleanup.length);
            byte[] bArr3 = new byte[16];
            long length = ((long) registerforcontextmenu.cleanup.length) << 3;
            setMinimumWidth.getInstance((int) (length >>> 32), bArr3, 8);
            setMinimumWidth.getInstance((int) length, bArr3, 12);
            byte[] bArr4 = registerforcontextmenu.CardinalUiType;
            KeyPairGeneratorSpi.Ed448.Cardinal(bArr4, bArr3);
            registerforcontextmenu.init.configure(bArr4);
        }
        registerforcontextmenu.CardinalRenderType = new byte[16];
        registerforcontextmenu.CardinalActionCode = new byte[16];
        registerforcontextmenu.getString = new byte[16];
        registerforcontextmenu.getChallengeTimeout = new byte[16];
        registerforcontextmenu.getEnvironment = 0;
        registerforcontextmenu.setChallengeTimeout = 0;
        registerforcontextmenu.getProxyAddress = 0;
        registerforcontextmenu.setRequestTimeout = setForegroundTintBlendMode.cca_continue(registerforcontextmenu.CardinalUiType);
        registerforcontextmenu.CardinalConfigurationParameters = -2;
        registerforcontextmenu.getRequestTimeout = 0;
        registerforcontextmenu.getActionCode = 0;
        if (registerforcontextmenu.values != null) {
            registerforcontextmenu.getInstance(registerforcontextmenu.values, registerforcontextmenu.values.length);
        }
        return registerforcontextmenu;
    }

    public static AuthenticatedCipherText init(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3) throws JOSEException {
        registerForContextMenu a = m2178a(secretKey, true, bArr, bArr3);
        byte[] bArr4 = new byte[a.configure(bArr2.length)];
        int instance = a.getInstance(bArr2, 0, bArr2.length, bArr4);
        try {
            int cca_continue = (instance + a.cca_continue(bArr4, instance)) - 16;
            byte[] bArr5 = new byte[cca_continue];
            byte[] bArr6 = new byte[16];
            System.arraycopy(bArr4, 0, bArr5, 0, cca_continue);
            System.arraycopy(bArr4, cca_continue, bArr6, 0, 16);
            return new AuthenticatedCipherText(bArr5, bArr6);
        } catch (KeyFactorySpi.ECDH e) {
            StringBuilder sb = new StringBuilder("Couldn't generate GCM authentication tag: ");
            sb.append(e.getMessage());
            throw new JOSEException(sb.toString(), e);
        }
    }

    public static byte[] getInstance(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws JOSEException {
        registerForContextMenu a = m2178a(secretKey, false, bArr, bArr3);
        int length = bArr2.length + bArr4.length;
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        System.arraycopy(bArr4, 0, bArr5, bArr2.length, bArr4.length);
        byte[] bArr6 = new byte[a.configure(length)];
        try {
            a.cca_continue(bArr6, a.getInstance(bArr5, 0, length, bArr6));
            return bArr6;
        } catch (KeyFactorySpi.ECDH e) {
            StringBuilder sb = new StringBuilder("Couldn't validate GCM authentication tag: ");
            sb.append(e.getMessage());
            throw new JOSEException(sb.toString(), e);
        }
    }

    public static byte[] cca_continue(RSAPublicKey rSAPublicKey, SecretKey secretKey, Provider provider) throws JOSEException {
        Cipher cipher;
        if (provider == null) {
            try {
                cipher = Cipher.getInstance(C10604d.f30291c);
            } catch (IllegalBlockSizeException e) {
                throw new JOSEException("RSA block size exception: The RSA key is too short, try a longer one", e);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder("Couldn't encrypt Content Encryption Key (CEK): ");
                sb.append(e2.getMessage());
                throw new JOSEException(sb.toString(), e2);
            }
        } else {
            cipher = Cipher.getInstance(C10604d.f30291c, provider);
        }
        cipher.init(1, rSAPublicKey);
        return cipher.doFinal(secretKey.getEncoded());
    }

    public static boolean configure(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        byte b = 0;
        for (int i = 0; i < bArr.length; i++) {
            b |= bArr[i] ^ bArr2[i];
        }
        if (b == 0) {
            return true;
        }
        return false;
    }

    public static boolean configure(ECPublicKey eCPublicKey, ECParameterSpec eCParameterSpec) {
        ECPoint w = eCPublicKey.getW();
        return configure(w.getAffineX(), w.getAffineY(), eCParameterSpec);
    }

    public static boolean configure(BigInteger bigInteger, BigInteger bigInteger2, ECParameterSpec eCParameterSpec) {
        EllipticCurve curve = eCParameterSpec.getCurve();
        BigInteger a = curve.getA();
        BigInteger b = curve.getB();
        BigInteger p = ((ECFieldFp) curve.getField()).getP();
        return bigInteger2.pow(2).mod(p).equals(bigInteger.pow(3).add(a.multiply(bigInteger)).add(b).mod(p));
    }

    public static byte[] init(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getInstance(byte[] r5) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.Deflater r2 = new java.util.zip.Deflater     // Catch:{ all -> 0x0026 }
            r3 = 8
            r4 = 1
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0026 }
            java.util.zip.DeflaterOutputStream r3 = new java.util.zip.DeflaterOutputStream     // Catch:{ all -> 0x0024 }
            r3.<init>(r0, r2)     // Catch:{ all -> 0x0024 }
            r3.write(r5)     // Catch:{ all -> 0x0021 }
            r3.close()
            r2.end()
            byte[] r5 = r0.toByteArray()
            return r5
        L_0x0021:
            r5 = move-exception
            r1 = r3
            goto L_0x0028
        L_0x0024:
            r5 = move-exception
            goto L_0x0028
        L_0x0026:
            r5 = move-exception
            r2 = r1
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.end()
        L_0x0032:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.valueOf.getInstance(byte[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] Cardinal(byte[] r5) throws java.io.IOException {
        /*
            r0 = 0
            java.util.zip.Inflater r1 = new java.util.zip.Inflater     // Catch:{ all -> 0x0035 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0035 }
            java.util.zip.InflaterInputStream r2 = new java.util.zip.InflaterInputStream     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0033 }
            r3.<init>(r5)     // Catch:{ all -> 0x0033 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0030 }
            r5.<init>()     // Catch:{ all -> 0x0030 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0030 }
        L_0x001a:
            int r3 = r2.read(r0)     // Catch:{ all -> 0x0030 }
            if (r3 <= 0) goto L_0x0025
            r4 = 0
            r5.write(r0, r4, r3)     // Catch:{ all -> 0x0030 }
            goto L_0x001a
        L_0x0025:
            byte[] r5 = r5.toByteArray()     // Catch:{ all -> 0x0030 }
            r2.close()
            r1.end()
            return r5
        L_0x0030:
            r5 = move-exception
            r0 = r2
            goto L_0x0037
        L_0x0033:
            r5 = move-exception
            goto L_0x0037
        L_0x0035:
            r5 = move-exception
            r1 = r0
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.end()
        L_0x0041:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.valueOf.Cardinal(byte[]):byte[]");
    }

    public static setLayoutTransition init(String str) throws ParseException {
        try {
            setLayoutMode setlayoutmode = new setLayoutMode((byte) 0);
            if (setlayoutmode.Cardinal == null) {
                setlayoutmode.Cardinal = new setHttpAuthUsernamePassword(setlayoutmode.init);
            }
            Object configure2 = setlayoutmode.Cardinal.configure(str, setAddStatesFromChildren.configure.cca_continue);
            if (configure2 instanceof setLayoutTransition) {
                return (setLayoutTransition) configure2;
            }
            throw new ParseException("JSON entity is not an object", 0);
        } catch (setCertificate e) {
            StringBuilder sb = new StringBuilder("Invalid JSON: ");
            sb.append(e.getMessage());
            throw new ParseException(sb.toString(), 0);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("Unexpected exception: ");
            sb2.append(e2.getMessage());
            throw new ParseException(sb2.toString(), 0);
        }
    }

    public static <T> T getInstance(setLayoutTransition setlayouttransition, String str, Class<T> cls) throws ParseException {
        if (setlayouttransition.get(str) == null) {
            return null;
        }
        T t = setlayouttransition.get(str);
        if (cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        StringBuilder sb = new StringBuilder("Unexpected type of JSON object member with key \"");
        sb.append(str);
        sb.append(Const.jsQuote);
        throw new ParseException(sb.toString(), 0);
    }

    public static boolean init(setLayoutTransition setlayouttransition, String str) throws ParseException {
        Boolean bool = (Boolean) getInstance(setlayouttransition, str, Boolean.class);
        if (bool != null) {
            return bool.booleanValue();
        }
        StringBuilder sb = new StringBuilder("JSON object member with key \"");
        sb.append(str);
        sb.append("\" is missing or null");
        throw new ParseException(sb.toString(), 0);
    }

    public static long cca_continue(setLayoutTransition setlayouttransition, String str) throws ParseException {
        Number number = (Number) getInstance(setlayouttransition, str, Number.class);
        if (number != null) {
            return number.longValue();
        }
        StringBuilder sb = new StringBuilder("JSON object member with key \"");
        sb.append(str);
        sb.append("\" is missing or null");
        throw new ParseException(sb.toString(), 0);
    }

    public static URI getInstance(setLayoutTransition setlayouttransition, String str) throws ParseException {
        String str2 = (String) getInstance(setlayouttransition, str, String.class);
        if (str2 == null) {
            return null;
        }
        try {
            return new URI(str2);
        } catch (URISyntaxException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public static String[] configure(setLayoutTransition setlayouttransition, String str) throws ParseException {
        setDescendantFocusability setdescendantfocusability = (setDescendantFocusability) getInstance(setlayouttransition, str, setDescendantFocusability.class);
        if (setdescendantfocusability == null) {
            return null;
        }
        try {
            return (String[]) setdescendantfocusability.toArray(new String[0]);
        } catch (ArrayStoreException unused) {
            StringBuilder sb = new StringBuilder("JSON object member with key \"");
            sb.append(str);
            sb.append("\" is not an array of strings");
            throw new ParseException(sb.toString(), 0);
        }
    }

    public static List<com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64> Cardinal(setDescendantFocusability setdescendantfocusability) throws ParseException {
        if (setdescendantfocusability == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (i < setdescendantfocusability.size()) {
            Object obj = setdescendantfocusability.get(i);
            if (obj == null) {
                StringBuilder sb = new StringBuilder("The X.509 certificate at position ");
                sb.append(i);
                sb.append(" must not be null");
                throw new ParseException(sb.toString(), 0);
            } else if (obj instanceof String) {
                linkedList.add(new com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64((String) obj));
                i++;
            } else {
                StringBuilder sb2 = new StringBuilder("The X.509 certificate at position ");
                sb2.append(i);
                sb2.append(" must be encoded as a Base64 string");
                throw new ParseException(sb2.toString(), 0);
            }
        }
        return linkedList;
    }

    public static List<X509Certificate> getInstance(List<com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64> list) throws ParseException {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                X509Certificate cca_continue = X509CertUtils.cca_continue(list.get(i).cca_continue());
                if (cca_continue != null) {
                    linkedList.add(cca_continue);
                } else {
                    throw new ParseException("Invalid X.509 certificate at position ".concat(String.valueOf(i)), 0);
                }
            }
        }
        return linkedList;
    }
}
