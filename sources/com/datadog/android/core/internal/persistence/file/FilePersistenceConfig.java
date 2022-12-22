package com.datadog.android.core.internal.persistence.file;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig;", "", "recentDelayMs", "", "maxBatchSize", "maxItemSize", "maxItemsPerBatch", "", "oldFileThreshold", "maxDiskSpace", "(JJJIJJ)V", "getMaxBatchSize", "()J", "getMaxDiskSpace", "getMaxItemSize", "getMaxItemsPerBatch", "()I", "getOldFileThreshold", "getRecentDelayMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilePersistenceConfig.kt */
public final class FilePersistenceConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MAX_BATCH_SIZE = 4194304;
    public static final long MAX_DELAY_BETWEEN_MESSAGES_MS = 5000;
    public static final long MAX_DISK_SPACE = 536870912;
    public static final int MAX_ITEMS_PER_BATCH = 500;
    public static final long MAX_ITEMS_SIZE = 524288;
    public static final long OLD_FILE_THRESHOLD = 64800000;

    /* renamed from: a */
    private final long f3515a;

    /* renamed from: b */
    private final long f3516b;

    /* renamed from: c */
    private final long f3517c;

    /* renamed from: d */
    private final int f3518d;

    /* renamed from: e */
    private final long f3519e;

    /* renamed from: f */
    private final long f3520f;

    public FilePersistenceConfig() {
        this(0, 0, 0, 0, 0, 0, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FilePersistenceConfig copy$default(FilePersistenceConfig filePersistenceConfig, long j, long j2, long j3, int i, long j4, long j5, int i2, Object obj) {
        FilePersistenceConfig filePersistenceConfig2 = filePersistenceConfig;
        return filePersistenceConfig.copy((i2 & 1) != 0 ? filePersistenceConfig2.f3515a : j, (i2 & 2) != 0 ? filePersistenceConfig2.f3516b : j2, (i2 & 4) != 0 ? filePersistenceConfig2.f3517c : j3, (i2 & 8) != 0 ? filePersistenceConfig2.f3518d : i, (i2 & 16) != 0 ? filePersistenceConfig2.f3519e : j4, (i2 & 32) != 0 ? filePersistenceConfig2.f3520f : j5);
    }

    public final long component1() {
        return this.f3515a;
    }

    public final long component2() {
        return this.f3516b;
    }

    public final long component3() {
        return this.f3517c;
    }

    public final int component4() {
        return this.f3518d;
    }

    public final long component5() {
        return this.f3519e;
    }

    public final long component6() {
        return this.f3520f;
    }

    public final FilePersistenceConfig copy(long j, long j2, long j3, int i, long j4, long j5) {
        return new FilePersistenceConfig(j, j2, j3, i, j4, j5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePersistenceConfig)) {
            return false;
        }
        FilePersistenceConfig filePersistenceConfig = (FilePersistenceConfig) obj;
        return this.f3515a == filePersistenceConfig.f3515a && this.f3516b == filePersistenceConfig.f3516b && this.f3517c == filePersistenceConfig.f3517c && this.f3518d == filePersistenceConfig.f3518d && this.f3519e == filePersistenceConfig.f3519e && this.f3520f == filePersistenceConfig.f3520f;
    }

    public int hashCode() {
        return (((((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3515a) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3516b)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3517c)) * 31) + this.f3518d) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3519e)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3520f);
    }

    public String toString() {
        return "FilePersistenceConfig(recentDelayMs=" + this.f3515a + ", maxBatchSize=" + this.f3516b + ", maxItemSize=" + this.f3517c + ", maxItemsPerBatch=" + this.f3518d + ", oldFileThreshold=" + this.f3519e + ", maxDiskSpace=" + this.f3520f + VersionRange.RIGHT_OPEN;
    }

    public FilePersistenceConfig(long j, long j2, long j3, int i, long j4, long j5) {
        this.f3515a = j;
        this.f3516b = j2;
        this.f3517c = j3;
        this.f3518d = i;
        this.f3519e = j4;
        this.f3520f = j5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FilePersistenceConfig(long r12, long r14, long r16, int r18, long r19, long r21, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23 & 1
            if (r0 == 0) goto L_0x0007
            r0 = 5000(0x1388, double:2.4703E-320)
            goto L_0x0008
        L_0x0007:
            r0 = r12
        L_0x0008:
            r2 = r23 & 2
            if (r2 == 0) goto L_0x0010
            r2 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x0011
        L_0x0010:
            r2 = r14
        L_0x0011:
            r4 = r23 & 4
            if (r4 == 0) goto L_0x0019
            r4 = 524288(0x80000, double:2.590327E-318)
            goto L_0x001b
        L_0x0019:
            r4 = r16
        L_0x001b:
            r6 = r23 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 500(0x1f4, float:7.0E-43)
            goto L_0x0024
        L_0x0022:
            r6 = r18
        L_0x0024:
            r7 = r23 & 16
            if (r7 == 0) goto L_0x002c
            r7 = 64800000(0x3dcc500, double:3.2015454E-316)
            goto L_0x002e
        L_0x002c:
            r7 = r19
        L_0x002e:
            r9 = r23 & 32
            if (r9 == 0) goto L_0x0036
            r9 = 536870912(0x20000000, double:2.652494739E-315)
            goto L_0x0038
        L_0x0036:
            r9 = r21
        L_0x0038:
            r12 = r11
            r13 = r0
            r15 = r2
            r17 = r4
            r19 = r6
            r20 = r7
            r22 = r9
            r12.<init>(r13, r15, r17, r19, r20, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.core.internal.persistence.file.FilePersistenceConfig.<init>(long, long, long, int, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getRecentDelayMs() {
        return this.f3515a;
    }

    public final long getMaxBatchSize() {
        return this.f3516b;
    }

    public final long getMaxItemSize() {
        return this.f3517c;
    }

    public final int getMaxItemsPerBatch() {
        return this.f3518d;
    }

    public final long getOldFileThreshold() {
        return this.f3519e;
    }

    public final long getMaxDiskSpace() {
        return this.f3520f;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/datadog/android/core/internal/persistence/file/FilePersistenceConfig$Companion;", "", "()V", "MAX_BATCH_SIZE", "", "MAX_DELAY_BETWEEN_MESSAGES_MS", "MAX_DISK_SPACE", "MAX_ITEMS_PER_BATCH", "", "MAX_ITEMS_SIZE", "OLD_FILE_THRESHOLD", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FilePersistenceConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
