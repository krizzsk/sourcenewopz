package com.yanzhenjie.permission.overlay;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.overlay.b */
/* compiled from: LRequest */
class C20716b extends C20715a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f56220a;

    C20716b(Source source) {
        super(source);
        this.f56220a = source;
    }

    public void start() {
        if (m40479a(this.f56220a.getContext())) {
            mo169103a();
        } else {
            mo169104a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56220a);
        bridgeRequest.setType(5);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo169105b();
    }

    public void onCallback() {
        if (m40479a(this.f56220a.getContext())) {
            mo169103a();
        } else {
            mo169105b();
        }
    }
}
