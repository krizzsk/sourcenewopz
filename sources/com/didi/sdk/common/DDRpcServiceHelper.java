package com.didi.sdk.common;

import android.content.Context;
import com.didichuxing.foundation.rpc.RpcServiceFactory;

public class DDRpcServiceHelper {

    /* renamed from: b */
    private static DDRpcServiceHelper f35620b;

    /* renamed from: a */
    private RpcServiceFactory f35621a;

    private DDRpcServiceHelper(Context context) {
        this.f35621a = new RpcServiceFactory(context);
    }

    public static void init(Context context) {
        if (f35620b == null) {
            f35620b = new DDRpcServiceHelper(context.getApplicationContext());
        }
    }

    /* renamed from: a */
    private static DDRpcServiceHelper m25231a() {
        return f35620b;
    }

    public static RpcServiceFactory getRpcServiceFactory() {
        return m25231a().f35621a;
    }
}
