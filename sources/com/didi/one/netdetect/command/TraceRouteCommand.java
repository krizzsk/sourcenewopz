package com.didi.one.netdetect.command;

import android.content.Context;
import android.text.TextUtils;

public class TraceRouteCommand extends Command {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f29439a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f29440b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f29441c;

    /* access modifiers changed from: protected */
    public String whichCmd() {
        return "traceroute";
    }

    protected TraceRouteCommand(Context context) {
        super(context);
    }

    public String generateCommandStr() {
        if (!TextUtils.isEmpty(this.f29439a)) {
            StringBuilder sb = new StringBuilder(getCmdPath());
            if (this.f29441c > 0) {
                sb.append(" ");
                sb.append("-m");
                sb.append(this.f29441c);
            }
            if (this.f29440b > 0) {
                sb.append(" ");
                sb.append("-w");
                sb.append(this.f29440b);
            }
            sb.append(" ");
            sb.append(this.f29439a);
            return sb.toString();
        }
        throw new IllegalArgumentException("host must not be null");
    }

    public static class Builder {
        private String host;
        private int maxTTL;
        private int waitTime;

        public Builder setHost(String str) {
            this.host = str;
            return this;
        }

        public Builder setMaxTTL(int i) {
            this.maxTTL = i;
            return this;
        }

        public Builder setWaitTime(int i) {
            this.waitTime = i;
            return this;
        }

        public TraceRouteCommand build(Context context) {
            TraceRouteCommand traceRouteCommand = new TraceRouteCommand(context);
            int unused = traceRouteCommand.f29440b = this.waitTime;
            String unused2 = traceRouteCommand.f29439a = this.host;
            int unused3 = traceRouteCommand.f29441c = this.maxTTL;
            return traceRouteCommand;
        }
    }
}
