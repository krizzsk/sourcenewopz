package com.didi.sdk.event;

import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EventDispatcherImpl {

    /* renamed from: a */
    static ExecutorService f35841a = Executors.newCachedThreadPool();

    /* renamed from: b */
    public static String f35842b = "EventDispatcherImpl";

    /* renamed from: c */
    private static final boolean f35843c = true;

    /* renamed from: d */
    private static final Map<Class<?>, List<Class<?>>> f35844d = new HashMap();

    /* renamed from: e */
    private final Map<Class<?>, CopyOnWriteArrayList<C12188h>> f35845e = new HashMap();

    /* renamed from: f */
    private final Map<Object, List<Class<?>>> f35846f = new HashMap();

    /* renamed from: g */
    private final Map<Class<?>, Event> f35847g = new ConcurrentHashMap();

    /* renamed from: h */
    private final ThreadLocal<PostingThreadState> f35848h = new ThreadLocal<PostingThreadState>() {
        /* access modifiers changed from: protected */
        public PostingThreadState initialValue() {
            return new PostingThreadState();
        }
    };

    /* renamed from: i */
    private final C12183c f35849i = new C12183c(this, Looper.getMainLooper(), 10);

    /* renamed from: j */
    private final C12182b f35850j = new C12182b(this);

    /* renamed from: k */
    private final C12181a f35851k = new C12181a(this);

    /* renamed from: l */
    private final C12187g f35852l = new C12187g();

    /* renamed from: m */
    private boolean f35853m;

    /* renamed from: a */
    public static void m25375a() {
        C12187g.m25410a();
        f35844d.clear();
    }

    /* renamed from: a */
    public static void m25378a(Class<?> cls) {
        C12187g.m25412b(cls);
    }

    /* renamed from: b */
    public static void m25384b() {
        C12187g.m25411b();
    }

    /* renamed from: a */
    public void mo91598a(Object obj) {
        m25381a(obj, false, 0);
    }

    /* renamed from: a */
    public void mo91599a(Object obj, int i) {
        m25381a(obj, false, i);
    }

    /* renamed from: b */
    public void mo91602b(Object obj) {
        m25381a(obj, true, 0);
    }

    /* renamed from: b */
    public void mo91603b(Object obj, int i) {
        m25381a(obj, true, i);
    }

    /* renamed from: a */
    private synchronized void m25381a(Object obj, boolean z, int i) {
        for (C12186f a : this.f35852l.mo91627a(obj.getClass())) {
            m25379a(obj, a, z, i);
        }
    }

    /* renamed from: a */
    private synchronized void m25382a(Object obj, boolean z, Class<?> cls, Class<?>... clsArr) {
        for (C12186f next : this.f35852l.mo91627a(obj.getClass())) {
            if (cls == next.f35872c) {
                m25379a(obj, next, z, 0);
            } else if (clsArr != null) {
                int length = clsArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (clsArr[i] == next.f35872c) {
                        m25379a(obj, next, z, 0);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m25379a(Object obj, C12186f fVar, boolean z, int i) {
        Event event;
        boolean z2 = true;
        this.f35853m = true;
        Class<?> cls = fVar.f35872c;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f35845e.get(cls);
        C12188h hVar = new C12188h(obj, fVar, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f35845e.put(cls, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((C12188h) it.next()).equals(hVar)) {
                    throw new StoreException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || hVar.f35879c > ((C12188h) copyOnWriteArrayList.get(i2)).f35879c) {
                copyOnWriteArrayList.add(i2, hVar);
            } else {
                i2++;
            }
        }
        List list = this.f35846f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f35846f.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.f35847g) {
                event = this.f35847g.get(cls);
            }
            if (event != null) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    z2 = false;
                }
                m25377a(hVar, event, z2);
            }
        }
    }

    /* renamed from: c */
    public synchronized boolean mo91606c(Object obj) {
        return this.f35846f.containsKey(obj);
    }

    /* renamed from: a */
    private void m25380a(Object obj, Class<?> cls) {
        List list = this.f35845e.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                C12188h hVar = (C12188h) list.get(i);
                if (hVar.f35877a == obj) {
                    hVar.f35880d = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* renamed from: d */
    public synchronized void mo91607d(Object obj) {
        List<Class> list = this.f35846f.get(obj);
        if (list != null) {
            for (Class a : list) {
                m25380a(obj, (Class<?>) a);
            }
            this.f35846f.remove(obj);
        } else {
            String str = f35842b;
            SystemUtils.log(5, str, "Subscriber to unregister was not registered before: " + obj.getClass(), (Throwable) null, "com.didi.sdk.event.EventDispatcherImpl", 334);
        }
    }

    /* renamed from: a */
    public void mo91595a(Event event) {
        PostingThreadState postingThreadState = this.f35848h.get();
        List<Event> list = postingThreadState.eventQueue;
        list.add(event);
        if (!postingThreadState.isPosting) {
            postingThreadState.isMainThread = Looper.getMainLooper() == Looper.myLooper();
            postingThreadState.isPosting = true;
            if (!postingThreadState.canceled) {
                while (!list.isEmpty()) {
                    try {
                        m25376a(list.remove(0), postingThreadState);
                    } finally {
                        postingThreadState.isPosting = false;
                        postingThreadState.isMainThread = false;
                    }
                }
                return;
            }
            throw new StoreException("Internal error. Abort state was not reset");
        }
    }

    /* renamed from: e */
    public void mo91608e(Object obj) {
        PostingThreadState postingThreadState = this.f35848h.get();
        if (!postingThreadState.isPosting) {
            throw new StoreException("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new StoreException("Event may not be null");
        } else if (postingThreadState.event != obj) {
            throw new StoreException("Only the currently handled event may be aborted");
        } else if (postingThreadState.subscription.f35878b.f35871b == ThreadMode.PostThread) {
            postingThreadState.canceled = true;
        } else {
            throw new StoreException(" event handlers may only abort the incoming event");
        }
    }

    /* renamed from: b */
    public void mo91601b(Event event) {
        synchronized (this.f35847g) {
            this.f35847g.put(event.getClass(), event);
        }
        mo91595a(event);
    }

    /* renamed from: b */
    public <T> T mo91600b(Class<T> cls) {
        T cast;
        synchronized (this.f35847g) {
            cast = cls.cast(this.f35847g.get(cls));
        }
        return cast;
    }

    /* renamed from: c */
    public <T> T mo91604c(Class<T> cls) {
        T cast;
        synchronized (this.f35847g) {
            cast = cls.cast(this.f35847g.remove(cls));
        }
        return cast;
    }

    /* renamed from: f */
    public boolean mo91609f(Object obj) {
        synchronized (this.f35847g) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f35847g.get(cls))) {
                return false;
            }
            this.f35847g.remove(cls);
            return true;
        }
    }

    /* renamed from: c */
    public void mo91605c() {
        synchronized (this.f35847g) {
            this.f35847g.clear();
        }
    }

    /* renamed from: a */
    private void m25376a(Event event, PostingThreadState postingThreadState) throws Error {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Class<?> cls = event.getClass();
        List<Class<?>> d = m25385d(cls);
        int size = d.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            Class cls2 = d.get(i);
            synchronized (this) {
                copyOnWriteArrayList = this.f35845e.get(cls2);
            }
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    C12188h hVar = (C12188h) it.next();
                    postingThreadState.event = event;
                    postingThreadState.subscription = hVar;
                    try {
                        m25377a(hVar, event, postingThreadState.isMainThread);
                        if (postingThreadState.canceled) {
                            break;
                        }
                    } finally {
                        postingThreadState.event = null;
                        postingThreadState.subscription = null;
                        postingThreadState.canceled = false;
                    }
                }
                z = true;
            }
        }
        if (!z) {
            String str = f35842b;
            SystemUtils.log(3, str, "No subscribers registered for event " + cls, (Throwable) null, "com.didi.sdk.event.EventDispatcherImpl", 483);
        }
    }

    /* renamed from: com.didi.sdk.event.EventDispatcherImpl$2 */
    static /* synthetic */ class C121802 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$event$ThreadMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.sdk.event.ThreadMode[] r0 = com.didi.sdk.event.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$event$ThreadMode = r0
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$sdk$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.event.EventDispatcherImpl.C121802.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m25377a(C12188h hVar, Event event, boolean z) {
        int i = C121802.$SwitchMap$com$didi$sdk$event$ThreadMode[hVar.f35878b.f35871b.ordinal()];
        if (i == 1) {
            mo91597a(hVar, event);
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    this.f35851k.mo91612a(hVar, event);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + hVar.f35878b.f35871b);
            } else if (z) {
                this.f35850j.mo91614a(hVar, event);
            } else {
                mo91597a(hVar, event);
            }
        } else if (z) {
            mo91597a(hVar, event);
        } else {
            this.f35849i.mo91616a(hVar, event);
        }
    }

    /* renamed from: d */
    private List<Class<?>> m25385d(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f35844d) {
            list = f35844d.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    m25383a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f35844d.put(cls, list);
            }
        }
        return list;
    }

    /* renamed from: a */
    static void m25383a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                m25383a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91596a(C12184d dVar) {
        Event event = dVar.f35865a;
        C12188h hVar = dVar.f35866b;
        C12184d.m25405a(dVar);
        if (hVar.f35880d) {
            mo91597a(hVar, event);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo91597a(C12188h hVar, Event event) throws Error {
        try {
            hVar.f35878b.f35870a.invoke(hVar.f35877a, new Object[]{event});
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (event instanceof StoreExceptionEvent) {
                String str = f35842b;
                SystemUtils.log(6, str, "StoreExceptionEvent subscriber " + hVar.f35877a.getClass() + " threw an exception", cause, "com.didi.sdk.event.EventDispatcherImpl", 573);
                StoreExceptionEvent storeExceptionEvent = (StoreExceptionEvent) event;
                String str2 = f35842b;
                SystemUtils.log(6, str2, "Initial event " + storeExceptionEvent.causingEvent + " caused exception in " + storeExceptionEvent.causingSubscriber, storeExceptionEvent.throwable, "com.didi.sdk.event.EventDispatcherImpl", 578);
                return;
            }
            String str3 = f35842b;
            SystemUtils.log(6, str3, "Could not dispatch event: " + event.getClass() + " to subscribing class " + hVar.f35877a.getClass(), cause, "com.didi.sdk.event.EventDispatcherImpl", 583);
            mo91595a((Event) new StoreExceptionEvent(this, cause, event, hVar.f35877a));
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    static final class PostingThreadState {
        boolean canceled;
        Event event;
        List<Event> eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;
        C12188h subscription;

        PostingThreadState() {
        }
    }
}
