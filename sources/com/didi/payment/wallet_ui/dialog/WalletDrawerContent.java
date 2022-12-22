package com.didi.payment.wallet_ui.dialog;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.WalletButton;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\u0018\u00002\u00020\u0001:\u00016B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ¨\u0001\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020#2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010)2\n\b\u0002\u00100\u001a\u0004\u0018\u00010+2\n\b\u0002\u00101\u001a\u0004\u0018\u00010)2\n\b\u0002\u00102\u001a\u0004\u0018\u00010+2\n\b\u0002\u00103\u001a\u0004\u0018\u00010)J8\u00104\u001a\u00020!2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010)2\n\b\u0002\u00100\u001a\u0004\u0018\u00010+2\n\b\u0002\u00101\u001a\u0004\u0018\u00010)H\u0002JP\u00105\u001a\u00020!2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010)2\n\b\u0002\u00100\u001a\u0004\u0018\u00010+2\n\b\u0002\u00101\u001a\u0004\u0018\u00010)2\n\b\u0002\u00102\u001a\u0004\u0018\u00010+2\n\b\u0002\u00103\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletDrawerContent;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mFlBottomBtn", "Landroid/widget/FrameLayout;", "mFlInsert", "mIvClose", "Landroid/widget/ImageView;", "mIvImage", "mLlHorizontalBtn", "mLlVerticalBtn", "mNsvContent", "Landroidx/core/widget/NestedScrollView;", "mTvBtnHorizontalFirst", "Lcom/didi/payment/wallet_ui/WalletButton;", "mTvBtnHorizontalSecond", "mTvBtnVerticalFirst", "mTvBtnVerticalSecond", "mTvBtnVerticalThird", "mTvContent", "Landroid/widget/TextView;", "mTvTitle", "mVClose", "Landroid/view/View;", "maxDrawerHeight", "config", "", "horizontalAction", "", "imageUrl", "", "imageRes", "showClose", "closeClickListener", "Landroid/view/View$OnClickListener;", "title", "", "content", "insertView", "firstBtnText", "firstClickListener", "secondBtnText", "secondClickListener", "thirdBtnText", "thirdClickListener", "configHorizontalAction", "configVerticalAction", "Builder", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDrawerContent.kt */
public final class WalletDrawerContent extends LinearLayout {

    /* renamed from: a */
    private WalletButton f32932a;

    /* renamed from: b */
    private WalletButton f32933b;

    /* renamed from: c */
    private WalletButton f32934c;

    /* renamed from: d */
    private WalletButton f32935d;

    /* renamed from: e */
    private WalletButton f32936e;

    /* renamed from: f */
    private NestedScrollView f32937f;

    /* renamed from: g */
    private FrameLayout f32938g;

    /* renamed from: h */
    private TextView f32939h;

    /* renamed from: i */
    private TextView f32940i;

    /* renamed from: j */
    private View f32941j;

    /* renamed from: k */
    private ImageView f32942k;

    /* renamed from: l */
    private ImageView f32943l;

    /* renamed from: m */
    private FrameLayout f32944m;

    /* renamed from: n */
    private LinearLayout f32945n;

    /* renamed from: o */
    private LinearLayout f32946o;

