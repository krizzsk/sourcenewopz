package com.didi.dimina.container.secondparty.permission.install;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

/* renamed from: com.didi.dimina.container.secondparty.permission.install.c */
/* compiled from: ORequest */
class C7596c extends C7594a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f17362a;

    C7596c(Source source) {
        super(source);
        this.f17362a = source;
    }

    public void start() {
        if (this.f17362a.canRequestPackageInstalls()) {
            mo55903b();
            mo55901a();
            return;
        }
        mo55902a(this);
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f17362a);
        bridgeRequest.setType(3);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo55904c();
    }

    public void onCallback() {
        if (this.f17362a.canRequestPackageInstalls()) {
            mo55903b();
            mo55901a();
            return;
        }
        mo55904c();
    }
}
