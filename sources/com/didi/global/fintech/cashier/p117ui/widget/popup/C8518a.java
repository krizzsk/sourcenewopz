package com.didi.global.fintech.cashier.p117ui.widget.popup;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import com.taxis99.R;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.a */
/* compiled from: CashierPopup */
class C8518a extends PopupWindow {

    /* renamed from: a */
    private ViewGroup f21951a;

    /* renamed from: b */
    private CashierBubbleLayout f21952b;

    /* renamed from: c */
    private Context f21953c;

    C8518a(Context context) {
        this.f21953c = context;
        setWidth(-2);
        setHeight(-2);
        m15887e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66250a(int i) {
        this.f21952b.setBubbleBackgroundColor(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66257a(String str) {
        this.f21952b.setText(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66263b(int i) {
        this.f21952b.setTypeface(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66252a(int i, int i2, int i3) {
        this.f21952b.mo66227a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66258a(String str, int i) {
        this.f21952b.mo66229a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66265b(String str) {
        this.f21952b.setLeftDrawable(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo66268c(int i) {
        this.f21952b.setLeftDrawable(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66254a(View view) {
        this.f21952b.setLeftView(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66255a(View view, int i, int i2) {
        this.f21952b.mo66228a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66261a(boolean z) {
        this.f21952b.setCloseBtnVisible(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66253a(View.OnClickListener onClickListener) {
        this.f21952b.setCloseClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66266b(boolean z) {
        setFocusable(z);
        setOutsideTouchable(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66264b(View.OnClickListener onClickListener) {
        this.f21951a.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo66272d(int i) {
        this.f21952b.setMaxLines(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66260a(String str, String str2, int i, String str3, int i2, View view, int i3, int i4, View.OnClickListener onClickListener) {
        CashierBubbleLayout cashierBubbleLayout = new CashierBubbleLayout(this.f21953c);
        this.f21952b = cashierBubbleLayout;
        cashierBubbleLayout.mo66229a(str2, 0);
        this.f21952b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f21952b.setLeftDrawable(str3);
        }
        if (i2 > 0) {
            this.f21952b.setLeftDrawable(i2);
        }
        if (view != null) {
            if (i3 <= 0 || i4 <= 0) {
                this.f21952b.setLeftView(view);
            } else {
                this.f21952b.mo66228a(view, i3, i4);
            }
        }
        this.f21952b.setTypeface(i);
        this.f21952b.setCloseBtnVisible(true);
        CashierBubbleLayout cashierBubbleLayout2 = this.f21952b;
        if (onClickListener == null) {
            onClickListener = new CashierPopup$1(this);
        }
        cashierBubbleLayout2.setCloseClickListener(onClickListener);
        this.f21951a.addView(this.f21952b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66259a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, View.OnClickListener onClickListener) {
        this.f21952b.mo66229a(str2, 0);
        this.f21952b.setBubbleBackgroundColor(i);
        this.f21952b.setPadding(20, 20, 20, 20);
        this.f21952b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f21952b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f21952b.setLeftDrawable(str3);
        }
        if (i3 > 0) {
            this.f21952b.setLeftDrawable(i3);
        }
        if (view != null) {
            if (i4 <= 0 || i5 <= 0) {
                this.f21952b.setLeftView(view);
            } else {
                this.f21952b.mo66228a(view, i4, i5);
            }
        }
        this.f21952b.setTypeface(i2);
        this.f21952b.setCloseBtnVisible(z);
        CashierBubbleLayout cashierBubbleLayout = this.f21952b;
        if (onClickListener == null) {
            onClickListener = new CashierPopup$2(this);
        }
        cashierBubbleLayout.setCloseClickListener(onClickListener);
        this.f21951a.addView(this.f21952b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66256a(C8519b bVar) {
        if (bVar != null && bVar.f21954a != null && !TextUtils.isEmpty(bVar.f21954a.text)) {
            this.f21952b = new CashierBubbleLayout(this.f21953c);
            if (bVar.f21959f != null) {
                this.f21952b.mo66229a(bVar.f21959f.position, bVar.f21959f.offset);
            }
            if (!TextUtils.isEmpty(bVar.f21957d)) {
                this.f21952b.setBubbleBackgroundColor(ContextKtxKt.getColor(this.f21953c, bVar.f21957d, (String) null));
            }
            this.f21952b.setPadding(20, 20, 20, 20);
            this.f21952b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f21952b.setText(bVar.f21954a.text);
            this.f21952b.mo66227a(bVar.f21954a.size, bVar.f21954a.bold, bVar.f21954a.italic);
            CashierBubbleLayout cashierBubbleLayout = this.f21952b;
            boolean z = true;
            if (bVar.f21956c != 1) {
                z = false;
            }
            cashierBubbleLayout.setCloseBtnVisible(z);
            this.f21952b.setCloseClickListener(bVar.f21960g);
            this.f21952b.setLeftDrawable(bVar.f21958e);
            this.f21951a.addView(this.f21952b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo66267b(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            mo66269c(view, i, i2);
            return true;
        } else if (!view.getRootView().isAttachedToWindow()) {
            return false;
        } else {
            mo66269c(view, i, i2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo66269c(View view, int i, int i2) {
        if (view != null && view.getContext() != null && !m15886a(view.getContext())) {
            try {
                showAsDropDown(view, i, i2);
            } catch (Exception unused) {
                new Handler().postDelayed(new CashierPopup$3(this, view, i, i2), 500);
            }
            CashierBubbleLayout cashierBubbleLayout = this.f21952b;
            cashierBubbleLayout.setPivotX(cashierBubbleLayout.getPivot()[0]);
            CashierBubbleLayout cashierBubbleLayout2 = this.f21952b;
            cashierBubbleLayout2.setPivotY(cashierBubbleLayout2.getPivot()[1]);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21952b, "translationX", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21952b, "translationY", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
    }

    /* renamed from: a */
    private boolean m15886a(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        super.dismiss();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo66249a() {
        return this.f21952b.getLayoutWidth();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo66262b() {
        return this.f21952b.getLayoutHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo66270c() {
        return this.f21952b.getMeasureWidthAndHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66251a(int i, int i2) {
        this.f21952b.mo66226a(i, i2);
    }

    /* renamed from: e */
    private void m15887e() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.f21953c.getSystemService("layout_inflater")).inflate(R.layout.global_cashier_popup_window, (ViewGroup) null);
        this.f21951a = viewGroup;
        viewGroup.setOnClickListener(new CashierPopup$4(this));
        setContentView(this.f21951a);
        setFocusable(false);
        setOutsideTouchable(false);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        CashierBubbleLayout cashierBubbleLayout = new CashierBubbleLayout(this.f21953c);
        this.f21952b = cashierBubbleLayout;
        cashierBubbleLayout.setBubbleBackgroundColor(this.f21953c.getResources().getColor(R.color.grayscale_color_2));
        this.f21952b.setPadding(20, 20, 20, 20);
        this.f21952b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo66271d() {
        this.f21951a.addView(this.f21952b);
    }
}
