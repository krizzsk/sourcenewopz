package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import java.util.Map;

/* renamed from: com.cardinalcommerce.a.McElieceKeyFactorySpi */
public interface McElieceKeyFactorySpi {
    void cca_continue(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2);

    boolean cca_continue(String str, String str2);

    void init(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter);

    void init(String str, String str2);

    void init(String str, Map<String, String> map);
}
