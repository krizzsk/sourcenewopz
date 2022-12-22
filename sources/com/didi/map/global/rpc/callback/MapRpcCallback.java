package com.didi.map.global.rpc.callback;

import com.didi.map.global.rpc.model.MapRpcBaseResult;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

public abstract class MapRpcCallback<T extends MapRpcBaseResult> implements RpcService.Callback<T> {
    private static final String TAG = "MapRpcCallback";
    private boolean autoGson = true;
    private MapRequestCallback<T> resultCallback;

    public MapRpcCallback(MapRequestCallback<T> mapRequestCallback) {
        this.resultCallback = mapRequestCallback;
    }

    public void notAutoGson() {
        this.autoGson = false;
    }

    public void onSuccess(T t) {
        SystemUtils.log(3, TAG, "\nonSuccess, " + t, (Throwable) null, "com.didi.map.global.rpc.callback.MapRpcCallback", 36);
        if (t == null) {
            onRpcFail((MapRpcBaseResult) null);
        } else {
            if (!this.autoGson) {
                t.parseJson(t.getJson());
            }
            if (t.isSuccess()) {
                onRpcSuccess(t);
            } else {
                onRpcError(t);
            }
        }
        onRpcFinish(t);
    }

    public void onFailure(IOException iOException) {
        MapRpcBaseResult mapRpcBaseResult;
        Exception e;
        try {
            mapRpcBaseResult = (MapRpcBaseResult) ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
            try {
                mapRpcBaseResult.setErrcode(-204);
                mapRpcBaseResult.setErrmsg("Network unavailable.");
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            Exception exc = e3;
            mapRpcBaseResult = null;
            e = exc;
            e.printStackTrace();
            SystemUtils.log(3, TAG, "\nonFailure, " + mapRpcBaseResult + "\nexception=" + iOException, (Throwable) null, "com.didi.map.global.rpc.callback.MapRpcCallback", 66);
            onRpcFail(mapRpcBaseResult);
            onRpcFinish(mapRpcBaseResult);
        }
        SystemUtils.log(3, TAG, "\nonFailure, " + mapRpcBaseResult + "\nexception=" + iOException, (Throwable) null, "com.didi.map.global.rpc.callback.MapRpcCallback", 66);
        onRpcFail(mapRpcBaseResult);
        onRpcFinish(mapRpcBaseResult);
    }

    public void onRpcStart() {
        MapRequestCallback<T> mapRequestCallback = this.resultCallback;
        if (mapRequestCallback != null) {
            mapRequestCallback.onStart();
        }
    }

    public void onRpcSuccess(T t) {
        MapRequestCallback<T> mapRequestCallback = this.resultCallback;
        if (mapRequestCallback != null) {
            mapRequestCallback.onSuccess(t);
        }
    }

    public void onRpcError(T t) {
        MapRequestCallback<T> mapRequestCallback = this.resultCallback;
        if (mapRequestCallback != null) {
            mapRequestCallback.onError(t);
        }
    }

    public void onRpcFail(T t) {
        T t2;
        Exception e;
        if (this.resultCallback != null) {
            if (t == null) {
                try {
                    t2 = (MapRpcBaseResult) ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
                    try {
                        t2.setErrcode(-204);
                        t2.setErrmsg("data is null");
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    Exception exc = e3;
                    t2 = t;
                    e = exc;
                    e.printStackTrace();
                    t = t2;
                    this.resultCallback.onFailure(t);
                }
                t = t2;
            }
            this.resultCallback.onFailure(t);
        }
    }

    public void onRpcFinish(T t) {
        MapRequestCallback<T> mapRequestCallback = this.resultCallback;
        if (mapRequestCallback != null) {
            mapRequestCallback.onFinish(t);
        }
        this.resultCallback = null;
    }
}
