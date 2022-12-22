package com.datadog.android.core.internal.net;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataOkHttpUploader.kt */
final class DataOkHttpUploader$userAgent$2 extends Lambda implements Function0<String> {
    public static final DataOkHttpUploader$userAgent$2 INSTANCE = new DataOkHttpUploader$userAgent$2();

    DataOkHttpUploader$userAgent$2() {
        super(0);
    }

    public final String invoke() {
        String property = System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        CharSequence charSequence = property;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "Datadog/1.11.1 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " Build/" + Build.ID + VersionRange.RIGHT_OPEN;
        }
        Intrinsics.checkNotNullExpressionValue(property, "{\n                it\n            }");
        return property;
    }
}
