package com.didi.payment.wallet.global.prepaidcard;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.password.PasswordScene;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/VerifyPwdUtil;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VerifyPwdUtil.kt */
public final class VerifyPwdUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/VerifyPwdUtil$Companion;", "", "()V", "handlePwdVerify", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "netModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "bundle", "Landroid/os/Bundle;", "pwdType", "", "callback", "Lcom/didi/payment/wallet/global/prepaidcard/IPwdVerify;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: VerifyPwdUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void handlePwdVerify(FragmentActivity fragmentActivity, WalletPageModel walletPageModel, Bundle bundle, String str, IPwdVerify iPwdVerify) {
            FragmentManager supportFragmentManager;
            Intrinsics.checkNotNullParameter(walletPageModel, "netModel");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (Intrinsics.areEqual((Object) str, (Object) "1")) {
                String string = bundle.getString("pay_session_id");
                if (string == null) {
                    string = "";
                }
                OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
                Intrinsics.checkNotNullExpressionValue(openCertificationListener, "listener");
                PaySecure.INSTANCE.verifyPayPassword(PasswordScene.PREPAY_CARD_ACTIVATION.name(), string, "", new VerifyPwdUtil$Companion$handlePwdVerify$1(iPwdVerify, fragmentActivity, bundle, walletPageModel), openCertificationListener);
            } else if (Intrinsics.areEqual((Object) str, (Object) "2") && fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                CardPwdManager.INSTANCE.showCardPasswordDialog(supportFragmentManager, bundle, new VerifyPwdUtil$Companion$handlePwdVerify$2$1(iPwdVerify));
            }
        }
    }
}
