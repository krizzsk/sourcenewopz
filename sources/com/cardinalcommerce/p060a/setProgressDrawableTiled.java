package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.util.p064io.pem.PemReader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.ConcatKDF;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.ECDH;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.SecretKey;

/* renamed from: com.cardinalcommerce.a.setProgressDrawableTiled */
public final class setProgressDrawableTiled {

    /* renamed from: a */
    private static int f2948a = 0;

    /* renamed from: b */
    private static int f2949b = 1;
    public static final JWK cca_continue = new JWK();

    static {
        int i = f2949b;
        int i2 = i ^ 11;
        boolean z = true;
        int i3 = -(-((i & 11) << 1));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2948a = i4 % 128;
        if (i4 % 2 != 0) {
            z = false;
        }
        if (!z) {
            Object obj = null;
            super.hashCode();
        }
    }

    public static KeyPair configure() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        ECGenParameterSpec eCGenParameterSpec = new ECGenParameterSpec("P-256");
        KeyPairGenerator instance = KeyPairGenerator.getInstance("ECDH", cca_continue);
        instance.initialize(eCGenParameterSpec, new SecureRandom());
        KeyPair generateKeyPair = instance.generateKeyPair();
        int i = f2949b;
        int i2 = (i & -92) | ((~i) & 91);
        boolean z = true;
        int i3 = -(-((i & 91) << 1));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2948a = i4 % 128;
        if (i4 % 2 != 0) {
            z = false;
        }
        if (z) {
            return generateKeyPair;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return generateKeyPair;
    }

    public static SecretKey cca_continue(setIndeterminateDrawableTiled setindeterminatedrawabletiled, KeyPair keyPair, String str) {
        int i = f2948a + 49;
        f2949b = i % 128;
        int i2 = i % 2;
        SecretKey cca_continue2 = cca_continue((PublicKey) m2071a(setindeterminatedrawabletiled, ((ECPublicKey) keyPair.getPublic()).getParams(), cca_continue), keyPair.getPrivate(), str);
        int i3 = f2949b;
        int i4 = (((i3 ^ 75) | (i3 & 75)) << 1) - (((~i3) & 75) | (i3 & -76));
        f2948a = i4 % 128;
        if ((i4 % 2 != 0 ? 'I' : '=') != 'I') {
            return cca_continue2;
        }
        int i5 = 41 / 0;
        return cca_continue2;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, java.lang.Object, javax.crypto.SecretKey] */
    public static SecretKey cca_continue(PublicKey publicKey, PrivateKey privateKey, String str) {
        ? r0 = 0;
        try {
            SecretKey Cardinal = new ConcatKDF("SHA-256").Cardinal(ECDH.cca_continue((ECPublicKey) publicKey, privateKey, cca_continue), 256, ConcatKDF.Cardinal(ConcatKDF.cca_continue(), ConcatKDF.configure(r0), ConcatKDF.configure(Base64URL.init(str)), ConcatKDF.init(), ConcatKDF.getInstance()));
            int i = f2948a;
            char c = 1;
            int i2 = (i ^ 102) + ((i & 102) << 1);
            int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
            f2949b = i3 % 128;
            if (i3 % 2 != 0) {
                c = 'J';
            }
            if (c == 'J') {
                return Cardinal;
            }
            super.hashCode();
            return Cardinal;
        } catch (Exception e) {
            setProgressBackgroundTintMode init = setProgressBackgroundTintMode.init();
            StringBuilder sb = new StringBuilder("Error generating ECDH Secret Key. ");
            sb.append(e.getLocalizedMessage());
            init.init(new setImageMatrix(11405, sb.toString()));
            return r0;
        }
    }

