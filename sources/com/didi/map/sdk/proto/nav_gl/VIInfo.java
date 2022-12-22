package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class VIInfo extends Message {
    public static final Integer DEFAULT_DESTINDEX = 0;
    public static final VoiceDistanceKindEnum DEFAULT_DISTANCEKIND = VoiceDistanceKindEnum.VoiceDistanceKind_Null;
    public static final Integer DEFAULT_PASSTIME = 0;
    public static final List<VISentence> DEFAULT_SENTENCE = Collections.emptyList();
    public static final VoiceTargetKindEnum DEFAULT_TARGETKIND = VoiceTargetKindEnum.VoiceTargetKind_Intersection;
    public static final TrafficLineStatusEnum DEFAULT_TRAFFICSTATUS = TrafficLineStatusEnum.TLS_Unknow;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer destIndex;
    @ProtoField(tag = 6, type = Message.Datatype.ENUM)
    public final VoiceDistanceKindEnum distanceKind;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer passTime;
    @ProtoField(label = Message.Label.REPEATED, messageType = VISentence.class, tag = 4)
    public final List<VISentence> sentence;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint targetBeginPos;
    @ProtoField(tag = 3)
    public final MapRoutePoint targetEndPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final VoiceTargetKindEnum targetKind;
    @ProtoField(tag = 7, type = Message.Datatype.ENUM)
    public final TrafficLineStatusEnum trafficStatus;

    public VIInfo(VoiceTargetKindEnum voiceTargetKindEnum, MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2, List<VISentence> list, Integer num, VoiceDistanceKindEnum voiceDistanceKindEnum, TrafficLineStatusEnum trafficLineStatusEnum, Integer num2) {
        this.targetKind = voiceTargetKindEnum;
        this.targetBeginPos = mapRoutePoint;
        this.targetEndPos = mapRoutePoint2;
        this.sentence = immutableCopyOf(list);
        this.passTime = num;
        this.distanceKind = voiceDistanceKindEnum;
        this.trafficStatus = trafficLineStatusEnum;
        this.destIndex = num2;
    }

    private VIInfo(Builder builder) {
        this(builder.targetKind, builder.targetBeginPos, builder.targetEndPos, builder.sentence, builder.passTime, builder.distanceKind, builder.trafficStatus, builder.destIndex);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VIInfo)) {
            return false;
        }
        VIInfo vIInfo = (VIInfo) obj;
        if (!equals((Object) this.targetKind, (Object) vIInfo.targetKind) || !equals((Object) this.targetBeginPos, (Object) vIInfo.targetBeginPos) || !equals((Object) this.targetEndPos, (Object) vIInfo.targetEndPos) || !equals((List<?>) this.sentence, (List<?>) vIInfo.sentence) || !equals((Object) this.passTime, (Object) vIInfo.passTime) || !equals((Object) this.distanceKind, (Object) vIInfo.distanceKind) || !equals((Object) this.trafficStatus, (Object) vIInfo.trafficStatus) || !equals((Object) this.destIndex, (Object) vIInfo.destIndex)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        VoiceTargetKindEnum voiceTargetKindEnum = this.targetKind;
        int i2 = 0;
        int hashCode = (voiceTargetKindEnum != null ? voiceTargetKindEnum.hashCode() : 0) * 37;
        MapRoutePoint mapRoutePoint = this.targetBeginPos;
        int hashCode2 = (hashCode + (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0)) * 37;
        MapRoutePoint mapRoutePoint2 = this.targetEndPos;
        int hashCode3 = (hashCode2 + (mapRoutePoint2 != null ? mapRoutePoint2.hashCode() : 0)) * 37;
        List<VISentence> list = this.sentence;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.passTime;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        VoiceDistanceKindEnum voiceDistanceKindEnum = this.distanceKind;
        int hashCode6 = (hashCode5 + (voiceDistanceKindEnum != null ? voiceDistanceKindEnum.hashCode() : 0)) * 37;
        TrafficLineStatusEnum trafficLineStatusEnum = this.trafficStatus;
        int hashCode7 = (hashCode6 + (trafficLineStatusEnum != null ? trafficLineStatusEnum.hashCode() : 0)) * 37;
        Integer num2 = this.destIndex;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VIInfo> {
        public Integer destIndex;
        public VoiceDistanceKindEnum distanceKind;
        public Integer passTime;
        public List<VISentence> sentence;
        public MapRoutePoint targetBeginPos;
        public MapRoutePoint targetEndPos;
        public VoiceTargetKindEnum targetKind;
        public TrafficLineStatusEnum trafficStatus;

        public Builder() {
        }

        public Builder(VIInfo vIInfo) {
            super(vIInfo);
            if (vIInfo != null) {
                this.targetKind = vIInfo.targetKind;
                this.targetBeginPos = vIInfo.targetBeginPos;
                this.targetEndPos = vIInfo.targetEndPos;
                this.sentence = VIInfo.copyOf(vIInfo.sentence);
                this.passTime = vIInfo.passTime;
                this.distanceKind = vIInfo.distanceKind;
                this.trafficStatus = vIInfo.trafficStatus;
                this.destIndex = vIInfo.destIndex;
            }
        }

        public Builder targetKind(VoiceTargetKindEnum voiceTargetKindEnum) {
            this.targetKind = voiceTargetKindEnum;
            return this;
        }

        public Builder targetBeginPos(MapRoutePoint mapRoutePoint) {
            this.targetBeginPos = mapRoutePoint;
            return this;
        }

        public Builder targetEndPos(MapRoutePoint mapRoutePoint) {
            this.targetEndPos = mapRoutePoint;
            return this;
        }

        public Builder sentence(List<VISentence> list) {
            this.sentence = checkForNulls(list);
            return this;
        }

        public Builder passTime(Integer num) {
            this.passTime = num;
            return this;
        }

        public Builder distanceKind(VoiceDistanceKindEnum voiceDistanceKindEnum) {
            this.distanceKind = voiceDistanceKindEnum;
            return this;
        }

        public Builder trafficStatus(TrafficLineStatusEnum trafficLineStatusEnum) {
            this.trafficStatus = trafficLineStatusEnum;
            return this;
        }

        public Builder destIndex(Integer num) {
            this.destIndex = num;
            return this;
        }

        public VIInfo build() {
            checkRequiredFields();
            return new VIInfo(this);
        }
    }
}
