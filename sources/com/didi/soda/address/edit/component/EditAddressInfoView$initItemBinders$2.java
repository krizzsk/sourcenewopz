package com.didi.soda.address.edit.component;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.nova.assembly.country.CountryListDialog;
import com.didi.nova.assembly.country.OnCountrySelectListener;
import com.didi.soda.address.edit.binder.EditContactBinder;
import com.didi.soda.address.edit.component.Contract;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\f"}, mo175978d2 = {"com/didi/soda/address/edit/component/EditAddressInfoView$initItemBinders$2", "Lcom/didi/soda/address/edit/binder/EditContactBinder;", "isTypeAid", "", "onSaveContract", "", "action", "Lkotlin/Function0;", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "onSelectCountry", "countryId", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoView.kt */
public final class EditAddressInfoView$initItemBinders$2 extends EditContactBinder {
    final /* synthetic */ EditAddressInfoView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressInfoView$initItemBinders$2(EditAddressInfoView editAddressInfoView, ScopeContext scopeContext) {
        super(scopeContext);
        this.this$0 = editAddressInfoView;
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
    }

    public boolean isTypeAid() {
        return ((Contract.AbsEditAddressInfoPresent) this.this$0.getPresenter()).isTypeAid();
    }

    /* access modifiers changed from: protected */
    public void onSelectCountry(int i) {
        CountryListDialog.show(this.this$0.getScopeContext(), (OnCountrySelectListener) new OnCountrySelectListener() {
            public final void onSelect(String str, int i) {
                EditAddressInfoView$initItemBinders$2.m46753onSelectCountry$lambda0(EditAddressInfoView.this, str, i);
            }
        }, i, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), CustomerSystemUtil.getImmersiveStatusBarHeight(this.this$0.getContext()), GlobalContext.isBrazil() ? R.style.NovaAssemblyCountryStyleYellow : R.style.NovaAssemblyCountryStyleOrange);
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String string = this.this$0.getScopeContext().getBundle().getString("cart_id");
        ScopeContext access$getScopeContext = this.this$0.getScopeContext();
        Intrinsics.checkNotNullExpressionValue(access$getScopeContext, "scopeContext");
        companion.clickArea(string, access$getScopeContext);
    }

    /* access modifiers changed from: private */
    /* renamed from: onSelectCountry$lambda-0  reason: not valid java name */
    public static final void m46753onSelectCountry$lambda0(EditAddressInfoView editAddressInfoView, String str, int i) {
        Intrinsics.checkNotNullParameter(editAddressInfoView, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "callingCode");
        ((Contract.AbsEditAddressInfoPresent) editAddressInfoView.getPresenter()).onCountryResult(str, i);
    }

    /* access modifiers changed from: protected */
    public void onSaveContract(Function0<? extends ContactEntity> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.this$0.f38755i = function0;
    }
}
