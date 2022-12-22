package com.didi.one.netdetect.command;

import android.content.Context;

public class NetstatCommand extends Command {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f29424a;

    /* access modifiers changed from: protected */
    public String whichCmd() {
        return "netstat";
    }

    protected NetstatCommand(Context context) {
        super(context);
        this.isNative = true;
    }

    public String generateCommandStr() {
        StringBuilder sb = new StringBuilder(getCmdPath());
        if (this.f29424a) {
            sb.append("-r");
            sb.append(" ");
        }
        return sb.toString();
    }

    public static class Builder {
        private boolean isRoutingTable;

        public Builder setRoutingTable(boolean z) {
            this.isRoutingTable = z;
            return this;
        }

        public NetstatCommand build(Context context) {
            NetstatCommand netstatCommand = new NetstatCommand(context);
            boolean unused = netstatCommand.f29424a = this.isRoutingTable;
            return netstatCommand;
        }
    }
}
