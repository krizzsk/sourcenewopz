package com.didi.drouter.router;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.drouter.utils.RouterLogger;

class ResultAgent$1 implements LifecycleObserver {
    final /* synthetic */ C7943c this$0;
    final /* synthetic */ Request val$primaryRequest;

    ResultAgent$1(C7943c cVar, Request request) {
        this.this$0 = cVar;
        this.val$primaryRequest = request;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        if (C7943c.f19209l.containsKey(this.val$primaryRequest.getNumber())) {
            RouterLogger.getCoreLogger().mo59002w("request \"%s\" lifecycleOwner \"%s\" destroy and complete", this.val$primaryRequest.getNumber(), this.val$primaryRequest.f19180b.getLifecycle().getClass().getSimpleName());
            RouterCallback unused = this.this$0.f19214p = null;
            C7943c.m14374b(this.val$primaryRequest.getNumber(), "request_cancel");
        }
    }
}
