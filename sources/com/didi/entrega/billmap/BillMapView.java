package com.didi.entrega.billmap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.entrega.billmap.Contract;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.map.marker.ReceiverMarker;
import com.didi.entrega.customer.map.marker.SenderMarker;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.entrega.customer.widget.map.SodaMapView;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0006\u0010\u0016\u001a\u00020\fJ\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014J\u0006\u0010\u001b\u001a\u00020\fJ\b\u0010\u001c\u001a\u00020\fH\u0002J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\"H\u0002J0\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didi/entrega/billmap/BillMapView;", "Lcom/didi/entrega/billmap/Contract$AbsBillMapView;", "()V", "mDefaultPadding", "", "mReceiverMarker", "Lcom/didi/entrega/customer/map/marker/ReceiverMarker;", "mSenderMarker", "Lcom/didi/entrega/customer/map/marker/SenderMarker;", "sodaMapView", "Lcom/didi/entrega/customer/widget/map/SodaMapView;", "cleanSendAndRecMarker", "", "destroyMarker", "getReceiverMark", "getSenderMark", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initView", "onCreate", "onDestroy", "onPause", "onResume", "removerMarker", "resetMapSetting", "setMapPadding", "startLatLng", "Lcom/didi/common/map/model/LatLng;", "endLatLng", "callback", "Lkotlin/Function0;", "showSendAndRecMarkInfo", "senderLatLng", "receiverLatLng", "sendTip", "", "receiveTip", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillMapView.kt */
public final class BillMapView extends Contract.AbsBillMapView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final String f19617e = "BillMapView";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static float f19618f = 230.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static int f19619g;

    /* renamed from: a */
    private SodaMapView f19620a;

    /* renamed from: b */
    private SenderMarker f19621b;

    /* renamed from: c */
    private ReceiverMarker f19622c;

    /* renamed from: d */
    private final int f19623d = DisplayUtils.dip2px(GlobalContext.getContext(), 20.0f);

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/billmap/BillMapView$Companion;", "", "()V", "TAG", "", "mMapMarginBottom", "", "getMMapMarginBottom", "()F", "setMMapMarginBottom", "(F)V", "mMapMarginTop", "", "getMMapMarginTop", "()I", "setMMapMarginTop", "(I)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillMapView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final float getMMapMarginBottom() {
            return BillMapView.f19618f;
        }

        public final void setMMapMarginBottom(float f) {
            BillMapView.f19618f = f;
        }

        public final int getMMapMarginTop() {
            return BillMapView.f19619g;
        }

        public final void setMMapMarginTop(int i) {
            BillMapView.f19619g = i;
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_component_bill_map, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…nent_bill_map, container)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        initView();
    }

    public final void initView() {
        View findViewById = getView().findViewById(R.id.customer_custom_map_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.customer_custom_map_view)");
        SodaMapView sodaMapView = (SodaMapView) findViewById;
        this.f19620a = sodaMapView;
        SodaMapView sodaMapView2 = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.setLogoVisibility(false);
        SodaMapView sodaMapView3 = this.f19620a;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
        } else {
            sodaMapView2 = sodaMapView3;
        }
        sodaMapView2.removeAllElement();
    }

    public void showSendAndRecMarkInfo(LatLng latLng, LatLng latLng2, String str, String str2) {
        if (latLng != null) {
            m14643a(latLng, latLng2, new BillMapView$showSendAndRecMarkInfo$1(this, latLng, latLng2, str, str2));
        } else if (latLng2 != null) {
            m14643a(latLng2, latLng, new BillMapView$showSendAndRecMarkInfo$2(this, latLng2, str2));
        }
    }

    public void cleanSendAndRecMarker() {
        ReceiverMarker receiverMarker = this.f19622c;
        if (receiverMarker != null) {
            receiverMarker.remove();
        }
        SenderMarker senderMarker = this.f19621b;
        if (senderMarker != null) {
            senderMarker.remove();
        }
    }

    /* renamed from: a */
    private final void m14643a(LatLng latLng, LatLng latLng2, Function0<Unit> function0) {
        BestViewModel bestViewModel = new BestViewModel();
        int i = this.f19623d;
        bestViewModel.mPadding = new Padding(i * 2, (i * 2) + CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()) + DisplayUtils.dip2px(getContext(), (float) f19619g), this.f19623d * 2, CustomerSystemUtil.getRealScreenHeight(getContext()) - DisplayUtils.dip2px(getContext(), f19618f));
        bestViewModel.mIncludes.add(latLng);
        if (latLng2 != null) {
            bestViewModel.mIncludes.add(latLng2);
        }
        SodaMapView sodaMapView = this.f19620a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.centerBestView(bestViewModel, new BestViewer.IBestViewListener(function0) {
            public final /* synthetic */ Function0 f$1;

            {
                this.f$1 = r2;
            }

            public final void onFinished() {
                BillMapView.m14644a(BillMapView.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14644a(BillMapView billMapView, Function0 function0) {
        LiveHandler liveHandler;
        Intrinsics.checkNotNullParameter(billMapView, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$callback");
        ScopeContext scopeContext = billMapView.getScopeContext();
        boolean z = true;
        if (scopeContext == null || (liveHandler = scopeContext.getLiveHandler()) == null || !liveHandler.isActive()) {
            z = false;
        }
        if (z) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ReceiverMarker m14642a() {
        SodaMapView sodaMapView = this.f19620a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        MapViewImpl mapImpl = sodaMapView.getMapImpl();
        Intrinsics.checkNotNullExpressionValue(mapImpl, "sodaMapView.mapImpl");
        if (this.f19622c == null) {
            this.f19622c = new ReceiverMarker(getContext(), mapImpl, 1);
        }
        ReceiverMarker receiverMarker = this.f19622c;
        if (receiverMarker != null) {
            return receiverMarker;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.customer.map.marker.ReceiverMarker");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final SenderMarker m14645b() {
        SodaMapView sodaMapView = this.f19620a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        MapViewImpl mapImpl = sodaMapView.getMapImpl();
        Intrinsics.checkNotNullExpressionValue(mapImpl, "sodaMapView.mapImpl");
        if (this.f19621b == null) {
            this.f19621b = new SenderMarker(getContext(), mapImpl, 1);
        }
        SenderMarker senderMarker = this.f19621b;
        if (senderMarker != null) {
            return senderMarker;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.customer.map.marker.SenderMarker");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SodaMapView sodaMapView = this.f19620a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SodaMapView sodaMapView = this.f19620a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onResume();
    }

    /* renamed from: c */
    private final void m14646c() {
        SodaMapView sodaMapView = this.f19620a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.setLogoVisibility(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m14646c();
        removerMarker();
    }

    public final void removerMarker() {
        m14647d();
        SodaMapView sodaMapView = this.f19620a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onDestroy();
    }

    /* renamed from: d */
    private final void m14647d() {
        LogUtil.m14765i(f19617e, "destroyMarker===start");
        if (this.f19621b != null) {
            LogUtil.m14765i(f19617e, "destroyMarker===mSenderMarker remove");
            SenderMarker senderMarker = this.f19621b;
            if (senderMarker != null) {
                senderMarker.onDestroy();
            }
            this.f19621b = null;
        }
        if (this.f19622c != null) {
            LogUtil.m14765i(f19617e, "destroyMarker===mReceiverMarker remove");
            ReceiverMarker receiverMarker = this.f19622c;
            if (receiverMarker != null) {
                receiverMarker.onDestroy();
            }
            this.f19622c = null;
        }
        LogUtil.m14765i(f19617e, "destroyMarker===end");
    }
}
