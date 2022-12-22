package com.didi.dimina.container.p106ui.statusbar;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.dimina.container.ui.statusbar.c */
/* compiled from: FitsKeyboard */
class C7683c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private final ImmersionBar f17775a;

    /* renamed from: b */
    private final Window f17776b;

    /* renamed from: c */
    private final View f17777c;

    /* renamed from: d */
    private final View f17778d;

    /* renamed from: e */
    private View f17779e;

    /* renamed from: f */
    private int f17780f = 0;

    /* renamed from: g */
    private int f17781g = 0;

    /* renamed from: h */
    private int f17782h = 0;

    /* renamed from: i */
    private int f17783i = 0;

    /* renamed from: j */
    private int f17784j;

    /* renamed from: k */
    private boolean f17785k;

    /* renamed from: l */
    private View f17786l;

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C7683c(com.didi.dimina.container.p106ui.statusbar.ImmersionBar r4) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f17780f = r0
            r3.f17781g = r0
            r3.f17782h = r0
            r3.f17783i = r0
            r3.f17775a = r4
            android.view.Window r1 = r4.mo56593i()
            r3.f17776b = r1
            android.view.View r1 = r1.getDecorView()
            r3.f17777c = r1
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            boolean r2 = r4.mo56601m()
            if (r2 == 0) goto L_0x0043
            androidx.fragment.app.Fragment r0 = r4.mo56595j()
            if (r0 == 0) goto L_0x0036
            android.view.View r4 = r0.getView()
            r3.f17779e = r4
            goto L_0x0057
        L_0x0036:
            android.app.Fragment r4 = r4.mo56596k()
            if (r4 == 0) goto L_0x0057
            android.view.View r4 = r4.getView()
            r3.f17779e = r4
            goto L_0x0057
        L_0x0043:
            android.view.View r4 = r1.getChildAt(r0)
            r3.f17779e = r4
            if (r4 == 0) goto L_0x0057
            boolean r2 = r4 instanceof androidx.drawerlayout.widget.DrawerLayout
            if (r2 == 0) goto L_0x0057
            androidx.drawerlayout.widget.DrawerLayout r4 = (androidx.drawerlayout.widget.DrawerLayout) r4
            android.view.View r4 = r4.getChildAt(r0)
            r3.f17779e = r4
        L_0x0057:
            android.view.View r4 = r3.f17779e
            if (r4 == 0) goto L_0x0079
            int r4 = r4.getPaddingLeft()
            r3.f17780f = r4
            android.view.View r4 = r3.f17779e
            int r4 = r4.getPaddingTop()
            r3.f17781g = r4
            android.view.View r4 = r3.f17779e
            int r4 = r4.getPaddingRight()
            r3.f17782h = r4
            android.view.View r4 = r3.f17779e
            int r4 = r4.getPaddingBottom()
            r3.f17783i = r4
        L_0x0079:
            android.view.View r4 = r3.f17779e
            if (r4 == 0) goto L_0x007e
            r1 = r4
        L_0x007e:
            r3.f17778d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.statusbar.C7683c.<init>(com.didi.dimina.container.ui.statusbar.ImmersionBar):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56692a(int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f17776b.setSoftInputMode(i);
            if (!this.f17785k) {
                if (!(this.f17775a.mo56591h() == null || this.f17775a.mo56591h().isFinishing() || this.f17778d == null)) {
                    if (this.f17786l == null) {
                        this.f17786l = new LinearLayout(this.f17775a.mo56591h());
                    }
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
                    layoutParams.width = 0;
                    layoutParams.height = -1;
                    layoutParams.softInputMode = 16;
                    try {
                        this.f17775a.mo56591h().getWindowManager().addView(this.f17786l, layoutParams);
                        this.f17786l.getViewTreeObserver().addOnGlobalLayoutListener(this);
                    } catch (Exception e) {
                        SystemUtils.log(6, "FitsKeyboard", e.getMessage(), (Throwable) null, "com.didi.dimina.container.ui.statusbar.FitsKeyboard", 82);
                    }
                }
                this.f17785k = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56691a() {
        if (Build.VERSION.SDK_INT >= 19 && this.f17785k) {
            if (this.f17779e != null) {
                this.f17778d.setPadding(this.f17780f, this.f17781g, this.f17782h, this.f17783i);
            } else {
                this.f17778d.setPadding(this.f17775a.mo56575d(), this.f17775a.mo56576e(), this.f17775a.mo56577f(), this.f17775a.mo56588g());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo56693b() {
        if (Build.VERSION.SDK_INT >= 19 && this.f17785k) {
            View view = this.f17786l;
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            this.f17785k = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (r3 > r1) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        if (r3 > r1) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (r3 > r1) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGlobalLayout() {
        /*
            r7 = this;
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f17775a
            if (r0 == 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r0.getBarParams()
            if (r0 == 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f17775a
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r0.getBarParams()
            boolean r0 = r0.keyboardEnable
            if (r0 == 0) goto L_0x00ce
            android.view.View r0 = r7.f17786l
            if (r0 == 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f17775a
            com.didi.dimina.container.ui.statusbar.a r0 = r0.mo56621o()
            boolean r1 = r0.mo56685a()
            if (r1 == 0) goto L_0x0029
            int r1 = r0.mo56689e()
            goto L_0x002d
        L_0x0029:
            int r1 = r0.mo56690f()
        L_0x002d:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.view.View r3 = r7.f17786l
            r3.getWindowVisibleDisplayFrame(r2)
            android.view.View r3 = r7.f17778d
            int r3 = r3.getHeight()
            int r2 = r2.bottom
            int r3 = r3 - r2
            int r2 = r7.f17784j
            if (r3 == r2) goto L_0x00ce
            r7.f17784j = r3
            android.view.Window r2 = r7.f17776b
            android.view.View r2 = r2.getDecorView()
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r2.findViewById(r4)
            boolean r2 = com.didi.dimina.container.p106ui.statusbar.ImmersionBar.checkFitsSystemWindows(r2)
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x008b
            android.view.View r2 = r7.f17779e
            if (r2 == 0) goto L_0x0087
            com.didi.dimina.container.ui.statusbar.ImmersionBar r2 = r7.f17775a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r2.getBarParams()
            boolean r2 = r2.isSupportActionBar
            if (r2 == 0) goto L_0x0075
            com.didi.dimina.container.ui.statusbar.ImmersionBar r2 = r7.f17775a
            int r2 = r2.mo56623p()
            int r6 = r0.mo56686b()
            int r2 = r2 + r6
            int r3 = r3 + r2
        L_0x0075:
            com.didi.dimina.container.ui.statusbar.ImmersionBar r2 = r7.f17775a
            com.didi.dimina.container.ui.statusbar.BarParams r2 = r2.getBarParams()
            boolean r2 = r2.fits
            if (r2 == 0) goto L_0x0084
            int r2 = r0.mo56686b()
            int r3 = r3 + r2
        L_0x0084:
            if (r3 <= r1) goto L_0x008f
            goto L_0x0090
        L_0x0087:
            int r3 = r3 - r1
            if (r3 <= r1) goto L_0x008f
            goto L_0x0090
        L_0x008b:
            int r3 = r3 - r1
            if (r3 <= r1) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r5 = 0
        L_0x0090:
            if (r3 >= 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r4 = r3
        L_0x0094:
            com.didi.dimina.container.ui.statusbar.ImmersionBar r1 = r7.f17775a
            com.didi.dimina.container.ui.statusbar.BarParams r1 = r1.getBarParams()
            com.didi.dimina.container.ui.statusbar.OnKeyboardListener r1 = r1.f17690b
            if (r1 == 0) goto L_0x00bb
            com.didi.dimina.container.ui.statusbar.ImmersionBar r1 = r7.f17775a
            com.didi.dimina.container.ui.statusbar.BarParams r1 = r1.getBarParams()
            com.didi.dimina.container.ui.statusbar.OnKeyboardListener r1 = r1.f17690b
            android.view.View r2 = r7.f17778d
            int r2 = r2.getHeight()
            com.didi.dimina.container.ui.statusbar.ImmersionBar r3 = r7.f17775a
            int r3 = r3.mo56623p()
            int r2 = r2 - r3
            int r0 = r0.mo56686b()
            int r2 = r2 - r0
            r1.onKeyboardChange(r5, r4, r2)
        L_0x00bb:
            if (r5 != 0) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f17775a
            com.didi.dimina.container.ui.statusbar.BarParams r0 = r0.getBarParams()
            com.didi.dimina.container.ui.statusbar.BarHide r0 = r0.barHide
            com.didi.dimina.container.ui.statusbar.BarHide r1 = com.didi.dimina.container.p106ui.statusbar.BarHide.FLAG_SHOW_BAR
            if (r0 == r1) goto L_0x00ce
            com.didi.dimina.container.ui.statusbar.ImmersionBar r0 = r7.f17775a
            r0.mo56574c()
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.statusbar.C7683c.onGlobalLayout():void");
    }
}
