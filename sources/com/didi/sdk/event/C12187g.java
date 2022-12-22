package com.didi.sdk.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;

/* renamed from: com.didi.sdk.event.g */
/* compiled from: SubscriberMethodFinder */
class C12187g {

    /* renamed from: a */
    private static final int f35874a = 1032;

    /* renamed from: b */
    private static final Map<String, List<C12186f>> f35875b = new HashMap();

    /* renamed from: c */
    private static final Map<Class<?>, Class<?>> f35876c = new ConcurrentHashMap();

    C12187g() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C12186f> mo91627a(Class<?> cls) {
        List<C12186f> list;
        EventReceiver eventReceiver;
        String str = cls.getName() + '.' + cls.getClassLoader().hashCode();
        synchronized (f35875b) {
            list = f35875b.get(str);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name2 = method.getName();
                if ((method.getModifiers() & 1032) == 0) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && (eventReceiver = (EventReceiver) method.getAnnotation(EventReceiver.class)) != null && !f35876c.containsKey(cls2)) {
                        Class cls3 = parameterTypes[0];
                        if (Event.class.isAssignableFrom(cls3)) {
                            ThreadMode value = eventReceiver.value();
                            method.setAccessible(true);
                            sb.setLength(0);
                            sb.append(name2);
                            sb.append(Typography.greater);
                            sb.append(cls3.getName());
                            if (hashSet.add(sb.toString())) {
                                arrayList.add(new C12186f(method, value, cls3));
                            }
                        }
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (f35875b) {
                f35875b.put(str, arrayList);
            }
            return arrayList;
        }
        throw new StoreException("Subscriber " + cls + " has no @EventReceiver methods called ");
    }

    /* renamed from: a */
    static void m25410a() {
        synchronized (f35875b) {
            f35875b.clear();
        }
    }

    /* renamed from: b */
    static void m25412b(Class<?> cls) {
        if (f35875b.isEmpty()) {
            f35876c.put(cls, cls);
            return;
        }
        throw new IllegalStateException("This method must be called before registering anything");
    }

    /* renamed from: b */
    public static void m25411b() {
        f35876c.clear();
    }
}
