package com.didi.trackupload.sdk.datachannel.protobuf;

import com.google.gson.annotations.SerializedName;
import com.sdu.didi.protobuf.MapTrackExtraMessageData;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackUploadReq extends Message {
    public static final List<BizNode> DEFAULT_BIZ_INFO = Collections.emptyList();
    public static final List<TrackLocationInfo> DEFAULT_LOC_RECENT = Collections.emptyList();
    public static final String DEFAULT_PHONE = "";
    public static final List<TrackNode> DEFAULT_TRACK_NODES = Collections.emptyList();
    public static final Long DEFAULT_UPLOAD_TIME64_LOC = 0L;
    public static final Long DEFAULT_UPLOAD_TIME64_MOBILE = 0L;
    public static final Long DEFAULT_USER_ID = 0L;
    @SerializedName("biz_info")
    @ProtoField(label = Message.Label.REPEATED, messageType = BizNode.class, tag = 9)
    public final List<BizNode> biz_info;
    @SerializedName("loc")
    @ProtoField(label = Message.Label.REQUIRED, tag = 5)
    public final TrackLocationInfo loc;
    @SerializedName("loc_recent")
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackLocationInfo.class, tag = 7)
    public final List<TrackLocationInfo> loc_recent;
    @SerializedName("loc_rectified")
    @ProtoField(tag = 6)
    public final TrackLocationInfo loc_rectified;
    @SerializedName("map_extra_message_data")
    @ProtoField(tag = 10)
    public final MapTrackExtraMessageData map_extra_message_data;
    @SerializedName("phone")
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone;
    @SerializedName("track_nodes")
    @ProtoField(label = Message.Label.REPEATED, messageType = TrackNode.class, tag = 8)
    public final List<TrackNode> track_nodes;
    @SerializedName("upload_time64_loc")
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.UINT64)
    public final Long upload_time64_loc;
    @SerializedName("upload_time64_mobile")
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long upload_time64_mobile;
    @SerializedName("user_id")
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long user_id;

    public TrackUploadReq(String str, Long l, Long l2, Long l3, TrackLocationInfo trackLocationInfo, TrackLocationInfo trackLocationInfo2, List<TrackLocationInfo> list, List<TrackNode> list2, List<BizNode> list3, MapTrackExtraMessageData mapTrackExtraMessageData) {
        this.phone = str;
        this.user_id = l;
        this.upload_time64_mobile = l2;
        this.upload_time64_loc = l3;
        this.loc = trackLocationInfo;
        this.loc_rectified = trackLocationInfo2;
        this.loc_recent = immutableCopyOf(list);
        this.track_nodes = immutableCopyOf(list2);
        this.biz_info = immutableCopyOf(list3);
        this.map_extra_message_data = mapTrackExtraMessageData;
    }

    private TrackUploadReq(Builder builder) {
        this(builder.phone, builder.user_id, builder.upload_time64_mobile, builder.upload_time64_loc, builder.loc, builder.loc_rectified, builder.loc_recent, builder.track_nodes, builder.biz_info, builder.map_extra_message_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackUploadReq)) {
            return false;
        }
        TrackUploadReq trackUploadReq = (TrackUploadReq) obj;
        if (!equals((Object) this.phone, (Object) trackUploadReq.phone) || !equals((Object) this.user_id, (Object) trackUploadReq.user_id) || !equals((Object) this.upload_time64_mobile, (Object) trackUploadReq.upload_time64_mobile) || !equals((Object) this.upload_time64_loc, (Object) trackUploadReq.upload_time64_loc) || !equals((Object) this.loc, (Object) trackUploadReq.loc) || !equals((Object) this.loc_rectified, (Object) trackUploadReq.loc_rectified) || !equals((List<?>) this.loc_recent, (List<?>) trackUploadReq.loc_recent) || !equals((List<?>) this.track_nodes, (List<?>) trackUploadReq.track_nodes) || !equals((List<?>) this.biz_info, (List<?>) trackUploadReq.biz_info) || !equals((Object) this.map_extra_message_data, (Object) trackUploadReq.map_extra_message_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.user_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.upload_time64_mobile;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.upload_time64_loc;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        TrackLocationInfo trackLocationInfo = this.loc;
        int hashCode5 = (hashCode4 + (trackLocationInfo != null ? trackLocationInfo.hashCode() : 0)) * 37;
        TrackLocationInfo trackLocationInfo2 = this.loc_rectified;
        int hashCode6 = (hashCode5 + (trackLocationInfo2 != null ? trackLocationInfo2.hashCode() : 0)) * 37;
        List<TrackLocationInfo> list = this.loc_recent;
        int i3 = 1;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        List<TrackNode> list2 = this.track_nodes;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<BizNode> list3 = this.biz_info;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode8 + i3) * 37;
        MapTrackExtraMessageData mapTrackExtraMessageData = this.map_extra_message_data;
        if (mapTrackExtraMessageData != null) {
            i2 = mapTrackExtraMessageData.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<TrackUploadReq> {
        public List<BizNode> biz_info;
        public TrackLocationInfo loc;
        public List<TrackLocationInfo> loc_recent;
        public TrackLocationInfo loc_rectified;
        public MapTrackExtraMessageData map_extra_message_data;
        public String phone;
        public List<TrackNode> track_nodes;
        public Long upload_time64_loc;
        public Long upload_time64_mobile;
        public Long user_id;

        public Builder() {
        }

        public Builder(TrackUploadReq trackUploadReq) {
            super(trackUploadReq);
            if (trackUploadReq != null) {
                this.phone = trackUploadReq.phone;
                this.user_id = trackUploadReq.user_id;
                this.upload_time64_mobile = trackUploadReq.upload_time64_mobile;
                this.upload_time64_loc = trackUploadReq.upload_time64_loc;
                this.loc = trackUploadReq.loc;
                this.loc_rectified = trackUploadReq.loc_rectified;
                this.loc_recent = TrackUploadReq.copyOf(trackUploadReq.loc_recent);
                this.track_nodes = TrackUploadReq.copyOf(trackUploadReq.track_nodes);
                this.biz_info = TrackUploadReq.copyOf(trackUploadReq.biz_info);
                this.map_extra_message_data = trackUploadReq.map_extra_message_data;
            }
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder upload_time64_mobile(Long l) {
            this.upload_time64_mobile = l;
            return this;
        }

        public Builder upload_time64_loc(Long l) {
            this.upload_time64_loc = l;
            return this;
        }

        public Builder loc(TrackLocationInfo trackLocationInfo) {
            this.loc = trackLocationInfo;
            return this;
        }

        public Builder loc_rectified(TrackLocationInfo trackLocationInfo) {
            this.loc_rectified = trackLocationInfo;
            return this;
        }

        public Builder loc_recent(List<TrackLocationInfo> list) {
            this.loc_recent = checkForNulls(list);
            return this;
        }

        public Builder track_nodes(List<TrackNode> list) {
            this.track_nodes = checkForNulls(list);
            return this;
        }

        public Builder biz_info(List<BizNode> list) {
            this.biz_info = checkForNulls(list);
            return this;
        }

        public Builder map_extra_message_data(MapTrackExtraMessageData mapTrackExtraMessageData) {
            this.map_extra_message_data = mapTrackExtraMessageData;
            return this;
        }

        public TrackUploadReq build() {
            checkRequiredFields();
            return new TrackUploadReq(this);
        }
    }
}
