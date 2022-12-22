package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverConfig extends Message {
    public static final Boolean DEFAULT_AUTOSTARTNAVI = false;
    public static final String DEFAULT_DEFAULTNAVIENGINE = "";
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean autoStartNavi;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String defaultNaviEngine;

    public DriverConfig(Boolean bool, String str) {
        this.autoStartNavi = bool;
        this.defaultNaviEngine = str;
    }

    private DriverConfig(Builder builder) {
        this(builder.autoStartNavi, builder.defaultNaviEngine);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverConfig)) {
            return false;
        }
        DriverConfig driverConfig = (DriverConfig) obj;
        if (!equals((Object) this.autoStartNavi, (Object) driverConfig.autoStartNavi) || !equals((Object) this.defaultNaviEngine, (Object) driverConfig.defaultNaviEngine)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.autoStartNavi;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        String str = this.defaultNaviEngine;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverConfig> {
        public Boolean autoStartNavi;
        public String defaultNaviEngine;

        public Builder() {
        }

        public Builder(DriverConfig driverConfig) {
            super(driverConfig);
            if (driverConfig != null) {
                this.autoStartNavi = driverConfig.autoStartNavi;
                this.defaultNaviEngine = driverConfig.defaultNaviEngine;
            }
        }

        public Builder autoStartNavi(Boolean bool) {
            this.autoStartNavi = bool;
            return this;
        }

        public Builder defaultNaviEngine(String str) {
            this.defaultNaviEngine = str;
            return this;
        }

        public DriverConfig build() {
            return new DriverConfig(this);
        }
    }
}
