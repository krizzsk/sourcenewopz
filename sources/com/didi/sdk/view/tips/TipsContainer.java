package com.didi.sdk.view.tips;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.taxis99.R;

public class TipsContainer extends FrameLayout {

    /* renamed from: a */
    private static int f38251a;

    /* renamed from: b */
    private Activity f38252b;

    /* renamed from: c */
    private OnActivityListener f38253c;

    /* renamed from: d */
    private OnTipClearListener f38254d;

    /* renamed from: e */
    private boolean f38255e = false;

    /* renamed from: f */
    private C13274a f38256f;

    public interface OnActivityListener {
        void onAttach();

        void onDetach();
    }

    public interface OnTipClearListener {
        void onDismiss();
    }

    public TipsContainer(Activity activity) {
        super(activity);
        m27038a(activity);
    }

    public TipsContainer(Activity activity, OnActivityListener onActivityListener) {
        super(activity);
        this.f38253c = onActivityListener;
        m27038a(activity);
    }

    /* renamed from: a */
    private void m27038a(Activity activity) {
        this.f38252b = activity;
        setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    /* renamed from: a */
    private void m27037a() {
        if (!this.f38255e) {
            this.f38255e = true;
            this.f38252b.addContentView(this, new ViewGroup.LayoutParams(-1, -1));
            OnActivityListener onActivityListener = this.f38253c;
            if (onActivityListener != null) {
                onActivityListener.onAttach();
            }
        }
    }

    public void detachFromActivity() {
        if (this.f38255e) {
            this.f38255e = false;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
                OnActivityListener onActivityListener = this.f38253c;
                if (onActivityListener != null) {
                    onActivityListener.onDetach();
                }
            }
        }
    }

    public void clearAllTips() {
        C13274a aVar = this.f38256f;
        if (aVar != null) {
            aVar.mo97888b();
        }
    }

    /* access modifiers changed from: protected */
    public void clear() {
        removeAllViews();
        detachFromActivity();
        OnTipClearListener onTipClearListener = this.f38254d;
        if (onTipClearListener != null) {
            onTipClearListener.onDismiss();
        }
        f38251a = 0;
    }

    public static void subtractShowTime() {
        f38251a--;
    }

    public void show(TipsView tipsView, View view, int i, int i2) {
        show(tipsView, view, i, i2, 0, 0);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4) {
        show(tipsView, view, i, i2, 0, 0, false);
    }

    public void show(TipsView tipsView, View view, int i, int i2, int i3, int i4, boolean z) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m27037a();
            C13277d dVar = new C13277d(this.f38252b, this);
            this.f38256f = dVar;
            dVar.mo97886a(view, tipsView);
            this.f38256f.mo97885a(i, i2, 0, i3, i4, z);
            f38251a++;
        }
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5) {
        showWithLine(tipsView, view, i, i2, i3, i4, i5, 0, "");
    }

    public void showWithLine(TipsView tipsView, View view, int i, int i2, int i3, int i4, int i5, long j, String str) {
        View view2 = view;
        if (tipsView != null && view2 != null) {
            m27037a();
            C13276c cVar = new C13276c(this.f38252b, this);
            this.f38256f = cVar;
            cVar.mo97886a(view, tipsView);
            ((C13276c) this.f38256f).mo97890a(j, str);
            this.f38256f.mo97885a(i, i2, i3, i4, i5, false);
            f38251a++;
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

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
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

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view.getParent() == null) {
            super.addView(view, i, layoutParams);
        }
    }

    @Deprecated
    /* renamed from: b */
    private void m27039b() {
        C13274a aVar = this.f38256f;
        if (aVar != null) {
            aVar.mo97888b();
        }
        removeAllViews();
        f38251a = 0;
    }

    public static boolean isShowing() {
        return f38251a != 0;
    }

    public void setOnClearListener(OnTipClearListener onTipClearListener) {
        this.f38254d = onTipClearListener;
    }
}
