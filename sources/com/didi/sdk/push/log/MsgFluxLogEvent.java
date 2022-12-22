package com.didi.sdk.push.log;

import com.didi.sdk.push.log.LogEvent;
import com.didi.soda.blocks.constant.Const;
import java.util.HashMap;
import java.util.Map;

public class MsgFluxLogEvent extends LogEvent {
    private long flux;
    private int fluxType;
    private int msgType;

    public MsgFluxLogEvent(Builder builder) {
        this.flux = builder.flux;
        this.fluxType = builder.fluxType;
        this.msgType = builder.msgType;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.msgType));
        hashMap.put(Const.YogaConst.YOGA_DIRECTION, Integer.valueOf(this.fluxType));
        hashMap.put("flux", Long.valueOf(this.flux));
        return hashMap;
    }

    public static class Builder implements LogEvent.Builder<MsgFluxLogEvent> {
        /* access modifiers changed from: private */
        public long flux;
        /* access modifiers changed from: private */
        public int fluxType;
        /* access modifiers changed from: private */
        public int msgType;

        public Builder msgType(int i) {
            this.msgType = i;
            return this;
        }

        public Builder fluxType(int i) {
            this.fluxType = i;
            return this;
        }

        public Builder flux(long j) {
            this.flux = j;
            return this;
        }

        public MsgFluxLogEvent build() {
            return new MsgFluxLogEvent(this);
        }
    }
}
