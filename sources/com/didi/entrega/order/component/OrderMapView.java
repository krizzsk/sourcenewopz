package com.didi.entrega.order.component;

import android.content.Context;
import android.graphics.PointF;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.order.Tip;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.map.listener.MapGestureListener;
import com.didi.entrega.customer.map.marker.InfoWindowViewBuildConfig;
import com.didi.entrega.customer.map.marker.ReceiverMarker;
import com.didi.entrega.customer.map.marker.RiderMarker;
import com.didi.entrega.customer.map.marker.SenderMarker;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.entrega.customer.widget.map.SodaMapView;
import com.didi.entrega.order.component.Contract;
import com.didi.entrega.order.widgets.MarkerInfoWindowView;
import com.didi.entrega.order.widgets.SpreadView;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.didi.global.map.animation.SodaAnimEngine;
import com.didi.global.map.animation.SodaAnimLatLng;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ]2\u00020\u0001:\u0002]^B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020-H\u0014J\b\u00104\u001a\u00020-H\u0014J\b\u00105\u001a\u00020-H\u0002J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020\u0004H\u0014J\b\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020-H\u0014J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\bH\u0014J\b\u0010B\u001a\u00020-H\u0014J\b\u0010C\u001a\u00020-H\u0014J\b\u0010D\u001a\u00020-H\u0014J\b\u0010E\u001a\u00020-H\u0014J<\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010\f2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0004H\u0014J2\u0010N\u001a\u00020-2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010O\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\f2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020-H\u0014J\b\u0010R\u001a\u00020-H\u0014J\b\u0010S\u001a\u00020-H\u0014J\u0010\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020\u0004H\u0014J\b\u0010V\u001a\u00020-H\u0002J\u001a\u0010W\u001a\u00020-2\b\u0010X\u001a\u0004\u0018\u00010\f2\u0006\u0010Y\u001a\u00020ZH\u0014J\b\u0010[\u001a\u00020-H\u0002J\b\u0010\\\u001a\u00020-H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u0018\u0010\"\u001a\u0004\u0018\u00010#8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000¨\u0006_"}, mo175978d2 = {"Lcom/didi/entrega/order/component/OrderMapView;", "Lcom/didi/entrega/order/component/Contract$AbsMapView;", "()V", "alreadyShowCompleteAnim", "", "mAnimEngine", "Lcom/didi/global/map/animation/SodaAnimEngine;", "mContainer", "Landroid/view/ViewGroup;", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mInfoWindowCenterLocation", "Lcom/didi/common/map/model/LatLng;", "mInfoWindowView", "Lcom/didi/entrega/order/widgets/MarkerInfoWindowView;", "mMapGestureListener", "Lcom/didi/entrega/order/component/OrderMapView$DefaultMapGestureListener;", "mOnCameraChangeListener", "Lcom/didi/common/map/listener/OnCameraChangeListener;", "mReceiverLatLng", "getMReceiverLatLng", "()Lcom/didi/common/map/model/LatLng;", "mReceiverMarker", "Lcom/didi/entrega/customer/map/marker/ReceiverMarker;", "getMReceiverMarker", "()Lcom/didi/entrega/customer/map/marker/ReceiverMarker;", "mRiderLatLng", "getMRiderLatLng", "mRiderMarker", "Lcom/didi/entrega/customer/map/marker/RiderMarker;", "getMRiderMarker", "()Lcom/didi/entrega/customer/map/marker/RiderMarker;", "mSenderLatLng", "getMSenderLatLng", "mSenderMarker", "Lcom/didi/entrega/customer/map/marker/SenderMarker;", "getMSenderMarker", "()Lcom/didi/entrega/customer/map/marker/SenderMarker;", "mSodaMapView", "Lcom/didi/entrega/customer/widget/map/SodaMapView;", "mSpreadBubbleHidden", "mSpreadCenterLocation", "mSpreadView", "Lcom/didi/entrega/order/widgets/SpreadView;", "cancelOldCountDownInfoWindow", "", "centerBestView", "model", "Lcom/didi/entrega/customer/map/model/BestViewModel;", "bestViewListener", "Lcom/didi/common/map/BestViewer$IBestViewListener;", "clearAllMapElement", "clearMapExceptRider", "destroyMarker", "doSlidingRiderAnim", "sodaAnimLatLng", "Lcom/didi/global/map/animation/SodaAnimLatLng;", "hideInfoWindow", "showAnim", "hideNormalInfoWindow", "hideSpreadView", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onCreate", "onDestroy", "onStart", "onStop", "showInfoWindow", "isMarkerInfoWindowTip", "originMapTip", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/Tip;", "latLng", "orderStatus", "", "needSpred", "showInfoWindowView", "tip", "hasAnim", "showMapWithRiderArriveReceiver", "showMapWithRiderArrivedSender", "showMapWithRiderComing", "showMapWithRiderToDelivering", "doBoxAnim", "showRiderMaker", "showSpreadView", "location", "type", "Lcom/didi/entrega/order/widgets/SpreadView$SpreadViewType;", "updateInfoWindowLocation", "updateSpreadLocation", "Companion", "DefaultMapGestureListener", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderMapView.kt */
public final class OrderMapView extends Contract.AbsMapView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: p */
    private static final String f20843p = "OrderMapView";

    /* renamed from: a */
    private SenderMarker f20844a;

    /* renamed from: b */
    private ReceiverMarker f20845b;

    /* renamed from: c */
    private RiderMarker f20846c;

    /* renamed from: d */
    private SodaMapView f20847d;

    /* renamed from: e */
    private MarkerInfoWindowView f20848e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SpreadView f20849f;

    /* renamed from: g */
    private SodaAnimEngine f20850g;

    /* renamed from: h */
    private ViewGroup f20851h;

    /* renamed from: i */
    private LatLng f20852i;

    /* renamed from: j */
    private CountDownTimer f20853j;

    /* renamed from: k */
    private LatLng f20854k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f20855l;

    /* renamed from: m */
    private boolean f20856m;

    /* renamed from: n */
    private DefaultMapGestureListener f20857n;

    /* renamed from: o */
    private final OnCameraChangeListener f20858o = new OnCameraChangeListener() {
        public final void onCameraChange(CameraPosition cameraPosition) {
            OrderMapView.m15270a(OrderMapView.this, cameraPosition);
        }
    };

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/order/component/OrderMapView$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderMapView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final SenderMarker m15268a() {
        SenderMarker senderMarker = this.f20844a;
        if (senderMarker == null) {
            LogUtil.m14765i(f20843p, Intrinsics.stringPlus("mSenderMarker====Instance ", senderMarker));
            Context context = getContext();
            SodaMapView sodaMapView = this.f20847d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            this.f20844a = new SenderMarker(context, sodaMapView.getMapImpl(), 2);
        }
        return this.f20844a;
    }

    /* renamed from: b */
    private final ReceiverMarker m15272b() {
        ReceiverMarker receiverMarker = this.f20845b;
        if (receiverMarker == null) {
            LogUtil.m14765i(f20843p, Intrinsics.stringPlus("mReceiverMarker====Instance ", receiverMarker));
            Context context = getContext();
            SodaMapView sodaMapView = this.f20847d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            this.f20845b = new ReceiverMarker(context, sodaMapView.getMapImpl(), 2);
        }
        return this.f20845b;
    }

    /* renamed from: c */
    private final RiderMarker m15273c() {
        RiderMarker riderMarker = this.f20846c;
        if (riderMarker == null) {
            LogUtil.m14765i(f20843p, Intrinsics.stringPlus("mRiderMarker====Instance ", riderMarker));
            Context context = getContext();
            SodaMapView sodaMapView = this.f20847d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            this.f20846c = new RiderMarker(context, sodaMapView.getMapImpl());
        }
        return this.f20846c;
    }

    /* renamed from: d */
    private final LatLng m15274d() {
        return ((Contract.AbsMapPresenter) getPresenter()).getSenderLatLng();
    }

    /* renamed from: e */
    private final LatLng m15275e() {
        return ((Contract.AbsMapPresenter) getPresenter()).getReceiverLatLng();
    }

    /* renamed from: f */
    private final LatLng m15276f() {
        return ((Contract.AbsMapPresenter) getPresenter()).getRiderLatLng();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15270a(OrderMapView orderMapView, CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(orderMapView, "this$0");
        orderMapView.m15279i();
        orderMapView.m15281k();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        SodaAnimEngine sodaAnimEngine = new SodaAnimEngine(getContext());
        this.f20850g = sodaAnimEngine;
        SodaMapView sodaMapView = null;
        if (sodaAnimEngine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine = null;
        }
        sodaAnimEngine.setTranslateIntervalTime((long) ((Contract.AbsMapPresenter) getPresenter()).getAnimIntervalTime());
        SodaMapView sodaMapView2 = this.f20847d;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
        } else {
            sodaMapView = sodaMapView2;
        }
        sodaMapView.getSodaMapAsync(new OnMapReadyCallBack() {
            public final void onMapReady(Map map) {
                OrderMapView.m15269a(OrderMapView.this, map);
            }
        });
        this.f20855l = CustomerApolloUtil.isMapBubbleHiddenEnable();
        LogUtil.m14765i(f20843p, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15269a(OrderMapView orderMapView, Map map) {
        Intrinsics.checkNotNullParameter(orderMapView, "this$0");
        SodaMapView sodaMapView = orderMapView.f20847d;
        SodaMapView sodaMapView2 = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        sodaMapView.removeAllElement();
        SodaMapView sodaMapView3 = orderMapView.f20847d;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView3 = null;
        }
        sodaMapView3.setLogoVisibility(false);
        SodaMapView sodaMapView4 = orderMapView.f20847d;
        if (sodaMapView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView4 = null;
        }
        MapViewImpl mapImpl = sodaMapView4.getMapImpl();
        if (mapImpl != null) {
            SenderMarker a = orderMapView.m15268a();
            if (a != null) {
                SodaMapView sodaMapView5 = orderMapView.f20847d;
                if (sodaMapView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                    sodaMapView5 = null;
                }
                a.updateMapView(sodaMapView5.getMapImpl());
            }
            ReceiverMarker b = orderMapView.m15272b();
            if (b != null) {
                SodaMapView sodaMapView6 = orderMapView.f20847d;
                if (sodaMapView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                    sodaMapView6 = null;
                }
                b.updateMapView(sodaMapView6.getMapImpl());
            }
            RiderMarker c = orderMapView.m15273c();
            if (c != null) {
                SodaMapView sodaMapView7 = orderMapView.f20847d;
                if (sodaMapView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                } else {
                    sodaMapView2 = sodaMapView7;
                }
                c.updateMapView(sodaMapView2.getMapImpl());
            }
            DefaultMapGestureListener defaultMapGestureListener = new DefaultMapGestureListener(orderMapView);
            orderMapView.f20857n = defaultMapGestureListener;
            mapImpl.addOnMapGestureListener(defaultMapGestureListener);
            mapImpl.addOnCameraChangeListener(orderMapView.f20858o);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SodaMapView sodaMapView = this.f20847d;
        SodaAnimEngine sodaAnimEngine = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onResume();
        LogUtil.m14765i(f20843p, "onStart");
        SpreadView spreadView = this.f20849f;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.onResume();
        SodaAnimEngine sodaAnimEngine2 = this.f20850g;
        if (sodaAnimEngine2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
        } else {
            sodaAnimEngine = sodaAnimEngine2;
        }
        sodaAnimEngine.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        LogUtil.m14765i(f20843p, "onStop");
        SpreadView spreadView = this.f20849f;
        SodaMapView sodaMapView = null;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.onPause();
        SodaAnimEngine sodaAnimEngine = this.f20850g;
        if (sodaAnimEngine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine = null;
        }
        sodaAnimEngine.onPause();
        SodaMapView sodaMapView2 = this.f20847d;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
        } else {
            sodaMapView = sodaMapView2;
        }
        sodaMapView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        hideInfoWindow(false);
        m15282l();
        SodaMapView sodaMapView = this.f20847d;
        SodaAnimEngine sodaAnimEngine = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        MapViewImpl mapImpl = sodaMapView.getMapImpl();
        if (mapImpl != null) {
            mapImpl.removeOnCameraChangeListener(this.f20858o);
            mapImpl.removeOnMapGestureListener(this.f20857n);
        }
        SodaMapView sodaMapView2 = this.f20847d;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView2 = null;
        }
        sodaMapView2.setLogoVisibility(true);
        SodaMapView sodaMapView3 = this.f20847d;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView3 = null;
        }
        sodaMapView3.onDestroy();
        SpreadView spreadView = this.f20849f;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.onDestroy();
        SodaAnimEngine sodaAnimEngine2 = this.f20850g;
        if (sodaAnimEngine2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
        } else {
            sodaAnimEngine = sodaAnimEngine2;
        }
        sodaAnimEngine.onDestroy();
        LogUtil.m14765i(f20843p, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_page_order_map, viewGroup);
        if (inflate != null) {
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            this.f20851h = viewGroup2;
            ViewGroup viewGroup3 = null;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup2 = null;
            }
            View findViewById = viewGroup2.findViewById(R.id.customer_custom_map_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mContainer.findViewById(…customer_custom_map_view)");
            this.f20847d = (SodaMapView) findViewById;
            ViewGroup viewGroup4 = this.f20851h;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup4 = null;
            }
            View findViewById2 = viewGroup4.findViewById(R.id.customer_custom_spreed_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mContainer.findViewById(…tomer_custom_spreed_view)");
            this.f20849f = (SpreadView) findViewById2;
            ViewGroup viewGroup5 = this.f20851h;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup5 = null;
            }
            View findViewById3 = viewGroup5.findViewById(R.id.customer_custom_info_view);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mContainer.findViewById(…ustomer_custom_info_view)");
            this.f20848e = (MarkerInfoWindowView) findViewById3;
            ViewGroup viewGroup6 = this.f20851h;
            if (viewGroup6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            } else {
                viewGroup3 = viewGroup6;
            }
            return viewGroup3;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* access modifiers changed from: protected */
    public void centerBestView(BestViewModel bestViewModel, BestViewer.IBestViewListener iBestViewListener) {
        SodaMapView sodaMapView = this.f20847d;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        sodaMapView.centerBestView(bestViewModel, iBestViewListener);
    }

    /* access modifiers changed from: protected */
    public void doSlidingRiderAnim(SodaAnimLatLng sodaAnimLatLng) {
        LogUtil.m14765i(f20843p, "doSlidingRiderAnim");
        SodaAnimEngine sodaAnimEngine = this.f20850g;
        SodaAnimEngine sodaAnimEngine2 = null;
        if (sodaAnimEngine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine = null;
        }
        sodaAnimEngine.setAnimState(1);
        SodaAnimEngine sodaAnimEngine3 = this.f20850g;
        if (sodaAnimEngine3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine3 = null;
        }
        ReceiverMarker b = m15272b();
        sodaAnimEngine3.setCustomerMarker(b == null ? null : b.getMarker());
        SodaAnimEngine sodaAnimEngine4 = this.f20850g;
        if (sodaAnimEngine4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine4 = null;
        }
        SenderMarker a = m15268a();
        sodaAnimEngine4.setBusinessMarker(a == null ? null : a.getMarker());
        SodaAnimEngine sodaAnimEngine5 = this.f20850g;
        if (sodaAnimEngine5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine5 = null;
        }
        RiderMarker c = m15273c();
        sodaAnimEngine5.setDeliveryMarker(c == null ? null : c.getMarker());
        SodaAnimEngine sodaAnimEngine6 = this.f20850g;
        if (sodaAnimEngine6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
        } else {
            sodaAnimEngine2 = sodaAnimEngine6;
        }
        sodaAnimEngine2.onLocationChanged(sodaAnimLatLng);
    }

    /* access modifiers changed from: protected */
    public void showSpreadView(LatLng latLng, SpreadView.SpreadViewType spreadViewType) {
        Intrinsics.checkNotNullParameter(spreadViewType, "type");
        this.f20852i = latLng;
        SpreadView spreadView = this.f20849f;
        SpreadView spreadView2 = null;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.setVisibility(0);
        SpreadView spreadView3 = this.f20849f;
        if (spreadView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView3 = null;
        }
        if (spreadView3.getSpreadType() == null) {
            SpreadView spreadView4 = this.f20849f;
            if (spreadView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                spreadView4 = null;
            }
            spreadView4.setSpreadType(spreadViewType);
        } else {
            SpreadView spreadView5 = this.f20849f;
            if (spreadView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                spreadView5 = null;
            }
            if (spreadView5.getSpreadType() != spreadViewType) {
                SpreadView spreadView6 = this.f20849f;
                if (spreadView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                    spreadView6 = null;
                }
                spreadView6.setSpreadType(spreadViewType);
            }
        }
        m15279i();
        SpreadView spreadView7 = this.f20849f;
        if (spreadView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
        } else {
            spreadView2 = spreadView7;
        }
        spreadView2.start();
    }

    /* access modifiers changed from: protected */
    public void hideSpreadView() {
        SpreadView spreadView = null;
        this.f20852i = null;
        SpreadView spreadView2 = this.f20849f;
        if (spreadView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView2 = null;
        }
        if (spreadView2.isShown()) {
            SpreadView spreadView3 = this.f20849f;
            if (spreadView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                spreadView3 = null;
            }
            spreadView3.setVisibility(8);
            SpreadView spreadView4 = this.f20849f;
            if (spreadView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            } else {
                spreadView = spreadView4;
            }
            spreadView.stop();
        }
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderArrivedSender() {
        SenderMarker a = m15268a();
        if (a != null) {
            a.show(m15274d());
        }
        m15278h();
    }

    /* access modifiers changed from: protected */
    public void showInfoWindow(boolean z, Tip tip, LatLng latLng, boolean z2, int i, boolean z3) {
        if (tip != null) {
            m15280j();
            if (!TextUtils.isEmpty(tip.getStatusDesc())) {
                m15271a(z, tip, latLng, true, i);
            }
            if (!z3 || tip.getCountDown() < 0) {
                hideSpreadView();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long countDown = tip.getCountDown() * ((long) 1000);
            long max = Math.max(0, countDown - currentTimeMillis);
            LogUtil.m14765i(f20843p, countDown + '-' + System.currentTimeMillis() + "= MapTipInfo countdownTime：" + max);
            CountDownTimer orderMapView$showInfoWindow$1$1 = new OrderMapView$showInfoWindow$1$1(z2, this, max);
            this.f20853j = orderMapView$showInfoWindow$1$1;
            if (orderMapView$showInfoWindow$1$1 != null) {
                orderMapView$showInfoWindow$1$1.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void hideInfoWindow(boolean z) {
        MarkerInfoWindowView markerInfoWindowView = null;
        this.f20854k = null;
        LogUtil.m14765i(f20843p, "hideInfoWindow ：");
        if (z) {
            MarkerInfoWindowView markerInfoWindowView2 = this.f20848e;
            if (markerInfoWindowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView = markerInfoWindowView2;
            }
            markerInfoWindowView.hideViewWithAnim();
        } else {
            MarkerInfoWindowView markerInfoWindowView3 = this.f20848e;
            if (markerInfoWindowView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView = markerInfoWindowView3;
            }
            markerInfoWindowView.hideViewImmediately();
        }
        RiderMarker c = m15273c();
        if (c != null) {
            c.hideInfoWindow();
        }
        m15280j();
    }

    /* renamed from: g */
    private final void m15277g() {
        MarkerInfoWindowView markerInfoWindowView = null;
        this.f20854k = null;
        LogUtil.m14765i(f20843p, "hideInfoWindow ：");
        MarkerInfoWindowView markerInfoWindowView2 = this.f20848e;
        if (markerInfoWindowView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            markerInfoWindowView2 = null;
        }
        if (markerInfoWindowView2.isShown()) {
            MarkerInfoWindowView markerInfoWindowView3 = this.f20848e;
            if (markerInfoWindowView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView = markerInfoWindowView3;
            }
            markerInfoWindowView.hideViewImmediately();
        }
    }

    /* access modifiers changed from: protected */
    public void clearAllMapElement() {
        ReceiverMarker b = m15272b();
        if (b != null) {
            b.remove();
        }
        SenderMarker a = m15268a();
        if (a != null) {
            a.remove();
        }
        RiderMarker c = m15273c();
        if (c != null) {
            c.remove();
        }
    }

    /* access modifiers changed from: protected */
    public void clearMapExceptRider() {
        ReceiverMarker b = m15272b();
        if (b != null) {
            b.remove();
        }
        SenderMarker a = m15268a();
        if (a != null) {
            a.remove();
        }
    }

    /* renamed from: h */
    private final void m15278h() {
        RiderMarker c = m15273c();
        if (c != null) {
            if (!c.isExist()) {
                c.show(m15276f());
            } else {
                c.setVisible(true);
                LatLng f = m15276f();
                if (f != null) {
                    c.getMarker().setPosition(f);
                }
            }
            c.updateIcon();
        }
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderComing() {
        LogUtil.m14765i(f20843p, "showMapWithRiderComing");
        SenderMarker a = m15268a();
        if (a != null) {
            a.show(m15274d(), m15276f());
        }
        m15278h();
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderToDelivering(boolean z) {
        m15278h();
        ReceiverMarker b = m15272b();
        if (b != null) {
            b.show(m15275e(), m15276f());
        }
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderArriveReceiver() {
        ReceiverMarker b = m15272b();
        if (b != null) {
            b.show(m15275e());
        }
        m15278h();
    }

    /* renamed from: i */
    private final void m15279i() {
        if (this.f20852i != null) {
            SodaMapView sodaMapView = this.f20847d;
            SpreadView spreadView = null;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            PointF screenLocation = sodaMapView.getScreenLocation(this.f20852i);
            Intrinsics.checkNotNullExpressionValue(screenLocation, "mSodaMapView.getScreenLo…on(mSpreadCenterLocation)");
            SpreadView spreadView2 = this.f20849f;
            if (spreadView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            } else {
                spreadView = spreadView2;
            }
            spreadView.updateLocation(screenLocation.x, screenLocation.y);
        }
    }

    /* renamed from: j */
    private final void m15280j() {
        CountDownTimer countDownTimer = this.f20853j;
        if (countDownTimer != null) {
            Intrinsics.checkNotNull(countDownTimer);
            countDownTimer.cancel();
            this.f20853j = null;
        }
    }

    /* renamed from: a */
    private final void m15271a(boolean z, Tip tip, LatLng latLng, boolean z2, int i) {
        String statusDesc = tip.getStatusDesc();
        String subStatusDesc = tip.getSubStatusDesc();
        LogUtil.m14763e("gl--test", Intrinsics.stringPlus(" getSpan", subStatusDesc));
        MarkerInfoWindowView markerInfoWindowView = null;
        if (z) {
            m15277g();
            RiderMarker c = m15273c();
            if (c != null) {
                c.updateInfoWindow(new InfoWindowViewBuildConfig.Builder().setTitle(statusDesc).setCategory(3).setSubDesc(subStatusDesc).setOrderStatus(i).build(), (OnInfoWindowClickListener) null);
                return;
            }
            return;
        }
        this.f20854k = latLng;
        LogUtil.m14765i(f20843p, "showInfoWindowView location：" + this.f20854k + " hasAnim=" + z2);
        if (this.f20854k != null) {
            MarkerInfoWindowView markerInfoWindowView2 = this.f20848e;
            if (markerInfoWindowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                markerInfoWindowView2 = null;
            }
            markerInfoWindowView2.setMarkInfoWindowRes(i);
            if (z2) {
                MarkerInfoWindowView markerInfoWindowView3 = this.f20848e;
                if (markerInfoWindowView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                } else {
                    markerInfoWindowView = markerInfoWindowView3;
                }
                markerInfoWindowView.showView(statusDesc, subStatusDesc, false);
            } else {
                MarkerInfoWindowView markerInfoWindowView4 = this.f20848e;
                if (markerInfoWindowView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                } else {
                    markerInfoWindowView = markerInfoWindowView4;
                }
                markerInfoWindowView.updateView(statusDesc, subStatusDesc, false);
            }
            m15281k();
        }
    }

    /* renamed from: k */
    private final void m15281k() {
        MarkerInfoWindowView markerInfoWindowView = this.f20848e;
        MarkerInfoWindowView markerInfoWindowView2 = null;
        if (markerInfoWindowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            markerInfoWindowView = null;
        }
        if (markerInfoWindowView.isShown() && this.f20854k != null) {
            SodaMapView sodaMapView = this.f20847d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            PointF screenLocation = sodaMapView.getScreenLocation(this.f20854k);
            Intrinsics.checkNotNullExpressionValue(screenLocation, "mSodaMapView.getScreenLo…InfoWindowCenterLocation)");
            StringBuilder sb = new StringBuilder();
            sb.append("showInfoWindowView updateInfoWindowLocation：");
            sb.append(screenLocation);
            sb.append("shown=");
            MarkerInfoWindowView markerInfoWindowView3 = this.f20848e;
            if (markerInfoWindowView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                markerInfoWindowView3 = null;
            }
            sb.append(markerInfoWindowView3.isShown());
            LogUtil.m14765i(f20843p, sb.toString());
            MarkerInfoWindowView markerInfoWindowView4 = this.f20848e;
            if (markerInfoWindowView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView2 = markerInfoWindowView4;
            }
            markerInfoWindowView2.updateLocation((int) screenLocation.x, (int) screenLocation.y, this.f20855l);
        }
    }

    /* renamed from: l */
    private final void m15282l() {
        LogUtil.m14765i(f20843p, "destroyMarker===start");
        if (m15268a() != null) {
            SenderMarker a = m15268a();
            if (a != null) {
                a.onDestroy();
            }
            this.f20844a = null;
        }
        if (m15272b() != null) {
            ReceiverMarker b = m15272b();
            if (b != null) {
                b.onDestroy();
            }
            this.f20845b = null;
        }
        if (m15273c() != null) {
            RiderMarker c = m15273c();
            if (c != null) {
                c.onDestroy();
            }
            this.f20846c = null;
        }
        LogUtil.m14765i(f20843p, "destroyMarker===end");
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/entrega/order/component/OrderMapView$DefaultMapGestureListener;", "Lcom/didi/entrega/customer/map/listener/MapGestureListener;", "(Lcom/didi/entrega/order/component/OrderMapView;)V", "mDownX", "", "getMDownX", "()F", "setMDownX", "(F)V", "mDownY", "getMDownY", "setMDownY", "onDown", "", "x", "y", "onScroll", "onUp", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderMapView.kt */
    private final class DefaultMapGestureListener extends MapGestureListener {
        private float mDownX;
        private float mDownY;
        final /* synthetic */ OrderMapView this$0;

        public DefaultMapGestureListener(OrderMapView orderMapView) {
            Intrinsics.checkNotNullParameter(orderMapView, "this$0");
            this.this$0 = orderMapView;
        }

        public final float getMDownX() {
            return this.mDownX;
        }

        public final void setMDownX(float f) {
            this.mDownX = f;
        }

        public final float getMDownY() {
            return this.mDownY;
        }

        public final void setMDownY(float f) {
            this.mDownY = f;
        }

        public boolean onScroll(float f, float f2) {
            ((Contract.AbsMapPresenter) this.this$0.getPresenter()).setDraggedMap(true);
            return super.onScroll(f, f2);
        }

        public boolean onDown(float f, float f2) {
            this.mDownX = f;
            this.mDownY = f2;
            return super.onDown(f, f2);
        }

        public boolean onUp(float f, float f2) {
            if (Math.abs(f - this.mDownX) > 0.0f || Math.abs(f2 - this.mDownY) > 0.0f) {
                ((Contract.AbsMapPresenter) this.this$0.getPresenter()).setDraggedMap(true);
            }
            return super.onUp(f, f2);
        }
    }
}
