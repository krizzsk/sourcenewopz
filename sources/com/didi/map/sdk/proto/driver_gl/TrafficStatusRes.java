package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class TrafficStatusRes extends Message {
    public static final List<Integer> DEFAULT_ETAS = Collections.emptyList();
    public static final ByteString DEFAULT_EVENT = ByteString.EMPTY;
    public static final ByteString DEFAULT_EXTENDDATA = ByteString.EMPTY;
    public static final List<IndexOfLeg> DEFAULT_LEGS = Collections.emptyList();
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_LOGSTR = "";
    public static final String DEFAULT_MSG = "";
    public static final ByteString DEFAULT_NAVIEVENTS = ByteString.EMPTY;
    public static final List<OptionalRouteRes> DEFAULT_OPROUTERES = Collections.emptyList();
    public static final Integer DEFAULT_RAINBOWEXPIRETIMEMS = 0;
    public static final Integer DEFAULT_RET = 0;
    public static final Long DEFAULT_SERVERTIMESTAMPNS = 0L;
    public static final List<TrafficItem> DEFAULT_TRAFFIC = Collections.emptyList();
    public static final List<NaviTrafficSegment> DEFAULT_TRAFFIC_SEGMENTS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT32)
    public final List<Integer> etas;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final ByteString event;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final ByteString extendData;
    @ProtoField(label = Message.Label.REPEATED, messageType = IndexOfLeg.class, tag = 7)
    public final List<IndexOfLeg> legs;
    @ProtoField(tag = 14, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String logStr;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 15)
    public final Msg2PsgRes msg2PsgRes;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final ByteString naviEvents;
    @ProtoField(label = Message.Label.REPEATED, messageType = OptionalRouteRes.class, tag = 13)
    public final List<OptionalRouteRes> opRouteRes;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer rainbowExpireTimeMS;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long serverTimestampNS;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficItem.class, tag = 3)
    public final List<TrafficItem> traffic;
    @ProtoField(label = Message.Label.REPEATED, messageType = NaviTrafficSegment.class, tag = 4)
    public final List<NaviTrafficSegment> traffic_segments;

    public TrafficStatusRes(Integer num, String str, List<TrafficItem> list, List<NaviTrafficSegment> list2, ByteString byteString, ByteString byteString2, List<IndexOfLeg> list3, String str2, Integer num2, List<Integer> list4, Long l, ByteString byteString3, List<OptionalRouteRes> list5, Long l2, Msg2PsgRes msg2PsgRes2) {
        this.ret = num;
        this.msg = str;
        this.traffic = immutableCopyOf(list);
        this.traffic_segments = immutableCopyOf(list2);
        this.naviEvents = byteString;
        this.event = byteString2;
        this.legs = immutableCopyOf(list3);
        this.logStr = str2;
        this.rainbowExpireTimeMS = num2;
        this.etas = immutableCopyOf(list4);
        this.serverTimestampNS = l;
        this.extendData = byteString3;
        this.opRouteRes = immutableCopyOf(list5);
        this.logId = l2;
        this.msg2PsgRes = msg2PsgRes2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TrafficStatusRes(com.didi.map.sdk.proto.driver_gl.TrafficStatusRes.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Integer r2 = r0.ret
            java.lang.String r3 = r0.msg
            java.util.List<com.didi.map.sdk.proto.driver_gl.TrafficItem> r4 = r0.traffic
            java.util.List<com.didi.map.sdk.proto.driver_gl.NaviTrafficSegment> r5 = r0.traffic_segments
            okio.ByteString r6 = r0.naviEvents
            okio.ByteString r7 = r0.event
            java.util.List<com.didi.map.sdk.proto.driver_gl.IndexOfLeg> r8 = r0.legs
            java.lang.String r9 = r0.logStr
            java.lang.Integer r10 = r0.rainbowExpireTimeMS
            java.util.List<java.lang.Integer> r11 = r0.etas
            java.lang.Long r12 = r0.serverTimestampNS
            okio.ByteString r13 = r0.extendData
            java.util.List<com.didi.map.sdk.proto.driver_gl.OptionalRouteRes> r14 = r0.opRouteRes
            java.lang.Long r15 = r0.logId
            com.didi.map.sdk.proto.driver_gl.Msg2PsgRes r1 = r0.msg2PsgRes
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.TrafficStatusRes.<init>(com.didi.map.sdk.proto.driver_gl.TrafficStatusRes$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficStatusRes)) {
            return false;
        }
        TrafficStatusRes trafficStatusRes = (TrafficStatusRes) obj;
        if (!equals((Object) this.ret, (Object) trafficStatusRes.ret) || !equals((Object) this.msg, (Object) trafficStatusRes.msg) || !equals((List<?>) this.traffic, (List<?>) trafficStatusRes.traffic) || !equals((List<?>) this.traffic_segments, (List<?>) trafficStatusRes.traffic_segments) || !equals((Object) this.naviEvents, (Object) trafficStatusRes.naviEvents) || !equals((Object) this.event, (Object) trafficStatusRes.event) || !equals((List<?>) this.legs, (List<?>) trafficStatusRes.legs) || !equals((Object) this.logStr, (Object) trafficStatusRes.logStr) || !equals((Object) this.rainbowExpireTimeMS, (Object) trafficStatusRes.rainbowExpireTimeMS) || !equals((List<?>) this.etas, (List<?>) trafficStatusRes.etas) || !equals((Object) this.serverTimestampNS, (Object) trafficStatusRes.serverTimestampNS) || !equals((Object) this.extendData, (Object) trafficStatusRes.extendData) || !equals((List<?>) this.opRouteRes, (List<?>) trafficStatusRes.opRouteRes) || !equals((Object) this.logId, (Object) trafficStatusRes.logId) || !equals((Object) this.msg2PsgRes, (Object) trafficStatusRes.msg2PsgRes)) {
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
        List<TrafficItem> list = this.traffic;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<NaviTrafficSegment> list2 = this.traffic_segments;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        ByteString byteString = this.naviEvents;
        int hashCode5 = (hashCode4 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        ByteString byteString2 = this.event;
        int hashCode6 = (hashCode5 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        List<IndexOfLeg> list3 = this.legs;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 1)) * 37;
        String str2 = this.logStr;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.rainbowExpireTimeMS;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<Integer> list4 = this.etas;
        int hashCode10 = (hashCode9 + (list4 != null ? list4.hashCode() : 1)) * 37;
        Long l = this.serverTimestampNS;
        int hashCode11 = (hashCode10 + (l != null ? l.hashCode() : 0)) * 37;
        ByteString byteString3 = this.extendData;
        int hashCode12 = (hashCode11 + (byteString3 != null ? byteString3.hashCode() : 0)) * 37;
        List<OptionalRouteRes> list5 = this.opRouteRes;
        if (list5 != null) {
            i3 = list5.hashCode();
        }
        int i4 = (hashCode12 + i3) * 37;
        Long l2 = this.logId;
        int hashCode13 = (i4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Msg2PsgRes msg2PsgRes2 = this.msg2PsgRes;
        if (msg2PsgRes2 != null) {
            i2 = msg2PsgRes2.hashCode();
        }
        int i5 = hashCode13 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<TrafficStatusRes> {
        public List<Integer> etas;
        public ByteString event;
        public ByteString extendData;
        public List<IndexOfLeg> legs;
        public Long logId;
        public String logStr;
        public String msg;
        public Msg2PsgRes msg2PsgRes;
        public ByteString naviEvents;
        public List<OptionalRouteRes> opRouteRes;
        public Integer rainbowExpireTimeMS;
        public Integer ret;
        public Long serverTimestampNS;
        public List<TrafficItem> traffic;
        public List<NaviTrafficSegment> traffic_segments;

        public Builder() {
        }

        public Builder(TrafficStatusRes trafficStatusRes) {
            super(trafficStatusRes);
            if (trafficStatusRes != null) {
                this.ret = trafficStatusRes.ret;
                this.msg = trafficStatusRes.msg;
                this.traffic = TrafficStatusRes.copyOf(trafficStatusRes.traffic);
                this.traffic_segments = TrafficStatusRes.copyOf(trafficStatusRes.traffic_segments);
                this.naviEvents = trafficStatusRes.naviEvents;
                this.event = trafficStatusRes.event;
                this.legs = TrafficStatusRes.copyOf(trafficStatusRes.legs);
                this.logStr = trafficStatusRes.logStr;
                this.rainbowExpireTimeMS = trafficStatusRes.rainbowExpireTimeMS;
                this.etas = TrafficStatusRes.copyOf(trafficStatusRes.etas);
                this.serverTimestampNS = trafficStatusRes.serverTimestampNS;
                this.extendData = trafficStatusRes.extendData;
                this.opRouteRes = TrafficStatusRes.copyOf(trafficStatusRes.opRouteRes);
                this.logId = trafficStatusRes.logId;
                this.msg2PsgRes = trafficStatusRes.msg2PsgRes;
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

        public Builder traffic(List<TrafficItem> list) {
            this.traffic = checkForNulls(list);
            return this;
        }

        public Builder traffic_segments(List<NaviTrafficSegment> list) {
            this.traffic_segments = checkForNulls(list);
            return this;
        }

        public Builder naviEvents(ByteString byteString) {
            this.naviEvents = byteString;
            return this;
        }

        public Builder event(ByteString byteString) {
            this.event = byteString;
            return this;
        }

        public Builder legs(List<IndexOfLeg> list) {
            this.legs = checkForNulls(list);
            return this;
        }

        public Builder logStr(String str) {
            this.logStr = str;
            return this;
        }

        public Builder rainbowExpireTimeMS(Integer num) {
            this.rainbowExpireTimeMS = num;
            return this;
        }

        public Builder etas(List<Integer> list) {
            this.etas = checkForNulls(list);
            return this;
        }

        public Builder serverTimestampNS(Long l) {
            this.serverTimestampNS = l;
            return this;
        }

        public Builder extendData(ByteString byteString) {
            this.extendData = byteString;
            return this;
        }

        public Builder opRouteRes(List<OptionalRouteRes> list) {
            this.opRouteRes = checkForNulls(list);
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public Builder msg2PsgRes(Msg2PsgRes msg2PsgRes2) {
            this.msg2PsgRes = msg2PsgRes2;
            return this;
        }

        public TrafficStatusRes build() {
            checkRequiredFields();
            return new TrafficStatusRes(this);
        }
    }
}
