package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PassengerMultiRouteRes extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    public static final String DEFAULT_INHERITFAILEDTIPS = "";
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    public static final Long DEFAULT_ROUTENUM = 0L;
    public static final List<Route> DEFAULT_ROUTES = Collections.emptyList();
    public static final Integer DEFAULT_UPDATEREASON = 0;
    @ProtoField(tag = 7)
    public final DriverLoc driverLoc;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String inheritFailedTips;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long routeNum;
    @ProtoField(label = Message.Label.REPEATED, messageType = Route.class, tag = 4)
    public final List<Route> routes;
    @ProtoField(tag = 5)
    public final selectedRouteInfo selectedRoute;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer updateReason;

    public PassengerMultiRouteRes(Integer num, String str, Long l, List<Route> list, selectedRouteInfo selectedrouteinfo, Long l2, DriverLoc driverLoc2, Integer num2, Long l3, String str2) {
        this.ret = num;
        this.msg = str;
        this.logId = l;
        this.routes = immutableCopyOf(list);
        this.selectedRoute = selectedrouteinfo;
        this.routeNum = l2;
        this.driverLoc = driverLoc2;
        this.updateReason = num2;
        this.groupId = l3;
        this.inheritFailedTips = str2;
    }

    private PassengerMultiRouteRes(Builder builder) {
        this(builder.ret, builder.msg, builder.logId, builder.routes, builder.selectedRoute, builder.routeNum, builder.driverLoc, builder.updateReason, builder.groupId, builder.inheritFailedTips);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerMultiRouteRes)) {
            return false;
        }
        PassengerMultiRouteRes passengerMultiRouteRes = (PassengerMultiRouteRes) obj;
        if (!equals((Object) this.ret, (Object) passengerMultiRouteRes.ret) || !equals((Object) this.msg, (Object) passengerMultiRouteRes.msg) || !equals((Object) this.logId, (Object) passengerMultiRouteRes.logId) || !equals((List<?>) this.routes, (List<?>) passengerMultiRouteRes.routes) || !equals((Object) this.selectedRoute, (Object) passengerMultiRouteRes.selectedRoute) || !equals((Object) this.routeNum, (Object) passengerMultiRouteRes.routeNum) || !equals((Object) this.driverLoc, (Object) passengerMultiRouteRes.driverLoc) || !equals((Object) this.updateReason, (Object) passengerMultiRouteRes.updateReason) || !equals((Object) this.groupId, (Object) passengerMultiRouteRes.groupId) || !equals((Object) this.inheritFailedTips, (Object) passengerMultiRouteRes.inheritFailedTips)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.logId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        List<Route> list = this.routes;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        selectedRouteInfo selectedrouteinfo = this.selectedRoute;
        int hashCode5 = (hashCode4 + (selectedrouteinfo != null ? selectedrouteinfo.hashCode() : 0)) * 37;
        Long l2 = this.routeNum;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        DriverLoc driverLoc2 = this.driverLoc;
        int hashCode7 = (hashCode6 + (driverLoc2 != null ? driverLoc2.hashCode() : 0)) * 37;
        Integer num2 = this.updateReason;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.groupId;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.inheritFailedTips;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PassengerMultiRouteRes> {
        public DriverLoc driverLoc;
        public Long groupId;
        public String inheritFailedTips;
        public Long logId;
        public String msg;
        public Integer ret;
        public Long routeNum;
        public List<Route> routes;
        public selectedRouteInfo selectedRoute;
        public Integer updateReason;

        public Builder() {
        }

        public Builder(PassengerMultiRouteRes passengerMultiRouteRes) {
            super(passengerMultiRouteRes);
            if (passengerMultiRouteRes != null) {
                this.ret = passengerMultiRouteRes.ret;
                this.msg = passengerMultiRouteRes.msg;
                this.logId = passengerMultiRouteRes.logId;
                this.routes = PassengerMultiRouteRes.copyOf(passengerMultiRouteRes.routes);
                this.selectedRoute = passengerMultiRouteRes.selectedRoute;
                this.routeNum = passengerMultiRouteRes.routeNum;
                this.driverLoc = passengerMultiRouteRes.driverLoc;
                this.updateReason = passengerMultiRouteRes.updateReason;
                this.groupId = passengerMultiRouteRes.groupId;
                this.inheritFailedTips = passengerMultiRouteRes.inheritFailedTips;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public Builder routes(List<Route> list) {
            this.routes = checkForNulls(list);
            return this;
        }

        public Builder selectedRoute(selectedRouteInfo selectedrouteinfo) {
            this.selectedRoute = selectedrouteinfo;
            return this;
        }

        public Builder routeNum(Long l) {
            this.routeNum = l;
            return this;
        }

        public Builder driverLoc(DriverLoc driverLoc2) {
            this.driverLoc = driverLoc2;
            return this;
        }

        public Builder updateReason(Integer num) {
            this.updateReason = num;
            return this;
        }

        public Builder groupId(Long l) {
            this.groupId = l;
            return this;
        }

        public Builder inheritFailedTips(String str) {
            this.inheritFailedTips = str;
            return this;
        }

        public PassengerMultiRouteRes build() {
            checkRequiredFields();
            return new PassengerMultiRouteRes(this);
        }
    }

    public static final class selectedRouteInfo extends Message {
        public static final Long DEFAULT_ROUTEID = 0L;
        public static final String DEFAULT_ROUTELABEL = "";
        @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
        public final Long routeId;
        @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
        public final String routeLabel;

        public selectedRouteInfo(Long l, String str) {
            this.routeId = l;
            this.routeLabel = str;
        }

        private selectedRouteInfo(Builder builder) {
            this(builder.routeId, builder.routeLabel);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof selectedRouteInfo)) {
                return false;
            }
            selectedRouteInfo selectedrouteinfo = (selectedRouteInfo) obj;
            if (!equals((Object) this.routeId, (Object) selectedrouteinfo.routeId) || !equals((Object) this.routeLabel, (Object) selectedrouteinfo.routeLabel)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            Long l = this.routeId;
            int i2 = 0;
            int hashCode = (l != null ? l.hashCode() : 0) * 37;
            String str = this.routeLabel;
            if (str != null) {
                i2 = str.hashCode();
            }
            int i3 = hashCode + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<selectedRouteInfo> {
            public Long routeId;
            public String routeLabel;

            public Builder() {
            }

            public Builder(selectedRouteInfo selectedrouteinfo) {
                super(selectedrouteinfo);
                if (selectedrouteinfo != null) {
                    this.routeId = selectedrouteinfo.routeId;
                    this.routeLabel = selectedrouteinfo.routeLabel;
                }
            }

            public Builder routeId(Long l) {
                this.routeId = l;
                return this;
            }

            public Builder routeLabel(String str) {
                this.routeLabel = str;
                return this;
            }

            public selectedRouteInfo build() {
                checkRequiredFields();
                return new selectedRouteInfo(this);
            }
        }
    }
}
