package com.didi.hawaii.p118ar.utils;

import java.util.logging.Logger;

/* renamed from: com.didi.hawaii.ar.utils.Matrix3f */
public final class Matrix3f {
    public static final Matrix3f IDENTITY = new Matrix3f();
    public static final Matrix3f ZERO = new Matrix3f(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a */
    static final long f23323a = 1;

    /* renamed from: b */
    private static final Logger f23324b = Logger.getLogger(Matrix3f.class.getName());
    protected float m00;
    protected float m01;
    protected float m02;
    protected float m10;
    protected float m11;
    protected float m12;
    protected float m20;
    protected float m21;
    protected float m22;

    public Matrix3f() {
        loadIdentity();
    }

    public Matrix3f(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.m00 = f;
        this.m01 = f2;
        this.m02 = f3;
        this.m10 = f4;
        this.m11 = f5;
        this.m12 = f6;
        this.m20 = f7;
        this.m21 = f8;
        this.m22 = f9;
    }

    public Matrix3f(Matrix3f matrix3f) {
        set(matrix3f);
    }

    public void absoluteLocal() {
        this.m00 = FastMath.abs(this.m00);
        this.m01 = FastMath.abs(this.m01);
        this.m02 = FastMath.abs(this.m02);
        this.m10 = FastMath.abs(this.m10);
        this.m11 = FastMath.abs(this.m11);
        this.m12 = FastMath.abs(this.m12);
        this.m20 = FastMath.abs(this.m20);
        this.m21 = FastMath.abs(this.m21);
        this.m22 = FastMath.abs(this.m22);
    }

    public Matrix3f set(Matrix3f matrix3f) {
        if (matrix3f == null) {
            loadIdentity();
        } else {
            this.m00 = matrix3f.m00;
            this.m01 = matrix3f.m01;
            this.m02 = matrix3f.m02;
            this.m10 = matrix3f.m10;
            this.m11 = matrix3f.m11;
            this.m12 = matrix3f.m12;
            this.m20 = matrix3f.m20;
            this.m21 = matrix3f.m21;
            this.m22 = matrix3f.m22;
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r3 == 2) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float get(int r3, int r4) {
        /*
            r2 = this;
            r0 = 2
            r1 = 1
            if (r3 == 0) goto L_0x0009
            if (r3 == r1) goto L_0x000f
            if (r3 != r0) goto L_0x001e
            goto L_0x0015
        L_0x0009:
            if (r4 == 0) goto L_0x0042
            if (r4 == r1) goto L_0x003f
            if (r4 == r0) goto L_0x003c
        L_0x000f:
            if (r4 == 0) goto L_0x0039
            if (r4 == r1) goto L_0x0036
            if (r4 == r0) goto L_0x0033
        L_0x0015:
            if (r4 == 0) goto L_0x0030
            if (r4 == r1) goto L_0x002d
            if (r4 != r0) goto L_0x001e
            float r3 = r2.m22
            return r3
        L_0x001e:
            java.util.logging.Logger r3 = f23324b
            java.lang.String r4 = "Invalid matrix index."
            r3.warning(r4)
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Invalid indices into matrix."
            r3.<init>(r4)
            throw r3
        L_0x002d:
            float r3 = r2.m21
            return r3
        L_0x0030:
            float r3 = r2.m20
            return r3
        L_0x0033:
            float r3 = r2.m12
            return r3
        L_0x0036:
            float r3 = r2.m11
            return r3
        L_0x0039:
            float r3 = r2.m10
            return r3
        L_0x003c:
            float r3 = r2.m02
            return r3
        L_0x003f:
            float r3 = r2.m01
            return r3
        L_0x0042:
            float r3 = r2.m00
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.Matrix3f.get(int, int):float");
    }

    public void get(float[] fArr, boolean z) {
        if (fArr.length == 9) {
            if (z) {
                fArr[0] = this.m00;
                fArr[1] = this.m01;
                fArr[2] = this.m02;
                fArr[3] = this.m10;
                fArr[4] = this.m11;
                fArr[5] = this.m12;
                fArr[6] = this.m20;
                fArr[7] = this.m21;
                fArr[8] = this.m22;
                return;
            }
            fArr[0] = this.m00;
            fArr[1] = this.m10;
            fArr[2] = this.m20;
            fArr[3] = this.m01;
            fArr[4] = this.m11;
            fArr[5] = this.m21;
            fArr[6] = this.m02;
            fArr[7] = this.m12;
            fArr[8] = this.m22;
        } else if (fArr.length != 16) {
            throw new IndexOutOfBoundsException("Array size must be 9 or 16 in Matrix3f.get().");
        } else if (z) {
            fArr[0] = this.m00;
            fArr[1] = this.m01;
            fArr[2] = this.m02;
            fArr[4] = this.m10;
            fArr[5] = this.m11;
            fArr[6] = this.m12;
            fArr[8] = this.m20;
            fArr[9] = this.m21;
            fArr[10] = this.m22;
        } else {
            fArr[0] = this.m00;
            fArr[1] = this.m10;
            fArr[2] = this.m20;
            fArr[4] = this.m01;
            fArr[5] = this.m11;
            fArr[6] = this.m21;
            fArr[8] = this.m02;
            fArr[9] = this.m12;
            fArr[10] = this.m22;
        }
    }

    public Vector3f getColumn(int i) {
        return getColumn(i, (Vector3f) null);
    }

    public Vector3f getColumn(int i, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        if (i == 0) {
            vector3f.f23353x = this.m00;
            vector3f.f23354y = this.m10;
            vector3f.f23355z = this.m20;
        } else if (i == 1) {
            vector3f.f23353x = this.m01;
            vector3f.f23354y = this.m11;
            vector3f.f23355z = this.m21;
        } else if (i == 2) {
            vector3f.f23353x = this.m02;
            vector3f.f23354y = this.m12;
            vector3f.f23355z = this.m22;
        } else {
            f23324b.warning("Invalid column index.");
            throw new IllegalArgumentException("Invalid column index. " + i);
        }
        return vector3f;
    }

    public Vector3f getRow(int i) {
        return getRow(i, (Vector3f) null);
    }

    public Vector3f getRow(int i, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        if (i == 0) {
            vector3f.f23353x = this.m00;
            vector3f.f23354y = this.m01;
            vector3f.f23355z = this.m02;
        } else if (i == 1) {
            vector3f.f23353x = this.m10;
            vector3f.f23354y = this.m11;
            vector3f.f23355z = this.m12;
        } else if (i == 2) {
            vector3f.f23353x = this.m20;
            vector3f.f23354y = this.m21;
            vector3f.f23355z = this.m22;
        } else {
            f23324b.warning("Invalid row index.");
            throw new IllegalArgumentException("Invalid row index. " + i);
        }
        return vector3f;
    }

    public void fillFloatArray(float[] fArr, boolean z) {
        if (z) {
            fArr[0] = this.m00;
            fArr[1] = this.m10;
            fArr[2] = this.m20;
            fArr[3] = this.m01;
            fArr[4] = this.m11;
            fArr[5] = this.m21;
            fArr[6] = this.m02;
            fArr[7] = this.m12;
            fArr[8] = this.m22;
            return;
        }
        fArr[0] = this.m00;
        fArr[1] = this.m01;
        fArr[2] = this.m02;
        fArr[3] = this.m10;
        fArr[4] = this.m11;
        fArr[5] = this.m12;
        fArr[6] = this.m20;
        fArr[7] = this.m21;
        fArr[8] = this.m22;
    }

    public Matrix3f setColumn(int i, Vector3f vector3f) {
        if (vector3f == null) {
            f23324b.warning("Column is null. Ignoring.");
            return this;
        }
        if (i == 0) {
            this.m00 = vector3f.f23353x;
            this.m10 = vector3f.f23354y;
            this.m20 = vector3f.f23355z;
        } else if (i == 1) {
            this.m01 = vector3f.f23353x;
            this.m11 = vector3f.f23354y;
            this.m21 = vector3f.f23355z;
        } else if (i == 2) {
            this.m02 = vector3f.f23353x;
            this.m12 = vector3f.f23354y;
            this.m22 = vector3f.f23355z;
        } else {
            f23324b.warning("Invalid column index.");
            throw new IllegalArgumentException("Invalid column index. " + i);
        }
        return this;
    }

    public Matrix3f setRow(int i, Vector3f vector3f) {
        if (vector3f == null) {
            f23324b.warning("Row is null. Ignoring.");
            return this;
        }
        if (i == 0) {
            this.m00 = vector3f.f23353x;
            this.m01 = vector3f.f23354y;
            this.m02 = vector3f.f23355z;
        } else if (i == 1) {
            this.m10 = vector3f.f23353x;
            this.m11 = vector3f.f23354y;
            this.m12 = vector3f.f23355z;
        } else if (i == 2) {
            this.m20 = vector3f.f23353x;
            this.m21 = vector3f.f23354y;
            this.m22 = vector3f.f23355z;
        } else {
            f23324b.warning("Invalid row index.");
            throw new IllegalArgumentException("Invalid row index. " + i);
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r3 == 2) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.hawaii.p118ar.utils.Matrix3f set(int r3, int r4, float r5) {
        /*
            r2 = this;
            r0 = 2
            r1 = 1
            if (r3 == 0) goto L_0x0009
            if (r3 == r1) goto L_0x000f
            if (r3 != r0) goto L_0x001e
            goto L_0x0015
        L_0x0009:
            if (r4 == 0) goto L_0x0042
            if (r4 == r1) goto L_0x003f
            if (r4 == r0) goto L_0x003c
        L_0x000f:
            if (r4 == 0) goto L_0x0039
            if (r4 == r1) goto L_0x0036
            if (r4 == r0) goto L_0x0033
        L_0x0015:
            if (r4 == 0) goto L_0x0030
            if (r4 == r1) goto L_0x002d
            if (r4 != r0) goto L_0x001e
            r2.m22 = r5
            return r2
        L_0x001e:
            java.util.logging.Logger r3 = f23324b
            java.lang.String r4 = "Invalid matrix index."
            r3.warning(r4)
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Invalid indices into matrix."
            r3.<init>(r4)
            throw r3
        L_0x002d:
            r2.m21 = r5
            return r2
        L_0x0030:
            r2.m20 = r5
            return r2
        L_0x0033:
            r2.m12 = r5
            return r2
        L_0x0036:
            r2.m11 = r5
            return r2
        L_0x0039:
            r2.m10 = r5
            return r2
        L_0x003c:
            r2.m02 = r5
            return r2
        L_0x003f:
            r2.m01 = r5
            return r2
        L_0x0042:
            r2.m00 = r5
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.Matrix3f.set(int, int, float):com.didi.hawaii.ar.utils.Matrix3f");
    }

    public Matrix3f set(float[][] fArr) {
        if (fArr.length == 3 && fArr[0].length == 3) {
            this.m00 = fArr[0][0];
            this.m01 = fArr[0][1];
            this.m02 = fArr[0][2];
            this.m10 = fArr[1][0];
            this.m11 = fArr[1][1];
            this.m12 = fArr[1][2];
            this.m20 = fArr[2][0];
            this.m21 = fArr[2][1];
            this.m22 = fArr[2][2];
            return this;
        }
        throw new IllegalArgumentException("Array must be of size 9.");
    }

    public void fromAxes(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        this.m00 = vector3f.f23353x;
        this.m10 = vector3f.f23354y;
        this.m20 = vector3f.f23355z;
        this.m01 = vector3f2.f23353x;
        this.m11 = vector3f2.f23354y;
        this.m21 = vector3f2.f23355z;
        this.m02 = vector3f3.f23353x;
        this.m12 = vector3f3.f23354y;
        this.m22 = vector3f3.f23355z;
    }

    public Matrix3f set(float[] fArr) {
        return set(fArr, true);
    }

    public Matrix3f set(float[] fArr, boolean z) {
        if (fArr.length == 9) {
            if (z) {
                this.m00 = fArr[0];
                this.m01 = fArr[1];
                this.m02 = fArr[2];
                this.m10 = fArr[3];
                this.m11 = fArr[4];
                this.m12 = fArr[5];
                this.m20 = fArr[6];
                this.m21 = fArr[7];
                this.m22 = fArr[8];
            } else {
                this.m00 = fArr[0];
                this.m01 = fArr[3];
                this.m02 = fArr[6];
                this.m10 = fArr[1];
                this.m11 = fArr[4];
                this.m12 = fArr[7];
                this.m20 = fArr[2];
                this.m21 = fArr[5];
                this.m22 = fArr[8];
            }
            return this;
        }
        throw new IllegalArgumentException("Array must be of size 9.");
    }

    public Matrix3f set(Quaternion quaternion) {
        return quaternion.toRotationMatrix(this);
    }

    public void loadIdentity() {
        this.m21 = 0.0f;
        this.m20 = 0.0f;
        this.m12 = 0.0f;
        this.m10 = 0.0f;
        this.m02 = 0.0f;
        this.m01 = 0.0f;
        this.m22 = 1.0f;
        this.m11 = 1.0f;
        this.m00 = 1.0f;
    }

    public boolean isIdentity() {
        return this.m00 == 1.0f && this.m01 == 0.0f && this.m02 == 0.0f && this.m10 == 0.0f && this.m11 == 1.0f && this.m12 == 0.0f && this.m20 == 0.0f && this.m21 == 0.0f && this.m22 == 1.0f;
    }

    public void fromAngleAxis(float f, Vector3f vector3f) {
        fromAngleNormalAxis(f, vector3f.normalize());
    }

    public void fromAngleNormalAxis(float f, Vector3f vector3f) {
        float cos = FastMath.cos(f);
        float sin = FastMath.sin(f);
        float f2 = 1.0f - cos;
        float f3 = vector3f.f23353x * vector3f.f23353x;
        float f4 = vector3f.f23354y * vector3f.f23354y;
        float f5 = vector3f.f23355z * vector3f.f23355z;
        float f6 = vector3f.f23353x * vector3f.f23354y * f2;
        float f7 = vector3f.f23353x * vector3f.f23355z * f2;
        float f8 = vector3f.f23354y * vector3f.f23355z * f2;
        float f9 = vector3f.f23353x * sin;
        float f10 = vector3f.f23354y * sin;
        float f11 = vector3f.f23355z * sin;
        this.m00 = (f3 * f2) + cos;
        this.m01 = f6 - f11;
        this.m02 = f7 + f10;
        this.m10 = f6 + f11;
        this.m11 = (f4 * f2) + cos;
        this.m12 = f8 - f9;
        this.m20 = f7 - f10;
        this.m21 = f8 + f9;
        this.m22 = (f5 * f2) + cos;
    }

    public Matrix3f mult(Matrix3f matrix3f) {
        return mult(matrix3f, (Matrix3f) null);
    }

    public Matrix3f mult(Matrix3f matrix3f, Matrix3f matrix3f2) {
        Matrix3f matrix3f3 = matrix3f;
        Matrix3f matrix3f4 = matrix3f2 == null ? new Matrix3f() : matrix3f2;
        float f = this.m00;
        float f2 = matrix3f3.m00;
        float f3 = this.m01;
        float f4 = matrix3f3.m10;
        float f5 = this.m02;
        float f6 = matrix3f3.m20;
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = matrix3f3.m01;
        float f9 = matrix3f3.m11;
        float f10 = matrix3f3.m21;
        float f11 = matrix3f3.m02;
        float f12 = matrix3f3.m12;
        float f13 = matrix3f3.m22;
        float f14 = (f * f11) + (f3 * f12) + (f5 * f13);
        float f15 = this.m10;
        float f16 = f14;
        float f17 = this.m11;
        float f18 = (f * f8) + (f3 * f9) + (f5 * f10);
        float f19 = this.m12;
        float f20 = (f15 * f11) + (f17 * f12) + (f19 * f13);
        float f21 = this.m20;
        float f22 = this.m21;
        float f23 = (f2 * f21) + (f4 * f22);
        float f24 = this.m22;
        matrix3f4.m00 = f7;
        matrix3f4.m01 = f18;
        matrix3f4.m02 = f16;
        matrix3f4.m10 = (f15 * f2) + (f17 * f4) + (f19 * f6);
        matrix3f4.m11 = (f15 * f8) + (f17 * f9) + (f19 * f10);
        matrix3f4.m12 = f20;
        matrix3f4.m20 = f23 + (f6 * f24);
        matrix3f4.m21 = (f8 * f21) + (f9 * f22) + (f10 * f24);
        matrix3f4.m22 = (f21 * f11) + (f22 * f12) + (f24 * f13);
        return matrix3f4;
    }

    public Vector3f mult(Vector3f vector3f) {
        return mult(vector3f, (Vector3f) null);
    }

    public Vector3f mult(Vector3f vector3f, Vector3f vector3f2) {
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        float f = vector3f.f23353x;
        float f2 = vector3f.f23354y;
        float f3 = vector3f.f23355z;
        vector3f2.f23353x = (this.m00 * f) + (this.m01 * f2) + (this.m02 * f3);
        vector3f2.f23354y = (this.m10 * f) + (this.m11 * f2) + (this.m12 * f3);
        vector3f2.f23355z = (this.m20 * f) + (this.m21 * f2) + (this.m22 * f3);
        return vector3f2;
    }

    public Matrix3f multLocal(float f) {
        this.m00 *= f;
        this.m01 *= f;
        this.m02 *= f;
        this.m10 *= f;
        this.m11 *= f;
        this.m12 *= f;
        this.m20 *= f;
        this.m21 *= f;
        this.m22 *= f;
        return this;
    }

    public Vector3f multLocal(Vector3f vector3f) {
        if (vector3f == null) {
            return null;
        }
        float f = vector3f.f23353x;
        float f2 = vector3f.f23354y;
        vector3f.f23353x = (this.m00 * f) + (this.m01 * f2) + (this.m02 * vector3f.f23355z);
        vector3f.f23354y = (this.m10 * f) + (this.m11 * f2) + (this.m12 * vector3f.f23355z);
        vector3f.f23355z = (this.m20 * f) + (this.m21 * f2) + (this.m22 * vector3f.f23355z);
        return vector3f;
    }

    public Matrix3f multLocal(Matrix3f matrix3f) {
        return mult(matrix3f, this);
    }

    public Matrix3f transposeLocal() {
        float f = this.m01;
        this.m01 = this.m10;
        this.m10 = f;
        float f2 = this.m02;
        this.m02 = this.m20;
        this.m20 = f2;
        float f3 = this.m12;
        this.m12 = this.m21;
        this.m21 = f3;
        return this;
    }

    public Matrix3f invert() {
        return invert((Matrix3f) null);
    }

    public Matrix3f invert(Matrix3f matrix3f) {
        if (matrix3f == null) {
            matrix3f = new Matrix3f();
        }
        float determinant = determinant();
        if (FastMath.abs(determinant) <= 1.1920929E-7f) {
            return matrix3f.zero();
        }
        float f = this.m11;
        float f2 = this.m22;
        float f3 = this.m12;
        float f4 = this.m21;
        matrix3f.m00 = (f * f2) - (f3 * f4);
        float f5 = this.m02;
        matrix3f.m01 = (f5 * f4) - (this.m01 * f2);
        float f6 = this.m01;
        matrix3f.m02 = (f6 * f3) - (f5 * f);
        float f7 = this.m20;
        matrix3f.m10 = (f3 * f7) - (this.m10 * f2);
        float f8 = this.m00;
        float f9 = this.m02;
        matrix3f.m11 = (f2 * f8) - (f9 * f7);
        float f10 = this.m10;
        matrix3f.m12 = (f9 * f10) - (f3 * f8);
        float f11 = this.m11;
        matrix3f.m20 = (f10 * f4) - (f7 * f11);
        matrix3f.m21 = (this.m20 * f6) - (f4 * f8);
        matrix3f.m22 = (f8 * f11) - (f6 * f10);
        matrix3f.multLocal(1.0f / determinant);
        return matrix3f;
    }

    public Matrix3f invertLocal() {
        float determinant = determinant();
        if (FastMath.abs(determinant) <= 0.0f) {
            return zero();
        }
        float f = this.m11;
        float f2 = this.m22;
        float f3 = this.m12;
        float f4 = this.m21;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.m02;
        float f7 = this.m01;
        float f8 = (f6 * f4) - (f7 * f2);
        float f9 = (f7 * f3) - (f6 * f);
        float f10 = this.m20;
        float f11 = this.m10;
        float f12 = (f3 * f10) - (f11 * f2);
        float f13 = this.m00;
        float f14 = (f2 * f13) - (f6 * f10);
        this.m00 = f5;
        this.m01 = f8;
        this.m02 = f9;
        this.m10 = f12;
        this.m11 = f14;
        this.m12 = (f6 * f11) - (f3 * f13);
        this.m20 = (f11 * f4) - (f * f10);
        this.m21 = (f10 * f7) - (f4 * f13);
        this.m22 = (f13 * f) - (f7 * f11);
        multLocal(1.0f / determinant);
        return this;
    }

    public Matrix3f adjoint() {
        return adjoint((Matrix3f) null);
    }

    public Matrix3f adjoint(Matrix3f matrix3f) {
        if (matrix3f == null) {
            matrix3f = new Matrix3f();
        }
        float f = this.m11;
        float f2 = this.m22;
        float f3 = this.m12;
        float f4 = this.m21;
        matrix3f.m00 = (f * f2) - (f3 * f4);
        float f5 = this.m02;
        matrix3f.m01 = (f5 * f4) - (this.m01 * f2);
        float f6 = this.m01;
        matrix3f.m02 = (f6 * f3) - (f5 * f);
        float f7 = this.m20;
        matrix3f.m10 = (f3 * f7) - (this.m10 * f2);
        float f8 = this.m00;
        float f9 = this.m02;
        matrix3f.m11 = (f2 * f8) - (f9 * f7);
        float f10 = this.m10;
        matrix3f.m12 = (f9 * f10) - (f3 * f8);
        float f11 = this.m11;
        matrix3f.m20 = (f10 * f4) - (f7 * f11);
        matrix3f.m21 = (this.m20 * f6) - (f4 * f8);
        matrix3f.m22 = (f8 * f11) - (f6 * f10);
        return matrix3f;
    }

    public float determinant() {
        float f = this.m11;
        float f2 = this.m22;
        float f3 = this.m12;
        float f4 = this.m21;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.m20;
        float f7 = this.m10;
        return (this.m00 * f5) + (this.m01 * ((f3 * f6) - (f2 * f7))) + (this.m02 * ((f7 * f4) - (f * f6)));
    }

    public Matrix3f zero() {
        this.m22 = 0.0f;
        this.m21 = 0.0f;
        this.m20 = 0.0f;
        this.m12 = 0.0f;
        this.m11 = 0.0f;
        this.m10 = 0.0f;
        this.m02 = 0.0f;
        this.m01 = 0.0f;
        this.m00 = 0.0f;
        return this;
    }

    public Matrix3f transpose() {
        return transposeLocal();
    }

    public Matrix3f transposeNew() {
        return new Matrix3f(this.m00, this.m10, this.m20, this.m01, this.m11, this.m21, this.m02, this.m12, this.m22);
    }

    public String toString() {
        return "Matrix3f\n[\n" + " " + this.m00 + "  " + this.m01 + "  " + this.m02 + " \n" + " " + this.m10 + "  " + this.m11 + "  " + this.m12 + " \n" + " " + this.m20 + "  " + this.m21 + "  " + this.m22 + " \n]";
    }

    public int hashCode() {
        return ((((((((((((((((1369 + Float.floatToIntBits(this.m00)) * 37) + Float.floatToIntBits(this.m01)) * 37) + Float.floatToIntBits(this.m02)) * 37) + Float.floatToIntBits(this.m10)) * 37) + Float.floatToIntBits(this.m11)) * 37) + Float.floatToIntBits(this.m12)) * 37) + Float.floatToIntBits(this.m20)) * 37) + Float.floatToIntBits(this.m21)) * 37) + Float.floatToIntBits(this.m22);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix3f) || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Matrix3f matrix3f = (Matrix3f) obj;
        return Float.compare(this.m00, matrix3f.m00) == 0 && Float.compare(this.m01, matrix3f.m01) == 0 && Float.compare(this.m02, matrix3f.m02) == 0 && Float.compare(this.m10, matrix3f.m10) == 0 && Float.compare(this.m11, matrix3f.m11) == 0 && Float.compare(this.m12, matrix3f.m12) == 0 && Float.compare(this.m20, matrix3f.m20) == 0 && Float.compare(this.m21, matrix3f.m21) == 0 && Float.compare(this.m22, matrix3f.m22) == 0;
    }

    public void fromStartEndVectors(Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3 = new Vector3f();
        vector3f.cross(vector3f2, vector3f3);
        float dot = vector3f.dot(vector3f2);
        if ((dot < 0.0f ? -dot : dot) > 0.9999f) {
            Vector3f vector3f4 = new Vector3f();
            Vector3f vector3f5 = new Vector3f();
            vector3f5.f23353x = ((double) vector3f.f23353x) > 0.0d ? vector3f.f23353x : -vector3f.f23353x;
            vector3f5.f23354y = ((double) vector3f.f23354y) > 0.0d ? vector3f.f23354y : -vector3f.f23354y;
            vector3f5.f23355z = ((double) vector3f.f23355z) > 0.0d ? vector3f.f23355z : -vector3f.f23355z;
            if (vector3f5.f23353x < vector3f5.f23354y) {
                if (vector3f5.f23353x < vector3f5.f23355z) {
                    vector3f5.f23353x = 1.0f;
                    vector3f5.f23355z = 0.0f;
                    vector3f5.f23354y = 0.0f;
                } else {
                    vector3f5.f23355z = 1.0f;
                    vector3f5.f23354y = 0.0f;
                    vector3f5.f23353x = 0.0f;
                }
            } else if (vector3f5.f23354y < vector3f5.f23355z) {
                vector3f5.f23354y = 1.0f;
                vector3f5.f23355z = 0.0f;
                vector3f5.f23353x = 0.0f;
            } else {
                vector3f5.f23355z = 1.0f;
                vector3f5.f23354y = 0.0f;
                vector3f5.f23353x = 0.0f;
            }
            vector3f4.f23353x = vector3f5.f23353x - vector3f.f23353x;
            vector3f4.f23354y = vector3f5.f23354y - vector3f.f23354y;
            vector3f4.f23355z = vector3f5.f23355z - vector3f.f23355z;
            vector3f3.f23353x = vector3f5.f23353x - vector3f2.f23353x;
            vector3f3.f23354y = vector3f5.f23354y - vector3f2.f23354y;
            vector3f3.f23355z = vector3f5.f23355z - vector3f2.f23355z;
            float dot2 = 2.0f / vector3f4.dot(vector3f4);
            float dot3 = 2.0f / vector3f3.dot(vector3f3);
            float dot4 = dot2 * dot3 * vector3f4.dot(vector3f3);
            for (int i = 0; i < 3; i++) {
                for (int i2 = 0; i2 < 3; i2++) {
                    set(i, i2, ((((-dot2) * vector3f4.get(i)) * vector3f4.get(i2)) - ((vector3f3.get(i) * dot3) * vector3f3.get(i2))) + (vector3f3.get(i) * dot4 * vector3f4.get(i2)));
                }
                set(i, i, get(i, i) + 1.0f);
            }
            return;
        }
        float f = 1.0f / (dot + 1.0f);
        float f2 = vector3f3.f23353x * f;
        float f3 = vector3f3.f23355z * f;
        float f4 = vector3f3.f23354y * f2;
        float f5 = vector3f3.f23355z * f2;
        float f6 = vector3f3.f23354y * f3;
        set(0, 0, (f2 * vector3f3.f23353x) + dot);
        set(0, 1, f4 - vector3f3.f23355z);
        set(0, 2, vector3f3.f23354y + f5);
        set(1, 0, f4 + vector3f3.f23355z);
        set(1, 1, (f * vector3f3.f23354y * vector3f3.f23354y) + dot);
        set(1, 2, f6 - vector3f3.f23353x);
        set(2, 0, f5 - vector3f3.f23354y);
        set(2, 1, f6 + vector3f3.f23353x);
        set(2, 2, dot + (f3 * vector3f3.f23355z));
    }

    public void scale(Vector3f vector3f) {
        this.m00 *= vector3f.f23353x;
        this.m10 *= vector3f.f23353x;
        this.m20 *= vector3f.f23353x;
        this.m01 *= vector3f.f23354y;
        this.m11 *= vector3f.f23354y;
        this.m21 *= vector3f.f23354y;
        this.m02 *= vector3f.f23355z;
        this.m12 *= vector3f.f23355z;
        this.m22 *= vector3f.f23355z;
    }

    /* renamed from: a */
    static boolean m16717a(Matrix3f matrix3f) {
        if (((double) Math.abs(matrix3f.m00 - 1.0f)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m11 - 1.0f)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m22 - 1.0f)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m01)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m02)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m10)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m12)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m20)) <= 1.0E-4d && ((double) Math.abs(matrix3f.m21)) <= 1.0E-4d) {
            return true;
        }
        return false;
    }

    public Matrix3f clone() {
        try {
            return (Matrix3f) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
