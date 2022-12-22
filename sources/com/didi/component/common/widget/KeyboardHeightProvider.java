package com.didi.component.common.widget;

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
    private static final String f12021a = "sample_KeyboardHeightProvider";

    /* renamed from: b */
    private KeyboardHeightObserver f12022b;

    /* renamed from: c */
    private int f12023c;

    /* renamed from: d */
    private int f12024d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f12025e;

    /* renamed from: f */
    private View f12026f;

    /* renamed from: g */
    private Activity f12027g;

    public interface KeyboardHeightObserver {
        void onKeyboardHeightChanged(int i, int i2);
    }

    public KeyboardHeightProvider(Activity activity) {
        super(activity);
        this.f12027g = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.global_keyboard_height_window, (ViewGroup) null, false);
        this.f12025e = inflate;
        setContentView(inflate);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f12026f = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.f12025e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (KeyboardHeightProvider.this.f12025e != null) {
                    KeyboardHeightProvider.this.m8107b();
                }
            }
        });
    }

    public void start() {
        try {
            if (!isShowing() && this.f12026f.getWindowToken() != null) {
                setBackgroundDrawable(new ColorDrawable(0));
                showAtLocation(this.f12026f, 0, 0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        this.f12022b = null;
        dismiss();
    }

    public void setKeyboardHeightObserver(KeyboardHeightObserver keyboardHeightObserver) {
        this.f12022b = keyboardHeightObserver;
    }

    /* renamed from: a */
    private int m8104a() {
        return this.f12027g.getResources().getConfiguration().orientation;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m8107b() {
        int i;
        int i2;
        Rect rect = new Rect();
        this.f12025e.getWindowVisibleDisplayFrame(rect);
        int a = m8104a();
        View view = this.f12026f;
        if (view == null || view.getBottom() <= 0) {
            Point point = new Point();
            this.f12027g.getWindowManager().getDefaultDisplay().getSize(point);
            i = point.y;
            i2 = rect.bottom;
        } else {
            i = this.f12026f.getBottom();
            i2 = rect.bottom;
        }
        int i3 = i - i2;
        if (a == 1) {
            if (this.f12024d != i3) {
                this.f12024d = i3;
                m8106a(i3, a);
            }
        } else if (this.f12023c != i3) {
            this.f12023c = i3;
            m8106a(i3, a);
        }
    }

    /* renamed from: a */
    private void m8106a(int i, int i2) {
        KeyboardHeightObserver keyboardHeightObserver = this.f12022b;
        if (keyboardHeightObserver != null) {
            keyboardHeightObserver.onKeyboardHeightChanged(i, i2);
        }
    }
}
