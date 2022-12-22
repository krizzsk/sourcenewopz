package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.getProcessorTransactionId */
public final class getProcessorTransactionId implements getActionCode {

    /* renamed from: a */
    private final int f2570a;

    /* renamed from: b */
    private final DSASigner.dsaSha3_384 f2571b;

    public getProcessorTransactionId(int i, DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2570a = i;
        this.f2571b = dsasha3_384;
    }

    public final setLocationDataConsentGiven getInstance() throws IOException {
        return new getJSON(this.f2570a, this.f2571b.configure());
    }

    public final setLocationDataConsentGiven values() {
        try {
            return getInstance();
        } catch (IOException e) {
            throw new setUICustomization(e.getMessage(), e);
        }
    }
}
