package com.didichuxing.dfbasesdk.video_capture;

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
    private static final boolean f46827a = false;

    /* renamed from: b */
    private static final String f46828b = "MediaMuxerWrapper";

    /* renamed from: c */
    private final MediaMuxer f46829c;

    /* renamed from: d */
    private String f46830d;

    /* renamed from: e */
    private int f46831e;

    /* renamed from: f */
    private int f46832f;

    /* renamed from: g */
    private boolean f46833g;

    /* renamed from: h */
    private MediaEncoder f46834h;

    /* renamed from: i */
    private MediaEncoder f46835i;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        try {
            this.f46830d = PathUtils.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str).toString();
            this.f46829c = new MediaMuxer(this.f46830d, 0);
            this.f46832f = 0;
            this.f46831e = 0;
            this.f46833g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public MediaMuxerWrapper(Context context, String str, String str2) throws IOException {
        try {
            this.f46830d = PathUtils.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str, str2).toString();
            this.f46829c = new MediaMuxer(this.f46830d, 0);
            this.f46832f = 0;
            this.f46831e = 0;
            this.f46833g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public String getOutputPath() {
        return this.f46830d;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f46834h;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f46835i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f46834h;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f46835i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f46834h;
        if (mediaEncoder != null) {
            mediaEncoder.mo115853b();
        }
        this.f46834h = null;
        MediaEncoder mediaEncoder2 = this.f46835i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo115853b();
        }
        this.f46835i = null;
    }

    public synchronized boolean isStarted() {
        return this.f46833g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115863a(MediaEncoder mediaEncoder) {
        if (mediaEncoder instanceof MediaVideoEncoder) {
            if (this.f46834h == null) {
                this.f46834h = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f46835i == null) {
            this.f46835i = mediaEncoder;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i = 1;
        int i2 = this.f46834h != null ? 1 : 0;
        if (this.f46835i == null) {
            i = 0;
        }
        this.f46831e = i2 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo115864a() {
        int i = this.f46832f + 1;
        this.f46832f = i;
        if (this.f46831e > 0 && i == this.f46831e) {
            this.f46829c.start();
            this.f46833g = true;
            notifyAll();
        }
        return this.f46833g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo115865b() {
        int i = this.f46832f - 1;
        this.f46832f = i;
        if (this.f46831e > 0 && i <= 0) {
            this.f46829c.stop();
            this.f46829c.release();
            this.f46833g = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo115861a(MediaFormat mediaFormat) {
        if (!this.f46833g) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f46829c.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo115862a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f46832f > 0) {
            this.f46829c.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
