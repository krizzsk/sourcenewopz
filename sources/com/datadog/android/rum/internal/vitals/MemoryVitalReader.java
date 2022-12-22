package com.datadog.android.rum.internal.vitals;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/MemoryVitalReader;", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "statusFile", "Ljava/io/File;", "(Ljava/io/File;)V", "readVitalData", "", "()Ljava/lang/Double;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MemoryVitalReader.kt */
public final class MemoryVitalReader implements VitalReader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f3901b = "/proc/self/status";

    /* renamed from: c */
    private static final File f3902c = new File(f3901b);

    /* renamed from: d */
    private static final String f3903d = "VmRSS:\\s+(\\d+) kB";

    /* renamed from: e */
    private static final Regex f3904e = new Regex(f3903d);

    /* renamed from: a */
    private final File f3905a;

    public MemoryVitalReader() {
        this((File) null, 1, (DefaultConstructorMarker) null);
    }

    public MemoryVitalReader(File file) {
        Intrinsics.checkNotNullParameter(file, "statusFile");
        this.f3905a = file;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MemoryVitalReader(File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? f3902c : file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003e, code lost:
        r4 = r4.getGroupValues();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Double readVitalData() {
        /*
            r6 = this;
            java.io.File r0 = r6.f3905a
            boolean r0 = com.datadog.android.core.internal.persistence.file.FileExtKt.existsSafe(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0072
            java.io.File r0 = r6.f3905a
            boolean r0 = com.datadog.android.core.internal.persistence.file.FileExtKt.canReadSafe(r0)
            if (r0 != 0) goto L_0x0012
            goto L_0x0072
        L_0x0012:
            java.io.File r0 = r6.f3905a
            r2 = 1
            java.util.List r0 = kotlin.p245io.FilesKt.readLines$default(r0, r1, r2, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x0026:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            kotlin.text.Regex r5 = f3904e
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            kotlin.text.MatchResult r4 = r5.matchEntire(r4)
            if (r4 != 0) goto L_0x003e
        L_0x003c:
            r4 = r1
            goto L_0x004b
        L_0x003e:
            java.util.List r4 = r4.getGroupValues()
            if (r4 != 0) goto L_0x0045
            goto L_0x003c
        L_0x0045:
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r4 = (java.lang.String) r4
        L_0x004b:
            if (r4 == 0) goto L_0x0026
            r3.add(r4)
            goto L_0x0026
        L_0x0051:
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x005d
            r0 = r1
            goto L_0x0061
        L_0x005d:
            java.lang.Double r0 = kotlin.text.StringsKt.toDoubleOrNull(r0)
        L_0x0061:
            if (r0 != 0) goto L_0x0064
            return r1
        L_0x0064:
            double r0 = r0.doubleValue()
            r2 = 1000(0x3e8, float:1.401E-42)
            double r2 = (double) r2
            double r0 = r0 * r2
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            return r0
        L_0x0072:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.vitals.MemoryVitalReader.readVitalData():java.lang.Double");
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/MemoryVitalReader$Companion;", "", "()V", "STATUS_FILE", "Ljava/io/File;", "STATUS_PATH", "", "VM_RSS_PATTERN", "VM_RSS_REGEX", "Lkotlin/text/Regex;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MemoryVitalReader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
