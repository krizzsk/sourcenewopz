package com.didi.sdk.global.sign.payselect.module;

import com.didi.sdk.global.sign.model.local.PaySelItemData;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/IPayModule;", "", "isSelectable", "", "performClick", "", "targetItem", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "refreshUI", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IPayModule.kt */
public interface IPayModule {
    boolean isSelectable();

    void performClick(PaySelItemData paySelItemData);

    void refreshUI();
}
