package com.didi.hawaii.p118ar.utils;

import java.util.Random;
import kotlin.jvm.internal.ShortCompanionObject;

/* renamed from: com.didi.hawaii.ar.utils.FastMath */
public final class FastMath {
    public static final double DBL_EPSILON = 2.220446049250313E-16d;
    public static final float DEG_TO_RAD = 0.017453292f;
    public static final float FLT_EPSILON = 1.1920929E-7f;
    public static final float HALF_PI = 1.5707964f;
    public static final float INV_PI = 0.31830987f;
    public static final float INV_TWO_PI = 0.15915494f;
    public static final float ONE_THIRD = 0.33333334f;

    /* renamed from: PI */
    public static final float f23316PI = 3.1415927f;
    public static final float QUARTER_PI = 0.7853982f;
    public static final float RAD_TO_DEG = 57.295776f;
    public static final float TWO_PI = 6.2831855f;
    public static final float ZERO_TOLERANCE = 1.0E-4f;
    public static final Random rand = new Random(System.currentTimeMillis());

    public static float abs(float f) {
        return f < 0.0f ? -f : f;
    }

    public static float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static float copysign(float f, float f2) {
        return (f2 < 0.0f || f > 0.0f) ? (f2 >= 0.0f || f < 0.0f) ? f : -f : -f;
    }

    public static float determinant(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = (d9 * d14) - (d10 * d13);
        double d18 = (d9 * d15) - (d11 * d13);
        double d19 = (d9 * d16) - (d12 * d13);
        double d20 = (d10 * d15) - (d11 * d14);
        double d21 = (d10 * d16) - (d12 * d14);
        double d22 = (d11 * d16) - (d12 * d15);
        return (float) (((((((d6 * d22) - (d7 * d21)) + (d8 * d20)) * d) - ((((d22 * d5) - (d7 * d19)) + (d8 * d18)) * d2)) + (d3 * (((d21 * d5) - (d19 * d6)) + (d8 * d17)))) - (d4 * (((d5 * d20) - (d18 * d6)) + (d17 * d7))));
    }

    public static float extrapolateLinear(float f, float f2, float f3) {
        return ((1.0f - f) * f2) + (f * f3);
    }

    public static float interpolateBezier(float f, float f2, float f3, float f4, float f5) {
        float f6 = 1.0f - f;
        float f7 = f6 * f6;
        float f8 = f * f;
        return (f2 * f7 * f6) + (f3 * 3.0f * f * f7) + (f4 * 3.0f * f8 * f6) + (f5 * f8 * f);
    }

    public static float interpolateCatmullRom(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 * 2.0f;
        float f8 = -f2;
        return (((((((f8 * f3) + ((2.0f - f2) * f4) + ((f2 - 2.0f) * f5) + (f2 * f6)) * f) + (f7 * f3) + ((f2 - 3.0f) * f4) + ((3.0f - f7) * f5) + (f8 * f6)) * f) + (-1.0f * f2 * f3) + (f2 * f5)) * f) + f4;
    }

    public static float interpolateLinear(float f, float f2, float f3) {
        return (f2 != f3 && f > 0.0f) ? f >= 1.0f ? f3 : ((1.0f - f) * f2) + (f * f3) : f2;
    }

    public static boolean isPowerOfTwo(int i) {
        return i > 0 && (i & (i + -1)) == 0;
    }

