package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.api.entity.voice.IMVoiceBody;
import com.didi.beatles.p099im.common.IMBtsAudioPlayer;
import com.didi.beatles.p099im.utils.IMVoiceDownloadUtil;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* renamed from: com.didi.beatles.im.utils.IMAudioHelper */
public final class IMAudioHelper {
    public static final int MODULE_DEFAULT = 0;
    public static final int MODULE_MESSAGE_LIST = 1;
    public static final int MODULE_ROBOT_PANEL = 2;

    /* renamed from: a */
    private static final String f9746a = IMAudioHelper.class.getSimpleName();

    /* renamed from: b */
    private static String f9747b;

    /* renamed from: c */
    private static int f9748c = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.utils.IMAudioHelper$AudioModule */
    public @interface AudioModule {
    }

    public static boolean isPlayingCurrentAudio(String str, int i) {
        Context context;
        if (i != f9748c || TextUtils.isEmpty(f9747b) || TextUtils.isEmpty(str) || (context = IMCommonContextInfoHelper.getContext()) == null) {
            return false;
        }
        String filePath = IMFileUtil.getFilePath(context, str);
        if (!IMBtsAudioPlayer.isPlaying() || !TextUtils.equals(filePath, f9747b)) {
            return false;
        }
        return true;
    }

    public static void playFromNet(final Context context, String str, final int i, final IMBtsAudioPlayer.OnAudioPlayingListener onAudioPlayingListener) {
        String filePath = IMFileUtil.getFilePath(context, str);
        if (IMFileUtil.isFileExist(filePath)) {
            play(filePath, i, onAudioPlayingListener);
            return;
        }
        IMVoiceDownloadUtil.downloadVoiceUrl(new IMVoiceDownloadUtil.UrlCallback() {
            public void onUrlCallback(List<IMVoiceBody> list) {
                if (list == null || list.size() <= 0) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            onAudioPlayingListener.onError("Null response");
                        }
                    });
                    return;
                }
                IMVoiceDownloadUtil.downloadVoice(context, list.get(0), (IMVoiceDownloadUtil.FilepathCallback) new IMVoiceDownloadUtil.FilepathCallback() {
                    public void onPathCallback(final String str, String str2) {
                        UiThreadHandler.post(new Runnable() {
                            public void run() {
                                if (TextUtils.isEmpty(str)) {
                                    onAudioPlayingListener.onError("Download voice error");
                                } else {
                                    IMAudioHelper.play(str, i, onAudioPlayingListener);
                                }
                            }
                        });
                    }
                });
            }
        }, str);
    }

    public static void playFromUrl(Context context, String str, final int i, final IMBtsAudioPlayer.OnAudioPlayingListener onAudioPlayingListener) {
        String filePath = IMFileUtil.getFilePath(context, str);
        if (IMFileUtil.isFileExist(filePath)) {
            play(filePath, i, onAudioPlayingListener);
        } else {
            IMVoiceDownloadUtil.downloadVoice(context, str, (IMVoiceDownloadUtil.FilepathCallback) new IMVoiceDownloadUtil.FilepathCallback() {
                public void onPathCallback(final String str, String str2) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            if (TextUtils.isEmpty(str)) {
                                onAudioPlayingListener.onError("Download voice error");
                            } else {
                                IMAudioHelper.play(str, i, onAudioPlayingListener);
                            }
                        }
                    });
                }
            });
        }
    }

    public static void play(String str, int i, IMBtsAudioPlayer.OnAudioPlayingListener onAudioPlayingListener) {
        IMLog.m6631d(f9746a, " [play] called with fileId ");
        File file = new File(str);
        if (!file.exists()) {
            IMLog.m6632e(f9746a, " [play] file not exist");
            return;
        }
        if (IMBtsAudioPlayer.isPlaying()) {
            stopPlay();
            onAudioPlayingListener.onStop();
            if (i == f9748c && TextUtils.equals(str, f9747b)) {
                IMLog.m6632e(f9746a, " [play] fieldId equals audioFiledId");
                return;
            }
        }
        f9747b = str;
        f9748c = i;
        try {
            IMBtsAudioPlayer.play(file.getAbsolutePath(), onAudioPlayingListener, false);
        } catch (Exception e) {
            IMLog.m6632e(f9746a, "[play]", e);
            onAudioPlayingListener.onError("[play] with exception -> " + e.getMessage());
        }
    }

    public static void stopPlay(int i) {
        IMLog.m6631d(f9746a, C4234I.m6591t(" [stopPlaying] audioModule=", Integer.valueOf(i)));
        try {
            if (i == f9748c) {
                IMBtsAudioPlayer.release();
            }
        } catch (Exception e) {
            IMLog.m6632e(f9746a, "[stopPlaying]", e);
        }
    }

    public static void stopPlay() {
        IMLog.m6631d(f9746a, " [stopPlaying] ");
        try {
            IMBtsAudioPlayer.release();
        } catch (Exception e) {
            IMLog.m6632e(f9746a, "[stopPlaying]", e);
        }
    }
}
