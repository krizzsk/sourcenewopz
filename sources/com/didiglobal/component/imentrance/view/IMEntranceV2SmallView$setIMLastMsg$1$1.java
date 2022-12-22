package com.didiglobal.component.imentrance.view;

import android.view.View;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.imentrance.AbsIMEntrancePresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMEntranceV2SmallView.kt */
final class IMEntranceV2SmallView$setIMLastMsg$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ IMEntranceV2SmallView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IMEntranceV2SmallView$setIMLastMsg$1$1(IMEntranceV2SmallView iMEntranceV2SmallView) {
        super(1);
        this.this$0 = iMEntranceV2SmallView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "$noName_0");
        AbsIMEntrancePresenter access$getMPresenter$p$s1508161750 = this.this$0.mPresenter;
        if (access$getMPresenter$p$s1508161750 != null) {
            access$getMPresenter$p$s1508161750.startIMActivity();
            access$getMPresenter$p$s1508161750.notifyShowMsgBubble(false);
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_driverimnotice_ck", "type", "2");
    }
}
