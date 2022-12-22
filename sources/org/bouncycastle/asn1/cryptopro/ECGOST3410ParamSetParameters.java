package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    ASN1Integer f5642a;

    /* renamed from: b */
    ASN1Integer f5643b;

    /* renamed from: p */
    ASN1Integer f5644p;

    /* renamed from: q */
    ASN1Integer f5645q;

    /* renamed from: x */
    ASN1Integer f5646x;

    /* renamed from: y */
    ASN1Integer f5647y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f5642a = new ASN1Integer(bigInteger);
        this.f5643b = new ASN1Integer(bigInteger2);
        this.f5644p = new ASN1Integer(bigInteger3);
        this.f5645q = new ASN1Integer(bigInteger4);
        this.f5646x = new ASN1Integer((long) i);
        this.f5647y = new ASN1Integer(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f5642a = (ASN1Integer) objects.nextElement();
        this.f5643b = (ASN1Integer) objects.nextElement();
        this.f5644p = (ASN1Integer) objects.nextElement();
        this.f5645q = (ASN1Integer) objects.nextElement();
        this.f5646x = (ASN1Integer) objects.nextElement();
        this.f5647y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.f5642a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f5644p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f5645q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(this.f5642a);
        aSN1EncodableVector.add(this.f5643b);
        aSN1EncodableVector.add(this.f5644p);
        aSN1EncodableVector.add(this.f5645q);
        aSN1EncodableVector.add(this.f5646x);
        aSN1EncodableVector.add(this.f5647y);
        return new DERSequence(aSN1EncodableVector);
    }
}
