package com.didi.onehybrid.log;

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
    boolean f29639a = false;

    /* renamed from: b */
    private ViewGroup f29640b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FrameLayout f29641c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout.LayoutParams f29642d;

    /* renamed from: e */
    private LinearLayout f29643e;

    /* renamed from: f */
    private LinearLayout.LayoutParams f29644f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditText f29645g;

    /* renamed from: h */
    private FrameLayout.LayoutParams f29646h;

    /* renamed from: i */
    private TextView f29647i;

    /* renamed from: j */
    private TextView f29648j;

    /* renamed from: k */
    private TextView f29649k;

    /* renamed from: l */
    private LinearLayout f29650l;

    /* renamed from: m */
    private FrameLayout.LayoutParams f29651m;

    /* renamed from: n */
    private int f29652n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f29653o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f29654p;

    /* renamed from: q */
    private int f29655q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f29656r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f29657s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f29658t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f29659u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f29660v;

    /* renamed from: w */
    private Activity f29661w;

    /* renamed from: x */
    private int f29662x = 10;

    public LogFloatingView(Activity activity) {
        this.f29661w = activity;
    }

    public void show() {
        m20822a(this.f29661w);
        this.f29661w.addContentView(this.f29641c, this.f29642d);
        this.f29640b = (ViewGroup) this.f29641c.getParent();
    }

    public void hide() {
        FrameLayout frameLayout;
        ViewGroup viewGroup = this.f29640b;
        if (viewGroup != null && (frameLayout = this.f29641c) != null) {
            viewGroup.removeView(frameLayout);
            this.f29640b = null;
        }
    }

    public void smartShow() {
        if (!this.f29639a) {
            m20822a(this.f29661w);
            this.f29661w.addContentView(this.f29641c, this.f29642d);
            this.f29640b = (ViewGroup) this.f29641c.getParent();
            this.f29639a = true;
        }
    }

    public void smartHide() {
        FrameLayout frameLayout;
        if (this.f29639a) {
            ViewGroup viewGroup = this.f29640b;
            if (!(viewGroup == null || (frameLayout = this.f29641c) == null)) {
                viewGroup.removeView(frameLayout);
                this.f29640b = null;
            }
            this.f29639a = false;
        }
    }

    public void writeLine(String str) {
        write(str + "\n");
    }

    public void write(String str) {
        EditText editText = this.f29645g;
        if (editText != null) {
            editText.append(str);
        }
    }

    /* renamed from: a */
    private void m20822a(Activity activity) {
        this.f29654p = 100;
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        this.f29652n = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels - 50;
        this.f29653o = i;
        this.f29655q = (i / 3) + 100;
        this.f29641c = new FrameLayout(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f29642d = layoutParams;
        layoutParams.height = this.f29655q;
        this.f29642d.width = this.f29652n;
        this.f29641c.setLayoutParams(this.f29642d);
        this.f29643e = new LinearLayout(activity);
        this.f29644f = new LinearLayout.LayoutParams(-1, -2);
        this.f29643e.setOrientation(1);
        this.f29645g = new EditText(activity);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f29646h = layoutParams2;
        this.f29645g.setLayoutParams(layoutParams2);
        this.f29645g.setTextSize(12.0f);
        this.f29645g.setCursorVisible(false);
        this.f29645g.setFocusable(false);
        this.f29645g.setFocusableInTouchMode(false);
        this.f29645g.setGravity(48);
        this.f29645g.setBackgroundColor(Color.argb(120, 0, 0, 0));
        this.f29645g.setTextColor(-1);
        this.f29645g.setMaxLines(this.f29662x);
        this.f29650l = new LinearLayout(activity);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        this.f29651m = layoutParams3;
        layoutParams3.height = this.f29654p;
        this.f29648j = new TextView(activity);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = 12;
        layoutParams4.bottomMargin = 12;
        layoutParams4.topMargin = 2;
        this.f29648j.setText("移动");
        this.f29648j.setTextColor(-1);
        this.f29648j.setTextSize(12.0f);
        this.f29648j.setPadding(10, 10, 10, 10);
        this.f29648j.setLayoutParams(layoutParams4);
        this.f29648j.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f29648j.setOnTouchListener(new LogPanelOnTouchListener());
        this.f29650l.addView(this.f29648j);
        this.f29647i = new TextView(activity);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = 12;
        layoutParams5.bottomMargin = 12;
        layoutParams5.topMargin = 2;
        this.f29647i.setText("清空");
        this.f29647i.setTextColor(-1);
        this.f29647i.setTextSize(12.0f);
        this.f29647i.setPadding(10, 10, 10, 10);
        this.f29647i.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f29647i.setLayoutParams(layoutParams5);
        this.f29647i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (LogFloatingView.this.f29645g != null) {
                    LogFloatingView.this.f29645g.setText("");
                }
            }
        });
        this.f29650l.addView(this.f29647i);
        this.f29649k = new TextView(activity);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = 12;
        layoutParams6.bottomMargin = 12;
        layoutParams6.topMargin = 2;
        this.f29649k.setText("关闭");
        this.f29649k.setTextColor(-1);
        this.f29649k.setTextSize(12.0f);
        this.f29649k.setPadding(10, 10, 10, 10);
        this.f29649k.setBackgroundColor(Color.argb(200, 120, 120, 120));
        this.f29649k.setLayoutParams(layoutParams6);
        this.f29649k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LogFloatingView.this.smartHide();
            }
        });
        this.f29650l.addView(this.f29649k);
        this.f29643e.addView(this.f29645g);
        this.f29643e.addView(this.f29650l);
        this.f29641c.addView(this.f29643e, this.f29644f);
    }

    private class LogPanelOnTouchListener implements View.OnTouchListener {
        private LogPanelOnTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int unused = LogFloatingView.this.f29656r = (int) motionEvent.getRawY();
                return true;
            } else if (action != 2) {
                return true;
            } else {
                int rawY = ((int) motionEvent.getRawY()) - LogFloatingView.this.f29656r;
                int bottom = LogFloatingView.this.f29641c.getBottom() + rawY;
                int right = LogFloatingView.this.f29641c.getRight();
                int top = LogFloatingView.this.f29641c.getTop() + rawY;
                if (top < 0) {
                    bottom = LogFloatingView.this.f29641c.getHeight() + 0;
                    top = 0;
                }
                if (bottom > LogFloatingView.this.f29653o - LogFloatingView.this.f29654p) {
                    bottom = LogFloatingView.this.f29653o - LogFloatingView.this.f29654p;
                    top = bottom - LogFloatingView.this.f29641c.getHeight();
                }
                int unused2 = LogFloatingView.this.f29657s = 0;
                int unused3 = LogFloatingView.this.f29658t = top;
                int unused4 = LogFloatingView.this.f29659u = right;
                int unused5 = LogFloatingView.this.f29660v = bottom;
                LogFloatingView.this.f29641c.layout(0, top, right, bottom);
                int unused6 = LogFloatingView.this.f29656r = (int) motionEvent.getRawY();
                LogFloatingView.this.f29642d.setMargins(LogFloatingView.this.f29657s, LogFloatingView.this.f29658t, LogFloatingView.this.f29659u, LogFloatingView.this.f29660v);
                LogFloatingView.this.f29641c.setLayoutParams(LogFloatingView.this.f29642d);
                LogFloatingView.this.f29641c.postInvalidate();
                return true;
            }
        }
    }
}
