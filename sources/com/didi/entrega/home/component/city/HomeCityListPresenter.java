package com.didi.entrega.home.component.city;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.widget.abnormal.AbnormalRvModel;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.home.component.city.entity.HomeServiceCityEntity;
import com.didi.entrega.home.component.city.entity.HomeServiceCountryEntity;
import com.didi.entrega.home.component.city.entity.HomeServiceCountryListEntity;
import com.didi.entrega.home.component.city.model.HomeCityItemRvModel;
import com.didi.entrega.home.component.city.model.HomeCityTitleRvModel;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;
import com.didi.entrega.home.manager.SelectedCityInfoRepo;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerHomeManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class HomeCityListPresenter extends CustomerRecyclerPresenter<HomeCityListView> {

    /* renamed from: a */
    private String f20640a;

    /* renamed from: b */
    private int f20641b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ChildDataListManager<RecyclerModel> f20642c;

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f20642c == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f20642c = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    public void onCreate() {
        super.onCreate();
        m15093a();
        m15097b();
        ((HomeCityListView) getLogicView()).setTitle(this.f20640a);
        HomeOtherOmegaHelper.trackOpenedCityListSW();
    }

    public void reverseLocation(HomeCityItemRvModel homeCityItemRvModel) {
        ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).setValue(homeCityItemRvModel);
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByCityInfo();
        getScopeContext().getNavigator().popToRoot();
    }

    /* renamed from: a */
    private void m15093a() {
        Bundle bundle = getScopeContext().getBundle();
        this.f20640a = bundle.getString("param_title");
        this.f20641b = bundle.getInt("param_error_code", 0);
    }

    /* renamed from: b */
    private void m15097b() {
        ((HomeCityListView) getLogicView()).showLoadingView();
        CustomerRpcManagerProxy.get().getServiceCityList(new CustomerRpcCallback<HomeServiceCountryListEntity>() {
            public void onRpcSuccess(HomeServiceCountryListEntity homeServiceCountryListEntity, long j) {
                ((HomeCityListView) HomeCityListPresenter.this.getLogicView()).dismissLoadingDialog();
                List a = HomeCityListPresenter.this.m15092a(homeServiceCountryListEntity);
                if (CollectionsUtil.isEmpty(a)) {
                    HomeCityListPresenter.this.m15096a(ResourceHelper.getString(R.string.FoodC_remind_Unable_to_LXKj));
                    return;
                }
                HomeCityListPresenter.this.f20642c.clear();
                HomeCityListPresenter.this.f20642c.addAll(a);
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                ((HomeCityListView) HomeCityListPresenter.this.getLogicView()).dismissLoadingDialog();
                String string = HomeCityListPresenter.this.getContext().getResources().getString(R.string.FoodC_orderlist3_No_service_laow);
                if (sFRpcException != null && !TextUtils.isEmpty(sFRpcException.getMessage())) {
                    string = sFRpcException.getMessage();
                }
                HomeCityListPresenter.this.m15096a(string);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15096a(String str) {
        if (NetWorkUtils.isNetworkConnected(getContext())) {
            AbnormalRvModel abnormalRvModel = new AbnormalRvModel();
            abnormalRvModel.mHeight = -1;
            abnormalRvModel.setAbnormalVm(AbnormalViewModelFactory.buildNoService(str, new View.OnClickListener() {
                public final void onClick(View view) {
                    HomeCityListPresenter.this.m15098b(view);
                }
            }));
            this.f20642c.clear();
            this.f20642c.add(abnormalRvModel);
            return;
        }
        AbnormalRvModel abnormalRvModel2 = new AbnormalRvModel();
        abnormalRvModel2.mHeight = -1;
        abnormalRvModel2.setAbnormalVm(AbnormalViewModelFactory.buildNoNetwork(new View.OnClickListener() {
            public final void onClick(View view) {
                HomeCityListPresenter.this.m15094a(view);
            }
        }));
        this.f20642c.clear();
        this.f20642c.add(abnormalRvModel2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15098b(View view) {
        m15097b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15094a(View view) {
        m15097b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<RecyclerModel> m15092a(HomeServiceCountryListEntity homeServiceCountryListEntity) {
        ArrayList arrayList = new ArrayList();
        if (homeServiceCountryListEntity != null && !CollectionsUtil.isEmpty(homeServiceCountryListEntity.countryList)) {
            int size = homeServiceCountryListEntity.countryList.size();
            int i = 0;
            int i2 = 0;
            for (HomeServiceCountryEntity next : homeServiceCountryListEntity.countryList) {
                if (next != null && !CollectionsUtil.isEmpty(next.cities)) {
                    arrayList.add(new HomeCityTitleRvModel(next.countryName));
                    int size2 = next.cities.size();
                    int i3 = 0;
                    for (HomeServiceCityEntity homeCityItemRvModel : next.cities) {
                        HomeCityItemRvModel homeCityItemRvModel2 = new HomeCityItemRvModel(i2, homeCityItemRvModel, true ^ (i3 == size2 + -1 && i != size + -1));
                        homeCityItemRvModel2.mCountryCode = next.countryCode;
                        arrayList.add(homeCityItemRvModel2);
                        i3++;
                        i2++;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }
}
