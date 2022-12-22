package com.didi.sdk.global.base;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/sdk/global/base/EventObserver;", "T", "Landroidx/lifecycle/Observer;", "Lcom/didi/sdk/global/base/Event;", "onEventUnhandledContent", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onChanged", "event", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Event.kt */
public final class EventObserver<T> implements Observer<Event<? extends T>> {

    /* renamed from: a */
    private final Function1<T, Unit> f36054a;

    public EventObserver(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onEventUnhandledContent");
        this.f36054a = function1;
    }

    public void onChanged(Event<? extends T> event) {
        Object contentIfNotHandled;
        if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
            this.f36054a.invoke(contentIfNotHandled);
        }
    }
}
