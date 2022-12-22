package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.spec.ECParameterSpec;

/* renamed from: com.cardinalcommerce.a.GOST3410Util */
public class GOST3410Util {
    public SecureRandom getInstance;
    public int values;

    GOST3410Util() {
    }

    public static KeyAgreementSpi.C1970DH configure(String str) {
        try {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                return ECUtil.init(new ASN1ObjectIdentifier(str));
            }
            if (str.indexOf(32) > 0) {
                str = str.substring(str.indexOf(32) + 1);
            }
            return ECUtil.init(str);
        } catch (IllegalArgumentException unused) {
            return ECUtil.init(str);
        }
    }

    public static KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo configure(ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof Base64URL) {
            Base64URL base64URL = (Base64URL) eCParameterSpec;
            ASN1ObjectIdentifier cca_continue = ECUtil.cca_continue(base64URL.getInstance);
            if (cca_continue == null) {
                cca_continue = new ASN1ObjectIdentifier(base64URL.getInstance);
            }
            return new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(cca_continue);
        } else if (eCParameterSpec == null) {
            return new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo((setUiType) ECGOST.Mappings.Cardinal);
        } else {
            getSDKAppID Cardinal = EC5Util.Cardinal(eCParameterSpec.getCurve());
            return new KeyAgreementSpi.CDHwithSHA512KDFAndSharedInfo(new KeyAgreementSpi.C1970DH(Cardinal, EC5Util.init(Cardinal, eCParameterSpec.getGenerator()), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed()));
        }
    }

    public GOST3410Util(SecureRandom secureRandom, int i) {
        this.getInstance = secureRandom;
        this.values = i;
    }
}
