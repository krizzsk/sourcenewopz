package com.didi.hawaii.p118ar.utils;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.logging.Logger;

/* renamed from: com.didi.hawaii.ar.utils.Quaternion */
public final class Quaternion {
    public static final Quaternion DIRECTION_Z = new Quaternion();
    public static final Quaternion IDENTITY = new Quaternion();
    public static final Quaternion ZERO = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a */
    static final long f23330a = 1;

    /* renamed from: b */
    private static final Logger f23331b = Logger.getLogger(Quaternion.class.getName());

    /* renamed from: w */
    protected float f23332w;

    /* renamed from: x */
    protected float f23333x;

    /* renamed from: y */
    protected float f23334y;

    /* renamed from: z */
    protected float f23335z;

    static {
        DIRECTION_Z.fromAxes(Vector3f.UNIT_X, Vector3f.UNIT_Y, Vector3f.UNIT_Z);
    }

    public Quaternion() {
        this.f23333x = 0.0f;
        this.f23334y = 0.0f;
        this.f23335z = 0.0f;
        this.f23332w = 1.0f;
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        this.f23333x = f;
        this.f23334y = f2;
        this.f23335z = f3;
        this.f23332w = f4;
    }

    public float getX() {
        return this.f23333x;
    }

    public float getY() {
        return this.f23334y;
    }

    public float getZ() {
        return this.f23335z;
    }

    public float getW() {
        return this.f23332w;
    }

    public Quaternion set(float f, float f2, float f3, float f4) {
        this.f23333x = f;
        this.f23334y = f2;
        this.f23335z = f3;
        this.f23332w = f4;
        return this;
    }

    public Quaternion set(Quaternion quaternion) {
        this.f23333x = quaternion.f23333x;
        this.f23334y = quaternion.f23334y;
        this.f23335z = quaternion.f23335z;
        this.f23332w = quaternion.f23332w;
        return this;
    }

    public Quaternion(float[] fArr) {
        fromAngles(fArr);
    }

    public Quaternion(Quaternion quaternion, Quaternion quaternion2, float f) {
        slerp(quaternion, quaternion2, f);
    }

    public Quaternion(Quaternion quaternion) {
        this.f23333x = quaternion.f23333x;
        this.f23334y = quaternion.f23334y;
        this.f23335z = quaternion.f23335z;
        this.f23332w = quaternion.f23332w;
    }

    public void loadIdentity() {
        this.f23335z = 0.0f;
        this.f23334y = 0.0f;
        this.f23333x = 0.0f;
        this.f23332w = 1.0f;
    }

    public boolean isIdentity() {
        return this.f23333x == 0.0f && this.f23334y == 0.0f && this.f23335z == 0.0f && this.f23332w == 1.0f;
    }

    public Quaternion fromAngles(float[] fArr) {
        if (fArr.length == 3) {
            return fromAngles(fArr[0], fArr[1], fArr[2]);
        }
        throw new IllegalArgumentException("Angles array must have three elements");
    }

    public Quaternion fromAngles(float f, float f2, float f3) {
        float f4 = f3 * 0.5f;
        float sin = FastMath.sin(f4);
        float cos = FastMath.cos(f4);
        float f5 = f2 * 0.5f;
        float sin2 = FastMath.sin(f5);
        float cos2 = FastMath.cos(f5);
        float f6 = f * 0.5f;
        float sin3 = FastMath.sin(f6);
        float cos3 = FastMath.cos(f6);
        float f7 = cos2 * cos;
        float f8 = sin2 * sin;
        float f9 = cos2 * sin;
        float f10 = sin2 * cos;
        this.f23332w = (f7 * cos3) - (f8 * sin3);
        this.f23333x = (f7 * sin3) + (f8 * cos3);
        this.f23334y = (f10 * cos3) + (f9 * sin3);
        this.f23335z = (f9 * cos3) - (f10 * sin3);
        normalize();
        return this;
    }

