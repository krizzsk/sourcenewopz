package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.content.Context;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/PasswordDialog;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/IDialogManager;", "()V", "read", "", "context", "Landroid/content/Context;", "write", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.PasswordDialog */
/* compiled from: WalletHomeDialogManager.kt */
public final class PasswordDialog implements IDialogManager {
    public boolean read(Context context) {
        Boolean canRequestPwd = WalletSPUtils.getCanRequestPwd(context, WalletCommonParamsUtil.getToken(context));
        Intrinsics.checkNotNullExpressionValue(canRequestPwd, "getCanRequestPwd(context…msUtil.getToken(context))");
        return canRequestPwd.booleanValue() && WalletSPUtils.getPayPwdGuideShowCount(WalletCommonParamsUtil.getToken(context), context) < 3;
    }

    public void write(Context context) {
        WalletSPUtils.savePayPwdGuideShowCount(WalletCommonParamsUtil.getToken(context), context);
        WalletSPUtils.saveCanRequestPwd(context, WalletCommonParamsUtil.getToken(context), false);
    }
}
