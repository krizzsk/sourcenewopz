package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey extends ASN1Object {

    /* renamed from: g */
    private final GF2Matrix f6434g;

    /* renamed from: n */
    private final int f6435n;

    /* renamed from: t */
    private final int f6436t;

    public McEliecePublicKey(int i, int i2, GF2Matrix gF2Matrix) {
        this.f6435n = i;
        this.f6436t = i2;
        this.f6434g = new GF2Matrix(gF2Matrix);
    }

    private McEliecePublicKey(ASN1Sequence aSN1Sequence) {
        this.f6435n = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f6436t = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intValueExact();
        this.f6434g = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
    }

    public static McEliecePublicKey getInstance(Object obj) {
        if (obj instanceof McEliecePublicKey) {
            return (McEliecePublicKey) obj;
        }
        if (obj != null) {
            return new McEliecePublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.f6434g);
    }

    public int getN() {
        return this.f6435n;
    }

    public int getT() {
        return this.f6436t;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f6435n));
        aSN1EncodableVector.add(new ASN1Integer((long) this.f6436t));
        aSN1EncodableVector.add(new DEROctetString(this.f6434g.getEncoded()));
        return new DERSequence(aSN1EncodableVector);
    }
}
