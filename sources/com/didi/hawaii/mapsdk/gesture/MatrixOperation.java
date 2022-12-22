package com.didi.hawaii.mapsdk.gesture;

import java.lang.reflect.Array;

public class MatrixOperation {
    public static float[][] fillMatrix(float[][] fArr) {
        int i = 0;
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i < fArr[i2].length) {
                i = fArr[i2].length;
            }
        }
        int length = fArr.length;
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = length;
        float[][] fArr2 = (float[][]) Array.newInstance(float.class, iArr);
        for (int i3 = 0; i3 < fArr.length; i3++) {
            for (int i4 = 0; i4 < fArr[i3].length; i4++) {
                fArr2[i3][i4] = fArr[i3][i4];
            }
        }
        return fArr2;
    }

    public static float[][] multiplication(float[][] fArr, float[][] fArr2) throws Exception {
        float[][] fillMatrix = fillMatrix(fArr);
        float[][] fillMatrix2 = fillMatrix(fArr2);
        if (fillMatrix[0].length == fillMatrix2.length) {
            int length = fillMatrix.length;
            int[] iArr = new int[2];
            iArr[1] = fillMatrix2[0].length;
            iArr[0] = length;
            float[][] fArr3 = (float[][]) Array.newInstance(float.class, iArr);
            for (int i = 0; i < fillMatrix.length; i++) {
                for (int i2 = 0; i2 < fillMatrix2[i].length; i2++) {
                    for (int i3 = 0; i3 < fillMatrix[i].length; i3++) {
                        float[] fArr4 = fArr3[i];
                        fArr4[i2] = fArr4[i2] + (fillMatrix[i][i3] * fillMatrix2[i3][i2]);
                    }
                }
            }
            return fArr3;
        }
        throw new Exception("矩阵A的列不等于矩阵B的行！");
    }

    public static float[][] transposed(float[][] fArr) {
        float[][] fillMatrix = fillMatrix(fArr);
        int length = fillMatrix[0].length;
        int[] iArr = new int[2];
        iArr[1] = fillMatrix.length;
        iArr[0] = length;
        float[][] fArr2 = (float[][]) Array.newInstance(float.class, iArr);
        for (int i = 0; i < fArr2.length; i++) {
            for (int i2 = 0; i2 < fArr2[0].length; i2++) {
                fArr2[i][i2] = fillMatrix[i2][i];
            }
        }
        return fArr2;
    }

    public static float[][] add(float[][] fArr, float[][] fArr2) {
        int length = fArr.length;
        int[] iArr = new int[2];
        iArr[1] = fArr[0].length;
        iArr[0] = length;
        float[][] fArr3 = (float[][]) Array.newInstance(float.class, iArr);
        for (int i = 0; i < fArr.length; i++) {
            for (int i2 = 0; i2 < fArr[0].length; i2++) {
                fArr3[i][i2] = fArr[i][i2] + fArr2[i][i2];
            }
        }
        return fArr3;
    }

    public static float[][] relu(float[][] fArr) {
        float[][] fillMatrix = fillMatrix(fArr);
        int length = fillMatrix.length;
        int[] iArr = new int[2];
        iArr[1] = fillMatrix[0].length;
        iArr[0] = length;
        float[][] fArr2 = (float[][]) Array.newInstance(float.class, iArr);
        for (int i = 0; i < fArr2.length; i++) {
            for (int i2 = 0; i2 < fArr2[0].length; i2++) {
                float[] fArr3 = fArr2[i];
                float f = 0.0f;
                if (fillMatrix[i][i2] >= 0.0f) {
                    f = fillMatrix[i][i2];
                }
                fArr3[i2] = f;
            }
        }
        return fArr2;
    }
}
