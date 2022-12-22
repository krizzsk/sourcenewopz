package com.didi.nova.assembly.p127ui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sofa.utils.UiUtils;
import com.taxis99.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.nova.assembly.ui.banner.Banner */
public class Banner extends RelativeLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: c */
    private static final String f29224c = "Banner";

    /* renamed from: d */
    private static final int f29225d = 800;

    /* renamed from: e */
    private static final long f29226e = 4000;

    /* renamed from: a */
    OnBannerClickListener f29227a;

    /* renamed from: b */
    ViewPager.OnPageChangeListener f29228b;

    /* renamed from: f */
    private Context f29229f;

    /* renamed from: g */
    private C10277a f29230g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ViewPager f29231h;

    /* renamed from: i */
    private LinearLayout f29232i;

    /* renamed from: j */
    private List<ImageView> f29233j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Handler f29234k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f29235l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f29236m;

    /* renamed from: n */
    private List<String> f29237n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f29238o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f29239p;

    /* renamed from: q */
    private boolean f29240q;

    /* renamed from: r */
    private int f29241r;

    /* renamed from: s */
    private int f29242s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f29243t;

    /* renamed from: u */
    private int f29244u;

    /* renamed from: v */
    private FitType f29245v;

    /* renamed from: w */
    private int f29246w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final Runnable f29247x;

    public Banner(Context context) {
        this(context, (AttributeSet) null);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29233j = new ArrayList();
        this.f29234k = new Handler(Looper.getMainLooper());
        this.f29237n = new ArrayList();
        this.f29238o = true;
        this.f29239p = 4000;
        this.f29240q = true;
        this.f29241r = 0;
        this.f29242s = 0;
        this.f29243t = true;
        this.f29244u = 0;
        this.f29245v = FitType.FIT_None;
        this.f29247x = new Runnable() {
            public void run() {
                int i;
                if (Banner.this.f29236m > 1 && Banner.this.f29231h != null) {
                    if (Banner.this.f29243t) {
                        i = (Banner.this.f29235l + 1) % (Banner.this.f29236m + 2);
                    } else {
                        i = (Banner.this.f29235l + 1) % Banner.this.f29236m;
                    }
                    SystemUtils.log(3, Banner.f29224c, "autoplay, setCurrentItem = " + i, (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner$1", 138);
                    Banner.this.f29231h.setCurrentItem(i, true);
                }
                if (Banner.this.f29238o) {
                    Banner.this.f29234k.postDelayed(Banner.this.f29247x, Banner.this.f29239p);
                }
            }
        };
        this.f29229f = context;
        m20620a(context, attributeSet);
        m20619a(context);
    }

    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f29228b;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        m20618a(this.f29235l, i);
        this.f29235l = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f29228b;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(m20615a(i));
        }
        SystemUtils.log(3, f29224c, "current index = " + i, (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 176);
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            setCheatCurrentItem(this.f29235l);
        } else if (i == 1) {
            setCheatCurrentItem(this.f29235l);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f29228b;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f29238o) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                start();
            } else if (action == 0) {
                stop();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        SystemUtils.log(3, f29224c, "onDetachedFromWindow", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 215);
        stop();
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    private void m20619a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_banner, this, true);
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.banner_viewpager);
        this.f29231h = viewPager;
        viewPager.setOnPageChangeListener(this);
        this.f29231h.setPageMargin(this.f29244u);
        this.f29231h.setOffscreenPageLimit(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(this.f29241r, 0, this.f29242s, 0);
        this.f29231h.setLayoutParams(layoutParams);
        m20617a();
        this.f29232i = (LinearLayout) inflate.findViewById(R.id.banner_indicator_ll);
    }

    /* renamed from: a */
    private void m20620a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.Banner);
        this.f29240q = obtainStyledAttributes.getBoolean(3, true);
        this.f29241r = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f29242s = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.f29243t = obtainStyledAttributes.getBoolean(4, true);
        this.f29244u = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f29238o = obtainStyledAttributes.getBoolean(0, false);
        this.f29245v = FitType.values()[obtainStyledAttributes.getInt(2, 0)];
        this.f29246w = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m20617a() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.f29231h, new C10278b(this.f29229f, 800));
        } catch (Exception e) {
            SystemUtils.log(6, f29224c, e.getMessage(), (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 260);
        }
    }

    public void setDatas(List<String> list) {
        if (list != null && !list.isEmpty() && !list.isEmpty()) {
            if (this.f29237n.isEmpty() || m20621a(this.f29237n, list)) {
                this.f29237n.clear();
                this.f29237n.addAll(list);
                this.f29236m = list.size();
                C10277a aVar = new C10277a(this, list, this.f29243t);
                this.f29230g = aVar;
                aVar.f29248a = this.f29246w;
                this.f29230g.f29249b = this.f29245v;
                this.f29231h.setAdapter(this.f29230g);
                m20623b();
                if (this.f29236m <= 1 || !this.f29243t) {
                    this.f29235l = 0;
                } else {
                    this.f29231h.setCurrentItem(1, false);
                    this.f29235l = 1;
                }
                start();
                return;
            }
            SystemUtils.log(3, f29224c, "The data list is not changed.", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 279);
            this.f29231h.requestLayout();
            start();
        }
    }

    /* renamed from: b */
    private void m20623b() {
        this.f29233j.clear();
        this.f29232i.removeAllViews();
        if (this.f29236m <= 1 || !this.f29240q) {
            this.f29232i.setVisibility(8);
            return;
        }
        this.f29232i.setVisibility(0);
        m20624c();
    }

    /* renamed from: c */
    private void m20624c() {
        for (int i = 0; i < this.f29236m; i++) {
            ImageView imageView = new ImageView(this.f29229f);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            int dip2px = UiUtils.dip2px(this.f29229f, 7.0f);
            int dip2px2 = UiUtils.dip2px(this.f29229f, 7.0f);
            int dip2px3 = UiUtils.dip2px(this.f29229f, 5.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px2);
            layoutParams.leftMargin = dip2px3;
            layoutParams.rightMargin = dip2px3;
            if (i == 0) {
                imageView.setImageResource(R.drawable.banner_indicator_gray_dot);
            } else {
                imageView.setImageResource(R.drawable.banner_indicator_white_dot);
            }
            this.f29232i.addView(imageView, layoutParams);
            this.f29233j.add(imageView);
        }
    }

    /* renamed from: a */
    private void m20618a(int i, int i2) {
        if (this.f29232i.getVisibility() == 0) {
            List<ImageView> list = this.f29233j;
            int i3 = this.f29236m;
            list.get(((i + i3) - 1) % i3).setImageResource(R.drawable.banner_indicator_white_dot);
            List<ImageView> list2 = this.f29233j;
            int i4 = this.f29236m;
            list2.get(((i2 + i4) - 1) % i4).setImageResource(R.drawable.banner_indicator_gray_dot);
        }
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.f29227a = onBannerClickListener;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f29228b = onPageChangeListener;
    }

    public int getCurrentPageIndex() {
        return m20615a(this.f29235l);
    }

    public void start() {
        SystemUtils.log(3, f29224c, "start", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 383);
        this.f29234k.removeCallbacks(this.f29247x);
        if (this.f29238o) {
            this.f29234k.postDelayed(this.f29247x, this.f29239p);
        }
    }

    public void stop() {
        SystemUtils.log(3, f29224c, "stop", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 394);
        this.f29234k.removeCallbacks(this.f29247x);
    }

    private void setCheatCurrentItem(int i) {
        if (this.f29243t) {
            if (i == 0) {
                this.f29231h.setCurrentItem(this.f29236m, false);
            } else if (i == this.f29236m + 1) {
                this.f29231h.setCurrentItem(1, false);
            }
        }
    }

    /* renamed from: d */
    private void m20627d() {
        SystemUtils.log(3, f29224c, "release", (Throwable) null, "com.didi.nova.assembly.ui.banner.Banner", 416);
        stop();
        this.f29227a = null;
        this.f29228b = null;
        this.f29233j.clear();
        this.f29232i.removeAllViews();
    }

    /* renamed from: a */
    private boolean m20621a(List<String> list, List<String> list2) {
        if (list.size() != list2.size()) {
            return true;
        }
        for (String indexOf : list) {
            if (list2.indexOf(indexOf) == -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m20615a(int i) {
        if (!this.f29243t) {
            return i;
        }
        if (this.f29237n.size() <= 1) {
            return 0;
        }
        int i2 = this.f29236m;
        return ((i + i2) - 1) % i2;
    }

    public void setDefaultDrawable(int i) {
        C10277a aVar = this.f29230g;
        if (aVar != null) {
            aVar.mo80218a(i);
        }
    }
}
