package com.didi.payment.wallet_ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.passenger.C10448R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/WalletButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnLevel", "corner", "", "pressedEndColor", "pressedForeBgColorInt", "pressedStartColor", "secondLevelPressedColor", "sizeType", "useMaxWidth", "", "configAttr", "", "typedArray", "Landroid/content/res/TypedArray;", "configButton", "content", "", "clickListener", "Landroid/view/View$OnClickListener;", "configEnableBg", "configPressedBg", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEnabled", "enabled", "Companion", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletButton.kt */
public final class WalletButton extends AppCompatTextView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int LEVEL_FIRST = 1;
    public static final int LEVEL_SECOND = 2;
    public static final int TYPE_BIG = 1;
    public static final int TYPE_MID = 2;
    public static final int TYPE_SMALL = 3;

    /* renamed from: i */
    private static final int f32875i;

    /* renamed from: j */
    private static final int f32876j;

    /* renamed from: k */
    private static final int f32877k = UiUtils.Companion.intSize(32);

    /* renamed from: l */
    private static final int f32878l = UiUtils.Companion.intSize(104);

    /* renamed from: m */
    private static final int f32879m = UiUtils.Companion.intSize(80);

    /* renamed from: n */
    private static final int f32880n = UiUtils.Companion.intSize(670);

    /* renamed from: o */
    private static final float f32881o = UiUtils.Companion.floatSize(40);

    /* renamed from: p */
    private static final int f32882p = UiUtils.Companion.intSize(345);

    /* renamed from: q */
    private static final float f32883q = UiUtils.Companion.floatSize(32);

    /* renamed from: r */
    private static final int f32884r = UiUtils.Companion.intSize(212);

    /* renamed from: s */
    private static final int f32885s = UiUtils.Companion.intSize(60);

    /* renamed from: t */
    private static final float f32886t = UiUtils.Companion.floatSize(24);

    /* renamed from: u */
    private static final int f32887u = Color.parseColor("#D4D7D9");

    /* renamed from: v */
    private static final int f32888v = Color.parseColor(ColorUtils.DIDI_GREY);

    /* renamed from: w */
    private static final int f32889w = Color.parseColor(ColorUtils.DIDI_GREY);

    /* renamed from: a */
    private int f32890a;

    /* renamed from: b */
    private float f32891b;

    /* renamed from: c */
    private boolean f32892c;

    /* renamed from: d */
    private int f32893d;

    /* renamed from: e */
    private final int f32894e;

    /* renamed from: f */
    private final int f32895f;

    /* renamed from: g */
    private final int f32896g;

    /* renamed from: h */
    private final int f32897h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842884 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f32890a = 1;
        this.f32893d = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.WalletButton);
        if (!obtainStyledAttributes.getBoolean(3, false)) {
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "it");
            configAttr(obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        int parseColor = Color.parseColor("#1A000000");
        this.f32894e = parseColor;
        this.f32895f = androidx.core.graphics.ColorUtils.compositeColors(parseColor, UiUtils.Companion.getWalletFirstLevelButtonBgStartColor());
        this.f32896g = androidx.core.graphics.ColorUtils.compositeColors(this.f32894e, UiUtils.Companion.getWalletFirstLevelButtonBgEndColor());
        this.f32897h = Color.parseColor("#E9EAEB");
    }

    public final void configButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        setText(charSequence);
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/WalletButton$Companion;", "", "()V", "LEVEL_FIRST", "", "LEVEL_SECOND", "TYPE_BIG", "TYPE_MID", "TYPE_SMALL", "heightBig", "heightMid", "heightSmall", "maxWidthBig", "maxWidthMid", "maxWidthSmall", "paddingBig", "paddingMid", "paddingSmall", "secondEnableBgColor", "textSizeBig", "", "textSizeMid", "textSizeSmall", "unableBgColor", "unableTextColor", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletButton.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int intSize = UiUtils.Companion.intSize(40);
        f32875i = intSize;
        f32876j = intSize;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.f32890a;
        if (i7 == 1) {
            i3 = f32880n;
            i5 = f32878l;
            i4 = f32875i;
        } else if (i7 != 2) {
            i3 = f32884r;
            i5 = f32885s;
            i4 = f32877k;
        } else {
            i3 = f32882p;
            i5 = f32879m;
            i4 = f32876j;
        }
        if (getText() == null) {
            i6 = i4 * 2;
        } else {
            i6 = (i4 * 2) + ((int) getPaint().measureText(getText().toString()));
        }
        if (this.f32892c || i6 > i3) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
    }

    public final void configAttr(TypedArray typedArray) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
        setTypeface(Typeface.DEFAULT_BOLD);
        int i = typedArray.getInt(2, 1);
        this.f32890a = i;
        if (i == 1) {
            setTextSize(0, f32881o);
            int i2 = f32875i;
            setPadding(i2, 0, i2, 0);
            this.f32891b = UiUtils.Companion.getBigBtnCornerFraction() * ((float) f32878l);
        } else if (i == 2) {
            setTextSize(0, f32883q);
            int i3 = f32876j;
            setPadding(i3, 0, i3, 0);
            this.f32891b = UiUtils.Companion.getMidBtnCornerFraction() * ((float) f32879m);
        } else if (i == 3) {
            setTextSize(0, f32886t);
            int i4 = f32877k;
            setPadding(i4, 0, i4, 0);
            this.f32891b = UiUtils.Companion.getSmallBtnCornerFraction() * ((float) f32885s);
        }
        this.f32893d = typedArray.getInt(0, 1);
        this.f32892c = typedArray.getBoolean(4, false);
        setText(getText());
        setEnabled(isEnabled());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer num;
        if (!isEnabled() || !isClickable()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent == null) {
            num = null;
        } else {
            num = Integer.valueOf(motionEvent.getAction());
        }
        if (num != null && num.intValue() == 0) {
            m23187a();
        } else {
            boolean z = true;
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
                z = false;
            }
            if (z) {
                m23188b();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private final void m23187a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f32891b);
        int i = -16777216;
        if (this.f32893d == 1) {
            int i2 = this.f32894e;
            if (UiUtils.Companion.isWhiteInThemeBg()) {
                i = -1;
            }
            setTextColor(androidx.core.graphics.ColorUtils.compositeColors(i2, i));
            gradientDrawable.setOrientation(UiUtils.Companion.getWalletFirstLevelButtonBgColorOrientation());
            gradientDrawable.setColors(new int[]{this.f32895f, this.f32896g});
        } else {
            setTextColor(androidx.core.graphics.ColorUtils.compositeColors(this.f32894e, -16777216));
            gradientDrawable.setColor(this.f32897h);
        }
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f32893d > 0) {
            if (!isEnabled()) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                setTextColor(f32887u);
                gradientDrawable.setCornerRadius(this.f32891b);
                gradientDrawable.setColor(f32888v);
                Unit unit = Unit.INSTANCE;
                setBackground(gradientDrawable);
                return;
            }
            m23188b();
        }
    }

    /* renamed from: b */
    private final void m23188b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f32891b);
        int i = -16777216;
        if (this.f32893d == 1) {
            if (UiUtils.Companion.isWhiteInThemeBg()) {
                i = -1;
            }
            setTextColor(i);
            gradientDrawable.setOrientation(UiUtils.Companion.getWalletFirstLevelButtonBgColorOrientation());
            gradientDrawable.setColors(new int[]{UiUtils.Companion.getWalletFirstLevelButtonBgStartColor(), UiUtils.Companion.getWalletFirstLevelButtonBgEndColor()});
        } else {
            setTextColor(-16777216);
            gradientDrawable.setColor(f32889w);
        }
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }
}
