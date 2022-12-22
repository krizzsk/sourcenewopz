package com.didi.dimina.p108v8.debug.mirror;

import com.didi.dimina.p108v8.Releasable;
import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;
import com.didi.dimina.p108v8.V8ResultUndefined;

/* renamed from: com.didi.dimina.v8.debug.mirror.Mirror */
public class Mirror implements Releasable {
    private static final String IS_ARRAY = "isArray";
    private static final String IS_BOOLEAN = "isBoolean";
    private static final String IS_FUNCTION = "isFunction";
    private static final String IS_NULL = "isNull";
    private static final String IS_NUMBER = "isNumber";
    private static final String IS_OBJECT = "isObject";
    private static final String IS_STRING = "isString";
    private static final String IS_UNDEFINED = "isUndefined";
    private static final String IS_VALUE = "isValue";
    protected V8Object v8Object;

    public boolean isArray() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isFrame() {
        return false;
    }

    public boolean isFunction() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isObject() {
        return false;
    }

    public boolean isProperty() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    Mirror(V8Object v8Object2) {
        this.v8Object = v8Object2.twin();
    }

    public boolean isUndefined() {
        return this.v8Object.executeBooleanFunction(IS_UNDEFINED, (V8Array) null);
    }

    public void close() {
        V8Object v8Object2 = this.v8Object;
        if (v8Object2 != null && !v8Object2.isReleased()) {
            this.v8Object.close();
            this.v8Object = null;
        }
    }

    @Deprecated
    public void release() {
        close();
    }

    protected static boolean isValue(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_VALUE, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isObject(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_OBJECT, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isNumber(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_NUMBER, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isBoolean(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_BOOLEAN, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isFunction(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_FUNCTION, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isArray(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_ARRAY, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isString(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_STRING, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isUndefined(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_UNDEFINED, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    private static boolean isNull(V8Object v8Object2) {
        try {
            return v8Object2.executeBooleanFunction(IS_NULL, (V8Array) null);
        } catch (V8ResultUndefined unused) {
            return false;
        }
    }

    protected static ValueMirror createMirror(V8Object v8Object2) {
        if (isNull(v8Object2)) {
            return new NullMirror(v8Object2);
        }
        if (isUndefined(v8Object2)) {
            return new UndefinedMirror(v8Object2);
        }
        if (isFunction(v8Object2)) {
            return new FunctionMirror(v8Object2);
        }
        if (isArray(v8Object2)) {
            return new ArrayMirror(v8Object2);
        }
        if (isObject(v8Object2)) {
            return new ObjectMirror(v8Object2);
        }
        if (isString(v8Object2)) {
            return new StringMirror(v8Object2);
        }
        if (isNumber(v8Object2)) {
            return new NumberMirror(v8Object2);
        }
        if (isBoolean(v8Object2)) {
            return new BooleanMirror(v8Object2);
        }
        return new ValueMirror(v8Object2);
    }

    public String toString() {
        return this.v8Object.toString();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Mirror)) {
            return this.v8Object.equals(((Mirror) obj).v8Object);
        }
        return false;
    }

    public int hashCode() {
        return this.v8Object.hashCode();
    }
}
