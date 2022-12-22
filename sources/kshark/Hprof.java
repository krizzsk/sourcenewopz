package kshark;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kshark.SharkLog;
import okio.BufferedSource;
import okio.Okio;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lkshark/Hprof;", "Ljava/io/Closeable;", "channel", "Ljava/nio/channels/FileChannel;", "source", "Lokio/BufferedSource;", "reader", "Lkshark/HprofReader;", "heapDumpTimestamp", "", "hprofVersion", "Lkshark/Hprof$HprofVersion;", "fileLength", "(Ljava/nio/channels/FileChannel;Lokio/BufferedSource;Lkshark/HprofReader;JLkshark/Hprof$HprofVersion;J)V", "getFileLength", "()J", "getHeapDumpTimestamp", "getHprofVersion", "()Lkshark/Hprof$HprofVersion;", "getReader", "()Lkshark/HprofReader;", "close", "", "moveReaderTo", "newPosition", "Companion", "HprofVersion", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: Hprof.kt */
public final class Hprof implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Map<String, HprofVersion> f4541g;

    /* renamed from: a */
    private final FileChannel f4542a;

    /* renamed from: b */
    private final BufferedSource f4543b;

    /* renamed from: c */
    private final HprofReader f4544c;

    /* renamed from: d */
    private final long f4545d;

    /* renamed from: e */
    private final HprofVersion f4546e;

    /* renamed from: f */
    private final long f4547f;

    private Hprof(FileChannel fileChannel, BufferedSource bufferedSource, HprofReader hprofReader, long j, HprofVersion hprofVersion, long j2) {
        this.f4542a = fileChannel;
        this.f4543b = bufferedSource;
        this.f4544c = hprofReader;
        this.f4545d = j;
        this.f4546e = hprofVersion;
        this.f4547f = j2;
    }

    public /* synthetic */ Hprof(FileChannel fileChannel, BufferedSource bufferedSource, HprofReader hprofReader, long j, HprofVersion hprofVersion, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileChannel, bufferedSource, hprofReader, j, hprofVersion, j2);
    }

    public final HprofReader getReader() {
        return this.f4544c;
    }

    public final long getHeapDumpTimestamp() {
        return this.f4545d;
    }

    public final HprofVersion getHprofVersion() {
        return this.f4546e;
    }

    public final long getFileLength() {
        return this.f4547f;
    }

    public void close() {
        this.f4543b.close();
    }

    public final void moveReaderTo(long j) {
        if (this.f4544c.getPosition() != j) {
            this.f4543b.buffer().clear();
            this.f4542a.position(j);
            this.f4544c.setPosition$shark(j);
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo175978d2 = {"Lkshark/Hprof$HprofVersion;", "", "versionString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getVersionString", "()Ljava/lang/String;", "JDK1_2_BETA3", "JDK1_2_BETA4", "JDK_6", "ANDROID", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: Hprof.kt */
    public enum HprofVersion {
        JDK1_2_BETA3("JAVA PROFILE 1.0"),
        JDK1_2_BETA4("JAVA PROFILE 1.0.1"),
        JDK_6("JAVA PROFILE 1.0.2"),
        ANDROID("JAVA PROFILE 1.0.3");
        
        private final String versionString;

        private HprofVersion(String str) {
            this.versionString = str;
        }

        public final String getVersionString() {
            return this.versionString;
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lkshark/Hprof$Companion;", "", "()V", "supportedVersions", "", "", "Lkshark/Hprof$HprofVersion;", "open", "Lkshark/Hprof;", "hprofFile", "Ljava/io/File;", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: Hprof.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Hprof open(File file) {
            Intrinsics.checkParameterIsNotNull(file, "hprofFile");
            long length = file.length();
            if (length != 0) {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileChannel channel = fileInputStream.getChannel();
                BufferedSource buffer = Okio.buffer(Okio.source((InputStream) fileInputStream));
                boolean z = false;
                long indexOf = buffer.indexOf((byte) 0);
                String readUtf8 = buffer.readUtf8(indexOf);
                HprofVersion hprofVersion = (HprofVersion) Hprof.f4541g.get(readUtf8);
                if (hprofVersion != null) {
                    z = true;
                }
                if (z) {
                    buffer.skip(1);
                    int readInt = buffer.readInt();
                    SharkLog.Logger logger = SharkLog.INSTANCE.getLogger();
                    if (logger != null) {
                        logger.mo23715d("identifierByteSize:" + readInt);
                    }
                    long readLong = buffer.readLong();
                    Intrinsics.checkExpressionValueIsNotNull(buffer, "source");
                    HprofReader hprofReader = new HprofReader(buffer, readInt, indexOf + 1 + ((long) 4) + ((long) 8));
                    Intrinsics.checkExpressionValueIsNotNull(channel, "channel");
                    return new Hprof(channel, buffer, hprofReader, readLong, hprofVersion, length, (DefaultConstructorMarker) null);
                }
                throw new IllegalArgumentException(("Unsupported Hprof version [" + readUtf8 + "] not in supported list " + Hprof.f4541g.keySet()).toString());
            }
            throw new IllegalArgumentException("Hprof file is 0 byte length");
        }
    }

    static {
        HprofVersion[] values = HprofVersion.values();
        Collection arrayList = new ArrayList(values.length);
        for (HprofVersion hprofVersion : values) {
            arrayList.add(TuplesKt.m42317to(hprofVersion.getVersionString(), hprofVersion));
        }
        f4541g = MapsKt.toMap((List) arrayList);
    }
}
