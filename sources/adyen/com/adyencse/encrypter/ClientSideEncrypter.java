package adyen.com.adyencse.encrypter;

import adyen.com.adyencse.encrypter.exception.EncrypterException;
import android.util.Base64;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ClientSideEncrypter {

    /* renamed from: a */
    private static final String f33a = "adyenan";

    /* renamed from: b */
    private static final String f34b = "0_1_1";

    /* renamed from: c */
    private static final String f35c = "$";

    /* renamed from: d */
    private PublicKey f36d;

    /* renamed from: e */
    private Cipher f37e;

    /* renamed from: f */
    private Cipher f38f;

    /* renamed from: g */
    private SecureRandom f39g = new SecureRandom();

    public ClientSideEncrypter(String str) throws EncrypterException {
        PRNGFixes.apply();
        String[] split = str.split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
        try {
            try {
                this.f36d = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(split[1].toLowerCase(Locale.getDefault()), 16), new BigInteger(split[0].toLowerCase(Locale.getDefault()), 16)));
                try {
                    this.f37e = Cipher.getInstance("AES/CCM/NoPadding", BouncyCastleProvider.PROVIDER_NAME);
                } catch (NoSuchAlgorithmException e) {
                    throw new EncrypterException("Problem instantiation AES Cipher Algorithm", e);
                } catch (NoSuchPaddingException e2) {
                    throw new EncrypterException("Problem instantiation AES Cipher Padding", e2);
                } catch (NoSuchProviderException e3) {
                    e3.printStackTrace();
                }
                try {
                    Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
                    this.f38f = instance;
                    instance.init(1, this.f36d);
                } catch (NoSuchAlgorithmException e4) {
                    throw new EncrypterException("Problem instantiation RSA Cipher Algorithm", e4);
                } catch (NoSuchPaddingException e5) {
                    throw new EncrypterException("Problem instantiation RSA Cipher Padding", e5);
                } catch (InvalidKeyException e6) {
                    throw new EncrypterException("Invalid public key: " + str, e6);
                }
            } catch (InvalidKeySpecException e7) {
                throw new EncrypterException("Problem reading public key: " + str, e7);
            }
        } catch (NoSuchAlgorithmException e8) {
            e8.printStackTrace();
        }
    }

    public String encrypt(String str) throws EncrypterException {
        SecretKey a = m68a(256);
        byte[] b = m69b(12);
        try {
            this.f37e.init(1, a, new IvParameterSpec(b));
            byte[] doFinal = this.f37e.doFinal(str.getBytes());
            byte[] bArr = new byte[(b.length + doFinal.length)];
            System.arraycopy(b, 0, bArr, 0, b.length);
            System.arraycopy(doFinal, 0, bArr, b.length, doFinal.length);
            try {
                return String.format("%s%s%s%s%s%s", new Object[]{f33a, f34b, f35c, Base64.encodeToString(this.f38f.doFinal(a.getEncoded()), 2), f35c, Base64.encodeToString(bArr, 2)});
            } catch (IllegalBlockSizeException e) {
                throw new EncrypterException("Incorrect RSA Block Size", e);
            } catch (BadPaddingException e2) {
                throw new EncrypterException("Incorrect RSA Padding", e2);
            }
        } catch (IllegalBlockSizeException e3) {
            throw new EncrypterException("Incorrect AES Block Size", e3);
        } catch (BadPaddingException e4) {
            throw new EncrypterException("Incorrect AES Padding", e4);
        } catch (InvalidKeyException e5) {
            throw new EncrypterException("Invalid AES Key", e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new EncrypterException("Invalid AES Parameters", e6);
        }
    }

    /* renamed from: a */
    private SecretKey m68a(int i) throws EncrypterException {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(i);
            return instance.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new EncrypterException("Unable to get AES algorithm", e);
        }
    }

    /* renamed from: b */
    private synchronized byte[] m69b(int i) {
        byte[] bArr;
        bArr = new byte[i];
        this.f39g.nextBytes(bArr);
        return bArr;
    }
}
