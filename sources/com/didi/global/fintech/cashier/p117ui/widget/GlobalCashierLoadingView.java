package com.didi.global.fintech.cashier.p117ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierBaseAlertDialog;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J \u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006&"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseAlertDialog;", "logo", "", "(Z)V", "isShowFragment", "loadingImage", "Landroid/widget/ImageView;", "getLoadingImage", "()Landroid/widget/ImageView;", "setLoadingImage", "(Landroid/widget/ImageView;)V", "getLogo", "()Z", "logoImage", "getLogoImage", "setLogoImage", "dismiss", "", "dismissAllowingStateLoss", "getTheme", "", "initData", "initView", "view", "Landroid/view/View;", "layout", "onDestroy", "onStart", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "showDuration", "duration", "", "Companion", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.widget.GlobalCashierLoadingView */
/* compiled from: GlobalCashierLoadingView.kt */
public final class GlobalCashierLoadingView extends GlobalCashierBaseAlertDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final boolean f21874a;

    /* renamed from: b */
    private boolean f21875b;
    public ImageView loadingImage;
    public ImageView logoImage;

    public GlobalCashierLoadingView() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public int getTheme() {
        return R.style.global_cashier_center_dialog;
    }

    public int layout() {
        return R.layout.global_cashier_loading_view;
    }

    public GlobalCashierLoadingView(boolean z) {
        this.f21874a = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierLoadingView(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public final boolean getLogo() {
        return this.f21874a;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "logo", "", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.widget.GlobalCashierLoadingView$Companion */
    /* compiled from: GlobalCashierLoadingView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ GlobalCashierLoadingView newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return companion.newInstance(z);
        }

        public final GlobalCashierLoadingView newInstance(boolean z) {
            return new GlobalCashierLoadingView(z);
        }
    }

    public final ImageView getLogoImage() {
        ImageView imageView = this.logoImage;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logoImage");
        return null;
    }

    public final void setLogoImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.logoImage = imageView;
    }

    public final ImageView getLoadingImage() {
        ImageView imageView = this.loadingImage;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingImage");
        return null;
    }

    public final void setLoadingImage(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.loadingImage = imageView;
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.merchant_sdk_loading_view_iv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…dk_loading_view_iv_title)");
        setLogoImage((ImageView) findViewById);
        View findViewById2 = view.findViewById(R.id.merchant_sdk_loading_view_iv_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.m…_loading_view_iv_loading)");
        setLoadingImage((ImageView) findViewById2);
    }

    public void initData() {
        if (!this.f21874a) {
            getLogoImage().setVisibility(8);
        } else if (CashierFacade.Companion.getInstance().getTheme().global()) {
            getLogoImage().setImageResource(R.drawable.global_cashier_loading_global_brand_ic);
        } else if (CashierFacade.Companion.getInstance().getTheme().brazil()) {
            getLogoImage().setImageResource(R.drawable.global_cashier_loading_99_brand_ic);
        } else {
            getLogoImage().setImageResource(R.drawable.global_cashier_loading_99_brand_ic);
        }
        getLoadingImage().setImageResource(R.drawable.global_cashier_loading_anim);
        Drawable drawable = getLoadingImage().getDrawable();
        if (drawable != null) {
            ((AnimationDrawable) drawable).start();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
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
            FragmentActivity activity2 = getActivity();
            int i = -2;
            int dp2px = activity2 == null ? -2 : ContextKtxKt.dp2px((Context) activity2, 115);
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                i = ContextKtxKt.dp2px((Context) activity3, 115);
            }
            window.setLayout(dp2px, i);
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        if (!this.f21875b) {
            this.f21875b = true;
            super.show(fragmentManager, str);
        }
    }

    public final void showDuration(long j, FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        if (!this.f21875b) {
            this.f21875b = true;
            UiThreadHandler.postDelayed(new Runnable() {
                public final void run() {
                    GlobalCashierLoadingView.m15840a(GlobalCashierLoadingView.this);
                }
            }, j);
            super.show(fragmentManager, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15840a(GlobalCashierLoadingView globalCashierLoadingView) {
        Intrinsics.checkNotNullParameter(globalCashierLoadingView, "this$0");
        globalCashierLoadingView.dismissAllowingStateLoss();
    }

    public void dismiss() {
        this.f21875b = false;
        super.dismiss();
    }

    public void dismissAllowingStateLoss() {
        this.f21875b = false;
        super.dismissAllowingStateLoss();
    }

    public void onDestroy() {
        this.f21875b = false;
        super.onDestroy();
    }
}
