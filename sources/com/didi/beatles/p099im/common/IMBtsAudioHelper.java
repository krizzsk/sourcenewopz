package com.didi.beatles.p099im.common;

import android.media.AudioRecord;
import android.text.TextUtils;
import android.widget.Toast;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.common.audio.IMAudioRecorder;
import com.didi.beatles.p099im.common.audio.IMFileHelper;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMPermissionUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;

/* renamed from: com.didi.beatles.im.common.IMBtsAudioHelper */
public class IMBtsAudioHelper {

    /* renamed from: a */
    private static final String f9132a = "IMBtsAudioHelper";
    public static String audioFileid;

    public static void initSensorModle(IMBtsAudioPlayer.onVoiceChannelChangeListener onvoicechannelchangelistener) {
        IMBtsAudioPlayer.initSensor(onvoicechannelchangelistener);
    }

    public static void releaseSensorModle() {
        IMBtsAudioPlayer.releaseSensor();
    }

    public static void record(final String str, final IMAudioRecorder.OnAudioRecordingListener onAudioRecordingListener) {
        IMAudioRecorder.ready(new IMAudioRecorder.OnAudioReadyListener() {
            public void onReady() {
                try {
                    int record = IMAudioRecorder.record(str, onAudioRecordingListener);
                    if (record == 1) {
                        IMLog.m6631d("hkc", "sdcard wrong");
                        onAudioRecordingListener.onError(IMResource.getString(R.string.bts_im_record_error_sdcard));
                    } else if (record == 2) {
                        IMLog.m6631d("hkc", "permisson dialog is showing");
                        onAudioRecordingListener.permissionDialogShowed();
                    } else if (record == 3) {
                        IMLog.m6631d("hkc", "record success");
                        onAudioRecordingListener.onSucess();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    IMLog.m6631d("hkc", "there is a exception when record");
                    onAudioRecordingListener.onError(IMResource.getString(R.string.bts_im_record_error));
                }
            }
        });
    }

    public static boolean checkRecordPermission() {
        if (IMPermissionUtil.checkPermissionGranted(IMContextInfoHelper.getContext(), Permission.RECORD_AUDIO)) {
            return true;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR, 12, 2);
        AudioRecord audioRecord = new AudioRecord(1, ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR, 12, 2, minBufferSize);
        audioRecord.startRecording();
        if (audioRecord.read(new byte[minBufferSize], 0, minBufferSize) < 0) {
            SystemUtils.showToast(Toast.makeText(IMContextInfoHelper.getContext(), IMResource.getString(R.string.im_something_wrong_with_record_permission), 0));
            audioRecord.stop();
            audioRecord.release();
            return false;
        }
        audioRecord.stop();
        audioRecord.release();
        IMPreference.getInstance(IMContextInfoHelper.getContext()).setCheckRecord(1);
        return true;
    }

    public static String stopRecording() {
        String recordFileId = IMAudioRecorder.getRecordFileId();
        IMAudioRecorder.stop();
        return recordFileId;
    }

    public static void cancelRecording() {
        String recordFileId = IMAudioRecorder.getRecordFileId();
        IMAudioRecorder.stop();
        IMFileHelper.deleteAudioFile(recordFileId);
    }

    public static double getAmplitude() {
        return IMAudioRecorder.getAmplitude();
    }

    public static boolean play(String str, IMBtsAudioPlayer.OnAudioPlayingListener onAudioPlayingListener) {
        IMLog.m6631d(f9132a, " [play] called with fileId ");
        File file = new File(str);
        if (!file.exists()) {
            IMLog.m6632e(f9132a, " [play] file not exist");
            return false;
        }
        if (IMBtsAudioPlayer.isPlaying()) {
            stopPlaying();
            onAudioPlayingListener.onStop();
            if (TextUtils.equals(str, audioFileid)) {
                IMLog.m6632e(f9132a, " [play] fieldId equals audioFiledId");
                return false;
            }
        }
        audioFileid = str;
        try {
            IMBtsAudioPlayer.play(file.getAbsolutePath(), onAudioPlayingListener, false);
        } catch (Exception e) {
            IMLog.m6632e(f9132a, "[play]", e);
            onAudioPlayingListener.onError("[play] with exception -> " + e.getMessage());
        }
        return true;
    }

    public static void stopPlaying() {
        IMLog.m6631d(f9132a, " [stopPlaying] ");
        try {
            IMBtsAudioPlayer.release();
        } catch (Exception e) {
            IMLog.m6632e(f9132a, "[stopPlaying]", e);
        }
    }
}
