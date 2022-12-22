package com.didi.dimina.container.secondparty.permission.setting.write;

import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import com.didi.dimina.container.secondparty.permission.bridge.BridgeRequest;
import com.didi.dimina.container.secondparty.permission.bridge.RequestManager;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class MWriteRequest extends C7608a implements RequestExecutor, BridgeRequest.Callback {

    /* renamed from: a */
    private final Source f17408a;

    public MWriteRequest(Source source) {
        super(source);
        this.f17408a = source;
    }

    public void start() {
        if (this.f17408a.canWriteSetting()) {
            mo55962a();
        } else {
            mo55963a(this);
        }
    }

    public void execute() {
        BridgeRequest bridgeRequest = new BridgeRequest(this.f17408a);
        bridgeRequest.setType(8);
        bridgeRequest.setCallback(this);
        RequestManager.get().add(bridgeRequest);
    }

    public void cancel() {
        mo55964b();
    }

    public void onCallback() {
        if (this.f17408a.canWriteSetting()) {
            mo55962a();
        } else {
            mo55964b();
        }
    }
}
