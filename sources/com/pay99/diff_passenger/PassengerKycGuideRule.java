package com.pay99.diff_passenger;

import android.app.Application;
import com.didi.drouter.api.DRouter;
import com.pay99.diff_base.base.IKycGuideRule;
import com.pay99.diff_passenger.utils.PixSPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, mo175978d2 = {"Lcom/pay99/diff_passenger/PassengerKycGuideRule;", "Lcom/pay99/diff_base/base/IKycGuideRule;", "()V", "showGuideRule", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PassengerKycGuideRule.kt */
public final class PassengerKycGuideRule implements IKycGuideRule {
    public boolean showGuideRule() {
        PixSPUtils pixSPUtils = PixSPUtils.INSTANCE;
        Application context = DRouter.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        boolean bShowPixSignUpGuide = pixSPUtils.bShowPixSignUpGuide(context);
        if (bShowPixSignUpGuide) {
            PixSPUtils pixSPUtils2 = PixSPUtils.INSTANCE;
            Application context2 = DRouter.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            pixSPUtils2.updatePixSignUpGuideShowCount(context2);
        }
        return bShowPixSignUpGuide;
    }
}
