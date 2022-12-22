package com.didi.hawaii.p118ar.utils;

import java.util.logging.Logger;

/* renamed from: com.didi.hawaii.ar.utils.Vector3f */
public final class Vector3f {
    public static final Vector3f NAN = new Vector3f(Float.NaN, Float.NaN, Float.NaN);
    public static final Vector3f NEGATIVE_INFINITY = new Vector3f(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    public static final Vector3f POSITIVE_INFINITY = new Vector3f(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    public static final Vector3f UNIT_X = new Vector3f(1.0f, 0.0f, 0.0f);
    public static final Vector3f UNIT_XYZ = new Vector3f(1.0f, 1.0f, 1.0f);
    public static final Vector3f UNIT_Y = new Vector3f(0.0f, 1.0f, 0.0f);
    public static final Vector3f UNIT_Z = new Vector3f(0.0f, 0.0f, 1.0f);
    public static final Vector3f ZERO = new Vector3f(0.0f, 0.0f, 0.0f);

    /* renamed from: a */
    static final long f23351a = 1;

    /* renamed from: b */
    private static final Logger f23352b = Logger.getLogger(Vector3f.class.getName());

    /* renamed from: x */
    public float f23353x;

    /* renamed from: y */
    public float f23354y;

    /* renamed from: z */
    public float f23355z;

    public Vector3f() {
        this.f23355z = 0.0f;
        this.f23354y = 0.0f;
        this.f23353x = 0.0f;
    }

    public Vector3f(float f, float f2, float f3) {
        this.f23353x = f;
        this.f23354y = f2;
        this.f23355z = f3;
    }

    public Vector3f(Vector3f vector3f) {
        set(vector3f);
    }

    public Vector3f set(float f, float f2, float f3) {
        this.f23353x = f;
        this.f23354y = f2;
        this.f23355z = f3;
        return this;
    }

    public Vector3f set(Vector3f vector3f) {
        this.f23353x = vector3f.f23353x;
        this.f23354y = vector3f.f23354y;
        this.f23355z = vector3f.f23355z;
        return this;
    }

    public Vector3f add(Vector3f vector3f) {
        if (vector3f != null) {
            return new Vector3f(this.f23353x + vector3f.f23353x, this.f23354y + vector3f.f23354y, this.f23355z + vector3f.f23355z);
        }
        f23352b.warning("Provided vector is null, null returned.");
        return null;
    }

    public Vector3f add(Vector3f vector3f, Vector3f vector3f2) {
        vector3f2.f23353x = this.f23353x + vector3f.f23353x;
        vector3f2.f23354y = this.f23354y + vector3f.f23354y;
        vector3f2.f23355z = this.f23355z + vector3f.f23355z;
        return vector3f2;
    }

    public Vector3f addLocal(Vector3f vector3f) {
        if (vector3f == null) {
            f23352b.warning("Provided vector is null, null returned.");
            return null;
        }
        this.f23353x += vector3f.f23353x;
        this.f23354y += vector3f.f23354y;
        this.f23355z += vector3f.f23355z;
        return this;
    }

    public Vector3f add(float f, float f2, float f3) {
        return new Vector3f(this.f23353x + f, this.f23354y + f2, this.f23355z + f3);
    }

    public Vector3f addLocal(float f, float f2, float f3) {
        this.f23353x += f;
        this.f23354y += f2;
        this.f23355z += f3;
        return this;
    }

    public Vector3f scaleAdd(float f, Vector3f vector3f) {
        this.f23353x = (this.f23353x * f) + vector3f.f23353x;
        this.f23354y = (this.f23354y * f) + vector3f.f23354y;
        this.f23355z = (this.f23355z * f) + vector3f.f23355z;
        return this;
    }

    public Vector3f scaleAdd(float f, Vector3f vector3f, Vector3f vector3f2) {
        this.f23353x = (vector3f.f23353x * f) + vector3f2.f23353x;
        this.f23354y = (vector3f.f23354y * f) + vector3f2.f23354y;
        this.f23355z = (vector3f.f23355z * f) + vector3f2.f23355z;
        return this;
    }

    public float dot(Vector3f vector3f) {
        if (vector3f != null) {
            return (this.f23353x * vector3f.f23353x) + (this.f23354y * vector3f.f23354y) + (this.f23355z * vector3f.f23355z);
        }
        f23352b.warning("Provided vector is null, 0 returned.");
        return 0.0f;
    }

    public Vector3f cross(Vector3f vector3f) {
        return cross(vector3f, (Vector3f) null);
    }

    public Vector3f cross(Vector3f vector3f, Vector3f vector3f2) {
        return cross(vector3f.f23353x, vector3f.f23354y, vector3f.f23355z, vector3f2);
    }

    public Vector3f cross(float f, float f2, float f3, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        float f4 = this.f23354y;
        float f5 = this.f23355z;
        float f6 = this.f23353x;
        vector3f.set((f4 * f3) - (f5 * f2), (f5 * f) - (f3 * f6), (f6 * f2) - (f4 * f));
        return vector3f;
    }

    public Vector3f crossLocal(Vector3f vector3f) {
        return crossLocal(vector3f.f23353x, vector3f.f23354y, vector3f.f23355z);
    }

    public Vector3f crossLocal(float f, float f2, float f3) {
        float f4 = this.f23354y;
        float f5 = this.f23355z;
        float f6 = this.f23353x;
        this.f23355z = (f6 * f2) - (f4 * f);
        this.f23353x = (f4 * f3) - (f5 * f2);
        this.f23354y = (f5 * f) - (f3 * f6);
        return this;
    }

    public Vector3f project(Vector3f vector3f) {
        return new Vector3f(vector3f).normalizeLocal().multLocal(dot(vector3f) / vector3f.lengthSquared());
    }

    public boolean isUnitVector() {
        float length = length();
        return 0.99f < length && length < 1.01f;
    }

    public float length() {
        return FastMath.sqrt(lengthSquared());
    }

    public float lengthSquared() {
        float f = this.f23353x;
        float f2 = this.f23354y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f23355z;
        return f3 + (f4 * f4);
    }

    public float distanceSquared(Vector3f vector3f) {
        double d = (double) (this.f23353x - vector3f.f23353x);
        double d2 = (double) (this.f23354y - vector3f.f23354y);
        double d3 = (double) (this.f23355z - vector3f.f23355z);
        return (float) ((d * d) + (d2 * d2) + (d3 * d3));
    }

    public float distance(Vector3f vector3f) {
        return FastMath.sqrt(distanceSquared(vector3f));
    }

    public Vector3f mult(float f) {
        return new Vector3f(this.f23353x * f, this.f23354y * f, this.f23355z * f);
    }

    public Vector3f mult(float f, Vector3f vector3f) {
        if (vector3f == null) {
            vector3f = new Vector3f();
        }
        vector3f.f23353x = this.f23353x * f;
        vector3f.f23354y = this.f23354y * f;
        vector3f.f23355z = this.f23355z * f;
        return vector3f;
    }

    public Vector3f multLocal(float f) {
        this.f23353x *= f;
        this.f23354y *= f;
        this.f23355z *= f;
        return this;
    }

    public Vector3f multLocal(Vector3f vector3f) {
        if (vector3f == null) {
            f23352b.warning("Provided vector is null, null returned.");
            return null;
        }
        this.f23353x *= vector3f.f23353x;
        this.f23354y *= vector3f.f23354y;
        this.f23355z *= vector3f.f23355z;
        return this;
    }

    public Vector3f multLocal(float f, float f2, float f3) {
        this.f23353x *= f;
        this.f23354y *= f2;
        this.f23355z *= f3;
        return this;
    }

    public Vector3f mult(Vector3f vector3f) {
        if (vector3f != null) {
            return mult(vector3f, (Vector3f) null);
        }
        f23352b.warning("Provided vector is null, null returned.");
        return null;
    }

    public Vector3f mult(Vector3f vector3f, Vector3f vector3f2) {
        if (vector3f == null) {
            f23352b.warning("Provided vector is null, null returned.");
            return null;
        }
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        return vector3f2.set(this.f23353x * vector3f.f23353x, this.f23354y * vector3f.f23354y, this.f23355z * vector3f.f23355z);
    }

    public Vector3f divide(float f) {
        float f2 = 1.0f / f;
        return new Vector3f(this.f23353x * f2, this.f23354y * f2, this.f23355z * f2);
    }

    public Vector3f divideLocal(float f) {
        float f2 = 1.0f / f;
        this.f23353x *= f2;
        this.f23354y *= f2;
        this.f23355z *= f2;
        return this;
    }

    public Vector3f divide(Vector3f vector3f) {
        return new Vector3f(this.f23353x / vector3f.f23353x, this.f23354y / vector3f.f23354y, this.f23355z / vector3f.f23355z);
    }

    public Vector3f divideLocal(Vector3f vector3f) {
        this.f23353x /= vector3f.f23353x;
        this.f23354y /= vector3f.f23354y;
        this.f23355z /= vector3f.f23355z;
        return this;
    }

    public Vector3f negate() {
        return new Vector3f(-this.f23353x, -this.f23354y, -this.f23355z);
    }

    public Vector3f negateLocal() {
        this.f23353x = -this.f23353x;
        this.f23354y = -this.f23354y;
        this.f23355z = -this.f23355z;
        return this;
    }

    public Vector3f subtract(Vector3f vector3f) {
        return new Vector3f(this.f23353x - vector3f.f23353x, this.f23354y - vector3f.f23354y, this.f23355z - vector3f.f23355z);
    }

    public Vector3f subtractLocal(Vector3f vector3f) {
        if (vector3f == null) {
            f23352b.warning("Provided vector is null, null returned.");
            return null;
        }
        this.f23353x -= vector3f.f23353x;
        this.f23354y -= vector3f.f23354y;
        this.f23355z -= vector3f.f23355z;
        return this;
    }

    public Vector3f subtract(Vector3f vector3f, Vector3f vector3f2) {
        if (vector3f2 == null) {
            vector3f2 = new Vector3f();
        }
        vector3f2.f23353x = this.f23353x - vector3f.f23353x;
        vector3f2.f23354y = this.f23354y - vector3f.f23354y;
        vector3f2.f23355z = this.f23355z - vector3f.f23355z;
        return vector3f2;
    }

    public Vector3f subtract(float f, float f2, float f3) {
        return new Vector3f(this.f23353x - f, this.f23354y - f2, this.f23355z - f3);
    }

    public Vector3f subtractLocal(float f, float f2, float f3) {
        this.f23353x -= f;
        this.f23354y -= f2;
        this.f23355z -= f3;
        return this;
    }

    public Vector3f normalize() {
        float f = this.f23353x;
        float f2 = this.f23354y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f23355z;
        float f5 = f3 + (f4 * f4);
        if (f5 == 1.0f || f5 == 0.0f) {
            return clone();
        }
        float sqrt = 1.0f / FastMath.sqrt(f5);
        return new Vector3f(this.f23353x * sqrt, this.f23354y * sqrt, this.f23355z * sqrt);
    }

    public Vector3f normalizeLocal() {
        float f = this.f23353x;
        float f2 = this.f23354y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f23355z;
        float f5 = f3 + (f4 * f4);
        if (!(f5 == 1.0f || f5 == 0.0f)) {
            float sqrt = 1.0f / FastMath.sqrt(f5);
            this.f23353x *= sqrt;
            this.f23354y *= sqrt;
            this.f23355z *= sqrt;
        }
        return this;
    }

    public void maxLocal(Vector3f vector3f) {
        float f = vector3f.f23353x;
        float f2 = this.f23353x;
        if (f <= f2) {
            f = f2;
        }
        this.f23353x = f;
        float f3 = vector3f.f23354y;
        float f4 = this.f23354y;
        if (f3 <= f4) {
            f3 = f4;
        }
        this.f23354y = f3;
        float f5 = vector3f.f23355z;
        float f6 = this.f23355z;
        if (f5 <= f6) {
            f5 = f6;
        }
        this.f23355z = f5;
    }

    public void minLocal(Vector3f vector3f) {
        float f = vector3f.f23353x;
        float f2 = this.f23353x;
        if (f >= f2) {
            f = f2;
        }
        this.f23353x = f;
        float f3 = vector3f.f23354y;
        float f4 = this.f23354y;
        if (f3 >= f4) {
            f3 = f4;
        }
        this.f23354y = f3;
        float f5 = vector3f.f23355z;
        float f6 = this.f23355z;
        if (f5 >= f6) {
            f5 = f6;
        }
        this.f23355z = f5;
    }

    public Vector3f zero() {
        this.f23355z = 0.0f;
        this.f23354y = 0.0f;
        this.f23353x = 0.0f;
        return this;
    }

    public float angleBetween(Vector3f vector3f) {
        return FastMath.acos(dot(vector3f));
    }

    public Vector3f interpolate(Vector3f vector3f, float f) {
        float f2 = 1.0f - f;
        this.f23353x = (this.f23353x * f2) + (vector3f.f23353x * f);
        this.f23354y = (this.f23354y * f2) + (vector3f.f23354y * f);
        this.f23355z = (f2 * this.f23355z) + (f * vector3f.f23355z);
        return this;
    }

    public Vector3f interpolate(Vector3f vector3f, Vector3f vector3f2, float f) {
        float f2 = 1.0f - f;
        this.f23353x = (vector3f.f23353x * f2) + (vector3f2.f23353x * f);
        this.f23354y = (vector3f.f23354y * f2) + (vector3f2.f23354y * f);
        this.f23355z = (f2 * vector3f.f23355z) + (f * vector3f2.f23355z);
        return this;
    }

    public static boolean isValidVector(Vector3f vector3f) {
        if (vector3f != null && !Float.isNaN(vector3f.f23353x) && !Float.isNaN(vector3f.f23354y) && !Float.isNaN(vector3f.f23355z) && !Float.isInfinite(vector3f.f23353x) && !Float.isInfinite(vector3f.f23354y) && !Float.isInfinite(vector3f.f23355z)) {
            return true;
        }
        return false;
    }

    public static void generateOrthonormalBasis(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        vector3f3.normalizeLocal();
        generateComplementBasis(vector3f, vector3f2, vector3f3);
    }

    public static void generateComplementBasis(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (FastMath.abs(vector3f3.f23353x) >= FastMath.abs(vector3f3.f23354y)) {
            float f = vector3f3.f23353x;
            float f2 = vector3f3.f23355z;
            float invSqrt = FastMath.invSqrt((f * f) + (f2 * f2));
            vector3f.f23353x = (-vector3f3.f23355z) * invSqrt;
            vector3f.f23354y = 0.0f;
            float f3 = vector3f3.f23353x * invSqrt;
            vector3f.f23355z = f3;
            vector3f2.f23353x = vector3f3.f23354y * f3;
            float f4 = vector3f3.f23355z;
            float f5 = vector3f.f23353x;
            vector3f2.f23354y = (f4 * f5) - (vector3f3.f23353x * f3);
            vector3f2.f23355z = (-vector3f3.f23354y) * f5;
            return;
        }
        float f6 = vector3f3.f23354y;
        float f7 = vector3f3.f23355z;
        float invSqrt2 = FastMath.invSqrt((f6 * f6) + (f7 * f7));
        vector3f.f23353x = 0.0f;
        float f8 = vector3f3.f23355z * invSqrt2;
        vector3f.f23354y = f8;
        float f9 = vector3f3.f23354y;
        float f10 = (-f9) * invSqrt2;
        vector3f.f23355z = f10;
        vector3f2.f23353x = (f9 * f10) - (vector3f3.f23355z * f8);
        float f11 = vector3f3.f23353x;
        vector3f2.f23354y = (-f11) * f10;
        vector3f2.f23355z = f11 * vector3f.f23354y;
    }

    public Vector3f clone() {
        try {
            return (Vector3f) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public float[] toArray(float[] fArr) {
        if (fArr == null) {
            fArr = new float[3];
        }
        fArr[0] = this.f23353x;
        fArr[1] = this.f23354y;
        fArr[2] = this.f23355z;
        return fArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Vector3f)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Vector3f vector3f = (Vector3f) obj;
        return Float.compare(this.f23353x, vector3f.f23353x) == 0 && Float.compare(this.f23354y, vector3f.f23354y) == 0 && Float.compare(this.f23355z, vector3f.f23355z) == 0;
    }

    public int hashCode() {
        int floatToIntBits = 1369 + Float.floatToIntBits(this.f23353x) + 37;
        int floatToIntBits2 = floatToIntBits + (floatToIntBits * 37) + Float.floatToIntBits(this.f23354y);
        return floatToIntBits2 + (floatToIntBits2 * 37) + Float.floatToIntBits(this.f23355z);
    }

    public String toString() {
        return "(" + this.f23353x + ", " + this.f23354y + ", " + this.f23355z + ")";
    }

    public float getX() {
        return this.f23353x;
    }

    public Vector3f setX(float f) {
        this.f23353x = f;
        return this;
    }

    public float getY() {
        return this.f23354y;
    }

    public Vector3f setY(float f) {
        this.f23354y = f;
        return this;
    }

    public float getZ() {
        return this.f23355z;
    }

    public Vector3f setZ(float f) {
        this.f23355z = f;
        return this;
    }

    public float get(int i) {
        if (i == 0) {
            return this.f23353x;
        }
        if (i == 1) {
            return this.f23354y;
        }
        if (i == 2) {
            return this.f23355z;
        }
        throw new IllegalArgumentException("index must be either 0, 1 or 2");
    }

    public void set(int i, float f) {
        if (i == 0) {
            this.f23353x = f;
        } else if (i == 1) {
            this.f23354y = f;
        } else if (i == 2) {
            this.f23355z = f;
        } else {
            throw new IllegalArgumentException("index must be either 0, 1 or 2");
        }
    }
}
