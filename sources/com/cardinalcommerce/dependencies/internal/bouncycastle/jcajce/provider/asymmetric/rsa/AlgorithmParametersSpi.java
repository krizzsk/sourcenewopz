package com.cardinalcommerce.dependencies.internal.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.cardinalcommerce.p060a.BCDSAPrivateKey;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.EdEC;
import com.cardinalcommerce.p060a.JWSAlgorithm;
import com.cardinalcommerce.p060a.KeyFactorySpi;
import com.cardinalcommerce.p060a.KeyPairGeneratorSpi;
import com.cardinalcommerce.p060a.XMSSMTKeyFactorySpi;
import com.cardinalcommerce.p060a.getProxyAddress;
import com.cardinalcommerce.p060a.isEnableDFSync;
import com.cardinalcommerce.p060a.setProxyAddress;
import com.cardinalcommerce.p060a.setThreeDSRequestorAppURL;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.bouncycastle.asn1.ASN1Encoding;

public abstract class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    protected static boolean cca_continue(String str) {
        return str == null || str.equals("ASN.1");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls != null) {
            return getInstance(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    /* access modifiers changed from: protected */
    public abstract AlgorithmParameterSpec getInstance(Class cls) throws InvalidParameterSpecException;

    public static class OAEP extends AlgorithmParametersSpi {
        private OAEPParameterSpec configure;

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            try {
                return new KeyPairGeneratorSpi(new DSASigner.stdDSA(XMSSMTKeyFactorySpi.configure(this.configure.getDigestAlgorithm()), ECGOST.Mappings.Cardinal), new DSASigner.stdDSA(KeyFactorySpi.CardinalError, new DSASigner.stdDSA(XMSSMTKeyFactorySpi.configure(((MGF1ParameterSpec) this.configure.getMGFParameters()).getDigestAlgorithm()), ECGOST.Mappings.Cardinal)), new DSASigner.stdDSA(KeyFactorySpi.values, new EdEC(((PSource.PSpecified) this.configure.getPSource()).getValue()))).init(ASN1Encoding.DER);
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding OAEPParameters");
            }
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) {
            if (cca_continue(str) || str.equalsIgnoreCase("X.509")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof OAEPParameterSpec) {
                this.configure = (OAEPParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format ".concat(String.valueOf(str)));
        }

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "OAEP Parameters";
        }

        /* access modifiers changed from: protected */
        public final AlgorithmParameterSpec getInstance(Class cls) throws InvalidParameterSpecException {
            if (cls == OAEPParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return this.configure;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                KeyPairGeneratorSpi instance = KeyPairGeneratorSpi.getInstance(bArr);
                if (instance.Cardinal.init.equals(KeyFactorySpi.CardinalError)) {
                    String Cardinal = JWSAlgorithm.Cardinal(instance.getInstance.init);
                    String mGFAlgorithm = OAEPParameterSpec.DEFAULT.getMGFAlgorithm();
                    getProxyAddress getproxyaddress = instance.Cardinal.cca_continue;
                    this.configure = new OAEPParameterSpec(Cardinal, mGFAlgorithm, new MGF1ParameterSpec(JWSAlgorithm.Cardinal((getproxyaddress instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) getproxyaddress : getproxyaddress != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).init)), new PSource.PSpecified(isEnableDFSync.init(instance.configure.cca_continue).cca_continue()));
                    return;
                }
                StringBuilder sb = new StringBuilder("unknown mask generation function: ");
                sb.append(instance.Cardinal.init);
                throw new IOException(sb.toString());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
        }
    }

    public static class PSS extends AlgorithmParametersSpi {
        private PSSParameterSpec cca_continue;

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() throws IOException {
            PSSParameterSpec pSSParameterSpec = this.cca_continue;
            return new BCDSAPrivateKey(new DSASigner.stdDSA(XMSSMTKeyFactorySpi.configure(pSSParameterSpec.getDigestAlgorithm()), ECGOST.Mappings.Cardinal), new DSASigner.stdDSA(KeyFactorySpi.CardinalError, new DSASigner.stdDSA(XMSSMTKeyFactorySpi.configure(((MGF1ParameterSpec) pSSParameterSpec.getMGFParameters()).getDigestAlgorithm()), ECGOST.Mappings.Cardinal)), new setProxyAddress((long) pSSParameterSpec.getSaltLength()), new setProxyAddress((long) pSSParameterSpec.getTrailerField())).init(ASN1Encoding.DER);
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PSSParameterSpec) {
                this.cca_continue = (PSSParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (cca_continue(str) || str.equalsIgnoreCase("X.509")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format ".concat(String.valueOf(str)));
        }

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "PSS Parameters";
        }

        /* access modifiers changed from: protected */
        public final AlgorithmParameterSpec getInstance(Class cls) throws InvalidParameterSpecException {
            if (cls == PSSParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return this.cca_continue;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            try {
                BCDSAPrivateKey Cardinal = BCDSAPrivateKey.Cardinal(bArr);
                if (Cardinal.cca_continue.init.equals(KeyFactorySpi.CardinalError)) {
                    String Cardinal2 = JWSAlgorithm.Cardinal(Cardinal.init.init);
                    String mGFAlgorithm = PSSParameterSpec.DEFAULT.getMGFAlgorithm();
                    getProxyAddress getproxyaddress = Cardinal.cca_continue.cca_continue;
                    this.cca_continue = new PSSParameterSpec(Cardinal2, mGFAlgorithm, new MGF1ParameterSpec(JWSAlgorithm.Cardinal((getproxyaddress instanceof DSASigner.stdDSA ? (DSASigner.stdDSA) getproxyaddress : getproxyaddress != null ? new DSASigner.stdDSA(setThreeDSRequestorAppURL.cca_continue((Object) getproxyaddress)) : null).init)), new BigInteger(Cardinal.getInstance.Cardinal).intValue(), new BigInteger(Cardinal.configure.Cardinal).intValue());
                    return;
                }
                StringBuilder sb = new StringBuilder("unknown mask generation function: ");
                sb.append(Cardinal.cca_continue.init);
                throw new IOException(sb.toString());
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
        }
    }
}