    public float[] toAngles(float[] fArr) {
        float[] fArr2 = fArr;
        if (fArr2 == null) {
            fArr2 = new float[3];
        } else if (fArr2.length != 3) {
            throw new IllegalArgumentException("Angles array must have three elements");
        }
        float f = this.f23332w;
        float f2 = f * f;
        float f3 = this.f23333x;
        float f4 = f3 * f3;
        float f5 = this.f23334y;
        float f6 = f5 * f5;
        float f7 = this.f23335z;
        float f8 = f7 * f7;
        float f9 = f4 + f6 + f8 + f2;
        float f10 = (f3 * f5) + (f7 * f);
        double d = (double) f10;
        float f11 = f6;
        float f12 = f7;
        double d2 = (double) f9;
        if (d > 0.499d * d2) {
            fArr2[1] = FastMath.atan2(f3, f) * 2.0f;
            fArr2[2] = 1.5707964f;
            fArr2[0] = 0.0f;
        } else if (d < d2 * -0.499d) {
            fArr2[1] = FastMath.atan2(f3, f) * -2.0f;
            fArr2[2] = -1.5707964f;
            fArr2[0] = 0.0f;
        } else {
            fArr2[1] = FastMath.atan2(((f5 * 2.0f) * f) - ((f3 * 2.0f) * f12), ((f4 - f11) - f8) + f2);
            fArr2[2] = FastMath.asin((f10 * 2.0f) / f9);
            fArr2[0] = FastMath.atan2(((this.f23333x * 2.0f) * this.f23332w) - ((this.f23334y * 2.0f) * this.f23335z), (((-f4) + f11) - f8) + f2);
        }
        return fArr2;
    }

    public Quaternion fromRotationMatrix(Matrix3f matrix3f) {
        return fromRotationMatrix(matrix3f.m00, matrix3f.m01, matrix3f.m02, matrix3f.m10, matrix3f.m11, matrix3f.m12, matrix3f.m20, matrix3f.m21, matrix3f.m22);
    }

    public Quaternion fromRotationMatrix(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f + f5 + f9;
        if (f10 >= 0.0f) {
            float sqrt = FastMath.sqrt(f10 + 1.0f);
            this.f23332w = sqrt * 0.5f;
            float f11 = 0.5f / sqrt;
            this.f23333x = (f8 - f6) * f11;
            this.f23334y = (f3 - f7) * f11;
            this.f23335z = (f4 - f2) * f11;
        } else if (f > f5 && f > f9) {
            float sqrt2 = FastMath.sqrt(((f + 1.0f) - f5) - f9);
            this.f23333x = sqrt2 * 0.5f;
            float f12 = 0.5f / sqrt2;
            this.f23334y = (f4 + f2) * f12;
            this.f23335z = (f3 + f7) * f12;
            this.f23332w = (f8 - f6) * f12;
        } else if (f5 > f9) {
            float sqrt3 = FastMath.sqrt(((f5 + 1.0f) - f) - f9);
            this.f23334y = sqrt3 * 0.5f;
            float f13 = 0.5f / sqrt3;
            this.f23333x = (f4 + f2) * f13;
            this.f23335z = (f8 + f6) * f13;
            this.f23332w = (f3 - f7) * f13;
        } else {
            float sqrt4 = FastMath.sqrt(((f9 + 1.0f) - f) - f5);
            this.f23335z = sqrt4 * 0.5f;
            float f14 = 0.5f / sqrt4;
            this.f23333x = (f3 + f7) * f14;
            this.f23334y = (f8 + f6) * f14;
            this.f23332w = (f4 - f2) * f14;
        }
        return this;
    }

    public Matrix3f toRotationMatrix() {
        return toRotationMatrix(new Matrix3f());
    }

    public Matrix3f toRotationMatrix(Matrix3f matrix3f) {
        float norm = norm();
        float f = 2.0f;
        if (norm != 1.0f) {
            f = norm > 0.0f ? 2.0f / norm : 0.0f;
        }
        float f2 = this.f23333x;
        float f3 = f2 * f;
        float f4 = this.f23334y;
        float f5 = f4 * f;
        float f6 = this.f23335z;
        float f7 = f * f6;
        float f8 = f2 * f3;
        float f9 = f2 * f5;
        float f10 = f2 * f7;
        float f11 = this.f23332w;
        float f12 = f3 * f11;
        float f13 = f4 * f5;
        float f14 = f4 * f7;
        float f15 = f5 * f11;
        float f16 = f6 * f7;
        float f17 = f11 * f7;
        matrix3f.m00 = 1.0f - (f13 + f16);
        matrix3f.m01 = f9 - f17;
        matrix3f.m02 = f10 + f15;
        matrix3f.m10 = f9 + f17;
        matrix3f.m11 = 1.0f - (f16 + f8);
        matrix3f.m12 = f14 - f12;
        matrix3f.m20 = f10 - f15;
        matrix3f.m21 = f14 + f12;
        matrix3f.m22 = 1.0f - (f8 + f13);
        return matrix3f;
    }

