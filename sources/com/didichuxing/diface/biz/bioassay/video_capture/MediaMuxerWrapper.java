package com.didichuxing.diface.biz.bioassay.video_capture;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaMuxerWrapper {

    /* renamed from: a */
    private static final boolean f47425a = false;

    /* renamed from: b */
    private static final String f47426b = "MediaMuxerWrapper";

    /* renamed from: c */
    private final MediaMuxer f47427c;

    /* renamed from: d */
    private String f47428d;

    /* renamed from: e */
    private int f47429e;

    /* renamed from: f */
    private int f47430f;

    /* renamed from: g */
    private boolean f47431g;

    /* renamed from: h */
    private MediaEncoder f47432h;

    /* renamed from: i */
    private MediaEncoder f47433i;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        try {
            this.f47428d = DiFaceVideoCaptureManager.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str).toString();
            this.f47427c = new MediaMuxer(this.f47428d, 0);
            this.f47430f = 0;
            this.f47429e = 0;
            this.f47431g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public String getOutputPath() {
        return this.f47428d;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f47432h;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f47433i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f47432h;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f47433i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f47432h;
        if (mediaEncoder != null) {
            mediaEncoder.mo116411b();
        }
        this.f47432h = null;
        MediaEncoder mediaEncoder2 = this.f47433i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo116411b();
        }
        this.f47433i = null;
    }

    public synchronized boolean isStarted() {
        return this.f47431g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo116421a(MediaEncoder mediaEncoder) {
        if (mediaEncoder instanceof MediaVideoEncoder) {
            if (this.f47432h == null) {
                this.f47432h = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f47433i == null) {
            this.f47433i = mediaEncoder;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i = 1;
        int i2 = this.f47432h != null ? 1 : 0;
        if (this.f47433i == null) {
            i = 0;
        }
        this.f47429e = i2 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo116422a() {
        int i = this.f47430f + 1;
        this.f47430f = i;
        if (this.f47429e > 0 && i == this.f47429e) {
            this.f47427c.start();
            this.f47431g = true;
            notifyAll();
        }
        return this.f47431g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo116423b() {
        int i = this.f47430f - 1;
        this.f47430f = i;
        if (this.f47429e > 0 && i <= 0) {
            this.f47427c.stop();
            this.f47427c.release();
            this.f47431g = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo116419a(MediaFormat mediaFormat) {
        if (!this.f47431g) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f47427c.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo116420a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f47430f > 0) {
            this.f47427c.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
