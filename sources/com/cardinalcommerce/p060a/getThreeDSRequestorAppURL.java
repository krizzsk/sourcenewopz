package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.X509;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.getThreeDSRequestorAppURL */
public abstract class getThreeDSRequestorAppURL implements getProxyAddress {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof getProxyAddress)) {
            return false;
        }
        return values().equals(((getProxyAddress) obj).values());
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new setEnableDFSync(byteArrayOutputStream).init(this);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return values().hashCode();
    }

    public abstract setLocationDataConsentGiven values();

    public final byte[] init(String str) throws IOException {
        if (str.equals(ASN1Encoding.DER)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            values().getSDKVersion().cca_continue(new ElGamal(byteArrayOutputStream));
            return byteArrayOutputStream.toByteArray();
        } else if (!str.equals(ASN1Encoding.f5639DL)) {
            return getEncoded();
        } else {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            values().getWarnings().cca_continue(new X509.Mappings(byteArrayOutputStream2));
            return byteArrayOutputStream2.toByteArray();
        }
    }
}
