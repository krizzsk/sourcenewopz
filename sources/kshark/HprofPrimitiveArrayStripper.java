package kshark;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, mo175978d2 = {"Lkshark/HprofPrimitiveArrayStripper;", "", "()V", "stripPrimitiveArrays", "Ljava/io/File;", "inputHprofFile", "outputHprofFile", "shark"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: HprofPrimitiveArrayStripper.kt */
public final class HprofPrimitiveArrayStripper {
    public static /* synthetic */ File stripPrimitiveArrays$default(HprofPrimitiveArrayStripper hprofPrimitiveArrayStripper, File file, File file2, int i, Object obj) {
        if ((i & 2) != 0) {
            String parent = file.getParent();
            String name = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "inputHprofFile.name");
            String replace$default = StringsKt.replace$default(name, ".hprof", "-stripped.hprof", false, 4, (Object) null);
            if (!(!Intrinsics.areEqual((Object) replace$default, (Object) file.getName()))) {
                replace$default = file.getName() + "-stripped";
            }
            file2 = new File(parent, replace$default);
        }
        return hprofPrimitiveArrayStripper.stripPrimitiveArrays(file, file2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File stripPrimitiveArrays(java.io.File r8, java.io.File r9) {
        /*
            r7 = this;
            java.lang.String r0 = "inputHprofFile"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "outputHprofFile"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            kshark.Hprof$Companion r0 = kshark.Hprof.Companion
            kshark.Hprof r8 = r0.open(r8)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r0 = 0
            r1 = r0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r8
            kshark.Hprof r2 = (kshark.Hprof) r2     // Catch:{ all -> 0x005a }
            kshark.HprofReader r3 = r2.getReader()     // Catch:{ all -> 0x005a }
            kshark.HprofWriter$Companion r4 = kshark.HprofWriter.Companion     // Catch:{ all -> 0x005a }
            int r5 = r3.getIdentifierByteSize()     // Catch:{ all -> 0x005a }
            kshark.Hprof$HprofVersion r2 = r2.getHprofVersion()     // Catch:{ all -> 0x005a }
            kshark.HprofWriter r2 = r4.open(r9, r5, r2)     // Catch:{ all -> 0x005a }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x005a }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x005a }
            r4 = r2
            kshark.HprofWriter r4 = (kshark.HprofWriter) r4     // Catch:{ all -> 0x0053 }
            java.lang.Class<kshark.HprofRecord> r5 = kshark.HprofRecord.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.C21490Reflection.getOrCreateKotlinClass(r5)     // Catch:{ all -> 0x0053 }
            java.util.Set r5 = kotlin.collections.SetsKt.setOf(r5)     // Catch:{ all -> 0x0053 }
            kshark.OnHprofRecordListener$Companion r6 = kshark.OnHprofRecordListener.Companion     // Catch:{ all -> 0x0053 }
            kshark.HprofPrimitiveArrayStripper$$special$$inlined$invoke$1 r6 = new kshark.HprofPrimitiveArrayStripper$$special$$inlined$invoke$1     // Catch:{ all -> 0x0053 }
            r6.<init>(r4)     // Catch:{ all -> 0x0053 }
            kshark.OnHprofRecordListener r6 = (kshark.OnHprofRecordListener) r6     // Catch:{ all -> 0x0053 }
            r3.readHprofRecords(r5, r6)     // Catch:{ all -> 0x0053 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0053 }
            kotlin.p245io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x005a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005a }
            kotlin.p245io.CloseableKt.closeFinally(r8, r1)
            return r9
        L_0x0053:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r2, r9)     // Catch:{ all -> 0x005a }
            throw r0     // Catch:{ all -> 0x005a }
        L_0x005a:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x005c }
        L_0x005c:
            r0 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kshark.HprofPrimitiveArrayStripper.stripPrimitiveArrays(java.io.File, java.io.File):java.io.File");
    }
}
