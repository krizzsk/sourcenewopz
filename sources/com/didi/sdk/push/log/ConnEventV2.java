package com.didi.sdk.push.log;

import com.didi.sdk.push.log.LogEvent;
import java.util.HashMap;
import java.util.Map;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;

public class ConnEventV2 extends LogEvent {
    private long confirmDur;

    /* renamed from: ip */
    private String f37081ip;
    private int isMulti;
    private int port;
    private long tcpHandshakeDur;
    private long tlsHandshakeDur;

    public ConnEventV2(Builder builder) {
        this.f37081ip = builder.f37082ip;
        this.port = builder.port;
        this.tcpHandshakeDur = builder.tcpHandshakeDur;
        this.confirmDur = builder.confirmDur;
        this.tlsHandshakeDur = builder.tlsHandshakeDur;
        this.isMulti = builder.isMulti;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("ip", this.f37081ip);
        hashMap.put(AgentOptions.PORT, Integer.valueOf(this.port));
        hashMap.put("tcp_handshake_duration", Long.valueOf(this.tcpHandshakeDur));
        hashMap.put("confirm_duration", Long.valueOf(this.confirmDur));
        hashMap.put("tls_handshake_duration", Long.valueOf(this.tlsHandshakeDur));
        hashMap.put("is_multiple", Integer.valueOf(this.isMulti));
        return hashMap;
    }

    public static class Builder implements LogEvent.Builder<ConnEventV2> {
        /* access modifiers changed from: private */
        public long confirmDur;
        /* access modifiers changed from: private */

        /* renamed from: ip */
        public String f37082ip;
        /* access modifiers changed from: private */
        public int isMulti;
        /* access modifiers changed from: private */
        public int port;
        /* access modifiers changed from: private */
        public long tcpHandshakeDur;
        /* access modifiers changed from: private */
        public long tlsHandshakeDur;

        /* renamed from: ip */
        public Builder mo95652ip(String str) {
            this.f37082ip = str;
            return this;
        }

        public Builder port(int i) {
            this.port = i;
            return this;
        }

        public Builder tcpHandshakeDur(long j) {
            this.tcpHandshakeDur = j;
            return this;
        }

        public Builder confirmDur(long j) {
            this.confirmDur = j;
            return this;
        }

        public Builder tlsHandshakeDur(long j) {
            this.tlsHandshakeDur = j;
            return this;
        }

        public Builder isMulti(int i) {
            this.isMulti = i;
            return this;
        }

        public ConnEventV2 build() {
            return new ConnEventV2(this);
        }
    }
}
