package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.Base64URL;
import com.cardinalcommerce.p060a.Container;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.GOST3410Util;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.getSDKAppID;
import com.cardinalcommerce.p060a.setUiType;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.AlgorithmParametersSpi */
public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {

    /* renamed from: a */
    private ECParameterSpec f3171a;

    /* renamed from: b */
    private String f3172b;

    /* renamed from: a */
    private static boolean m2195a(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr) throws IOException {
        engineInit(bArr, "ASN.1");
    }

    /* access modifiers changed from: protected */
    public String engineToString() {
        return "EC AlgorithmParameters ";
    }

    /* access modifiers changed from: protected */
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) algorithmParameterSpec;
            KeyAgreementSpi.C1970DH configure = GOST3410Util.configure(eCGenParameterSpec.getName());
            if (configure != null) {
                this.f3172b = eCGenParameterSpec.getName();
                ECParameterSpec cca_continue = EC5Util.cca_continue(configure);
                this.f3171a = new Base64URL(this.f3172b, cca_continue.getCurve(), cca_continue.getGenerator(), cca_continue.getOrder(), BigInteger.valueOf((long) cca_continue.getCofactor()));
                return;
            }
            StringBuilder sb = new StringBuilder("EC curve name not recognized: ");
            sb.append(eCGenParameterSpec.getName());
            throw new InvalidParameterSpecException(sb.toString());
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            this.f3172b = algorithmParameterSpec instanceof Base64URL ? ((Base64URL) algorithmParameterSpec).getInstance : null;
            this.f3171a = (ECParameterSpec) algorithmParameterSpec;
        } else {
            StringBuilder sb2 = new StringBuilder("AlgorithmParameterSpec class not recognized: ");
            sb2.append(algorithmParameterSpec.getClass().getName());
            throw new InvalidParameterSpecException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(byte[] bArr, String str) throws IOException {
        if (m2195a(str)) {
            KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo init = KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo.init(bArr);
            getSDKAppID instance = EC5Util.getInstance(JWK.getInstance, init);
            if (init.Cardinal()) {
                ASN1ObjectIdentifier instance2 = ASN1ObjectIdentifier.getInstance(init.configure);
                String cca_continue = IESCipher.ECIESwithCipher.cca_continue(instance2);
                this.f3172b = cca_continue;
                if (cca_continue == null) {
                    this.f3172b = instance2.init;
                }
            }
            this.f3171a = EC5Util.init(init, instance);
            return;
        }
        throw new IOException("Unknown encoded parameters format in AlgorithmParameters object: ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: protected */
    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (ECParameterSpec.class.isAssignableFrom(cls) || cls == AlgorithmParameterSpec.class) {
            return this.f3171a;
        }
        if (ECGenParameterSpec.class.isAssignableFrom(cls)) {
            String str = this.f3172b;
            if (str != null) {
                ASN1ObjectIdentifier cca_continue = ECUtil.cca_continue(str);
                return cca_continue != null ? new ECGenParameterSpec(cca_continue.init) : new ECGenParameterSpec(this.f3172b);
            }
            ASN1ObjectIdentifier init = ECUtil.init(EC5Util.cca_continue(this.f3171a));
            if (init != null) {
                return new ECGenParameterSpec(init.init);
            }
        }
        StringBuilder sb = new StringBuilder("EC AlgorithmParameters cannot convert to ");
        sb.append(cls.getName());
        throw new InvalidParameterSpecException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetEncoded(String str) throws IOException {
        KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo cDHwithSHA512KDFAndSharedInfo;
        if (m2195a(str)) {
            ECParameterSpec eCParameterSpec = this.f3171a;
            if (eCParameterSpec == null) {
                cDHwithSHA512KDFAndSharedInfo = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo((setUiType) ECGOST.Mappings.Cardinal);
            } else {
                String str2 = this.f3172b;
                if (str2 != null) {
                    cDHwithSHA512KDFAndSharedInfo = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(ECUtil.cca_continue(str2));
                } else {
                    Container cca_continue = EC5Util.cca_continue(eCParameterSpec);
                    cDHwithSHA512KDFAndSharedInfo = new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(new KeyAgreementSpi.C1970DH(cca_continue.init, cca_continue.Cardinal, cca_continue.getInstance, cca_continue.cca_continue, cca_continue.getInstance()));
                }
            }
            return cDHwithSHA512KDFAndSharedInfo.getEncoded();
        }
        throw new IOException("Unknown parameters format in AlgorithmParameters object: ".concat(String.valueOf(str)));
    }
}
