package com.didi.addressnew.framework.fragmentmarket.endconfirm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.address.SugBuild;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.endconfirm.EndConfirmFragment;
import com.didi.addressnew.framework.fragmentmarket.map.SugMapBaseFragment;
import com.didi.addressnew.framework.mapholder.SugSharedMapView;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.model.ISelectAddressModel;
import com.didi.addressnew.model.SelectAddressModel;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.dropoff.DropOffCompParam;
import com.didi.map.global.component.dropoff.DropOffComponent;
import com.didi.map.global.component.dropoff.IDropOffCompContract;
import com.didi.map.global.component.dropoff.IDropOffComponentCallback;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.pin.PinStyle;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;
import java.util.HashMap;

public class EndConfirmFragment extends SugMapBaseFragment {

    /* renamed from: a */
    private View f4382a;

    /* renamed from: b */
    private View f4383b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f4384c;

    /* renamed from: d */
    private View f4385d;

    /* renamed from: e */
    private ImageView f4386e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FrameLayout f4387f;

    /* renamed from: g */
    private FrameLayout f4388g;

    /* renamed from: h */
    private RpcPoi f4389h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IDropOffCompContract f4390i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public DropOffAddress f4391j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f4392k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Map f4393l;

    /* renamed from: m */
    private ISelectAddressModel f4394m;

    /* renamed from: n */
    private ViewTreeObserver.OnGlobalLayoutListener f4395n = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (EndConfirmFragment.this.f4384c != null && EndConfirmFragment.this.f4387f != null) {
                ViewGroup.LayoutParams layoutParams = EndConfirmFragment.this.f4384c.getLayoutParams();
                if (layoutParams.height != EndConfirmFragment.this.f4387f.getHeight()) {
                    layoutParams.height = EndConfirmFragment.this.f4387f.getHeight();
                    EndConfirmFragment.this.f4384c.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* renamed from: o */
    private IDropOffComponentCallback f4396o = new IDropOffComponentCallback() {
        public void onStartDragging() {
        }

        public void onDropOffAddressChanged(boolean z, DropOffAddress dropOffAddress, View view) {
            DropOffAddress unused = EndConfirmFragment.this.f4391j = dropOffAddress;
            EndConfirmFragment.this.f4387f.removeAllViews();
            EndConfirmFragment.this.f4387f.addView(view);
            EndConfirmFragment.this.f4387f.postDelayed(new Runnable(view) {
                public final /* synthetic */ View f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    EndConfirmFragment.C22792.this.lambda$onDropOffAddressChanged$0$EndConfirmFragment$2(this.f$1);
                }
            }, 100);
        }

        public /* synthetic */ void lambda$onDropOffAddressChanged$0$EndConfirmFragment$2(View view) {
            if (EndConfirmFragment.this.f4390i != null) {
                EndConfirmFragment.this.f4390i.adjustMapCamera(new Padding(0, 0, 0, view.getHeight() + DisplayUtils.dp2px(EndConfirmFragment.this.getActivity(), 10.0f)));
            }
        }

        public void onDropoffLoading(View view) {
            EndConfirmFragment.this.f4387f.removeAllViews();
            EndConfirmFragment.this.f4387f.addView(view);
        }

        public void onCardViewOperation(int i) {
            if (i == 0 && !ViewFastDoubleClickInterceptor.isFastClick()) {
                EndConfirmFragment.this.m2734g();
            }
        }
    };

    public boolean getDragHandlerEnable() {
        return false;
    }

    public View getFallbackView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.map_poi_select_fragment_layout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4394m = new SelectAddressModel(getContext());
    }

