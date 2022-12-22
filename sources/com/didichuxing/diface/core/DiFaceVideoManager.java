package com.didichuxing.diface.core;

import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.Timer;
import java.util.TimerTask;

public class DiFaceVideoManager {

    /* renamed from: a */
    private MediaRecorder f47495a;

    /* renamed from: b */
    private boolean f47496b;

    /* renamed from: c */
    private int f47497c = 1280;

    /* renamed from: d */
    private int f47498d = 720;

    /* renamed from: e */
    private Timer f47499e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f47500f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediaPlayer f47501g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f47502h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Timer f47503i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public IVideoProgressListener f47504j;

    public interface ITimerCallback {
        void onTick(int i);
    }

    public interface IVideoProgressListener {
        void onCompletion();

        void onProgress(int i);

        void onStart(int i);

        void onStop();
    }

    /* renamed from: a */
    static /* synthetic */ int m34006a(DiFaceVideoManager diFaceVideoManager) {
        int i = diFaceVideoManager.f47500f;
        diFaceVideoManager.f47500f = i - 1;
        return i;
    }

    public boolean isStartRecord() {
        return this.f47496b;
    }

    public void initRecordParam(int i, int i2) {
        this.f47497c = i;
        this.f47498d = i2;
    }

    public void record(Camera camera, int i, Surface surface, String str) {
        record(camera, i, surface, str, -1, (ITimerCallback) null);
    }

    public void record(Camera camera, int i, Surface surface, String str, int i2, ITimerCallback iTimerCallback) {
        if (!this.f47496b) {
            try {
                if (this.f47495a == null) {
                    this.f47495a = new MediaRecorder();
                }
                camera.unlock();
                this.f47495a.setCamera(camera);
                this.f47495a.setAudioSource(1);
                this.f47495a.setVideoSource(1);
                this.f47495a.setOutputFormat(2);
                this.f47495a.setAudioEncoder(1);
                this.f47495a.setVideoEncoder(2);
                this.f47495a.setVideoSize(this.f47497c, this.f47498d);
                this.f47495a.setVideoFrameRate(30);
                this.f47495a.setVideoEncodingBitRate(3145728);
                this.f47495a.setOrientationHint(i);
                this.f47495a.setPreviewDisplay(surface);
                this.f47495a.setOutputFile(str);
                this.f47495a.prepare();
                this.f47495a.start();
                this.f47496b = true;
                if (i2 != -1) {
                    m34009a(i2, iTimerCallback);
                }
            } catch (Exception e) {
                LogUtils.m33563d("start record failed: " + e.getMessage());
            }
        }
    }

    public void stopRecord() {
        if (this.f47496b) {
            try {
                this.f47495a.stop();
                this.f47495a.reset();
                this.f47495a.release();
                this.f47495a = null;
                this.f47496b = false;
                m34008a();
            } catch (Exception e) {
                LogUtils.m33563d("stop record failed: " + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m34009a(int i, final ITimerCallback iTimerCallback) {
        this.f47500f = i;
        if (this.f47499e == null) {
            this.f47499e = new Timer();
        }
        this.f47499e.schedule(new TimerTask() {
            public void run() {
                DiFaceVideoManager.m34006a(DiFaceVideoManager.this);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        if (iTimerCallback != null) {
                            iTimerCallback.onTick(DiFaceVideoManager.this.f47500f);
                        }
                        if (DiFaceVideoManager.this.f47500f == 0) {
                            DiFaceVideoManager.this.stopRecord();
                        }
                    }
                });
            }
        }, 1000, 1000);
    }

    /* renamed from: a */
    private synchronized void m34008a() {
        if (this.f47499e != null) {
            this.f47499e.cancel();
            this.f47499e.purge();
            this.f47499e = null;
        }
    }

    public void startPlay(String str, SurfaceHolder surfaceHolder) {
        startPlay(str, surfaceHolder, true, (IVideoProgressListener) null);
    }

    public void startPlay(String str, SurfaceHolder surfaceHolder, final boolean z, IVideoProgressListener iVideoProgressListener) {
        if (!this.f47502h) {
            this.f47504j = iVideoProgressListener;
            try {
                if (this.f47501g == null) {
                    this.f47501g = new MediaPlayer();
                }
                this.f47501g.setDataSource(str);
                this.f47501g.setDisplay(surfaceHolder);
                this.f47501g.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (DiFaceVideoManager.this.f47504j != null) {
                            DiFaceVideoManager.this.f47504j.onCompletion();
                        }
                        if (z) {
                            DiFaceVideoManager.this.f47501g.seekTo(0);
                            DiFaceVideoManager.this.f47501g.start();
                            return;
                        }
                        DiFaceVideoManager.this.stopPlay();
                    }
                });
                this.f47501g.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        if (DiFaceVideoManager.this.f47504j != null) {
                            DiFaceVideoManager.this.f47504j.onStart(DiFaceVideoManager.this.f47501g.getDuration());
                        }
                        mediaPlayer.start();
                        boolean unused = DiFaceVideoManager.this.f47502h = true;
                        if (DiFaceVideoManager.this.f47503i == null) {
                            Timer unused2 = DiFaceVideoManager.this.f47503i = new Timer();
                            DiFaceVideoManager.this.f47503i.schedule(new TimerTask() {
                                public void run() {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            if (DiFaceVideoManager.this.f47504j != null && DiFaceVideoManager.this.f47501g != null) {
                                                DiFaceVideoManager.this.f47504j.onProgress(DiFaceVideoManager.this.f47501g.getCurrentPosition());
                                            }
                                        }
                                    });
                                }
                            }, 0, 1000);
                        }
                    }
                });
                this.f47501g.prepareAsync();
            } catch (Exception e) {
                LogUtils.m33563d("play video error: " + e.getMessage());
            }
        }
    }

    public void stopPlay() {
        if (this.f47502h) {
            IVideoProgressListener iVideoProgressListener = this.f47504j;
            if (iVideoProgressListener != null) {
                iVideoProgressListener.onStop();
            }
            this.f47503i.cancel();
            this.f47503i.purge();
            this.f47503i = null;
            this.f47501g.stop();
            this.f47501g.release();
            this.f47501g = null;
            this.f47502h = false;
        }
    }
}
