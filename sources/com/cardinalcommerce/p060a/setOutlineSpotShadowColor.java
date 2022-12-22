package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import java.io.IOException;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.setOutlineSpotShadowColor */
public final class setOutlineSpotShadowColor implements KeyAgreementSpi.ECKAEGwithSHA512KDF, PublicKey {
    private setLongClickable configure;

    public setOutlineSpotShadowColor(setLongClickable setlongclickable) {
        this.configure = setlongclickable;
    }

    public final String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public final String getFormat() {
        return "X.509";
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("McEliecePublicKey:\n");
        sb.append(" length of the code         : ");
        sb.append(this.configure.configure);
        sb.append("\n");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(" error correction capability: ");
        sb2.append(this.configure.Cardinal);
        sb2.append("\n");
        String obj2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj2);
        sb3.append(" generator matrix           : ");
        sb3.append(this.configure.init.toString());
        return sb3.toString();
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof setOutlineSpotShadowColor)) {
            setOutlineSpotShadowColor setoutlinespotshadowcolor = (setOutlineSpotShadowColor) obj;
            if (this.configure.configure == setoutlinespotshadowcolor.configure.configure && this.configure.Cardinal == setoutlinespotshadowcolor.configure.Cardinal && this.configure.init.equals(setoutlinespotshadowcolor.configure.init)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.configure.configure + (this.configure.Cardinal * 37)) * 37) + this.configure.init.hashCode();
    }

    public final byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new DSASigner.stdDSA(PQCObjectIdentifiers.cca_continue), (getProxyAddress) new setOnApplyWindowInsetsListener(this.configure.configure, this.configure.Cardinal, this.configure.init, setScrollBarDefaultDelayBeforeFade.getInstance(this.configure.getInstance))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }
}
