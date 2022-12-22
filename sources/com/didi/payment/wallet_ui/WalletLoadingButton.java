package com.didi.payment.wallet_ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006'"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/WalletLoadingButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mAvLoading", "Lcom/airbnb/lottie/LottieAnimationView;", "mTvContent", "Lcom/didi/payment/wallet_ui/WalletButton;", "preLoadingTextColor", "getPreLoadingTextColor", "()I", "setPreLoadingTextColor", "(I)V", "value", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "isEnabled", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setEnabled", "enabled", "setOnClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "startLoading", "stopLoading", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletLoadingButton.kt */
public final class WalletLoadingButton extends FrameLayout {

    /* renamed from: a */
    private LottieAnimationView f32898a;

    /* renamed from: b */
    private WalletButton f32899b;

    /* renamed from: c */
    private int f32900c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletLoadingButton(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_button, this);
        View findViewById = findViewById(R.id.av_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.av_loading)");
        this.f32898a = (LottieAnimationView) findViewById;
        View findViewById2 = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_content)");
        this.f32899b = (WalletButton) findViewById2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.WalletButton);
        LottieAnimationView lottieAnimationView = this.f32898a;
        ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
        int i4 = obtainStyledAttributes.getInt(2, 1);
        if (i4 != 2) {
            i3 = i4 != 3 ? (UiUtils.Companion.intSize(104) * 36) / 104 : (UiUtils.Companion.intSize(60) * 36) / 104;
        } else {
            i3 = (UiUtils.Companion.intSize(80) * 36) / 104;
        }
        layoutParams.height = i3;
        layoutParams.width = (layoutParams.height * 60) / 36;
        Unit unit = Unit.INSTANCE;
        lottieAnimationView.setLayoutParams(layoutParams);
        this.f32898a.setAnimation((obtainStyledAttributes.getInt(0, 1) != 1 || !UiUtils.Companion.isWhiteInThemeBg()) ? R.raw.wallet_button_loading_dark : R.raw.wallet_button_loading_light);
        this.f32899b.setText(obtainStyledAttributes.getString(1));
        WalletButton walletButton = this.f32899b;
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "typeArray");
        walletButton.configAttr(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public final CharSequence getText() {
        return this.f32899b.getText();
    }

    public final void setText(CharSequence charSequence) {
        this.f32899b.setText(charSequence);
    }

    public final void startLoading() {
        if (!this.f32898a.isAnimating()) {
            this.f32900c = this.f32899b.getCurrentTextColor();
            this.f32899b.setTextColor(0);
            this.f32899b.setClickable(false);
            this.f32898a.setVisibility(0);
            this.f32898a.playAnimation();
        }
    }

    public final void stopLoading() {
        this.f32898a.setVisibility(8);
        this.f32898a.cancelAnimation();
        this.f32899b.setTextColor(this.f32900c);
        this.f32899b.setClickable(true);
    }

    public final int getPreLoadingTextColor() {
        return this.f32900c;
    }

    public final void setPreLoadingTextColor(int i) {
        this.f32900c = i;
    }

    public boolean isEnabled() {
        return this.f32899b.isEnabled();
    }

    public void setEnabled(boolean z) {
        this.f32899b.setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f32899b.measure(i, i2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f32899b.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f32899b.getMeasuredHeight(), 1073741824));
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f32899b.setOnClickListener(new View.OnClickListener(onClickListener) {
                public final /* synthetic */ View.OnClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    WalletLoadingButton.m23189a(WalletLoadingButton.this, this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23189a(WalletLoadingButton walletLoadingButton, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(walletLoadingButton, "this$0");
        Intrinsics.checkNotNullParameter(onClickListener, "$listener");
        if (!walletLoadingButton.f32898a.isAnimating()) {
            walletLoadingButton.startLoading();
            onClickListener.onClick(view);
        }
    }
}
