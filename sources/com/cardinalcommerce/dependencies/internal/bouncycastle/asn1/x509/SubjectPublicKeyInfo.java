package com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509;

import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.GOST;
import com.cardinalcommerce.p060a.PrivateKeyInfo;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.getThreeDSRequestorAppURL;
import com.cardinalcommerce.p060a.setForegroundTintBlendMode;
import com.cardinalcommerce.p060a.setLocationDataConsentGiven;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.util.Enumeration;

public class SubjectPublicKeyInfo extends getThreeDSRequestorAppURL {
    public PrivateKeyInfo getInstance;
    public DSASigner.stdDSA init;

    public SubjectPublicKeyInfo(DSASigner.stdDSA stddsa, getProxyAddress getproxyaddress) throws IOException {
        this.getInstance = new PrivateKeyInfo(getproxyaddress);
        this.init = stddsa;
    }

    public SubjectPublicKeyInfo(DSASigner.stdDSA stddsa, byte[] bArr) {
        this.getInstance = new PrivateKeyInfo(bArr);
        this.init = stddsa;
    }

    public static SubjectPublicKeyInfo init(Object obj) {
        if (obj instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo) obj;
        }
        if (obj != null) {
            return new SubjectPublicKeyInfo(setThreeDSRequestorAppURL.cca_continue(obj));
        }
        return null;
    }

    private SubjectPublicKeyInfo(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        if (setthreedsrequestorappurl.getInstance() == 2) {
            Enumeration cca_continue = setthreedsrequestorappurl.cca_continue();
            Object nextElement = cca_continue.nextElement();
            this.init = nextElement instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) nextElement : nextElement != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue(nextElement)) : null;
            this.getInstance = PrivateKeyInfo.Cardinal(cca_continue.nextElement());
            return;
        }
        StringBuilder sb = new StringBuilder("Bad sequence size: ");
        sb.append(setthreedsrequestorappurl.getInstance());
        throw new IllegalArgumentException(sb.toString());
    }

    public final setLocationDataConsentGiven values() {
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        setforegroundtintblendmode.cca_continue.addElement(this.init);
        setforegroundtintblendmode.cca_continue.addElement(this.getInstance);
        return new GOST(setforegroundtintblendmode);
    }
}
