package com.didi.sdk.global.sign.payselect.module;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.payselect.utils.GuidePopViewHelper;
import com.didi.sdk.global.util.PayUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/BalanceItemModule;", "Lcom/didi/sdk/global/sign/payselect/module/ItemBaseModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "ivSwitch", "Landroid/widget/ImageView;", "tvTopUp", "Landroid/widget/TextView;", "bindData", "", "data", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "type", "hideRightArea", "initView", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "setEnabled", "enabled", "", "setSelected", "selected", "showRightAreaArrow", "showRightAreaCheckBox", "showRightAreaSwitch", "showRightAreaTopUpBtn", "updateRightArea", "Companion", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BalanceItemModule.kt */
public final class BalanceItemModule extends ItemBaseModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f36245a;

    /* renamed from: b */
    private ImageView f36246b;

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/BalanceItemModule$Companion;", "", "()V", "create", "Lcom/didi/sdk/global/sign/payselect/module/BalanceItemModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BalanceItemModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BalanceItemModule create(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            return new BalanceItemModule(fragmentActivity, viewGroup, R.layout.payment_paysel_balance_item_view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BalanceItemModule(FragmentActivity fragmentActivity, ViewGroup viewGroup, int i) {
        super(fragmentActivity, viewGroup, i);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
    }

    public void initView() {
        super.initView();
        this.f36245a = (TextView) getRootView().findViewById(R.id.paysel_balance_topup);
        this.f36246b = (ImageView) getRootView().findViewById(R.id.paysel_balance_switch);
        if (PayUtils.INSTANCE.isBrazilClient(getContext())) {
            TextView textView = this.f36245a;
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColorStateList(getContext(), R.color.payment_paysel_topup_color_selector_99));
            }
            TextView textView2 = this.f36245a;
            if (textView2 != null) {
                textView2.setBackgroundResource(R.drawable.payment_paysel_topup_bg_selector_99);
            }
            ImageView imageView = this.f36246b;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.payment_paysel_balance_switch_btn_99);
            }
        } else {
            TextView textView3 = this.f36245a;
            if (textView3 != null) {
                textView3.setTextColor(ContextCompat.getColorStateList(getContext(), R.color.payment_paysel_topup_color_selector_global));
            }
            TextView textView4 = this.f36245a;
            if (textView4 != null) {
                textView4.setBackgroundResource(R.drawable.payment_paysel_topup_bg_selector_global);
            }
            ImageView imageView2 = this.f36246b;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.payment_paysel_balance_switch_btn_global);
            }
        }
        if (WalletApolloUtil.isNewTopUpTitle()) {
            TextView textView5 = this.f36245a;
            if (textView5 != null) {
                textView5.setText(R.string.payment_paysel_pix_recharge);
                return;
            }
            return;
        }
        TextView textView6 = this.f36245a;
        if (textView6 != null) {
            textView6.setText(R.string.payment_paysel_recharge);
        }
    }

    public void bindData(PaySelItemData paySelItemData, int i) {
        Intrinsics.checkNotNullParameter(paySelItemData, "data");
        super.bindData(paySelItemData, i);
        m25633a(paySelItemData);
        if (!BalanceItemModuleKt.f36247a) {
            BalanceItemModuleKt.f36247a = true;
            GuidePopViewHelper.showGuideView(this.f36246b, paySelItemData);
        }
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        super.onDestroy(lifecycleOwner);
        GuidePopViewHelper.dismiss();
    }

    /* access modifiers changed from: protected */
    public void setSelected(boolean z) {
        super.setSelected(z);
        ImageView imageView = this.f36246b;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    /* access modifiers changed from: protected */
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        TextView textView = this.f36245a;
        if (textView != null) {
            textView.setEnabled(z);
        }
        ImageView imageView = this.f36246b;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    /* renamed from: a */
    private final void m25633a(PaySelItemData paySelItemData) {
        if (BalanceItemModuleKt.canShowTopUpBtn(paySelItemData)) {
            m25632a();
            return;
        }
        int i = paySelItemData.style;
        if (i == 1) {
            m25635c();
        } else if (i == 2) {
            m25634b();
        } else if (i != 3) {
            m25637e();
        } else {
            m25636d();
        }
    }

    /* renamed from: a */
    private final void m25632a() {
        TextView textView = this.f36245a;
        if (textView != null) {
            textView.setVisibility(0);
        }
        ImageView imageView = this.f36246b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView ivRightIcon = getIvRightIcon();
        if (ivRightIcon != null) {
            ivRightIcon.setVisibility(8);
        }
    }

    /* renamed from: b */
    private final void m25634b() {
        TextView textView = this.f36245a;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f36246b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView ivRightIcon = getIvRightIcon();
        if (ivRightIcon != null) {
            ivRightIcon.setVisibility(0);
        }
        ImageView ivRightIcon2 = getIvRightIcon();
        if (ivRightIcon2 != null) {
            ivRightIcon2.setImageResource(R.drawable.one_payment_global_check_right_arrow);
        }
    }

    /* renamed from: c */
    private final void m25635c() {
        TextView textView = this.f36245a;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f36246b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView ivRightIcon = getIvRightIcon();
        if (ivRightIcon != null) {
            ivRightIcon.setVisibility(0);
        }
        int i = PayUtils.INSTANCE.isBrazilClient(getContext()) ? R.drawable.one_payment_99_paymethod_check_selector : R.drawable.one_payment_global_paymethod_check_selector;
        ImageView ivRightIcon2 = getIvRightIcon();
        if (ivRightIcon2 != null) {
            ivRightIcon2.setImageResource(i);
        }
    }

    /* renamed from: d */
    private final void m25636d() {
        TextView textView = this.f36245a;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView ivRightIcon = getIvRightIcon();
        if (ivRightIcon != null) {
            ivRightIcon.setVisibility(8);
        }
        ImageView imageView = this.f36246b;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* renamed from: e */
    private final void m25637e() {
        TextView textView = this.f36245a;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView ivRightIcon = getIvRightIcon();
        if (ivRightIcon != null) {
            ivRightIcon.setVisibility(8);
        }
        ImageView imageView = this.f36246b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
