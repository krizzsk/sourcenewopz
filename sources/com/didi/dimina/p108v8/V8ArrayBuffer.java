package com.didi.dimina.p108v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.didi.dimina.v8.V8ArrayBuffer */
public class V8ArrayBuffer extends V8Value {
    ByteBuffer byteBuffer;

    public V8ArrayBuffer(C7781V8 v8, int i) {
        super(v8);
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i));
        ByteBuffer createV8ArrayBufferBackingStore = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.objectHandle, i);
        this.byteBuffer = createV8ArrayBufferBackingStore;
        createV8ArrayBufferBackingStore.order(ByteOrder.nativeOrder());
    }

    public V8ArrayBuffer(C7781V8 v8, ByteBuffer byteBuffer2) {
        super(v8);
        byteBuffer2 = byteBuffer2 == null ? ByteBuffer.allocateDirect(0) : byteBuffer2;
        if (byteBuffer2.isDirect()) {
            initialize(v8.getV8RuntimePtr(), byteBuffer2);
            this.byteBuffer = byteBuffer2;
            byteBuffer2.order(ByteOrder.nativeOrder());
            return;
        }
        throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
    }

    /* access modifiers changed from: protected */
    public void initialize(long j, Object obj) {
        this.f18203v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer2 = (ByteBuffer) obj;
            this.objectHandle = this.f18203v8.initNewV8ArrayBuffer(this.f18203v8.getV8RuntimePtr(), byteBuffer2, byteBuffer2.limit());
        } else {
            this.objectHandle = this.f18203v8.initNewV8ArrayBuffer(this.f18203v8.getV8RuntimePtr(), ((Integer) obj).intValue());
        }
        this.released = false;
        addObjectReference(this.objectHandle);
    }

    /* access modifiers changed from: protected */
    public V8Value createTwin() {
        return new V8ArrayBuffer(this.f18203v8, this.byteBuffer);
    }

    public V8ArrayBuffer twin() {
        this.f18203v8.checkThread();
        checkReleased();
        return (V8ArrayBuffer) super.twin();
    }

    public int limit() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.limit();
    }

    public final int capacity() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.capacity();
    }

    public final int position() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.position();
    }

    public final V8ArrayBuffer position(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.position(i);
        return this;
    }

    public final V8ArrayBuffer limit(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.limit(i);
        return this;
    }

    public final V8ArrayBuffer mark() {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.mark();
        return this;
    }

    public final V8ArrayBuffer reset() {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.reset();
        return this;
    }

    public final V8ArrayBuffer clear() {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.clear();
        return this;
    }

    public final V8ArrayBuffer flip() {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.flip();
        return this;
    }

    public final V8ArrayBuffer rewind() {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.rewind();
        return this;
    }

    public final int remaining() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.remaining();
    }

    public final boolean hasRemaining() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasRemaining();
    }

    public boolean isReadOnly() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.isReadOnly();
    }

    public byte get() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.get();
    }

    public V8ArrayBuffer put(byte b) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.put(b);
        return this;
    }

    public byte get(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.get(i);
    }

    public V8ArrayBuffer put(int i, byte b) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.put(i, b);
        return this;
    }

    public V8ArrayBuffer get(byte[] bArr, int i, int i2) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr, i, i2);
        return this;
    }

    public V8ArrayBuffer get(byte[] bArr) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.get(bArr);
        return this;
    }

    public V8ArrayBuffer put(ByteBuffer byteBuffer2) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.put(byteBuffer2);
        return this;
    }

    public V8ArrayBuffer put(byte[] bArr, int i, int i2) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr, i, i2);
        return this;
    }

    public final V8ArrayBuffer put(byte[] bArr) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr);
        return this;
    }

    public final boolean hasArray() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.hasArray();
    }

    public final byte[] array() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.array();
    }

    public final int arrayOffset() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.arrayOffset();
    }

    public V8ArrayBuffer compact() {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.compact();
        return this;
    }

    public boolean isDirect() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.isDirect();
    }

    public final ByteOrder order() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.order();
    }

    public final V8ArrayBuffer order(ByteOrder byteOrder) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.order(byteOrder);
        return this;
    }

    public char getChar() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar();
    }

    public V8ArrayBuffer putChar(char c) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(c);
        return this;
    }

    public char getChar(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getChar(i);
    }

    public V8ArrayBuffer putChar(int i, char c) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putChar(i, c);
        return this;
    }

    public short getShort() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort();
    }

    public V8ArrayBuffer putShort(short s) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(s);
        return this;
    }

    public short getShort(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getShort(i);
    }

    public V8ArrayBuffer putShort(int i, short s) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putShort(i, s);
        return this;
    }

    public int getInt() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt();
    }

    public V8ArrayBuffer putInt(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putInt(i);
        return this;
    }

    public int getInt(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getInt(i);
    }

    public V8ArrayBuffer putInt(int i, int i2) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.asIntBuffer().put(i, i2);
        return this;
    }

    public long getLong() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong();
    }

    public V8ArrayBuffer putLong(long j) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(j);
        return this;
    }

    public long getLong(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getLong(i);
    }

    public V8ArrayBuffer putLong(int i, long j) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putLong(i, j);
        return this;
    }

    public float getFloat() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat();
    }

    public V8ArrayBuffer putFloat(float f) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(f);
        return this;
    }

    public float getFloat(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getFloat(i);
    }

    public V8ArrayBuffer putFloat(int i, float f) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putFloat(i, f);
        return this;
    }

    public double getDouble() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble();
    }

    public V8ArrayBuffer putDouble(double d) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(d);
        return this;
    }

    public double getDouble(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.getDouble(i);
    }

    public V8ArrayBuffer putDouble(int i, double d) {
        this.f18203v8.checkThread();
        checkReleased();
        this.byteBuffer.putDouble(i, d);
        return this;
    }

    public int floatLimit() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.asFloatBuffer().limit();
    }

    public int intLimit() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.asIntBuffer().limit();
    }

    public int shortLimit() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.asShortBuffer().limit();
    }

    public int doubleLimit() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.byteBuffer.asDoubleBuffer().limit();
    }
}
