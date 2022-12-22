package com.adyen.checkout.adyen3ds2.connection;

import com.adyen.checkout.core.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, mo175978d2 = {"ENDPOINT", "", "TAG", "3ds2_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubmitFingerprintConnection.kt */
public final class SubmitFingerprintConnectionKt {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f543a;

    /* renamed from: b */
    private static final String f544b = "v1/submitThreeDS2Fingerprint?token=";

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        f543a = tag;
    }
}
