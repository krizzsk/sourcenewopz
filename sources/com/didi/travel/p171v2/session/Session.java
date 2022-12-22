package com.didi.travel.p171v2.session;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.didi.travel.p171v2.IKey;
import com.didi.travel.p171v2.TravelSDKV2;
import com.didi.travel.p171v2.biz.Biz;
import com.didi.travel.p171v2.biz.BizProxy;
import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.api.Api;
import com.didi.travel.p171v2.biz.api.ApiInvokePolicy;
import com.didi.travel.p171v2.biz.api.DataLevel;
import com.didi.travel.p171v2.biz.bff.BffVersion;
import com.didi.travel.p171v2.util.KeyUtil;
import com.didi.travel.p171v2.util.LogUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.travel.v2.session.Session */
public final class Session implements LifecycleOwner, IKey {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f44321a = Session.class.getSimpleName();

    /* renamed from: b */
    private static final AtomicInteger f44322b = new AtomicInteger();

    /* renamed from: c */
    private final String f44323c;

    /* renamed from: d */
    private final String f44324d;

    /* renamed from: e */
    private ArrayMap<Class<? extends IBiz>, Biz<? extends IBiz>> f44325e = new ArrayMap<>();

    /* renamed from: f */
    private ArrayMap<Class<? extends IBiz>, IBiz> f44326f = new ArrayMap<>();

    /* renamed from: g */
    private ArrayMap<Class<? extends IBiz>, IBiz> f44327g = new ArrayMap<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LifecycleRegistry f44328h = LifecycleRegistry.createUnsafe(this);

    /* renamed from: i */
    private final LifecycleOwner f44329i = ProcessLifecycleOwner.get();

    /* renamed from: j */
    private final LifecycleEventObserver f44330j = new LifecycleEventObserver() {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            int i = C144142.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
            if (i != 1) {
                if (i == 2 && Session.this.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                    Session.this.f44328h.setCurrentState(Lifecycle.State.STARTED);
                }
            } else if (Session.this.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                Session.this.f44328h.setCurrentState(Lifecycle.State.RESUMED);
            }
        }
    };

    /* renamed from: com.didi.travel.v2.session.Session$2 */
    static /* synthetic */ class C144142 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.p171v2.session.Session.C144142.<clinit>():void");
        }
    }

    public Session(String str, Class<? extends IBiz>... clsArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f44321a + ".new:tag is empty");
        } else if (clsArr == null || clsArr.length == 0) {
            throw new IllegalArgumentException(f44321a + ".new:bizClzArray is empty");
        } else {
            this.f44323c = str;
            this.f44324d = KeyUtil.generateSessionKey(String.valueOf(f44322b.addAndGet(1)), this.f44323c);
            for (Class<? extends IBiz> cls : clsArr) {
                if (cls != null) {
                    Biz<? extends IBiz> biz = TravelSDKV2.getBiz(cls);
                    this.f44325e.put(cls, biz);
                    this.f44326f.put(cls, biz.getIBiz());
                    this.f44327g.put(cls, (IBiz) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new SessionProxy(biz)));
                }
            }
            this.f44328h.setCurrentState(Lifecycle.State.INITIALIZED);
            this.f44329i.getLifecycle().addObserver(this.f44330j);
        }
    }

    public String getTag() {
        return this.f44323c;
    }

    public <T extends IBiz> T getIBiz(Class<T> cls) {
        return (IBiz) this.f44327g.get(cls);
    }

    public String getKey() {
        return this.f44324d;
    }

    public LifecycleRegistry getLifecycle() {
        return this.f44328h;
    }

    /* renamed from: com.didi.travel.v2.session.Session$SessionProxy */
    private class SessionProxy<T extends IBiz> implements InvocationHandler {
        private final Biz<T> mBiz;
        private final BizProxy<T> mBizProxy;

        public SessionProxy(Biz<T> biz) {
            this.mBiz = biz;
            this.mBizProxy = biz.getBizProxy();
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (TravelSDKV2.isDebug()) {
                LogUtils.m31491d(Session.f44321a, "invoke:proxy = " + obj + ", method = " + method + ", args = " + objArr);
            }
            Api api = this.mBizProxy.getApi(method);
            if (api == null) {
                return method.invoke(this.mBiz.getIBiz(), objArr);
            }
            if (!DataLevel.NONE.equals(api.getStoreDataLevel())) {
                int length = objArr.length - 1;
                if (ApiInvokePolicy.RPC.equals(api.getApiInvokePolicy())) {
                    objArr[length] = new SessionRpcRemoteCallback(Session.this, api, objArr, objArr[length]);
                } else if (ApiInvokePolicy.BFF.equals(api.getApiInvokePolicy())) {
                    if (BffVersion.V1.equals(api.getIIBff().version())) {
                        objArr[length] = new SessionBffRemoteCallback(Session.this, api, objArr, objArr[length]);
                    } else if (BffVersion.V2.equals(api.getIIBff().version())) {
                        objArr[length] = new SessionBffResponseListener(Session.this, api, objArr, objArr[length]);
                    } else {
                        throw new UnsupportedOperationException(Session.f44321a + ".invoke:Bff, not match bff version");
                    }
                }
            }
            return method.invoke(this.mBiz.getIBiz(), objArr);
        }
    }
}
