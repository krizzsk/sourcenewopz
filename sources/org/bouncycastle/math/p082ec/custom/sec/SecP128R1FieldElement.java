package org.bouncycastle.math.p082ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.p082ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* renamed from: org.bouncycastle.math.ec.custom.sec.SecP128R1FieldElement */
public class SecP128R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f6326Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f6327x;

    public SecP128R1FieldElement() {
        this.f6327x = Nat128.create();
    }

    public SecP128R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f6326Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.f6327x = SecP128R1Field.fromBigInteger(bigInteger);
    }

    protected SecP128R1FieldElement(int[] iArr) {
        this.f6327x = iArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat128.create();
        SecP128R1Field.add(this.f6327x, ((SecP128R1FieldElement) eCFieldElement).f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat128.create();
        SecP128R1Field.addOne(this.f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat128.create();
        SecP128R1Field.inv(((SecP128R1FieldElement) eCFieldElement).f6327x, create);
        SecP128R1Field.multiply(create, this.f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP128R1FieldElement)) {
            return false;
        }
        return Nat128.m3735eq(this.f6327x, ((SecP128R1FieldElement) obj).f6327x);
    }

    public String getFieldName() {
        return "SecP128R1Field";
    }

    public int getFieldSize() {
        return f6326Q.bitLength();
    }

    public int hashCode() {
        return f6326Q.hashCode() ^ Arrays.hashCode(this.f6327x, 0, 4);
    }

    public ECFieldElement invert() {
        int[] create = Nat128.create();
        SecP128R1Field.inv(this.f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public boolean isOne() {
        return Nat128.isOne(this.f6327x);
    }

    public boolean isZero() {
        return Nat128.isZero(this.f6327x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat128.create();
        SecP128R1Field.multiply(this.f6327x, ((SecP128R1FieldElement) eCFieldElement).f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat128.create();
        SecP128R1Field.negate(this.f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f6327x;
        if (Nat128.isZero(iArr) || Nat128.isOne(iArr)) {
            return this;
        }
        int[] create = Nat128.create();
        SecP128R1Field.square(iArr, create);
        SecP128R1Field.multiply(create, iArr, create);
        int[] create2 = Nat128.create();
        SecP128R1Field.squareN(create, 2, create2);
        SecP128R1Field.multiply(create2, create, create2);
        int[] create3 = Nat128.create();
        SecP128R1Field.squareN(create2, 4, create3);
        SecP128R1Field.multiply(create3, create2, create3);
        SecP128R1Field.squareN(create3, 2, create2);
        SecP128R1Field.multiply(create2, create, create2);
        SecP128R1Field.squareN(create2, 10, create);
        SecP128R1Field.multiply(create, create2, create);
        SecP128R1Field.squareN(create, 10, create3);
        SecP128R1Field.multiply(create3, create2, create3);
        SecP128R1Field.square(create3, create2);
        SecP128R1Field.multiply(create2, iArr, create2);
        SecP128R1Field.squareN(create2, 95, create2);
        SecP128R1Field.square(create2, create3);
        if (Nat128.m3735eq(iArr, create3)) {
            return new SecP128R1FieldElement(create2);
        }
        return null;
    }

    public ECFieldElement square() {
        int[] create = Nat128.create();
        SecP128R1Field.square(this.f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat128.create();
        SecP128R1Field.subtract(this.f6327x, ((SecP128R1FieldElement) eCFieldElement).f6327x, create);
        return new SecP128R1FieldElement(create);
    }

    public boolean testBitZero() {
        return Nat128.getBit(this.f6327x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat128.toBigInteger(this.f6327x);
    }
}
