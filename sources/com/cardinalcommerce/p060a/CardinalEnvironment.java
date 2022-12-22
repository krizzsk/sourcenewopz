package com.cardinalcommerce.p060a;

import android.util.Base64;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.facebook.internal.security.OidcSecurityUtil;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.cardinalcommerce.a.CardinalEnvironment */
public final class CardinalEnvironment {

    /* renamed from: a */
    private static int f2339a = 0;

    /* renamed from: b */
    private static int f2340b = 1;
    public final SecretKey Cardinal;
    public final SecretKey getInstance;
    public final int init;

    public CardinalEnvironment() {
    }

    public static String cca_continue(String str) throws InvalidInputException {
        int i = f2340b;
        int i2 = ((i | 103) << 1) - (i ^ 103);
        f2339a = i2 % 128;
        int i3 = i2 % 2;
        byte[] decode = Base64.decode(str, 8);
        if (decode != null) {
            String str2 = new String(decode, StandardCharsets.UTF_8);
            int i4 = f2340b;
            int i5 = (i4 & 83) + (i4 | 83);
            f2339a = i5 % 128;
            if ((i5 % 2 != 0 ? 14 : 'T') != 14) {
                return str2;
            }
            int i6 = 5 / 0;
            return str2;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Null decodedBytes"));
    }

    public CardinalEnvironment(SecretKey secretKey) throws KeyLengthException {
        byte[] encoded = secretKey.getEncoded();
        if (encoded.length == 32) {
            this.Cardinal = new SecretKeySpec(encoded, 0, 16, "HMACSHA256");
            this.getInstance = new SecretKeySpec(encoded, 16, 16, "AES");
            this.init = 16;
        } else if (encoded.length == 48) {
            this.Cardinal = new SecretKeySpec(encoded, 0, 24, "HMACSHA384");
            this.getInstance = new SecretKeySpec(encoded, 24, 24, "AES");
            this.init = 24;
        } else if (encoded.length == 64) {
            this.Cardinal = new SecretKeySpec(encoded, 0, 32, "HMACSHA512");
            this.getInstance = new SecretKeySpec(encoded, 32, 32, "AES");
            this.init = 32;
        } else {
            throw new KeyLengthException("Unsupported AES/CBC/PKCS5Padding/HMAC-SHA2 key length, must be 256, 384 or 512 bits");
        }
    }

    public static Signature configure(JWSAlgorithm jWSAlgorithm, Provider provider) throws JOSEException {
        Signature signature;
        String str = "RSASSA-PSS";
        PSSParameterSpec pSSParameterSpec = null;
        if (jWSAlgorithm.equals(JWSAlgorithm.Cardinal)) {
            str = OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256;
        } else if (jWSAlgorithm.equals(JWSAlgorithm.getInstance)) {
            str = "SHA384withRSA";
        } else if (jWSAlgorithm.equals(JWSAlgorithm.init)) {
            str = "SHA512withRSA";
        } else if (jWSAlgorithm.equals(JWSAlgorithm.getSDKVersion)) {
            pSSParameterSpec = new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
        } else if (jWSAlgorithm.equals(JWSAlgorithm.CardinalRenderType)) {
            pSSParameterSpec = new PSSParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, 48, 1);
        } else if (jWSAlgorithm.equals(JWSAlgorithm.CardinalActionCode)) {
            pSSParameterSpec = new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1);
        } else {
            throw new JOSEException(AlgorithmSupportMessage.init(jWSAlgorithm, setShowDividers.configure));
        }
        if (provider != null) {
            try {
                signature = Signature.getInstance(str, provider);
            } catch (NoSuchAlgorithmException e) {
                StringBuilder sb = new StringBuilder("Unsupported RSASSA algorithm: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            }
        } else {
            signature = Signature.getInstance(str);
        }
        if (pSSParameterSpec != null) {
            try {
                signature.setParameter(pSSParameterSpec);
            } catch (InvalidAlgorithmParameterException e2) {
                StringBuilder sb2 = new StringBuilder("Invalid RSASSA-PSS salt length parameter: ");
                sb2.append(e2.getMessage());
                throw new JOSEException(sb2.toString(), e2);
            }
        }
        return signature;
    }

    public static byte[] configure(RSAPublicKey rSAPublicKey, SecretKey secretKey, Provider provider) throws JOSEException {
        Cipher cipher;
        if (provider == null) {
            try {
                cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
            } catch (IllegalBlockSizeException e) {
                throw new JOSEException("RSA block size exception: The RSA key is too short, try a longer one", e);
            } catch (Exception e2) {
                throw new JOSEException(e2.getMessage(), e2);
            }
        } else {
            cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", provider);
        }
        cipher.init(1, rSAPublicKey, new SecureRandom());
        return cipher.doFinal(secretKey.getEncoded());
    }
}
