package com.didi.global.fintech.cashier.p117ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierResultPayViewHolder;
import com.didi.global.fintech.cashier.p117ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierResultMutliMethodItemViewHolder;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.GlobalCashierResultSingleMethodItemViewHolder;
import com.didi.soda.blocks.entity.CallBackEntity;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u000e\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J$\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00120%H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierResultPayViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierResultPayViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "containerView", "Landroid/widget/LinearLayout;", "priceTV", "Landroid/widget/TextView;", "statusIV", "Landroid/widget/ImageView;", "statusTV", "symbolTV", "tipContentTV", "disableReturnButton", "", "initView", "layout", "", "updateAmountInfo", "symbolStr", "", "priceStr", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "updatePaymentMethod", "payments", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/PaymentMethod;", "updateReturnButton", "buttonData", "Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", "onClick", "Lkotlin/Function1;", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierResultPayViewHolder */
/* compiled from: GlobalCashierResultPayViewHolder.kt */
public final class GlobalCashierResultPayViewHolder extends GlobalCashierBaseViewHolder implements IGlobalCashierResultPayViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final LinearLayout f21803a;

    /* renamed from: b */
    private ImageView f21804b;

    /* renamed from: c */
    private TextView f21805c;

    /* renamed from: d */
    private TextView f21806d;

    /* renamed from: e */
    private TextView f21807e;

    /* renamed from: f */
    private TextView f21808f;

    public int layout() {
        return R.layout.viewholder_global_cashier_result_pay_info;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierResultPayViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View findViewById = getMRootView().findViewById(R.id.layout_pay_methods);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.layout_pay_methods)");
        this.f21803a = (LinearLayout) findViewById;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierResultPayViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierResultPayViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.GlobalCashierResultPayViewHolder$Companion */
    /* compiled from: GlobalCashierResultPayViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalCashierResultPayViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new GlobalCashierResultPayViewHolder(context, viewGroup);
        }
    }

    public void initView() {
        super.initView();
        View findViewById = getMRootView().findViewById(R.id.iv_pay_status);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.iv_pay_status)");
        this.f21804b = (ImageView) findViewById;
        View findViewById2 = getMRootView().findViewById(R.id.tv_pay_status);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.tv_pay_status)");
        this.f21805c = (TextView) findViewById2;
        View findViewById3 = getMRootView().findViewById(R.id.tv_symbol);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.tv_symbol)");
        this.f21806d = (TextView) findViewById3;
        View findViewById4 = getMRootView().findViewById(R.id.tv_price);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.tv_price)");
        this.f21807e = (TextView) findViewById4;
        View findViewById5 = getMRootView().findViewById(R.id.tv_tip_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.tv_tip_content)");
        this.f21808f = (TextView) findViewById5;
    }

    public void updateAmountInfo(String str, String str2, StringBuilder sb) {
        TextView textView = this.f21806d;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("symbolTV");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
        TextView textView3 = this.f21807e;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceTV");
            textView3 = null;
        }
        ViewKtxKt.content(textView3, str2);
        if (sb != null) {
            TextView textView4 = this.f21808f;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipContentTV");
            } else {
                textView2 = textView4;
            }
            ViewKtxKt.content(textView2, sb.toString());
        }
    }

    public void updatePaymentMethod(List<PaymentMethod> list) {
        Intrinsics.checkNotNullParameter(list, ParamKeys.PARAM_PAYMENT_STR);
        if (list.size() == 1) {
            PaymentMethod paymentMethod = list.get(0);
            GlobalCashierResultSingleMethodItemViewHolder.Companion.newInstance(getContext(), this.f21803a).setData((String) null, paymentMethod.getIcon(), paymentMethod.getDisplayName(), paymentMethod.getInstallmentName(), paymentMethod.getInstallmentAmount());
            return;
        }
        GlobalCashierResultSingleMethodItemViewHolder.Companion.newInstance(getContext(), this.f21803a).setData((String) null, (String) null, (String) null, (String) null, (String) null);
        for (PaymentMethod paymentMethod2 : list) {
            GlobalCashierResultMutliMethodItemViewHolder.Companion.newInstance(getContext(), this.f21803a).setData(paymentMethod2.getDisplayName(), paymentMethod2.getIcon(), paymentMethod2.getPrice());
        }
    }

    public void updateReturnButton(MerchantButtonData merchantButtonData, Function1<? super MerchantButtonData, Unit> function1) {
        Intrinsics.checkNotNullParameter(merchantButtonData, "buttonData");
        Intrinsics.checkNotNullParameter(function1, CallBackEntity.CALLBACK_TYPE_CLICK);
        TextView textView = (TextView) getMRootView().findViewById(R.id.btn_back_to_merchant);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        View view = textView;
        view.setVisibility(Intrinsics.areEqual((Object) merchantButtonData.getShow(), (Object) true) ? 0 : 8);
        textView.setText(merchantButtonData.getMessage());
        ViewKtxKt.click$default(view, 0, new GlobalCashierResultPayViewHolder$updateReturnButton$1$1(function1, merchantButtonData), 1, (Object) null);
    }

    public void disableReturnButton() {
        ((TextView) getMRootView().findViewById(R.id.btn_back_to_merchant)).setEnabled(false);
    }
}
