package com.didi.sdk.global.sign.payselect.utils.handler;

import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.payselect.utils.PaySelUtils;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper;
import com.didi.soda.customer.app.constant.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/utils/handler/BalanceCombineSwitchHandler;", "Lcom/didi/sdk/global/sign/payselect/utils/handler/IHandler;", "()V", "process", "", "pageData", "Lcom/didi/sdk/global/sign/model/local/PaySelPageData;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BalanceCombineSwitchHandler.kt */
public final class BalanceCombineSwitchHandler implements IHandler {
    public void process(PaySelPageData paySelPageData) {
        PaySelItemData paySelItemData;
        PaySelItemData paySelItemData2;
        Intrinsics.checkNotNullParameter(paySelPageData, Const.PageParams.PAGE_DATA);
        List<PaySelItemData> list = paySelPageData.payMethodList;
        if (list != null && !PaySelUtils.INSTANCE.isFrozenMode(paySelPageData.accountFreezeData)) {
            Iterator<PaySelItemData> it = list.iterator();
            while (true) {
                paySelItemData = null;
                if (!it.hasNext()) {
                    paySelItemData2 = null;
                    break;
                }
                paySelItemData2 = it.next();
                PaySelUtils paySelUtils = PaySelUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(paySelItemData2, "item");
                if (paySelUtils.isBalanceCombinedMode(paySelItemData2) && paySelItemData2.style == 3 && paySelItemData2.isPriorityUse) {
                    paySelItemData2.isSelected = paySelItemData2.isPriorityUse;
                    break;
                }
            }
            if (paySelItemData2 != null) {
                boolean z = false;
                for (PaySelItemData next : list) {
                    if (!Intrinsics.areEqual((Object) paySelItemData2, (Object) next)) {
                        if (!PayMethodSelectHelper.canCombine(paySelItemData2, next)) {
                            next.isSelected = false;
                        } else {
                            if (paySelItemData == null) {
                                paySelItemData = next;
                            }
                            if (!z) {
                                z = next.isSelected;
                            }
                        }
                    }
                }
                if (!z && paySelItemData != null) {
                    paySelItemData.isSelected = true;
                }
            }
        }
    }
}
