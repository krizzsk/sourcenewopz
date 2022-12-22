package com.didi.trackupload.sdk.utils;

import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LogStringUtils {
    public static String parseTags(String str) {
        return Const.joLeft + str + "}";
    }

    public static String parseTags(List<String> list) {
        if (list == null) {
            return "{null}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        for (String append : list) {
            sb.append(append);
            sb.append(";");
        }
        sb.append("}");
        return sb.toString();
    }

    public static String parseTags(Map<String, ?> map) {
        if (map == null) {
            return "{null}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Const.joLeft);
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null) {
                sb.append((String) next.getKey());
                sb.append(";");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String parseLocationInfo(TrackLocationInfo trackLocationInfo) {
        if (trackLocationInfo == null) {
            return "null";
        }
        return String.format(Locale.CHINA, "{%.6f,%.6f,%s,%d}", new Object[]{trackLocationInfo.lng, trackLocationInfo.lat, trackLocationInfo.locType, trackLocationInfo.timestamp64_loc});
    }

    public static String parseDIDILocation(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return "null";
        }
        return String.format(Locale.CHINA, "{%.6f,%.6f,%s,%d}", new Object[]{Double.valueOf(dIDILocation.getLongitude()), Double.valueOf(dIDILocation.getLatitude()), dIDILocation.getProvider(), Long.valueOf(dIDILocation.getTime())});
    }
}
