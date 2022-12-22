package com.didi.sdk.global.sign.payselect.module;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.sdk.global.base.FlowLayout;
import com.didi.sdk.global.base.module.BizModule;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.payselect.PayMethodSelVM;
import com.didi.sdk.global.sign.payselect.utils.PaySelUT;
import com.didi.unifylogin.utils.LoginConstants;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/AddCardItemModule;", "Lcom/didi/sdk/global/base/module/BizModule;", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "resId", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;I)V", "flowLayLout", "Lcom/didi/sdk/global/base/FlowLayout;", "payItemData", "tvMostFavorable", "Landroid/widget/TextView;", "tvTitle", "vm", "Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM;", "bindData", "", "data", "type", "initView", "updateTitle", "Companion", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddCardItemModule.kt */
public final class AddCardItemModule extends BizModule<PaySelItemData> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f36240a;

    /* renamed from: b */
    private FlowLayout f36241b;

    /* renamed from: c */
    private TextView f36242c;

    /* renamed from: d */
    private PaySelItemData f36243d;

    /* renamed from: e */
    private final PayMethodSelVM f36244e;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddCardItemModule(androidx.fragment.app.FragmentActivity r8, android.view.ViewGroup r9, int r10) {
        /*
            r7 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "parentView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r2 = r8
            android.content.Context r2 = (android.content.Context) r2
            r5 = r8
            androidx.lifecycle.LifecycleOwner r5 = (androidx.lifecycle.LifecycleOwner) r5
            androidx.lifecycle.ViewModelStoreOwner r8 = (androidx.lifecycle.ViewModelStoreOwner) r8
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            androidx.lifecycle.ViewModelProvider r9 = new androidx.lifecycle.ViewModelProvider
            r9.<init>(r8)
            java.lang.Class<com.didi.sdk.global.sign.payselect.PayMethodSelVM> r8 = com.didi.sdk.global.sign.payselect.PayMethodSelVM.class
            androidx.lifecycle.ViewModel r8 = r9.get(r8)
            java.lang.String r9 = "ViewModelProvider(activi…yMethodSelVM::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            com.didi.sdk.global.sign.payselect.PayMethodSelVM r8 = (com.didi.sdk.global.sign.payselect.PayMethodSelVM) r8
            r7.f36244e = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.payselect.module.AddCardItemModule.<init>(androidx.fragment.app.FragmentActivity, android.view.ViewGroup, int):void");
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/module/AddCardItemModule$Companion;", "", "()V", "create", "Lcom/didi/sdk/global/sign/payselect/module/AddCardItemModule;", "activity", "Landroidx/fragment/app/FragmentActivity;", "parentView", "Landroid/view/ViewGroup;", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AddCardItemModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddCardItemModule create(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            return new AddCardItemModule(fragmentActivity, viewGroup, R.layout.payment_paysel_addcard_item_view);
        }
    }

    public void initView() {
        View findViewById = getRootView().findViewById(R.id.paysel_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.paysel_item_title)");
        this.f36240a = (TextView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.paysel_labels_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.….paysel_labels_container)");
        this.f36241b = (FlowLayout) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.paysel_item_most_favorable);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.…ysel_item_most_favorable)");
        this.f36242c = (TextView) findViewById3;
        getRootView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddCardItemModule.m25631a(AddCardItemModule.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25631a(AddCardItemModule addCardItemModule, View view) {
        Intrinsics.checkNotNullParameter(addCardItemModule, "this$0");
        PaySelItemData paySelItemData = addCardItemModule.f36243d;
        if (paySelItemData != null) {
            PaySelUT paySelUT = PaySelUT.INSTANCE;
            String str = paySelItemData.logData;
            List<String> list = paySelItemData.cardDiscountTags;
            Intrinsics.checkNotNullExpressionValue(list, "itemData.cardDiscountTags");
            paySelUT.trackClkWithPromotionInfo(LoginConstants.AUTH_BIND_METHOD, str, list);
            addCardItemModule.f36244e.doItemClick(paySelItemData);
        }
    }

    public void bindData(PaySelItemData paySelItemData, int i) {
        Intrinsics.checkNotNullParameter(paySelItemData, "data");
        this.f36243d = paySelItemData;
        if (paySelItemData.isFrozen) {
            getRootView().setVisibility(8);
            return;
        }
        getRootView().setVisibility(0);
        m25630a(paySelItemData);
        NViewUtils nViewUtils = NViewUtils.INSTANCE;
        TextView textView = this.f36242c;
        FlowLayout flowLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMostFavorable");
            textView = null;
        }
        nViewUtils.setText(textView, paySelItemData.mostFavorableTxt);
        FlowLayout flowLayout2 = this.f36241b;
        if (flowLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flowLayLout");
        } else {
            flowLayout = flowLayout2;
        }
        ItemBaseModuleKt.updateFlowLayoutImpl(flowLayout, paySelItemData);
    }

    /* renamed from: a */
    private final void m25630a(PaySelItemData paySelItemData) {
        PaySelGroupData paySelGroupData = paySelItemData.groupData;
        if (paySelGroupData != null) {
            TextView textView = null;
            if (paySelGroupData.isOtherGroup()) {
                TextView textView2 = this.f36240a;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                } else {
                    textView = textView2;
                }
                textView.setTypeface(Typeface.defaultFromStyle(1));
                return;
            }
            TextView textView3 = this.f36240a;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            } else {
                textView = textView3;
            }
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
    }
}
