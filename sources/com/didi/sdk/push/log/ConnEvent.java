package com.didi.sdk.push.log;

import android.text.TextUtils;
import com.didi.sdk.push.log.LogEvent;
import java.util.HashMap;
import java.util.Map;

public class ConnEvent extends LogEvent {
    protected int errorCode;
    protected String extraMsg;
    protected int subCode;

    public ConnEvent(Builder builder) {
        this.errorCode = builder.errorCode;
        this.subCode = builder.subCode;
        this.extraMsg = builder.extraMsg;
    }

    public ConnEvent() {
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public String getExtraMsg() {
        return this.extraMsg;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("retCode", Integer.valueOf(this.errorCode));
        hashMap.put("subCode", Integer.valueOf(this.subCode));
        if (!TextUtils.isEmpty(this.extraMsg)) {
            hashMap.put("extraMsg", this.extraMsg);
        }
        return hashMap;
    }

    public static class Builder implements LogEvent.Builder<ConnEvent> {
        protected int errorCode;
        protected String extraMsg;
        protected int subCode;

        public Builder errorCode(int i) {
            this.errorCode = i;
            return this;
        }

        public Builder subCode(int i) {
            this.subCode = i;
            return this;
        }

        public Builder extraMsg(String str) {
            this.extraMsg = str;
            return this;
        }

        public ConnEvent build() {
            return new ConnEvent(this);
        }
    }
}
