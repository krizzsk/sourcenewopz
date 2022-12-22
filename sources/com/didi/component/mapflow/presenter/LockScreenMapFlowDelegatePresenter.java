package com.didi.component.mapflow.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.address.model.WayPoint;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.DriverPosUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.net.CarServerParam;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.infowindow.factory.InfoWindowViewFactory;
import com.didi.component.mapflow.infowindow.model.NewWaitArrivalWithTipsModel;
import com.didi.component.mapflow.infowindow.model.OneMessageModel;
import com.didi.component.mapflow.infowindow.widget.NewWaitArrivalInfoWindow;
import com.didi.component.mapflow.infowindow.widget.OneLineInfoWindow;
import com.didi.component.mapflow.view.IMapFlowDelegateView;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.global.flow.scene.order.serving.ILockScreenServingController;
import com.didi.map.global.flow.scene.order.serving.ISctxStateCallback;
import com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.nav.inertia.SctxStateInfo;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.push.PushManager;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockScreenMapFlowDelegatePresenter extends AbsAfterOrderMapFlowDelegatePresenter {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14436a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            LockScreenMapFlowDelegatePresenter.this.f14437b.info("mOrderStatusChangedEventReceiver", new Object[0]);
            LockScreenMapFlowDelegatePresenter.this.m10183e();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f14437b = LoggerFactory.getLogger(getClass());

    /* renamed from: c */
    private OneMessageModel f14438c;

    /* renamed from: d */
    private int f14439d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f14440e = true;

    /* renamed from: f */
    private NewWaitArrivalInfoWindow f14441f;

    /* renamed from: g */
    private NewWaitArrivalWithTipsModel f14442g;

    /* renamed from: h */
    private LockScreenServingParam f14443h;

    /* renamed from: i */
    private ISctxStateCallback f14444i = new ISctxStateCallback() {
        public void onSctxStateUpdate(SctxStateInfo sctxStateInfo) {
            if (sctxStateInfo != null && CarOrderHelper.isWaitDriver()) {
                if (sctxStateInfo.isExceptionState()) {
                    boolean unused = LockScreenMapFlowDelegatePresenter.this.f14445j = true;
                    LockScreenMapFlowDelegatePresenter.this.m10176b();
                } else {
                    boolean unused2 = LockScreenMapFlowDelegatePresenter.this.f14445j = false;
                    LockScreenMapFlowDelegatePresenter.this.m10179c();
                }
                LockScreenMapFlowDelegatePresenter.this.doPublish("event_sctx_state_change", sctxStateInfo);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f14445j;

    /* renamed from: k */
    private PushManager.DriversMigrationRoutesListener f14446k = new PushManager.DriversMigrationRoutesListener() {
        public void onDriversMigrationRoutesMessageReceived(byte[] bArr) {
            if (LockScreenMapFlowDelegatePresenter.this.mLockScreenServingController != null) {
                LockScreenMapFlowDelegatePresenter.this.mLockScreenServingController.onPushMsgReceived(bArr);
                LockScreenMapFlowDelegatePresenter.this.f14437b.info("OnServiceMapFlowDelegate onDriversMigrationRoutesMessageReceived..", new Object[0]);
                DriverPosUtils.setLatLng(LockScreenMapFlowDelegatePresenter.this.mLockScreenServingController.getLastDriverPosition());
            }
        }
    };

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<Boolean> f14447l = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            double d;
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null && LockScreenMapFlowDelegatePresenter.this.mLockScreenServingController != null) {
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
                DriverPosUtils.setLatLng(LockScreenMapFlowDelegatePresenter.this.mLockScreenServingController.getLastDriverPosition());
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
                hashMap.put("distance", Double.valueOf(LockScreenMapFlowDelegatePresenter.this.mLockScreenServingController.getLeftRouteDistance()));
                if (bool.booleanValue()) {
                    hashMap.put("eta", -1);
                } else if (LockScreenMapFlowDelegatePresenter.this.mEtaEda != null) {
                    hashMap.put("eta", Integer.valueOf(LockScreenMapFlowDelegatePresenter.this.mEtaEda.eta));
                }
                GlobalOmegaUtils.trackEvent("gp_driverArriver_map_rsp", (Map<String, Object>) hashMap);
            }
        }
    };
    protected EtaEda mEtaEda;
    protected IEtaEdaCallback mEtaEdaCallback = new IEtaEdaCallback() {
        public void onEtaEdaChanged(EtaEda etaEda) {
            if (etaEda != null && !LockScreenMapFlowDelegatePresenter.this.f14445j) {
                LockScreenMapFlowDelegatePresenter.this.showLockScreenEtaInfoWindow(etaEda.eta, etaEda.eda);
                LockScreenMapFlowDelegatePresenter.this.mEtaEda = etaEda;
            }
        }
    };
    protected ILockScreenServingController mLockScreenServingController;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10176b() {
        if (this.f14438c == null) {
            OneMessageModel oneMessageModel = new OneMessageModel();
            this.f14438c = oneMessageModel;
            oneMessageModel.setContent(this.mContext.getString(R.string.global_map_simulate_move_tips_on_car));
        }
        OneLineInfoWindow infoWindowView = InfoWindowViewFactory.getInfoWindowView(this.mContext, this.f14438c);
        if (getSceneController() != null) {
            getSceneController().updateMarkerBubble(MapElementId.ID_MARKER_START, infoWindowView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10179c() {
        EtaEda etaEda = this.mEtaEda;
        if (etaEda != null) {
            showLockScreenEtaInfoWindow(etaEda.eta, this.mEtaEda.eda);
        } else if (getSceneController() != null) {
            getSceneController().updateMarkerBubble(MapElementId.ID_MARKER_START, (View) null);
        }
    }

    /* renamed from: a */
    private void m10174a(LockScreenServingParam lockScreenServingParam) {
        if (lockScreenServingParam != null && lockScreenServingParam.getBuilder() != null) {
            lockScreenServingParam.reset(lockScreenServingParam.getBuilder().sctxStateCallback(this.f14444i));
            this.f14443h = lockScreenServingParam;
        }
    }

    /* renamed from: d */
    private void m10181d() {
        LockScreenServingParam lockScreenServingParam = this.f14443h;
        if (lockScreenServingParam != null && lockScreenServingParam.getBuilder() != null) {
            LockScreenServingParam lockScreenServingParam2 = this.f14443h;
            lockScreenServingParam2.reset(lockScreenServingParam2.getBuilder().sctxStateCallback((ISctxStateCallback) null));
        }
    }

    public LockScreenMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f14442g = new NewWaitArrivalWithTipsModel();
        if (CarOrderHelper.getOrder() != null) {
            this.f14442g.setShowEdit(false);
            this.f14442g.setAddress(CarOrderHelper.getOrder().startAddress.address);
        }
        this.f14441f = InfoWindowViewFactory.getNewWaitArrivalInfoWindow(this.mContext, this.f14442g);
        this.f14440e = true;
        ((IMapFlowDelegateView) this.mView).dismissMapOverlayView();
        m10183e();
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14436a);
        PushManager.registerDriverMigrationRoutesMessageListener(this.f14446k);
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f14447l);
        load3DCar();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f14440e = true;
        m10181d();
        PushManager.unregisterDriverMigrationRoutesMessageListener();
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f14436a);
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f14447l);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10183e() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            Logger logger = this.f14437b;
            logger.info("LockScreenMapFlowDelegate processOrderStatus  status=" + order.status + " substaus=" + order.substatus, new Object[0]);
            if (order.status != 4) {
                doPublish(BaseEventKeys.LockScreen.EVENT_ACTIVITY_CLOSE);
            } else if (order.substatus == 4001 || order.substatus == 4002) {
                if (this.f14439d != 0) {
                    this.f14439d = 0;
                    enterLockScreenSecen(order, 0);
                }
            } else if (order.substatus != 4003 && order.substatus != 4004 && order.substatus != 4005 && order.substatus != 4007) {
                doPublish(BaseEventKeys.LockScreen.EVENT_ACTIVITY_CLOSE);
            } else if (this.f14439d != 1) {
                this.f14439d = 1;
                enterLockScreenSecen(order, 1);
            }
        } else {
            this.f14437b.info("LockScreenMapFlowDelegate processOrderStatus order is null", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void enterLockScreenSecen(CarOrder carOrder, int i) {
        LockScreenServingParam a = m10172a(carOrder, this.mWaitForArrivalNewSctxRequestInterval, i);
        if (a != null) {
            m10174a(a);
            this.mLockScreenServingController = transformToLockScreenScene(a);
        }
    }

    /* access modifiers changed from: protected */
    public ILockScreenServingController getSceneController() {
        return this.mLockScreenServingController;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x024f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam m10172a(com.didi.travel.psnger.model.response.CarOrder r19, long r20, int r22) {
        /*
            r18 = this;
            r8 = r18
            r9 = r19
            r10 = r22
            r12 = 0
            if (r9 == 0) goto L_0x0276
            com.didi.sdk.address.address.entity.Address r0 = r9.startAddress
            if (r0 == 0) goto L_0x0276
            com.didi.sdk.address.address.entity.Address r0 = r9.endAddress
            if (r0 != 0) goto L_0x0013
            goto L_0x0276
        L_0x0013:
            r0 = 0
            com.didi.travel.psnger.core.model.response.DTSDKDriverModel r2 = r9.carDriver
            if (r2 == 0) goto L_0x0021
            com.didi.travel.psnger.core.model.response.DTSDKDriverModel r0 = r9.carDriver
            java.lang.String r0 = r0.did
            long r0 = com.didi.travel.psnger.utils.NumberUtil.strToLong(r0)
        L_0x0021:
            r13 = r0
            java.lang.String r1 = r9.oid
            r7 = 1005(0x3ed, float:1.408E-42)
            r0 = r18
            r2 = r13
            r4 = r20
            r6 = r22
            com.didi.map.global.flow.scene.order.serving.param.OrderParams r0 = r0.createOrderParams(r1, r2, r4, r6, r7)
            int r1 = r9.productid
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.productID = r1
            r1 = 1
            if (r10 == 0) goto L_0x003e
            if (r10 != r1) goto L_0x0044
        L_0x003e:
            com.didi.sdk.address.address.entity.Address r2 = r9.startAddress
            java.lang.String r2 = r2.srcTag
            r0.srcTag = r2
        L_0x0044:
            java.lang.String r2 = r9.lastOrderId
            r0.lastOrderId = r2
            com.didi.sdk.app.BusinessContext r2 = r8.mBusinessContext
            com.didi.sdk.misconfig.model.CountryInfo r2 = r2.getCountryInfo()
            if (r2 == 0) goto L_0x005b
            com.didi.sdk.app.BusinessContext r2 = r8.mBusinessContext
            com.didi.sdk.misconfig.model.CountryInfo r2 = r2.getCountryInfo()
            java.lang.String r2 = r2.getCountryIsoCode()
            goto L_0x005c
        L_0x005b:
            r2 = 0
        L_0x005c:
            com.didi.map.global.flow.scene.order.serving.param.ClientParams r3 = new com.didi.map.global.flow.scene.order.serving.param.ClientParams
            android.content.Context r4 = r8.mContext
            java.lang.String r4 = com.didi.sdk.util.SystemUtil.getVersionName(r4)
            java.lang.String r5 = com.didi.sdk.util.SystemUtil.getIMEI()
            r3.<init>(r4, r2, r5)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r4 = new com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder
            r4.<init>()
            r5 = 2131236274(0x7f0815b2, float:1.8088766E38)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r4 = r4.markerIconResId(r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            java.lang.String r7 = "latin_pax_serial_note"
            java.lang.String r10 = "flag"
            java.lang.Object r6 = com.didi.component.business.util.GlobalApolloUtil.getParam(r7, r10, r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r7 = 3
            r10 = 2
            r15 = 2131099778(0x7f060082, float:1.7811919E38)
            r11 = 2131956290(0x7f131242, float:1.9549132E38)
            if (r6 == r1) goto L_0x00da
            if (r6 == r10) goto L_0x00c3
            if (r6 == r7) goto L_0x009e
            com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter$7 r6 = new com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter$7
            r6.<init>()
            r5 = r6
            goto L_0x00ec
        L_0x009e:
            android.content.Context r6 = r8.mContext
            java.lang.String r6 = com.didi.sdk.util.ResourcesHelper.getString(r6, r11)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r6 = r4.addressName(r6)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r6 = r6.addressNameColorResId(r15)
            android.content.Context r5 = r8.mContext
            boolean r5 = com.didi.sdk.util.AppUtils.isGlobalApp(r5)
            if (r5 == 0) goto L_0x00b8
            r5 = 2131101080(0x7f060598, float:1.781456E38)
            goto L_0x00bb
        L_0x00b8:
            r5 = 2131101079(0x7f060597, float:1.7814558E38)
        L_0x00bb:
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r5 = r6.sensingCircleColorRes(r5)
            r5.showSensingCircle(r1)
            goto L_0x00eb
        L_0x00c3:
            android.content.Context r5 = r8.mContext
            java.lang.String r5 = com.didi.sdk.util.ResourcesHelper.getString(r5, r11)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r5 = r4.addressName(r5)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r5 = r5.addressNameColorResId(r15)
            r5.showSensingCircle(r12)
            com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter$6 r5 = new com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter$6
            r5.<init>()
            goto L_0x00ec
        L_0x00da:
            android.content.Context r5 = r8.mContext
            java.lang.String r5 = com.didi.sdk.util.ResourcesHelper.getString(r5, r11)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r5 = r4.addressName(r5)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r5 = r5.addressNameColorResId(r15)
            r5.showSensingCircle(r12)
        L_0x00eb:
            r5 = 0
        L_0x00ec:
            int r6 = com.didi.component.business.util.GlobalApolloUtil.getInterlinkOrderPerceptionGroupNo()
            if (r6 == r1) goto L_0x00f6
            if (r6 == r10) goto L_0x00f6
            if (r6 != r7) goto L_0x0103
        L_0x00f6:
            android.content.Context r1 = r8.mContext
            java.lang.String r1 = com.didi.sdk.util.ResourcesHelper.getString(r1, r11)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r4.addressName(r1)
            r1.addressNameColorResId(r15)
        L_0x0103:
            com.didi.common.map.model.LatLng r1 = new com.didi.common.map.model.LatLng
            com.didi.sdk.address.address.entity.Address r6 = r9.startAddress
            double r6 = r6.latitude
            com.didi.sdk.address.address.entity.Address r10 = r9.startAddress
            double r10 = r10.longitude
            r1.<init>((double) r6, (double) r10)
            com.didi.common.map.model.LatLng r6 = new com.didi.common.map.model.LatLng
            com.didi.sdk.address.address.entity.Address r7 = r9.endAddress
            double r10 = r7.latitude
            com.didi.sdk.address.address.entity.Address r7 = r9.endAddress
            r16 = r13
            double r12 = r7.longitude
            r6.<init>((double) r10, (double) r12)
            com.didi.sdk.logging.Logger r7 = r8.f14437b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "OnServiceMapFlowDelegate getServingParam oid="
            r10.append(r11)
            java.lang.String r11 = r9.oid
            r10.append(r11)
            java.lang.String r11 = " driverId="
            r10.append(r11)
            r11 = r16
            r10.append(r11)
            java.lang.String r11 = " countryId="
            r10.append(r11)
            r10.append(r2)
            java.lang.String r2 = " startLatLng="
            r10.append(r2)
            r10.append(r1)
            java.lang.String r2 = " endLatLng="
            r10.append(r2)
            r10.append(r6)
            java.lang.String r2 = r10.toString()
            r10 = 0
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r7.info((java.lang.String) r2, (java.lang.Object[]) r11)
            com.android.didi.theme.DidiThemeManager r2 = com.android.didi.theme.DidiThemeManager.getIns()
            android.content.Context r7 = r8.mContext
            com.android.didi.theme.ThemeResPicker r2 = r2.getResPicker(r7)
            r7 = 2130969980(0x7f04057c, float:1.7548657E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r7)
            com.android.didi.theme.DidiThemeManager r7 = com.android.didi.theme.DidiThemeManager.getIns()
            android.content.Context r10 = r8.mContext
            com.android.didi.theme.ThemeResPicker r7 = r7.getResPicker(r10)
            r10 = 2130969979(0x7f04057b, float:1.7548655E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r10 = new com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder
            r10.<init>()
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r10.point(r1)
            android.graphics.Bitmap r2 = com.didi.common.map.util.ImageUtil.Drawable2Bitmap(r2)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.markerIcon(r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.anchorU(r2)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.anchorV(r2)
            com.didi.map.global.flow.scene.param.MapElementId r10 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.mo75597id(r10)
            com.didi.sdk.address.address.entity.Address r10 = r9.startAddress
            java.lang.String r10 = r10.getDisplayName()
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.addressName(r10)
            r10 = 2131100644(0x7f0603e4, float:1.7813675E38)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.addressNameColorResId(r10)
            com.didi.map.global.flow.scene.param.CommonMarkerParam r11 = new com.didi.map.global.flow.scene.param.CommonMarkerParam
            r11.<init>(r1)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = new com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder
            r1.<init>()
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.point(r6)
            android.graphics.Bitmap r6 = com.didi.common.map.util.ImageUtil.Drawable2Bitmap(r7)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.markerIcon(r6)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.anchorU(r2)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.anchorV(r2)
            com.didi.map.global.flow.scene.param.MapElementId r2 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.mo75597id(r2)
            com.didi.sdk.address.address.entity.Address r2 = r9.endAddress
            java.lang.String r2 = r2.getDisplayName()
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.addressName(r2)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r1 = r1.addressNameColorResId(r10)
            com.didi.map.global.flow.scene.param.CommonMarkerParam r2 = new com.didi.map.global.flow.scene.param.CommonMarkerParam
            r2.<init>(r1)
            com.didi.map.global.flow.scene.param.CommonMarkerParam r1 = new com.didi.map.global.flow.scene.param.CommonMarkerParam
            r1.<init>(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.didi.map.global.flow.scene.param.MapElementId r6 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START
            r4.put(r6, r11)
            com.didi.map.global.flow.scene.param.MapElementId r6 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_END
            r4.put(r6, r2)
            com.didi.map.global.flow.scene.param.MapElementId r2 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT
            r4.put(r2, r1)
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = new com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder
            r1.<init>()
            android.content.Context r2 = r8.mContext
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = r1.context((android.content.Context) r2)
            r2 = 0
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = r1.isNewVersion(r2)
            com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor r2 = r8.mCarBitmapDescriptor
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = r1.carBitmapDescriptor(r2)
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = r1.clientParams(r3)
            boolean r2 = r19.isSplitFareUser()
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = r1.bReadOnly(r2)
            com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback r2 = r8.mEtaEdaCallback
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = r1.etaEdaCallback(r2)
            com.didi.map.global.flow.scene.order.serving.IOraOrderStageCallback r2 = r8.mIOraOrderStageCallback
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r1 = r1.oraOrderStageCallback(r2)
            if (r5 == 0) goto L_0x0233
            r1.passPointStatusCallback(r5)
        L_0x0233:
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r2 = new com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder
            r2.<init>()
            r3 = 2131236274(0x7f0815b2, float:1.8088766E38)
            com.didi.map.global.flow.scene.param.CommonMarkerParam$Builder r2 = r2.markerIconResId(r3)
            com.didi.map.global.flow.scene.param.CommonMarkerParam r3 = new com.didi.map.global.flow.scene.param.CommonMarkerParam
            r3.<init>(r2)
            com.didi.map.global.flow.scene.param.MapElementId r2 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_ODPOINT
            r4.put(r2, r3)
            boolean r2 = r18.m10191i()
            if (r2 == 0) goto L_0x0263
            com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter$8 r2 = new com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter$8
            r2.<init>()
            r1.odPointsExpiredCallback(r2)
            java.util.List r2 = r18.m10185f()
            r0.odPoints = r2
            long r2 = r18.m10187g()
            r0.odPointsTimestamp = r2
        L_0x0263:
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r0 = r1.orderParams(r0)
            com.didi.map.global.flow.scene.order.serving.param.ServingParam$Builder r0 = r0.markerParams(r4)
            java.util.List r2 = r8.mCache3DList
            r0.car3DIcons(r2)
            com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam r0 = new com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam
            r0.<init>(r1)
            return r0
        L_0x0276:
            java.lang.Class r0 = r18.getClass()
            com.didi.sdk.logging.Logger r0 = com.didi.sdk.logging.LoggerFactory.getLogger((java.lang.Class<?>) r0)
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "OnServiceMapFlowDelegate getServingParam order is null"
            r0.error((java.lang.String) r2, (java.lang.Object[]) r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter.m10172a(com.didi.travel.psnger.model.response.CarOrder, long, int):com.didi.map.global.flow.scene.order.serving.param.LockScreenServingParam");
    }

    /* access modifiers changed from: protected */
    public void showLockScreenEtaInfoWindow(int i, int i2) {
        if (i < 1) {
            i = 1;
        }
        String valueOf = String.valueOf(i);
        Object[] objArr = new Object[1];
        if (i2 < 100) {
            i2 = 100;
        }
        objArr[0] = Double.valueOf(((double) i2) / 1000.0d);
        String format = String.format("%.1f", objArr);
        this.f14442g.setEta(valueOf);
        this.f14442g.setEda(format);
        this.f14441f.setData(this.f14442g);
        this.mLockScreenServingController.updateMarkerBubble(MapElementId.ID_MARKER_START, this.f14441f);
    }

    /* renamed from: f */
    private List<OdPoint> m10185f() {
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

    /* renamed from: g */
    private long m10187g() {
        if (TextUtils.isEmpty(CarOrderHelper.getOrder().wayPointsVersion) || "null".equals(CarOrderHelper.getOrder().wayPointsVersion)) {
            return 0;
        }
        return Long.parseLong(CarOrderHelper.getOrder().wayPointsVersion);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m10189h() {
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
                    LockScreenMapFlowDelegatePresenter.this.m10192j();
                    LockScreenMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED);
                }
            });
        }
    }

    /* renamed from: i */
    private boolean m10191i() {
        CarOrder order = CarOrderHelper.getOrder();
        return (order == null || order.updateWayPoint == null || order.updateWayPoint.updateIsOk != 0) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void refreshCarBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        ILockScreenServingController iLockScreenServingController = this.mLockScreenServingController;
        if (iLockScreenServingController != null) {
            iLockScreenServingController.refreshCarBitmapDescriptor(bitmapDescriptor);
        }
    }

    /* access modifiers changed from: protected */
    public void refresh3DCard(List<String> list) {
        ILockScreenServingController iLockScreenServingController = this.mLockScreenServingController;
        if (iLockScreenServingController != null) {
            iLockScreenServingController.refresh3DCarIcons(true, list);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m10192j() {
        if (this.mLockScreenServingController != null && m10191i()) {
            this.mLockScreenServingController.setOdPoints(m10185f(), m10187g());
        }
    }
}
