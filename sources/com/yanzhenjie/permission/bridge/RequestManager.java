package com.yanzhenjie.permission.bridge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestManager {

    /* renamed from: a */
    private static RequestManager f56167a;

    /* renamed from: b */
    private final BlockingQueue<BridgeRequest> f56168b = new LinkedBlockingQueue();

    public static RequestManager get() {
        if (f56167a == null) {
            synchronized (RequestManager.class) {
                if (f56167a == null) {
                    f56167a = new RequestManager();
                }
            }
        }
        return f56167a;
    }

    private RequestManager() {
        new C20688a(this.f56168b).start();
    }

    public void add(BridgeRequest bridgeRequest) {
        this.f56168b.add(bridgeRequest);
    }
}
