package com.didi.soda.address.edit.component;

import android.content.Context;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.address.edit.binder.EditAddressBinder;
import com.didi.soda.address.edit.binder.EditAddressModel;
import com.didi.soda.address.edit.component.Contract;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¨\u0006\u0015"}, mo175978d2 = {"com/didi/soda/address/edit/component/EditAddressInfoView$initItemBinders$1", "Lcom/didi/soda/address/edit/binder/EditAddressBinder;", "getFirstViewHeight", "", "firstHeight", "", "isAddressClickable", "", "isUseNewAddressArrow", "needShowAddressTips", "onAddressClick", "onBindFinish", "height", "onHouseBuildChanged", "houseName", "", "buildNumber", "onSaveAddress", "action", "Lkotlin/Function0;", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoView.kt */
public final class EditAddressInfoView$initItemBinders$1 extends EditAddressBinder {
    final /* synthetic */ EditAddressInfoView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressInfoView$initItemBinders$1(EditAddressInfoView editAddressInfoView, ScopeContext scopeContext) {
        super(scopeContext);
        this.this$0 = editAddressInfoView;
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
    }

    public void onHouseBuildChanged(String str, String str2) {
        ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).updateHouseBuildName(str, str2);
    }

    public boolean isAddressClickable() {
        return ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).isAddressClickable();
    }

    public boolean isUseNewAddressArrow() {
        return ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).isUseBillAddressStrategy();
    }

    public void onAddressClick() {
        if (!ClickUtils.isFastClick()) {
            Context context = this.this$0.getContext();
            View access$getBackView$p = this.this$0.f38754h;
            if (access$getBackView$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backView");
                access$getBackView$p = null;
            }
            KeyboardUtils.hideSoftInput(context, access$getBackView$p);
            ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).onAddressClick();
        }
    }

    public void onSaveAddress(Function0<EditAddressModel> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.this$0.f38756j = function0;
    }

    public void onBindFinish(int i) {
        ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).onBindFinish(i);
    }

    public void getFirstViewHeight(int i) {
        this.this$0.m27446a(i);
        this.this$0.setAddressMoveDistance(i);
    }

    public boolean needShowAddressTips() {
        return ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).needShowAddressTips();
    }
}