    /* renamed from: p */
    private final int f32947p;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletDrawerContent(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_dialog_drawer, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        setOrientation(1);
        Unit unit = Unit.INSTANCE;
        setLayoutParams(layoutParams);
        View findViewById = findViewById(R.id.iv_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_image)");
        this.f32943l = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_close)");
        this.f32942k = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.v_close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.v_close)");
        this.f32941j = findViewById3;
        View findViewById4 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_title)");
        this.f32940i = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_content)");
        this.f32939h = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.fl_insert);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.fl_insert)");
        this.f32938g = (FrameLayout) findViewById6;
        View findViewById7 = findViewById(R.id.nsv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.nsv_content)");
        this.f32937f = (NestedScrollView) findViewById7;
        View findViewById8 = findViewById(R.id.tv_btn_vertical_first);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_btn_vertical_first)");
        this.f32936e = (WalletButton) findViewById8;
        View findViewById9 = findViewById(R.id.tv_btn_vertical_second);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_btn_vertical_second)");
        this.f32935d = (WalletButton) findViewById9;
        View findViewById10 = findViewById(R.id.tv_btn_vertical_third);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.tv_btn_vertical_third)");
        this.f32934c = (WalletButton) findViewById10;
        View findViewById11 = findViewById(R.id.tv_btn_horizontal_first);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.tv_btn_horizontal_first)");
        this.f32933b = (WalletButton) findViewById11;
        View findViewById12 = findViewById(R.id.tv_btn_horizontal_second);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.tv_btn_horizontal_second)");
        this.f32932a = (WalletButton) findViewById12;
        View findViewById13 = findViewById(R.id.ll_horizontal_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.ll_horizontal_btn)");
        this.f32945n = (LinearLayout) findViewById13;
        View findViewById14 = findViewById(R.id.ll_vertical_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.ll_vertical_btn)");
        this.f32946o = (LinearLayout) findViewById14;
        View findViewById15 = findViewById(R.id.fl_bottom_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.fl_bottom_btn)");
        this.f32944m = (FrameLayout) findViewById15;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        setBackground(gradientDrawable);
        this.f32947p = UiUtils.Companion.getScreenHeight() - UiUtils.Companion.intSize(180);
    }

    public static /* synthetic */ void config$default(WalletDrawerContent walletDrawerContent, boolean z, String str, int i, boolean z2, View.OnClickListener onClickListener, CharSequence charSequence, CharSequence charSequence2, View view, CharSequence charSequence3, View.OnClickListener onClickListener2, CharSequence charSequence4, View.OnClickListener onClickListener3, CharSequence charSequence5, View.OnClickListener onClickListener4, int i2, Object obj) {
        int i3 = i2;
        boolean z3 = false;
        boolean z4 = (i3 & 1) != 0 ? false : z;
        View.OnClickListener onClickListener5 = null;
        String str2 = (i3 & 2) != 0 ? null : str;
        int i4 = (i3 & 4) != 0 ? -1 : i;
        if ((i3 & 8) == 0) {
            z3 = z2;
        }
        View.OnClickListener onClickListener6 = (i3 & 16) != 0 ? null : onClickListener;
        CharSequence charSequence6 = (i3 & 32) != 0 ? null : charSequence;
        CharSequence charSequence7 = (i3 & 64) != 0 ? null : charSequence2;
        View view2 = (i3 & 128) != 0 ? null : view;
        CharSequence charSequence8 = (i3 & 256) != 0 ? null : charSequence3;
        View.OnClickListener onClickListener7 = (i3 & 512) != 0 ? null : onClickListener2;
        CharSequence charSequence9 = (i3 & 1024) != 0 ? null : charSequence4;
        View.OnClickListener onClickListener8 = (i3 & 2048) != 0 ? null : onClickListener3;
        CharSequence charSequence10 = (i3 & 4096) != 0 ? null : charSequence5;
        if ((i3 & 8192) == 0) {
            onClickListener5 = onClickListener4;
        }
        walletDrawerContent.config(z4, str2, i4, z3, onClickListener6, charSequence6, charSequence7, view2, charSequence8, onClickListener7, charSequence9, onClickListener8, charSequence10, onClickListener5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
        if (r1 <= 1) goto L_0x00a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void config(boolean r10, java.lang.String r11, int r12, boolean r13, android.view.View.OnClickListener r14, java.lang.CharSequence r15, java.lang.CharSequence r16, android.view.View r17, java.lang.CharSequence r18, android.view.View.OnClickListener r19, java.lang.CharSequence r20, android.view.View.OnClickListener r21, java.lang.CharSequence r22, android.view.View.OnClickListener r23) {
        /*
            r9 = this;
            r0 = r9
            r1 = r11
            r2 = r12
            r3 = r17
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 8
            r6 = 0
            if (r4 == 0) goto L_0x001a
            r4 = -1
            if (r2 != r4) goto L_0x001a
            android.widget.ImageView r1 = r0.f32943l
            r1.setVisibility(r5)
            goto L_0x002e
        L_0x001a:
            android.widget.ImageView r4 = r0.f32943l
            r4.setVisibility(r6)
            android.content.Context r4 = r9.getContext()
            com.didi.payment.wallet_ui.dialog.WalletDialog$Companion r7 = com.didi.payment.wallet_ui.dialog.WalletDialog.Companion
            float r7 = r7.getRadius()
            android.widget.ImageView r8 = r0.f32943l
            com.didi.payment.base.utils.GlideUtils.loadTopRoundImageMix(r4, r12, r11, r7, r8)
        L_0x002e:
            if (r13 == 0) goto L_0x0041
            android.widget.ImageView r1 = r0.f32942k
            r1.setVisibility(r6)
            android.view.View r1 = r0.f32941j
            r1.setVisibility(r6)
            android.view.View r1 = r0.f32941j
            r2 = r14
            r1.setOnClickListener(r14)
            goto L_0x004b
        L_0x0041:
            android.widget.ImageView r1 = r0.f32942k
            r1.setVisibility(r5)
            android.view.View r1 = r0.f32941j
            r1.setVisibility(r5)
        L_0x004b:
            boolean r1 = android.text.TextUtils.isEmpty(r15)
            if (r1 == 0) goto L_0x0057
            android.widget.TextView r1 = r0.f32940i
            r1.setVisibility(r5)
            goto L_0x0062
        L_0x0057:
            android.widget.TextView r1 = r0.f32940i
            r1.setVisibility(r6)
            android.widget.TextView r1 = r0.f32940i
            r2 = r15
            r1.setText(r15)
        L_0x0062:
            boolean r1 = android.text.TextUtils.isEmpty(r16)
            if (r1 == 0) goto L_0x006e
            android.widget.TextView r1 = r0.f32939h
            r1.setVisibility(r5)
            goto L_0x007a
        L_0x006e:
            android.widget.TextView r1 = r0.f32939h
            r1.setVisibility(r6)
            android.widget.TextView r1 = r0.f32939h
            r2 = r16
            r1.setText(r2)
        L_0x007a:
            if (r3 != 0) goto L_0x0082
            android.widget.FrameLayout r1 = r0.f32938g
            r1.setVisibility(r5)
            goto L_0x0091
        L_0x0082:
            android.widget.FrameLayout r1 = r0.f32938g
            r1.setVisibility(r6)
            android.widget.FrameLayout r1 = r0.f32938g
            r1.removeAllViews()
            android.widget.FrameLayout r1 = r0.f32938g
            r1.addView(r3)
        L_0x0091:
            if (r10 == 0) goto L_0x00a7
            r1 = 2
            boolean r2 = android.text.TextUtils.isEmpty(r18)
            r3 = 1
            if (r2 == 0) goto L_0x009c
            r1 = 1
        L_0x009c:
            boolean r2 = android.text.TextUtils.isEmpty(r20)
            if (r2 == 0) goto L_0x00a4
            int r1 = r1 + -1
        L_0x00a4:
            if (r1 > r3) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r6 = r10
        L_0x00a8:
            if (r6 == 0) goto L_0x00b6
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r9.m23193a(r1, r2, r3, r4)
            goto L_0x00ce
        L_0x00b6:
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r10 = r9
            r11 = r18
            r12 = r19
            r13 = r20
            r14 = r21
            r15 = r22
            r16 = r23
            r10.m23194a(r11, r12, r13, r14, r15, r16)
        L_0x00ce:
            com.didi.payment.wallet_ui.UiUtils$Companion r1 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r1 = r1.getScreenWidth()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
            com.didi.payment.wallet_ui.UiUtils$Companion r3 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r3 = r3.getScreenHeight()
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            r9.measure(r1, r3)
            android.widget.FrameLayout r1 = r0.f32944m
            com.didi.payment.wallet_ui.UiUtils$Companion r3 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r3 = r3.getScreenWidth()
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            com.didi.payment.wallet_ui.UiUtils$Companion r4 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r4 = r4.getScreenHeight()
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            r1.measure(r3, r2)
            int r1 = r9.getMeasuredHeight()
            int r2 = r0.f32947p
            if (r1 <= r2) goto L_0x011e
            androidx.core.widget.NestedScrollView r1 = r0.f32937f
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            int r3 = r0.f32947p
            android.widget.FrameLayout r4 = r0.f32944m
            int r4 = r4.getMeasuredHeight()
            int r3 = r3 - r4
            r2.height = r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r1.setLayoutParams(r2)
        L_0x011e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet_ui.dialog.WalletDrawerContent.config(boolean, java.lang.String, int, boolean, android.view.View$OnClickListener, java.lang.CharSequence, java.lang.CharSequence, android.view.View, java.lang.CharSequence, android.view.View$OnClickListener, java.lang.CharSequence, android.view.View$OnClickListener, java.lang.CharSequence, android.view.View$OnClickListener):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m23192a(WalletDrawerContent walletDrawerContent, CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2, CharSequence charSequence3, View.OnClickListener onClickListener3, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        if ((i & 8) != 0) {
            onClickListener2 = null;
        }
        if ((i & 16) != 0) {
            charSequence3 = null;
        }
        if ((i & 32) != 0) {
            onClickListener3 = null;
        }
        walletDrawerContent.m23194a(charSequence, onClickListener, charSequence2, onClickListener2, charSequence3, onClickListener3);
    }

    /* renamed from: a */
    private final void m23194a(CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2, CharSequence charSequence3, View.OnClickListener onClickListener3) {
        this.f32946o.setVisibility(0);
        this.f32945n.setVisibility(8);
        this.f32936e.setVisibility(0);
        this.f32936e.configButton(charSequence, onClickListener);
        if (TextUtils.isEmpty(charSequence2)) {
            this.f32935d.setVisibility(8);
        } else {
            this.f32935d.setVisibility(0);
            this.f32935d.configButton(charSequence2, onClickListener2);
        }
        if (TextUtils.isEmpty(charSequence3)) {
            this.f32934c.setVisibility(8);
            return;
        }
        this.f32934c.setVisibility(0);
        this.f32934c.configButton(charSequence3, onClickListener3);
    }

    /* renamed from: a */
    static /* synthetic */ void m23191a(WalletDrawerContent walletDrawerContent, CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        if ((i & 8) != 0) {
            onClickListener2 = null;
        }
        walletDrawerContent.m23193a(charSequence, onClickListener, charSequence2, onClickListener2);
    }

    /* renamed from: a */
    private final void m23193a(CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2) {
        this.f32946o.setVisibility(8);
        this.f32945n.setVisibility(0);
        this.f32933b.setVisibility(0);
        this.f32933b.setText(charSequence);
        this.f32933b.setOnClickListener(onClickListener);
        this.f32932a.setVisibility(0);
        this.f32932a.setText(charSequence2);
        this.f32932a.setOnClickListener(onClickListener2);
    }

    @Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001c\u00106\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001c\u0010<\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e¨\u0006C"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletDrawerContent$Builder;", "", "()V", "closeClickListener", "Landroid/view/View$OnClickListener;", "getCloseClickListener", "()Landroid/view/View$OnClickListener;", "setCloseClickListener", "(Landroid/view/View$OnClickListener;)V", "content", "", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "firstBtnText", "getFirstBtnText", "setFirstBtnText", "firstClickListener", "getFirstClickListener", "setFirstClickListener", "horizontalAction", "", "getHorizontalAction", "()Z", "setHorizontalAction", "(Z)V", "imageRes", "", "getImageRes", "()I", "setImageRes", "(I)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "insertView", "Landroid/view/View;", "getInsertView", "()Landroid/view/View;", "setInsertView", "(Landroid/view/View;)V", "secondBtnText", "getSecondBtnText", "setSecondBtnText", "secondClickListener", "getSecondClickListener", "setSecondClickListener", "showClose", "getShowClose", "setShowClose", "thirdBtnText", "getThirdBtnText", "setThirdBtnText", "thirdClickListener", "getThirdClickListener", "setThirdClickListener", "title", "getTitle", "setTitle", "build", "Lcom/didi/payment/wallet_ui/dialog/WalletDrawerContent;", "context", "Landroid/content/Context;", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletDrawerContent.kt */
    public static final class Builder {
        private View.OnClickListener closeClickListener;
        private CharSequence content;
        private CharSequence firstBtnText;
        private View.OnClickListener firstClickListener;
        private boolean horizontalAction;
        private int imageRes = -1;
        private String imageUrl;
        private View insertView;
        private CharSequence secondBtnText;
        private View.OnClickListener secondClickListener;
        private boolean showClose;
        private CharSequence thirdBtnText;
        private View.OnClickListener thirdClickListener;
        private CharSequence title;

        public final boolean getHorizontalAction() {
            return this.horizontalAction;
        }

        public final void setHorizontalAction(boolean z) {
            this.horizontalAction = z;
        }

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

        public final boolean getShowClose() {
            return this.showClose;
        }

        public final void setShowClose(boolean z) {
            this.showClose = z;
        }

        public final View.OnClickListener getCloseClickListener() {
            return this.closeClickListener;
        }

        public final void setCloseClickListener(View.OnClickListener onClickListener) {
            this.closeClickListener = onClickListener;
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

        public final WalletDrawerContent build(Context context) {
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context2, "context");
            WalletDrawerContent walletDrawerContent = new WalletDrawerContent(context2, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            walletDrawerContent.config(getHorizontalAction(), getImageUrl(), getImageRes(), getShowClose(), getCloseClickListener(), getTitle(), getContent(), getInsertView(), getFirstBtnText(), getFirstClickListener(), getSecondBtnText(), getSecondClickListener(), getThirdBtnText(), getThirdClickListener());
            return walletDrawerContent;
        }
    }
}
