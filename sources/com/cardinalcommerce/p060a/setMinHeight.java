package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWECryptoParts;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.DirectEncrypter;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AAD;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESCBC;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESGCM;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AuthenticatedCipherText;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.DeflateHelper;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.ByteUtils;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Container;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.cardinalcommerce.a.setMinHeight */
public final class setMinHeight extends DirectEncrypter {

    /* renamed from: a */
    private static int f2885a = 12;

    /* renamed from: c */
    private static int f2886c = 0;

    /* renamed from: d */
    private static int f2887d = 1;

    /* renamed from: b */
    private byte f2888b;

    static {
        int i = 0 ^ 3;
        int i2 = ((((0 & 3) | i) << 1) - (~(-i))) - 1;
        f2887d = i2 % 128;
        if ((i2 % 2 == 0 ? 'J' : 8) == 'J') {
            Object obj = null;
            super.hashCode();
        }
    }

    public setMinHeight(byte[] bArr, byte b) throws KeyLengthException {
        super(new SecretKeySpec(bArr, "AES"));
        this.f2888b = b;
        f2885a = 12;
    }

    /* renamed from: a */
    private static byte[] m2034a(byte b) {
        int i = f2886c;
        int i2 = (((i | 88) << 1) - (i ^ 88)) - 1;
        f2887d = i2 % 128;
        int i3 = i2 % 2;
        byte[] b2 = m2035b(b);
        int i4 = f2886c;
        int i5 = (i4 ^ 79) + ((i4 & 79) << 1);
        f2887d = i5 % 128;
        if (!(i5 % 2 == 0)) {
            return b2;
        }
        Object obj = null;
        super.hashCode();
        return b2;
    }

    /* renamed from: b */
    private static byte[] m2035b(byte b) {
        int i = (f2886c + 46) - 1;
        f2887d = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = f2885a;
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) 1);
            bArr[i2 << 1] = b;
            return bArr;
        }
        int i3 = f2885a;
        byte[] bArr2 = new byte[i3];
        Arrays.fill(bArr2, (byte) 0);
        int i4 = i3 - 0;
        bArr2[(i4 ^ -1) + ((i4 & -1) << 1)] = b;
        return bArr2;
    }

    public final JWECryptoParts Cardinal(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        AuthenticatedCipherText authenticatedCipherText;
        int i = f2886c;
        int i2 = i & 103;
        boolean z = true;
        int i3 = (((i ^ 103) | i2) << 1) - ((i | 103) & (~i2));
        f2887d = i3 % 128;
        int i4 = i3 % 2;
        JWEAlgorithm Cardinal = jWEHeader.Cardinal();
        if (Cardinal.equals(JWEAlgorithm.cleanup)) {
            EncryptionMethod encryptionMethod = jWEHeader.init;
            if (encryptionMethod.Cardinal != ByteUtils.configure(init().getEncoded())) {
                throw new KeyLengthException(encryptionMethod.Cardinal, encryptionMethod);
            } else if (encryptionMethod.Cardinal == ByteUtils.configure(init().getEncoded())) {
                byte[] init = DeflateHelper.init(jWEHeader, bArr);
                byte[] configure = AAD.configure(jWEHeader);
                byte[] a = m2034a(this.f2888b);
                Object obj = null;
                if (jWEHeader.init.equals(EncryptionMethod.getInstance)) {
                    int i5 = f2886c;
                    int i6 = ((i5 | 53) << 1) - (i5 ^ 53);
                    f2887d = i6 % 128;
                    if ((i6 % 2 == 0 ? 'b' : 31) != 'b') {
                        authenticatedCipherText = AESCBC.Cardinal(init(), a, init, configure, cca_continue().Cardinal, cca_continue().Cardinal);
                    } else {
                        authenticatedCipherText = AESCBC.Cardinal(init(), a, init, configure, cca_continue().Cardinal, cca_continue().Cardinal);
                        super.hashCode();
                    }
                } else if (jWEHeader.init.equals(EncryptionMethod.cleanup)) {
                    authenticatedCipherText = AESGCM.getInstance(init(), new Container(a), init, configure, cca_continue().Cardinal);
                    int i7 = f2886c + 110;
                    int i8 = (i7 & -1) + (i7 | -1);
                    f2887d = i8 % 128;
                    int i9 = i8 % 2;
                } else {
                    throw new JOSEException(AlgorithmSupportMessage.configure(jWEHeader.init, (Collection<EncryptionMethod>) init));
                }
                JWECryptoParts jWECryptoParts = new JWECryptoParts(jWEHeader, (Base64URL) null, Base64URL.cca_continue(a), Base64URL.cca_continue(authenticatedCipherText.Cardinal()), Base64URL.cca_continue(authenticatedCipherText.getInstance()));
                int i10 = f2886c;
                int i11 = i10 & 17;
                int i12 = (i10 ^ 17) | i11;
                int i13 = (i11 ^ i12) + ((i12 & i11) << 1);
                f2887d = i13 % 128;
                if (i13 % 2 == 0) {
                    z = false;
                }
                if (z) {
                    return jWECryptoParts;
                }
                super.hashCode();
                return jWECryptoParts;
            } else {
                StringBuilder sb = new StringBuilder("The Content Encryption Key (CEK) length for ");
                sb.append(encryptionMethod);
                sb.append(" must be ");
                sb.append(encryptionMethod.Cardinal);
                sb.append(" bits");
                throw new KeyLengthException(sb.toString());
            }
        } else {
            throw new JOSEException("Invalid alg ".concat(String.valueOf(Cardinal)));
        }
    }
}
