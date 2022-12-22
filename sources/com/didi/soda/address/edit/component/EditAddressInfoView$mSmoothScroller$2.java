package com.didi.soda.address.edit.component;

import com.didi.soda.address.edit.component.EditAddressInfoView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/soda/address/edit/component/EditAddressInfoView$LinearTopSmoothScroller;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditAddressInfoView.kt */
final class EditAddressInfoView$mSmoothScroller$2 extends Lambda implements Function0<EditAddressInfoView.LinearTopSmoothScroller> {
    final /* synthetic */ EditAddressInfoView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditAddressInfoView$mSmoothScroller$2(EditAddressInfoView editAddressInfoView) {
        super(0);
        this.this$0 = editAddressInfoView;
    }

    public final EditAddressInfoView.LinearTopSmoothScroller invoke() {
        return new EditAddressInfoView.LinearTopSmoothScroller(this.this$0.getContext());
    }
}
