package com.didi.map.global.flow.scene.simple.impl;

import android.view.View;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.controller.OrderInterceptMode;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.simple.IOrderInterceptCallbackNew;
import com.didi.map.global.flow.scene.simple.ISimpleMapSceneController;
import com.didi.map.global.flow.scene.simple.params.SimpleSceneParams;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.PointType;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.taxis99.R;
import java.util.HashMap;

@IScene.Scene(mo74615id = 1003)
public class SimpleMapScene extends PageScene<SimpleSceneParams> implements ISimpleMapSceneController {

    /* renamed from: a */
    private static final String f27038a = "SimpleMapScene";

    /* renamed from: b */
    private IDepartureCompContract f27039b;

    /* renamed from: c */
    private NLPRegisterParam f27040c = MapFlowApolloUtils.getDepartureNlpParam();

    public void refreshCarIcon() {
    }

    public SimpleMapScene(SimpleSceneParams simpleSceneParams, MapViewHolder mapViewHolder) {
        super(simpleSceneParams, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        DLog.m7384d(f27038a, "enter", new Object[0]);
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().startCalculateTime(8);
        }
        super.enter(bundle);
        PaxEnvironment.getInstance().setPointType(PointType.START);
        m19067a();
        m19072b();
    }

    /* renamed from: a */
    private void m19067a() {
        if (this.mMapView != null) {
            NLPRegisterParam nLPRegisterParam = this.f27040c;
            if (nLPRegisterParam != null) {
                nLPRegisterParam.setmCallFrom(CallFrom.PICKUP_PAGE.toString());
                this.mMapView.setNeedNlpLocation(this.f27040c);
                return;
            }
            this.mMapView.setNeedNlpLocation((NLPRegisterParam) null);
        }
    }

    /* renamed from: b */
    private void m19072b() {
        DepartureCompParams departureCompParams = getDepartureCompParams();
        if (departureCompParams != null && getContext() != null && getMap() != null) {
            DepartureComponent departureComponent = new DepartureComponent();
            this.f27039b = departureComponent;
            departureComponent.setConfigParam(departureCompParams);
            this.f27039b.create(getContext(), getMap());
            this.f27039b.registerCallback(new IDepartureCompContract.IDepartureComponentCallback() {
                public /* synthetic */ void onUp() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onUp(this);
                }

                public void onStartDragging() {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onStartDragging();
                    }
                }

                public void onDragging(int i) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onDragging(i);
                    }
                }

