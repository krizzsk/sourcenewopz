package com.didi.payment.base.net;

import java.util.Map;
import javax.net.ssl.HostnameVerifier;

public class HttpConfig {
    public long connectTimeout;
    public Map<String, String> headers;
    public long readTimeout;
    public HostnameVerifier verifier;
    public long writeTimeout;

    private HttpConfig(Builder builder) {
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.verifier = builder.verifier;
        this.headers = builder.headers;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public long connectTimeout = 10000;
        /* access modifiers changed from: private */
        public Map<String, String> headers;
        /* access modifiers changed from: private */
        public long readTimeout = 10000;
        /* access modifiers changed from: private */
        public HostnameVerifier verifier;
        /* access modifiers changed from: private */
        public long writeTimeout = 10000;

        public Builder setConnectTimeout(long j) {
            this.connectTimeout = j;
            return this;
        }

        public Builder setReadTimeout(long j) {
            this.readTimeout = j;
            return this;
        }

        public Builder setWriteTimeout(long j) {
            this.writeTimeout = j;
            return this;
        }

        public Builder setVerifier(HostnameVerifier hostnameVerifier) {
            this.verifier = hostnameVerifier;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public HttpConfig build() {
            return new HttpConfig(this);
        }
    }
}
