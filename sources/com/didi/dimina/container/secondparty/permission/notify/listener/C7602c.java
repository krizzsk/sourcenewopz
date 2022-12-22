package com.didi.dimina.container.secondparty.permission.notify.listener;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.listener.c */
/* compiled from: J2Request */
class C7602c extends C7600a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f17376a;

    C7602c(Source source) {
        super(source);
        this.f17376a = source;
    }

    public void start() {
        if (this.f17376a.canListenerNotification()) {
            mo55922a();
        } else {
            mo55923a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f17376a);
        bridgeRequest.setType(7);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo55924b();
    }

    public void onCallback() {
        if (this.f17376a.canListenerNotification()) {
            mo55922a();
        } else {
            mo55924b();
        }
    }
}
