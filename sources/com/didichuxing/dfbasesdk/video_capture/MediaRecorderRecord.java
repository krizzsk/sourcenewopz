package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.media.MediaRecorder;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.camera.ICameraInterface;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaRecorderRecord implements IRecordVideo {

    /* renamed from: a */
    private MediaRecorder f46836a;

    /* renamed from: b */
    private final ICameraInterface f46837b;

    /* renamed from: c */
    private final Context f46838c;

    /* renamed from: d */
    private String f46839d;

    /* renamed from: e */
    private AtomicBoolean f46840e = new AtomicBoolean(false);

    public void frameAvailable(float[] fArr) {
    }

    @Deprecated
    public void start(int i, String str) {
    }

    public MediaRecorderRecord(Context context, ICameraInterface iCameraInterface) {
        this.f46838c = context.getApplicationContext();
        this.f46837b = iCameraInterface;
    }

    public void start(int i) {
        stop();
        this.f46839d = PathUtils.getCaptureFile(this.f46838c, "_m.mp4").toString();
        if (this.f46837b.getCamera() != null) {
            this.f46836a = new MediaRecorder();
            this.f46837b.getCamera().unlock();
            this.f46836a.setCamera(this.f46837b.getCamera());
            this.f46836a.setAudioSource(0);
            this.f46836a.setVideoSource(1);
            this.f46836a.setOrientationHint(90);
            this.f46836a.setOutputFormat(2);
            this.f46836a.setAudioEncoder(1);
            this.f46836a.setVideoEncoder(2);
            this.f46836a.setVideoEncodingBitRate(1556480);
            this.f46836a.setVideoSize(this.f46837b.getPreviewWidth(), this.f46837b.getPreviewHeight());
            this.f46836a.setOutputFile(this.f46839d);
            try {
                this.f46836a.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f46836a.start();
        }
        this.f46840e.set(true);
    }

    public void stop() {
        if (this.f46840e.get()) {
            this.f46840e.set(false);
            MediaRecorder mediaRecorder = this.f46836a;
            if (mediaRecorder != null) {
                mediaRecorder.stop();
                this.f46836a.reset();
                this.f46836a.release();
            }
        }
    }

    public String getVideoPath() {
        if (TextUtils.isEmpty(this.f46839d)) {
            return null;
        }
        String str = this.f46839d;
        this.f46839d = null;
        return str;
    }

    public void setErrorListener(final IErrorListener iErrorListener) {
        MediaRecorder mediaRecorder = this.f46836a;
        if (mediaRecorder != null) {
            mediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
                public void onError(MediaRecorder mediaRecorder, int i, int i2) {
                    IErrorListener iErrorListener = iErrorListener;
                    if (iErrorListener != null) {
                        iErrorListener.onError("MediaRecorder onError : what : " + i + "  extra : " + i2);
                    }
                }
            });
        }
    }

    public boolean recording() {
        return this.f46840e.get();
    }
}
