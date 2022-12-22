package com.didi.entrega.home.component.feed;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.customer.base.binder.ComponentLogicUnit;
import com.didi.entrega.customer.flutter.CustomerFlutterPage;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.storage.AppConfigStorage;
import com.didi.entrega.customer.foundation.storage.model.AppConfig;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.LocalPermissionHelper;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.widget.SingleChildDataListManager;
import com.didi.entrega.home.component.feed.Contract;
import com.didi.entrega.home.component.feed.entity.HomeServiceItemEntity;
import com.didi.entrega.home.component.feed.entity.ServiceRuleEntity;
import com.didi.entrega.home.manager.AddressAbnormalRepo;
import com.didi.entrega.home.manager.HomeFeedRefreshRepo;
import com.didi.entrega.home.manager.HomeFeedRepo;
import com.didi.entrega.home.manager.HomeNoServiceRepo;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;
import com.didi.entrega.home.manager.RpcLazyLoader;
import com.didi.entrega.home.manager.SelectedCityInfoRepo;
import com.didi.entrega.home.page.ServiceNotifyPage;
import com.didi.entrega.home.policy.HomePolicyHelper;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerHomeManager;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0014J\b\u0010\u001f\u001a\u00020\u0019H\u0014J\b\u0010 \u001a\u00020\u0019H\u0016J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020#H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XD¢\u0006\u0002\n\u0000¨\u0006-"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/HomeFeedPresenter;", "Lcom/didi/entrega/home/component/feed/Contract$AbsHomeFeedPresenter;", "()V", "customerHomeManager", "Lcom/didi/entrega/manager/base/ICustomerHomeManager;", "kotlin.jvm.PlatformType", "customerOrderManager", "Lcom/didi/entrega/manager/base/ICustomerOrderManager;", "mComponentLogicUnit", "Lcom/didi/entrega/customer/base/binder/ComponentLogicUnit;", "mDialogInstrument", "Lcom/didi/app/nova/skeleton/dialog/DialogInstrument;", "mFeedListManager", "Lcom/didi/entrega/customer/widget/SingleChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "mHomePolicyHelper", "Lcom/didi/entrega/home/policy/HomePolicyHelper;", "mIsLoading", "", "mServiceRuleEntity", "Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "tag", "", "checkAddressAbnormal", "fetchFeedIndex", "", "from", "", "initDataManagers", "onCreate", "onDestroy", "onResume", "onRetryAction", "onUnavailable", "data", "Lcom/didi/entrega/home/component/feed/entity/HomeServiceItemEntity;", "openPlaceOrderPage", "item", "openServiceNotifyPage", "provideComponentLogicUnit", "subscribeFeedIndex", "subscribeHomeRefresh", "syncPoi", "address", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedPresenter.kt */
public final class HomeFeedPresenter extends Contract.AbsHomeFeedPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SingleChildDataListManager<RecyclerModel> f20644a;

    /* renamed from: b */
    private ComponentLogicUnit f20645b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ServiceRuleEntity f20646c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HomePolicyHelper f20647d;

    /* renamed from: e */
    private DialogInstrument f20648e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f20649f;

    /* renamed from: g */
    private final ICustomerHomeManager f20650g = ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ICustomerOrderManager f20651h = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class));
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final String f20652i = "HomeFeedPresenter";

    public void onCreate() {
        super.onCreate();
        m15100a();
        DialogInstrument scopeDialogInstrument = DialogUtil.getScopeDialogInstrument(getScopeContext());
        this.f20648e = scopeDialogInstrument;
        HomePolicyHelper homePolicyHelper = new HomePolicyHelper(scopeDialogInstrument);
        this.f20647d = homePolicyHelper;
        if (homePolicyHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHomePolicyHelper");
            homePolicyHelper = null;
        }
        homePolicyHelper.showFirstPolicyDialog();
        m15106c();
        Contract.AbsHomeFeedView absHomeFeedView = (Contract.AbsHomeFeedView) getLogicView();
        if (absHomeFeedView != null) {
            absHomeFeedView.showShimmer();
        }
        LogUtil.m14765i(this.f20652i, "onCreate:");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f20650g.locateThenRefreshHome(2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Contract.AbsHomeFeedView absHomeFeedView = (Contract.AbsHomeFeedView) getLogicView();
        if (absHomeFeedView != null) {
            absHomeFeedView.dismissShimmer();
        }
        RepoFactory.clearRepo(HomeFeedRepo.class);
        RepoFactory.clearRepo(HomeFeedRefreshRepo.class);
        RepoFactory.clearRepo(AddressAbnormalRepo.class);
        RepoFactory.clearRepo(SelectedCityInfoRepo.class);
        RepoFactory.clearRepo(HomeNoServiceRepo.class);
        RpcLazyLoader.getLoader().mIsInit = false;
    }

    public void onRetryAction() {
        HomeOtherOmegaHelper.trackExceptionCK(1);
        this.f20650g.locateThenRefreshHome(4);
    }

    public void initDataManagers() {
        super.initDataManagers();
        SingleChildDataListManager<RecyclerModel> singleChildDataListManager = new SingleChildDataListManager<>(((Contract.AbsHomeFeedView) getLogicView()).getAdapter());
        this.f20644a = singleChildDataListManager;
        if (singleChildDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedListManager");
            singleChildDataListManager = null;
        }
        addDataManager(singleChildDataListManager);
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        if (this.f20645b == null) {
            this.f20645b = new HomeFeedPresenter$provideComponentLogicUnit$1(this);
        }
        return this.f20645b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15104a(HomeServiceItemEntity homeServiceItemEntity) {
        HomeServiceItemEntity.HomeServiceAlertEntity alert;
        if (homeServiceItemEntity != null && (alert = homeServiceItemEntity.getAlert()) != null) {
            Integer type = alert.getType();
            if (type != null && type.intValue() == 1) {
                String content = alert.getContent();
                if (content != null) {
                    ((Contract.AbsHomeFeedView) getLogicView()).showGooglePlayDialog(content);
                }
            } else if (type != null && type.intValue() == 2) {
                ((Contract.AbsHomeFeedView) getLogicView()).showBusinessServiceDialog(alert);
            } else if (!TextUtils.isEmpty(alert.getContent())) {
                ToastUtil.showCustomerToast(getScopeContext(), alert.getContent());
            }
        }
    }

    public void openServiceNotifyPage(ServiceRuleEntity serviceRuleEntity) {
        int i;
        Integer num;
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        if (data == null) {
            i = 0;
        } else {
            i = data.shownServiceRuleNum;
        }
        if (i < 1 && serviceRuleEntity != null) {
            ServiceNotifyPage.Companion.showPage(serviceRuleEntity);
            if (data == null) {
                num = null;
            } else {
                num = Integer.valueOf(data.shownServiceRuleNum);
            }
            if (num != null) {
                data.shownServiceRuleNum++;
            } else if (data != null) {
                data.shownServiceRuleNum = 1;
            }
            appConfigStorage.setData(data);
        }
    }

    public void openPlaceOrderPage(HomeServiceItemEntity homeServiceItemEntity) {
        Intrinsics.checkNotNullParameter(homeServiceItemEntity, "item");
        if (homeServiceItemEntity.getType() == 1) {
            CustomerFlutterPage.Companion.showPage();
            openServiceNotifyPage(this.f20646c);
        }
    }

    /* renamed from: a */
    private final void m15100a() {
        HomeFeedRefreshRepo.Companion.getRepo().subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                HomeFeedPresenter.m15103a(HomeFeedPresenter.this, (Integer) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15103a(HomeFeedPresenter homeFeedPresenter, Integer num) {
        Intrinsics.checkNotNullParameter(homeFeedPresenter, "this$0");
        String str = homeFeedPresenter.f20652i;
        LogUtil.m14765i(str, "subscribeHomeRefresh:" + num + " mIsLoading :" + homeFeedPresenter.f20649f);
        if (!homeFeedPresenter.f20649f && !homeFeedPresenter.m15105b()) {
            boolean z = true;
            homeFeedPresenter.f20649f = true;
            if (!((num != null && num.intValue() == 1) || (num != null && num.intValue() == 4)) && (num == null || num.intValue() != 7)) {
                z = false;
            }
            if (z) {
                Contract.AbsHomeFeedView absHomeFeedView = (Contract.AbsHomeFeedView) homeFeedPresenter.getLogicView();
                if (absHomeFeedView != null) {
                    absHomeFeedView.dismissAbnormal();
                }
                Contract.AbsHomeFeedView absHomeFeedView2 = (Contract.AbsHomeFeedView) homeFeedPresenter.getLogicView();
                if (absHomeFeedView2 != null) {
                    absHomeFeedView2.showShimmer();
                }
            }
            if (num != null) {
                homeFeedPresenter.m15101a(num.intValue());
            }
        }
    }

    /* renamed from: a */
    private final void m15101a(int i) {
        this.f20650g.fetchFeedIndex(getScopeContext(), i);
    }

    /* renamed from: b */
    private final boolean m15105b() {
        String str = this.f20652i;
        LogUtil.m14765i(str, "checkAddressAbnormal=  hasLocationPermission= " + LocalPermissionHelper.hasLocationPermission() + "hasValidLocation= " + LocationUtil.hasValidLocation() + "SelectedCityInfoRepo= " + ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue());
        if ((!LocalPermissionHelper.hasLocationPermission() || !LocationUtil.hasValidLocation()) && !SelectedCityInfoRepo.Companion.hasData()) {
            AddressAbnormalRepo.Companion.setShowStatus();
            return true;
        }
        AddressAbnormalRepo.Companion.setHiddenStatus();
        return false;
    }

    /* renamed from: c */
    private final void m15106c() {
        this.f20650g.subscribeFeedIndex(getScopeContext(), new HomeFeedPresenter$subscribeFeedIndex$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15102a(AddressEntity addressEntity) {
        SelectedCityInfoRepo.Companion.onChangeData(addressEntity);
    }
}
