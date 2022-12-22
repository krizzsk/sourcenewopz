package com.didi.payment.kycservice.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/PixSPUtils;", "", "()V", "KEY_PIX_SIGN_UP_GUIDE_SHOW_COUNT", "", "SP_FILE_NAME", "bShowPixSignUpGuide", "", "context", "Landroid/content/Context;", "getSP", "Landroid/content/SharedPreferences;", "updatePixSignUpGuideShowCount", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixSPUtils.kt */
public final class PixSPUtils {
    public static final PixSPUtils INSTANCE = new PixSPUtils();

    /* renamed from: a */
    private static final String f30936a = "pix_sp";

    /* renamed from: b */
    private static final String f30937b = "pix_sign_up_guide_show_count";

    private PixSPUtils() {
    }

    public final boolean bShowPixSignUpGuide(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (m21742a(context).getInt(f30937b, 0) < 2) {
            return true;
        }
        return false;
    }

    public final void updatePixSignUpGuideShowCount(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences a = m21742a(context);
        a.edit().putInt(f30937b, a.getInt(f30937b, 0) + 1).apply();
    }

    /* renamed from: a */
    private final SharedPreferences m21742a(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, f30936a, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
