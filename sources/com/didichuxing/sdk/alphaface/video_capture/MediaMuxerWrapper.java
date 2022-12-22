package com.didichuxing.sdk.alphaface.video_capture;

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
    private static final boolean f48824a = false;

    /* renamed from: b */
    private static final String f48825b = "MediaMuxerWrapper";

    /* renamed from: c */
    private final MediaMuxer f48826c;

    /* renamed from: d */
    private String f48827d;

    /* renamed from: e */
    private int f48828e;

    /* renamed from: f */
    private int f48829f;

    /* renamed from: g */
    private boolean f48830g;

    /* renamed from: h */
    private MediaEncoder f48831h;

    /* renamed from: i */
    private MediaEncoder f48832i;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        boolean isEmpty = TextUtils.isEmpty(str);
        this.f48826c = new MediaMuxer(this.f48827d, 0);
        this.f48829f = 0;
        this.f48828e = 0;
        this.f48830g = false;
    }

    public MediaMuxerWrapper(Context context, String str, String str2) throws IOException {
        try {
            this.f48827d = DiFaceVideoCaptureManager.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str, str2).toString();
            this.f48826c = new MediaMuxer(this.f48827d, 0);
            this.f48829f = 0;
            this.f48828e = 0;
            this.f48830g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public String getOutputPath() {
        return this.f48827d;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f48831h;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f48832i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f48831h;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f48832i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f48831h;
        if (mediaEncoder != null) {
            mediaEncoder.mo120682b();
        }
        this.f48831h = null;
        MediaEncoder mediaEncoder2 = this.f48832i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo120682b();
        }
        this.f48832i = null;
    }

    public synchronized boolean isStarted() {
        return this.f48830g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo120692a(MediaEncoder mediaEncoder) {
        if (mediaEncoder instanceof MediaVideoEncoder) {
            if (this.f48831h == null) {
                this.f48831h = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f48832i == null) {
            this.f48832i = mediaEncoder;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i = 1;
        int i2 = this.f48831h != null ? 1 : 0;
        if (this.f48832i == null) {
            i = 0;
        }
        this.f48828e = i2 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo120693a() {
        int i = this.f48829f + 1;
        this.f48829f = i;
        if (this.f48828e > 0 && i == this.f48828e) {
            this.f48826c.start();
            this.f48830g = true;
            notifyAll();
        }
        return this.f48830g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo120694b() {
        int i = this.f48829f - 1;
        this.f48829f = i;
        if (this.f48828e > 0 && i <= 0) {
            this.f48826c.stop();
            this.f48826c.release();
            this.f48830g = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo120690a(MediaFormat mediaFormat) {
        if (!this.f48830g) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f48826c.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo120691a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f48829f > 0) {
            this.f48826c.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
