package com.didi.drouter.service;

import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.remote.RemoteBridge;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.store.Statistics;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ServiceAgent<T> {

    /* renamed from: a */
    private static final Map<Class<?>, Object> f19215a = new ConcurrentHashMap();

    /* renamed from: b */
    private static final Map<Class<?>, WeakReference<Object>> f19216b = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<Class<?>, RouterMeta> f19217c = new ConcurrentHashMap();

    /* renamed from: d */
    private final Class<T> f19218d;

    /* renamed from: e */
    private String f19219e = "";

    /* renamed from: f */
    private Object f19220f;

    /* renamed from: g */
    private String f19221g;

    /* renamed from: h */
    private int f19222h;

    /* renamed from: i */
    private WeakReference<LifecycleOwner> f19223i;

    /* renamed from: j */
    private T f19224j;

    ServiceAgent(Class<T> cls) {
        Statistics.track("service");
        this.f19218d = cls;
        for (RouterMeta next : RouterStore.getServiceMetas(cls)) {
            if (next.getRouterType() == RouterMeta.SERVICE && !next.isDynamic()) {
                this.f19217c.put(next.getTargetClass(), next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58922a(String str) {
        if (str == null) {
            str = "";
        }
        this.f19219e = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58921a(Object obj) {
        this.f19220f = obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo58926b(String str) {
        this.f19221g = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58919a(int i) {
        this.f19222h = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58920a(LifecycleOwner lifecycleOwner) {
        this.f19223i = lifecycleOwner != null ? new WeakReference<>(lifecycleOwner) : null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo58925b(T t) {
        this.f19224j = t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<Class<? extends T>> mo58917a() {
        ArrayList arrayList = new ArrayList();
        if (this.f19218d != null) {
            for (RouterMeta next : this.f19217c.values()) {
                if (!next.isDynamic() && m14384a(next.getServiceAlias(), (IFeatureMatcher<Object>) next.getFeatureMatcher())) {
                    arrayList.add(next.getTargetClass());
                }
            }
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, new ServiceComparator());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Class<? extends T> mo58923b() {
        List a = mo58917a();
        if (!a.isEmpty()) {
            return (Class) a.get(0);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<T> mo58918a(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        Class<T> cls = this.f19218d;
        if (cls != null) {
            for (RouterMeta next : RouterStore.getServiceMetas(cls)) {
                if (next.isDynamic() && m14384a(next.getServiceAlias(), (IFeatureMatcher<Object>) next.getFeatureMatcher())) {
                    arrayList.add(next.getService());
                }
            }
            for (Class a : mo58917a()) {
                Object a2 = m14382a((Class<?>) a, objArr);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public T mo58924b(Object... objArr) {
        if (!TextUtils.isEmpty(this.f19221g)) {
            RouterLogger.getCoreLogger().mo59000d("[..] Get remote service \"%s\" by RemoteBridge", this.f19218d.getSimpleName());
            return RemoteBridge.load(this.f19221g, this.f19222h, this.f19223i).getService(this.f19218d, this.f19219e, this.f19220f, objArr);
        }
        for (RouterMeta next : RouterStore.getServiceMetas(this.f19218d)) {
            if (next.isDynamic() && m14384a(next.getServiceAlias(), (IFeatureMatcher<Object>) next.getFeatureMatcher())) {
                RouterLogger.getCoreLogger().mo59000d("[..] Get local dynamic service \"%s\" with result \"%s\"", this.f19218d.getSimpleName(), next.getService().getClass().getName());
                return next.getService();
            }
        }
        T a = m14382a((Class<?>) mo58923b(), objArr);
        if (a == null) {
            RouterLogger coreLogger = RouterLogger.getCoreLogger();
            Object[] objArr2 = new Object[2];
            objArr2[0] = this.f19218d.getSimpleName();
            T t = this.f19224j;
            objArr2[1] = t != null ? t.getClass().getName() : null;
            coreLogger.mo59002w("[..] Get local service \"%s\" fail with default instance \"%s\"", objArr2);
            return this.f19224j;
        } else if (this.f19218d != ICallService.class || !CallHandler.isCallService(a)) {
            RouterLogger.getCoreLogger().mo59000d("[..] Get local static service \"%s\" with result \"%s\"", this.f19218d.getSimpleName(), a.getClass().getSimpleName());
            return a;
        } else {
            RouterLogger.getCoreLogger().mo59000d("[..] Get local ICallService service \"%s\" with result \"%s\"", this.f19218d.getSimpleName(), a.getClass().getSimpleName());
            return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f19218d}, new CallHandler(a));
        }
    }

    /* renamed from: a */
    private boolean m14384a(String str, IFeatureMatcher<Object> iFeatureMatcher) {
        return this.f19219e.equals(str) && (iFeatureMatcher == null || iFeatureMatcher.match(this.f19220f));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
        return r9;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m14382a(java.lang.Class<?> r8, java.lang.Object... r9) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0004
            r8 = 0
            return r8
        L_0x0004:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = f19215a
            java.lang.Object r0 = r0.get(r8)
            if (r0 != 0) goto L_0x0020
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r1 = f19216b
            boolean r1 = r1.containsKey(r8)
            if (r1 == 0) goto L_0x0020
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r0 = f19216b
            java.lang.Object r0 = r0.get(r8)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
        L_0x0020:
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0095
            java.lang.Class<com.didi.drouter.service.ServiceLoader> r3 = com.didi.drouter.service.ServiceLoader.class
            monitor-enter(r3)
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = f19215a     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x0043
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r4 = f19216b     // Catch:{ all -> 0x0092 }
            boolean r4 = r4.containsKey(r8)     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x0043
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r0 = f19216b     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0092 }
        L_0x0043:
            if (r0 != 0) goto L_0x0090
            java.lang.Object r9 = com.didi.drouter.utils.ReflectUtil.getInstance((java.lang.Class<?>) r8, (java.lang.Object[]) r9)     // Catch:{ all -> 0x0092 }
            if (r9 == 0) goto L_0x008f
            com.didi.drouter.utils.RouterLogger r0 = com.didi.drouter.utils.RouterLogger.getCoreLogger()     // Catch:{ all -> 0x0092 }
            java.lang.String r4 = "[..] Get service \"%s\" instance by create new"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x0092 }
            java.lang.Class r6 = r9.getClass()     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ all -> 0x0092 }
            r5[r1] = r6     // Catch:{ all -> 0x0092 }
            r0.mo59000d(r4, r5)     // Catch:{ all -> 0x0092 }
            java.util.Map<java.lang.Class<?>, com.didi.drouter.store.RouterMeta> r0 = r7.f19217c     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            com.didi.drouter.store.RouterMeta r0 = (com.didi.drouter.store.RouterMeta) r0     // Catch:{ all -> 0x0092 }
            int r0 = r0.getCache()     // Catch:{ all -> 0x0092 }
            r1 = 2
            if (r0 != r1) goto L_0x0075
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = f19215a     // Catch:{ all -> 0x0092 }
            r0.put(r8, r9)     // Catch:{ all -> 0x0092 }
            goto L_0x008d
        L_0x0075:
            java.util.Map<java.lang.Class<?>, com.didi.drouter.store.RouterMeta> r0 = r7.f19217c     // Catch:{ all -> 0x0092 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0092 }
            com.didi.drouter.store.RouterMeta r0 = (com.didi.drouter.store.RouterMeta) r0     // Catch:{ all -> 0x0092 }
            int r0 = r0.getCache()     // Catch:{ all -> 0x0092 }
            if (r0 != r2) goto L_0x008d
            java.util.Map<java.lang.Class<?>, java.lang.ref.WeakReference<java.lang.Object>> r0 = f19216b     // Catch:{ all -> 0x0092 }
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0092 }
            r1.<init>(r9)     // Catch:{ all -> 0x0092 }
            r0.put(r8, r1)     // Catch:{ all -> 0x0092 }
        L_0x008d:
            monitor-exit(r3)     // Catch:{ all -> 0x0092 }
            return r9
        L_0x008f:
            r0 = r9
        L_0x0090:
            monitor-exit(r3)     // Catch:{ all -> 0x0092 }
            goto L_0x0095
        L_0x0092:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0092 }
            throw r8
        L_0x0095:
            if (r0 == 0) goto L_0x00ac
            com.didi.drouter.utils.RouterLogger r8 = com.didi.drouter.utils.RouterLogger.getCoreLogger()
            java.lang.String r9 = "[..] Get service \"%s\" instance by cache"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2[r1] = r3
            r8.mo59000d(r9, r2)
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.service.ServiceAgent.m14382a(java.lang.Class, java.lang.Object[]):java.lang.Object");
    }

    private static class CallHandler implements InvocationHandler {
        Object callService;

        CallHandler(Object obj) {
            this.callService = obj;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object[] objArr2 = objArr[0];
            if (objArr2 == null) {
                objArr2 = new Object[]{null};
            }
            Object obj2 = this.callService;
            if ((obj2 instanceof ICallService0) && objArr2.length == 0) {
                return ((ICallService0) obj2).call();
            }
            Object obj3 = this.callService;
            if ((obj3 instanceof ICallService1) && objArr2.length == 1) {
                return ((ICallService1) obj3).call(objArr2[0]);
            }
            Object obj4 = this.callService;
            if ((obj4 instanceof ICallService2) && objArr2.length == 2) {
                return ((ICallService2) obj4).call(objArr2[0], objArr2[1]);
            }
            Object obj5 = this.callService;
            if ((obj5 instanceof ICallService3) && objArr2.length == 3) {
                return ((ICallService3) obj5).call(objArr2[0], objArr2[1], objArr2[2]);
            }
            Object obj6 = this.callService;
            if ((obj6 instanceof ICallService4) && objArr2.length == 4) {
                return ((ICallService4) obj6).call(objArr2[0], objArr2[1], objArr2[2], objArr2[3]);
            }
            Object obj7 = this.callService;
            if ((obj7 instanceof ICallService5) && objArr2.length == 5) {
                return ((ICallService5) obj7).call(objArr2[0], objArr2[1], objArr2[2], objArr2[3], objArr2[4]);
            }
            Object obj8 = this.callService;
            if (obj8 instanceof ICallServiceN) {
                return ((ICallServiceN) obj8).call(objArr2);
            }
            RouterLogger.getCoreLogger().mo59001e("%s not match with argument length %s ", this.callService.getClass().getSimpleName(), Integer.valueOf(objArr2.length));
            return null;
        }

        static boolean isCallService(Object obj) {
            return (obj instanceof ICallService0) || (obj instanceof ICallService1) || (obj instanceof ICallService2) || (obj instanceof ICallService3) || (obj instanceof ICallService4) || (obj instanceof ICallService5) || (obj instanceof ICallServiceN);
        }
    }

    private class ServiceComparator implements Comparator<Class<?>> {
        private ServiceComparator() {
        }

        public int compare(Class<?> cls, Class<?> cls2) {
            return ((RouterMeta) ServiceAgent.this.f19217c.get(cls2)).getPriority() - ((RouterMeta) ServiceAgent.this.f19217c.get(cls)).getPriority();
        }
    }
}
