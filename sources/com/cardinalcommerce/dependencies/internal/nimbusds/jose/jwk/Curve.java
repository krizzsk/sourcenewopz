package com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm;
import com.cardinalcommerce.p060a.setDividerDrawable;
import java.io.Serializable;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

public final class Curve implements Serializable {
    public static final Curve Cardinal = new Curve("secp256k1", (byte) 0);
    public static final Curve CardinalError = new Curve(EdDSAParameterSpec.Ed448, (byte) 0);
    public static final Curve cca_continue = new Curve("P-521", (byte) 0);
    public static final Curve cleanup = new Curve(XDHParameterSpec.X448, (byte) 0);
    public static final Curve configure = new Curve(EdDSAParameterSpec.Ed25519, (byte) 0);
    public static final Curve getInstance = new Curve("P-256", (byte) 0);
    public static final Curve getSDKVersion = new Curve(XDHParameterSpec.X25519, (byte) 0);
    public static final Curve init = new Curve("P-384", (byte) 0);
    @Deprecated
    private static Curve values = new Curve("P-256K", (byte) 0);
    private final String getWarnings;

    private Curve(String str) {
        this(str, (byte) 0);
    }

    private Curve(String str, byte b) {
        if (str != null) {
            this.getWarnings = str;
            return;
        }
        throw new IllegalArgumentException("The JOSE cryptographic curve name must not be null");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Curve) && toString().equals(obj.toString());
    }

    public static Curve cca_continue(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The cryptographic curve string must not be null or empty");
        } else if (str.equals(getInstance.getWarnings)) {
            return getInstance;
        } else {
            if (str.equals(values.getWarnings)) {
                return values;
            }
            if (str.equals(Cardinal.getWarnings)) {
                return Cardinal;
            }
            if (str.equals(init.getWarnings)) {
                return init;
            }
            if (str.equals(cca_continue.getWarnings)) {
                return cca_continue;
            }
            if (str.equals(configure.getWarnings)) {
                return configure;
            }
            if (str.equals(CardinalError.getWarnings)) {
                return CardinalError;
            }
            if (str.equals(getSDKVersion.getWarnings)) {
                return getSDKVersion;
            }
            if (str.equals(cleanup.getWarnings)) {
                return cleanup;
            }
            return new Curve(str);
        }
    }

    public static Set<Curve> Cardinal(JWSAlgorithm jWSAlgorithm) {
        if (JWSAlgorithm.getWarnings.equals(jWSAlgorithm)) {
            return Collections.singleton(getInstance);
        }
        if (JWSAlgorithm.CardinalError.equals(jWSAlgorithm)) {
            return Collections.singleton(Cardinal);
        }
        if (JWSAlgorithm.values.equals(jWSAlgorithm)) {
            return Collections.singleton(init);
        }
        if (JWSAlgorithm.cleanup.equals(jWSAlgorithm)) {
            return Collections.singleton(cca_continue);
        }
        if (!JWSAlgorithm.CardinalEnvironment.equals(jWSAlgorithm)) {
            return null;
        }
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(new Curve[]{configure, CardinalError})));
    }

    public static Curve Cardinal(ECParameterSpec eCParameterSpec) {
        return setDividerDrawable.getInstance(eCParameterSpec);
    }

    public final String toString() {
        return this.getWarnings;
    }
}
