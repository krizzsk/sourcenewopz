package com.didi.safety.god.util;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.mlcp.drtc.consts.RTCConsts;

public class VideoCodecUtils {
    private VideoCodecUtils() {
    }

    public static int selectVideoCodec() {
        if (Build.VERSION.SDK_INT < 16) {
            return 3;
        }
        try {
            if (m24586a("h264") || m24586a(RTCConsts.VIDEO_CODEC_H264)) {
                return 2;
            }
            return 3;
        } catch (Exception unused) {
            return 3;
        }
    }

    /* renamed from: a */
    private static boolean m24586a(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt != null && codecInfoAt.isEncoder()) {
                String name = codecInfoAt.getName();
                if (!TextUtils.isEmpty(name) && name.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
