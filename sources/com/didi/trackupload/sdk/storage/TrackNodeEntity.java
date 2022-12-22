package com.didi.trackupload.sdk.storage;

import com.didi.trackupload.sdk.datachannel.protobuf.CoordinateType;
import com.didi.trackupload.sdk.datachannel.protobuf.LocationType;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackNode;
import com.didi.trackupload.sdk.utils.OmegaUtils;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.greendao.converter.PropertyConverter;

public class TrackNodeEntity {
    private static final Wire WIRE = new Wire((Class<?>[]) new Class[0]);
    private Float accelerated_speed_x;
    private Float accelerated_speed_y;
    private Float accelerated_speed_z;
    private Double accuracy;
    private Float altitude;
    private Double direction;

    /* renamed from: id */
    private Long f44003id;
    private Float included_angle_pitch;
    private Float included_angle_roll;
    private Float included_angle_yaw;
    private Double lat;
    private Double lng;
    private byte[] map_extra_point_data;
    private Double speed;
    private LocationType src;
    private List<String> tags;
    private Integer time;
    private Long time64;
    private Integer time_local;
    private CoordinateType type;

    public TrackNodeEntity(Long l, Double d, Double d2, CoordinateType coordinateType, LocationType locationType, Double d3, Double d4, Double d5, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Integer num, Long l2, Integer num2, List<String> list, byte[] bArr) {
        this.f44003id = l;
        this.lat = d;
        this.lng = d2;
        this.type = coordinateType;
        this.src = locationType;
        this.accuracy = d3;
        this.direction = d4;
        this.speed = d5;
        this.altitude = f;
        this.accelerated_speed_x = f2;
        this.accelerated_speed_y = f3;
        this.accelerated_speed_z = f4;
        this.included_angle_yaw = f5;
        this.included_angle_roll = f6;
        this.included_angle_pitch = f7;
        this.time = num;
        this.time64 = l2;
        this.time_local = num2;
        this.tags = list;
        this.map_extra_point_data = bArr;
    }

    public TrackNodeEntity() {
    }

    public Long getId() {
        return this.f44003id;
    }

    public void setId(Long l) {
        this.f44003id = l;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double d) {
        this.lat = d;
    }

    public Double getLng() {
        return this.lng;
    }

    public void setLng(Double d) {
        this.lng = d;
    }

    public CoordinateType getType() {
        return this.type;
    }

    public void setType(CoordinateType coordinateType) {
        this.type = coordinateType;
    }

    public LocationType getSrc() {
        return this.src;
    }

    public void setSrc(LocationType locationType) {
        this.src = locationType;
    }

    public Double getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(Double d) {
        this.accuracy = d;
    }

    public Double getDirection() {
        return this.direction;
    }

    public void setDirection(Double d) {
        this.direction = d;
    }

    public Double getSpeed() {
        return this.speed;
    }

    public void setSpeed(Double d) {
        this.speed = d;
    }

    public Float getAltitude() {
        return this.altitude;
    }

    public void setAltitude(Float f) {
        this.altitude = f;
    }

    public Float getAccelerated_speed_x() {
        return this.accelerated_speed_x;
    }

    public void setAccelerated_speed_x(Float f) {
        this.accelerated_speed_x = f;
    }

    public Float getAccelerated_speed_y() {
        return this.accelerated_speed_y;
    }

    public void setAccelerated_speed_y(Float f) {
        this.accelerated_speed_y = f;
    }

    public Float getAccelerated_speed_z() {
        return this.accelerated_speed_z;
    }

    public void setAccelerated_speed_z(Float f) {
        this.accelerated_speed_z = f;
    }

    public Float getIncluded_angle_yaw() {
        return this.included_angle_yaw;
    }

    public void setIncluded_angle_yaw(Float f) {
        this.included_angle_yaw = f;
    }

    public Float getIncluded_angle_roll() {
        return this.included_angle_roll;
    }

    public void setIncluded_angle_roll(Float f) {
        this.included_angle_roll = f;
    }

    public Float getIncluded_angle_pitch() {
        return this.included_angle_pitch;
    }

