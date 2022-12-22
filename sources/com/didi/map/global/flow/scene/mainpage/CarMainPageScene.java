package com.didi.map.global.flow.scene.mainpage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.component.slideCars.ISlideCarsCompContract;
import com.didi.map.global.component.slideCars.SlideCarsCompParams;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ClientConfigParam;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.impl.MultiSlideCarsCompImpl;
import com.didi.map.global.component.slideCars.model.IDriverChangeListener;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.flow.utils.SystemUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.omega.AppFluentOmega;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Utils;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.IPoiBaseApi;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@IScene.Scene(mo74615id = 1001)
public class CarMainPageScene extends PageScene<MainPageSceneParam> implements ICarMainPageController {

    /* renamed from: a */
    private static final String f26310a = "CarMainPageScene|sfs";

    /* renamed from: j */
    private static Padding f26311j;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ISlideCarsCompContract f26312b;

    /* renamed from: c */
    private DIDILocationListener f26313c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LatLng f26314d;

    /* renamed from: e */
    private IDepartureCompContract f26315e;

    /* renamed from: f */
    private IPoiBaseApi f26316f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f26317g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f26318h = 10000;

    /* renamed from: i */
    private int f26319i = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ValueAnimator f26320k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f26321l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ReverseGeoResult f26322m;

    /* renamed from: n */
    private boolean f26323n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f26324o = true;

    public /* synthetic */ void hideCarSliding() {
        ICarMainPageController.CC.$default$hideCarSliding(this);
    }

    public /* synthetic */ void showCarSliding() {
        ICarMainPageController.CC.$default$showCarSliding(this);
    }

    public CarMainPageScene(final MainPageSceneParam mainPageSceneParam, MapViewHolder mapViewHolder) {
        super(mainPageSceneParam, mapViewHolder);
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().startCalculateTime(1, 3);
        }
        this.f26313c = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locMode = getLocMode();
                if (CarMainPageScene.this.f26317g != locMode) {
                    int unused = CarMainPageScene.this.f26317g = locMode;
                    MapFlowOmegaUtil.onLocateStatusChange(CarMainPageScene.this.f26317g);
                }
                if (dIDILocation != null && CarMainPageScene.this.isSceneValid) {
                    LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (LatLngUtils.locateCorrect(latLng)) {
                        if (CarMainPageScene.this.getAppFluentOmega() != null) {
                            CarMainPageScene.this.getAppFluentOmega().stopCalculateTime(CarMainPageScene.this.getContext(), CarMainPageScene.this.getMap(), 3, (HashMap<String, Object>) null);
                        }
                        CarMainPageScene.this.m18631b();
                        if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (CarMainPageScene.this.f26321l == 0 || Math.abs(currentTimeMillis - CarMainPageScene.this.f26321l) >= ((long) CarMainPageScene.this.f26318h)) {
                                CarMainPageScene carMainPageScene = CarMainPageScene.this;
                                carMainPageScene.m18626a(carMainPageScene.mPadding, true);
                                long unused2 = CarMainPageScene.this.f26321l = currentTimeMillis;
                            }
                        }
                        if (CarMainPageScene.this.f26314d == null && CarMainPageScene.this.getMap() != null) {
                            CarMainPageScene.this.m18632b(latLng);
                            if (CarMainPageScene.this.mParam != null && !((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene()) {
                                BestViewer.doBestView(CarMainPageScene.this.getMap(), false, Float.valueOf(18.0f), latLng, CarMainPageScene.this.getMap().getPadding(), (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                                    public void onFinished() {
                                        if (mainPageSceneParam.getMapLocationLoadedCallback() != null) {
                                            mainPageSceneParam.getMapLocationLoadedCallback().loaded();
                                        }
                                    }
                                });
                            }
                        } else if (DDSphericalUtil.computeDistanceBetween(CarMainPageScene.this.f26314d, latLng) < 35.0d) {
                            return;
                        }
                        CarMainPageScene.this.m18624a(latLng);
                        LatLng unused3 = CarMainPageScene.this.f26314d = latLng;
                        if (CarMainPageScene.this.f26312b != null) {
                            CarMainPageScene.this.f26312b.updateLocationPosition(latLng);
                        }
                    }
                }
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = (errInfo == null || errInfo.getErrMessage() == null) ? "" : errInfo.getErrMessage();
                DLog.m7384d("CarMainPageScene", "CarMainPageScene, onLocationErr:%d, errInfo:%s", objArr);
            }

