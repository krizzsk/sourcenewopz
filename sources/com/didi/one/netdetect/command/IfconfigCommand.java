package com.didi.one.netdetect.command;

import android.content.Context;

public class IfconfigCommand extends Command {
    /* access modifiers changed from: protected */
    public String whichCmd() {
        return "ifconfig";
    }

    protected IfconfigCommand(Context context) {
        super(context);
        this.isNative = true;
    }

    public String generateCommandStr() {
        return new StringBuilder(getCmdPath()).toString();
    }

    public static class Builder {
        public IfconfigCommand build(Context context) {
            return new IfconfigCommand(context);
        }
    }
}
