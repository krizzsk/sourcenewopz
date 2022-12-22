package com.scwang.smart.refresh.horizontal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshInitializer;
import com.taxis99.R;

public class SmartRefreshHorizontal extends SmartRefreshLayout {
    protected static DefaultRefreshFooterCreator sFooterCreator;
    protected static DefaultRefreshHeaderCreator sHeaderCreator;
    protected static DefaultRefreshInitializer sRefreshInitializer;
    protected boolean isInLayout;

    public SmartRefreshHorizontal(Context context) {
        this(context, (AttributeSet) null);
    }

    public SmartRefreshHorizontal(Context context, AttributeSet attributeSet) {
        super(wrapper(context), attributeSet);
        this.isInLayout = false;
        setScrollBoundaryDecider(new ScrollBoundaryHorizontal());
    }

    protected static Context wrapper(Context context) {
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultHorizontalInitializer(sRefreshInitializer, SmartRefreshLayout.sRefreshInitializer));
        return context;
    }

    public static void setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        sHeaderCreator = defaultRefreshHeaderCreator;
    }

    public static void setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        sFooterCreator = defaultRefreshFooterCreator;
    }

    public static void setDefaultRefreshInitializer(DefaultRefreshInitializer defaultRefreshInitializer) {
        sRefreshInitializer = defaultRefreshInitializer;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        DefaultRefreshHeaderCreator defaultRefreshHeaderCreator = SmartRefreshLayout.sHeaderCreator;
        DefaultRefreshFooterCreator defaultRefreshFooterCreator = SmartRefreshLayout.sFooterCreator;
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(sHeaderCreator);
        SmartRefreshLayout.setDefaultRefreshFooterCreator(sFooterCreator);
        super.onAttachedToWindow();
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(defaultRefreshHeaderCreator);
        SmartRefreshLayout.setDefaultRefreshFooterCreator(defaultRefreshFooterCreator);
        if (this.mRefreshContent != null && !(this.mRefreshContent instanceof RefreshContentHorizontal)) {
            this.mRefreshContent = new RefreshContentHorizontal(this.mRefreshContent.getView());
            View view = null;
            View findViewById = this.mFixedHeaderViewId > 0 ? findViewById(this.mFixedHeaderViewId) : null;
            if (this.mFixedFooterViewId > 0) {
                view = findViewById(this.mFixedFooterViewId);
            }
            this.mRefreshContent.setScrollBoundaryDecider(this.mScrollBoundaryDecider);
            this.mRefreshContent.setEnableLoadMoreWhenContentNotFull(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.setUpComponent(this.mKernel, findViewById, view);
        }
        setRotation(-90.0f);
    }

    /* access modifiers changed from: protected */
    public boolean isRefreshComponent(View view) {
        RefreshComponent refreshComponent = this.mRefreshHeader;
        RefreshComponent refreshComponent2 = this.mRefreshFooter;
        return (refreshComponent != null && (view == refreshComponent || view == refreshComponent.getView())) || (refreshComponent2 != null && (view == refreshComponent2 || view == refreshComponent2.getView()));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        String str;
        String str2;
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            str = "GONE";
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (!isRefreshComponent(childAt)) {
                str = "VISIBLE";
            }
            childAt.setTag(R.id.srl_tag, str);
            i3++;
        }
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        }
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        }
        int childCount2 = getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            View childAt2 = getChildAt(i4);
            if (isRefreshComponent(childAt2)) {
                str2 = "VISIBLE";
            } else {
                str2 = str;
            }
            childAt2.setTag(R.id.srl_tag, str2);
        }
        super.onMeasure(i2, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i3 - i;
        int i7 = i4 - i2;
        int i8 = (i7 - i6) / 2;
        if (this.isInLayout) {
            RefreshComponent refreshComponent = this.mRefreshHeader;
            RefreshComponent refreshComponent2 = this.mRefreshFooter;
            int paddingLeft = getPaddingLeft();
            getPaddingRight();
            int paddingTop = getPaddingTop();
            getPaddingBottom();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (!isRefreshComponent(childAt) && childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int i10 = i6 - paddingTop;
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i5 = marginLayoutParams.leftMargin + paddingLeft;
                        i10 -= marginLayoutParams.topMargin;
                    } else {
                        i5 = paddingLeft;
                    }
                    int i11 = (measuredHeight - measuredWidth) / 2;
                    int i12 = i5 - i11;
                    int i13 = i10 - i11;
                    childAt.setRotation(90.0f);
                    childAt.setTag(R.id.srl_tag, "GONE");
                    childAt.layout(i13 - measuredWidth, i12, i13, measuredHeight + i12);
                }
            }
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int i14 = i2 - i8;
        int i15 = i8 + i;
        this.isInLayout = true;
        super.layout(i15, i14, i6 + i15, i7 + i14);
        this.isInLayout = false;
    }

    protected static class DefaultHorizontalInitializer implements DefaultRefreshInitializer {
        protected DefaultRefreshInitializer initializer;
        protected DefaultRefreshInitializer oldInitializer;

        protected DefaultHorizontalInitializer(DefaultRefreshInitializer defaultRefreshInitializer, DefaultRefreshInitializer defaultRefreshInitializer2) {
            this.oldInitializer = defaultRefreshInitializer2;
            this.initializer = defaultRefreshInitializer;
        }

        public void initialize(Context context, RefreshLayout refreshLayout) {
            refreshLayout.setEnableLoadMore(true);
            DefaultRefreshInitializer defaultRefreshInitializer = this.initializer;
            if (defaultRefreshInitializer != null) {
                defaultRefreshInitializer.initialize(context, refreshLayout);
            }
            DefaultRefreshInitializer defaultRefreshInitializer2 = this.oldInitializer;
            if (defaultRefreshInitializer2 != null) {
                SmartRefreshLayout.setDefaultRefreshInitializer(defaultRefreshInitializer2);
            }
        }
    }
}
