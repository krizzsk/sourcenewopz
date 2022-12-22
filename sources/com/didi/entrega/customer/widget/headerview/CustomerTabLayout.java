package com.didi.entrega.customer.widget.headerview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.headerview.tabitem.ITab;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerTabLayout extends HorizontalScrollView {

    /* renamed from: a */
    private static final String f20467a = "CustomerTabLayout";

    /* renamed from: b */
    private static final int f20468b = 0;

    /* renamed from: c */
    private static final int f20469c = 1;

    /* renamed from: d */
    private static final int f20470d = 2;

    /* renamed from: e */
    private static final int f20471e = 3;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f20472f;

    /* renamed from: g */
    private LinearLayout f20473g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LinearLayout f20474h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public List<View> f20475i;

    /* renamed from: j */
    private int f20476j;

    /* renamed from: k */
    private int f20477k;

    /* renamed from: l */
    private boolean f20478l = true;

    /* renamed from: m */
    private boolean f20479m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f20480n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f20481o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f20482p = false;

    /* renamed from: q */
    private TabAdapter f20483q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OnTabSelectedListener f20484r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public OnTabExposureListener f20485s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ObjectAnimator f20486t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Rect f20487u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public List<Integer> f20488v;

    /* renamed from: w */
    private ViewTreeObserver.OnScrollChangedListener f20489w;

    public CustomerTabLayout(Context context) {
        super(context);
        m14972a();
    }

    public CustomerTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14975a(attributeSet);
        m14972a();
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.f20484r = onTabSelectedListener;
    }

    public void setOnTabExposureListener(OnTabExposureListener onTabExposureListener) {
        this.f20485s = onTabExposureListener;
    }

    public void setTabAdapter(TabAdapter tabAdapter) {
        if (!m14983a(tabAdapter)) {
            this.f20488v.clear();
            this.f20483q = tabAdapter;
            if (tabAdapter != null && tabAdapter.getItemCount() > 0) {
                int itemCount = tabAdapter.getItemCount();
                this.f20475i = new ArrayList();
                this.f20474h.removeAllViews();
                for (int i = 0; i < itemCount; i++) {
                    ITab itemView = tabAdapter.getItemView(i);
                    if (itemView instanceof View) {
                        itemView.updateTabView(tabAdapter.getData().get(i), i, itemCount);
                        itemView.setSelectedState(false);
                        m14976a((View) itemView, i);
                    }
                }
                this.f20474h.post(new Runnable() {
                    public void run() {
                        if (CustomerTabLayout.this.f20482p) {
                            CustomerTabLayout.this.f20486t.cancel();
                        }
                        CustomerTabLayout.this.setSelectorColor(0);
                        CustomerTabLayout.this.m14989d();
                        if (CustomerTabLayout.this.f20484r != null) {
                            CustomerTabLayout.this.f20484r.onTabSelected(0, false, true);
                        }
                    }
                });
            }
        }
    }

    public void selectTab(final int i) {
        this.f20474h.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f20475i != null && CustomerTabLayout.this.f20481o != (i = i) && i >= 0 && i < CustomerTabLayout.this.f20475i.size()) {
                    ((View) CustomerTabLayout.this.f20475i.get(i)).performClick();
                }
            }
        });
    }

    public void selectTab(final int i, final boolean z) {
        this.f20474h.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f20475i != null && CustomerTabLayout.this.f20481o != (i = i) && i >= 0 && i < CustomerTabLayout.this.f20475i.size()) {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m14977a((View) customerTabLayout.f20475i.get(i), i, z);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m14985b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m14986c();
    }

    /* renamed from: a */
    private void m14975a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaTabLayout);
        this.f20477k = obtainStyledAttributes.getColor(1, ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        this.f20480n = obtainStyledAttributes.getInt(0, 0);
        this.f20479m = obtainStyledAttributes.getBoolean(3, false);
        this.f20476j = obtainStyledAttributes.getDimensionPixelSize(2, DisplayUtils.dip2px(getContext(), 3.0f));
        this.f20478l = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m14972a() {
        this.f20473g = new LinearLayout(getContext());
        this.f20474h = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.f20473g.setLayoutParams(layoutParams);
        this.f20473g.setMinimumWidth(DisplayUtils.getScreenWidth(getContext()));
        this.f20474h.setLayoutParams(layoutParams);
        this.f20473g.setOrientation(1);
        this.f20474h.setOrientation(0);
        addView(this.f20473g);
        this.f20473g.addView(this.f20474h);
        setHorizontalScrollBarEnabled(false);
        if (this.f20478l) {
            View view = new View(getContext());
            this.f20472f = view;
            view.setLayoutParams(new LinearLayout.LayoutParams(0, this.f20476j));
            this.f20472f.setBackgroundColor(this.f20477k);
            this.f20473g.addView(this.f20472f);
        }
        if (this.f20479m) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
            this.f20473g.addView(view2);
        }
        this.f20488v = new ArrayList();
        this.f20487u = new Rect();
        this.f20489w = new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                int childCount = CustomerTabLayout.this.f20474h.getChildCount();
                if (CustomerTabLayout.this.f20488v.size() < childCount) {
                    for (int i = 0; i < childCount; i++) {
                        View childAt = CustomerTabLayout.this.f20474h.getChildAt(i);
                        if (!CustomerTabLayout.this.f20488v.contains(Integer.valueOf(i)) && childAt.getLocalVisibleRect(CustomerTabLayout.this.f20487u)) {
                            CustomerTabLayout.this.f20488v.add(Integer.valueOf(i));
                            LogUtil.m14765i(CustomerTabLayout.f20467a, "Visible:" + i);
                            if (CustomerTabLayout.this.f20485s != null) {
                                CustomerTabLayout.this.f20485s.onTabItemExposure(i);
                            }
                        }
                    }
                }
            }
        };
    }

    /* renamed from: b */
    private void m14985b() {
        getViewTreeObserver().addOnScrollChangedListener(this.f20489w);
    }

    /* renamed from: c */
    private void m14986c() {
        getViewTreeObserver().removeOnScrollChangedListener(this.f20489w);
    }

    /* renamed from: a */
    private void m14976a(final View view, final int i) {
        this.f20475i.add(view);
        this.f20474h.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CustomerTabLayout.this.m14977a(view, i, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14977a(final View view, int i, boolean z) {
        if (i != this.f20481o) {
            if (this.f20482p) {
                this.f20486t.cancel();
            }
            setSelectorColor(i);
            OnTabSelectedListener onTabSelectedListener = this.f20484r;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabSelected(i, z, false);
            }
            if (this.f20478l) {
                m14973a(i);
            }
            post(new Runnable() {
                public void run() {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m14974a(customerTabLayout.f20480n, view);
                }
            });
        }
    }

    /* renamed from: a */
    private void m14973a(int i) {
        float x = this.f20474h.getX();
        View view = this.f20475i.get(i);
        if (view != null) {
            final ViewGroup.LayoutParams layoutParams = this.f20472f.getLayoutParams();
            int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(C16471q.f49112a, new float[]{Float.valueOf(this.f20472f.getX()).floatValue(), Float.valueOf(view.getX() + ((float) view.getPaddingLeft()) + x).floatValue()});
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("", new int[]{layoutParams.width, width});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f20472f, new PropertyValuesHolder[]{ofInt, ofFloat});
            this.f20486t = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new FastOutSlowInInterpolator());
            this.f20486t.start();
            this.f20486t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    CustomerTabLayout.this.f20472f.setLayoutParams(layoutParams);
                }
            });
            this.f20486t.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f20482p = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f20482p = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m14989d() {
        List<View> list = this.f20475i;
        if (list != null) {
            View view = list.get(0);
            if (view != null) {
                this.f20472f.setLayoutParams(new LinearLayout.LayoutParams((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight(), this.f20476j));
                this.f20472f.setX((float) view.getPaddingLeft());
            }
            scrollTo(0, 0);
        }
    }

    /* access modifiers changed from: private */
    public void setSelectorColor(int i) {
        int i2 = this.f20481o;
        if (i2 >= 0 && i2 < this.f20475i.size()) {
            ((ITab) this.f20475i.get(this.f20481o)).setSelectedState(false);
        }
        this.f20481o = i;
        if (i >= 0 && i < this.f20475i.size()) {
            ((ITab) this.f20475i.get(this.f20481o)).setSelectedState(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14974a(int i, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (i == 1) {
            smoothScrollBy(iArr[0], 0);
        } else if (i == 2) {
            smoothScrollBy((iArr[0] + view.getWidth()) - DisplayUtils.getScreenWidth(getContext()), 0);
        } else if (i == 3) {
            smoothScrollBy((iArr[0] + (view.getWidth() / 2)) - (DisplayUtils.getScreenWidth(getContext()) / 2), 0);
        } else if (iArr[0] + view.getWidth() > DisplayUtils.getScreenWidth(getContext())) {
            smoothScrollBy(view.getWidth(), 0);
        } else if (iArr[0] < 0) {
            smoothScrollBy(-view.getWidth(), 0);
        }
    }

    /* renamed from: a */
    private boolean m14983a(TabAdapter tabAdapter) {
        TabAdapter tabAdapter2 = this.f20483q;
        if (tabAdapter2 == null || tabAdapter2.getData() == null || tabAdapter.getItemCount() != this.f20483q.getItemCount()) {
            return false;
        }
        if (tabAdapter.getData() == null) {
            return true;
        }
        return this.f20483q.getData().toString().equals(tabAdapter.getData().toString());
    }
}
