package com.didi.sdk.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.didi.sdk.view.tips.c */
/* compiled from: TipsWithLine */
class C13276c implements C13274a {

    /* renamed from: B */
    private static final String f38274B = "\\{[^}]*\\}";

    /* renamed from: A */
    private View.OnLayoutChangeListener f38275A = new TipsWithLine$2(this);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TipsView f38276a;

    /* renamed from: b */
    private TipsLineView f38277b;

    /* renamed from: c */
    private ImageView f38278c;

    /* renamed from: d */
    private View f38279d;

    /* renamed from: e */
    private Context f38280e;

    /* renamed from: f */
    private int f38281f;

    /* renamed from: g */
    private int f38282g;

    /* renamed from: h */
    private int f38283h;

    /* renamed from: i */
    private int f38284i;

    /* renamed from: j */
    private int f38285j;

    /* renamed from: k */
    private TipsContainer f38286k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f38287l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f38288m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f38289n = false;

    /* renamed from: o */
    private float f38290o;

    /* renamed from: p */
    private int f38291p;

    /* renamed from: q */
    private int f38292q;

    /* renamed from: r */
    private int f38293r;

    /* renamed from: s */
    private int f38294s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C13275b f38295t;

    /* renamed from: u */
    private long f38296u;

    /* renamed from: v */
    private String f38297v;

    /* renamed from: w */
    private CountDownTimer f38298w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public Point f38299x;

    /* renamed from: y */
    private boolean f38300y = false;

