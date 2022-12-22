package com.didi.map.global.rpc.service;

import android.content.Context;
import com.didi.map.global.rpc.callback.MapRpcCallback;
import com.didichuxing.foundation.rpc.RpcService;

public abstract class MapHttpService extends MapRpcService {
    public MapHttpService(Context context) {
        super(context);
    }

    public <T extends RpcService> T getService(Class<T> cls, String str, MapRpcCallback mapRpcCallback) {
        return super.getService(cls, str);
    }
}
