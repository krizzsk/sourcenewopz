package com.didi.soda.business.component.detail;

import com.didi.soda.business.component.detail.Contract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDetailView.kt */
final class BusinessDetailView$renderDisclaimerDesc$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $disclaimerUrl;
    final /* synthetic */ BusinessDetailView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BusinessDetailView$renderDisclaimerDesc$1(BusinessDetailView businessDetailView, String str) {
        super(0);
        this.this$0 = businessDetailView;
        this.$disclaimerUrl = str;
    }

    public final void invoke() {
        Contract.AbsBusinessDetailPresenter absBusinessDetailPresenter = (Contract.AbsBusinessDetailPresenter) this.this$0.getPresenter();
        if (absBusinessDetailPresenter != null) {
            absBusinessDetailPresenter.openBusinessDisclaimerPage(this.$disclaimerUrl);
        }
    }
}