    /* renamed from: z */
    private ViewTreeObserver.OnGlobalLayoutListener f38301z = new TipsWithLine$1(this);

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m27066c() {
        if (this.f38279d != null && !this.f38300y) {
            this.f38300y = true;
            this.f38279d.getViewTreeObserver().addOnGlobalLayoutListener(this.f38301z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m27071d() {
        this.f38300y = false;
        if (this.f38279d != null) {
            this.f38279d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f38301z);
        }
    }

    public C13276c(Context context, TipsContainer tipsContainer) {
        this.f38280e = context;
        this.f38286k = tipsContainer;
        this.f38290o = context.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public void mo97886a(View view, TipsView tipsView) {
        this.f38279d = view;
        this.f38276a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f38280e).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.f38295t = new C13275b(this.f38279d, rect.top);
    }

    /* renamed from: a */
    public void mo97890a(long j, String str) {
        this.f38296u = j;
        this.f38297v = str;
    }

    /* renamed from: a */
    public void mo97885a(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6 = i3;
        this.f38287l = false;
        this.f38282g = i;
        this.f38281f = i2;
        this.f38283h = i4;
        this.f38284i = i5;
        this.f38285j = i6;
        this.f38289n = true;
        View view = this.f38279d;
        if (view != null) {
            view.addOnLayoutChangeListener(this.f38275A);
            this.f38275A.onLayoutChange(this.f38279d, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        Point a = this.f38295t.mo97889a(i4, i5, 0, 0, (int) ((this.f38290o * 25.0f) + 0.5f), i, i2);
        float f = this.f38290o;
        this.f38291p = (int) ((5.0f * f) + 0.5f);
        int i7 = (int) ((((float) i6) * f) + 0.5f);
        this.f38292q = i7;
        int i8 = (int) ((f * 6.0f) + 0.5f);
        this.f38293r = i8;
        this.f38294s = i7 - i8;
        this.f38277b = new TipsLineView(this.f38280e);
        m27056a(a.x - (this.f38291p / 2), a.y - this.f38294s, this.f38291p, this.f38292q - this.f38293r);
        int i9 = (int) ((this.f38290o * 12.0f) + 0.5f);
        m27067c(a.x - (i9 / 2), a.y, i9, i9);
    }

    /* renamed from: a */
    public boolean mo97887a() {
        return this.f38287l;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m27072e() {
        Point a = this.f38295t.mo97889a(this.f38283h, this.f38284i, 0, 0, (int) ((this.f38290o * 25.0f) + 0.5f), this.f38282g, this.f38281f);
        Point point = this.f38299x;
        if (point != null && point.y == a.y && this.f38299x.x == a.x) {
            m27071d();
        }
        this.f38299x = a;
        m27057a(new Point(a.x - (this.f38291p / 2), a.y - this.f38294s));
        m27062b(new Point(a.x - (((int) ((this.f38290o * 12.0f) + 0.5f)) / 2), a.y));
        TipsView tipsView = this.f38276a;
        tipsView.measure(0, 0);
        Point a2 = this.f38295t.mo97889a(this.f38283h, this.f38293r + (this.f38284i - this.f38294s), tipsView.getMeasuredWidth(), tipsView.getMeasuredHeight(), 0, this.f38282g, this.f38281f);
        if (a2.x < 0) {
            a2.x = 0;
        }
        if (a2.y < 0) {
            a2.y = 0;
        }
        a2.x += this.f38276a.getLeftMargin();
        a2.y += this.f38276a.getTopMargin();
        m27068c(a2);
    }

    /* renamed from: a */
    private void m27057a(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f38277b.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
        this.f38277b.setLayoutParams(layoutParams);
    }

    /* renamed from: b */
    private void m27062b(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f38278c.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
        this.f38278c.setLayoutParams(layoutParams);
    }

    /* renamed from: c */
    private void m27068c(Point point) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f38276a.getLayoutParams();
        layoutParams.topMargin = point.y;
        layoutParams.leftMargin = point.x;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
        this.f38276a.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m27056a(int i, int i2, int i3, int i4) {
        TipsLineView tipsLineView = this.f38277b;
        tipsLineView.setEnterAnimatorListener(new TipsWithLine$3(this, tipsLineView));
        tipsLineView.setExitAnimatorLiener(new TipsWithLine$4(this));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f38286k.addView((View) tipsLineView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m27074f() {
        TipsView tipsView = this.f38276a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f38295t.mo97889a(this.f38283h, (this.f38284i - this.f38294s) + this.f38293r, measuredWidth, measuredHeight, 0, this.f38282g, this.f38281f);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m27061b(a.x, a.y, measuredWidth, measuredHeight);
        tipsView.setPosGone();
        tipsView.attachContainer(this.f38286k);
        tipsView.showEnterAnim();
        m27078h();
    }

    /* renamed from: g */
    private boolean m27077g() {
        return this.f38296u > 0 && !TextUtil.isEmpty(this.f38297v);
    }

    /* renamed from: h */
    private void m27078h() {
        CountDownTimer countDownTimer = this.f38298w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (m27077g()) {
            TipsWithLine$5 tipsWithLine$5 = new TipsWithLine$5(this, 1000 * (this.f38296u + 1), 1000);
            this.f38298w = tipsWithLine$5;
            tipsWithLine$5.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27064b(String str) {
        try {
            if (this.f38276a != null && !TextUtil.isEmpty(this.f38297v)) {
                this.f38276a.updateContent(m27055a(this.f38297v.replace(InvitationTrackFragment.INVITE_DATE, str)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m27061b(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f38276a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i + tipsView.getLeftMargin(), i2 + tipsView.getTopMargin(), tipsView.getRightMargin(), tipsView.getBottomMargin());
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f38286k.addView((View) tipsView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* renamed from: c */
    private void m27067c(int i, int i2, int i3, int i4) {
        ImageView imageView = new ImageView(this.f38280e);
        this.f38278c = imageView;
        imageView.setImageResource(R.drawable.tips_guide_ring);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f38286k.addView((View) imageView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* renamed from: b */
    public void mo97888b() {
        if (!this.f38287l) {
            View view = this.f38279d;
            if (view != null) {
                view.removeOnLayoutChangeListener(this.f38275A);
            }
            m27071d();
            this.f38287l = true;
            TipsContainer tipsContainer = this.f38286k;
            if (tipsContainer != null) {
                tipsContainer.clear();
            }
            CountDownTimer countDownTimer = this.f38298w;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f38298w = null;
        }
    }

    /* renamed from: a */
    public static CharSequence m27055a(String str) {
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
