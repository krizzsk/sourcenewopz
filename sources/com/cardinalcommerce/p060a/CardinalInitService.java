package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.CardinalInitService */
public final class CardinalInitService implements getActionCode {

    /* renamed from: a */
    private boolean f2341a;

    /* renamed from: b */
    private int f2342b;

    /* renamed from: c */
    private DSASigner.dsaSha3_384 f2343c;

    public CardinalInitService(boolean z, int i, DSASigner.dsaSha3_384 dsasha3_384) {
        this.f2341a = z;
        this.f2342b = i;
        this.f2343c = dsasha3_384;
    }

    public final setLocationDataConsentGiven getInstance() throws IOException {
        return this.f2343c.init(this.f2341a, this.f2342b);
    }

    public final setLocationDataConsentGiven values() {
        try {
            return getInstance();
        } catch (IOException e) {
            throw new setUICustomization(e.getMessage());
        }
    }
}