            private int getLocMode() {
                if (CarMainPageScene.this.getContext() != null) {
                    return Utils.getLocationSwitchLevel(CarMainPageScene.this.getContext());
                }
                return -1;
            }
        };
        m18642e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18624a(LatLng latLng) {
        if (getContext() == null || getMap() == null || latLng == null || this.mParam == null || ((MainPageSceneParam) this.mParam).getAddressParam() == null) {
            SystemUtils.log(5, f26310a, "handlerPoiCache() mParam == null || getAddressParam == null", (Throwable) null, "com.didi.map.global.flow.scene.mainpage.CarMainPageScene", 189);
            return;
        }
        AddressParam addressParam = ((MainPageSceneParam) this.mParam).getAddressParam();
        if (addressParam.currentAddress != null) {
            addressParam.currentAddress.latitude = latLng.latitude;
            addressParam.currentAddress.longitude = latLng.longitude;
        }
        if (addressParam.targetAddress != null) {
            addressParam.targetAddress.latitude = latLng.latitude;
            addressParam.targetAddress.longitude = latLng.longitude;
        }
        if (this.f26316f == null) {
            this.f26316f = PoiBaseApiFactory.createDidiApi(getContext());
        }
        String mapVendor = (getMap() == null || getMap().getMapVendor() == null) ? "gmap" : getMap().getMapVendor().toString();
        ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
        reverseGeoParam.mapType = mapVendor;
        reverseGeoParam.select_lat = addressParam.currentAddress.latitude;
        reverseGeoParam.select_lng = addressParam.currentAddress.longitude;
        reverseGeoParam.user_loc_lat = addressParam.currentAddress.latitude;
        reverseGeoParam.user_loc_lng = addressParam.currentAddress.longitude;
        reverseGeoParam.accuracy = addressParam.currentAddress.accuracy;
        reverseGeoParam.provider = addressParam.currentAddress.provider;
        reverseGeoParam.callFrom = CallFrom.HOME_PAGE_DRAG;
        reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
        reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
        reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
        reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
        reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        DLog.m7384d(f26310a, "reverseGeo: param = " + reverseGeoParam, new Object[0]);
        this.f26316f.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                DLog.m7384d(CarMainPageScene.f26310a, "storeLocationReverseInfo onSuccess...", new Object[0]);
                if (!CarMainPageScene.this.isSceneValid) {
                    DLog.m7384d(CarMainPageScene.f26310a, "storeLocationReverseInfo isSceneValid = false", new Object[0]);
                    return;
                }
                ReverseGeoResult unused = CarMainPageScene.this.f26322m = reverseGeoResult;
                if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener() != null) {
                    ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener().onSuccess(reverseGeoResult);
                }
            }

            public void onFail(IOException iOException) {
                DLog.m7384d(CarMainPageScene.f26310a, "storeLocationReverseInfo fail...", new Object[0]);
                if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener() != null) {
                    ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener().onFail(iOException);
                }
            }
        });
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (!(getContext() == null || getMap() == null)) {
            LocationHelper.registerListener(getContext(), DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f26313c);
        }
        if (AppFluentOmega.getInstance() != null) {
            AppFluentOmega.getInstance().startCalculateTime(2);
        }
        m18621a();
    }

    /* renamed from: a */
    private void m18621a() {
        if (MapFlowApolloUtils.getIsEnableTrackPermissionState() && getContext() != null && getContext().getApplicationInfo() != null && getContext().getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 31) {
            if (SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_COARSE_LOCATION) == 0 && SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_FINE_LOCATION) == 0) {
                MapFlowOmegaUtil.trackLocationPermissionState(2);
            } else if (SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_COARSE_LOCATION) == 0) {
                MapFlowOmegaUtil.trackLocationPermissionState(0);
            } else if (SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_FINE_LOCATION) == 0) {
                MapFlowOmegaUtil.trackLocationPermissionState(1);
            } else {
                MapFlowOmegaUtil.trackLocationPermissionState(3);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18631b() {
        if (this.mParam != null && getMap() != null && getContext() != null && this.f26312b == null) {
            this.f26312b = new MultiSlideCarsCompImpl();
            SlideCarsCompParams slideCarsCompParams = new SlideCarsCompParams();
            if (((MainPageSceneParam) this.mParam).getSlidingParam() != null) {
                slideCarsCompParams.setCarSlidingRequestParam(m18619a(((MainPageSceneParam) this.mParam).getSlidingParam()));
                slideCarsCompParams.setBitmapGetter(((MainPageSceneParam) this.mParam).getSlidingParam().getBitmap());
            }
            slideCarsCompParams.setPullIntervalMs(this.f26318h);
            slideCarsCompParams.setShowSlidingCar(true);
            this.f26312b.setConfigParam(slideCarsCompParams);
            this.f26312b.create(getContext(), getMap());
            this.f26312b.setListener(new IDriverChangeListener() {
                public void onGetResultSuccess(NearCarDriver nearCarDriver) {
                    if (!(CarMainPageScene.this.mParam == null || ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener() == null)) {
                        if (CarMainPageScene.this.getAppFluentOmega() != null) {
                            CarMainPageScene.this.getAppFluentOmega().stopCalculateTime(CarMainPageScene.this.getContext(), CarMainPageScene.this.getMap(), 1, (HashMap<String, Object>) null);
                        }
                        ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener().onGetResultSuccess(nearCarDriver);
                    }
                    if (!(CarMainPageScene.this.mPadding == null || CarMainPageScene.this.mParam == null || ((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene())) {
                        CarMainPageScene carMainPageScene = CarMainPageScene.this;
                        carMainPageScene.doBestView(carMainPageScene.mPadding);
                    }
                    if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene() && CarMainPageScene.this.f26324o && CarMainPageScene.this.f26312b != null && !CollectionUtil.isEmpty((Collection<?>) CarMainPageScene.this.f26312b.getDriverPoints())) {
                        boolean unused = CarMainPageScene.this.f26324o = false;
                        MapFlowOmegaUtil.reportOmegaSACarShow();
                    }
                }

                public void onGetResultError(String str) {
                    if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener() != null) {
                        ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener().onGetResultError(str);
                    }
                }
            });
            this.f26312b.start();
        }
    }

    /* renamed from: a */
    private CarNavigatorRequest m18619a(CarSlidingParam carSlidingParam) {
        String str = null;
        if (getContext() != null) {
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
            LatLng latLng = lastKnownLocation != null ? new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()) : null;
            if (carSlidingParam != null) {
                if (!(getMap() == null || getMap().getMapVendor() == null)) {
                    str = getMap().getMapVendor().toString();
                }
                String productId = PaxEnvironment.getInstance().getProductId();
                if (str == null) {
                    str = "gmap";
                }
                CarNavigatorRequest carNavigatorRequest = new CarNavigatorRequest(productId, str, new ClientConfigParam(LocaleCodeHolder.getInstance().getCurrentLang(), "wgs84", carSlidingParam.getIdfa(), carSlidingParam.getOriginId(), carSlidingParam.getMixFlag(), carSlidingParam.getA3Token()), latLng, carSlidingParam.getType(), carSlidingParam.getOrderState());
                carNavigatorRequest.setPid(carSlidingParam.getPid());
                carNavigatorRequest.setCarLevel(carSlidingParam.getCarLevel());
                carNavigatorRequest.setType(carSlidingParam.getType());
                carNavigatorRequest.setOrderState(carSlidingParam.getOrderState());
                if (carSlidingParam.getEndLatLng() != null) {
                    carNavigatorRequest.setEndPosition(carSlidingParam.getEndLatLng());
                }
                if (carSlidingParam.getXtags() != null) {
                    carNavigatorRequest.setXtags(carSlidingParam.getXtags());
                }
                if (carSlidingParam.getExtra() != null) {
                    carNavigatorRequest.setExtra(carSlidingParam.getExtra());
                }
                if (carSlidingParam.getBubbleId() != null) {
                    carNavigatorRequest.setBubbleId(carSlidingParam.getBubbleId());
                }
                if (carSlidingParam.getOrderTab() != 0) {
                    carNavigatorRequest.setOrderTab(carSlidingParam.getOrderTab());
                }
                return carNavigatorRequest;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18632b(LatLng latLng) {
        if (this.mParam != null && getMap() != null && latLng != null && this.mMapView != null && this.f26315e == null) {
            this.f26315e = new DepartureComponent();
            DepartureLocationInfo departureLocationInfo = new DepartureLocationInfo(latLng, (Address) null, "wgs84");
            DepartureFenceOptions departureFenceOptions = new DepartureFenceOptions();
            DepartureCompParams.Builder builder = new DepartureCompParams.Builder();
            builder.departureTime(0).pinStyle((PinStyle) null).isPinVisible(false).isRecPointVisible(false).isBubbleVisible(false).locationInfo(departureLocationInfo).requireByDrag(false).isFenceVisible(true).recStyle((RecPointStyle) null).zoom(((MainPageSceneParam) this.mParam).isSuperAppScene() ? m18639d() : 18.0f).callFrom(CallFrom.GLOBAL_HOMEPAGE_STATION).apiType(ApiType.DEPARTURE_POI_INFO).fenceOptions(departureFenceOptions);
            this.f26315e.setConfigParam(builder.build());
            this.f26315e.create(getContext(), getMap());
            this.f26315e.registerCallback(new IDepartureCompContract.IDepartureComponentCallback() {
                public /* synthetic */ void onBroadOtherMapCallback(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onBroadOtherMapCallback(this, i);
                }

                public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
                }

                public /* synthetic */ void onClickBubble() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBubble(this);
                }

                public /* synthetic */ void onConfirmPickup(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onConfirmPickup(this, departureAddress);
                }

                public /* synthetic */ void onDepartureLoading(LatLng latLng) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDepartureLoading(this, latLng);
                }

                public /* synthetic */ void onDragging(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDragging(this, i);
                }

                public /* synthetic */ void onFetchAddressFail(LatLng latLng) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onFetchAddressFail(this, latLng);
                }

                public /* synthetic */ void onStartDragging() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartDragging(this);
                }

                public /* synthetic */ void onStartSugPage(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartSugPage(this, departureAddress);
                }

                public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
                }

                public /* synthetic */ void onUp() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onUp(this);
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    if (CarMainPageScene.this.mParam != null && departureAddress != null && departureAddress.getFenceInfo() != null) {
                        if (((MainPageSceneParam) CarMainPageScene.this.mParam).getFenceChangeListener() != null) {
                            ((MainPageSceneParam) CarMainPageScene.this.mParam).getFenceChangeListener().onChange(departureAddress.getFenceInfo());
                        }
                        if (((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene()) {
                            MapFlowOmegaUtil.reportOmegaSAFenceShow();
                        }
                    }
                }
            });
            this.f26315e.start();
        }
    }

    public void leave() {
        super.leave();
        this.f26314d = null;
        if (getContext() != null) {
            LocationHelper.unRegisterListener(getContext(), this.f26313c);
        }
        ISlideCarsCompContract iSlideCarsCompContract = this.f26312b;
        if (iSlideCarsCompContract != null) {
            iSlideCarsCompContract.destroy();
            this.f26312b = null;
        }
        IDepartureCompContract iDepartureCompContract = this.f26315e;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f26315e = null;
        }
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().removeOmega(1, 3);
        }
        if (((MainPageSceneParam) this.mParam).getMapClickListener() != null) {
            m18644f();
        }
        if (this.f26319i != 0) {
            m18622a(0);
        }
    }

    public void onResume() {
        super.onResume();
        if (getContext() != null) {
            LocationHelper.registerListener(getContext(), DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f26313c);
        }
        ISlideCarsCompContract iSlideCarsCompContract = this.f26312b;
        if (iSlideCarsCompContract != null) {
            iSlideCarsCompContract.onMapVisible(true);
        }
    }

    public void onPause() {
        super.onPause();
        if (getContext() != null) {
            LocationHelper.unRegisterListener(getContext(), this.f26313c);
        }
        ISlideCarsCompContract iSlideCarsCompContract = this.f26312b;
        if (iSlideCarsCompContract != null) {
            iSlideCarsCompContract.onMapVisible(false);
        }
    }

    public void doBestView(Padding padding) {
        if (padding != null) {
            if (this.mParam == null || !((MainPageSceneParam) this.mParam).isSuperAppScene()) {
                super.doBestView(padding);
                if (this.isSceneValid && getMap() != null) {
                    hideResetView();
                    ISlideCarsCompContract iSlideCarsCompContract = this.f26312b;
                    if (iSlideCarsCompContract != null && !CollectionUtil.isEmpty((Collection<?>) iSlideCarsCompContract.getDriverPoints())) {
                        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
                        LatLng latLng = null;
                        if (lastKnownLocation != null) {
                            latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                        }
                        BestViewer.doBestView(getMap(), true, latLng, this.f26312b.getDriverPoints(), padding, (Padding) null);
                    } else if (this.mMapView != null) {
                        BestViewer.doBestView(getMap(), true, this.mMapView.getMyLocationMarkers(), padding, (Padding) null, (BestViewer.IBestViewListener) null);
                    }
                }
            } else {
                m18625a(padding);
            }
        }
    }

    public void updateCarIcon() {
        ISlideCarsCompContract iSlideCarsCompContract;
        if (this.isSceneValid && (iSlideCarsCompContract = this.f26312b) != null) {
            iSlideCarsCompContract.refreshCarIcon();
        }
    }

    public boolean onDomainChanged() {
        if (this.mMapView == null || getContext() == null || !this.isSceneValid) {
            SystemUtils.log(6, f26310a, "onDomainChanged() mMapView == null || getContext() == null || !isSceneValid", (Throwable) null, "com.didi.map.global.flow.scene.mainpage.CarMainPageScene", 542);
            return false;
        }
        LatLng latLng = this.f26314d;
        if (latLng == null) {
            SystemUtils.log(6, f26310a, "onDomainChanged() lastLocation == null", (Throwable) null, "com.didi.map.global.flow.scene.mainpage.CarMainPageScene", 547);
            return false;
        }
        IDepartureCompContract iDepartureCompContract = this.f26315e;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.updateDepartureLocation(new DepartureLocationInfo(latLng, (Address) null, "wgs84"));
        }
        m18624a(this.f26314d);
        if (this.f26312b == null || this.mParam == null) {
            return true;
        }
        this.f26312b.reStart(m18619a(((MainPageSceneParam) this.mParam).getSlidingParam()));
        return true;
    }

    public void leaveSaPage(int i) {
        if (this.isSceneValid && getMap() != null) {
            DLog.m7384d(f26310a, "leaveSaPage", new Object[0]);
            m18637c();
            m18644f();
            ValueAnimator b = m18630b(i);
            this.f26320k = b;
            if (b != null) {
                b.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        ValueAnimator unused = CarMainPageScene.this.f26320k = null;
                        CarMainPageScene.this.m18626a(new Padding(), false);
                    }
                });
                this.f26320k.start();
                return;
            }
            m18626a(new Padding(), false);
        }
    }

    public void saCarMainToSAPage(Padding padding) {
        if (this.isSceneValid && getMap() != null) {
            DLog.m7384d(f26310a, "saCarMainToSAPage", new Object[0]);
            m18625a(padding);
        }
    }

    /* renamed from: a */
    private void m18625a(Padding padding) {
        if (padding == null) {
            m18626a(new Padding(), true);
        } else if (padding.bottom == 0 && padding.top == 0) {
            m18626a(padding, true);
        } else {
            if (f26311j != null) {
                m18622a(padding.bottom - f26311j.bottom);
            } else {
                f26311j = padding;
            }
            if (this.f26323n) {
                this.f26323n = false;
                m18626a(f26311j, true);
            }
        }
    }

    /* renamed from: c */
    private void m18637c() {
        ValueAnimator valueAnimator = this.f26320k;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f26320k.cancel();
            this.f26320k = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18622a(int i) {
        if (this.mMapView != null && this.mMapView.getMapView() != null && this.f26319i != i) {
            this.f26319i = i;
            this.mMapView.getMapView().scrollTo(0, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18626a(Padding padding, boolean z) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
            LatLng latLng = null;
            if (lastKnownLocation != null) {
                latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            }
            if (!z) {
                ISlideCarsCompContract iSlideCarsCompContract = this.f26312b;
                if (iSlideCarsCompContract != null && !CollectionUtil.isEmpty((Collection<?>) iSlideCarsCompContract.getDriverPoints()) && latLng != null) {
                    BestViewer.doBestView(getMap(), true, latLng, this.f26312b.getDriverPoints(), padding, (Padding) null, (BestViewer.IBestViewListener) null);
                } else if (this.mMapView != null) {
                    BestViewer.doBestView(getMap(), true, this.mMapView.getMyLocationMarkers(), padding, (Padding) null, (BestViewer.IBestViewListener) null);
                }
            } else if (latLng != null) {
                BestViewer.doBestView(getMap(), true, Float.valueOf(m18639d()), latLng, padding, (BestViewer.IBestViewListener) null);
            }
        }
    }

    /* renamed from: d */
    private float m18639d() {
        if (getMap() == null) {
            return MapFlowApolloUtils.getSAZoomLevelParam(0);
        }
        if (getMap().getMapVendor() == MapVendor.DIDI) {
            return MapFlowApolloUtils.getSAZoomLevelParam(1);
        }
        return MapFlowApolloUtils.getSAZoomLevelParam(0);
    }

    /* renamed from: b */
    private ValueAnimator m18630b(int i) {
        int i2 = this.f26319i;
        if (i2 == 0) {
            DLog.m7384d(f26310a, "getResetScrollMapAnimator return; mScrollY = 0", new Object[0]);
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, 0});
        ofInt.setDuration((long) i);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CarMainPageScene.this.m18623a(valueAnimator);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CarMainPageScene.this.m18622a(0);
                DLog.m7384d(CarMainPageScene.f26310a, "saResetScrollMap end", new Object[0]);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18623a(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        if (num != null) {
            m18622a(num.intValue());
        }
    }

    /* renamed from: e */
    private void m18642e() {
        if (this.mMapView != null && this.mMapView.getMapView() != null && this.mMapView.getMapView().getMap() != null && this.mParam != null && ((MainPageSceneParam) this.mParam).getMapClickListener() != null) {
            Map map = this.mMapView.getMapView().getMap();
            DLog.m7384d(f26310a, "registerListener: ", new Object[0]);
            map.addOnCameraChangeListener(((MainPageSceneParam) this.mParam).getMapClickListener());
            map.addOnMapGestureListener(((MainPageSceneParam) this.mParam).getMapClickListener());
        }
    }

    /* renamed from: f */
    private void m18644f() {
        if (this.mMapView != null && this.mMapView.getMapView() != null && this.mMapView.getMapView().getMap() != null && this.mParam != null && ((MainPageSceneParam) this.mParam).getMapClickListener() != null) {
            Map map = this.mMapView.getMapView().getMap();
            DLog.m7384d(f26310a, "unRegisterListener: ", new Object[0]);
            map.removeOnCameraChangeListener(((MainPageSceneParam) this.mParam).getMapClickListener());
            map.removeOnMapGestureListener(((MainPageSceneParam) this.mParam).getMapClickListener());
        }
    }

    public void saUpdatePageSceneParam(MainPageSceneParam mainPageSceneParam) {
        if (mainPageSceneParam != null) {
            DLog.m7384d(f26310a, "saUpdatePageSceneParam; isSuperAppScene = " + mainPageSceneParam.isSuperAppScene(), new Object[0]);
            m18644f();
            this.mParam = mainPageSceneParam;
            this.f26324o = true;
            this.f26323n = true;
            this.mMapChangeListener = mainPageSceneParam.getMapChangeListener();
            if (mainPageSceneParam.getMapClickListener() != null) {
                m18642e();
            }
            if (mainPageSceneParam.getReverseGeoListener() != null && this.f26322m != null) {
                mainPageSceneParam.getReverseGeoListener().onSuccess(this.f26322m);
            }
        }
    }
}