    public void setIncluded_angle_pitch(Float f) {
        this.included_angle_pitch = f;
    }

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer num) {
        this.time = num;
    }

    public Long getTime64() {
        return this.time64;
    }

    public void setTime64(Long l) {
        this.time64 = l;
    }

    public Integer getTime_local() {
        return this.time_local;
    }

    public void setTime_local(Integer num) {
        this.time_local = num;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public byte[] getMap_extra_point_data() {
        return this.map_extra_point_data;
    }

    public void setMap_extra_point_data(byte[] bArr) {
        this.map_extra_point_data = bArr;
    }

    public void assignLocInfo(TrackLocationInfo trackLocationInfo) {
        this.lng = trackLocationInfo.lng;
        this.lat = trackLocationInfo.lat;
        this.type = trackLocationInfo.coordType;
        this.src = trackLocationInfo.locType;
        this.accuracy = trackLocationInfo.accuracy;
        this.direction = trackLocationInfo.direction;
        this.speed = trackLocationInfo.speed;
        this.altitude = trackLocationInfo.altitude;
        this.accelerated_speed_x = trackLocationInfo.acceleratedSpeedX;
        this.accelerated_speed_y = trackLocationInfo.acceleratedSpeedY;
        this.accelerated_speed_z = trackLocationInfo.acceleratedSpeedZ;
        this.included_angle_yaw = trackLocationInfo.includedAngleYaw;
        this.included_angle_roll = trackLocationInfo.includedAngleRoll;
        this.included_angle_pitch = trackLocationInfo.includedAnglePitch;
        this.time = trackLocationInfo.timestamp_loc;
        this.time64 = trackLocationInfo.timestamp64_loc;
        this.time_local = trackLocationInfo.timestamp_mobile;
        this.map_extra_point_data = trackLocationInfo.map_extra_point_data != null ? trackLocationInfo.map_extra_point_data.toByteArray() : null;
    }

    public static class StringListConverter implements PropertyConverter<List<String>, String> {
        public List<String> convertToEntityProperty(String str) {
            if (str != null) {
                return Arrays.asList(str.split(","));
            }
            return null;
        }

        public String convertToDatabaseValue(List<String> list) {
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String append : list) {
                sb.append(append);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    public static TrackNodeEntity fromPBMessage(TrackNode trackNode) {
        TrackNodeEntity trackNodeEntity = new TrackNodeEntity();
        trackNodeEntity.assignLocInfo(trackNode.loc);
        trackNodeEntity.setTags(trackNode.tags);
        return trackNodeEntity;
    }

    public static TrackNode toPBMessage(TrackNodeEntity trackNodeEntity) {
        TrackLocationInfo locationInfo = trackNodeEntity.getLocationInfo();
        if (locationInfo != null) {
            return new TrackNode.Builder().loc(locationInfo).tags(trackNodeEntity.getTags()).build();
        }
        return null;
    }

    public static List<TrackNode> toPBMessages(List<TrackNodeEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (TrackNodeEntity pBMessage : list) {
            TrackNode pBMessage2 = toPBMessage(pBMessage);
            if (pBMessage2 != null) {
                arrayList.add(pBMessage2);
            }
        }
        return arrayList;
    }

    public static class CoordinateTypeConverter implements PropertyConverter<CoordinateType, Integer> {
        public CoordinateType convertToEntityProperty(Integer num) {
            int intValue = num.intValue();
            if (intValue == 1) {
                return CoordinateType.BD_09;
            }
            if (intValue == 2) {
                return CoordinateType.GCJ_02;
            }
            if (intValue != 4) {
                return CoordinateType.UNKNOWN;
            }
            return CoordinateType.WGS_84;
        }

        public Integer convertToDatabaseValue(CoordinateType coordinateType) {
            if (coordinateType == null) {
                return -1;
            }
            return Integer.valueOf(coordinateType.getValue());
        }
    }

    public static class LocationTypeConverter implements PropertyConverter<LocationType, Integer> {
        public LocationType convertToEntityProperty(Integer num) {
            int intValue = num.intValue();
            if (intValue == 1) {
                return LocationType.LOC_GPS;
            }
            if (intValue == 2) {
                return LocationType.LOC_NET;
            }
            if (intValue != 3) {
                return LocationType.LOC_OTHER;
            }
            return LocationType.LOC_OTHER;
        }

        public Integer convertToDatabaseValue(LocationType locationType) {
            if (locationType == null) {
                return -1;
            }
            return Integer.valueOf(locationType.getValue());
        }
    }

    public TrackLocationInfo getLocationInfo() {
        try {
            return new TrackLocationInfo.Builder().lng(this.lng).lat(this.lat).coordType(this.type).locType(this.src).accuracy(this.accuracy).direction(this.direction).speed(this.speed).altitude(this.altitude).acceleratedSpeedX(this.accelerated_speed_x).acceleratedSpeedY(this.accelerated_speed_y).acceleratedSpeedZ(this.accelerated_speed_z).includedAnglePitch(this.included_angle_pitch).includedAngleRoll(this.included_angle_roll).includedAngleYaw(this.included_angle_yaw).timestamp_loc(this.time).timestamp64_loc(this.time64).timestamp_mobile(this.time_local).map_extra_point_data(buildMapTrackExtraPointData(this.map_extra_point_data)).build();
        } catch (Exception e) {
            OmegaUtils.trackWireError(203, e);
            return null;
        }
    }

    private MapTrackExtraPointData buildMapTrackExtraPointData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (MapTrackExtraPointData) WIRE.parseFrom(bArr, MapTrackExtraPointData.class);
        } catch (Exception unused) {
            return null;
        }
    }
}
