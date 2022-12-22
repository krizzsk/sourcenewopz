package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.KeyLengthException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AAD;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESCBC;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESGCM;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.DeflateHelper;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.ByteUtils;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.cardinalcommerce.a.setMaxWidth */
public final class setMaxWidth {
    public static final Set<EncryptionMethod> Cardinal;
    public static final Map<Integer, Set<EncryptionMethod>> cca_continue;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(EncryptionMethod.getInstance);
        linkedHashSet.add(EncryptionMethod.init);
        linkedHashSet.add(EncryptionMethod.CardinalError);
        linkedHashSet.add(EncryptionMethod.cleanup);
        linkedHashSet.add(EncryptionMethod.values);
        linkedHashSet.add(EncryptionMethod.CardinalActionCode);
        linkedHashSet.add(EncryptionMethod.getSDKVersion);
        linkedHashSet.add(EncryptionMethod.getWarnings);
        Cardinal = Collections.unmodifiableSet(linkedHashSet);
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        hashSet.add(EncryptionMethod.cleanup);
        hashSet2.add(EncryptionMethod.values);
        hashSet3.add(EncryptionMethod.CardinalActionCode);
        hashSet3.add(EncryptionMethod.getInstance);
        hashSet3.add(EncryptionMethod.getSDKVersion);
        hashSet4.add(EncryptionMethod.init);
        hashSet5.add(EncryptionMethod.CardinalError);
        hashSet5.add(EncryptionMethod.getWarnings);
        hashMap.put(128, Collections.unmodifiableSet(hashSet));
        hashMap.put(192, Collections.unmodifiableSet(hashSet2));
        hashMap.put(256, Collections.unmodifiableSet(hashSet3));
        hashMap.put(384, Collections.unmodifiableSet(hashSet4));
        hashMap.put(512, Collections.unmodifiableSet(hashSet5));
        cca_continue = Collections.unmodifiableMap(hashMap);
    }

    public static SecretKey init(EncryptionMethod encryptionMethod, SecureRandom secureRandom) throws JOSEException {
        if (Cardinal.contains(encryptionMethod)) {
            byte[] bArr = new byte[ByteUtils.init(encryptionMethod.Cardinal)];
            secureRandom.nextBytes(bArr);
            return new SecretKeySpec(bArr, "AES");
        }
        throw new JOSEException(AlgorithmSupportMessage.configure(encryptionMethod, (Collection<EncryptionMethod>) Cardinal));
    }

    /* renamed from: a */
    private static void m2033a(SecretKey secretKey, EncryptionMethod encryptionMethod) throws KeyLengthException {
        try {
            if (encryptionMethod.Cardinal != ByteUtils.Cardinal(secretKey.getEncoded())) {
                StringBuilder sb = new StringBuilder("The Content Encryption Key (CEK) length for ");
                sb.append(encryptionMethod);
                sb.append(" must be ");
                sb.append(encryptionMethod.Cardinal);
                sb.append(" bits");
                throw new KeyLengthException(sb.toString());
            }
        } catch (setIndeterminateDrawable e) {
            StringBuilder sb2 = new StringBuilder("The Content Encryption Key (CEK) is too long: ");
            sb2.append(e.getMessage());
            throw new KeyLengthException(sb2.toString());
        }
    }

    /* JADX WARNING: type inference failed for: r10v2, types: [T] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWECryptoParts configure(com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader r8, byte[] r9, javax.crypto.SecretKey r10, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r11, com.cardinalcommerce.p060a.setMeasureWithLargestChildEnabled r12) throws com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException {
        /*
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            m2033a(r10, r0)
            byte[] r9 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.DeflateHelper.init(r8, r9)
            byte[] r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AAD.configure(r8)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.getInstance
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ae
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.init
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ae
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.CardinalError
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002d
            goto L_0x00ae
        L_0x002d:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.cleanup
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008d
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.values
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008d
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.CardinalActionCode
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004c
            goto L_0x008d
        L_0x004c:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.getSDKVersion
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006f
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r0 = r8.init
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod.getWarnings
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0061
            goto L_0x006f
        L_0x0061:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException r9 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod r8 = r8.init
            java.util.Set<com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod> r10 = Cardinal
            java.lang.String r8 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AlgorithmSupportMessage.configure((com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod) r8, (java.util.Collection<com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod>) r10)
            r9.<init>(r8)
            throw r9
        L_0x006f:
            java.security.SecureRandom r0 = r12.configure
            if (r0 == 0) goto L_0x0076
            java.security.SecureRandom r0 = r12.configure
            goto L_0x007b
        L_0x0076:
            java.security.SecureRandom r0 = new java.security.SecureRandom
            r0.<init>()
        L_0x007b:
            byte[] r0 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESCBC.configure(r0)
            java.security.Provider r6 = r12.Cardinal
            java.security.Provider r7 = r12.Cardinal
            r1 = r8
            r2 = r10
            r3 = r11
            r4 = r0
            r5 = r9
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AuthenticatedCipherText r9 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESCBC.cca_continue((com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader) r1, (javax.crypto.SecretKey) r2, (com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL) r3, (byte[]) r4, (byte[]) r5, (java.security.Provider) r6, (java.security.Provider) r7)
            goto L_0x00c9
        L_0x008d:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Container r0 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Container
            java.security.SecureRandom r1 = r12.configure
            if (r1 == 0) goto L_0x0096
            java.security.SecureRandom r1 = r12.configure
            goto L_0x009b
        L_0x0096:
            java.security.SecureRandom r1 = new java.security.SecureRandom
            r1.<init>()
        L_0x009b:
            byte[] r1 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESGCM.Cardinal(r1)
            r0.<init>(r1)
            java.security.Provider r12 = r12.Cardinal
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AuthenticatedCipherText r9 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESGCM.getInstance(r10, r0, r9, r4, r12)
            T r10 = r0.getInstance
            r0 = r10
            byte[] r0 = (byte[]) r0
            goto L_0x00c9
        L_0x00ae:
            java.security.SecureRandom r0 = r12.configure
            if (r0 == 0) goto L_0x00b5
            java.security.SecureRandom r0 = r12.configure
            goto L_0x00ba
        L_0x00b5:
            java.security.SecureRandom r0 = new java.security.SecureRandom
            r0.<init>()
        L_0x00ba:
            byte[] r0 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESCBC.configure(r0)
            java.security.Provider r5 = r12.Cardinal
            java.security.Provider r6 = r12.Cardinal
            r1 = r10
            r2 = r0
            r3 = r9
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AuthenticatedCipherText r9 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl.AESCBC.Cardinal(r1, r2, r3, r4, r5, r6)
        L_0x00c9:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWECryptoParts r10 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWECryptoParts
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r4 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.cca_continue(r0)
            byte[] r12 = r9.Cardinal()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r5 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.cca_continue(r12)
            byte[] r9 = r9.getInstance()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL r6 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL.cca_continue(r9)
            r1 = r10
            r2 = r8
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMaxWidth.configure(com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader, byte[], javax.crypto.SecretKey, com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL, com.cardinalcommerce.a.setMeasureWithLargestChildEnabled):com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWECryptoParts");
    }

    public static byte[] init(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, SecretKey secretKey, setMeasureWithLargestChildEnabled setmeasurewithlargestchildenabled) throws JOSEException {
        byte[] bArr;
        m2033a(secretKey, jWEHeader.init);
        byte[] configure = AAD.configure(jWEHeader);
        if (jWEHeader.init.equals(EncryptionMethod.getInstance) || jWEHeader.init.equals(EncryptionMethod.init) || jWEHeader.init.equals(EncryptionMethod.CardinalError)) {
            bArr = AESCBC.cca_continue(secretKey, base64URL.cca_continue(), base64URL2.cca_continue(), configure, base64URL3.cca_continue(), setmeasurewithlargestchildenabled.Cardinal, setmeasurewithlargestchildenabled.Cardinal);
        } else if (jWEHeader.init.equals(EncryptionMethod.cleanup) || jWEHeader.init.equals(EncryptionMethod.values) || jWEHeader.init.equals(EncryptionMethod.CardinalActionCode)) {
            bArr = AESGCM.init(secretKey, base64URL.cca_continue(), base64URL2.cca_continue(), configure, base64URL3.cca_continue(), setmeasurewithlargestchildenabled.Cardinal);
        } else if (jWEHeader.init.equals(EncryptionMethod.getSDKVersion) || jWEHeader.init.equals(EncryptionMethod.getWarnings)) {
            bArr = AESCBC.init(jWEHeader, secretKey, (Base64URL) null, base64URL, base64URL2, base64URL3, setmeasurewithlargestchildenabled.Cardinal, setmeasurewithlargestchildenabled.Cardinal);
        } else {
            throw new JOSEException(AlgorithmSupportMessage.configure(jWEHeader.init, (Collection<EncryptionMethod>) Cardinal));
        }
        return DeflateHelper.getInstance(jWEHeader, bArr);
    }
}
