package com.didi.payment.wallet_ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.payment.base.utils.GlideUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001+B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0001\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0003\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\"J\u0012\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletSystemContent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mFlInsert", "Landroid/widget/FrameLayout;", "mIvImage", "Landroid/widget/ImageView;", "mTvBtnFirst", "Landroid/widget/TextView;", "mTvBtnSecond", "mTvBtnThird", "mTvContent", "mTvTitle", "mVLine2", "Landroid/view/View;", "mVLine3", "config", "", "imageUrl", "", "imageRes", "title", "", "content", "insertView", "firstBtnText", "firstClickListener", "Landroid/view/View$OnClickListener;", "secondBtnText", "secondClickListener", "thirdBtnText", "thirdClickListener", "getSelector", "Landroid/graphics/drawable/Drawable;", "bottomCorner", "", "Builder", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletSystemContent.kt */
public final class WalletSystemContent extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f32951a;

    /* renamed from: b */
    private TextView f32952b;

    /* renamed from: c */
    private TextView f32953c;

    /* renamed from: d */
    private FrameLayout f32954d;

    /* renamed from: e */
    private TextView f32955e;

    /* renamed from: f */
    private View f32956f;

    /* renamed from: g */
    private TextView f32957g;

    /* renamed from: h */
    private View f32958h;

    /* renamed from: i */
    private TextView f32959i;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSystemContent(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSystemContent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSystemContent(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletSystemContent(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletSystemContent(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_dialog_system, this);
        View findViewById = findViewById(R.id.iv_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_image)");
        this.f32951a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_title)");
        this.f32952b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_content)");
        this.f32953c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.fl_insert);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.fl_insert)");
        this.f32954d = (FrameLayout) findViewById4;
        View findViewById5 = findViewById(R.id.tv_btn_first);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_btn_first)");
        this.f32955e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.v_line_2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.v_line_2)");
        this.f32956f = findViewById6;
        View findViewById7 = findViewById(R.id.tv_btn_second);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_btn_second)");
        this.f32957g = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.v_line_3);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.v_line_3)");
        this.f32958h = findViewById8;
        View findViewById9 = findViewById(R.id.tv_btn_third);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_btn_third)");
        this.f32959i = (TextView) findViewById9;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(WalletDialog.Companion.getRadius());
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    public static /* synthetic */ void config$default(WalletSystemContent walletSystemContent, String str, int i, CharSequence charSequence, CharSequence charSequence2, View view, CharSequence charSequence3, View.OnClickListener onClickListener, CharSequence charSequence4, View.OnClickListener onClickListener2, CharSequence charSequence5, View.OnClickListener onClickListener3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            charSequence = null;
        }
        if ((i2 & 8) != 0) {
            charSequence2 = null;
        }
        if ((i2 & 16) != 0) {
            view = null;
        }
        if ((i2 & 32) != 0) {
            charSequence3 = null;
        }
        if ((i2 & 64) != 0) {
            onClickListener = null;
        }
        if ((i2 & 128) != 0) {
            charSequence4 = null;
        }
        if ((i2 & 256) != 0) {
            onClickListener2 = null;
        }
        if ((i2 & 512) != 0) {
            charSequence5 = null;
        }
        if ((i2 & 1024) != 0) {
            onClickListener3 = null;
        }
        walletSystemContent.config(str, i, charSequence, charSequence2, view, charSequence3, onClickListener, charSequence4, onClickListener2, charSequence5, onClickListener3);
    }

    public final void config(String str, int i, CharSequence charSequence, CharSequence charSequence2, View view, CharSequence charSequence3, View.OnClickListener onClickListener, CharSequence charSequence4, View.OnClickListener onClickListener2, CharSequence charSequence5, View.OnClickListener onClickListener3) {
        boolean z;
        int i2 = i;
        View view2 = view;
        if (!TextUtils.isEmpty(str) || i2 != -1) {
            this.f32951a.setVisibility(0);
            GlideUtils.loadTopRoundImageMix(getContext(), i, str, WalletDialog.Companion.getRadius(), this.f32951a);
        } else {
            this.f32951a.setVisibility(8);
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f32952b.setVisibility(8);
        } else {
            this.f32952b.setVisibility(0);
            CharSequence charSequence6 = charSequence;
            this.f32952b.setText(charSequence);
        }
        if (TextUtils.isEmpty(charSequence2)) {
            this.f32953c.setVisibility(8);
        } else {
            CharSequence charSequence7 = charSequence2;
            this.f32953c.setText(charSequence2);
            this.f32953c.setVisibility(0);
        }
        if (view2 == null) {
            this.f32954d.setVisibility(8);
        } else {
            this.f32954d.setVisibility(0);
            this.f32954d.removeAllViews();
            this.f32954d.addView(view);
        }
        if (TextUtils.isEmpty(charSequence5)) {
            this.f32959i.setVisibility(8);
            this.f32958h.setVisibility(8);
            z = false;
        } else {
            this.f32958h.setVisibility(0);
            this.f32959i.setText(charSequence5);
            this.f32959i.setVisibility(0);
            this.f32959i.setOnClickListener(onClickListener3);
            this.f32959i.setBackground(m23197a(true));
            z = true;
        }
        if (TextUtils.isEmpty(charSequence4)) {
            this.f32957g.setVisibility(8);
            this.f32956f.setVisibility(8);
        } else {
            this.f32956f.setVisibility(0);
            this.f32957g.setText(charSequence4);
            this.f32957g.setVisibility(0);
            this.f32957g.setOnClickListener(onClickListener2);
            if (z) {
                this.f32957g.setBackground(m23197a(false));
            } else {
                this.f32957g.setBackground(m23197a(true));
                z = true;
            }
        }
        CharSequence charSequence8 = charSequence3;
        this.f32955e.setText(charSequence3);
        this.f32955e.setBackground(m23197a(!z));
        this.f32955e.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    static /* synthetic */ Drawable m23196a(WalletSystemContent walletSystemContent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return walletSystemContent.m23197a(z);
    }

    /* renamed from: a */
    private final Drawable m23197a(boolean z) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = {16842919};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F3F3F3"));
        if (z) {
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius()});
        }
        Unit unit = Unit.INSTANCE;
        stateListDrawable.addState(iArr, gradientDrawable);
        int[] iArr2 = new int[0];
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(0);
        if (z) {
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius()});
        }
        Unit unit2 = Unit.INSTANCE;
        stateListDrawable.addState(iArr2, gradientDrawable2);
        return stateListDrawable;
    }

    @Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001c\u0010'\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00067"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletSystemContent$Builder;", "", "()V", "content", "", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "firstBtnText", "getFirstBtnText", "setFirstBtnText", "firstClickListener", "Landroid/view/View$OnClickListener;", "getFirstClickListener", "()Landroid/view/View$OnClickListener;", "setFirstClickListener", "(Landroid/view/View$OnClickListener;)V", "imageRes", "", "getImageRes", "()I", "setImageRes", "(I)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "insertView", "Landroid/view/View;", "getInsertView", "()Landroid/view/View;", "setInsertView", "(Landroid/view/View;)V", "secondBtnText", "getSecondBtnText", "setSecondBtnText", "secondClickListener", "getSecondClickListener", "setSecondClickListener", "thirdBtnText", "getThirdBtnText", "setThirdBtnText", "thirdClickListener", "getThirdClickListener", "setThirdClickListener", "title", "getTitle", "setTitle", "build", "Lcom/didi/payment/wallet_ui/dialog/WalletSystemContent;", "context", "Landroid/content/Context;", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletSystemContent.kt */
    public static final class Builder {
        private CharSequence content;
        private CharSequence firstBtnText;
        private View.OnClickListener firstClickListener;
        private int imageRes = -1;
        private String imageUrl;
        private View insertView;
        private CharSequence secondBtnText;
        private View.OnClickListener secondClickListener;
        private CharSequence thirdBtnText;
        private View.OnClickListener thirdClickListener;
        private CharSequence title;

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final int getImageRes() {
            return this.imageRes;
        }

        public final void setImageRes(int i) {
            this.imageRes = i;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final void setTitle(CharSequence charSequence) {
            this.title = charSequence;
        }

        public final CharSequence getContent() {
            return this.content;
        }

        public final void setContent(CharSequence charSequence) {
            this.content = charSequence;
        }

        public final View getInsertView() {
            return this.insertView;
        }

        public final void setInsertView(View view) {
            this.insertView = view;
        }

        public final CharSequence getFirstBtnText() {
            return this.firstBtnText;
        }

        public final void setFirstBtnText(CharSequence charSequence) {
            this.firstBtnText = charSequence;
        }

        public final View.OnClickListener getFirstClickListener() {
            return this.firstClickListener;
        }

        public final void setFirstClickListener(View.OnClickListener onClickListener) {
            this.firstClickListener = onClickListener;
        }

        public final CharSequence getSecondBtnText() {
            return this.secondBtnText;
        }

        public final void setSecondBtnText(CharSequence charSequence) {
            this.secondBtnText = charSequence;
        }

        public final View.OnClickListener getSecondClickListener() {
            return this.secondClickListener;
        }

        public final void setSecondClickListener(View.OnClickListener onClickListener) {
            this.secondClickListener = onClickListener;
        }

        public final CharSequence getThirdBtnText() {
            return this.thirdBtnText;
        }

        public final void setThirdBtnText(CharSequence charSequence) {
            this.thirdBtnText = charSequence;
        }

        public final View.OnClickListener getThirdClickListener() {
            return this.thirdClickListener;
        }

        public final void setThirdClickListener(View.OnClickListener onClickListener) {
            this.thirdClickListener = onClickListener;
        }

        public final WalletSystemContent build(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WalletSystemContent walletSystemContent = new WalletSystemContent(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            String imageUrl2 = getImageUrl();
            int imageRes2 = getImageRes();
            CharSequence title2 = getTitle();
            CharSequence content2 = getContent();
            View insertView2 = getInsertView();
            CharSequence firstBtnText2 = getFirstBtnText();
            if (firstBtnText2 == null) {
            }
            walletSystemContent.config(imageUrl2, imageRes2, title2, content2, insertView2, firstBtnText2, getFirstClickListener(), getSecondBtnText(), getSecondClickListener(), getThirdBtnText(), getThirdClickListener());
            return walletSystemContent;
        }
    }
}
