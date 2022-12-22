package com.cardinalcommerce.p060a;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.PrivateKeyInfo */
public class PrivateKeyInfo extends getString {
    public PrivateKeyInfo(getProxyAddress getproxyaddress) throws IOException {
        super(getproxyaddress.values().init(ASN1Encoding.DER), 0);
    }

    public PrivateKeyInfo(byte[] bArr) {
        this(bArr, 0);
    }

    public PrivateKeyInfo(byte[] bArr, int i) {
        super(bArr, i);
    }

    public static PrivateKeyInfo Cardinal(Object obj) {
        if (obj == null || (obj instanceof PrivateKeyInfo)) {
            return (PrivateKeyInfo) obj;
        }
        if (obj instanceof AlgorithmParametersSpi) {
            AlgorithmParametersSpi algorithmParametersSpi = (AlgorithmParametersSpi) obj;
            return new PrivateKeyInfo(algorithmParametersSpi.cca_continue, algorithmParametersSpi.configure);
        } else if (obj instanceof byte[]) {
            try {
                return (PrivateKeyInfo) getInstance((byte[]) obj);
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

    /* access modifiers changed from: package-private */
    public final boolean Cardinal() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int configure() {
        return KeyAgreementSpi.Cardinal(this.cca_continue.length + 1) + 1 + this.cca_continue.length + 1;
    }

    public static PrivateKeyInfo getInstance(getType gettype) {
        setLocationDataConsentGiven values = gettype.getInstance != null ? gettype.getInstance.values() : null;
        if (values instanceof PrivateKeyInfo) {
            return Cardinal(values);
        }
        byte[] cca_continue = ((isEnableDFSync) values).cca_continue();
        if (cca_continue.length > 0) {
            byte b = cca_continue[0];
            int length = cca_continue.length - 1;
            byte[] bArr = new byte[length];
            if (length != 0) {
                System.arraycopy(cca_continue, 1, bArr, 0, cca_continue.length - 1);
            }
            return new PrivateKeyInfo(bArr, b);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    /* access modifiers changed from: package-private */
    public final void cca_continue(setEnableDFSync setenabledfsync) throws IOException {
        byte[] Cardinal = Cardinal(this.cca_continue, this.configure);
        int length = Cardinal.length + 1;
        byte[] bArr = new byte[length];
        bArr[0] = (byte) cleanup();
        System.arraycopy(Cardinal, 0, bArr, 1, length - 1);
        setenabledfsync.configure(3);
        setenabledfsync.Cardinal(length);
        setenabledfsync.getInstance.write(bArr);
    }
}
