package com.didi.dimina.container.secondparty.permission.bridge;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestManager {

    /* renamed from: a */
    private static RequestManager f17344a;

    /* renamed from: b */
    private final BlockingQueue<BridgeRequest> f17345b = new LinkedBlockingQueue();

    public static RequestManager get() {
        if (f17344a == null) {
            synchronized (RequestManager.class) {
                if (f17344a == null) {
                    f17344a = new RequestManager();
                }
            }
        }
        return f17344a;
    }

    private RequestManager() {
        new C7587a(this.f17345b).start();
    }

    public void add(BridgeRequest bridgeRequest) {
        this.f17345b.add(bridgeRequest);
    }
}
