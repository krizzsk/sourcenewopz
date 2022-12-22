package com.jakewharton.disklrucache;

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
    public static final OutputStream f54459B = new OutputStream() {
        public void write(int i) throws IOException {
        }
    };

    /* renamed from: a */
    static final String f54460a = "journal";

    /* renamed from: b */
    static final String f54461b = "journal.tmp";

    /* renamed from: c */
    static final String f54462c = "journal.bkp";

    /* renamed from: d */
    static final String f54463d = "libcore.io.DiskLruCache";

    /* renamed from: e */
    static final String f54464e = "1";

    /* renamed from: f */
    static final long f54465f = -1;

    /* renamed from: g */
    static final String f54466g = "[A-Za-z0-9_-]{1,120}";

    /* renamed from: h */
    static final Pattern f54467h = Pattern.compile(f54466g);

    /* renamed from: j */
    private static final String f54468j = "CLEAN";

    /* renamed from: k */
    private static final String f54469k = "DIRTY";

    /* renamed from: l */
    private static final String f54470l = "REMOVE";

    /* renamed from: m */
    private static final String f54471m = "READ";

    /* renamed from: A */
    private final Callable<Void> f54472A = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f54482v     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m39411g()     // Catch:{ all -> 0x0028 }
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.m39408e()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r1.m39405d()     // Catch:{ all -> 0x0028 }
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f54484x = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.C199321.call():java.lang.Void");
        }
    };

    /* renamed from: i */
    final ThreadPoolExecutor f54473i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final File f54474n;

    /* renamed from: o */
    private final File f54475o;

    /* renamed from: p */
    private final File f54476p;

    /* renamed from: q */
    private final File f54477q;

    /* renamed from: r */
    private final int f54478r;

    /* renamed from: s */
    private long f54479s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final int f54480t;

    /* renamed from: u */
    private long f54481u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Writer f54482v;

    /* renamed from: w */
    private final LinkedHashMap<String, Entry> f54483w = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f54484x;

    /* renamed from: y */
    private RemoveListener f54485y;

    /* renamed from: z */
    private long f54486z = 0;

    public interface RemoveListener {
        void onEntryRemoved(String str);
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        File file2 = file;
        this.f54474n = file2;
        this.f54478r = i;
        this.f54475o = new File(file2, "journal");
        this.f54476p = new File(file2, "journal.tmp");
        this.f54477q = new File(file2, "journal.bkp");
        this.f54480t = i2;
        this.f54479s = j;
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
                    m39397a(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.f54475o.exists()) {
                try {
                    diskLruCache.m39400b();
                    diskLruCache.m39403c();
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
            diskLruCache2.m39405d();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public void setEntryRemoveListener(RemoveListener removeListener) {
        this.f54485y = removeListener;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f54484x = r0 - r9.f54483w.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.mo162257b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        m39405d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f54482v = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f54475o, true), com.jakewharton.disklrucache.C19935b.f54494a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m39400b() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.jakewharton.disklrucache.a r1 = new com.jakewharton.disklrucache.a
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f54475o
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.jakewharton.disklrucache.C19935b.f54494a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.mo162256a()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.mo162256a()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.mo162256a()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.mo162256a()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.mo162256a()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f54478r     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f54480t     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.mo162256a()     // Catch:{ EOFException -> 0x005f }
            r9.m39398a((java.lang.String) r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r2 = r9.f54483w     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.f54484x = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.mo162257b()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.m39405d()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f54475o     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = com.jakewharton.disklrucache.C19935b.f54494a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f54482v = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            com.jakewharton.disklrucache.C19935b.m39417a((java.io.Closeable) r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            com.jakewharton.disklrucache.C19935b.m39417a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.m39400b():void");
    }

    /* renamed from: a */
    private void m39398a(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f54483w.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = this.f54483w.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.f54483w.put(str2, entry);
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
    private void m39403c() throws IOException {
        m39396a(this.f54476p);
        Iterator<Entry> it = this.f54483w.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.f54480t) {
                    this.f54481u += next.lengths[i];
                    i++;
                }
            } else {
                Editor unused = next.currentEditor = null;
                while (i < this.f54480t) {
                    m39396a(next.getCleanFile(i));
                    m39396a(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m39405d() throws IOException {
        if (this.f54482v != null) {
            this.f54482v.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f54476p), C19935b.f54494a));
        try {
            bufferedWriter.write(f54463d);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f54478r));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f54480t));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry next : this.f54483w.values()) {
                if (next.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + next.key + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.key + next.getLengths() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f54475o.exists()) {
                m39397a(this.f54475o, this.f54477q, true);
            }
            m39397a(this.f54476p, this.f54475o, false);
            this.f54477q.delete();
            this.f54482v = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f54475o, true), C19935b.f54494a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m39396a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m39397a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m39396a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.f54484x++;
        r11.f54482v.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        if (m39408e() == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r11.f54473i.submit(r11.f54472A);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        return new com.jakewharton.disklrucache.DiskLruCache.Snapshot(r11, r12, com.jakewharton.disklrucache.DiskLruCache.Entry.access$1200(r0), r8, com.jakewharton.disklrucache.DiskLruCache.Entry.access$1000(r0), (com.jakewharton.disklrucache.DiskLruCache.C199321) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.jakewharton.disklrucache.DiskLruCache.Snapshot get(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.m39410f()     // Catch:{ all -> 0x0087 }
            r11.m39402b((java.lang.String) r12)     // Catch:{ all -> 0x0087 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r11.f54483w     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0087 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.readable     // Catch:{ all -> 0x0087 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.f54480t     // Catch:{ all -> 0x0087 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0087 }
            r2 = 0
            r3 = 0
        L_0x0022:
            int r4 = r11.f54480t     // Catch:{ FileNotFoundException -> 0x0075 }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0075 }
            java.io.File r5 = r0.getCleanFile(r3)     // Catch:{ FileNotFoundException -> 0x0075 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0075 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0075 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.f54484x     // Catch:{ all -> 0x0087 }
            int r1 = r1 + 1
            r11.f54484x = r1     // Catch:{ all -> 0x0087 }
            java.io.Writer r1 = r11.f54482v     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r2.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            r2.append(r12)     // Catch:{ all -> 0x0087 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            boolean r1 = r11.m39408e()     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0062
            java.util.concurrent.ThreadPoolExecutor r1 = r11.f54473i     // Catch:{ all -> 0x0087 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f54472A     // Catch:{ all -> 0x0087 }
            r1.submit(r2)     // Catch:{ all -> 0x0087 }
        L_0x0062:
            com.jakewharton.disklrucache.DiskLruCache$Snapshot r1 = new com.jakewharton.disklrucache.DiskLruCache$Snapshot     // Catch:{ all -> 0x0087 }
            long r6 = r0.sequenceNumber     // Catch:{ all -> 0x0087 }
            long[] r9 = r0.lengths     // Catch:{ all -> 0x0087 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r5, r6, r8, r9)     // Catch:{ all -> 0x0087 }
            monitor-exit(r11)
            return r1
        L_0x0075:
            int r12 = r11.f54480t     // Catch:{ all -> 0x0087 }
            if (r2 >= r12) goto L_0x0085
            r12 = r8[r2]     // Catch:{ all -> 0x0087 }
            if (r12 == 0) goto L_0x0085
            r12 = r8[r2]     // Catch:{ all -> 0x0087 }
            com.jakewharton.disklrucache.C19935b.m39417a((java.io.Closeable) r12)     // Catch:{ all -> 0x0087 }
            int r2 = r2 + 1
            goto L_0x0075
        L_0x0085:
            monitor-exit(r11)
            return r1
        L_0x0087:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.get(java.lang.String):com.jakewharton.disklrucache.DiskLruCache$Snapshot");
    }

    public Editor edit(String str) throws IOException {
        return m39390a(str, -1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.jakewharton.disklrucache.DiskLruCache.Editor m39390a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m39410f()     // Catch:{ all -> 0x0061 }
            r5.m39402b((java.lang.String) r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r5.f54483w     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0061 }
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
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = new com.jakewharton.disklrucache.DiskLruCache$Entry     // Catch:{ all -> 0x0061 }
            r0.<init>(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r7 = r5.f54483w     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            com.jakewharton.disklrucache.DiskLruCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r3
        L_0x0037:
            com.jakewharton.disklrucache.DiskLruCache$Editor r7 = new com.jakewharton.disklrucache.DiskLruCache$Editor     // Catch:{ all -> 0x0061 }
            r7.<init>(r0)     // Catch:{ all -> 0x0061 }
            com.jakewharton.disklrucache.DiskLruCache.Editor unused = r0.currentEditor = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.f54482v     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.f54482v     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.m39390a(java.lang.String, long):com.jakewharton.disklrucache.DiskLruCache$Editor");
    }

    public File getDirectory() {
        return this.f54474n;
    }

    public synchronized long getMaxSize() {
        return this.f54479s;
    }

    public synchronized void setMaxSize(long j) {
        this.f54479s = j;
        this.f54473i.submit(this.f54472A);
    }

    public synchronized long size() {
        return this.f54481u;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m39394a(com.jakewharton.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = r10.entry     // Catch:{ all -> 0x0110 }
            com.jakewharton.disklrucache.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x0110 }
            if (r1 != r10) goto L_0x010a
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.readable     // Catch:{ all -> 0x0110 }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f54480t     // Catch:{ all -> 0x0110 }
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
            int r10 = r9.f54480t     // Catch:{ all -> 0x0110 }
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
            long r7 = r9.f54481u     // Catch:{ all -> 0x0110 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f54481u = r7     // Catch:{ all -> 0x0110 }
            goto L_0x007e
        L_0x007b:
            m39396a((java.io.File) r10)     // Catch:{ all -> 0x0110 }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f54484x     // Catch:{ all -> 0x0110 }
            r1 = 1
            int r10 = r10 + r1
            r9.f54484x = r10     // Catch:{ all -> 0x0110 }
            r10 = 0
            com.jakewharton.disklrucache.DiskLruCache.Editor unused = r0.currentEditor = r10     // Catch:{ all -> 0x0110 }
            boolean r10 = r0.readable     // Catch:{ all -> 0x0110 }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00c8
            boolean unused = r0.readable = r1     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f54482v     // Catch:{ all -> 0x0110 }
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
            long r10 = r9.f54486z     // Catch:{ all -> 0x0110 }
            r1 = 1
            long r1 = r1 + r10
            r9.f54486z = r1     // Catch:{ all -> 0x0110 }
            long unused = r0.sequenceNumber = r10     // Catch:{ all -> 0x0110 }
            goto L_0x00ee
        L_0x00c8:
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r10 = r9.f54483w     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x0110 }
            r10.remove(r11)     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f54482v     // Catch:{ all -> 0x0110 }
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
            java.io.Writer r10 = r9.f54482v     // Catch:{ all -> 0x0110 }
            r10.flush()     // Catch:{ all -> 0x0110 }
            long r10 = r9.f54481u     // Catch:{ all -> 0x0110 }
            long r0 = r9.f54479s     // Catch:{ all -> 0x0110 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0101
            boolean r10 = r9.m39408e()     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x0108
        L_0x0101:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f54473i     // Catch:{ all -> 0x0110 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f54472A     // Catch:{ all -> 0x0110 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.m39394a(com.jakewharton.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m39408e() {
        int i = this.f54484x;
        return i >= 2000 && i >= this.f54483w.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0099, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m39410f()     // Catch:{ all -> 0x009c }
            r7.m39402b((java.lang.String) r8)     // Catch:{ all -> 0x009c }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r7.f54483w     // Catch:{ all -> 0x009c }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x009c }
            com.jakewharton.disklrucache.DiskLruCache$Entry r0 = (com.jakewharton.disklrucache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x009c }
            r1 = 0
            if (r0 == 0) goto L_0x009a
            com.jakewharton.disklrucache.DiskLruCache$Editor r2 = r0.currentEditor     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x001a
            goto L_0x009a
        L_0x001a:
            int r2 = r7.f54480t     // Catch:{ all -> 0x009c }
            if (r1 >= r2) goto L_0x005c
            java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x009c }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x0046
            boolean r3 = r2.delete()     // Catch:{ all -> 0x009c }
            if (r3 == 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x009c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r0.<init>()     // Catch:{ all -> 0x009c }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x009c }
            r0.append(r2)     // Catch:{ all -> 0x009c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x009c }
            r8.<init>(r0)     // Catch:{ all -> 0x009c }
            throw r8     // Catch:{ all -> 0x009c }
        L_0x0046:
            long r2 = r7.f54481u     // Catch:{ all -> 0x009c }
            long[] r4 = r0.lengths     // Catch:{ all -> 0x009c }
            r5 = r4[r1]     // Catch:{ all -> 0x009c }
            long r2 = r2 - r5
            r7.f54481u = r2     // Catch:{ all -> 0x009c }
            long[] r2 = r0.lengths     // Catch:{ all -> 0x009c }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x009c }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x005c:
            int r0 = r7.f54484x     // Catch:{ all -> 0x009c }
            r1 = 1
            int r0 = r0 + r1
            r7.f54484x = r0     // Catch:{ all -> 0x009c }
            java.io.Writer r0 = r7.f54482v     // Catch:{ all -> 0x009c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r2.<init>()     // Catch:{ all -> 0x009c }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x009c }
            r2.append(r8)     // Catch:{ all -> 0x009c }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x009c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x009c }
            r0.append(r2)     // Catch:{ all -> 0x009c }
            java.util.LinkedHashMap<java.lang.String, com.jakewharton.disklrucache.DiskLruCache$Entry> r0 = r7.f54483w     // Catch:{ all -> 0x009c }
            r0.remove(r8)     // Catch:{ all -> 0x009c }
            boolean r0 = r7.m39408e()     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x008f
            java.util.concurrent.ThreadPoolExecutor r0 = r7.f54473i     // Catch:{ all -> 0x009c }
            java.util.concurrent.Callable<java.lang.Void> r2 = r7.f54472A     // Catch:{ all -> 0x009c }
            r0.submit(r2)     // Catch:{ all -> 0x009c }
        L_0x008f:
            com.jakewharton.disklrucache.DiskLruCache$RemoveListener r0 = r7.f54485y     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0098
            com.jakewharton.disklrucache.DiskLruCache$RemoveListener r0 = r7.f54485y     // Catch:{ all -> 0x009c }
            r0.onEntryRemoved(r8)     // Catch:{ all -> 0x009c }
        L_0x0098:
            monitor-exit(r7)
            return r1
        L_0x009a:
            monitor-exit(r7)
            return r1
        L_0x009c:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public synchronized boolean isClosed() {
        return this.f54482v == null;
    }

    /* renamed from: f */
    private void m39410f() {
        if (this.f54482v == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        m39410f();
        m39411g();
        this.f54482v.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f54482v != null) {
            Iterator it = new ArrayList(this.f54483w.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            m39411g();
            this.f54482v.close();
            this.f54482v = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m39411g() throws IOException {
        while (this.f54481u > this.f54479s) {
            remove((String) this.f54483w.entrySet().iterator().next().getKey());
        }
    }

    public void delete() throws IOException {
        close();
        C19935b.m39418a(this.f54474n);
    }

    /* renamed from: b */
    private void m39402b(String str) {
        if (!f54467h.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [A-Za-z0-9_-]{1,120}: \"" + str + Const.jsQuote);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m39399b(InputStream inputStream) throws IOException {
        return C19935b.m39416a((Reader) new InputStreamReader(inputStream, C19935b.f54495b));
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
            return DiskLruCache.this.m39390a(this.key, this.sequenceNumber);
        }

        public InputStream getInputStream(int i) {
            return this.ins[i];
        }

        public String getString(int i) throws IOException {
            return DiskLruCache.m39399b(getInputStream(i));
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public void close() {
            for (InputStream a : this.ins) {
                C19935b.m39417a((Closeable) a);
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
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.f54480t];
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
                return DiskLruCache.m39399b(newInputStream);
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
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                int r0 = r0.f54480t
                if (r4 >= r0) goto L_0x0053
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0050 }
                com.jakewharton.disklrucache.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0050 }
                if (r1 != r3) goto L_0x004a
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0050 }
                boolean r1 = r1.readable     // Catch:{ all -> 0x0050 }
                if (r1 != 0) goto L_0x0022
                boolean[] r1 = r3.written     // Catch:{ all -> 0x0050 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0050 }
            L_0x0022:
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0050 }
                java.io.File r4 = r1.getDirtyFile(r4)     // Catch:{ all -> 0x0050 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002e }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x002e }
                goto L_0x003c
            L_0x002e:
                com.jakewharton.disklrucache.DiskLruCache r1 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0050 }
                java.io.File r1 = r1.f54474n     // Catch:{ all -> 0x0050 }
                r1.mkdirs()     // Catch:{ all -> 0x0050 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0044 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0044 }
            L_0x003c:
                com.jakewharton.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream r4 = new com.jakewharton.disklrucache.DiskLruCache$Editor$FaultHidingOutputStream     // Catch:{ all -> 0x0050 }
                r2 = 0
                r4.<init>(r1)     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return r4
            L_0x0044:
                java.io.OutputStream r4 = com.jakewharton.disklrucache.DiskLruCache.f54459B     // Catch:{ all -> 0x0050 }
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
                com.jakewharton.disklrucache.DiskLruCache r4 = com.jakewharton.disklrucache.DiskLruCache.this
                int r4 = r4.f54480t
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.newOutputStream(int):java.io.OutputStream");
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
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                int r0 = r0.f54480t
                if (r4 >= r0) goto L_0x006d
                if (r5 == 0) goto L_0x0065
                com.jakewharton.disklrucache.DiskLruCache r0 = com.jakewharton.disklrucache.DiskLruCache.this
                monitor-enter(r0)
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0062 }
                com.jakewharton.disklrucache.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0062 }
                if (r1 != r3) goto L_0x005c
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0062 }
                boolean r1 = r1.readable     // Catch:{ all -> 0x0062 }
                if (r1 != 0) goto L_0x0024
                boolean[] r1 = r3.written     // Catch:{ all -> 0x0062 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0062 }
            L_0x0024:
                com.jakewharton.disklrucache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0062 }
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
                com.jakewharton.disklrucache.DiskLruCache r5 = com.jakewharton.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x003c }
                java.io.File r5 = r5.f54474n     // Catch:{ all -> 0x003c }
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
                com.jakewharton.disklrucache.DiskLruCache r4 = com.jakewharton.disklrucache.DiskLruCache.this
                int r4 = r4.f54480t
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.disklrucache.DiskLruCache.Editor.writeToFileOutputStream(int, java.io.ByteArrayOutputStream):void");
        }

        public void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(newOutputStream(i), C19935b.f54495b);
                try {
                    outputStreamWriter2.write(str);
                    C19935b.m39417a((Closeable) outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    C19935b.m39417a((Closeable) outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C19935b.m39417a((Closeable) outputStreamWriter);
                throw th;
            }
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.m39394a(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.m39394a(this, true);
            }
            this.committed = true;
        }

        public void abort() throws IOException {
            DiskLruCache.this.m39394a(this, false);
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
            this.lengths = new long[DiskLruCache.this.f54480t];
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
            if (strArr.length == DiskLruCache.this.f54480t) {
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
            File f = DiskLruCache.this.f54474n;
            return new File(f, this.key + "." + i);
        }

        public File getDirtyFile(int i) {
            File f = DiskLruCache.this.f54474n;
            return new File(f, this.key + "." + i + DefaultDiskStorage.FileType.TEMP);
        }
    }
}
