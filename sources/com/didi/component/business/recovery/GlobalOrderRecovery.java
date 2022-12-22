package com.didi.component.business.recovery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.component.business.bizconfig.BizConfigFacade;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.common.base.CompSceneUtil;
import com.didi.component.core.Animations;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.bff.BffService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.service.CoreHttpRequest;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didiglobal.travel.biz.ride.CarOrderUtils;
import com.taxis99.R;
import java.util.Map;

public class GlobalOrderRecovery {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f11331d = false;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public BusinessContext f11332a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f11333b;

    /* renamed from: c */
    private String f11334c;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Logger f11335e = LoggerFactory.getLogger(getClass());

    public GlobalOrderRecovery(BusinessContext businessContext) {
        this.f11332a = businessContext;
        this.f11333b = businessContext.getContext();
    }

    public void onCurrentOrderRecovery(Intent intent, int i) {
        recovery(intent, i);
        if (!GlobalApolloUtil.isBffStageNewFifth()) {
            updateSafeSwitch(intent);
        } else {
            BffService.getSafetyConfig(DIDIApplication.getAppContext());
        }
    }

    public void onNoOrderRecovery(Intent intent) {
        CarOrderHelper.saveOrder((CarOrder) null);
        if (!GlobalApolloUtil.isBffStageNewFifth()) {
            updateSafeSwitch(intent);
        } else {
            BffService.getSafetyConfig(DIDIApplication.getAppContext());
        }
    }

