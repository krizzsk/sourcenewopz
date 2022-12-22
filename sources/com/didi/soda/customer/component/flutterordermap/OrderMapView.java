package com.didi.soda.customer.component.flutterordermap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.global.map.animation.transition.SodaAnimEngine;
import com.didi.global.map.animation.transition.SodaAnimLatLng;
import com.didi.global.map.animation.transition.callback.OnTranslateAnimEndCallback;
import com.didi.soda.customer.component.flutterordermap.Contract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.Bubble;
import com.didi.soda.customer.map.listener.MapGestureListener;
import com.didi.soda.customer.map.marker.AbsMarker;
import com.didi.soda.customer.map.marker.BusinessMarker;
import com.didi.soda.customer.map.marker.DestAddressMarker;
import com.didi.soda.customer.map.marker.LineCenterLocationMarker;
import com.didi.soda.customer.map.marker.RiderMarker;
import com.didi.soda.customer.map.model.BestViewModel;
import com.didi.soda.customer.widget.map.SodaMapView;
import com.taxis99.R;

public class OrderMapView extends Contract.AbsMapView {

    /* renamed from: a */
    private static final String f40802a = "OrderMapView";

    /* renamed from: b */
    private BusinessMarker f40803b;

    /* renamed from: c */
    private RiderMarker f40804c;

    /* renamed from: d */
    private DestAddressMarker f40805d;

    /* renamed from: e */
    private LineCenterLocationMarker f40806e;

    /* renamed from: f */
    private SodaMapView f40807f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SodaAnimEngine f40808g;

    /* renamed from: h */
    private ViewGroup f40809h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f40810i = true;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f40811j = false;

    /* renamed from: k */
    private DefaultMapGestureListener f40812k;

