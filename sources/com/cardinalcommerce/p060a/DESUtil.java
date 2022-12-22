package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.X931SignatureSpi;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encoding;

/* renamed from: com.cardinalcommerce.a.DESUtil */
public final class DESUtil implements X931SignatureSpi.RIPEMD128WithRSAEncryption {
    public static final DESUtil cca_continue = new DESUtil();

    public final byte[] getInstance(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) throws IOException {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        if (bigInteger2.signum() < 0 || (bigInteger != null && bigInteger2.compareTo(bigInteger) >= 0)) {
            throw new IllegalArgumentException("Value out of range");
        }
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(bigInteger2));
        if (bigInteger3.signum() < 0 || (bigInteger != null && bigInteger3.compareTo(bigInteger) >= 0)) {
            throw new IllegalArgumentException("Value out of range");
        }
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(bigInteger3));
        return new GOST(setforegroundtintblendmode).init(ASN1Encoding.DER);
    }

    public final BigInteger[] configure(BigInteger bigInteger, byte[] bArr) throws IOException {
        setThreeDSRequestorAppURL setthreedsrequestorappurl = (setThreeDSRequestorAppURL) setLocationDataConsentGiven.getInstance(bArr);
        if (setthreedsrequestorappurl.getInstance() == 2) {
            BigInteger bigInteger2 = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(0)).Cardinal);
            if (bigInteger2.signum() < 0 || (bigInteger != null && bigInteger2.compareTo(bigInteger) >= 0)) {
                throw new IllegalArgumentException("Value out of range");
            }
            BigInteger bigInteger3 = new BigInteger(((setProxyAddress) setthreedsrequestorappurl.Cardinal(1)).Cardinal);
            if (bigInteger3.signum() < 0 || (bigInteger != null && bigInteger3.compareTo(bigInteger) >= 0)) {
                throw new IllegalArgumentException("Value out of range");
            } else if (setForegroundTintBlendMode.Cardinal(getInstance(bigInteger, bigInteger2, bigInteger3), bArr)) {
                return new BigInteger[]{bigInteger2, bigInteger3};
            }
        }
        throw new IllegalArgumentException("Malformed signature");
    }
}
