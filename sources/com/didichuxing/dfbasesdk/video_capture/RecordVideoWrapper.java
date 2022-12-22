package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import com.didichuxing.dfbasesdk.camera.ICameraInterface;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class RecordVideoWrapper implements IRecordVideo {

    /* renamed from: a */
    private IRecordVideo f46850a;

    /* renamed from: b */
    private Context f46851b;

    /* renamed from: c */
    private ICameraInterface f46852c;

    /* renamed from: d */
    private IErrorListener f46853d;

    public RecordVideoWrapper(Context context, boolean z, GLSurfaceView gLSurfaceView, ICameraInterface iCameraInterface, float f, int i) {
        this.f46851b = context.getApplicationContext();
        this.f46852c = iCameraInterface;
        if (Build.VERSION.SDK_INT < 18) {
            this.f46850a = new MediaRecorderRecord(context, iCameraInterface);
        } else {
            this.f46850a = new FacePlusRecordVideo(context, iCameraInterface, z, gLSurfaceView, f, i);
        }
    }

    public void start(int i) {
        try {
            this.f46850a.start(i);
        } catch (Throwable th) {
            m33621a();
            LogUtils.logStackTrace(th);
        }
    }

    public void start(int i, String str) {
        try {
            this.f46850a.start(i, str);
        } catch (Throwable th) {
            m33621a();
            LogUtils.logStackTrace(th);
        }
    }

    public void stop() {
        try {
            this.f46850a.stop();
        } catch (Throwable th) {
            LogUtils.logStackTrace(th);
        }
    }

    public String getVideoPath() {
        try {
            return this.f46850a.getVideoPath();
        } catch (Throwable th) {
            LogUtils.logStackTrace(th);
            return "";
        }
    }

    public void setErrorListener(final IErrorListener iErrorListener) {
        this.f46853d = iErrorListener;
        IRecordVideo iRecordVideo = this.f46850a;
        if (iRecordVideo != null) {
            iRecordVideo.setErrorListener(new IErrorListener() {
                public void onError(String str) {
                    IErrorListener iErrorListener = iErrorListener;
                    if (iErrorListener != null) {
                        iErrorListener.onError(str);
                    }
                }

                public void onStartError(String str) {
                    IErrorListener iErrorListener = iErrorListener;
                    if (iErrorListener != null) {
                        iErrorListener.onStartError(str);
                    }
                    RecordVideoWrapper.this.m33621a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33621a() {
        IRecordVideo iRecordVideo = this.f46850a;
        if (iRecordVideo == null || !(iRecordVideo instanceof FacePlusRecordVideo)) {
            IErrorListener iErrorListener = this.f46853d;
            if (iErrorListener != null) {
                iErrorListener.onError("尝试使用MediaRecord录制一次失败");
                return;
            }
            return;
        }
        try {
            MediaRecorderRecord mediaRecorderRecord = new MediaRecorderRecord(this.f46851b, this.f46852c);
            this.f46850a = mediaRecorderRecord;
            mediaRecorderRecord.start(0);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            IErrorListener iErrorListener2 = this.f46853d;
            if (iErrorListener2 != null) {
                iErrorListener2.onError("尝试使用MediaRecord录制一次失败，" + e.getMessage());
            }
        }
    }

    public void frameAvailable(float[] fArr) {
        IRecordVideo iRecordVideo = this.f46850a;
        if (iRecordVideo != null) {
            try {
                iRecordVideo.frameAvailable(fArr);
            } catch (Throwable th) {
                LogUtils.logStackTrace(th);
            }
        }
    }

    public boolean recording() {
        IRecordVideo iRecordVideo = this.f46850a;
        if (iRecordVideo != null) {
            return iRecordVideo.recording();
        }
        return false;
    }
}
