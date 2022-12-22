package com.didi.entrega.customer.flutter;

import com.didi.flutter.nacho2.p115v2.NachoAction;

public final class FlutterEngineStore {

    /* renamed from: a */
    private static FlutterEngineStore f19892a;

    /* renamed from: b */
    private NachoAction f19893b;

    private FlutterEngineStore() {
    }

    public static FlutterEngineStore getInstance() {
        if (f19892a == null) {
            synchronized (FlutterEngineStore.class) {
                if (f19892a == null) {
                    f19892a = new FlutterEngineStore();
                }
            }
        }
        return f19892a;
    }

    public void setBizMainEngineAction(NachoAction nachoAction) {
        this.f19893b = nachoAction;
    }

    public NachoAction getBizMainEngineAction() {
        return this.f19893b;
    }
}
