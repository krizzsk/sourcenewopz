package p001a;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a.c */
/* compiled from: SingleLiveEvent.kt */
public class C0020c<T> extends MutableLiveData<T> {

    /* renamed from: a */
    public final AtomicBoolean f32a = new AtomicBoolean(false);

    /* renamed from: a */
    public static final void m67a(C0020c cVar, Observer observer, Object obj) {
        Intrinsics.checkNotNullParameter(cVar, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (cVar.f32a.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(lifecycleOwner, new Observer(observer) {
            public final /* synthetic */ Observer f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                C0020c.m67a(C0020c.this, this.f$1, obj);
            }
        });
    }

    public void setValue(T t) {
        this.f32a.set(true);
        super.setValue(t);
    }
}
