package com.didi.hawaii.p118ar.utils;

import com.didi.hawaii.p118ar.jni.DARCMatrix3F;
import com.didi.hawaii.p118ar.jni.DARCMatrix4F;
import com.didi.hawaii.p118ar.jni.DARCPoint3F;
import com.didi.hawaii.p118ar.jni.DARCPoint4F;

/* renamed from: com.didi.hawaii.ar.utils.MatrixUtil */
public class MatrixUtil {
    /* renamed from: a */
    private static int m16718a(double d) {
        int i = (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i == 0 ? 0 : -1;
    }

    public static DARCMatrix4F convertViewMatrix2DARCMatrix(float[] fArr) {
        DARCMatrix4F dARCMatrix4F = new DARCMatrix4F();
        DARCPoint4F dARCPoint4F = new DARCPoint4F();
        dARCPoint4F.setX(fArr[0]);
        dARCPoint4F.setY(fArr[1]);
        dARCPoint4F.setZ(fArr[2]);
        dARCPoint4F.setW(fArr[3]);
        dARCMatrix4F.setX(dARCPoint4F);
        DARCPoint4F dARCPoint4F2 = new DARCPoint4F();
        dARCPoint4F2.setX(fArr[4]);
        dARCPoint4F2.setY(fArr[5]);
        dARCPoint4F2.setZ(fArr[6]);
        dARCPoint4F2.setW(fArr[7]);
        dARCMatrix4F.setY(dARCPoint4F2);
        DARCPoint4F dARCPoint4F3 = new DARCPoint4F();
        dARCPoint4F3.setX(fArr[8]);
        dARCPoint4F3.setY(fArr[9]);
        dARCPoint4F3.setZ(fArr[10]);
        dARCPoint4F3.setW(fArr[11]);
        dARCMatrix4F.setZ(dARCPoint4F3);
        DARCPoint4F dARCPoint4F4 = new DARCPoint4F();
        dARCPoint4F4.setX(fArr[12]);
        dARCPoint4F4.setY(fArr[13]);
        dARCPoint4F4.setZ(fArr[14]);
        dARCPoint4F4.setW(fArr[15]);
        dARCMatrix4F.setW(dARCPoint4F4);
        return dARCMatrix4F;
    }

    public static DARCMatrix3F convetMatrix3F2DARCMatrix3F(float[] fArr) {
        DARCPoint3F dARCPoint3F = new DARCPoint3F();
        dARCPoint3F.setX(fArr[0]);
        dARCPoint3F.setY(fArr[1]);
        dARCPoint3F.setZ(fArr[2]);
        DARCPoint3F dARCPoint3F2 = new DARCPoint3F();
        dARCPoint3F2.setX(fArr[3]);
        dARCPoint3F2.setY(fArr[4]);
        dARCPoint3F2.setZ(fArr[5]);
        DARCPoint3F dARCPoint3F3 = new DARCPoint3F();
        dARCPoint3F3.setX(fArr[6]);
        dARCPoint3F3.setY(fArr[7]);
        dARCPoint3F3.setZ(fArr[8]);
        DARCMatrix3F dARCMatrix3F = new DARCMatrix3F();
        dARCMatrix3F.setX(dARCPoint3F);
        dARCMatrix3F.setY(dARCPoint3F2);
        dARCMatrix3F.setZ(dARCPoint3F3);
        return dARCMatrix3F;
    }

    public static DARCMatrix3F convetMatrix3F2DARCMatrix3FTranspose(float[] fArr) {
        DARCPoint3F dARCPoint3F = new DARCPoint3F();
        dARCPoint3F.setX(fArr[0]);
        dARCPoint3F.setY(fArr[3]);
        dARCPoint3F.setZ(fArr[6]);
        DARCPoint3F dARCPoint3F2 = new DARCPoint3F();
        dARCPoint3F2.setX(fArr[1]);
        dARCPoint3F2.setY(fArr[4]);
        dARCPoint3F2.setZ(fArr[7]);
        DARCPoint3F dARCPoint3F3 = new DARCPoint3F();
        dARCPoint3F3.setX(fArr[2]);
        dARCPoint3F3.setY(fArr[5]);
        dARCPoint3F3.setZ(fArr[8]);
        DARCMatrix3F dARCMatrix3F = new DARCMatrix3F();
        dARCMatrix3F.setX(dARCPoint3F);
        dARCMatrix3F.setY(dARCPoint3F2);
        dARCMatrix3F.setZ(dARCPoint3F3);
        return dARCMatrix3F;
    }

    public static DARCMatrix3F alignToIOSOfAndroidForAttitudeData(float[] fArr) {
        DARCPoint3F dARCPoint3F = new DARCPoint3F();
        dARCPoint3F.setX(fArr[1]);
        dARCPoint3F.setY(-fArr[0]);
        dARCPoint3F.setZ(fArr[2]);
        DARCPoint3F dARCPoint3F2 = new DARCPoint3F();
        dARCPoint3F2.setX(fArr[4]);
        dARCPoint3F2.setY(-fArr[3]);
        dARCPoint3F2.setZ(fArr[5]);
        DARCPoint3F dARCPoint3F3 = new DARCPoint3F();
        dARCPoint3F3.setX(fArr[7]);
        dARCPoint3F3.setY(-fArr[6]);
        dARCPoint3F3.setZ(fArr[8]);
        DARCMatrix3F dARCMatrix3F = new DARCMatrix3F();
        dARCMatrix3F.setX(dARCPoint3F);
        dARCMatrix3F.setY(dARCPoint3F2);
        dARCMatrix3F.setZ(dARCPoint3F3);
        return dARCMatrix3F;
    }

    public static DARCPoint3F convet2DARCPoint3F(double[] dArr) {
        DARCPoint3F dARCPoint3F = new DARCPoint3F();
        dARCPoint3F.setX((float) dArr[0]);
        dARCPoint3F.setY((float) dArr[1]);
        dARCPoint3F.setZ((float) dArr[2]);
        return dARCPoint3F;
    }

    public static double[] quaternionToEuler(float[] fArr) {
        double[] dArr = {0.0d, 0.0d, 0.0d};
        double d = (double) ((fArr[3] * fArr[1]) - (fArr[0] * fArr[2]));
        if (d < -0.4990234375d || d > 0.4990234375d) {
            int a = m16718a(d);
            dArr[2] = ((double) (a * -2)) * Math.atan2((double) fArr[0], (double) fArr[3]);
            dArr[0] = ((double) a) * 1.5707963267948966d;
            dArr[1] = 0.0d;
        } else {
            dArr[1] = -Math.atan2((double) (((fArr[1] * fArr[2]) + (fArr[3] * fArr[0])) * 2.0f), (double) ((((fArr[3] * fArr[3]) - (fArr[0] * fArr[0])) - (fArr[1] * fArr[1])) + (fArr[2] * fArr[2])));
            dArr[0] = Math.asin((double) (((fArr[0] * fArr[2]) - (fArr[3] * fArr[1])) * -2.0f));
            dArr[2] = Math.atan2((double) (((fArr[0] * fArr[1]) + (fArr[3] * fArr[2])) * 2.0f), (double) ((((fArr[3] * fArr[3]) + (fArr[0] * fArr[0])) - (fArr[1] * fArr[1])) - (fArr[2] * fArr[2])));
        }
        return dArr;
    }
}