                public void onDepartureLoading(LatLng latLng) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onDepartureLoading(latLng);
                    }
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onDepartureAddressChanged(departureAddress);
                        if (SimpleMapScene.this.getAppFluentOmega() != null) {
                            SimpleMapScene.this.getAppFluentOmega().stopCalculateTime(SimpleMapScene.this.getContext(), SimpleMapScene.this.getMap(), 8, (HashMap<String, Object>) null);
                        }
                    }
                }

                public void onFetchAddressFail(LatLng latLng) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onFetchAddressFail(latLng);
                    }
                }

                public void onStartSugPage(DepartureAddress departureAddress) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onStartSugPage(departureAddress == null ? null : departureAddress.getAddress());
                    }
                }

                public void onStartTerminalWindow(DepartureAddress departureAddress) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onStartTerminalWindow(departureAddress);
                    }
                }

                public void onConfirmPickup(DepartureAddress departureAddress) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onConfirmPickup(departureAddress);
                    }
                }

                public void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onClickBroadOtherInStationCard(departureAddress);
                    }
                }

                public void onBroadOtherMapCallback(int i) {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onBroadOtherMapCallback(i);
                    }
                }

                public void onClickBubble() {
                    if (SimpleMapScene.this.mParam != null && ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback() != null) {
                        ((SimpleSceneParams) SimpleMapScene.this.mParam).getDeparturePinCallback().onClickBubble();
                    }
                }
            });
            this.f27039b.start();
        }
    }

    public DepartureCompParams getDepartureCompParams() {
        if (this.mParam == null) {
            return null;
        }
        int sceneType = ((SimpleSceneParams) this.mParam).getSceneType();
        NLPRegisterParam nLPRegisterParam = this.f27040c;
        if (nLPRegisterParam != null) {
            nLPRegisterParam.setmCallFrom(CallFrom.PICKUP_PAGE.toString());
        }
        return new DepartureCompParams.Builder().setNlpRegisterParam(this.f27040c).isPinVisible(true).isFenceVisible(true).isRecPointVisible(true).requireByDrag(true).isBubbleVisible(true).isGuideLineVisible(true).isWalkDropVisible(true).isTerminalViewVisible(true).recStyle(m19073c()).zoom(getDefaultZoomLevel()).setEndPoint(((SimpleSceneParams) this.mParam).getEndInfo()).hasWayPoint(((SimpleSceneParams) this.mParam).isHasWayPoint()).fenceOptions(m19063a(sceneType)).apiType(m19068b(sceneType)).callFrom(CallFrom.PICKUP_PAGE).sceneType(sceneType).locationInfo(((SimpleSceneParams) this.mParam).getDepartureLocationInfo()).pinStyle(((SimpleSceneParams) this.mParam).getPinStyle()).build();
    }

    /* renamed from: c */
    private RecPointStyle m19073c() {
        boolean recPointStyleConfig = MapFlowApolloUtils.getRecPointStyleConfig();
        RecPointStyle recPointStyle = new RecPointStyle();
        recPointStyle.isShowInfoWindow = !recPointStyleConfig;
        recPointStyle.isShowAddressName = recPointStyleConfig;
        return recPointStyle;
    }

    /* renamed from: a */
    private DepartureFenceOptions m19063a(int i) {
        DepartureFenceOptions departureFenceOptions = new DepartureFenceOptions();
        departureFenceOptions.cardWizardStart = 3;
        if (i != 1) {
            departureFenceOptions.cardStyle = 1;
        }
        return departureFenceOptions;
    }

    /* renamed from: b */
    private ApiType m19068b(int i) {
        if (i != 1) {
            return ApiType.DEPARTURE_POI_INFO;
        }
        return ApiType.DEPARTURE_REVERSE_GEO;
    }

    public void leave() {
        super.leave();
        IDepartureCompContract iDepartureCompContract = this.f27039b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f27039b = null;
        }
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().removeOmega(8);
        }
    }

    public View getDepartureTerminalView() {
        IDepartureCompContract iDepartureCompContract = this.f27039b;
        if (iDepartureCompContract == null) {
            return null;
        }
        return iDepartureCompContract.getDepartureCardView();
    }

    public void onConfirmClickInBroadOther() {
        IDepartureCompContract iDepartureCompContract = this.f27039b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.onConfirmClickInBroadOther();
        }
    }

    public boolean onDomainChanged() {
        DIDILocation lastKnownLocation;
        if (this.mMapView == null || getContext() == null || !this.isSceneValid || (lastKnownLocation = LocationHelper.getLastKnownLocation(getContext())) == null) {
            return false;
        }
        LatLng latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        if (!(this.f27039b == null || this.mParam == null)) {
            DepartureLocationInfo departureLocationInfo = ((SimpleSceneParams) this.mParam).getDepartureLocationInfo();
            if (departureLocationInfo != null) {
                departureLocationInfo.latLng = latLng;
            }
            this.f27039b.updateDepartureLocation(departureLocationInfo);
            return true;
        }
        return false;
    }

    public void onOrderIntercepted(final IOrderInterceptCallbackNew iOrderInterceptCallbackNew) {
        IDepartureCompContract iDepartureCompContract = this.f27039b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.addOrderInterceptListener(new DepartureInterceptController.IInterceptListener() {
                public void onIntercept(OrderInterceptMode orderInterceptMode, boolean z) {
                    IOrderInterceptCallbackNew iOrderInterceptCallbackNew = iOrderInterceptCallbackNew;
                    if (iOrderInterceptCallbackNew != null) {
                        iOrderInterceptCallbackNew.onIntercept(orderInterceptMode, z, SimpleMapScene.this.m19065a(orderInterceptMode, z), SimpleMapScene.this.m19075c(orderInterceptMode, z), SimpleMapScene.this.m19070b(orderInterceptMode, z));
                    }
                }

                public void onContinue() {
                    IOrderInterceptCallbackNew iOrderInterceptCallbackNew = iOrderInterceptCallbackNew;
                    if (iOrderInterceptCallbackNew != null) {
                        iOrderInterceptCallbackNew.onContinue();
                    }
                }

                public void onStart() {
                    IOrderInterceptCallbackNew iOrderInterceptCallbackNew = iOrderInterceptCallbackNew;
                    if (iOrderInterceptCallbackNew != null) {
                        iOrderInterceptCallbackNew.onStart();
                    }
                }
            });
        }
    }

    public void setPadding(Padding padding) {
        IDepartureCompContract iDepartureCompContract = this.f27039b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.setPadding(padding);
        }
    }

    public void updatePositionWhenOutStation(DepartureLocationInfo departureLocationInfo) {
        IDepartureCompContract iDepartureCompContract = this.f27039b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.updatePositionWhenOutStation(departureLocationInfo);
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && this.mMapView != null && getMap() != null && getContext() != null) {
            hideResetView();
            IDepartureCompContract iDepartureCompContract = this.f27039b;
            if (iDepartureCompContract != null) {
                DepartureLocationInfo locationInfo = iDepartureCompContract.getLocationInfo();
                DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
                if (lastKnownLocation != null) {
                    if (locationInfo == null) {
                        locationInfo = new DepartureLocationInfo(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), (Address) null, "wgs84");
                    } else {
                        locationInfo.latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                    }
                    this.f27039b.setPadding(padding);
                    this.f27039b.updateDepartureLocation(locationInfo);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m19065a(OrderInterceptMode orderInterceptMode, boolean z) {
        if (getContext() == null) {
            return "";
        }
        int i = C97063.f27041x9cf5a386[orderInterceptMode.ordinal()];
        if (i == 1) {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Confirmation_too_hMwr);
        }
        if (i == 2) {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Go_to_YjTy);
        }
        if (i != 3) {
            if (i != 4) {
                return "";
            }
            if (z) {
                return getContext().getResources().getString(R.string.GRider_requestConfirm_Confirmation_pickup_NrZC);
            }
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Confirmation_pickup_eaxZ);
        } else if (z) {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Confirmation_pickup_NrZC);
        } else {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Go_to_YjTy);
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.simple.impl.SimpleMapScene$3 */
    static /* synthetic */ class C97063 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$departure$controller$OrderInterceptMode */
        static final /* synthetic */ int[] f27041x9cf5a386;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.map.global.component.departure.controller.OrderInterceptMode[] r0 = com.didi.map.global.component.departure.controller.OrderInterceptMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27041x9cf5a386 = r0
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_START_NEAR_END     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27041x9cf5a386     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_START_POSITION_TO_FAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27041x9cf5a386     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_REC_POSITION_TO_FAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27041x9cf5a386     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_REC_POSITION_LEVEL_BAD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.simple.impl.SimpleMapScene.C97063.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m19070b(OrderInterceptMode orderInterceptMode, boolean z) {
        if (getContext() == null) {
            return "";
        }
        int i = C97063.f27041x9cf5a386[orderInterceptMode.ordinal()];
        if (i == 1 || i == 2) {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Order_continue_MfPR);
        }
        if (i != 3) {
            if (i == 4 && z) {
                return getContext().getResources().getString(R.string.GRider_requestConfirm_Order_ScmU);
            }
            return "";
        } else if (z) {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Order_ScmU);
        } else {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_Order_continue_MfPR);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m19075c(OrderInterceptMode orderInterceptMode, boolean z) {
        if (getContext() == null) {
            return "";
        }
        int i = C97063.f27041x9cf5a386[orderInterceptMode.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_modify_return_pjrL);
        }
        if (i != 4) {
            return "";
        }
        if (z) {
            return getContext().getResources().getString(R.string.GRider_requestConfirm_modify_return_pjrL);
        }
        return getContext().getResources().getString(R.string.GRider_requestConfirm_know_iwUe);
    }
}
