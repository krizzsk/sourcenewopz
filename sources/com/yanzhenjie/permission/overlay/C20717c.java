package com.yanzhenjie.permission.overlay;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.overlay.c */
/* compiled from: MRequest */
class C20717c extends C20715a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f56221a;

    C20717c(Source source) {
        super(source);
        this.f56221a = source;
    }

    public void start() {
        if (this.f56221a.canDrawOverlays()) {
            onCallback();
        } else {
            mo169104a((RequestExecutor) this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56221a);
        bridgeRequest.setType(4);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo169105b();
    }

    public void onCallback() {
        if (!this.f56221a.canDrawOverlays() || !m40479a(this.f56221a.getContext())) {
            mo169105b();
        } else {
            mo169103a();
        }
    }
}