    public Vector3f getRotationColumn(int i) {
        return getRotationColumn(i, (Vector3f) null);
    }

    public Vector3f getRotationColumn(int i, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        float norm = norm();
        if (norm != 1.0f) {
            norm = FastMath.invSqrt(norm);
        }
        float f = this.f23333x;
        float f2 = f * f * norm;
        float f3 = this.f23334y;
        float f4 = f * f3 * norm;
        float f5 = this.f23335z;
        float f6 = f * f5 * norm;
        float f7 = this.f23332w;
        float f8 = f * f7 * norm;
        float f9 = f3 * f3 * norm;
        float f10 = f3 * f5 * norm;
        float f11 = f3 * f7 * norm;
        float f12 = f5 * f5 * norm;
        float f13 = f5 * f7 * norm;
        if (i == 0) {
            vector3f.f23353x = 1.0f - ((f9 + f12) * 2.0f);
            vector3f.f23354y = (f4 + f13) * 2.0f;
            vector3f.f23355z = (f6 - f11) * 2.0f;
        } else if (i == 1) {
            vector3f.f23353x = (f4 - f13) * 2.0f;
            vector3f.f23354y = 1.0f - ((f2 + f12) * 2.0f);
            vector3f.f23355z = (f10 + f8) * 2.0f;
        } else if (i == 2) {
            vector3f.f23353x = (f6 + f11) * 2.0f;
            vector3f.f23354y = (f10 - f8) * 2.0f;
            vector3f.f23355z = 1.0f - ((f2 + f9) * 2.0f);
        } else {
            f23331b.warning("Invalid column index.");
            throw new IllegalArgumentException("Invalid column index. " + i);
        }
        return vector3f;
    }

    public Quaternion fromAngleAxis(float f, Vector3f vector3f) {
        fromAngleNormalAxis(f, vector3f.normalize());
        return this;
    }

    public Quaternion fromAngleNormalAxis(float f, Vector3f vector3f) {
        if (vector3f.f23353x == 0.0f && vector3f.f23354y == 0.0f && vector3f.f23355z == 0.0f) {
            loadIdentity();
        } else {
            float f2 = f * 0.5f;
            float sin = FastMath.sin(f2);
            this.f23332w = FastMath.cos(f2);
            this.f23333x = vector3f.f23353x * sin;
            this.f23334y = vector3f.f23354y * sin;
            this.f23335z = sin * vector3f.f23355z;
        }
        return this;
    }

    public float toAngleAxis(Vector3f vector3f) {
        float f = this.f23333x;
        float f2 = this.f23334y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f23335z;
        float f5 = f3 + (f4 * f4);
        float f6 = 0.0f;
        if (f5 != 0.0f) {
            f6 = 2.0f * FastMath.acos(this.f23332w);
            if (vector3f != null) {
                float sqrt = 1.0f / FastMath.sqrt(f5);
                vector3f.f23353x = this.f23333x * sqrt;
                vector3f.f23354y = this.f23334y * sqrt;
                vector3f.f23355z = this.f23335z * sqrt;
            }
        } else if (vector3f != null) {
            vector3f.f23353x = 1.0f;
            vector3f.f23354y = 0.0f;
            vector3f.f23355z = 0.0f;
        }
        return f6;
    }

    public Quaternion slerp(Quaternion quaternion, Quaternion quaternion2, float f) {
        if (quaternion.f23333x == quaternion2.f23333x && quaternion.f23334y == quaternion2.f23334y && quaternion.f23335z == quaternion2.f23335z && quaternion.f23332w == quaternion2.f23332w) {
            set(quaternion);
            return this;
        }
        float f2 = quaternion.f23333x;
        float f3 = quaternion2.f23333x;
        float f4 = quaternion.f23334y;
        float f5 = quaternion2.f23334y;
        float f6 = (f2 * f3) + (f4 * f5);
        float f7 = quaternion.f23335z;
        float f8 = quaternion2.f23335z;
        float f9 = f6 + (f7 * f8);
        float f10 = quaternion.f23332w;
        float f11 = quaternion2.f23332w;
        float f12 = f9 + (f10 * f11);
        if (f12 < 0.0f) {
            quaternion2.f23333x = -f3;
            quaternion2.f23334y = -f5;
            quaternion2.f23335z = -f8;
            quaternion2.f23332w = -f11;
            f12 = -f12;
        }
        float f13 = 1.0f - f;
        if (1.0f - f12 > 0.1f) {
            float acos = FastMath.acos(f12);
            float sin = 1.0f / FastMath.sin(acos);
            f13 = FastMath.sin(f13 * acos) * sin;
            f = FastMath.sin(f * acos) * sin;
        }
        this.f23333x = (quaternion.f23333x * f13) + (quaternion2.f23333x * f);
        this.f23334y = (quaternion.f23334y * f13) + (quaternion2.f23334y * f);
        this.f23335z = (quaternion.f23335z * f13) + (quaternion2.f23335z * f);
        this.f23332w = (f13 * quaternion.f23332w) + (f * quaternion2.f23332w);
        return this;
    }

