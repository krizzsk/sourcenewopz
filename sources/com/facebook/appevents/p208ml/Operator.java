package com.facebook.appevents.p208ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001b\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u001e"}, mo175978d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "()V", "addmv", "", "x", "Lcom/facebook/appevents/ml/MTensor;", "b", "concatenate", "tensors", "", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "conv1D", "w", "dense", "embedding", "texts", "", "seqLength", "", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "flatten", "startDim", "maxPool1D", "poolSize", "mul", "relu", "softmax", "transpose2D", "transpose3D", "facebook-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.facebook.appevents.ml.Operator */
/* compiled from: Operator.kt */
public final class Operator {
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    @JvmStatic
    public static final void addmv(MTensor mTensor, MTensor mTensor2) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                Intrinsics.checkNotNullParameter(mTensor2, "b");
                int shape = mTensor.getShape(0);
                int shape2 = mTensor.getShape(1);
                int shape3 = mTensor.getShape(2);
                float[] data = mTensor.getData();
                float[] data2 = mTensor2.getData();
                if (shape > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (shape2 > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                if (shape3 > 0) {
                                    int i5 = 0;
                                    while (true) {
                                        int i6 = i5 + 1;
                                        int i7 = (i * shape2 * shape3) + (i3 * shape3) + i5;
                                        data[i7] = data[i7] + data2[i5];
                                        if (i6 >= shape3) {
                                            break;
                                        }
                                        i5 = i6;
                                    }
                                }
                                if (i4 >= shape2) {
                                    break;
                                }
                                i3 = i4;
                            }
                        }
                        if (i2 < shape) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final MTensor mul(MTensor mTensor, MTensor mTensor2) {
        MTensor mTensor3 = mTensor;
        MTensor mTensor4 = mTensor2;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor3, "x");
            Intrinsics.checkNotNullParameter(mTensor4, "w");
            int shape = mTensor3.getShape(0);
            int shape2 = mTensor4.getShape(0);
            int shape3 = mTensor4.getShape(1);
            MTensor mTensor5 = new MTensor(new int[]{shape, shape3});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            float[] data3 = mTensor5.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape3 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            int i5 = (i * shape3) + i3;
                            data3[i5] = 0.0f;
                            if (shape2 > 0) {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6 + 1;
                                    data3[i5] = data3[i5] + (data[(i * shape2) + i6] * data2[(i6 * shape3) + i3]);
                                    if (i7 >= shape2) {
                                        break;
                                    }
                                    i6 = i7;
                                }
                            }
                            if (i4 >= shape3) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mTensor5;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final void relu(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                float[] data = mTensor.getData();
                int i = 0;
                int length = data.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        if (data[i] < 0.0f) {
                            data[i] = 0.0f;
                        }
                        if (i2 <= length) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void flatten(MTensor mTensor, int i) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                if (i < mTensor.getShapeSize()) {
                    int shapeSize = mTensor.getShapeSize();
                    int i2 = 1;
                    if (i < shapeSize) {
                        int i3 = i;
                        while (true) {
                            int i4 = i3 + 1;
                            i2 *= mTensor.getShape(i3);
                            if (i4 >= shapeSize) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    int[] iArr = new int[(i + 1)];
                    int i5 = 0;
                    if (i > 0) {
                        while (true) {
                            int i6 = i5 + 1;
                            iArr[i5] = mTensor.getShape(i5);
                            if (i6 >= i) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    iArr[i] = i2;
                    mTensor.reshape(iArr);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final MTensor concatenate(MTensor[] mTensorArr) {
        int i;
        MTensor[] mTensorArr2 = mTensorArr;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensorArr2, "tensors");
            int shape = mTensorArr2[0].getShape(0);
            int length = mTensorArr2.length - 1;
            if (length >= 0) {
                int i2 = 0;
                i = 0;
                while (true) {
                    int i3 = i2 + 1;
                    i += mTensorArr2[i2].getShape(1);
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            } else {
                i = 0;
            }
            MTensor mTensor = new MTensor(new int[]{shape, i});
            float[] data = mTensor.getData();
            if (shape > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    int i6 = i4 * i;
                    int length2 = mTensorArr2.length - 1;
                    if (length2 >= 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            float[] data2 = mTensorArr2[i7].getData();
                            int shape2 = mTensorArr2[i7].getShape(1);
                            System.arraycopy(data2, i4 * shape2, data, i6, shape2);
                            i6 += shape2;
                            if (i8 > length2) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    if (i5 >= shape) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final void softmax(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(mTensor, "x");
                int i = 0;
                int shape = mTensor.getShape(0);
                int shape2 = mTensor.getShape(1);
                float[] data = mTensor.getData();
                if (shape > 0) {
                    while (true) {
                        int i2 = i + 1;
                        int i3 = i * shape2;
                        int i4 = i3 + shape2;
                        float f = Float.MIN_VALUE;
                        float f2 = 0.0f;
                        if (i3 < i4) {
                            int i5 = i3;
                            while (true) {
                                int i6 = i5 + 1;
                                if (data[i5] > f) {
                                    f = data[i5];
                                }
                                if (i6 >= i4) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        if (i3 < i4) {
                            int i7 = i3;
                            while (true) {
                                int i8 = i7 + 1;
                                data[i7] = (float) Math.exp((double) (data[i7] - f));
                                f2 += data[i7];
                                if (i8 >= i4) {
                                    break;
                                }
                                i7 = i8;
                            }
                        }
                        if (i3 < i4) {
                            while (true) {
                                int i9 = i3 + 1;
                                data[i3] = data[i3] / f2;
                                if (i9 >= i4) {
                                    break;
                                }
                                i3 = i9;
                            }
                        }
                        if (i2 < shape) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final MTensor dense(MTensor mTensor, MTensor mTensor2, MTensor mTensor3) {
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor, "x");
            Intrinsics.checkNotNullParameter(mTensor2, "w");
            Intrinsics.checkNotNullParameter(mTensor3, "b");
            int shape = mTensor.getShape(0);
            int shape2 = mTensor3.getShape(0);
            MTensor mul = mul(mTensor, mTensor2);
            float[] data = mTensor3.getData();
            float[] data2 = mul.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            int i5 = (i * shape2) + i3;
                            data2[i5] = data2[i5] + data[i3];
                            if (i4 >= shape2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mul;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor embedding(String[] strArr, int i, MTensor mTensor) {
        String[] strArr2 = strArr;
        int i2 = i;
        MTensor mTensor2 = mTensor;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(strArr2, "texts");
            Intrinsics.checkNotNullParameter(mTensor2, "w");
            int length = strArr2.length;
            int shape = mTensor2.getShape(1);
            MTensor mTensor3 = new MTensor(new int[]{length, i2, shape});
            float[] data = mTensor3.getData();
            float[] data2 = mTensor.getData();
            if (length > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    int[] vectorize = Utils.INSTANCE.vectorize(strArr2[i3], i2);
                    if (i2 > 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            System.arraycopy(data2, vectorize[i5] * shape, data, (shape * i2 * i3) + (i5 * shape), shape);
                            if (i6 >= i2) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    if (i4 >= length) {
                        break;
                    }
                    i3 = i4;
                }
            }
            return mTensor3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor transpose2D(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor, "x");
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            MTensor mTensor2 = new MTensor(new int[]{shape2, shape});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            data2[(i3 * shape) + i] = data[(i * shape2) + i3];
                            if (i4 >= shape2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mTensor2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor transpose3D(MTensor mTensor) {
        MTensor mTensor2 = mTensor;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor2, "x");
            int shape = mTensor2.getShape(0);
            int shape2 = mTensor2.getShape(1);
            int shape3 = mTensor2.getShape(2);
            MTensor mTensor3 = new MTensor(new int[]{shape3, shape2, shape});
            float[] data = mTensor.getData();
            float[] data2 = mTensor3.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            if (shape3 > 0) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5 + 1;
                                    data2[(i5 * shape * shape2) + (i3 * shape) + i] = data[(i * shape2 * shape3) + (i3 * shape3) + i5];
                                    if (i6 >= shape3) {
                                        break;
                                    }
                                    i5 = i6;
                                }
                            }
                            if (i4 >= shape2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mTensor3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor conv1D(MTensor mTensor, MTensor mTensor2) {
        Class<Operator> cls;
        MTensor mTensor3;
        Class<Operator> cls2;
        MTensor mTensor4 = mTensor;
        MTensor mTensor5 = mTensor2;
        Class<Operator> cls3 = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls3)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor4, "x");
            Intrinsics.checkNotNullParameter(mTensor5, "w");
            int shape = mTensor4.getShape(0);
            int shape2 = mTensor4.getShape(1);
            int shape3 = mTensor4.getShape(2);
            int shape4 = mTensor5.getShape(0);
            int i = (shape2 - shape4) + 1;
            int shape5 = mTensor5.getShape(2);
            MTensor mTensor6 = new MTensor(new int[]{shape, i, shape5});
            float[] data = mTensor.getData();
            float[] data2 = mTensor6.getData();
            float[] data3 = mTensor2.getData();
            if (shape <= 0) {
                return mTensor6;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (shape5 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        if (i > 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                float f = 0.0f;
                                if (shape4 > 0) {
                                    int i8 = 0;
                                    while (true) {
                                        cls2 = cls3;
                                        int i9 = i8 + 1;
                                        if (shape3 > 0) {
                                            int i10 = 0;
                                            while (true) {
                                                mTensor3 = mTensor6;
                                                int i11 = i10 + 1;
                                                try {
                                                    f += data[(shape2 * shape3 * i2) + ((i8 + i6) * shape3) + i10] * data3[(((i8 * shape3) + i10) * shape5) + i4];
                                                    if (i11 >= shape3) {
                                                        break;
                                                    }
                                                    i10 = i11;
                                                    mTensor6 = mTensor3;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    cls = cls2;
                                                    CrashShieldHandler.handleThrowable(th, cls);
                                                    return null;
                                                }
                                            }
                                        } else {
                                            mTensor3 = mTensor6;
                                        }
                                        if (i9 >= shape4) {
                                            break;
                                        }
                                        i8 = i9;
                                        cls3 = cls2;
                                        mTensor6 = mTensor3;
                                    }
                                } else {
                                    cls2 = cls3;
                                    mTensor3 = mTensor6;
                                }
                                data2[(i * shape5 * i2) + (i6 * shape5) + i4] = f;
                                if (i7 >= i) {
                                    break;
                                }
                                i6 = i7;
                                cls3 = cls2;
                                mTensor6 = mTensor3;
                            }
                        } else {
                            cls2 = cls3;
                            mTensor3 = mTensor6;
                        }
                        if (i5 >= shape5) {
                            break;
                        }
                        i4 = i5;
                        cls3 = cls2;
                        mTensor6 = mTensor3;
                    }
                } else {
                    cls2 = cls3;
                    mTensor3 = mTensor6;
                }
                if (i3 >= shape) {
                    return mTensor3;
                }
                i2 = i3;
                cls3 = cls2;
                mTensor6 = mTensor3;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = cls3;
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final MTensor maxPool1D(MTensor mTensor, int i) {
        int i2;
        MTensor mTensor2 = mTensor;
        int i3 = i;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(mTensor2, "x");
            int shape = mTensor2.getShape(0);
            int shape2 = mTensor2.getShape(1);
            int shape3 = mTensor2.getShape(2);
            int i4 = (shape2 - i3) + 1;
            MTensor mTensor3 = new MTensor(new int[]{shape, i4, shape3});
            float[] data = mTensor.getData();
            float[] data2 = mTensor3.getData();
            if (shape > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (shape3 > 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            if (i4 > 0) {
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9 + 1;
                                    int i11 = i9 * shape3;
                                    int i12 = (i5 * i4 * shape3) + i11 + i7;
                                    int i13 = (i5 * shape2 * shape3) + i11 + i7;
                                    data2[i12] = Float.MIN_VALUE;
                                    if (i3 > 0) {
                                        int i14 = 0;
                                        while (true) {
                                            int i15 = i14 + 1;
                                            i2 = shape2;
                                            data2[i12] = Math.max(data2[i12], data[i13 + (i14 * shape3)]);
                                            if (i15 >= i3) {
                                                break;
                                            }
                                            i14 = i15;
                                            shape2 = i2;
                                        }
                                    } else {
                                        i2 = shape2;
                                    }
                                    if (i10 >= i4) {
                                        break;
                                    }
                                    i9 = i10;
                                    shape2 = i2;
                                }
                            } else {
                                i2 = shape2;
                            }
                            if (i8 >= shape3) {
                                break;
                            }
                            i7 = i8;
                            shape2 = i2;
                        }
                    } else {
                        i2 = shape2;
                    }
                    if (i6 >= shape) {
                        break;
                    }
                    i5 = i6;
                    shape2 = i2;
                }
            }
            return mTensor3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
