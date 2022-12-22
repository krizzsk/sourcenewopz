package com.sdu.didi.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MapTrackExtraMessageData extends Message {
    public static final AppPage DEFAULT_APP_PAGE = AppPage.OTHERS;
    public static final AppState DEFAULT_APP_STATE = AppState.FOREGROUND_ACTIVE;
    public static final String DEFAULT_FLP_STRATEGY = "";
    public static final NetworkState DEFAULT_NETWORK_STATE = NetworkState.NET_WIFI;
    public static final String DEFAULT_ORIGINAL_LOC_SOURCE = "";
    public static final Integer DEFAULT_SATELLITE_NUM = 0;
    public static final Integer DEFAULT_SIGNAL_LEVEL = 0;
    public static final Integer DEFAULT_TRACK_SDK_FLAG = 0;
    public static final List<SimpleLocationInfo> DEFAULT_VDR_LOCATIONS = Collections.emptyList();
    @ProtoField(tag = 7, type = Message.Datatype.ENUM)
    public final AppPage app_page;
    @ProtoField(tag = 6, type = Message.Datatype.ENUM)
    public final AppState app_state;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String flp_strategy;
    @ProtoField(tag = 2, type = Message.Datatype.ENUM)
    public final NetworkState network_state;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String original_loc_source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer satellite_num;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer signal_level;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer track_sdk_flag;
    @ProtoField(label = Message.Label.REPEATED, messageType = SimpleLocationInfo.class, tag = 9)
    public final List<SimpleLocationInfo> vdr_locations;

    public MapTrackExtraMessageData(Integer num, NetworkState networkState, Integer num2, String str, String str2, AppState appState, AppPage appPage, Integer num3, List<SimpleLocationInfo> list) {
        this.satellite_num = num;
        this.network_state = networkState;
        this.signal_level = num2;
        this.flp_strategy = str;
        this.original_loc_source = str2;
        this.app_state = appState;
        this.app_page = appPage;
        this.track_sdk_flag = num3;
        this.vdr_locations = immutableCopyOf(list);
    }

    private MapTrackExtraMessageData(Builder builder) {
        this(builder.satellite_num, builder.network_state, builder.signal_level, builder.flp_strategy, builder.original_loc_source, builder.app_state, builder.app_page, builder.track_sdk_flag, builder.vdr_locations);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapTrackExtraMessageData)) {
            return false;
        }
        MapTrackExtraMessageData mapTrackExtraMessageData = (MapTrackExtraMessageData) obj;
        if (!equals((Object) this.satellite_num, (Object) mapTrackExtraMessageData.satellite_num) || !equals((Object) this.network_state, (Object) mapTrackExtraMessageData.network_state) || !equals((Object) this.signal_level, (Object) mapTrackExtraMessageData.signal_level) || !equals((Object) this.flp_strategy, (Object) mapTrackExtraMessageData.flp_strategy) || !equals((Object) this.original_loc_source, (Object) mapTrackExtraMessageData.original_loc_source) || !equals((Object) this.app_state, (Object) mapTrackExtraMessageData.app_state) || !equals((Object) this.app_page, (Object) mapTrackExtraMessageData.app_page) || !equals((Object) this.track_sdk_flag, (Object) mapTrackExtraMessageData.track_sdk_flag) || !equals((List<?>) this.vdr_locations, (List<?>) mapTrackExtraMessageData.vdr_locations)) {
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
        NetworkState networkState = this.network_state;
        int hashCode2 = (hashCode + (networkState != null ? networkState.hashCode() : 0)) * 37;
        Integer num2 = this.signal_level;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.flp_strategy;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.original_loc_source;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        AppState appState = this.app_state;
        int hashCode6 = (hashCode5 + (appState != null ? appState.hashCode() : 0)) * 37;
        AppPage appPage = this.app_page;
        int hashCode7 = (hashCode6 + (appPage != null ? appPage.hashCode() : 0)) * 37;
        Integer num3 = this.track_sdk_flag;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = (hashCode7 + i2) * 37;
        List<SimpleLocationInfo> list = this.vdr_locations;
        int hashCode8 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode8;
        return hashCode8;
    }

    public static final class Builder extends Message.Builder<MapTrackExtraMessageData> {
        public AppPage app_page;
        public AppState app_state;
        public String flp_strategy;
        public NetworkState network_state;
        public String original_loc_source;
        public Integer satellite_num;
        public Integer signal_level;
        public Integer track_sdk_flag;
        public List<SimpleLocationInfo> vdr_locations;

        public Builder() {
        }

        public Builder(MapTrackExtraMessageData mapTrackExtraMessageData) {
            super(mapTrackExtraMessageData);
            if (mapTrackExtraMessageData != null) {
                this.satellite_num = mapTrackExtraMessageData.satellite_num;
                this.network_state = mapTrackExtraMessageData.network_state;
                this.signal_level = mapTrackExtraMessageData.signal_level;
                this.flp_strategy = mapTrackExtraMessageData.flp_strategy;
                this.original_loc_source = mapTrackExtraMessageData.original_loc_source;
                this.app_state = mapTrackExtraMessageData.app_state;
                this.app_page = mapTrackExtraMessageData.app_page;
                this.track_sdk_flag = mapTrackExtraMessageData.track_sdk_flag;
                this.vdr_locations = MapTrackExtraMessageData.copyOf(mapTrackExtraMessageData.vdr_locations);
            }
        }

        public Builder satellite_num(Integer num) {
            this.satellite_num = num;
            return this;
        }

        public Builder network_state(NetworkState networkState) {
            this.network_state = networkState;
            return this;
        }

        public Builder signal_level(Integer num) {
            this.signal_level = num;
            return this;
        }

        public Builder flp_strategy(String str) {
            this.flp_strategy = str;
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

        public Builder app_page(AppPage appPage) {
            this.app_page = appPage;
            return this;
        }

        public Builder track_sdk_flag(Integer num) {
            this.track_sdk_flag = num;
            return this;
        }

        public Builder vdr_locations(List<SimpleLocationInfo> list) {
            this.vdr_locations = checkForNulls(list);
            return this;
        }

        public MapTrackExtraMessageData build() {
            return new MapTrackExtraMessageData(this);
        }
    }
}
