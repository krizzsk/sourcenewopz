package com.datadog.android.core.internal.persistence.file;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a*\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0004H\n"}, mo175978d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "Ljava/io/File;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FileExt.kt */
final class FileExtKt$listSafe$1 extends Lambda implements Function1<File, String[]> {
    public static final FileExtKt$listSafe$1 INSTANCE = new FileExtKt$listSafe$1();

    FileExtKt$listSafe$1() {
        super(1);
    }

    public final String[] invoke(File file) {
        Intrinsics.checkNotNullParameter(file, "$this$safeCall");
        return file.list();
    }
}
