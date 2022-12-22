package com.didi.addressold.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.addressold.view.tips.c */
/* compiled from: TipsWithLine */
class C3538c implements C3536a {

    /* renamed from: B */
    private static final String f8017B = "\\{[^}]*\\}";

    /* renamed from: A */
    private View.OnLayoutChangeListener f8018A = new TipsWithLine$2(this);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TipsView f8019a;

    /* renamed from: b */
    private TipsLineView f8020b;

    /* renamed from: c */
    private ImageView f8021c;

    /* renamed from: d */
    private View f8022d;

    /* renamed from: e */
    private Context f8023e;

    /* renamed from: f */
    private int f8024f;

    /* renamed from: g */
    private int f8025g;

    /* renamed from: h */
    private int f8026h;

    /* renamed from: i */
    private int f8027i;

    /* renamed from: j */
    private int f8028j;

    /* renamed from: k */
    private TipsContainer f8029k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f8030l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f8031m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f8032n = false;

    /* renamed from: o */
    private float f8033o;

    /* renamed from: p */
    private int f8034p;

    /* renamed from: q */
    private int f8035q;

    /* renamed from: r */
    private int f8036r;

    /* renamed from: s */
    private int f8037s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C3537b f8038t;

    /* renamed from: u */
    private long f8039u;

    /* renamed from: v */
    private String f8040v;

    /* renamed from: w */
    private CountDownTimer f8041w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public Point f8042x;

    /* renamed from: y */
    private boolean f8043y = false;

