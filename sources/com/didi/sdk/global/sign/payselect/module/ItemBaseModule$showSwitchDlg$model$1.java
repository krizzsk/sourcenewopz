package com.didi.sdk.global.sign.payselect.module;

import android.view.View;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.sdk.global.sign.payselect.utils.PaySelUT;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/sdk/global/sign/payselect/module/ItemBaseModule$showSwitchDlg$model$1", "Lcom/didi/global/globaluikit/callback/LEGOOnAntiShakeClickListener;", "onAntiShakeClick", "", "p0", "Landroid/view/View;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemBaseModule.kt */
public final class ItemBaseModule$showSwitchDlg$model$1 extends LEGOOnAntiShakeClickListener {
    final /* synthetic */ String $channelIds4UT;
    final /* synthetic */ int $dlgType;
    final /* synthetic */ ItemBaseModule this$0;

    ItemBaseModule$showSwitchDlg$model$1(ItemBaseModule itemBaseModule, int i, String str) {
        this.this$0 = itemBaseModule;
        this.$dlgType = i;
        this.$channelIds4UT = str;
    }

    public void onAntiShakeClick(View view) {
        this.this$0.m25642a();
        if (this.$dlgType == 2) {
            PaySelUT.INSTANCE.trackDlgOKBtn("fin_pmmethod_combinepopup_ck", this.$channelIds4UT);
        } else {
            PaySelUT.INSTANCE.trackDlgOKBtn("fin_pmmethod_retrievepopup_ck", this.$channelIds4UT);
        }
    }
}
