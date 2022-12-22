package com.didichuxing.security.quickjs;

import com.didichuxing.security.quickjs.TypeAdapter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

class ArrayTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapter.Factory FACTORY = $$Lambda$ArrayTypeAdapter$hnFMMUaFiHDVleGkQ6fHgeFuRLk.INSTANCE;
    private final TypeAdapter<Object> elementAdapter;
    private final Class<?> elementClass;

    static /* synthetic */ TypeAdapter lambda$static$0(TypeAdapter.Depot depot, Type type) {
        Type arrayComponentType = Types.arrayComponentType(type);
        if (arrayComponentType == null) {
            return null;
        }
        return new ArrayTypeAdapter(Types.getRawType(arrayComponentType), depot.getAdapter(arrayComponentType)).nullable();
    }

    private ArrayTypeAdapter(Class<?> cls, TypeAdapter<Object> typeAdapter) {
        this.elementClass = cls;
        this.elementAdapter = typeAdapter;
    }

    public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Object obj) {
        JSArray createJSArray = context.createJSArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            createJSArray.setProperty(i, this.elementAdapter.toJSValue(depot, context, Array.get(obj, i)));
        }
        return createJSArray;
    }

    public Object fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
        JSArray jSArray = (JSArray) jSValue.cast(JSArray.class);
        int length = jSArray.getLength();
        Object newInstance = Array.newInstance(this.elementClass, length);
        for (int i = 0; i < length; i++) {
            Array.set(newInstance, i, this.elementAdapter.fromJSValue(depot, context, jSArray.getProperty(i)));
        }
        return newInstance;
    }
}
