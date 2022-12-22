package com.didi.component.business.bff.callback_adapter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;

@Deprecated
public class BffCommonCallbackAdapter<T extends BaseObject> implements RpcService.Callback<JsonObject> {
    private Context mContext;
    private ResponseListener<T> mResponseListener;
    private String mTargetKey;

    public BffCommonCallbackAdapter(ResponseListener<T> responseListener, Context context) {
        this.mResponseListener = responseListener;
        this.mContext = context;
    }

    public BffCommonCallbackAdapter(ResponseListener<T> responseListener, Context context, String str) {
        this.mResponseListener = responseListener;
        this.mContext = context;
        this.mTargetKey = str;
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

    public void onSuccess(JsonObject jsonObject) {
        BaseObject baseObject;
        ResponseListener<T> responseListener = this.mResponseListener;
        if (responseListener != null) {
            Class cls = (Class) ((ParameterizedType) responseListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            jsonObject.toString();
            if (jsonObject.has("data")) {
                JsonObject targetJsonObject = getTargetJsonObject(jsonObject.getAsJsonObject("data"));
                jsonObject.remove("data");
                if (targetJsonObject != null) {
                    for (String next : targetJsonObject.keySet()) {
                        jsonObject.add(next, targetJsonObject.get(next));
                    }
                }
            }
            try {
                baseObject = (BaseObject) new Gson().fromJson((JsonElement) jsonObject, cls);
            } catch (Exception e) {
                e.printStackTrace();
                baseObject = null;
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
                try {
                    baseObject.parse(jsonObject.toString());
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
    }

    public void onFailure(IOException iOException) {
        ResponseListener<T> responseListener = this.mResponseListener;
        if (responseListener != null) {
            try {
                responseListener.onError(null);
            } finally {
                this.mResponseListener.onFinish(null);
            }
        }
    }
}
