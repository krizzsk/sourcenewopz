package com.didi.soda.home.component.city;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCityEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCountryEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCountryListEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.home.component.city.model.HomeCityItemRvModel;
import com.didi.soda.home.component.city.model.HomeCityTitleRvModel;
import com.didi.soda.home.manager.HomeSimpleOmegaHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeCityListPresenter extends CustomerRecyclerPresenter<HomeCityListView> {

    /* renamed from: a */
    private static final String f42574a = "HomeCityListPresenter";

    /* renamed from: b */
    private String f42575b;

    /* renamed from: c */
    private int f42576c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ChildDataListManager<RecyclerModel> f42577d;

    public void reverseLocation(HomeCityItemRvModel homeCityItemRvModel) {
        HomeSimpleOmegaHelper.trackHomeCityListCK(this.f42576c);
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByCityInfo(homeCityItemRvModel.mLat, homeCityItemRvModel.mLng, homeCityItemRvModel.mCityId);
        getScopeContext().getNavigator().popToRoot();
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f42577d == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f42577d = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    public void onCreate() {
        super.onCreate();
        m30039a();
        m30043b();
        ((HomeCityListView) getLogicView()).setTitle(this.f42575b);
        HomeSimpleOmegaHelper.trackHomeCityListSW(this.f42576c);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m30039a() {
        Bundle bundle = getScopeContext().getBundle();
        this.f42575b = bundle.getString("param_title");
        this.f42576c = bundle.getInt("param_error_code", 0);
    }

    /* renamed from: b */
    private void m30043b() {
        ((HomeCityListView) getLogicView()).showLoadingView();
        CustomerRpcManagerProxy.get().getServiceCityList(new CustomerRpcCallback<HomeServiceCountryListEntity>() {
            public void onRpcSuccess(HomeServiceCountryListEntity homeServiceCountryListEntity, long j) {
                ((HomeCityListView) HomeCityListPresenter.this.getLogicView()).dismissLoadingDialog();
                List a = HomeCityListPresenter.this.m30037a(homeServiceCountryListEntity);
                if (CollectionsUtil.isEmpty(a)) {
                    HomeCityListPresenter.this.m30042a(ResourceHelper.getString(R.string.customer_get_data_failure));
                    return;
                }
                HomeCityListPresenter.this.f42577d.clear();
                HomeCityListPresenter.this.f42577d.addAll(a);
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                ((HomeCityListView) HomeCityListPresenter.this.getLogicView()).dismissLoadingDialog();
                String string = HomeCityListPresenter.this.getContext().getResources().getString(R.string.customer_service_not_connected);
                if (sFRpcException != null && !TextUtils.isEmpty(sFRpcException.getMessage())) {
                    string = sFRpcException.getMessage();
                }
                HomeCityListPresenter.this.m30042a(string);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30042a(String str) {
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel.mHeight = -1;
            topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeCityListPresenter.this.m30044b(view);
                }
            }));
            this.f42577d.clear();
            this.f42577d.add(topGunAbnormalRvModel);
            return;
        }
        TopGunAbnormalRvModel topGunAbnormalRvModel2 = new TopGunAbnormalRvModel();
        topGunAbnormalRvModel2.mHeight = -1;
        topGunAbnormalRvModel2.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeCityListPresenter.this.m30040a(view);
            }
        }));
        this.f42577d.clear();
        this.f42577d.add(topGunAbnormalRvModel2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30044b(View view) {
        m30043b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30040a(View view) {
        m30043b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<RecyclerModel> m30037a(HomeServiceCountryListEntity homeServiceCountryListEntity) {
        ArrayList arrayList = new ArrayList();
        if (homeServiceCountryListEntity != null && !CollectionsUtil.isEmpty(homeServiceCountryListEntity.countryList)) {
            int size = homeServiceCountryListEntity.countryList.size();
            int i = 0;
            for (HomeServiceCountryEntity next : homeServiceCountryListEntity.countryList) {
                if (next != null && !CollectionsUtil.isEmpty(next.cities)) {
                    arrayList.add(new HomeCityTitleRvModel(next.countryName));
                    int size2 = next.cities.size();
                    int i2 = 0;
                    for (HomeServiceCityEntity homeCityItemRvModel : next.cities) {
                        arrayList.add(new HomeCityItemRvModel(homeCityItemRvModel, true ^ (i2 == size2 + -1 && i != size + -1)));
                        i2++;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }
}
