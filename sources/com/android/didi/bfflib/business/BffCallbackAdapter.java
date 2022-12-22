package com.android.didi.bfflib.business;

import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.BffExtra;
import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.utils.BffThreadPool;
import com.android.didi.bfflib.utils.TrackUtil;
import com.didichuxing.foundation.util.TypeResolver;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;

public class BffCallbackAdapter<T extends BffBaseObject> implements BffCallBack<JsonObject> {
    private Exception mException;
    private String mJsonString;
    private BffResponseListener<T> mResponseListener;

    public BffCallbackAdapter(BffResponseListener<T> bffResponseListener) {
        this.mResponseListener = bffResponseListener;
    }

    /* access modifiers changed from: private */
    public BffBaseObject getBaseObject(JsonObject jsonObject) {
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
        BffBaseObject bffBaseObject2;
        if (bffBaseObject != null) {
            try {
                if (bffBaseObject.isAvailable()) {
                    this.mResponseListener.onSuccess(bffBaseObject);
                } else {
                    this.mResponseListener.onFail(bffBaseObject);
                }
            } finally {
                this.mResponseListener.onFinish(bffBaseObject);
            }
        } else {
            if (bffExtra != null) {
                TrackUtil.trackError(1, bffExtra.traceId, this.mException, this.mJsonString, bffExtra.abilityId);
            }
            try {
                bffBaseObject2 = (BffBaseObject) ((Class) TypeResolver.getSuperclassTypeParameter(this.mResponseListener.getClass())).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                bffBaseObject2 = null;
            }
            if (bffBaseObject2 != null) {
                bffBaseObject2.errno = 1;
            }
            this.mResponseListener.onError(bffBaseObject2);
            this.mResponseListener.onFinish(null);
        }
    }

    public void onSuccess(final JsonObject jsonObject, final BffExtra bffExtra) {
        if (this.mResponseListener != null) {
            BffThreadPool.execute((BffThreadPool.IORunnable) new BffThreadPool.IORunnable() {
                public Object run() {
                    return BffCallbackAdapter.this.getBaseObject(jsonObject);
                }

                public void postRun(Object obj) {
                    BffCallbackAdapter.this.handleObject((BffBaseObject) obj, bffExtra);
                }
            });
        }
    }

    public void onFailure(BffExtra bffExtra) {
        BffBaseObject bffBaseObject;
        BffResponseListener<T> bffResponseListener = this.mResponseListener;
        if (bffResponseListener != null) {
            try {
                bffBaseObject = (BffBaseObject) ((Class) TypeResolver.getSuperclassTypeParameter(bffResponseListener.getClass())).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                bffBaseObject = null;
            } catch (Throwable th) {
                this.mResponseListener.onFinish(null);
                throw th;
            }
            if (bffBaseObject == null || bffExtra.errType != 3) {
                if (bffBaseObject != null) {
                    bffBaseObject.errno = bffExtra.errType;
                }
                this.mResponseListener.onError(bffBaseObject);
            } else {
                this.mResponseListener.onFail(bffBaseObject);
            }
            this.mResponseListener.onFinish(null);
        }
    }
}
