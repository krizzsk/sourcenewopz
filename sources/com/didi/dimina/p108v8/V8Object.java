package com.didi.dimina.p108v8;

import java.lang.reflect.Method;

/* renamed from: com.didi.dimina.v8.V8Object */
public class V8Object extends V8Value {
    public V8Object(C7781V8 v8) {
        this(v8, (Object) null);
    }

    protected V8Object(C7781V8 v8, Object obj) {
        super(v8);
        if (v8 != null) {
            this.f18203v8.checkThread();
            initialize(this.f18203v8.getV8RuntimePtr(), obj);
        }
    }

    protected V8Object() {
    }

    /* access modifiers changed from: protected */
    public V8Value createTwin() {
        return new V8Object(this.f18203v8);
    }

    public V8Object twin() {
        return (V8Object) super.twin();
    }

    public boolean contains(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.f18203v8.contains(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public String[] getKeys() {
        this.f18203v8.checkThread();
        checkReleased();
        return this.f18203v8.getKeys(this.f18203v8.getV8RuntimePtr(), this.objectHandle);
    }

    public int getType(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.f18203v8.getType(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public Object get(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.f18203v8.get(this.f18203v8.getV8RuntimePtr(), 6, this.objectHandle, str);
    }

    public int getInteger(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.f18203v8.getInteger(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public boolean getBoolean(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.f18203v8.getBoolean(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public double getDouble(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.f18203v8.getDouble(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public String getString(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.f18203v8.getString(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public V8Array getArray(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.f18203v8.get(this.f18203v8.getV8RuntimePtr(), 5, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Array)) {
            return (V8Array) obj;
        }
        throw new V8ResultUndefined();
    }

    public V8Object getObject(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.f18203v8.get(this.f18203v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Object)) {
            return (V8Object) obj;
        }
        throw new V8ResultUndefined();
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        return this.f18203v8.executeIntegerFunction(this.f18203v8.getV8RuntimePtr(), getHandle(), str, j);
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        return this.f18203v8.executeDoubleFunction(this.f18203v8.getV8RuntimePtr(), getHandle(), str, j);
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        return this.f18203v8.executeStringFunction(this.f18203v8.getV8RuntimePtr(), getHandle(), str, j);
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        return this.f18203v8.executeBooleanFunction(this.f18203v8.getV8RuntimePtr(), getHandle(), str, j);
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        Object executeFunction = this.f18203v8.executeFunction(this.f18203v8.getV8RuntimePtr(), 5, this.objectHandle, str, j);
        if (executeFunction instanceof V8Array) {
            return (V8Array) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        Object executeFunction = this.f18203v8.executeFunction(this.f18203v8.getV8RuntimePtr(), 6, this.objectHandle, str, j);
        if (executeFunction instanceof V8Object) {
            return (V8Object) executeFunction;
        }
        throw new V8ResultUndefined();
    }

    public Object executeFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        return this.f18203v8.executeFunction(this.f18203v8.getV8RuntimePtr(), 0, this.objectHandle, str, j);
    }

    public Object executeJSFunction(String str) {
        return executeFunction(str, (V8Array) null);
    }

    public Object executeJSFunction(String str, Object... objArr) {
        if (objArr == null) {
            return executeFunction(str, (V8Array) null);
        }
        V8Array v8Array = new V8Array(this.f18203v8.getRuntime());
        try {
            for (V8Value v8Value : objArr) {
                if (v8Value == null) {
                    v8Array.pushNull();
                } else if (v8Value instanceof V8Value) {
                    v8Array.push(v8Value);
                } else if (v8Value instanceof Integer) {
                    v8Array.push((Object) v8Value);
                } else if (v8Value instanceof Double) {
                    v8Array.push((Object) v8Value);
                } else if (v8Value instanceof Long) {
                    v8Array.push(((Long) v8Value).doubleValue());
                } else if (v8Value instanceof Float) {
                    v8Array.push((double) ((Float) v8Value).floatValue());
                } else if (v8Value instanceof Boolean) {
                    v8Array.push((Object) v8Value);
                } else if (v8Value instanceof String) {
                    v8Array.push((String) v8Value);
                } else {
                    throw new IllegalArgumentException("Unsupported Object of type: " + v8Value.getClass());
                }
            }
            return executeFunction(str, v8Array);
        } finally {
            v8Array.close();
        }
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        long j;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Array);
        if (v8Array == null) {
            j = 0;
        } else {
            j = v8Array.getHandle();
        }
        this.f18203v8.executeVoidFunction(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str, j);
    }

    public V8Object add(String str, int i) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.add(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str, i);
        return this;
    }

    public V8Object add(String str, boolean z) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.add(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str, z);
        return this;
    }

    public V8Object add(String str, double d) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.add(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str, d);
        return this;
    }

    public V8Object add(String str, String str2) {
        this.f18203v8.checkThread();
        checkReleased();
        if (str2 == null) {
            this.f18203v8.addNull(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (str2.equals(C7781V8.getUndefined())) {
            this.f18203v8.addUndefined(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.f18203v8.add(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str, str2);
        }
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        V8Value v8Value2 = v8Value;
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.checkRuntime(v8Value2);
        if (v8Value2 == null) {
            this.f18203v8.addNull(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (v8Value2.equals(C7781V8.getUndefined())) {
            this.f18203v8.addUndefined(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.f18203v8.addObject(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
        }
        return this;
    }

    public V8Object addUndefined(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.addUndefined(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public V8Object addNull(String str) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.addNull(this.f18203v8.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public V8Object setPrototype(V8Object v8Object) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.setPrototype(this.f18203v8.getV8RuntimePtr(), this.objectHandle, v8Object.getHandle());
        return this;
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.registerCallback(javaCallback, getHandle(), str);
        return this;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        this.f18203v8.checkThread();
        checkReleased();
        this.f18203v8.registerVoidCallback(javaVoidCallback, getHandle(), str);
        return this;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        return registerJavaMethod(obj, str, str2, clsArr, false);
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
        this.f18203v8.checkThread();
        checkReleased();
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            this.f18203v8.registerCallback(obj, method, getHandle(), str2, z);
            return this;
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (SecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public String toString() {
        if (isReleased() || this.f18203v8.isReleased()) {
            return "[Object released]";
        }
        this.f18203v8.checkThread();
        return this.f18203v8.toString(this.f18203v8.getV8RuntimePtr(), getHandle());
    }

    private void checkKey(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    /* renamed from: com.didi.dimina.v8.V8Object$Undefined */
    static class Undefined extends V8Object {
        public void close() {
        }

        public int hashCode() {
            return 919;
        }

        public boolean isReleased() {
            return false;
        }

        public boolean isUndefined() {
            return true;
        }

        @Deprecated
        public void release() {
        }

        public String toString() {
            return "undefined";
        }

        public Undefined twin() {
            return (Undefined) V8Object.super.twin();
        }

        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
        }

        public V8Object add(String str, boolean z) {
            throw new UnsupportedOperationException();
        }

        public C7781V8 getRuntime() {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, double d) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, int i) {
            throw new UnsupportedOperationException();
        }

        public Object executeJSFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        public Object executeFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        public V8Object addUndefined(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean contains(String str) {
            throw new UnsupportedOperationException();
        }

        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public double executeDoubleFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public int executeIntegerFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public String executeStringFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public void executeVoidFunction(String str, V8Array v8Array) {
            throw new UnsupportedOperationException();
        }

        public V8Array getArray(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(String str) {
            throw new UnsupportedOperationException();
        }

        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        public String[] getKeys() {
            throw new UnsupportedOperationException();
        }

        public V8Object getObject(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        public String getString(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        public int getType(String str) throws V8ResultUndefined {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            throw new UnsupportedOperationException();
        }

        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            throw new UnsupportedOperationException();
        }

        public V8Object setPrototype(V8Object v8Object) {
            throw new UnsupportedOperationException();
        }
    }
}
