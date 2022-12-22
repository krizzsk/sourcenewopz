package com.didi.mapbizinterface.track;

import com.sdu.didi.protobuf.MapTrackExtraMessageData;
import com.sdu.didi.protobuf.MapTrackExtraPointData;

public class MapTrackExtraDataConverter {
    public static MapTrackExtraMessageData convert2MessageData(MapTrackExtraPointData mapTrackExtraPointData) {
        if (mapTrackExtraPointData != null) {
            return new MapTrackExtraMessageData.Builder().satellite_num(mapTrackExtraPointData.satellite_num).original_loc_source(mapTrackExtraPointData.original_loc_source).build();
        }
        return null;
    }

    public static MapTrackExtraPointData convert2PointData(MapTrackExtraMessageData mapTrackExtraMessageData) {
        if (mapTrackExtraMessageData != null) {
            return new MapTrackExtraPointData.Builder().satellite_num(mapTrackExtraMessageData.satellite_num).original_loc_source(mapTrackExtraMessageData.original_loc_source).build();
        }
        return null;
    }
}
