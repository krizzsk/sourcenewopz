package com.didichuxing.security.quickjs;

import java.lang.reflect.Type;

public abstract class TypeAdapter<T> {

    public interface Context {
        JSArray createJSArray();

        JSBoolean createJSBoolean(boolean z);

        JSFunction createJSFunction(Object obj, Method method);

        JSFunction createJSFunctionS(Class cls, Method method);

        JSNull createJSNull();

        JSNumber createJSNumber(double d);

        JSNumber createJSNumber(int i);

        JSObject createJSObject();

        JSObject createJSObject(Object obj);

        JSString createJSString(String str);

        JSUndefined createJSUndefined();
    }

    public interface Depot {
        <T> TypeAdapter<T> getAdapter(Type type);
    }

    public interface Factory {
        TypeAdapter<?> create(Depot depot, Type type);
    }

    public abstract T fromJSValue(Depot depot, Context context, JSValue jSValue);

    public abstract JSValue toJSValue(Depot depot, Context context, T t);

    public final TypeAdapter<T> nullable() {
        return new NullableTypeAdapter(this);
    }

    private static class NullableTypeAdapter<T> extends TypeAdapter<T> {
        private final TypeAdapter<T> delegate;

        NullableTypeAdapter(TypeAdapter<T> typeAdapter) {
            this.delegate = typeAdapter;
        }

        public JSValue toJSValue(Depot depot, Context context, T t) {
            if (t == null) {
                return context.createJSNull();
            }
            return this.delegate.toJSValue(depot, context, t);
        }

        public T fromJSValue(Depot depot, Context context, JSValue jSValue) {
            if ((jSValue instanceof JSNull) || (jSValue instanceof JSUndefined)) {
                return null;
            }
            return this.delegate.fromJSValue(depot, context, jSValue);
        }
    }
}
