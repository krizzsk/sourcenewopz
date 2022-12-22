package com.didi.dimina.p108v8.utils;

import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.p108v8.V8ArrayBuffer;
import com.didi.dimina.p108v8.V8TypedArray;

/* renamed from: com.didi.dimina.v8.utils.TypedArray */
public class TypedArray {
    private V8TypedArray typedArray;

    TypedArray(V8TypedArray v8TypedArray) {
        this.typedArray = (V8TypedArray) v8TypedArray.twin().setWeak();
    }

    public TypedArray(C7781V8 v8, ArrayBuffer arrayBuffer, int i, int i2, int i3) {
        V8ArrayBuffer v8ArrayBuffer = arrayBuffer.getV8ArrayBuffer();
        V8TypedArray v8TypedArray = new V8TypedArray(v8, v8ArrayBuffer, i, i2, i3);
        try {
            this.typedArray = (V8TypedArray) v8TypedArray.twin().setWeak();
        } finally {
            v8ArrayBuffer.close();
            v8TypedArray.close();
        }
    }

    public boolean isAvailable() {
        return !this.typedArray.isReleased();
    }

    public V8TypedArray getV8TypedArray() {
        return (V8TypedArray) this.typedArray.twin();
    }
}
