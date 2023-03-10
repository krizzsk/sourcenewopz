package org.mozilla.javascript;

import java.lang.reflect.Method;

public class InterfaceAdapter {
    private final Object proxyHelper;

    static Object create(Context context, Class<?> cls, ScriptableObject scriptableObject) {
        InterfaceAdapter interfaceAdapter;
        if (cls.isInterface()) {
            Scriptable topCallScope = ScriptRuntime.getTopCallScope(context);
            ClassCache classCache = ClassCache.get(topCallScope);
            InterfaceAdapter interfaceAdapter2 = (InterfaceAdapter) classCache.getInterfaceAdapter(cls);
            ContextFactory factory = context.getFactory();
            if (interfaceAdapter2 == null) {
                Method[] methods = cls.getMethods();
                if (scriptableObject instanceof Callable) {
                    int length = methods.length;
                    if (length != 0) {
                        int i = 1;
                        if (length > 1) {
                            String name = methods[0].getName();
                            while (i < length) {
                                if (name.equals(methods[i].getName())) {
                                    i++;
                                } else {
                                    throw Context.reportRuntimeError1("msg.no.function.interface.conversion", cls.getName());
                                }
                            }
                        }
                    } else {
                        throw Context.reportRuntimeError1("msg.no.empty.interface.conversion", cls.getName());
                    }
                }
                InterfaceAdapter interfaceAdapter3 = new InterfaceAdapter(factory, cls);
                classCache.cacheInterfaceAdapter(cls, interfaceAdapter3);
                interfaceAdapter = interfaceAdapter3;
            } else {
                interfaceAdapter = interfaceAdapter2;
            }
            return VMBridge.instance.newInterfaceProxy(interfaceAdapter.proxyHelper, factory, interfaceAdapter, scriptableObject, topCallScope);
        }
        throw new IllegalArgumentException();
    }

    private InterfaceAdapter(ContextFactory contextFactory, Class<?> cls) {
        this.proxyHelper = VMBridge.instance.getInterfaceProxyHelper(contextFactory, new Class[]{cls});
    }

    public Object invoke(ContextFactory contextFactory, Object obj, Scriptable scriptable, Object obj2, Method method, Object[] objArr) {
        final Object obj3 = obj;
        final Scriptable scriptable2 = scriptable;
        final Object obj4 = obj2;
        final Method method2 = method;
        final Object[] objArr2 = objArr;
        return contextFactory.call(new ContextAction() {
            public Object run(Context context) {
                return InterfaceAdapter.this.invokeImpl(context, obj3, scriptable2, obj4, method2, objArr2);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Object invokeImpl(Context context, Object obj, Scriptable scriptable, Object obj2, Method method, Object[] objArr) {
        Callable callable;
        if (obj instanceof Callable) {
            callable = (Callable) obj;
        } else {
            String name = method.getName();
            Object property = ScriptableObject.getProperty((Scriptable) obj, name);
            if (property == ScriptableObject.NOT_FOUND) {
                Context.reportWarning(ScriptRuntime.getMessage1("msg.undefined.function.interface", name));
                Class<?> returnType = method.getReturnType();
                if (returnType == Void.TYPE) {
                    return null;
                }
                return Context.jsToJava((Object) null, returnType);
            } else if (property instanceof Callable) {
                callable = (Callable) property;
            } else {
                throw Context.reportRuntimeError1("msg.not.function.interface", name);
            }
        }
        WrapFactory wrapFactory = context.getWrapFactory();
        if (objArr == null) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            int length = objArr.length;
            for (int i = 0; i != length; i++) {
                Object obj3 = objArr[i];
                if (!(obj3 instanceof String) && !(obj3 instanceof Number) && !(obj3 instanceof Boolean)) {
                    objArr[i] = wrapFactory.wrap(context, scriptable, obj3, (Class<?>) null);
                }
            }
        }
        Object call = callable.call(context, scriptable, wrapFactory.wrapAsJavaObject(context, scriptable, obj2, (Class<?>) null), objArr);
        Class<?> returnType2 = method.getReturnType();
        if (returnType2 == Void.TYPE) {
            return null;
        }
        return Context.jsToJava(call, returnType2);
    }
}
