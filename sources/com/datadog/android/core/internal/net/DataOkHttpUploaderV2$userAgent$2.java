package com.datadog.android.core.internal.net;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataOkHttpUploaderV2.kt */
final class DataOkHttpUploaderV2$userAgent$2 extends Lambda implements Function0<String> {
    final /* synthetic */ DataOkHttpUploaderV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataOkHttpUploaderV2$userAgent$2(DataOkHttpUploaderV2 dataOkHttpUploaderV2) {
        super(0);
        this.this$0 = dataOkHttpUploaderV2;
    }

    public final String invoke() {
        String property = System.getProperty(DataOkHttpUploader.SYSTEM_UA);
        DataOkHttpUploaderV2 dataOkHttpUploaderV2 = this.this$0;
        CharSequence charSequence = property;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "Datadog/" + dataOkHttpUploaderV2.getSdkVersion$dd_sdk_android_release() + " (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " Build/" + Build.ID + VersionRange.RIGHT_OPEN;
        }
        Intrinsics.checkNotNullExpressionValue(property, "{\n                it\n            }");
        return property;
    }
}
