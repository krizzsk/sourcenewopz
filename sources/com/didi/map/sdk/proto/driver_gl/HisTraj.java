package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class HisTraj extends Message {
    public static final List<String> DEFAULT_FLPEXT = Collections.emptyList();
    public static final List<Float> DEFAULT_HISACCURACY = Collections.emptyList();
    public static final List<Integer> DEFAULT_HISDIRECTION = Collections.emptyList();
    public static final List<LocationSource> DEFAULT_HISLOCATIONSOURCE = Collections.emptyList();
    public static final List<Integer> DEFAULT_HISSPEED = Collections.emptyList();
    public static final List<Long> DEFAULT_HISTIMESTAMP = Collections.emptyList();
    public static final List<Integer> DEFAULT_SATELLITESNUM = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.STRING)
    public final List<String> flpExt;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.FLOAT)
    public final List<Float> hisAccuracy;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> hisDirection;
    @ProtoField(enumType = LocationSource.class, label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.ENUM)
    public final List<LocationSource> hisLocationSource;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> hisSpeed;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.UINT64)
    public final List<Long> hisTimestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DiffGeoPoints historyTraj;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.INT32)
    public final List<Integer> satellitesNum;

    public HisTraj(DiffGeoPoints diffGeoPoints, List<Long> list, List<Integer> list2, List<Integer> list3, List<Float> list4, List<LocationSource> list5, List<Integer> list6, List<String> list7) {
        this.historyTraj = diffGeoPoints;
        this.hisTimestamp = immutableCopyOf(list);
        this.hisDirection = immutableCopyOf(list2);
        this.hisSpeed = immutableCopyOf(list3);
        this.hisAccuracy = immutableCopyOf(list4);
        this.hisLocationSource = immutableCopyOf(list5);
        this.satellitesNum = immutableCopyOf(list6);
        this.flpExt = immutableCopyOf(list7);
    }

    private HisTraj(Builder builder) {
        this(builder.historyTraj, builder.hisTimestamp, builder.hisDirection, builder.hisSpeed, builder.hisAccuracy, builder.hisLocationSource, builder.satellitesNum, builder.flpExt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HisTraj)) {
            return false;
        }
        HisTraj hisTraj = (HisTraj) obj;
        if (!equals((Object) this.historyTraj, (Object) hisTraj.historyTraj) || !equals((List<?>) this.hisTimestamp, (List<?>) hisTraj.hisTimestamp) || !equals((List<?>) this.hisDirection, (List<?>) hisTraj.hisDirection) || !equals((List<?>) this.hisSpeed, (List<?>) hisTraj.hisSpeed) || !equals((List<?>) this.hisAccuracy, (List<?>) hisTraj.hisAccuracy) || !equals((List<?>) this.hisLocationSource, (List<?>) hisTraj.hisLocationSource) || !equals((List<?>) this.satellitesNum, (List<?>) hisTraj.satellitesNum) || !equals((List<?>) this.flpExt, (List<?>) hisTraj.flpExt)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DiffGeoPoints diffGeoPoints = this.historyTraj;
        int hashCode = (diffGeoPoints != null ? diffGeoPoints.hashCode() : 0) * 37;
        List<Long> list = this.hisTimestamp;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.hisDirection;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.hisSpeed;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Float> list4 = this.hisAccuracy;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<LocationSource> list5 = this.hisLocationSource;
        int hashCode6 = (hashCode5 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<Integer> list6 = this.satellitesNum;
        int hashCode7 = (hashCode6 + (list6 != null ? list6.hashCode() : 1)) * 37;
        List<String> list7 = this.flpExt;
        if (list7 != null) {
            i2 = list7.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HisTraj> {
        public List<String> flpExt;
        public List<Float> hisAccuracy;
        public List<Integer> hisDirection;
        public List<LocationSource> hisLocationSource;
        public List<Integer> hisSpeed;
        public List<Long> hisTimestamp;
        public DiffGeoPoints historyTraj;
        public List<Integer> satellitesNum;

        public Builder() {
        }

        public Builder(HisTraj hisTraj) {
            super(hisTraj);
            if (hisTraj != null) {
                this.historyTraj = hisTraj.historyTraj;
                this.hisTimestamp = HisTraj.copyOf(hisTraj.hisTimestamp);
                this.hisDirection = HisTraj.copyOf(hisTraj.hisDirection);
                this.hisSpeed = HisTraj.copyOf(hisTraj.hisSpeed);
                this.hisAccuracy = HisTraj.copyOf(hisTraj.hisAccuracy);
                this.hisLocationSource = HisTraj.copyOf(hisTraj.hisLocationSource);
                this.satellitesNum = HisTraj.copyOf(hisTraj.satellitesNum);
                this.flpExt = HisTraj.copyOf(hisTraj.flpExt);
            }
        }

        public Builder historyTraj(DiffGeoPoints diffGeoPoints) {
            this.historyTraj = diffGeoPoints;
            return this;
        }

        public Builder hisTimestamp(List<Long> list) {
            this.hisTimestamp = checkForNulls(list);
            return this;
        }

        public Builder hisDirection(List<Integer> list) {
            this.hisDirection = checkForNulls(list);
            return this;
        }

        public Builder hisSpeed(List<Integer> list) {
            this.hisSpeed = checkForNulls(list);
            return this;
        }

        public Builder hisAccuracy(List<Float> list) {
            this.hisAccuracy = checkForNulls(list);
            return this;
        }

        public Builder hisLocationSource(List<LocationSource> list) {
            this.hisLocationSource = checkForNulls(list);
            return this;
        }

        public Builder satellitesNum(List<Integer> list) {
            this.satellitesNum = checkForNulls(list);
            return this;
        }

        public Builder flpExt(List<String> list) {
            this.flpExt = checkForNulls(list);
            return this;
        }

        public HisTraj build() {
            checkRequiredFields();
            return new HisTraj(this);
        }
    }
}
