package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class VISentence extends Message {
    public static final List<VICond> DEFAULT_COND = Collections.emptyList();
    public static final VIPrefixKindEnum DEFAULT_PREFIXKIND = VIPrefixKindEnum.VIPrefixKind_Null;
    public static final String DEFAULT_TTSCONTENT = "";
    @ProtoField(label = Message.Label.REPEATED, messageType = VICond.class, tag = 3)
    public final List<VICond> cond;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final VIPrefixKindEnum prefixKind;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String ttsContent;

    public VISentence(VIPrefixKindEnum vIPrefixKindEnum, String str, List<VICond> list) {
        this.prefixKind = vIPrefixKindEnum;
        this.ttsContent = str;
        this.cond = immutableCopyOf(list);
    }

    private VISentence(Builder builder) {
        this(builder.prefixKind, builder.ttsContent, builder.cond);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VISentence)) {
            return false;
        }
        VISentence vISentence = (VISentence) obj;
        if (!equals((Object) this.prefixKind, (Object) vISentence.prefixKind) || !equals((Object) this.ttsContent, (Object) vISentence.ttsContent) || !equals((List<?>) this.cond, (List<?>) vISentence.cond)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        VIPrefixKindEnum vIPrefixKindEnum = this.prefixKind;
        int i2 = 0;
        int hashCode = (vIPrefixKindEnum != null ? vIPrefixKindEnum.hashCode() : 0) * 37;
        String str = this.ttsContent;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<VICond> list = this.cond;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<VISentence> {
        public List<VICond> cond;
        public VIPrefixKindEnum prefixKind;
        public String ttsContent;

        public Builder() {
        }

        public Builder(VISentence vISentence) {
            super(vISentence);
            if (vISentence != null) {
                this.prefixKind = vISentence.prefixKind;
                this.ttsContent = vISentence.ttsContent;
                this.cond = VISentence.copyOf(vISentence.cond);
            }
        }

        public Builder prefixKind(VIPrefixKindEnum vIPrefixKindEnum) {
            this.prefixKind = vIPrefixKindEnum;
            return this;
        }

        public Builder ttsContent(String str) {
            this.ttsContent = str;
            return this;
        }

        public Builder cond(List<VICond> list) {
            this.cond = checkForNulls(list);
            return this;
        }

        public VISentence build() {
            checkRequiredFields();
            return new VISentence(this);
        }
    }
}
