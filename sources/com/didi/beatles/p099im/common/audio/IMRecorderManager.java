package com.didi.beatles.p099im.common.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.common.IMChatHelper;
import com.didi.beatles.p099im.common.audio.IMAudioRecorder;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;

/* renamed from: com.didi.beatles.im.common.audio.IMRecorderManager */
public class IMRecorderManager implements Handler.Callback {
    public static final int ERROR_NOT_RECORDER = 5;
    public static final int ERROR_NOT_START = 6;
    public static final int ERROR_OTHER_RECORDER = 4;
    public static final int ERROR_PERMISSION_DIALOG = 3;
    public static final int ERROR_SYSTEM_ERROR = 1;
    public static final int ERROR_TOO_SHORT = 2;

    /* renamed from: a */
    private static final String f9151a = "IMRecorderManager";

    /* renamed from: b */
    private static final int f9152b = 0;

    /* renamed from: c */
    private static final int f9153c = 1;

    /* renamed from: d */
    private static final int f9154d = 2;

    /* renamed from: e */
    private static final int f9155e = 3;

    /* renamed from: f */
    private static IMRecorderManager f9156f = new IMRecorderManager();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Holder f9157g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f9158h = new Handler(Looper.getMainLooper(), this);

    /* renamed from: i */
    private int f9159i = 11;

    /* renamed from: com.didi.beatles.im.common.audio.IMRecorderManager$Callback */
    public interface Callback {
        void onEndRecord();

        void onError(int i, String str);

        void onResidueTimeChange(String str);

        void onSoundLevelChange(int i);

        void onStartRecord();

        void onSuccess(String str, long j);
    }

    public static String createFileId() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static IMRecorderManager getInstance() {
        return f9156f;
    }

    private IMRecorderManager() {
    }

    public void recorder(String str, Callback callback) {
        IMLog.m6635i(f9151a, C4234I.m6591t("recorder fileId ", str));
        Holder holder = this.f9157g;
        if (holder == null || !TextUtils.equals(str, holder.fileId)) {
            Holder holder2 = new Holder();
            holder2.fileId = str;
            holder2.callback = callback;
            holder2.recordTime = System.currentTimeMillis();
            Holder holder3 = this.f9157g;
            if (holder3 != null) {
                holder3.callback.onError(4, C4234I.m6591t("now recorder", str));
            }
            m6215a(true);
            this.f9157g = holder2;
            IMBtsAudioHelper.stopPlaying();
            m6217a(this.f9157g);
            return;
        }
        IMLog.m6632e(f9151a, C4234I.m6591t("fileId", str, "same as cur"));
    }

