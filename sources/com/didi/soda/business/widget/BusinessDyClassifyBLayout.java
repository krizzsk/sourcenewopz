package com.didi.soda.business.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.headerview.OnMoreCategoryListener;
import com.didi.soda.customer.widget.headerview.OnTabExposureListener;
import com.didi.soda.customer.widget.headerview.OnTabSelectedListener;
import com.didi.soda.customer.widget.headerview.TabAdapter;
import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import com.didi.soda.customer.widget.headerview.tabitem.p166dy.BusinessDyClassifyTab;
import com.taxis99.R;
import java.util.List;

public class BusinessDyClassifyBLayout extends ConstraintLayout {

    /* renamed from: a */
    private static final String f39772a = "BusinessDyClassifyBLayout";

    /* renamed from: b */
    private BusinessDyHomeHeaderView.OnBusinessTabItemListener f39773b;

    /* renamed from: c */
    private OnMoreCategoryListener f39774c;
    public BusinessCategoryRvModel currentCategoryRvModel;
    @BindView(17903)
    CustomerTabLayout mClassifyTab;
    @BindView(18129)
    public View mMenuContainer;

    public BusinessDyClassifyBLayout(Context context) {
        super(context);
        m28359b();
    }

    public BusinessDyClassifyBLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28359b();
    }

    public BusinessDyClassifyBLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28359b();
    }

    public void setCategoryClickListener(OnMoreCategoryListener onMoreCategoryListener) {
        this.f39774c = onMoreCategoryListener;
    }

    public void setTabItemListener(BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener) {
        this.f39773b = onBusinessTabItemListener;
    }

    public void setOnCategoryTouchListener(View.OnTouchListener onTouchListener) {
        this.mClassifyTab.setOnTouchListener(onTouchListener);
    }

    public void setOnCategoryScrollListener(CustomerTabLayout.OnScollChangedListener onScollChangedListener) {
        this.mClassifyTab.setCustomerOnScrollChanedListener(onScollChangedListener);
    }

    public void updateBusinessCategoryData(BusinessHeaderRvModel businessHeaderRvModel) {
        setVisibility(0);
        m28356a(businessHeaderRvModel);
    }

    public void selectTab(int i) {
        CustomerTabLayout customerTabLayout = this.mClassifyTab;
        if (customerTabLayout != null) {
            customerTabLayout.selectTab(i);
        }
    }

    public void selectTab(int i, boolean z) {
        CustomerTabLayout customerTabLayout = this.mClassifyTab;
        if (customerTabLayout != null) {
            customerTabLayout.selectTab(i, z);
        }
    }

    /* renamed from: a */
    private void m28353a(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener = this.f39773b;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onTabItemExposure(i, businessCategoryRvModel);
        }
    }

    /* renamed from: a */
    private void m28354a(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener = this.f39773b;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onTabItemSelected(i, businessCategoryRvModel, z, z2);
        }
    }

    public void showClassifyTabSelectedColor(boolean z) {
        this.mClassifyTab.setShowSelectedItemColor(z);
    }

    /* renamed from: a */
    private void m28356a(final BusinessHeaderRvModel businessHeaderRvModel) {
        if (businessHeaderRvModel.mCategoryList == null || businessHeaderRvModel.mCategoryList.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mClassifyTab.setTabAdapter(new TabAdapter<BusinessCategoryRvModel>() {
            public ITab<BusinessCategoryRvModel> getItemView(int i) {
                return new BusinessDyClassifyTab(BusinessDyClassifyBLayout.this.getContext());
            }

            public int getItemCount() {
                if (businessHeaderRvModel.mCategoryList == null) {
                    return 0;
                }
                return businessHeaderRvModel.mCategoryList.size();
            }

            public List<BusinessCategoryRvModel> getData() {
                return businessHeaderRvModel.mCategoryList;
            }
        });
        this.mClassifyTab.setOnTabSelectedListener(new OnTabSelectedListener(businessHeaderRvModel) {
            public final /* synthetic */ BusinessHeaderRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onTabSelected(int i, boolean z, boolean z2) {
                BusinessDyClassifyBLayout.this.m28358a(this.f$1, i, z, z2);
            }
        });
        this.mClassifyTab.setOnTabExposureListener(new OnTabExposureListener(businessHeaderRvModel) {
            public final /* synthetic */ BusinessHeaderRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onTabItemExposure(int i) {
                BusinessDyClassifyBLayout.this.m28357a(this.f$1, i);
            }
        });
        if (businessHeaderRvModel.mCategoryList.size() >= 4) {
            this.mMenuContainer.setVisibility(0);
            this.mMenuContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessDyClassifyBLayout.this.m28355a(view);
                }
            });
            m28351a();
            return;
        }
        this.mMenuContainer.setVisibility(8);
        this.mMenuContainer.setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28358a(BusinessHeaderRvModel businessHeaderRvModel, int i, boolean z, boolean z2) {
        if (i >= 0 && i < businessHeaderRvModel.mCategoryList.size() && businessHeaderRvModel.mCategoryList.get(i) != null) {
            this.currentCategoryRvModel = businessHeaderRvModel.mCategoryList.get(i);
            m28354a(i, businessHeaderRvModel.mCategoryList.get(i), z, z2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28357a(BusinessHeaderRvModel businessHeaderRvModel, int i) {
        if (i >= 0 && i < businessHeaderRvModel.mCategoryList.size() && businessHeaderRvModel.mCategoryList.get(i) != null) {
            m28353a(i, businessHeaderRvModel.mCategoryList.get(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28355a(View view) {
        if (this.f39774c != null) {
            this.f39774c.onClickMoreCategoryListener(new BusinessSelectedCallback() {
                public final void onSelectedCategory(int i) {
                    BusinessDyClassifyBLayout.this.m28352a(i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28352a(int i) {
        this.mClassifyTab.selectTab(i, false);
    }

    /* renamed from: a */
    private void m28351a() {
        BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener = this.f39773b;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onMoreTabExposure();
        }
    }

    /* renamed from: b */
    private void m28359b() {
        ButterKnife.bind((Object) this, LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_classify_b, this, true));
        setClickable(false);
    }
}
