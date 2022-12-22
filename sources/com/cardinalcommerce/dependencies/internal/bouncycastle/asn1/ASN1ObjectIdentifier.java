package com.cardinalcommerce.dependencies.internal.bouncycastle.asn1;

import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getType;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setEnableDFSync;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ASN1ObjectIdentifier extends setLocationDataConsentGiven {

    /* renamed from: b */
    private static final ConcurrentMap<C2139configure, ASN1ObjectIdentifier> f3133b = new ConcurrentHashMap();

    /* renamed from: a */
    private byte[] f3134a;
    public final String init;

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier$configure */
    static class C2139configure {
        private final int cca_continue;
        private final byte[] getInstance;

        C2139configure(byte[] bArr) {
            this.cca_continue = setForegroundTintBlendMode.init(bArr);
            this.getInstance = bArr;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof C2139configure) {
                return setForegroundTintBlendMode.Cardinal(this.getInstance, ((C2139configure) obj).getInstance);
            }
            return false;
        }

        public final int hashCode() {
            return this.cca_continue;
        }
    }

    public ASN1ObjectIdentifier(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'identifier' cannot be null");
        } else if (m2182a(str)) {
            this.init = str;
        } else {
            StringBuilder sb = new StringBuilder("string ");
            sb.append(str);
            sb.append(" not an OID");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private ASN1ObjectIdentifier(byte[] bArr) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigInteger = null;
        for (int i = 0; i != bArr2.length; i++) {
            byte b = bArr2[i] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (b & Byte.MAX_VALUE));
                if ((b & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf((long) (b & Byte.MAX_VALUE)));
                if ((b & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.init = stringBuffer.toString();
        this.f3134a = setForegroundTintBlendMode.cca_continue(bArr);
    }

    /* renamed from: a */
    private void m2179a(ByteArrayOutputStream byteArrayOutputStream) {
        IESCipher.ECIESwithCipher eCIESwithCipher = new IESCipher.ECIESwithCipher(this.init);
        int parseInt = Integer.parseInt(eCIESwithCipher.init()) * 40;
        String init2 = eCIESwithCipher.init();
        if (init2.length() <= 18) {
            m2180a(byteArrayOutputStream, ((long) parseInt) + Long.parseLong(init2));
        } else {
            m2181a(byteArrayOutputStream, new BigInteger(init2).add(BigInteger.valueOf((long) parseInt)));
        }
        while (eCIESwithCipher.Cardinal()) {
            String init3 = eCIESwithCipher.init();
            if (init3.length() <= 18) {
                m2180a(byteArrayOutputStream, Long.parseLong(init3));
            } else {
                m2181a(byteArrayOutputStream, new BigInteger(init3));
            }
        }
    }

    /* renamed from: a */
    private static void m2180a(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    /* renamed from: a */
    private static void m2181a(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    /* renamed from: a */
    private static boolean m2182a(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return m2183a(str, 2);
    }

    /* renamed from: a */
    private static boolean m2183a(String str, int i) {
        boolean z;
        char charAt;
        int length = str.length();
        do {
            z = false;
            while (true) {
                length--;
                if (length < i) {
                    return z;
                }
                charAt = str.charAt(length);
                if ('0' <= charAt && charAt <= '9') {
                    z = true;
                }
            }
            if (charAt != '.') {
                break;
            }
        } while (z);
        return false;
    }

    /* renamed from: a */
    private synchronized byte[] m2184a() {
        if (this.f3134a == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m2179a(byteArrayOutputStream);
            this.f3134a = byteArrayOutputStream.toByteArray();
        }
        return this.f3134a;
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) obj;
        }
        if (obj instanceof getProxyAddress) {
            setLocationDataConsentGiven values = ((getProxyAddress) obj).values();
            if (values instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier) values;
            }
        }
        StringBuilder sb = new StringBuilder("illegal object in getInstance: ");
        sb.append(obj.getClass().getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public static ASN1ObjectIdentifier init(byte[] bArr) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) f3133b.get(new C2139configure(bArr));
        return aSN1ObjectIdentifier == null ? new ASN1ObjectIdentifier(bArr) : aSN1ObjectIdentifier;
    }

    public final boolean Cardinal() {
        return false;
    }

    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (setlocationdataconsentgiven == this) {
            return true;
        }
        if (!(setlocationdataconsentgiven instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.init.equals(((ASN1ObjectIdentifier) setlocationdataconsentgiven).init);
    }

    public final int configure() throws IOException {
        int length = m2184a().length;
        return KeyAgreementSpi.Cardinal(length) + 1 + length;
    }

    public final ASN1ObjectIdentifier getInstance() {
        C2139configure configure = new C2139configure(m2184a());
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) f3133b.get(configure);
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        ASN1ObjectIdentifier putIfAbsent = f3133b.putIfAbsent(configure, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    public int hashCode() {
        return this.init.hashCode();
    }

    public static ASN1ObjectIdentifier init(getType gettype) {
        setLocationDataConsentGiven values = gettype.getInstance != null ? gettype.getInstance.values() : null;
        return values instanceof ASN1ObjectIdentifier ? getInstance(values) : init(isEnableDFSync.init(values).cca_continue());
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (m2183a(str, 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(aSN1ObjectIdentifier.init);
            sb.append(".");
            sb.append(str);
            this.init = sb.toString();
            return;
        }
        StringBuilder sb2 = new StringBuilder("string ");
        sb2.append(str);
        sb2.append(" not a valid OID branch");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean cca_continue(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = this.init;
        String str2 = aSN1ObjectIdentifier.init;
        return str.length() > str2.length() && str.charAt(str2.length()) == '.' && str.startsWith(str2);
    }

    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] a = m2184a();
        setenabledfsync.configure(6);
        setenabledfsync.Cardinal(a.length);
        setenabledfsync.getInstance.write(a);
    }

    public String toString() {
        return this.init;
    }
}
