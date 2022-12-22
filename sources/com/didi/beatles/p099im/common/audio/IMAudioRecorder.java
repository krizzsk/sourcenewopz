package com.didi.beatles.p099im.common.audio;

import android.media.MediaRecorder;
import com.didi.beatles.p099im.access.IMRecorderProtocol;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMLog;
import com.taxis99.R;
import java.io.File;

/* renamed from: com.didi.beatles.im.common.audio.IMAudioRecorder */
public class IMAudioRecorder {
    public static final int RECORD_NEED_PERMISSION = 2;
    public static final int RECORD_SDCARD_WORING = 1;
    public static final int RECORD_SUCCESS = 3;

    /* renamed from: a */
    private static boolean f9146a = false;

    /* renamed from: b */
    private static MediaRecorder f9147b = null;

    /* renamed from: c */
    private static String f9148c = null;

    /* renamed from: d */
    private static boolean f9149d = false;

    /* renamed from: com.didi.beatles.im.common.audio.IMAudioRecorder$OnAudioReadyListener */
    public interface OnAudioReadyListener {
        void onReady();
    }

    /* renamed from: com.didi.beatles.im.common.audio.IMAudioRecorder$OnAudioRecordingListener */
    public interface OnAudioRecordingListener {
        void onError(String str);

        void onSucess();

        void permissionDialogShowed();
    }

    public static void ready(OnAudioReadyListener onAudioReadyListener) {
        if (!f9146a) {
            f9146a = true;
            f9149d = false;
            if (IMRecorderProtocol.isCurrentUse()) {
                IMRecorderProtocol.getInstance().registerRecorderProtocolHandler(new RecorderProtocol(onAudioReadyListener));
                IMRecorderProtocol.getInstance().requireRecorder(1);
                return;
            }
            IMRecorderProtocol.getInstance().requireRecorder(1);
            onAudioReadyListener.onReady();
        }
    }

    public static int record(String str, OnAudioRecordingListener onAudioRecordingListener) throws Exception {
        f9149d = true;
        if (f9147b != null) {
            return 3;
        }
        File parentFile = IMFileHelper.getAudioFile(str).getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return 1;
        }
        MediaRecorder mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(1);
        mediaRecorder.setOutputFormat(3);
        mediaRecorder.setAudioEncoder(1);
        mediaRecorder.setOutputFile(IMFileHelper.getAudioFilePath(str));
        m6211b(mediaRecorder, onAudioRecordingListener);
        long currentTimeMillis = System.currentTimeMillis();
        mediaRecorder.prepare();
        if (System.currentTimeMillis() - currentTimeMillis > 1000) {
            return 2;
        }
        mediaRecorder.start();
        f9147b = mediaRecorder;
        f9148c = str;
        return 3;
    }

    @Deprecated
    /* renamed from: a */
    private static void m6210a(final MediaRecorder mediaRecorder, final OnAudioRecordingListener onAudioRecordingListener) {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i += mediaRecorder.getMaxAmplitude();
                }
                if (i == 0) {
                    OnAudioRecordingListener onAudioRecordingListener = onAudioRecordingListener;
                    return;
                }
                OnAudioRecordingListener onAudioRecordingListener2 = onAudioRecordingListener;
                if (onAudioRecordingListener2 != null) {
                    onAudioRecordingListener2.onSucess();
                }
            }
        }).start();
    }

    /* renamed from: b */
    private static void m6211b(MediaRecorder mediaRecorder, final OnAudioRecordingListener onAudioRecordingListener) {
        mediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
            public void onError(MediaRecorder mediaRecorder, int i, int i2) {
                OnAudioRecordingListener onAudioRecordingListener = onAudioRecordingListener;
                if (onAudioRecordingListener != null) {
                    onAudioRecordingListener.onError(IMResource.getString(R.string.bts_im_record_error_inner));
                    IMLog.m6631d("hkc", "something wrong inner when record !");
                }
            }
        });
    }

    public static void stop() {
        IMRecorderProtocol.getInstance().unRegisterRecorderProtocolHandler(new RecorderProtocol((OnAudioReadyListener) null));
        m6209a();
        if (f9146a) {
            IMRecorderProtocol.getInstance().releaseRecorder(1);
        }
        f9146a = false;
    }

    /* renamed from: a */
    private static void m6209a() {
        MediaRecorder mediaRecorder = f9147b;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                f9147b.release();
            } catch (Exception unused) {
            }
            f9147b = null;
            f9148c = null;
        }
    }

    public static double getAmplitude() {
        MediaRecorder mediaRecorder = f9147b;
        if (mediaRecorder == null) {
            return 0.0d;
        }
        int maxAmplitude = mediaRecorder.getMaxAmplitude() / 600;
        int i = 0;
        if (maxAmplitude > 1) {
            i = (int) (Math.log10((double) maxAmplitude) * 20.0d);
        }
        return (double) i;
    }

    public static String getRecordFileId() {
        return f9148c;
    }

    public static boolean isAudioExecute() {
        return f9149d;
    }

    /* renamed from: com.didi.beatles.im.common.audio.IMAudioRecorder$RecorderProtocol */
    private static class RecorderProtocol implements IMRecorderProtocol.IIMRecorderProtocolHandler {
        private boolean isReady = false;
        private OnAudioReadyListener listener;

        public int getLevel() {
            return 1;
        }

        public void onRecorderAcquired() {
        }

        RecorderProtocol(OnAudioReadyListener onAudioReadyListener) {
            this.listener = onAudioReadyListener;
        }

        public void onRecorderReleased(int i) {
            OnAudioReadyListener onAudioReadyListener = this.listener;
            if (onAudioReadyListener != null && !this.isReady) {
                this.isReady = true;
                onAudioReadyListener.onReady();
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof RecorderProtocol;
        }

        public int hashCode() {
            return RecorderProtocol.class.hashCode();
        }
    }
}
