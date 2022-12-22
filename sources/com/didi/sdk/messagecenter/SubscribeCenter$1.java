package com.didi.sdk.messagecenter;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

class SubscribeCenter$1 implements GenericLifecycleObserver {
    final /* synthetic */ C12468b this$0;

    SubscribeCenter$1(C12468b bVar) {
        this.this$0 = bVar;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.this$0.release(lifecycleOwner);
        }
    }
}
