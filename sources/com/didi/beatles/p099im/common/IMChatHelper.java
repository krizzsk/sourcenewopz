package com.didi.beatles.p099im.common;

import android.text.TextUtils;
import com.didi.beatles.p099im.common.audio.IMFileHelper;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.sdk.audiorecorder.helper.AudioUploader;
import java.io.File;

/* renamed from: com.didi.beatles.im.common.IMChatHelper */
public class IMChatHelper {
    public static int AUDIO_RECORD_DB_DURATION = 120;
    public static int AUDIO_RECORD_MAX_DURATION = 60000;
    public static int AUDIO_RECORD_MIN_DURATION = 1000;
    public static int AUDIO_RECORD_RESIDUE_DURATION = 1000;
    public static int AUDIO_RECORD_RESIDUE_TIME = 49000;
    public static int AUDIO_RECORD_THRESHOLD = 200;
    public static int NORMAL_RECORD = 2;
    public static int ONCLICK_EVENT = 0;
    public static int SIZE_TOO_SMALL = 3;
    public static int TIME_TOO_SHORT = 1;

    public static int isAudioValid(long j, String str) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < ((long) AUDIO_RECORD_THRESHOLD)) {
            return ONCLICK_EVENT;
        }
        if (currentTimeMillis < ((long) AUDIO_RECORD_MIN_DURATION)) {
            return TIME_TOO_SHORT;
        }
        if (TextUtils.isEmpty(str)) {
            return SIZE_TOO_SMALL;
        }
        long a = m6202a(IMFileHelper.getAudioFilePath(str));
        if (a >= 800) {
            return NORMAL_RECORD;
        }
        IMTraceUtil.addBusinessEvent("im_audio_error").add("type", 1).add(AudioUploader.REQ_PARAMS.FILE_SIZE, Long.valueOf(a)).report();
        return SIZE_TOO_SMALL;
    }

    /* renamed from: a */
    private static long m6202a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 0;
        }
        return file.length();
    }

    public static int getBtsAudioAmpLitude() {
        double amplitude = IMBtsAudioHelper.getAmplitude();
        if (amplitude < 10.0d) {
            return 2;
        }
        if (amplitude >= 10.0d && amplitude < 15.0d) {
            return 3;
        }
        if (amplitude >= 15.0d && amplitude < 20.0d) {
            return 4;
        }
        if (amplitude >= 20.0d && amplitude < 25.0d) {
            return 5;
        }
        if (amplitude < 25.0d || amplitude >= 30.0d) {
            return (amplitude < 30.0d || amplitude >= 35.0d) ? 3 : 7;
        }
        return 6;
    }
}
