package com.didi.dimina.container.secondparty.permission.overlay;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.overlay.b */
/* compiled from: LRequest */
class C7604b extends C7603a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f17381a;

    C7604b(Source source) {
        super(source);
        this.f17381a = source;
    }

    public void start() {
        if (m12911a(this.f17381a.getContext())) {
            mo55930a();
        } else {
            mo55931a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f17381a);
        bridgeRequest.setType(5);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo55932b();
    }

    public void onCallback() {
        if (m12911a(this.f17381a.getContext())) {
            mo55930a();
        } else {
            mo55932b();
        }
    }
}
