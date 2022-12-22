package com.didi.sdk.messagecenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.didi.sdk.messagecenter.interfaces.IStore;
import com.didi.sdk.messagecenter.interfaces.ISubscribe;
import com.didi.sdk.messagecenter.model.PushMessage;

/* renamed from: com.didi.sdk.messagecenter.b */
/* compiled from: SubscribeCenter */
class C12468b implements ISubscribe {

    /* renamed from: a */
    private static ISubscribe f36761a;

    /* renamed from: b */
    private IStore f36762b = new C12469c();

    /* renamed from: c */
    private final LifecycleObserver f36763c = new SubscribeCenter$1(this);

    private C12468b() {
    }

    /* renamed from: a */
    public static ISubscribe m26031a() {
        if (f36761a == null) {
            synchronized (C12468b.class) {
                if (f36761a == null) {
                    f36761a = new C12468b();
                }
            }
        }
        return f36761a;
    }

    public ISubscribe.ISubscribeWrapper bind(Object obj) {
        return new C12470d(obj, this.f36762b);
    }

    public ISubscribe.ISubscribeWrapper autoBind(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            Lifecycle lifecycle = lifecycleOwner.getLifecycle();
            if (lifecycle != null) {
                lifecycle.addObserver(this.f36763c);
                return new C12470d(lifecycleOwner, this.f36762b);
            }
            throw new IllegalArgumentException("lifecycle is null");
        }
        throw new IllegalArgumentException("lifecycleOwner is null");
    }

    public void release(Object obj) {
        this.f36762b.remove(obj);
    }

    public void release(Object obj, Class<? extends PushMessage> cls) {
        this.f36762b.removeMessage(obj, cls);
    }
}
