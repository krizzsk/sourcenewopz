package com.didi.soda.business.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.business.widget.BusinessDyHeaderAnimator;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.business.widget.IBusinessHeaderAnimator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.lang.ref.WeakReference;

public class BusinessHeaderDyScrollingBehavior extends CoordinatorLayout.Behavior<RecyclerView> {

    /* renamed from: a */
    private static final String f39678a = "BusinessHeaderScrollingBehavior";

    /* renamed from: b */
    private static final float f39679b = 0.0f;

    /* renamed from: c */
    private static final float f39680c = 1.0f;

    /* renamed from: d */
    private static final int f39681d = 1;

    /* renamed from: e */
    private static final int f39682e = 2;

    /* renamed from: f */
    private static final int f39683f = 6000;

    /* renamed from: g */
    private int f39684g = 0;

    /* renamed from: h */
    private WeakReference<BusinessDyHomeHeaderView> f39685h;

    /* renamed from: i */
    private boolean f39686i = false;

    /* renamed from: a */
    private TextView m28277a(BusinessDyHomeHeaderView businessDyHomeHeaderView) {
        return null;
    }

    public BusinessHeaderDyScrollingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view) {
        if (!(view instanceof BusinessDyHomeHeaderView)) {
            return super.layoutDependsOn(coordinatorLayout, recyclerView, view);
        }
        BusinessDyHomeHeaderView businessDyHomeHeaderView = (BusinessDyHomeHeaderView) view;
        this.f39685h = new WeakReference<>(businessDyHomeHeaderView);
        businessDyHomeHeaderView.getHeaderAnimator().setDependentViewDyChangedCallback(new BusinessDyHeaderAnimator.DependentViewChangedCallback(view) {
            public final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onDependentViewChanged() {
                CoordinatorLayout.this.dispatchDependentViewsChanged(this.f$1);
            }
        });
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, int i) {
        m28280a(recyclerView, (View) coordinatorLayout);
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view) {
        m28280a(recyclerView, (View) coordinatorLayout);
        return true;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, View view2, int i, int i2) {
        m28281a("onStartNestedScroll---type:" + i2);
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, View view2, int i, int i2) {
        super.onNestedScrollAccepted(coordinatorLayout, recyclerView, view, view2, i, i2);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, int i, int i2, int[] iArr, int i3) {
        if (i2 > 0) {
            this.f39684g = 1;
        } else if (i2 < 0) {
            this.f39684g = 2;
            this.f39686i = false;
        }
        if (i2 > 0 || !recyclerView.canScrollVertically(-1)) {
            IBusinessHeaderAnimator d = m28285d();
            float animatedY = d.getAnimatedY() - ((float) i2);
            float maxAnimatedY = d.getMaxAnimatedY();
            m28281a("onNestedPreScroll-----" + i2 + "---- type:" + i3 + " newTranslateY:" + animatedY + " minHeaderTranslate:" + maxAnimatedY);
            if (animatedY > 0.0f) {
                return;
            }
            if (animatedY > maxAnimatedY) {
                d.setAnimatedY(animatedY);
                iArr[1] = i2;
            } else if (animatedY <= maxAnimatedY && !this.f39686i) {
                this.f39686i = true;
                d.setAnimatedY(maxAnimatedY);
            }
        }
    }

    /* renamed from: a */
    private int m28276a() {
        int[] iArr = new int[2];
        m28281a("location[1] Y : " + iArr[1]);
        return iArr[1];
    }

    /* renamed from: a */
    private boolean m28282a(TextView textView) {
        if (textView == null || textView.getText() == null || m28284c().currentCategoryRvModel == null || m28284c().currentCategoryRvModel.businessTabTipRvModel == null || m28284c().currentCategoryRvModel.businessTabTipRvModel.getTopContent() == null || !m28284c().currentCategoryRvModel.businessTabTipRvModel.getTopContent().equals(textView.getText().toString())) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private String m28278a(RecyclerView recyclerView) {
        return (m28284c().currentCategoryRvModel == null || m28284c().currentCategoryRvModel.businessTabTipRvModel == null || m28284c().currentCategoryRvModel.businessTabTipRvModel.getTopContent() == null) ? "" : m28284c().currentCategoryRvModel.businessTabTipRvModel.getTopContent();
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2) {
        m28281a("onNestedPreFling-----" + f2);
        if (f2 > 0.0f) {
            this.f39684g = 1;
        } else if (f2 < 0.0f) {
            this.f39684g = 2;
        }
        if (f2 >= 0.0f || Math.abs(f2) <= 6000.0f) {
            return false;
        }
        recyclerView.scrollToPosition(0);
        return true;
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2, boolean z) {
        m28281a("onNestedFling-----" + f2);
        m28280a(recyclerView, (View) coordinatorLayout);
        return super.onNestedFling(coordinatorLayout, recyclerView, view, f, f2, z);
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, int i) {
        m28281a("onStopNestedScroll-----" + i);
        m28285d().getAnimatedProgress();
        m28281a("scroll direction: " + this.f39684g);
        m28283b();
        m28284c().getBusinessHeaderViewTipHelper().setTouchNow(false);
    }

    /* renamed from: b */
    private void m28283b() {
        this.f39684g = 0;
    }

    /* renamed from: c */
    private BusinessDyHomeHeaderView m28284c() {
        return (BusinessDyHomeHeaderView) this.f39685h.get();
    }

    /* renamed from: d */
    private IBusinessHeaderAnimator m28285d() {
        return ((BusinessDyHomeHeaderView) this.f39685h.get()).getHeaderAnimator();
    }

    /* renamed from: a */
    private void m28280a(RecyclerView recyclerView, View view) {
        int height = m28284c().getHeight() - m28286e();
        recyclerView.setTranslationY(((float) height) + m28285d().getAnimatedY());
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = (int) (((float) (view.getHeight() - height)) + Math.abs(m28285d().getAnimatedY()));
        recyclerView.setLayoutParams(layoutParams);
    }

    /* renamed from: e */
    private int m28286e() {
        TextView a = m28277a(m28284c());
        if (a != null) {
            return a.getHeight();
        }
        return 0;
    }

    /* renamed from: a */
    private void m28281a(String str) {
        LogUtil.m29100d(f39678a, str);
    }
}
