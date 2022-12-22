package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.onSetupCompleted */
public final class onSetupCompleted implements isLocationDataConsentGiven {

    /* renamed from: a */
    private DSASigner.dsaSha3_384 f2622a;

    public onSetupCompleted(DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2622a = dsasha3_384;
    }

    public final setLocationDataConsentGiven getInstance() throws IOException {
        return new CardinalValidateReceiver(this.f2622a.configure());
    }

    public final setLocationDataConsentGiven values() {
        try {
            return getInstance();
        } catch (IOException e) {
            throw new setUICustomization(e.getMessage(), e);
        }
    }
}
