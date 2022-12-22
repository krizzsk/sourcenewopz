package com.adyen.threeds2.internal.p059ui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView */
public final class ExpandableInfoTextView extends LinearLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final View f1069a;

    /* renamed from: b */
    private final ImageView f1070b;

    /* renamed from: c */
    private final TextView f1071c;

    /* renamed from: d */
    private final TextView f1072d;

    /* renamed from: e */
    private final DividerView f1073e;

    /* renamed from: f */
    private float f1074f;

    /* renamed from: g */
    private int f1075g;

    /* renamed from: h */
    private C1426b f1076h;

    /* renamed from: com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$a */
    static /* synthetic */ class C1425a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1077a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$b[] r0 = com.adyen.threeds2.internal.p059ui.widget.ExpandableInfoTextView.C1426b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1077a = r0
                com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$b r1 = com.adyen.threeds2.internal.p059ui.widget.ExpandableInfoTextView.C1426b.EXPANDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1077a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$b r1 = com.adyen.threeds2.internal.p059ui.widget.ExpandableInfoTextView.C1426b.COLLAPSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.p059ui.widget.ExpandableInfoTextView.C1425a.<clinit>():void");
        }
    }

    /* renamed from: com.adyen.threeds2.internal.ui.widget.ExpandableInfoTextView$b */
    public enum C1426b {
        EXPANDED,
        COLLAPSED
    }

    public ExpandableInfoTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setState(C1426b bVar) {
        this.f1076h = bVar;
    }

    /* renamed from: a */
    public void mo14896a(boolean z) {
        if (this.f1076h != C1426b.COLLAPSED) {
            if (z) {
                this.f1070b.animate().rotation(0.0f).start();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f1072d.getHeight(), 0});
                ofInt.addUpdateListener(this);
                ofInt.addListener(this);
                ofInt.start();
                this.f1072d.animate().alpha(0.0f).start();
                return;
            }
            this.f1070b.setRotation(0.0f);
            this.f1072d.setHeight(0);
            this.f1072d.setAlpha(0.0f);
            setState(C1426b.COLLAPSED);
        }
    }

    /* renamed from: b */
    public void mo14897b(boolean z) {
        if (this.f1076h != C1426b.EXPANDED) {
            if (z) {
                this.f1070b.animate().rotation(180.0f).start();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f1075g});
                ofInt.addUpdateListener(this);
                ofInt.addListener(this);
                ofInt.start();
                this.f1072d.animate().alpha(this.f1074f).start();
                return;
            }
            this.f1070b.setRotation(180.0f);
            this.f1072d.setHeight(this.f1075g);
            this.f1072d.setAlpha(this.f1074f);
            setState(C1426b.EXPANDED);
        }
    }

    /* renamed from: c */
    public void mo14898c(boolean z) {
        int i = C1425a.f1077a[getState().ordinal()];
        if (i == 1) {
            mo14896a(z);
        } else if (i == 2) {
            mo14897b(z);
        }
    }

    public C1426b getState() {
        return this.f1076h;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        C1426b bVar = this.f1076h;
        C1426b bVar2 = C1426b.COLLAPSED;
        if (bVar == bVar2) {
            bVar2 = C1426b.EXPANDED;
        }
        setState(bVar2);
        this.f1069a.setClickable(true);
        if (this.f1076h == C1426b.COLLAPSED) {
            this.f1069a.sendAccessibilityEvent(8);
        } else {
            this.f1072d.sendAccessibilityEvent(8);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.f1069a.setClickable(false);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1072d.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        mo14898c(true);
    }

    public void onGlobalLayout() {
        this.f1072d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f1074f = this.f1072d.getAlpha();
        this.f1075g = this.f1072d.getMeasuredHeight();
        mo14898c(false);
    }

    public void setHeaderBackgroundColor(int i) {
        Drawable background = this.f1069a.getBackground();
        if (Build.VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        } else {
            ((RippleDrawable) background).setColor(ColorStateList.valueOf(i));
        }
    }

    public void setHorizontalDividerColor(int i) {
        this.f1073e.setColor(i);
    }

    public void setHorizontalDividerThickness(int i) {
        this.f1073e.setThickness(i);
    }

    public void setInfo(String str) {
        this.f1072d.setText(str);
    }

    public void setInfoFontSize(Integer num) {
        this.f1072d.setTextSize((float) num.intValue());
    }

    public void setInfoTextColor(int i) {
        this.f1072d.setTextColor(i);
    }

    public void setInfoTypeface(Typeface typeface) {
        this.f1072d.setTypeface(typeface);
    }

    public void setStateIndicatorColor(int i) {
        this.f1070b.setColorFilter(i);
    }

    public void setTitle(String str) {
        this.f1071c.setText(str);
    }

    public void setTitleFontSize(Integer num) {
        this.f1071c.setTextSize((float) num.intValue());
    }

    public void setTitleTextColor(int i) {
        this.f1071c.setTextColor(i);
    }

    public void setTitleTypeface(Typeface typeface) {
        this.f1071c.setTypeface(typeface);
    }

    public ExpandableInfoTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableInfoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1076h = C1426b.EXPANDED;
        LinearLayout.inflate(context, R.layout.a3ds2_widget_expandable_info_text, this);
        View findViewById = findViewById(R.id.viewGroup_header);
        this.f1069a = findViewById;
        findViewById.setOnClickListener(this);
        this.f1070b = (ImageView) findViewById(R.id.imageView_stateIndicator);
        this.f1071c = (TextView) findViewById(R.id.textView_title);
        TextView textView = (TextView) findViewById(R.id.textView_info);
        this.f1072d = textView;
        textView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f1073e = (DividerView) findViewById(R.id.dividerView_info);
    }
}
