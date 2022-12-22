package com.didi.soda.address.edit;

import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"KEY_EDIT_ADDRESS_POP_CALLBACK", "", "needInterceptPopRoot", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "checkFromSaLandingPage", "", "Lcom/didi/soda/address/edit/EditAddressInfoPage;", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoPage.kt */
public final class EditAddressInfoPageKt {

    /* renamed from: a */
    private static final String f38710a = "key_edit_address_pop_callback";

    public static final void checkFromSaLandingPage(EditAddressInfoPage editAddressInfoPage) {
        Intrinsics.checkNotNullParameter(editAddressInfoPage, "<this>");
        PageInstrument instrument = editAddressInfoPage.getInstrument();
        Intrinsics.checkNotNullExpressionValue(instrument, "getInstrument()");
        if (((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).isHolderPage(instrument.getRootPage())) {
            EditAddressInfoPageKt$checkFromSaLandingPage$popCallback$1 editAddressInfoPageKt$checkFromSaLandingPage$popCallback$1 = new EditAddressInfoPageKt$checkFromSaLandingPage$popCallback$1(instrument);
            ScopeContext scopeContext = editAddressInfoPage.getScopeContext();
            if (scopeContext != null) {
                scopeContext.attach(f38710a, editAddressInfoPageKt$checkFromSaLandingPage$popCallback$1);
            }
        }
    }

    public static final boolean needInterceptPopRoot(ScopeContext scopeContext) {
        Object object;
        if (scopeContext == null || (object = scopeContext.getObject(f38710a)) == null || !(object instanceof C13382a)) {
            return false;
        }
        return ((C13382a) object).invoke();
    }
}
