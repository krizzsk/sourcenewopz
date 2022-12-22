package com.datadog.android.core.internal.persistence.file;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Ljava/io/File;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FileExt.kt */
final class FileExtKt$lengthSafe$1 extends Lambda implements Function1<File, Long> {
    public static final FileExtKt$lengthSafe$1 INSTANCE = new FileExtKt$lengthSafe$1();

    FileExtKt$lengthSafe$1() {
        super(1);
    }

    public final long invoke(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$safeCall");
        return file.length();
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Long.valueOf(invoke((File) obj));
    }
}
