package com.didi.sdk.global.sign.payselect.module;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.global.base.module.BizModule;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000ej\b\u0012\u0004\u0012\u00020\u0003`\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/GroupBaseModule;", "Lcom/didi/sdk/global/base/module/BizModule;", "Lcom/didi/sdk/global/sign/model/local/PaySelGroupData;", "Lcom/didi/sdk/global/sign/payselect/module/IPayModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "itemModules", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemModules", "()Ljava/util/ArrayList;", "detach", "", "isSelectable", "", "performClick", "targetItem", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "refreshUI", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GroupBaseModule.kt */
public abstract class GroupBaseModule extends BizModule<PaySelGroupData> implements IPayModule {

    /* renamed from: a */
    private final FragmentActivity f36248a;

    /* renamed from: b */
    private final ArrayList<IPayModule> f36249b = new ArrayList<>();

    public final FragmentActivity getActivity() {
        return this.f36248a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupBaseModule(FragmentActivity fragmentActivity, ViewGroup viewGroup, int i) {
        super(fragmentActivity, viewGroup, i, fragmentActivity, fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        this.f36248a = fragmentActivity;
    }

    /* access modifiers changed from: protected */
    public final ArrayList<IPayModule> getItemModules() {
        return this.f36249b;
    }

    public void refreshUI() {
        for (IPayModule refreshUI : this.f36249b) {
            refreshUI.refreshUI();
        }
    }

    public boolean isSelectable() {
        for (IPayModule isSelectable : this.f36249b) {
            if (isSelectable.isSelectable()) {
                return true;
            }
        }
        return false;
    }

    public void performClick(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "targetItem");
        for (IPayModule performClick : this.f36249b) {
            performClick.performClick(paySelItemData);
        }
    }

    public void detach() {
        super.detach();
        for (IPayModule iPayModule : this.f36249b) {
            if (iPayModule instanceof BizModule) {
                ((BizModule) iPayModule).detach();
            }
        }
    }
}
