package com.didi.map.global.flow.scene.vamos.sug;

import android.app.Activity;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.ISugControlCallback;
import com.didi.address.model.SugParams;
import com.didi.addressold.vamos.AddressException;
import com.didi.addressold.vamos.DidiAddressApiFactory;
import com.didi.addressold.vamos.GlobalSugCallback;
import com.didi.addressold.vamos.IDidiAddressApi;
import com.didi.common.map.BestViewer;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.vamos.BaseVamosPageScene;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.departure.DepartureAddress;
import com.didi.map.sdk.departure.DepartureFactory;
import com.didi.map.sdk.departure.IDepartureCompContract;
import com.didi.map.sdk.departure.param.ApiType;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.didi.map.sdk.departure.param.PinStyle;
import com.didi.map.sdk.departure.param.RecPointStyle;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.lang.reflect.Field;

@IScene.Scene(mo74615id = 2111)
public class VamosSugPageScene extends BaseVamosPageScene<VamosSugPageSceneParam> implements IVamosSugPageSceneController {

    /* renamed from: a */
    private static final String f27184a = "VamosSugPageScene";

    /* renamed from: b */
    private static final float f27185b = 19.0f;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final IDidiAddressApi f27186c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IDepartureCompContract f27187d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IDepartureCompContract.IDepartueCompCallback f27188e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FromType f27189f;

    /* renamed from: g */
    private OnMapGestureListener f27190g;

    /* renamed from: h */
    private SceneUpdater f27191h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f27192i;

