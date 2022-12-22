package com.didi.soda.customer.widget.headerview;

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
import com.didi.passenger.C10448R;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CustomerTabLayout extends HorizontalScrollView {

    /* renamed from: a */
    private static final String f41994a = "CustomerTabLayout";

    /* renamed from: b */
    private static final int f41995b = 0;

    /* renamed from: c */
    private static final int f41996c = 1;

    /* renamed from: d */
    private static final int f41997d = 2;

    /* renamed from: e */
    private static final int f41998e = 3;

    /* renamed from: f */
    private static final int f41999f = 4;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f42000g;

    /* renamed from: h */
    private LinearLayout f42001h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LinearLayout f42002i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<View> f42003j;

    /* renamed from: k */
    private int f42004k;

    /* renamed from: l */
    private int f42005l;

    /* renamed from: m */
    private boolean f42006m = true;

    /* renamed from: n */
    private boolean f42007n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f42008o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f42009p = -1;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f42010q = false;

    /* renamed from: r */
    private TabAdapter f42011r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public OnTabSelectedListener f42012s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public OnTabExposureListener f42013t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ObjectAnimator f42014u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Rect f42015v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public List<Integer> f42016w;

    /* renamed from: x */
    private ViewTreeObserver.OnScrollChangedListener f42017x;

    /* renamed from: y */
    private OnScollChangedListener f42018y = null;

    /* renamed from: z */
    private boolean f42019z = true;

    public interface OnScollChangedListener {
        void onScrollChanged(CustomerTabLayout customerTabLayout, int i, int i2, int i3, int i4);
    }

    public void setCustomerOnScrollChanedListener(OnScollChangedListener onScollChangedListener) {
        this.f42018y = onScollChangedListener;
    }

    public CustomerTabLayout(Context context) {
        super(context);
        m29615a();
    }

    public CustomerTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29618a(attributeSet);
        m29615a();
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.f42012s = onTabSelectedListener;
    }

    public void setOnTabExposureListener(OnTabExposureListener onTabExposureListener) {
        this.f42013t = onTabExposureListener;
    }

    public void setTabAdapter(TabAdapter tabAdapter) {
        if (!m29626a(tabAdapter)) {
            this.f42016w.clear();
            this.f42011r = tabAdapter;
            if (tabAdapter != null && tabAdapter.getItemCount() > 0) {
                int itemCount = tabAdapter.getItemCount();
                this.f42003j = new ArrayList();
                this.f42002i.removeAllViews();
                for (int i = 0; i < itemCount; i++) {
                    ITab itemView = tabAdapter.getItemView(i);
                    if (itemView instanceof View) {
                        itemView.updateTabView(tabAdapter.getData().get(i), i, itemCount);
                        itemView.setSelectedState(false, this.f42019z);
                        m29619a((View) itemView, i);
                    }
                }
                this.f42002i.post(new Runnable() {
                    public void run() {
                        if (CustomerTabLayout.this.f42010q) {
                            CustomerTabLayout.this.f42014u.cancel();
                        }
                        CustomerTabLayout.this.setSelectorColor(0);
                        CustomerTabLayout.this.m29632d();
                        if (CustomerTabLayout.this.f42012s != null) {
                            CustomerTabLayout.this.f42012s.onTabSelected(0, false, true);
                        }
                    }
                });
            }
        }
    }

    public void selectTab(final int i) {
        this.f42002i.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f42003j != null && CustomerTabLayout.this.f42009p != (i = i) && i >= 0 && i < CustomerTabLayout.this.f42003j.size()) {
                    ((View) CustomerTabLayout.this.f42003j.get(i)).performClick();
                }
            }
        });
    }

    public void selectTab(final int i, final boolean z) {
        this.f42002i.post(new Runnable() {
            public void run() {
                int i;
                if (CustomerTabLayout.this.f42003j != null && CustomerTabLayout.this.f42009p != (i = i) && i >= 0 && i < CustomerTabLayout.this.f42003j.size()) {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m29620a((View) customerTabLayout.f42003j.get(i), i, z);
                }
            }
        });
    }

    public void setShowSelectedItemColor(boolean z) {
        this.f42019z = z;
        setSelectorColor(this.f42009p);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m29628b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m29629c();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScollChangedListener onScollChangedListener = this.f42018y;
        if (onScollChangedListener != null) {
            onScollChangedListener.onScrollChanged(this, i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    private void m29618a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.CustomerTabLayout);
        this.f42005l = obtainStyledAttributes.getColor(1, ResourceHelper.getColor(R.color.rf_color_gery_1_0_000000));
        this.f42008o = obtainStyledAttributes.getInt(0, 0);
        this.f42007n = obtainStyledAttributes.getBoolean(3, false);
        this.f42004k = obtainStyledAttributes.getDimensionPixelSize(2, DisplayUtils.dip2px(getContext(), 3.0f));
        this.f42006m = obtainStyledAttributes.getBoolean(4, true);
        this.f42019z = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m29615a() {
        this.f42001h = new LinearLayout(getContext());
        this.f42002i = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.f42001h.setLayoutParams(layoutParams);
        this.f42001h.setMinimumWidth(DisplayUtils.getScreenWidth(getContext()));
        this.f42002i.setLayoutParams(layoutParams);
        this.f42001h.setOrientation(1);
        this.f42002i.setOrientation(0);
        addView(this.f42001h);
        this.f42001h.addView(this.f42002i);
        setHorizontalScrollBarEnabled(false);
        if (this.f42006m) {
            View view = new View(getContext());
            this.f42000g = view;
            view.setLayoutParams(new LinearLayout.LayoutParams(0, this.f42004k));
            this.f42000g.setBackgroundColor(this.f42005l);
            this.f42001h.addView(this.f42000g);
        }
        if (this.f42007n) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
            view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
            this.f42001h.addView(view2);
        }
        this.f42016w = new ArrayList();
        this.f42015v = new Rect();
        this.f42017x = new ViewTreeObserver.OnScrollChangedListener() {
            public void onScrollChanged() {
                int childCount = CustomerTabLayout.this.f42002i.getChildCount();
                if (CustomerTabLayout.this.f42016w.size() < childCount) {
                    for (int i = 0; i < childCount; i++) {
                        View childAt = CustomerTabLayout.this.f42002i.getChildAt(i);
                        if (!CustomerTabLayout.this.f42016w.contains(Integer.valueOf(i)) && childAt.getLocalVisibleRect(CustomerTabLayout.this.f42015v)) {
                            CustomerTabLayout.this.f42016w.add(Integer.valueOf(i));
                            LogUtil.m29104i(CustomerTabLayout.f41994a, "Visible:" + i);
                            if (CustomerTabLayout.this.f42013t != null) {
                                CustomerTabLayout.this.f42013t.onTabItemExposure(i);
                            }
                        }
                    }
                }
            }
        };
    }

    /* renamed from: b */
    private void m29628b() {
        getViewTreeObserver().addOnScrollChangedListener(this.f42017x);
    }

    /* renamed from: c */
    private void m29629c() {
        getViewTreeObserver().removeOnScrollChangedListener(this.f42017x);
    }

    /* renamed from: a */
    private void m29619a(final View view, final int i) {
        this.f42003j.add(view);
        this.f42002i.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerTabLayout.this.m29620a(view, i, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29620a(final View view, int i, boolean z) {
        if (i == 0 || i != this.f42009p) {
            int i2 = i - 1;
            final View view2 = i2 >= 0 ? this.f42003j.get(i2) : null;
            if (this.f42010q) {
                this.f42014u.cancel();
            }
            setSelectorColor(i);
            OnTabSelectedListener onTabSelectedListener = this.f42012s;
            if (onTabSelectedListener != null) {
                onTabSelectedListener.onTabSelected(i, z, false);
            }
            if (this.f42006m) {
                m29616a(i);
            }
            post(new Runnable() {
                public void run() {
                    CustomerTabLayout customerTabLayout = CustomerTabLayout.this;
                    customerTabLayout.m29617a(customerTabLayout.f42008o, view, view2);
                }
            });
        }
    }

    /* renamed from: a */
    private void m29616a(int i) {
        float x = this.f42002i.getX();
        View view = this.f42003j.get(i);
        if (view != null) {
            final ViewGroup.LayoutParams layoutParams = this.f42000g.getLayoutParams();
            int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(C16471q.f49112a, new float[]{Float.valueOf(this.f42000g.getX()).floatValue(), Float.valueOf(view.getX() + ((float) view.getPaddingLeft()) + x).floatValue()});
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("", new int[]{layoutParams.width, width});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f42000g, new PropertyValuesHolder[]{ofInt, ofFloat});
            this.f42014u = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new FastOutSlowInInterpolator());
            this.f42014u.start();
            this.f42014u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    CustomerTabLayout.this.f42000g.setLayoutParams(layoutParams);
                }
            });
            this.f42014u.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f42010q = true;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = CustomerTabLayout.this.f42010q = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29632d() {
        List<View> list = this.f42003j;
        if (list != null) {
            View view = list.get(0);
            if (view != null) {
                this.f42000g.setLayoutParams(new LinearLayout.LayoutParams((view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight(), this.f42004k));
                this.f42000g.setX((float) view.getPaddingLeft());
            }
            scrollTo(0, 0);
        }
    }

    /* access modifiers changed from: private */
    public void setSelectorColor(int i) {
        int i2 = this.f42009p;
        if (i2 >= 0 && i2 < this.f42003j.size()) {
            ((ITab) this.f42003j.get(this.f42009p)).setSelectedState(false, this.f42019z);
        }
        this.f42009p = i;
        if (i >= 0 && i < this.f42003j.size()) {
            ((ITab) this.f42003j.get(this.f42009p)).setSelectedState(true, this.f42019z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29617a(int i, View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (i == 1) {
            smoothScrollBy(iArr[0], 0);
        } else if (i == 2) {
            smoothScrollBy((iArr[0] + view.getWidth()) - DisplayUtils.getScreenWidth(getContext()), 0);
        } else if (i == 3) {
            smoothScrollBy((iArr[0] + (view.getWidth() / 2)) - (DisplayUtils.getScreenWidth(getContext()) / 2), 0);
        } else if (i != 4) {
            if (iArr[0] + view.getWidth() > DisplayUtils.getScreenWidth(getContext())) {
                smoothScrollBy(view.getWidth(), 0);
            } else if (iArr[0] < 0) {
                smoothScrollBy(-view.getWidth(), 0);
            }
        } else if (view2 != null) {
            smoothScrollTo(view2.getLeft(), 0);
        } else {
            smoothScrollTo(view.getLeft(), 0);
        }
    }

    /* renamed from: a */
    private boolean m29626a(TabAdapter tabAdapter) {
        TabAdapter tabAdapter2 = this.f42011r;
        if (tabAdapter2 == null || tabAdapter2.getData() == null || tabAdapter.getItemCount() != this.f42011r.getItemCount()) {
            return false;
        }
        if (tabAdapter.getData() == null) {
            return true;
        }
        return this.f42011r.getData().toString().equals(tabAdapter.getData().toString());
    }
}
