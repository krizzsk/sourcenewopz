package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.cardinalcommerce.a.CipherSpi */
public class CipherSpi implements KeyAgreementSpi.ECKAEGwithSHA512KDF {
    public BigInteger Cardinal;
    public BigInteger cca_continue;
    public BigInteger configure;
    public BigInteger getInstance;
    public int getSDKVersion;
    public NoPadding getWarnings;
    public int init;

    /* renamed from: com.cardinalcommerce.a.CipherSpi$NoPadding */
    public final class NoPadding {
        public int configure;
        private byte[] init;

        public NoPadding(byte[] bArr, int i) {
            this.init = setForegroundTintBlendMode.cca_continue(bArr);
            this.configure = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof NoPadding)) {
                return false;
            }
            NoPadding noPadding = (NoPadding) obj;
            if (noPadding.configure != this.configure) {
                return false;
            }
            return setForegroundTintBlendMode.Cardinal(this.init, noPadding.init);
        }

        public final byte[] getInstance() {
            return setForegroundTintBlendMode.cca_continue(this.init);
        }

        public final int hashCode() {
            return this.configure ^ setForegroundTintBlendMode.init(this.init);
        }
    }

    /* renamed from: com.cardinalcommerce.a.CipherSpi$OAEPPadding */
    public final class OAEPPadding {
        public int Cardinal;
        private byte[] cca_continue;

        public OAEPPadding(byte[] bArr, int i) {
            this(bArr, i, (byte) 0);
        }

        public OAEPPadding(byte[] bArr, int i, byte b) {
            this.cca_continue = setForegroundTintBlendMode.cca_continue(bArr);
            this.Cardinal = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof OAEPPadding)) {
                return false;
            }
            OAEPPadding oAEPPadding = (OAEPPadding) obj;
            if (oAEPPadding.Cardinal != this.Cardinal) {
                return false;
            }
            return setForegroundTintBlendMode.Cardinal(this.cca_continue, oAEPPadding.cca_continue);
        }

        public final int hashCode() {
            return this.Cardinal ^ setForegroundTintBlendMode.init(this.cca_continue);
        }

        public final byte[] init() {
            return setForegroundTintBlendMode.cca_continue(this.cca_continue);
        }
    }

    /* renamed from: com.cardinalcommerce.a.CipherSpi$PKCS1v1_5Padding_PrivateOnly */
    public final class PKCS1v1_5Padding_PrivateOnly extends GOST3410Util {
        public PKCS1v1_5Padding_PrivateOnly(SecureRandom secureRandom) {
            super(secureRandom, 256);
        }
    }

    public CipherSpi(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public CipherSpi(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, NoPadding noPadding) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i <= bigInteger.bitLength()) {
            this.configure = bigInteger2;
            this.Cardinal = bigInteger;
            this.getInstance = bigInteger3;
            this.init = i;
            this.getSDKVersion = i2;
            this.cca_continue = bigInteger4;
            this.getWarnings = noPadding;
            return;
        }
        throw new IllegalArgumentException("unsafe p value so small specific l required");
    }

    public CipherSpi(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, NoPadding noPadding) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, noPadding);
    }

    /* renamed from: com.cardinalcommerce.a.CipherSpi$ISO9796d1Padding */
    public final class ISO9796d1Padding extends PKCS1v1_5Padding_PublicOnly {
        public final ASN1ObjectIdentifier cleanup;
        public final ASN1ObjectIdentifier configure;
        public final ASN1ObjectIdentifier getWarnings;

        public ISO9796d1Padding(BCRSAPublicKey bCRSAPublicKey, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, ASN1ObjectIdentifier aSN1ObjectIdentifier3) {
            super(aSN1ObjectIdentifier, bCRSAPublicKey.Cardinal, bCRSAPublicKey.init, bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance, bCRSAPublicKey.init());
            if (aSN1ObjectIdentifier.equals(((PKCS1v1_5Padding_PublicOnly) bCRSAPublicKey).getSDKVersion)) {
                this.configure = aSN1ObjectIdentifier;
                this.getWarnings = aSN1ObjectIdentifier2;
                this.cleanup = aSN1ObjectIdentifier3;
                return;
            }
            throw new IllegalArgumentException("named parameters do not match publicKeyParamSet value");
        }
    }

    /* renamed from: com.cardinalcommerce.a.CipherSpi$PKCS1v1_5Padding */
    public final class PKCS1v1_5Padding extends BCElGamalPrivateKey {
        private static final BigInteger getInstance = BigInteger.valueOf(1);
        private static final BigInteger init = BigInteger.valueOf(2);
        public BigInteger Cardinal;

        public final int hashCode() {
            return this.Cardinal.hashCode() ^ super.hashCode();
        }

        public PKCS1v1_5Padding(BigInteger bigInteger, CipherSpi cipherSpi) {
            super(false, cipherSpi);
            if (bigInteger == null) {
                throw new NullPointerException("y value cannot be null");
            } else if (bigInteger.compareTo(init) < 0 || bigInteger.compareTo(cipherSpi.Cardinal.subtract(init)) > 0) {
                throw new IllegalArgumentException("invalid DH public key");
            } else if (cipherSpi.getInstance == null || getInstance.equals(bigInteger.modPow(cipherSpi.getInstance, cipherSpi.Cardinal))) {
                this.Cardinal = bigInteger;
            } else {
                throw new IllegalArgumentException("Y value does not appear to be in correct group");
            }
        }

        public final boolean equals(Object obj) {
            return (obj instanceof PKCS1v1_5Padding) && ((PKCS1v1_5Padding) obj).Cardinal.equals(this.Cardinal) && super.equals(obj);
        }
    }

    /* renamed from: com.cardinalcommerce.a.CipherSpi$PKCS1v1_5Padding_PublicOnly */
    public class PKCS1v1_5Padding_PublicOnly extends BCRSAPublicKey {
        public ASN1ObjectIdentifier getSDKVersion;

        public PKCS1v1_5Padding_PublicOnly(ASN1ObjectIdentifier aSN1ObjectIdentifier, getSDKAppID getsdkappid, ChallengeParameters challengeParameters, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
            super(getsdkappid, challengeParameters, bigInteger, bigInteger2, bArr);
            this.getSDKVersion = aSN1ObjectIdentifier;
        }

        public PKCS1v1_5Padding_PublicOnly(ASN1ObjectIdentifier aSN1ObjectIdentifier, BCRSAPublicKey bCRSAPublicKey) {
            super(bCRSAPublicKey.Cardinal, bCRSAPublicKey.init, bCRSAPublicKey.cca_continue, bCRSAPublicKey.getInstance, bCRSAPublicKey.init());
            this.getSDKVersion = aSN1ObjectIdentifier;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CipherSpi(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this(bigInteger, bigInteger2, (BigInteger) null, (i == 0 || i >= 160) ? 160 : i, i, (BigInteger) null, (NoPadding) null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CipherSpi)) {
            return false;
        }
        CipherSpi cipherSpi = (CipherSpi) obj;
        BigInteger bigInteger = this.getInstance;
        if (bigInteger != null) {
            if (!bigInteger.equals(cipherSpi.getInstance)) {
                return false;
            }
        } else if (cipherSpi.getInstance != null) {
            return false;
        }
        if (!cipherSpi.Cardinal.equals(this.Cardinal) || !cipherSpi.configure.equals(this.configure)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.Cardinal.hashCode() ^ this.configure.hashCode();
        BigInteger bigInteger = this.getInstance;
        return hashCode ^ (bigInteger != null ? bigInteger.hashCode() : 0);
    }
}
