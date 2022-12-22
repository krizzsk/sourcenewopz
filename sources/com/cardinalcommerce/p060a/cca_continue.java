package com.cardinalcommerce.p060a;

import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* renamed from: com.cardinalcommerce.a.cca_continue */
public enum cca_continue {
    New(0),
    Configured(1),
    InitStarted(2),
    InitCompleted(3),
    Continue(6),
    Validated(9);
    
    private static int cca_continue = 1;
    private static int configure;
    final int index;

    static {
        int i = cca_continue;
        int i2 = ((i | 113) << 1) - (i ^ 113);
        configure = i2 % 128;
        if ((i2 % 2 != 0 ? Matrix.MATRIX_TYPE_RANDOM_REGULAR : 30) == 'R') {
            Object obj = null;
            super.hashCode();
        }
    }

    private cca_continue(int i) {
        this.index = i;
    }
}
