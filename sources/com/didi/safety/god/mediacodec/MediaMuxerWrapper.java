package com.didi.safety.god.mediacodec;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.didi.beatles.p099im.picture.utils.IMPictureFileUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MediaMuxerWrapper {

    /* renamed from: a */
    private static final boolean f34661a = false;

    /* renamed from: b */
    private static final String f34662b = "MediaMuxerWrapper";

    /* renamed from: c */
    private static final String f34663c = "Liveness-Video";

    /* renamed from: d */
    private static final SimpleDateFormat f34664d = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: e */
    private final MediaMuxer f34665e;

    /* renamed from: f */
    private String f34666f;

    /* renamed from: g */
    private int f34667g;

    /* renamed from: h */
    private int f34668h;

    /* renamed from: i */
    private boolean f34669i;

    /* renamed from: j */
    private MediaEncoder f34670j;

    /* renamed from: k */
    private MediaEncoder f34671k;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        this(context, (String) null, str);
    }

    public MediaMuxerWrapper(Context context, String str, String str2) throws IOException {
        str2 = TextUtils.isEmpty(str2) ? IMPictureFileUtils.POST_VIDEO : str2;
        if (str == null) {
            try {
                this.f34666f = getCaptureFile(context, str2).toString();
            } catch (NullPointerException unused) {
                throw new RuntimeException("This app has no permission of writing external storage");
            }
        } else {
            this.f34666f = str + str2;
        }
        SystemUtils.log(6, f34662b, "path = " + this.f34666f, (Throwable) null, "com.didi.safety.god.mediacodec.MediaMuxerWrapper", 55);
        this.f34665e = new MediaMuxer(this.f34666f, 0);
        this.f34668h = 0;
        this.f34667g = 0;
        this.f34669i = false;
    }

    public static final File getCaptureFile(Context context, String str) {
        if (context == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(f34663c);
        externalFilesDir.mkdirs();
        if (!externalFilesDir.canWrite()) {
            return null;
        }
        return new File(externalFilesDir, m24484c() + str);
    }

    /* renamed from: c */
    private static final String m24484c() {
        return f34664d.format(new GregorianCalendar().getTime());
    }

    public String getOutputPath() {
        return this.f34666f;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f34670j;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f34671k;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f34670j;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f34671k;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f34670j;
        if (mediaEncoder != null) {
            mediaEncoder.mo89855b();
        }
        this.f34670j = null;
        MediaEncoder mediaEncoder2 = this.f34671k;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo89855b();
        }
        this.f34671k = null;
    }

    public synchronized boolean isStarted() {
        return this.f34669i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo89880a(MediaEncoder mediaEncoder) {
        if (!(mediaEncoder instanceof MediaVideoEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f34670j == null) {
            this.f34670j = mediaEncoder;
            int i = 1;
            int i2 = mediaEncoder != null ? 1 : 0;
            if (this.f34671k == null) {
                i = 0;
            }
            this.f34667g = i2 + i;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo89881a() {
        int i = this.f34668h + 1;
        this.f34668h = i;
        if (this.f34667g > 0 && i == this.f34667g) {
            this.f34665e.start();
            this.f34669i = true;
            notifyAll();
        }
        return this.f34669i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo89882b() {
        int i = this.f34668h - 1;
        this.f34668h = i;
        if (this.f34667g > 0 && i <= 0) {
            this.f34665e.stop();
            this.f34665e.release();
            this.f34669i = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo89878a(MediaFormat mediaFormat) {
        if (!this.f34669i) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f34665e.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo89879a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f34668h > 0) {
            this.f34665e.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
