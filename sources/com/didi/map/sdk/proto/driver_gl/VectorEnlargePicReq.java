package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class VectorEnlargePicReq extends Message {
    public static final List<Long> DEFAULT_CONFUSING_INTERINLINKS = Collections.emptyList();
    public static final Integer DEFAULT_HEIGHT = 0;
    public static final List<Long> DEFAULT_INLINKS = Collections.emptyList();
    public static final List<Long> DEFAULT_INTERINLINKS = Collections.emptyList();
    public static final String DEFAULT_MAPVERSION = "";
    public static final List<Long> DEFAULT_OUTLINKS = Collections.emptyList();
    public static final List<Long> DEFAULT_PASSLINKS = Collections.emptyList();
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_VERSION = 0;
    public static final Integer DEFAULT_WIDTH = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 10, type = Message.Datatype.INT64)
    public final List<Long> confusing_interInLinks;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> inLinks;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT64)
    public final List<Long> interInLinks;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String mapVersion;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> outLinks;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> passLinks;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer version;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer width;

    public VectorEnlargePicReq(List<Long> list, List<Long> list2, List<Long> list3, Integer num, String str, String str2, Integer num2, Integer num3, List<Long> list4, List<Long> list5) {
        this.inLinks = immutableCopyOf(list);
        this.passLinks = immutableCopyOf(list2);
        this.outLinks = immutableCopyOf(list3);
        this.version = num;
        this.mapVersion = str;
        this.phone = str2;
        this.height = num2;
        this.width = num3;
        this.interInLinks = immutableCopyOf(list4);
        this.confusing_interInLinks = immutableCopyOf(list5);
    }

    private VectorEnlargePicReq(Builder builder) {
        this(builder.inLinks, builder.passLinks, builder.outLinks, builder.version, builder.mapVersion, builder.phone, builder.height, builder.width, builder.interInLinks, builder.confusing_interInLinks);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VectorEnlargePicReq)) {
            return false;
        }
        VectorEnlargePicReq vectorEnlargePicReq = (VectorEnlargePicReq) obj;
        if (!equals((List<?>) this.inLinks, (List<?>) vectorEnlargePicReq.inLinks) || !equals((List<?>) this.passLinks, (List<?>) vectorEnlargePicReq.passLinks) || !equals((List<?>) this.outLinks, (List<?>) vectorEnlargePicReq.outLinks) || !equals((Object) this.version, (Object) vectorEnlargePicReq.version) || !equals((Object) this.mapVersion, (Object) vectorEnlargePicReq.mapVersion) || !equals((Object) this.phone, (Object) vectorEnlargePicReq.phone) || !equals((Object) this.height, (Object) vectorEnlargePicReq.height) || !equals((Object) this.width, (Object) vectorEnlargePicReq.width) || !equals((List<?>) this.interInLinks, (List<?>) vectorEnlargePicReq.interInLinks) || !equals((List<?>) this.confusing_interInLinks, (List<?>) vectorEnlargePicReq.confusing_interInLinks)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.inLinks;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Long> list2 = this.passLinks;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Long> list3 = this.outLinks;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 1)) * 37;
        Integer num = this.version;
        int i3 = 0;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.mapVersion;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.phone;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.height;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.width;
        if (num3 != null) {
            i3 = num3.hashCode();
        }
        int i4 = (hashCode7 + i3) * 37;
        List<Long> list4 = this.interInLinks;
        int hashCode8 = (i4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<Long> list5 = this.confusing_interInLinks;
        if (list5 != null) {
            i2 = list5.hashCode();
        }
        int i5 = hashCode8 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<VectorEnlargePicReq> {
        public List<Long> confusing_interInLinks;
        public Integer height;
        public List<Long> inLinks;
        public List<Long> interInLinks;
        public String mapVersion;
        public List<Long> outLinks;
        public List<Long> passLinks;
        public String phone;
        public Integer version;
        public Integer width;

        public Builder() {
        }

        public Builder(VectorEnlargePicReq vectorEnlargePicReq) {
            super(vectorEnlargePicReq);
            if (vectorEnlargePicReq != null) {
                this.inLinks = VectorEnlargePicReq.copyOf(vectorEnlargePicReq.inLinks);
                this.passLinks = VectorEnlargePicReq.copyOf(vectorEnlargePicReq.passLinks);
                this.outLinks = VectorEnlargePicReq.copyOf(vectorEnlargePicReq.outLinks);
                this.version = vectorEnlargePicReq.version;
                this.mapVersion = vectorEnlargePicReq.mapVersion;
                this.phone = vectorEnlargePicReq.phone;
                this.height = vectorEnlargePicReq.height;
                this.width = vectorEnlargePicReq.width;
                this.interInLinks = VectorEnlargePicReq.copyOf(vectorEnlargePicReq.interInLinks);
                this.confusing_interInLinks = VectorEnlargePicReq.copyOf(vectorEnlargePicReq.confusing_interInLinks);
            }
        }

        public Builder inLinks(List<Long> list) {
            this.inLinks = checkForNulls(list);
            return this;
        }

        public Builder passLinks(List<Long> list) {
            this.passLinks = checkForNulls(list);
            return this;
        }

        public Builder outLinks(List<Long> list) {
            this.outLinks = checkForNulls(list);
            return this;
        }

        public Builder version(Integer num) {
            this.version = num;
            return this;
        }

        public Builder mapVersion(String str) {
            this.mapVersion = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder height(Integer num) {
            this.height = num;
            return this;
        }

        public Builder width(Integer num) {
            this.width = num;
            return this;
        }

        public Builder interInLinks(List<Long> list) {
            this.interInLinks = checkForNulls(list);
            return this;
        }

        public Builder confusing_interInLinks(List<Long> list) {
            this.confusing_interInLinks = checkForNulls(list);
            return this;
        }

        public VectorEnlargePicReq build() {
            return new VectorEnlargePicReq(this);
        }
    }
}
