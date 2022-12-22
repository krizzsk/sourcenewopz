package com.didi.soda.business.component.address;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.didi.soda.business.component.address.Contract;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.map.marker.BusinessMarker;
import com.didi.soda.customer.map.marker.DestAddressMarker;
import com.didi.soda.customer.map.model.BestViewModel;
import com.didi.soda.customer.widget.map.SodaMapView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\u0006\u0010!\u001a\u00020\u001cJ\u001c\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u001c\u0010&\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/didi/soda/business/component/address/BusinessAddressMapView;", "Lcom/didi/soda/business/component/address/Contract$AbsBusinessAddressMapView;", "()V", "addressMarker", "Lcom/didi/soda/customer/map/marker/DestAddressMarker;", "backBtn", "Lcom/didi/soda/customer/widget/text/IconTextView;", "businessAddressTv", "Landroid/widget/TextView;", "businessLatLng", "Lcom/didi/common/map/model/LatLng;", "businessMarker", "Lcom/didi/soda/customer/map/marker/BusinessMarker;", "businessNameTv", "contentContainer", "Landroid/view/View;", "customerLatLng", "onGlobalLayoutListener", "com/didi/soda/business/component/address/BusinessAddressMapView$onGlobalLayoutListener$1", "Lcom/didi/soda/business/component/address/BusinessAddressMapView$onGlobalLayoutListener$1;", "sodaMapView", "Lcom/didi/soda/customer/widget/map/SodaMapView;", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initView", "", "onCreate", "onDestroy", "onPause", "onResume", "refreshMapPadding", "showBusinessInfoText", "name", "", "address", "showLocationMarkView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessAddressMapView.kt */
public final class BusinessAddressMapView extends Contract.AbsBusinessAddressMapView {

    /* renamed from: a */
    private SodaMapView f39363a;

    /* renamed from: b */
    private TextView f39364b;

    /* renamed from: c */
    private TextView f39365c;

    /* renamed from: d */
    private View f39366d;

    /* renamed from: e */
    private IconTextView f39367e;

    /* renamed from: f */
    private DestAddressMarker f39368f;

    /* renamed from: g */
    private BusinessMarker f39369g;

    /* renamed from: h */
    private LatLng f39370h;

    /* renamed from: i */
    private LatLng f39371i;

    /* renamed from: j */
    private final BusinessAddressMapView$onGlobalLayoutListener$1 f39372j = new BusinessAddressMapView$onGlobalLayoutListener$1(this);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27862a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_business_address, viewGroup);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…iness_address, container)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        initView();
        SodaMapView sodaMapView = this.f39363a;
        IconTextView iconTextView = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.removeAllElement();
        View view = this.f39366d;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        view.setOnTouchListener($$Lambda$BusinessAddressMapView$Y4DCVWuMN_9b7NVb0Ozc_xBIjI.INSTANCE);
        IconTextView iconTextView2 = this.f39367e;
        if (iconTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        } else {
            iconTextView = iconTextView2;
        }
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessAddressMapView.m27861a(BusinessAddressMapView.this, view);
            }
        });
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f39372j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27861a(BusinessAddressMapView businessAddressMapView, View view) {
        Intrinsics.checkNotNullParameter(businessAddressMapView, "this$0");
        ((Contract.AbsBusinessAddressMapPresenter) businessAddressMapView.getPresenter()).onPageClose();
    }

    public final void refreshMapPadding() {
        BestViewModel bestViewModel = new BestViewModel();
        SodaMapView sodaMapView = this.f39363a;
        SodaMapView sodaMapView2 = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        Padding padding = sodaMapView.getMapImpl().getDidiCommonMap().getPadding();
        View view = this.f39366d;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        bestViewModel.mPadding = new Padding(padding.left, padding.top, padding.right, view.getHeight() + ResourceHelper.getDimensionPixelSize(R.dimen.customer_75px));
        bestViewModel.zoomCenter = this.f39371i;
        bestViewModel.mIncludes.add(this.f39371i);
        bestViewModel.mIncludes.add(this.f39370h);
        SodaMapView sodaMapView3 = this.f39363a;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
        } else {
            sodaMapView2 = sodaMapView3;
        }
        sodaMapView2.centerBestZoomView(bestViewModel);
    }

    public final void initView() {
        View findViewById = getView().findViewById(R.id.customer_custom_map_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.customer_custom_map_view)");
        this.f39363a = (SodaMapView) findViewById;
        View findViewById2 = getView().findViewById(R.id.customer_tv_business_address);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.c…omer_tv_business_address)");
        this.f39364b = (TextView) findViewById2;
        View findViewById3 = getView().findViewById(R.id.customer_tv_business_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.customer_tv_business_name)");
        this.f39365c = (TextView) findViewById3;
        View findViewById4 = getView().findViewById(R.id.customer_ll_address_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.c…mer_ll_address_container)");
        this.f39366d = findViewById4;
        View findViewById5 = getView().findViewById(R.id.customer_custom_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.customer_custom_page_back)");
        this.f39367e = (IconTextView) findViewById5;
    }

    public void showLocationMarkView(LatLng latLng, LatLng latLng2) {
        BestViewModel bestViewModel = new BestViewModel();
        int dip2px = DisplayUtils.dip2px(getContext(), 40.0f);
        bestViewModel.mPadding = new Padding(dip2px, dip2px, dip2px, dip2px);
        bestViewModel.mPadding.top += DisplayUtils.dip2px(getContext(), 50.0f);
        bestViewModel.mPadding.bottom += DisplayUtils.dip2px(getContext(), 50.0f);
        bestViewModel.mPadding.bottom += CustomerSystemUtil.getImmersiveStatusBarHeight(getContext());
        this.f39370h = latLng;
        this.f39371i = latLng2;
        bestViewModel.zoomCenter = latLng2;
        bestViewModel.mIncludes.add(latLng2);
        bestViewModel.mIncludes.add(latLng);
        SodaMapView sodaMapView = this.f39363a;
        BusinessMarker businessMarker = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.centerBestZoomView(bestViewModel);
        SodaMapView sodaMapView2 = this.f39363a;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView2 = null;
        }
        MapViewImpl mapImpl = sodaMapView2.getMapImpl();
        Intrinsics.checkNotNullExpressionValue(mapImpl, "sodaMapView.getMapImpl()");
        IMapView iMapView = mapImpl;
        DestAddressMarker destAddressMarker = new DestAddressMarker(getContext(), iMapView);
        this.f39368f = destAddressMarker;
        if (destAddressMarker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addressMarker");
            destAddressMarker = null;
        }
        destAddressMarker.show(latLng);
        BusinessMarker businessMarker2 = new BusinessMarker(getContext(), iMapView);
        this.f39369g = businessMarker2;
        if (businessMarker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessMarker");
        } else {
            businessMarker = businessMarker2;
        }
        businessMarker.show(latLng2);
    }

    public void showBusinessInfoText(String str, String str2) {
        CharSequence charSequence = str2;
        boolean z = false;
        TextView textView = null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            TextView textView2 = this.f39364b;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessAddressTv");
                textView2 = null;
            }
            textView2.setText(charSequence);
        }
        CharSequence charSequence2 = str;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (!z) {
            TextView textView3 = this.f39365c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessNameTv");
            } else {
                textView = textView3;
            }
            textView.setText(charSequence2);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SodaMapView sodaMapView = this.f39363a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SodaMapView sodaMapView = this.f39363a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f39372j);
        SodaMapView sodaMapView = this.f39363a;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onDestroy();
    }
}
