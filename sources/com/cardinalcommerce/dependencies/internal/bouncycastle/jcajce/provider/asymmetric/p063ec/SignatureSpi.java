package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.p063ec;

import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.DSABase;
import com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.cardinalcommerce.p060a.BCECGOST3410PrivateKey;
import com.cardinalcommerce.p060a.DESUtil;
import com.cardinalcommerce.p060a.DHUtil;
import com.cardinalcommerce.p060a.ISOSignatureSpi;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.SignatureSpi;
import com.cardinalcommerce.p060a.X931SignatureSpi;
import com.cardinalcommerce.p060a.setKeyboardNavigationCluster;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi */
public class SignatureSpi extends DSABase {

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSARipeMD160 */
    public static class ecDSARipeMD160 extends SignatureSpi {
        public ecDSARipeMD160() {
            super(new SignatureSpi.ecDetDSASha3_256(), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAnone */
    public static class ecDSAnone extends SignatureSpi {
        public ecDSAnone() {
            super(new SignatureSpi.ecDetDSASha3_224(), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecPlainDSARP160 */
    public static class ecPlainDSARP160 extends SignatureSpi {
        public ecPlainDSARP160() {
            super(new SignatureSpi.ecDetDSASha3_256(), new X931SignatureSpi.SHA384WithRSAEncryption(), DHUtil.cca_continue);
        }
    }

    SignatureSpi(KeyAgreementSpi.MQVwithSHA256KDFAndSharedInfo mQVwithSHA256KDFAndSharedInfo, KeyFactorySpi.C1979EC ec, X931SignatureSpi.RIPEMD128WithRSAEncryption rIPEMD128WithRSAEncryption) {
        super(mQVwithSHA256KDFAndSharedInfo, ec, rIPEMD128WithRSAEncryption);
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        setKeyboardNavigationCluster instance = ECUtil.getInstance(privateKey);
        this.getPayment.cca_continue();
        if (this.appRandom != null) {
            this.getErrorDescription.getInstance(true, new ISOSignatureSpi.SHA224WithRSAEncryption(instance, this.appRandom));
        } else {
            this.getErrorDescription.getInstance(true, instance);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA */
    public static class ecCVCDSA extends SignatureSpi {
        public ecCVCDSA() {
            super(new SignatureSpi.ecNR224(), new X931SignatureSpi.SHA384WithRSAEncryption(), DHUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224 */
    public static class ecCVCDSA224 extends SignatureSpi {
        public ecCVCDSA224() {
            super(new SignatureSpi.ecNR256(), new X931SignatureSpi.SHA384WithRSAEncryption(), DHUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256 */
    public static class ecCVCDSA256 extends SignatureSpi {
        public ecCVCDSA256() {
            super(new SignatureSpi.ecNR(), new X931SignatureSpi.SHA384WithRSAEncryption(), DHUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA384 */
    public static class ecCVCDSA384 extends SignatureSpi {
        public ecCVCDSA384() {
            super(new SignatureSpi.ecNR384(), new X931SignatureSpi.SHA384WithRSAEncryption(), DHUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA512 */
    public static class ecCVCDSA512 extends SignatureSpi {
        public ecCVCDSA512() {
            super(new BCECGOST3410PrivateKey(), new X931SignatureSpi.SHA384WithRSAEncryption(), DHUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA */
    public static class ecDSA extends SignatureSpi {
        public ecDSA() {
            super(new SignatureSpi.ecNR224(), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA224 */
    public static class ecDSA224 extends SignatureSpi {
        public ecDSA224() {
            super(new SignatureSpi.ecNR256(), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA256 */
    public static class ecDSA256 extends SignatureSpi {
        public ecDSA256() {
            super(new SignatureSpi.ecNR(), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA384 */
    public static class ecDSA384 extends SignatureSpi {
        public ecDSA384() {
            super(new SignatureSpi.ecNR384(), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA512 */
    public static class ecDSA512 extends SignatureSpi {
        public ecDSA512() {
            super(new BCECGOST3410PrivateKey(), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_224 */
    public static class ecDSASha3_224 extends SignatureSpi {
        public ecDSASha3_224() {
            super(new KeyAgreementSpi.ECVKO(224), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_256 */
    public static class ecDSASha3_256 extends SignatureSpi {
        public ecDSASha3_256() {
            super(new KeyAgreementSpi.ECVKO(256), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_384 */
    public static class ecDSASha3_384 extends SignatureSpi {
        public ecDSASha3_384() {
            super(new KeyAgreementSpi.ECVKO(384), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSASha3_512 */
    public static class ecDSASha3_512 extends SignatureSpi {
        public ecDSASha3_512() {
            super(new KeyAgreementSpi.ECVKO(512), new X931SignatureSpi.SHA384WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA */
    public static class ecDetDSA extends SignatureSpi {
        public ecDetDSA() {
            super(new SignatureSpi.ecNR224(), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR224())), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA224 */
    public static class ecDetDSA224 extends SignatureSpi {
        public ecDetDSA224() {
            super(new SignatureSpi.ecNR256(), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR256())), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA256 */
    public static class ecDetDSA256 extends SignatureSpi {
        public ecDetDSA256() {
            super(new SignatureSpi.ecNR(), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR())), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA384 */
    public static class ecDetDSA384 extends SignatureSpi {
        public ecDetDSA384() {
            super(new SignatureSpi.ecNR384(), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new SignatureSpi.ecNR384())), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSA512 */
    public static class ecDetDSA512 extends SignatureSpi {
        public ecDetDSA512() {
            super(new BCECGOST3410PrivateKey(), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new BCECGOST3410PrivateKey())), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_224 */
    public static class ecDetDSASha3_224 extends SignatureSpi {
        public ecDetDSASha3_224() {
            super(new KeyAgreementSpi.ECVKO(224), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(224))), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_256 */
    public static class ecDetDSASha3_256 extends SignatureSpi {
        public ecDetDSASha3_256() {
            super(new KeyAgreementSpi.ECVKO(256), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(256))), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_384 */
    public static class ecDetDSASha3_384 extends SignatureSpi {
        public ecDetDSASha3_384() {
            super(new KeyAgreementSpi.ECVKO(384), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(384))), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDetDSASha3_512 */
    public static class ecDetDSASha3_512 extends SignatureSpi {
        public ecDetDSASha3_512() {
            super(new KeyAgreementSpi.ECVKO(512), new X931SignatureSpi.SHA384WithRSAEncryption(new X931SignatureSpi.WhirlpoolWithRSAEncryption(new KeyAgreementSpi.ECVKO(512))), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR */
    public static class ecNR extends SignatureSpi {
        public ecNR() {
            super(new SignatureSpi.ecNR224(), new X931SignatureSpi.SHA224WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR224 */
    public static class ecNR224 extends SignatureSpi {
        public ecNR224() {
            super(new SignatureSpi.ecNR256(), new X931SignatureSpi.SHA224WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR256 */
    public static class ecNR256 extends SignatureSpi {
        public ecNR256() {
            super(new SignatureSpi.ecNR(), new X931SignatureSpi.SHA224WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR384 */
    public static class ecNR384 extends SignatureSpi {
        public ecNR384() {
            super(new SignatureSpi.ecNR384(), new X931SignatureSpi.SHA224WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR512 */
    public static class ecNR512 extends SignatureSpi {
        public ecNR512() {
            super(new BCECGOST3410PrivateKey(), new X931SignatureSpi.SHA224WithRSAEncryption(), DESUtil.cca_continue);
        }
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        KeyAgreementSpi.ECKAEGwithSHA512KDF eCKAEGwithSHA512KDF;
        if (publicKey instanceof BCECPublicKey) {
            eCKAEGwithSHA512KDF = ((BCECPublicKey) publicKey).configure;
        } else {
            eCKAEGwithSHA512KDF = ECUtil.Cardinal(publicKey);
        }
        this.getPayment.cca_continue();
        this.getErrorDescription.getInstance(false, eCKAEGwithSHA512KDF);
    }
}
