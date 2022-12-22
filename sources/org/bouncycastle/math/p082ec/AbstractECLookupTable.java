package org.bouncycastle.math.p082ec;

/* renamed from: org.bouncycastle.math.ec.AbstractECLookupTable */
public abstract class AbstractECLookupTable implements ECLookupTable {
    public ECPoint lookupVar(int i) {
        return lookup(i);
    }
}
