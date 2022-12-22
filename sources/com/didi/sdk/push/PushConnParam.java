package com.didi.sdk.push;

import com.didi.sdk.protobuf.UserAgent;

class PushConnParam {
    private String account;
    private String appId;
    private int cityId;
    private String deviceId;
    private String docDir;
    private int flowTag;
    private String fluxMsgType;
    private int heartBeatInterval;
    private int heartBeatRetryInterval;
    private String host;
    private int port;
    private int role;
    private String token;
    private UserAgent userAgent;
    private long writeBufCheckRepeat;
    private long writeTimeout;

    public PushConnParam(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.role = builder.role;
        this.account = builder.account;
        this.token = builder.token;
        this.userAgent = builder.userAgent;
        this.writeBufCheckRepeat = builder.writeBufCheckRepeat;
        this.writeTimeout = builder.writeTimeout;
        this.cityId = builder.cityId;
        this.flowTag = builder.flowTag;
        this.docDir = builder.docDir;
        this.heartBeatInterval = builder.heartBeatInterval;
        this.heartBeatRetryInterval = builder.heartBeatRetryInterval;
        this.appId = builder.appId;
        this.deviceId = builder.deviceId;
        this.fluxMsgType = builder.fluxMsgType;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public int getRole() {
        return this.role;
    }

    public String getAccount() {
        return this.account;
    }

    public String getToken() {
        return this.token;
    }

    public UserAgent getUserAgent() {
        return this.userAgent;
    }

    public long getWriteBufCheckRepeat() {
        return this.writeBufCheckRepeat;
    }

    public long getWriteTimeout() {
        return this.writeTimeout;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getFlowTag() {
        return this.flowTag;
    }

    public String getDocDir() {
        return this.docDir;
    }

    public int getHeartBeatInterval() {
        return this.heartBeatInterval;
    }

    public int getHeartBeatRetryInterval() {
        return this.heartBeatRetryInterval;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getFluxMsgType() {
        return this.fluxMsgType;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public String account;
        /* access modifiers changed from: private */
        public String appId;
        /* access modifiers changed from: private */
        public int cityId;
        /* access modifiers changed from: private */
        public String deviceId;
        /* access modifiers changed from: private */
        public String docDir;
        /* access modifiers changed from: private */
        public int flowTag;
        /* access modifiers changed from: private */
        public String fluxMsgType;
        /* access modifiers changed from: private */
        public int heartBeatInterval;
        /* access modifiers changed from: private */
        public int heartBeatRetryInterval;
        /* access modifiers changed from: private */
        public String host;
        /* access modifiers changed from: private */
        public int port;
        /* access modifiers changed from: private */
        public int role;
        /* access modifiers changed from: private */
        public String token;
        /* access modifiers changed from: private */
        public UserAgent userAgent;
        /* access modifiers changed from: private */
        public long writeBufCheckRepeat;
        /* access modifiers changed from: private */
        public long writeTimeout;

        public Builder host(String str) {
            this.host = str;
            return this;
        }

        public Builder port(int i) {
            this.port = i;
            return this;
        }

        public Builder role(int i) {
            this.role = i;
            return this;
        }

        public Builder account(String str) {
            this.account = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder userAgent(UserAgent userAgent2) {
            this.userAgent = userAgent2;
            return this;
        }

        public Builder writeBufCheckRepeat(long j) {
            this.writeBufCheckRepeat = j;
            return this;
        }

        public Builder writeTimeout(long j) {
            this.writeTimeout = j;
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

        public Builder docDir(String str) {
            this.docDir = str;
            return this;
        }

        public Builder heartBeatInterval(int i) {
            this.heartBeatInterval = i;
            return this;
        }

        public Builder heartBeatRetryInterval(int i) {
            this.heartBeatRetryInterval = i;
            return this;
        }

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder fluxMsgType(String str) {
            this.fluxMsgType = str;
            return this;
        }

        public PushConnParam build() {
            return new PushConnParam(this);
        }
    }
}