    /* renamed from: j */
    private final ISugControlCallback f27193j = new ISugControlCallback() {
        public void onResetBtnClick() {
            if (VamosSugPageScene.this.isSceneValid) {
                animateToTargetAddress(getLocLatLng());
                if (VamosSugPageScene.this.f27187d != null) {
                    VamosSugPageScene.this.f27187d.updateDepartureLocation(new DepartureLocationInfo(getLocLatLng(), (Address) null, "wgs84"), true);
                }
            }
        }

        public void onDeparturePinShow(boolean z, int i, Address address, Padding padding) {
            if (VamosSugPageScene.this.isSceneValid && VamosSugPageScene.this.getMap() != null && VamosSugPageScene.this.getContext() != null) {
                SystemUtils.log(6, "ccc", "onDeparturePinShow:" + z + ",type= " + i + ", addr =" + address.toString(), (Throwable) null, "com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene$1", 99);
                if (VamosSugPageScene.this.f27187d == null) {
                    if (z) {
                        IDepartureCompContract unused = VamosSugPageScene.this.f27187d = DepartureFactory.createCoreManager();
                        VamosSugPageScene.this.f27187d.create(VamosSugPageScene.this.getContext().getApplicationContext(), VamosSugPageScene.this.getMap());
                        VamosSugPageScene.this.f27187d.setConfigParam(getDepartureCompParam(i));
                        VamosSugPageScene.this.f27187d.start();
                        moveToTargetAddress(address != null ? new LatLng(address.latitude, address.longitude) : getLocLatLng());
                    }
                } else if (!z) {
                    VamosSugPageScene.this.f27187d.stop();
                } else if (!VamosSugPageScene.this.f27187d.isStarted() || VamosSugPageScene.this.f27192i != i) {
                    VamosSugPageScene.this.f27187d.setConfigParam(getDepartureCompParam(i));
                    VamosSugPageScene.this.f27187d.start();
                }
            }
        }

        private DepartureCompParam getDepartureCompParam(int i) {
            int unused = VamosSugPageScene.this.f27192i = i;
            return new DepartureCompParam.Builder().bizId(Integer.valueOf(PaxEnvironment.getInstance().getProductId()).intValue()).isDriverRole(false).requireByDrag(true).callFrom(computeFromPage(i)).phoneNum(PaxEnvironment.getInstance().getPhoneNumber()).token(PaxEnvironment.getInstance().getToken()).userId(PaxEnvironment.getInstance().getUid()).departureTime(((VamosSugPageSceneParam) VamosSugPageScene.this.mParam).getDeparturePinInfo().getDepartureTime()).isPinVisible(((VamosSugPageSceneParam) VamosSugPageScene.this.mParam).getDeparturePinInfo().getPinVisible()).isRecPointVisible(((VamosSugPageSceneParam) VamosSugPageScene.this.mParam).getDeparturePinInfo().getRecommendVisible()).isFenceVisible(((VamosSugPageSceneParam) VamosSugPageScene.this.mParam).getDeparturePinInfo().getFenceVisible()).pinStyle(getPinStyle(i)).recStyle((RecPointStyle) null).apiType(ApiType.DEPARTURE_REVERSE_GEO).listener(VamosSugPageScene.this.f27188e).zoom(VamosSugPageScene.f27185b).build();
        }

        private PinStyle getPinStyle(int i) {
            if (i == 1) {
                return getStartPinStyleData();
            }
            if (i == 2) {
                return getEndPinStyleData();
            }
            return getStartPinStyleData();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
            if (r0 != 2) goto L_0x0034;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.sdk.poibase.CallFrom computeFromPage(int r4) {
            /*
                r3 = this;
                com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene r0 = com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.this
                com.didi.address.FromType r0 = r0.f27189f
                if (r0 != 0) goto L_0x000b
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.UNKNOWN
                return r4
            L_0x000b:
                int[] r0 = com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.C97445.$SwitchMap$com$didi$address$FromType
                com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene r1 = com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.this
                com.didi.address.FromType r1 = r1.f27189f
                int r1 = r1.ordinal()
                r0 = r0[r1]
                r1 = 2
                r2 = 1
                if (r0 == r2) goto L_0x0020
                if (r0 == r1) goto L_0x002a
                goto L_0x0034
            L_0x0020:
                if (r4 != r2) goto L_0x0025
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_FROMHOME_STARTSUG_DRAG
                return r4
            L_0x0025:
                if (r4 != r1) goto L_0x002a
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_FROMHOME_ENDSUG_DRAG
                return r4
            L_0x002a:
                if (r4 != r2) goto L_0x002f
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_FROMBUBBLE_STARTSUG_DRAG
                return r4
            L_0x002f:
                if (r4 != r1) goto L_0x0034
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_FROMBUBBLE_ENDSUG_DRAG
                return r4
            L_0x0034:
                if (r4 != r2) goto L_0x0039
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_STARTSUG_DRAG
                return r4
            L_0x0039:
                if (r4 != r1) goto L_0x003e
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.GLOBAL_ENDSUG_DRAG
                return r4
            L_0x003e:
                com.sdk.poibase.CallFrom r4 = com.sdk.poibase.CallFrom.UNKNOWN
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.C97401.computeFromPage(int):com.sdk.poibase.CallFrom");
        }

        private PinStyle getStartPinStyleData() {
            PinStyle pinStyle = new PinStyle();
            pinStyle.rectVisible = true;
            pinStyle.bigCircleColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_black);
            pinStyle.smallCircleColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_green);
            pinStyle.rectColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_black);
            pinStyle.shadowColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_black);
            return pinStyle;
        }

        private PinStyle getEndPinStyleData() {
            PinStyle pinStyle = new PinStyle();
            pinStyle.rectVisible = true;
            pinStyle.bigCircleColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_black);
            pinStyle.smallCircleColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_orange);
            pinStyle.rectColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_black);
            pinStyle.shadowColor = ResourcesHelper.getColor(VamosSugPageScene.this.getContext(), R.color.global_map_flow_pin_color_black);
            return pinStyle;
        }

        private void moveToTargetAddress(LatLng latLng) {
            if (latLng != null && VamosSugPageScene.this.getMap() != null) {
                BestViewer.doBestView_Move(VamosSugPageScene.this.getMap(), latLng, VamosSugPageScene.this.getMap().getPadding());
            }
        }

        private void animateToTargetAddress(LatLng latLng) {
            if (latLng != null && VamosSugPageScene.this.getMap() != null) {
                BestViewer.doBestView_Animate(VamosSugPageScene.this.getMap(), latLng, VamosSugPageScene.this.getMap().getPadding());
            }
        }

        private LatLng getLocLatLng() {
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(VamosSugPageScene.this.getContext());
            if (lastKnownLocation != null) {
                return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            }
            return null;
        }
    };

    /* renamed from: com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene$5 */
    static /* synthetic */ class C97445 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$address$FromType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.address.FromType[] r0 = com.didi.address.FromType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$address$FromType = r0
                com.didi.address.FromType r1 = com.didi.address.FromType.HOME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.address.FromType r1 = com.didi.address.FromType.CONFIRM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.address.FromType r1 = com.didi.address.FromType.GET_ON     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$address$FromType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.address.FromType r1 = com.didi.address.FromType.SETTING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.C97445.<clinit>():void");
        }
    }

    public VamosSugPageScene(VamosSugPageSceneParam vamosSugPageSceneParam, MapViewHolder mapViewHolder) {
        super(vamosSugPageSceneParam, mapViewHolder);
        this.mParam = vamosSugPageSceneParam;
        this.mMapView = mapViewHolder;
        this.mPadding = new Padding();
        this.f27186c = DidiAddressApiFactory.createDidiAddress(getContext());
        m19221a();
        m19226b();
    }

    /* renamed from: a */
    private void m19221a() {
        this.f27188e = new IDepartureCompContract.IDepartueCompCallback() {
            public void onStartDragging() {
            }

            public void onDepartureLoading(LatLng latLng) {
                if (VamosSugPageScene.this.f27186c.getSugViewController() != null && VamosSugPageScene.this.f27186c.getSugViewController().getPoiChangeListener() != null) {
                    VamosSugPageScene.this.f27186c.getSugViewController().getPoiChangeListener().onPinLoading(latLng.latitude, latLng.longitude);
                }
            }

            public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                if (VamosSugPageScene.this.f27186c.getSugViewController() != null && VamosSugPageScene.this.f27186c.getSugViewController().getPoiChangeListener() != null) {
                    VamosSugPageScene.this.f27186c.getSugViewController().getPoiChangeListener().onPinPoiChanged(SugModelConverter.convert2Address(VamosSugPageScene.this.getContext().getApplicationContext(), departureAddress));
                }
            }

            public void onFetchAddressFailed(LatLng latLng) {
                if (VamosSugPageScene.this.f27186c.getSugViewController() != null && VamosSugPageScene.this.f27186c.getSugViewController().getPoiChangeListener() != null) {
                    VamosSugPageScene.this.f27186c.getSugViewController().getPoiChangeListener().onPinFetchPoiFailed(SugModelConverter.convert2Address(VamosSugPageScene.this.getContext().getApplicationContext(), latLng));
                }
            }
        };
    }