    public static int sign(int i) {
        if (i > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }

    public static float sqr(float f) {
        return f * f;
    }

    private FastMath() {
    }

    public static int nearestPowerOfTwo(int i) {
        return (int) Math.pow(2.0d, Math.ceil(Math.log((double) i) / Math.log(2.0d)));
    }

    public static Vector3f interpolateLinear(float f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (vector3f3 == null) {
            vector3f3 = new Vector3f();
        }
        vector3f3.f23353x = interpolateLinear(f, vector3f.f23353x, vector3f2.f23353x);
        vector3f3.f23354y = interpolateLinear(f, vector3f.f23354y, vector3f2.f23354y);
        vector3f3.f23355z = interpolateLinear(f, vector3f.f23355z, vector3f2.f23355z);
        return vector3f3;
    }

    public static Vector3f interpolateLinear(float f, Vector3f vector3f, Vector3f vector3f2) {
        return interpolateLinear(f, vector3f, vector3f2, (Vector3f) null);
    }

    public static Vector3f extrapolateLinear(float f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        if (vector3f3 == null) {
            vector3f3 = new Vector3f();
        }
        vector3f3.f23353x = extrapolateLinear(f, vector3f.f23353x, vector3f2.f23353x);
        vector3f3.f23354y = extrapolateLinear(f, vector3f.f23354y, vector3f2.f23354y);
        vector3f3.f23355z = extrapolateLinear(f, vector3f.f23355z, vector3f2.f23355z);
        return vector3f3;
    }

    public static Vector3f extrapolateLinear(float f, Vector3f vector3f, Vector3f vector3f2) {
        return extrapolateLinear(f, vector3f, vector3f2, (Vector3f) null);
    }

    public static Vector3f interpolateCatmullRom(float f, float f2, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector3f vector3f5) {
        if (vector3f5 == null) {
            vector3f5 = new Vector3f();
        }
        vector3f5.f23353x = interpolateCatmullRom(f, f2, vector3f.f23353x, vector3f2.f23353x, vector3f3.f23353x, vector3f4.f23353x);
        float f3 = f;
        float f4 = f2;
        vector3f5.f23354y = interpolateCatmullRom(f3, f4, vector3f.f23354y, vector3f2.f23354y, vector3f3.f23354y, vector3f4.f23354y);
        vector3f5.f23355z = interpolateCatmullRom(f3, f4, vector3f.f23355z, vector3f2.f23355z, vector3f3.f23355z, vector3f4.f23355z);
        return vector3f5;
    }

    public static Vector3f interpolateCatmullRom(float f, float f2, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        return interpolateCatmullRom(f, f2, vector3f, vector3f2, vector3f3, vector3f4, (Vector3f) null);
    }

    public static Vector3f interpolateBezier(float f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector3f vector3f5) {
        if (vector3f5 == null) {
            vector3f5 = new Vector3f();
        }
        vector3f5.f23353x = interpolateBezier(f, vector3f.f23353x, vector3f2.f23353x, vector3f3.f23353x, vector3f4.f23353x);
        vector3f5.f23354y = interpolateBezier(f, vector3f.f23354y, vector3f2.f23354y, vector3f3.f23354y, vector3f4.f23354y);
        vector3f5.f23355z = interpolateBezier(f, vector3f.f23355z, vector3f2.f23355z, vector3f3.f23355z, vector3f4.f23355z);
        return vector3f5;
    }

    public static Vector3f interpolateBezier(float f, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        return interpolateBezier(f, vector3f, vector3f2, vector3f3, vector3f4, (Vector3f) null);
    }

    public static float getCatmullRomP1toP2Length(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, float f, float f2, float f3) {
        float f4 = (f + f2) * 0.5f;
        Vector3f clone = vector3f2.clone();
        if (f != 0.0f) {
            interpolateCatmullRom(f, f3, vector3f, vector3f2, vector3f3, vector3f4, clone);
        }
        Vector3f clone2 = vector3f3.clone();
        if (f2 != 1.0f) {
            interpolateCatmullRom(f2, f3, vector3f, vector3f2, vector3f3, vector3f4, clone2);
        }
        Vector3f interpolateCatmullRom = interpolateCatmullRom(f4, f3, vector3f, vector3f2, vector3f3, vector3f4);
        float length = clone2.subtract(clone).length();
        float length2 = interpolateCatmullRom.subtract(clone).length();
        float length3 = clone2.subtract(interpolateCatmullRom).length();
        if (length + 0.001f < length2 + length3) {
            Vector3f vector3f5 = vector3f;
            Vector3f vector3f6 = vector3f2;
            Vector3f vector3f7 = vector3f3;
            Vector3f vector3f8 = vector3f4;
            float f5 = f3;
            float catmullRomP1toP2Length = getCatmullRomP1toP2Length(vector3f5, vector3f6, vector3f7, vector3f8, f, f4, f5);
            length3 = getCatmullRomP1toP2Length(vector3f5, vector3f6, vector3f7, vector3f8, f4, f2, f5);
            length2 = catmullRomP1toP2Length;
        }
        return length2 + length3;
    }

    public static float getBezierP1toP2Length(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        Vector3f clone = vector3f.clone();
        Vector3f vector3f5 = new Vector3f();
        float f = 0.0f;
        for (float f2 = 0.0f; f2 <= 1.0f; f2 += 0.02f) {
            interpolateBezier(f2, vector3f, vector3f2, vector3f3, vector3f4, vector3f5);
            f += clone.subtractLocal(vector3f5).length();
            clone.set(vector3f5);
        }
        return f;
    }

    public static float acos(float f) {
        if (-1.0f >= f) {
            return 3.1415927f;
        }
        if (f < 1.0f) {
            return (float) Math.acos((double) f);
        }
        return 0.0f;
    }

    public static float asin(float f) {
        if (-1.0f >= f) {
            return -1.5707964f;
        }
        if (f < 1.0f) {
            return (float) Math.asin((double) f);
        }
        return 1.5707964f;
    }

    public static float atan(float f) {
        return (float) Math.atan((double) f);
    }

    public static float atan2(float f, float f2) {
        return (float) Math.atan2((double) f, (double) f2);
    }

    public static float ceil(float f) {
        return (float) Math.ceil((double) f);
    }

    public static float reduceSinAngle(float f) {
        float f2 = f % 6.2831855f;
        if (Math.abs(f2) > 3.1415927f) {
            f2 -= 6.2831855f;
        }
        return Math.abs(f2) > 1.5707964f ? 3.1415927f - f2 : f2;
    }

    public static float sin2(float f) {
        double cos;
        float reduceSinAngle = reduceSinAngle(f);
        if (((double) Math.abs(reduceSinAngle)) <= 0.7853981633974483d) {
            cos = Math.sin((double) reduceSinAngle);
        } else {
            cos = Math.cos(1.5707963267948966d - ((double) reduceSinAngle));
        }
        return (float) cos;
    }

    public static float cos2(float f) {
        return sin2(f + 1.5707964f);
    }

    public static float cos(float f) {
        return (float) Math.cos((double) f);
    }

    public static float sin(float f) {
        return (float) Math.sin((double) f);
    }

    public static float exp(float f) {
        return (float) Math.exp((double) f);
    }

    public static float floor(float f) {
        return (float) Math.floor((double) f);
    }

    public static float invSqrt(float f) {
        return (float) (1.0d / Math.sqrt((double) f));
    }

    public static float fastInvSqrt(float f) {
        float f2 = 0.5f * f;
        float intBitsToFloat = Float.intBitsToFloat(1597463174 - (Float.floatToIntBits(f) >> 1));
        return intBitsToFloat * (1.5f - ((f2 * intBitsToFloat) * intBitsToFloat));
    }

    public static float log(float f) {
        return (float) Math.log((double) f);
    }

    public static float log(float f, float f2) {
        return (float) (Math.log((double) f) / Math.log((double) f2));
    }

    public static float pow(float f, float f2) {
        return (float) Math.pow((double) f, (double) f2);
    }

    public static float sqrt(float f) {
        return (float) Math.sqrt((double) f);
    }

    public static float tan(float f) {
        return (float) Math.tan((double) f);
    }

    public static float sign(float f) {
        return Math.signum(f);
    }

    public static Vector3f computeNormal(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        return vector3f3.subtract(vector3f2).crossLocal(vector3f.subtract(vector3f2)).normalizeLocal();
    }

    public static float nextRandomFloat() {
        return rand.nextFloat();
    }

    public static int nextRandomInt(int i, int i2) {
        return ((int) (nextRandomFloat() * ((float) ((i2 - i) + 1)))) + i;
    }

    public static int nextRandomInt() {
        return rand.nextInt();
    }

    public static Vector3f sphericalToCartesian(Vector3f vector3f, Vector3f vector3f2) {
        vector3f2.f23354y = vector3f.f23353x * sin(vector3f.f23355z);
        float cos = vector3f.f23353x * cos(vector3f.f23355z);
        vector3f2.f23353x = cos(vector3f.f23354y) * cos;
        vector3f2.f23355z = cos * sin(vector3f.f23354y);
        return vector3f2;
    }

    public static Vector3f cartesianToSpherical(Vector3f vector3f, Vector3f vector3f2) {
        float f = vector3f.f23353x;
        if (f == 0.0f) {
            f = 1.1920929E-7f;
        }
        vector3f2.f23353x = sqrt((f * f) + (vector3f.f23354y * vector3f.f23354y) + (vector3f.f23355z * vector3f.f23355z));
        vector3f2.f23354y = atan(vector3f.f23355z / f);
        if (f < 0.0f) {
            vector3f2.f23354y += 3.1415927f;
        }
        vector3f2.f23355z = asin(vector3f.f23354y / vector3f2.f23353x);
        return vector3f2;
    }

    public static Vector3f sphericalToCartesianZ(Vector3f vector3f, Vector3f vector3f2) {
        vector3f2.f23355z = vector3f.f23353x * sin(vector3f.f23355z);
        float cos = vector3f.f23353x * cos(vector3f.f23355z);
        vector3f2.f23353x = cos(vector3f.f23354y) * cos;
        vector3f2.f23354y = cos * sin(vector3f.f23354y);
        return vector3f2;
    }

    public static Vector3f cartesianZToSpherical(Vector3f vector3f, Vector3f vector3f2) {
        float f = vector3f.f23353x;
        if (f == 0.0f) {
            f = 1.1920929E-7f;
        }
        vector3f2.f23353x = sqrt((f * f) + (vector3f.f23354y * vector3f.f23354y) + (vector3f.f23355z * vector3f.f23355z));
        vector3f2.f23355z = atan(vector3f.f23355z / f);
        if (f < 0.0f) {
            vector3f2.f23355z += 3.1415927f;
        }
        vector3f2.f23354y = asin(vector3f.f23354y / vector3f2.f23353x);
        return vector3f2;
    }

    public static float normalize(float f, float f2, float f3) {
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return 0.0f;
        }
        float f4 = f3 - f2;
        while (f > f3) {
            f -= f4;
        }
        while (f < f2) {
            f += f4;
        }
        return f;
    }

