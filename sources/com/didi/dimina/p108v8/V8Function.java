package com.didi.dimina.p108v8;

/* renamed from: com.didi.dimina.v8.V8Function */
public class V8Function extends V8Object {
    public V8Function(C7781V8 v8, JavaCallback javaCallback) {
        super(v8, javaCallback);
    }

    protected V8Function(C7781V8 v8) {
        this(v8, (JavaCallback) null);
    }

    /* access modifiers changed from: protected */
    public V8Value createTwin() {
        return new V8Function(this.f18203v8);
    }

    public String toString() {
        return (this.released || this.f18203v8.isReleased()) ? "[Function released]" : super.toString();
    }

    /* access modifiers changed from: protected */
    public void initialize(long j, Object obj) {
        if (obj == null) {
            super.initialize(j, (Object) null);
            return;
        }
        long[] initNewV8Function = this.f18203v8.initNewV8Function(j);
        this.f18203v8.createAndRegisterMethodDescriptor((JavaCallback) obj, initNewV8Function[1]);
        this.released = false;
        addObjectReference(initNewV8Function[0]);
    }

    public V8Function twin() {
        return (V8Function) super.twin();
    }

    public Object call(V8Object v8Object, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Object);
        this.f18203v8.checkRuntime(v8Array);
        if (v8Object == null) {
            v8Object = this.f18203v8;
        }
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        return this.f18203v8.executeFunction(this.f18203v8.getV8RuntimePtr(), v8Object.isUndefined() ? this.f18203v8.getHandle() : v8Object.getHandle(), this.objectHandle, j);
    }
}
