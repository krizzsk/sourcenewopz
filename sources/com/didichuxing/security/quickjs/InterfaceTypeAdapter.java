package com.didichuxing.security.quickjs;

import com.didichuxing.security.quickjs.TypeAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class InterfaceTypeAdapter extends TypeAdapter<Object> {
    static final TypeAdapter.Factory FACTORY = $$Lambda$InterfaceTypeAdapter$u3EuMDr6lmdU2hz9spQi5p2M91Q.INSTANCE;
    private static final JSValueHolderTag JS_VALUE_HOLDER_TAG = new JSValueHolderTag();
    private final Map<String, Method> methods;
    private final Class<?> rawType;

    private interface JSValueHolder {
        JSValue getJSValue(JSValueHolderTag jSValueHolderTag);
    }

    static Map<String, Method> getInterfaceMethods(Type type) {
        Class<?> rawType2 = Types.getRawType(type);
        if (!rawType2.isInterface()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Method method : rawType2.getMethods()) {
            Type resolve = Types.resolve(type, rawType2, method.getGenericReturnType());
            if (resolve instanceof TypeVariable) {
                return null;
            }
            String name = method.getName();
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            int length = genericParameterTypes.length;
            Type[] typeArr = new Type[length];
            for (int i = 0; i < length; i++) {
                typeArr[i] = Types.resolve(type, rawType2, genericParameterTypes[i]);
                if (typeArr[i] instanceof TypeVariable) {
                    return null;
                }
            }
            Method method2 = (Method) hashMap.get(name);
            if (method2 != null) {
                if (!Arrays.equals(method2.parameterTypes, typeArr)) {
                    return null;
                }
                if (!resolve.equals(method2.returnType)) {
                    if (Types.getRawType(resolve).isAssignableFrom(Types.getRawType(method2.returnType))) {
                    }
                }
            }
            hashMap.put(name, new Method(resolve, name, typeArr));
        }
        return hashMap;
    }

    static /* synthetic */ TypeAdapter lambda$static$0(TypeAdapter.Depot depot, Type type) {
        Map<String, Method> interfaceMethods = getInterfaceMethods(type);
        if (interfaceMethods == null) {
            return null;
        }
        return new InterfaceTypeAdapter(Types.getRawType(type), interfaceMethods).nullable();
    }

    private InterfaceTypeAdapter(Class<?> cls, Map<String, Method> map) {
        this.rawType = cls;
        this.methods = map;
    }

    public JSValue toJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, Object obj) {
        if (obj instanceof JSValueHolder) {
            return ((JSValueHolder) obj).getJSValue(JS_VALUE_HOLDER_TAG);
        }
        JSObject createJSObject = context.createJSObject(obj);
        for (Method next : this.methods.values()) {
            createJSObject.setProperty(next.name, (JSValue) context.createJSFunction(obj, next));
        }
        return createJSObject;
    }

    public Object fromJSValue(TypeAdapter.Depot depot, TypeAdapter.Context context, JSValue jSValue) {
        JSObject jSObject = (JSObject) jSValue.cast(JSObject.class);
        Object javaObject = jSObject.getJavaObject();
        if (this.rawType.isInstance(javaObject)) {
            return javaObject;
        }
        return Proxy.newProxyInstance(this.rawType.getClassLoader(), new Class[]{this.rawType, JSValueHolder.class}, new InvocationHandler(jSValue, depot, context, jSObject) {
            public final /* synthetic */ JSValue f$1;
            public final /* synthetic */ TypeAdapter.Depot f$2;
            public final /* synthetic */ TypeAdapter.Context f$3;
            public final /* synthetic */ JSObject f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return InterfaceTypeAdapter.this.lambda$fromJSValue$1$InterfaceTypeAdapter(this.f$1, this.f$2, this.f$3, this.f$4, obj, method, objArr);
            }
        });
    }

    public /* synthetic */ Object lambda$fromJSValue$1$InterfaceTypeAdapter(JSValue jSValue, TypeAdapter.Depot depot, TypeAdapter.Context context, JSObject jSObject, Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr != null && objArr.length == 1 && objArr[0] == JS_VALUE_HOLDER_TAG) {
            return jSValue;
        }
        String name = method.getName();
        Method method2 = this.methods.get(name);
        if (method2 != null) {
            int length = objArr != null ? objArr.length : 0;
            if (length == method2.parameterTypes.length) {
                JSValue[] jSValueArr = new JSValue[length];
                for (int i = 0; i < length; i++) {
                    jSValueArr[i] = depot.getAdapter(method2.parameterTypes[i]).toJSValue(depot, context, objArr[i]);
                }
                return depot.getAdapter(method2.returnType).fromJSValue(depot, context, ((JSFunction) jSObject.getProperty(name).cast(JSFunction.class)).invoke(jSObject, jSValueArr));
            }
            throw new IllegalStateException("Parameter number doesn't match: " + name);
        }
        throw new NoSuchMethodException("Can't find method: " + name);
    }

    private static class JSValueHolderTag {
        private JSValueHolderTag() {
        }
    }
}
