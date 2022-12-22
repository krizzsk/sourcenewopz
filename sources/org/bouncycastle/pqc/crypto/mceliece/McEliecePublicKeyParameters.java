package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g */
    private GF2Matrix f6519g;

    /* renamed from: n */
    private int f6520n;

    /* renamed from: t */
    private int f6521t;

    public McEliecePublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix) {
        super(false, (McElieceParameters) null);
        this.f6520n = i;
        this.f6521t = i2;
        this.f6519g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f6519g;
    }

    public int getK() {
        return this.f6519g.getNumRows();
    }

    public int getN() {
        return this.f6520n;
    }

    public int getT() {
        return this.f6521t;
    }
}
