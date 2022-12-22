package com.didi.payment.wallet_ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ$\u0010\u0018\u001a\u00020\u00192\b\b\u0003\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0007J\u001a\u0010\u001e\u001a\u00020\u00192\b\b\u0003\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ.\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010\u001cJ.\u0010\u001f\u001a\u00020\u00192\b\b\u0003\u0010%\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010&\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u001cJ2\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001c\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010.2\n\b\u0002\u00101\u001a\u0004\u0018\u00010.J\u000e\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u000204R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, mo175978d2 = {"Lcom/didi/payment/wallet_ui/WalletTopNavigationBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIvBack", "Landroid/widget/ImageView;", "mIvClose", "mIvRight", "mIvRightSecond", "mTvLeft", "Landroid/widget/TextView;", "mTvRight", "mTvSubTitle", "mTvTitle", "mVRightBack", "Landroid/view/View;", "mVRightClose", "size32", "configBackBtn", "", "resId", "clickListener", "Landroid/view/View$OnClickListener;", "visibility", "configCloseBtn", "configRightBtn", "rightDrawable", "Landroid/graphics/drawable/Drawable;", "rightClickListener", "leftDrawable", "leftClickListener", "rightResId", "leftResId", "configRightBtnInner", "imageView", "leftPadding", "rightPadding", "drawable", "configRightText", "content", "", "configTitle", "title", "subTitle", "switchTheme", "white", "", "wallet-ui_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletTopNavigationBar.kt */
public final class WalletTopNavigationBar extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f32913a;

    /* renamed from: b */
    private ImageView f32914b;

    /* renamed from: c */
    private TextView f32915c;

    /* renamed from: d */
    private TextView f32916d;

    /* renamed from: e */
    private ImageView f32917e;

    /* renamed from: f */
    private ImageView f32918f;

    /* renamed from: g */
    private TextView f32919g;

    /* renamed from: h */
    private TextView f32920h;

    /* renamed from: i */
    private View f32921i;

    /* renamed from: j */
    private View f32922j;

    /* renamed from: k */
    private final int f32923k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletTopNavigationBar(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletTopNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletTopNavigationBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletTopNavigationBar(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTopNavigationBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f32923k = UiUtils.Companion.intSize(32);
        View.inflate(context, R.layout.wallet_ui_top_navigation, this);
        View findViewById = findViewById(R.id.iv_back);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_back)");
        this.f32913a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_close)");
        this.f32914b = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_title)");
        this.f32915c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tv_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_sub_title)");
        this.f32916d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.iv_right);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_right)");
        this.f32917e = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.iv_right_second);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_right_second)");
        this.f32918f = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.tv_right);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_right)");
        this.f32919g = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.tv_left);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_left)");
        this.f32920h = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.v_place_right_back);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.v_place_right_back)");
        this.f32921i = findViewById9;
        View findViewById10 = findViewById(R.id.v_place_right_close);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.v_place_right_close)");
        this.f32922j = findViewById10;
        int intSize = UiUtils.Companion.intSize(104);
        ImageView imageView = this.f32913a;
        int i3 = this.f32923k;
        imageView.setPadding(i3, i3, i3, i3);
        imageView.getLayoutParams().height = intSize;
        View view = this.f32921i;
        int i4 = this.f32923k;
        view.setPadding(i4, i4, i4, i4);
        view.getLayoutParams().height = intSize;
        this.f32922j.getLayoutParams().height = intSize;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.WalletTopNavigationBar);
        if (obtainStyledAttributes.getBoolean(6, false)) {
            setBackground(new ColorDrawable(UiUtils.Companion.getThemeBgColor()));
            switchTheme(UiUtils.Companion.isWhiteInThemeBg());
        } else {
            switchTheme(obtainStyledAttributes.getBoolean(7, false));
        }
        if (obtainStyledAttributes.getBoolean(3, false)) {
            configCloseBtn(-1, (View.OnClickListener) null);
        }
        CharSequence string = obtainStyledAttributes.getString(2);
        if (TextUtils.isEmpty(string)) {
            configRightBtn(obtainStyledAttributes.getDrawable(0), (View.OnClickListener) null, obtainStyledAttributes.getDrawable(1), (View.OnClickListener) null);
        } else {
            configRightText(string, (View.OnClickListener) null);
        }
        configTitle(obtainStyledAttributes.getString(5), obtainStyledAttributes.getString(4));
        obtainStyledAttributes.recycle();
    }

    public final void switchTheme(boolean z) {
        int i = z ? -1 : -16777216;
        this.f32915c.setTextColor(i);
        this.f32916d.setTextColor(i);
        this.f32913a.setImageResource(z ? R.drawable.wallet_icon_arrow_left_white : R.drawable.wallet_icon_arrow_left);
        this.f32914b.setImageResource(z ? R.drawable.wallet_icon_nav_close_white : R.drawable.wallet_icon_nav_close_black);
    }

    public static /* synthetic */ void configTitle$default(WalletTopNavigationBar walletTopNavigationBar, CharSequence charSequence, CharSequence charSequence2, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence2 = null;
        }
        walletTopNavigationBar.configTitle(charSequence, charSequence2);
    }

    public final void configTitle(CharSequence charSequence, CharSequence charSequence2) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f32915c.setVisibility(8);
            this.f32916d.setVisibility(8);
        } else if (!TextUtils.isEmpty(charSequence2)) {
            TextView textView = this.f32916d;
            textView.setVisibility(0);
            textView.setTextSize(0, UiUtils.Companion.floatSize(24));
            textView.setText(charSequence2);
            TextView textView2 = this.f32915c;
            textView2.setVisibility(0);
            textView2.setTextSize(0, UiUtils.Companion.floatSize(32));
            textView2.setText(charSequence);
        } else {
            this.f32916d.setVisibility(8);
            TextView textView3 = this.f32915c;
            textView3.setVisibility(0);
            textView3.setTextSize(0, UiUtils.Companion.floatSize(40));
            textView3.setText(charSequence);
        }
    }

    public static /* synthetic */ void configBackBtn$default(WalletTopNavigationBar walletTopNavigationBar, int i, View.OnClickListener onClickListener, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = -1;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        walletTopNavigationBar.configBackBtn(i, onClickListener, i2);
    }

    public final void configBackBtn(int i, View.OnClickListener onClickListener, int i2) {
        if (i2 != 0) {
            this.f32913a.setVisibility(4);
            this.f32913a.setClickable(false);
            return;
        }
        this.f32913a.setVisibility(0);
        this.f32913a.setClickable(true);
        if (i != -1) {
            this.f32913a.setImageResource(i);
        }
        this.f32913a.setOnClickListener(onClickListener);
    }

    public static /* synthetic */ void configCloseBtn$default(WalletTopNavigationBar walletTopNavigationBar, int i, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        walletTopNavigationBar.configCloseBtn(i, onClickListener);
    }

    public final void configCloseBtn(int i, View.OnClickListener onClickListener) {
        this.f32922j.setVisibility(0);
        ImageView imageView = this.f32914b;
        imageView.setVisibility(0);
        int i2 = this.f32923k;
        imageView.setPadding(i2 / 2, i2, i2 / 2, i2);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = UiUtils.Companion.intSize(104);
        Unit unit = Unit.INSTANCE;
        imageView.setLayoutParams(layoutParams);
        if (i != -1) {
            imageView.setImageResource(i);
        }
        imageView.setOnClickListener(onClickListener);
    }

    public final void configRightBtn(Drawable drawable, View.OnClickListener onClickListener, Drawable drawable2, View.OnClickListener onClickListener2) {
        this.f32922j.setVisibility(this.f32914b.getVisibility());
        if (drawable == null && drawable2 == null) {
            this.f32917e.setVisibility(8);
            this.f32918f.setVisibility(8);
        } else if (drawable == null && drawable2 != null) {
            this.f32917e.setVisibility(8);
            m23190a(this.f32918f, 0, this.f32923k, drawable2, onClickListener2);
        } else if (drawable != null && drawable2 == null) {
            this.f32918f.setVisibility(8);
            ImageView imageView = this.f32917e;
            int i = this.f32923k;
            m23190a(imageView, i, i, drawable, onClickListener);
        } else if (drawable != null && drawable2 != null) {
            this.f32917e.setVisibility(0);
            this.f32918f.setVisibility(0);
            ImageView imageView2 = this.f32917e;
            int i2 = this.f32923k;
            m23190a(imageView2, i2, i2, drawable, onClickListener);
            int i3 = this.f32923k / 2;
            m23190a(this.f32918f, i3, i3, drawable2, onClickListener2);
        }
    }

    public static /* synthetic */ void configRightBtn$default(WalletTopNavigationBar walletTopNavigationBar, int i, View.OnClickListener onClickListener, int i2, View.OnClickListener onClickListener2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = -1;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        walletTopNavigationBar.configRightBtn(i, onClickListener, i2, onClickListener2);
    }

    public final void configRightBtn(int i, View.OnClickListener onClickListener, int i2, View.OnClickListener onClickListener2) {
        Resources resources = getResources();
        if (resources != null) {
            configRightBtn(ResourcesCompat.getDrawable(resources, i, (Resources.Theme) null), onClickListener, ResourcesCompat.getDrawable(resources, i2, (Resources.Theme) null), onClickListener2);
        }
    }

    public final void configRightText(CharSequence charSequence, View.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f32919g.setVisibility(8);
            this.f32920h.setVisibility(8);
            return;
        }
        this.f32922j.setVisibility(this.f32914b.getVisibility());
        this.f32917e.setVisibility(8);
        this.f32918f.setVisibility(8);
        TextView textView = this.f32919g;
        textView.setVisibility(0);
        textView.setTextSize(0, UiUtils.Companion.floatSize(24));
        textView.setPadding(UiUtils.Companion.intSize(16), 0, UiUtils.Companion.intSize(32), 0);
        textView.setText(charSequence);
        TextView textView2 = this.f32920h;
        textView2.setVisibility(0);
        textView2.setTextSize(0, UiUtils.Companion.floatSize(24));
        textView2.setPadding(UiUtils.Companion.intSize(16), 0, UiUtils.Companion.intSize(32), 0);
        textView2.setText(charSequence);
        if (onClickListener != null) {
            this.f32919g.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: a */
    private final void m23190a(ImageView imageView, int i, int i2, Drawable drawable, View.OnClickListener onClickListener) {
        imageView.setVisibility(0);
        imageView.setImageDrawable(drawable);
        int i3 = this.f32923k;
        imageView.setPadding(i, i3, i2, i3);
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
