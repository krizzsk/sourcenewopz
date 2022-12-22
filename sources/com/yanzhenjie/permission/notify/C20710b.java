package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.b */
/* compiled from: NRequest */
class C20710b extends C20709a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f56209a;

    C20710b(Source source) {
        super(source);
        this.f56209a = source;
    }

    public void start() {
        if (this.f56209a.canNotify()) {
            mo169087a();
        } else {
            mo169088a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56209a);
        bridgeRequest.setType(1);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo169089b();
    }

    public void onCallback() {
        if (this.f56209a.canNotify()) {
            mo169087a();
        } else {
            mo169089b();
        }
    }
}
