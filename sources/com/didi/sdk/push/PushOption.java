package com.didi.sdk.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class PushOption {
    /* access modifiers changed from: private */
    public String appId;
    /* access modifiers changed from: private */
    public int cityId;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public String deviceId;
    /* access modifiers changed from: private */
    public Dns dns;
    /* access modifiers changed from: private */
    public Map<String, Object> extra = new HashMap();
    /* access modifiers changed from: private */
    public int flowTag;
    /* access modifiers changed from: private */

    /* renamed from: ip */
    public String f37078ip;
    /* access modifiers changed from: private */
    public double lat;
    /* access modifiers changed from: private */
    public double lng;
    /* access modifiers changed from: private */
    public String phone;
    /* access modifiers changed from: private */
    public int port;
    /* access modifiers changed from: private */
    public int role;
    /* access modifiers changed from: private */
    public String token;

    public PushOption(Builder builder) {
        this.context = builder.context;
        this.phone = builder.phone;
        this.token = builder.token;
        this.role = builder.role;
        this.f37078ip = builder.f37079ip;
        this.port = builder.port;
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.cityId = builder.cityId;
        this.flowTag = builder.flowTag;
        this.extra.putAll(builder.extra);
        this.dns = builder.dns;
        this.appId = builder.appId;
        this.deviceId = builder.deviceId;
        if (TextUtils.isEmpty(this.appId)) {
            throw new IllegalArgumentException("appId must not be null or empty!");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkValid() {
        if (this.context != null && !TextUtils.isEmpty(this.token) && !TextUtils.isEmpty(this.f37078ip)) {
            return true;
        }
        return false;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getToken() {
        return this.token;
    }

    public int getRole() {
        return this.role;
    }

    public String getIp() {
        return this.f37078ip;
    }

    public int getPort() {
        return this.port;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getFlowTag() {
        return this.flowTag;
    }

    public Context getContext() {
        return this.context;
    }

    public Dns getDns() {
        return this.dns;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String appId;
        /* access modifiers changed from: private */
        public int cityId;
        /* access modifiers changed from: private */
        public Context context;
        /* access modifiers changed from: private */
        public String deviceId;
        /* access modifiers changed from: private */
        public Dns dns;
        /* access modifiers changed from: private */
        public Map<String, Object> extra;
        /* access modifiers changed from: private */
        public int flowTag;
        /* access modifiers changed from: private */

        /* renamed from: ip */
        public String f37079ip;
        /* access modifiers changed from: private */
        public double lat;
        /* access modifiers changed from: private */
        public double lng;
        /* access modifiers changed from: private */
        public String phone;
        /* access modifiers changed from: private */
        public int port;
        /* access modifiers changed from: private */
        public int role;
        /* access modifiers changed from: private */
        public String token;

        public Builder() {
            this.extra = new HashMap();
            this.dns = Dns.SYSTEM;
        }

        public Builder(PushOption pushOption) {
            this.extra = new HashMap();
            this.context = pushOption.context;
            this.phone = pushOption.phone;
            this.token = pushOption.token;
            this.role = pushOption.role;
            this.f37079ip = pushOption.f37078ip;
            this.port = pushOption.port;
            this.lat = pushOption.lat;
            this.lng = pushOption.lng;
            this.cityId = pushOption.cityId;
            this.flowTag = pushOption.flowTag;
            this.extra.putAll(pushOption.extra);
            this.dns = pushOption.dns;
            this.appId = pushOption.appId;
            this.deviceId = pushOption.deviceId;
        }

        public Builder context(Context context2) {
            this.context = context2;
            ContextUtil.initApplicationContext(context2);
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder role(int i) {
            this.role = i;
            return this;
        }

        /* renamed from: ip */
        public Builder mo95545ip(String str) {
            this.f37079ip = str;
            return this;
        }

        public Builder port(int i) {
            this.port = i;
            return this;
        }

        public Builder lat(double d) {
            this.lat = d;
            return this;
        }

        public Builder lng(double d) {
            this.lng = d;
            return this;
        }

        public Builder cityId(int i) {
            this.cityId = i;
            return this;
        }

        public Builder flowTag(int i) {
            this.flowTag = i;
            return this;
        }

        public Builder extra(Map<String, Object> map) {
            this.extra.putAll(map);
            return this;
        }

        public Builder dns(Dns dns2) {
            if (dns2 != null) {
                this.dns = dns2;
                return this;
            }
            throw new IllegalArgumentException("dns must be not null");
        }

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public PushOption build() {
            return new PushOption(this);
        }
    }
}
