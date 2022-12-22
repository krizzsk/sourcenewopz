package com.didi.component.mapflow.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.ImageUtil;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarNotifyManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.DriverPosUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xengine.request.XESimpleReqParams;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.AddressUtil;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.OnServiceOmegaUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.MapFlowComponent;
import com.didi.component.mapflow.infowindow.callback.CountDownCallback;
import com.didi.component.mapflow.infowindow.factory.InfoWindowViewFactory;
import com.didi.component.mapflow.infowindow.model.CircleCountWrapper;
import com.didi.component.mapflow.infowindow.model.EditWithTipsModel;
import com.didi.component.mapflow.infowindow.model.NewWaitArrivalWithTipsModel;
import com.didi.component.mapflow.infowindow.model.OneMessageModel;
import com.didi.component.mapflow.infowindow.widget.EditInfoWindow;
import com.didi.component.mapflow.infowindow.widget.FindCarCountdownInfoWindowV2;
import com.didi.component.mapflow.infowindow.widget.LoadingInfoWindow;
import com.didi.component.mapflow.infowindow.widget.NewWaitArrivalInfoWindow;
import com.didi.component.mapflow.infowindow.widget.OneLineInfoWindow;
import com.didi.component.mapflow.view.IMapFlowDelegateView;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.model.EventDescribe;
import com.didi.map.global.flow.model.GuideStartInfo;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.minibus.scene.service.IMiniBusSctxSceneController;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusAppointParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusSctxParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusSctxSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusStreetParam;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.order.serving.IEventCallback;
import com.didi.map.global.flow.scene.order.serving.IGuideEntranceCallback;
import com.didi.map.global.flow.scene.order.serving.IPassBTMStatusCallback;
import com.didi.map.global.flow.scene.order.serving.IPassPointStatusCallback;
import com.didi.map.global.flow.scene.order.serving.ISctxStateCallback;
import com.didi.map.global.flow.scene.order.serving.ISecRouteInfoCallback;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.param.ClientParams;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.order.serving.scene.IOdPointsExpiredCallback;
import com.didi.map.global.flow.scene.order.serving.scene.ITripStateCallback;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.scene.sug.IPopSugSceneController;
import com.didi.map.global.flow.scene.sug.ISubmitWayPointsCallback;
import com.didi.map.global.flow.scene.sug.ISugSceneCallback;
import com.didi.map.global.flow.scene.sug.ISugTransferAnimator;
import com.didi.map.global.flow.scene.sug.PopSugSceneParam;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.map.global.sctx.model.SecRouteInfoEx;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SPUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.push.PushManager;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.FlierFeature;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.DrivingMapBubbleMsg;
import com.didi.travel.psnger.model.response.DrivingMapInfo;
import com.didi.travel.psnger.model.response.FlierPoolStationModel;
import com.didi.travel.psnger.model.response.MapLineInfo;
import com.didi.travel.psnger.model.response.MarkerInfo;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.xengine.register.XERegister;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.global.didi.elvish.Elvish;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class OnServiceMapFlowDelegatePresenter extends AbsAfterOrderMapFlowDelegatePresenter {
    public static final int EXPRESS = 1;
    public static final int MINIBUS = 2;
    public static final int OTHERS = 3;

    /* renamed from: d */
    private static int f14448d = 1200000;

    /* renamed from: e */
    private static int f14449e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int f14450f = 1;

    /* renamed from: g */
    private static int f14451g = 2;

    /* renamed from: h */
    private static int f14452h = 3;

    /* renamed from: A */
    private ServingParam f14453A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public LEGODrawer f14454B;

    /* renamed from: C */
    private ISctxStateCallback f14455C = new ISctxStateCallback() {
        public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
            if (sctxStateInfo != null && CarOrderHelper.isWaitDriver()) {
                boolean unused = OnServiceMapFlowDelegatePresenter.this.f14457E = false;
                OnServiceMapFlowDelegatePresenter.this.m10239e();
                OnServiceMapFlowDelegatePresenter.this.doPublish("event_sctx_state_change", sctxStateInfo);
            }
        }
    };

    /* renamed from: D */
    private boolean f14456D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public boolean f14457E;

    /* renamed from: F */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14458F = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            OnServiceMapFlowDelegatePresenter.this.forwardUpdatePickupPage();
        }
    };

    /* renamed from: G */
    private final ILocation.ILocationChangedListener f14459G = new ILocation.ILocationChangedListener() {
        private double desLat;
        private double desLng;
        private final int distance = ((Integer) GlobalApolloUtils.getParamByStatus("LostandFound_PAX_push_v1", "distance", 200, true)).intValue();

        {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null && order.endAddress != null) {
                this.desLat = order.endAddress.latitude;
                this.desLng = order.endAddress.longitude;
            }
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            String orderId = CarOrderHelper.getOrderId();
            boolean booleanValue = ((Boolean) SPUtils.get(OnServiceMapFlowDelegatePresenter.this.mContext, orderId, false)).booleanValue();
            if (dIDILocation != null && !booleanValue && CarOrderHelper.isOnService() && !OnServiceMapFlowDelegatePresenter.this.mRemoved && ActivityLifecycleManager.getInstance().isAppActive() && dIDILocation.distanceTo(this.desLng, this.desLat) <= ((double) this.distance) && OnServiceMapFlowDelegatePresenter.this.f14481p != 2) {
                SPUtils.put(OnServiceMapFlowDelegatePresenter.this.mContext, orderId, true);
                OnServiceMapFlowDelegatePresenter.this.uninstallLosingOfPassenger();
                LEGOToastHelper.showToast(OnServiceMapFlowDelegatePresenter.this.mContext, ResourcesHelper.getString(OnServiceMapFlowDelegatePresenter.this.mContext, R.string.Help_push_Before_you_MRbP));
                GlobalOmegaUtils.trackEvent("ibt_lost_and_found_push_sw");
            }
        }
    };

    /* renamed from: H */
    private PushManager.DriversMigrationRoutesListener f14460H = new PushManager.DriversMigrationRoutesListener() {
        public void onDriversMigrationRoutesMessageReceived(byte[] bArr) {
            if (OnServiceMapFlowDelegatePresenter.this.mOnServiceController != null) {
                OnServiceMapFlowDelegatePresenter.this.mOnServiceController.onPushMsgReceived(bArr);
                OnServiceMapFlowDelegatePresenter.this.mLogger.info("OnServiceMapFlowDelegate onDriversMigrationRoutesMessageReceived..", new Object[0]);
                DriverPosUtils.setLatLng(OnServiceMapFlowDelegatePresenter.this.mOnServiceController.getLastDriverPosition());
            }
        }
    };

    /* renamed from: I */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14461I = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CarOrder order;
            Address address;
            final int i;
            FromType fromType;
            if ((BaseEventKeys.OnService.EVENT_SHOW_SUG_PAGE_DEST.equals(str) || BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE.equals(str)) && (order = CarOrderHelper.getOrder()) != null) {
                if (BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE.equals(str)) {
                    i = 1;
                    if (OnServiceMapFlowDelegatePresenter.this.mPoiChangedAddress != null) {
                        address = OnServiceMapFlowDelegatePresenter.this.mPoiChangedAddress;
                    } else {
                        address = order.startAddress;
                    }
                    fromType = FromType.WAITRSP;
                    OnServiceOmegaUtil.sendClickUpdatePickUpAddressOmega();
                } else {
                    i = 2;
                    address = order.endAddress;
                    fromType = FromType.DRIVING;
                }
                if (address != null) {
                    OnServiceMapFlowDelegatePresenter.this.enterSugPageScene(i, address, fromType, new ISugSceneCallback() {
                        public ISugTransferAnimator getSwitchAnimator() {
                            return null;
                        }

                        public /* synthetic */ void onCancelButtonPressed() {
                            ISugSceneCallback.CC.$default$onCancelButtonPressed(this);
                        }

                        public void onOpenWebUrl(String str) {
                        }

                        public /* synthetic */ void onStartChoosen(Address address) {
                            ISugSceneCallback.CC.$default$onStartChoosen(this, address);
                        }

                        public /* synthetic */ void onStartEndAddressChanged(Address address, Address address2) {
                            ISugSceneCallback.CC.$default$onStartEndAddressChanged(this, address, address2);
                        }

                        public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
                        }

                        public /* synthetic */ void onSugSessionClosed() {
                            ISugSceneCallback.CC.$default$onSugSessionClosed(this);
                        }

                        public void setResult(SugResult sugResult) {
                            SystemUtils.log(6, "ccc", "setResult 4", (Throwable) null, "com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter$17$1", 1489);
                            if (sugResult != null && i == 2 && sugResult.end != null) {
                                OnServiceMapFlowDelegatePresenter.this.m10255k();
                                OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_SUG_PAGE_CHANGE_END_ADDRESS, sugResult.end);
                            }
                        }
                    });
                }
            }
        }
    };

    /* renamed from: J */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14462J = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            SystemUtils.log(6, "ccc", "mShowRouteEditorPageListener enterSugPageScene", (Throwable) null, "com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter$18", 1525);
            OnServiceMapFlowDelegatePresenter.this.enterSugPageScene(1, FormStore.getInstance().getStartAddress(), FromType.ROUTE_EDITOR, OnServiceMapFlowDelegatePresenter.this.f14465M);
        }
    };

    /* renamed from: K */
    private final BaseEventPublisher.OnEventListener<LatLng> f14463K = new BaseEventPublisher.OnEventListener<LatLng>() {
        public void onEvent(String str, LatLng latLng) {
            if (OnServiceMapFlowDelegatePresenter.this.mOnServiceController != null) {
                OnServiceMapFlowDelegatePresenter.this.mOnServiceController.updatePickupPoint(latLng);
            }
        }
    };

    /* renamed from: L */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14464L = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (OnServiceMapFlowDelegatePresenter.this.mOnServiceController != null) {
                OnServiceMapFlowDelegatePresenter.this.mOnServiceController.cancelPickupPointRecommend();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: M */
    public ISugSceneCallback f14465M = new ISugSceneCallback() {
        public ISugTransferAnimator getSwitchAnimator() {
            return null;
        }

        public /* synthetic */ void onCancelButtonPressed() {
            ISugSceneCallback.CC.$default$onCancelButtonPressed(this);
        }

        public void onOpenWebUrl(String str) {
        }

        public /* synthetic */ void onStartChoosen(Address address) {
            ISugSceneCallback.CC.$default$onStartChoosen(this, address);
        }

        public /* synthetic */ void onStartEndAddressChanged(Address address, Address address2) {
            ISugSceneCallback.CC.$default$onStartEndAddressChanged(this, address, address2);
        }

        public void setResult(SugResult sugResult) {
            SystemUtils.log(6, "ccc", "setResult 1", (Throwable) null, "com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter$21", 1557);
        }

        public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
            OnServiceMapFlowDelegatePresenter.this.onSubmitWayPoints(fragmentActivity, list, list2, iSubmitWayPointsCallback);
        }

        public void onSugSessionClosed() {
            OnServiceMapFlowDelegatePresenter.this.m10255k();
        }
    };

    /* renamed from: N */
    private BaseEventPublisher.OnEventListener<Address> f14466N = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, Address address) {
            if (BaseEventKeys.OnService.EVENT_MAP_UPDATE_DEST.equals(str) && address != null && OnServiceMapFlowDelegatePresenter.this.mOnServiceController != null) {
                OnServiceMapFlowDelegatePresenter.this.mOnServiceController.modifyDestination(new LatLng(address.latitude, address.longitude));
            }
        }
    };

    /* renamed from: O */
    private BaseEventPublisher.OnEventListener<Boolean> f14467O = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            double d;
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null && OnServiceMapFlowDelegatePresenter.this.mOnServiceController != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("order_id", order.getOid());
                if (order.carDriver != null) {
                    hashMap.put(CarServerParam.PARAM_DRIVER_ID, order.carDriver.did);
                }
                if (NationComponentDataUtil.getLoginInfo() != null) {
                    hashMap.put("passenger_id", NationComponentDataUtil.getLoginInfo().getUid());
                }
                if (order.startAddress != null) {
                    hashMap.put("lng", Double.valueOf(order.startAddress.longitude));
                    hashMap.put("lat", Double.valueOf(order.startAddress.latitude));
                }
                DIDILocation lastKnownLocation = NationComponentDataUtil.getLastKnownLocation();
                if (lastKnownLocation != null) {
                    hashMap.put("pas_lng", Double.valueOf(lastKnownLocation.getLongitude()));
                    hashMap.put("pas_lat", Double.valueOf(lastKnownLocation.getLatitude()));
                }
                DriverPosUtils.setLatLng(OnServiceMapFlowDelegatePresenter.this.mOnServiceController.getLastDriverPosition());
                LatLng latLng = DriverPosUtils.getLatLng();
                double d2 = 0.0d;
                if (latLng == null) {
                    d = 0.0d;
                } else {
                    d = latLng.longitude;
                }
                if (latLng != null) {
                    d2 = latLng.latitude;
                }
                hashMap.put("dri_lng", Double.valueOf(d));
                hashMap.put("dri_lat", Double.valueOf(d2));
                hashMap.put("distance", Double.valueOf(OnServiceMapFlowDelegatePresenter.this.mOnServiceController.getLeftRouteDistance()));
                if (bool.booleanValue()) {
                    hashMap.put("eta", -1);
                } else if (OnServiceMapFlowDelegatePresenter.this.mEtaEda != null) {
                    hashMap.put("eta", Integer.valueOf(OnServiceMapFlowDelegatePresenter.this.mEtaEda.eta));
                }
                GlobalOmegaUtils.trackEvent("gp_driverArriver_map_rsp", (Map<String, Object>) hashMap);
            }
        }
    };

    /* renamed from: P */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14468P = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            OnServiceMapFlowDelegatePresenter.this.m10259m();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f14469Q = false;

    /* renamed from: R */
    private BaseEventPublisher.OnEventListener<String> f14470R = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            DTSDKOrderDetail.DTSDKMapRequestData dTSDKMapRequestData;
            if (OnServiceMapFlowDelegatePresenter.this.f14469Q) {
                boolean unused = OnServiceMapFlowDelegatePresenter.this.f14469Q = false;
                CarOrder order = CarOrderHelper.getOrder();
                GuideStartInfo guideStartInfo = new GuideStartInfo();
                if (order != null) {
                    Address address = order.startAddress;
                    GLog.m7965d("XEngineOrderDetail", address.displayName);
                    guideStartInfo.startAddressName = address.getDisplayName();
                    guideStartInfo.srcTag = address.getSrcTag();
                    guideStartInfo.startPoiId = address.uid;
                    DTSDKOrderDetail.DTSDKMapData dTSDKMapData = order.mapData;
                    if (!(dTSDKMapData == null || (dTSDKMapRequestData = dTSDKMapData.requestData) == null)) {
                        guideStartInfo.stationWalkGuideLink = dTSDKMapRequestData.stationWalkGuideLink;
                        guideStartInfo.stationWalkGuidePhoto = dTSDKMapRequestData.walkGuidePhoto;
                    }
                    guideStartInfo.startPosition = new LatLng(address.latitude, address.longitude);
                    OnServiceMapFlowDelegatePresenter.this.mOnServiceController.onStartChangedForSharer(guideStartInfo);
                    OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, false);
                }
            }
        }
    };

    /* renamed from: S */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14471S = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            boolean unused = OnServiceMapFlowDelegatePresenter.this.f14469Q = true;
            XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
        }
    };

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14472a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(str, BaseEventKeys.OnService.EVENT_OPERATION_PANEL_ROUTE_EDIT)) {
                OnServiceMapFlowDelegatePresenter.this.mIsShowingUpdatePickUp = false;
            }
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14473b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            OnServiceMapFlowDelegatePresenter.this.mLogger.info("mOrderStatusChangedEventReceiver", new Object[0]);
            OnServiceMapFlowDelegatePresenter.this.m10218a(true);
        }
    };

    /* renamed from: c */
    OnInfoWindowClickListener f14474c = new OnInfoWindowClickListener() {
        public void onInfoWindowClick(Marker marker) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null && order.startAddress != null) {
                if (GlobalSPUtil.isUpdatePickUpTipsShown(OnServiceMapFlowDelegatePresenter.this.mContext)) {
                    OnServiceMapFlowDelegatePresenter.this.mIsShowingUpdatePickUp = false;
                    OnServiceOmegaUtil.setOmegaParamUpdatePickUpChannelMap();
                    OnServiceOmegaUtil.sendClickEditOmega();
                    OnServiceMapFlowDelegatePresenter.this.forwardUpdatePickupPage();
                    return;
                }
                GlobalSPUtil.setUpdatePickUpTipsShown(OnServiceMapFlowDelegatePresenter.this.mContext);
                if (GlobalApolloUtil.isNewUpdatePickUp()) {
                    OnServiceMapFlowDelegatePresenter.this.showNewWaitArrivalInfoWindow();
                } else {
                    OnServiceMapFlowDelegatePresenter.this.m10227b(false);
                }
            }
        }
    };
    protected int currentTime = 0;
    protected DrivingMapBubbleMsg drivingMapBubbleMsg;
    protected DrivingMapInfo drivingMapInfo = new DrivingMapInfo();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f14475i = f14449e;
    protected ITripStateCallback iTripStateCallback = new ITripStateCallback() {
        public void onTripStateUpdate(int i) {
            Logger logger = OnServiceMapFlowDelegatePresenter.this.mLogger;
            logger.info("===onTripStateUpdate ====" + i, new Object[0]);
            OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Trip.EVENT_TRIP_STATE, Integer.valueOf(i));
        }
    };
    protected boolean isCancleDown = false;
    protected boolean isShowMap = false;

    /* renamed from: j */
    private OneMessageModel f14476j;

    /* renamed from: k */
    private LoadingInfoWindow f14477k;

    /* renamed from: l */
    private EditWithTipsModel f14478l;

    /* renamed from: m */
    private FindCarCountdownInfoWindowV2 f14479m;
    protected int mCurSubStatus = -1;
    protected EtaEda mEtaEda;
    protected IEtaEdaCallback mEtaEdaCallback = new IEtaEdaCallback() {
        public void onEtaEdaChanged(EtaEda etaEda) {
            if (etaEda != null && !OnServiceMapFlowDelegatePresenter.this.f14457E) {
                OnServiceMapFlowDelegatePresenter.this.m10211a(etaEda);
                OnServiceMapFlowDelegatePresenter.this.mEtaEda = etaEda;
            }
        }
    };
    protected int mFromPageId;
    protected IGuideEntranceCallback mIGuideEntranceCallback = new IGuideEntranceCallback() {
        public void onShowARErrorDialog(String str, String str2) {
            OnServiceMapFlowDelegatePresenter.this.m10217a(str2);
        }

        public void onNavigateToRealScene(String str) {
            OnServiceMapFlowDelegatePresenter.this.m10226b(str);
        }
    };
    protected boolean mIsShowingUpdatePickUp;
    protected Logger mLogger = LoggerFactory.getLogger(getClass());
    protected ISceneController mMiniBusScene;
    protected IServingController mOnServiceController;
    protected Address mPoiChangedAddress;
    protected int mSugPageContainerId;
    protected XEResponseCallback mXELogicCallbackMapInfo = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            OnServiceMapFlowDelegatePresenter.this.isCancleDown = false;
            OnServiceMapFlowDelegatePresenter.this.isShowMap = false;
            if (xEngineData.jsonObject != null) {
                Logger logger = OnServiceMapFlowDelegatePresenter.this.mLogger;
                logger.info("drivingMapInfo" + xEngineData.jsonObject.toString(), new Object[0]);
                OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.parse(xEngineData.jsonObject.toString());
                if (!(OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapBubbleMsg == null || OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapBubbleMsg.size() == 0)) {
                    for (int i = 0; i < OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapBubbleMsg.size(); i++) {
                        if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapBubbleMsg.get(i).bubbleType == 2) {
                            OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter = OnServiceMapFlowDelegatePresenter.this;
                            onServiceMapFlowDelegatePresenter.currentTime = Integer.parseInt(onServiceMapFlowDelegatePresenter.drivingMapInfo.mapBubbleMsg.get(i).msg);
                            OnServiceMapFlowDelegatePresenter.this.isCancleDown = true;
                        }
                        if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapBubbleMsg.get(i).bubbleType == 3) {
                            OnServiceMapFlowDelegatePresenter.this.isShowMap = true;
                        }
                    }
                    OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter2 = OnServiceMapFlowDelegatePresenter.this;
                    onServiceMapFlowDelegatePresenter2.doPublish(BaseEventKeys.CarPool.EVENT_NEW_CAR_POOL_PEOPLE_INFOS_UPDATE, onServiceMapFlowDelegatePresenter2.drivingMapInfo);
                }
                if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo != null && OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig != null) {
                    if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.bizScene == 2) {
                        OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter3 = OnServiceMapFlowDelegatePresenter.this;
                        int unused = onServiceMapFlowDelegatePresenter3.f14481p = onServiceMapFlowDelegatePresenter3.drivingMapInfo.mapConfig.bizScene;
                        Logger logger2 = OnServiceMapFlowDelegatePresenter.this.mLogger;
                        logger2.info("minibusMap发车: 0未发车/1已发车 " + OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.carDepart + "样式（1未发车大于25分钟、2 未发车小于25分钟样式、3已发车样式，接驾、4 司机到达样式，等驾、5 送驾阶段样式） = " + OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle, new Object[0]);
                        OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, false);
                        if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.carDepart == 0) {
                            if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle == 1) {
                                if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.lineData != null && !OnServiceMapFlowDelegatePresenter.this.f14483r) {
                                    OnServiceMapFlowDelegatePresenter.this.mLogger.info("minibusMap未发车大于25分钟样式", new Object[0]);
                                    MiniBusAppointParam.Builder builder = new MiniBusAppointParam.Builder();
                                    MiniBusAppointParam.Builder mapChangeListener = builder.context(OnServiceMapFlowDelegatePresenter.this.mContext).mapChangeListener(OnServiceMapFlowDelegatePresenter.this.mMapChangeListener);
                                    OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter4 = OnServiceMapFlowDelegatePresenter.this;
                                    MiniBusAppointParam.Builder miniBusParamInterface = mapChangeListener.miniBusParamInterface(onServiceMapFlowDelegatePresenter4.getMiniBusParam(onServiceMapFlowDelegatePresenter4.drivingMapInfo.mapConfig.lineData.lineInfos, OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.lineData.markerInfos, OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle));
                                    OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter5 = OnServiceMapFlowDelegatePresenter.this;
                                    miniBusParamInterface.sceneState(onServiceMapFlowDelegatePresenter5.transMpaStyle(onServiceMapFlowDelegatePresenter5.drivingMapInfo.mapConfig.mapStyle));
                                    OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter6 = OnServiceMapFlowDelegatePresenter.this;
                                    onServiceMapFlowDelegatePresenter6.mMiniBusScene = onServiceMapFlowDelegatePresenter6.transformToMinibusAppointScene(builder.build());
                                    boolean unused2 = OnServiceMapFlowDelegatePresenter.this.f14483r = true;
                                }
                            } else if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle == 2 && OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.lineData != null && !OnServiceMapFlowDelegatePresenter.this.f14484s) {
                                MiniBusAppointParam.Builder builder2 = new MiniBusAppointParam.Builder();
                                MiniBusAppointParam.Builder mapChangeListener2 = builder2.context(OnServiceMapFlowDelegatePresenter.this.mContext).mapChangeListener(OnServiceMapFlowDelegatePresenter.this.mMapChangeListener);
                                OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter7 = OnServiceMapFlowDelegatePresenter.this;
                                MiniBusAppointParam.Builder miniBusParamInterface2 = mapChangeListener2.miniBusParamInterface(onServiceMapFlowDelegatePresenter7.getMiniBusParam(onServiceMapFlowDelegatePresenter7.drivingMapInfo.mapConfig.lineData.lineInfos, OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.lineData.markerInfos, OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle, OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.stationBoardHint));
                                OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter8 = OnServiceMapFlowDelegatePresenter.this;
                                miniBusParamInterface2.sceneState(onServiceMapFlowDelegatePresenter8.transMpaStyle(onServiceMapFlowDelegatePresenter8.drivingMapInfo.mapConfig.mapStyle));
                                MiniBusAppointParam build = builder2.build();
                                OnServiceMapFlowDelegatePresenter.this.mLogger.info("minibusMap未发车小于25分钟样式", new Object[0]);
                                OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter9 = OnServiceMapFlowDelegatePresenter.this;
                                onServiceMapFlowDelegatePresenter9.mMiniBusScene = onServiceMapFlowDelegatePresenter9.transformToMinibusAppointScene(build);
                                boolean unused3 = OnServiceMapFlowDelegatePresenter.this.f14484s = true;
                            }
                        } else if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.carDepart == 1) {
                            if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle == 3) {
                                OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter10 = OnServiceMapFlowDelegatePresenter.this;
                                onServiceMapFlowDelegatePresenter10.m10225b(onServiceMapFlowDelegatePresenter10.drivingMapInfo.mapConfig);
                            } else if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle == 4) {
                                OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter11 = OnServiceMapFlowDelegatePresenter.this;
                                onServiceMapFlowDelegatePresenter11.m10225b(onServiceMapFlowDelegatePresenter11.drivingMapInfo.mapConfig);
                            } else if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle == 5) {
                                OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter12 = OnServiceMapFlowDelegatePresenter.this;
                                onServiceMapFlowDelegatePresenter12.m10216a(onServiceMapFlowDelegatePresenter12.drivingMapInfo.mapConfig);
                            }
                        }
                        if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.dropOffThreshold != 0) {
                            OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter13 = OnServiceMapFlowDelegatePresenter.this;
                            onServiceMapFlowDelegatePresenter13.doPublish(BaseEventKeys.OnService.EVENT_STATUS_NEAR_DROPOFF_ETA, Integer.valueOf(onServiceMapFlowDelegatePresenter13.drivingMapInfo.mapConfig.dropOffThreshold));
                        }
                    } else if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.bizScene == 1) {
                        int unused4 = OnServiceMapFlowDelegatePresenter.this.f14481p = 1;
                    } else {
                        int unused5 = OnServiceMapFlowDelegatePresenter.this.f14481p = 3;
                    }
                }
            }
        }
    };

    /* renamed from: n */
    private Timer f14480n;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f14481p = 1;

    /* renamed from: q */
    private boolean f14482q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f14483r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f14484s;

    /* renamed from: t */
    private boolean f14485t;

    /* renamed from: u */
    private boolean f14486u;

    /* renamed from: v */
    private IPopSugSceneController f14487v;

    /* renamed from: w */
    private HashMap<String, Object> f14488w = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f14489x = true;

    /* renamed from: y */
    private NewWaitArrivalInfoWindow f14490y;

    /* renamed from: z */
    private NewWaitArrivalWithTipsModel f14491z;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10217a(String str) {
        LEGODrawerModel1 lEGODrawerModel1;
        CarOrder order = CarOrderHelper.getOrder();
        boolean z = order != null && !TextUtils.isEmpty(order.stationWalkGuideLink);
        LEGOBtnTextAndCallback lEGOBtnTextAndCallback = new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.mContext, R.string.GRider_new_I_see_tgYO), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GlobalOmegaUtils.trackEvent("ibt_gp_armaperror_close_ck");
                if (OnServiceMapFlowDelegatePresenter.this.f14454B != null) {
                    OnServiceMapFlowDelegatePresenter.this.f14454B.dismiss();
                }
            }
        });
        LEGOBtnTextAndCallback lEGOBtnTextAndCallback2 = null;
        if (z) {
            lEGOBtnTextAndCallback2 = new LEGOBtnTextAndCallback(ResourcesHelper.getString(this.mContext, R.string.GRider_new_View_Graphic_SGng), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    GlobalOmegaUtils.trackEvent("ibt_gp_armaperror_othernavigation_ck");
                    if (OnServiceMapFlowDelegatePresenter.this.f14454B != null) {
                        OnServiceMapFlowDelegatePresenter.this.f14454B.dismiss();
                    }
                    OnServiceMapFlowDelegatePresenter.this.m10230c();
                }
            });
        }
        String string = ResourcesHelper.getString(this.mContext, R.string.GRider_new_Sorry_AR_FsvP);
        if (z) {
            lEGODrawerModel1 = new LEGODrawerModel1(string, lEGOBtnTextAndCallback2);
            lEGODrawerModel1.addMinorBtn(lEGOBtnTextAndCallback);
        } else {
            lEGODrawerModel1 = new LEGODrawerModel1(string, lEGOBtnTextAndCallback);
        }
        lEGODrawerModel1.setSubTitle(str);
        this.f14454B = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10230c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && !TextUtils.isEmpty(order.stationWalkGuideLink)) {
            m10226b(order.stationWalkGuideLink);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10226b(String str) {
        if (!TextUtils.isEmpty(str)) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = str;
            webViewModel.isSupportCache = false;
            webViewModel.isPostBaseParams = false;
            Intent intent = new Intent(this.mContext, WebActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            this.mContext.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10216a(DrivingMapInfo.MapConfig mapConfig) {
        if (!this.f14486u) {
            doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, true);
            this.mLogger.info("minibusMap送驾场景", new Object[0]);
            this.mMiniBusScene = transformToMinibusOnServiceScene(m10229c(mapConfig));
            this.f14486u = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10225b(DrivingMapInfo.MapConfig mapConfig) {
        if (!this.f14485t) {
            MiniBusSctxSceneParam c = m10229c(mapConfig);
            Logger logger = this.mLogger;
            logger.info("minibusMap接等场景， 创建场景。样式（1未发车大于25分钟、2 未发车小于25分钟样式、3已发车样式，接驾、4 司机到达样式，等驾、5 送驾阶段样式） = " + mapConfig.mapStyle, new Object[0]);
            this.mMiniBusScene = transformToMinibusPickingScene(c);
            this.f14485t = true;
        } else if (mapConfig.mapStyle == 4 && (this.mMiniBusScene instanceof IMiniBusSctxSceneController)) {
            CarOrder order = CarOrderHelper.getOrder();
            long j = 0;
            if (order.carDriver != null) {
                j = NumberUtil.strToLong(order.carDriver.did);
            }
            OrderParams orderParams = new OrderParams(order.oid, j, PaxEnvironment.getInstance().getPhoneNumber());
            orderParams.travelId = order.travelid;
            orderParams.orderStage = 1;
            orderParams.srcTag = order.startAddress.srcTag;
            orderParams.productID = String.valueOf(order.productid);
            Logger logger2 = this.mLogger;
            logger2.info("minibusMap接等场景， onOrderStateChanged。样式（1未发车大于25分钟、2 未发车小于25分钟样式、3已发车样式，接驾、4 司机到达样式，等驾、5 送驾阶段样式） = " + mapConfig.mapStyle, new Object[0]);
            ((IMiniBusSctxSceneController) this.mMiniBusScene).onOrderStateChanged(1, orderParams);
        }
    }

    /* renamed from: c */
    private MiniBusSctxSceneParam m10229c(final DrivingMapInfo.MapConfig mapConfig) {
        MiniBusSctxSceneParam.Builder builder = new MiniBusSctxSceneParam.Builder();
        builder.context(this.mContext).mapChangeListener(this.mMapChangeListener);
        builder.paramInterface(new MiniBusSctxParamInterface() {
            public OrderParams getOrderParams() {
                CarOrder order = CarOrderHelper.getOrder();
                OrderParams orderParams = new OrderParams(order.oid, order.carDriver != null ? NumberUtil.strToLong(order.carDriver.did) : 0, PaxEnvironment.getInstance().getPhoneNumber());
                orderParams.travelId = order.travelid;
                if (mapConfig.mapStyle == 4) {
                    orderParams.orderStage = 1;
                } else if (mapConfig.mapStyle == 3) {
                    orderParams.orderStage = 0;
                } else if (mapConfig.mapStyle == 5) {
                    orderParams.orderStage = 2;
                }
                orderParams.srcTag = order.startAddress.srcTag;
                orderParams.productID = String.valueOf(order.productid);
                return orderParams;
            }

            public ICarBitmapDescriptor getCarMarkerBitmap() {
                return new ICarBitmapDescriptor() {
                    public BitmapDescriptor getBitmapDescriptor() {
                        return OnServiceMapFlowDelegatePresenter.this.mCarBitmapDescriptor.getBitmapDescriptor();
                    }

                    public BitmapDescriptor getDefaultBitmapDescriptor() {
                        return OnServiceMapFlowDelegatePresenter.this.mCarBitmapDescriptor.getBitmapDescriptor();
                    }
                };
            }

            public ClientParams getClientParam() {
                return new ClientParams(SystemUtil.getVersionName(OnServiceMapFlowDelegatePresenter.this.mContext), OnServiceMapFlowDelegatePresenter.this.mBusinessContext.getCountryInfo() != null ? OnServiceMapFlowDelegatePresenter.this.mBusinessContext.getCountryInfo().getCountryIsoCode() : null, SystemUtil.getIMEI());
            }

            public List<CommonMarkerParam> getMarkerParams() {
                MapElementId mapElementId;
                float f;
                Bitmap bitmap;
                MapElementId mapElementId2;
                Bitmap bitmap2;
                Bitmap decodeResource;
                ArrayList arrayList = new ArrayList();
                DrivingMapInfo.MapConfig mapConfig = mapConfig;
                if (!(mapConfig == null || mapConfig.lineData == null || CollectionUtils.isEmpty((Collection) mapConfig.lineData.markerInfos))) {
                    for (MarkerInfo next : mapConfig.lineData.markerInfos) {
                        Bitmap decodeResource2 = BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                        MapElementId mapElementId3 = MapElementId.ID_MARKER_START;
                        float f2 = 0.5f;
                        int i = next.markerType;
                        if (i != 1) {
                            if (i == 2) {
                                if (mapConfig.mapStyle == 3 || mapConfig.mapStyle == 4) {
                                    decodeResource = BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                                } else {
                                    decodeResource = BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up_station);
                                    f2 = 0.8f;
                                }
                                mapElementId2 = MapElementId.ID_MARKER_PICK_UP;
                            } else if (i == 3) {
                                if (mapConfig.mapStyle == 6) {
                                    bitmap2 = BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_dest_station_round);
                                } else {
                                    bitmap2 = BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_dest_station);
                                    f2 = 0.8f;
                                }
                                mapElementId2 = MapElementId.ID_MARKER_DROP_OFF;
                            } else if (i == 4) {
                                decodeResource2 = BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_destination);
                                mapElementId3 = MapElementId.ID_MARKER_END;
                            }
                            bitmap = bitmap2;
                            mapElementId = mapElementId2;
                            f = f2;
                            arrayList.add(new CommonMarkerParam(new LatLng(Double.parseDouble(next.lat), Double.parseDouble(next.lng)), bitmap, 0.5f, f, mapElementId));
                        } else {
                            decodeResource2 = BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                            mapElementId3 = MapElementId.ID_MARKER_START;
                        }
                        bitmap = decodeResource2;
                        mapElementId = mapElementId3;
                        f = 0.5f;
                        arrayList.add(new CommonMarkerParam(new LatLng(Double.parseDouble(next.lat), Double.parseDouble(next.lng)), bitmap, 0.5f, f, mapElementId));
                    }
                }
                return arrayList;
            }

            public List<CommonLineParam> getLineParams() {
                ArrayList arrayList = new ArrayList();
                DrivingMapInfo.MapConfig mapConfig = mapConfig;
                if (!(mapConfig == null || mapConfig.lineData == null || CollectionUtils.isEmpty((Collection) mapConfig.lineData.lineInfos))) {
                    for (MapLineInfo next : mapConfig.lineData.lineInfos) {
                        ArrayList arrayList2 = null;
                        MapElementId mapElementId = MapElementId.ID_LINE_START_PICKUP;
                        if (!CollectionUtils.isEmpty((Collection) next.wayPoints)) {
                            for (MapLineInfo.Point next2 : next.wayPoints) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(new LatLng(next2.lat, next2.lng));
                            }
                        }
                        ArrayList arrayList3 = arrayList2;
                        int i = next.lineStyle;
                        if (i == 1) {
                            mapElementId = MapElementId.ID_LINE_START_PICKUP;
                        } else if (i == 2) {
                            mapElementId = MapElementId.ID_LINE_PICKUP_DROPOFF;
                        } else if (i == 3) {
                            mapElementId = MapElementId.ID_LINE_DROPOFF_END;
                        }
                        MapElementId mapElementId2 = mapElementId;
                        arrayList.add(new CommonLineParam(mapElementId2, Color.parseColor(next.lineColor), next.lineWidth, next.lineMode, new LatLng(next.startPoints.lat, next.startPoints.lng), new LatLng(next.endPoints.lat, next.endPoints.lng), arrayList3));
                    }
                }
                return arrayList;
            }

            public Bitmap getWayPointIcon() {
                if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo == null || OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig == null || OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.mapStyle != 5) {
                    return BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up_station_round);
                }
                return BitmapFactory.decodeResource(OnServiceMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_dest_station_round);
            }

            public MiniBusStreetParam getStreetParam() {
                LatLng latLng = null;
                if (OnServiceMapFlowDelegatePresenter.this.drivingMapInfo == null || OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig == null || OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.stationBoardHint == null) {
                    return null;
                }
                if (mapConfig.lineData != null && !CollectionUtils.isEmpty((Collection) mapConfig.lineData.markerInfos)) {
                    for (MarkerInfo next : mapConfig.lineData.markerInfos) {
                        if (next.markerType == 2) {
                            latLng = new LatLng(Double.parseDouble(next.lat), Double.parseDouble(next.lng));
                        }
                    }
                }
                return new MiniBusStreetParam(OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.stationBoardHint.mStationIcon, latLng, OnServiceMapFlowDelegatePresenter.this.drivingMapInfo.mapConfig.stationBoardHint.mText, "");
            }
        });
        builder.etaEdaCallback(this.mEtaEdaCallback);
        return builder.build();
    }

    /* renamed from: d */
    private void m10235d() {
        if (this.f14476j == null) {
            OneMessageModel oneMessageModel = new OneMessageModel();
            this.f14476j = oneMessageModel;
            oneMessageModel.setContent(this.mContext.getString(R.string.global_map_simulate_move_tips_on_car));
        }
        OneLineInfoWindow infoWindowView = InfoWindowViewFactory.getInfoWindowView(this.mContext, this.f14476j);
        if (getSceneController() != null) {
            getSceneController().updateMarkerBubble(MapElementId.ID_MARKER_CAR, infoWindowView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10239e() {
        if (this.mEtaEda == null && getSceneController() != null) {
            getSceneController().updateMarkerBubble(MapElementId.ID_MARKER_CAR, (View) null);
        }
    }

    /* renamed from: a */
    private void m10213a(ServingParam servingParam) {
        if (servingParam != null && servingParam.getBuilder() != null) {
            servingParam.reset(servingParam.getBuilder().sctxStateCallback(this.f14455C));
            this.f14453A = servingParam;
        }
    }

    /* renamed from: f */
    private void m10243f() {
        ServingParam servingParam = this.f14453A;
        if (servingParam != null && servingParam.getBuilder() != null) {
            ServingParam servingParam2 = this.f14453A;
            servingParam2.reset(servingParam2.getBuilder().sctxStateCallback((ISctxStateCallback) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10211a(EtaEda etaEda) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (4001 == order.substatus || 4002 == order.substatus) {
                doPublish(BaseEventKeys.OnService.EVENT_STATUS_WAIT_PICK_UP_ETA, etaEda);
            } else if (4006 == order.substatus) {
                doPublish(BaseEventKeys.OnService.EVENT_STATUS_ON_SERVICE_ETA, etaEda);
            }
            if (order.substatus >= 4001 && order.substatus < 4006) {
                doPublish(BaseEventKeys.WaitRspNew.EVENT_DRIVER_CARD_NEAR_PICK, etaEda);
            }
            doPublish(BaseEventKeys.Trip.EVENT_DRIVER_ETA_EDA, etaEda);
        }
    }

    public OnServiceMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mSugPageContainerId = ((Integer) componentParams.getExtra(MapFlowComponent.SUG_PAGE_CONTAINER_ID)).intValue();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (bundle != null) {
            this.mFromPageId = bundle.getInt(BaseExtras.Common.EXTRA_FROM_PAGE_ID, -1);
        }
        this.f14491z = new NewWaitArrivalWithTipsModel();
        if (CarOrderHelper.getOrder() != null) {
            this.f14491z.setAddress(CarOrderHelper.getOrder().startAddress.address);
        }
        this.f14490y = InfoWindowViewFactory.getNewWaitArrivalInfoWindow(this.mContext, this.f14491z);
        this.f14489x = true;
        ((IMapFlowDelegateView) this.mView).dismissMapOverlayView();
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_MAP_INFO, XERequestKey.SCENE_TRIP, this.mXELogicCallbackMapInfo);
        xERegisterModel.requestParams = new XEReqParamsCallback() {
            public Object getRequestParams() {
                HashMap hashMap = new HashMap();
                hashMap.put("oid", CarOrderHelper.getOrderId());
                hashMap.put("version", 1);
                return hashMap;
            }
        };
        XERegister.registerTemplate(xERegisterModel);
        m10218a(false);
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14473b);
        PushManager.registerDriverMigrationRoutesMessageListener(this.f14460H);
        subscribe(BaseEventKeys.OnService.EVENT_SHOW_SUG_PAGE_DEST, this.f14461I);
        subscribe(BaseEventKeys.OnService.EVENT_SHOW_ROUTE_EDITOR_PAGE, this.f14462J);
        subscribe(BaseEventKeys.OnService.EVENT_MAP_UPDATE_DEST, this.f14466N);
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f14467O);
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE, this.f14461I);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_WAY_POINT, this.f14468P);
        subscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT, this.f14458F);
        subscribe(BaseEventKeys.OnService.EVENT_OPERATION_PANEL_ROUTE_EDIT, this.f14472a);
        subscribe(BaseEventKeys.Push.EVENT_SPLIT_STREET_SHOW, this.f14471S);
        subscribe(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS, this.f14470R);
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_UPDATE_ADDRESS, this.f14463K);
        subscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_DISMISS, this.f14464L);
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && (order.substatus == 4006 || order.substatus == 4005)) {
            m10259m();
        }
        load3DCar();
        setupLosingOfPassenger();
    }

    /* access modifiers changed from: protected */
    public void setupLosingOfPassenger() {
        if (GlobalApolloUtils.getStatus("LostandFound_PAX_push_v1")) {
            LocationPerformer.getInstance().addLocationListener(this.f14459G);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f14489x = true;
        m10243f();
        m10249h();
        this.f14475i = f14449e;
        m10253j();
        PushManager.unregisterDriverMigrationRoutesMessageListener();
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14473b);
        unsubscribe(BaseEventKeys.OnService.EVENT_SHOW_SUG_PAGE_DEST, this.f14461I);
        unsubscribe(BaseEventKeys.OnService.EVENT_SHOW_ROUTE_EDITOR_PAGE, this.f14462J);
        unsubscribe(BaseEventKeys.OnService.EVENT_MAP_UPDATE_DEST, this.f14466N);
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f14467O);
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE, this.f14461I);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_WAY_POINT, this.f14468P);
        unsubscribe(BaseEventKeys.OnService.EVENT_UPDATE_PICKUP_POINT, this.f14458F);
        unsubscribe(BaseEventKeys.OnService.EVENT_OPERATION_PANEL_ROUTE_EDIT, this.f14472a);
        unsubscribe(BaseEventKeys.Push.EVENT_SPLIT_STREET_SHOW, this.f14471S);
        unsubscribe(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS, this.f14470R);
        XERegister.unregisterCallback(XERequestKey.REQUEST_KEY_MAP_INFO, this.mXELogicCallbackMapInfo);
        uninstallLosingOfPassenger();
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_UPDATE_ADDRESS, this.f14463K);
        unsubscribe(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_DISMISS, this.f14464L);
    }

    /* access modifiers changed from: protected */
    public void uninstallLosingOfPassenger() {
        if (GlobalApolloUtils.getStatus("LostandFound_PAX_push_v1")) {
            LocationPerformer.getInstance().removeLocationListener(this.f14459G);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10218a(boolean z) {
        IServingController iServingController;
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (!BusinessDataUtil.onInterceptOrderStatus(order, this.mCurSubStatus)) {
                this.mCurSubStatus = order.substatus;
            }
            Logger logger = this.mLogger;
            logger.info("OnServiceMapFlowDelegate processOrderStatus  status=" + order.status + " substaus=" + order.substatus, new Object[0]);
            if (this.f14481p == 2) {
                if (order.status == 4 && order.substatus == 4006 && !this.f14482q) {
                    doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, true);
                    this.f14482q = true;
                }
            } else if (order.status == 4 || order.status == 1) {
                int i = order.substatus;
                if (i == 2) {
                    IServingController iServingController2 = this.mOnServiceController;
                    if (iServingController2 != null) {
                        iServingController2.onOrderStateChanged(4, (ServingParam) null);
                    }
                } else if (i != 7) {
                    if (!(i == 4003 || i == 4004)) {
                        if (i == 4006) {
                            m10224b(order, z);
                        } else if (i != 4007) {
                            waitForArrival(order, z);
                        }
                    }
                    m10215a(order, z);
                } else {
                    IServingController iServingController3 = this.mOnServiceController;
                    if (iServingController3 != null) {
                        iServingController3.onOrderStateChanged(3, (ServingParam) null);
                    }
                }
                onPostTransformScene();
            } else if (order.status == 7 && order.substatus == 7 && (iServingController = this.mOnServiceController) != null) {
                iServingController.onOrderStateChanged(3, (ServingParam) null);
            }
        } else {
            this.mLogger.info("OnServiceMapFlowDelegate processOrderStatus order is null", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void waitForArrival(CarOrder carOrder, boolean z) {
        IServingController iServingController;
        if (this.f14475i != f14450f) {
            doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, false);
            ServingParam servingParam = getServingParam(carOrder, this.mWaitForArrivalNewSctxRequestInterval, 0);
            if (servingParam != null) {
                GLog.m7965d("zl-sctx-tips", "addSctxStateCallback : waitForArrival");
                this.f14475i = f14450f;
                m10213a(servingParam);
                long b = m10220b(carOrder);
                if (b > 0) {
                    this.mOnServiceController = transformToWaitingForDrivingAppointScene(servingParam);
                    m10204a(b);
                } else if (!z || (iServingController = this.mOnServiceController) == null) {
                    this.mOnServiceController = transformToWaitingForDrivingScene(servingParam);
                } else {
                    iServingController.onOrderStateChanged(0, servingParam);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10214a(CarOrder carOrder) {
        if (carOrder != null && this.f14475i == f14450f) {
            if (carOrder.carDriver != null && carOrder.isBooking() && carOrder.transportTime > 0) {
                CarNotifyManager.buildWaitForArrivalAfter30(this.mContext, carOrder.transportTime, carOrder.carDriver.card, carOrder.carDriver.carType);
            }
            ServingParam servingParam = getServingParam(carOrder, this.mWaitForArrivalNewSctxRequestInterval, 0);
            if (servingParam != null) {
                GLog.m7965d("zl-sctx-tips", "addSctxStateCallback : waitForArrivalAfter30");
                m10213a(servingParam);
                this.mOnServiceController = transformToWaitingForDrivingScene(servingParam);
            }
        }
    }

    /* renamed from: a */
    private void m10215a(CarOrder carOrder, boolean z) {
        if (this.f14475i == f14451g) {
            checkPassengerLate();
            return;
        }
        doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, false);
        doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_EDIT, true);
        m10237d(carOrder, z);
        checkPassengerLate();
        SceneHelper.getInstance().setEtaExecute(false);
    }

    /* renamed from: b */
    private void m10224b(CarOrder carOrder, boolean z) {
        if (this.f14475i != f14452h) {
            doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, true);
            m10232c(carOrder, z);
        }
    }

    /* access modifiers changed from: protected */
    public IServingController getSceneController() {
        return this.mOnServiceController;
    }

    /* access modifiers changed from: protected */
    public ISceneController getSceneController1() {
        ISceneController iSceneController = this.mMiniBusScene;
        if (iSceneController != null) {
            return iSceneController;
        }
        return this.mOnServiceController;
    }

    /* access modifiers changed from: protected */
    public ServingParam getServingParam(CarOrder carOrder, long j, int i) {
        if (BusinessDataUtil.isCarPoolLine(carOrder)) {
            return getCarPoolServingParam(carOrder, j, i);
        }
        return m10203a(carOrder, j, i);
    }

    /* renamed from: g */
    private int m10245g() {
        if (this.drivingMapInfo.mapBubbleMsg == null || this.drivingMapInfo.mapBubbleMsg.size() == 0) {
            return 0;
        }
        for (int i = 0; i < this.drivingMapInfo.mapBubbleMsg.size(); i++) {
            if (this.drivingMapInfo.mapBubbleMsg.get(i).bubbleType == 3) {
                return this.drivingMapInfo.mapBubbleMsg.get(i).positionType;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void clearMockWindowLoadingV2() {
        LoadingInfoWindow loadingInfoWindow = this.f14477k;
        if (loadingInfoWindow != null) {
            loadingInfoWindow.stopLoading();
            this.f14477k = null;
        }
        FindCarCountdownInfoWindowV2 findCarCountdownInfoWindowV2 = this.f14479m;
        if (findCarCountdownInfoWindowV2 != null) {
            findCarCountdownInfoWindowV2.stop(false);
            this.f14479m = null;
        }
    }

    /* renamed from: h */
    private void m10249h() {
        clearMockWindowLoadingV2();
        if (getSceneController() != null) {
            updateInfoWindow(MapElementId.ID_MARKER_START, (View) null);
            updateInfoWindow(MapElementId.ID_MARKER_END, (View) null);
        }
    }

    /* access modifiers changed from: protected */
    public void newCheckPassengerLate() {
        EtaEda etaEda;
        String parseEtaMsg;
        if (CarOrderHelper.getOrder() != null && !FormStore.getInstance().isFromOpenRide()) {
            long j = (long) this.currentTime;
            if (!this.isCancleDown) {
                CharSequence charSequence = null;
                if (!(this.drivingMapInfo.mapBubbleMsg == null || this.drivingMapInfo.mapBubbleMsg.size() == 0)) {
                    for (int i = 0; i < this.drivingMapInfo.mapBubbleMsg.size(); i++) {
                        if (this.drivingMapInfo.mapBubbleMsg.get(i).bubbleType == 3 && (etaEda = this.mEtaEda) != null && etaEda.eta > 0 && (parseEtaMsg = parseEtaMsg(this.drivingMapInfo.mapBubbleMsg.get(i).msg)) != null) {
                            Context context = this.mContext;
                            charSequence = HighlightUtil.highlight(context, parseEtaMsg + Elvish.Companion.getInstance().formatCountdownTime(this.mEtaEda.eta * 60, true));
                        }
                    }
                }
                if (charSequence != null) {
                    showInfoWindowTextOnCar(charSequence, true);
                } else {
                    showInfoWindowTextOnCar(charSequence, false);
                }
            } else if (j <= 0) {
                SimpleRequestMapInfo();
                m10251i();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkPassengerLate() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && !FormStore.getInstance().isFromOpenRide()) {
            String string = ResourcesHelper.getString(this.mContext, R.string.map_flow_info_window_driver_arrival);
            DTSDKOrderDetail.DTSDKPushInfo dTSDKPushInfo = order.prepareSCModel;
            long j = (long) this.currentTime;
            if ((dTSDKPushInfo == null || dTSDKPushInfo.isServiceControl != 1) && !this.isCancleDown) {
                showInfoWindowTextOnCar(string, false);
            } else if (j <= 0) {
                SimpleRequestMapInfo();
                m10251i();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void SimpleRequestMapInfo() {
        XESimpleReqParams xESimpleReqParams = new XESimpleReqParams();
        xESimpleReqParams.requestKey = XERequestKey.REQUEST_KEY_MAP_INFO;
        xESimpleReqParams.bizParams = new HashMap();
        xESimpleReqParams.bizParams.put("oid", CarOrderHelper.getOrderId());
        xESimpleReqParams.bizParams.put("version", 1);
        doPublish(BaseEventKeys.XEngine.EVENT_XENGINE_SIMPLE_REQUEST, xESimpleReqParams);
    }

    /* access modifiers changed from: protected */
    public long calculateLeftTime(long j) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long currentTimeMillis = System.currentTimeMillis();
        Logger logger = this.mLogger;
        logger.info("driver arrived ===> system time is:" + currentTimeMillis + " and calendar time :" + timeInMillis + " and passenger late time :" + j, new Object[0]);
        return Math.max((j - timeInMillis) / 1000, 0);
    }

    /* access modifiers changed from: protected */
    public long getWaitTime(long j, long j2) {
        long j3 = (j2 - j) / 1000;
        if (j3 > 0) {
            j3++;
        }
        return Math.max(j3, 0);
    }

    /* renamed from: i */
    private void m10251i() {
        String str;
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            DTSDKOrderDetail.DTSDKPushInfo dTSDKPushInfo = order.prepareSCModel;
            if (dTSDKPushInfo == null || dTSDKPushInfo.isServiceControl != 1 || TextUtil.isEmpty(dTSDKPushInfo.pushTipsPassengerLateBubble)) {
                str = ResourcesHelper.getString(this.mContext, R.string.map_flow_car_passenger_late_tips);
            } else {
                str = dTSDKPushInfo.pushTipsPassengerLateBubble;
            }
            showInfoWindowTextOnCar(str, false);
            CarNotifyManager.buildPassengerLateNotify(this.mContext);
            doPublish(BaseEventKeys.OnService.EVENT_STATUS_PASSENGER_LATE);
        }
    }

    /* access modifiers changed from: protected */
    public void destroyCountDownV2() {
        if (getSceneController() != null) {
            getSceneController().destroyMarkerBubble(MapElementId.ID_MARKER_CAR);
        }
    }

    /* access modifiers changed from: protected */
    public void showInfoWindowTextOnCar(CharSequence charSequence, boolean z) {
        if (!z) {
            clearMockWindowLoadingV2();
            destroyCountDownV2();
        } else if (charSequence != null && charSequence.length() != 0) {
            OneMessageModel oneMessageModel = new OneMessageModel();
            if (charSequence instanceof String) {
                oneMessageModel.setContent((String) charSequence);
            } else {
                oneMessageModel.setCustomContent(SpannableString.valueOf(charSequence));
            }
            clearMockWindowLoadingV2();
            OneLineInfoWindow infoWindowView = InfoWindowViewFactory.getInfoWindowView(this.mContext, oneMessageModel);
            int g = m10245g();
            if (this.isShowMap && g == 1) {
                updateInfoWindow(MapElementId.ID_MARKER_START, infoWindowView);
            }
        }
    }

    /* renamed from: b */
    private long m10220b(CarOrder carOrder) {
        if (carOrder == null) {
            return 0;
        }
        return (carOrder.transportTime - System.currentTimeMillis()) - ((long) f14448d);
    }

    /* renamed from: a */
    private void m10204a(long j) {
        Timer timer = new Timer();
        this.f14480n = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                Logger logger = OnServiceMapFlowDelegatePresenter.this.mLogger;
                logger.info("OnServiceMapFlowDelegatePresenter timer excue" + System.currentTimeMillis(), new Object[0]);
                if (OnServiceMapFlowDelegatePresenter.this.f14475i == OnServiceMapFlowDelegatePresenter.f14450f) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            OnServiceMapFlowDelegatePresenter.this.m10214a(CarOrderHelper.getOrder());
                        }
                    });
                }
                OnServiceMapFlowDelegatePresenter.this.m10253j();
            }
        }, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m10253j() {
        Timer timer = this.f14480n;
        if (timer != null) {
            timer.cancel();
            this.f14480n = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        IPopSugSceneController iPopSugSceneController = this.f14487v;
        if (iPopSugSceneController == null) {
            return super.onBackPressed(backType);
        }
        iPopSugSceneController.closeSugSession();
        m10255k();
        return true;
    }

    /* access modifiers changed from: protected */
    public void enterSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        boolean z = false;
        this.mLogger.info("OnServiceMapFlowDelegatePresenter enterSugPageScene..", new Object[0]);
        if (address == null) {
            this.mLogger.error("OnServiceMapFlowDelegatePresenter target is empty", new Object[0]);
            return;
        }
        this.mIsShowingUpdatePickUp = false;
        BaseEventPublisher.getPublisher().publish("event_show_sug_page_container");
        this.mPoiChangedAddress = address;
        List<WayPoint> wayPointAddressList = FormStore.getInstance().getWayPointAddressList();
        if (wayPointAddressList != null && wayPointAddressList.size() > 0) {
            z = true;
        }
        SystemUtils.log(6, "ccc", "enterSugPageScene hasWayPoint", (Throwable) null, "com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter", 1609);
        if (z) {
            enterNewSugPageScene(i, address, fromType, iSugSceneCallback);
        } else {
            enterOldSugPageScene(i, address, fromType, iSugSceneCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void enterNewSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        SystemUtils.log(6, "ccc", "enterNewSugPageScene", (Throwable) null, "com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter", 1626);
        SugParams createSugPageAddressParam = AddressUtil.createSugPageAddressParam(this.mContext, i, address);
        createSugPageAddressParam.fromType = fromType;
        AddressParam addressParam = createSugPageAddressParam.addressParam;
        addressParam.departure_time = FormStore.getInstance().getTransportTime() + "";
        createSugPageAddressParam.wayPointParam.setWayPointTypes(getEditableWayPointsType());
        createSugPageAddressParam.wayPointParam.setWayPoints(getWayPoints());
        createSugPageAddressParam.wayPointParam.setAddDefaultWayPoint(false);
        this.f14487v = transformToPopSugPageScene(new PopSugSceneParam.Builder().sugSceneCallback(iSugSceneCallback).sugParams(createSugPageAddressParam).context(this.mContext).mapChangeListener(this.mMapChangeListener).build());
        doPublish(BaseEventKeys.Service.EVENT_HOME_SHOWN_SUG_PAGE);
    }

    /* access modifiers changed from: protected */
    public void enterOldSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        SystemUtils.log(6, "ccc", "enterOldSugPageScene", (Throwable) null, "com.didi.component.mapflow.presenter.OnServiceMapFlowDelegatePresenter", 1660);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m10255k() {
        this.mLogger.info("OnServiceMapFlowDelegatePresenter leaveSugPage..", new Object[0]);
        BaseEventPublisher.getPublisher().publish("event_hide_sug_page_container");
        m10257l();
        this.f14487v = null;
    }

    /* renamed from: l */
    private void m10257l() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            Logger logger = this.mLogger;
            logger.info("OnServiceMapFlowDelegate resetMapFlow  status=" + order.status + " substaus=" + order.substatus, new Object[0]);
            if (order.status == 4 || order.status == 1) {
                switch (order.substatus) {
                    case 4003:
                    case 4004:
                    case 4007:
                        if (this.f14475i == f14451g) {
                            m10237d(order, false);
                            break;
                        }
                        break;
                    case 4006:
                        if (this.f14475i == f14452h) {
                            m10232c(order, false);
                            break;
                        }
                        break;
                    default:
                        if (this.f14475i == f14450f) {
                            m10231c(order);
                            break;
                        }
                        break;
                }
                onPostTransformScene();
                IServingController iServingController = this.mOnServiceController;
                if (iServingController != null) {
                    iServingController.doBestView(getCurrentPadding());
                    return;
                }
                return;
            }
            return;
        }
        this.mLogger.info("OnServiceMapFlowDelegate resetMapFlow order is null", new Object[0]);
    }

    /* renamed from: c */
    private void m10232c(CarOrder carOrder, boolean z) {
        IServingController iServingController;
        ServingParam servingParam = getServingParam(carOrder, this.mOnServiceNewSctxRequestInterval, 2);
        if (servingParam != null) {
            this.f14475i = f14452h;
            GLog.m7965d("zl-sctx-tips", "removeSctxStateCallback : mapSwitchToOnService");
            if (z && (iServingController = this.mOnServiceController) != null) {
                iServingController.onOrderStateChanged(2, servingParam);
            }
            this.mOnServiceController = transformToInServiceScene(servingParam);
            m10243f();
            IServingController iServingController2 = this.mOnServiceController;
            if (iServingController2 != null) {
                DriverPosUtils.setLatLng(iServingController2.getLastDriverPosition());
            }
            m10249h();
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ONSERVICE);
        }
    }

    /* renamed from: d */
    private void m10237d(CarOrder carOrder, boolean z) {
        IServingController iServingController;
        ServingParam servingParam = getServingParam(carOrder, this.mWaitForArrivalNewSctxRequestInterval, 1);
        if (servingParam != null) {
            this.f14475i = f14451g;
            GLog.m7965d("zl-sctx-tips", "removeSctxStateCallback : mapSwitchToDriverArrival");
            if (!z || (iServingController = this.mOnServiceController) == null) {
                this.mOnServiceController = transformToWaitingForDrivingScene(servingParam);
                m10243f();
                return;
            }
            iServingController.onOrderStateChanged(1, servingParam);
        }
    }

    /* renamed from: c */
    private void m10231c(CarOrder carOrder) {
        ServingParam servingParam = getServingParam(carOrder, this.mWaitForArrivalNewSctxRequestInterval, 0);
        if (servingParam != null) {
            GLog.m7965d("zl-sctx-tips", "addSctxStateCallback : mapSwitchToWaitDriving");
            m10213a(servingParam);
            if (m10220b(carOrder) <= 0) {
                this.mOnServiceController = transformToWaitingForDrivingScene(servingParam);
            } else if (this.f14480n == null) {
                this.mOnServiceController = transformToWaitingForDrivingScene(servingParam);
            } else {
                this.mOnServiceController = transformToWaitingForDrivingAppointScene(servingParam);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addExtraParams(OrderParams orderParams) {
        DTSDKOrderDetail.DTSDKMapRequestData dTSDKMapRequestData;
        DTSDKOrderDetail.DTSDKMapData dTSDKMapData = CarOrderHelper.getOrder().mapData;
        if (dTSDKMapData != null && (dTSDKMapRequestData = dTSDKMapData.requestData) != null) {
            orderParams.stationWalkGuideLink = dTSDKMapRequestData.stationWalkGuideLink;
            orderParams.stationWalkGuidePhoto = dTSDKMapRequestData.walkGuidePhoto;
        }
    }

    /* renamed from: a */
    private ServingParam m10203a(CarOrder carOrder, long j, int i) {
        String str;
        long j2;
        CarOrder carOrder2 = carOrder;
        OrderComManager.getInstance().isShowBlueToothEntrance = false;
        String str2 = null;
        if (carOrder2 == null || carOrder2.startAddress == null || carOrder2.endAddress == null) {
            this.mLogger.error("OnServiceMapFlowDelegate getServingParam order is null", new Object[0]);
            return null;
        }
        String str3 = "";
        if (carOrder2.carDriver != null) {
            j2 = NumberUtil.strToLong(carOrder2.carDriver.did);
            str = carOrder2.carDriver.card;
        } else {
            j2 = 0;
            str = str3;
        }
        OrderParams createOrderParams = createOrderParams(carOrder2.oid, j2, j, i, this.mFromPageId);
        createOrderParams.productID = String.valueOf(carOrder2.productid);
        createOrderParams.licensePlateNumber = str;
        createOrderParams.srcTag = carOrder2.startAddress.srcTag;
        createOrderParams.orderType = carOrder2.orderType;
        createOrderParams.isShowExtendedAnimation = true;
        createOrderParams.pickupExtendedAnimDurationInMs = 1000;
        if (this.mBusinessContext.getCountryInfo() != null) {
            str2 = this.mBusinessContext.getCountryInfo().getCountryIsoCode();
        }
        ClientParams clientParams = new ClientParams(SystemUtil.getVersionName(this.mContext), str2, SystemUtil.getIMEI());
        createOrderParams.lastOrderId = carOrder2.lastOrderId;
        CommonMarkerParam.Builder builder = new CommonMarkerParam.Builder();
        C616924 r4 = new IPassPointStatusCallback() {
            public void onPassPointStatusCallback(boolean z) {
                if (OnServiceMapFlowDelegatePresenter.this.f14489x != z) {
                    boolean unused = OnServiceMapFlowDelegatePresenter.this.f14489x = z;
                    OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Service.EVENT_POINT_PASSED_OF_CONTINUOUS_ORDERS, Boolean.valueOf(z));
                }
            }
        };
        ClientParams clientParams2 = clientParams;
        LatLng latLng = new LatLng(carOrder2.startAddress.latitude, carOrder2.startAddress.longitude);
        LatLng latLng2 = new LatLng(carOrder2.endAddress.latitude, carOrder2.endAddress.longitude);
        this.mLogger.info("OnServiceMapFlowDelegate getServingParam oid=" + carOrder2.oid + " driverId=" + j2 + " countryId=" + str2 + " startLatLng=" + latLng + " endLatLng=" + latLng2, new Object[0]);
        Drawable drawable = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_pick_up);
        Drawable drawable2 = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_destination);
        if (!GlobalApolloUtil.isNewUpdatePickUp()) {
            str3 = carOrder2.startAddress.getDisplayName();
        }
        addExtraParams(createOrderParams);
        CommonMarkerParam commonMarkerParam = new CommonMarkerParam(builder);
        HashMap hashMap = new HashMap();
        CommonMarkerParam commonMarkerParam2 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng).markerIcon(ImageUtil.Drawable2Bitmap(drawable)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_START).poiId(carOrder2.startAddress.uid).addressName(str3).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        CommonMarkerParam commonMarkerParam3 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng2).markerIcon(ImageUtil.Drawable2Bitmap(drawable2)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_END).addressName(carOrder2.endAddress.getDisplayName()).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        hashMap.put(MapElementId.ID_MARKER_START, commonMarkerParam2);
        hashMap.put(MapElementId.ID_MARKER_END, commonMarkerParam3);
        hashMap.put(MapElementId.ID_MARKER_WAYPOINT, commonMarkerParam);
        ServingParam.Builder passBTMStatusCallback = new ServingParam.Builder().context(this.mContext).isNewVersion(true).markerParams(hashMap).carBitmapDescriptor(this.mCarBitmapDescriptor).orderParams(createOrderParams).showGuideEntrance(true).clientParams(clientParams2).etaEdaCallback(this.mEtaEdaCallback).guideEntranceCallback(this.mIGuideEntranceCallback).mapChangeListener(this.mMapChangeListener).secRouteInfoCallback(new ISecRouteInfoCallback() {
            public void showSecRouteInfoCallback(SecRouteInfoEx secRouteInfoEx, boolean z) {
                GLog.m7964d("showSecRouteInfoCallback:show " + z);
                if (z) {
                    OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW, secRouteInfoEx);
                } else {
                    OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_CARD_HIDE);
                }
            }
        }).eventCallback(new IEventCallback() {
            public void onEventCallback(String str, String str2) {
                GLog.m7964d("onEventCallback:eventType： " + str);
                if (str.equals(EventDescribe.RecommendPickupDismissTips)) {
                    OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.OnService.EVENT_RECOMMEND_BOARDING_POINT_SHOW_TOAST);
                }
                if (str.equals(EventDescribe.BubblePageTips) || str.equals(EventDescribe.GoingOffCourse)) {
                    OnServiceMapFlowDelegatePresenter onServiceMapFlowDelegatePresenter = OnServiceMapFlowDelegatePresenter.this;
                    if (str2 == null) {
                        str2 = "";
                    }
                    onServiceMapFlowDelegatePresenter.doPublish(BaseEventKeys.OnService.EVENT_MAP_ROUTE_DESCRIBE, str2);
                }
            }
        }).passBTMStatusCallback(new IPassBTMStatusCallback() {
            public void showBTMEntry(boolean z) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ENTRANCE_SHOW, Boolean.valueOf(z));
                OrderComManager.getInstance().isShowBlueToothEntrance = z;
                OnServiceMapFlowDelegatePresenter.this.traceBlueMeetShowEvent();
            }
        });
        hashMap.put(MapElementId.ID_MARKER_ODPOINT, new CommonMarkerParam(new CommonMarkerParam.Builder()));
        if (m10267q()) {
            passBTMStatusCallback.odPointsExpiredCallback(new IOdPointsExpiredCallback() {
                public void onOdPointsExpired() {
                    OnServiceMapFlowDelegatePresenter.this.m10265p();
                }
            });
            createOrderParams.odPoints = m10261n();
            createOrderParams.odPointsTimestamp = m10262o();
        }
        passBTMStatusCallback.markerParams(hashMap).orderParams(createOrderParams).bReadOnly(carOrder.isSplitFareUser()).car3DIcons(this.mCache3DList).oraOrderStageCallback(this.mIOraOrderStageCallback);
        passBTMStatusCallback.passPointStatusCallback(r4);
        passBTMStatusCallback.tripStateCallback(this.iTripStateCallback);
        return new ServingParam(passBTMStatusCallback);
    }

    /* access modifiers changed from: protected */
    public void traceBlueMeetShowEvent() {
        HashMap hashMap = new HashMap();
        if (CarOrderHelper.getOrder() != null) {
            hashMap.put("order_id", CarOrderHelper.getOrder().oid);
        }
        EtaEda etaEda = this.mEtaEda;
        if (etaEda != null) {
            hashMap.put("distance", Integer.valueOf(etaEda.eda));
        }
        hashMap.put("showguide", Boolean.valueOf(!GlobalSPUtil.isBluetoothMeetGuideShown(this.mContext)));
        GlobalOmegaUtils.trackEvent("map_btnavi_paxbt1_bt", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public ServingParam getCarPoolServingParam(CarOrder carOrder, long j, int i) {
        String str;
        FlierPoolStationModel flierPoolStationModel;
        CarOrder carOrder2 = carOrder;
        String str2 = null;
        if (carOrder2 == null || carOrder2.startAddress == null || carOrder2.endAddress == null) {
            this.mLogger.error("OnServiceMapFlowDelegate getServingParam order is null", new Object[0]);
            return null;
        }
        long j2 = 0;
        if (carOrder2.carDriver != null) {
            j2 = NumberUtil.strToLong(carOrder2.carDriver.did);
            str = carOrder2.carDriver.card;
        } else {
            str = "";
        }
        long j3 = j2;
        String str3 = str;
        OrderParams createOrderParams = createOrderParams(carOrder2.oid, j3, j, i, this.mFromPageId);
        createOrderParams.productID = String.valueOf(carOrder2.productid);
        createOrderParams.licensePlateNumber = str3;
        createOrderParams.srcTag = carOrder2.startAddress.srcTag;
        createOrderParams.orderType = carOrder2.orderType;
        createOrderParams.isShowExtendedAnimation = true;
        createOrderParams.pickupExtendedAnimDurationInMs = 1000;
        createOrderParams.lastOrderId = carOrder2.lastOrderId;
        m10212a(createOrderParams, carOrder2);
        if (this.mBusinessContext.getCountryInfo() != null) {
            str2 = this.mBusinessContext.getCountryInfo().getCountryIsoCode();
        }
        ClientParams clientParams = new ClientParams(SystemUtil.getVersionName(this.mContext), str2, SystemUtil.getIMEI());
        CommonMarkerParam commonMarkerParam = new CommonMarkerParam(new CommonMarkerParam.Builder());
        LatLng latLng = new LatLng(carOrder2.startAddress.latitude, carOrder2.startAddress.longitude);
        FlierFeature flierFeature = carOrder2.flierFeature;
        if (!(flierFeature == null || (flierPoolStationModel = flierFeature.flierPoolStationModel) == null)) {
            latLng.latitude = flierPoolStationModel.lat;
            latLng.longitude = flierPoolStationModel.lng;
        }
        LatLng latLng2 = new LatLng(carOrder2.endAddress.latitude, carOrder2.endAddress.longitude);
        Logger logger = this.mLogger;
        logger.info("OnServiceMapFlowDelegate getServingParam oid=" + carOrder2.oid + " driverId=" + j3 + " countryId=" + str2 + " startLatLng=" + latLng + " endLatLng=" + latLng2, new Object[0]);
        DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.pin_pickup_icon);
        DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.pin_dropoff_icon);
        CommonMarkerParam.Builder builder = new CommonMarkerParam.Builder();
        builder.mo75597id(MapElementId.ID_MARKER_ODPOINT);
        CommonMarkerParam commonMarkerParam2 = new CommonMarkerParam(builder);
        addExtraParams(createOrderParams);
        Drawable drawable = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_pick_up);
        Drawable drawable2 = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_destination);
        CommonMarkerParam commonMarkerParam3 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng).markerIcon(ImageUtil.Drawable2Bitmap(drawable)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_START).poiId(carOrder2.startAddress.uid).addressName(carOrder2.startAddress.getDisplayName()).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        CommonMarkerParam commonMarkerParam4 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng2).markerIcon(ImageUtil.Drawable2Bitmap(drawable2)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_END).addressName(carOrder2.endAddress.getDisplayName()).addressNameColorResId(R.color.global_driving_start_end_marker_color));
        HashMap hashMap = new HashMap();
        hashMap.put(MapElementId.ID_MARKER_START, commonMarkerParam3);
        hashMap.put(MapElementId.ID_MARKER_END, commonMarkerParam4);
        hashMap.put(MapElementId.ID_MARKER_WAYPOINT, commonMarkerParam);
        hashMap.put(MapElementId.ID_MARKER_ODPOINT, commonMarkerParam2);
        ServingParam.Builder passBTMStatusCallback = new ServingParam.Builder().context(this.mContext).isNewVersion(true).markerParams(hashMap).carBitmapDescriptor(this.mCarBitmapDescriptor).orderParams(createOrderParams).showGuideEntrance(true).clientParams(clientParams).etaEdaCallback(this.mEtaEdaCallback).guideEntranceCallback(this.mIGuideEntranceCallback).mapChangeListener(this.mMapChangeListener).passBTMStatusCallback(new IPassBTMStatusCallback() {
            public void showBTMEntry(boolean z) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ENTRANCE_SHOW, Boolean.valueOf(z));
                OrderComManager.getInstance().isShowBlueToothEntrance = z;
                OnServiceMapFlowDelegatePresenter.this.traceBlueMeetShowEvent();
            }
        });
        passBTMStatusCallback.oraOrderStageCallback(this.mIOraOrderStageCallback);
        passBTMStatusCallback.tripStateCallback(this.iTripStateCallback);
        return new ServingParam(passBTMStatusCallback);
    }

    /* renamed from: a */
    private void m10212a(OrderParams orderParams, CarOrder carOrder) {
        if (carOrder != null) {
            orderParams.travelId = carOrder.travelid;
            orderParams.carpoolStartIcon = ((BitmapDrawable) DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.carpool_people_start_icon)).getBitmap();
            orderParams.carpoolEndIcon = ((BitmapDrawable) DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.carpool_people_end_icon)).getBitmap();
        }
    }

    /* access modifiers changed from: protected */
    public void updateInfoWindow(MapElementId mapElementId, final View view) {
        updateInfoWindowInMainThread(new Runnable() {
            public void run() {
                if (OnServiceMapFlowDelegatePresenter.this.getSceneController() != null) {
                    OnServiceMapFlowDelegatePresenter.this.getSceneController().updateMarkerBubble(MapElementId.ID_MARKER_CAR, view);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void updateInfoWindowInMainThread(final Runnable runnable) {
        if (runnable != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        runnable.run();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10227b(boolean z) {
        this.mIsShowingUpdatePickUp = true;
        if (this.f14478l == null) {
            EditWithTipsModel editWithTipsModel = new EditWithTipsModel();
            this.f14478l = editWithTipsModel;
            editWithTipsModel.setContent(ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_pop_update_pick_up_message));
        }
        if (z) {
            this.f14478l.setTips(ResourcesHelper.getString(this.mContext, R.string.map_flow_on_service_update_pick_tips));
        } else {
            this.f14478l.setTips("");
        }
        EditInfoWindow infoWindowView = InfoWindowViewFactory.getInfoWindowView(this.mContext, this.f14478l);
        getSceneController().destroyMarkerBubble(MapElementId.ID_MARKER_START);
        getSceneController().updateMarkerBubble(MapElementId.ID_MARKER_START, infoWindowView);
        if (FormStore.getInstance().isFromOpenRide() || CarOrderHelper.getOrder().isSplitFareUser()) {
            getSceneController().setInfoWindowClickListener(MapElementId.ID_MARKER_START, (OnInfoWindowClickListener) null);
        } else {
            getSceneController().setInfoWindowClickListener(MapElementId.ID_MARKER_START, this.f14474c);
        }
        if (CarOrderHelper.getOrder().isSplitFareUser()) {
            getSceneController().hideMarkerBubble(MapElementId.ID_MARKER_START);
        }
    }

    /* access modifiers changed from: protected */
    public void showNewWaitArrivalInfoWindow() {
        this.f14490y.setData(this.f14491z);
        this.mOnServiceController.updateMarkerBubble(MapElementId.ID_MARKER_START, this.f14490y);
        if (this.f14491z.isShowEdit()) {
            this.mOnServiceController.setInfoWindowClickListener(MapElementId.ID_MARKER_START, this.f14474c);
        } else {
            this.mOnServiceController.setInfoWindowClickListener(MapElementId.ID_MARKER_START, (OnInfoWindowClickListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public Padding getCurrentPadding() {
        return super.getCurrentPadding();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m10259m() {
        if (this.mOnServiceController != null && m10267q()) {
            this.mOnServiceController.setOdPoints(m10261n(), m10262o());
        }
    }

    /* renamed from: n */
    private List<OdPoint> m10261n() {
        ArrayList arrayList = new ArrayList();
        if (CarOrderHelper.getOrder().wayPointList != null) {
            for (WayPoint next : CarOrderHelper.getOrder().wayPointList) {
                if (next.getTripState() == 0) {
                    arrayList.add(new OdPoint.Builder().orderId(0L).odType(1).point(new DoublePoint.Builder().lat(Float.valueOf((float) next.getAddress().getLatitude())).lng(Float.valueOf((float) next.getAddress().getLongitude())).build()).strOrderId(CarOrderHelper.getOrder().oid).pointType(2).build());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: o */
    private long m10262o() {
        if (TextUtils.isEmpty(CarOrderHelper.getOrder().wayPointsVersion) || "null".equals(CarOrderHelper.getOrder().wayPointsVersion)) {
            return 0;
        }
        return Long.parseLong(CarOrderHelper.getOrder().wayPointsVersion);
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m10265p() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            TravelUtil.getOrderDetail(this.mComponentProxy.getSession(), order.oid, new ITravelOrderListener() {
                public void onError(int i, String str) {
                }

                public void onFail(int i, String str) {
                }

                public void onTimeout(String str) {
                }

                public void onSuccess(ICarOrder iCarOrder) {
                    OnServiceMapFlowDelegatePresenter.this.m10259m();
                    OnServiceMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED);
                }
            });
        }
    }

    /* renamed from: q */
    private boolean m10267q() {
        CarOrder order = CarOrderHelper.getOrder();
        return (order == null || order.updateWayPoint == null || order.updateWayPoint.updateIsOk != 0) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void onPostTransformScene() {
        setGoogloLogoPlace();
    }

    /* access modifiers changed from: protected */
    public void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        IServingController iServingController = this.mOnServiceController;
        if (iServingController != null) {
            iServingController.refreshCarBitmapDescriptor(bitmapDescriptor);
        }
    }

    /* access modifiers changed from: protected */
    public void refresh3DCard(List<String> list) {
        IServingController iServingController = this.mOnServiceController;
        if (iServingController != null) {
            iServingController.refresh3DCarIcons(true, list);
        }
    }

    /* access modifiers changed from: protected */
    public void forwardUpdatePickupPage() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
        bundle.putBoolean(BaseExtras.ConfirmService.EXTRA_CONFIRM_GET_ON_SCENE, true);
        forward(1035, bundle);
    }

    /* renamed from: a */
    private void m10205a(final CircleCountWrapper circleCountWrapper) {
        FindCarCountdownInfoWindowV2 infoWindowViewV2 = InfoWindowViewFactory.getInfoWindowViewV2(this.mContext);
        this.f14479m = infoWindowViewV2;
        infoWindowViewV2.init(circleCountWrapper.getCount(), circleCountWrapper.getInitCount(), 1, new CountDownCallback() {
            public void onFinish() {
                CircleCountWrapper circleCountWrapper = circleCountWrapper;
                if (circleCountWrapper != null && circleCountWrapper.getCallback() != null) {
                    circleCountWrapper.getCallback().onFinish();
                }
            }

            public void onTick(long j) {
                CircleCountWrapper circleCountWrapper = circleCountWrapper;
                if (circleCountWrapper != null && circleCountWrapper.getCallback() != null) {
                    circleCountWrapper.getCallback().onTick(j);
                    OnServiceMapFlowDelegatePresenter.this.showCountDownV2();
                }
            }
        });
        this.f14479m.start();
        showCountDownV2();
    }

    /* access modifiers changed from: protected */
    public void showCountDownV2() {
        CarOrder order = CarOrderHelper.getOrder();
        int i = 0;
        for (int i2 = 0; i2 < this.drivingMapInfo.mapBubbleMsg.size(); i2++) {
            if (this.drivingMapInfo.mapBubbleMsg.get(i2).bubbleType == 2) {
                i = this.drivingMapInfo.mapBubbleMsg.get(i2).positionType;
            }
        }
        if (order == null || i != 5) {
            updateInfoWindow(MapElementId.ID_MARKER_START, this.f14479m);
        } else {
            updateInfoWindow(MapElementId.ID_MARKER_CAR, this.f14479m);
        }
    }

    /* renamed from: r */
    private boolean m10269r() {
        return !m10273t() && !m10275u();
    }

    /* renamed from: s */
    private boolean m10271s() {
        return FormStore.getInstance().isFromOpenRide();
    }

    /* renamed from: t */
    private boolean m10273t() {
        return BusinessDataUtil.isCarPoolLine(CarOrderHelper.getOrder());
    }

    /* renamed from: u */
    private boolean m10275u() {
        CarOrder order = CarOrderHelper.getOrder();
        return order != null && order.isTwoPriceScene();
    }

    /* access modifiers changed from: protected */
    public String parseEtaMsg(String str) {
        return str.substring(0, str.indexOf(Const.joLeft));
    }
}
