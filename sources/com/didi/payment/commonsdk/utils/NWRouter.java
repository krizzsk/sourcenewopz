package com.didi.payment.commonsdk.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NWRouter;", "", "()V", "go2PixKeyListPage", "", "context", "Landroid/content/Context;", "gotoPDFPage", "activity", "Landroidx/fragment/app/FragmentActivity;", "pdfUrl", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NWRouter.kt */
public final class NWRouter {
    public static final NWRouter INSTANCE = new NWRouter();

    private NWRouter() {
    }

    public final void gotoPDFPage(FragmentActivity fragmentActivity, String str) {
        String stringPlus = Intrinsics.stringPlus("https://docs.google.com/viewer?embedded=true&url=", str);
        if (str != null) {
            if (StringsKt.endsWith(str, ".pdf", true)) {
                str = stringPlus;
            }
            stringPlus = str;
        }
        if (WalletCommonParamsUtil.is99PayClient()) {
            IWebViewStart service = DRouter.build(IWebViewStart.class).setAlias(IWebViewStart.WEB_99PAY_ALIAS).getService(new Object[0]);
            if (service != null) {
                service.open(fragmentActivity, stringPlus, "");
            }
        } else if (WalletCommonParamsUtil.isDriverClient()) {
            IWebViewStart service2 = DRouter.build(IWebViewStart.class).setAlias(IWebViewStart.WEB_DRIVER_ALIAS).getService(new Object[0]);
            if (service2 != null) {
                service2.open(fragmentActivity, stringPlus, "");
            }
        } else {
            WebBrowserUtil.startInternalWebActivity(fragmentActivity, stringPlus, "");
        }
    }

    public final void go2PixKeyListPage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DRouter.build("99pay://one/pix_key_manager").start(context);
    }
}
