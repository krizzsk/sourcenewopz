package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.InputStream;

public class InputStreamDataEmitter implements DataEmitter {

    /* renamed from: a */
    AsyncServer f55440a;

    /* renamed from: b */
    InputStream f55441b;

    /* renamed from: c */
    DataCallback f55442c;

    /* renamed from: d */
    boolean f55443d;

    /* renamed from: e */
    int f55444e = 0;

    /* renamed from: f */
    ByteBufferList f55445f = new ByteBufferList();

    /* renamed from: g */
    Runnable f55446g = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004d A[Catch:{ Exception -> 0x007e }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r0 = r0.f55445f     // Catch:{ Exception -> 0x007e }
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x007e }
                if (r0 != 0) goto L_0x0023
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.AsyncServer r0 = r0.getServer()     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter$2$1 r1 = new com.koushikdutta.async.stream.InputStreamDataEmitter$2$1     // Catch:{ Exception -> 0x007e }
                r1.<init>()     // Catch:{ Exception -> 0x007e }
                r0.run(r1)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r0 = r0.f55445f     // Catch:{ Exception -> 0x007e }
                boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x007e }
                if (r0 != 0) goto L_0x0023
                return
            L_0x0023:
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                int r0 = r0.f55444e     // Catch:{ Exception -> 0x007e }
                r1 = 4096(0x1000, float:5.74E-42)
                int r0 = java.lang.Math.max(r0, r1)     // Catch:{ Exception -> 0x007e }
                r1 = 262144(0x40000, float:3.67342E-40)
                int r0 = java.lang.Math.min(r0, r1)     // Catch:{ Exception -> 0x007e }
                java.nio.ByteBuffer r0 = com.koushikdutta.async.ByteBufferList.obtain(r0)     // Catch:{ Exception -> 0x007e }
                r1 = -1
                com.koushikdutta.async.stream.InputStreamDataEmitter r2 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                java.io.InputStream r2 = r2.f55441b     // Catch:{ Exception -> 0x007e }
                byte[] r3 = r0.array()     // Catch:{ Exception -> 0x007e }
                int r2 = r2.read(r3)     // Catch:{ Exception -> 0x007e }
                if (r1 != r2) goto L_0x004d
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                r1 = 0
                r0.m40004a(r1)     // Catch:{ Exception -> 0x007e }
                return
            L_0x004d:
                com.koushikdutta.async.stream.InputStreamDataEmitter r1 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                int r3 = r2 * 2
                r1.f55444e = r3     // Catch:{ Exception -> 0x007e }
                r0.limit(r2)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r1 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r1 = r1.f55445f     // Catch:{ Exception -> 0x007e }
                r1.add((java.nio.ByteBuffer) r0)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.AsyncServer r0 = r0.getServer()     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter$2$2 r1 = new com.koushikdutta.async.stream.InputStreamDataEmitter$2$2     // Catch:{ Exception -> 0x007e }
                r1.<init>()     // Catch:{ Exception -> 0x007e }
                r0.run(r1)     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                com.koushikdutta.async.ByteBufferList r0 = r0.f55445f     // Catch:{ Exception -> 0x007e }
                int r0 = r0.remaining()     // Catch:{ Exception -> 0x007e }
                if (r0 != 0) goto L_0x0084
                com.koushikdutta.async.stream.InputStreamDataEmitter r0 = com.koushikdutta.async.stream.InputStreamDataEmitter.this     // Catch:{ Exception -> 0x007e }
                boolean r0 = r0.isPaused()     // Catch:{ Exception -> 0x007e }
                if (r0 == 0) goto L_0x0023
                goto L_0x0084
            L_0x007e:
                r0 = move-exception
                com.koushikdutta.async.stream.InputStreamDataEmitter r1 = com.koushikdutta.async.stream.InputStreamDataEmitter.this
                r1.m40004a(r0)
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.stream.InputStreamDataEmitter.C202542.run():void");
        }
    };

    /* renamed from: h */
    CompletedCallback f55447h;

    public String charset() {
        return null;
    }

    public boolean isChunked() {
        return false;
    }

    public InputStreamDataEmitter(AsyncServer asyncServer, InputStream inputStream) {
        this.f55440a = asyncServer;
        this.f55441b = inputStream;
        m40002a();
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.f55442c = dataCallback;
    }

    public DataCallback getDataCallback() {
        return this.f55442c;
    }

    public void pause() {
        this.f55443d = true;
    }

    public void resume() {
        this.f55443d = false;
        m40002a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40004a(final Exception exc) {
        getServer().post(new Runnable() {
            public void run() {
                Exception e = exc;
                try {
                    InputStreamDataEmitter.this.f55441b.close();
                } catch (Exception e2) {
                    e = e2;
                }
                if (InputStreamDataEmitter.this.f55447h != null) {
                    InputStreamDataEmitter.this.f55447h.onCompleted(e);
                }
            }
        });
    }

    /* renamed from: a */
    private void m40002a() {
        new Thread(this.f55446g).start();
    }

    public boolean isPaused() {
        return this.f55443d;
    }

    public void setEndCallback(CompletedCallback completedCallback) {
        this.f55447h = completedCallback;
    }

    public CompletedCallback getEndCallback() {
        return this.f55447h;
    }

    public AsyncServer getServer() {
        return this.f55440a;
    }

    public void close() {
        m40004a((Exception) null);
        try {
            this.f55441b.close();
        } catch (Exception unused) {
        }
    }
}
