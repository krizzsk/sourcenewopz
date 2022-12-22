package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class LinkInfo extends Message {
    public static final List<Integer> DEFAULT_DIRECTIONS = Collections.emptyList();
    public static final List<Integer> DEFAULT_FUNCLASS = Collections.emptyList();
    public static final List<String> DEFAULT_KIND = Collections.emptyList();
    public static final Long DEFAULT_LINKID = 0L;
    public static final List<Long> DEFAULT_ROADLINKLIST = Collections.emptyList();
    public static final String DEFAULT_ROADNAME = "";
    public static final List<Integer> DEFAULT_SPDCLASS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.UINT32)
    public final List<Integer> directions;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> funClass;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.STRING)
    public final List<String> kind;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT64)
    public final Long linkId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DiffGeoPoints points;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.INT64)
    public final List<Long> roadLinkList;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String roadName;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> spdClass;

    public LinkInfo(DiffGeoPoints diffGeoPoints, List<Integer> list, String str, Long l, List<Integer> list2, List<Integer> list3, List<String> list4, List<Long> list5) {
        this.points = diffGeoPoints;
        this.directions = immutableCopyOf(list);
        this.roadName = str;
        this.linkId = l;
        this.funClass = immutableCopyOf(list2);
        this.spdClass = immutableCopyOf(list3);
        this.kind = immutableCopyOf(list4);
        this.roadLinkList = immutableCopyOf(list5);
    }

    private LinkInfo(Builder builder) {
        this(builder.points, builder.directions, builder.roadName, builder.linkId, builder.funClass, builder.spdClass, builder.kind, builder.roadLinkList);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinkInfo)) {
            return false;
        }
        LinkInfo linkInfo = (LinkInfo) obj;
        if (!equals((Object) this.points, (Object) linkInfo.points) || !equals((List<?>) this.directions, (List<?>) linkInfo.directions) || !equals((Object) this.roadName, (Object) linkInfo.roadName) || !equals((Object) this.linkId, (Object) linkInfo.linkId) || !equals((List<?>) this.funClass, (List<?>) linkInfo.funClass) || !equals((List<?>) this.spdClass, (List<?>) linkInfo.spdClass) || !equals((List<?>) this.kind, (List<?>) linkInfo.kind) || !equals((List<?>) this.roadLinkList, (List<?>) linkInfo.roadLinkList)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DiffGeoPoints diffGeoPoints = this.points;
        int i2 = 0;
        int hashCode = (diffGeoPoints != null ? diffGeoPoints.hashCode() : 0) * 37;
        List<Integer> list = this.directions;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.roadName;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.linkId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i4 = (hashCode3 + i2) * 37;
        List<Integer> list2 = this.funClass;
        int hashCode4 = (i4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.spdClass;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<String> list4 = this.kind;
        int hashCode6 = (hashCode5 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<Long> list5 = this.roadLinkList;
        if (list5 != null) {
            i3 = list5.hashCode();
        }
        int i5 = hashCode6 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<LinkInfo> {
        public List<Integer> directions;
        public List<Integer> funClass;
        public List<String> kind;
        public Long linkId;
        public DiffGeoPoints points;
        public List<Long> roadLinkList;
        public String roadName;
        public List<Integer> spdClass;

        public Builder() {
        }

        public Builder(LinkInfo linkInfo) {
            super(linkInfo);
            if (linkInfo != null) {
                this.points = linkInfo.points;
                this.directions = LinkInfo.copyOf(linkInfo.directions);
                this.roadName = linkInfo.roadName;
                this.linkId = linkInfo.linkId;
                this.funClass = LinkInfo.copyOf(linkInfo.funClass);
                this.spdClass = LinkInfo.copyOf(linkInfo.spdClass);
                this.kind = LinkInfo.copyOf(linkInfo.kind);
                this.roadLinkList = LinkInfo.copyOf(linkInfo.roadLinkList);
            }
        }

        public Builder points(DiffGeoPoints diffGeoPoints) {
            this.points = diffGeoPoints;
            return this;
        }

        public Builder directions(List<Integer> list) {
            this.directions = checkForNulls(list);
            return this;
        }

        public Builder roadName(String str) {
            this.roadName = str;
            return this;
        }

        public Builder linkId(Long l) {
            this.linkId = l;
            return this;
        }

        public Builder funClass(List<Integer> list) {
            this.funClass = checkForNulls(list);
            return this;
        }

        public Builder spdClass(List<Integer> list) {
            this.spdClass = checkForNulls(list);
            return this;
        }

        public Builder kind(List<String> list) {
            this.kind = checkForNulls(list);
            return this;
        }

        public Builder roadLinkList(List<Long> list) {
            this.roadLinkList = checkForNulls(list);
            return this;
        }

        public LinkInfo build() {
            checkRequiredFields();
            return new LinkInfo(this);
        }
    }
}
