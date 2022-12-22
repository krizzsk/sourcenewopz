package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.DigestSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.getDeviceData;
import com.cardinalcommerce.p060a.setAnimation;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import net.lingala.zip4j.util.InternalZipConstants;

public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    private static final Hashtable CardinalError = new Hashtable();
    private static final Map<String, ASN1ObjectIdentifier> cca_continue = new HashMap();
    private static final Map<String, String> cleanup = new HashMap();
    private static final Map<String, Integer> configure = new HashMap();
    private static final Hashtable getSDKVersion = new Hashtable();
    public final KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo Cardinal;
    public byte[] getInstance;
    public final String init;

    public BaseAgreementSpi(String str, KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo) {
        this.init = str;
        this.Cardinal = mQVwithSHA224KDFAndSharedInfo;
    }

    protected static byte[] getInstance(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i = 0;
        while (i < bArr.length && bArr[i] == 0) {
            i++;
        }
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    private byte[] getInstance(byte[] bArr, String str, int i) throws NoSuchAlgorithmException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        KeyAgreementSpi.MQVwithSHA224KDFAndSharedInfo mQVwithSHA224KDFAndSharedInfo = this.Cardinal;
        if (mQVwithSHA224KDFAndSharedInfo != null) {
            if (i >= 0) {
                int i2 = i / 8;
                byte[] bArr2 = new byte[i2];
                if (!(mQVwithSHA224KDFAndSharedInfo instanceof SignatureSpi.ecDSA224)) {
                    eCKAEGwithSHA512KDF = new DigestSignatureSpi.noneRSA(bArr, this.getInstance);
                } else if (str != null) {
                    try {
                        eCKAEGwithSHA512KDF = new getDeviceData(new ASN1ObjectIdentifier(str), i, bArr, this.getInstance);
                    } catch (IllegalArgumentException unused) {
                        throw new NoSuchAlgorithmException("no OID for algorithm: ".concat(String.valueOf(str)));
                    }
                } else {
                    throw new NoSuchAlgorithmException("algorithm OID is null");
                }
                this.Cardinal.getInstance(eCKAEGwithSHA512KDF);
                this.Cardinal.init(bArr2, 0, i2);
                setForegroundTintBlendMode.getInstance(bArr);
                return bArr2;
            }
            throw new NoSuchAlgorithmException("unknown algorithm encountered: ".concat(String.valueOf(str)));
        } else if (i <= 0) {
            return bArr;
        } else {
            int i3 = i / 8;
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr, 0, bArr3, 0, i3);
            setForegroundTintBlendMode.getInstance(bArr);
            return bArr3;
        }
    }

    /* access modifiers changed from: protected */
    public abstract byte[] Cardinal();

    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.init);
        sb.append(" key agreement: need ");
        sb.append(engineGenerateSecret.length);
        sb.append(" bytes");
        throw new ShortBufferException(sb.toString());
    }

    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.Cardinal == null) {
            return Cardinal();
        }
        byte[] Cardinal2 = Cardinal();
        try {
            return getInstance(Cardinal2, (String) null, Cardinal2.length << 3);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        String str2;
        int i;
        String Cardinal2 = setAnimation.Cardinal(str);
        if (CardinalError.containsKey(Cardinal2)) {
            str2 = ((ASN1ObjectIdentifier) CardinalError.get(Cardinal2)).init;
        } else {
            str2 = str;
        }
        if (str2.indexOf(91) > 0) {
            i = Integer.parseInt(str2.substring(str2.indexOf(91) + 1, str2.indexOf(93)));
        } else {
            String Cardinal3 = setAnimation.Cardinal(str2);
            i = !configure.containsKey(Cardinal3) ? -1 : configure.get(Cardinal3).intValue();
        }
        byte[] instance = getInstance(Cardinal(), str2, i);
        if (str.indexOf(91) > 0) {
            str = str.substring(0, str.indexOf(91));
        } else if (str.startsWith(KeyAgreementSpi.MQVwithSHA224KDF.CardinalEnvironment.init)) {
            str = "AES";
        } else if (str.startsWith(KeyAgreementSpi.DHwithSHA384CKDF.Cardinal.init)) {
            str = "Serpent";
        } else {
            String str3 = cleanup.get(setAnimation.Cardinal(str));
            if (str3 != null) {
                str = str3;
            }
        }
        if (getSDKVersion.containsKey(str)) {
            for (int i2 = 0; i2 < instance.length; i2++) {
                byte b = instance[i2];
                instance[i2] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
            }
        }
        return new SecretKeySpec(instance, str);
    }

    static {
        configure.put("DES", 64);
        configure.put("DESEDE", 192);
        configure.put("BLOWFISH", 128);
        configure.put("AES", 256);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getString.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setChallengeTimeout.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setUiType.init, 256);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setRequestTimeout.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getEnvironment.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getUICustomization.init, 256);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getActionCode.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setRenderType.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getThreeDSRequestorAppURL.init, 256);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getRequestTimeout.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setEnvironment.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setEnableDFSync.init, 256);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.CardinalConfigurationParameters.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getRenderType.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setUICustomization.init, 256);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getChallengeTimeout.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setProxyAddress.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.setThreeDSRequestorAppURL.init, 256);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getProxyAddress.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.getUiType.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA224KDF.isEnableDFSync.init, 256);
        configure.put(KeyAgreementSpi.MQVwithSHA256KDF.cca_continue.init, 128);
        configure.put(KeyAgreementSpi.MQVwithSHA256KDF.init.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA256KDF.values.init, 256);
        configure.put(KeyAgreementSpi.DHwithSHA512CKDF.cca_continue.init, 128);
        configure.put(KeyFactorySpi.getProcessorTransactionId.init, 192);
        configure.put(KeyFactorySpi.getString.init, 192);
        configure.put(KeyAgreementSpi.MQVwithSHA512KDF.configure.init, 64);
        configure.put(KeyAgreementSpi.DHUwithSHA512CKDF.cca_continue.init, 256);
        configure.put(KeyAgreementSpi.DHUwithSHA512CKDF.configure.init, 256);
        configure.put(KeyAgreementSpi.DHUwithSHA512CKDF.Cardinal.init, 256);
        configure.put(KeyFactorySpi.setChallengeTimeout.init, 160);
        configure.put(KeyFactorySpi.setProxyAddress.init, 256);
        configure.put(KeyFactorySpi.getRenderType.init, 384);
        configure.put(KeyFactorySpi.setRenderType.init, 512);
        cca_continue.put("DESEDE", KeyFactorySpi.getString);
        cca_continue.put("AES", KeyAgreementSpi.MQVwithSHA224KDF.getUICustomization);
        cca_continue.put("CAMELLIA", KeyAgreementSpi.MQVwithSHA256KDF.Cardinal);
        cca_continue.put("SEED", KeyAgreementSpi.DHwithSHA512CKDF.Cardinal);
        cca_continue.put("DES", KeyAgreementSpi.MQVwithSHA512KDF.configure);
        cleanup.put(KeyAgreementSpi.DHwithSHA512KDF.CardinalError.init, "CAST5");
        cleanup.put(KeyAgreementSpi.DHwithSHA512KDF.cleanup.init, "IDEA");
        cleanup.put(KeyAgreementSpi.DHwithSHA512KDF.getWarnings.init, "Blowfish");
        cleanup.put(KeyAgreementSpi.DHwithSHA512KDF.CardinalRenderType.init, "Blowfish");
        cleanup.put(KeyAgreementSpi.DHwithSHA512KDF.valueOf.init, "Blowfish");
        cleanup.put(KeyAgreementSpi.DHwithSHA512KDF.CardinalActionCode.init, "Blowfish");
        cleanup.put(KeyAgreementSpi.MQVwithSHA512KDF.init.init, "DES");
        cleanup.put(KeyAgreementSpi.MQVwithSHA512KDF.configure.init, "DES");
        cleanup.put(KeyAgreementSpi.MQVwithSHA512KDF.cca_continue.init, "DES");
        cleanup.put(KeyAgreementSpi.MQVwithSHA512KDF.getInstance.init, "DES");
        cleanup.put(KeyAgreementSpi.MQVwithSHA512KDF.Cardinal.init, "DESede");
        cleanup.put(KeyFactorySpi.getString.init, "DESede");
        cleanup.put(KeyFactorySpi.getProcessorTransactionId.init, "DESede");
        cleanup.put(KeyFactorySpi.ValidateResponse.init, "RC2");
        cleanup.put(KeyFactorySpi.setChallengeTimeout.init, InternalZipConstants.AES_MAC_ALGORITHM);
        cleanup.put(KeyFactorySpi.getUiType.init, "HmacSHA224");
        cleanup.put(KeyFactorySpi.setProxyAddress.init, "HmacSHA256");
        cleanup.put(KeyFactorySpi.getRenderType.init, "HmacSHA384");
        cleanup.put(KeyFactorySpi.setRenderType.init, "HmacSHA512");
        cleanup.put(KeyAgreementSpi.MQVwithSHA256KDF.configure.init, "Camellia");
        cleanup.put(KeyAgreementSpi.MQVwithSHA256KDF.getInstance.init, "Camellia");
        cleanup.put(KeyAgreementSpi.MQVwithSHA256KDF.Cardinal.init, "Camellia");
        cleanup.put(KeyAgreementSpi.MQVwithSHA256KDF.cca_continue.init, "Camellia");
        cleanup.put(KeyAgreementSpi.MQVwithSHA256KDF.init.init, "Camellia");
        cleanup.put(KeyAgreementSpi.MQVwithSHA256KDF.values.init, "Camellia");
        cleanup.put(KeyAgreementSpi.DHwithSHA512CKDF.cca_continue.init, "SEED");
        cleanup.put(KeyAgreementSpi.DHwithSHA512CKDF.Cardinal.init, "SEED");
        cleanup.put(KeyAgreementSpi.DHwithSHA512CKDF.configure.init, "SEED");
        cleanup.put(KeyAgreementSpi.DHUwithSHA512CKDF.cca_continue.init, "GOST28147");
        cleanup.put(KeyAgreementSpi.MQVwithSHA224KDF.CardinalConfigurationParameters.init, "AES");
        cleanup.put(KeyAgreementSpi.MQVwithSHA224KDF.getChallengeTimeout.init, "AES");
        cleanup.put(KeyAgreementSpi.MQVwithSHA224KDF.getChallengeTimeout.init, "AES");
        CardinalError.put("DESEDE", KeyFactorySpi.getString);
        CardinalError.put("AES", KeyAgreementSpi.MQVwithSHA224KDF.getUICustomization);
        CardinalError.put("DES", KeyAgreementSpi.MQVwithSHA512KDF.configure);
        getSDKVersion.put("DES", "DES");
        getSDKVersion.put("DESEDE", "DES");
        getSDKVersion.put(KeyAgreementSpi.MQVwithSHA512KDF.configure.init, "DES");
        getSDKVersion.put(KeyFactorySpi.getString.init, "DES");
        getSDKVersion.put(KeyFactorySpi.getProcessorTransactionId.init, "DES");
    }
}
