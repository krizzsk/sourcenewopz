package com.didi.sdk.global.sign.payselect.module;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.util.PayUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/CardItemModule;", "Lcom/didi/sdk/global/sign/payselect/module/ItemBaseModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "bindData", "", "data", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "type", "updateRightArea", "Companion", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CardItemModule.kt */
public final class CardItemModule extends ItemBaseModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardItemModule(FragmentActivity fragmentActivity, ViewGroup viewGroup, int i) {
        super(fragmentActivity, viewGroup, i);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/CardItemModule$Companion;", "", "()V", "create", "Lcom/didi/sdk/global/sign/payselect/module/CardItemModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CardItemModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CardItemModule create(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            return new CardItemModule(fragmentActivity, viewGroup, R.layout.payment_paysel_card_item_view);
        }
    }

    public void bindData(PaySelItemData paySelItemData, int i) {
        Intrinsics.checkNotNullParameter(paySelItemData, "data");
        super.bindData(paySelItemData, i);
        m25639a(paySelItemData);
    }

    /* renamed from: a */
    private final void m25639a(PaySelItemData paySelItemData) {
        if (paySelItemData.style == 1) {
            int i = PayUtils.INSTANCE.isBrazilClient(getContext()) ? R.drawable.one_payment_99_paymethod_check_selector : R.drawable.one_payment_global_paymethod_check_selector;
            ImageView ivRightIcon = getIvRightIcon();
            if (ivRightIcon != null) {
                ivRightIcon.setImageResource(i);
                return;
            }
            return;
        }
        ImageView ivRightIcon2 = getIvRightIcon();
        if (ivRightIcon2 != null) {
            ivRightIcon2.setImageResource(R.drawable.one_payment_global_check_right_arrow);
        }
    }
}
