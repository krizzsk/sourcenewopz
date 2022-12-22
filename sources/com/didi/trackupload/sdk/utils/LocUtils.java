package com.didi.trackupload.sdk.utils;

import com.didi.mapbizinterface.track.MapTrackExtraDataProvider;
import com.didi.mapbizinterface.track.TrackMessageParams;
import com.didi.mapbizinterface.track.TrackPointParams;
import com.didi.trackupload.sdk.Constants;
import com.didi.trackupload.sdk.ICommonInfoDelegate;
import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.datachannel.protobuf.CoordinateType;
import com.didi.trackupload.sdk.datachannel.protobuf.LocationType;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdu.didi.protobuf.MapTrackExtraMessageData;
import com.sdu.didi.protobuf.MapTrackExtraPointData;

public class LocUtils {
    public static boolean isLocEffective(long j) {
        return System.currentTimeMillis() - j < 30000;
    }

    public static boolean similarTrackLocationInfo(TrackLocationInfo trackLocationInfo, TrackLocationInfo trackLocationInfo2) {
        if (trackLocationInfo == trackLocationInfo2) {
            return true;
        }
        if (!m31335a(trackLocationInfo.lat, trackLocationInfo2.lat) || !m31335a(trackLocationInfo.lng, trackLocationInfo2.lng) || !m31335a(trackLocationInfo.timestamp_loc, trackLocationInfo2.timestamp_loc)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m31335a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static TrackLocationInfo buildLocationInfo(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            return new TrackLocationInfo.Builder().lng(Double.valueOf(dIDILocation.getLongitude())).lat(Double.valueOf(dIDILocation.getLatitude())).coordType(m31337c(dIDILocation)).locType(m31338d(dIDILocation)).accuracy(Double.valueOf((double) dIDILocation.getAccuracy())).direction(Double.valueOf((double) dIDILocation.getBearing())).speed(Double.valueOf((double) dIDILocation.getSpeed())).altitude(Float.valueOf((float) dIDILocation.getAltitude())).timestamp_loc(Integer.valueOf((int) (dIDILocation.getTime() / 1000))).timestamp64_loc(Long.valueOf(dIDILocation.getTime())).timestamp_mobile(Integer.valueOf((int) (dIDILocation.getLocalTime() / 1000))).map_extra_message_data(m31334a(dIDILocation)).map_extra_point_data(m31336b(dIDILocation)).build();
        }
        return null;
    }

    /* renamed from: a */
    private static MapTrackExtraMessageData m31334a(DIDILocation dIDILocation) {
        ICommonInfoDelegate commonInfoDelegate = TrackController.getIntance().getInitParams().getCommonInfoDelegate();
        return MapTrackExtraDataProvider.getInstance().getExtraTrackMessageData(new TrackMessageParams.Builder().phone(commonInfoDelegate != null ? commonInfoDelegate.getPhone() : null).orderId((String) null).location(dIDILocation).trackSdkFlag(1).build());
    }

    /* renamed from: b */
    private static MapTrackExtraPointData m31336b(DIDILocation dIDILocation) {
        return MapTrackExtraDataProvider.getInstance().getExtraTrackPointData(new TrackPointParams.Builder().location(dIDILocation).build());
    }

    /* renamed from: c */
    private static CoordinateType m31337c(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            int coordinateType = dIDILocation.getCoordinateType();
            if (coordinateType == 0) {
                return CoordinateType.WGS_84;
            }
            if (coordinateType == 1) {
                return CoordinateType.GCJ_02;
            }
        }
        return CoordinateType.WGS_84;
    }

    /* renamed from: d */
    private static LocationType m31338d(DIDILocation dIDILocation) {
        String provider = dIDILocation != null ? dIDILocation.getProvider() : null;
        if (provider != null) {
            char c = 65535;
            switch (provider.hashCode()) {
                case -509470367:
                    if (provider.equals(DIDILocation.NLP_PROVIDER)) {
                        c = 2;
                        break;
                    }
                    break;
                case -392428361:
                    if (provider.equals(DIDILocation.CELL_PROVIDER)) {
                        c = 3;
                        break;
                    }
                    break;
                case -391828886:
                    if (provider.equals(DIDILocation.WIFI_PROVIDER)) {
                        c = 1;
                        break;
                    }
                    break;
                case 102570:
                    if (provider.equals("gps")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                return LocationType.LOC_GPS;
            }
            if (c == 1 || c == 2) {
                return LocationType.LOC_NET;
            }
            if (c == 3) {
                return LocationType.LOC_OTHER;
            }
        }
        return LocationType.LOC_OTHER;
    }

    public static TrackLocationInfo addTrackFlag(TrackLocationInfo trackLocationInfo, long j) {
        return new TrackLocationInfo.Builder(trackLocationInfo).map_extra_message_data(new MapTrackExtraMessageData.Builder(trackLocationInfo.map_extra_message_data).track_sdk_flag(Integer.valueOf((int) j)).build()).build();
    }

    public static boolean isSubtitudeLocEffective(long j) {
        return System.currentTimeMillis() - j < Constants.SUBTITUDE_LOC_EFFECTIVE_TIME;
    }
}
