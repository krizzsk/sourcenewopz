package com.didi.safety.god.p144ui;

import android.app.Activity;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.p144ui.GLSurfaceRecorder;
import com.didi.safety.god.util.LogUtils;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.didi.safety.god.ui.GLSurfaceRecorder2 */
public class GLSurfaceRecorder2 extends GLSurfaceRecorder {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile MediaRecorder f34758b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f34759c;

    /* renamed from: d */
    private HandlerThread f34760d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f34761e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Runnable f34762f = new Runnable() {
        public void run() {
            if (!GLSurfaceRecorder2.this.f34761e) {
                boolean unused = GLSurfaceRecorder2.this.f34761e = true;
                try {
                    GLSurfaceRecorder2.this.f34758b.stop();
                    GLSurfaceRecorder2.this.f34758b.reset();
                    GLSurfaceRecorder2.this.f34758b.release();
                    MediaRecorder unused2 = GLSurfaceRecorder2.this.f34758b = null;
                } catch (Exception e) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("cmd", "RECORDVID");
                    hashMap.put("code", 6);
                    hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "停止录制视频出现异常,e = " + e.getMessage());
                    SafetyTraceEventHandler.trace(hashMap, GLSurfaceRecorder2.this.activity);
                    LogUtils.m24580e("stop recording exception, e = " + e.getMessage());
                } catch (Throwable th) {
                    LogUtils.m24578d("real stop video done===");
                    GLSurfaceRecorder2.this.mo89919b();
                    throw th;
                }
                LogUtils.m24578d("real stop video done===");
                GLSurfaceRecorder2.this.mo89919b();
            }
        }
    };

    public GLSurfaceRecorder2(Activity activity, GLSurfaceView gLSurfaceView) {
        super(activity, gLSurfaceView);
    }

    /* renamed from: d */
    private boolean m24549d() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public void beginRecord() {
        if (m24549d()) {
            super.beginRecord();
            return;
        }
        if (this.f34760d == null) {
            HandlerThread handlerThread = new HandlerThread("god_camera");
            this.f34760d = handlerThread;
            handlerThread.start();
            this.f34759c = new Handler(this.f34760d.getLooper());
        }
        this.f34761e = false;
        this.systemRecord = true;
        this.f34759c.post(new Runnable() {
            public void run() {
                if (GLSurfaceRecorder2.this.captureOnce) {
                    LogUtils.m24578d("........ capturing now,wait to next frame.....");
                    GLSurfaceRecorder2.this.f34759c.postDelayed(this, 25);
                    return;
                }
                File c = GLSurfaceRecorder2.this.mo89921c();
                GLSurfaceRecorder2.this.f34732a = new GLSurfaceRecorder.VideoInfo(c);
                String str = c.getAbsolutePath() + ".log";
                Camera camera = GLSurfaceRecorder2.this.mICamera.getCamera();
                try {
                    camera.unlock();
                    MediaRecorder unused = GLSurfaceRecorder2.this.f34758b = new MediaRecorder();
                    GLSurfaceRecorder2.this.f34758b.setCamera(camera);
                    GLSurfaceRecorder2.this.f34758b.setAudioSource(0);
                    GLSurfaceRecorder2.this.f34758b.setVideoSource(1);
                    GLSurfaceRecorder2.this.f34758b.setOutputFormat(2);
                    GLSurfaceRecorder2.this.f34758b.setAudioEncoder(1);
                    GLSurfaceRecorder2.this.f34758b.setVideoEncoder(2);
                    GLSurfaceRecorder2.this.f34758b.setVideoEncodingBitRate(1556480);
                    GLSurfaceRecorder2.this.f34758b.setVideoSize(GLSurfaceRecorder2.this.mICamera.cameraWidth, GLSurfaceRecorder2.this.mICamera.cameraHeight);
                    GLSurfaceRecorder2.this.f34758b.setOutputFile(str);
                    GLSurfaceRecorder2.this.f34758b.prepare();
                    GLSurfaceRecorder2.this.f34758b.start();
                    GLSurfaceRecorder2.this.f34759c.removeCallbacks(GLSurfaceRecorder2.this.f34762f);
                    GLSurfaceRecorder2.this.f34759c.postDelayed(GLSurfaceRecorder2.this.f34762f, (long) ((GLSurfaceRecorder2.this.videoLength + 1) * 1000));
                    LogUtils.m24578d("begin system video record, path = " + str);
                    GLSurfaceRecorder2.this.mo89918a();
                } catch (Exception e) {
                    LogUtils.m24580e("system video record start error, msg===" + e.getMessage());
                    try {
                        GLSurfaceRecorder2.this.f34758b.release();
                    } catch (Exception e2) {
                        LogUtils.logStackTrace(e2);
                    }
                    MediaRecorder unused2 = GLSurfaceRecorder2.this.f34758b = null;
                    HashMap hashMap = new HashMap();
                    hashMap.put("cmd", "RECORDVID");
                    hashMap.put("code", 5);
                    hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "打开系统Recorder失败, msg===" + e.getMessage());
                    SafetyTraceEventHandler.trace(hashMap, GLSurfaceRecorder2.this.activity);
                }
            }
        });
    }

    /* renamed from: a */
    private void m24543a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "VIDCODEC");
        StringBuilder sb = new StringBuilder("(");
        sb.append(i);
        try {
            CamcorderProfile camcorderProfile = CamcorderProfile.get(0);
            CamcorderProfile camcorderProfile2 = CamcorderProfile.get(1);
            int i2 = -1;
            int i3 = camcorderProfile != null ? camcorderProfile.videoCodec : -1;
            if (camcorderProfile2 != null) {
                i2 = camcorderProfile2.videoCodec;
            }
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i2);
        } catch (Throwable th) {
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, th.getMessage());
        }
        sb.append(")");
        hashMap.put("info", sb.toString());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void cleanup() {
        super.cleanup();
        if (this.f34758b != null && !this.f34761e) {
            LogUtils.m24578d("stop video unexpected===");
            Handler handler = this.f34759c;
            if (handler != null) {
                handler.removeCallbacks(this.f34762f);
                this.f34759c.postAtFrontOfQueue(this.f34762f);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f34760d == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            this.f34760d.quitSafely();
        } else {
            this.f34760d.quit();
        }
    }
}
