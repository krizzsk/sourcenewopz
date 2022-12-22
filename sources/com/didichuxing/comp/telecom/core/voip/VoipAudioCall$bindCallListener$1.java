package com.didichuxing.comp.telecom.core.voip;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didichuxing/comp/telecom/core/voip/VoipAudioCall$bindCallListener$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipAudioCall.kt */
public final class VoipAudioCall$bindCallListener$1 implements LifecycleEventObserver {
    final /* synthetic */ VoipCallListener $callback;
    final /* synthetic */ CopyOnWriteArrayList $callbackList;
    final /* synthetic */ VoipAudioCall this$0;

    VoipAudioCall$bindCallListener$1(VoipAudioCall voipAudioCall, CopyOnWriteArrayList copyOnWriteArrayList, VoipCallListener voipCallListener) {
        this.this$0 = voipAudioCall;
        this.$callbackList = copyOnWriteArrayList;
        this.$callback = voipCallListener;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "source");
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.$callbackList.remove(this.$callback);
            this.this$0.f46437i = null;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
