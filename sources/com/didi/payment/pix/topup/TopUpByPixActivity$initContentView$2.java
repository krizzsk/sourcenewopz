package com.didi.payment.pix.topup;

import androidx.core.content.ContextCompat;
import com.didi.payment.commonsdk.widget.WalletAmountEditText;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "onExceed", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopUpByPixActivity.kt */
final class TopUpByPixActivity$initContentView$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TopUpByPixActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopUpByPixActivity$initContentView$2(TopUpByPixActivity topUpByPixActivity) {
        super(1);
        this.this$0 = topUpByPixActivity;
    }

    public /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        WalletAmountEditText walletAmountEditText = null;
        if (z) {
            WalletAmountEditText access$getEtAmount$p = this.this$0.f31211b;
            if (access$getEtAmount$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etAmount");
            } else {
                walletAmountEditText = access$getEtAmount$p;
            }
            walletAmountEditText.setExtraTextColor(ContextCompat.getColor(this.this$0, R.color.wallet_color_FF4060));
            return;
        }
        WalletAmountEditText access$getEtAmount$p2 = this.this$0.f31211b;
        if (access$getEtAmount$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etAmount");
        } else {
            walletAmountEditText = access$getEtAmount$p2;
        }
        walletAmountEditText.setExtraTextColor(ContextCompat.getColor(this.this$0, R.color.wallet_color_666666));
    }
}
