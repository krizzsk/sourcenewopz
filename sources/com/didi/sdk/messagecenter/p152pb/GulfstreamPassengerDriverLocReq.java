package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.sdk.messagecenter.pb.GulfstreamPassengerDriverLocReq */
public final class GulfstreamPassengerDriverLocReq extends Message {
    public static final Integer DEFAULT_DEBUG_OPEN = 0;
    public static final Integer DEFAULT_ETA = 0;
    public static final Integer DEFAULT_ETA_DISTANCE = 0;
    public static final String DEFAULT_ETA_ICON = "";
    public static final String DEFAULT_ETA_STR = "";
    public static final String DEFAULT_ETA_STR_VICE = "";
    public static final List<GridInfo> DEFAULT_GRID_INFOS = Collections.emptyList();
    public static final Integer DEFAULT_ISEXIST_CAR = 0;
    public static final Integer DEFAULT_ISFORBIDDEN_ORDER = 0;
    public static final Integer DEFAULT_ISSHOW_ETA = 0;
    public static final List<DriverLocationInfo> DEFAULT_LOC = Collections.emptyList();
    public static final Integer DEFAULT_LOOP_INTERVAL = 0;
    public static final OrderStat DEFAULT_ORDER_STAT = OrderStat.HomePage;
    public static final Integer DEFAULT_REDIRECT = 0;
    public static final Integer DEFAULT_SDS_VISUAL_OPEN = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer debug_open;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer eta_distance;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String eta_icon;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String eta_str;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String eta_str_vice;
    @ProtoField(label = Message.Label.REPEATED, messageType = GridInfo.class, tag = 9)
    public final List<GridInfo> grid_infos;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer isexist_car;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer isforbidden_order;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer isshow_eta;
    @ProtoField(label = Message.Label.REPEATED, messageType = DriverLocationInfo.class, tag = 1)
    public final List<DriverLocationInfo> loc;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer loop_interval;
    @ProtoField(tag = 5, type = Message.Datatype.ENUM)
    public final OrderStat order_stat;
    @ProtoField(tag = 10)
    public final PQueueInfo pq_info;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer redirect;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer sds_visual_open;
    @ProtoField(tag = 12)
    public final TEta t_eta;

