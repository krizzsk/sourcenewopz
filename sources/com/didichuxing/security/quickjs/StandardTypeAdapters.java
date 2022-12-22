package com.didichuxing.security.quickjs;

import com.didichuxing.security.quickjs.TypeAdapter;
import java.lang.reflect.Type;

class StandardTypeAdapters {
    /* access modifiers changed from: private */
    public static final TypeAdapter<Boolean> BOOLEAN_TYPE_ADAPTER = new TypeAdapter<Boolean>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Boolean bool) {
            return context.createJSBoolean(bool.booleanValue());
        }

        public Boolean fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Boolean.valueOf(((JSBoolean) jSValue.cast(JSBoolean.class)).getBoolean());
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Byte> BYTE_TYPE_ADAPTER = new TypeAdapter<Byte>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Byte b) {
            return context.createJSNumber((int) b.byteValue());
        }

        public Byte fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Byte.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getByte());
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Character> CHARACTER_TYPE_ADAPTER = new TypeAdapter<Character>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Character ch) {
            return context.createJSString(ch.toString());
        }

        public Character fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            String string = ((JSString) jSValue.cast(JSString.class)).getString();
            if (string.length() == 1) {
                return Character.valueOf(string.charAt(0));
            }
            throw new JSDataException("Can't treat \"" + string + "\" as char");
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Double> DOUBLE_TYPE_ADAPTER = new TypeAdapter<Double>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Double d) {
            return context.createJSNumber(d.doubleValue());
        }

        public Double fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Double.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getDouble());
        }
    };
    static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() {
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == Void.TYPE) {
                return StandardTypeAdapters.VOID_TYPE_ADAPTER;
            }
            if (type == Boolean.TYPE) {
                return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER;
            }
            if (type == Byte.TYPE) {
                return StandardTypeAdapters.BYTE_TYPE_ADAPTER;
            }
            if (type == Character.TYPE) {
                return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER;
            }
            if (type == Short.TYPE) {
                return StandardTypeAdapters.SHORT_TYPE_ADAPTER;
            }
            if (type == Integer.TYPE) {
                return StandardTypeAdapters.INTEGER_TYPE_ADAPTER;
            }
            if (type == Long.TYPE) {
                return StandardTypeAdapters.LONG_TYPE_ADAPTER;
            }
            if (type == Float.TYPE) {
                return StandardTypeAdapters.FLOAT_TYPE_ADAPTER;
            }
            if (type == Double.TYPE) {
                return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER;
            }
            if (type == Void.class) {
                return StandardTypeAdapters.VOID_TYPE_ADAPTER;
            }
            if (type == Boolean.class) {
                return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER.nullable();
            }
            if (type == Byte.class) {
                return StandardTypeAdapters.BYTE_TYPE_ADAPTER.nullable();
            }
            if (type == Character.class) {
                return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER.nullable();
            }
            if (type == Short.class) {
                return StandardTypeAdapters.SHORT_TYPE_ADAPTER.nullable();
            }
            if (type == Integer.class) {
                return StandardTypeAdapters.INTEGER_TYPE_ADAPTER.nullable();
            }
            if (type == Long.class) {
                return StandardTypeAdapters.LONG_TYPE_ADAPTER.nullable();
            }
            if (type == Float.class) {
                return StandardTypeAdapters.FLOAT_TYPE_ADAPTER.nullable();
            }
            if (type == Double.class) {
                return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER.nullable();
            }
            if (type == String.class) {
                return StandardTypeAdapters.STRING_TYPE_ADAPTER.nullable();
            }
            return null;
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Float> FLOAT_TYPE_ADAPTER = new TypeAdapter<Float>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Float f) {
            return context.createJSNumber((double) f.floatValue());
        }

        public Float fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Float.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getFloat());
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Integer> INTEGER_TYPE_ADAPTER = new TypeAdapter<Integer>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Integer num) {
            return context.createJSNumber(num.intValue());
        }

        public Integer fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Integer.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getInt());
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Long> LONG_TYPE_ADAPTER = new TypeAdapter<Long>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Long l) {
            return context.createJSNumber((double) l.longValue());
        }

        public Long fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Long.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getLong());
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Short> SHORT_TYPE_ADAPTER = new TypeAdapter<Short>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Short sh) {
            return context.createJSNumber((int) sh.shortValue());
        }

        public Short fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return Short.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getShort());
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<String> STRING_TYPE_ADAPTER = new TypeAdapter<String>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, String str) {
            return context.createJSString(str);
        }

        public String fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return ((JSString) jSValue.cast(JSString.class)).getString();
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<Void> VOID_TYPE_ADAPTER = new TypeAdapter<Void>() {
        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Void voidR) {
            return context.createJSNull();
        }

        public Void fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            if ((jSValue instanceof JSNull) || (jSValue instanceof JSUndefined)) {
                return null;
            }
            throw new JSDataException("excepted: JSNull or JSUndefined, actual: " + jSValue.getClass().getSimpleName());
        }
    };

    StandardTypeAdapters() {
    }
}
