package com.didi.drouter.router;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.utils.ReflectUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class InterceptorLoader {

    /* renamed from: a */
    private static final Map<Class<? extends IRouterInterceptor>, IRouterInterceptor> f19175a = new ArrayMap();

    /* renamed from: b */
    private static final Map<Class<? extends IRouterInterceptor>, WeakReference<IRouterInterceptor>> f19176b = new ArrayMap();

    /* renamed from: c */
    private static final Set<Class<? extends IRouterInterceptor>> f19177c = new ArraySet();

    InterceptorLoader() {
    }

    static {
        for (Map.Entry next : RouterStore.getInterceptors().entrySet()) {
            if (((RouterMeta) next.getValue()).isGlobal()) {
                f19177c.add(next.getKey());
            }
        }
    }

    /* renamed from: a */
    static Queue<IRouterInterceptor> m14355a(RouterMeta routerMeta) {
        ArraySet<Class> arraySet = new ArraySet<>(f19177c);
        Class[] interceptors = routerMeta.getInterceptors();
        if (interceptors != null) {
            arraySet.addAll(Arrays.asList(interceptors));
        }
        PriorityQueue priorityQueue = new PriorityQueue(11, new InterceptorComparator());
        for (Class a : arraySet) {
            priorityQueue.add(m14354a((Class<? extends IRouterInterceptor>) a));
        }
        return priorityQueue;
    }

    private static class InterceptorComparator implements Comparator<IRouterInterceptor> {
        private InterceptorComparator() {
        }

        public int compare(IRouterInterceptor iRouterInterceptor, IRouterInterceptor iRouterInterceptor2) {
            return RouterStore.getInterceptors().get(iRouterInterceptor2.getClass()).getPriority() - RouterStore.getInterceptors().get(iRouterInterceptor.getClass()).getPriority();
        }
    }

    /* renamed from: a */
    private static IRouterInterceptor m14354a(Class<? extends IRouterInterceptor> cls) {
        IRouterInterceptor iRouterInterceptor;
        IRouterInterceptor iRouterInterceptor2 = f19175a.get(cls);
        if (iRouterInterceptor2 == null && f19176b.containsKey(cls)) {
            iRouterInterceptor2 = (IRouterInterceptor) f19176b.get(cls).get();
        }
        if (iRouterInterceptor == null) {
            synchronized (InterceptorLoader.class) {
                iRouterInterceptor = f19175a.get(cls);
                if (iRouterInterceptor == null && f19176b.containsKey(cls)) {
                    iRouterInterceptor = (IRouterInterceptor) f19176b.get(cls).get();
                }
                if (iRouterInterceptor == null) {
                    RouterMeta routerMeta = RouterStore.getInterceptors().get(cls);
                    if (routerMeta == null) {
                        routerMeta = RouterMeta.build(RouterMeta.INTERCEPTOR).assembleInterceptor(cls, 0, false, 0);
                        RouterStore.getInterceptors().put(cls, routerMeta);
                    }
                    IRouterInterceptor iRouterInterceptor3 = (IRouterInterceptor) ReflectUtil.getInstance((Class<?>) cls, new Object[0]);
                    if (routerMeta.getCache() == 2) {
                        f19175a.put(cls, iRouterInterceptor3);
                    } else if (routerMeta.getCache() == 1) {
                        f19176b.put(cls, new WeakReference(iRouterInterceptor3));
                    }
                    iRouterInterceptor = iRouterInterceptor3;
                }
            }
        }
        return iRouterInterceptor;
    }
}