    public void slerp(Quaternion quaternion, float f) {
        if (this.f23333x != quaternion.f23333x || this.f23334y != quaternion.f23334y || this.f23335z != quaternion.f23335z || this.f23332w != quaternion.f23332w) {
            float f2 = this.f23333x;
            float f3 = quaternion.f23333x;
            float f4 = this.f23334y;
            float f5 = quaternion.f23334y;
            float f6 = (f2 * f3) + (f4 * f5);
            float f7 = this.f23335z;
            float f8 = quaternion.f23335z;
            float f9 = f6 + (f7 * f8);
            float f10 = this.f23332w;
            float f11 = quaternion.f23332w;
            float f12 = f9 + (f10 * f11);
            if (f12 < 0.0f) {
                quaternion.f23333x = -f3;
                quaternion.f23334y = -f5;
                quaternion.f23335z = -f8;
                quaternion.f23332w = -f11;
                f12 = -f12;
            }
            float f13 = 1.0f - f;
            if (1.0f - f12 > 0.1f) {
                float acos = FastMath.acos(f12);
                float sin = 1.0f / FastMath.sin(acos);
                f13 = FastMath.sin(f13 * acos) * sin;
                f = FastMath.sin(f * acos) * sin;
            }
            this.f23333x = (this.f23333x * f13) + (quaternion.f23333x * f);
            this.f23334y = (this.f23334y * f13) + (quaternion.f23334y * f);
            this.f23335z = (this.f23335z * f13) + (quaternion.f23335z * f);
            this.f23332w = (f13 * this.f23332w) + (f * quaternion.f23332w);
        }
    }

    public void nlerp(Quaternion quaternion, float f) {
        float f2 = 1.0f - f;
        if (dot(quaternion) < 0.0f) {
            this.f23333x = (this.f23333x * f2) - (quaternion.f23333x * f);
            this.f23334y = (this.f23334y * f2) - (quaternion.f23334y * f);
            this.f23335z = (this.f23335z * f2) - (quaternion.f23335z * f);
            this.f23332w = (f2 * this.f23332w) - (f * quaternion.f23332w);
        } else {
            this.f23333x = (this.f23333x * f2) + (quaternion.f23333x * f);
            this.f23334y = (this.f23334y * f2) + (quaternion.f23334y * f);
            this.f23335z = (this.f23335z * f2) + (quaternion.f23335z * f);
            this.f23332w = (f2 * this.f23332w) + (f * quaternion.f23332w);
        }
        normalizeLocal();
    }

    public Quaternion add(Quaternion quaternion) {
        return new Quaternion(this.f23333x + quaternion.f23333x, this.f23334y + quaternion.f23334y, this.f23335z + quaternion.f23335z, this.f23332w + quaternion.f23332w);
    }

    public Quaternion addLocal(Quaternion quaternion) {
        this.f23333x += quaternion.f23333x;
        this.f23334y += quaternion.f23334y;
        this.f23335z += quaternion.f23335z;
        this.f23332w += quaternion.f23332w;
        return this;
    }

    public Quaternion subtract(Quaternion quaternion) {
        return new Quaternion(this.f23333x - quaternion.f23333x, this.f23334y - quaternion.f23334y, this.f23335z - quaternion.f23335z, this.f23332w - quaternion.f23332w);
    }

    public Quaternion subtractLocal(Quaternion quaternion) {
        this.f23333x -= quaternion.f23333x;
        this.f23334y -= quaternion.f23334y;
        this.f23335z -= quaternion.f23335z;
        this.f23332w -= quaternion.f23332w;
        return this;
    }

