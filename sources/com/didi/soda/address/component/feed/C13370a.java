package com.didi.soda.address.component.feed;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.address.component.feed.Contract;
import com.didi.soda.address.component.feed.binder.DeliveryAddressRvModel;
import com.didi.soda.address.manager.AddressMessageRepo;
import com.didi.soda.address.omega.AddressOmegaHelper;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressPageListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.tracker.performance.PageRenderingTrackerNew;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.helper.CustomerLocationSettingHelper;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* renamed from: com.didi.soda.address.component.feed.a */
/* compiled from: AddressFeedMessagePresenter */
class C13370a extends Contract.AbsAddressFeedMessagePresenter {

    /* renamed from: a */
    private static final String f38665a = "AddressFeedMessagePresenter";

    /* renamed from: b */
    private int f38666b;

    /* renamed from: c */
    private boolean f38667c;

    /* renamed from: d */
    private HomeAddressEntity f38668d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ChildDataListManager<RecyclerModel> f38669e;

    /* renamed from: f */
    private DeliveryAddressRvModel f38670f;

    /* renamed from: g */
    private DeliveryAddressRvModel f38671g;

    /* renamed from: h */
    private AddressFeedOmegaHelper f38672h;

    C13370a() {
    }

    public void onCreate() {
        super.onCreate();
        if (this.f38669e == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f38669e = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
        m27379b();
        AddressFeedOmegaHelper instance = AddressFeedOmegaHelper.getInstance();
        this.f38672h = instance;
        instance.attach(getScopeContext());
        m27367a();
        m27385c();
        this.f38672h.openAddressHomePage(this.f38666b, m27394l(), m27393k());
    }

    public void onResume() {
        if (!this.f38667c) {
            this.f38667c = true;
            return;
        }
        PageRenderingTrackerNew.Companion.trackExceptionUtil(getScopeContext());
        getAddressAllList();
        CustomerLocationSettingHelper.Companion.getInstance().updateWindowShownStatus(getContext(), 5, (Function2<? super Boolean, ? super Boolean, Unit>) null);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f38672h.detach(getScopeContext());
    }

    public void getAddressAllList() {
        m27389g();
    }

    public void goLogin() {
        LoginUtil.updateLoginPopToRootStatus(false);
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 10);
    }

    public void onAddressClick(AddressEntity addressEntity, int i, int i2) {
        if (AddressUtil.checkAddressValid(addressEntity)) {
            AddressFeedOmegaHelper addressFeedOmegaHelper = this.f38672h;
            String str = addressEntity.aid;
            String str2 = addressEntity.poi.poiId;
            String str3 = addressEntity.poi.poiType;
            boolean k = m27393k();
            ChildDataListManager<RecyclerModel> childDataListManager = this.f38669e;
            addressFeedOmegaHelper.trackActionOnAddress(i, str, str2, str3, k, i2, childDataListManager == null ? 0 : childDataListManager.size());
            if (m27386d()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("entity", addressEntity);
                getScopeContext().getNavigator().finish(bundle);
                return;
            }
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(addressEntity, m27388f() ? 9 : 1);
            getScopeContext().getNavigator().finish();
        }
    }

