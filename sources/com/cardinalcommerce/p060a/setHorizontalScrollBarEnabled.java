package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.cardinalcommerce.dependencies.internal.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.cardinalcommerce.p060a.DSASigner;
import java.io.IOException;
import java.security.PublicKey;

/* renamed from: com.cardinalcommerce.a.setHorizontalScrollBarEnabled */
public final class setHorizontalScrollBarEnabled implements PublicKey {
    private setSaveFromParentEnabled getInstance;

    public setHorizontalScrollBarEnabled(setSaveFromParentEnabled setsavefromparentenabled) {
        this.getInstance = setsavefromparentenabled;
    }

    public final String getAlgorithm() {
        return "McEliece";
    }

    public final String getFormat() {
        return "X.509";
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("McEliecePublicKey:\n");
        sb.append(" length of the code         : ");
        sb.append(this.getInstance.getInstance);
        sb.append("\n");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(" error correction capability: ");
        sb2.append(this.getInstance.configure);
        sb2.append("\n");
        String obj2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj2);
        sb3.append(" generator matrix           : ");
        sb3.append(this.getInstance.init);
        return sb3.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof setHorizontalScrollBarEnabled) {
            setHorizontalScrollBarEnabled sethorizontalscrollbarenabled = (setHorizontalScrollBarEnabled) obj;
            if (this.getInstance.getInstance == sethorizontalscrollbarenabled.getInstance.getInstance && this.getInstance.configure == sethorizontalscrollbarenabled.getInstance.configure && this.getInstance.init.equals(sethorizontalscrollbarenabled.getInstance.init)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.getInstance.getInstance + (this.getInstance.configure * 37)) * 37) + this.getInstance.init.hashCode();
    }

    public final byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new DSASigner.stdDSA(PQCObjectIdentifiers.init), (getProxyAddress) new setEnabled(this.getInstance.getInstance, this.getInstance.configure, this.getInstance.init)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }
}
