package com.sdu.didi.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MapTrackExtraPointData extends Message {
    public static final AppState DEFAULT_APP_STATE = AppState.FOREGROUND_ACTIVE;
    public static final String DEFAULT_FLP_SIMPLIFIED_STRATEGY = "";
    public static final String DEFAULT_ORIGINAL_LOC_SOURCE = "";
    public static final Integer DEFAULT_SATELLITE_NUM = 0;
    @ProtoField(tag = 3, type = Message.Datatype.ENUM)
    public final AppState app_state;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String flp_simplified_strategy;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String original_loc_source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer satellite_num;

    public MapTrackExtraPointData(Integer num, String str, AppState appState, String str2) {
        this.satellite_num = num;
        this.original_loc_source = str;
        this.app_state = appState;
        this.flp_simplified_strategy = str2;
    }

    private MapTrackExtraPointData(Builder builder) {
        this(builder.satellite_num, builder.original_loc_source, builder.app_state, builder.flp_simplified_strategy);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapTrackExtraPointData)) {
            return false;
        }
        MapTrackExtraPointData mapTrackExtraPointData = (MapTrackExtraPointData) obj;
        if (!equals((Object) this.satellite_num, (Object) mapTrackExtraPointData.satellite_num) || !equals((Object) this.original_loc_source, (Object) mapTrackExtraPointData.original_loc_source) || !equals((Object) this.app_state, (Object) mapTrackExtraPointData.app_state) || !equals((Object) this.flp_simplified_strategy, (Object) mapTrackExtraPointData.flp_simplified_strategy)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.satellite_num;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.original_loc_source;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        AppState appState = this.app_state;
        int hashCode3 = (hashCode2 + (appState != null ? appState.hashCode() : 0)) * 37;
        String str2 = this.flp_simplified_strategy;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MapTrackExtraPointData> {
        public AppState app_state;
        public String flp_simplified_strategy;
        public String original_loc_source;
        public Integer satellite_num;

        public Builder() {
        }

        public Builder(MapTrackExtraPointData mapTrackExtraPointData) {
            super(mapTrackExtraPointData);
            if (mapTrackExtraPointData != null) {
                this.satellite_num = mapTrackExtraPointData.satellite_num;
                this.original_loc_source = mapTrackExtraPointData.original_loc_source;
                this.app_state = mapTrackExtraPointData.app_state;
                this.flp_simplified_strategy = mapTrackExtraPointData.flp_simplified_strategy;
            }
        }

        public Builder satellite_num(Integer num) {
            this.satellite_num = num;
            return this;
        }

        public Builder original_loc_source(String str) {
            this.original_loc_source = str;
            return this;
        }

        public Builder app_state(AppState appState) {
            this.app_state = appState;
            return this;
        }

        public Builder flp_simplified_strategy(String str) {
            this.flp_simplified_strategy = str;
            return this;
        }

        public MapTrackExtraPointData build() {
            return new MapTrackExtraPointData(this);
        }
    }
}
