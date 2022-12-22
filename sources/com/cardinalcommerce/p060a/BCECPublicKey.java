package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;

/* renamed from: com.cardinalcommerce.a.BCECPublicKey */
public final class BCECPublicKey extends getThreeDSRequestorAppURL {

    /* renamed from: a */
    private setThreeDSRequestorAppURL f2279a;
    public PrivateKeyInfo cca_continue;
    public GMSignatureSpi configure;
    public DSASigner.stdDSA getInstance;

    public final setLocationDataConsentGiven values() {
        return this.f2279a;
    }

    public BCECPublicKey(setThreeDSRequestorAppURL setthreedsrequestorappurl) {
        this.f2279a = setthreedsrequestorappurl;
        if (setthreedsrequestorappurl.getInstance() == 3) {
            getProxyAddress Cardinal = setthreedsrequestorappurl.Cardinal(0);
            DSASigner.stdDSA stddsa = null;
            this.configure = Cardinal instanceof GMSignatureSpi ? (GMSignatureSpi) Cardinal : Cardinal != null ? new GMSignatureSpi(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal)) : null;
            getProxyAddress Cardinal2 = setthreedsrequestorappurl.Cardinal(1);
            if (Cardinal2 instanceof DSASigner.stdDSA) {
                stddsa = (DSASigner.stdDSA) Cardinal2;
            } else if (Cardinal2 != null) {
                stddsa = new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) Cardinal2));
            }
            this.getInstance = stddsa;
            this.cca_continue = PrivateKeyInfo.Cardinal(setthreedsrequestorappurl.Cardinal(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }
}
