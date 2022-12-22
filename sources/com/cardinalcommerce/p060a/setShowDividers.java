package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setShowDividers */
public abstract class setShowDividers extends setImageTintMode {
    public static final Set<JWSAlgorithm> configure;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWSAlgorithm.Cardinal);
        linkedHashSet.add(JWSAlgorithm.getInstance);
        linkedHashSet.add(JWSAlgorithm.init);
        linkedHashSet.add(JWSAlgorithm.getSDKVersion);
        linkedHashSet.add(JWSAlgorithm.CardinalRenderType);
        linkedHashSet.add(JWSAlgorithm.CardinalActionCode);
        configure = Collections.unmodifiableSet(linkedHashSet);
    }

    public setShowDividers() {
        super(configure);
    }
}
