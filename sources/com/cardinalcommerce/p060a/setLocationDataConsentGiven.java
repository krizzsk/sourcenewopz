package com.cardinalcommerce.p060a;

import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setLocationDataConsentGiven */
public abstract class setLocationDataConsentGiven extends getThreeDSRequestorAppURL {
    public static setLocationDataConsentGiven getInstance(byte[] bArr) throws IOException {
        getUiType getuitype = new getUiType(bArr);
        try {
            setLocationDataConsentGiven cca_continue = getuitype.cca_continue();
            if (getuitype.available() == 0) {
                return cca_continue;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean Cardinal();

    /* access modifiers changed from: protected */
    public abstract boolean Cardinal(setLocationDataConsentGiven setlocationdataconsentgiven);

    /* access modifiers changed from: protected */
    public abstract void cca_continue(setEnableDFSync setenabledfsync) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int configure() throws IOException;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof getProxyAddress) && Cardinal(((getProxyAddress) obj).values());
    }

    /* access modifiers changed from: package-private */
    public setLocationDataConsentGiven getSDKVersion() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public setLocationDataConsentGiven getWarnings() {
        return this;
    }

    public final setLocationDataConsentGiven values() {
        return this;
    }
}