    /* renamed from: z */
    private ViewTreeObserver.OnGlobalLayoutListener f8044z = new TipsWithLine$1(this);

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m5202c() {
        if (this.f8022d != null && !this.f8043y) {
            this.f8043y = true;
            this.f8022d.getViewTreeObserver().addOnGlobalLayoutListener(this.f8044z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m5207d() {
        this.f8043y = false;
        if (this.f8022d != null) {
            this.f8022d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f8044z);
        }
    }

    public C3538c(Context context, TipsContainer tipsContainer) {
        this.f8023e = context;
        this.f8029k = tipsContainer;
        this.f8033o = context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public void mo39979a(View view, TipsView tipsView) {
        this.f8022d = view;
        this.f8019a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f8023e).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.f8038t = new C3537b(this.f8022d, rect.top);
    }

    /* renamed from: a */
    public void mo39983a(long j, String str) {
        this.f8039u = j;
        this.f8040v = str;
    }

    /* renamed from: a */
    public void mo39978a(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i3;
        this.f8030l = false;
        this.f8025g = i;
        this.f8024f = i2;
        this.f8026h = i4;
        this.f8027i = i5;
        this.f8028j = i6;
        this.f8032n = true;
        View view = this.f8022d;
        if (view != null) {
            view.addOnLayoutChangeListener(this.f8018A);
            this.f8018A.onLayoutChange(this.f8022d, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        Point a = this.f8038t.mo39982a(i4, i5, 0, 0, (int) ((this.f8033o * 25.0f) + 0.5f), i, i2);
        float f = this.f8033o;
        this.f8034p = (int) ((5.0f * f) + 0.5f);
        int i7 = (int) ((((float) i6) * f) + 0.5f);
        this.f8035q = i7;
        int i8 = (int) ((f * 6.0f) + 0.5f);
        this.f8036r = i8;
        this.f8037s = i7 - i8;
        this.f8020b = new TipsLineView(this.f8023e);
        m5192a(a.x - (this.f8034p / 2), a.y - this.f8037s, this.f8034p, this.f8035q - this.f8036r);
        int i9 = (int) ((this.f8033o * 12.0f) + 0.5f);
        m5203c(a.x - (i9 / 2), a.y, i9, i9);
    }

    /* renamed from: a */
    public boolean mo39980a() {
        return this.f8030l;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m5208e() {
        Point a = this.f8038t.mo39982a(this.f8026h, this.f8027i, 0, 0, (int) ((this.f8033o * 25.0f) + 0.5f), this.f8025g, this.f8024f);
        Point point = this.f8042x;
        if (point != null && point.y == a.y && this.f8042x.x == a.x) {
            m5207d();
        }
        this.f8042x = a;
        m5193a(new Point(a.x - (this.f8034p / 2), a.y - this.f8037s));
        m5198b(new Point(a.x - (((int) ((this.f8033o * 12.0f) + 0.5f)) / 2), a.y));
        TipsView tipsView = this.f8019a;
        tipsView.measure(0, 0);
        Point a2 = this.f8038t.mo39982a(this.f8026h, this.f8036r + (this.f8027i - this.f8037s), tipsView.getMeasuredWidth(), tipsView.getMeasuredHeight(), 0, this.f8025g, this.f8024f);
        if (a2.x < 0) {
            a2.x = 0;
        }
        if (a2.y < 0) {
            a2.y = 0;
        }
        a2.x += this.f8019a.getLeftMargin();
        a2.y += this.f8019a.getTopMargin();
        m5204c(a2);
    }

    /* renamed from: a */
    private void m5193a(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8020b.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        this.f8020b.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m5198b(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8021c.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        this.f8021c.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    private void m5204c(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8019a.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        this.f8019a.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m5192a(int i, int i2, int i3, int i4) {
        TipsLineView tipsLineView = this.f8020b;
        tipsLineView.setEnterAnimatorListener(new TipsWithLine$3(this, tipsLineView));
        tipsLineView.setExitAnimatorLiener(new TipsWithLine$4(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.f8029k.addView((View) tipsLineView, layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m5210f() {
        TipsView tipsView = this.f8019a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f8038t.mo39982a(this.f8026h, (this.f8027i - this.f8037s) + this.f8036r, measuredWidth, measuredHeight, 0, this.f8025g, this.f8024f);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m5197b(a.x, a.y, measuredWidth, measuredHeight);
        tipsView.setPosGone();
        tipsView.attachContainer(this.f8029k);
        tipsView.showEnterAnim();
        m5214h();
    }

    /* renamed from: g */
    private boolean m5213g() {
        return this.f8039u > 0 && !TextUtil.isEmpty(this.f8040v);
    }

    /* renamed from: h */
    private void m5214h() {
        CountDownTimer countDownTimer = this.f8041w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (m5213g()) {
            TipsWithLine$5 tipsWithLine$5 = new TipsWithLine$5(this, 1000 * (this.f8039u + 1), 1000);
            this.f8041w = tipsWithLine$5;
            tipsWithLine$5.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5200b(String str) {
        try {
            if (this.f8019a != null && !TextUtil.isEmpty(this.f8040v)) {
                this.f8019a.updateContent(m5191a(this.f8040v.replace(InvitationTrackFragment.INVITE_DATE, str)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m5197b(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f8019a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i + tipsView.getLeftMargin(), i2 + tipsView.getTopMargin(), tipsView.getRightMargin(), tipsView.getBottomMargin());
        this.f8029k.addView((View) tipsView, layoutParams);
    }

    /* renamed from: c */
    private void m5203c(int i, int i2, int i3, int i4) {
        ImageView imageView = new ImageView(this.f8023e);
        this.f8021c = imageView;
        imageView.setImageResource(R.drawable.tips_guide_ring);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.f8029k.addView((View) imageView, layoutParams);
    }

    /* renamed from: b */
    public void mo39981b() {
        if (!this.f8030l) {
            View view = this.f8022d;
            if (view != null) {
                view.removeOnLayoutChangeListener(this.f8018A);
            }
            m5207d();
            this.f8030l = true;
            TipsContainer tipsContainer = this.f8029k;
            if (tipsContainer != null) {
                tipsContainer.clear();
            }
            CountDownTimer countDownTimer = this.f8041w;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f8041w = null;
        }
    }

    /* renamed from: a */
    public static CharSequence m5191a(String str) {
        Matcher matcher = Pattern.compile("\\{[^}]*\\}").matcher(str);
        Stack stack = new Stack();
        while (matcher.find()) {
            stack.push(new Point(matcher.start(), matcher.end()));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int parseColor = Color.parseColor("#FC9153");
        while (stack.size() > 0) {
            Point point = (Point) stack.pop();
            spannableStringBuilder.delete(point.x, point.x + 1);
            spannableStringBuilder.delete(point.y - 2, point.y - 1);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), point.x, point.y - 2, 18);
        }
        return spannableStringBuilder;
    }
}
