package com.didi.component.business.bff.callback_adapter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;

@Deprecated
public class BffTravelCallbackAdapter<T extends BaseObject> implements RpcService.Callback<JsonObject> {
    private Context mContext;
    private boolean mIsAsync = false;
    private Logger mLogger = LoggerFactory.getLogger(getClass());
    private ResponseListener<T> mResponseListener;
    private String mTargetKey;

    public BffTravelCallbackAdapter(ResponseListener<T> responseListener, Context context) {
        this.mResponseListener = responseListener;
        this.mContext = context;
    }

    public BffTravelCallbackAdapter(ResponseListener<T> responseListener, Context context, String str) {
        this.mResponseListener = responseListener;
        this.mContext = context;
        this.mTargetKey = str;
    }

    public BffTravelCallbackAdapter(ResponseListener<T> responseListener, Context context, boolean z) {
        this.mResponseListener = responseListener;
        this.mContext = context;
        this.mIsAsync = z;
    }

    private JsonObject getTargetJsonObject(JsonObject jsonObject) {
        if (TextUtils.isEmpty(this.mTargetKey)) {
            return jsonObject;
        }
        Iterator<String> it = jsonObject.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().equals(this.mTargetKey)) {
                return jsonObject.get(this.mTargetKey).getAsJsonObject();
            }
            jsonObject = getTargetJsonObject(jsonObject.get(it.next()).getAsJsonObject());
        }
        return jsonObject;
    }

    /* access modifiers changed from: private */
    public BaseObject getBaseObject(JsonObject jsonObject) {
        Class cls = (Class) ((ParameterizedType) this.mResponseListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String jsonObject2 = jsonObject.toString();
        this.mLogger.info("bffCallbackonSuccess", new Object[0]);
        if (jsonObject.has("data")) {
            JsonObject targetJsonObject = getTargetJsonObject(jsonObject.getAsJsonObject("data"));
            jsonObject.remove("data");
            if (targetJsonObject != null) {
                for (String next : targetJsonObject.keySet()) {
                    jsonObject.add(next, targetJsonObject.get(next));
                }
            }
        }
        BaseObject baseObject = null;
        try {
            baseObject = (BaseObject) new Gson().fromJson((JsonElement) jsonObject, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (baseObject == null) {
            try {
                baseObject = (BaseObject) cls.newInstance();
            } catch (Exception unused) {
                try {
                    baseObject = (BaseObject) cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mContext});
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (baseObject != null) {
            if (!TextUtils.isEmpty(this.mTargetKey)) {
                jsonObject2 = jsonObject.toString();
            }
            baseObject.parse(jsonObject2);
        }
        return baseObject;
    }

    /* access modifiers changed from: private */
    public void handleObject(BaseObject baseObject) {
        if (baseObject != null) {
            try {
                if (baseObject.isAvailable()) {
                    this.mResponseListener.onSuccess(baseObject);
                } else {
                    this.mResponseListener.onFail(baseObject);
                }
            } finally {
                this.mResponseListener.onFinish(baseObject);
            }
        } else {
            this.mResponseListener.onFinish(null);
        }
    }

    public void onSuccess(final JsonObject jsonObject) {
        if (this.mResponseListener == null) {
            return;
        }
        if (this.mIsAsync) {
            ApmThreadPool.execute((ApmThreadPool.IORunnable) new ApmThreadPool.IORunnable() {
                public Object run() {
                    try {
                        return BffTravelCallbackAdapter.this.getBaseObject(jsonObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }

                public void postRun(Object obj) {
                    BffTravelCallbackAdapter.this.handleObject((BaseObject) obj);
                }
            });
            return;
        }
        BaseObject baseObject = null;
        try {
            baseObject = getBaseObject(jsonObject);
        } finally {
            handleObject(baseObject);
        }
    }

    public void onFailure(IOException iOException) {
        BaseObject baseObject;
        this.mLogger.info("bffCallbackonFailure", new Object[0]);
        ResponseListener<T> responseListener = this.mResponseListener;
        if (responseListener != null) {
            try {
                try {
                    baseObject = (BaseObject) ((Class) ((ParameterizedType) responseListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
                    try {
                        baseObject.errmsg = ResourcesHelper.getString(DIDIApplication.getAppContext(), R.string.car_confrim_cancel_fail);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e = e2;
                    baseObject = null;
                    e.printStackTrace();
                    this.mResponseListener.onError(baseObject);
                }
                this.mResponseListener.onError(baseObject);
            } finally {
                this.mResponseListener.onFinish(null);
            }
        }
    }
}
