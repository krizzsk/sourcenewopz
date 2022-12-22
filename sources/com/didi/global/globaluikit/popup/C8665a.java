package com.didi.global.globaluikit.popup;

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
import com.didi.global.globaluikit.utils.UiUtils;
import com.taxis99.R;

/* renamed from: com.didi.global.globaluikit.popup.a */
/* compiled from: LEGOPopup */
class C8665a extends PopupWindow {

    /* renamed from: a */
    private ViewGroup f22613a;

    /* renamed from: b */
    private LEGOBubbleLayout f22614b;

    /* renamed from: c */
    private Context f22615c;

    C8665a(Context context) {
        this.f22615c = context;
        setWidth(-2);
        setHeight(-2);
        m16271e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67053a(int i) {
        this.f22614b.setBubbleBackgroundColor(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67060a(String str) {
        this.f22614b.setText(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67066b(int i) {
        this.f22614b.setTypeface(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67055a(int i, int i2, int i3) {
        this.f22614b.mo67030a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67061a(String str, int i) {
        this.f22614b.mo67032a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67068b(String str) {
        this.f22614b.setLeftDrawable(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo67071c(int i) {
        this.f22614b.setLeftDrawable(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67057a(View view) {
        this.f22614b.setLeftView(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67058a(View view, int i, int i2) {
        this.f22614b.mo67031a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67064a(boolean z) {
        this.f22614b.setCloseBtnVisible(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67056a(View.OnClickListener onClickListener) {
        this.f22614b.setCloseClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67069b(boolean z) {
        setFocusable(z);
        setOutsideTouchable(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo67067b(View.OnClickListener onClickListener) {
        this.f22613a.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo67075d(int i) {
        this.f22614b.setMaxLines(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67063a(String str, String str2, int i, String str3, int i2, View view, int i3, int i4, View.OnClickListener onClickListener) {
        LEGOBubbleLayout lEGOBubbleLayout = new LEGOBubbleLayout(this.f22615c);
        this.f22614b = lEGOBubbleLayout;
        lEGOBubbleLayout.mo67032a(str2, 0);
        this.f22614b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f22614b.setLeftDrawable(str3);
        }
        if (i2 > 0) {
            this.f22614b.setLeftDrawable(i2);
        }
        if (view != null) {
            if (i3 <= 0 || i4 <= 0) {
                this.f22614b.setLeftView(view);
            } else {
                this.f22614b.mo67031a(view, i3, i4);
            }
        }
        this.f22614b.setTypeface(i);
        this.f22614b.setCloseBtnVisible(true);
        LEGOBubbleLayout lEGOBubbleLayout2 = this.f22614b;
        if (onClickListener == null) {
            onClickListener = new LEGOPopup$1(this);
        }
        lEGOBubbleLayout2.setCloseClickListener(onClickListener);
        this.f22613a.addView(this.f22614b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67062a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, View.OnClickListener onClickListener) {
        this.f22614b.mo67032a(str2, 0);
        this.f22614b.setBubbleBackgroundColor(i);
        this.f22614b.setPadding(20, 20, 20, 20);
        this.f22614b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f22614b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f22614b.setLeftDrawable(str3);
        }
        if (i3 > 0) {
            this.f22614b.setLeftDrawable(i3);
        }
        if (view != null) {
            if (i4 <= 0 || i5 <= 0) {
                this.f22614b.setLeftView(view);
            } else {
                this.f22614b.mo67031a(view, i4, i5);
            }
        }
        this.f22614b.setTypeface(i2);
        this.f22614b.setCloseBtnVisible(z);
        LEGOBubbleLayout lEGOBubbleLayout = this.f22614b;
        if (onClickListener == null) {
            onClickListener = new LEGOPopup$2(this);
        }
        lEGOBubbleLayout.setCloseClickListener(onClickListener);
        this.f22613a.addView(this.f22614b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67059a(C8666b bVar) {
        if (bVar != null && bVar.f22616a != null && !TextUtils.isEmpty(bVar.f22616a.text)) {
            this.f22614b = new LEGOBubbleLayout(this.f22615c);
            if (bVar.f22621f != null) {
                this.f22614b.mo67032a(bVar.f22621f.position, bVar.f22621f.offset);
            }
            if (!TextUtils.isEmpty(bVar.f22619d)) {
                this.f22614b.setBubbleBackgroundColor(UiUtils.getColor(bVar.f22619d));
            }
            this.f22614b.setPadding(20, 20, 20, 20);
            this.f22614b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f22614b.setText(bVar.f22616a.text);
            this.f22614b.mo67030a(bVar.f22616a.size, bVar.f22616a.bold, bVar.f22616a.italic);
            LEGOBubbleLayout lEGOBubbleLayout = this.f22614b;
            boolean z = true;
            if (bVar.f22618c != 1) {
                z = false;
            }
            lEGOBubbleLayout.setCloseBtnVisible(z);
            this.f22614b.setCloseClickListener(bVar.f22622g);
            this.f22614b.setLeftDrawable(bVar.f22620e);
            this.f22613a.addView(this.f22614b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo67070b(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            mo67072c(view, i, i2);
            return true;
        } else if (!view.getRootView().isAttachedToWindow()) {
            return false;
        } else {
            mo67072c(view, i, i2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo67072c(View view, int i, int i2) {
        if (view != null && view.getContext() != null && !m16270a(view.getContext())) {
            try {
                showAsDropDown(view, i, i2);
            } catch (Exception unused) {
                new Handler().postDelayed(new LEGOPopup$3(this, view, i, i2), 500);
            }
            LEGOBubbleLayout lEGOBubbleLayout = this.f22614b;
            lEGOBubbleLayout.setPivotX(lEGOBubbleLayout.getPivot()[0]);
            LEGOBubbleLayout lEGOBubbleLayout2 = this.f22614b;
            lEGOBubbleLayout2.setPivotY(lEGOBubbleLayout2.getPivot()[1]);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22614b, "translationX", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22614b, "translationY", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
    }

    /* renamed from: a */
    private boolean m16270a(Context context) {
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
    public int mo67052a() {
        return this.f22614b.getLayoutWidth();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo67065b() {
        return this.f22614b.getLayoutHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo67073c() {
        return this.f22614b.getMeasureWidthAndHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67054a(int i, int i2) {
        this.f22614b.mo67029a(i, i2);
    }

    /* renamed from: e */
    private void m16271e() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.f22615c.getSystemService("layout_inflater")).inflate(R.layout.lego_popup_window, (ViewGroup) null);
        this.f22613a = viewGroup;
        viewGroup.setOnClickListener(new LEGOPopup$4(this));
        setContentView(this.f22613a);
        setFocusable(false);
        setOutsideTouchable(false);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        LEGOBubbleLayout lEGOBubbleLayout = new LEGOBubbleLayout(this.f22615c);
        this.f22614b = lEGOBubbleLayout;
        lEGOBubbleLayout.setBubbleBackgroundColor(this.f22615c.getResources().getColor(R.color.grayscale_color_2));
        this.f22614b.setPadding(20, 20, 20, 20);
        this.f22614b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo67074d() {
        this.f22613a.addView(this.f22614b);
    }
}
