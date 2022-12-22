package com.didi.payment.wallet_ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.payment.wallet_ui.WalletToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/WalletToast;", "", "()V", "Companion", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletToast.kt */
public final class WalletToast {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int f32901a = UiUtils.Companion.intSize(538);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int f32902b = UiUtils.Companion.intSize(710);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final int f32903c = UiUtils.Companion.intSize(216);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final int f32904d = UiUtils.Companion.intSize(124);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final float f32905e = UiUtils.Companion.floatSize(50);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int f32906f = UiUtils.Companion.intSize(174);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final int f32907g = UiUtils.Companion.intSize(60);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final int f32908h = UiUtils.Companion.intSize(40);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final int f32909i = UiUtils.Companion.intSize(32);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final float f32910j = UiUtils.Companion.floatSize(40);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final float f32911k = UiUtils.Companion.floatSize(28);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final int f32912l = Color.parseColor("#08121B");

    @Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J$\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010$\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010%\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/WalletToast$Companion;", "", "()V", "animationHeight", "", "bgColor", "", "corner", "imageLeftMargin", "imageRightMargin", "imageToastTextMaxWidth", "imageWidth", "offsetY", "toastHeight", "toastMaxWidth", "toastTextSize", "wrapToastHeight", "configCustomView", "Landroid/view/View;", "customView", "weakRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/Toast;", "getEnterAnim", "Landroid/view/animation/Animation;", "toastRef", "getImageToastView", "context", "Landroid/content/Context;", "content", "", "isSuccess", "", "toast", "", "toastFail", "toastSuccess", "toastText", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletToast.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void toastSuccess(Context context, CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(context, "context");
            toast(context, getImageToastView(context, charSequence, true));
        }

        public final void toastFail(Context context, CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(context, "context");
            toast(context, getImageToastView(context, charSequence, false));
        }

        public final void toastText(Context context, CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppCompatTextView appCompatTextView = new AppCompatTextView(context);
            appCompatTextView.setPadding(WalletToast.f32908h, 0, WalletToast.f32908h, 0);
            appCompatTextView.setHeight(WalletToast.f32904d);
            appCompatTextView.setMaxWidth(WalletToast.f32902b);
            appCompatTextView.setMaxLines(2);
            appCompatTextView.setGravity(19);
            appCompatTextView.setTextSize(0, WalletToast.f32911k);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(WalletToast.f32912l);
            gradientDrawable.setCornerRadius(WalletToast.f32910j);
            Unit unit = Unit.INSTANCE;
            appCompatTextView.setBackground(gradientDrawable);
            appCompatTextView.setTextColor(-1);
            appCompatTextView.setText(charSequence);
            Unit unit2 = Unit.INSTANCE;
            toast(context, appCompatTextView);
        }

        public final void toast(Context context, View view) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "customView");
            Toast toast = new Toast(context);
            toast.setView(WalletToast.Companion.configCustomView(view, new WeakReference(toast)));
            toast.setDuration(1);
            toast.setGravity(81, 0, WalletToast.f32903c);
            SystemUtils.showToast(toast);
        }

        private final View configCustomView(View view, WeakReference<Toast> weakReference) {
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            linearLayout.setGravity(48);
            linearLayout.addView(view, -2, -2);
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, WalletToast.f32906f));
            view.post(new Runnable(weakReference) {
                public final /* synthetic */ WeakReference f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WalletToast.Companion.m46641configCustomView$lambda5$lambda4(View.this, this.f$1);
                }
            });
            return frameLayout;
        }

        /* access modifiers changed from: private */
        /* renamed from: configCustomView$lambda-5$lambda-4  reason: not valid java name */
        public static final void m46641configCustomView$lambda5$lambda4(View view, WeakReference weakReference) {
            Intrinsics.checkNotNullParameter(view, "$customView");
            Intrinsics.checkNotNullParameter(weakReference, "$weakRef");
            view.startAnimation(WalletToast.Companion.getEnterAnim(weakReference));
        }

        private final Animation getEnterAnim(WeakReference<Toast> weakReference) {
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.setFillAfter(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            Unit unit = Unit.INSTANCE;
            animationSet.addAnimation(alphaAnimation);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, WalletToast.f32905e, 0.0f);
            translateAnimation.setDuration(500);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            Unit unit2 = Unit.INSTANCE;
            animationSet.addAnimation(translateAnimation);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            alphaAnimation2.setStartOffset(2500);
            alphaAnimation2.setFillAfter(true);
            alphaAnimation2.setInterpolator(new AccelerateInterpolator());
            Unit unit3 = Unit.INSTANCE;
            animationSet.addAnimation(alphaAnimation2);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, WalletToast.f32905e);
            translateAnimation2.setDuration(500);
            translateAnimation2.setStartOffset(2500);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setInterpolator(new AccelerateInterpolator());
            Unit unit4 = Unit.INSTANCE;
            animationSet.addAnimation(translateAnimation2);
            animationSet.setAnimationListener(new WalletToast$Companion$getEnterAnim$1$5(weakReference));
            return animationSet;
        }

        static /* synthetic */ View getImageToastView$default(Companion companion, Context context, CharSequence charSequence, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.getImageToastView(context, charSequence, z);
        }

        private final View getImageToastView(Context context, CharSequence charSequence, boolean z) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            AppCompatImageView appCompatImageView = new AppCompatImageView(context);
            appCompatImageView.setImageResource(z ? R.drawable.wallet_icon_toast_success : R.drawable.wallet_icon_toast_fail);
            appCompatImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Unit unit = Unit.INSTANCE;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(WalletToast.f32907g, WalletToast.f32907g);
            layoutParams.setMargins(WalletToast.f32908h, 0, WalletToast.f32909i, 0);
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(appCompatImageView, layoutParams);
            AppCompatTextView appCompatTextView = new AppCompatTextView(context);
            appCompatTextView.setMaxWidth(WalletToast.f32901a);
            appCompatTextView.setTextColor(-1);
            appCompatTextView.setGravity(19);
            appCompatTextView.setMaxLines(2);
            appCompatTextView.setTextSize(0, WalletToast.f32911k);
            appCompatTextView.setText(charSequence);
            Unit unit3 = Unit.INSTANCE;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, WalletToast.f32904d);
            layoutParams2.setMargins(0, 0, WalletToast.f32908h, 0);
            Unit unit4 = Unit.INSTANCE;
            linearLayout.addView(appCompatTextView, layoutParams2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(WalletToast.f32912l);
            gradientDrawable.setCornerRadius(WalletToast.f32910j);
            Unit unit5 = Unit.INSTANCE;
            linearLayout.setBackground(gradientDrawable);
            return linearLayout;
        }
    }
}