    public Quaternion mult(Quaternion quaternion) {
        return mult(quaternion, (Quaternion) null);
    }

    public Quaternion mult(Quaternion quaternion, Quaternion quaternion2) {
        if (quaternion2 == null) {
            quaternion2 = new Quaternion();
        }
        float f = quaternion.f23332w;
        float f2 = quaternion.f23333x;
        float f3 = quaternion.f23334y;
        float f4 = quaternion.f23335z;
        float f5 = this.f23334y;
        float f6 = (this.f23333x * f) + (f5 * f4);
        float f7 = this.f23335z;
        float f8 = this.f23332w;
        quaternion2.f23333x = (f6 - (f7 * f3)) + (f8 * f2);
        float f9 = this.f23333x;
        quaternion2.f23334y = ((-f9) * f4) + (f5 * f) + (f7 * f2) + (f8 * f3);
        float f10 = this.f23334y;
        quaternion2.f23335z = ((f9 * f3) - (f10 * f2)) + (f7 * f) + (f8 * f4);
        quaternion2.f23332w = ((((-f9) * f2) - (f10 * f3)) - (this.f23335z * f4)) + (f8 * f);
        return quaternion2;
    }

    public void apply(Matrix3f matrix3f) {
        float f = this.f23333x;
        float f2 = this.f23334y;
        float f3 = this.f23335z;
        float f4 = this.f23332w;
        fromRotationMatrix(matrix3f);
        float f5 = this.f23333x;
        float f6 = this.f23334y;
        float f7 = this.f23335z;
        float f8 = this.f23332w;
        this.f23333x = (((f * f8) + (f2 * f7)) - (f3 * f6)) + (f4 * f5);
        float f9 = -f;
        this.f23334y = (f9 * f7) + (f2 * f8) + (f3 * f5) + (f4 * f6);
        this.f23335z = ((f * f6) - (f2 * f5)) + (f3 * f8) + (f4 * f7);
        this.f23332w = (((f9 * f5) - (f2 * f6)) - (f3 * f7)) + (f4 * f8);
    }

    public Quaternion fromAxes(Vector3f[] vector3fArr) {
        if (vector3fArr.length == 3) {
            return fromAxes(vector3fArr[0], vector3fArr[1], vector3fArr[2]);
        }
        throw new IllegalArgumentException("Axis array must have three elements");
    }

    public Quaternion fromAxes(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        return fromRotationMatrix(vector3f.f23353x, vector3f2.f23353x, vector3f3.f23353x, vector3f.f23354y, vector3f2.f23354y, vector3f3.f23354y, vector3f.f23355z, vector3f2.f23355z, vector3f3.f23355z);
    }

    public void toAxes(Vector3f[] vector3fArr) {
        Matrix3f rotationMatrix = toRotationMatrix();
        vector3fArr[0] = rotationMatrix.getColumn(0, vector3fArr[0]);
        vector3fArr[1] = rotationMatrix.getColumn(1, vector3fArr[1]);
        vector3fArr[2] = rotationMatrix.getColumn(2, vector3fArr[2]);
    }

    public Vector3f mult(Vector3f vector3f) {
        return mult(vector3f, (Vector3f) null);
    }

