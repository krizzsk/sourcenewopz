package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xpanel.sdk.IGlobalXPanelControllerInflater;
import com.didi.component.business.xpanel.sdk.controllers.IXPanelServiceCardController;
import com.didi.component.common.util.LocationUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.IUnableCityContainerView;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.misconfig.p153v2.SecondConfProxy;
import com.didi.sdk.monitor.GlobalPaxTechTracker;
import com.didi.sdk.util.permission.PermissionActivity;
import com.didi.sdk.util.permission.PermissionCallback;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestCallback;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestManager;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.Map;

public class HomeUnableCityPresenter extends AbsUnableCityPresenter implements IGlobalXPanelControllerInflater<IXPanelServiceCardController> {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16176a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            HomeUnableCityPresenter.this.showUnenableCityIfNeed();
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<OrderBanCardInfo> f16177b = new BaseEventPublisher.OnEventListener<OrderBanCardInfo>() {
        public void onEvent(String str, OrderBanCardInfo orderBanCardInfo) {
            HomeUnableCityPresenter.this.showOrderBanView(orderBanCardInfo);
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<SafetyTrainCardInfo> f16178c = new BaseEventPublisher.OnEventListener<SafetyTrainCardInfo>() {
        public void onEvent(String str, SafetyTrainCardInfo safetyTrainCardInfo) {
            HomeUnableCityPresenter.this.showSafetyTrainView(safetyTrainCardInfo);
        }
    };

    /* renamed from: d */
    private boolean f16179d = false;

    public HomeUnableCityPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m11873d();
        m11870b();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        m11873d();
        m11870b();
    }

    /* renamed from: b */
    private void m11870b() {
        subscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f16176a);
        subscribe(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, this.f16177b);
        subscribe(BaseEventKeys.Home.SAFETY_TRAIN_CARD_INFO, this.f16178c);
    }

    /* renamed from: c */
    private void m11871c() {
        unsubscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f16176a);
        unsubscribe(BaseEventKeys.Home.ORDER_BAN_CARD_INFO, this.f16177b);
        unsubscribe(BaseEventKeys.Home.SAFETY_TRAIN_CARD_INFO, this.f16178c);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        m11871c();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m11871c();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11873d() {
        showUnenableCityIfNeed();
        showOpenPositionDialog();
    }

    /* access modifiers changed from: protected */
    public void showUnenableCityIfNeed() {
        if (!FormStore.getInstance().isOrderBan() && !FormStore.getInstance().isSafetyTrain()) {
            if (this.mBizContext != null && LocationUtils.parseLocation(this.mContext) != 0) {
                addViewToXpanel();
                showNoOpenPositionView();
            } else if (this.mBizContext != null && BusinessUtils.isPreHeat(this.mBizContext)) {
                addViewToXpanel();
                showPreHeatView();
            } else if (this.mBizContext == null || SecondConfProxy.getInstance().isCityOpen(this.mBizContext.getBusinessGroupType())) {
                removeviewFromXpanel();
                if (this.f16179d) {
                    this.f16179d = false;
                    GlobalPaxTechTracker.getInstance().trackUnableCity(false);
                }
            } else {
                addViewToXpanel();
                showUnopenedView();
                HashMap hashMap = new HashMap();
                hashMap.put("city", NationComponentDataUtil.getLocCityId());
                GlobalOmegaUtils.trackEvent("gp_home_unenableCity_sw", (Map<String, Object>) hashMap);
                if (!this.f16179d) {
                    this.f16179d = true;
                    GlobalPaxTechTracker.getInstance().trackUnableCity(true);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setNoPositionClickEvent() {
        ((IUnableCityContainerView) this.mView).setNoPositionEnableListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (HomeUnableCityPresenter.this.mContext instanceof FragmentActivity) {
                    PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog((FragmentActivity) HomeUnableCityPresenter.this.mContext, PrivacyTypeEnum.LOCATION, new PrivacyDisclosureBaseDialog.Callback() {
                        public void onNegativeResult() {
                        }

                        public void onPositiveResult(PositiveResultReason positiveResultReason) {
                            HomeUnableCityPresenter.this.m11876e();
                        }
                    });
                } else {
                    HomeUnableCityPresenter.this.m11876e();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("action", 1);
                GlobalOmegaUtils.trackEvent("map_loc_home_page_card_ck", (Map<String, Object>) hashMap);
            }
        });
        ((IUnableCityContainerView) this.mView).setNoPositionManualEnterListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("action", 0);
                GlobalOmegaUtils.trackEvent("map_loc_home_page_card_ck", (Map<String, Object>) hashMap);
                HomeUnableCityPresenter.this.gotoSugPage();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m11876e() {
        if (!LocationUtils.isLocationPermissionGranted(this.mContext) && Build.VERSION.SDK_INT >= 23 && ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.mContext, Permission.ACCESS_FINE_LOCATION)) {
            PermissionActivity.request(this.mContext, new String[]{Permission.ACCESS_FINE_LOCATION}, new PermissionCallback() {
                public void onPermissionGranted() {
                    HomeUnableCityPresenter.this.m11873d();
                    HashMap hashMap = new HashMap();
                    hashMap.put("action", 1);
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("map_loc_permission_ck", (Map<String, Object>) hashMap);
                }

                public void onPermissionReject(String str) {
                    HashMap hashMap = new HashMap();
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) HomeUnableCityPresenter.this.mContext, Permission.ACCESS_FINE_LOCATION)) {
                        hashMap.put("action", 0);
                    } else {
                        hashMap.put("action", -1);
                    }
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("map_loc_permission_ck", (Map<String, Object>) hashMap);
                }
            });
        } else if (!LocationUtils.isLocationPermissionGranted(this.mContext) && Build.VERSION.SDK_INT >= 23 && !ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.mContext, Permission.ACCESS_FINE_LOCATION)) {
            DRouter.build("taxis99onetravel://one/syssettings?permission=android.permission.ACCESS_FINE_LOCATION&type=2").start(this.mContext);
        } else if (LocationUtils.isLocationPermissionGranted(this.mContext)) {
            showOpenPositionDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void showOpenPositionDialog() {
        if (LocationUtils.isLocationPermissionGranted(this.mContext)) {
            LocationSettingRequestManager.getInstance().checkSettingRequest((Activity) this.mContext, new LocationSettingRequestCallback() {
                public void onFailed() {
                }

                public /* synthetic */ void onFailed(boolean z) {
                    LocationSettingRequestCallback.CC.$default$onFailed(this, z);
                }

                public void onSuccess() {
                }
            });
        }
    }

    public void inflateController(IXPanelServiceCardController iXPanelServiceCardController) {
        this.mXpanelController = iXPanelServiceCardController;
    }
}
