package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class RC2CBCParameter extends ASN1Object {

    /* renamed from: iv */
    ASN1OctetString f5662iv;
    ASN1Integer version;

    public RC2CBCParameter(int i, byte[] bArr) {
        this.version = new ASN1Integer((long) i);
        this.f5662iv = new DEROctetString(bArr);
    }

    private RC2CBCParameter(ASN1Sequence aSN1Sequence) {
        ASN1Encodable aSN1Encodable;
        if (aSN1Sequence.size() == 1) {
            this.version = null;
            aSN1Encodable = aSN1Sequence.getObjectAt(0);
        } else {
            this.version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
            aSN1Encodable = aSN1Sequence.getObjectAt(1);
        }
        this.f5662iv = (ASN1OctetString) aSN1Encodable;
    }

    public RC2CBCParameter(byte[] bArr) {
        this.version = null;
        this.f5662iv = new DEROctetString(bArr);
    }

    public static RC2CBCParameter getInstance(Object obj) {
        if (obj instanceof RC2CBCParameter) {
            return (RC2CBCParameter) obj;
        }
        if (obj != null) {
            return new RC2CBCParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public byte[] getIV() {
        return this.f5662iv.getOctets();
    }

    public BigInteger getRC2ParameterVersion() {
        ASN1Integer aSN1Integer = this.version;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        ASN1Integer aSN1Integer = this.version;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        aSN1EncodableVector.add(this.f5662iv);
        return new DERSequence(aSN1EncodableVector);
    }
}
