package com.didi.component.mapflow.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.address.model.WayPointParam;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.ImageUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.event.ResetMapEvent;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xpanel.sdk.XPanelStore;
import com.didi.component.common.cache.CacheStore;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.AddressUtil;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.OnServiceOmegaUtil;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.MapFlowComponent;
import com.didi.component.mapflow.view.IMapFlowDelegateView;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.map.global.component.departure.controller.OrderInterceptMode;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.view.LoadingInfoWindow;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.pre.IMiniBusConfirmSceneController;
import com.didi.map.global.flow.scene.minibus.scene.pre.MiniBusConfirmSceneParam;
import com.didi.map.global.flow.scene.order.confirm.normal.IOrderConfirmController;
import com.didi.map.global.flow.scene.order.confirm.normal.OrderConfirmSceneParam;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.param.ClientParams;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.scene.sug.IPopSugSceneController;
import com.didi.map.global.flow.scene.sug.ISubmitWayPointsCallback;
import com.didi.map.global.flow.scene.sug.ISugSceneCallback;
import com.didi.map.global.flow.scene.sug.ISugTransferAnimator;
import com.didi.map.global.flow.scene.sug.PopSugSceneParam;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarMoveBean;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.MapLineInfo;
import com.didi.travel.psnger.model.response.MapModel;
import com.didi.travel.psnger.model.response.MarkerInfo;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.Elvish;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.util.SatelliteManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ConfirmMapFlowDelegatePresenter extends AbsBeforeOrderMapFlowDelegatePresenter {
    protected static final int CARPOOL_DEFAULT_RADIUS = 200;
    protected static final int SCENE_CONFIRM = 0;
    protected static final int SCENE_GET_ON = 1;
    protected static final int SCENE_UPDATE_PICK_UP = 2;

    /* renamed from: a */
    private static final String f14391a = "key_cache_start_points";

    /* renamed from: b */
    private static final int f14392b = 200;

    /* renamed from: c */
    private static final int f14393c = 5061010;

    /* renamed from: d */
    private static final int f14394d = 1026;

    /* renamed from: e */
    private static final int f14395e = 101;

    /* renamed from: f */
    private static final int f14396f = 102;

    /* renamed from: g */
    private static final int f14397g = 101;

    /* renamed from: h */
    private static final int f14398h = 102;

    /* renamed from: i */
    private static final int f14399i = 103;

    /* renamed from: j */
    private static final int f14400j = 104;

    /* renamed from: A */
    private final BaseEventPublisher.OnEventListener<DepartureAddress> f14401A = new BaseEventPublisher.OnEventListener<DepartureAddress>() {
        public void onEvent(String str, DepartureAddress departureAddress) {
            if (departureAddress != null && departureAddress.getAddress() != null) {
                OnServiceOmegaUtil.sendClickUpdateButtonOmega();
                ConfirmMapFlowDelegatePresenter.this.m10129c(departureAddress.getAddress());
            }
        }
    };

    /* renamed from: B */
    private final BaseEventPublisher.OnEventListener<Address> f14402B = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, Address address) {
            if (address != null) {
                OnServiceOmegaUtil.sendClickUpdateButtonOmega();
                ConfirmMapFlowDelegatePresenter.this.m10129c(address);
            }
        }
    };

    /* renamed from: C */
    private final BaseEventPublisher.OnEventListener<Integer> f14403C = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
        }
    };

    /* renamed from: D */
    private final ResponseListener<BaseObject> f14404D = new ResponseListener<BaseObject>() {
        public void onSuccess(BaseObject baseObject) {
            super.onSuccess(baseObject);
            if (ConfirmMapFlowDelegatePresenter.this.mPopSugSceneController != null) {
                ConfirmMapFlowDelegatePresenter.this.mPopSugSceneController.closeSugSession();
            }
            if (baseObject.errno == 0) {
                OnServiceOmegaUtil.sendUpdatePickUpSuccessOmega(ConfirmMapFlowDelegatePresenter.this.f14414t);
                CarOrder order = CarOrderHelper.getOrder();
                if (order != null) {
                    order.showUpdatePickUpPop = false;
                    order.startAddress = ConfirmMapFlowDelegatePresenter.this.f14414t;
                }
                ConfirmMapFlowDelegatePresenter.this.goBack();
                ConfirmMapFlowDelegatePresenter.this.m10136f();
                return;
            }
            ConfirmMapFlowDelegatePresenter.this.m10112a(baseObject.errno);
        }

        public void onError(BaseObject baseObject) {
            super.onError(baseObject);
            ConfirmMapFlowDelegatePresenter.this.m10112a(101);
        }

        public void onFail(BaseObject baseObject) {
            super.onFail(baseObject);
            ConfirmMapFlowDelegatePresenter.this.m10112a(baseObject != null ? baseObject.getErrorCode() : 101);
        }

        public void onFinish(BaseObject baseObject) {
            super.onFinish(baseObject);
            ConfirmMapFlowDelegatePresenter.this.hideLoading();
        }
    };

    /* renamed from: E */
    private final BaseEventPublisher.OnEventListener<Integer> f14405E = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (ConfirmMapFlowDelegatePresenter.this.mMiniBusConfirmSceneController != null) {
                ConfirmMapFlowDelegatePresenter.this.mMiniBusConfirmSceneController.doBestView(ConfirmMapFlowDelegatePresenter.this.getCurrentPadding(), num.intValue());
            }
        }
    };

    /* renamed from: k */
    private LatLng f14406k;

    /* renamed from: l */
    private boolean f14407l = true;

    /* renamed from: m */
    private boolean f14408m = false;
    protected int mCurrentScene = 0;
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mEventListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.WaitRsp.EVENT_BEFORE_GOTO_WAITRSP_ANIMATION.equals(str)) {
                ConfirmMapFlowDelegatePresenter.this.m10132d();
            }
        }
    };
    /* access modifiers changed from: protected */
    public ISugSceneCallback mGlobalSugCallback = new ISugSceneCallback() {
        public /* synthetic */ ISugTransferAnimator getSwitchAnimator() {
            return ISugSceneCallback.CC.$default$getSwitchAnimator(this);
        }

        public void onCancelButtonPressed() {
        }

        public /* synthetic */ void onStartChoosen(Address address) {
            ISugSceneCallback.CC.$default$onStartChoosen(this, address);
        }

        public /* synthetic */ void onStartEndAddressChanged(Address address, Address address2) {
            ISugSceneCallback.CC.$default$onStartEndAddressChanged(this, address, address2);
        }

        public void setResult(SugResult sugResult) {
            Address startAddress;
            Logger logger = ConfirmMapFlowDelegatePresenter.this.mLogger;
            logger.info("ConfirmMapFlowDelegate SugCallback setResult: " + sugResult, new Object[0]);
            FormStore.getInstance().updateStartAddressSrcTypeBySug();
            if (sugResult != null) {
                Address address = sugResult.start;
                Address address2 = sugResult.end;
                boolean z = true;
                if (address != null) {
                    if (!(!ConfirmMapFlowDelegatePresenter.this.isAnycar() || (startAddress = FormStore.getInstance().getStartAddress()) == null || startAddress.cityId == address.cityId)) {
                        AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneChangeCity, (Map<String, Object>) null);
                    }
                    FormStore.getInstance().setStartAddress(address, FormStore.getInstance().getStartAddressSrcType(), sugResult.isStartNeedNearRoad);
                    Logger logger2 = ConfirmMapFlowDelegatePresenter.this.mLogger;
                    logger2.info("RideBizMapLog", "eyeball_modify " + address);
                    SearchIdUploadManager.getInstance().setEstimateAction("change_from");
                }
                if (FormStore.getInstance().getEndAddress() == address2) {
                    z = false;
                }
                if (address2 != null) {
                    FormStore.getInstance().setEndAddress(address2);
                    if (z) {
                        SearchIdUploadManager.getInstance().setEstimateAction("change_to");
                    } else {
                        SearchIdUploadManager.getInstance().setEstimateAction("change_from");
                    }
                }
            }
            if (ConfirmMapFlowDelegatePresenter.this.mModel == OrderInterceptMode.MODE_START_NEAR_END) {
                ConfirmMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Service.SendOrder.EVENT_BACK_TO_ESTIMATE);
            }
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_CONFIRM_PAGE_RESULT_CALLBACK, sugResult);
            ConfirmMapFlowDelegatePresenter.this.mSugAddressResult = sugResult;
            ConfirmMapFlowDelegatePresenter.this.mIsCarpoolOverviewState = false;
            ConfirmMapFlowDelegatePresenter.this.leaveSugPage();
            ConfirmMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }

        public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
            ConfirmMapFlowDelegatePresenter.this.onSubmitWayPoints(fragmentActivity, list, list2, iSubmitWayPointsCallback);
            ConfirmMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }

        public void onOpenWebUrl(String str) {
            ConfirmMapFlowDelegatePresenter.this.openWebActivity(str);
        }

        public void onSugSessionClosed() {
            FormStore.getInstance().setSkipEstimateGet(true);
            ConfirmMapFlowDelegatePresenter.this.leaveSugPage(true);
        }
    };
    protected BaseEventPublisher.OnEventListener<ResetMapEvent> mInitMapListener = new BaseEventPublisher.OnEventListener<ResetMapEvent>() {
        public void onEvent(String str, ResetMapEvent resetMapEvent) {
            ConfirmMapFlowDelegatePresenter.this.getOnInitBestView(str, resetMapEvent);
        }
    };
    /* access modifiers changed from: protected */
    public boolean mIsCarpoolOverviewState = false;
    protected boolean mIsFirstPoi = true;
    /* access modifiers changed from: protected */
    public boolean mIsRouteEditorEnable = GlobalApolloUtil.isRouteEditorEnable();
    protected Logger mLogger = LoggerFactory.getLogger(getClass());
    protected IMiniBusConfirmSceneController mMiniBusConfirmSceneController;
    /* access modifiers changed from: protected */
    public OrderInterceptMode mModel;
    @Deprecated
    protected Address mNewStartAddress;
    /* access modifiers changed from: protected */
    public IServingController mOnServiceController;
    /* access modifiers changed from: protected */
    public IOrderConfirmController mOrderConfirmController;
    protected BaseEventPublisher.OnEventListener<Integer> mPaddingBottomMapListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (ConfirmMapFlowDelegatePresenter.this.mCurrentPadding != null) {
                ConfirmMapFlowDelegatePresenter.this.mCurrentPadding.bottom = num.intValue();
            }
        }
    };
    protected Address mPoiChangedAddress;
    protected IPopSugSceneController mPopSugSceneController;
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mShowPinListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CarOrder order;
            if (ConfirmMapFlowDelegatePresenter.this.needHandleShowPinListener() && BaseEventKeys.Map.EVENT_GET_ON_SCENE_SHOW_PIN.equals(str)) {
                GLog.m7965d("zl-cache-poiselect", "EVENT_GET_ON_SCENE_SHOW_PIN ... setDepartureLocation...");
                if (ConfirmMapFlowDelegatePresenter.this.mCurrentScene == 2 && (order = CarOrderHelper.getOrder()) != null && order.startAddress != null) {
                    ConfirmMapFlowDelegatePresenter.this.m10117a(order.startAddress);
                }
            }
        }
    };
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mShowSugPageListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE.equals(str)) {
                ConfirmMapFlowDelegatePresenter.this.mSugAddressResult = null;
                FromType fromType = FromType.GET_ON;
                if (ConfirmMapFlowDelegatePresenter.this.mCurrentScene == 2) {
                    fromType = FromType.WAITRSP;
                    OnServiceOmegaUtil.sendClickUpdatePickUpAddressOmega();
                }
                ConfirmMapFlowDelegatePresenter.this.enterSugPageScene(1, FormStore.getInstance().getDepartureAddress(), fromType, new ISugSceneCallback() {
                    public ISugTransferAnimator getSwitchAnimator() {
                        return null;
                    }

                    public /* synthetic */ void onStartChoosen(Address address) {
                        ISugSceneCallback.CC.$default$onStartChoosen(this, address);
                    }

                    public /* synthetic */ void onStartEndAddressChanged(Address address, Address address2) {
                        ISugSceneCallback.CC.$default$onStartEndAddressChanged(this, address, address2);
                    }

                    public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
                    }

                    public void setResult(SugResult sugResult) {
                        Address address;
                        SystemUtils.log(6, "ccc", "setResult 3", (Throwable) null, "com.didi.component.mapflow.presenter.ConfirmMapFlowDelegatePresenter$8$1", 449);
                        if (sugResult != null && (address = sugResult.start) != null) {
                            ConfirmMapFlowDelegatePresenter.this.m10116a(sugResult, address);
                        }
                    }

                    public void onOpenWebUrl(String str) {
                        ConfirmMapFlowDelegatePresenter.this.openWebActivity(str);
                    }

                    public void onSugSessionClosed() {
                        SystemUtils.log(6, "ccc", "onSugSessionClosed", (Throwable) null, "com.didi.component.mapflow.presenter.ConfirmMapFlowDelegatePresenter$8$1", 476);
                        ConfirmMapFlowDelegatePresenter.this.leaveSugPage();
                    }

                    public void onCancelButtonPressed() {
                        SystemUtils.log(6, "ccc", "onCancelButtonPressed", (Throwable) null, "com.didi.component.mapflow.presenter.ConfirmMapFlowDelegatePresenter$8$1", 482);
                        ConfirmMapFlowDelegatePresenter.this.leaveSugPage();
                    }
                });
            }
        }
    };
    protected SugResult mSugAddressResult;
    protected int mSugPageContainerId;

    /* renamed from: n */
    private boolean f14409n = true;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Circle f14410p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public com.didi.common.map.Map f14411q;

    /* renamed from: r */
    private OnCameraChangeListener f14412r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f14413s = true;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Address f14414t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public MapModel f14415u;

    /* renamed from: v */
    private final BaseEventPublisher.OnEventListener<MapModel> f14416v = new BaseEventPublisher.OnEventListener<MapModel>() {
        public void onEvent(String str, MapModel mapModel) {
            MapModel unused = ConfirmMapFlowDelegatePresenter.this.f14415u = mapModel;
            GLog.m7965d("minibus", "getMapModel");
        }
    };

    /* renamed from: w */
    private GGKDrawer f14417w;

    /* renamed from: x */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14418x = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            Logger logger = ConfirmMapFlowDelegatePresenter.this.mLogger;
            logger.info("Form state change event callback: event => " + str, new Object[0]);
            if (BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE.equals(str)) {
                ConfirmMapFlowDelegatePresenter.this.mIsCarpoolOverviewState = false;
                ConfirmMapFlowDelegatePresenter.this.enterConfirmScene();
                ConfirmMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
                if (ConfirmMapFlowDelegatePresenter.this.mOrderConfirmController != null) {
                    ConfirmMapFlowDelegatePresenter.this.mOrderConfirmController.doBestView(ConfirmMapFlowDelegatePresenter.this.getCurrentPadding());
                }
            } else if (!BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS.equals(str)) {
            } else {
                if (ConfirmMapFlowDelegatePresenter.this.isShowCarPoolStyle()) {
                    ConfirmMapFlowDelegatePresenter.this.enterGetOnSceneInCarPool();
                } else if (ConfirmMapFlowDelegatePresenter.this.m10130c()) {
                    ConfirmMapFlowDelegatePresenter.this.m10124b();
                } else {
                    ConfirmMapFlowDelegatePresenter.this.enterGetOnScene();
                }
            }
        }
    };

    /* renamed from: y */
    private CarMoveBean f14419y;

    /* renamed from: z */
    private final BaseEventPublisher.OnEventListener<Boolean> f14420z = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (TextUtils.equals(BaseEventKeys.CarPool.EVENT_CAR_POOL_MAPFLOW_OVERVIEW_SWITCH, str) && ConfirmMapFlowDelegatePresenter.this.isShowCarPoolStyle()) {
                ConfirmMapFlowDelegatePresenter.this.mIsCarpoolOverviewState = bool.booleanValue();
                int i = 1;
                ConfirmMapFlowDelegatePresenter.this.updateMapView(true, Boolean.valueOf(ConfirmMapFlowDelegatePresenter.this.mIsCarpoolOverviewState));
                if (ConfirmMapFlowDelegatePresenter.this.mOrderConfirmController != null) {
                    ConfirmMapFlowDelegatePresenter.this.mOrderConfirmController.doBestView(ConfirmMapFlowDelegatePresenter.this.getCurrentPadding());
                }
                HashMap hashMap = new HashMap();
                String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
                if (!ConfirmMapFlowDelegatePresenter.this.mIsCarpoolOverviewState) {
                    i = 2;
                }
                hashMap.put("type", Integer.valueOf(i));
                if (estimateModelTraceId == null) {
                    estimateModelTraceId = "";
                }
                hashMap.put(ParamConst.TRACE_ID, estimateModelTraceId);
                GlobalOmegaUtils.trackEvent("gp_mapConverse_btn_ck", (Map<String, Object>) hashMap);
            }
        }
    };

    /* renamed from: a */
    private boolean m10122a(String str, String str2, String str3, String str4, String str5) {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10132d() {
    }

    /* access modifiers changed from: protected */
    public void addOrUpdateExtraParams(OrderConfirmSceneParam.Builder builder) {
    }

    /* access modifiers changed from: protected */
    public void enterGetOnScene() {
    }

    /* access modifiers changed from: protected */
    public void enterGetOnSceneInCarPool() {
    }

    /* access modifiers changed from: protected */
    public void enterSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
    }

    /* access modifiers changed from: protected */
    public boolean needHandleShowPinListener() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPickUpNewAddress(Address address) {
    }

    /* access modifiers changed from: protected */
    public void refresh3DCard(List<String> list) {
    }

    /* access modifiers changed from: protected */
    public void registerStartEndAbnormalListener() {
    }

    /* access modifiers changed from: protected */
    public void requestUpdatePickUpWithConfirm(Address address) {
    }

    /* access modifiers changed from: protected */
    public void unregisterStartEndAbnormalListener() {
    }

    /* access modifiers changed from: protected */
    public void updateMapState() {
    }

    /* access modifiers changed from: protected */
    public void updateMapView(Boolean bool, Boolean bool2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r6 != false) goto L_0x0025;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.Object> m10111a(int r5, boolean r6) {
        /*
            r4 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 1
            java.lang.String r2 = "recommendtoofar"
            java.lang.String r3 = "selecttoofar"
            if (r5 == r1) goto L_0x0023
            r1 = 2
            if (r5 == r1) goto L_0x0021
            r1 = 3
            if (r5 == r1) goto L_0x001e
            r1 = 4
            if (r5 == r1) goto L_0x0018
            java.lang.String r2 = ""
            goto L_0x0025
        L_0x0018:
            if (r6 == 0) goto L_0x001b
            goto L_0x0025
        L_0x001b:
            java.lang.String r2 = "poorGps"
            goto L_0x0025
        L_0x001e:
            if (r6 == 0) goto L_0x0021
            goto L_0x0025
        L_0x0021:
            r2 = r3
            goto L_0x0025
        L_0x0023:
            java.lang.String r2 = "fromdestclose"
        L_0x0025:
            java.lang.String r5 = "type"
            r0.put(r5, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.mapflow.presenter.ConfirmMapFlowDelegatePresenter.m10111a(int, boolean):java.util.Map");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10124b() {
        GLog.m7965d("minibus", "enterMinibusGetOnScene");
        doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 8);
        this.mOrderConfirmController = null;
        this.mPopSugSceneController = null;
        MapModel mapModel = this.f14415u;
        if (!(mapModel == null || mapModel.lineInfos == null || this.f14415u.markerInfos == null)) {
            this.mMiniBusConfirmSceneController = transformToMinibusGetOnScene(m10109a(this.f14415u.lineInfos, this.f14415u.markerInfos));
        }
        this.mCurrentScene = 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m10130c() {
        return FormStore.getInstance().isInMiniBus();
    }

    /* renamed from: a */
    private MiniBusConfirmSceneParam m10109a(List<MapLineInfo> list, List<MarkerInfo> list2) {
        return new MiniBusConfirmSceneParam.Builder().miniBusParamInterface(getMiniBusParam(list, list2)).context(this.mContext).mapChangeListener(this.mMapChangeListener).build();
    }

    /* access modifiers changed from: protected */
    public void getOnInitBestView(String str, ResetMapEvent resetMapEvent) {
        if (BaseEventKeys.Map.EVENT_GET_ON_SCENE_INIT_MAP.equals(str) && resetMapEvent != null && resetMapEvent.getPadding() != null) {
            this.mCurrentPadding = resetMapEvent.getPadding();
            resetMapEvent.recycle();
            getCurrentPadding();
        }
    }

    public ConfirmMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mSugPageContainerId = ((Integer) componentParams.getExtra(MapFlowComponent.SUG_PAGE_CONTAINER_ID)).intValue();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        SatelliteManager.getInstance(this.mContext).start();
        this.f14408m = GlobalApolloUtil.needMapFlowShowRecommendName();
        Logger logger = this.mLogger;
        logger.info("ConfirmMapFlowDelegate onAdd..isShowRecommendName:" + this.f14408m, new Object[0]);
        if (bundle == null || !bundle.getBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, false)) {
            this.mLogger.info("ConfirmMapFlowDelegate onAdd enterConfirmScene", new Object[0]);
            enterConfirmScene();
        } else {
            CarOrder order = CarOrderHelper.getOrder();
            if (order == null || order.startAddress == null) {
                this.mLogger.info("ConfirmMapFlowDelegate onAdd enterGetOnScene", new Object[0]);
                enterGetOnScene();
            } else {
                load3DCar();
            }
        }
        registerListener();
        this.f14409n = false;
        FormStore.getInstance().setShowNearCarMsg(GlobalApolloUtil.isNearbyCarMsgHintEnable());
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        try {
            SatelliteManager.getInstance(this.mContext).stop();
        } catch (Exception unused) {
        }
        unregisterListener();
        leaveConfirmScene();
        m10138g();
    }

    /* access modifiers changed from: protected */
    public void enterConfirmScene() {
        this.mLogger.info("ConfirmMapFlowDelegate enterConfirmScene..", new Object[0]);
        Address startAddress = FormStore.getInstance().getStartAddress();
        Address endAddress = FormStore.getInstance().getEndAddress();
        if (startAddress == null || endAddress == null) {
            Logger logger = this.mLogger;
            logger.error("ConfirmMapFlowDelegate address is empty, startAddress=" + startAddress + " endAddress=" + endAddress, new Object[0]);
            return;
        }
        m10134e();
        this.mPopSugSceneController = null;
        OrderConfirmSceneParam.Builder builder = new OrderConfirmSceneParam.Builder();
        builder.context(this.mContext);
        builder.setCarSlidingSuccessRunnable(new Runnable() {
            public void run() {
                ConfirmMapFlowDelegatePresenter.this.carslidingOnSuccess();
            }
        });
        builder.setLineSelectedListener(this.mLineSelectedListener);
        builder.setStartAddress(startAddress);
        builder.setEndAddress(endAddress);
        builder.mapChangeListener(this.mMapChangeListener);
        List<CommonMarkerParam> commonMarkerParam = getCommonMarkerParam(startAddress, endAddress, FormStore.getInstance().getWayPointAddressList());
        if (commonMarkerParam != null) {
            builder.setMarkerParams(commonMarkerParam);
        }
        addOrUpdateExtraParams(builder);
        builder.setCollideRectCallback(new LoadingInfoWindow.CollideRectCallback() {
            public List<Rect> getCollideAvoidRect() {
                ArrayList arrayList = new ArrayList();
                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                if (confirmListener != null) {
                    if (confirmListener.getAnycarEstimtePanleRect() != null) {
                        arrayList.add(confirmListener.getAnycarEstimtePanleRect());
                    }
                    if (confirmListener.getPreferenceRect() != null) {
                        arrayList.add(confirmListener.getPreferenceRect());
                    }
                }
                return arrayList;
            }
        });
        this.mOrderConfirmController = transformToConfirmScene(new OrderConfirmSceneParam(builder));
        this.mCurrentScene = 0;
        FormStore.getInstance().removeChangeAddressTypes(1);
        FormStore.getInstance().removeChangeAddressTypes(2);
    }

    /* access modifiers changed from: protected */
    public List<CommonMarkerParam> getCommonMarkerParam(Address address, Address address2, List<WayPoint> list) {
        MapElementId mapElementId;
        if (address == null || address2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CommonMarkerParam commonMarkerParam = new CommonMarkerParam(new LatLng(address.getLatitude(), address.getLongitude()), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.map_icon_pick_up), 0.5f, 0.5f, MapElementId.ID_MARKER_START);
        CommonMarkerParam commonMarkerParam2 = new CommonMarkerParam(new LatLng(address2.getLatitude(), address2.getLongitude()), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.map_icon_destination), 0.5f, 0.5f, MapElementId.ID_MARKER_END);
        arrayList.add(commonMarkerParam);
        arrayList.add(commonMarkerParam2);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                mapElementId = MapElementId.ID_MARKER_WAYPOINT_1;
            } else if (i != 1) {
                mapElementId = MapElementId.ID_MARKER_WAYPOINT_3;
            } else {
                mapElementId = MapElementId.ID_MARKER_WAYPOINT_2;
            }
            MapElementId mapElementId2 = mapElementId;
            Address address3 = list.get(i).getAddress();
            if (address3 != null) {
                arrayList.add(new CommonMarkerParam(new LatLng(address3.getLatitude(), address3.getLongitude()), BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.map_icon_waypoint), 0.5f, 0.5f, mapElementId2));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public MiniBusParamInterface getMiniBusParam(final List<MapLineInfo> list, final List<MarkerInfo> list2) {
        return new MiniBusParamInterface() {
            public List<CommonLineParam> getMiniBusLineParam() {
                ArrayList arrayList = new ArrayList();
                if (!CollectionUtils.isEmpty((Collection) list)) {
                    for (MapLineInfo mapLineInfo : list) {
                        ArrayList arrayList2 = null;
                        MapElementId mapElementId = MapElementId.ID_LINE_START_PICKUP;
                        if (!CollectionUtils.isEmpty((Collection) mapLineInfo.wayPoints)) {
                            for (MapLineInfo.Point next : mapLineInfo.wayPoints) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(new LatLng(next.lat, next.lng));
                            }
                        }
                        ArrayList arrayList3 = arrayList2;
                        int i = mapLineInfo.lineStyle;
                        if (i == 1) {
                            mapElementId = MapElementId.ID_LINE_START_PICKUP;
                        } else if (i == 2) {
                            mapElementId = MapElementId.ID_LINE_PICKUP_DROPOFF;
                        } else if (i == 3) {
                            mapElementId = MapElementId.ID_LINE_DROPOFF_END;
                        }
                        MapElementId mapElementId2 = mapElementId;
                        arrayList.add(new CommonLineParam(mapElementId2, Color.parseColor(mapLineInfo.lineColor), mapLineInfo.lineWidth, mapLineInfo.lineMode, new LatLng(mapLineInfo.startPoints.lat, mapLineInfo.startPoints.lng), new LatLng(mapLineInfo.endPoints.lat, mapLineInfo.endPoints.lng), arrayList3));
                    }
                }
                return arrayList;
            }

            public List<CommonMarkerParam> getMiniBusMarkerParam() {
                MapElementId mapElementId;
                float f;
                Bitmap bitmap;
                MapElementId mapElementId2;
                Bitmap bitmap2;
                ArrayList arrayList = new ArrayList();
                if (!CollectionUtils.isEmpty((Collection) list2)) {
                    for (MarkerInfo markerInfo : list2) {
                        Bitmap decodeResource = BitmapFactory.decodeResource(ConfirmMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                        MapElementId mapElementId3 = MapElementId.ID_MARKER_START;
                        int i = markerInfo.markerType;
                        if (i != 1) {
                            if (i == 2) {
                                bitmap2 = BitmapFactory.decodeResource(ConfirmMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up_station);
                                mapElementId2 = MapElementId.ID_MARKER_PICK_UP;
                            } else if (i == 3) {
                                bitmap2 = BitmapFactory.decodeResource(ConfirmMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_dest_station);
                                mapElementId2 = MapElementId.ID_MARKER_DROP_OFF;
                            } else if (i == 4) {
                                decodeResource = BitmapFactory.decodeResource(ConfirmMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_destination);
                                mapElementId3 = MapElementId.ID_MARKER_END;
                            }
                            bitmap = bitmap2;
                            mapElementId = mapElementId2;
                            f = 0.8f;
                            arrayList.add(new CommonMarkerParam(new LatLng(Double.parseDouble(markerInfo.lat), Double.parseDouble(markerInfo.lng)), bitmap, 0.5f, f, mapElementId));
                        } else {
                            decodeResource = BitmapFactory.decodeResource(ConfirmMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                            mapElementId3 = MapElementId.ID_MARKER_START;
                        }
                        bitmap = decodeResource;
                        mapElementId = mapElementId3;
                        f = 0.5f;
                        arrayList.add(new CommonMarkerParam(new LatLng(Double.parseDouble(markerInfo.lat), Double.parseDouble(markerInfo.lng)), bitmap, 0.5f, f, mapElementId));
                    }
                }
                return arrayList;
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10116a(SugResult sugResult, Address address) {
        Objects.requireNonNull(sugResult);
        Objects.requireNonNull(address);
        if (this.mCurrentScene == 2) {
            requestUpdatePickUpWithConfirm(address);
            return;
        }
        FormStore.getInstance().updateStartAddressSrcTypeBySug();
        FormStore.getInstance().addChangeAddressTypes(2);
        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
        this.f14406k = latLng;
        m10118a(latLng);
        this.mSugAddressResult = sugResult;
        doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_GET_ON_SUG_PAGE_CHANGE_ADDRESS, address);
        onPickUpNewAddress(address);
    }

    /* renamed from: e */
    private void m10134e() {
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        GLog.m7965d("zl-omega", "start src type = " + FormStore.getInstance().getStartAddressSrcType());
        double lat = LocationController.getInstance().getLat(this.mContext);
        double lng = LocationController.getInstance().getLng(this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(lat));
        hashMap.put("lng", Double.valueOf(lng));
        GlobalOmegaUtils.trackEvent("map_bubble_location", (Map<String, Object>) hashMap);
        Address startAddress = FormStore.getInstance().getStartAddress();
        if (startAddress != null && this.f14409n) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("lat", Double.valueOf(startAddress.latitude));
            hashMap2.put("lng", Double.valueOf(startAddress.longitude));
            hashMap2.put("opt", Integer.valueOf(FormStore.getInstance().getStartAddressSrcType().getType()));
            GlobalOmegaUtils.trackEvent("map_bubble_rgeo", (Map<String, Object>) hashMap2);
        }
    }

    /* access modifiers changed from: protected */
    public void trackLocationInGetOnScene() {
        if (!GPageIdConstant.G_PAGE_ID_PICONF.equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        }
        double lat = LocationController.getInstance().getLat(this.mContext);
        double lng = LocationController.getInstance().getLng(this.mContext);
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(lat));
        hashMap.put("lng", Double.valueOf(lng));
        GlobalOmegaUtils.trackEvent("map_pickup_location", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private boolean m10118a(LatLng latLng) {
        return LatLngUtils.isSameLatLng(latLng, (LatLng) CacheStore.getInstance().getCache(f14391a, null));
    }

    /* access modifiers changed from: protected */
    public void leaveConfirmScene() {
        this.mLogger.info("ConfirmMapFlowDelegate leaveConfirmScene..", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public Padding getCurrentPadding() {
        Padding currentPadding = super.getCurrentPadding();
        if (currentPadding != null) {
            if (currentPadding.bottom > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt(XPanelStore.EXTRA_MAP_PADDING_BOTTOM, currentPadding.bottom);
                XPanelStore.getInstance().addCache(1030, bundle);
            }
            if (currentPadding.top > 0) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(XPanelStore.EXTRA_MAP_PADDING_TOP, currentPadding.top);
                XPanelStore.getInstance().addCache(1030, bundle2);
            }
        }
        return currentPadding;
    }

    /* access modifiers changed from: protected */
    public void enterNewSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        AbsConfirmConfigState.isInSugPage = true;
        SugParams createSugPageAddressParam = AddressUtil.createSugPageAddressParam(this.mContext, i, address);
        createSugPageAddressParam.fromType = fromType;
        createSugPageAddressParam.enable_way_point = (FormStore.getInstance().isBubbleEnablePassingPoint() && this.mIsRouteEditorEnable) || isAnycar();
        AddressParam addressParam = createSugPageAddressParam.addressParam;
        addressParam.departure_time = FormStore.getInstance().getTransportTime() + "";
        if (fromType == FromType.CONFIRM_NEW || fromType == FromType.OPEN_RIDE_CONFIRM) {
            createSugPageAddressParam.endAddress = FormStore.getInstance().getEndAddress();
        }
        WayPointParam wayPointParam = createSugPageAddressParam.wayPointParam;
        wayPointParam.setWayPointTypes(getEditableWayPointsType());
        wayPointParam.setWayPoints(getWayPoints());
        wayPointParam.setAddDefaultWayPoint(true);
        Fragment host = getHost();
        if (host != null && host.isAdded()) {
            this.mPopSugSceneController = transformToPopSugPageScene(new PopSugSceneParam.Builder().sugParams(createSugPageAddressParam).context(host.requireContext()).mapChangeListener(this.mMapChangeListener).sugSceneCallback(iSugSceneCallback).build());
            doPublish(BaseEventKeys.Service.EVENT_HOME_SHOWN_SUG_PAGE);
        }
    }

    /* access modifiers changed from: protected */
    public void openRouterEditorPage(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        SystemUtils.log(6, "ccc", "openRouterEditorPage", (Throwable) null, "com.didi.component.mapflow.presenter.ConfirmMapFlowDelegatePresenter", 897);
    }

    /* access modifiers changed from: protected */
    public void leaveSugPage() {
        leaveSugPage(false);
    }

    /* access modifiers changed from: protected */
    public void leaveSugPage(boolean z) {
        Logger logger = this.mLogger;
        logger.info("ConfirmMapFlowDelegate leaveSugPage.. mCurrentScene => " + this.mCurrentScene, new Object[0]);
        BaseEventPublisher.getPublisher().publish("event_hide_sug_page_container");
        int i = this.mCurrentScene;
        if (i == 0) {
            enterConfirmScene();
            if (z) {
                updateMapState();
            }
            resetMap();
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_HIDE_RESET_MAP);
        } else if (i == 1) {
            if (isShowCarPoolStyle()) {
                enterGetOnSceneInCarPool();
            } else {
                enterGetOnScene();
            }
            resetMap();
        }
        this.mPopSugSceneController = null;
        AbsConfirmConfigState.isInSugPage = false;
    }

    /* access modifiers changed from: protected */
    public ISceneController getSceneController() {
        IOrderConfirmController iOrderConfirmController = this.mOrderConfirmController;
        if (iOrderConfirmController != null) {
            return iOrderConfirmController;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void registerListener() {
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f14418x);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f14418x);
        subscribe(BaseEventKeys.Map.EVENT_GET_ON_SCENE_INIT_MAP, this.mInitMapListener);
        subscribe(BaseEventKeys.Map.EVENT_GET_ON_SCENE_PADDING_BOTTOM_BY_PUDO, this.mPaddingBottomMapListener);
        subscribe(BaseEventKeys.Map.EVENT_GET_ON_SCENE_SHOW_PIN, this.mShowPinListener);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE, this.mShowSugPageListener);
        subscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_GOTO_WAITRSP_ANIMATION, this.mEventListener);
        subscribe(BaseEventKeys.CarPool.EVENT_CAR_POOL_MAPFLOW_OVERVIEW_SWITCH, this.f14420z);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_BUTTON_CLICK, this.f14401A);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_BUTTON_CLICK_V2, this.f14402B);
        subscribe(BaseEventKeys.Confirm.EVENT_UPDATE_PICK_UP_XPANEL_HEIGHT_CHANGED, this.f14403C);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFORM_MAP_INFO, this.f14416v);
        subscribe(BaseEventKeys.Map.EVENT_SWITCH_VIEW_FOR_GET_ON_AND_OFF_MAP, this.f14405E);
        registerStartEndAbnormalListener();
    }

    /* access modifiers changed from: protected */
    public void unregisterListener() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_PRICE, this.f14418x);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f14418x);
        unsubscribe(BaseEventKeys.Map.EVENT_GET_ON_SCENE_INIT_MAP, this.mInitMapListener);
        unsubscribe(BaseEventKeys.Map.EVENT_GET_ON_SCENE_PADDING_BOTTOM_BY_PUDO, this.mPaddingBottomMapListener);
        unsubscribe(BaseEventKeys.Map.EVENT_GET_ON_SCENE_SHOW_PIN, this.mShowPinListener);
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_BEFORE_GOTO_WAITRSP_ANIMATION, this.mEventListener);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE, this.mShowSugPageListener);
        unsubscribe(BaseEventKeys.CarPool.EVENT_CAR_POOL_MAPFLOW_OVERVIEW_SWITCH, this.f14420z);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_BUTTON_CLICK, this.f14401A);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_BUTTON_CLICK_V2, this.f14402B);
        unsubscribe(BaseEventKeys.Confirm.EVENT_UPDATE_PICK_UP_XPANEL_HEIGHT_CHANGED, this.f14403C);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFORM_MAP_INFO, this.f14416v);
        unsubscribe(BaseEventKeys.Map.EVENT_SWITCH_VIEW_FOR_GET_ON_AND_OFF_MAP, this.f14405E);
        unregisterStartEndAbnormalListener();
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        return super.onBackPressed(backType);
    }

    /* access modifiers changed from: protected */
    public void resetMap() {
        IOrderConfirmController iOrderConfirmController;
        CarOrder order = CarOrderHelper.getOrder();
        DIDILocation lastKnownLocation = NationComponentDataUtil.getLastKnownLocation();
        if (this.mCurrentScene == 2 && order != null && order.startAddress != null) {
            Address address = order.startAddress;
        } else if (lastKnownLocation != null) {
            Address address2 = new Address();
            address2.setLatitude(lastKnownLocation.getLatitude());
            address2.setLongitude(lastKnownLocation.getLongitude());
        } else {
            FormStore.getInstance().getStartAddress();
        }
        if (!isShowCarPoolStyle() || this.mIsCarpoolOverviewState || (iOrderConfirmController = this.mOrderConfirmController) == null) {
            super.resetMap();
        } else {
            iOrderConfirmController.doBestView(getCurrentPadding());
        }
    }

    public static void requestMapLayout(Fragment fragment) {
        View findViewById;
        if (fragment != null) {
            try {
                FragmentActivity activity = fragment.getActivity();
                if (activity != null && (findViewById = activity.findViewById(R.id.home_map_fragment)) != null) {
                    findViewById.forceLayout();
                    findViewById.requestLayout();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public Drawable getServingParamPickUpIcon() {
        return ResourcesHelper.getDrawable(this.mContext, R.drawable.global_mapflow_way_point);
    }

    /* access modifiers changed from: protected */
    public ServingParam getServingParam(CarOrder carOrder, long j, int i) {
        return getServingParam(carOrder, j, i, false);
    }

    /* access modifiers changed from: protected */
    public ServingParam getServingParam(CarOrder carOrder, long j, int i, boolean z) {
        CarOrder carOrder2 = carOrder;
        String str = null;
        if (carOrder2 == null || carOrder2.startAddress == null || carOrder2.endAddress == null) {
            this.mLogger.error("OnServiceMapFlowDelegate getServingParam order is null", new Object[0]);
            return null;
        }
        long j2 = 0;
        if (carOrder2.carDriver != null) {
            j2 = NumberUtil.strToLong(carOrder2.carDriver.did);
        }
        long j3 = j2;
        OrderParams createOrderParams = createOrderParams(carOrder2.oid, j3, j, i, 1005);
        createOrderParams.productID = String.valueOf(carOrder2.productid);
        createOrderParams.srcTag = carOrder2.startAddress.srcTag;
        createOrderParams.lastOrderId = carOrder2.lastOrderId;
        if (this.mBusinessContext.getCountryInfo() != null) {
            str = this.mBusinessContext.getCountryInfo().getCountryIsoCode();
        }
        ClientParams clientParams = new ClientParams(SystemUtil.getVersionName(this.mContext), str, SystemUtil.getIMEI());
        LatLng latLng = new LatLng(carOrder2.startAddress.latitude, carOrder2.startAddress.longitude);
        LatLng latLng2 = new LatLng(carOrder2.endAddress.latitude, carOrder2.endAddress.longitude);
        Drawable servingParamPickUpIcon = getServingParamPickUpIcon();
        CommonMarkerParam commonMarkerParam = new CommonMarkerParam(new CommonMarkerParam.Builder().markerIconResId(DidiThemeManager.getIns().getResPicker(this.mContext).getResIdByTheme(R.attr.pass_point_icon)));
        Logger logger = this.mLogger;
        logger.info("ConfirmMapFlowDelegatePresenter getServingParam oid=" + carOrder2.oid + " driverId=" + j3 + " countryId=" + str + " startLatLng=" + latLng + " endLatLng=" + latLng2, new Object[0]);
        CommonMarkerParam commonMarkerParam2 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng).markerIcon(ImageUtil.Drawable2Bitmap(servingParamPickUpIcon)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_START).addressName(carOrder2.startAddress.getDisplayName()).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        CommonMarkerParam commonMarkerParam3 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng2).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_END).addressName(carOrder2.endAddress.getDisplayName()).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        HashMap hashMap = new HashMap();
        hashMap.put(MapElementId.ID_MARKER_START, commonMarkerParam2);
        hashMap.put(MapElementId.ID_MARKER_END, commonMarkerParam3);
        hashMap.put(MapElementId.ID_MARKER_WAYPOINT, commonMarkerParam);
        return new ServingParam(new ServingParam.Builder().context(this.mContext).isNewVersion(z).markerParams(hashMap).carBitmapDescriptor(this.mCarBitmapDescriptor).orderParams(createOrderParams).clientParams(clientParams).bReadOnly(carOrder.isSplitFareUser()).car3DIcons(this.mCache3DList).oraOrderStageCallback(this.mIOraOrderStageCallback).mapChangeListener(this.mMapChangeListener));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10117a(final Address address) {
        if (!(((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView() == null || ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().getMap() == null)) {
            this.f14411q = ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().getMap();
        }
        com.didi.common.map.Map map = this.f14411q;
        if (map != null) {
            this.f14410p = map.addCircle(m10123b(address));
            this.f14413s = true;
            C611613 r0 = new OnCameraChangeListener() {
                public void onCameraChange(CameraPosition cameraPosition) {
                    if (ConfirmMapFlowDelegatePresenter.this.f14411q != null && ConfirmMapFlowDelegatePresenter.this.f14410p != null && ConfirmMapFlowDelegatePresenter.this.f14411q.getCameraPosition() != null && ConfirmMapFlowDelegatePresenter.this.f14411q.getCameraPosition().target != null) {
                        ConfirmMapFlowDelegatePresenter confirmMapFlowDelegatePresenter = ConfirmMapFlowDelegatePresenter.this;
                        if (!confirmMapFlowDelegatePresenter.m10127b(confirmMapFlowDelegatePresenter.f14411q.getCameraPosition().target) || ConfirmMapFlowDelegatePresenter.this.f14413s) {
                            ConfirmMapFlowDelegatePresenter confirmMapFlowDelegatePresenter2 = ConfirmMapFlowDelegatePresenter.this;
                            if (!confirmMapFlowDelegatePresenter2.m10127b(confirmMapFlowDelegatePresenter2.f14411q.getCameraPosition().target) && ConfirmMapFlowDelegatePresenter.this.f14413s) {
                                Address address = ConfirmMapFlowDelegatePresenter.this.mPoiChangedAddress;
                                boolean unused = ConfirmMapFlowDelegatePresenter.this.f14413s = false;
                                ConfirmMapFlowDelegatePresenter.this.f14410p.setFillColor(ConfirmMapFlowDelegatePresenter.this.mContext.getResources().getColor(R.color.mapflow_update_pick_up_out_circle_bg));
                                ConfirmMapFlowDelegatePresenter.this.f14410p.setStrokeColor(ConfirmMapFlowDelegatePresenter.this.mContext.getResources().getColor(R.color.mapflow_update_pick_up_out_circle_stroke));
                                ConfirmMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_AREA_STATUS_CHANGE, false);
                                return;
                            }
                            return;
                        }
                        boolean unused2 = ConfirmMapFlowDelegatePresenter.this.f14413s = true;
                        ConfirmMapFlowDelegatePresenter.this.f14410p.setFillColor(ConfirmMapFlowDelegatePresenter.this.mContext.getResources().getColor(R.color.mapflow_update_pick_up_in_circle_bg));
                        ConfirmMapFlowDelegatePresenter.this.f14410p.setStrokeColor(ConfirmMapFlowDelegatePresenter.this.mContext.getResources().getColor(R.color.mapflow_update_pick_up_in_circle_stroke));
                        ConfirmMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_UPDATE_PICK_UP_AREA_STATUS_CHANGE, true);
                    }
                }
            };
            this.f14412r = r0;
            this.f14411q.addOnCameraChangeListener(r0);
        }
    }

    /* renamed from: b */
    private CircleOptions m10123b(Address address) {
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(address.getLatitude(), address.getLongitude()));
        circleOptions.fillColor(this.mContext.getResources().getColor(R.color.mapflow_update_pick_up_in_circle_bg));
        circleOptions.strokeColor(this.mContext.getResources().getColor(R.color.mapflow_update_pick_up_in_circle_stroke));
        circleOptions.strokeWidth(this.mContext.getResources().getDimension(R.dimen.mapflow_update_pick_up_in_circle_stroke_width));
        circleOptions.radius(200.0d);
        return circleOptions;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m10127b(LatLng latLng) {
        Circle circle = this.f14410p;
        if (circle != null) {
            return circle.contains(latLng);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10129c(Address address) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && address != null) {
            this.f14414t = address;
            CarRequest.updatePickUp(this.mContext, order.oid, address, this.f14404D);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10136f() {
        ToastHelper.showLongInfo(this.mContext, ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_up_success_toast));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10112a(int i) {
        String str;
        int i2 = i;
        int i3 = 102;
        if (i2 != 102) {
            OnServiceOmegaUtil.sendUpdatePickUpFailOmega(i2, this.f14414t);
        }
        String string = ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_title);
        String string2 = ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_button_ok);
        String str2 = "";
        if (i2 == 102) {
            string = ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_title_out_area);
            str = String.format(ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_content_out_area), new Object[]{Elvish.Companion.getInstance().formatDistance(200.0d, DistanceStyle.AUTO, 0, false)});
            if (m10122a(string, str, string2, str2, "Unable to Change")) {
                return;
            }
        } else if (i2 == 1026) {
            i3 = 104;
            str = ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_content_version_low);
            if (m10122a(string, str, string2, str2, "Driver Version Low")) {
                return;
            }
        } else if (i2 != f14393c) {
            i3 = 101;
            String string3 = ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_network);
            String string4 = ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_button_retry);
            if (!m10122a(string, string3, string2, string4, "No Network")) {
                String str3 = string4;
                str = string3;
                str2 = str3;
            } else {
                return;
            }
        } else {
            i3 = 103;
            str = ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_fail_content_arrival);
            if (m10122a(string, str, string2, str2, "Driver Arrival")) {
                return;
            }
        }
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(i3);
        normalDialogInfo.setPositiveText(string2);
        if (!TextUtils.isEmpty(str2)) {
            normalDialogInfo.setNegativeText(str2);
        }
        normalDialogInfo.setCancelable(false);
        normalDialogInfo.setTitle(string);
        normalDialogInfo.setMessage(str);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i2 == 2) {
            if (i == 103 || i == 104) {
                goBack();
            }
        } else if (i2 != 1) {
            dismissDialog(i);
        } else if (i == 101) {
            m10129c(this.f14414t);
        }
    }

    /* renamed from: g */
    private void m10138g() {
        Circle circle;
        com.didi.common.map.Map map = this.f14411q;
        if (map != null && (circle = this.f14410p) != null) {
            map.remove(circle);
            OnCameraChangeListener onCameraChangeListener = this.f14412r;
            if (onCameraChangeListener != null) {
                this.f14411q.removeOnCameraChangeListener(onCameraChangeListener);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isShowCarPoolStyle() {
        return FormStore.getInstance().isBubbleShowCarpoolStyle();
    }
}
