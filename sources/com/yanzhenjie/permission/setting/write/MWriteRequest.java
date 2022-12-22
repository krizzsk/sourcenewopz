package com.yanzhenjie.permission.setting.write;

import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.bridge.BridgeRequest;
import com.yanzhenjie.permission.bridge.RequestManager;
import com.yanzhenjie.permission.source.Source;

public class MWriteRequest extends C20720a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private Source f56248a;

    public MWriteRequest(Source source) {
        super(source);
        this.f56248a = source;
    }

    public void start() {
        if (this.f56248a.canWriteSetting()) {
            mo169135a();
        } else {
            mo169136a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f56248a);
        bridgeRequest.setType(8);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo169137b();
    }

    public void onCallback() {
        if (this.f56248a.canWriteSetting()) {
            mo169135a();
        } else {
            mo169137b();
        }
    }
}