    /* renamed from: b */
    private void m19226b() {
        this.f27190g = new OnMapGestureListener() {
            public boolean onDoubleTap(float f, float f2) {
                return false;
            }

            public boolean onFling(float f, float f2) {
                return false;
            }

            public boolean onLongPress(float f, float f2) {
                return false;
            }

            public void onMapStable() {
            }

            public boolean onSingleTap(float f, float f2) {
                return false;
            }

            public boolean onUp(float f, float f2) {
                return false;
            }

            public boolean onDown(float f, float f2) {
                if (VamosSugPageScene.this.f27186c.getSugViewController() == null) {
                    return false;
                }
                VamosSugPageScene.this.f27186c.getSugViewController().onMapTouch();
                return false;
            }

            public boolean onScroll(float f, float f2) {
                if (VamosSugPageScene.this.f27186c.getSugViewController() == null) {
                    return false;
                }
                VamosSugPageScene.this.f27186c.getSugViewController().onMapScroll();
                return false;
            }
        };
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        try {
            m19228c();
        } catch (AddressException e) {
            e.printStackTrace();
        }
        if (getMap() != null) {
            getMap().addOnMapGestureListener(this.f27190g);
            doBestView(new Padding(0, 0, 0, 0));
        }
    }

    public void leave() {
        super.leave();
        IDidiAddressApi iDidiAddressApi = this.f27186c;
        if (iDidiAddressApi != null) {
            iDidiAddressApi.closeFragment();
        }
        IDepartureCompContract iDepartureCompContract = this.f27187d;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f27187d = null;
        }
        if (getMap() != null) {
            getMap().removeOnMapGestureListener(this.f27190g);
        }
    }

    public void onResume() {
        IDepartureCompContract iDepartureCompContract;
        super.onResume();
        if (this.isSceneValid && (iDepartureCompContract = this.f27187d) != null) {
            iDepartureCompContract.onMapVisible(true);
        }
    }

    public void onPause() {
        IDepartureCompContract iDepartureCompContract;
        super.onPause();
        if (this.isSceneValid && (iDepartureCompContract = this.f27187d) != null) {
            iDepartureCompContract.onMapVisible(false);
        }
    }

    /* renamed from: c */
    private void m19228c() throws AddressException {
        this.f27186c.selectAddress((Activity) ((VamosSugPageSceneParam) this.mParam).getContext(), ((VamosSugPageSceneParam) this.mParam).getContainer(), ((VamosSugPageSceneParam) this.mParam).getSugParams(), m19219a(((VamosSugPageSceneParam) this.mParam).getSugSceneCallback()));
        this.f27186c.setSugControlCallback(this.f27193j);
        m19223a(((VamosSugPageSceneParam) this.mParam).getSugParams());
        this.f27189f = ((VamosSugPageSceneParam) this.mParam).getSugParams().fromType;
    }

    /* renamed from: a */
    private void m19223a(SugParams sugParams) {
        if (this.mParam != null && ((VamosSugPageSceneParam) this.mParam).getActorGetter() != null) {
            if (((VamosSugPageSceneParam) this.mParam).getActorGetter().getActor() == 0) {
                sugParams.usrType = "rider";
            } else if (((VamosSugPageSceneParam) this.mParam).getActorGetter().getActor() == 1) {
                sugParams.usrType = "driver";
            }
            if (this.f27191h == null) {
                this.f27191h = new SceneUpdater(sugParams.fromType, ((VamosSugPageSceneParam) this.mParam).getActorGetter().getActor());
                m19231d();
            }
        }
    }

    public boolean onBackPressed() {
        IDidiAddressApi iDidiAddressApi = this.f27186c;
        return iDidiAddressApi != null && iDidiAddressApi.onBackPressed();
    }

    /* renamed from: a */
    private GlobalSugCallback m19219a(final IVamosSugSceneCallback iVamosSugSceneCallback) {
        if (iVamosSugSceneCallback == null) {
            return null;
        }
        return new GlobalSugCallback() {
            public void onCloseButtonClick() {
                SystemUtils.log(3, VamosSugPageScene.f27184a, "GlobalSugCallback onCloseButtonClick()", (Throwable) null, "com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene$4", 415);
                iVamosSugSceneCallback.onCloseButtonClick();
            }

            public void setResult(AddressResult addressResult) {
                SystemUtils.log(3, VamosSugPageScene.f27184a, "GlobalSugCallback setResult()", (Throwable) null, "com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene$4", 421);
                iVamosSugSceneCallback.setResult(convertSugResult(addressResult));
            }

            private VamosSugResult convertSugResult(AddressResult addressResult) {
                if (addressResult == null) {
                    return null;
                }
                VamosSugResult vamosSugResult = new VamosSugResult();
                vamosSugResult.common = addressResult.common;
                vamosSugResult.company = addressResult.company;
                vamosSugResult.end = addressResult.end;
                vamosSugResult.fromType = addressResult.fromType;
                vamosSugResult.home = addressResult.home;
                vamosSugResult.isStartNeedNearRoad = addressResult.isStartNeedNearRoad;
                vamosSugResult.start = addressResult.start;
                vamosSugResult.type = addressResult.type;
                return vamosSugResult;
            }
        };
    }

    /* renamed from: d */
    private void m19231d() {
        SceneUpdater sceneUpdater = this.f27191h;
        if (sceneUpdater != null) {
            sceneUpdater.updateSugPageType();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19222a(int i) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = PageScene.class.getDeclaredField("b");
        declaredField.setAccessible(true);
        declaredField.setInt(this, i);
    }

    class SceneUpdater {
        private FromType fromType;
        private int thisTimeSceneId = -1;
        private int usertype;

        public SceneUpdater(FromType fromType2, int i) {
            this.fromType = fromType2;
            this.usertype = i;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0047 A[SYNTHETIC, Splitter:B:29:0x0047] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void updateSugPageType() {
            /*
                r4 = this;
                com.didi.address.FromType r0 = r4.fromType
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                int[] r0 = com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.C97445.$SwitchMap$com$didi$address$FromType
                com.didi.address.FromType r1 = r4.fromType
                int r1 = r1.ordinal()
                r0 = r0[r1]
                r1 = -1
                r2 = 1
                if (r0 == r2) goto L_0x0038
                r3 = 2
                if (r0 == r3) goto L_0x002c
                r3 = 3
                if (r0 == r3) goto L_0x0020
                r2 = 4
                if (r0 == r2) goto L_0x001d
                goto L_0x0044
            L_0x001d:
                r0 = 2021(0x7e5, float:2.832E-42)
                goto L_0x0045
            L_0x0020:
                int r0 = r4.usertype
                if (r0 != r2) goto L_0x0027
                r0 = 2019(0x7e3, float:2.829E-42)
                goto L_0x0045
            L_0x0027:
                if (r0 != 0) goto L_0x0044
                r0 = 2020(0x7e4, float:2.83E-42)
                goto L_0x0045
            L_0x002c:
                int r0 = r4.usertype
                if (r0 != r2) goto L_0x0033
                r0 = 2017(0x7e1, float:2.826E-42)
                goto L_0x0045
            L_0x0033:
                if (r0 != 0) goto L_0x0044
                r0 = 2018(0x7e2, float:2.828E-42)
                goto L_0x0045
            L_0x0038:
                int r0 = r4.usertype
                if (r0 != r2) goto L_0x003f
                r0 = 2015(0x7df, float:2.824E-42)
                goto L_0x0045
            L_0x003f:
                if (r0 != 0) goto L_0x0044
                r0 = 2016(0x7e0, float:2.825E-42)
                goto L_0x0045
            L_0x0044:
                r0 = -1
            L_0x0045:
                if (r0 == r1) goto L_0x0056
                com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene r1 = com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.this     // Catch:{ NoSuchFieldException -> 0x0052, IllegalAccessException -> 0x004d }
                r1.m19222a((int) r0)     // Catch:{ NoSuchFieldException -> 0x0052, IllegalAccessException -> 0x004d }
                goto L_0x0056
            L_0x004d:
                r1 = move-exception
                r1.printStackTrace()
                goto L_0x0056
            L_0x0052:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0056:
                r4.thisTimeSceneId = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.vamos.sug.VamosSugPageScene.SceneUpdater.updateSugPageType():void");
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (getMap() != null && padding != null) {
            getMap().setPadding(this.mPadding.left, this.mPadding.top, this.mPadding.right, this.mPadding.bottom);
        }
    }
}
