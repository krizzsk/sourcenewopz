package com.didi.sdk.logging.net;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.C2434Util;
import okio.Buffer;
import okio.BufferedSink;

public class FileRequestBody extends RequestBody {

    /* renamed from: a */
    private static final MediaType f36583a = MediaType.parse("multipart/form-data");

    /* renamed from: b */
    private final MediaType f36584b;

    /* renamed from: c */
    private final File f36585c;

    /* renamed from: d */
    private final long f36586d;

    /* renamed from: e */
    private final long f36587e;

    public FileRequestBody(MediaType mediaType, File file, long j, long j2) {
        this.f36584b = mediaType;
        this.f36585c = file;
        this.f36586d = j;
        this.f36587e = j2;
    }

    public MediaType contentType() {
        return this.f36584b;
    }

    public long contentLength() {
        return this.f36587e;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f36585c, "r");
            try {
                randomAccessFile2.seek(this.f36586d);
                byte[] bArr = new byte[((int) this.f36587e)];
                randomAccessFile2.read(bArr);
                buffer.write(bArr);
                bufferedSink.write(buffer, this.f36587e);
                C2434Util.closeQuietly((Closeable) randomAccessFile2);
                C2434Util.closeQuietly((Closeable) buffer);
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                C2434Util.closeQuietly((Closeable) randomAccessFile);
                C2434Util.closeQuietly((Closeable) buffer);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C2434Util.closeQuietly((Closeable) randomAccessFile);
            C2434Util.closeQuietly((Closeable) buffer);
            throw th;
        }
    }

    public static FileRequestBody create(MediaType mediaType, File file, long j, long j2) {
        if (file != null) {
            return new FileRequestBody(mediaType, file, j, j2);
        }
        throw new NullPointerException("content == null");
    }

    public static FileRequestBody create(File file, long j, long j2) {
        if (file != null) {
            return new FileRequestBody(f36583a, file, j, j2);
        }
        throw new NullPointerException("content == null");
    }

    public static FileRequestBody create(File file) {
        if (file != null) {
            return new FileRequestBody(f36583a, file, 0, file.length());
        }
        throw new NullPointerException("content == null");
    }
}
