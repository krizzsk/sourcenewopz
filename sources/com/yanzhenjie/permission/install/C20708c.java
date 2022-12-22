package com.yanzhenjie.permission.install;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.install.c */
/* compiled from: ORequest */
class C20708c extends C20706a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f56201a;

    C20708c(Source source) {
        super(source);
        this.f56201a = source;
    }

    public void start() {
        if (this.f56201a.canRequestPackageInstalls()) {
            mo169076b();
            mo169074a();
            return;
        }
        mo169075a(this);
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56201a);
        bridgeRequest.setType(3);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo169077c();
    }

    public void onCallback() {
        if (this.f56201a.canRequestPackageInstalls()) {
            mo169076b();
            mo169074a();
            return;
        }
        mo169077c();
    }
}
