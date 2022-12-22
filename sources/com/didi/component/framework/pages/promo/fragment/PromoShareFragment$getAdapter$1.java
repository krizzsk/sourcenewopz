package com.didi.component.framework.pages.promo.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didi.component.common.adapter.CommonRvAdapter;
import com.didi.component.common.adapter.CommonRvVH;
import com.didi.component.framework.pages.promo.model.PromoShareItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo175978d2 = {"com/didi/component/framework/pages/promo/fragment/PromoShareFragment$getAdapter$1", "Lcom/didi/component/common/adapter/CommonRvAdapter;", "Lcom/didi/component/framework/pages/promo/model/PromoShareItem;", "bindData", "", "holder", "Lcom/didi/component/common/adapter/CommonRvVH;", "position", "", "getLayoutResourceId", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoShareFragment.kt */
public final class PromoShareFragment$getAdapter$1 extends CommonRvAdapter<PromoShareItem> {
    final /* synthetic */ PromoShareFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PromoShareFragment$getAdapter$1(PromoShareFragment promoShareFragment, FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.this$0 = promoShareFragment;
        Intrinsics.checkNotNullExpressionValue(fragmentActivity, "requireActivity()");
    }

    public int getLayoutResourceId(int i) {
        return this.this$0.m9652a(i);
    }

    public void bindData(CommonRvVH commonRvVH, int i) {
        if (i < this.this$0.f13934e.size()) {
            PromoShareFragment promoShareFragment = this.this$0;
            promoShareFragment.m9655a(commonRvVH, (PromoShareItem) promoShareFragment.f13934e.get(i));
        }
    }
}
