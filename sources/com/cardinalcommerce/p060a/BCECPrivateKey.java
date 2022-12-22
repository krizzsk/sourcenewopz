package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.BCECPrivateKey */
public final class BCECPrivateKey extends getThreeDSRequestorAppURL {
    public setProxyAddress Cardinal = null;

    /* renamed from: a */
    private setChallengeTimeout f2278a = setChallengeTimeout.cca_continue(false);

    public BCECPrivateKey(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        if (setthreedsrequestorappurl.getInstance() == 0) {
            this.f2278a = null;
            this.Cardinal = null;
            return;
        }
        if (setthreedsrequestorappurl.Cardinal(0) instanceof setChallengeTimeout) {
            this.f2278a = setChallengeTimeout.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0));
        } else {
            this.f2278a = null;
            this.Cardinal = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(0));
        }
        if (setthreedsrequestorappurl.getInstance() <= 1) {
            return;
        }
        if (this.f2278a != null) {
            this.Cardinal = setProxyAddress.Cardinal((Object) setthreedsrequestorappurl.Cardinal(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    public final boolean getInstance() {
        setChallengeTimeout setchallengetimeout = this.f2278a;
        return setchallengetimeout != null && setchallengetimeout.init();
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setChallengeTimeout setchallengetimeout = this.f2278a;
        if (setchallengetimeout != null) {
            setforegroundtintblendmode.cca_continue.addElement(setchallengetimeout);
        }
        setProxyAddress setproxyaddress = this.Cardinal;
        if (setproxyaddress != null) {
            setforegroundtintblendmode.cca_continue.addElement(setproxyaddress);
        }
        return new GOST(setforegroundtintblendmode);
    }

    public final String toString() {
        if (this.Cardinal != null) {
            StringBuilder sb = new StringBuilder("BasicConstraints: isCa(");
            sb.append(getInstance());
            sb.append("), pathLenConstraint = ");
            sb.append(new BigInteger(this.Cardinal.Cardinal));
            return sb.toString();
        } else if (this.f2278a == null) {
            return "BasicConstraints: isCa(false)";
        } else {
            StringBuilder sb2 = new StringBuilder("BasicConstraints: isCa(");
            sb2.append(getInstance());
            sb2.append(")");
            return sb2.toString();
        }
    }
}
