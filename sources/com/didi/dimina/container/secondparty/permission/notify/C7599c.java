package com.didi.dimina.container.secondparty.permission.notify;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.notify.c */
/* compiled from: ORequest */
class C7599c extends C7597a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f17371a;

    C7599c(Source source) {
        super(source);
        this.f17371a = source;
    }

    public void start() {
        if (this.f17371a.canNotify()) {
            mo55914a();
        } else {
            mo55915a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f17371a);
        bridgeRequest.setType(6);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo55916b();
    }

    public void onCallback() {
        if (this.f17371a.canNotify()) {
            mo55914a();
        } else {
            mo55916b();
        }
    }
}
