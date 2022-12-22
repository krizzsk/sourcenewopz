package com.didi.soda.customer.flutter;

import com.didi.flutter.nacho2.p115v2.NachoAction;

public class CustomerFlutterEngineManager {

    /* renamed from: a */
    private static CustomerFlutterEngineManager f40889a;

    /* renamed from: b */
    private NachoAction f40890b;

    private CustomerFlutterEngineManager() {
    }

    public static CustomerFlutterEngineManager getInstance() {
        if (f40889a == null) {
            synchronized (CustomerFlutterEngineManager.class) {
                if (f40889a == null) {
                    f40889a = new CustomerFlutterEngineManager();
                }
            }
        }
        return f40889a;
    }

    public void setBizFoodEngineAction(NachoAction nachoAction) {
        this.f40890b = nachoAction;
    }

    public NachoAction getBizFoodEngineAction() {
        return this.f40890b;
    }
}
