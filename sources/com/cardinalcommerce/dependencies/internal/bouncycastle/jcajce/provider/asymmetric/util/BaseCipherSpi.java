package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.cardinalcommerce.p060a.JWEObject;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.JWSObject;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class BaseCipherSpi extends CipherSpi {
    private final JWEObject cca_continue = new JWSObject();

    public BaseCipherSpi() {
        Class<IvParameterSpec> cls = IvParameterSpec.class;
        Class<PBEParameterSpec> cls2 = PBEParameterSpec.class;
        Class<RC2ParameterSpec> cls3 = RC2ParameterSpec.class;
        Class<RC5ParameterSpec> cls4 = RC5ParameterSpec.class;
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        return -1;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        StringBuilder sb = new StringBuilder("Padding ");
        sb.append(str);
        sb.append(" unknown.");
        throw new NoSuchPaddingException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            try {
                return engineDoFinal(encoded, 0, encoded.length);
            } catch (BadPaddingException e) {
                throw new IllegalBlockSizeException(e.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }

    /* access modifiers changed from: protected */
    public final AlgorithmParameters getInstance(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.cca_continue.configure(str);
    }

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        public final byte[] getInstance() {
            return this.buf;
        }

        public final void cca_continue() {
            byte[] bArr = this.buf;
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = 0;
            }
            reset();
        }
    }

    /* access modifiers changed from: protected */
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            if (!str.equals("") || i != 2) {
                try {
                    KeyFactory init = this.cca_continue.init(str);
                    if (i == 1) {
                        return init.generatePublic(new X509EncodedKeySpec(engineDoFinal));
                    }
                    if (i == 2) {
                        return init.generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
                    }
                    throw new InvalidKeyException("Unknown key type ".concat(String.valueOf(i)));
                } catch (NoSuchAlgorithmException e) {
                    StringBuilder sb = new StringBuilder("Unknown key type ");
                    sb.append(e.getMessage());
                    throw new InvalidKeyException(sb.toString());
                } catch (InvalidKeySpecException e2) {
                    StringBuilder sb2 = new StringBuilder("Unknown key type ");
                    sb2.append(e2.getMessage());
                    throw new InvalidKeyException(sb2.toString());
                } catch (NoSuchProviderException e3) {
                    StringBuilder sb3 = new StringBuilder("Unknown key type ");
                    sb3.append(e3.getMessage());
                    throw new InvalidKeyException(sb3.toString());
                }
            } else {
                try {
                    PrivateKeyInfo init2 = PrivateKeyInfo.init(engineDoFinal);
                    PrivateKey configure = JWK.configure(init2);
                    if (configure != null) {
                        return configure;
                    }
                    StringBuilder sb4 = new StringBuilder("algorithm ");
                    sb4.append(init2.cca_continue.init);
                    sb4.append(" not supported");
                    throw new InvalidKeyException(sb4.toString());
                } catch (Exception unused) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
        } catch (KeyFactorySpi.ECDH e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (BadPaddingException e5) {
            throw new InvalidKeyException("unable to unwrap") {
                public final synchronized Throwable getCause() {
                    return e5;
                }
            };
        } catch (IllegalBlockSizeException e6) {
            throw new InvalidKeyException(e6.getMessage());
        }
    }
}
