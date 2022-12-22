package com.didi.dimina.container.p106ui.custom.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.ViewUtil;

/* renamed from: com.didi.dimina.container.ui.custom.input.InputUtil */
class InputUtil {

    /* renamed from: a */
    public int f17515a = 0;

    /* renamed from: b */
    public boolean f17516b = false;

    /* renamed from: c */
    public boolean f17517c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f17518d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ISoftInputChanged f17519e;

    /* renamed from: f */
    private final View.OnLayoutChangeListener f17520f = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int navigationBarHeight = ViewUtil.getNavigationBarHeight(InputUtil.this.f17518d.getContext());
            int height = InputUtil.this.f17518d.getHeight();
            Rect rect = new Rect();
            InputUtil.this.f17518d.getWindowVisibleDisplayFrame(rect);
            LogUtil.m13408d("attachSoftInput", rect.bottom + "--" + height + "--" + navigationBarHeight);
            int i9 = height - navigationBarHeight;
            boolean z = true;
            int i10 = 0;
            if (i9 > rect.bottom) {
                int i11 = i9 - rect.bottom;
                if (InputUtil.this.f17515a != i11) {
                    InputUtil.this.f17516b = true;
                    InputUtil.this.f17515a = i11;
                } else {
                    InputUtil.this.f17516b = false;
                }
                i10 = i11;
            } else {
                z = false;
            }
            LogUtil.m13408d("attachSoftInput", i10 + "--" + InputUtil.this.f17518d.getHeight() + "---" + rect.bottom);
            if (InputUtil.this.f17517c != z || (z && InputUtil.this.f17516b)) {
                if (InputUtil.this.f17519e != null) {
                    InputUtil.this.f17519e.onChanged(z, i10, rect.bottom);
                }
                InputUtil.this.f17517c = z;
            }
        }
    };

    /* renamed from: com.didi.dimina.container.ui.custom.input.InputUtil$ISoftInputChanged */
    public interface ISoftInputChanged {
        void onChanged(boolean z, int i, int i2);
    }

    InputUtil() {
    }

    /* renamed from: a */
    public void mo56233a(View view) {
        view.getRootView().removeOnLayoutChangeListener(this.f17520f);
    }

    /* renamed from: a */
    public void mo56234a(View view, ISoftInputChanged iSoftInputChanged) {
        this.f17519e = iSoftInputChanged;
        this.f17518d = view.getRootView();
        StringBuilder sb = new StringBuilder();
        sb.append("rootView:");
        sb.append(this.f17518d != null);
        LogUtil.m13408d("attachSoftInput", sb.toString());
        View view2 = this.f17518d;
        if (view2 != null) {
            view2.addOnLayoutChangeListener(this.f17520f);
        }
    }

    /* renamed from: b */
    public static void m13024b(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) != null) {
            if (!inputMethodManager.isActive(view)) {
                inputMethodManager.showSoftInput(view, 0);
            }
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    /* renamed from: c */
    public static void m13025c(View view) {
        if (view != null) {
            view.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        }
    }

    /* renamed from: a */
    public static int m13020a(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* renamed from: b */
    public static int m13022b(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }
}