    public void onAddressDeleteClick(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
        if (deliveryAddressRvModel != null && AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            DialogUtil.showAddressDeleteDialog(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener(deliveryAddressRvModel, i) {
                public final /* synthetic */ DeliveryAddressRvModel f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(RFDialog rFDialog) {
                    C13370a.this.m27373a(this.f$1, this.f$2, rFDialog);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27373a(DeliveryAddressRvModel deliveryAddressRvModel, int i, RFDialog rFDialog) {
        if (AddressUtil.checkAddressEqualCurrent(deliveryAddressRvModel.mAddress)) {
            ((Contract.AbsAddressFeedMessageView) getLogicView()).showAddressUnableDeleteDialog();
        } else {
            m27372a(deliveryAddressRvModel, i);
        }
        rFDialog.dismiss();
    }

    public void onAddressEditClick(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
        if (!LoginUtil.isLogin()) {
            goLogin();
        } else if (deliveryAddressRvModel == null || ClickUtils.isFastClick()) {
        } else {
            if (!m27386d() || !deliveryAddressRvModel.mIsChecked) {
                DiRouter.request().path(RoutePath.ADDRESS_EDIT).putSerializable(Const.PageParams.ADDRESS_ENTITY, deliveryAddressRvModel.mAddress).putInt("from", 0).putBoolean(Const.PageParams.CHECK_STATUS, deliveryAddressRvModel.mIsChecked).open();
                if (AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
                    AddressOmegaHelper.trackAddressEditCk(deliveryAddressRvModel.mAddress.poi.poiId, deliveryAddressRvModel.mAddress.aid, i);
                    return;
                }
                return;
            }
            int i2 = -1;
            ChildDataListManager<RecyclerModel> childDataListManager = this.f38669e;
            if (childDataListManager != null) {
                i2 = childDataListManager.indexOf(deliveryAddressRvModel);
            }
            onAddressClick(deliveryAddressRvModel.mAddress, deliveryAddressRvModel.addressType, i2);
        }
    }

    public void onOpenLocation() {
        CustomerLocationSettingHelper.Companion.getInstance().startLocationSettingRequest((Activity) GlobalContext.getContext(), 5, (CustomerLocationSettingHelper.ILocationSettingRequestCallback) null);
        this.f38672h.trackOpenGps(this.f38666b, true);
    }

    public void onRetryLocation() {
        AddressOmegaHelper.clickRefreshLocateAddress(this.f38670f.mAddress, this.f38666b);
        LocationUtil.getCurrentLocationOnce(new AddressFeedMessagePresenter$1(this));
    }

    public void onOpenLocationPermission() {
        LogUtil.m29104i(f38665a, "onOpenLocationPermission");
        LocalPermissionHelper.openPermissionSetting((Activity) GlobalContext.getContext());
        this.f38672h.trackOpenGps(this.f38666b, false);
    }

    /* renamed from: a */
    public void mo98340a(int i, String str) {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f38670f;
        if (deliveryAddressRvModel == null || this.f38669e.indexOf(deliveryAddressRvModel) < 0) {
            m27391i();
            TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
            topGunAbnormalRvModel.mHeight = -1;
            if (NetWorkUtils.isNetworkConnected(getContext())) {
                topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildHomeNoService(str, new View.OnClickListener() {
                    public final void onClick(View view) {
                        C13370a.this.m27380b(view);
                    }
                }));
            } else {
                topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
                    public final void onClick(View view) {
                        C13370a.this.m27368a(view);
                    }
                }));
            }
            this.f38669e.add(topGunAbnormalRvModel);
        } else if (i == -1) {
            ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.customer_get_data_failure));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27380b(View view) {
        getAddressAllList();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27368a(View view) {
        getAddressAllList();
    }

    /* renamed from: a */
    private void m27367a() {
        AddressPageListEntity addressPageListEntity;
        Bundle bundle = getScopeContext().getBundle();
        this.f38666b = bundle.getInt("from", -1);
        if (m27387e()) {
            addressPageListEntity = (AddressPageListEntity) bundle.getSerializable("entity");
            this.f38668d = addressPageListEntity.deliveryAddress;
        } else {
            this.f38668d = new HomeAddressEntity();
            if (m27386d()) {
                this.f38668d.address = (AddressEntity) bundle.getSerializable("entity");
            } else {
                this.f38668d.address = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
            }
            addressPageListEntity = null;
        }
        if (addressPageListEntity != null) {
            PageRenderingTrackerNew.Companion.trackExceptionUtil(getScopeContext());
            m27374a(addressPageListEntity);
            return;
        }
        getAddressAllList();
    }

    /* renamed from: b */
    private void m27379b() {
        if (!m27393k() || !m27394l()) {
            DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel((HomeAddressEntity) null, m27393k(), m27394l(), false, true);
            this.f38670f = buildLocationAddressRvModel;
            this.f38669e.add(buildLocationAddressRvModel);
        }
    }

    /* renamed from: c */
    private void m27385c() {
        ((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).subscribeAddressDragStatus(getScopeContext(), new AddressFeedMessagePresenter$2(this));
    }

    /* renamed from: d */
    private boolean m27386d() {
        int i = this.f38666b;
        return i == 4 || i == 9;
    }

    /* renamed from: e */
    private boolean m27387e() {
        return this.f38666b == 5;
    }

    /* renamed from: f */
    private boolean m27388f() {
        return this.f38666b == 8;
    }

    /* renamed from: g */
    private void m27389g() {
        ((Contract.AbsAddressFeedMessageView) getLogicView()).showLoading();
        HomeAddressEntity homeAddressEntity = this.f38668d;
        boolean z = homeAddressEntity != null && AddressUtil.checkAddressValid(homeAddressEntity.address);
        CustomerRpcManagerProxy.get().getAddressAndHistoryList(z ? this.f38668d.address.poi : null, z ? this.f38668d.address.aid : "", new AddressFeedMessagePresenter$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m27390h() {
        CustomerRpcManagerProxy.get().getAddressByLocation(new AddressFeedMessagePresenter$4(this));
    }

    /* renamed from: a */
    private void m27372a(DeliveryAddressRvModel deliveryAddressRvModel, int i) {
        if (deliveryAddressRvModel != null && deliveryAddressRvModel.mAddress != null) {
            AddressEntity addressEntity = deliveryAddressRvModel.mAddress;
            CustomerRpcManagerProxy.get().deleteAddress(TextUtils.isEmpty(addressEntity.aid) ? addressEntity.poi.poiId : addressEntity.aid, new AddressFeedMessagePresenter$5(this));
            int indexOf = this.f38669e.indexOf(deliveryAddressRvModel);
            if (indexOf >= 0 && indexOf < this.f38669e.size()) {
                this.f38669e.remove(indexOf);
            }
            if (AddressUtil.checkAddressValid(addressEntity)) {
                AddressOmegaHelper.trackAddressDeleteCk(addressEntity.poi.poiId, addressEntity.aid, i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27374a(AddressPageListEntity addressPageListEntity) {
        String str;
        if (addressPageListEntity == null) {
            this.f38672h.resetAddressTrackerNum(this.f38666b, (String) null, (List<AddressEntity>) null);
            return;
        }
        boolean z = false;
        if (addressPageListEntity.deliveryAddress == null || !AddressUtil.checkAddressValid(addressPageListEntity.deliveryAddress.address)) {
            str = "";
        } else {
            str = addressPageListEntity.deliveryAddress.address.getAid();
            if (addressPageListEntity.locationAddress != null) {
                z = m27378a(addressPageListEntity.locationAddress.address, addressPageListEntity.deliveryAddress.address);
            }
        }
        m27391i();
        m27375a(addressPageListEntity, str);
        m27377a(addressPageListEntity.deliveryAddress, z);
        m27376a(z ? addressPageListEntity.deliveryAddress : addressPageListEntity.locationAddress);
        this.f38672h.resetAddressTrackerNum(this.f38666b, addressPageListEntity.recid, addressPageListEntity.historyAddressList);
        AddressOmegaHelper.trackRealexposureSw(addressPageListEntity);
    }

    /* renamed from: a */
    private void m27375a(AddressPageListEntity addressPageListEntity, String str) {
        List<DeliveryAddressRvModel> buildHistoryAddressRvModelList = DeliveryAddressRvModel.buildHistoryAddressRvModelList(addressPageListEntity.historyAddressList, str);
        if (!CollectionsUtil.isEmpty(buildHistoryAddressRvModelList)) {
            this.f38669e.addAll(buildHistoryAddressRvModelList);
        }
    }

    /* renamed from: a */
    private void m27377a(HomeAddressEntity homeAddressEntity, boolean z) {
        if (!z) {
            DeliveryAddressRvModel buildCurAddressRvModel = DeliveryAddressRvModel.buildCurAddressRvModel(homeAddressEntity, this.f38669e.size() == 0);
            this.f38671g = buildCurAddressRvModel;
            if (buildCurAddressRvModel != null) {
                this.f38669e.add(0, buildCurAddressRvModel);
                return;
            }
            return;
        }
        this.f38671g = null;
    }

    /* renamed from: a */
    private void m27376a(HomeAddressEntity homeAddressEntity) {
        AddressEntity addressEntity = null;
        AddressEntity addressEntity2 = homeAddressEntity != null ? homeAddressEntity.address : null;
        HomeAddressEntity homeAddressEntity2 = this.f38668d;
        if (homeAddressEntity2 != null) {
            addressEntity = homeAddressEntity2.address;
        }
        DeliveryAddressRvModel buildLocationAddressRvModel = DeliveryAddressRvModel.buildLocationAddressRvModel(homeAddressEntity, m27393k(), m27394l(), m27378a(addressEntity2, addressEntity), this.f38669e.size() == 0);
        this.f38670f = buildLocationAddressRvModel;
        this.f38669e.add(0, buildLocationAddressRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27382b(HomeAddressEntity homeAddressEntity) {
        AddressEntity addressEntity = null;
        AddressEntity addressEntity2 = homeAddressEntity != null ? homeAddressEntity.address : null;
        boolean z = true;
        if (AddressUtil.checkAddressValid(addressEntity2)) {
            HomeAddressEntity homeAddressEntity2 = this.f38668d;
            if (homeAddressEntity2 != null) {
                addressEntity = homeAddressEntity2.address;
            }
            boolean a = m27378a(addressEntity2, addressEntity);
            HomeAddressEntity homeAddressEntity3 = new HomeAddressEntity();
            homeAddressEntity3.address = addressEntity;
            m27383b(homeAddressEntity3, a);
            if (this.f38669e.size() != 1) {
                z = false;
            }
            this.f38670f = DeliveryAddressRvModel.buildLocationAddressRvModel(homeAddressEntity, m27393k(), m27394l(), a, z);
        } else {
            if (this.f38669e.size() != 1) {
                z = false;
            }
            this.f38670f.setGpsEnable(m27393k(), m27394l(), z);
        }
        this.f38669e.set(0, this.f38670f);
    }

    /* renamed from: b */
    private void m27383b(HomeAddressEntity homeAddressEntity, boolean z) {
        if (z) {
            DeliveryAddressRvModel deliveryAddressRvModel = this.f38671g;
            if (deliveryAddressRvModel != null) {
                int indexOf = this.f38669e.indexOf(deliveryAddressRvModel);
                if (indexOf >= 0 && indexOf < this.f38669e.size()) {
                    this.f38669e.remove(indexOf);
                }
                this.f38671g = null;
            }
        } else if (this.f38671g == null) {
            DeliveryAddressRvModel buildCurAddressRvModel = DeliveryAddressRvModel.buildCurAddressRvModel(homeAddressEntity, this.f38669e.size() == 1);
            this.f38671g = buildCurAddressRvModel;
            if (buildCurAddressRvModel != null) {
                this.f38669e.add(1, buildCurAddressRvModel);
            }
        }
    }

    /* renamed from: i */
    private void m27391i() {
        this.f38669e.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m27392j() {
        DeliveryAddressRvModel deliveryAddressRvModel = this.f38670f;
        if (deliveryAddressRvModel != null && AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.customer_address_gps_no_location));
        }
    }

    /* renamed from: k */
    private boolean m27393k() {
        return CustomerSystemUtil.isGpsEnabled(getContext());
    }

    /* renamed from: l */
    private boolean m27394l() {
        return LocalPermissionHelper.checkoutPermission((Activity) GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
    }

    /* renamed from: a */
    private boolean m27378a(AddressEntity addressEntity, AddressEntity addressEntity2) {
        if (!AddressUtil.checkAddressValid(addressEntity) || !AddressUtil.checkAddressValid(addressEntity2)) {
            return false;
        }
        String str = addressEntity2.poi.poiId;
        if (!TextUtils.isEmpty(addressEntity2.getAid()) || !str.equals(addressEntity.poi.poiId) || !m27393k() || !m27394l()) {
            return false;
        }
        return true;
    }
}
