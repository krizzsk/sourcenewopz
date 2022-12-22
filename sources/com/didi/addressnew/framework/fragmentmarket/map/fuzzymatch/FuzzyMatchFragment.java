package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.map.SugMapBaseFragment;
import com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchCardCallback;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchCardController;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchCardView;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchListView;
import com.didi.addressnew.framework.mapholder.SugSharedMapView;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.ParentAddress;
import com.didi.addressnew.model.ISelectAddressModel;
import com.didi.addressnew.model.SelectAddressModel;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.PreferenceUtil;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.addressnew.view.shadow.ShadowLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
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
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FuzzyMatchFragment extends SugMapBaseFragment {

    /* renamed from: D */
    private static final int f7119D = 0;

    /* renamed from: E */
    private static final int f7120E = 1;

    /* renamed from: F */
    private static final int f7121F = 2;

    /* renamed from: G */
    private static final int f7122G = 3;

    /* renamed from: H */
    private static final int f7123H = 4;

    /* renamed from: I */
    private static final String f7124I = "key_new_hand_show";

    /* renamed from: A */
    private boolean f7125A = true;

    /* renamed from: B */
    private boolean f7126B = true;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f7127C = 0;

    /* renamed from: J */
    private Padding f7128J;

    /* renamed from: K */
    private final int f7129K = 30;

    /* renamed from: L */
    private int f7130L = 0;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f7131M = false;

    /* renamed from: N */
    private ViewGroup f7132N;

    /* renamed from: a */
    FuzzyMatchAddressComponent.AdapterMoveBackQuestionCallback f7133a = new FuzzyMatchAddressComponent.AdapterMoveBackQuestionCallback() {
        public boolean onMoveBack() {
            return FuzzyMatchFragment.this.f7131M;
        }
    };

    /* renamed from: b */
    private View f7134b;

    /* renamed from: c */
    private View f7135c;

    /* renamed from: d */
    private View f7136d;

    /* renamed from: e */
    private View f7137e;

    /* renamed from: f */
    private ImageView f7138f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FrameLayout f7139g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f7140h;

    /* renamed from: i */
    private FrameLayout f7141i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Map f7142j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f7143k;

    /* renamed from: l */
    private IDropOffCompContract f7144l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DropOffAddress f7145m;

    /* renamed from: n */
    private ISelectAddressModel f7146n;

    /* renamed from: o */
    private FuzzyMatchAddressComponent f7147o;

    /* renamed from: p */
    private FuzzyMatchCardController f7148p;

    /* renamed from: q */
    private FuzzyMatchListView f7149q;

    /* renamed from: r */
    private FuzzyMatchCardView f7150r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public RpcPoi f7151s;

    /* renamed from: t */
    private int f7152t;

    /* renamed from: u */
    private RpcRecSug.TrackParameterForChild f7153u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public List<RpcPoi> f7154v = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public List<RpcPoi> f7155w;

    /* renamed from: x */
    private boolean f7156x;

    /* renamed from: y */
    private int f7157y;

    /* renamed from: z */
    private int f7158z;

    public boolean getDragHandlerEnable() {
        return false;
    }

    public View getFallbackView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.map_same_address_fragment_layout;
    }

    /* access modifiers changed from: protected */
    public void onInit(View view) {
        this.f7134b = view;
        this.f7135c = view.findViewById(R.id.map_mask);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_reset_map);
        this.f7138f = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FuzzyMatchFragment.this.m4303b();
            }
        });
        View findViewById = view.findViewById(R.id.btnNavBack);
        this.f7137e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FuzzyMatchFragment.this.m4305b(view);
            }
        });
        this.f7141i = (FrameLayout) view.findViewById(R.id.mapContainer);
        this.f7140h = view.findViewById(R.id.mapViewOverLayer);
        this.f7139g = (FrameLayout) view.findViewById(R.id.cardViewContainer);
        this.f7136d = view.findViewById(R.id.card_mask_bg);
        this.f7134b.postDelayed(new Runnable() {
            public final void run() {
                FuzzyMatchFragment.this.m4338q();
            }
        }, 800);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m4305b(View view) {
        m4311d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4338q() {
        if (getActivity() != null && getContext() != null && this.f7134b != null) {
            int i = PreferenceUtil.getInstance(getContext()).getInt(f7124I);
            ViewStub viewStub = (ViewStub) this.f7134b.findViewById(R.id.view_new_hand);
            if (i < 1) {
                this.f7143k = viewStub.inflate();
                PreferenceUtil.getInstance(getContext()).put(f7124I, i + 1);
                this.f7143k.findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (FuzzyMatchFragment.this.f7143k != null) {
                            FuzzyMatchFragment.this.f7143k.setVisibility(8);
                        }
                    }
                });
                this.f7143k.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4303b() {
        if (this.f7142j != null) {
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f7147o;
            if (fuzzyMatchAddressComponent != null) {
                fuzzyMatchAddressComponent.doBestView(this.f7128J);
            }
            ImageView imageView = this.f7138f;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public boolean onBackPressed() {
        m4308c();
        if (this.f7127C == 0 || this.f7152t == 1) {
            return super.onBackPressed();
        }
        m4311d();
        return false;
    }

    /* renamed from: c */
    private void m4308c() {
        if (this.f7147o != null) {
            this.f7131M = true;
            if (this.f7134b != null && getContext() != null) {
                this.f7134b.postDelayed(new Runnable() {
                    public final void run() {
                        FuzzyMatchFragment.this.m4336p();
                    }
                }, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void m4336p() {
        if (this.f7147o != null) {
            this.f7131M = false;
        }
    }

    /* renamed from: d */
    private void m4311d() {
        DropOffAddress dropOffAddress;
        DropOffAddress dropOffAddress2;
        int i = this.f7127C;
        if (i == 0) {
            AddressTrack.trackFuzzyMatchBackOrConfirm((RpcPoi) null, this.f7153u, getmParam().addressParam.clone(), AddressTrack.SEARCH_CK_TYPE.MAP_BACK);
            m4321i();
            if (this.f7127C == 4 && (dropOffAddress = this.f7145m) != null) {
                m4297a(dropOffAddress.getAddress());
            }
        } else if (i == 1 || i == 2 || i == 3 || i == 4) {
            AddressTrack.trackFuzzyMatchBackOrConfirm(this.f7151s, this.f7153u, getmParam().addressParam.clone(), AddressTrack.SEARCH_CK_TYPE.POI_BACK);
            if (this.f7152t == 1) {
                m4321i();
                if (this.f7127C == 4 && (dropOffAddress2 = this.f7145m) != null) {
                    m4297a(dropOffAddress2.getAddress());
                    return;
                }
                return;
            }
            m4290a(0, false);
            m4289a(0);
        }
    }

    public void onPageEnter() {
        super.onPageEnter();
        getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
        if (getView() != null) {
            getView().requestFocus();
        }
        SugSharedMapView.getInstance(getActivity()).onAdd(this.f7141i);
        SugSharedMapView.getInstance(getActivity()).onResume();
        View view = this.f7135c;
        if (view != null) {
            view.setVisibility(8);
        }
        m4314e();
        final MapView mapView = SugSharedMapView.getInstance(getActivity()).getMapView();
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    Map unused = FuzzyMatchFragment.this.f7142j = map;
                    FuzzyMatchFragment.this.m4328l();
                    FuzzyMatchFragment fuzzyMatchFragment = FuzzyMatchFragment.this;
                    fuzzyMatchFragment.m4289a(fuzzyMatchFragment.f7127C);
                    FuzzyMatchFragment fuzzyMatchFragment2 = FuzzyMatchFragment.this;
                    fuzzyMatchFragment2.m4290a(fuzzyMatchFragment2.f7127C, false);
                    FuzzyMatchFragment fuzzyMatchFragment3 = FuzzyMatchFragment.this;
                    fuzzyMatchFragment3.playAnimationMapLayer(fuzzyMatchFragment3.f7140h);
                    FuzzyMatchFragment.this.addOnMapGestureListener(map);
                    mapView.sendAccessibilityEvent(8);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onShowMapReset() {
        ImageView imageView = this.f7138f;
        if (imageView == null) {
            return;
        }
        if (this.f7127C == 4) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }

    public void onPageExit() {
        removeOnMapGestureListener(this.f7142j);
        m4324j();
        m4326k();
        SugSharedMapView.getInstance(getActivity()).setNeedLocation(true);
        View view = this.f7135c;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f7142j = null;
        SugSharedMapView.getInstance(getActivity()).onRemove(this.f7141i);
        super.onPageExit();
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.MAPCONFIRM;
    }

    /* renamed from: e */
    private void m4314e() {
        this.f7154v.addAll((ArrayList) getArguments().getSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST));
        this.f7151s = (RpcPoi) getArguments().getSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS);
        this.f7153u = (RpcRecSug.TrackParameterForChild) getArguments().getSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM);
        this.f7157y = getArguments().getInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP);
        this.f7158z = getArguments().getInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE);
        this.f7156x = getArguments().getBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER);
        this.f7125A = true;
        this.f7126B = true;
        RpcPoi rpcPoi = this.f7151s;
        if (rpcPoi == null) {
            this.f7127C = 0;
            this.f7152t = 0;
            return;
        }
        this.f7152t = 1;
        if (rpcPoi == null || !CollectionUtil.isEmpty((Collection<?>) rpcPoi.sub_poi_list)) {
            this.f7127C = 2;
        } else {
            this.f7127C = 1;
        }
    }

    /* renamed from: a */
    private void m4297a(Address address) {
        if (address != null && address.poiId != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, address.poiId);
            GlobalOmegaTracker.trackEvent("map_dropoff_ck", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4289a(int i) {
        this.f7127C = i;
        if (i == 0) {
            m4324j();
            m4326k();
            m4298a(this.f7154v);
        } else if (i == 1) {
            SugSharedMapView.getInstance(getActivity()).setNeedLocation(true);
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f7147o;
            if (fuzzyMatchAddressComponent == null) {
                m4324j();
                m4298a(this.f7154v);
            } else {
                fuzzyMatchAddressComponent.onSelectValueChanged(this.f7151s, false);
            }
        } else if (i == 2) {
            SugSharedMapView.getInstance(getActivity()).setNeedLocation(false);
            m4324j();
            m4326k();
            m4298a(this.f7155w);
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent2 = this.f7147o;
            if (fuzzyMatchAddressComponent2 != null) {
                fuzzyMatchAddressComponent2.onSelectValueChanged(this.f7151s, true);
            }
        } else if (i == 4) {
            SugSharedMapView.getInstance(getActivity()).setNeedLocation(false);
            m4326k();
            m4324j();
            m4316f();
        }
        FuzzyMatchAddressComponent fuzzyMatchAddressComponent3 = this.f7147o;
        if (fuzzyMatchAddressComponent3 != null) {
            fuzzyMatchAddressComponent3.doBestView(this.f7128J);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4290a(int i, boolean z) {
        FuzzyMatchCardController fuzzyMatchCardController;
        FuzzyMatchCardController fuzzyMatchCardController2;
        FuzzyMatchCardController fuzzyMatchCardController3;
        FrameLayout frameLayout;
        this.f7127C = i;
        if (i == 0) {
            this.f7130L = 0;
            if (this.f7149q == null && (fuzzyMatchCardController = this.f7148p) != null) {
                this.f7149q = (FuzzyMatchListView) fuzzyMatchCardController.getView(1);
            }
            this.f7149q.updateListData(this.f7154v, this.f7153u, this.mCurrAddressType, this.f7156x, this.f7157y);
            FrameLayout frameLayout2 = this.f7139g;
            if (frameLayout2 != null) {
                frameLayout2.removeAllViews();
                this.f7139g.addView(this.f7149q);
                if (!z) {
                    m4330m();
                }
            }
        } else if (i == 1 || i == 2) {
            this.f7130L = 1;
            if (this.f7150r == null && (fuzzyMatchCardController2 = this.f7148p) != null) {
                this.f7150r = (FuzzyMatchCardView) fuzzyMatchCardController2.getView(0);
            }
            this.f7150r.updateView(this.f7151s, this.f7153u, this.mCurrAddressType);
            FrameLayout frameLayout3 = this.f7139g;
            if (frameLayout3 != null) {
                frameLayout3.removeAllViews();
                this.f7139g.addView(m4282a((View) this.f7150r), new FrameLayout.LayoutParams(-1, -2));
                if (!z) {
                    m4330m();
                }
            }
        } else if (i == 3) {
            if (this.f7150r == null && (fuzzyMatchCardController3 = this.f7148p) != null) {
                this.f7150r = (FuzzyMatchCardView) fuzzyMatchCardController3.getView(0);
            }
            FrameLayout frameLayout4 = this.f7139g;
            if (frameLayout4 != null) {
                frameLayout4.removeAllViews();
                this.f7139g.addView(m4282a((View) this.f7150r), new FrameLayout.LayoutParams(-1, -2));
                this.f7150r.onDataLoading(this.mCurrAddressType);
            }
        } else if (i == 4 && (frameLayout = this.f7139g) != null) {
            frameLayout.removeAllViews();
        }
    }

    /* renamed from: f */
    private void m4316f() {
        if (this.f7142j != null) {
            this.f7144l = new DropOffComponent();
            PinStyle pinStyle = new PinStyle();
            pinStyle.pinNormalColor = Color.parseColor("#ff8903");
            pinStyle.rectVisible = true;
            this.f7144l.setConfigParam(new DropOffCompParam.Builder(CallFrom.DROPOFF_PAGE, new IDropOffComponentCallback() {
                public void onStartDragging() {
                }

                public void onDropOffAddressChanged(boolean z, DropOffAddress dropOffAddress, View view) {
                    DropOffAddress unused = FuzzyMatchFragment.this.f7145m = dropOffAddress;
                    FuzzyMatchFragment.this.f7139g.removeAllViews();
                    FuzzyMatchFragment.this.f7139g.addView(FuzzyMatchFragment.this.m4282a(view), new FrameLayout.LayoutParams(-1, -2));
                    FuzzyMatchFragment.this.m4330m();
                }

                public void onDropoffLoading(View view) {
                    FuzzyMatchFragment.this.f7139g.removeAllViews();
                    FuzzyMatchFragment.this.f7139g.addView(FuzzyMatchFragment.this.m4282a(view), new FrameLayout.LayoutParams(-1, -2));
                }

                public void onCardViewOperation(int i) {
                    if (i == 0 && !ViewFastDoubleClickInterceptor.isFastClick()) {
                        FuzzyMatchFragment.this.m4319h();
                    }
                }
            }).locationInfo(m4318g()).pinStyle(pinStyle).zoom(18.0f).build());
            this.f7144l.create(getContext(), this.f7142j);
            this.f7144l.start();
        }
    }

    /* renamed from: g */
    private DropOffLocationInfo m4318g() {
        Map map;
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getActivity());
        DropOffLocationInfo dropOffLocationInfo = null;
        LatLng latLng = lastKnownLocation != null ? new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()) : null;
        Address convertToAddress = ModelConverter.convertToAddress(this.f7151s);
        convertToAddress.operationType = this.f7158z;
        if (this.f7151s != null) {
            latLng = new LatLng(convertToAddress.getLatitude(), convertToAddress.getLongitude());
        }
        if (!(latLng != null || (map = this.f7142j) == null || map.getCameraPosition() == null)) {
            latLng = this.f7142j.getCameraPosition().target;
        }
        if (latLng != null) {
            dropOffLocationInfo = new DropOffLocationInfo();
            dropOffLocationInfo.latLng = latLng;
            dropOffLocationInfo.sugPoi = convertToAddress;
            if (this.mParentAddress != null) {
                dropOffLocationInfo.parentPoi = this.mParentAddress.address;
            }
            RpcPoi rpcPoi = this.f7151s;
            if (rpcPoi != null) {
                dropOffLocationInfo.extendInfo = rpcPoi.extend_info;
            }
            dropOffLocationInfo.coordinateType = convertToAddress.coordinate_type;
        }
        return dropOffLocationInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m4319h() {
        if (this.f7144l != null && this.f7145m != null) {
            getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Chose);
            m4309c(this.f7145m.getAddress());
            RpcPoi rpcPoi = this.f7151s;
            if (rpcPoi != null) {
                if (this.f7146n == null) {
                    this.f7146n = new SelectAddressModel(getContext());
                }
                this.f7146n.recordClickPoi(getmParam().addressParam, rpcPoi.base_info);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4307b(Address address) {
        if (address != null) {
            getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.FuzzyMatch);
            m4309c(address);
        }
    }

    /* renamed from: c */
    private void m4309c(Address address) {
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

    /* renamed from: i */
    private void m4321i() {
        if (!this.mDestroyed) {
            getmResult().setResultAllowNull(this.mCurrAddressType, (Address) null);
            updateAddressToSwitcher(getmParam(), getmResult());
            onCancel(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        }
    }

    /* renamed from: j */
    private void m4324j() {
        IDropOffCompContract iDropOffCompContract = this.f7144l;
        if (iDropOffCompContract != null) {
            iDropOffCompContract.destroy();
            this.f7144l = null;
        }
    }

    /* renamed from: a */
    private void m4298a(final List<RpcPoi> list) {
        if (this.f7142j != null && getContext() != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            FuzzyMatchParam fuzzyMatchParam = new FuzzyMatchParam(list, this.mCurrAddressType, new FuzzyMatchOperationCallback() {
                public void onShowAllAddress(ArrayList<RpcPoi> arrayList) {
                }

                public void onSelectAddress(RpcPoi rpcPoi, boolean z, boolean z2) {
                    if (rpcPoi != null) {
                        RpcPoi unused = FuzzyMatchFragment.this.f7151s = rpcPoi;
                        FuzzyMatchFragment fuzzyMatchFragment = FuzzyMatchFragment.this;
                        fuzzyMatchFragment.m4299a(list, rpcPoi, z2, fuzzyMatchFragment.f7127C);
                        if (FuzzyMatchFragment.this.mCurrAddressType == 2 && ((rpcPoi.extend_info != null && rpcPoi.extend_info.enable_confirm_dropoff == 1) || rpcPoi.isDiscountPoi)) {
                            FuzzyMatchFragment.this.m4290a(4, z2);
                            FuzzyMatchFragment.this.m4289a(4);
                        } else if (z) {
                            FuzzyMatchFragment.this.m4290a(2, z2);
                        } else {
                            FuzzyMatchFragment.this.m4290a(1, z2);
                        }
                    }
                }

                public void onDateLoading() {
                    FuzzyMatchFragment.this.m4290a(3, false);
                }
            });
            if (this.f7127C != 0) {
                fuzzyMatchParam.setSelectAddress(this.f7151s);
            }
            fuzzyMatchParam.setGroup(this.f7127C == 2);
            if (CommonUtils.isFromHomePage(getmParam().fromType)) {
                fuzzyMatchParam.setPageFrom(0);
            } else if (CommonUtils.isFromConfirmPage(getmParam().fromType)) {
                fuzzyMatchParam.setPageFrom(1);
            }
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = new FuzzyMatchAddressComponent();
            this.f7147o = fuzzyMatchAddressComponent;
            fuzzyMatchAddressComponent.setParamConfig(fuzzyMatchParam);
            this.f7147o.create(getContext(), this.f7142j);
            this.f7147o.setAdapterMoveBackQuestionCallback(this.f7133a);
        }
    }

    /* renamed from: k */
    private void m4326k() {
        FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f7147o;
        if (fuzzyMatchAddressComponent != null) {
            fuzzyMatchAddressComponent.onDestroy();
            this.f7147o = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m4328l() {
        if (this.f7142j != null && getContext() != null) {
            if (this.f7148p == null) {
                this.f7148p = new FuzzyMatchCardController(getContext(), new FuzzyMatchCardCallback() {
                    public void onSelectAddress(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
                        RpcPoi unused = FuzzyMatchFragment.this.f7151s = rpcPoi;
                        AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, FuzzyMatchFragment.this.getmParam().addressParam.clone(), i, i2, AddressTrack.SEARCH_CK_TYPE.SEARCH_LIST_CK);
                        if (FuzzyMatchFragment.this.mCurrAddressType == 2 && ((rpcPoi.extend_info != null && rpcPoi.extend_info.enable_confirm_dropoff == 1) || rpcPoi.isDiscountPoi)) {
                            if (i2 != -1 && !CollectionUtil.isEmpty((Collection<?>) FuzzyMatchFragment.this.f7154v) && FuzzyMatchFragment.this.f7154v.size() > i) {
                                ParentAddress unused2 = FuzzyMatchFragment.this.mParentAddress = new ParentAddress();
                                FuzzyMatchFragment.this.mParentAddress.addressType = 2;
                                FuzzyMatchFragment.this.mParentAddress.address = ModelConverter.convertToAddress((RpcPoi) FuzzyMatchFragment.this.f7154v.get(i));
                                FuzzyMatchFragment.this.getmResult().setParent(FuzzyMatchFragment.this.mParentAddress);
                            }
                            int unused3 = FuzzyMatchFragment.this.f7127C = 4;
                        } else if (!CollectionUtil.isEmpty((Collection<?>) FuzzyMatchFragment.this.f7151s.sub_poi_list) || i2 != -1) {
                            if (FuzzyMatchFragment.this.f7155w == null) {
                                List unused4 = FuzzyMatchFragment.this.f7155w = new ArrayList();
                            }
                            FuzzyMatchFragment.this.f7155w.clear();
                            if (i2 == -1) {
                                FuzzyMatchFragment.this.f7155w.add(FuzzyMatchFragment.this.f7151s);
                                FuzzyMatchFragment.this.f7155w.addAll(FuzzyMatchFragment.this.f7151s.sub_poi_list);
                            } else if (FuzzyMatchFragment.this.f7154v != null && i < FuzzyMatchFragment.this.f7154v.size()) {
                                RpcPoi rpcPoi2 = (RpcPoi) FuzzyMatchFragment.this.f7154v.get(i);
                                FuzzyMatchFragment.this.f7155w.add(rpcPoi2);
                                FuzzyMatchFragment.this.f7155w.addAll(rpcPoi2.sub_poi_list);
                            }
                            int unused5 = FuzzyMatchFragment.this.f7127C = 2;
                        } else {
                            int unused6 = FuzzyMatchFragment.this.f7127C = 1;
                        }
                        FuzzyMatchFragment fuzzyMatchFragment = FuzzyMatchFragment.this;
                        fuzzyMatchFragment.m4290a(fuzzyMatchFragment.f7127C, false);
                        FuzzyMatchFragment fuzzyMatchFragment2 = FuzzyMatchFragment.this;
                        fuzzyMatchFragment2.m4289a(fuzzyMatchFragment2.f7127C);
                    }

                    public void onConfirmAddress(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild) {
                        if (!(rpcPoi == null || rpcPoi.base_info == null || rpcPoi.base_info.srctag == null || !rpcPoi.base_info.srctag.equals("newes_parent_child") || TextUtils.isEmpty(rpcPoi.base_info.fullname))) {
                            rpcPoi.base_info.displayname = rpcPoi.base_info.fullname;
                        }
                        Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
                        AddressTrack.trackFuzzyMatchBackOrConfirm(rpcPoi, trackParameterForChild, FuzzyMatchFragment.this.getmParam().addressParam.clone(), AddressTrack.SEARCH_CK_TYPE.POI_CONFIRM);
                        FuzzyMatchFragment.this.m4307b(convertToAddress);
                    }
                });
            }
            this.f7149q = (FuzzyMatchListView) this.f7148p.getView(1);
            this.f7150r = (FuzzyMatchCardView) this.f7148p.getView(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m4282a(View view) {
        if (this.f7132N == null) {
            this.f7132N = (ViewGroup) View.inflate(getContext(), R.layout.map_view_shadowlayout, (ViewGroup) null);
        }
        ShadowLayout shadowLayout = (ShadowLayout) this.f7132N.findViewById(R.id.cardViewContainer);
        shadowLayout.removeAllViews();
        shadowLayout.setCornerRadius(40);
        shadowLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return this.f7132N;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m4330m() {
        if (this.f7139g != null) {
            m4332n();
            this.f7139g.postDelayed(new Runnable() {
                public final void run() {
                    FuzzyMatchFragment.this.m4334o();
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void m4334o() {
        if (this.f7139g != null && getContext() != null && getActivity() != null) {
            this.f7128J = new Padding(30, 30, 30, this.f7139g.getHeight() + DisplayUtils.dp2px(getActivity(), 10.0f));
            m4304b(this.f7139g.getHeight());
            IDropOffCompContract iDropOffCompContract = this.f7144l;
            if (iDropOffCompContract != null) {
                iDropOffCompContract.adjustMapCamera(this.f7128J);
            }
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f7147o;
            if (fuzzyMatchAddressComponent != null) {
                fuzzyMatchAddressComponent.setPadding(this.f7128J);
            }
            View view = this.f7136d;
            if (view != null && this.f7139g != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int height = this.f7139g.getHeight();
                if (layoutParams.height != height) {
                    layoutParams.height = height;
                    this.f7136d.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4299a(List<RpcPoi> list, RpcPoi rpcPoi, boolean z, int i) {
        int i2;
        if (list != null && !list.isEmpty()) {
            if (z) {
                if (this.f7130L == 0) {
                    if (this.mCurrAddressType == 1) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.START_MAP_SELECT, this.f7125A);
                    } else if (this.mCurrAddressType == 2) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.END_MAP_SELECT, this.f7125A);
                    }
                    this.f7125A = false;
                }
                if (this.f7130L == 1) {
                    if (this.mCurrAddressType == 1) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.START_POI, this.f7126B);
                    } else if (this.mCurrAddressType == 2) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.END_POI, this.f7126B);
                    }
                    this.f7126B = false;
                    return;
                }
                return;
            }
            int i3 = this.f7127C;
            int i4 = -1;
            if (i3 == 0) {
                AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, getmParam().addressParam.clone(), list.indexOf(rpcPoi), -1, AddressTrack.SEARCH_CK_TYPE.SEARCH_MAP_CK);
            } else if (i3 == 1) {
                AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, getmParam().addressParam.clone(), list.indexOf(rpcPoi), -1, AddressTrack.SEARCH_CK_TYPE.POI_MAP_CK);
            } else if (i3 == 2 && rpcPoi != null && !CollectionUtil.isEmpty((Collection<?>) this.f7155w)) {
                if (!CollectionUtil.isEmpty((Collection<?>) rpcPoi.sub_poi_list)) {
                    i4 = list.indexOf(rpcPoi);
                    i2 = -1;
                } else {
                    i2 = this.f7155w.indexOf(rpcPoi) - 1;
                }
                AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, getmParam().addressParam.clone(), i4, i2, AddressTrack.SEARCH_CK_TYPE.POI_GROUP_CK);
            }
        }
    }

    /* renamed from: n */
    private void m4332n() {
        FrameLayout frameLayout = this.f7139g;
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -1;
            this.f7139g.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: b */
    private void m4304b(int i) {
        ImageView imageView = this.f7138f;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, i - DisplayUtils.dp2px(getContext(), 5.0f));
        }
    }
}
