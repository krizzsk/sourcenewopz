package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ToastData extends Message {
    public static final List<String> DEFAULT_EVENTIDS = Collections.emptyList();
    public static final String DEFAULT_MSG = "";
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final ToastType DEFAULT_TYPE = ToastType.TrafficJam;
    public static final String DEFAULT_UNIQID = "";
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.STRING)
    public final List<String> eventIds;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long routeId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final ToastType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String uniqId;

    public ToastData(ToastType toastType, String str, String str2, Long l, List<String> list) {
        this.type = toastType;
        this.uniqId = str;
        this.msg = str2;
        this.routeId = l;
        this.eventIds = immutableCopyOf(list);
    }

    private ToastData(Builder builder) {
        this(builder.type, builder.uniqId, builder.msg, builder.routeId, builder.eventIds);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ToastData)) {
            return false;
        }
        ToastData toastData = (ToastData) obj;
        if (!equals((Object) this.type, (Object) toastData.type) || !equals((Object) this.uniqId, (Object) toastData.uniqId) || !equals((Object) this.msg, (Object) toastData.msg) || !equals((Object) this.routeId, (Object) toastData.routeId) || !equals((List<?>) this.eventIds, (List<?>) toastData.eventIds)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ToastType toastType = this.type;
        int i2 = 0;
        int hashCode = (toastType != null ? toastType.hashCode() : 0) * 37;
        String str = this.uniqId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.routeId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<String> list = this.eventIds;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<ToastData> {
        public List<String> eventIds;
        public String msg;
        public Long routeId;
        public ToastType type;
        public String uniqId;

        public Builder() {
        }

        public Builder(ToastData toastData) {
            super(toastData);
            if (toastData != null) {
                this.type = toastData.type;
                this.uniqId = toastData.uniqId;
                this.msg = toastData.msg;
                this.routeId = toastData.routeId;
                this.eventIds = ToastData.copyOf(toastData.eventIds);
            }
        }

        public Builder type(ToastType toastType) {
            this.type = toastType;
            return this;
        }

        public Builder uniqId(String str) {
            this.uniqId = str;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder eventIds(List<String> list) {
            this.eventIds = checkForNulls(list);
            return this;
        }

        public ToastData build() {
            checkRequiredFields();
            return new ToastData(this);
        }
    }
}
