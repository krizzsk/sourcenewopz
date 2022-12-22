package com.didi.soda.address.edit;

import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.address.edit.component.EditAddressInfoComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoPage.kt */
final class EditAddressInfoPage$onCreate$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ EditAddressInfoComponent $this_apply;
    final /* synthetic */ EditAddressInfoPage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressInfoPage$onCreate$1$1(EditAddressInfoPage editAddressInfoPage, EditAddressInfoComponent editAddressInfoComponent) {
        super(0);
        this.this$0 = editAddressInfoPage;
        this.$this_apply = editAddressInfoComponent;
    }

    public final void invoke() {
        INavigator navigator;
        this.this$0.m27422a();
        ScopeContext scopeContext = this.$this_apply.getScopeContext();
        if (scopeContext != null && (navigator = scopeContext.getNavigator()) != null) {
            navigator.finish();
        }
    }
}
