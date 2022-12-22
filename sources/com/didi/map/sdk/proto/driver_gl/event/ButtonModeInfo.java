package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ButtonModeInfo extends Message {
    public static final Integer DEFAULT_BUTTONMODE = 0;
    public static final String DEFAULT_BUTTONPICURL = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer buttonMode;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String buttonPicUrl;

    public ButtonModeInfo(String str, Integer num) {
        this.buttonPicUrl = str;
        this.buttonMode = num;
    }

    private ButtonModeInfo(Builder builder) {
        this(builder.buttonPicUrl, builder.buttonMode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ButtonModeInfo)) {
            return false;
        }
        ButtonModeInfo buttonModeInfo = (ButtonModeInfo) obj;
        if (!equals((Object) this.buttonPicUrl, (Object) buttonModeInfo.buttonPicUrl) || !equals((Object) this.buttonMode, (Object) buttonModeInfo.buttonMode)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.buttonPicUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.buttonMode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ButtonModeInfo> {
        public Integer buttonMode;
        public String buttonPicUrl;

        public Builder() {
        }

        public Builder(ButtonModeInfo buttonModeInfo) {
            super(buttonModeInfo);
            if (buttonModeInfo != null) {
                this.buttonPicUrl = buttonModeInfo.buttonPicUrl;
                this.buttonMode = buttonModeInfo.buttonMode;
            }
        }

        public Builder buttonPicUrl(String str) {
            this.buttonPicUrl = str;
            return this;
        }

        public Builder buttonMode(Integer num) {
            this.buttonMode = num;
            return this;
        }

        public ButtonModeInfo build() {
            checkRequiredFields();
            return new ButtonModeInfo(this);
        }
    }
}
