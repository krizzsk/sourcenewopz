package com.didi.global.fintech.cashier.p117ui.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierBaseAlertDialog;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierRetryView;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseAlertDialog;", "listener", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "btnRetry", "Landroid/widget/TextView;", "getBtnRetry", "()Landroid/widget/TextView;", "setBtnRetry", "(Landroid/widget/TextView;)V", "getListener", "()Lkotlin/jvm/functions/Function0;", "getTheme", "", "initData", "initView", "view", "Landroid/view/View;", "layout", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.widget.GlobalCashierRetryView */
/* compiled from: GlobalCashierRetryView.kt */
public final class GlobalCashierRetryView extends GlobalCashierBaseAlertDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Function0<Unit> f21876a;
    public TextView btnRetry;

    public int getTheme() {
        return R.style.full_screen_dialog;
    }

    public void initData() {
    }

    public int layout() {
        return R.layout.global_cashier_retry_view;
    }

    public GlobalCashierRetryView(Function0<Unit> function0) {
        this.f21876a = function0;
    }

    public final Function0<Unit> getListener() {
        return this.f21876a;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierRetryView$Companion;", "", "()V", "showInstance", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "listener", "Lkotlin/Function0;", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.widget.GlobalCashierRetryView$Companion */
    /* compiled from: GlobalCashierRetryView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showInstance(FragmentActivity fragmentActivity, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            GlobalCashierRetryView globalCashierRetryView = new GlobalCashierRetryView(function0);
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            globalCashierRetryView.show(supportFragmentManager, GlobalCashierRetryView.class.getSimpleName());
        }
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.btn_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.btn_retry)");
        setBtnRetry((TextView) findViewById);
        getBtnRetry().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                GlobalCashierRetryView.m15841a(GlobalCashierRetryView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15841a(GlobalCashierRetryView globalCashierRetryView, View view) {
        Intrinsics.checkNotNullParameter(globalCashierRetryView, "this$0");
        Function0<Unit> listener = globalCashierRetryView.getListener();
        if (listener != null) {
            listener.invoke();
        }
        globalCashierRetryView.dismissAllowingStateLoss();
    }

    public final TextView getBtnRetry() {
        TextView textView = this.btnRetry;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
        return null;
    }

    public final void setBtnRetry(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.btnRetry = textView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public void onStart() {
        Window window;
        WindowManager windowManager;
        Display defaultDisplay;
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }
}