    /* access modifiers changed from: protected */
    public void onInit(View view) {
        this.f4382a = view;
        this.f4383b = view.findViewById(R.id.map_mask);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_reset_map);
        this.f4386e = imageView;
        imageView.setVisibility(8);
        View findViewById = view.findViewById(R.id.btnNavBack);
        this.f4385d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EndConfirmFragment.this.m2719a(view);
            }
        });
        this.f4388g = (FrameLayout) view.findViewById(R.id.mapContainer);
        if (getSugCallback() != null) {
            SugBuild sugBuild = getSugCallback().getSugBuild();
            StringBuilder sb = new StringBuilder();
            sb.append("onInit sugBuild = ");
            sb.append(sugBuild == null ? "null" : Integer.valueOf(sugBuild.getVersion()));
            logWriter(sb.toString());
        }
        this.f4392k = view.findViewById(R.id.mapViewOverLayer);
        this.f4387f = (FrameLayout) view.findViewById(R.id.cardViewContainer);
        this.f4384c = view.findViewById(R.id.card_mask_bg);
        this.f4382a.getViewTreeObserver().addOnGlobalLayoutListener(this.f4395n);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m2719a(View view) {
        m2735h();
        DropOffAddress dropOffAddress = this.f4391j;
        if (dropOffAddress != null) {
            m2725b(dropOffAddress.getAddress());
        }
    }

    /* access modifiers changed from: protected */
    public void onShowMapReset() {
        ImageView imageView = this.f4386e;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2718a() {
        m2736i();
        m2723b();
    }

    /* renamed from: b */
    private void m2723b() {
        DropOffComponent dropOffComponent = new DropOffComponent();
        this.f4390i = dropOffComponent;
        dropOffComponent.setConfigParam(m2726c());
        this.f4390i.create(getContext(), this.f4393l);
        this.f4390i.start();
    }

    /* renamed from: c */
    private DropOffCompParam m2726c() {
        if (this.f4393l == null) {
            return null;
        }
        return new DropOffCompParam.Builder(CallFrom.DROPOFF_PAGE, this.f4396o).locationInfo(m2733f()).pinStyle(m2729d()).zoom(18.0f).build();
    }

    /* renamed from: d */
    private PinStyle m2729d() {
        PinStyle pinStyle = new PinStyle();
        pinStyle.pinNormalColor = Color.parseColor("#ff8903");
        pinStyle.rectVisible = true;
        return pinStyle;
    }

    /* renamed from: e */
    private LatLng m2730e() {
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getActivity());
        if (lastKnownLocation != null) {
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        }
        return null;
    }

    /* renamed from: f */
    private DropOffLocationInfo m2733f() {
        Map map;
        LatLng e = m2730e();
        if (this.mCurrentAddress != null) {
            e = new LatLng(this.mCurrentAddress.getLatitude(), this.mCurrentAddress.getLongitude());
        }
        if (!(e != null || (map = this.f4393l) == null || map.getCameraPosition() == null)) {
            e = this.f4393l.getCameraPosition().target;
        }
        if (e == null) {
            return null;
        }
        DropOffLocationInfo dropOffLocationInfo = new DropOffLocationInfo();
        dropOffLocationInfo.latLng = e;
        dropOffLocationInfo.sugPoi = this.mCurrentAddress;
        if (this.mParentAddress != null) {
            dropOffLocationInfo.parentPoi = this.mParentAddress.address;
        }
        RpcPoi rpcPoi = this.f4389h;
        if (rpcPoi != null) {
            dropOffLocationInfo.extendInfo = rpcPoi.extend_info;
        }
        dropOffLocationInfo.coordinateType = this.mCurrentAddress.coordinate_type;
        return dropOffLocationInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m2734g() {
        ISelectAddressModel iSelectAddressModel;
        if (this.f4390i != null && this.f4391j != null) {
            getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Chose);
            m2721a(this.f4391j.getAddress());
            RpcPoi convertToRpcPoi = ModelConverter.convertToRpcPoi(this.mCurrentAddress);
            if (convertToRpcPoi != null && (iSelectAddressModel = this.f4394m) != null) {
                iSelectAddressModel.recordClickPoi(getmParam().addressParam, convertToRpcPoi.base_info);
            }
        }
    }

    /* renamed from: a */
    private void m2721a(Address address) {
        if (!this.mDestroyed) {
            if (this.mCurrAddressType == 5) {
                getmParam().addressParam.targetAddress = address;
                getmResult().setCommonAddress(AddressConvertUtil.addressToRpcCommonPoi(address, getmResult().getCommonAddress()));
                onConfirm(getmParam(), getmResult());
                switchEditFavorite(getmParam(), getmResult());
                return;
            }
            getmResult().setResult(this.mCurrAddressType, address);
            onConfirm(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        }
    }

    /* renamed from: h */
    private void m2735h() {
        if (!this.mDestroyed) {
            getmResult().setResultAllowNull(this.mCurrAddressType, (Address) null);
            updateAddressToSwitcher(getmParam(), getmResult());
            onCancel(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        }
    }

    public boolean onBackPressed() {
        logWriter("onBackPressed...");
        m2735h();
        return super.onBackPressed();
    }

    public void onPageEnter() {
        logWriter("onPageEnter...");
        super.onPageEnter();
        this.f4389h = (RpcPoi) getArguments().getSerializable("end_confirm_data");
        getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
        if (getView() != null) {
            getView().requestFocus();
        }
        SugSharedMapView.getInstance(getActivity()).setNeedLocation(false);
        SugSharedMapView.getInstance(getActivity()).onAdd(this.f4388g);
        SugSharedMapView.getInstance(getActivity()).onResume();
        View view = this.f4383b;
        if (view != null) {
            view.setVisibility(8);
        }
        final MapView mapView = SugSharedMapView.getInstance(getActivity()).getMapView();
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    Map unused = EndConfirmFragment.this.f4393l = map;
                    EndConfirmFragment.this.m2718a();
                    EndConfirmFragment endConfirmFragment = EndConfirmFragment.this;
                    endConfirmFragment.playAnimationMapLayer(endConfirmFragment.f4392k);
                    EndConfirmFragment.this.addOnMapGestureListener(map);
                    mapView.sendAccessibilityEvent(8);
                }
            });
        }
    }

    public void onPageExit() {
        logWriter("onPageExit...");
        removeOnMapGestureListener(this.f4393l);
        m2736i();
        SugSharedMapView.getInstance(getActivity()).setNeedLocation(true);
        View view = this.f4383b;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f4393l = null;
        super.onPageExit();
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.END_CONFIRM;
    }

    /* renamed from: i */
    private void m2736i() {
        IDropOffCompContract iDropOffCompContract = this.f4390i;
        if (iDropOffCompContract != null) {
            iDropOffCompContract.destroy();
            this.f4390i = null;
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        IDropOffCompContract iDropOffCompContract = this.f4390i;
        if (iDropOffCompContract != null) {
            iDropOffCompContract.onMapVisible(true);
        }
    }

    public void onPause() {
        super.onPause();
        IDropOffCompContract iDropOffCompContract = this.f4390i;
        if (iDropOffCompContract != null) {
            iDropOffCompContract.onMapVisible(false);
        }
    }

    public void onDestroyView() {
        removeOnMapGestureListener(this.f4393l);
        m2736i();
        View view = this.f4382a;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4395n);
        }
        SugSharedMapView.getInstance(getActivity()).onRemove(this.f4388g);
        super.onDestroyView();
    }

    /* renamed from: b */
    private void m2725b(Address address) {
        if (address != null && address.poiId != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, address.poiId);
            GlobalOmegaTracker.trackEvent("map_dropoff_ck", hashMap);
        }
    }
}
