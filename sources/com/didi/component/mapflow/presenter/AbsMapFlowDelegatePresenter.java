package com.didi.component.mapflow.presenter;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.fragment.app.FragmentActivity;
import com.didi.address.FromType;
import com.didi.address.SugBuild;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.ResetMapEvent;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.MapUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.common.helper.Car3dHelper;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.common.util.AddressUtil;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.anim.AnimNewUI;
import com.didi.component.mapflow.carsliding.IconHelper;
import com.didi.component.mapflow.view.IMapFlowDelegateView;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.MapFlowView;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.global.IDeparturePinInfo;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.map.global.flow.scene.mainpage.MainPageSceneParam;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.pre.IMiniBusConfirmSceneController;
import com.didi.map.global.flow.scene.minibus.scene.pre.MiniBusConfirmSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusAppointParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusSctxSceneParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusTripSceneState;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.global.flow.scene.order.confirm.normal.IOrderConfirmController;
import com.didi.map.global.flow.scene.order.confirm.normal.OrderConfirmSceneParam;
import com.didi.map.global.flow.scene.order.serving.ILockScreenServingController;
import com.didi.map.global.flow.scene.order.serving.IOraOrderStageCallback;
import com.didi.map.global.flow.scene.order.serving.IServingController;
import com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.order.serving.param.ServiceOverParam;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.order.waiting.IWaitingForReplyController;
import com.didi.map.global.flow.scene.order.waiting.WaitingForReplyParam;
import com.didi.map.global.flow.scene.order.waiting.p123v2.IWaitingForReplyControllerV2;
import com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingForReplyParamV2;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.scene.simple.ISimpleMapSceneController;
import com.didi.map.global.flow.scene.simple.params.SimpleSceneParams;
import com.didi.map.global.flow.scene.sug.IPopSugSceneController;
import com.didi.map.global.flow.scene.sug.ISubmitWayPointsCallback;
import com.didi.map.global.flow.scene.sug.ISugSceneCallback;
import com.didi.map.global.flow.scene.sug.ISugTransferAnimator;
import com.didi.map.global.flow.scene.sug.PopSugSceneParam;
import com.didi.map.global.flow.scene.sug.SugResult;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.messagecenter.p152pb.OrderStat;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.util.SideBarBusinessUtil;
import com.didi.sdk.util.MixFlagUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.core.order.OrderService;
import com.didi.travel.psnger.model.response.CarMoveBean;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.MapLineInfo;
import com.didi.travel.psnger.model.response.MarkerInfo;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.StationBoardHintModel;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.poll.ExpressOrderStatusPoll;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.travel.psnger.utils.TextUtil;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public abstract class AbsMapFlowDelegatePresenter extends AbsLoadingPresenter<IMapFlowDelegateView> {
    protected static final float ICON_ANCHOR_X = 0.5f;
    protected static final float ICON_ANCHOR_Y = 0.5f;

    /* renamed from: a */
    private static final String f14379a = "check_status";

    /* renamed from: b */
    private final String f14380b = getClass().getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Logger f14381c = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f14382d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f14383e = 0;

    /* renamed from: f */
    private float f14384f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f14385g;
    protected int googloLogoPaddding = 0;

    /* renamed from: h */
    private int f14386h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f14387i = "";
    protected boolean is_start_address_new_select;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f14388j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f14389k = 40;

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<Integer> f14390l = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if ("home".equals(AbsMapFlowDelegatePresenter.this.f14387i)) {
                AbsMapFlowDelegatePresenter absMapFlowDelegatePresenter = AbsMapFlowDelegatePresenter.this;
                int intValue = num.intValue();
                int intValue2 = num.intValue();
                if (intValue != 0) {
                    intValue2 += AbsMapFlowDelegatePresenter.this.mContext.getResources().getDimensionPixelOffset(R.dimen._10dip);
                }
                int unused = absMapFlowDelegatePresenter.f14383e = intValue2;
                AbsMapFlowDelegatePresenter absMapFlowDelegatePresenter2 = AbsMapFlowDelegatePresenter.this;
                final int newHeightWithUIOffset = absMapFlowDelegatePresenter2.getNewHeightWithUIOffset(absMapFlowDelegatePresenter2.f14385g);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        int bizBarHeight = AbsMapFlowDelegatePresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                        AbsMapFlowDelegatePresenter.this.googloLogoPaddding = (-((((-newHeightWithUIOffset) - bizBarHeight) - AbsMapFlowDelegatePresenter.this.f14383e) + AbsMapFlowDelegatePresenter.this.getCurrentPadding().bottom)) + AbsMapFlowDelegatePresenter.this.f14388j + AbsMapFlowDelegatePresenter.this.f14389k;
                        AbsMapFlowDelegatePresenter.this.setGoogloLogoPlace();
                    }
                }, 100);
            }
        }
    };
    protected BusinessContext mBusinessContext;
    protected List<String> mCache3DList = null;
    protected ICarBitmapDescriptor mCarBitmapDescriptor = new ICarBitmapDescriptor() {
        public BitmapDescriptor getBitmapDescriptor() {
            AbsMapFlowDelegatePresenter.this.f14381c.info("onservice map getBitmapDescriptor", new Object[0]);
            return IconHelper.getInstance().getSmoothDriverIcon(AbsMapFlowDelegatePresenter.this.mContext.getApplicationContext(), AbsMapFlowDelegatePresenter.this.f14382d, R.drawable.global_mapflow_default_car_icon);
        }

        public BitmapDescriptor getDefaultBitmapDescriptor() {
            AbsMapFlowDelegatePresenter.this.f14381c.info("onservice map getDefaultBitmapDescriptor", new Object[0]);
            return IconHelper.getInstance().getSmoothDriverIcon(AbsMapFlowDelegatePresenter.this.mContext.getApplicationContext(), AbsMapFlowDelegatePresenter.this.f14382d, R.drawable.global_mapflow_default_car_icon);
        }
    };
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mClearMapScene = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE.equals(str)) {
                AbsMapFlowDelegatePresenter.this.clearMapScene();
            }
        }
    };
    /* access modifiers changed from: protected */
    public Padding mCurrentPadding;
    protected IDeparturePinInfo mDeparturePinInfo = new DeparturePinInfo() {
        public boolean getFenceVisible() {
            return true;
        }

        public boolean getRecommendVisible() {
            return true;
        }
    };
    protected ISugSceneCallback mGlobalSugCallback = new ISugSceneCallback() {
        public /* synthetic */ void onCancelButtonPressed() {
            ISugSceneCallback.CC.$default$onCancelButtonPressed(this);
        }

        public void setResult(SugResult sugResult) {
            SystemUtils.log(6, "ccc", "setResult 2  publish  EVENT_SUG_PAGE_RESULT_CALLBACK", (Throwable) null, "com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter$7", 412);
            FormStore.getInstance().updateStartAddressSrcTypeBySug();
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_SUG_PAGE_RESULT_CALLBACK, sugResult);
        }

        public void onStartChoosen(Address address) {
            AbsMapFlowDelegatePresenter.this.setStartAddress(address);
        }

        public void onSugSessionClosed() {
            SystemUtils.log(6, "ccc", "onSugSessionClosed doPublish（EVENT_HOME_HIDE_SUG_PAGE）", (Throwable) null, "com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter$7", 424);
            AbsMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Service.EVENT_HOME_HIDE_SUG_PAGE);
            AbsMapFlowDelegatePresenter.this.onSugSessionClosed();
            FormStore.getInstance().setMapSelectOper(SugParams.MapSelectOper.OTHER);
        }

        public ISugTransferAnimator getSwitchAnimator() {
            return new ISugTransferAnimator() {
                public /* synthetic */ Animator getSecondaryPageEnterAnimator() {
                    return ISugTransferAnimator.CC.$default$getSecondaryPageEnterAnimator(this);
                }

                public /* synthetic */ Animator getSecondaryPageExitAnimator() {
                    return ISugTransferAnimator.CC.$default$getSecondaryPageExitAnimator(this);
                }

                public Animator getEnterAnimator() {
                    return AnimNewUI.getEnterTranslationX(AbsMapFlowDelegatePresenter.this.mContext);
                }

                public Animator getExitAnimator() {
                    return AnimNewUI.getExitTranslationX(AbsMapFlowDelegatePresenter.this.mContext);
                }
            };
        }

        public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
            AbsMapFlowDelegatePresenter.this.onSubmitWayPoints(fragmentActivity, list, list2, iSubmitWayPointsCallback);
            Bundle bundle = new Bundle();
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            if (AbsMapFlowDelegatePresenter.this.mComponentProxy.getSession() == null) {
                bundle = TravelUtil.getBundleOnCreateSession(bundle, true, TravelConstant.SESSION_TAG_NEW_SUG_WAY_POINT_CONFIRM, false);
            }
            if (!NationComponentDataUtil.isLoginNow()) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_SUG_PAGE_WAYPOINTS_RESULT_CALLBACK, bundle);
            } else {
                AbsMapFlowDelegatePresenter.this.forward(1030, bundle);
            }
        }

        public void onOpenWebUrl(String str) {
            AbsMapFlowDelegatePresenter.this.openWebActivity(str);
        }

        public void onStartEndAddressChanged(Address address, Address address2) {
            if (address != null) {
                FormStore.getInstance().setStartAddress(address);
            }
            if (address2 != null) {
                FormStore.getInstance().setEndAddress(address2);
            }
        }
    };
    protected IOraOrderStageCallback mIOraOrderStageCallback = new IOraOrderStageCallback() {
        public void onAbnormal(int i) {
            GLog.m7965d("check_status", "onAbnormal");
            if (AbsMapFlowDelegatePresenter.this.m10080a(i) && AbsMapFlowDelegatePresenter.this.mOrderStatusPoll != null) {
                AbsMapFlowDelegatePresenter.this.mOrderStatusPoll.startPoll((Scene) null);
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mJarvisVisibilityListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = AbsMapFlowDelegatePresenter.this.f14388j = num.intValue();
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    int newHeightWithUIOffset = AbsMapFlowDelegatePresenter.this.getNewHeightWithUIOffset(AbsMapFlowDelegatePresenter.this.f14385g);
                    int bizBarHeight = AbsMapFlowDelegatePresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                    AbsMapFlowDelegatePresenter.this.googloLogoPaddding = (-((((-newHeightWithUIOffset) - bizBarHeight) - AbsMapFlowDelegatePresenter.this.f14383e) + AbsMapFlowDelegatePresenter.this.f14385g)) + AbsMapFlowDelegatePresenter.this.f14388j + UiUtils.dip2px(AbsMapFlowDelegatePresenter.this.mContext, 20.0f);
                    AbsMapFlowDelegatePresenter.this.setGoogloLogoPlace();
                }
            }, 100);
        }
    };
    protected ILineSelectedListener mLineSelectedListener = new ILineSelectedListener() {
        public void routeSelected(long j, long j2) {
            if (j != 0) {
                AbsMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }
    };
    protected IMapChangeListener mMapChangeListener = new IMapChangeListener() {
        public void hideResetView() {
            AbsMapFlowDelegatePresenter.this.hideResetView();
        }

        public void showResetView() {
            AbsMapFlowDelegatePresenter.this.showResetView();
        }
    };
    protected IDeparturePinInfo mNoRecommendDeparturePinInfo = new IDeparturePinInfo() {
        public long getDepartureTime() {
            return 0;
        }

        public boolean getFenceVisible() {
            return false;
        }

        public boolean getPinVisible() {
            return true;
        }

        public boolean getRecommendVisible() {
            return false;
        }
    };
    protected BaseEventPublisher.OnEventListener mOnEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                AbsMapFlowDelegatePresenter.this.onXPanelDefaultHeightChanged(num.intValue());
            }
        }
    };
    protected BaseEventPublisher.OnEventListener mOnScrollEventListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER)) {
                GLog.m7965d("lxsXpanelCb", "biz: " + num);
                AbsMapFlowDelegatePresenter.this.onXPanelScrollChanged(num.intValue());
            }
        }
    };
    protected long mOnServiceNewSctxRequestInterval;
    protected ExpressOrderStatusPoll mOrderStatusPoll;
    protected BaseEventPublisher.OnEventListener<ResetMapEvent> mResetMapListener = new BaseEventPublisher.OnEventListener<ResetMapEvent>() {
        public void onEvent(String str, ResetMapEvent resetMapEvent) {
            if ("event_map_reset_map".equals(str) && resetMapEvent != null && resetMapEvent.getPadding() != null) {
                AbsMapFlowDelegatePresenter.this.mCurrentPadding = resetMapEvent.getPadding();
                resetMapEvent.recycle();
                AbsMapFlowDelegatePresenter.this.resetMap();
            }
        }
    };
    protected BaseEventPublisher.OnEventListener<Integer> mShowNewSugPageListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if ("event_show_new_sug_page".equals(str)) {
                SystemUtils.log(6, "ccc", "showNewSugOrRouterPage EVENT_SHOW_SUG_PAGE", (Throwable) null, "com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter$5", 255);
                AbsMapFlowDelegatePresenter.this.showNewSugOrRouterPage(num.intValue(), FromType.HOME, AbsMapFlowDelegatePresenter.this.mGlobalSugCallback, true, true);
            } else if (BaseEventKeys.Home.EVENT_SHOW_ROUTER_PAGE.equals(str)) {
                SystemUtils.log(6, "ccc", "showNewSugOrRouterPage EVENT_SHOW_ROUTER_PAGE", (Throwable) null, "com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter$5", 258);
                AbsMapFlowDelegatePresenter.this.showNewSugOrRouterPage(num.intValue(), FromType.ROUTE_EDITOR, AbsMapFlowDelegatePresenter.this.mGlobalSugCallback, true, true);
            }
        }
    };
    protected BaseEventPublisher.OnEventListener<Integer> mShowNewSugPageListenerFromNewOpenRide = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (BaseEventKeys.Home.EVENT_SHOW_SUG_PAGE_FROM_NEW_OPEN_RIDE.equals(str)) {
                SystemUtils.log(6, "ccc", "showNewSugOrRouterPage EVENT_SHOW_SUG_PAGE_FROM_NEW_OPEN_RIDE", (Throwable) null, "com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter$3", 234);
                AbsMapFlowDelegatePresenter.this.showNewSugOrRouterPage(num.intValue(), FromType.OPEN_RIDE, AbsMapFlowDelegatePresenter.this.mGlobalSugCallback, true, true);
            }
        }
    };
    protected IDeparturePinInfo mSugDeparturePinInfo = new DeparturePinInfo() {
        public boolean getFenceVisible() {
            return false;
        }

        public boolean getRecommendVisible() {
            return false;
        }
    };
    protected OrderService mTravelOrderService;
    protected long mWaitForArrivalNewSctxRequestInterval;

    public static class DeparturePinInfo implements IDeparturePinInfo {
        public long getDepartureTime() {
            return 0;
        }

        public boolean getFenceVisible() {
            return true;
        }

        public boolean getPinVisible() {
            return true;
        }

        public boolean getRecommendVisible() {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean addDefaultWayPoint() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void carslidingOnSuccess() {
    }

    /* access modifiers changed from: protected */
    public abstract List<Integer> getEditableWayPointsType();

    /* access modifiers changed from: protected */
    public abstract ISceneController getSceneController();

    /* access modifiers changed from: protected */
    public ISceneController getSceneController1() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract List<WayPoint> getWayPoints();

    /* access modifiers changed from: protected */
    public boolean isAnycar() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback);

    /* access modifiers changed from: protected */
    public void onSugSessionClosed() {
    }

    /* access modifiers changed from: protected */
    public void refresh3DCard(List<String> list) {
    }

    /* access modifiers changed from: protected */
    public void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
    }

    /* access modifiers changed from: protected */
    public void setStartAddress(Address address) {
    }

    /* access modifiers changed from: protected */
    public MiniBusParamInterface getMiniBusParam(List<MapLineInfo> list, List<MarkerInfo> list2, int i) {
        return getMiniBusParam(list, list2, i, (StationBoardHintModel) null);
    }

    /* access modifiers changed from: protected */
    public MiniBusParamInterface getMiniBusParam(List<MapLineInfo> list, List<MarkerInfo> list2, int i, StationBoardHintModel stationBoardHintModel) {
        final List<MapLineInfo> list3 = list;
        final List<MarkerInfo> list4 = list2;
        final int i2 = i;
        final StationBoardHintModel stationBoardHintModel2 = stationBoardHintModel;
        return new MiniBusParamInterface() {
            public List<CommonLineParam> getMiniBusLineParam() {
                ArrayList arrayList = new ArrayList();
                if (!CollectionUtils.isEmpty((Collection) list3)) {
                    for (MapLineInfo mapLineInfo : list3) {
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
                float f;
                Bitmap bitmap;
                StationBoardHintModel stationBoardHintModel;
                Bitmap decodeResource;
                ArrayList arrayList = new ArrayList();
                if (!CollectionUtils.isEmpty((Collection) list4)) {
                    for (MarkerInfo markerInfo : list4) {
                        Bitmap decodeResource2 = BitmapFactory.decodeResource(AbsMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                        MapElementId mapElementId = MapElementId.ID_MARKER_START;
                        int i = markerInfo.markerType;
                        if (i != 1) {
                            f = 0.8f;
                            if (i == 2) {
                                if (i2 == 2) {
                                    decodeResource = BitmapFactory.decodeResource(AbsMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                                    f = 0.5f;
                                } else {
                                    decodeResource = BitmapFactory.decodeResource(AbsMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up_station);
                                }
                                mapElementId = MapElementId.ID_MARKER_PICK_UP;
                            } else if (i == 3) {
                                if (i2 == 6) {
                                    bitmap = BitmapFactory.decodeResource(AbsMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_dest_station_round);
                                    f = 0.5f;
                                } else {
                                    bitmap = BitmapFactory.decodeResource(AbsMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_dest_station);
                                }
                                mapElementId = MapElementId.ID_MARKER_DROP_OFF;
                            } else if (i == 4) {
                                decodeResource2 = BitmapFactory.decodeResource(AbsMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_destination);
                                mapElementId = MapElementId.ID_MARKER_END;
                            }
                            CommonMarkerParam.Builder id = new CommonMarkerParam.Builder().point(new LatLng(Double.parseDouble(markerInfo.lat), Double.parseDouble(markerInfo.lng))).markerIcon(bitmap).anchorU(0.5f).anchorV(f).mo75597id(mapElementId);
                            if (markerInfo.markerType == 2 && i2 == 2 && (stationBoardHintModel = stationBoardHintModel2) != null && !TextUtils.isEmpty(stationBoardHintModel.mText)) {
                                id.addressName(stationBoardHintModel2.mText);
                            }
                            arrayList.add(new CommonMarkerParam(id));
                        } else {
                            decodeResource2 = BitmapFactory.decodeResource(AbsMapFlowDelegatePresenter.this.mContext.getResources(), R.drawable.map_icon_pick_up);
                            mapElementId = MapElementId.ID_MARKER_START;
                        }
                        f = 0.5f;
                        CommonMarkerParam.Builder id2 = new CommonMarkerParam.Builder().point(new LatLng(Double.parseDouble(markerInfo.lat), Double.parseDouble(markerInfo.lng))).markerIcon(bitmap).anchorU(0.5f).anchorV(f).mo75597id(mapElementId);
                        id2.addressName(stationBoardHintModel2.mText);
                        arrayList.add(new CommonMarkerParam(id2));
                    }
                }
                return arrayList;
            }
        };
    }

    /* access modifiers changed from: protected */
    public MiniBusTripSceneState transMpaStyle(int i) {
        if (i == 1) {
            return MiniBusTripSceneState.STATE_ETA_OVER_25;
        }
        if (i == 2) {
            return MiniBusTripSceneState.STATE_ETA_BELOW_25;
        }
        if (i == 3) {
            return MiniBusTripSceneState.STATE_PICKUP;
        }
        if (i == 4) {
            return MiniBusTripSceneState.STATE_WAITING_FOR_DRIVING;
        }
        if (i != 5) {
            return null;
        }
        return MiniBusTripSceneState.STATE_DRIVE_OFF;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m10080a(int i) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            int i2 = order.status;
            int i3 = order.substatus;
            GLog.m7965d("check_status", "checkOrderStatusDiff " + i + " - " + i2 + " - " + i3);
            if (i == 1) {
                if (i3 == 4001 || i3 == 4002) {
                    return false;
                }
            } else if (i == 2) {
                if (i3 == 4003 || i3 == 4004 || i3 == 4005) {
                    return false;
                }
            } else if (i == 4) {
                if (i3 == 4006 || i3 == 4007) {
                    return false;
                }
            } else if (i == 5 && (i2 == 5 || i2 == 6 || i2 == 2)) {
                return false;
            }
        }
        GLog.m7965d("check_status", "checkOrderStatusDiff true");
        return true;
    }

    public AbsMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
        this.mBusinessContext = componentParams.bizCtx;
        this.mWaitForArrivalNewSctxRequestInterval = GlobalApolloUtil.getWaitForArrivalNewSctxRequestInterval();
        this.mOnServiceNewSctxRequestInterval = GlobalApolloUtil.getOnServiceNewSctxRequestInterval();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m10084b();
        subscribe("event_map_reset_map", this.mResetMapListener);
        MapUtils.hookToOpenMapIndoor(this.mContext, ((IMapFlowDelegateView) this.mView).getMapFlowView());
        if (this.mComponentProxy.getSession() == null || TextUtils.isEmpty(this.mComponentProxy.getOrderId())) {
            String str = this.f14380b;
            LogUtils.m31495w(str, "new.invalid data, session = " + this.mComponentProxy.getSession() + ", orderId = " + this.mComponentProxy.getOrderId());
        } else {
            this.mOrderStatusPoll = ExpressOrderStatusPoll.getInstance(TravelUtil.getScene(1105), this.mComponentProxy.getSession(), this.mComponentProxy.getOrderId());
        }
        this.f14384f = TypedValue.applyDimension(1, 4.0f, this.mContext.getResources().getDisplayMetrics());
        subscribe(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, this.mJarvisVisibilityListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f14390l);
        subscribe(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE, this.mClearMapScene);
    }

    /* access modifiers changed from: protected */
    public void beforeOrderIdUpdate() {
        ExpressOrderStatusPoll expressOrderStatusPoll = this.mOrderStatusPoll;
        if (expressOrderStatusPoll != null) {
            expressOrderStatusPoll.stopPoll((Scene) null);
            this.mOrderStatusPoll.destroyPoll((Scene) null);
        }
    }

    /* access modifiers changed from: protected */
    public void afterOrderIdUpdate() {
        if (this.mComponentProxy.getSession() == null || TextUtils.isEmpty(this.mComponentProxy.getOrderId())) {
            String str = this.f14380b;
            LogUtils.m31495w(str, "afterOrderIdUpdate:invalid data, session = " + this.mComponentProxy.getSession() + ", orderId = " + this.mComponentProxy.getOrderId());
            return;
        }
        this.mOrderStatusPoll = ExpressOrderStatusPoll.getInstance(TravelUtil.getScene(1106), this.mComponentProxy.getSession(), this.mComponentProxy.getOrderId());
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe("event_map_reset_map", this.mResetMapListener);
        unsubscribe(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, this.mJarvisVisibilityListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.mOnEventListener);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, this.mOnScrollEventListener);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f14390l);
        unsubscribe(BaseEventKeys.Map.EVENT_CLEAR_MAP_SCENE, this.mClearMapScene);
    }

    /* access modifiers changed from: protected */
    public void resetMap() {
        ISceneController sceneController1 = getSceneController1();
        if (sceneController1 == null) {
            sceneController1 = getSceneController();
        }
        Padding currentPadding = getCurrentPadding();
        if (!(sceneController1 == null || currentPadding == null)) {
            sceneController1.doBestView(currentPadding);
        }
        setGoogloLogoPlace();
        Logger logger = this.f14381c;
        logger.info("MapFlowDelegate doBestView padding=" + currentPadding, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public Padding getCurrentPadding() {
        if (this.mCurrentPadding == null) {
            this.mCurrentPadding = new Padding(0, 0, 0, 0);
        }
        return this.mCurrentPadding;
    }

    /* access modifiers changed from: protected */
    public void setGoogloLogoPlace() {
        if (this.mView != null && ((IMapFlowDelegateView) this.mView).getMapFlowView() != null && ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView() != null && ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().getMap() != null && ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().getMap().getUiSettings() != null && this.googloLogoPaddding > 0) {
            ((IMapFlowDelegateView) this.mView).getMapFlowView().getMapView().getMap().getUiSettings().setLogoGravityWithMargin(0, 0, this.googloLogoPaddding, 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public int getMapBizId() {
        return this.mComponentParams.bid;
    }

    public ICarMainPageController transformToMainScene(MainPageSceneParam mainPageSceneParam) {
        this.f14381c.info("MapFlowDelegate switch2CarMainPageScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2CarMainPageScene(mainPageSceneParam);
        }
        return null;
    }

    public ISimpleMapSceneController transformToMainPageMapScene(SimpleSceneParams simpleSceneParams) {
        this.f14381c.info("MapFlowDelegate transformToMainPageMapScene", new Object[0]);
        MapFlowView mapFlowView = ((IMapFlowDelegateView) this.mView).getMapFlowView();
        if (mapFlowView != null) {
            return mapFlowView.getPresenter().openSimpleScene(simpleSceneParams);
        }
        return null;
    }

    public IPopSugSceneController transformToPopSugPageScene(PopSugSceneParam popSugSceneParam) {
        this.f14381c.info("MapFlowDelegate switch2PopSugPageScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2PopSugPageScene(popSugSceneParam);
        }
        return null;
    }

    public IOrderConfirmController transformToConfirmScene(OrderConfirmSceneParam orderConfirmSceneParam) {
        this.f14381c.info("MapFlowDelegate switch2OrderConfirmScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2OrderConfirmScene(orderConfirmSceneParam);
        }
        return null;
    }

    public IMiniBusConfirmSceneController transformToMinibusGetOnScene(MiniBusConfirmSceneParam miniBusConfirmSceneParam) {
        this.f14381c.info("MapFlowDelegate transformToMinibusGetOnScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switchMiniBusConfirmScene(miniBusConfirmSceneParam);
        }
        return null;
    }

    public ISceneController transformToMinibusAppointScene(MiniBusAppointParam miniBusAppointParam) {
        this.f14381c.info("MapFlowDelegate transformToMinibusAppointScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switchMiniBusAppointScene(miniBusAppointParam);
        }
        return null;
    }

    public ISceneController transformToMinibusOrderOverScene(MiniBusOrderOverSceneParam miniBusOrderOverSceneParam) {
        this.f14381c.info("MapFlowDelegate transformToMinibusOrderOverScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switchMiniBusOrderOverScene(miniBusOrderOverSceneParam);
        }
        return null;
    }

    public ISceneController transformToMinibusPickingScene(MiniBusSctxSceneParam miniBusSctxSceneParam) {
        this.f14381c.info("MapFlowDelegate transformToMinibusPickingScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switchMiniBusPickingScene(miniBusSctxSceneParam);
        }
        return null;
    }

    public ISceneController transformToMinibusOnServiceScene(MiniBusSctxSceneParam miniBusSctxSceneParam) {
        this.f14381c.info("MapFlowDelegate transformToMinibusOnServiceScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switchMiniBusInsServiceScene(miniBusSctxSceneParam);
        }
        return null;
    }

    public IWaitingForReplyController transformToWaitingForReplyScene(WaitingForReplyParam waitingForReplyParam) {
        this.f14381c.info("MapFlowDelegate switch2WaitingForReplyScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2WaitingForReplyOldScene(waitingForReplyParam);
        }
        return null;
    }

    public IWaitingForReplyController transformToWaitingForNewReplyScene(WaitingForReplyParam waitingForReplyParam) {
        this.f14381c.info("MapFlowDelegate switch2WaitingForReplyScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2WaitingForReplyScene(waitingForReplyParam);
        }
        return null;
    }

    public IWaitingForReplyControllerV2 transformToWaitingForNewReplySceneV2(WaitingForReplyParamV2 waitingForReplyParamV2) {
        this.f14381c.info("MapFlowDelegate transformToWaitingForNewReplySceneV2..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2WaitingForReplySceneV2(waitingForReplyParamV2);
        }
        return null;
    }

    public IServingController transformToWaitingForDrivingScene(ServingParam servingParam) {
        this.f14381c.info("MapFlowDelegate switch2WaitingForDrivingScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2WaitingForDrivingScene(servingParam);
        }
        return null;
    }

    public IServingController transformToInServiceScene(ServingParam servingParam) {
        this.f14381c.info("MapFlowDelegate switch2InServiceScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2InServiceScene(servingParam);
        }
        return null;
    }

    public ISceneController transformToServiceOverScene(ServiceOverParam serviceOverParam) {
        this.f14381c.info("MapFlowDelegate switch2ServiceOverScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2ServiceOverScene(serviceOverParam);
        }
        return null;
    }

    public IServingController transformToWaitingForDrivingAppointScene(ServingParam servingParam) {
        this.f14381c.info("MapFlowDelegate switch2WaitingForDrivingAppointScene..", new Object[0]);
        return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2WaitingForDrivingAppointScene(servingParam);
    }

    public ILockScreenServingController transformToLockScreenScene(LockScreenServingParam lockScreenServingParam) {
        this.f14381c.info("MapFlowDelegate switch2LockScreenScene..", new Object[0]);
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            return ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().switch2LockScreenScene(lockScreenServingParam);
        }
        return null;
    }

    public void clearMapScene() {
        if (((IMapFlowDelegateView) this.mView).getMapFlowView() != null) {
            ((IMapFlowDelegateView) this.mView).getMapFlowView().getPresenter().clear();
        }
    }

    public void hideResetView() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_HIDE_RESET_MAP);
    }

    public void showResetView() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Map.EVENT_SHOW_RESET_MAP);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        String str;
        if (CarOrderHelper.getOrder() == null) {
            str = "";
        } else {
            str = CarOrderHelper.getOrder().getOid();
        }
        GlobalOmegaUtils.trackEvent(LoginOmegaUtil.PAS_RETURN_CK, "g_OrderId", str);
        return super.onBackPressed(backType);
    }

    /* access modifiers changed from: protected */
    public OrderParams createOrderParams(String str, long j, long j2, int i, int i2) {
        OrderParams orderParams = new OrderParams(str, j, PaxEnvironment.getInstance().getPhoneNumber());
        orderParams.isShowExtendedAnimation = false;
        orderParams.orderStage = i;
        return orderParams;
    }

    /* renamed from: b */
    private void m10084b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return;
        }
        if (order.carInfo == null || TextUtils.isEmpty(order.carInfo.carMapImage)) {
            int i = -1;
            if (!TextUtil.isEmpty(order.carPoolOrderScene)) {
                i = NumberUtil.parseInt(order.carPoolOrderScene);
            }
            CarInfo carInfo = BusinessUtils.getCarInfo(this.mBusinessContext, order.productid, NumberUtil.parseInt(order.carLevel), order.comboType, i);
            Logger logger = this.f14381c;
            logger.info("onservice map carinfo:" + carInfo, new Object[0]);
            if (carInfo != null) {
                m10079a(carInfo.getMapIcon());
                return;
            }
            return;
        }
        m10079a(order.carInfo.carMapImage);
    }

    /* renamed from: a */
    private void m10079a(String str) {
        this.f14382d = str;
        if (!TextUtils.isEmpty(str) && !IconHelper.getInstance().haveCache(this.f14382d)) {
            IconHelper.getInstance().requestMisIcon(this.mContext.getApplicationContext(), this.f14382d, false, new IconHelper.IconChangeListener() {
                public void iconChange() {
                    AbsMapFlowDelegatePresenter.this.refreshCarBitmapDescriptor(IconHelper.getInstance().getSmoothDriverIcon(AbsMapFlowDelegatePresenter.this.mContext.getApplicationContext(), AbsMapFlowDelegatePresenter.this.f14382d, R.drawable.global_mapflow_default_car_icon));
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void load3DCar() {
        if (!GlobalApolloUtil.use3DCar(this.mContext)) {
            SystemUtils.log(3, "Car3dHelper", " not use 3d,apollo not allow ", (Throwable) null, "com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter", 987);
            return;
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.carInfo != null && !TextUtils.isEmpty(order.carInfo.car3DImageZip)) {
            Car3dHelper.getInstance().loadIconList(order.carInfo.car3DImageZip, this.mContext.getApplicationContext(), new Car3dHelper.LoadCallBack() {
                public void onFailed() {
                }

                public void onSuccess(List<String> list) {
                    AbsMapFlowDelegatePresenter.this.mCache3DList = list;
                    AbsMapFlowDelegatePresenter.this.refresh3DCard(list);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasWayPointBy(List<WayPoint> list, int... iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            int i3 = iArr[i];
            Iterator<WayPoint> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getWayPointType() == i3) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                i2++;
            }
            i++;
        }
        if (iArr.length == i2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public List<WayPoint> filterWayPointBy(List<WayPoint> list, int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (WayPoint next : list) {
            if (Arrays.binarySearch(iArr, next.getWayPointType()) >= 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public SugBuild getSugBuild() {
        SugBuild sugBuild = new SugBuild();
        sugBuild.setVersion(2);
        return sugBuild;
    }

    /* access modifiers changed from: protected */
    public Address getCurrentAddress() {
        if (!FormStore.getInstance().isFromOpenRide() || FormStore.getInstance().getDriverInfo() == null) {
            Address startAddress = FormStore.getInstance().getStartAddress();
            if (startAddress != null) {
                return startAddress;
            }
            DIDILocation lastKnownLocation = NationComponentDataUtil.getLastKnownLocation();
            if (lastKnownLocation == null) {
                return null;
            }
            Address address = new Address();
            address.setLatitude(lastKnownLocation.getLatitude());
            address.setLongitude(lastKnownLocation.getLongitude());
            return address;
        }
        Address address2 = new Address();
        PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
        try {
            address2.setLatitude(Double.parseDouble(driverInfo.driverLat));
            address2.setLongitude(Double.parseDouble(driverInfo.driverLng));
        } catch (Exception unused) {
            address2.setLatitude(0.0d);
            address2.setLongitude(0.0d);
        }
        return address2;
    }

    /* access modifiers changed from: protected */
    public void openWebActivity(String str) {
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

    /* access modifiers changed from: protected */
    public void showNewSugOrRouterPage(int i, FromType fromType, ISugSceneCallback iSugSceneCallback, Boolean bool, boolean z) {
        Address currentAddress = getCurrentAddress();
        if (currentAddress == null) {
            currentAddress = new Address();
            currentAddress.latitude = 0.0d;
            currentAddress.longitude = 0.0d;
            currentAddress.displayName = this.mContext.getResources().getString(R.string.GRider_Sug_2020_placeholder_pickup);
        }
        if (!bool.booleanValue()) {
            currentAddress = null;
        }
        SugParams createSugPageAddressParam = AddressUtil.createSugPageAddressParam(this.mContext, i, currentAddress);
        boolean isRouteEditorEnable = CacheApolloUtils.isRouteEditorEnable();
        GlobalOmegaUtils.trackEvent("gp_editRoute_add_sw", "is_learn_sw", isRouteEditorEnable ? "1" : "0");
        createSugPageAddressParam.enable_way_point = isRouteEditorEnable || isAnycar();
        createSugPageAddressParam.fromType = fromType;
        AddressParam addressParam = createSugPageAddressParam.addressParam;
        addressParam.departure_time = FormStore.getInstance().getTransportTime() + "";
        createSugPageAddressParam.is_start_address_new_select = this.is_start_address_new_select;
        createSugPageAddressParam.map_select_oper = FormStore.getInstance().getMapSelectOper();
        createSugPageAddressParam.wayPointParam.setWayPointTypes(getEditableWayPointsType());
        createSugPageAddressParam.wayPointParam.setWayPoints(getWayPoints());
        createSugPageAddressParam.wayPointParam.setAddDefaultWayPoint(z);
        transformToPopSugPageScene(new PopSugSceneParam.Builder().sugSceneCallback(iSugSceneCallback).mapChangeListener(this.mMapChangeListener).context((Context) getHost().getActivity()).sugParams(createSugPageAddressParam).build());
        doPublish(BaseEventKeys.Service.EVENT_HOME_SHOWN_SUG_PAGE);
    }

    public CarSlidingParam getCarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor, OrderStat orderStat, CarMoveBean carMoveBean) {
        String str;
        CarMoveBean carMoveBean2 = carMoveBean;
        int i = FormStore.getInstance().Bid;
        String mapTypeString = NationComponentDataUtil.getMapTypeString();
        int carLevel = FormStore.getInstance().getCarLevel();
        if (carMoveBean2 != null) {
            if (carMoveBean2.channel > 0) {
                i = carMoveBean2.channel;
            }
            if (!TextUtils.isEmpty(carMoveBean2.sdkmaptype)) {
                mapTypeString = carMoveBean2.sdkmaptype;
            }
        }
        CarSlidingParam carSlidingParam = new CarSlidingParam(iCarBitmapDescriptor, String.valueOf(i), mapTypeString, carLevel, orderStat.getValue(), NationTypeUtil.getNationComponentData().getLocaleCode(), NationComponentDataUtil.getMapTypeStringForApi(), TEBridge.clientConfig().idfa(), NationComponentDataUtil.getOriginID(), MixFlagUtil.getMixFlag(this.mContext), TEBridge.clientConfig().a3Token());
        carSlidingParam.setPid(String.valueOf(NationComponentDataUtil.getUid()));
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null) {
            str = "";
        } else {
            str = newEstimateItem.estimateId;
        }
        carSlidingParam.setBubbleId(str);
        carSlidingParam.setCarLevel(carLevel);
        carSlidingParam.setOrderTab(FormStore.getInstance().getTransportTime() > 0 ? 2 : 1);
        if (carMoveBean2 != null) {
            carSlidingParam.setExtra(m10077a(carMoveBean2));
            carSlidingParam.setEndLatLng(carMoveBean2.endLatLng);
            if (carMoveBean2.driversId != null && carMoveBean2.driversId.size() > 0) {
                carSlidingParam.setDriverId(carMoveBean2.driversId.get(0));
            }
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.status == 7 && !TextUtils.isEmpty(order.xActivityId)) {
            carSlidingParam.setXtags(order.xActivityId);
        }
        return carSlidingParam;
    }

    /* renamed from: a */
    private String m10077a(CarMoveBean carMoveBean) {
        if (carMoveBean == null) {
            return "";
        }
        List<String> list = carMoveBean.pickupFreeCompIds;
        String str = carMoveBean.companyId;
        try {
            Address endAddress = FormStore.getInstance().getEndAddress();
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            JSONObject jSONObject = new JSONObject();
            if (endAddress != null) {
                jSONObject.put("tlat", String.valueOf(endAddress.getLatitude()));
                jSONObject.put("tlng", String.valueOf(endAddress.getLongitude()));
            }
            int i = 0;
            if (newEstimateItem != null) {
                jSONObject.put(CarServerParam.PARAM_CARPOOING, String.valueOf(0));
            }
            if (!TextUtils.isEmpty(str)) {
                if (SideBarBusinessUtil.isPriceFix()) {
                    jSONObject.put("company_id", str);
                } else {
                    jSONObject.put(CarServerParam.PARAM_COMPANY_GROUP_ID, str);
                }
            }
            TaxiCompanyListModel.CompanyModel curCompany = FormStore.getInstance().getCurCompany();
            if (curCompany != null && curCompany.isFreePickup()) {
                StringBuilder sb = new StringBuilder();
                if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                    int size = list.size();
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        sb.append(it.next());
                        if (i >= size - 1) {
                            break;
                        }
                        sb.append(",");
                        i++;
                    }
                }
                String sb2 = sb.toString();
                if (com.didi.sdk.util.TextUtil.isEmpty(sb2)) {
                    sb2 = "-1";
                }
                jSONObject.put(CarServerParam.PARAM_COMPANY_GROUP_IDS, sb2);
            }
            if (endAddress == null && newEstimateItem == null && TextUtils.isEmpty(str)) {
                return "";
            }
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public void setCurrentPage(String str) {
        this.f14387i = str;
    }

    /* access modifiers changed from: protected */
    public int getNewHeightWithUIOffset(int i) {
        if (this.mView == null) {
            return i;
        }
        float f = (float) i;
        float f2 = this.f14384f;
        return f > f2 ? (int) (f + f2) : i;
    }

    /* access modifiers changed from: protected */
    public void onXPanelScrollChanged(int i) {
        this.f14385g = i;
        final int newHeightWithUIOffset = getNewHeightWithUIOffset(i);
        if ("home".equals(this.f14387i)) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    int bizBarHeight = AbsMapFlowDelegatePresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                    AbsMapFlowDelegatePresenter absMapFlowDelegatePresenter = AbsMapFlowDelegatePresenter.this;
                    absMapFlowDelegatePresenter.googloLogoPaddding = (-((((-newHeightWithUIOffset) - bizBarHeight) - absMapFlowDelegatePresenter.f14383e) + AbsMapFlowDelegatePresenter.this.f14385g)) + AbsMapFlowDelegatePresenter.this.f14388j + AbsMapFlowDelegatePresenter.this.f14389k;
                    AbsMapFlowDelegatePresenter.this.setGoogloLogoPlace();
                }
            }, 100);
        } else {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    AbsMapFlowDelegatePresenter absMapFlowDelegatePresenter = AbsMapFlowDelegatePresenter.this;
                    absMapFlowDelegatePresenter.googloLogoPaddding = (-((-newHeightWithUIOffset) + absMapFlowDelegatePresenter.f14385g)) + AbsMapFlowDelegatePresenter.this.f14388j + AbsMapFlowDelegatePresenter.this.f14389k;
                    AbsMapFlowDelegatePresenter.this.setGoogloLogoPlace();
                }
            }, 100);
        }
    }

    /* access modifiers changed from: protected */
    public void onXPanelDefaultHeightChanged(int i) {
        if (i >= 0) {
            this.f14386h = i;
            onXPanelScrollChanged(this.f14385g);
        }
    }
}
