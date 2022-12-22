package com.didichuxing.security.quickjs;

import com.didichuxing.security.quickjs.TypeAdapter;
import java.lang.reflect.Type;

class JSValueAdapter {
    static final TypeAdapter.Factory FACTORY = new TypeAdapter.Factory() {
        public TypeAdapter<?> create(TypeAdapter.Depot depot, Type type) {
            if (type == JSValue.class) {
                return JSValueAdapter.JS_VALUE_TYPE_ADAPTER;
            }
            return null;
        }
    };
    /* access modifiers changed from: private */
    public static final TypeAdapter<JSValue> JS_VALUE_TYPE_ADAPTER = new TypeAdapter<JSValue>() {
        public JSValue fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            return jSValue;
        }

        public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
            if (jSValue != null) {
                return jSValue;
            }
            throw new NullPointerException("value == null");
        }
    };

    JSValueAdapter() {
    }
}
