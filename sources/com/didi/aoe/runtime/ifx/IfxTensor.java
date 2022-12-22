package com.didi.aoe.runtime.ifx;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class IfxTensor {
    public static final int SHAPE_C = 2;
    public static final int SHAPE_CSETP = 5;
    public static final int SHAPE_DIMS = 3;
    public static final int SHAPE_ELEMSIZE = 4;
    public static final int SHAPE_H = 1;
    public static final int SHAPE_SIZE = 6;
    public static final int SHAPE_W = 0;

    /* renamed from: a */
    private long f8213a;

    /* renamed from: b */
    private int[] f8214b;

    private static native ByteBuffer buffer(long j);

    private static native long create(long j, int i, boolean z);

    private static native void delete(long j);

    private static native int numBytes(long j);

    private static native void readMultiDimensionalArray(long j, Object obj);

    private static native int[] shape(long j);

    private static native void writeDirectBuffer(long j, ByteBuffer byteBuffer);

    private static native void writeMultiDimensionalArray(long j, Object obj);

    /* renamed from: a */
    static IfxTensor m5328a(long j, int i, boolean z) {
        return new IfxTensor(create(j, i, z));
    }

    private IfxTensor(long j) {
        this.f8213a = j;
        this.f8214b = shape(j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40267a() {
        this.f8213a = 0;
    }

    public int[] shape() {
        return this.f8214b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo40270b() {
        this.f8214b = shape(this.f8213a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo40271c() {
        return this.f8213a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo40268a(Object obj) {
        m5334g(obj);
        if (!m5333f(obj)) {
            writeMultiDimensionalArray(this.f8213a, obj);
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()) {
            m5330d().put(byteBuffer);
        } else {
            writeDirectBuffer(this.f8213a, byteBuffer);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo40269b(Object obj) {
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            ByteBuffer d = m5330d();
            if (d != null) {
                byteBuffer.put(d);
            }
            return obj;
        }
        readMultiDimensionalArray(this.f8213a, obj);
        return obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo40272c(Object obj) {
        if (m5333f(obj)) {
            return null;
        }
        int[] d = m5331d(obj);
        if (Arrays.equals(this.f8214b, d)) {
            return null;
        }
        return d;
    }

    /* renamed from: d */
    static int[] m5331d(Object obj) {
        int[] iArr = new int[m5332e(obj)];
        m5329a(obj, 0, iArr);
        return iArr;
    }

    /* renamed from: e */
    static int m5332e(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return 0;
        }
        if (Array.getLength(obj) != 0) {
            return m5332e(Array.get(obj, 0)) + 1;
        }
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    /* renamed from: a */
    static void m5329a(Object obj, int i, int[] iArr) {
        if (iArr != null && i != iArr.length) {
            int length = Array.getLength(obj);
            if (iArr[i] == 0) {
                iArr[i] = length;
            } else if (iArr[i] != length) {
                throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", new Object[]{Integer.valueOf(iArr[i]), Integer.valueOf(length), Integer.valueOf(i)}));
            }
            for (int i2 = 0; i2 < length; i2++) {
                m5329a(Array.get(obj, i2), i + 1, iArr);
            }
        }
    }

    /* renamed from: f */
    private static boolean m5333f(Object obj) {
        return obj instanceof ByteBuffer;
    }

    public int numBytes() {
        return numBytes(this.f8213a);
    }

    /* renamed from: g */
    private void m5334g(Object obj) {
        if (m5333f(obj)) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            if (byteBuffer.capacity() != numBytes()) {
                throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite buffer with %d bytes and a ByteBuffer with %d bytes.", new Object[]{Integer.valueOf(numBytes()), Integer.valueOf(byteBuffer.capacity())}));
            }
        }
    }

    /* renamed from: d */
    private ByteBuffer m5330d() {
        ByteBuffer buffer = buffer(this.f8213a);
        if (buffer != null) {
            buffer.order(ByteOrder.nativeOrder());
        }
        return buffer;
    }
}
