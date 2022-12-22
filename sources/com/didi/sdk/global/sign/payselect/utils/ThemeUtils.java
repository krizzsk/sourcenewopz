package com.didi.sdk.global.sign.payselect.utils;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/utils/ThemeUtils;", "", "()V", "TERMINAL_ID_BRAZIL", "", "TERMINAL_ID_GLOBAL", "inflate", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "parentView", "resId", "", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThemeUtils.kt */
public final class ThemeUtils {
    public static final ThemeUtils INSTANCE = new ThemeUtils();

    /* renamed from: a */
    private static final String f36284a = "5";

    /* renamed from: b */
    private static final String f36285b = "7";

    private ThemeUtils() {
    }

    public final ViewGroup inflate(Context context, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        String terminalId = WalletCommonParamsUtil.getTerminalId(context);
        Intrinsics.checkNotNullExpressionValue(terminalId, DCryptoUtils.PARAMS_KEY_TERMINAL_ID);
        View inflate = LayoutInflater.from(context).cloneInContext(new ContextThemeWrapper(context, terminalId.contentEquals("5") ? R.style.payment_theme_ext_brazil : R.style.payment_theme_ext_global)).inflate(i, viewGroup, true);
        if (inflate != null) {
            return (ViewGroup) inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
