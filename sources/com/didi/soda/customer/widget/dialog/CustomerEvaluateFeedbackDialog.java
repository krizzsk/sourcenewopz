package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.component.evaluate.EvaluateCallback;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/dialog/CustomerEvaluateFeedbackDialog;", "Lcom/didi/app/nova/skeleton/dialog/Dialog;", "context", "Landroid/content/Context;", "callback", "Lcom/didi/soda/order/component/evaluate/EvaluateCallback;", "(Landroid/content/Context;Lcom/didi/soda/order/component/evaluate/EvaluateCallback;)V", "descIv", "Landroid/widget/TextView;", "lottieIv", "Lcom/airbnb/lottie/LottieAnimationView;", "rootView", "Landroid/view/View;", "timeoutAction", "Ljava/lang/Runnable;", "getEnterAnimation", "Lcom/didi/app/nova/skeleton/dialog/TransformAnimation;", "getExitAnimation", "initView", "", "onCreate", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "onShow", "updateView", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerEvaluateFeedbackDialog.kt */
public final class CustomerEvaluateFeedbackDialog extends Dialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: g */
    private static final long f41716g = 2000;

    /* renamed from: a */
    private final Context f41717a;

    /* renamed from: b */
    private final EvaluateCallback f41718b;

    /* renamed from: c */
    private View f41719c;

    /* renamed from: d */
    private LottieAnimationView f41720d;

    /* renamed from: e */
    private TextView f41721e;

    /* renamed from: f */
    private final Runnable f41722f = new Runnable() {
        public final void run() {
            CustomerEvaluateFeedbackDialog.m29463a(CustomerEvaluateFeedbackDialog.this);
        }
    };

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public void onShow() {
    }

    public CustomerEvaluateFeedbackDialog(Context context, EvaluateCallback evaluateCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(evaluateCallback, "callback");
        this.f41717a = context;
        this.f41718b = evaluateCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29463a(CustomerEvaluateFeedbackDialog customerEvaluateFeedbackDialog) {
        Intrinsics.checkNotNullParameter(customerEvaluateFeedbackDialog, "this$0");
        if (!customerEvaluateFeedbackDialog.isDestroyed()) {
            customerEvaluateFeedbackDialog.dismiss();
        }
        customerEvaluateFeedbackDialog.f41718b.invoke();
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_dialog_evaluate_feedback, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_feedback, parent, false)");
        this.f41719c = inflate;
        m29464e();
        m29465f();
        View view = this.f41719c;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public void onDismiss() {
        UiHandlerUtil.removeCallbacks(this.f41722f);
    }

    /* renamed from: e */
    private final void m29464e() {
        View view = this.f41719c;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.customer_iv_evaluate_feedback_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…evaluate_feedback_lottie)");
        this.f41720d = (LottieAnimationView) findViewById;
        View view3 = this.f41719c;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            view2 = view3;
        }
        View findViewById2 = view2.findViewById(R.id.customer_tv_evaluate_feedback);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.…mer_tv_evaluate_feedback)");
        this.f41721e = (TextView) findViewById2;
    }

    /* renamed from: f */
    private final void m29465f() {
        TextView textView = this.f41721e;
        LottieAnimationView lottieAnimationView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descIv");
            textView = null;
        }
        textView.setText(ResourceHelper.getString(R.string.FoodC_didifood_Thank_you_jVuq));
        IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        TextView textView2 = this.f41721e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descIv");
            textView2 = null;
        }
        iToolsService.setTypeface(textView2, IToolsService.FontType.MEDIUM);
        LottieAnimationView lottieAnimationView2 = this.f41720d;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieIv");
        } else {
            lottieAnimationView = lottieAnimationView2;
        }
        lottieAnimationView.playAnimation();
        UiHandlerUtil.postDelayed(this.f41722f, f41716g);
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/dialog/CustomerEvaluateFeedbackDialog$Companion;", "", "()V", "TIMEOUT_DURATION", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerEvaluateFeedbackDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
