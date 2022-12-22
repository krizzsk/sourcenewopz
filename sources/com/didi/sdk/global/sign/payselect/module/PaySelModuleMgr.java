package com.didi.sdk.global.sign.payselect.module;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.global.base.module.BizModule;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.soda.customer.app.constant.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\bR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/PaySelModuleMgr;", "", "()V", "groupModules", "Ljava/util/ArrayList;", "Lcom/didi/sdk/global/sign/payselect/module/GroupBaseModule;", "Lkotlin/collections/ArrayList;", "addModule", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "pageData", "Lcom/didi/sdk/global/sign/model/local/PaySelPageData;", "hasSelectablePayItem", "", "performClick", "itemData", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "updateUI", "Companion", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaySelModuleMgr.kt */
public final class PaySelModuleMgr {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final ArrayList<GroupBaseModule> f36275a = new ArrayList<>();

    public final void addModule(FragmentActivity fragmentActivity, ViewGroup viewGroup, PaySelPageData paySelPageData) {
        GroupBaseModule groupBaseModule;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(paySelPageData, Const.PageParams.PAGE_DATA);
        if (paySelPageData.payMethodList != null && !paySelPageData.payMethodList.isEmpty() && paySelPageData.groupList != null && !paySelPageData.groupList.isEmpty()) {
            viewGroup.removeAllViews();
            for (GroupBaseModule detach : this.f36275a) {
                detach.detach();
            }
            this.f36275a.clear();
            List<PaySelGroupData> list = paySelPageData.groupList;
            Intrinsics.checkNotNullExpressionValue(list, "groupList");
            for (PaySelGroupData paySelGroupData : list) {
                if (paySelGroupData.channelIds != null) {
                    int[] iArr = paySelGroupData.channelIds;
                    Intrinsics.checkNotNullExpressionValue(iArr, "it.channelIds");
                    if (!(iArr.length == 0)) {
                        groupBaseModule = MainGroupModule.Companion.create(fragmentActivity, viewGroup);
                        GroupBaseModule groupBaseModule2 = groupBaseModule;
                        Intrinsics.checkNotNullExpressionValue(paySelGroupData, "it");
                        BizModule.bindData$default(groupBaseModule2, paySelGroupData, 0, 2, (Object) null);
                        this.f36275a.add(groupBaseModule2);
                    }
                }
                groupBaseModule = OtherGroupModule.Companion.create(fragmentActivity, viewGroup);
                GroupBaseModule groupBaseModule22 = groupBaseModule;
                Intrinsics.checkNotNullExpressionValue(paySelGroupData, "it");
                BizModule.bindData$default(groupBaseModule22, paySelGroupData, 0, 2, (Object) null);
                this.f36275a.add(groupBaseModule22);
            }
        }
    }

    public final void updateUI() {
        for (GroupBaseModule refreshUI : this.f36275a) {
            refreshUI.refreshUI();
        }
    }

    public final void performClick(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "itemData");
        for (GroupBaseModule performClick : this.f36275a) {
            performClick.performClick(paySelItemData);
        }
    }

    public final boolean hasSelectablePayItem() {
        for (GroupBaseModule isSelectable : this.f36275a) {
            if (isSelectable.isSelectable()) {
                return true;
            }
        }
        return false;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/PaySelModuleMgr$Companion;", "", "()V", "create", "Lcom/didi/sdk/global/base/module/BizModule;", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "data", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PaySelModuleMgr.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BizModule<PaySelItemData> create(FragmentActivity fragmentActivity, ViewGroup viewGroup, PaySelItemData paySelItemData) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(paySelItemData, "data");
            int i = paySelItemData.channelId;
            if (i != 120) {
                if (i != 150) {
                    if (i != 190) {
                        return ThirdItemModule.Companion.create(fragmentActivity, viewGroup);
                    }
                } else if (paySelItemData.isAddCreditCard()) {
                    return AddCardItemModule.Companion.create(fragmentActivity, viewGroup);
                } else {
                    return CardItemModule.Companion.create(fragmentActivity, viewGroup);
                }
            }
            return BalanceItemModule.Companion.create(fragmentActivity, viewGroup);
        }
    }
}
