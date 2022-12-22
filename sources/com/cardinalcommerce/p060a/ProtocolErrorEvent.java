package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* renamed from: com.cardinalcommerce.a.ProtocolErrorEvent */
public final class ProtocolErrorEvent implements DeflateHelper, AlgorithmParameterSpec {
    public String Cardinal;
    public setErrorCode cca_continue;
    public String configure;
    public String init;

    private ProtocolErrorEvent(String str, String str2) {
        this(str, str2, (String) null);
    }

    public final String Cardinal() {
        return this.Cardinal;
    }

    public final setErrorCode cca_continue() {
        return this.cca_continue;
    }

    public final String configure() {
        return this.init;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ProtocolErrorEvent) {
            ProtocolErrorEvent protocolErrorEvent = (ProtocolErrorEvent) obj;
            if (this.cca_continue.equals(protocolErrorEvent.cca_continue) && this.Cardinal.equals(protocolErrorEvent.Cardinal)) {
                String str = this.configure;
                String str2 = protocolErrorEvent.configure;
                if (str != str2) {
                    return str != null && str.equals(str2);
                }
                return true;
            }
        }
    }

    public final String getInstance() {
        return this.configure;
    }

    public final int hashCode() {
        int hashCode = this.cca_continue.hashCode() ^ this.Cardinal.hashCode();
        String str = this.configure;
        return hashCode ^ (str != null ? str.hashCode() : 0);
    }

    public ProtocolErrorEvent(String str, String str2, String str3) {
        KeyAgreementSpi.DHUwithSHA512KDF dHUwithSHA512KDF;
        try {
            dHUwithSHA512KDF = KeyAgreementSpi.DHwithSHA1KDF.configure(new ASN1ObjectIdentifier(str));
        } catch (IllegalArgumentException unused) {
            ASN1ObjectIdentifier Cardinal2 = KeyAgreementSpi.DHwithSHA1KDF.Cardinal(str);
            if (Cardinal2 != null) {
                str = Cardinal2.init;
                dHUwithSHA512KDF = KeyAgreementSpi.DHwithSHA1KDF.configure(Cardinal2);
            } else {
                dHUwithSHA512KDF = null;
            }
        }
        if (dHUwithSHA512KDF != null) {
            this.cca_continue = new setErrorCode(new BigInteger(1, dHUwithSHA512KDF.cca_continue.Cardinal), new BigInteger(1, dHUwithSHA512KDF.getInstance.Cardinal), new BigInteger(1, dHUwithSHA512KDF.configure.Cardinal));
            this.init = str;
            this.Cardinal = str2;
            this.configure = str3;
            return;
        }
        throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
    }

    public ProtocolErrorEvent(String str) {
        this(str, KeyAgreementSpi.DHUwithSHA512CKDF.CardinalError.init, (String) null);
    }

    public ProtocolErrorEvent(setErrorCode seterrorcode) {
        this.cca_continue = seterrorcode;
        this.Cardinal = KeyAgreementSpi.DHUwithSHA512CKDF.CardinalError.init;
        this.configure = null;
    }

    public static ProtocolErrorEvent configure(KeyAgreementSpi.DHwithSHA1CKDF dHwithSHA1CKDF) {
        if (dHwithSHA1CKDF.configure != null) {
            return new ProtocolErrorEvent(dHwithSHA1CKDF.cca_continue.init, dHwithSHA1CKDF.Cardinal.init, dHwithSHA1CKDF.configure.init);
        }
        return new ProtocolErrorEvent(dHwithSHA1CKDF.cca_continue.init, dHwithSHA1CKDF.Cardinal.init);
    }
}
