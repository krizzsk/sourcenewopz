package com.didi.drouter.store;

import android.net.Uri;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.utils.ReflectUtil;
import com.didi.drouter.utils.RouterLogger;
import com.didi.sdk.service.ForegroundService;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

public class RouterStore {
    public static final String HOST = "host";

    /* renamed from: a */
    static final String f19257a = "RegexRouter";

    /* renamed from: b */
    private static final Map<String, Object> f19258b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final Map<Class<? extends IRouterInterceptor>, RouterMeta> f19259c = new ArrayMap();

    /* renamed from: d */
    private static final Map<Class<?>, Set<RouterMeta>> f19260d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final Set<String> f19261e = new CopyOnWriteArraySet();

    /* renamed from: f */
    private static final CountDownLatch f19262f = new CountDownLatch(1);

    /* renamed from: g */
    private static volatile boolean f19263g;

    public static void load(String str) {
        if (!f19261e.contains(str)) {
            synchronized (RouterStore.class) {
                if (!f19261e.contains(str)) {
                    f19261e.add(str);
                    RouterLogger.getCoreLogger().mo59000d("[===DRouter load start in %s===]", Thread.currentThread().getName());
                    long currentTimeMillis = System.currentTimeMillis();
                    m14397a("Router", f19258b, str);
                    m14397a("Interceptor", f19259c, str);
                    m14397a(ForegroundService.NOTIFICATION_CHANNEL_GROUP_NAME, f19260d, str);
                    RouterLogger.getCoreLogger().mo59000d("[===DRouter load complete=== waste time: %sms]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if ("host".equals(str)) {
                        Statistics.m14398a();
                        f19263g = true;
                        f19262f.countDown();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m14397a(String str, Map<?, ?> map, String str2) {
        try {
            MetaLoader metaLoader = (MetaLoader) ReflectUtil.getInstance(Class.forName(String.format("com.didi.drouter.loader.%s.%sLoader", new Object[]{str2, str})), new Object[0]);
            if (metaLoader != null) {
                metaLoader.load(map);
                RouterLogger.getCoreLogger().mo59000d("%sLoader in %s load success", str, str2);
            }
        } catch (ClassNotFoundException unused) {
            RouterLogger.getCoreLogger().mo59001e("%sLoader in %s not found", str, str2);
        }
    }

    public static Set<RouterMeta> getRouterMetas(Uri uri) {
        m14395a();
        ArraySet arraySet = new ArraySet();
        Object obj = f19258b.get(uri.toString());
        if (obj instanceof RouterMeta) {
            arraySet.add((RouterMeta) obj);
        }
        Map map = (Map) f19258b.get(f19257a);
        if (map != null) {
            for (RouterMeta routerMeta : map.values()) {
                if (routerMeta.isRegexMatch(uri)) {
                    arraySet.add(routerMeta);
                }
            }
        }
        return arraySet;
    }

    public static Map<Class<? extends IRouterInterceptor>, RouterMeta> getInterceptors() {
        m14395a();
        return f19259c;
    }

    public static Set<RouterMeta> getServiceMetas(Class<?> cls) {
        m14395a();
        Set<RouterMeta> set = f19260d.get(cls);
        return set == null ? Collections.emptySet() : set;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b6 A[SYNTHETIC, Splitter:B:25:0x00b6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.didi.drouter.store.IRegister register(final com.didi.drouter.store.RouterKey r11, final com.didi.drouter.router.IRouterHandler r12) {
        /*
            java.lang.Class<com.didi.drouter.store.RouterStore> r0 = com.didi.drouter.store.RouterStore.class
            monitor-enter(r0)
            if (r11 == 0) goto L_0x00bd
            if (r12 == 0) goto L_0x00bd
            m14395a()     // Catch:{ all -> 0x00c5 }
            int r1 = com.didi.drouter.store.RouterMeta.HANDLER     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterMeta r2 = com.didi.drouter.store.RouterMeta.build(r1)     // Catch:{ all -> 0x00c5 }
            android.net.Uri r1 = r11.f19226a     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r1.getScheme()     // Catch:{ all -> 0x00c5 }
            android.net.Uri r1 = r11.f19226a     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = r1.getHost()     // Catch:{ all -> 0x00c5 }
            android.net.Uri r1 = r11.f19226a     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r1.getPath()     // Catch:{ all -> 0x00c5 }
            r1 = 0
            r6 = r1
            java.lang.Class r6 = (java.lang.Class) r6     // Catch:{ all -> 0x00c5 }
            java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[] r7 = r11.f19227b     // Catch:{ all -> 0x00c5 }
            int r8 = r11.f19228c     // Catch:{ all -> 0x00c5 }
            r9 = 0
            boolean r10 = r11.f19229d     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterMeta r1 = r2.assembleRouter((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.Class<?>) r6, (java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[]) r7, (int) r8, (int) r9, (boolean) r10)     // Catch:{ all -> 0x00c5 }
            r1.setHandler(r11, r12)     // Catch:{ all -> 0x00c5 }
            boolean r2 = r1.isRegexUri()     // Catch:{ all -> 0x00c5 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0066
            java.util.Map<java.lang.String, java.lang.Object> r2 = f19258b     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = "RegexRouter"
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x00c5 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x00c5 }
            if (r2 != 0) goto L_0x0054
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x00c5 }
            r2.<init>()     // Catch:{ all -> 0x00c5 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = f19258b     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = "RegexRouter"
            r5.put(r6, r2)     // Catch:{ all -> 0x00c5 }
        L_0x0054:
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            boolean r5 = r2.containsKey(r5)     // Catch:{ all -> 0x00c5 }
            if (r5 != 0) goto L_0x007d
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            r2.put(r5, r1)     // Catch:{ all -> 0x00c5 }
            goto L_0x007b
        L_0x0066:
            java.util.Map<java.lang.String, java.lang.Object> r2 = f19258b     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            boolean r2 = r2.containsKey(r5)     // Catch:{ all -> 0x00c5 }
            if (r2 != 0) goto L_0x007d
            java.util.Map<java.lang.String, java.lang.Object> r2 = f19258b     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            r2.put(r5, r1)     // Catch:{ all -> 0x00c5 }
        L_0x007b:
            r2 = 1
            goto L_0x007e
        L_0x007d:
            r2 = 0
        L_0x007e:
            if (r2 == 0) goto L_0x00b6
            androidx.lifecycle.LifecycleOwner r2 = r11.f19230e     // Catch:{ all -> 0x00c5 }
            if (r2 == 0) goto L_0x0092
            androidx.lifecycle.LifecycleOwner r2 = r11.f19230e     // Catch:{ all -> 0x00c5 }
            androidx.lifecycle.Lifecycle r2 = r2.getLifecycle()     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterStore$1 r5 = new com.didi.drouter.store.RouterStore$1     // Catch:{ all -> 0x00c5 }
            r5.<init>(r11, r12)     // Catch:{ all -> 0x00c5 }
            r2.addObserver(r5)     // Catch:{ all -> 0x00c5 }
        L_0x0092:
            com.didi.drouter.utils.RouterLogger r2 = com.didi.drouter.utils.RouterLogger.getCoreLogger()     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = "register \"%s\" with handler \"%s\" success"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = r1.getLegalUri()     // Catch:{ all -> 0x00c5 }
            r6[r3] = r1     // Catch:{ all -> 0x00c5 }
            java.lang.Class r1 = r12.getClass()     // Catch:{ all -> 0x00c5 }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x00c5 }
            r6[r4] = r1     // Catch:{ all -> 0x00c5 }
            r2.mo59000d(r5, r6)     // Catch:{ all -> 0x00c5 }
            com.didi.drouter.store.RouterRegister r1 = new com.didi.drouter.store.RouterRegister     // Catch:{ all -> 0x00c5 }
            r1.<init>((com.didi.drouter.store.RouterKey) r11, (com.didi.drouter.router.IRouterHandler) r12, (boolean) r4)     // Catch:{ all -> 0x00c5 }
            monitor-exit(r0)
            return r1
        L_0x00b6:
            com.didi.drouter.store.RouterRegister r1 = new com.didi.drouter.store.RouterRegister     // Catch:{ all -> 0x00c5 }
            r1.<init>((com.didi.drouter.store.RouterKey) r11, (com.didi.drouter.router.IRouterHandler) r12, (boolean) r3)     // Catch:{ all -> 0x00c5 }
            monitor-exit(r0)
            return r1
        L_0x00bd:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c5 }
            java.lang.String r12 = "argument null illegal error"
            r11.<init>(r12)     // Catch:{ all -> 0x00c5 }
            throw r11     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.store.RouterStore.register(com.didi.drouter.store.RouterKey, com.didi.drouter.router.IRouterHandler):com.didi.drouter.store.IRegister");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004a, code lost:
        if (r1.remove(r11.getLegalUri()) != null) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m14396a(com.didi.drouter.store.RouterKey r11, com.didi.drouter.router.IRouterHandler r12) {
        /*
            java.lang.Class<com.didi.drouter.store.RouterStore> r0 = com.didi.drouter.store.RouterStore.class
            monitor-enter(r0)
            if (r11 == 0) goto L_0x0080
            if (r12 == 0) goto L_0x0080
            int r1 = com.didi.drouter.store.RouterMeta.HANDLER     // Catch:{ all -> 0x007d }
            com.didi.drouter.store.RouterMeta r2 = com.didi.drouter.store.RouterMeta.build(r1)     // Catch:{ all -> 0x007d }
            android.net.Uri r1 = r11.f19226a     // Catch:{ all -> 0x007d }
            java.lang.String r3 = r1.getScheme()     // Catch:{ all -> 0x007d }
            android.net.Uri r1 = r11.f19226a     // Catch:{ all -> 0x007d }
            java.lang.String r4 = r1.getHost()     // Catch:{ all -> 0x007d }
            android.net.Uri r1 = r11.f19226a     // Catch:{ all -> 0x007d }
            java.lang.String r5 = r1.getPath()     // Catch:{ all -> 0x007d }
            r1 = 0
            r6 = r1
            java.lang.Class r6 = (java.lang.Class) r6     // Catch:{ all -> 0x007d }
            java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[] r7 = r11.f19227b     // Catch:{ all -> 0x007d }
            int r8 = r11.f19228c     // Catch:{ all -> 0x007d }
            r9 = 0
            boolean r10 = r11.f19229d     // Catch:{ all -> 0x007d }
            com.didi.drouter.store.RouterMeta r11 = r2.assembleRouter((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.Class<?>) r6, (java.lang.Class<? extends com.didi.drouter.router.IRouterInterceptor>[]) r7, (int) r8, (int) r9, (boolean) r10)     // Catch:{ all -> 0x007d }
            boolean r1 = r11.isRegexUri()     // Catch:{ all -> 0x007d }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0050
            java.util.Map<java.lang.String, java.lang.Object> r1 = f19258b     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "RegexRouter"
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x007d }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x004e
            java.lang.String r4 = r11.getLegalUri()     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x004e
        L_0x004c:
            r1 = 1
            goto L_0x005d
        L_0x004e:
            r1 = 0
            goto L_0x005d
        L_0x0050:
            java.util.Map<java.lang.String, java.lang.Object> r1 = f19258b     // Catch:{ all -> 0x007d }
            java.lang.String r4 = r11.getLegalUri()     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r1.remove(r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x004e
            goto L_0x004c
        L_0x005d:
            if (r1 == 0) goto L_0x0080
            com.didi.drouter.utils.RouterLogger r1 = com.didi.drouter.utils.RouterLogger.getCoreLogger()     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "unregister \"%s\" with handler \"%s\" success"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x007d }
            java.lang.String r11 = r11.getLegalUri()     // Catch:{ all -> 0x007d }
            r5[r3] = r11     // Catch:{ all -> 0x007d }
            java.lang.Class r11 = r12.getClass()     // Catch:{ all -> 0x007d }
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ all -> 0x007d }
            r5[r2] = r11     // Catch:{ all -> 0x007d }
            r1.mo59000d(r4, r5)     // Catch:{ all -> 0x007d }
            goto L_0x0080
        L_0x007d:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        L_0x0080:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.store.RouterStore.m14396a(com.didi.drouter.store.RouterKey, com.didi.drouter.router.IRouterHandler):void");
    }

    public static synchronized <T> IRegister register(final ServiceKey<T> serviceKey, final T t) {
        RouterRegister routerRegister;
        synchronized (RouterStore.class) {
            if (serviceKey != null) {
                if (!(serviceKey.f19264a == null || t == null)) {
                    RouterMeta assembleService = RouterMeta.build(RouterMeta.SERVICE).assembleService((Class<?>) null, serviceKey.f19265b, serviceKey.f19266c, 0, 0);
                    assembleService.setService(serviceKey, t);
                    serviceKey.f19268e = assembleService;
                    Set set = f19260d.get(serviceKey.f19264a);
                    if (set == null) {
                        set = Collections.newSetFromMap(new ConcurrentHashMap());
                        f19260d.put(serviceKey.f19264a, set);
                    }
                    set.add(assembleService);
                    if (serviceKey.f19267d != null) {
                        serviceKey.f19267d.getLifecycle().addObserver(new LifecycleObserver() {
                            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                            public void onDestroy(LifecycleOwner lifecycleOwner) {
                                RouterStore.unregister(serviceKey, t);
                            }
                        });
                    }
                    RouterLogger.getCoreLogger().mo59000d("register \"%s\" with service \"%s\" success, size:%s", serviceKey.f19264a.getSimpleName(), t, Integer.valueOf(set.size()));
                    routerRegister = new RouterRegister((ServiceKey<?>) serviceKey, (Object) t, true);
                }
            }
            throw new IllegalArgumentException("argument null illegal error");
        }
        return routerRegister;
    }

    public static synchronized void unregister(ServiceKey<?> serviceKey, Object obj) {
        synchronized (RouterStore.class) {
            if (!(serviceKey == null || obj == null)) {
                Set set = f19260d.get(serviceKey.f19264a);
                if (set != null && set.remove(serviceKey.f19268e)) {
                    RouterLogger.getCoreLogger().mo59000d("unregister \"%s\" with service \"%s\" success", serviceKey.f19264a.getSimpleName(), obj);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m14395a() {
        if (!f19263g) {
            load("host");
            try {
                f19262f.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
