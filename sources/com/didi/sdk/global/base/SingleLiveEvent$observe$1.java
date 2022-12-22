package com.didi.sdk.global.base;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo175978d2 = {"com/didi/sdk/global/base/SingleLiveEvent$observe$1", "Landroidx/lifecycle/Observer;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleLiveEvent.kt */
public final class SingleLiveEvent$observe$1 implements Observer<T> {
    final /* synthetic */ Observer<? super T> $observer;
    final /* synthetic */ SingleLiveEvent<T> this$0;

    SingleLiveEvent$observe$1(SingleLiveEvent<T> singleLiveEvent, Observer<? super T> observer) {
        this.this$0 = singleLiveEvent;
        this.$observer = observer;
    }

    public void onChanged(T t) {
        if (this.this$0.f36081a.compareAndSet(true, false)) {
            this.$observer.onChanged(t);
        }
    }
}
