package com.didi.drouter.router;

import com.didi.drouter.utils.RouterExecutor;

class Monitor$1 implements Runnable {
    final /* synthetic */ Request val$request;

    Monitor$1(Request request) {
        this.val$request = request;
    }

    public void run() {
        RouterExecutor.submit(new Runnable() {
            public void run() {
                C7943c.m14370a(Monitor$1.this.val$request, "timeout");
            }
        });
    }
}
