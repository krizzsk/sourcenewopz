package com.didi.soda.business.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.business.widget.BusinessHeaderAnimator;
import com.didi.soda.business.widget.BusinessHomeHeaderView;
import com.didi.soda.business.widget.IBusinessHeaderAnimator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.lang.ref.WeakReference;

public class BusinessHeaderScrollingBehavior extends CoordinatorLayout.Behavior<RecyclerView> {

    /* renamed from: a */
    private static final String f39690a = "BusinessHeaderScrollingBehavior";

    /* renamed from: b */
    private static final float f39691b = 0.0f;

    /* renamed from: c */
    private static final float f39692c = 1.0f;

    /* renamed from: d */
    private static final int f39693d = 1;

    /* renamed from: e */
    private static final int f39694e = 2;

    /* renamed from: f */
    private static final int f39695f = 6000;

    /* renamed from: g */
    private int f39696g = 0;

    /* renamed from: h */
    private WeakReference<BusinessHomeHeaderView> f39697h;

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public BusinessHeaderScrollingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view) {
        if (!(view instanceof BusinessHomeHeaderView)) {
            return false;
        }
        BusinessHomeHeaderView businessHomeHeaderView = (BusinessHomeHeaderView) view;
        this.f39697h = new WeakReference<>(businessHomeHeaderView);
        businessHomeHeaderView.getHeaderAnimator().setDependentViewChangedCallback(new BusinessHeaderAnimator.DependentViewChangedCallback(view) {
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
        m28291a(recyclerView, (View) coordinatorLayout);
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view) {
        m28291a(recyclerView, (View) coordinatorLayout);
        return true;
    }

    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, View view2, int i, int i2) {
        super.onNestedScrollAccepted(coordinatorLayout, recyclerView, view, view2, i, i2);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            if (i2 > 0) {
                this.f39696g = 1;
            } else if (i2 < 0) {
                this.f39696g = 2;
            }
            if (i2 > 0 || !recyclerView.canScrollVertically(-1)) {
                IBusinessHeaderAnimator d = m28296d();
                float animatedY = d.getAnimatedY() - ((float) i2);
                if (animatedY > d.getMaxAnimatedY() && animatedY <= 0.0f) {
                    d.setAnimatedY(animatedY);
                    iArr[1] = i2;
                }
            }
        }
    }

    /* renamed from: a */
    private int m28287a() {
        int[] iArr = new int[2];
        m28295c().mBusinessTabTipTv.getLocationOnScreen(iArr);
        m28292a("location[1] Y : " + iArr[1]);
        return iArr[1];
    }

    /* renamed from: a */
    private boolean m28293a(TextView textView) {
        if (textView == null || textView.getText() == null || m28295c().currentCategoryRvModel == null || m28295c().currentCategoryRvModel.businessTabTipRvModel == null || m28295c().currentCategoryRvModel.businessTabTipRvModel.getTopContent() == null || !m28295c().currentCategoryRvModel.businessTabTipRvModel.getTopContent().equals(textView.getText().toString())) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private String m28289a(RecyclerView recyclerView) {
        return (m28295c().currentCategoryRvModel == null || m28295c().currentCategoryRvModel.businessTabTipRvModel == null || m28295c().currentCategoryRvModel.businessTabTipRvModel.getTopContent() == null) ? "" : m28295c().currentCategoryRvModel.businessTabTipRvModel.getTopContent();
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2) {
        if (f2 > 0.0f) {
            this.f39696g = 1;
        } else if (f2 < 0.0f) {
            this.f39696g = 2;
        }
        m28292a("onNestedPreFling " + f2);
        if (f2 >= 0.0f || Math.abs(f2) <= 6000.0f) {
            return false;
        }
        recyclerView.scrollToPosition(0);
        return true;
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, float f, float f2, boolean z) {
        m28295c().getBusinessHeaderViewTipHelper().setTouchNow(false);
        return super.onNestedFling(coordinatorLayout, recyclerView, view, f, f2, z);
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, View view, int i) {
        IBusinessHeaderAnimator d = m28296d();
        float animatedProgress = d.getAnimatedProgress();
        m28292a("scroll direction: " + this.f39696g);
        int i2 = this.f39696g;
        if (i2 != 1) {
            if (i2 == 2 && animatedProgress < 1.0f) {
                m28292a("自动吸顶：自动向下展开");
                d.expandHeader();
            }
        } else if (animatedProgress > 0.0f) {
            m28292a("自动吸顶：自动向上吸顶");
            d.collapseHeader();
        }
        m28294b();
        m28295c().getBusinessHeaderViewTipHelper().setTouchNow(false);
    }

    /* renamed from: b */
    private void m28294b() {
        this.f39696g = 0;
    }

    /* renamed from: c */
    private BusinessHomeHeaderView m28295c() {
        return (BusinessHomeHeaderView) this.f39697h.get();
    }

    /* renamed from: d */
    private IBusinessHeaderAnimator m28296d() {
        return ((BusinessHomeHeaderView) this.f39697h.get()).getHeaderAnimator();
    }

    /* renamed from: a */
    private void m28291a(RecyclerView recyclerView, View view) {
        int height = m28295c().getHeight() - m28297e();
        recyclerView.setTranslationY(((float) height) + m28296d().getAnimatedY());
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = (int) (((float) (view.getHeight() - height)) + Math.abs(m28296d().getAnimatedY()));
        recyclerView.setLayoutParams(layoutParams);
    }

    /* renamed from: e */
    private int m28297e() {
        TextView a = m28288a(m28295c());
        if (a != null) {
            return a.getHeight();
        }
        return 0;
    }

    /* renamed from: a */
    private TextView m28288a(BusinessHomeHeaderView businessHomeHeaderView) {
        if (businessHomeHeaderView != null) {
            return businessHomeHeaderView.mBusinessTabTipTv;
        }
        return null;
    }

    /* renamed from: a */
    private void m28292a(String str) {
        LogUtil.m29100d(f39690a, str);
    }
}
