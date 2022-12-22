package didihttp.internal.cache2;

import didihttp.internal.C20747Util;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay {

    /* renamed from: a */
    static final ByteString f56627a = ByteString.encodeUtf8("OkHttp cache v1\n");

    /* renamed from: b */
    static final ByteString f56628b = ByteString.encodeUtf8("OkHttp DIRTY :(\n");

    /* renamed from: l */
    private static final int f56629l = 1;

    /* renamed from: m */
    private static final int f56630m = 2;

    /* renamed from: n */
    private static final long f56631n = 32;

    /* renamed from: c */
    RandomAccessFile f56632c;

    /* renamed from: d */
    Thread f56633d;

    /* renamed from: e */
    Source f56634e;

    /* renamed from: f */
    final Buffer f56635f = new Buffer();

    /* renamed from: g */
    long f56636g;

    /* renamed from: h */
    boolean f56637h;

    /* renamed from: i */
    final Buffer f56638i = new Buffer();

    /* renamed from: j */
    final long f56639j;

    /* renamed from: k */
    int f56640k;

    /* renamed from: o */
    private final ByteString f56641o;

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.f56632c = randomAccessFile;
        this.f56634e = source;
        this.f56637h = source == null;
        this.f56636g = j;
        this.f56641o = byteString;
        this.f56639j = j2;
    }

    /* renamed from: a */
    public static Relay m40670a(File file, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j);
        randomAccessFile.setLength(0);
        relay.m40671a(f56628b, -1, -1);
        return relay;
    }

    /* renamed from: a */
    public static Relay m40669a(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        C20756a aVar = new C20756a(randomAccessFile.getChannel());
        Buffer buffer = new Buffer();
        aVar.mo170003b(0, buffer, 32);
        if (buffer.readByteString((long) f56627a.size()).equals(f56627a)) {
            long readLong = buffer.readLong();
            long readLong2 = buffer.readLong();
            Buffer buffer2 = new Buffer();
            aVar.mo170003b(readLong + 32, buffer2, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer2.readByteString(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    /* renamed from: a */
    private void m40671a(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.writeLong(j);
        buffer.writeLong(j2);
        if (buffer.size() == 32) {
            new C20756a(this.f56632c.getChannel()).mo170002a(0, buffer, 32);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    private void m40672b(long j) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.f56641o);
        new C20756a(this.f56632c.getChannel()).mo170002a(32 + j, buffer, (long) this.f56641o.size());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169998a(long j) throws IOException {
        m40672b(j);
        this.f56632c.getChannel().force(false);
        m40671a(f56627a, j, (long) this.f56641o.size());
        this.f56632c.getChannel().force(false);
        synchronized (this) {
            this.f56637h = true;
        }
        C20747Util.closeQuietly((Closeable) this.f56634e);
        this.f56634e = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo169999a() {
        return this.f56632c == null;
    }

    /* renamed from: b */
    public ByteString mo170000b() {
        return this.f56641o;
    }

    /* renamed from: c */
    public Source mo170001c() {
        synchronized (this) {
            if (this.f56632c == null) {
                return null;
            }
            this.f56640k++;
            return new RelaySource();
        }
    }

    class RelaySource implements Source {
        private C20756a fileOperator = new C20756a(Relay.this.f56632c.getChannel());
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            r5 = r7 - r1.this$0.f56638i.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
            if (r1.sourcePos >= r5) goto L_0x011b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r1.sourcePos);
            r1.this$0.f56638i.copyTo(r22, r1.sourcePos - r5, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0136, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                r21 = this;
                r1 = r21
                r2 = r23
                didihttp.internal.cache2.a r0 = r1.fileOperator
                if (r0 == 0) goto L_0x013a
                didihttp.internal.cache2.Relay r4 = didihttp.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0137 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0137 }
                long r7 = r0.f56636g     // Catch:{ all -> 0x0137 }
                r0 = 2
                r9 = -1
                int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r11 != 0) goto L_0x0039
                didihttp.internal.cache2.Relay r5 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0137 }
                boolean r5 = r5.f56637h     // Catch:{ all -> 0x0137 }
                if (r5 == 0) goto L_0x0020
                monitor-exit(r4)     // Catch:{ all -> 0x0137 }
                return r9
            L_0x0020:
                didihttp.internal.cache2.Relay r5 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0137 }
                java.lang.Thread r5 = r5.f56633d     // Catch:{ all -> 0x0137 }
                if (r5 == 0) goto L_0x002e
                okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0137 }
                didihttp.internal.cache2.Relay r5 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0137 }
                r0.waitUntilNotified(r5)     // Catch:{ all -> 0x0137 }
                goto L_0x000b
            L_0x002e:
                didihttp.internal.cache2.Relay r5 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0137 }
                java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0137 }
                r5.f56633d = r6     // Catch:{ all -> 0x0137 }
                r5 = 1
                monitor-exit(r4)     // Catch:{ all -> 0x0137 }
                goto L_0x004b
            L_0x0039:
                didihttp.internal.cache2.Relay r5 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0137 }
                okio.Buffer r5 = r5.f56638i     // Catch:{ all -> 0x0137 }
                long r5 = r5.size()     // Catch:{ all -> 0x0137 }
                long r5 = r7 - r5
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0137 }
                int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r13 >= 0) goto L_0x011b
                monitor-exit(r4)     // Catch:{ all -> 0x0137 }
                r5 = 2
            L_0x004b:
                r11 = 32
                if (r5 != r0) goto L_0x0069
                long r4 = r1.sourcePos
                long r7 = r7 - r4
                long r2 = java.lang.Math.min(r2, r7)
                didihttp.internal.cache2.a r13 = r1.fileOperator
                long r4 = r1.sourcePos
                long r14 = r4 + r11
                r16 = r22
                r17 = r2
                r13.mo170003b(r14, r16, r17)
                long r4 = r1.sourcePos
                long r4 = r4 + r2
                r1.sourcePos = r4
                return r2
            L_0x0069:
                r4 = 0
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                okio.Source r0 = r0.f56634e     // Catch:{ all -> 0x0109 }
                didihttp.internal.cache2.Relay r5 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                okio.Buffer r5 = r5.f56635f     // Catch:{ all -> 0x0109 }
                didihttp.internal.cache2.Relay r6 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                long r13 = r6.f56639j     // Catch:{ all -> 0x0109 }
                long r5 = r0.read(r5, r13)     // Catch:{ all -> 0x0109 }
                int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x0094
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                r0.mo169998a((long) r7)     // Catch:{ all -> 0x0109 }
                didihttp.internal.cache2.Relay r2 = didihttp.internal.cache2.Relay.this
                monitor-enter(r2)
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0091 }
                r0.f56633d = r4     // Catch:{ all -> 0x0091 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0091 }
                r0.notifyAll()     // Catch:{ all -> 0x0091 }
                monitor-exit(r2)     // Catch:{ all -> 0x0091 }
                return r9
            L_0x0091:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0091 }
                throw r0
            L_0x0094:
                long r2 = java.lang.Math.min(r5, r2)     // Catch:{ all -> 0x0109 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                okio.Buffer r13 = r0.f56635f     // Catch:{ all -> 0x0109 }
                r15 = 0
                r14 = r22
                r17 = r2
                r13.copyTo((okio.Buffer) r14, (long) r15, (long) r17)     // Catch:{ all -> 0x0109 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0109 }
                long r9 = r9 + r2
                r1.sourcePos = r9     // Catch:{ all -> 0x0109 }
                didihttp.internal.cache2.a r15 = r1.fileOperator     // Catch:{ all -> 0x0109 }
                long r16 = r7 + r11
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                okio.Buffer r0 = r0.f56635f     // Catch:{ all -> 0x0109 }
                okio.Buffer r18 = r0.clone()     // Catch:{ all -> 0x0109 }
                r19 = r5
                r15.mo170002a(r16, r18, r19)     // Catch:{ all -> 0x0109 }
                didihttp.internal.cache2.Relay r7 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0109 }
                monitor-enter(r7)     // Catch:{ all -> 0x0109 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                okio.Buffer r0 = r0.f56638i     // Catch:{ all -> 0x0106 }
                didihttp.internal.cache2.Relay r8 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                okio.Buffer r8 = r8.f56635f     // Catch:{ all -> 0x0106 }
                r0.write((okio.Buffer) r8, (long) r5)     // Catch:{ all -> 0x0106 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                okio.Buffer r0 = r0.f56638i     // Catch:{ all -> 0x0106 }
                long r8 = r0.size()     // Catch:{ all -> 0x0106 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                long r10 = r0.f56639j     // Catch:{ all -> 0x0106 }
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 <= 0) goto L_0x00ed
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                okio.Buffer r0 = r0.f56638i     // Catch:{ all -> 0x0106 }
                didihttp.internal.cache2.Relay r8 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                okio.Buffer r8 = r8.f56638i     // Catch:{ all -> 0x0106 }
                long r8 = r8.size()     // Catch:{ all -> 0x0106 }
                didihttp.internal.cache2.Relay r10 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                long r10 = r10.f56639j     // Catch:{ all -> 0x0106 }
                long r8 = r8 - r10
                r0.skip(r8)     // Catch:{ all -> 0x0106 }
            L_0x00ed:
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0106 }
                long r8 = r0.f56636g     // Catch:{ all -> 0x0106 }
                long r8 = r8 + r5
                r0.f56636g = r8     // Catch:{ all -> 0x0106 }
                monitor-exit(r7)     // Catch:{ all -> 0x0106 }
                didihttp.internal.cache2.Relay r5 = didihttp.internal.cache2.Relay.this
                monitor-enter(r5)
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0103 }
                r0.f56633d = r4     // Catch:{ all -> 0x0103 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0103 }
                r0.notifyAll()     // Catch:{ all -> 0x0103 }
                monitor-exit(r5)     // Catch:{ all -> 0x0103 }
                return r2
            L_0x0103:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0103 }
                throw r0
            L_0x0106:
                r0 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0106 }
                throw r0     // Catch:{ all -> 0x0109 }
            L_0x0109:
                r0 = move-exception
                didihttp.internal.cache2.Relay r2 = didihttp.internal.cache2.Relay.this
                monitor-enter(r2)
                didihttp.internal.cache2.Relay r3 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                r3.f56633d = r4     // Catch:{ all -> 0x0118 }
                didihttp.internal.cache2.Relay r3 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0118 }
                r3.notifyAll()     // Catch:{ all -> 0x0118 }
                monitor-exit(r2)     // Catch:{ all -> 0x0118 }
                throw r0
            L_0x0118:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0118 }
                throw r0
            L_0x011b:
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0137 }
                long r7 = r7 - r9
                long r2 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0137 }
                didihttp.internal.cache2.Relay r0 = didihttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0137 }
                okio.Buffer r9 = r0.f56638i     // Catch:{ all -> 0x0137 }
                long r7 = r1.sourcePos     // Catch:{ all -> 0x0137 }
                long r11 = r7 - r5
                r10 = r22
                r13 = r2
                r9.copyTo((okio.Buffer) r10, (long) r11, (long) r13)     // Catch:{ all -> 0x0137 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0137 }
                long r5 = r5 + r2
                r1.sourcePos = r5     // Catch:{ all -> 0x0137 }
                monitor-exit(r4)     // Catch:{ all -> 0x0137 }
                return r2
            L_0x0137:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0137 }
                throw r0
            L_0x013a:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.f56640k--;
                    if (Relay.this.f56640k == 0) {
                        RandomAccessFile randomAccessFile2 = Relay.this.f56632c;
                        Relay.this.f56632c = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    C20747Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }
    }
}
