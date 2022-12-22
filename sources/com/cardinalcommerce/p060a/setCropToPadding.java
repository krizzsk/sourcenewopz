package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setCropToPadding */
public abstract class setCropToPadding extends setImageTintMode {
    public static final Set<JWSAlgorithm> configure;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWSAlgorithm.getWarnings);
        linkedHashSet.add(JWSAlgorithm.CardinalError);
        linkedHashSet.add(JWSAlgorithm.values);
        linkedHashSet.add(JWSAlgorithm.cleanup);
        configure = Collections.unmodifiableSet(linkedHashSet);
    }

    public setCropToPadding(JWSAlgorithm jWSAlgorithm) throws JOSEException {
        super(new HashSet(Collections.singletonList(jWSAlgorithm)));
        if (!configure.contains(jWSAlgorithm)) {
            throw new JOSEException("Unsupported EC DSA algorithm: ".concat(String.valueOf(jWSAlgorithm)));
        }
    }
}
