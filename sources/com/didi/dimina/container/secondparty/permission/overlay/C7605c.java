package com.didi.dimina.container.secondparty.permission.overlay;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.overlay.c */
/* compiled from: MRequest */
class C7605c extends C7603a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f17382a;

    C7605c(Source source) {
        super(source);
        this.f17382a = source;
    }

    public void start() {
        if (this.f17382a.canDrawOverlays()) {
            onCallback();
        } else {
            mo55931a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f17382a);
        bridgeRequest.setType(4);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo55932b();
    }

    public void onCallback() {
        if (!this.f17382a.canDrawOverlays() || !m12911a(this.f17382a.getContext())) {
            mo55932b();
        } else {
            mo55930a();
        }
    }
}
