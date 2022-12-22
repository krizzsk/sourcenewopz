package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.util.StreamUtility;
import java.io.File;
import java.nio.channels.FileChannel;

public class FileDataEmitter extends DataEmitterBase {

    /* renamed from: a */
    AsyncServer f55212a;

    /* renamed from: b */
    File f55213b;

    /* renamed from: c */
    DataCallback f55214c;

    /* renamed from: d */
    boolean f55215d;

    /* renamed from: e */
    ByteBufferList f55216e = new ByteBufferList();

    /* renamed from: f */
    FileChannel f55217f;

    /* renamed from: g */
    Runnable f55218g = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:13:0x004d A[Catch:{ Exception -> 0x0073 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0046 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                java.nio.channels.FileChannel r0 = r0.f55217f     // Catch:{ Exception -> 0x0073 }
                if (r0 != 0) goto L_0x0017
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.FileDataEmitter r2 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                java.io.File r2 = r2.f55213b     // Catch:{ Exception -> 0x0073 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0073 }
                java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch:{ Exception -> 0x0073 }
                r0.f55217f = r1     // Catch:{ Exception -> 0x0073 }
            L_0x0017:
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.ByteBufferList r0 = r0.f55216e     // Catch:{ Exception -> 0x0073 }
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0073 }
                if (r0 != 0) goto L_0x0035
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.FileDataEmitter r1 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.ByteBufferList r1 = r1.f55216e     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.C20137Util.emitAllData(r0, r1)     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.ByteBufferList r0 = r0.f55216e     // Catch:{ Exception -> 0x0073 }
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0073 }
                if (r0 != 0) goto L_0x0035
                return
            L_0x0035:
                r0 = 8192(0x2000, float:1.14794E-41)
                java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)     // Catch:{ Exception -> 0x0073 }
                r1 = -1
                com.koushikdutta.async.FileDataEmitter r2 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                java.nio.channels.FileChannel r2 = r2.f55217f     // Catch:{ Exception -> 0x0073 }
                int r2 = r2.read(r0)     // Catch:{ Exception -> 0x0073 }
                if (r1 != r2) goto L_0x004d
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                r1 = 0
                r0.report(r1)     // Catch:{ Exception -> 0x0073 }
                return
            L_0x004d:
                r0.flip()     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.FileDataEmitter r1 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.ByteBufferList r1 = r1.f55216e     // Catch:{ Exception -> 0x0073 }
                r1.add((java.nio.ByteBuffer) r0)     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.FileDataEmitter r1 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.ByteBufferList r1 = r1.f55216e     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.C20137Util.emitAllData(r0, r1)     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                com.koushikdutta.async.ByteBufferList r0 = r0.f55216e     // Catch:{ Exception -> 0x0073 }
                int r0 = r0.remaining()     // Catch:{ Exception -> 0x0073 }
                if (r0 != 0) goto L_0x0079
                com.koushikdutta.async.FileDataEmitter r0 = com.koushikdutta.async.FileDataEmitter.this     // Catch:{ Exception -> 0x0073 }
                boolean r0 = r0.isPaused()     // Catch:{ Exception -> 0x0073 }
                if (r0 == 0) goto L_0x0035
                goto L_0x0079
            L_0x0073:
                r0 = move-exception
                com.koushikdutta.async.FileDataEmitter r1 = com.koushikdutta.async.FileDataEmitter.this
                r1.report(r0)
            L_0x0079:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.FileDataEmitter.C201261.run():void");
        }
    };

    public boolean isChunked() {
        return false;
    }

    public FileDataEmitter(AsyncServer asyncServer, File file) {
        this.f55212a = asyncServer;
        this.f55213b = file;
        boolean z = !asyncServer.isAffinityThread();
        this.f55215d = z;
        if (!z) {
            m39732a();
        }
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.f55214c = dataCallback;
    }

    public DataCallback getDataCallback() {
        return this.f55214c;
    }

    public void pause() {
        this.f55215d = true;
    }

    public void resume() {
        this.f55215d = false;
        m39732a();
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        StreamUtility.closeQuietly(this.f55217f);
        super.report(exc);
    }

    /* renamed from: a */
    private void m39732a() {
        this.f55212a.post(this.f55218g);
    }

    public boolean isPaused() {
        return this.f55215d;
    }

    public AsyncServer getServer() {
        return this.f55212a;
    }

    public void close() {
        try {
            this.f55217f.close();
        } catch (Exception unused) {
        }
    }
}
