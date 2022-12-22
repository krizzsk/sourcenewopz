package com.didi.payment.commonsdk.p129ui.helper;

import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\u0005"}, mo175978d2 = {"com/didi/payment/commonsdk/ui/helper/NLEGODialogBuilder$build$1", "Lcom/didi/global/globaluikit/drawer/templatemodel/LEGODrawerModel1;", "convertOthers", "Lcom/didi/global/globaluikit/drawer/LEGODrawerModel;", "model", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.helper.NLEGODialogBuilder$build$1 */
/* compiled from: NLEGODialogBuilder.kt */
public final class NLEGODialogBuilder$build$1 extends LEGODrawerModel1 {
    final /* synthetic */ NLEGODialogBuilder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NLEGODialogBuilder$build$1(NLEGODialogBuilder nLEGODialogBuilder, String str, LEGOBtnTextAndCallback lEGOBtnTextAndCallback) {
        super(str, lEGOBtnTextAndCallback);
        this.this$0 = nLEGODialogBuilder;
    }

    /* access modifiers changed from: protected */
    public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
        if (!(this.this$0.getBtnOrientation() == 1 || lEGODrawerModel == null)) {
            lEGODrawerModel.isTwoBtnHorizontal = true;
        }
        LEGODrawerModel convertOthers = super.convertOthers(lEGODrawerModel);
        Intrinsics.checkNotNullExpressionValue(convertOthers, "super.convertOthers(model)");
        return convertOthers;
    }
}
