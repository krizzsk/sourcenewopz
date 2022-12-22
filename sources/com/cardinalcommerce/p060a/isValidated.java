package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.isValidated */
public final class isValidated implements setEnableLogging {

    /* renamed from: a */
    private DSASigner.dsaSha3_384 f2598a;

    public isValidated(DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2598a = dsasha3_384;
    }

    public final setLocationDataConsentGiven getInstance() throws IOException {
        return new ValidateResponse(this.f2598a.configure());
    }

    public final setLocationDataConsentGiven values() {
        try {
            return getInstance();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
