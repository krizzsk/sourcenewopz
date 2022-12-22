package com.didi.soda.home.component.city;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalViewBinder;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.widget.titlebar.OnBackClickListener;
import com.didi.soda.customer.widget.titlebar.TitleBarView;
import com.didi.soda.home.component.city.binder.HomeCityItemBinder;
import com.didi.soda.home.component.city.binder.HomeCityTitleBinder;
import com.didi.soda.home.component.city.model.HomeCityItemRvModel;
import com.taxis99.R;

public class HomeCityListView extends CustomerRecyclerView<HomeCityListPresenter> {
    @BindView(18669)
    NovaRecyclerView mRecyclerView;
    @BindView(18725)
    TitleBarView mTitleBarView;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    public void dismissLoadingDialog() {
        DialogUtil.hideLoadingDialog();
    }

    public void showLoadingView() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void setTitle(String str) {
        this.mTitleBarView.setTitleText(str);
    }

    public void onCreate() {
        super.onCreate();
        this.mTitleBarView.setOnBackClickListener(new OnBackClickListener() {
            public final void onBackClick(View view) {
                HomeCityListView.this.m30045a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30045a(View view) {
        getScopeContext().getNavigator().finish();
    }

    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    public void initItemBinders() {
        registerBinder(new HomeCityTitleBinder());
        registerBinder(new HomeCityItemBinder() {
            public void clickCity(HomeCityItemRvModel homeCityItemRvModel) {
                ((HomeCityListPresenter) HomeCityListView.this.getPresenter()).reverseLocation(homeCityItemRvModel);
            }
        });
        registerBinder(new TopGunAbnormalViewBinder());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_component_city_list, viewGroup, true);
    }
}
