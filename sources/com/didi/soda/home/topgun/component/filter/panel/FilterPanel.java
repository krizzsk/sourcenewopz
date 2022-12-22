package com.didi.soda.home.topgun.component.filter.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.customer.foundation.util.ViewSafeHelper;
import com.didi.soda.home.topgun.model.FilterModel;

public abstract class FilterPanel {

    /* renamed from: a */
    private View f42876a;

    /* renamed from: b */
    private boolean f42877b;

    /* renamed from: c */
    private FilterModel f42878c;
    protected int mFromScene = 1;
    protected OnFilterPanelEvent mOnFilterPanelEvent;
    public String mTimePeriod = null;
    public int mTopicFromScence = -1;

    public interface OnFilterPanelEvent {
        void onConfirm(FilterPanel filterPanel, boolean z, boolean z2);
    }

    public void bindData(FilterModel filterModel) {
    }

    public View createRootView(Context context) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    public FilterPanel(Context context) {
        View createRootView = createRootView(context);
        this.f42876a = createRootView;
        if (createRootView == null) {
            throw new IllegalArgumentException("FilterPanel getRootView 返回值为null");
        }
    }

    public void setOnFilterPanelEvent(OnFilterPanelEvent onFilterPanelEvent) {
        this.mOnFilterPanelEvent = onFilterPanelEvent;
    }

    public boolean isShow() {
        return this.f42876a.getParent() != null;
    }

    public final void attach(ViewGroup viewGroup, FilterModel filterModel, int i) {
        if (!this.f42877b) {
            this.mFromScene = i;
            this.f42877b = true;
            onAttach();
            ViewSafeHelper.safeAddView(viewGroup, this.f42876a, new ViewGroup.LayoutParams(-1, -2));
            this.f42878c = filterModel;
            if (filterModel.mFilterComponent != null && filterModel.mFilterComponent.size() != 0) {
                bindData(filterModel);
            }
        }
    }

    public final boolean detach(ViewGroup viewGroup) {
        if (!this.f42877b) {
            return false;
        }
        this.f42877b = false;
        onDetach();
        return true;
    }

    public View getView() {
        return this.f42876a;
    }

    public FilterModel getFilterModel() {
        return this.f42878c;
    }

    /* access modifiers changed from: protected */
    public void doConfirm(boolean z, boolean z2) {
        OnFilterPanelEvent onFilterPanelEvent = this.mOnFilterPanelEvent;
        if (onFilterPanelEvent != null) {
            onFilterPanelEvent.onConfirm(this, z, z2);
        }
    }
}
