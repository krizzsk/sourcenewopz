package com.didi.soda.customer.component.flutterordermap;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.global.map.animation.transition.SodaAnimLatLng;
import com.didi.global.map.animation.transition.util.FramesUtil;
import com.didi.global.map.animation.transition.util.SphericalUtil;
import com.didi.soda.customer.biz.sliding.ISlidingLooperService;
import com.didi.soda.customer.biz.sliding.SlidingLooperService;
import com.didi.soda.customer.component.flutterordermap.Contract;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusModel;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusRepo;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapUtil;
import com.didi.soda.customer.component.flutterordermap.model.AbstractOrderStatus;
import com.didi.soda.customer.component.flutterordermap.model.OrderStatusFactory;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.Bubble;
import com.didi.soda.customer.foundation.rpc.entity.MapData;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.map.MapStateModel;
import com.didi.soda.customer.map.MapStateRepo;
import com.didi.soda.customer.map.model.BestViewModel;
import com.didi.soda.customer.repo.RepoFactory;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.taxis99.R;

public class OrderMapPresenter extends Contract.AbsMapPresenter {

    /* renamed from: b */
    private static final String f40790b = "OrderMapPresenter";

    /* renamed from: a */
    SlidingLooperService.DriverSlidingListener f40791a = new SlidingLooperService.DriverSlidingListener() {
        public void onDriverSlidingChange(DriverCollection driverCollection) {
            if (OrderMapPresenter.this.f40800k != null && OrderMapPresenter.this.f40800k.isSupportSliding() && OrderMapPresenter.this.getScopeContext().getLiveHandler().isActive()) {
                OrderMapPresenter.this.m28966a(driverCollection);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OrderMapStatusModel f40792c;

    /* renamed from: d */
    private LatLng f40793d;

    /* renamed from: e */
    private LatLng f40794e;

    /* renamed from: f */
    private LatLng f40795f;

    /* renamed from: g */
    private int f40796g;

    /* renamed from: h */
    private boolean f40797h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ISlidingLooperService f40798i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f40799j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AbstractOrderStatus f40800k;

    /* renamed from: l */
    private boolean f40801l = true;

    public void onCreate() {
        super.onCreate();
        m28960a();
        m28975d();
        m28972c();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m28976e();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m28969b();
        if (this.f40801l) {
            this.f40801l = false;
            return;
        }
        LogUtil.m29104i(f40790b, "onResume showBestView");
        m28980i();
    }

    /* renamed from: a */
    private void m28960a() {
        this.f40796g = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_10);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f40798i.stop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public void setDraggedMap(boolean z) {
        this.f40797h = z;
    }

    /* renamed from: b */
    private void m28969b() {
        if (!((MapStateRepo) RepoFactory.getRepo(MapStateRepo.class)).mapReady()) {
            LogUtil.m29104i(f40790b, "Map not ready when init order.");
            ((MapStateRepo) RepoFactory.getRepo(MapStateRepo.class)).subscribe(getScopeContext(), new Action2() {
                public final void call(Object obj, Subscription subscription) {
                    OrderMapPresenter.this.m28965a((MapStateModel) obj, subscription);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28965a(MapStateModel mapStateModel, Subscription subscription) {
        if (mapStateModel.mapReady) {
            LogUtil.m29104i(f40790b, "Order refresh after mMap ready showBestView");
            m28980i();
            subscription.unsubscribe();
        }
    }

    /* renamed from: c */
    private void m28972c() {
        ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).subscribe(getScopeContext(), new Action1<OrderMapStatusModel>() {
            public void call(OrderMapStatusModel orderMapStatusModel) {
                LogUtil.m29104i(OrderMapPresenter.f40790b, "set OrderMapStatusModel showBestView:" + orderMapStatusModel);
                if (orderMapStatusModel != null) {
                    OrderMapPresenter.this.setDraggedMap(false);
                    OrderMapStatusModel b = OrderMapPresenter.this.f40792c;
                    OrderMapStatusModel unused = OrderMapPresenter.this.f40792c = orderMapStatusModel;
                    int unused2 = OrderMapPresenter.this.f40799j = orderMapStatusModel.getOrderStatus();
                    OrderMapPresenter orderMapPresenter = OrderMapPresenter.this;
                    AbstractOrderStatus unused3 = orderMapPresenter.f40800k = OrderStatusFactory.getOrderStatus(orderMapPresenter.f40799j);
                    OrderMapPresenter.this.f40800k.updateOrderData(orderMapStatusModel);
                    OrderMapPresenter.this.f40800k.setLocation(OrderMapPresenter.this.getBusinessLatLng(), OrderMapPresenter.this.getCustomerLatLng(), OrderMapPresenter.this.getDeliveryLatLng());
                    if (OrderMapUtil.isOrderIdChange(b, orderMapStatusModel)) {
                        ((Contract.AbsMapView) OrderMapPresenter.this.getLogicView()).clearMapWithRider();
                    }
                    OrderMapPresenter.this.m28964a(b, orderMapStatusModel);
                    return;
                }
                ((Contract.AbsMapView) OrderMapPresenter.this.getLogicView()).clearMapWithRider();
                ((Contract.AbsMapView) OrderMapPresenter.this.getLogicView()).centerBestView((BestViewer.IBestViewListener) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28964a(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (OrderMapUtil.isOrderStatusChange(orderMapStatusModel, orderMapStatusModel2) || OrderMapUtil.isDeliveryStatusChange(orderMapStatusModel, orderMapStatusModel2)) {
            m28967a(true);
            return;
        }
        if (OrderMapUtil.isOrderBubbleContentChange(orderMapStatusModel, orderMapStatusModel2)) {
            ((Contract.AbsMapView) getLogicView()).updateBubbleContent(m28978g(), isSelfDelivery());
        }
        if (orderMapStatusModel2.manualMapRest && this.f40800k != null) {
            ((Contract.AbsMapView) getLogicView()).centerBestView((BestViewer.IBestViewListener) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28966a(DriverCollection driverCollection) {
        Driver driver;
        if (driverCollection != null && driverCollection.size() > 0 && (driver = (Driver) driverCollection.get(0)) != null && driver.getVectorCoordinateList() != null && driver.getVectorCoordinateList().size() > 0) {
            VectorCoordinate vectorCoordinate = (VectorCoordinate) driver.getVectorCoordinateList().get(0);
            double lat = vectorCoordinate.getLat();
            double lng = vectorCoordinate.getLng();
            SodaAnimLatLng sodaAnimLatLng = new SodaAnimLatLng(new LatLng(lat, lng), vectorCoordinate.getTimeStamp(), vectorCoordinate.getAngle());
            m28961a(lat, lng);
            ((Contract.AbsMapView) getLogicView()).slidingRider(sodaAnimLatLng);
            OmegaTracker.Builder.create(EventConst.Trace.SAILING_C_K_SYSTEM_ORDER_SLIDING).addEventParam("driver", GsonUtil.toJson(vectorCoordinate)).build().track();
        }
    }

    /* renamed from: d */
    private void m28975d() {
        SlidingLooperService slidingLooperService = new SlidingLooperService(getAnimIntervalTime());
        this.f40798i = slidingLooperService;
        slidingLooperService.addDriverSlidingListener(this.f40791a);
        getScopeContext().getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                OrderMapPresenter.this.f40798i.removeDriverSlidingListener(OrderMapPresenter.this.f40791a);
                OrderMapPresenter.this.f40798i.stop();
            }
        });
    }

    /* renamed from: a */
    private void m28967a(boolean z) {
        if (isActive()) {
            int i = this.f40799j;
            if (i == 0) {
                ((Contract.AbsMapView) getLogicView()).clearMapWithEmpty();
            } else if (i == 100 || i == 120 || i == 140) {
                ((Contract.AbsMapView) getLogicView()).showBusinessAndUserMarker();
            } else if (i == 200 || i == 300) {
                m28977f();
            } else if (i != 400) {
                if (i != 500) {
                    ((Contract.AbsMapView) getLogicView()).slidingRider((SodaAnimLatLng) null);
                    ((Contract.AbsMapView) getLogicView()).clearMapWithEmpty();
                } else if (this.f40792c.mDeliveryType == 2) {
                    m28979h();
                } else if (this.f40792c.mDeliveryType == 1) {
                    m28973c(z);
                }
            } else if (this.f40792c.mDeliveryType == 2) {
                m28979h();
            } else if (this.f40792c.mDeliveryType == 1) {
                m28970b(z);
            }
            m28976e();
        }
    }

    /* renamed from: e */
    private void m28976e() {
        OrderMapStatusModel orderMapStatusModel;
        this.f40798i.stop();
        AbstractOrderStatus abstractOrderStatus = this.f40800k;
        if (abstractOrderStatus != null && abstractOrderStatus.isSupportSliding() && (orderMapStatusModel = this.f40792c) != null && orderMapStatusModel.mDeliveryType == 1) {
            int i = this.f40799j;
            if (i == 400 || i == 500 || OrderMapUtil.needShowRiderForBusinessPrepare(this.f40792c)) {
                this.f40798i.start(this.f40792c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needShowRiderForBusinessPrepare() {
        OrderMapStatusModel orderMapStatusModel = this.f40792c;
        if (orderMapStatusModel == null) {
            return false;
        }
        return OrderMapUtil.needShowRiderForBusinessPrepare(orderMapStatusModel);
    }

    /* renamed from: f */
    private void m28977f() {
        if (this.f40792c.mDeliveryType == 2) {
            ((Contract.AbsMapView) getLogicView()).showMapWithBusinessPrepare();
        } else if (this.f40792c.mDeliveryType != 1) {
        } else {
            if (needShowRiderForBusinessPrepare()) {
                ((Contract.AbsMapView) getLogicView()).showRiderForBusinessPrepare(m28978g());
            } else {
                ((Contract.AbsMapView) getLogicView()).showMapWithBusinessPrepare();
            }
        }
    }

    /* renamed from: b */
    private void m28970b(boolean z) {
        FramesUtil.initDefaultAngle(getDeliveryLatLng(), getBusinessLatLng());
        boolean z2 = true;
        if (getBusinessLatLng() == null || getDeliveryLatLng() == null) {
            ((Contract.AbsMapView) getLogicView()).showMapRiderToken(true, m28978g(), z);
            return;
        }
        Contract.AbsMapView absMapView = (Contract.AbsMapView) getLogicView();
        if (SphericalUtil.computeDistanceBetween(getBusinessLatLng(), getDeliveryLatLng()) >= ((double) CustomerApolloUtil.getPollingBDDistance())) {
            z2 = false;
        }
        absMapView.showMapRiderToken(z2, m28978g(), z);
    }

    /* renamed from: g */
    private Bubble m28978g() {
        OrderMapStatusModel orderMapStatusModel = this.f40792c;
        if (orderMapStatusModel == null || orderMapStatusModel.mMapData == null) {
            return null;
        }
        return this.f40792c.mMapData.getBubble();
    }

    /* renamed from: h */
    private void m28979h() {
        if (this.f40792c.mMapData != null) {
            ((Contract.AbsMapView) getLogicView()).showMapWithBusinessDelivery(this.f40792c.mMapData.getBubble());
        }
    }

    /* renamed from: c */
    private void m28973c(boolean z) {
        FramesUtil.initDefaultAngle(getDeliveryLatLng(), getCustomerLatLng());
        ((Contract.AbsMapView) getLogicView()).showMapRiderArrive(m28978g(), z);
    }

    /* renamed from: i */
    private void m28980i() {
        if (this.f40800k != null && this.f40792c != null) {
            m28967a(false);
        }
    }

    /* access modifiers changed from: package-private */
    public BestViewModel getBestViewModel() {
        Padding padding = new Padding(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), this.f40796g * 12, ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), (CustomerSystemUtil.getScreenHeight(getContext()) - DisplayUtils.getScreenWidth(getContext())) + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_180));
        LogUtil.m29100d("OrderCardView", "padding:" + padding);
        BestViewModel bestViewModel = new BestViewModel();
        bestViewModel.mPadding = padding;
        return bestViewModel;
    }

    public int getAnimIntervalTime() {
        return CustomerApolloUtil.getPollingDuration() * 1000;
    }

    /* access modifiers changed from: package-private */
    public boolean isSelfDelivery() {
        OrderMapStatusModel orderMapStatusModel = this.f40792c;
        return orderMapStatusModel != null && orderMapStatusModel.mDeliveryType == 2;
    }

    public LatLng getBusinessLatLng() {
        OrderMapStatusModel orderMapStatusModel;
        if (!(this.f40793d != null || (orderMapStatusModel = this.f40792c) == null || orderMapStatusModel.mMapData == null || this.f40792c.mMapData.getShopLat() == 0.0d || this.f40792c.mMapData.getShopLng() == 0.0d)) {
            MapData mapData = this.f40792c.mMapData;
            this.f40793d = new LatLng(mapData.getShopLat(), mapData.getShopLng());
        }
        return this.f40793d;
    }

    public LatLng getCustomerLatLng() {
        OrderMapStatusModel orderMapStatusModel;
        if (!(this.f40794e != null || (orderMapStatusModel = this.f40792c) == null || orderMapStatusModel.mMapData == null || this.f40792c.mMapData.getUserLat() == 0.0d || this.f40792c.mMapData.getUserLng() == 0.0d)) {
            MapData mapData = this.f40792c.mMapData;
            this.f40794e = new LatLng(mapData.getUserLat(), mapData.getUserLng());
        }
        return this.f40794e;
    }

    public LatLng getDeliveryLatLng() {
        OrderMapStatusModel orderMapStatusModel;
        if (!(this.f40795f != null || (orderMapStatusModel = this.f40792c) == null || orderMapStatusModel.mMapData == null || this.f40792c.mMapData.getRiderLng() == 0.0d || this.f40792c.mMapData.getRiderLat() == 0.0d)) {
            MapData mapData = this.f40792c.mMapData;
            this.f40795f = new LatLng(mapData.getRiderLat(), mapData.getRiderLng());
        }
        return this.f40795f;
    }

    /* renamed from: a */
    private void m28961a(double d, double d2) {
        String str;
        LatLng latLng = new LatLng(d, d2);
        this.f40795f = latLng;
        if (latLng != null) {
            str = this.f40795f.latitude + "-" + this.f40795f.longitude;
        } else {
            str = "";
        }
        LogUtil.m29104i("OrderMapPresenter getDeliveryLatLng", str);
    }
}
