package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util;

import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import java.util.HashSet;
import java.util.Set;

public class DESUtil {

    /* renamed from: a */
    private static final Set<String> f3217a;

    static {
        HashSet hashSet = new HashSet();
        f3217a = hashSet;
        hashSet.add("DES");
        f3217a.add("DESEDE");
        f3217a.add(KeyAgreementSpi.MQVwithSHA512KDF.configure.init);
        f3217a.add(KeyFactorySpi.getString.init);
        f3217a.add(KeyFactorySpi.getString.init);
        f3217a.add(KeyFactorySpi.getProcessorTransactionId.init);
    }
}
