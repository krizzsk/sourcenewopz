package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PeerCoordinateRelation extends Message {
    public static final Integer DEFAULT_BIZ_TYPE = 0;
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final Integer DEFAULT_INACTIVE_EXPIRE_SECONDS = 0;
    public static final Integer DEFAULT_LAST_ACTIVE_TIMESTAMP = 0;
    public static final String DEFAULT_LOCAL_ID = "";
    public static final RelationType DEFAULT_TYPE = RelationType.kRelationTypeRealTime;
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer biz_type;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer create_time;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)
    public final Integer inactive_expire_seconds;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer last_active_timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String local_id;
    @ProtoField(tag = 6, type = Message.Datatype.ENUM)
    public final RelationType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long user_id;

    public PeerCoordinateRelation(String str, Long l, Integer num, Integer num2, Integer num3, RelationType relationType, Integer num4) {
        this.local_id = str;
        this.user_id = l;
        this.inactive_expire_seconds = num;
        this.last_active_timestamp = num2;
        this.create_time = num3;
        this.type = relationType;
        this.biz_type = num4;
    }

    private PeerCoordinateRelation(Builder builder) {
        this(builder.local_id, builder.user_id, builder.inactive_expire_seconds, builder.last_active_timestamp, builder.create_time, builder.type, builder.biz_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PeerCoordinateRelation)) {
            return false;
        }
        PeerCoordinateRelation peerCoordinateRelation = (PeerCoordinateRelation) obj;
        if (!equals((Object) this.local_id, (Object) peerCoordinateRelation.local_id) || !equals((Object) this.user_id, (Object) peerCoordinateRelation.user_id) || !equals((Object) this.inactive_expire_seconds, (Object) peerCoordinateRelation.inactive_expire_seconds) || !equals((Object) this.last_active_timestamp, (Object) peerCoordinateRelation.last_active_timestamp) || !equals((Object) this.create_time, (Object) peerCoordinateRelation.create_time) || !equals((Object) this.type, (Object) peerCoordinateRelation.type) || !equals((Object) this.biz_type, (Object) peerCoordinateRelation.biz_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.local_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.user_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.inactive_expire_seconds;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.last_active_timestamp;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.create_time;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        RelationType relationType = this.type;
        int hashCode6 = (hashCode5 + (relationType != null ? relationType.hashCode() : 0)) * 37;
        Integer num4 = this.biz_type;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PeerCoordinateRelation> {
        public Integer biz_type;
        public Integer create_time;
        public Integer inactive_expire_seconds;
        public Integer last_active_timestamp;
        public String local_id;
        public RelationType type;
        public Long user_id;

        public Builder() {
        }

        public Builder(PeerCoordinateRelation peerCoordinateRelation) {
            super(peerCoordinateRelation);
            if (peerCoordinateRelation != null) {
                this.local_id = peerCoordinateRelation.local_id;
                this.user_id = peerCoordinateRelation.user_id;
                this.inactive_expire_seconds = peerCoordinateRelation.inactive_expire_seconds;
                this.last_active_timestamp = peerCoordinateRelation.last_active_timestamp;
                this.create_time = peerCoordinateRelation.create_time;
                this.type = peerCoordinateRelation.type;
                this.biz_type = peerCoordinateRelation.biz_type;
            }
        }

        public Builder local_id(String str) {
            this.local_id = str;
            return this;
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder inactive_expire_seconds(Integer num) {
            this.inactive_expire_seconds = num;
            return this;
        }

        public Builder last_active_timestamp(Integer num) {
            this.last_active_timestamp = num;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder type(RelationType relationType) {
            this.type = relationType;
            return this;
        }

        public Builder biz_type(Integer num) {
            this.biz_type = num;
            return this;
        }

        public PeerCoordinateRelation build() {
            checkRequiredFields();
            return new PeerCoordinateRelation(this);
        }
    }
}
