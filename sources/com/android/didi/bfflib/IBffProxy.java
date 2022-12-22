package com.android.didi.bfflib;

import android.content.Context;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBffProxy {
    IBffProxy addAbility(Ability ability);

    boolean canAddAbilityInThisTask(Ability ability);

    String getServiceId();

    int getStatus();

    boolean isRequesting();

    IBffProxy removeAbility(String str);

    void removeCache();

    void requestAbilityInLoop(List<Ability> list);

    void setRequesting(boolean z);

    IBffProxy setServiceId(String str);

    void setStatus(int i);

    int size();

    public static class Ability {
        /* access modifiers changed from: private */
        public BffCallBack<JsonObject> mBffCallBack;
        /* access modifiers changed from: private */
        public RpcService.Callback<JsonObject> mCallback;
        private Context mContext;
        private String mId;
        /* access modifiers changed from: private */
        public Map<String, Object> mRequestParam;
        /* access modifiers changed from: private */
        public String mServiceId;

        private Ability(Context context, String str) {
            this.mRequestParam = new HashMap();
            this.mContext = context;
            this.mId = str;
        }

        public static class Builder {
            private Ability mAbility;

            public Builder(Context context, String str) {
                this.mAbility = new Ability(context, str);
            }

            public Builder setParams(Map<String, Object> map) {
                if (CollectionUtil.isEmpty((Map<?, ?>) map)) {
                    return this;
                }
                Map unused = this.mAbility.mRequestParam = map;
                return this;
            }

            public Builder addParams(String str, Object obj) {
                if (this.mAbility.mRequestParam == null) {
                    Map unused = this.mAbility.mRequestParam = new HashMap();
                }
                this.mAbility.mRequestParam.put(str, obj);
                return this;
            }

            public Builder removeParams() {
                if (this.mAbility.mRequestParam != null) {
                    this.mAbility.mRequestParam.clear();
                }
                return this;
            }

            public Builder setCallback(RpcService.Callback<JsonObject> callback) {
                RpcService.Callback unused = this.mAbility.mCallback = callback;
                return this;
            }

            public Builder setBffCallBack(BffCallBack<JsonObject> bffCallBack) {
                BffCallBack unused = this.mAbility.mBffCallBack = bffCallBack;
                return this;
            }

            public Builder setServiceId(String str) {
                String unused = this.mAbility.mServiceId = str;
                return this;
            }

            public Ability build() {
                return this.mAbility;
            }
        }

        public String getId() {
            return this.mId;
        }

        public String getServiceId() {
            return this.mServiceId;
        }

        public Map<String, Object> getRequestParam() {
            return this.mRequestParam;
        }

        public RpcService.Callback<JsonObject> getCallback() {
            return this.mCallback;
        }

        public BffCallBack<JsonObject> getBffCallBack() {
            return this.mBffCallBack;
        }

        public Context getContext() {
            return this.mContext;
        }
    }
}
