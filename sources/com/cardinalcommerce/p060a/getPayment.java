package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cardinalcommerce.a.getPayment */
public final class getPayment implements getUICustomization {

    /* renamed from: a */
    private DSASigner.dsaSha3_384 f2569a;

    public getPayment(DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2569a = dsasha3_384;
    }

    public final InputStream init() {
        return new C1986a(this.f2569a);
    }

    public final setLocationDataConsentGiven values() {
        try {
            return getInstance();
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("IOException converting stream to byte array: ");
            sb.append(e.getMessage());
            throw new setUICustomization(sb.toString(), e);
        }
    }

    public final setLocationDataConsentGiven getInstance() throws IOException {
        return new getErrorNumber(setTooltipText.cca_continue(new C1986a(this.f2569a)));
    }
}
