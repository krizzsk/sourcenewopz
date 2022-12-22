package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setImageTintMode */
public abstract class setImageTintMode implements setAdjustViewBounds {

    /* renamed from: a */
    private final Set<JWSAlgorithm> f2823a;

    /* renamed from: b */
    private final setColorFilter f2824b = new setColorFilter();

    public setImageTintMode(Set<JWSAlgorithm> set) {
        if (set != null) {
            this.f2823a = Collections.unmodifiableSet(set);
            return;
        }
        throw new IllegalArgumentException("The supported JWS algorithm set must not be null");
    }

    public final Set<JWSAlgorithm> getInstance() {
        return this.f2823a;
    }

    public final setColorFilter Cardinal() {
        return this.f2824b;
    }
}