    public void stop(String str, Callback callback) {
        String str2 = str;
        Callback callback2 = callback;
        IMLog.m6635i(f9151a, C4234I.m6591t("stop fileId ", str2));
        Holder holder = this.f9157g;
        if (holder == null || !TextUtils.equals(str2, holder.fileId)) {
            IMLog.m6637w(f9151a, C4234I.m6591t("fileId", str2, "not recorder"));
            callback2.onError(5, (String) null);
            return;
        }
        long j = this.f9157g.recordTime;
        String a = m6215a(false);
        if (!IMAudioRecorder.isAudioExecute()) {
            IMLog.m6632e(f9151a, C4234I.m6591t("stop fileId ", str2, " but not start"));
            callback2.onError(6, (String) null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        IMLog.m6635i(f9151a, C4234I.m6591t("fileId ", str2, " recorder duration ", Long.valueOf(currentTimeMillis), "ms"));
        int isAudioValid = IMChatHelper.isAudioValid(j, a);
        if (isAudioValid != IMChatHelper.ONCLICK_EVENT) {
            if (isAudioValid == IMChatHelper.TIME_TOO_SHORT) {
                callback2.onError(2, (String) null);
            } else if (isAudioValid == IMChatHelper.SIZE_TOO_SMALL) {
                callback2.onError(3, (String) null);
            } else {
                callback2.onSuccess(str2, currentTimeMillis);
            }
        }
    }

    public void cancel(String str, Callback callback) {
        IMLog.m6635i(f9151a, C4234I.m6591t("cancel fileId ", str));
        Holder holder = this.f9157g;
        if (holder == null || !TextUtils.equals(str, holder.fileId)) {
            IMLog.m6637w(f9151a, C4234I.m6591t("cancel fileId ", str, " but not recorder"));
            callback.onError(5, (String) null);
            return;
        }
        m6215a(true);
    }

    /* renamed from: a */
    private void m6217a(final Holder holder) {
        IMBtsAudioHelper.record(holder.fileId, new IMAudioRecorder.OnAudioRecordingListener() {
            /* access modifiers changed from: private */
            public boolean checkHolderPass() {
                if (holder == IMRecorderManager.this.f9157g) {
                    return false;
                }
                IMLog.m6635i(IMRecorderManager.f9151a, "holder is not same");
                return true;
            }

            public void onError(final String str) {
                IMLog.m6631d(IMRecorderManager.f9151a, "onError, " + str);
                IMRecorderManager.this.f9158h.post(new Runnable() {
                    public void run() {
                        if (!C39891.this.checkHolderPass()) {
                            holder.callback.onError(1, str);
                            String unused = IMRecorderManager.this.m6215a(true);
                        }
                    }
                });
            }

            public void onSucess() {
                IMLog.m6631d(IMRecorderManager.f9151a, "onSucess");
                IMRecorderManager.this.f9158h.post(new Runnable() {
                    public void run() {
                        if (!C39891.this.checkHolderPass()) {
                            holder.recordTime = System.currentTimeMillis();
                            IMRecorderManager.this.f9158h.sendEmptyMessageDelayed(0, (long) IMChatHelper.AUDIO_RECORD_THRESHOLD);
                        }
                    }
                });
            }

            public void permissionDialogShowed() {
                IMLog.m6631d(IMRecorderManager.f9151a, "permissionDialogShowed");
                IMRecorderManager.this.f9158h.post(new Runnable() {
                    public void run() {
                        if (!C39891.this.checkHolderPass()) {
                            holder.callback.onError(3, (String) null);
                            String unused = IMRecorderManager.this.m6215a(true);
                        }
                    }
                });
            }
        });
        this.f9158h.sendEmptyMessageDelayed(1, (long) IMChatHelper.AUDIO_RECORD_MAX_DURATION);
    }

    /* renamed from: a */
    private void m6216a() {
        Holder holder = this.f9157g;
        if (holder == null) {
            IMLog.m6637w(f9151a, "stopInner bug recorder is null!");
            return;
        }
        IMLog.m6635i(f9151a, C4234I.m6591t("stopInner fileId ", holder.fileId));
        stop(this.f9157g.fileId, this.f9157g.callback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m6215a(boolean z) {
        this.f9158h.removeCallbacksAndMessages((Object) null);
        Holder holder = this.f9157g;
        if (holder != null) {
            holder.callback.onEndRecord();
        }
        this.f9157g = null;
        if (!z) {
            return IMBtsAudioHelper.stopRecording();
        }
        IMBtsAudioHelper.cancelRecording();
        return null;
    }

    public boolean handleMessage(Message message) {
        if (this.f9157g == null) {
            IMLog.m6637w(f9151a, C4234I.m6591t("handleMessage but recorder null msg what is ", Integer.valueOf(message.what)));
            return false;
        }
        int i = message.what;
        if (i == 0) {
            this.f9157g.callback.onStartRecord();
            this.f9159i = 11;
            this.f9158h.sendEmptyMessageDelayed(2, (long) IMChatHelper.AUDIO_RECORD_RESIDUE_TIME);
            this.f9158h.sendEmptyMessageDelayed(3, (long) IMChatHelper.AUDIO_RECORD_DB_DURATION);
        } else if (i == 1) {
            m6216a();
        } else if (i == 2) {
            int i2 = this.f9159i - 1;
            this.f9159i = i2;
            if (i2 > 0) {
                Callback callback = this.f9157g.callback;
                callback.onResidueTimeChange(this.f9159i + "");
            }
            this.f9158h.sendEmptyMessageDelayed(2, (long) IMChatHelper.AUDIO_RECORD_RESIDUE_DURATION);
        } else if (i != 3) {
            return false;
        } else {
            this.f9157g.callback.onSoundLevelChange(IMChatHelper.getBtsAudioAmpLitude());
            this.f9158h.sendEmptyMessageDelayed(3, (long) IMChatHelper.AUDIO_RECORD_DB_DURATION);
        }
        return true;
    }

    /* renamed from: com.didi.beatles.im.common.audio.IMRecorderManager$Holder */
    private static class Holder {
        Callback callback;
        String fileId;
        long recordTime;

        private Holder() {
        }
    }
}
