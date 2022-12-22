package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.security.spec.DSAParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.cardinalcommerce.a.d */
final class C1993d implements NHKeyFactorySpi {

    /* renamed from: a */
    private ThreadLocal f2523a = new ThreadLocal();

    /* renamed from: b */
    private ThreadLocal f2524b = new ThreadLocal();

    /* renamed from: c */
    private volatile Container f2525c;

    /* renamed from: d */
    private volatile Object f2526d;

    /* renamed from: e */
    private volatile Set f2527e = new HashSet();

    /* renamed from: f */
    private volatile Map f2528f = new HashMap();

    static {
        new McElieceCCA2KeyFactorySpi(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);
        new McElieceCCA2KeyFactorySpi(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.EC_IMPLICITLY_CA);
        new McElieceCCA2KeyFactorySpi(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS);
        new McElieceCCA2KeyFactorySpi(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.DH_DEFAULT_PARAMS);
        new McElieceCCA2KeyFactorySpi(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.ACCEPTABLE_EC_CURVES);
        new McElieceCCA2KeyFactorySpi(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.ADDITIONAL_EC_PARAMETERS);
    }

    C1993d() {
    }

    public final Map Cardinal() {
        return Collections.unmodifiableMap(this.f2528f);
    }

    public final Container cca_continue() {
        Container container = (Container) this.f2523a.get();
        return container != null ? container : this.f2525c;
    }

    public final Set configure() {
        return Collections.unmodifiableSet(this.f2527e);
    }

    public final DHParameterSpec init(int i) {
        Object obj = this.f2524b.get();
        if (obj == null) {
            obj = this.f2526d;
        }
        if (obj instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) obj;
            if (dHParameterSpec.getP().bitLength() == i) {
                return dHParameterSpec;
            }
        } else if (obj instanceof DHParameterSpec[]) {
            DHParameterSpec[] dHParameterSpecArr = (DHParameterSpec[]) obj;
            for (int i2 = 0; i2 != dHParameterSpecArr.length; i2++) {
                if (dHParameterSpecArr[i2].getP().bitLength() == i) {
                    return dHParameterSpecArr[i2];
                }
            }
        }
        CipherSpi cipherSpi = (CipherSpi) KeyAgreementSpi.MQV.init(KeyAgreementSpi.MQV.C1976configure.init, i);
        if (cipherSpi != null) {
            return new Sphincs256KeyFactorySpi(cipherSpi);
        }
        return null;
    }

    public final DSAParameterSpec cca_continue(int i) {
        BCGOST3410PublicKey bCGOST3410PublicKey = (BCGOST3410PublicKey) KeyAgreementSpi.MQV.init(KeyAgreementSpi.MQV.C1976configure.getInstance, i);
        if (bCGOST3410PublicKey != null) {
            return new DSAParameterSpec(bCGOST3410PublicKey.init, bCGOST3410PublicKey.getInstance, bCGOST3410PublicKey.cca_continue);
        }
        return null;
    }
}
