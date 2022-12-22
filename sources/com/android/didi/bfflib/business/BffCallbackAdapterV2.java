package com.android.didi.bfflib.business;

import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.BffExtra;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.utils.BffThreadPool;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didichuxing.foundation.util.TypeResolver;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;

public class BffCallbackAdapterV2<T extends BffBaseObject> implements BffCallBack<JsonObject> {
    private Exception mException;
    private String mJsonString = "";
    private BffResponseListenerV2<T> mResponseListener;

    public BffCallbackAdapterV2(BffResponseListenerV2<T> bffResponseListenerV2) {
        this.mResponseListener = bffResponseListenerV2;
    }

    /* access modifiers changed from: private */
    public Object getBaseObject(JsonObject jsonObject) {
        BffBaseObject bffBaseObject;
        Type superclassTypeParameter = TypeResolver.getSuperclassTypeParameter(this.mResponseListener.getClass());
        if (jsonObject.has("data")) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
            jsonObject.remove("data");
            if (asJsonObject != null) {
                for (String next : asJsonObject.keySet()) {
                    jsonObject.add(next, asJsonObject.get(next));
                }
            }
        }
        try {
            bffBaseObject = (BffBaseObject) GsonUtil.fromJson(jsonObject.toString(), superclassTypeParameter);
        } catch (Exception e) {
            e.printStackTrace();
            this.mException = e;
            bffBaseObject = null;
        }
        if (bffBaseObject == null) {
            this.mJsonString = jsonObject.toString();
        }
        return bffBaseObject;
    }

    /* access modifiers changed from: private */
    public void handleObject(BffBaseObject bffBaseObject, BffExtra bffExtra) {
        if (bffBaseObject == null) {
            if (bffExtra != null) {
                bffExtra.exception = this.mException;
                TrackUtil.trackError(1, bffExtra.traceId, this.mException, this.mJsonString, bffExtra.abilityId);
            }
            this.mResponseListener.onFail(null, bffExtra);
        } else if (bffBaseObject.isAvailable()) {
            this.mResponseListener.onSuccess(bffBaseObject, bffExtra);
        } else {
            this.mResponseListener.onFail(bffBaseObject, bffExtra);
        }
    }

    public void onSuccess(final JsonObject jsonObject, final BffExtra bffExtra) {
        if (this.mResponseListener != null) {
            BffThreadPool.execute((BffThreadPool.IORunnable) new BffThreadPool.IORunnable() {
                public Object run() {
                    return BffCallbackAdapterV2.this.getBaseObject(jsonObject);
                }

                public void postRun(Object obj) {
                    BffCallbackAdapterV2.this.handleObject((BffBaseObject) obj, bffExtra);
                }
            });
        }
    }

    public void onFailure(BffExtra bffExtra) {
        BffResponseListenerV2<T> bffResponseListenerV2 = this.mResponseListener;
        if (bffResponseListenerV2 != null) {
            bffResponseListenerV2.onFail(null, bffExtra);
        }
    }
}
