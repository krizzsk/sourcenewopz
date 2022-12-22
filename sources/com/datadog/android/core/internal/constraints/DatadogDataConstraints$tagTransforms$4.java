package com.datadog.android.core.internal.constraints;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "", "it"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogDataConstraints.kt */
final class DatadogDataConstraints$tagTransforms$4 extends Lambda implements Function1<String, String> {
    public static final DatadogDataConstraints$tagTransforms$4 INSTANCE = new DatadogDataConstraints$tagTransforms$4();

    DatadogDataConstraints$tagTransforms$4() {
        super(1);
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        CharSequence charSequence = str;
        if (!StringsKt.endsWith$default(charSequence, ':', false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, StringsKt.getLastIndex(charSequence));
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }
}