    public void onCreate() {
        super.onCreate();
        SodaAnimEngine sodaAnimEngine = new SodaAnimEngine(getContext());
        this.f40808g = sodaAnimEngine;
        sodaAnimEngine.setTranslateIntervalTime((long) ((Contract.AbsMapPresenter) getPresenter()).getAnimIntervalTime());
        this.f40808g.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
            public void onTranslateAnimEnd() {
                LogUtil.m29100d(OrderMapView.f40802a, "onTranslateAnimEnd start--------");
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    if (((Contract.AbsMapPresenter) OrderMapView.this.getPresenter()).needShowRiderForBusinessPrepare()) {
                        OrderMapView orderMapView = OrderMapView.this;
                        orderMapView.m28982a((BestViewer.IBestViewListener) null, orderMapView.m28990c(), OrderMapView.this.m28995e());
                    } else {
                        OrderMapView orderMapView2 = OrderMapView.this;
                        orderMapView2.m28982a((BestViewer.IBestViewListener) null, orderMapView2.m28992d(), OrderMapView.this.m28995e());
                    }
                }
                LogUtil.m29100d(OrderMapView.f40802a, "onTranslateAnimEnd end--------");
            }
        });
        this.f40807f.getSodaMapAsync(new OnMapReadyCallBack() {
            public final void onMapReady(Map map) {
                OrderMapView.this.m28983a(map);
            }
        });
        LogUtil.m29104i(f40802a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28983a(Map map) {
        this.f40807f.removeTopView();
        if (this.f40807f.getMapImpl() != null) {
            m28990c().updateMapView(this.f40807f.getMapImpl());
            m28992d().updateMapView(this.f40807f.getMapImpl());
            m28995e().updateMapView(this.f40807f.getMapImpl());
            m28997f().updateMapView(this.f40807f.getMapImpl());
            this.f40812k = new DefaultMapGestureListener();
            this.f40807f.getMapImpl().addOnMapGestureListener(this.f40812k);
        }
    }

    public void onStart() {
        super.onStart();
        this.f40807f.onResume();
        LogUtil.m29104i(f40802a, "onStart");
        this.f40808g.onResume();
    }

    public void onStop() {
        super.onStop();
        LogUtil.m29104i(f40802a, "onStop");
        this.f40808g.onPause();
        this.f40807f.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        m28988b();
        if (this.f40807f.getMapImpl() != null) {
            this.f40807f.getMapImpl().removeOnMapGestureListener(this.f40812k);
        }
        this.f40807f.onDestroy();
        this.f40808g.onDestroy();
        LogUtil.m29104i(f40802a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LogUtil.m29104i(f40802a, "onResume");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LogUtil.m29104i(f40802a, "onPause");
        m28990c().removeLine();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.customer_page_order_map, viewGroup);
        this.f40809h = viewGroup2;
        this.f40807f = (SodaMapView) viewGroup2.findViewById(R.id.customer_custom_map_view);
        return this.f40809h;
    }

    /* access modifiers changed from: package-private */
    public void centerBestView(BestViewer.IBestViewListener iBestViewListener) {
        LogUtil.m29104i(f40802a, "centerBestView start");
        m28982a(iBestViewListener, m28990c(), m28992d(), m28995e(), m28997f());
        LogUtil.m29104i(f40802a, "centerBestView end");
    }

    /* access modifiers changed from: package-private */
    public void slidingRider(SodaAnimLatLng sodaAnimLatLng) {
        if (!this.f40808g.isDeliverTranslateAnimRunning()) {
            this.f40808g.onLocationChanged(sodaAnimLatLng);
        }
    }

    /* access modifiers changed from: package-private */
    public void showBusinessAndUserMarker() {
        m28990c().attachToMap(getBusinessLatLng());
        m28992d().attachToMap(getCustomerLatLng());
        m28982a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m29104i(OrderMapView.f40802a, "showBusinessAndUserMarker onFinished start");
                    if (OrderMapView.this.m28990c().isExist()) {
                        OrderMapView.this.m28990c().setVisible(true);
                    }
                    if (OrderMapView.this.m28992d().isExist()) {
                        OrderMapView.this.m28992d().setVisible(true);
                    }
                    LogUtil.m29104i(OrderMapView.f40802a, "showBusinessAndUserMarker onFinished end");
                }
            }
        }, m28990c(), m28992d());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28982a(BestViewer.IBestViewListener iBestViewListener, AbsMarker... absMarkerArr) {
        BestViewModel bestViewModel = ((Contract.AbsMapPresenter) getPresenter()).getBestViewModel();
        if (absMarkerArr != null && absMarkerArr.length > 0) {
            for (AbsMarker absMarker : absMarkerArr) {
                if (absMarker != null && absMarker.isRealExistInMapView()) {
                    bestViewModel.mapElements.add(absMarker.getMarker());
                    bestViewModel.mIncludes.add(absMarker.getMarker().getPosition());
                }
            }
        }
        this.f40807f.centerBestViewWithMapElement(bestViewModel, iBestViewListener);
    }

    /* access modifiers changed from: package-private */
    public void clearMapWithEmpty() {
        m28992d().remove();
        m28990c().remove();
        m28995e().remove();
        m28997f().remove();
    }

    /* access modifiers changed from: package-private */
    public void clearMapWithRider() {
        m28992d().remove();
        m28990c().remove();
        m28997f().remove();
        m28997f().removeInfoWindow();
        m28995e().setVisible(false);
        m28995e().hideInfoWindow();
    }

    /* access modifiers changed from: package-private */
    public void updateBubbleContent(Bubble bubble, boolean z) {
        if (z) {
            m28997f().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
            m28997f().showInfoWindow();
            return;
        }
        m28995e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
        m28995e().showInfoWindow();
    }

    /* access modifiers changed from: package-private */
    public void showMapWithBusinessPrepare() {
        m28995e().remove();
        m28992d().attachToMap(getCustomerLatLng());
        if (!this.f40811j) {
            m28990c().attachToMapWithAnim(getBusinessLatLng());
        } else {
            m28990c().attachToMap(getBusinessLatLng());
        }
        this.f40808g.setCustomerMarker(m28992d().getMarker());
        this.f40808g.setBusinessMarker(m28990c().getMarker());
        m28982a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m29104i(OrderMapView.f40802a, "showMapWithBusinessPrepare onFinished start");
                    if (OrderMapView.this.m28990c().isExist()) {
                        OrderMapView.this.m28990c().setVisible(true);
                        if (!OrderMapView.this.f40811j) {
                            boolean unused = OrderMapView.this.f40811j = true;
                            OrderMapView.this.f40808g.doBusinessAnim(true);
                        }
                    }
                    if (OrderMapView.this.m28992d().isExist()) {
                        OrderMapView.this.m28992d().setVisible(true);
                    }
                    LogUtil.m29104i(OrderMapView.f40802a, "showMapWithBusinessPrepare onFinished end");
                }
            }
        }, m28990c(), m28992d());
    }

    /* access modifiers changed from: package-private */
    public void showRiderForBusinessPrepare(Bubble bubble) {
        m28992d().remove();
        m28995e().attachToMap(getDeliveryLatLng());
        m28995e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
        m28990c().attachToMap(getBusinessLatLng());
        this.f40808g.setDeliveryMarker(m28995e().getMarker());
        this.f40808g.setBusinessMarker(m28990c().getMarker());
        this.f40808g.setAnimState(1);
        m28982a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m29104i(OrderMapView.f40802a, "showMapWithRiderGoToBusiness onFinished start");
                    if (OrderMapView.this.m28990c().isExist()) {
                        OrderMapView.this.m28990c().setVisible(true);
                    }
                    if (OrderMapView.this.m28995e().isExist()) {
                        OrderMapView.this.m28995e().setVisible(true);
                        OrderMapView.this.m28995e().showInfoWindow();
                    }
                    LogUtil.m29104i(OrderMapView.f40802a, "showMapWithRiderGoToBusiness onFinished end");
                }
            }
        }, m28990c(), m28995e());
    }

    /* access modifiers changed from: package-private */
    public void showMapRiderToken(final boolean z, Bubble bubble, boolean z2) {
        if (!this.f40808g.isDeliverTranslateAnimRunning() || z2 || m28985a()) {
            m28990c().remove();
            m28992d().attachToMap(getCustomerLatLng());
            m28995e().attachToMap(getDeliveryLatLng());
            m28995e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
            this.f40808g.setCustomerMarker(m28992d().getMarker());
            this.f40808g.setDeliveryMarker(m28995e().getMarker());
            m28982a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                    if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                        LogUtil.m29104i(OrderMapView.f40802a, "showMapRiderToken onFinished start");
                        if (OrderMapView.this.m28992d().isExist()) {
                            OrderMapView.this.m28992d().setVisible(true);
                        }
                        if (OrderMapView.this.m28995e().isExist()) {
                            OrderMapView.this.m28995e().setVisible(true);
                            if (OrderMapView.this.f40810i && !OrderMapView.this.f40808g.doBoxAnim() && z) {
                                OrderMapView.this.f40808g.setAnimState(2);
                                OrderMapView.this.f40808g.doBoxAnim();
                                boolean unused = OrderMapView.this.f40810i = false;
                            }
                            OrderMapView.this.m28995e().showInfoWindow();
                            OrderMapView.this.f40808g.setAnimState(3);
                        }
                        LogUtil.m29104i(OrderMapView.f40802a, "showMapRiderToken onFinished end");
                    }
                }
            }, m28992d(), m28995e());
        }
    }

    /* renamed from: a */
    private boolean m28985a() {
        return !m28995e().isRealExistInMapView() || !m28992d().isRealExistInMapView();
    }

    /* access modifiers changed from: package-private */
    public void showMapRiderArrive(Bubble bubble, boolean z) {
        if (!this.f40808g.isDeliverTranslateAnimRunning() || z || m28985a()) {
            m28990c().remove();
            m28992d().attachToMap(getCustomerLatLng());
            m28995e().attachToMap(getDeliveryLatLng());
            m28995e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
            this.f40808g.setCustomerMarker(m28992d().getMarker());
            this.f40808g.setDeliveryMarker(m28995e().getMarker());
            this.f40808g.setAnimState(4);
            m28982a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                    if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                        LogUtil.m29104i(OrderMapView.f40802a, "showMapWithBusinessPrepare onFinished start");
                        if (OrderMapView.this.m28992d().isExist()) {
                            OrderMapView.this.m28992d().setVisible(true);
                        }
                        if (OrderMapView.this.m28995e().isExist()) {
                            OrderMapView.this.m28995e().setVisible(true);
                            if (OrderMapView.this.f40810i && !OrderMapView.this.f40808g.doBoxAnim()) {
                                OrderMapView.this.f40808g.doBoxAnim();
                            }
                            OrderMapView.this.m28995e().showInfoWindow();
                        }
                        LogUtil.m29104i(OrderMapView.f40802a, "showMapWithBusinessPrepare onFinished end");
                    }
                }
            }, m28995e(), m28992d());
        }
    }

    /* access modifiers changed from: package-private */
    public void showMapWithBusinessDelivery(Bubble bubble) {
        m28990c().attachToMap(getBusinessLatLng(), getCustomerLatLng());
        m28992d().attachToMap(getCustomerLatLng());
        m28997f().attachToMap(m28990c().getLineCenter());
        m28997f().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
        m28982a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m29104i(OrderMapView.f40802a, "showMapWithBusinessDelivery onFinished start");
                    if (OrderMapView.this.m28992d().isExist()) {
                        OrderMapView.this.m28992d().setVisible(true);
                    }
                    if (OrderMapView.this.m28990c().isExist()) {
                        OrderMapView.this.m28990c().setVisible(true);
                        OrderMapView.this.m28990c().setLineVisible(true);
                    }
                    if (OrderMapView.this.m28997f().isExist()) {
                        OrderMapView.this.m28997f().setVisible(true);
                        OrderMapView.this.m28997f().showInfoWindow();
                    }
                    LogUtil.m29104i(OrderMapView.f40802a, "showMapWithBusinessDelivery onFinished end");
                }
            }
        }, m28990c(), m28992d());
    }

    /* renamed from: b */
    private void m28988b() {
        BusinessMarker businessMarker = this.f40803b;
        if (businessMarker != null) {
            businessMarker.onDestroy();
            this.f40803b = null;
        }
        DestAddressMarker destAddressMarker = this.f40805d;
        if (destAddressMarker != null) {
            destAddressMarker.onDestroy();
            this.f40805d = null;
        }
        RiderMarker riderMarker = this.f40804c;
        if (riderMarker != null) {
            riderMarker.onDestroy();
            this.f40804c = null;
        }
        LineCenterLocationMarker lineCenterLocationMarker = this.f40806e;
        if (lineCenterLocationMarker != null) {
            lineCenterLocationMarker.onDestroy();
            this.f40806e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public BusinessMarker m28990c() {
        if (this.f40803b == null) {
            this.f40803b = new BusinessMarker(getContext(), this.f40807f.getMapImpl());
        }
        return this.f40803b;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public DestAddressMarker m28992d() {
        if (this.f40805d == null) {
            this.f40805d = new DestAddressMarker(getContext(), this.f40807f.getMapImpl());
        }
        return this.f40805d;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public RiderMarker m28995e() {
        if (this.f40804c == null) {
            this.f40804c = new RiderMarker(getContext(), this.f40807f.getMapImpl());
        }
        return this.f40804c;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public LineCenterLocationMarker m28997f() {
        if (this.f40806e == null) {
            this.f40806e = new LineCenterLocationMarker(getContext(), this.f40807f.getMapImpl());
        }
        return this.f40806e;
    }

    public LatLng getBusinessLatLng() {
        return ((Contract.AbsMapPresenter) getPresenter()).getBusinessLatLng();
    }

    public LatLng getCustomerLatLng() {
        return ((Contract.AbsMapPresenter) getPresenter()).getCustomerLatLng();
    }

    public LatLng getDeliveryLatLng() {
        return ((Contract.AbsMapPresenter) getPresenter()).getDeliveryLatLng();
    }

    private class DefaultMapGestureListener extends MapGestureListener {
        float mDownX;
        float mDownY;

        private DefaultMapGestureListener() {
        }

        public boolean onScroll(float f, float f2) {
            ((Contract.AbsMapPresenter) OrderMapView.this.getPresenter()).setDraggedMap(true);
            return super.onScroll(f, f2);
        }

        public boolean onDown(float f, float f2) {
            this.mDownX = f;
            this.mDownY = f2;
            return super.onDown(f, f2);
        }

        public boolean onUp(float f, float f2) {
            if (Math.abs(f - this.mDownX) > 0.0f || Math.abs(f2 - this.mDownY) > 0.0f) {
                ((Contract.AbsMapPresenter) OrderMapView.this.getPresenter()).setDraggedMap(true);
            }
            return super.onUp(f, f2);
        }
    }
}
