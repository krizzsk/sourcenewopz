package com.didi.dimina.p108v8;

/* renamed from: com.didi.dimina.v8.V8TypedArray */
public class V8TypedArray extends V8Array {
    public V8TypedArray(C7781V8 v8, V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
        super(v8, new V8ArrayData(v8ArrayBuffer, i2, i3, i));
    }

    private V8TypedArray(C7781V8 v8) {
        super(v8);
    }

    /* access modifiers changed from: protected */
    public V8Value createTwin() {
        this.f18203v8.checkThread();
        checkReleased();
        return new V8TypedArray(this.f18203v8);
    }

    public Object get(int i) {
        this.f18203v8.checkThread();
        checkReleased();
        int type = getType();
        if (type == 1) {
            return super.get(i);
        }
        if (type == 2) {
            return super.get(i);
        }
        if (type == 9) {
            return Byte.valueOf(((Number) super.get(i)).byteValue());
        }
        switch (type) {
            case 11:
                return Short.valueOf((short) (((Number) super.get(i)).shortValue() & 255));
            case 12:
                return Short.valueOf((short) (((Number) super.get(i)).byteValue() & 255));
            case 13:
                return Short.valueOf(((Number) super.get(i)).shortValue());
            case 14:
                return Integer.valueOf(((Integer) super.get(i)).intValue() & 65535);
            case 15:
                return Long.valueOf(-1 & ((Number) super.get(i)).longValue());
            case 16:
                return Float.valueOf(((Number) super.get(i)).floatValue());
            default:
                return null;
        }
    }

    public V8ArrayBuffer getBuffer() {
        return (V8ArrayBuffer) get("buffer");
    }

    /* access modifiers changed from: protected */
    public void initialize(long j, Object obj) {
        this.f18203v8.checkThread();
        if (obj == null) {
            super.initialize(j, obj);
            return;
        }
        V8ArrayData v8ArrayData = (V8ArrayData) obj;
        checkArrayProperties(v8ArrayData);
        long createTypedArray = createTypedArray(j, v8ArrayData);
        this.released = false;
        addObjectReference(createTypedArray);
    }

    private long createTypedArray(long j, V8ArrayData v8ArrayData) {
        int access$000 = v8ArrayData.type;
        if (access$000 == 1) {
            return this.f18203v8.initNewV8Int32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        } else if (access$000 == 2) {
            return this.f18203v8.initNewV8Float64Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        } else if (access$000 != 9) {
            switch (access$000) {
                case 11:
                    return this.f18203v8.initNewV8UInt8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 12:
                    return this.f18203v8.initNewV8UInt8ClampedArray(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 13:
                    return this.f18203v8.initNewV8Int16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 14:
                    return this.f18203v8.initNewV8UInt16Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 15:
                    return this.f18203v8.initNewV8UInt32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                case 16:
                    return this.f18203v8.initNewV8Float32Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
                default:
                    throw new IllegalArgumentException("Cannot create a typed array of type " + getStringRepresentation(v8ArrayData.type));
            }
        } else {
            return this.f18203v8.initNewV8Int8Array(j, v8ArrayData.buffer.objectHandle, v8ArrayData.offset, v8ArrayData.size);
        }
    }

    public static int getStructureSize(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 8;
        }
        if (i != 9) {
            switch (i) {
                case 11:
                case 12:
                    break;
                case 13:
                case 14:
                    return 2;
                case 15:
                case 16:
                    return 4;
                default:
                    throw new IllegalArgumentException("Cannot create a typed array of type " + getStringRepresentation(i));
            }
        }
        return 1;
    }

    private void checkArrayProperties(V8ArrayData v8ArrayData) {
        checkOffset(v8ArrayData);
        checkSize(v8ArrayData);
    }

    private void checkSize(V8ArrayData v8ArrayData) {
        if (v8ArrayData.size < 0) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        } else if ((v8ArrayData.size * getStructureSize(v8ArrayData.type)) + v8ArrayData.offset > v8ArrayData.buffer.limit()) {
            throw new IllegalStateException("RangeError: Invalid typed array length");
        }
    }

    private void checkOffset(V8ArrayData v8ArrayData) {
        if (v8ArrayData.offset % getStructureSize(v8ArrayData.type) != 0) {
            throw new IllegalStateException("RangeError: Start offset of Int32Array must be a multiple of " + getStructureSize(v8ArrayData.type));
        }
    }

    /* renamed from: com.didi.dimina.v8.V8TypedArray$V8ArrayData */
    private static class V8ArrayData {
        /* access modifiers changed from: private */
        public V8ArrayBuffer buffer;
        /* access modifiers changed from: private */
        public int offset;
        /* access modifiers changed from: private */
        public int size;
        /* access modifiers changed from: private */
        public int type;

        public V8ArrayData(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3) {
            this.buffer = v8ArrayBuffer;
            this.offset = i;
            this.size = i2;
            this.type = i3;
        }
    }
}
