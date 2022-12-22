package com.didi.dimina.webview.log;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;

public class LogFloatingView {

    /* renamed from: a */
    boolean f18294a = false;

    /* renamed from: b */
    private ViewGroup f18295b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f18296c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout.LayoutParams f18297d;

    /* renamed from: e */
    private LinearLayout f18298e;

    /* renamed from: f */
    private LinearLayout.LayoutParams f18299f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditText f18300g;

    /* renamed from: h */
    private FrameLayout.LayoutParams f18301h;

    /* renamed from: i */
    private TextView f18302i;

    /* renamed from: j */
    private TextView f18303j;

    /* renamed from: k */
    private TextView f18304k;

    /* renamed from: l */
    private LinearLayout f18305l;

    /* renamed from: m */
    private FrameLayout.LayoutParams f18306m;

    /* renamed from: n */
    private int f18307n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f18308o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f18309p;

    /* renamed from: q */
    private int f18310q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f18311r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f18312s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f18313t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f18314u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f18315v;

    /* renamed from: w */
    private final Activity f18316w;

    /* renamed from: x */
    private final int f18317x = 10;

    public LogFloatingView(Activity activity) {
        this.f18316w = activity;
    }

    public void show() {
        m13604a(this.f18316w);
        this.f18316w.addContentView(this.f18296c, this.f18297d);
        this.f18295b = (ViewGroup) this.f18296c.getParent();
    }

    public void hide() {
        FrameLayout frameLayout;
        ViewGroup viewGroup = this.f18295b;
        if (viewGroup != null && (frameLayout = this.f18296c) != null) {
            viewGroup.removeView(frameLayout);
            this.f18295b = null;
        }
    }

    public void smartShow() {
        if (!this.f18294a) {
            m13604a(this.f18316w);
            this.f18316w.addContentView(this.f18296c, this.f18297d);
            this.f18295b = (ViewGroup) this.f18296c.getParent();
            this.f18294a = true;
        }
    }

    public void smartHide() {
        FrameLayout frameLayout;
        if (this.f18294a) {
            ViewGroup viewGroup = this.f18295b;
            if (!(viewGroup == null || (frameLayout = this.f18296c) == null)) {
                viewGroup.removeView(frameLayout);
                this.f18295b = null;
            }
            this.f18294a = false;
        }
    }

    public void writeLine(String str) {
        write(str + "\n");
    }

    public void write(String str) {
        EditText editText = this.f18300g;
        if (editText != null) {
            editText.append(str);
        }
    }

    /* renamed from: a */
    private void m13604a(Activity activity) {
        this.f18309p = 100;
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        this.f18307n = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels - 50;
        this.f18308o = i;
        this.f18310q = (i / 3) + 100;
        this.f18296c = new FrameLayout(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f18297d = layoutParams;
        layoutParams.height = this.f18310q;
        this.f18297d.width = this.f18307n;
        this.f18296c.setLayoutParams(this.f18297d);
        this.f18298e = new LinearLayout(activity);
        this.f18299f = new LinearLayout.LayoutParams(-1, -2);
        this.f18298e.setOrientation(1);
        this.f18300g = new EditText(activity);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f18301h = layoutParams2;
        this.f18300g.setLayoutParams(layoutParams2);
        this.f18300g.setTextSize(12.0f);
        this.f18300g.setCursorVisible(false);
        this.f18300g.setFocusable(false);
        this.f18300g.setFocusableInTouchMode(false);
        this.f18300g.setGravity(48);
        this.f18300g.setBackgroundColor(Color.argb(120, 0, 0, 0));
        this.f18300g.setTextColor(-1);
        this.f18300g.setMaxLines(10);
        this.f18305l = new LinearLayout(activity);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        this.f18306m = layoutParams3;
        layoutParams3.height = this.f18309p;
        this.f18303j = new TextView(activity);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = 12;
        layoutParams4.bottomMargin = 12;
        layoutParams4.topMargin = 2;
        this.f18303j.setText("移动");
        this.f18303j.setTextColor(-1);
        this.f18303j.setTextSize(12.0f);
        this.f18303j.setPadding(10, 10, 10, 10);
        this.f18303j.setLayoutParams(layoutParams4);
        this.f18303j.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f18303j.setOnTouchListener(new LogPanelOnTouchListener());
        this.f18305l.addView(this.f18303j);
        this.f18302i = new TextView(activity);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = 12;
        layoutParams5.bottomMargin = 12;
        layoutParams5.topMargin = 2;
        this.f18302i.setText("清空");
        this.f18302i.setTextColor(-1);
        this.f18302i.setTextSize(12.0f);
        this.f18302i.setPadding(10, 10, 10, 10);
        this.f18302i.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f18302i.setLayoutParams(layoutParams5);
        this.f18302i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (LogFloatingView.this.f18300g != null) {
                    LogFloatingView.this.f18300g.setText("");
                }
            }
        });
        this.f18305l.addView(this.f18302i);
        this.f18304k = new TextView(activity);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = 12;
        layoutParams6.bottomMargin = 12;
        layoutParams6.topMargin = 2;
        this.f18304k.setText("关闭");
        this.f18304k.setTextColor(-1);
        this.f18304k.setTextSize(12.0f);
        this.f18304k.setPadding(10, 10, 10, 10);
        this.f18304k.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f18304k.setLayoutParams(layoutParams6);
        this.f18304k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LogFloatingView.this.smartHide();
            }
        });
        this.f18305l.addView(this.f18304k);
        this.f18298e.addView(this.f18300g);
        this.f18298e.addView(this.f18305l);
        this.f18296c.addView(this.f18298e, this.f18299f);
    }

    private class LogPanelOnTouchListener implements View.OnTouchListener {
        private LogPanelOnTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int unused = LogFloatingView.this.f18311r = (int) motionEvent.getRawY();
                return true;
            } else if (action != 2) {
                return true;
            } else {
                int rawY = ((int) motionEvent.getRawY()) - LogFloatingView.this.f18311r;
                int bottom = LogFloatingView.this.f18296c.getBottom() + rawY;
                int right = LogFloatingView.this.f18296c.getRight();
                int top = LogFloatingView.this.f18296c.getTop() + rawY;
                if (top < 0) {
                    bottom = LogFloatingView.this.f18296c.getHeight() + 0;
                    top = 0;
                }
                if (bottom > LogFloatingView.this.f18308o - LogFloatingView.this.f18309p) {
                    bottom = LogFloatingView.this.f18308o - LogFloatingView.this.f18309p;
                    top = bottom - LogFloatingView.this.f18296c.getHeight();
                }
                int unused2 = LogFloatingView.this.f18312s = 0;
                int unused3 = LogFloatingView.this.f18313t = top;
                int unused4 = LogFloatingView.this.f18314u = right;
                int unused5 = LogFloatingView.this.f18315v = bottom;
                LogFloatingView.this.f18296c.layout(0, top, right, bottom);
                int unused6 = LogFloatingView.this.f18311r = (int) motionEvent.getRawY();
                LogFloatingView.this.f18297d.setMargins(LogFloatingView.this.f18312s, LogFloatingView.this.f18313t, LogFloatingView.this.f18314u, LogFloatingView.this.f18315v);
                LogFloatingView.this.f18296c.setLayoutParams(LogFloatingView.this.f18297d);
                LogFloatingView.this.f18296c.postInvalidate();
                return true;
            }
        }
    }
}
