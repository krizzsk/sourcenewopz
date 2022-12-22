package com.yanzhenjie.permission.notify;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

/* renamed from: com.yanzhenjie.permission.notify.c */
/* compiled from: ORequest */
class C20711c extends C20709a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f56210a;

    C20711c(Source source) {
        super(source);
        this.f56210a = source;
    }

    public void start() {
        if (this.f56210a.canNotify()) {
            mo169087a();
        } else {
            mo169088a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56210a);
        bridgeRequest.setType(6);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo169089b();
    }

    public void onCallback() {
        if (this.f56210a.canNotify()) {
            mo169087a();
        } else {
            mo169089b();
        }
    }
}
