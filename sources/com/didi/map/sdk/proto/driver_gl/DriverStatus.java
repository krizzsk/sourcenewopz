package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DriverStatus extends Message {
    public static final Integer DEFAULT_ABNORMALSCENE = 0;
    public static final enumAppPage DEFAULT_APPPAGE = enumAppPage.UnSet;
    public static final enumAppState DEFAULT_APPSTATE = enumAppState.Active;
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final List<Integer> DEFAULT_EDAS = Collections.emptyList();
    public static final List<Integer> DEFAULT_ETAS = Collections.emptyList();
    public static final String DEFAULT_ORDERID = "";
    public static final String DEFAULT_TRAVELID = "";
    @ProtoField(tag = 6)
    public final AdsorbLocInfo AdsorbLocInfo;
    @ProtoField(tag = 8, type = Message.Datatype.ENUM)
    public final enumAppPage AppPage;
    @ProtoField(tag = 7, type = Message.Datatype.ENUM)
    public final enumAppState AppState;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> EDAs;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> ETAs;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer abnormalScene;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long driverID;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String orderID;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String travelID;
    @ProtoField(tag = 1)
    public final VisitorInfo visitorInfo;

    public DriverStatus(VisitorInfo visitorInfo2, Long l, Integer num, List<Integer> list, List<Integer> list2, AdsorbLocInfo adsorbLocInfo, enumAppState enumappstate, enumAppPage enumapppage, Integer num2, String str, String str2) {
        this.visitorInfo = visitorInfo2;
        this.driverID = l;
        this.bizType = num;
        this.ETAs = immutableCopyOf(list);
        this.EDAs = immutableCopyOf(list2);
        this.AdsorbLocInfo = adsorbLocInfo;
        this.AppState = enumappstate;
        this.AppPage = enumapppage;
        this.abnormalScene = num2;
        this.orderID = str;
        this.travelID = str2;
    }

    private DriverStatus(Builder builder) {
        this(builder.visitorInfo, builder.driverID, builder.bizType, builder.ETAs, builder.EDAs, builder.AdsorbLocInfo, builder.AppState, builder.AppPage, builder.abnormalScene, builder.orderID, builder.travelID);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverStatus)) {
            return false;
        }
        DriverStatus driverStatus = (DriverStatus) obj;
        if (!equals((Object) this.visitorInfo, (Object) driverStatus.visitorInfo) || !equals((Object) this.driverID, (Object) driverStatus.driverID) || !equals((Object) this.bizType, (Object) driverStatus.bizType) || !equals((List<?>) this.ETAs, (List<?>) driverStatus.ETAs) || !equals((List<?>) this.EDAs, (List<?>) driverStatus.EDAs) || !equals((Object) this.AdsorbLocInfo, (Object) driverStatus.AdsorbLocInfo) || !equals((Object) this.AppState, (Object) driverStatus.AppState) || !equals((Object) this.AppPage, (Object) driverStatus.AppPage) || !equals((Object) this.abnormalScene, (Object) driverStatus.abnormalScene) || !equals((Object) this.orderID, (Object) driverStatus.orderID) || !equals((Object) this.travelID, (Object) driverStatus.travelID)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        VisitorInfo visitorInfo2 = this.visitorInfo;
        int i2 = 0;
        int hashCode = (visitorInfo2 != null ? visitorInfo2.hashCode() : 0) * 37;
        Long l = this.driverID;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.bizType;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        List<Integer> list = this.ETAs;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.EDAs;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode4 + i3) * 37;
        AdsorbLocInfo adsorbLocInfo = this.AdsorbLocInfo;
        int hashCode5 = (i4 + (adsorbLocInfo != null ? adsorbLocInfo.hashCode() : 0)) * 37;
        enumAppState enumappstate = this.AppState;
        int hashCode6 = (hashCode5 + (enumappstate != null ? enumappstate.hashCode() : 0)) * 37;
        enumAppPage enumapppage = this.AppPage;
        int hashCode7 = (hashCode6 + (enumapppage != null ? enumapppage.hashCode() : 0)) * 37;
        Integer num2 = this.abnormalScene;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.orderID;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.travelID;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i5 = hashCode9 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<DriverStatus> {
        public AdsorbLocInfo AdsorbLocInfo;
        public enumAppPage AppPage;
        public enumAppState AppState;
        public List<Integer> EDAs;
        public List<Integer> ETAs;
        public Integer abnormalScene;
        public Integer bizType;
        public Long driverID;
        public String orderID;
        public String travelID;
        public VisitorInfo visitorInfo;

        public Builder() {
        }

        public Builder(DriverStatus driverStatus) {
            super(driverStatus);
            if (driverStatus != null) {
                this.visitorInfo = driverStatus.visitorInfo;
                this.driverID = driverStatus.driverID;
                this.bizType = driverStatus.bizType;
                this.ETAs = DriverStatus.copyOf(driverStatus.ETAs);
                this.EDAs = DriverStatus.copyOf(driverStatus.EDAs);
                this.AdsorbLocInfo = driverStatus.AdsorbLocInfo;
                this.AppState = driverStatus.AppState;
                this.AppPage = driverStatus.AppPage;
                this.abnormalScene = driverStatus.abnormalScene;
                this.orderID = driverStatus.orderID;
                this.travelID = driverStatus.travelID;
            }
        }

        public Builder visitorInfo(VisitorInfo visitorInfo2) {
            this.visitorInfo = visitorInfo2;
            return this;
        }

        public Builder driverID(Long l) {
            this.driverID = l;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public Builder ETAs(List<Integer> list) {
            this.ETAs = checkForNulls(list);
            return this;
        }

        public Builder EDAs(List<Integer> list) {
            this.EDAs = checkForNulls(list);
            return this;
        }

        public Builder AdsorbLocInfo(AdsorbLocInfo adsorbLocInfo) {
            this.AdsorbLocInfo = adsorbLocInfo;
            return this;
        }

        public Builder AppState(enumAppState enumappstate) {
            this.AppState = enumappstate;
            return this;
        }

        public Builder AppPage(enumAppPage enumapppage) {
            this.AppPage = enumapppage;
            return this;
        }

        public Builder abnormalScene(Integer num) {
            this.abnormalScene = num;
            return this;
        }

        public Builder orderID(String str) {
            this.orderID = str;
            return this;
        }

        public Builder travelID(String str) {
            this.travelID = str;
            return this;
        }

        public DriverStatus build() {
            return new DriverStatus(this);
        }
    }
}
