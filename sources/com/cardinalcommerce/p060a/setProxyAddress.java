package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setProxyAddress */
public final class setProxyAddress extends setLocationDataConsentGiven {
    public final byte[] Cardinal;

    public setProxyAddress(long j) {
        this.Cardinal = BigInteger.valueOf(j).toByteArray();
    }

    public setProxyAddress(BigInteger bigInteger) {
        this.Cardinal = bigInteger.toByteArray();
    }

    public setProxyAddress(byte[] bArr) {
        this(bArr, true);
    }

    setProxyAddress(byte[] bArr, boolean z) {
        if (setMinimumHeight.Cardinal("com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.allow_unsafe_integer") || !m2078a(bArr)) {
            this.Cardinal = z ? setForegroundTintBlendMode.cca_continue(bArr) : bArr;
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }

    public static setProxyAddress Cardinal(Object obj) {
        if (obj == null || (obj instanceof setProxyAddress)) {
            return (setProxyAddress) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (setProxyAddress) getInstance((byte[]) obj);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("encoding error in getInstance: ");
                sb.append(e.toString());
                throw new IllegalArgumentException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder("illegal object in getInstance: ");
            sb2.append(obj.getClass().getName());
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* renamed from: a */
    static boolean m2078a(byte[] bArr) {
        if (bArr.length > 1) {
            if (bArr[0] == 0 && (bArr[1] & 128) == 0) {
                return true;
            }
            return bArr[0] == -1 && (bArr[1] & 128) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven) {
        if (!(setlocationdataconsentgiven instanceof setProxyAddress)) {
            return false;
        }
        return setForegroundTintBlendMode.Cardinal(this.Cardinal, ((setProxyAddress) setlocationdataconsentgiven).Cardinal);
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.Cardinal.length) + 1 + this.Cardinal.length;
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.Cardinal;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] bArr = this.Cardinal;
        setenabledfsync.configure(2);
        setenabledfsync.Cardinal(bArr.length);
        setenabledfsync.getInstance.write(bArr);
    }

    public final String toString() {
        return new BigInteger(this.Cardinal).toString();
    }
}
