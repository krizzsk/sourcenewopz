package com.didi.entrega.home.component.city;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewBinder;
import com.didi.entrega.customer.widget.titlebar.OnBackClickListener;
import com.didi.entrega.customer.widget.titlebar.TitleBarView;
import com.didi.entrega.home.component.city.binder.HomeCityItemBinder;
import com.didi.entrega.home.component.city.binder.HomeCityTitleBinder;
import com.didi.entrega.home.component.city.model.HomeCityItemRvModel;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;
import com.taxis99.R;

public class HomeCityListView extends CustomerRecyclerView<HomeCityListPresenter> {
    @BindView(16941)
    NovaRecyclerView mRecyclerView;
    @BindView(16947)
    TitleBarView mTitleBarView;

    /* access modifiers changed from: protected */
    public boolean useLinearLayout() {
        return true;
    }

    public void onCreate() {
        super.onCreate();
        this.mTitleBarView.setOnBackClickListener(new OnBackClickListener() {
            public final void onBackClick(View view) {
                HomeCityListView.this.m15099a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15099a(View view) {
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
                HomeOtherOmegaHelper.trackOpenedCityListCK(homeCityItemRvModel);
            }
        });
        registerBinder(new AbnormalViewBinder());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.entrega_component_city_list, viewGroup, true);
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
}
