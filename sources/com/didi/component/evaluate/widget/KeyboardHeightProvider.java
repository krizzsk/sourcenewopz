package com.didi.component.evaluate.widget;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.taxis99.R;

public class KeyboardHeightProvider extends PopupWindow {

    /* renamed from: a */
    private static final String f13460a = "sample_KeyboardHeightProvider";

    /* renamed from: b */
    private KeyboardHeightObserver f13461b;

    /* renamed from: c */
    private int f13462c;

    /* renamed from: d */
    private int f13463d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f13464e;

    /* renamed from: f */
    private View f13465f;

    /* renamed from: g */
    private Activity f13466g;

    public interface KeyboardHeightObserver {
        void onKeyboardHeightChanged(int i, int i2);
    }

    public KeyboardHeightProvider(Activity activity) {
        super(activity);
        this.f13466g = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.global_evaluate_popupwindow, (ViewGroup) null, false);
        this.f13464e = inflate;
        setContentView(inflate);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f13465f = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.f13464e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (KeyboardHeightProvider.this.f13464e != null) {
                    KeyboardHeightProvider.this.m9219b();
                }
            }
        });
    }

    public void start() {
        try {
            if (!isShowing() && this.f13465f.getWindowToken() != null) {
                setBackgroundDrawable(new ColorDrawable(0));
                showAtLocation(this.f13465f, 0, 0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        this.f13461b = null;
        dismiss();
    }

    public void setKeyboardHeightObserver(KeyboardHeightObserver keyboardHeightObserver) {
        this.f13461b = keyboardHeightObserver;
    }

    /* renamed from: a */
    private int m9216a() {
        return this.f13466g.getResources().getConfiguration().orientation;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9219b() {
        int i;
        int i2;
        Rect rect = new Rect();
        this.f13464e.getWindowVisibleDisplayFrame(rect);
        int a = m9216a();
        View view = this.f13465f;
        if (view == null || view.getBottom() <= 0) {
            Point point = new Point();
            this.f13466g.getWindowManager().getDefaultDisplay().getSize(point);
            i = point.y;
            i2 = rect.bottom;
        } else {
            i = this.f13465f.getBottom();
            i2 = rect.bottom;
        }
        int i3 = i - i2;
        if (a == 1) {
            if (this.f13463d != i3) {
                this.f13463d = i3;
                m9218a(i3, a);
            }
        } else if (this.f13462c != i3) {
            this.f13462c = i3;
            m9218a(i3, a);
        }
    }

    /* renamed from: a */
    private void m9218a(int i, int i2) {
        KeyboardHeightObserver keyboardHeightObserver = this.f13461b;
        if (keyboardHeightObserver != null) {
            keyboardHeightObserver.onKeyboardHeightChanged(i, i2);
        }
    }
}
