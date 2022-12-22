package com.didi.component.core.event;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.component.core.util.GenericHelper;
import com.didi.sdk.apm.SystemUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public final class BaseEventPublisher {

    /* renamed from: a */
    private static BaseEventPublisher f12752a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, Set<OnEventListener>> f12753b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<String, Set<OnEventListener>> f12754c = new HashMap();

    /* renamed from: d */
    private final Map<String, Set<OnEventListener>> f12755d = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Map<String, Object> f12756e = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SerialExecutor f12757f = new SerialExecutor();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f12758g = new Handler(Looper.getMainLooper());

    private interface Callback {
        public static final Callback NULL = null;

        void onCallback(boolean z);
    }

    public interface OnEventListener<T> {
        void onEvent(String str, T t);
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StrictType {
    }

    @Deprecated
    public void setPage(Context context, String str) {
    }

    private BaseEventPublisher() {
    }

    public static BaseEventPublisher getPublisher() {
        if (f12752a == null) {
            synchronized (BaseEventPublisher.class) {
                if (f12752a == null) {
                    f12752a = new BaseEventPublisher();
                }
            }
        }
        return f12752a;
    }

    public boolean subscribe(String str, OnEventListener<?> onEventListener) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        m8694a(str, onEventListener, (Class<?>) null, Callback.NULL);
        return true;
    }

    public boolean subscribe(String str, OnEventListener<?> onEventListener, Class<?> cls) {
        Set set;
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        if (cls == null) {
            return subscribe(str, onEventListener);
        }
        String b = m8698b(str, (Class<? extends Object>) cls);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        Map<String, Set<OnEventListener>> map = m8703b((Class) onEventListener.getClass()) ? this.f12753b : this.f12754c;
        synchronized (map) {
            set = map.get(b);
            if (set == null) {
                set = new LinkedHashSet();
                map.put(b, set);
            }
        }
        synchronized (set) {
            if (set.contains(onEventListener)) {
                return false;
            }
            set.add(onEventListener);
            return true;
        }
    }

    public boolean subscribeSync(String str, OnEventListener<?> onEventListener) {
        Set set;
        String b = m8698b(str, (Class<? extends Object>) GenericHelper.getGenericTypeArgument(onEventListener.getClass(), OnEventListener.class, 0));
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        Map<String, Set<OnEventListener>> map = m8703b((Class) onEventListener.getClass()) ? this.f12753b : this.f12754c;
        synchronized (map) {
            set = map.get(b);
            if (set == null) {
                set = new LinkedHashSet();
                map.put(b, set);
            }
        }
        synchronized (set) {
            if (set.contains(onEventListener)) {
                return false;
            }
            set.add(onEventListener);
            return true;
        }
    }

    /* renamed from: a */
    private void m8694a(String str, OnEventListener<?> onEventListener, Class<?> cls, Callback callback) {
        final OnEventListener<?> onEventListener2 = onEventListener;
        final Class<?> cls2 = cls;
        final String str2 = str;
        final Callback callback2 = callback;
        this.f12757f.execute(new Runnable() {
            public void run() {
                String str;
                Map map;
                Set set;
                OnEventListener onEventListener = onEventListener2;
                if (onEventListener != null && onEventListener.getClass() != null) {
                    Class cls = cls2;
                    if (cls == null) {
                        Class<?> cls2 = null;
                        try {
                            cls2 = GenericHelper.getGenericTypeArgument(onEventListener2.getClass(), OnEventListener.class, 0);
                        } catch (Exception unused) {
                        }
                        if (cls2 == null) {
                            cls2 = GenericHelper.getDeclaredGenericType(onEventListener2);
                        }
                        if (cls2 != null) {
                            str = BaseEventPublisher.m8698b(str2, (Class<? extends Object>) cls2);
                        } else {
                            return;
                        }
                    } else {
                        str = BaseEventPublisher.m8698b(str2, (Class<? extends Object>) cls);
                    }
                    if (TextUtils.isEmpty(str)) {
                        Callback callback = callback2;
                        if (callback != null) {
                            callback.onCallback(false);
                            return;
                        }
                        return;
                    }
                    if (BaseEventPublisher.m8703b((Class) onEventListener2.getClass())) {
                        map = BaseEventPublisher.this.f12753b;
                    } else {
                        map = BaseEventPublisher.this.f12754c;
                    }
                    synchronized (map) {
                        set = (Set) map.get(str);
                        if (set == null) {
                            set = new LinkedHashSet();
                            map.put(str, set);
                        }
                    }
                    synchronized (set) {
                        if (!set.contains(onEventListener2)) {
                            set.add(onEventListener2);
                            if (callback2 != null) {
                                callback2.onCallback(true);
                            }
                        } else if (callback2 != null) {
                            callback2.onCallback(false);
                        }
                    }
                }
            }
        });
    }

    public boolean subscribeStickySync(String str, OnEventListener onEventListener) {
        boolean subscribe = subscribe(str, onEventListener);
        if (subscribe) {
            synchronized (this.f12756e) {
                if (this.f12756e.containsKey(str)) {
                    onEventListener.onEvent(str, this.f12756e.get(str));
                }
            }
        }
        return subscribe;
    }

    public boolean subscribeSticky(String str, OnEventListener onEventListener) {
        return subscribeSticky(str, onEventListener, (Class<?>) null);
    }

    public boolean subscribeSticky(final String str, final OnEventListener onEventListener, Class<?> cls) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        m8694a(str, (OnEventListener<?>) onEventListener, cls, (Callback) new Callback() {
            public void onCallback(boolean z) {
                if (z) {
                    synchronized (BaseEventPublisher.this.f12756e) {
                        if (BaseEventPublisher.this.f12756e.containsKey(str)) {
                            BaseEventPublisher.this.f12758g.post(new Runnable() {
                                public void run() {
                                    if (!BaseEventPublisher.this.m8705c(str, onEventListener) && !BaseEventPublisher.this.m8705c(str, onEventListener)) {
                                        onEventListener.onEvent(str, BaseEventPublisher.this.f12756e.get(str));
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });
        return true;
    }

    /* renamed from: a */
    private void m8693a(String str, OnEventListener onEventListener) {
        Set set;
        synchronized (this.f12755d) {
            set = this.f12755d.get(str);
            if (set == null) {
                set = new LinkedHashSet();
                this.f12755d.put(str, set);
            }
        }
        synchronized (set) {
            set.add(onEventListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8701b(String str, OnEventListener onEventListener) {
        Set set;
        synchronized (this.f12755d) {
            set = this.f12755d.get(str);
        }
        if (set != null) {
            synchronized (set) {
                set.remove(onEventListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m8705c(String str, OnEventListener onEventListener) {
        Set set;
        boolean contains;
        synchronized (this.f12755d) {
            set = this.f12755d.get(str);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            contains = set.contains(onEventListener);
        }
        return contains;
    }

    public boolean unsubscribe(String str, OnEventListener onEventListener) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        return unsubscribeAsync(str, onEventListener);
    }

    public boolean unsubscribeSync(String str, OnEventListener onEventListener) {
        Set set;
        boolean remove;
        String b = m8698b(str, (Class<? extends Object>) GenericHelper.getGenericTypeArgument(onEventListener.getClass(), OnEventListener.class, 0));
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        Map<String, Set<OnEventListener>> map = m8703b((Class) onEventListener.getClass()) ? this.f12753b : this.f12754c;
        synchronized (map) {
            set = map.get(b);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            remove = set.remove(onEventListener);
        }
        return remove;
    }

    public boolean unsubscribeAsync(final String str, final OnEventListener onEventListener) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        m8693a(str, onEventListener);
        this.f12757f.execute(new Runnable() {
            public void run() {
                Map map;
                Set set;
                try {
                    try {
                        String a = BaseEventPublisher.m8698b(str, (Class<? extends Object>) GenericHelper.getGenericTypeArgument(onEventListener.getClass(), OnEventListener.class, 0));
                        if (!TextUtils.isEmpty(a)) {
                            if (BaseEventPublisher.m8703b((Class) onEventListener.getClass())) {
                                map = BaseEventPublisher.this.f12753b;
                            } else {
                                map = BaseEventPublisher.this.f12754c;
                            }
                            synchronized (map) {
                                set = (Set) map.get(a);
                            }
                            if (set != null) {
                                synchronized (set) {
                                    set.remove(onEventListener);
                                }
                                BaseEventPublisher.this.m8701b(str, onEventListener);
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        BaseEventPublisher.this.m8701b(str, onEventListener);
                        throw th;
                    }
                } catch (Exception unused) {
                    SystemUtils.log(6, "BaseEventPublisher", "unsubscribe caught exception: category=" + str + ", listener=" + onEventListener, (Throwable) null, "com.didi.component.core.event.BaseEventPublisher$3", 363);
                }
                BaseEventPublisher.this.m8701b(str, onEventListener);
            }
        });
        return true;
    }

    public boolean unsubscribe(String str, OnEventListener onEventListener, Class<?> cls) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        return unsubscribeAsync(str, onEventListener, cls);
    }

    public boolean unsubscribeSync(String str, OnEventListener onEventListener, Class<?> cls) {
        Set set;
        boolean remove;
        String b = m8698b(str, (Class<? extends Object>) cls);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        Map<String, Set<OnEventListener>> map = m8703b((Class) onEventListener.getClass()) ? this.f12753b : this.f12754c;
        synchronized (map) {
            set = map.get(b);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            remove = set.remove(onEventListener);
        }
        return remove;
    }

    public boolean unsubscribeAsync(final String str, final OnEventListener onEventListener, final Class<?> cls) {
        m8693a(str, onEventListener);
        this.f12757f.execute(new Runnable() {
            public void run() {
                Map map;
                Set set;
                try {
                    String a = BaseEventPublisher.m8698b(str, (Class<? extends Object>) cls);
                    if (!TextUtils.isEmpty(a)) {
                        if (BaseEventPublisher.m8703b((Class) onEventListener.getClass())) {
                            map = BaseEventPublisher.this.f12753b;
                        } else {
                            map = BaseEventPublisher.this.f12754c;
                        }
                        synchronized (map) {
                            set = (Set) map.get(a);
                        }
                        if (set != null) {
                            synchronized (set) {
                                set.remove(onEventListener);
                            }
                            BaseEventPublisher.this.m8701b(str, onEventListener);
                            return;
                        }
                    }
                    BaseEventPublisher.this.m8701b(str, onEventListener);
                } catch (Throwable th) {
                    BaseEventPublisher.this.m8701b(str, onEventListener);
                    throw th;
                }
            }
        });
        return true;
    }

    public void publish(String str) {
        publish(str, (Object) null);
    }

    public void publish(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            publishAsync(str, obj);
        }
    }

    public void publishSync(String str, Object obj) {
        Class cls = obj != null ? obj.getClass() : NullEvent.class;
        String b = m8698b(str, (Class<? extends Object>) cls);
        m8695a(b, str, obj, this.f12754c);
        m8695a(b, str, obj, this.f12753b);
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            m8695a(m8698b(str, (Class<? extends Object>) superclass), str, obj, this.f12753b);
        }
    }

    public void publishAsync(final String str, final Object obj) {
        this.f12757f.execute(new Runnable() {
            public void run() {
                Object obj = obj;
                Class cls = obj != null ? obj.getClass() : NullEvent.class;
                final String a = BaseEventPublisher.m8698b(str, (Class<? extends Object>) cls);
                BaseEventPublisher.this.f12757f.execute(new Runnable() {
                    public void run() {
                        BaseEventPublisher.this.m8702b(a, str, obj, BaseEventPublisher.this.f12754c);
                    }
                });
                BaseEventPublisher.this.f12757f.execute(new Runnable() {
                    public void run() {
                        BaseEventPublisher.this.m8702b(a, str, obj, BaseEventPublisher.this.f12753b);
                    }
                });
                for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                    final String a2 = BaseEventPublisher.m8698b(str, (Class<? extends Object>) superclass);
                    BaseEventPublisher.this.f12757f.execute(new Runnable() {
                        public void run() {
                            BaseEventPublisher.this.m8702b(a2, str, obj, BaseEventPublisher.this.f12753b);
                        }
                    });
                }
            }
        });
    }

    public void publishSticky(String str) {
        publishSticky(str, (Object) null);
    }

    public void publishSticky(String str, Object obj) {
        Object obj2;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f12756e) {
                if (obj != null) {
                    obj2 = obj;
                } else {
                    obj2 = new NullEvent();
                }
                this.f12756e.put(str, obj2);
            }
            publish(str, obj);
        }
    }

    public void removeStickyEvent(String str) {
        synchronized (this.f12756e) {
            this.f12756e.remove(str);
        }
    }

    public void removeAllStickyEvent() {
        synchronized (this.f12756e) {
            this.f12756e.clear();
        }
    }

    /* renamed from: a */
    private void m8695a(String str, String str2, Object obj, Map<String, Set<OnEventListener>> map) {
        Set set;
        OnEventListener[] onEventListenerArr;
        synchronized (map) {
            set = map.get(str);
        }
        if (set != null) {
            synchronized (set) {
                if (set != null) {
                    try {
                        onEventListenerArr = (OnEventListener[]) set.toArray(new OnEventListener[set.size()]);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                } else {
                    onEventListenerArr = null;
                }
            }
            int length = onEventListenerArr != null ? onEventListenerArr.length : 0;
            for (int i = 0; i < length; i++) {
                OnEventListener onEventListener = onEventListenerArr[i];
                if (onEventListener != null) {
                    onEventListener.onEvent(str2, obj);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8702b(String str, String str2, Object obj, Map<String, Set<OnEventListener>> map) {
        Set set;
        OnEventListener[] onEventListenerArr;
        synchronized (map) {
            set = map.get(str);
        }
        if (set != null) {
            synchronized (set) {
                if (set != null) {
                    try {
                        onEventListenerArr = (OnEventListener[]) set.toArray(new OnEventListener[set.size()]);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                } else {
                    onEventListenerArr = null;
                }
            }
            int length = onEventListenerArr != null ? onEventListenerArr.length : 0;
            for (int i = 0; i < length; i++) {
                final OnEventListener onEventListener = onEventListenerArr[i];
                if (onEventListener != null && !m8705c(str2, onEventListener)) {
                    final String str3 = str2;
                    final Set set2 = set;
                    final Object obj2 = obj;
                    this.f12758g.post(new Runnable() {
                        public void run() {
                            if (!BaseEventPublisher.this.m8705c(str3, onEventListener)) {
                                synchronized (set2) {
                                    if (set2.contains(onEventListener)) {
                                        onEventListener.onEvent(str3, obj2);
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public String toString() {
        return "{spread: " + this.f12753b + ", normal: " + this.f12754c + "}";
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m8703b(Class cls) {
        try {
            Annotation[][] parameterAnnotations = cls.getMethod("onEvent", new Class[]{String.class, Object.class}).getParameterAnnotations();
            if (parameterAnnotations != null && parameterAnnotations.length == 2) {
                int length = parameterAnnotations[1] != null ? parameterAnnotations[1].length : 0;
                for (int i = 0; i < length; i++) {
                    if (StrictType.class.isAssignableFrom(parameterAnnotations[1][i].getClass())) {
                        return false;
                    }
                }
            }
        } catch (NoSuchMethodException unused) {
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m8698b(String str, Class<? extends Object> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        return str + "@" + cls.getCanonicalName();
    }

    public static final class NullEvent {
        private NullEvent() {
        }
    }

    private static class SerialExecutor implements Executor {
        Runnable mActive;
        final ArrayDeque<Runnable> mTasks;

        private SerialExecutor() {
            this.mTasks = new ArrayDeque<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: private */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
            }
        }
    }
}