    public Vector3f multLocal(Vector3f vector3f) {
        float f = this.f23332w;
        float f2 = (((f * f) * vector3f.f23353x) + (((this.f23334y * 2.0f) * this.f23332w) * vector3f.f23355z)) - (((this.f23335z * 2.0f) * this.f23332w) * vector3f.f23354y);
        float f3 = this.f23333x;
        float f4 = f2 + (f3 * f3 * vector3f.f23353x) + (this.f23334y * 2.0f * this.f23333x * vector3f.f23354y) + (this.f23335z * 2.0f * this.f23333x * vector3f.f23355z);
        float f5 = this.f23335z;
        float f6 = f4 - ((f5 * f5) * vector3f.f23353x);
        float f7 = this.f23334y;
        float f8 = f6 - ((f7 * f7) * vector3f.f23353x);
        float f9 = this.f23333x * 2.0f * this.f23334y * vector3f.f23353x;
        float f10 = this.f23334y;
        float f11 = f9 + (f10 * f10 * vector3f.f23354y) + (this.f23335z * 2.0f * this.f23334y * vector3f.f23355z) + (this.f23332w * 2.0f * this.f23335z * vector3f.f23353x);
        float f12 = this.f23335z;
        float f13 = f11 - ((f12 * f12) * vector3f.f23354y);
        float f14 = this.f23332w;
        float f15 = (f13 + ((f14 * f14) * vector3f.f23354y)) - (((this.f23333x * 2.0f) * this.f23332w) * vector3f.f23355z);
        float f16 = this.f23333x;
        float f17 = f15 - ((f16 * f16) * vector3f.f23354y);
        float f18 = (this.f23333x * 2.0f * this.f23335z * vector3f.f23353x) + (this.f23334y * 2.0f * this.f23335z * vector3f.f23354y);
        float f19 = this.f23335z;
        float f20 = (f18 + ((f19 * f19) * vector3f.f23355z)) - (((this.f23332w * 2.0f) * this.f23334y) * vector3f.f23353x);
        float f21 = this.f23334y;
        float f22 = this.f23333x;
        float f23 = ((f20 - ((f21 * f21) * vector3f.f23355z)) + (((this.f23332w * 2.0f) * this.f23333x) * vector3f.f23354y)) - ((f22 * f22) * vector3f.f23355z);
        float f24 = this.f23332w;
        vector3f.f23355z = f23 + (f24 * f24 * vector3f.f23355z);
        vector3f.f23353x = f8;
        vector3f.f23354y = f17;
        return vector3f;
    }

    public Quaternion multLocal(Quaternion quaternion) {
        float f = this.f23333x;
        float f2 = quaternion.f23332w;
        float f3 = this.f23334y;
        float f4 = quaternion.f23335z;
        float f5 = this.f23335z;
        float f6 = quaternion.f23334y;
        float f7 = this.f23332w;
        float f8 = quaternion.f23333x;
        this.f23332w = ((((-f) * f8) - (f3 * f6)) - (f5 * f4)) + (f7 * f2);
        this.f23333x = (((f * f2) + (f3 * f4)) - (f5 * f6)) + (f7 * f8);
        this.f23334y = ((-f) * f4) + (f3 * f2) + (f5 * f8) + (f7 * f6);
        this.f23335z = ((f * f6) - (f3 * f8)) + (f5 * f2) + (f7 * f4);
        return this;
    }

    public Quaternion multLocal(float f, float f2, float f3, float f4) {
        float f5 = this.f23333x;
        float f6 = this.f23334y;
        float f7 = this.f23335z;
        float f8 = this.f23332w;
        this.f23332w = ((((-f5) * f) - (f6 * f2)) - (f7 * f3)) + (f8 * f4);
        this.f23333x = (((f5 * f4) + (f6 * f3)) - (f7 * f2)) + (f8 * f);
        this.f23334y = ((-f5) * f3) + (f6 * f4) + (f7 * f) + (f8 * f2);
        this.f23335z = ((f5 * f2) - (f6 * f)) + (f7 * f4) + (f8 * f3);
        return this;
    }

    public Vector3f mult(Vector3f vector3f, Vector3f vector3f2) {
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        if (vector3f.f23353x == 0.0f && vector3f.f23354y == 0.0f && vector3f.f23355z == 0.0f) {
            vector3f2.set(0.0f, 0.0f, 0.0f);
        } else {
            float f = vector3f.f23353x;
            float f2 = vector3f.f23354y;
            float f3 = vector3f.f23355z;
            float f4 = this.f23332w;
            float f5 = this.f23334y;
            float f6 = (f4 * f4 * f) + (f5 * 2.0f * f4 * f3);
            float f7 = this.f23335z;
            float f8 = this.f23333x;
            vector3f2.f23353x = (((((f6 - (((f7 * 2.0f) * f4) * f2)) + ((f8 * f8) * f)) + (((f5 * 2.0f) * f8) * f2)) + (((f7 * 2.0f) * f8) * f3)) - ((f7 * f7) * f)) - ((f5 * f5) * f);
            float f9 = this.f23333x;
            float f10 = this.f23334y;
            float f11 = (f9 * 2.0f * f10 * f) + (f10 * f10 * f2);
            float f12 = this.f23335z;
            float f13 = this.f23332w;
            vector3f2.f23354y = (((((f11 + (((f12 * 2.0f) * f10) * f3)) + (((f13 * 2.0f) * f12) * f)) - ((f12 * f12) * f2)) + ((f13 * f13) * f2)) - (((f9 * 2.0f) * f13) * f3)) - ((f9 * f9) * f2);
            float f14 = this.f23333x;
            float f15 = this.f23335z;
            float f16 = this.f23334y;
            float f17 = (f14 * 2.0f * f15 * f) + (f16 * 2.0f * f15 * f2) + (f15 * f15 * f3);
            float f18 = this.f23332w;
            vector3f2.f23355z = ((((f17 - (((f18 * 2.0f) * f16) * f)) - ((f16 * f16) * f3)) + (((2.0f * f18) * f14) * f2)) - ((f14 * f14) * f3)) + (f18 * f18 * f3);
        }
        return vector3f2;
    }

