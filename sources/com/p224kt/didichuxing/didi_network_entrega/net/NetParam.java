package com.p224kt.didichuxing.didi_network_entrega.net;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kt.didichuxing.didi_network_entrega.net.NetParam */
public class NetParam implements Cloneable {
    protected final Map<String, String> mHeadParams;
    protected final Map<String, Object> mPostGetParams;
    protected final Map<String, Object> mQueryParams;
    protected final RequestType mRequestType;
    protected final String mUrl;

    NetParam(Builder builder) {
        this.mRequestType = builder.mRequestType;
        this.mUrl = builder.mUrl;
        this.mQueryParams = Collections.unmodifiableMap(builder.mQueryParams);
        this.mPostGetParams = Collections.unmodifiableMap(builder.mPostGetParams);
        this.mHeadParams = Collections.unmodifiableMap(builder.mHeadParams);
    }

    public RequestType getRequestType() {
        return this.mRequestType;
    }

    public Map<String, Object> getQueryParameters() {
        return this.mQueryParams;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public NetParam clone() {
        return newBuilder().build();
    }

    /* renamed from: com.kt.didichuxing.didi_network_entrega.net.NetParam$Builder */
    public static class Builder {
        /* access modifiers changed from: private */
        public final Map<String, String> mHeadParams;
        protected final Map<String, Object> mPostGetParams;
        /* access modifiers changed from: private */
        public final Map<String, Object> mQueryParams;
        /* access modifiers changed from: private */
        public RequestType mRequestType;
        /* access modifiers changed from: private */
        public String mUrl;

        public Builder() {
            this.mQueryParams = new HashMap();
            this.mPostGetParams = new HashMap();
            this.mHeadParams = new HashMap();
            this.mRequestType = RequestType.getDefault();
        }

        private Builder(NetParam netParam) {
            this.mQueryParams = new HashMap();
            this.mPostGetParams = new HashMap();
            this.mHeadParams = new HashMap();
            this.mRequestType = RequestType.getDefault();
            this.mRequestType = netParam.mRequestType;
            this.mUrl = netParam.mUrl;
            this.mQueryParams.putAll(netParam.mQueryParams);
            this.mPostGetParams.putAll(netParam.mPostGetParams);
            this.mHeadParams.putAll(netParam.mHeadParams);
        }

        public Builder setUrl(String str) {
            this.mUrl = str;
            return this;
        }

        public Builder setRequestType(RequestType requestType) {
            this.mRequestType = requestType;
            return this;
        }

        public Builder setQueryParameter(Map<String, Object> map) {
            if (!(map == null || map.size() == 0)) {
                this.mQueryParams.putAll(map);
            }
            return this;
        }

        public Builder setPostGetterParameter(Map<String, Object> map) {
            if (!(map == null || map.size() == 0)) {
                this.mPostGetParams.putAll(map);
            }
            return this;
        }

        public Builder setHeadParameter(Map<String, String> map) {
            if (!(map == null || map.size() == 0)) {
                this.mHeadParams.putAll(map);
            }
            return this;
        }

        public Builder addQueryParameter(String str, Object obj) {
            if (str != null && str.trim().length() > 0 && obj != null && !"".equals(obj) && !"null".equals(obj)) {
                this.mQueryParams.put(str, obj);
            }
            return this;
        }

        public Builder addHeadParameter(String str, String str2) {
            if (str != null && str.trim().length() > 0 && str2 != null && !"".equals(str2) && !"null".equals(str2)) {
                this.mHeadParams.put(str, str2);
            }
            return this;
        }

        public Map<String, Object> getQueryParameters() {
            return this.mQueryParams;
        }

        public Map<String, String> getHeadParams() {
            return this.mHeadParams;
        }

        public NetParam build() {
            return new NetParam(this);
        }
    }
}