    public static float saturate(float f) {
        return clamp(f, 0.0f, 1.0f);
    }

    public static float convertHalfToFloat(short s) {
        if (s == 0) {
            return 0.0f;
        }
        if (s == 31744) {
            return Float.POSITIVE_INFINITY;
        }
        if (s == 32768) {
            return -0.0f;
        }
        if (s == 64512) {
            return Float.NEGATIVE_INFINITY;
        }
        return Float.intBitsToFloat(((s & 1023) << 13) | ((32768 & s) << 16) | (((s & 31744) + 114688) << 13));
    }

    public static short convertFloatToHalf(float f) {
        if (Float.isNaN(f)) {
            throw new UnsupportedOperationException("NaN to half conversion not supported!");
        } else if (f == Float.POSITIVE_INFINITY) {
            return 31744;
        } else {
            if (f == Float.NEGATIVE_INFINITY) {
                return -1024;
            }
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            if (f == -0.0f) {
                return ShortCompanionObject.MIN_VALUE;
            }
            if (f > 65504.0f) {
                return 31743;
            }
            if (f < -65504.0f) {
                return -1025;
            }
            if (i > 0 && f < 5.96046E-8f) {
                return 1;
            }
            if (f < 0.0f && f > -5.96046E-8f) {
                return -32767;
            }
            int floatToIntBits = Float.floatToIntBits(f);
            return (short) (((floatToIntBits >> 13) & 1023) | ((floatToIntBits >> 16) & 32768) | (31744 & (((2139095040 & floatToIntBits) - 939524096) >> 13)));
        }
    }
}
