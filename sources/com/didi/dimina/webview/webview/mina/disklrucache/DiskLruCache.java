package com.didi.dimina.webview.webview.mina.disklrucache;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: B */
    public static final OutputStream f18438B = new OutputStream() {
        public void write(int i) throws IOException {
        }
    };

    /* renamed from: a */
    static final String f18439a = "journal";

    /* renamed from: b */
    static final String f18440b = "journal.tmp";

    /* renamed from: c */
    static final String f18441c = "journal.bkp";

    /* renamed from: d */
    static final String f18442d = "libcore.io.DiskLruCache";

    /* renamed from: e */
    static final String f18443e = "1";

    /* renamed from: f */
    static final long f18444f = -1;

    /* renamed from: g */
    static final String f18445g = "[A-Za-z0-9_-]{1,120}";

    /* renamed from: h */
    static final Pattern f18446h = Pattern.compile(f18445g);

    /* renamed from: j */
    private static final String f18447j = "CLEAN";

    /* renamed from: k */
    private static final String f18448k = "DIRTY";

    /* renamed from: l */
    private static final String f18449l = "REMOVE";

    /* renamed from: m */
    private static final String f18450m = "READ";

    /* renamed from: A */
    private final Callable<Void> f18451A = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r0 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r1 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f18461v     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r1 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m13707g()     // Catch:{ all -> 0x0028 }
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r1 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.m13704e()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r1 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m13701d()     // Catch:{ all -> 0x0028 }
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r1 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f18463x = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.C78221.call():java.lang.Void");
        }
    };

    /* renamed from: i */
    final ThreadPoolExecutor f18452i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final File f18453n;

    /* renamed from: o */
    private final File f18454o;

    /* renamed from: p */
    private final File f18455p;

    /* renamed from: q */
    private final File f18456q;

    /* renamed from: r */
    private final int f18457r;

    /* renamed from: s */
    private long f18458s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final int f18459t;

    /* renamed from: u */
    private long f18460u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Writer f18461v;

    /* renamed from: w */
    private final LinkedHashMap<String, Entry> f18462w = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f18463x;

    /* renamed from: y */
    private RemoveListener f18464y;

    /* renamed from: z */
    private long f18465z = 0;

    public interface RemoveListener {
        void onEntryRemoved(String str);
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        File file2 = file;
        this.f18453n = file2;
        this.f18457r = i;
        this.f18454o = new File(file2, "journal");
        this.f18455p = new File(file2, "journal.tmp");
        this.f18456q = new File(file2, "journal.bkp");
        this.f18459t = i2;
        this.f18458s = j;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m13693a(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.f18454o.exists()) {
                try {
                    diskLruCache.m13696b();
                    diskLruCache.m13699c();
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
            diskLruCache2.m13701d();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public void setEntryRemoveListener(RemoveListener removeListener) {
        this.f18464y = removeListener;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f18463x = r0 - r9.f18462w.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.mo58123b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        m13701d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f18461v = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f18454o, true), com.didi.dimina.webview.webview.mina.disklrucache.C7825b.f18473a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13696b() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.didi.dimina.webview.webview.mina.disklrucache.a r1 = new com.didi.dimina.webview.webview.mina.disklrucache.a
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f18454o
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.didi.dimina.webview.webview.mina.disklrucache.C7825b.f18473a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.mo58122a()     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = r1.mo58122a()     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = r1.mo58122a()     // Catch:{ all -> 0x00bb }
            java.lang.String r5 = r1.mo58122a()     // Catch:{ all -> 0x00bb }
            java.lang.String r6 = r1.mo58122a()     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00bb }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00bb }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f18457r     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00bb }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f18459t     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00bb }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.mo58122a()     // Catch:{ EOFException -> 0x005f }
            r9.m13694a((java.lang.String) r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry> r2 = r9.f18462w     // Catch:{ all -> 0x00bb }
            int r2 = r2.size()     // Catch:{ all -> 0x00bb }
            int r0 = r0 - r2
            r9.f18463x = r0     // Catch:{ all -> 0x00bb }
            boolean r0 = r1.mo58123b()     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x0072
            r9.m13701d()     // Catch:{ all -> 0x00bb }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00bb }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00bb }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bb }
            java.io.File r4 = r9.f18454o     // Catch:{ all -> 0x00bb }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00bb }
            java.nio.charset.Charset r4 = com.didi.dimina.webview.webview.mina.disklrucache.C7825b.f18473a     // Catch:{ all -> 0x00bb }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00bb }
            r0.<init>(r2)     // Catch:{ all -> 0x00bb }
            r9.f18461v = r0     // Catch:{ all -> 0x00bb }
        L_0x0088:
            com.didi.dimina.webview.webview.mina.disklrucache.C7825b.m13713a((java.io.Closeable) r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00bb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r7.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00bb }
            r7.append(r2)     // Catch:{ all -> 0x00bb }
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            r7.append(r3)     // Catch:{ all -> 0x00bb }
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            r7.append(r5)     // Catch:{ all -> 0x00bb }
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            r7.append(r6)     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00bb }
            r4.<init>(r0)     // Catch:{ all -> 0x00bb }
            throw r4     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            com.didi.dimina.webview.webview.mina.disklrucache.C7825b.m13713a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.m13696b():void");
    }

    /* renamed from: a */
    private void m13694a(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f18462w.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = this.f18462w.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.f18462w.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = entry.readable = true;
                Editor unused2 = entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                Editor unused3 = entry.currentEditor = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: c */
    private void m13699c() throws IOException {
        m13692a(this.f18455p);
        Iterator<Entry> it = this.f18462w.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.f18459t) {
                    this.f18460u += next.lengths[i];
                    i++;
                }
            } else {
                Editor unused = next.currentEditor = null;
                while (i < this.f18459t) {
                    m13692a(next.getCleanFile(i));
                    m13692a(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m13701d() throws IOException {
        if (this.f18461v != null) {
            this.f18461v.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f18455p), C7825b.f18473a));
        try {
            bufferedWriter.write(f18442d);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f18457r));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f18459t));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry next : this.f18462w.values()) {
                if (next.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + next.key + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.key + next.getLengths() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f18454o.exists()) {
                m13693a(this.f18454o, this.f18456q, true);
            }
            m13693a(this.f18455p, this.f18454o, false);
            this.f18456q.delete();
            this.f18461v = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f18454o, true), C7825b.f18473a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m13692a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m13693a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m13692a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.f18463x++;
        r11.f18461v.append("READ ").append(r12).append(java.lang.String.valueOf(10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (m13704e() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        r11.f18452i.submit(r11.f18451A);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        return new com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Snapshot(r11, r12, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Entry.access$1200(r0), r8, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Entry.access$1000(r0), (com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.C78221) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Snapshot get(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.m13706f()     // Catch:{ all -> 0x0081 }
            r11.m13698b((java.lang.String) r12)     // Catch:{ all -> 0x0081 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry> r0 = r11.f18462w     // Catch:{ all -> 0x0081 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0081 }
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r0 = (com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0081 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.readable     // Catch:{ all -> 0x0081 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.f18459t     // Catch:{ all -> 0x0081 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0081 }
            r2 = 0
            r3 = 0
        L_0x0022:
            int r4 = r11.f18459t     // Catch:{ FileNotFoundException -> 0x006f }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006f }
            java.io.File r5 = r0.getCleanFile(r3)     // Catch:{ FileNotFoundException -> 0x006f }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x006f }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x006f }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.f18463x     // Catch:{ all -> 0x0081 }
            int r1 = r1 + 1
            r11.f18463x = r1     // Catch:{ all -> 0x0081 }
            java.io.Writer r1 = r11.f18461v     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "READ "
            java.io.Writer r1 = r1.append(r2)     // Catch:{ all -> 0x0081 }
            java.io.Writer r1 = r1.append(r12)     // Catch:{ all -> 0x0081 }
            r2 = 10
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0081 }
            r1.append(r2)     // Catch:{ all -> 0x0081 }
            boolean r1 = r11.m13704e()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x005c
            java.util.concurrent.ThreadPoolExecutor r1 = r11.f18452i     // Catch:{ all -> 0x0081 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f18451A     // Catch:{ all -> 0x0081 }
            r1.submit(r2)     // Catch:{ all -> 0x0081 }
        L_0x005c:
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Snapshot r1 = new com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Snapshot     // Catch:{ all -> 0x0081 }
            long r6 = r0.sequenceNumber     // Catch:{ all -> 0x0081 }
            long[] r9 = r0.lengths     // Catch:{ all -> 0x0081 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r5, r6, r8, r9)     // Catch:{ all -> 0x0081 }
            monitor-exit(r11)
            return r1
        L_0x006f:
            int r12 = r11.f18459t     // Catch:{ all -> 0x0081 }
            if (r2 >= r12) goto L_0x007f
            r12 = r8[r2]     // Catch:{ all -> 0x0081 }
            if (r12 == 0) goto L_0x007f
            r12 = r8[r2]     // Catch:{ all -> 0x0081 }
            com.didi.dimina.webview.webview.mina.disklrucache.C7825b.m13713a((java.io.Closeable) r12)     // Catch:{ all -> 0x0081 }
            int r2 = r2 + 1
            goto L_0x006f
        L_0x007f:
            monitor-exit(r11)
            return r1
        L_0x0081:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.get(java.lang.String):com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Snapshot");
    }

    public Editor edit(String str) throws IOException {
        return m13686a(str, -1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Editor m13686a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m13706f()     // Catch:{ all -> 0x0061 }
            r5.m13698b((java.lang.String) r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry> r0 = r5.f18462w     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r0 = (com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r1 = r0.sequenceNumber     // Catch:{ all -> 0x0061 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r3
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r0 = new com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry     // Catch:{ all -> 0x0061 }
            r0.<init>(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry> r7 = r5.f18462w     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r3
        L_0x0037:
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor r7 = new com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x0061 }
            r7.<init>(r0)     // Catch:{ all -> 0x0061 }
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Editor unused = r0.currentEditor = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.f18461v     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.f18461v     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.m13686a(java.lang.String, long):com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor");
    }

    public File getDirectory() {
        return this.f18453n;
    }

    public synchronized long getMaxSize() {
        return this.f18458s;
    }

    public synchronized void setMaxSize(long j) {
        this.f18458s = j;
        this.f18452i.submit(this.f18451A);
    }

    public synchronized long size() {
        return this.f18460u;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m13690a(com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r0 = r10.entry     // Catch:{ all -> 0x0110 }
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x0110 }
            if (r1 != r10) goto L_0x010a
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.readable     // Catch:{ all -> 0x0110 }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f18459t     // Catch:{ all -> 0x0110 }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.written     // Catch:{ all -> 0x0110 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.getDirtyFile(r2)     // Catch:{ all -> 0x0110 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0110 }
            if (r3 != 0) goto L_0x0030
            r10.abort()     // Catch:{ all -> 0x0110 }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.abort()     // Catch:{ all -> 0x0110 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.<init>(r11)     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x004d:
            int r10 = r9.f18459t     // Catch:{ all -> 0x0110 }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.getDirtyFile(r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x0110 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x0110 }
            r3 = r10[r1]     // Catch:{ all -> 0x0110 }
            long r5 = r2.length()     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x0110 }
            r10[r1] = r5     // Catch:{ all -> 0x0110 }
            long r7 = r9.f18460u     // Catch:{ all -> 0x0110 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f18460u = r7     // Catch:{ all -> 0x0110 }
            goto L_0x007e
        L_0x007b:
            m13692a((java.io.File) r10)     // Catch:{ all -> 0x0110 }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f18463x     // Catch:{ all -> 0x0110 }
            r1 = 1
            int r10 = r10 + r1
            r9.f18463x = r10     // Catch:{ all -> 0x0110 }
            r10 = 0
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Editor unused = r0.currentEditor = r10     // Catch:{ all -> 0x0110 }
            boolean r10 = r0.readable     // Catch:{ all -> 0x0110 }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00c8
            boolean unused = r0.readable = r1     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f18461v     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r1.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "CLEAN "
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.key     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.getLengths()     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x00ee
            long r10 = r9.f18465z     // Catch:{ all -> 0x0110 }
            r1 = 1
            long r1 = r1 + r10
            r9.f18465z = r1     // Catch:{ all -> 0x0110 }
            long unused = r0.sequenceNumber = r10     // Catch:{ all -> 0x0110 }
            goto L_0x00ee
        L_0x00c8:
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry> r10 = r9.f18462w     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x0110 }
            r10.remove(r11)     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f18461v     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = "REMOVE "
            r11.append(r1)     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = r0.key     // Catch:{ all -> 0x0110 }
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r11)     // Catch:{ all -> 0x0110 }
        L_0x00ee:
            java.io.Writer r10 = r9.f18461v     // Catch:{ all -> 0x0110 }
            r10.flush()     // Catch:{ all -> 0x0110 }
            long r10 = r9.f18460u     // Catch:{ all -> 0x0110 }
            long r0 = r9.f18458s     // Catch:{ all -> 0x0110 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0101
            boolean r10 = r9.m13704e()     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x0108
        L_0x0101:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f18452i     // Catch:{ all -> 0x0110 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f18451A     // Catch:{ all -> 0x0110 }
            r10.submit(r11)     // Catch:{ all -> 0x0110 }
        L_0x0108:
            monitor-exit(r9)
            return
        L_0x010a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            r10.<init>()     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x0110:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.m13690a(com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m13704e() {
        int i = this.f18463x;
        return i >= 2000 && i >= this.f18462w.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m13706f()     // Catch:{ all -> 0x0096 }
            r7.m13698b((java.lang.String) r8)     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry> r0 = r7.f18462w     // Catch:{ all -> 0x0096 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0096 }
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r0 = (com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0096 }
            r1 = 0
            if (r0 == 0) goto L_0x0094
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor r2 = r0.currentEditor     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0094
        L_0x001a:
            int r2 = r7.f18459t     // Catch:{ all -> 0x0096 }
            if (r1 >= r2) goto L_0x005c
            java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x0096 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0096 }
            if (r3 == 0) goto L_0x0046
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0096 }
            if (r3 == 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r0.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0096 }
            r0.append(r2)     // Catch:{ all -> 0x0096 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0096 }
            r8.<init>(r0)     // Catch:{ all -> 0x0096 }
            throw r8     // Catch:{ all -> 0x0096 }
        L_0x0046:
            long r2 = r7.f18460u     // Catch:{ all -> 0x0096 }
            long[] r4 = r0.lengths     // Catch:{ all -> 0x0096 }
            r5 = r4[r1]     // Catch:{ all -> 0x0096 }
            long r2 = r2 - r5
            r7.f18460u = r2     // Catch:{ all -> 0x0096 }
            long[] r2 = r0.lengths     // Catch:{ all -> 0x0096 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0096 }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x005c:
            int r0 = r7.f18463x     // Catch:{ all -> 0x0096 }
            r1 = 1
            int r0 = r0 + r1
            r7.f18463x = r0     // Catch:{ all -> 0x0096 }
            java.io.Writer r0 = r7.f18461v     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "REMOVE "
            java.io.Writer r0 = r0.append(r2)     // Catch:{ all -> 0x0096 }
            java.io.Writer r0 = r0.append(r8)     // Catch:{ all -> 0x0096 }
            r2 = 10
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0096 }
            r0.append(r2)     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry> r0 = r7.f18462w     // Catch:{ all -> 0x0096 }
            r0.remove(r8)     // Catch:{ all -> 0x0096 }
            boolean r0 = r7.m13704e()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0089
            java.util.concurrent.ThreadPoolExecutor r0 = r7.f18452i     // Catch:{ all -> 0x0096 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r7.f18451A     // Catch:{ all -> 0x0096 }
            r0.submit(r2)     // Catch:{ all -> 0x0096 }
        L_0x0089:
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$RemoveListener r0 = r7.f18464y     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0092
            com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$RemoveListener r0 = r7.f18464y     // Catch:{ all -> 0x0096 }
            r0.onEntryRemoved(r8)     // Catch:{ all -> 0x0096 }
        L_0x0092:
            monitor-exit(r7)
            return r1
        L_0x0094:
            monitor-exit(r7)
            return r1
        L_0x0096:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized boolean isClosed() {
        return this.f18461v == null;
    }

    /* renamed from: f */
    private void m13706f() {
        if (this.f18461v == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        m13706f();
        m13707g();
        this.f18461v.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f18461v != null) {
            Iterator it = new ArrayList(this.f18462w.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            m13707g();
            this.f18461v.close();
            this.f18461v = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m13707g() throws IOException {
        while (this.f18460u > this.f18458s) {
            remove((String) this.f18462w.entrySet().iterator().next().getKey());
        }
    }

    public void delete() throws IOException {
        close();
        C7825b.m13714a(this.f18453n);
    }

    /* renamed from: b */
    private void m13698b(String str) {
        if (!f18446h.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [A-Za-z0-9_-]{1,120}: \"" + str + Const.jsQuote);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m13695b(InputStream inputStream) throws IOException {
        return C7825b.m13712a((Reader) new InputStreamReader(inputStream, C7825b.f18474b));
    }

    public final class Snapshot implements Closeable {
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Snapshot(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.ins = inputStreamArr;
            this.lengths = jArr;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.m13686a(this.key, this.sequenceNumber);
        }

        public InputStream getInputStream(int i) {
            return this.ins[i];
        }

        public String getString(int i) throws IOException {
            return DiskLruCache.m13695b(getInputStream(i));
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public void close() {
            for (InputStream a : this.ins) {
                C7825b.m13713a((Closeable) a);
            }
        }
    }

    public final class Editor {
        private boolean committed;
        /* access modifiers changed from: private */
        public final Entry entry;
        /* access modifiers changed from: private */
        public boolean hasErrors;
        /* access modifiers changed from: private */
        public final boolean[] written;

        private Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.f18459t];
        }

        public InputStream newInputStream(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (!this.entry.readable) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.entry.getCleanFile(i));
                        return fileInputStream;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        public String getString(int i) throws IOException {
            InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return DiskLruCache.m13695b(newInputStream);
            }
            return null;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream newOutputStream(int r4) throws java.io.IOException {
            /*
                r3 = this;
                if (r4 < 0) goto L_0x0053
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r0 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this
                int r0 = r0.f18459t
                if (r4 >= r0) goto L_0x0053
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r0 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0050 }
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0050 }
                if (r1 != r3) goto L_0x004a
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0050 }
                boolean r1 = r1.readable     // Catch:{ all -> 0x0050 }
                if (r1 != 0) goto L_0x0022
                boolean[] r1 = r3.written     // Catch:{ all -> 0x0050 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0050 }
            L_0x0022:
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0050 }
                java.io.File r4 = r1.getDirtyFile(r4)     // Catch:{ all -> 0x0050 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002e }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x002e }
                goto L_0x003c
            L_0x002e:
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r1 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0050 }
                java.io.File r1 = r1.f18453n     // Catch:{ all -> 0x0050 }
                r1.mkdirs()     // Catch:{ all -> 0x0050 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0044 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0044 }
            L_0x003c:
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream r4 = new com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream     // Catch:{ all -> 0x0050 }
                r2 = 0
                r4.<init>(r1)     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return r4
            L_0x0044:
                java.io.OutputStream r4 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.f18438B     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return r4
            L_0x004a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0050 }
                r4.<init>()     // Catch:{ all -> 0x0050 }
                throw r4     // Catch:{ all -> 0x0050 }
            L_0x0050:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r4
            L_0x0053:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Expected index "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = " to be greater than 0 and less than the maximum value count of "
                r1.append(r4)
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r4 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this
                int r4 = r4.f18459t
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Editor.newOutputStream(int):java.io.OutputStream");
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x003e */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0051 A[SYNTHETIC, Splitter:B:32:0x0051] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0058  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToFileOutputStream(int r4, java.io.ByteArrayOutputStream r5) throws java.io.IOException {
            /*
                r3 = this;
                if (r4 < 0) goto L_0x006d
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r0 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this
                int r0 = r0.f18459t
                if (r4 >= r0) goto L_0x006d
                if (r5 == 0) goto L_0x0065
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r0 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0062 }
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0062 }
                if (r1 != r3) goto L_0x005c
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0062 }
                boolean r1 = r1.readable     // Catch:{ all -> 0x0062 }
                if (r1 != 0) goto L_0x0024
                boolean[] r1 = r3.written     // Catch:{ all -> 0x0062 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0062 }
            L_0x0024:
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0062 }
                java.io.File r4 = r1.getDirtyFile(r4)     // Catch:{ all -> 0x0062 }
                r1 = 0
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003e }
                r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003e }
                r5.writeTo(r2)     // Catch:{ FileNotFoundException -> 0x003a, all -> 0x0037 }
                r2.close()     // Catch:{ all -> 0x0062 }
                goto L_0x0054
            L_0x0037:
                r4 = move-exception
                r1 = r2
                goto L_0x0056
            L_0x003a:
                r1 = r2
                goto L_0x003e
            L_0x003c:
                r4 = move-exception
                goto L_0x0056
            L_0x003e:
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r5 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x003c }
                java.io.File r5 = r5.f18453n     // Catch:{ all -> 0x003c }
                r5.mkdirs()     // Catch:{ all -> 0x003c }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004e }
                r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x004e }
                r1 = r5
                goto L_0x004f
            L_0x004e:
            L_0x004f:
                if (r1 == 0) goto L_0x0054
                r1.close()     // Catch:{ all -> 0x0062 }
            L_0x0054:
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                return
            L_0x0056:
                if (r1 == 0) goto L_0x005b
                r1.close()     // Catch:{ all -> 0x0062 }
            L_0x005b:
                throw r4     // Catch:{ all -> 0x0062 }
            L_0x005c:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0062 }
                r4.<init>()     // Catch:{ all -> 0x0062 }
                throw r4     // Catch:{ all -> 0x0062 }
            L_0x0062:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0062 }
                throw r4
            L_0x0065:
                java.lang.NullPointerException r4 = new java.lang.NullPointerException
                java.lang.String r5 = "newOutputStreamEx byteArrayOutputStream param is null!!!"
                r4.<init>(r5)
                throw r4
            L_0x006d:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Expected index "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = " to be greater than 0 and less than the maximum value count of "
                r0.append(r4)
                com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache r4 = com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.this
                int r4 = r4.f18459t
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.webview.webview.mina.disklrucache.DiskLruCache.Editor.writeToFileOutputStream(int, java.io.ByteArrayOutputStream):void");
        }

        public void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(newOutputStream(i), C7825b.f18474b);
                try {
                    outputStreamWriter2.write(str);
                    C7825b.m13713a((Closeable) outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    C7825b.m13713a((Closeable) outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C7825b.m13713a((Closeable) outputStreamWriter);
                throw th;
            }
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.m13690a(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.m13690a(this, true);
            }
            this.committed = true;
        }

        public void abort() throws IOException {
            DiskLruCache.this.m13690a(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.committed) {
                try {
                    abort();
                } catch (IOException unused) {
                }
            }
        }

        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.hasErrors = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.hasErrors = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.hasErrors = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = Editor.this.hasErrors = true;
                }
            }
        }
    }

    private final class Entry {
        /* access modifiers changed from: private */
        public Editor currentEditor;
        /* access modifiers changed from: private */
        public final String key;
        /* access modifiers changed from: private */
        public final long[] lengths;
        /* access modifiers changed from: private */
        public boolean readable;
        /* access modifiers changed from: private */
        public long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.f18459t];
        }

        public String getLengths() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.lengths) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f18459t) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.lengths[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
                return;
            }
            throw invalidLengths(strArr);
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File getCleanFile(int i) {
            File f = DiskLruCache.this.f18453n;
            return new File(f, this.key + "." + i);
        }

        public File getDirtyFile(int i) {
            File f = DiskLruCache.this.f18453n;
            return new File(f, this.key + "." + i + DefaultDiskStorage.FileType.TEMP);
        }
    }
}
