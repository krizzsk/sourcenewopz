package com.didi.addressold.view.tips;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.taxis99.R;

public class TipsContainer extends FrameLayout {

    /* renamed from: a */
    private static int f7972a;

    /* renamed from: b */
    private Activity f7973b;

    /* renamed from: c */
    private OnActivityListener f7974c;

    /* renamed from: d */
    private OnTipClearListener f7975d;

    /* renamed from: e */
    private boolean f7976e = false;

    /* renamed from: f */
    private C3536a f7977f;

    public interface OnActivityListener {
        void onAttach();

        void onDetach();
    }

    public interface OnTipClearListener {
        void onDismiss();
    }

    public TipsContainer(Activity activity) {
        super(activity);
        m5159a(activity);
    }

    public TipsContainer(Activity activity, OnActivityListener onActivityListener) {
        super(activity);
        this.f7974c = onActivityListener;
        m5159a(activity);
    }

    /* renamed from: a */
    private void m5159a(Activity activity) {
        this.f7973b = activity;
        setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    /* renamed from: a */
    private void m5158a() {
        if (!this.f7976e) {
            this.f7976e = true;
            this.f7973b.addContentView(this, new FrameLayout.LayoutParams(-1, -1));
            OnActivityListener onActivityListener = this.f7974c;
            if (onActivityListener != null) {
                onActivityListener.onAttach();
            }
        }
    }

    public void detachFromActivity() {
        if (this.f7976e) {
            this.f7976e = false;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
                OnActivityListener onActivityListener = this.f7974c;
                if (onActivityListener != null) {
                    onActivityListener.onDetach();
                }
            }
        }
    }

    public void clearAllTips() {
        C3536a aVar = this.f7977f;
        if (aVar != null) {
            aVar.mo39981b();
        }
    }

    /* access modifiers changed from: protected */
    public void clear() {
        removeAllViews();
        detachFromActivity();
        OnTipClearListener onTipClearListener = this.f7975d;
        if (onTipClearListener != null) {
            onTipClearListener.onDismiss();
        }
        f7972a = 0;
    }

    public static void subtractShowTime() {
        f7972a--;
    }

    public void show(TipsView tipsView, View view, int i, int i2) {
        show(tipsView, view, i, i2, 0, 0);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4) {
        show(tipsView, view, i, i2, i3, i4, false);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4, boolean z) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m5158a();
            C3539d dVar = new C3539d(this.f7973b, this);
            this.f7977f = dVar;
            dVar.mo39979a(view, tipsView);
            this.f7977f.mo39978a(i, i2, 0, i3, i4, z);
            f7972a++;
        }
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5) {
        showWithLine(tipsView, view, i, i2, i3, i4, i5, 0, "");
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5, long j, String str) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m5158a();
            C3538c cVar = new C3538c(this.f7973b, this);
            this.f7977f = cVar;
            cVar.mo39979a(view, tipsView);
            ((C3538c) this.f7977f).mo39983a(j, str);
            this.f7977f.mo39978a(i, i2, i3, i4, i5, false);
            f7972a++;
        }
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3) {
        showWithLine(tipsView, view, i, i2, i3, 0, 0, 0, "");
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, long j, String str) {
        showWithLine(tipsView, view, i, i2, i3, 0, 0, j, str);
    }

    public void addView(View view) {
        super.addView(view);
    }

    public void addView(View view, FrameLayout.LayoutParams layoutParams) {
        if (view.getParent() == null) {
            super.addView(view, layoutParams);
        }
    }

    public void addView(View view, int i) {
        if (view.getParent() == null) {
            super.addView(view, i);
        }
    }

    public void addView(View view, int i, int i2) {
        if (view.getParent() == null) {
            super.addView(view, i, i2);
        }
    }

    public void addView(View view, int i, FrameLayout.LayoutParams layoutParams) {
        if (view.getParent() == null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Deprecated
    /* renamed from: b */
    private void m5160b() {
        C3536a aVar = this.f7977f;
        if (aVar != null) {
            aVar.mo39981b();
        }
        removeAllViews();
        f7972a = 0;
    }

    public static boolean isShowing() {
        return f7972a != 0;
    }

    public void setOnClearListener(OnTipClearListener onTipClearListener) {
        this.f7975d = onTipClearListener;
    }
}
