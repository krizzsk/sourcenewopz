package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DriverAppCheckReq extends Message {
    public static final Integer DEFAULT_APPTYPE = 0;
    public static final List<CheckMessage> DEFAULT_CHECKLIST = Collections.emptyList();
    public static final Boolean DEFAULT_CHECKROOT = false;
    public static final Boolean DEFAULT_CHECKTIME = false;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer appType;
    @ProtoField(label = Message.Label.REPEATED, messageType = CheckMessage.class, tag = 4)
    public final List<CheckMessage> checkList;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean checkRoot;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean checkTime;

    public DriverAppCheckReq(Integer num, Boolean bool, Boolean bool2, List<CheckMessage> list) {
        this.appType = num;
        this.checkTime = bool;
        this.checkRoot = bool2;
        this.checkList = immutableCopyOf(list);
    }

    private DriverAppCheckReq(Builder builder) {
        this(builder.appType, builder.checkTime, builder.checkRoot, builder.checkList);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverAppCheckReq)) {
            return false;
        }
        DriverAppCheckReq driverAppCheckReq = (DriverAppCheckReq) obj;
        if (!equals((Object) this.appType, (Object) driverAppCheckReq.appType) || !equals((Object) this.checkTime, (Object) driverAppCheckReq.checkTime) || !equals((Object) this.checkRoot, (Object) driverAppCheckReq.checkRoot) || !equals((List<?>) this.checkList, (List<?>) driverAppCheckReq.checkList)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.appType;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Boolean bool = this.checkTime;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.checkRoot;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<CheckMessage> list = this.checkList;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<DriverAppCheckReq> {
        public Integer appType;
        public List<CheckMessage> checkList;
        public Boolean checkRoot;
        public Boolean checkTime;

        public Builder() {
        }

        public Builder(DriverAppCheckReq driverAppCheckReq) {
            super(driverAppCheckReq);
            if (driverAppCheckReq != null) {
                this.appType = driverAppCheckReq.appType;
                this.checkTime = driverAppCheckReq.checkTime;
                this.checkRoot = driverAppCheckReq.checkRoot;
                this.checkList = DriverAppCheckReq.copyOf(driverAppCheckReq.checkList);
            }
        }

        public Builder appType(Integer num) {
            this.appType = num;
            return this;
        }

        public Builder checkTime(Boolean bool) {
            this.checkTime = bool;
            return this;
        }

        public Builder checkRoot(Boolean bool) {
            this.checkRoot = bool;
            return this;
        }

        public Builder checkList(List<CheckMessage> list) {
            this.checkList = checkForNulls(list);
            return this;
        }

        public DriverAppCheckReq build() {
            return new DriverAppCheckReq(this);
        }
    }

    public static final class CheckMessage extends Message {
        public static final String DEFAULT_MD5 = "";
        public static final String DEFAULT_PACKAGE = "";
        @ProtoField(tag = 1, type = Message.Datatype.STRING)
        public final String _package;
        @ProtoField(tag = 2, type = Message.Datatype.STRING)
        public final String md5;

        public CheckMessage(String str, String str2) {
            this._package = str;
            this.md5 = str2;
        }

        private CheckMessage(Builder builder) {
            this(builder._package, builder.md5);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CheckMessage)) {
                return false;
            }
            CheckMessage checkMessage = (CheckMessage) obj;
            if (!equals((Object) this._package, (Object) checkMessage._package) || !equals((Object) this.md5, (Object) checkMessage.md5)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            String str = this._package;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 37;
            String str2 = this.md5;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            int i3 = hashCode + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<CheckMessage> {
            public String _package;
            public String md5;

            public Builder() {
            }

            public Builder(CheckMessage checkMessage) {
                super(checkMessage);
                if (checkMessage != null) {
                    this._package = checkMessage._package;
                    this.md5 = checkMessage.md5;
                }
            }

            public Builder _package(String str) {
                this._package = str;
                return this;
            }

            public Builder md5(String str) {
                this.md5 = str;
                return this;
            }

            public CheckMessage build() {
                return new CheckMessage(this);
            }
        }
    }
}
