package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import java.util.Enumeration;

/* renamed from: com.cardinalcommerce.a.BCDSAPublicKey */
public final class BCDSAPublicKey extends getThreeDSRequestorAppURL {
    public BigInteger cca_continue;
    public BigInteger getInstance;

    public BCDSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.getInstance = bigInteger;
        this.cca_continue = bigInteger2;
    }

    public BCDSAPublicKey(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        if (setthreedsrequestorappurl.getInstance() == 2) {
            Enumeration cca_continue2 = setthreedsrequestorappurl.cca_continue();
            this.getInstance = new BigInteger(1, setProxyAddress.Cardinal(cca_continue2.nextElement()).Cardinal);
            this.cca_continue = new BigInteger(1, setProxyAddress.Cardinal(cca_continue2.nextElement()).Cardinal);
            return;
        }
        StringBuilder sb = new StringBuilder("Bad sequence size: ");
        sb.append(setthreedsrequestorappurl.getInstance());
        throw new IllegalArgumentException(sb.toString());
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.getInstance));
        setforegroundtintblendmode.cca_continue.addElement(new setProxyAddress(this.cca_continue));
        return new GOST(setforegroundtintblendmode);
    }
}
