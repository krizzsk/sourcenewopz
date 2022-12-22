package com.datadog.android.log;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Logger.kt */
final class Logger$removeTagsWithKey$1 extends Lambda implements Function1<String, Boolean> {
    final /* synthetic */ String $prefix;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Logger$removeTagsWithKey$1(String str) {
        super(1);
        this.$prefix = str;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((String) obj));
    }

    public final boolean invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return StringsKt.startsWith$default(str, this.$prefix, false, 2, (Object) null);
    }
}