    /* renamed from: a */
    private static ECPublicKey m2071a(setIndeterminateDrawableTiled setindeterminatedrawabletiled, ECParameterSpec eCParameterSpec, Provider provider) {
        ECPublicKey eCPublicKey = null;
        try {
            ECPublicKey eCPublicKey2 = (ECPublicKey) KeyFactory.getInstance("EC", provider).generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, new Base64URL(setindeterminatedrawabletiled.cca_continue).cca_continue()), new BigInteger(1, new Base64URL(setindeterminatedrawabletiled.init).cca_continue())), eCParameterSpec));
            int i = f2948a;
            int i2 = (i & 77) + (i | 77);
            f2949b = i2 % 128;
            int i3 = i2 % 2;
            eCPublicKey = eCPublicKey2;
        } catch (Exception e) {
            setProgressBackgroundTintMode init = setProgressBackgroundTintMode.init();
            StringBuilder sb = new StringBuilder("Error generating ECDH Key Pair. ");
            sb.append(e.getLocalizedMessage());
            init.init(new setImageMatrix(11405, sb.toString()));
        }
        int i4 = f2949b;
        int i5 = i4 & 25;
        int i6 = (i4 ^ 25) | i5;
        int i7 = (i5 & i6) + (i6 | i5);
        f2948a = i7 % 128;
        int i8 = i7 % 2;
        return eCPublicKey;
    }

    public static RSAPublicKey configure(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(new PemReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8"))))).init().cca_continue()));
        int i = f2949b;
        int i2 = i & 5;
        int i3 = -(-(i | 5));
        int i4 = (i2 & i3) + (i3 | i2);
        f2948a = i4 % 128;
        if ((i4 % 2 != 0 ? 'B' : '`') == '`') {
            return rSAPublicKey;
        }
        int i5 = 17 / 0;
        return rSAPublicKey;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.security.cert.Certificate} */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.security.cert.Certificate] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.interfaces.RSAPublicKey Cardinal(java.lang.String r7) throws java.io.IOException, java.security.cert.CertificateException {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            byte[] r7 = r7.getBytes(r1)
            r0.<init>(r7)
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream
            r7.<init>(r0)
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)
            int r1 = f2948a
            r2 = r1 | 51
            r3 = 1
            int r2 = r2 << r3
            r1 = r1 ^ 51
            int r2 = r2 - r1
            int r1 = r2 % 128
            f2949b = r1
            int r2 = r2 % 2
            r1 = 0
            r2 = r1
        L_0x002b:
            int r4 = r7.available()
            r5 = 0
            if (r4 <= 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            r4 = 0
        L_0x0035:
            if (r4 == r3) goto L_0x00ba
            r7 = 70
            if (r2 == 0) goto L_0x003e
            r0 = 72
            goto L_0x0040
        L_0x003e:
            r0 = 70
        L_0x0040:
            if (r0 == r7) goto L_0x0086
            int r7 = f2949b
            r0 = 111(0x6f, float:1.56E-43)
            r4 = r7 ^ 111(0x6f, float:1.56E-43)
            r6 = r7 & 111(0x6f, float:1.56E-43)
            r4 = r4 | r6
            int r4 = r4 << r3
            r6 = r7 & -112(0xffffffffffffff90, float:NaN)
            int r7 = ~r7
            r7 = r7 & r0
            r7 = r7 | r6
            int r7 = -r7
            r0 = r4 & r7
            r7 = r7 | r4
            int r0 = r0 + r7
            int r7 = r0 % 128
            f2948a = r7
            int r0 = r0 % 2
            r7 = 71
            if (r0 == 0) goto L_0x0063
            r0 = 71
            goto L_0x0065
        L_0x0063:
            r0 = 42
        L_0x0065:
            if (r0 == r7) goto L_0x006d
            java.security.PublicKey r7 = r2.getPublicKey()
        L_0x006b:
            r1 = r7
            goto L_0x0075
        L_0x006d:
            java.security.PublicKey r7 = r2.getPublicKey()
            super.hashCode()     // Catch:{ all -> 0x0084 }
            goto L_0x006b
        L_0x0075:
            int r7 = f2949b
            r0 = r7 & 27
            r7 = r7 ^ 27
            r7 = r7 | r0
            int r0 = r0 + r7
            int r7 = r0 % 128
            f2948a = r7
            int r0 = r0 % 2
            goto L_0x0093
        L_0x0084:
            r7 = move-exception
            throw r7
        L_0x0086:
            int r7 = f2948a
            r0 = r7 & 85
            r7 = r7 | 85
            int r0 = r0 + r7
            int r7 = r0 % 128
            f2949b = r7
            int r0 = r0 % 2
        L_0x0093:
            java.security.interfaces.RSAPublicKey r1 = (java.security.interfaces.RSAPublicKey) r1
            int r7 = f2948a
            r0 = r7 ^ 41
            r2 = r7 & 41
            r0 = r0 | r2
            int r0 = r0 << r3
            int r2 = ~r2
            r7 = r7 | 41
            r7 = r7 & r2
            int r7 = -r7
            r2 = r0 ^ r7
            r7 = r7 & r0
            int r7 = r7 << r3
            int r2 = r2 + r7
            int r7 = r2 % 128
            f2949b = r7
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r3 = 0
        L_0x00b1:
            if (r3 == 0) goto L_0x00b9
            r7 = 68
            int r7 = r7 / r5
            return r1
        L_0x00b7:
            r7 = move-exception
            throw r7
        L_0x00b9:
            return r1
        L_0x00ba:
            int r2 = f2948a
            r4 = r2 & 7
            r2 = r2 ^ 7
            r2 = r2 | r4
            r6 = r4 | r2
            int r6 = r6 << r3
            r2 = r2 ^ r4
            int r6 = r6 - r2
            int r2 = r6 % 128
            f2949b = r2
            int r6 = r6 % 2
            if (r6 != 0) goto L_0x00cf
            r5 = 1
        L_0x00cf:
            java.security.cert.Certificate r2 = r0.generateCertificate(r7)
            if (r5 == r3) goto L_0x00d6
            goto L_0x00d9
        L_0x00d6:
            super.hashCode()     // Catch:{ all -> 0x00e9 }
        L_0x00d9:
            int r4 = f2949b
            r5 = r4 & 33
            r4 = r4 ^ 33
            r4 = r4 | r5
            int r5 = r5 + r4
            int r4 = r5 % 128
            f2948a = r4
            int r5 = r5 % 2
            goto L_0x002b
        L_0x00e9:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressDrawableTiled.Cardinal(java.lang.String):java.security.interfaces.RSAPublicKey");
    }

    public static ECPublicKey init(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        ECPublicKey eCPublicKey = (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(new PemReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8"))))).init().cca_continue()));
        int i = f2949b;
        int i2 = (i & 97) + (i | 97);
        f2948a = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 9 : 12) != 9) {
            return eCPublicKey;
        }
        Object obj = null;
        super.hashCode();
        return eCPublicKey;
    }
}
