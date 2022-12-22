package com.didichuxing.security.quickjs;

import java.lang.reflect.Type;

class JNIHelper {
    private static Type BOOLEAN_PRIMITIVE_TYPE = Boolean.TYPE;
    private static Type BYTE_PRIMITIVE_TYPE = Byte.TYPE;
    private static Type CHAR_PRIMITIVE_TYPE = Character.TYPE;
    private static Type DOUBLE_PRIMITIVE_TYPE = Double.TYPE;
    private static Type FLOAT_PRIMITIVE_TYPE = Float.TYPE;
    private static Type INT_PRIMITIVE_TYPE = Integer.TYPE;
    private static Type LONG_PRIMITIVE_TYPE = Long.TYPE;
    private static Type SHORT_PRIMITIVE_TYPE = Short.TYPE;
    private static Type VOID_PRIMITIVE_TYPE = Void.TYPE;

    JNIHelper() {
    }

    private static Object jsValueToJavaValue(JSContext jSContext, Type type, long j) {
        Object fromJSValue;
        synchronized (jSContext.jsRuntime) {
            try {
                jSContext.checkClosed();
                TypeAdapter adapter = jSContext.quickJS.getAdapter(type);
                JSValue wrapAsJSValue = jSContext.wrapAsJSValue(j);
                fromJSValue = adapter.fromJSValue(jSContext.quickJS, jSContext, wrapAsJSValue);
                if (wrapAsJSValue == null) {
                    QuickJS.destroyValue(jSContext.pointer, j);
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    QuickJS.destroyValue(jSContext.pointer, j);
                }
                throw th;
            }
        }
        return fromJSValue;
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, boolean z) {
        return javaValueToJSValue(jSContext, type, (Object) Boolean.valueOf(z));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, char c) {
        return javaValueToJSValue(jSContext, type, (Object) Character.valueOf(c));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, byte b) {
        return javaValueToJSValue(jSContext, type, (Object) Byte.valueOf(b));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, short s) {
        return javaValueToJSValue(jSContext, type, (Object) Short.valueOf(s));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, int i) {
        return javaValueToJSValue(jSContext, type, (Object) Integer.valueOf(i));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, long j) {
        return javaValueToJSValue(jSContext, type, (Object) Long.valueOf(j));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, float f) {
        return javaValueToJSValue(jSContext, type, (Object) Float.valueOf(f));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, double d) {
        return javaValueToJSValue(jSContext, type, (Object) Double.valueOf(d));
    }

    private static long javaValueToJSValue(JSContext jSContext, Type type, Object obj) {
        long j;
        synchronized (jSContext.jsRuntime) {
            jSContext.checkClosed();
            j = jSContext.quickJS.getAdapter(type).toJSValue(jSContext.quickJS, jSContext, obj).pointer;
        }
        return j;
    }

    private static boolean isPrimitiveType(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    private static boolean isSameType(Type type, Type type2) {
        return type == type2 || (type != null && type.equals(type2));
    }

    private static boolean unbox(Boolean bool) {
        return bool.booleanValue();
    }

    private static char unbox(Character ch) {
        return ch.charValue();
    }

    private static byte unbox(Byte b) {
        return b.byteValue();
    }

    private static short unbox(Short sh) {
        return sh.shortValue();
    }

    private static int unbox(Integer num) {
        return num.intValue();
    }

    private static long unbox(Long l) {
        return l.longValue();
    }

    private static float unbox(Float f) {
        return f.floatValue();
    }

    private static double unbox(Double d) {
        return d.doubleValue();
    }
}
