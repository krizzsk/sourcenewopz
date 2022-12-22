package com.datadog.android.rum.internal.vitals;

import com.datadog.android.core.internal.persistence.file.FileExtKt;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p245io.FilesKt;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/CPUVitalReader;", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "statFile", "Ljava/io/File;", "(Ljava/io/File;)V", "readVitalData", "", "()Ljava/lang/Double;", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPUVitalReader.kt */
public final class CPUVitalReader implements VitalReader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f3897b = "/proc/self/stat";

    /* renamed from: c */
    private static final File f3898c = new File(f3897b);

    /* renamed from: d */
    private static final int f3899d = 13;

    /* renamed from: a */
    private final File f3900a;

    public CPUVitalReader() {
        this((File) null, 1, (DefaultConstructorMarker) null);
    }

    public CPUVitalReader(File file) {
        Intrinsics.checkNotNullParameter(file, "statFile");
        this.f3900a = file;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CPUVitalReader(File file, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? f3898c : file);
    }

    public Double readVitalData() {
        if (!FileExtKt.existsSafe(this.f3900a) || !FileExtKt.canReadSafe(this.f3900a)) {
            return null;
        }
        List split$default = StringsKt.split$default((CharSequence) FilesKt.readText$default(this.f3900a, (Charset) null, 1, (Object) null), new char[]{' '}, false, 0, 6, (Object) null);
        if (split$default.size() > 13) {
            return StringsKt.toDoubleOrNull((String) split$default.get(13));
        }
        return null;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/CPUVitalReader$Companion;", "", "()V", "STAT_FILE", "Ljava/io/File;", "STAT_PATH", "", "UTIME_IDX", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CPUVitalReader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
