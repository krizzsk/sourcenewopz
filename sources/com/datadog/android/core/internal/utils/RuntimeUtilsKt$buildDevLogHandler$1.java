package com.datadog.android.core.internal.utils;

import com.datadog.android.Datadog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, mo175978d2 = {"<anonymous>", "", "i", "", "<anonymous parameter 1>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RuntimeUtils.kt */
final class RuntimeUtilsKt$buildDevLogHandler$1 extends Lambda implements Function2<Integer, Throwable, Boolean> {
    public static final RuntimeUtilsKt$buildDevLogHandler$1 INSTANCE = new RuntimeUtilsKt$buildDevLogHandler$1();

    RuntimeUtilsKt$buildDevLogHandler$1() {
        super(2);
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        return Boolean.valueOf(invoke(((Number) obj).intValue(), (Throwable) obj2));
    }

    public final boolean invoke(int i, Throwable th) {
        return i >= Datadog.INSTANCE.getLibraryVerbosity$dd_sdk_android_release();
    }
}
