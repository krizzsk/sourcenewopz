package com.didi.sdk.audiorecorder;

import android.content.Context;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.net.UploadService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface BaseAudioRecordContext {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Client {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    boolean debugable();

    Context getAppContext();

    String getAudioCacheDir();

    long getAudioExpiredDuration();

    int getAudioSegmentDuration();

    String getBusinessId();

    String getCaller();

    int getClientType();

    String getExtraJson();

    String getLanguage();

    @Deprecated
    AudioRecordContext.Logger getLogger();

    int getMaxUploadRetryCount();

    String getOrderIds();

    String getSensitiveWordsUploadUrl();

    UploadService getUploadService();

    String getUploadUrl();

    String getUserId();

    String getUserPhone();

    String getUserToken();

    int getUtcOffsetInMinutes();

    boolean isBluetoothRecordEnable();

    boolean speechDetectEnable();
}