    public GulfstreamPassengerDriverLocReq(List<DriverLocationInfo> list, Integer num, Integer num2, String str, OrderStat orderStat, Integer num3, Integer num4, Integer num5, List<GridInfo> list2, PQueueInfo pQueueInfo, Integer num6, TEta tEta, Integer num7, Integer num8, String str2, String str3, Integer num9) {
        this.loc = immutableCopyOf(list);
        this.eta = num;
        this.eta_distance = num2;
        this.eta_str = str;
        this.order_stat = orderStat;
        this.redirect = num3;
        this.debug_open = num4;
        this.sds_visual_open = num5;
        this.grid_infos = immutableCopyOf(list2);
        this.pq_info = pQueueInfo;
        this.isexist_car = num6;
        this.t_eta = tEta;
        this.isshow_eta = num7;
        this.loop_interval = num8;
        this.eta_str_vice = str2;
        this.eta_icon = str3;
        this.isforbidden_order = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private GulfstreamPassengerDriverLocReq(com.didi.sdk.messagecenter.p152pb.GulfstreamPassengerDriverLocReq.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            java.util.List<com.didi.sdk.messagecenter.pb.DriverLocationInfo> r2 = r0.loc
            java.lang.Integer r3 = r0.eta
            java.lang.Integer r4 = r0.eta_distance
            java.lang.String r5 = r0.eta_str
            com.didi.sdk.messagecenter.pb.OrderStat r6 = r0.order_stat
            java.lang.Integer r7 = r0.redirect
            java.lang.Integer r8 = r0.debug_open
            java.lang.Integer r9 = r0.sds_visual_open
            java.util.List<com.didi.sdk.messagecenter.pb.GridInfo> r10 = r0.grid_infos
            com.didi.sdk.messagecenter.pb.PQueueInfo r11 = r0.pq_info
            java.lang.Integer r12 = r0.isexist_car
            com.didi.sdk.messagecenter.pb.TEta r13 = r0.t_eta
            java.lang.Integer r14 = r0.isshow_eta
            java.lang.Integer r15 = r0.loop_interval
            r19 = r1
            java.lang.String r1 = r0.eta_str_vice
            r16 = r1
            java.lang.String r1 = r0.eta_icon
            r17 = r1
            java.lang.Integer r1 = r0.isforbidden_order
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.messagecenter.p152pb.GulfstreamPassengerDriverLocReq.<init>(com.didi.sdk.messagecenter.pb.GulfstreamPassengerDriverLocReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GulfstreamPassengerDriverLocReq)) {
            return false;
        }
        GulfstreamPassengerDriverLocReq gulfstreamPassengerDriverLocReq = (GulfstreamPassengerDriverLocReq) obj;
        if (!equals((List<?>) this.loc, (List<?>) gulfstreamPassengerDriverLocReq.loc) || !equals((Object) this.eta, (Object) gulfstreamPassengerDriverLocReq.eta) || !equals((Object) this.eta_distance, (Object) gulfstreamPassengerDriverLocReq.eta_distance) || !equals((Object) this.eta_str, (Object) gulfstreamPassengerDriverLocReq.eta_str) || !equals((Object) this.order_stat, (Object) gulfstreamPassengerDriverLocReq.order_stat) || !equals((Object) this.redirect, (Object) gulfstreamPassengerDriverLocReq.redirect) || !equals((Object) this.debug_open, (Object) gulfstreamPassengerDriverLocReq.debug_open) || !equals((Object) this.sds_visual_open, (Object) gulfstreamPassengerDriverLocReq.sds_visual_open) || !equals((List<?>) this.grid_infos, (List<?>) gulfstreamPassengerDriverLocReq.grid_infos) || !equals((Object) this.pq_info, (Object) gulfstreamPassengerDriverLocReq.pq_info) || !equals((Object) this.isexist_car, (Object) gulfstreamPassengerDriverLocReq.isexist_car) || !equals((Object) this.t_eta, (Object) gulfstreamPassengerDriverLocReq.t_eta) || !equals((Object) this.isshow_eta, (Object) gulfstreamPassengerDriverLocReq.isshow_eta) || !equals((Object) this.loop_interval, (Object) gulfstreamPassengerDriverLocReq.loop_interval) || !equals((Object) this.eta_str_vice, (Object) gulfstreamPassengerDriverLocReq.eta_str_vice) || !equals((Object) this.eta_icon, (Object) gulfstreamPassengerDriverLocReq.eta_icon) || !equals((Object) this.isforbidden_order, (Object) gulfstreamPassengerDriverLocReq.isforbidden_order)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<DriverLocationInfo> list = this.loc;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.eta;
        int i3 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.eta_distance;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.eta_str;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        OrderStat orderStat = this.order_stat;
        int hashCode5 = (hashCode4 + (orderStat != null ? orderStat.hashCode() : 0)) * 37;
        Integer num3 = this.redirect;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.debug_open;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.sds_visual_open;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        List<GridInfo> list2 = this.grid_infos;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i4 = (hashCode8 + i2) * 37;
        PQueueInfo pQueueInfo = this.pq_info;
        int hashCode9 = (i4 + (pQueueInfo != null ? pQueueInfo.hashCode() : 0)) * 37;
        Integer num6 = this.isexist_car;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        TEta tEta = this.t_eta;
        int hashCode11 = (hashCode10 + (tEta != null ? tEta.hashCode() : 0)) * 37;
        Integer num7 = this.isshow_eta;
        int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.loop_interval;
        int hashCode13 = (hashCode12 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str2 = this.eta_str_vice;
        int hashCode14 = (hashCode13 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.eta_icon;
        int hashCode15 = (hashCode14 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num9 = this.isforbidden_order;
        if (num9 != null) {
            i3 = num9.hashCode();
        }
        int i5 = hashCode15 + i3;
        this.hashCode = i5;
        return i5;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.GulfstreamPassengerDriverLocReq$Builder */
    public static final class Builder extends Message.Builder<GulfstreamPassengerDriverLocReq> {
        public Integer debug_open;
        public Integer eta;
        public Integer eta_distance;
        public String eta_icon;
        public String eta_str;
        public String eta_str_vice;
        public List<GridInfo> grid_infos;
        public Integer isexist_car;
        public Integer isforbidden_order;
        public Integer isshow_eta;
        public List<DriverLocationInfo> loc;
        public Integer loop_interval;
        public OrderStat order_stat;
        public PQueueInfo pq_info;
        public Integer redirect;
        public Integer sds_visual_open;
        public TEta t_eta;

        public Builder() {
        }

        public Builder(GulfstreamPassengerDriverLocReq gulfstreamPassengerDriverLocReq) {
            super(gulfstreamPassengerDriverLocReq);
            if (gulfstreamPassengerDriverLocReq != null) {
                this.loc = GulfstreamPassengerDriverLocReq.copyOf(gulfstreamPassengerDriverLocReq.loc);
                this.eta = gulfstreamPassengerDriverLocReq.eta;
                this.eta_distance = gulfstreamPassengerDriverLocReq.eta_distance;
                this.eta_str = gulfstreamPassengerDriverLocReq.eta_str;
                this.order_stat = gulfstreamPassengerDriverLocReq.order_stat;
                this.redirect = gulfstreamPassengerDriverLocReq.redirect;
                this.debug_open = gulfstreamPassengerDriverLocReq.debug_open;
                this.sds_visual_open = gulfstreamPassengerDriverLocReq.sds_visual_open;
                this.grid_infos = GulfstreamPassengerDriverLocReq.copyOf(gulfstreamPassengerDriverLocReq.grid_infos);
                this.pq_info = gulfstreamPassengerDriverLocReq.pq_info;
                this.isexist_car = gulfstreamPassengerDriverLocReq.isexist_car;
                this.t_eta = gulfstreamPassengerDriverLocReq.t_eta;
                this.isshow_eta = gulfstreamPassengerDriverLocReq.isshow_eta;
                this.loop_interval = gulfstreamPassengerDriverLocReq.loop_interval;
                this.eta_str_vice = gulfstreamPassengerDriverLocReq.eta_str_vice;
                this.eta_icon = gulfstreamPassengerDriverLocReq.eta_icon;
                this.isforbidden_order = gulfstreamPassengerDriverLocReq.isforbidden_order;
            }
        }

        public Builder loc(List<DriverLocationInfo> list) {
            this.loc = checkForNulls(list);
            return this;
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder eta_distance(Integer num) {
            this.eta_distance = num;
            return this;
        }

        public Builder eta_str(String str) {
            this.eta_str = str;
            return this;
        }

        public Builder order_stat(OrderStat orderStat) {
            this.order_stat = orderStat;
            return this;
        }

        public Builder redirect(Integer num) {
            this.redirect = num;
            return this;
        }

        public Builder debug_open(Integer num) {
            this.debug_open = num;
            return this;
        }

        public Builder sds_visual_open(Integer num) {
            this.sds_visual_open = num;
            return this;
        }

        public Builder grid_infos(List<GridInfo> list) {
            this.grid_infos = checkForNulls(list);
            return this;
        }

        public Builder pq_info(PQueueInfo pQueueInfo) {
            this.pq_info = pQueueInfo;
            return this;
        }

        public Builder isexist_car(Integer num) {
            this.isexist_car = num;
            return this;
        }

        public Builder t_eta(TEta tEta) {
            this.t_eta = tEta;
            return this;
        }

        public Builder isshow_eta(Integer num) {
            this.isshow_eta = num;
            return this;
        }

        public Builder loop_interval(Integer num) {
            this.loop_interval = num;
            return this;
        }

        public Builder eta_str_vice(String str) {
            this.eta_str_vice = str;
            return this;
        }

        public Builder eta_icon(String str) {
            this.eta_icon = str;
            return this;
        }

        public Builder isforbidden_order(Integer num) {
            this.isforbidden_order = num;
            return this;
        }

        public GulfstreamPassengerDriverLocReq build() {
            return new GulfstreamPassengerDriverLocReq(this);
        }
    }
}
