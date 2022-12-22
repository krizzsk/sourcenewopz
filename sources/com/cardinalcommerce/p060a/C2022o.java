package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.o */
abstract class C2022o implements setButtonTintMode {

    /* renamed from: a */
    private final Set<JWEAlgorithm> f2618a;

    /* renamed from: b */
    private final Set<EncryptionMethod> f2619b;

    /* renamed from: c */
    private final setMeasureWithLargestChildEnabled f2620c = new setMeasureWithLargestChildEnabled();

    public C2022o(Set<JWEAlgorithm> set, Set<EncryptionMethod> set2) {
        if (set != null) {
            this.f2618a = Collections.unmodifiableSet(set);
            if (set2 != null) {
                this.f2619b = set2;
                return;
            }
            throw new IllegalArgumentException("The supported encryption methods must not be null");
        }
        throw new IllegalArgumentException("The supported JWE algorithm set must not be null");
    }

    public Set<JWEAlgorithm> configure() {
        return this.f2618a;
    }

    public Set<EncryptionMethod> getInstance() {
        return this.f2619b;
    }

    /* renamed from: cca_continue */
    public setMeasureWithLargestChildEnabled Cardinal() {
        return this.f2620c;
    }
}
