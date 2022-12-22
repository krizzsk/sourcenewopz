package com.didi.dimina.p108v8.utils;

import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.p108v8.V8ArrayBuffer;
import java.nio.ByteBuffer;

/* renamed from: com.didi.dimina.v8.utils.ArrayBuffer */
public class ArrayBuffer {
    private V8ArrayBuffer arrayBuffer;

    ArrayBuffer(V8ArrayBuffer v8ArrayBuffer) {
        this.arrayBuffer = (V8ArrayBuffer) v8ArrayBuffer.twin().setWeak();
    }

    public ArrayBuffer(C7781V8 v8, ByteBuffer byteBuffer) {
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v8, byteBuffer);
        try {
            this.arrayBuffer = (V8ArrayBuffer) v8ArrayBuffer.twin().setWeak();
        } finally {
            v8ArrayBuffer.close();
        }
    }

    public boolean isAvailable() {
        return !this.arrayBuffer.isReleased();
    }

    public V8ArrayBuffer getV8ArrayBuffer() {
        return this.arrayBuffer.twin();
    }
}
