package org.bouncycastle.math.p082ec.endo;

import java.math.BigInteger;

/* renamed from: org.bouncycastle.math.ec.endo.GLVEndomorphism */
public interface GLVEndomorphism extends ECEndomorphism {
    BigInteger[] decomposeScalar(BigInteger bigInteger);
}