    public void updateSafeSwitch(Intent intent) {
        Map map = (Map) intent.getExtras().get("extra");
        String stringExtra = intent.getStringExtra("oid");
        if (TextUtil.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("orderId");
        }
        if (map != null) {
            try {
                String str = map.get("is_reporting_police") + "";
                GlobalSPUtil.setSFIsReportingPolice(this.f11333b, m7649a(str));
                GlobalSPUtil.setSFHavePassedOrderRecent(this.f11333b, m7649a(map.get("have_passed_order_recent") + ""));
                GlobalSPUtil.setSFHaveRidingOrderSwitch(this.f11333b, m7649a(map.get("have_riding_order_switch") + ""));
                LocalBroadcastManager.getInstance(this.f11333b).sendBroadcast(new Intent(BaseEventKeys.SafeToolkit.ACTION_UPDATE_SAFETY_SWITCH));
                if (m7649a(str)) {
                    SafeToolKit.getIns().showRecoverPoliceDialog(this.f11333b, stringExtra);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private boolean m7649a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        double d = 0.0d;
        try {
            d = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (d == 1.0d) {
            return true;
        }
        return false;
    }

    public void onHistoryOrderRecovery(Intent intent) {
        recovery(intent, 1);
    }

    public void recovery(Intent intent, int i) {
        String stringExtra = intent.getStringExtra("oid");
        if (TextUtil.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("orderId");
        }
        int intExtra = intent.getIntExtra("product_id", 0);
        if (GlobalApolloUtil.isBffStageNewFifth()) {
            this.f11334c = intent.getStringExtra("order_detail");
        }
        recovery(intExtra, stringExtra, i);
    }

    public void recovery(final int i, String str, final int i2) {
        TravelUtil.checkAndStoreOid(str, "GlobalOrderRecovery.recovery");
        if (f11331d && i2 != 1) {
            this.f11335e.warn("recovery is in progress, avoid duplicate request", new Object[0]);
        } else if (this.f11332a == null || this.f11333b == null) {
            this.f11335e.info("recovery detail busineSsscontext is null", new Object[0]);
        } else {
            if (CarOrderHelper.getOrder() != null) {
                this.f11335e.info("recovery detail recoveryOrderDetail carorder is not null .", new Object[0]);
                CarOrderHelper.saveOrder((CarOrder) null);
            }
            f11331d = true;
            showProgressDialog();
            if (!GlobalApolloUtil.isBffStageNewFifth() || TextUtils.isEmpty(this.f11334c)) {
                TravelUtil.getOrderDetail((Session) null, str, new ITravelOrderListener() {
                    public void onSuccess(ICarOrder iCarOrder) {
                        Logger a = GlobalOrderRecovery.this.f11335e;
                        a.info("recovery detail recoveryOrderDetail onSuccess " + iCarOrder, new Object[0]);
                        GlobalOrderRecovery.this.m7648a((CarOrder) iCarOrder, i, i2);
                        boolean unused = GlobalOrderRecovery.f11331d = false;
                    }

                    public void onError(int i, String str) {
                        Logger a = GlobalOrderRecovery.this.f11335e;
                        a.info("recovery detail recoveryOrderDetail onError " + i + ":" + str, new Object[0]);
                        ToastHelper.showShortInfo(GlobalOrderRecovery.this.f11333b, (int) R.string.car_get_order_detail_fail);
                        GlobalOrderRecovery.this.dismissProgressDialog();
                        boolean unused = GlobalOrderRecovery.f11331d = false;
                    }

                    public void onFail(int i, String str) {
                        Logger a = GlobalOrderRecovery.this.f11335e;
                        a.info("recovery detail recoveryOrderDetail onFail " + i + ":" + str, new Object[0]);
                        if (i == 700013) {
                            BaseObject baseObject = new BaseObject();
                            baseObject.errno = i;
                            baseObject.errmsg = str;
                            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Order.BIZ_ERROR, baseObject);
                        } else {
                            ToastHelper.showShortInfo(GlobalOrderRecovery.this.f11333b, (int) R.string.car_get_order_detail_fail);
                        }
                        GlobalOrderRecovery.this.dismissProgressDialog();
                        boolean unused = GlobalOrderRecovery.f11331d = false;
                    }

                    public void onTimeout(String str) {
                        Logger a = GlobalOrderRecovery.this.f11335e;
                        a.info("recovery detail recoveryOrderDetail onTimeout " + str, new Object[0]);
                        if (!TextUtils.isEmpty(str)) {
                            ToastHelper.showShortInfo(GlobalOrderRecovery.this.f11333b, str);
                        } else {
                            ToastHelper.showShortInfo(GlobalOrderRecovery.this.f11333b, (int) R.string.car_get_order_detail_fail);
                        }
                        GlobalOrderRecovery.this.dismissProgressDialog();
                        boolean unused = GlobalOrderRecovery.f11331d = false;
                    }
                });
                return;
            }
            DTSDKOrderDetail dTSDKOrderDetail = new DTSDKOrderDetail();
            dTSDKOrderDetail.parse(this.f11334c);
            CarOrder parseCarOrder = CoreHttpRequest.parseCarOrder(dTSDKOrderDetail);
            if (parseCarOrder != null) {
                Store.getOrCreateStore(TravelUtil.generateCarOrderStoreKey(parseCarOrder.oid)).setStore(Store.S_NONE_INVOKE_ARGS, parseCarOrder);
            } else {
                LogUtils.m31492e("GlobalOrderRecovery", "recovery:carOrder is null");
            }
            m7648a(parseCarOrder, i, i2);
            f11331d = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7648a(CarOrder carOrder, int i, int i2) {
        if (carOrder == null) {
            dismissProgressDialog();
            Context context = this.f11333b;
            ToastHelper.showShortInfo(context, ResourcesHelper.getString(context, R.string.global_history_order_error));
            return;
        }
        FormStore.getInstance().setStartAddress(carOrder.startAddress);
        FormStore.getInstance().setEndAddress(carOrder.endAddress);
        FormStore.getInstance().setCurrentComboType(carOrder.comboType);
        FormStore.getInstance().setTwoPriceBiz(carOrder.isTwoPriceScene());
        int i3 = -1;
        if (!TextUtil.isEmpty(carOrder.carPoolOrderScene)) {
            i3 = NumberUtil.parseInt(carOrder.carPoolOrderScene);
        }
        FormStore.getInstance().setCarpoolOrderScene(i3);
        GlobalOmegaUtils.setOrderType(carOrder.orderType);
        Bundle bundle = new Bundle();
        if (i > 0) {
            bundle.putInt(BaseExtras.Common.EXTRA_CURRENT_BID, i);
        }
        bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
        bundle.putInt(BaseExtras.Common.EXTRA_CURRENT_COMBOTYPE, carOrder.comboType);
        if (i2 == 1 || i2 == 3) {
            bundle.putInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 1);
            carOrder.orderSource = i2;
        } else {
            bundle.putInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, i2);
            carOrder.orderSource = i2;
        }
        DDTravelOrderStore.setOrder(carOrder);
        bundle.putString(TravelConstant.EXTRA_ORDER_ID, carOrder.oid);
        BizConfigFacade instance = BizConfigFacade.getInstance();
        BusinessContext businessContext = this.f11332a;
        instance.doubleCheckBizConfig(businessContext, i + "");
        if (carOrder.splitFareInfo == null || carOrder.splitFareInfo.isOwner() || carOrder.splitFareInfo.split_status != 0) {
            bundle.putSerializable(BaseExtras.Common.EXTRA_ORDER_BEAN, carOrder);
            switch (carOrder.status) {
                case 1:
                case 4:
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    m7646a(1010, bundle);
                    return;
                case 2:
                case 6:
                    if (6002 == carOrder.substatus) {
                        bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
                    }
                    bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    m7646a(1015, bundle);
                    return;
                case 3:
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    if (2001 == carOrder.substatus) {
                        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_DETAIL, true);
                    } else {
                        bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 1);
                    }
                    m7646a(1015, bundle);
                    NotificationUtils.getInstance(this.f11333b).hideNotification();
                    return;
                case 5:
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 3);
                    if (5001 == carOrder.substatus) {
                        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_DETAIL, true);
                    } else {
                        bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
                    }
                    m7646a(1015, bundle);
                    return;
                case 7:
                    if (CarOrderUtils.isInBooking(carOrder)) {
                        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                        m7646a(1025, bundle);
                        return;
                    }
                    m7646a(1005, bundle);
                    return;
                default:
                    dismissProgressDialog();
                    return;
            }
        } else {
            dismissProgressDialog();
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.Home.SPLIT_FARE_SHOW_ACCEPT_WINDOW, carOrder);
        }
    }

    /* renamed from: a */
    private void m7646a(final int i, final Bundle bundle) {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                int i = i;
                int pageIdtoScene = CompSceneUtil.pageIdtoScene(i);
                if (pageIdtoScene != -1) {
                    bundle.putInt(BaseExtras.Trip.EXTRA_TRIP_SCENE, pageIdtoScene);
                    i = 1040;
                }
                TravelUtil.getBundleOnCreateSession(bundle, true, "recovery", true);
                GlobalOrderRecovery.this.dismissProgressDialog();
                GlobalOmegaUtils.setBusinessId(GlobalOrderRecovery.this.f11332a);
                Class cls = IPresenter.templateMapping.get(Integer.valueOf(i));
                if (cls != null) {
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(GlobalOrderRecovery.this.f11332a.getContext(), cls);
                    Animations animations = new Animations();
                    GlobalOrderRecovery.this.f11332a.getNavigation().transition(GlobalOrderRecovery.this.f11332a, intent, new INavigation.TransactionAnimation(animations.enterAnim(), animations.exitAnim(), animations.enterPopAnim(), animations.exitPopAnim()));
                }
            }
        }, 1000);
    }

    public void showProgressDialog() {
        BaseEventPublisher.getPublisher().publish("event_show_loading_on_titlebar_in_home");
    }

    public void dismissProgressDialog() {
        BaseEventPublisher.getPublisher().publish("event_hide_loading_on_titlebar_in_home");
    }
}
