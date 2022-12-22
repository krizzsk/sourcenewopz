package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DebugInfo extends Message {
    @ProtoField(tag = 1)
    public final DebugDriverLoc drvLoc;

    public DebugInfo(DebugDriverLoc debugDriverLoc) {
        this.drvLoc = debugDriverLoc;
    }

    private DebugInfo(Builder builder) {
        this(builder.drvLoc);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DebugInfo)) {
            return false;
        }
        return equals((Object) this.drvLoc, (Object) ((DebugInfo) obj).drvLoc);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            DebugDriverLoc debugDriverLoc = this.drvLoc;
            i = debugDriverLoc != null ? debugDriverLoc.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<DebugInfo> {
        public DebugDriverLoc drvLoc;

        public Builder() {
        }

        public Builder(DebugInfo debugInfo) {
            super(debugInfo);
            if (debugInfo != null) {
                this.drvLoc = debugInfo.drvLoc;
            }
        }

        public Builder drvLoc(DebugDriverLoc debugDriverLoc) {
            this.drvLoc = debugDriverLoc;
            return this;
        }

        public DebugInfo build() {
            return new DebugInfo(this);
        }
    }
}
