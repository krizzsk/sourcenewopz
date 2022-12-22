package com.datadog.android.rum.internal.net;

import com.datadog.android.core.internal.CoreFeature;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumOkHttpUploader.kt */
final class RumOkHttpUploader$tags$2 extends Lambda implements Function0<String> {
    public static final RumOkHttpUploader$tags$2 INSTANCE = new RumOkHttpUploader$tags$2();

    RumOkHttpUploader$tags$2() {
        super(0);
    }

    public final String invoke() {
        boolean z = false;
        List mutableListOf = CollectionsKt.mutableListOf(Intrinsics.stringPlus("service:", CoreFeature.INSTANCE.getServiceName$dd_sdk_android_release()), Intrinsics.stringPlus("version:", CoreFeature.INSTANCE.getPackageVersion$dd_sdk_android_release()), "sdk_version:1.11.1", Intrinsics.stringPlus("env:", CoreFeature.INSTANCE.getEnvName$dd_sdk_android_release()));
        if (CoreFeature.INSTANCE.getVariant$dd_sdk_android_release().length() > 0) {
            z = true;
        }
        if (z) {
            mutableListOf.add(Intrinsics.stringPlus("variant:", CoreFeature.INSTANCE.getVariant$dd_sdk_android_release()));
        }
        return CollectionsKt.joinToString$default(mutableListOf, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
