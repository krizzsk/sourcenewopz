package com.yanzhenjie.permission.notify.listener;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.listener.c */
/* compiled from: J2Request */
class C20714c extends C20712a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f56215a;

    C20714c(Source source) {
        super(source);
        this.f56215a = source;
    }

    public void start() {
        if (this.f56215a.canListenerNotification()) {
            mo169095a();
        } else {
            mo169096a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56215a);
        bridgeRequest.setType(7);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo169097b();
    }

    public void onCallback() {
        if (this.f56215a.canListenerNotification()) {
            mo169095a();
        } else {
            mo169097b();
        }
    }
}
