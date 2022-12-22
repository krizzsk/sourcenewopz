package com.didi.sdk.audiorecorder.utils;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import java.io.File;

public class MediaUtil {
    public static long getMediaDuration(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists() || file.length() == 0) {
            LogUtil.log("MediaUtil MediaFile:" + str + ",文件不存在，或者长度是0");
            return 0;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata)) {
                long parseLong = Long.parseLong(extractMetadata);
                if (parseLong >= 0) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Throwable th) {
                        LogUtil.log("MediaUtil MediaMetadataRetriever retriver.release error", th);
                    }
                    return parseLong;
                }
                LogUtil.log("MediaUtil MediaMetadataRetriever 获取长度错误:" + parseLong);
                try {
                    mediaMetadataRetriever.release();
                } catch (Throwable th2) {
                    LogUtil.log("MediaUtil MediaMetadataRetriever retriver.release error", th2);
                }
                return 0;
            }
            mediaMetadataRetriever.release();
            return 0;
        } catch (Exception e) {
            try {
                LogUtil.log("MediaUtil MediaMetadataRetriever 获取长度错误", e);
                mediaMetadataRetriever.release();
            } catch (Throwable th3) {
                LogUtil.log("MediaUtil MediaMetadataRetriever retriver.release error", th3);
            }
        } catch (Throwable th4) {
            LogUtil.log("MediaUtil MediaMetadataRetriever retriver.release error", th4);
        }
        throw th;
    }
}
