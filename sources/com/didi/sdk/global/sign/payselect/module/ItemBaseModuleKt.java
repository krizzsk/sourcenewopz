package com.didi.sdk.global.sign.payselect.module;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.global.base.FlowLayout;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.payselect.view.LabelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"DLG_TYPE_SWITCH_OUT_99", "", "DLG_TYPE_SWITCH_OUT_COMBINED", "updateFlowLayoutImpl", "", "flowLayLout", "Lcom/didi/sdk/global/base/FlowLayout;", "data", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "payment_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemBaseModule.kt */
public final class ItemBaseModuleKt {

    /* renamed from: a */
    private static final int f36261a = 1;

    /* renamed from: b */
    private static final int f36262b = 2;

    public static final void updateFlowLayoutImpl(FlowLayout flowLayout, PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "data");
        if (flowLayout != null) {
            flowLayout.removeAllViews();
            List<String> list = paySelItemData.cardDiscountTags;
            if (list == null || list.isEmpty()) {
                flowLayout.setVisibility(8);
                return;
            }
            flowLayout.setVisibility(0);
            for (CharSequence charSequence : list) {
                if (!TextUtils.isEmpty(charSequence)) {
                    Context context = flowLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "flowLayLout.context");
                    LabelView labelView = new LabelView(context);
                    labelView.setText(charSequence);
                    flowLayout.addView(labelView);
                }
            }
        }
    }
}
