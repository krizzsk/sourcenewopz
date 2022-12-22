package org.bouncycastle.math.p082ec.endo;

import java.math.BigInteger;
import org.bouncycastle.math.p082ec.ECCurve;
import org.bouncycastle.math.p082ec.ECPointMap;
import org.bouncycastle.math.p082ec.ScaleYNegateXPointMap;

/* renamed from: org.bouncycastle.math.ec.endo.GLVTypeAEndomorphism */
public class GLVTypeAEndomorphism implements GLVEndomorphism {
    protected final GLVTypeAParameters parameters;
    protected final ECPointMap pointMap;

    public GLVTypeAEndomorphism(ECCurve eCCurve, GLVTypeAParameters gLVTypeAParameters) {
        this.parameters = gLVTypeAParameters;
        this.pointMap = new ScaleYNegateXPointMap(eCCurve.fromBigInteger(gLVTypeAParameters.getI()));
    }

    public BigInteger[] decomposeScalar(BigInteger bigInteger) {
        return EndoUtil.decomposeScalar(this.parameters.getSplitParams(), bigInteger);
    }

    public ECPointMap getPointMap() {
        return this.pointMap;
    }

    public boolean hasEfficientPointMap() {
        return true;
    }
}
