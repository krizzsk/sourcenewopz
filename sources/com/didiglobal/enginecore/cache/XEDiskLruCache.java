package com.didiglobal.enginecore.cache;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.enginecore.cache.concurrent.TaskQueue;
import com.didiglobal.enginecore.cache.concurrent.TaskRunner;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\u0013\b\u0000\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0004TUVWB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0016J!\u00106\u001a\u0002042\n\u00107\u001a\u000608R\u00020\u00002\u0006\u00109\u001a\u00020\u000fH\u0000¢\u0006\u0002\b:J\u0006\u0010;\u001a\u000204J \u0010<\u001a\b\u0018\u000108R\u00020\u00002\u0006\u0010=\u001a\u00020$2\b\b\u0002\u0010>\u001a\u00020\nH\u0007J\u0006\u0010?\u001a\u000204J\b\u0010@\u001a\u000204H\u0016J\u0017\u0010A\u001a\b\u0018\u00010BR\u00020\u00002\u0006\u0010=\u001a\u00020$H\u0002J\u0006\u0010C\u001a\u000204J\u0006\u0010D\u001a\u00020\u000fJ\b\u0010E\u001a\u00020\u000fH\u0002J\b\u0010F\u001a\u00020!H\u0002J\b\u0010G\u001a\u000204H\u0002J\b\u0010H\u001a\u000204H\u0002J\u0010\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020$H\u0002J\r\u0010K\u001a\u000204H\u0000¢\u0006\u0002\bLJ\u000e\u0010M\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020$J\u0019\u0010N\u001a\u00020\u000f2\n\u0010O\u001a\u00060%R\u00020\u0000H\u0000¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020\u000fH\u0002J\u0006\u0010/\u001a\u00020\nJ\u0006\u0010R\u001a\u000204J\u0010\u0010S\u001a\u0002042\u0006\u0010=\u001a\u00020$H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$\u0012\b\u0012\u00060%R\u00020\u00000#X\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lcom/didiglobal/enginecore/cache/XECacheFileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "maxSize", "", "taskRunner", "Lcom/didiglobal/enginecore/cache/concurrent/TaskRunner;", "(Lcom/didiglobal/enginecore/cache/XECacheFileSystem;Ljava/io/File;IJLcom/didiglobal/enginecore/cache/concurrent/TaskRunner;)V", "civilizedFileSystem", "", "cleanupQueue", "Lcom/didiglobal/enginecore/cache/concurrent/TaskQueue;", "cleanupTask", "com/didiglobal/enginecore/cache/XEDiskLruCache$cleanupTask$1", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$cleanupTask$1;", "closed", "getClosed$engine_core_release", "()Z", "setClosed$engine_core_release", "(Z)V", "getDirectory", "()Ljava/io/File;", "getFileSystem$engine_core_release", "()Lcom/didiglobal/enginecore/cache/XECacheFileSystem;", "hasJournalErrors", "initialized", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Entry;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", "size", "xECacheFile", "xECacheFileBackup", "xECacheFileTmp", "checkNotClosed", "", "close", "completeEdit", "editor", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;", "success", "completeEdit$engine_core_release", "delete", "edit", "key", "expectedSequenceNumber", "evictAll", "flush", "get", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$engine_core_release", "remove", "removeEntry", "entry", "removeEntry$engine_core_release", "removeOldestEntry", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEDiskLruCache.kt */
public final class XEDiskLruCache implements Closeable, Flushable {
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = CLEAN;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIRTY = DIRTY;
    public static final String JOURNAL_FILE = JOURNAL_FILE;
    public static final String JOURNAL_FILE_BACKUP = JOURNAL_FILE_BACKUP;
    public static final String JOURNAL_FILE_TEMP = JOURNAL_FILE_TEMP;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-zA-Z0-9_-]{1,120}");
    public static final String READ = READ;
    public static final String REMOVE = REMOVE;

    /* renamed from: a */
    private long f50118a;

    /* renamed from: b */
    private final File f50119b;

    /* renamed from: c */
    private final File f50120c;

    /* renamed from: d */
    private final File f50121d;

    /* renamed from: e */
    private long f50122e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public BufferedSink f50123f;

    /* renamed from: g */
    private final LinkedHashMap<String, Entry> f50124g = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f50125h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f50126i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f50127j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f50128k;

    /* renamed from: l */
    private boolean f50129l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f50130m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f50131n;

    /* renamed from: o */
    private long f50132o;

    /* renamed from: p */
    private final TaskQueue f50133p;

    /* renamed from: q */
    private final XEDiskLruCache$cleanupTask$1 f50134q;

    /* renamed from: r */
    private final XECacheFileSystem f50135r;

    /* renamed from: s */
    private final File f50136s;

    /* renamed from: t */
    private final int f50137t;

    /* renamed from: b */
    private final void m36130b(String str) {
    }

    public final Editor edit(String str) throws IOException {
        return edit$default(this, str, 0, 2, (Object) null);
    }

    public XEDiskLruCache(XECacheFileSystem xECacheFileSystem, File file, int i, long j, TaskRunner taskRunner) {
        Intrinsics.checkParameterIsNotNull(xECacheFileSystem, "fileSystem");
        Intrinsics.checkParameterIsNotNull(file, "directory");
        Intrinsics.checkParameterIsNotNull(taskRunner, "taskRunner");
        this.f50135r = xECacheFileSystem;
        this.f50136s = file;
        this.f50137t = i;
        this.f50118a = j;
        boolean z = false;
        this.f50133p = taskRunner.newQueue();
        this.f50134q = new XEDiskLruCache$cleanupTask$1(this, "XEngine Cache");
        if (j > 0 ? true : z) {
            this.f50119b = new File(this.f50136s, JOURNAL_FILE);
            this.f50120c = new File(this.f50136s, JOURNAL_FILE_TEMP);
            this.f50121d = new File(this.f50136s, JOURNAL_FILE_BACKUP);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public final XECacheFileSystem getFileSystem$engine_core_release() {
        return this.f50135r;
    }

    public final File getDirectory() {
        return this.f50136s;
    }

    public final synchronized long getMaxSize() {
        return this.f50118a;
    }

    public final synchronized void setMaxSize(long j) {
        this.f50118a = j;
        if (this.f50128k) {
            TaskQueue.schedule$default(this.f50133p, this.f50134q, 0, 2, (Object) null);
        }
    }

    public final boolean getClosed$engine_core_release() {
        return this.f50129l;
    }

    public final void setClosed$engine_core_release(boolean z) {
        this.f50129l = z;
    }

    public final synchronized void initialize() throws IOException {
        if (!this.f50128k) {
            if (this.f50135r.exists(this.f50121d)) {
                if (this.f50135r.exists(this.f50119b)) {
                    this.f50135r.delete(this.f50121d);
                } else {
                    this.f50135r.rename(this.f50121d, this.f50119b);
                }
            }
            this.f50127j = this.f50135r.isCivilized(this.f50121d);
            if (this.f50135r.exists(this.f50119b)) {
                try {
                    m36127a();
                    m36131c();
                    this.f50128k = true;
                    return;
                } catch (IOException unused) {
                    delete();
                    this.f50129l = false;
                } catch (Throwable th) {
                    this.f50129l = false;
                    throw th;
                }
            }
            rebuildJournal$engine_core_release();
            this.f50128k = true;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(1:15)(1:16)|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r7.f50125h = r6 - r7.f50124g.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        if (r2.exhausted() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        rebuildJournal$engine_core_release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r7.f50123f = m36129b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        throw r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0042 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0061=Splitter:B:20:0x0061, B:12:0x0042=Splitter:B:12:0x0042} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m36127a() throws java.io.IOException {
        /*
            r7 = this;
            com.didiglobal.enginecore.cache.XECacheFileSystem r0 = r7.f50135r
            java.io.File r1 = r7.f50119b
            okio.Source r0 = r0.source(r1)
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r0)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r0
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x007f }
            java.lang.String r3 = r2.readUtf8LineStrict()     // Catch:{ all -> 0x007f }
            java.lang.String r4 = r2.readUtf8LineStrict()     // Catch:{ all -> 0x007f }
            int r5 = r7.f50137t     // Catch:{ all -> 0x007f }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x007f }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r3)     // Catch:{ all -> 0x007f }
            r5 = 1
            r3 = r3 ^ r5
            if (r3 != 0) goto L_0x0061
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x007f }
            int r3 = r3.length()     // Catch:{ all -> 0x007f }
            r6 = 0
            if (r3 <= 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r5 = 0
        L_0x0036:
            if (r5 != 0) goto L_0x0061
        L_0x0038:
            java.lang.String r3 = r2.readUtf8LineStrict()     // Catch:{ EOFException -> 0x0042 }
            r7.m36128a(r3)     // Catch:{ EOFException -> 0x0042 }
            int r6 = r6 + 1
            goto L_0x0038
        L_0x0042:
            java.util.LinkedHashMap<java.lang.String, com.didiglobal.enginecore.cache.XEDiskLruCache$Entry> r3 = r7.f50124g     // Catch:{ all -> 0x007f }
            int r3 = r3.size()     // Catch:{ all -> 0x007f }
            int r6 = r6 - r3
            r7.f50125h = r6     // Catch:{ all -> 0x007f }
            boolean r2 = r2.exhausted()     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x0055
            r7.rebuildJournal$engine_core_release()     // Catch:{ all -> 0x007f }
            goto L_0x005b
        L_0x0055:
            okio.BufferedSink r2 = r7.m36129b()     // Catch:{ all -> 0x007f }
            r7.f50123f = r2     // Catch:{ all -> 0x007f }
        L_0x005b:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007f }
            kotlin.p245io.CloseableKt.closeFinally(r0, r1)
            return
        L_0x0061:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r2.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r3 = "unexpected journal header: ["
            r2.append(r3)     // Catch:{ all -> 0x007f }
            r2.append(r4)     // Catch:{ all -> 0x007f }
            r3 = 93
            r2.append(r3)     // Catch:{ all -> 0x007f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007f }
            r1.<init>(r2)     // Catch:{ all -> 0x007f }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x007f }
            throw r1     // Catch:{ all -> 0x007f }
        L_0x007f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r2 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.m36127a():void");
    }

    /* renamed from: b */
    private final BufferedSink m36129b() throws FileNotFoundException {
        return Okio.buffer((Sink) new FaultHidingSink(this.f50135r.appendingSink(this.f50119b), new XEDiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    /* renamed from: a */
    private final void m36128a(String str) throws IOException {
        String str2;
        String str3 = str;
        CharSequence charSequence = str3;
        int indexOf$default = StringsKt.indexOf$default(charSequence, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, ' ', i, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                if (str3 != null) {
                    str2 = str3.substring(i);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.String).substring(startIndex)");
                    if (indexOf$default == REMOVE.length() && StringsKt.startsWith$default(str3, REMOVE, false, 2, (Object) null)) {
                        this.f50124g.remove(str2);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (str3 != null) {
                str2 = str3.substring(i, indexOf$default2);
                Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            Entry entry = this.f50124g.get(str2);
            if (entry == null) {
                entry = new Entry(this, str2);
                this.f50124g.put(str2, entry);
            }
            if (indexOf$default2 != -1 && indexOf$default == CLEAN.length() && StringsKt.startsWith$default(str3, CLEAN, false, 2, (Object) null)) {
                int i2 = indexOf$default2 + 1;
                if (str3 != null) {
                    String substring = str3.substring(i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                    List split$default = StringsKt.split$default((CharSequence) substring, new char[]{' '}, false, 0, 6, (Object) null);
                    entry.setReadable$engine_core_release(true);
                    entry.setCurrentEditor$engine_core_release((Editor) null);
                    entry.setLength$engine_core_release((String) split$default.get(0));
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } else if (indexOf$default2 == -1 && indexOf$default == DIRTY.length() && StringsKt.startsWith$default(str3, DIRTY, false, 2, (Object) null)) {
                entry.setCurrentEditor$engine_core_release(new Editor(this, entry));
            } else if (indexOf$default2 != -1 || indexOf$default != READ.length() || !StringsKt.startsWith$default(str3, READ, false, 2, (Object) null)) {
                throw new IOException("unexpected journal line: " + str3);
            }
        } else {
            throw new IOException("unexpected journal line: " + str3);
        }
    }

    /* renamed from: c */
    private final void m36131c() throws IOException {
        this.f50135r.delete(this.f50120c);
        Iterator<Entry> it = this.f50124g.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "i.next()");
            Entry entry = next;
            if (entry.getCurrentEditor$engine_core_release() == null) {
                this.f50122e += entry.getLength$engine_core_release();
            } else {
                entry.setCurrentEditor$engine_core_release((Editor) null);
                this.f50135r.delete(entry.getCleanFile$engine_core_release());
                this.f50135r.delete(entry.getDirtyFile$engine_core_release());
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ab, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void rebuildJournal$engine_core_release() throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            okio.BufferedSink r0 = r8.f50123f     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00b0 }
        L_0x0008:
            com.didiglobal.enginecore.cache.XECacheFileSystem r0 = r8.f50135r     // Catch:{ all -> 0x00b0 }
            java.io.File r1 = r8.f50120c     // Catch:{ all -> 0x00b0 }
            okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x00b0 }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x00b0 }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ all -> 0x00b0 }
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00b0 }
            r2 = r0
            okio.BufferedSink r2 = (okio.BufferedSink) r2     // Catch:{ all -> 0x00a9 }
            int r3 = r8.f50137t     // Catch:{ all -> 0x00a9 }
            long r3 = (long) r3     // Catch:{ all -> 0x00a9 }
            okio.BufferedSink r3 = r2.writeDecimalLong(r3)     // Catch:{ all -> 0x00a9 }
            r4 = 10
            r3.writeByte(r4)     // Catch:{ all -> 0x00a9 }
            r2.writeByte(r4)     // Catch:{ all -> 0x00a9 }
            java.util.LinkedHashMap<java.lang.String, com.didiglobal.enginecore.cache.XEDiskLruCache$Entry> r3 = r8.f50124g     // Catch:{ all -> 0x00a9 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x00a9 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00a9 }
        L_0x0035:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x00a9 }
            if (r5 == 0) goto L_0x0074
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x00a9 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r5 = (com.didiglobal.enginecore.cache.XEDiskLruCache.Entry) r5     // Catch:{ all -> 0x00a9 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r6 = r5.getCurrentEditor$engine_core_release()     // Catch:{ all -> 0x00a9 }
            r7 = 32
            if (r6 == 0) goto L_0x005d
            java.lang.String r6 = DIRTY     // Catch:{ all -> 0x00a9 }
            okio.BufferedSink r6 = r2.writeUtf8(r6)     // Catch:{ all -> 0x00a9 }
            r6.writeByte(r7)     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = r5.getKey$engine_core_release()     // Catch:{ all -> 0x00a9 }
            r2.writeUtf8(r5)     // Catch:{ all -> 0x00a9 }
            r2.writeByte(r4)     // Catch:{ all -> 0x00a9 }
            goto L_0x0035
        L_0x005d:
            java.lang.String r6 = CLEAN     // Catch:{ all -> 0x00a9 }
            okio.BufferedSink r6 = r2.writeUtf8(r6)     // Catch:{ all -> 0x00a9 }
            r6.writeByte(r7)     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = r5.getKey$engine_core_release()     // Catch:{ all -> 0x00a9 }
            r2.writeUtf8(r6)     // Catch:{ all -> 0x00a9 }
            r5.writeLengths$engine_core_release(r2)     // Catch:{ all -> 0x00a9 }
            r2.writeByte(r4)     // Catch:{ all -> 0x00a9 }
            goto L_0x0035
        L_0x0074:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a9 }
            kotlin.p245io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x00b0 }
            com.didiglobal.enginecore.cache.XECacheFileSystem r0 = r8.f50135r     // Catch:{ all -> 0x00b0 }
            java.io.File r1 = r8.f50119b     // Catch:{ all -> 0x00b0 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x008c
            com.didiglobal.enginecore.cache.XECacheFileSystem r0 = r8.f50135r     // Catch:{ all -> 0x00b0 }
            java.io.File r1 = r8.f50119b     // Catch:{ all -> 0x00b0 }
            java.io.File r2 = r8.f50121d     // Catch:{ all -> 0x00b0 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00b0 }
        L_0x008c:
            com.didiglobal.enginecore.cache.XECacheFileSystem r0 = r8.f50135r     // Catch:{ all -> 0x00b0 }
            java.io.File r1 = r8.f50120c     // Catch:{ all -> 0x00b0 }
            java.io.File r2 = r8.f50119b     // Catch:{ all -> 0x00b0 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00b0 }
            com.didiglobal.enginecore.cache.XECacheFileSystem r0 = r8.f50135r     // Catch:{ all -> 0x00b0 }
            java.io.File r1 = r8.f50121d     // Catch:{ all -> 0x00b0 }
            r0.delete(r1)     // Catch:{ all -> 0x00b0 }
            okio.BufferedSink r0 = r8.m36129b()     // Catch:{ all -> 0x00b0 }
            r8.f50123f = r0     // Catch:{ all -> 0x00b0 }
            r0 = 0
            r8.f50126i = r0     // Catch:{ all -> 0x00b0 }
            r8.f50131n = r0     // Catch:{ all -> 0x00b0 }
            monitor-exit(r8)
            return
        L_0x00a9:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r2 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x00b0 }
            throw r2     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.rebuildJournal$engine_core_release():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.didiglobal.enginecore.cache.XEDiskLruCache.Snapshot get(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)     // Catch:{ all -> 0x0061 }
            r7.initialize()     // Catch:{ all -> 0x0061 }
            r7.m36133e()     // Catch:{ all -> 0x0061 }
            r7.m36130b(r8)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.didiglobal.enginecore.cache.XEDiskLruCache$Entry> r0 = r7.f50124g     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0061 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r0 = (com.didiglobal.enginecore.cache.XEDiskLruCache.Entry) r0     // Catch:{ all -> 0x0061 }
            r1 = 0
            if (r0 == 0) goto L_0x005f
            java.lang.String r2 = "lruEntries[key] ?: return null"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)     // Catch:{ all -> 0x0061 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Snapshot r0 = r0.snapshot$engine_core_release()     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x005d
            int r1 = r7.f50125h     // Catch:{ all -> 0x0061 }
            int r1 = r1 + 1
            r7.f50125h = r1     // Catch:{ all -> 0x0061 }
            okio.BufferedSink r1 = r7.f50123f     // Catch:{ all -> 0x0061 }
            if (r1 != 0) goto L_0x0032
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0061 }
        L_0x0032:
            java.lang.String r2 = READ     // Catch:{ all -> 0x0061 }
            okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x0061 }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0061 }
            okio.BufferedSink r8 = r1.writeUtf8(r8)     // Catch:{ all -> 0x0061 }
            r1 = 10
            r8.writeByte(r1)     // Catch:{ all -> 0x0061 }
            boolean r8 = r7.m36132d()     // Catch:{ all -> 0x0061 }
            if (r8 == 0) goto L_0x005b
            com.didiglobal.enginecore.cache.concurrent.TaskQueue r1 = r7.f50133p     // Catch:{ all -> 0x0061 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$cleanupTask$1 r8 = r7.f50134q     // Catch:{ all -> 0x0061 }
            r2 = r8
            com.didiglobal.enginecore.cache.concurrent.Task r2 = (com.didiglobal.enginecore.cache.concurrent.Task) r2     // Catch:{ all -> 0x0061 }
            r3 = 0
            r5 = 2
            r6 = 0
            com.didiglobal.enginecore.cache.concurrent.TaskQueue.schedule$default(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x0061 }
        L_0x005b:
            monitor-exit(r7)
            return r0
        L_0x005d:
            monitor-exit(r7)
            return r1
        L_0x005f:
            monitor-exit(r7)
            return r1
        L_0x0061:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.get(java.lang.String):com.didiglobal.enginecore.cache.XEDiskLruCache$Snapshot");
    }

    public static /* synthetic */ Editor edit$default(XEDiskLruCache xEDiskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return xEDiskLruCache.edit(str, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.didiglobal.enginecore.cache.XEDiskLruCache.Editor edit(java.lang.String r11, long r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)     // Catch:{ all -> 0x0096 }
            r10.initialize()     // Catch:{ all -> 0x0096 }
            r10.m36133e()     // Catch:{ all -> 0x0096 }
            r10.m36130b(r11)     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap<java.lang.String, com.didiglobal.enginecore.cache.XEDiskLruCache$Entry> r0 = r10.f50124g     // Catch:{ all -> 0x0096 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x0096 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r0 = (com.didiglobal.enginecore.cache.XEDiskLruCache.Entry) r0     // Catch:{ all -> 0x0096 }
            long r1 = ANY_SEQUENCE_NUMBER     // Catch:{ all -> 0x0096 }
            r3 = 0
            int r4 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x0028
            long r1 = r0.getSequenceNumber$engine_core_release()     // Catch:{ all -> 0x0096 }
            int r4 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            monitor-exit(r10)
            return r3
        L_0x002a:
            if (r0 == 0) goto L_0x0031
            com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r12 = r0.getCurrentEditor$engine_core_release()     // Catch:{ all -> 0x0096 }
            goto L_0x0032
        L_0x0031:
            r12 = r3
        L_0x0032:
            if (r12 == 0) goto L_0x0036
            monitor-exit(r10)
            return r3
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            int r12 = r0.getLockingSourceCount$engine_core_release()     // Catch:{ all -> 0x0096 }
            if (r12 == 0) goto L_0x0040
            monitor-exit(r10)
            return r3
        L_0x0040:
            boolean r12 = r10.f50130m     // Catch:{ all -> 0x0096 }
            if (r12 != 0) goto L_0x0086
            boolean r12 = r10.f50131n     // Catch:{ all -> 0x0096 }
            if (r12 == 0) goto L_0x0049
            goto L_0x0086
        L_0x0049:
            okio.BufferedSink r12 = r10.f50123f     // Catch:{ all -> 0x0096 }
            if (r12 != 0) goto L_0x0050
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0096 }
        L_0x0050:
            java.lang.String r13 = DIRTY     // Catch:{ all -> 0x0096 }
            okio.BufferedSink r13 = r12.writeUtf8(r13)     // Catch:{ all -> 0x0096 }
            r1 = 32
            okio.BufferedSink r13 = r13.writeByte(r1)     // Catch:{ all -> 0x0096 }
            okio.BufferedSink r13 = r13.writeUtf8(r11)     // Catch:{ all -> 0x0096 }
            r1 = 10
            r13.writeByte(r1)     // Catch:{ all -> 0x0096 }
            r12.flush()     // Catch:{ all -> 0x0096 }
            boolean r12 = r10.f50126i     // Catch:{ all -> 0x0096 }
            if (r12 == 0) goto L_0x006e
            monitor-exit(r10)
            return r3
        L_0x006e:
            if (r0 != 0) goto L_0x007c
            com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r0 = new com.didiglobal.enginecore.cache.XEDiskLruCache$Entry     // Catch:{ all -> 0x0096 }
            r0.<init>(r10, r11)     // Catch:{ all -> 0x0096 }
            java.util.LinkedHashMap<java.lang.String, com.didiglobal.enginecore.cache.XEDiskLruCache$Entry> r12 = r10.f50124g     // Catch:{ all -> 0x0096 }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ all -> 0x0096 }
            r12.put(r11, r0)     // Catch:{ all -> 0x0096 }
        L_0x007c:
            com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r11 = new com.didiglobal.enginecore.cache.XEDiskLruCache$Editor     // Catch:{ all -> 0x0096 }
            r11.<init>(r10, r0)     // Catch:{ all -> 0x0096 }
            r0.setCurrentEditor$engine_core_release(r11)     // Catch:{ all -> 0x0096 }
            monitor-exit(r10)
            return r11
        L_0x0086:
            com.didiglobal.enginecore.cache.concurrent.TaskQueue r4 = r10.f50133p     // Catch:{ all -> 0x0096 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$cleanupTask$1 r11 = r10.f50134q     // Catch:{ all -> 0x0096 }
            r5 = r11
            com.didiglobal.enginecore.cache.concurrent.Task r5 = (com.didiglobal.enginecore.cache.concurrent.Task) r5     // Catch:{ all -> 0x0096 }
            r6 = 0
            r8 = 2
            r9 = 0
            com.didiglobal.enginecore.cache.concurrent.TaskQueue.schedule$default(r4, r5, r6, r8, r9)     // Catch:{ all -> 0x0096 }
            monitor-exit(r10)
            return r3
        L_0x0096:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.edit(java.lang.String, long):com.didiglobal.enginecore.cache.XEDiskLruCache$Editor");
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.f50122e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0103, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void completeEdit$engine_core_release(com.didiglobal.enginecore.cache.XEDiskLruCache.Editor r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "editor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)     // Catch:{ all -> 0x0112 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r0 = r9.getEntry$engine_core_release()     // Catch:{ all -> 0x0112 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r1 = r0.getCurrentEditor$engine_core_release()     // Catch:{ all -> 0x0112 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x0104
            if (r10 == 0) goto L_0x0040
            boolean r1 = r0.getReadable$engine_core_release()     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0040
            boolean r1 = r9.getWritten$engine_core_release()     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x0033
            com.didiglobal.enginecore.cache.XECacheFileSystem r1 = r8.f50135r     // Catch:{ all -> 0x0112 }
            java.io.File r2 = r0.getDirtyFile$engine_core_release()     // Catch:{ all -> 0x0112 }
            boolean r1 = r1.exists(r2)     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0040
            r9.abort()     // Catch:{ all -> 0x0112 }
            monitor-exit(r8)
            return
        L_0x0033:
            r9.abort()     // Catch:{ all -> 0x0112 }
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0112 }
            java.lang.String r10 = "Newly created entry didn't create value"
            r9.<init>(r10)     // Catch:{ all -> 0x0112 }
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ all -> 0x0112 }
            throw r9     // Catch:{ all -> 0x0112 }
        L_0x0040:
            java.io.File r9 = r0.getDirtyFile$engine_core_release()     // Catch:{ all -> 0x0112 }
            if (r10 == 0) goto L_0x0071
            boolean r1 = r0.getZombie$engine_core_release()     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0071
            com.didiglobal.enginecore.cache.XECacheFileSystem r1 = r8.f50135r     // Catch:{ all -> 0x0112 }
            boolean r1 = r1.exists(r9)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x0076
            java.io.File r1 = r0.getCleanFile$engine_core_release()     // Catch:{ all -> 0x0112 }
            com.didiglobal.enginecore.cache.XECacheFileSystem r2 = r8.f50135r     // Catch:{ all -> 0x0112 }
            r2.rename(r9, r1)     // Catch:{ all -> 0x0112 }
            long r2 = r0.getLength$engine_core_release()     // Catch:{ all -> 0x0112 }
            com.didiglobal.enginecore.cache.XECacheFileSystem r9 = r8.f50135r     // Catch:{ all -> 0x0112 }
            long r4 = r9.size(r1)     // Catch:{ all -> 0x0112 }
            r0.setLength$engine_core_release((long) r4)     // Catch:{ all -> 0x0112 }
            long r6 = r8.f50122e     // Catch:{ all -> 0x0112 }
            long r6 = r6 - r2
            long r6 = r6 + r4
            r8.f50122e = r6     // Catch:{ all -> 0x0112 }
            goto L_0x0076
        L_0x0071:
            com.didiglobal.enginecore.cache.XECacheFileSystem r1 = r8.f50135r     // Catch:{ all -> 0x0112 }
            r1.delete(r9)     // Catch:{ all -> 0x0112 }
        L_0x0076:
            r9 = 0
            com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r9 = (com.didiglobal.enginecore.cache.XEDiskLruCache.Editor) r9     // Catch:{ all -> 0x0112 }
            r0.setCurrentEditor$engine_core_release(r9)     // Catch:{ all -> 0x0112 }
            boolean r9 = r0.getZombie$engine_core_release()     // Catch:{ all -> 0x0112 }
            if (r9 == 0) goto L_0x0087
            r8.removeEntry$engine_core_release(r0)     // Catch:{ all -> 0x0112 }
            monitor-exit(r8)
            return
        L_0x0087:
            int r9 = r8.f50125h     // Catch:{ all -> 0x0112 }
            r1 = 1
            int r9 = r9 + r1
            r8.f50125h = r9     // Catch:{ all -> 0x0112 }
            okio.BufferedSink r9 = r8.f50123f     // Catch:{ all -> 0x0112 }
            if (r9 != 0) goto L_0x0094
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x0112 }
        L_0x0094:
            boolean r2 = r0.getReadable$engine_core_release()     // Catch:{ all -> 0x0112 }
            r3 = 10
            r4 = 32
            if (r2 != 0) goto L_0x00be
            if (r10 == 0) goto L_0x00a1
            goto L_0x00be
        L_0x00a1:
            java.util.LinkedHashMap<java.lang.String, com.didiglobal.enginecore.cache.XEDiskLruCache$Entry> r10 = r8.f50124g     // Catch:{ all -> 0x0112 }
            java.lang.String r1 = r0.getKey$engine_core_release()     // Catch:{ all -> 0x0112 }
            r10.remove(r1)     // Catch:{ all -> 0x0112 }
            java.lang.String r10 = REMOVE     // Catch:{ all -> 0x0112 }
            okio.BufferedSink r10 = r9.writeUtf8(r10)     // Catch:{ all -> 0x0112 }
            r10.writeByte(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r10 = r0.getKey$engine_core_release()     // Catch:{ all -> 0x0112 }
            r9.writeUtf8(r10)     // Catch:{ all -> 0x0112 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0112 }
            goto L_0x00e3
        L_0x00be:
            r0.setReadable$engine_core_release(r1)     // Catch:{ all -> 0x0112 }
            java.lang.String r1 = CLEAN     // Catch:{ all -> 0x0112 }
            okio.BufferedSink r1 = r9.writeUtf8(r1)     // Catch:{ all -> 0x0112 }
            r1.writeByte(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r1 = r0.getKey$engine_core_release()     // Catch:{ all -> 0x0112 }
            r9.writeUtf8(r1)     // Catch:{ all -> 0x0112 }
            r0.writeLengths$engine_core_release(r9)     // Catch:{ all -> 0x0112 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0112 }
            if (r10 == 0) goto L_0x00e3
            long r1 = r8.f50132o     // Catch:{ all -> 0x0112 }
            r3 = 1
            long r3 = r3 + r1
            r8.f50132o = r3     // Catch:{ all -> 0x0112 }
            r0.setSequenceNumber$engine_core_release(r1)     // Catch:{ all -> 0x0112 }
        L_0x00e3:
            r9.flush()     // Catch:{ all -> 0x0112 }
            long r9 = r8.f50122e     // Catch:{ all -> 0x0112 }
            long r0 = r8.f50118a     // Catch:{ all -> 0x0112 }
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00f4
            boolean r9 = r8.m36132d()     // Catch:{ all -> 0x0112 }
            if (r9 == 0) goto L_0x0102
        L_0x00f4:
            com.didiglobal.enginecore.cache.concurrent.TaskQueue r0 = r8.f50133p     // Catch:{ all -> 0x0112 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$cleanupTask$1 r9 = r8.f50134q     // Catch:{ all -> 0x0112 }
            r1 = r9
            com.didiglobal.enginecore.cache.concurrent.Task r1 = (com.didiglobal.enginecore.cache.concurrent.Task) r1     // Catch:{ all -> 0x0112 }
            r2 = 0
            r4 = 2
            r5 = 0
            com.didiglobal.enginecore.cache.concurrent.TaskQueue.schedule$default(r0, r1, r2, r4, r5)     // Catch:{ all -> 0x0112 }
        L_0x0102:
            monitor-exit(r8)
            return
        L_0x0104:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0112 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0112 }
            r10.<init>(r9)     // Catch:{ all -> 0x0112 }
            java.lang.Throwable r10 = (java.lang.Throwable) r10     // Catch:{ all -> 0x0112 }
            throw r10     // Catch:{ all -> 0x0112 }
        L_0x0112:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.completeEdit$engine_core_release(com.didiglobal.enginecore.cache.XEDiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final boolean m36132d() {
        int i = this.f50125h;
        return i >= 2000 && i >= this.f50124g.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)     // Catch:{ all -> 0x0033 }
            r6.initialize()     // Catch:{ all -> 0x0033 }
            r6.m36133e()     // Catch:{ all -> 0x0033 }
            r6.m36130b(r7)     // Catch:{ all -> 0x0033 }
            java.util.LinkedHashMap<java.lang.String, com.didiglobal.enginecore.cache.XEDiskLruCache$Entry> r0 = r6.f50124g     // Catch:{ all -> 0x0033 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0033 }
            com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r7 = (com.didiglobal.enginecore.cache.XEDiskLruCache.Entry) r7     // Catch:{ all -> 0x0033 }
            r0 = 0
            if (r7 == 0) goto L_0x0031
            java.lang.String r1 = "lruEntries[key] ?: return false"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)     // Catch:{ all -> 0x0033 }
            boolean r7 = r6.removeEntry$engine_core_release(r7)     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x002f
            long r1 = r6.f50122e     // Catch:{ all -> 0x0033 }
            long r3 = r6.f50118a     // Catch:{ all -> 0x0033 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002f
            r6.f50130m = r0     // Catch:{ all -> 0x0033 }
        L_0x002f:
            monitor-exit(r6)
            return r7
        L_0x0031:
            monitor-exit(r6)
            return r0
        L_0x0033:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.remove(java.lang.String):boolean");
    }

    public final boolean removeEntry$engine_core_release(Entry entry) throws IOException {
        BufferedSink bufferedSink;
        Intrinsics.checkParameterIsNotNull(entry, ParamKeys.PARAM_COMPLAIN_ENTRY);
        if (!this.f50127j) {
            if (entry.getLockingSourceCount$engine_core_release() > 0 && (bufferedSink = this.f50123f) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey$engine_core_release());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$engine_core_release() > 0 || entry.getCurrentEditor$engine_core_release() != null) {
                entry.setZombie$engine_core_release(true);
                return true;
            }
        }
        Editor currentEditor$engine_core_release = entry.getCurrentEditor$engine_core_release();
        if (currentEditor$engine_core_release != null) {
            currentEditor$engine_core_release.detach$engine_core_release();
        }
        File cleanFile$engine_core_release = entry.getCleanFile$engine_core_release();
        if (cleanFile$engine_core_release != null) {
            this.f50135r.delete(cleanFile$engine_core_release);
        }
        this.f50122e -= entry.getLength$engine_core_release();
        entry.setLength$engine_core_release(0);
        this.f50125h++;
        BufferedSink bufferedSink2 = this.f50123f;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$engine_core_release());
            bufferedSink2.writeByte(10);
        }
        this.f50124g.remove(entry.getKey$engine_core_release());
        if (m36132d()) {
            TaskQueue.schedule$default(this.f50133p, this.f50134q, 0, 2, (Object) null);
        }
        return true;
    }

    /* renamed from: e */
    private final synchronized void m36133e() {
        if (!(!this.f50129l)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f50128k) {
            m36133e();
            trimToSize();
            BufferedSink bufferedSink = this.f50123f;
            if (bufferedSink == null) {
                Intrinsics.throwNpe();
            }
            bufferedSink.flush();
        }
    }

    public final synchronized boolean isClosed() {
        return this.f50129l;
    }

    public synchronized void close() throws IOException {
        Editor currentEditor$engine_core_release;
        if (this.f50128k) {
            if (!this.f50129l) {
                Collection<Entry> values = this.f50124g.values();
                Intrinsics.checkExpressionValueIsNotNull(values, "lruEntries.values");
                Object[] array = values.toArray(new Entry[0]);
                if (array != null) {
                    for (Entry entry : (Entry[]) array) {
                        if (!(entry.getCurrentEditor$engine_core_release() == null || (currentEditor$engine_core_release = entry.getCurrentEditor$engine_core_release()) == null)) {
                            currentEditor$engine_core_release.detach$engine_core_release();
                        }
                    }
                    trimToSize();
                    BufferedSink bufferedSink = this.f50123f;
                    if (bufferedSink == null) {
                        Intrinsics.throwNpe();
                    }
                    bufferedSink.close();
                    this.f50123f = null;
                    this.f50129l = true;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        this.f50129l = true;
    }

    public final void trimToSize() throws IOException {
        while (this.f50122e > this.f50118a) {
            if (!m36134f()) {
                return;
            }
        }
        this.f50130m = false;
    }

    /* renamed from: f */
    private final boolean m36134f() {
        for (Entry next : this.f50124g.values()) {
            if (!next.getZombie$engine_core_release()) {
                Intrinsics.checkExpressionValueIsNotNull(next, "toEvict");
                removeEntry$engine_core_release(next);
                return true;
            }
        }
        return false;
    }

    public final void delete() throws IOException {
        close();
        this.f50135r.deleteContents(this.f50136s);
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection<Entry> values = this.f50124g.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array != null) {
            for (Entry entry : (Entry[]) array) {
                Intrinsics.checkExpressionValueIsNotNull(entry, ParamKeys.PARAM_COMPLAIN_ENTRY);
                removeEntry$engine_core_release(entry);
            }
            this.f50130m = false;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\f\u0010\f\u001a\b\u0018\u00010\rR\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", "", "sequenceNumber", "", "source", "Lokio/Source;", "length", "(Lcom/didiglobal/enginecore/cache/XEDiskLruCache;Ljava/lang/String;JLokio/Source;J)V", "close", "", "edit", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "getLength", "getSource", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEDiskLruCache.kt */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long length;
        private final long sequenceNumber;
        private final Source source;
        final /* synthetic */ XEDiskLruCache this$0;

        public Snapshot(XEDiskLruCache xEDiskLruCache, String str, long j, Source source2, long j2) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            Intrinsics.checkParameterIsNotNull(source2, "source");
            this.this$0 = xEDiskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.source = source2;
            this.length = j2;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final Source getSource() {
            return this.source;
        }

        public final long getLength() {
            return this.length;
        }

        public void close() {
            Source source2 = this.source;
            if (source2 != null) {
                C16883Util.closeQuietly((Closeable) source2);
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\r\u0010\u0012\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;", "", "entry", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Entry;", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "(Lcom/didiglobal/enginecore/cache/XEDiskLruCache;Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Entry;)V", "done", "", "getEntry$engine_core_release", "()Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Entry;", "written", "getWritten$engine_core_release", "()Z", "setWritten$engine_core_release", "(Z)V", "abort", "", "commit", "detach", "detach$engine_core_release", "newSink", "Lokio/Sink;", "newSource", "Lokio/Source;", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEDiskLruCache.kt */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ XEDiskLruCache this$0;
        private boolean written;

        public Editor(XEDiskLruCache xEDiskLruCache, Entry entry2) {
            Intrinsics.checkParameterIsNotNull(entry2, ParamKeys.PARAM_COMPLAIN_ENTRY);
            this.this$0 = xEDiskLruCache;
            this.entry = entry2;
        }

        public final Entry getEntry$engine_core_release() {
            return this.entry;
        }

        public final boolean getWritten$engine_core_release() {
            return this.written;
        }

        public final void setWritten$engine_core_release(boolean z) {
            this.written = z;
        }

        public final void detach$engine_core_release() {
            if (!Intrinsics.areEqual((Object) this.entry.getCurrentEditor$engine_core_release(), (Object) this)) {
                return;
            }
            if (this.this$0.f50127j) {
                this.this$0.completeEdit$engine_core_release(this, false);
            } else {
                this.entry.setZombie$engine_core_release(true);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Source newSource() {
            /*
                r4 = this;
                com.didiglobal.enginecore.cache.XEDiskLruCache r0 = r4.this$0
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x0051 }
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x0043
                com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x0051 }
                boolean r1 = r1.getReadable$engine_core_release()     // Catch:{ all -> 0x0051 }
                r2 = 0
                if (r1 == 0) goto L_0x0041
                com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x0051 }
                com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r1 = r1.getCurrentEditor$engine_core_release()     // Catch:{ all -> 0x0051 }
                r3 = r4
                com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r3 = (com.didiglobal.enginecore.cache.XEDiskLruCache.Editor) r3     // Catch:{ all -> 0x0051 }
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ all -> 0x0051 }
                r1 = r1 ^ 1
                if (r1 != 0) goto L_0x0041
                com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x0051 }
                boolean r1 = r1.getZombie$engine_core_release()     // Catch:{ all -> 0x0051 }
                if (r1 == 0) goto L_0x002c
                goto L_0x0041
            L_0x002c:
                com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r1 = r4.entry     // Catch:{ FileNotFoundException -> 0x003f }
                java.io.File r1 = r1.getCleanFile$engine_core_release()     // Catch:{ FileNotFoundException -> 0x003f }
                if (r1 == 0) goto L_0x003f
                com.didiglobal.enginecore.cache.XEDiskLruCache r3 = r4.this$0     // Catch:{ FileNotFoundException -> 0x003f }
                com.didiglobal.enginecore.cache.XECacheFileSystem r3 = r3.getFileSystem$engine_core_release()     // Catch:{ FileNotFoundException -> 0x003f }
                okio.Source r1 = r3.source(r1)     // Catch:{ FileNotFoundException -> 0x003f }
                r2 = r1
            L_0x003f:
                monitor-exit(r0)
                return r2
            L_0x0041:
                monitor-exit(r0)
                return r2
            L_0x0043:
                java.lang.String r1 = "Check failed."
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0051 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0051 }
                r2.<init>(r1)     // Catch:{ all -> 0x0051 }
                java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0051 }
                throw r2     // Catch:{ all -> 0x0051 }
            L_0x0051:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.Editor.newSource():okio.Source");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r1 = okio.Okio.blackhole();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            return r1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Sink newSink() {
            /*
                r4 = this;
                com.didiglobal.enginecore.cache.XEDiskLruCache r0 = r4.this$0
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x005d }
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x004f
                com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x005d }
                com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r1 = r1.getCurrentEditor$engine_core_release()     // Catch:{ all -> 0x005d }
                r3 = r4
                com.didiglobal.enginecore.cache.XEDiskLruCache$Editor r3 = (com.didiglobal.enginecore.cache.XEDiskLruCache.Editor) r3     // Catch:{ all -> 0x005d }
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)     // Catch:{ all -> 0x005d }
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x001f
                okio.Sink r1 = okio.Okio.blackhole()     // Catch:{ all -> 0x005d }
                monitor-exit(r0)
                return r1
            L_0x001f:
                com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x005d }
                boolean r1 = r1.getReadable$engine_core_release()     // Catch:{ all -> 0x005d }
                if (r1 != 0) goto L_0x0029
                r4.written = r2     // Catch:{ all -> 0x005d }
            L_0x0029:
                com.didiglobal.enginecore.cache.XEDiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x005d }
                java.io.File r1 = r1.getDirtyFile$engine_core_release()     // Catch:{ all -> 0x005d }
                com.didiglobal.enginecore.cache.XEDiskLruCache r2 = r4.this$0     // Catch:{ FileNotFoundException -> 0x0049 }
                com.didiglobal.enginecore.cache.XECacheFileSystem r2 = r2.getFileSystem$engine_core_release()     // Catch:{ FileNotFoundException -> 0x0049 }
                okio.Sink r1 = r2.sink(r1)     // Catch:{ FileNotFoundException -> 0x0049 }
                com.didiglobal.enginecore.cache.FaultHidingSink r2 = new com.didiglobal.enginecore.cache.FaultHidingSink     // Catch:{ all -> 0x005d }
                com.didiglobal.enginecore.cache.XEDiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 r3 = new com.didiglobal.enginecore.cache.XEDiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1     // Catch:{ all -> 0x005d }
                r3.<init>(r4)     // Catch:{ all -> 0x005d }
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x005d }
                r2.<init>(r1, r3)     // Catch:{ all -> 0x005d }
                okio.Sink r2 = (okio.Sink) r2     // Catch:{ all -> 0x005d }
                monitor-exit(r0)
                return r2
            L_0x0049:
                okio.Sink r1 = okio.Okio.blackhole()     // Catch:{ all -> 0x005d }
                monitor-exit(r0)
                return r1
            L_0x004f:
                java.lang.String r1 = "Check failed."
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x005d }
                r2.<init>(r1)     // Catch:{ all -> 0x005d }
                java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x005d }
                throw r2     // Catch:{ all -> 0x005d }
            L_0x005d:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.cache.XEDiskLruCache.Editor.newSink():okio.Sink");
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor$engine_core_release(), (Object) this)) {
                        this.this$0.completeEdit$engine_core_release(this, true);
                    }
                    this.done = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor$engine_core_release(), (Object) this)) {
                        this.this$0.completeEdit$engine_core_release(this, false);
                    }
                    this.done = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0003H\u0002J\b\u00102\u001a\u000203H\u0002J\u0015\u00104\u001a\u0002052\u0006\u00101\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001bJ\u0013\u00106\u001a\b\u0018\u000107R\u00020\rH\u0000¢\u0006\u0002\b8J\u0015\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0018\u00010\fR\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001a\u0010,\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(¨\u0006="}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Entry;", "", "key", "", "(Lcom/didiglobal/enginecore/cache/XEDiskLruCache;Ljava/lang/String;)V", "cleanFile", "Ljava/io/File;", "getCleanFile$engine_core_release", "()Ljava/io/File;", "setCleanFile$engine_core_release", "(Ljava/io/File;)V", "currentEditor", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache;", "getCurrentEditor$engine_core_release", "()Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;", "setCurrentEditor$engine_core_release", "(Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Editor;)V", "dirtyFile", "getDirtyFile$engine_core_release", "setDirtyFile$engine_core_release", "getKey$engine_core_release", "()Ljava/lang/String;", "length", "", "getLength$engine_core_release", "()J", "setLength$engine_core_release", "(J)V", "lockingSourceCount", "", "getLockingSourceCount$engine_core_release", "()I", "setLockingSourceCount$engine_core_release", "(I)V", "readable", "", "getReadable$engine_core_release", "()Z", "setReadable$engine_core_release", "(Z)V", "sequenceNumber", "getSequenceNumber$engine_core_release", "setSequenceNumber$engine_core_release", "zombie", "getZombie$engine_core_release", "setZombie$engine_core_release", "invalidLengths", "", "string", "newSource", "Lokio/Source;", "setLength", "", "snapshot", "Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Snapshot;", "snapshot$engine_core_release", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$engine_core_release", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEDiskLruCache.kt */
    public final class Entry {
        private File cleanFile = new File("");
        private Editor currentEditor;
        private File dirtyFile = new File("");
        private final String key;
        private long length;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ XEDiskLruCache this$0;
        private boolean zombie;

        public Entry(XEDiskLruCache xEDiskLruCache, String str) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            this.this$0 = xEDiskLruCache;
            this.key = str;
            StringBuilder sb = new StringBuilder(this.key);
            sb.append('.');
            Intrinsics.checkExpressionValueIsNotNull(sb, "StringBuilder(key).append('.')");
            int length2 = sb.length();
            sb.append("json");
            this.cleanFile = new File(xEDiskLruCache.getDirectory(), sb.toString());
            sb.append(DefaultDiskStorage.FileType.TEMP);
            this.dirtyFile = new File(xEDiskLruCache.getDirectory(), sb.toString());
            sb.setLength(length2);
        }

        public final String getKey$engine_core_release() {
            return this.key;
        }

        public final long getLength$engine_core_release() {
            return this.length;
        }

        public final void setLength$engine_core_release(long j) {
            this.length = j;
        }

        public final File getCleanFile$engine_core_release() {
            return this.cleanFile;
        }

        public final void setCleanFile$engine_core_release(File file) {
            Intrinsics.checkParameterIsNotNull(file, "<set-?>");
            this.cleanFile = file;
        }

        public final File getDirtyFile$engine_core_release() {
            return this.dirtyFile;
        }

        public final void setDirtyFile$engine_core_release(File file) {
            Intrinsics.checkParameterIsNotNull(file, "<set-?>");
            this.dirtyFile = file;
        }

        public final boolean getReadable$engine_core_release() {
            return this.readable;
        }

        public final void setReadable$engine_core_release(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie$engine_core_release() {
            return this.zombie;
        }

        public final void setZombie$engine_core_release(boolean z) {
            this.zombie = z;
        }

        public final Editor getCurrentEditor$engine_core_release() {
            return this.currentEditor;
        }

        public final void setCurrentEditor$engine_core_release(Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSourceCount$engine_core_release() {
            return this.lockingSourceCount;
        }

        public final void setLockingSourceCount$engine_core_release(int i) {
            this.lockingSourceCount = i;
        }

        public final long getSequenceNumber$engine_core_release() {
            return this.sequenceNumber;
        }

        public final void setSequenceNumber$engine_core_release(long j) {
            this.sequenceNumber = j;
        }

        public final void setLength$engine_core_release(String str) throws IOException {
            Intrinsics.checkParameterIsNotNull(str, TypedValues.Custom.S_STRING);
            try {
                this.length = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                invalidLengths(str);
                throw null;
            }
        }

        public final void writeLengths$engine_core_release(BufferedSink bufferedSink) throws IOException {
            Intrinsics.checkParameterIsNotNull(bufferedSink, "writer");
            bufferedSink.writeByte(32).writeDecimalLong(this.length);
        }

        private final Void invalidLengths(String str) throws IOException {
            throw new IOException("unexpected journal line: " + str);
        }

        public final Snapshot snapshot$engine_core_release() {
            if (!this.readable) {
                return null;
            }
            if (!this.this$0.f50127j && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            Source newSource = newSource();
            try {
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, newSource, this.length);
            } catch (FileNotFoundException unused) {
                C16883Util.closeQuietly((Closeable) newSource);
                try {
                    this.this$0.removeEntry$engine_core_release(this);
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            }
        }

        private final Source newSource() {
            Source source = this.this$0.getFileSystem$engine_core_release().source(this.cleanFile);
            if (this.this$0.f50127j) {
                return source;
            }
            this.lockingSourceCount++;
            return new XEDiskLruCache$Entry$newSource$1(this, source, source);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/enginecore/cache/XEDiskLruCache$Companion;", "", "()V", "ANY_SEQUENCE_NUMBER", "", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "READ", "REMOVE", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEDiskLruCache.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