    public Quaternion mult(float f) {
        return new Quaternion(this.f23333x * f, this.f23334y * f, this.f23335z * f, f * this.f23332w);
    }

    public Quaternion multLocal(float f) {
        this.f23332w *= f;
        this.f23333x *= f;
        this.f23334y *= f;
        this.f23335z *= f;
        return this;
    }

    public float dot(Quaternion quaternion) {
        return (this.f23332w * quaternion.f23332w) + (this.f23333x * quaternion.f23333x) + (this.f23334y * quaternion.f23334y) + (this.f23335z * quaternion.f23335z);
    }

    public float norm() {
        float f = this.f23332w;
        float f2 = this.f23333x;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f23334y;
        float f5 = f3 + (f4 * f4);
        float f6 = this.f23335z;
        return f5 + (f6 * f6);
    }

    @Deprecated
    public void normalize() {
        float invSqrt = FastMath.invSqrt(norm());
        this.f23333x *= invSqrt;
        this.f23334y *= invSqrt;
        this.f23335z *= invSqrt;
        this.f23332w *= invSqrt;
    }

    public void normalizeLocal() {
        float invSqrt = FastMath.invSqrt(norm());
        this.f23333x *= invSqrt;
        this.f23334y *= invSqrt;
        this.f23335z *= invSqrt;
        this.f23332w *= invSqrt;
    }

    public Quaternion inverse() {
        float norm = norm();
        if (((double) norm) <= 0.0d) {
            return null;
        }
        float f = 1.0f / norm;
        return new Quaternion((-this.f23333x) * f, (-this.f23334y) * f, (-this.f23335z) * f, this.f23332w * f);
    }

    public Quaternion inverseLocal() {
        float norm = norm();
        if (((double) norm) > 0.0d) {
            float f = 1.0f / norm;
            float f2 = -f;
            this.f23333x *= f2;
            this.f23334y *= f2;
            this.f23335z *= f2;
            this.f23332w *= f;
        }
        return this;
    }

    public void negate() {
        this.f23333x *= -1.0f;
        this.f23334y *= -1.0f;
        this.f23335z *= -1.0f;
        this.f23332w *= -1.0f;
    }

    public String toString() {
        return "(" + this.f23333x + ", " + this.f23334y + ", " + this.f23335z + ", " + this.f23332w + ")";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Quaternion)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Quaternion quaternion = (Quaternion) obj;
        return Float.compare(this.f23333x, quaternion.f23333x) == 0 && Float.compare(this.f23334y, quaternion.f23334y) == 0 && Float.compare(this.f23335z, quaternion.f23335z) == 0 && Float.compare(this.f23332w, quaternion.f23332w) == 0;
    }

    public int hashCode() {
        return ((((((1369 + Float.floatToIntBits(this.f23333x)) * 37) + Float.floatToIntBits(this.f23334y)) * 37) + Float.floatToIntBits(this.f23335z)) * 37) + Float.floatToIntBits(this.f23332w);
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.f23333x = objectInput.readFloat();
        this.f23334y = objectInput.readFloat();
        this.f23335z = objectInput.readFloat();
        this.f23332w = objectInput.readFloat();
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeFloat(this.f23333x);
        objectOutput.writeFloat(this.f23334y);
        objectOutput.writeFloat(this.f23335z);
        objectOutput.writeFloat(this.f23332w);
    }

    public Quaternion opposite() {
        return opposite((Quaternion) null);
    }

    public Quaternion opposite(Quaternion quaternion) {
        if (quaternion == null) {
            quaternion = new Quaternion();
        }
        Vector3f vector3f = new Vector3f();
        quaternion.fromAngleAxis(toAngleAxis(vector3f) + 3.1415927f, vector3f);
        return quaternion;
    }

    public Quaternion oppositeLocal() {
        return opposite(this);
    }

    public Quaternion clone() {
        try {
            return (Quaternion) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
