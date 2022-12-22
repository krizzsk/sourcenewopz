package com.didi.xengine.config;

import com.didi.xengine.callback.XEReqUtilMethod;

public class EngineConfig {

    /* renamed from: a */
    private XEReqUtilMethod f45188a;

    private EngineConfig(Builder builder) {
        this.f45188a = builder.method;
    }

    public XEReqUtilMethod getMethod() {
        return this.f45188a;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public XEReqUtilMethod method;

        public EngineConfig build() {
            return new EngineConfig(this);
        }

        public Builder setReqMethod(XEReqUtilMethod xEReqUtilMethod) {
            this.method = xEReqUtilMethod;
            return this;
        }
    }
}
