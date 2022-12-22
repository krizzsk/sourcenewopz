package com.didi.addressnew.framework.fragmentmarket.map;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.address.FromType;
import com.didi.address.model.IWayPointsPostCallback;
import com.didi.address.model.SugMapConstants;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.map.adapter.SugWayPointListViewAdapter;
import com.didi.addressnew.framework.fragmentmarket.map.mode.SugWayPointItemViewTouchCallback;
import com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter;
import com.didi.addressnew.framework.fragmentmarket.map.view.SugWayPointEditView;
import com.didi.addressnew.framework.fragmentmarket.map.view.WayPointRcyViewSpacesItemDecoration;
import com.didi.addressnew.framework.mapholder.SugSharedMapView;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.pax.commonline.CommonLineManager;
import com.didi.map.global.component.line.pax.commonline.CommonLineParam;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.routesearchsdk.CallFrom;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SugMapWayPointFragment extends SugMapBaseFragment implements ISugWayPointPageView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4488a = SugMapWayPointFragment.class.getSimpleName();

    /* renamed from: b */
    private View f4489b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f4490c;

    /* renamed from: d */
    private ImageView f4491d;

    /* renamed from: e */
    private RecyclerView f4492e;

    /* renamed from: f */
    private FrameLayout f4493f;

    /* renamed from: g */
    private SugWayPointListViewAdapter f4494g;

    /* renamed from: h */
    private FrameLayout f4495h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f4496i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f4497j;

    /* renamed from: k */
    private CommonLineManager f4498k;

    /* renamed from: l */
    private IMarkersCompContract f4499l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ItemTouchHelper f4500m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SugMapWayPointPagePresenter f4501n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public List<WayPoint> f4502o = new ArrayList();

    /* renamed from: p */
    private boolean f4503p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Map f4504q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Padding f4505r = new Padding();

    /* renamed from: s */
    private Handler f4506s = new Handler(Looper.getMainLooper());

    /* renamed from: t */
    private Runnable f4507t = new Runnable() {
        public void run() {
            SugMapWayPointFragment.this.m2892e();
        }
    };

    /* renamed from: u */
    private ViewTreeObserver.OnGlobalLayoutListener f4508u = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (SugMapWayPointFragment.this.f4505r != null && SugMapWayPointFragment.this.f4497j != null && SugMapWayPointFragment.this.f4490c != null) {
                Padding padding = new Padding(0, SugMapWayPointFragment.this.f4497j.getHeight(), 0, SugMapWayPointFragment.this.f4490c.getHeight() + DisplayUtils.dp2px(SugMapWayPointFragment.this.getActivity(), 20.0f));
                if (!SugMapWayPointFragment.this.f4505r.equals(padding)) {
                    Padding unused = SugMapWayPointFragment.this.f4505r = padding;
                    SugMapWayPointFragment.this.m2886b();
                }
            }
        }
    };

    /* renamed from: v */
    private View.OnClickListener f4509v = new View.OnClickListener() {
        public final void onClick(View view) {
            SugMapWayPointFragment.this.m2879a(view);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: w */
    public WayPoint f4510w;

    /* renamed from: x */
    private SugWayPointListViewAdapter.WayPointRecyclerAdapterCallback f4511x = new SugWayPointListViewAdapter.WayPointRecyclerAdapterCallback() {
        public void onDragStart(RecyclerView.ViewHolder viewHolder) {
            SugMapWayPointFragment.this.f4500m.startDrag(viewHolder);
            for (WayPoint draging : SugMapWayPointFragment.this.f4502o) {
                draging.setDraging(true);
            }
            SugMapWayPointFragment.this.setSubmitEnable(false);
        }

        public void onDradEnd() {
            for (WayPoint draging : SugMapWayPointFragment.this.f4502o) {
                draging.setDraging(false);
            }
            if (SugMapWayPointFragment.this.f4501n != null) {
                SugMapWayPointFragment.this.f4501n.updateSubmitStatus(SugMapWayPointFragment.this.f4502o);
            }
            SugMapWayPointFragment.this.onWayPointsUpdated();
        }

        public void addToStopPoints(WayPoint wayPoint) {
            if (SugMapWayPointFragment.this.f4501n != null) {
                SugMapWayPointFragment.this.f4501n.addToStopPoints(wayPoint);
            }
        }

        public void clearStopPoints() {
            if (SugMapWayPointFragment.this.f4501n != null) {
                SugMapWayPointFragment.this.f4501n.clearStopPoints();
            }
        }

        public boolean addStopAble() {
            return SugMapWayPointFragment.this.f4501n.canAddStop();
        }
    };

    /* renamed from: y */
    private SugWayPointEditView.OnActionListener f4512y = new SugWayPointEditView.OnActionListener() {
        public void onSelectAddress(WayPoint wayPoint, int i) {
            WayPoint unused = SugMapWayPointFragment.this.f4510w = wayPoint;
            SugParams clone = SugMapWayPointFragment.this.getmParam().clone();
            if (SugMapWayPointFragment.this.getmParam().fromType == FromType.HOME) {
                clone.fromType = FromType.FROM_HOME_ROUTE_EDITOR;
            } else if (SugMapWayPointFragment.this.getmParam().fromType == FromType.CONFIRM_NEW || SugMapWayPointFragment.this.getmParam().fromType == FromType.CONFIRM) {
                clone.fromType = FromType.FROM_CONFIRM_ROUTE_EDITOR;
            } else {
                clone.fromType = FromType.ROUTE_EDITOR;
            }
            if (wayPoint.getWayPointType() == 2) {
                int i2 = i == 1 ? 101 : 102;
                clone.addressParam.addressType = i2;
                SugMapWayPointFragment.this.getmParam().addressParam.addressType = i2;
                Address address = wayPoint.getAddress();
                if (TextUtils.isEmpty(address.displayName) || address.getLatitude() == 0.0d || address.getLongitude() == 0.0d) {
                    SugMapWayPointFragment.this.getmResult().setResultAllowNull(i2, (Address) null);
                } else {
                    SugMapWayPointFragment.this.getmResult().setCommon(wayPoint.getAddress());
                }
                AddressTrack.trackWayPointViewCK(clone);
                SugMapWayPointFragment sugMapWayPointFragment = SugMapWayPointFragment.this;
                sugMapWayPointFragment.onConfirm(clone, sugMapWayPointFragment.getmResult());
                SugMapWayPointFragment sugMapWayPointFragment2 = SugMapWayPointFragment.this;
                sugMapWayPointFragment2.switchSingle(clone, sugMapWayPointFragment2.getmResult(), i2);
                return;
            }
            Address address2 = wayPoint.getAddress();
            if (wayPoint.getWayPointType() == 1) {
                clone.addressParam.addressType = 1;
                SugMapWayPointFragment.this.getmParam().addressParam.addressType = 1;
                if (TextUtils.isEmpty(address2.displayName) || address2.getLatitude() == 0.0d || address2.getLongitude() == 0.0d) {
                    SugMapWayPointFragment.this.getmResult().setResultAllowNull(1, (Address) null);
                } else {
                    SugMapWayPointFragment.this.getmResult().setStart(wayPoint.getAddress());
                }
                SugMapWayPointFragment sugMapWayPointFragment3 = SugMapWayPointFragment.this;
                sugMapWayPointFragment3.onConfirm(clone, sugMapWayPointFragment3.getmResult());
            } else if (wayPoint.getWayPointType() == 3) {
                clone.addressParam.addressType = 2;
                SugMapWayPointFragment.this.getmParam().addressParam.addressType = 2;
                if (TextUtils.isEmpty(address2.displayName) || address2.getLatitude() == 0.0d || address2.getLongitude() == 0.0d) {
                    SugMapWayPointFragment.this.getmResult().setResultAllowNull(2, (Address) null);
                } else {
                    SugMapWayPointFragment.this.getmResult().setEnd(wayPoint.getAddress());
                }
                SugMapWayPointFragment sugMapWayPointFragment4 = SugMapWayPointFragment.this;
                sugMapWayPointFragment4.onConfirm(clone, sugMapWayPointFragment4.getmResult());
            }
            SugMapWayPointFragment sugMapWayPointFragment5 = SugMapWayPointFragment.this;
            sugMapWayPointFragment5.switchFull(clone, sugMapWayPointFragment5.getmResult());
        }

        public void addToChangedWayPoints(WayPoint wayPoint) {
            if (SugMapWayPointFragment.this.f4501n != null) {
                SugMapWayPointFragment.this.f4501n.addToChangedWayPoints(wayPoint);
            }
        }
    };

    public boolean getDragHandlerEnable() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.map_waypoint_edit_fragment_layout;
    }

    public void updatePageContent() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2886b() {
        Handler handler = this.f4506s;
        if (handler != null) {
            handler.removeCallbacks(this.f4507t);
            this.f4506s.postDelayed(this.f4507t, 300);
        }
    }

    /* access modifiers changed from: protected */
    public void onInit(View view) {
        this.f4489b = view;
        this.f4497j = view.findViewById(R.id.cardView);
        this.f4492e = (RecyclerView) view.findViewById(R.id.rvWayPointList);
        this.f4495h = (FrameLayout) view.findViewById(R.id.progressbarView);
        this.f4496i = view.findViewById(R.id.mapViewOverLayer);
        this.f4493f = (FrameLayout) view.findViewById(R.id.mapContainer);
        TextView textView = (TextView) view.findViewById(R.id.tvWayPointSubmit);
        this.f4490c = textView;
        textView.setOnClickListener(this.f4509v);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgMapReset);
        this.f4491d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugMapWayPointFragment.this.m2887b(view);
            }
        });
        try {
            this.f4490c.setTextColor(ContextCompat.getColorStateList(getActivity(), DidiThemeManager.getIns().getResPicker(getActivity()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f4490c.setBackground(DidiThemeManager.getIns().getResPicker(getActivity()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        SugWayPointListViewAdapter sugWayPointListViewAdapter = new SugWayPointListViewAdapter(getContext());
        this.f4494g = sugWayPointListViewAdapter;
        sugWayPointListViewAdapter.setOnActionListener(this.f4512y);
        this.f4494g.setWayPointRecyclerAdapterCallback(this.f4511x);
        this.f4494g.setDataList(this.f4502o);
        this.f4492e.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.f4492e.addItemDecoration(new WayPointRcyViewSpacesItemDecoration(DisplayUtils.dp2px(getActivity(), 2.0f)));
        this.f4492e.setAdapter(this.f4494g);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SugWayPointItemViewTouchCallback(this.f4494g));
        this.f4500m = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.f4492e);
        if (getmResult().getLastPageType() != FragmentFactory.FragmentType.OTHER) {
            m2880a(this.mWayPointParam);
        }
        SugMapWayPointPagePresenter sugMapWayPointPagePresenter = new SugMapWayPointPagePresenter(this, this.mWayPointParam);
        this.f4501n = sugMapWayPointPagePresenter;
        this.f4494g.setWayPointEditPagePresenter(sugMapWayPointPagePresenter);
        this.f4494g.notifyDataSetChanged();
        this.f4503p = false;
        this.f4489b.getViewTreeObserver().addOnGlobalLayoutListener(this.f4508u);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m2887b(View view) {
        m2886b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2889c() {
        logWriter("refreshComponents start...");
        onWayPointsUpdated();
    }

    /* access modifiers changed from: protected */
    public void onShowMapReset() {
        ImageView imageView = this.f4491d;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void onPageEnter() {
        super.onPageEnter();
        logWriter("onPageEnter");
        this.f4503p = false;
        AddressParam addressParam = getmParam().addressParam;
        Address result = getmResult().getResult(addressParam.addressType);
        if (getView() != null) {
            getView().requestFocus();
        }
        if (!(isFirstEnter() || addressParam.addressType == 1 || addressParam.addressType == 2)) {
            delSwitcherResultAddress(addressParam.addressType);
        }
        boolean z = getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel;
        if (!(result == null || this.f4510w == null || z)) {
            logWriter("onPageEnter onAddressResult");
            this.f4501n.onAddressResult(result, this.f4510w);
        }
        AddressTrack.trackWayPointSW(getmParam().wayPointParam);
        if (isFirstEnter()) {
            AddressTrack.trackSugPageSW(1, 1, 0);
        }
        SugSharedMapView.getInstance(getActivity()).onAdd(this.f4493f);
        MapView mapView = SugSharedMapView.getInstance(getActivity()).getMapView();
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    Map unused = SugMapWayPointFragment.this.f4504q = map;
                    SugMapWayPointFragment.this.addOnMapGestureListener(map);
                    SugMapWayPointFragment.this.m2889c();
                    SugMapWayPointFragment sugMapWayPointFragment = SugMapWayPointFragment.this;
                    sugMapWayPointFragment.playAnimationMapLayer(sugMapWayPointFragment.f4496i);
                    SugMapWayPointFragment.this.m2886b();
                }
            });
        }
    }

    public void onPageExit() {
        logWriter("onPageExit...");
        this.f4503p = true;
        m2899h();
        m2897g();
        removeOnMapGestureListener(this.f4504q);
        this.f4504q = null;
        super.onPageExit();
    }

    /* renamed from: a */
    private LatLng m2876a(Address address) {
        if (address.getLongitude() == 0.0d || address.getLongitude() == 0.0d) {
            return null;
        }
        return new LatLng(address.getLatitude(), address.getLongitude());
    }

    /* renamed from: d */
    private void m2891d() {
        LatLng latLng;
        logWriter("addLineComponent");
        if (!this.mDestroyed && this.f4504q != null) {
            m2899h();
            m2897g();
            if (this.f4502o.isEmpty()) {
                logWriter("addLineComponent mWayPointList.isEmpty()");
                return;
            }
            ArrayList arrayList = new ArrayList();
            LatLng a = m2876a(this.f4502o.get(0).getAddress());
            if (a != null) {
                arrayList.add(a);
            }
            ArrayList arrayList2 = new ArrayList();
            int size = this.f4502o.size();
            if (size > 1) {
                if (size > 2) {
                    for (int i = 1; i < size - 1; i++) {
                        LatLng a2 = m2876a(this.f4502o.get(i).getAddress());
                        if (a2 != null) {
                            arrayList2.add(a2);
                        }
                    }
                }
                latLng = m2876a(this.f4502o.get(size - 1).getAddress());
            } else {
                latLng = null;
            }
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
            if (latLng != null) {
                arrayList.add(latLng);
            }
            if (arrayList.size() > 1) {
                LineParams lineParams = new LineParams((List<LatLng>) null, SugMapConstants.DEFAULT_WAYPOINT_MAP_LINE_COLOR, 6);
                CommonLineParam commonLineParam = new CommonLineParam();
                commonLineParam.setLineParam(lineParams);
                commonLineParam.setStartPos(a);
                commonLineParam.setEndPos((LatLng) arrayList.get(arrayList.size() - 1));
                commonLineParam.setCaller(CallFrom.ORDERROUTEAPI_BUBBLE_WAYPOINT);
                commonLineParam.setWayPoints(arrayList2);
                CommonLineManager commonLineManager = new CommonLineManager(getContext(), this.f4504q, commonLineParam);
                this.f4498k = commonLineManager;
                commonLineManager.setListener(new OnLineDrawStatusListener() {
                    public /* synthetic */ void onLineDrawStart() {
                        OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                    }

                    public void onLineDrawFinished() {
                        SystemUtils.log(4, SugMapWayPointFragment.f4488a, "mLineComponent line onRefresh", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.SugMapWayPointFragment$4", 316);
                        SugMapWayPointFragment.this.m2886b();
                    }
                });
                this.f4498k.create();
            }
            m2883a((List<LatLng>) arrayList);
        }
    }

    /* renamed from: a */
    private void m2883a(List<LatLng> list) {
        if (!this.mDestroyed) {
            m2899h();
            int size = this.f4502o.size();
            if (size != 0) {
                ArrayList arrayList = new ArrayList();
                int i = 10;
                if (size > 0) {
                    m2884a(arrayList, this.f4502o.get(0).getAddress(), "marker_0", R.drawable.waypoint_map_icon_pickup, 20);
                }
                if (size > 2) {
                    for (int i2 = 1; i2 < size - 1; i2++) {
                        Address address = this.f4502o.get(i2).getAddress();
                        m2884a(arrayList, address, "marker_" + i2, R.drawable.waypoint_map_icon_stop_point, i);
                        i++;
                    }
                }
                if (size > 1) {
                    int i3 = size - 1;
                    Address address2 = this.f4502o.get(i3).getAddress();
                    m2884a(arrayList, address2, "marker_" + i3, R.drawable.waypoint_map_icon_dest, 15);
                }
                if (!arrayList.isEmpty()) {
                    MarkersCompParams build = new MarkersCompParams.Builder().markerModels(arrayList).build();
                    MarkersComponent markersComponent = new MarkersComponent();
                    this.f4499l = markersComponent;
                    markersComponent.setConfigParam(build);
                    this.f4499l.create(getActivity(), this.f4504q);
                    if (this.f4502o.size() > 2) {
                        for (int i4 = 1; i4 < this.f4502o.size() - 1; i4++) {
                            m2882a(this.f4502o.get(i4).getAddress(), i4);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m2882a(Address address, int i) {
        if (this.f4499l != null && address != null && m2876a(address) != null && getContext() != null) {
            TextView textView = new TextView(getContext());
            int dp2px = DisplayUtils.dp2px(getContext(), 5.0f);
            int dp2px2 = DisplayUtils.dp2px(getContext(), 8.0f);
            textView.setPadding(dp2px2, dp2px, dp2px2, dp2px);
            textView.setBackgroundResource(R.drawable.waypoint_map_bubble_bg_shape);
            String str = "STOP " + i;
            if (i == 1) {
                str = getContext().getResources().getString(R.string.GRider_Sug_2020_stop1_bubble);
            } else if (i == 2) {
                str = getContext().getResources().getString(R.string.GRider_Sug_2020_stop2_bubble);
            }
            textView.setText(str);
            textView.setTextColor(-16777216);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(11.0f);
            this.f4499l.showMarkerInfoWindow("marker_" + i, textView);
        }
    }

    /* renamed from: a */
    private void m2884a(List<MarkerModel> list, Address address, String str, int i, int i2) {
        LatLng a = m2876a(address);
        if (a != null) {
            MarkerModel markerModel = new MarkerModel();
            markerModel.setPoint(a);
            markerModel.setId(str);
            markerModel.setMarkerIcon(BitmapFactory.decodeResource(getContext().getResources(), i));
            markerModel.setAnchorV(0.5f);
            markerModel.setAnchorU(0.5f);
            markerModel.setZOrder(i2);
            list.add(markerModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2892e() {
        if (this.f4504q != null && this.f4491d != null && getActivity() != null) {
            this.f4491d.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            CommonLineManager commonLineManager = this.f4498k;
            if (!(commonLineManager == null || commonLineManager.getBestViewElements() == null)) {
                arrayList.addAll(this.f4498k.getBestViewElements());
            }
            IMarkersCompContract iMarkersCompContract = this.f4499l;
            if (!(iMarkersCompContract == null || iMarkersCompContract.getMarkers() == null)) {
                arrayList.addAll(this.f4499l.getMarkers());
            }
            if (SugSharedMapView.getInstance(getActivity()).getMyLocationMarkers() != null) {
                arrayList.addAll(SugSharedMapView.getInstance(getActivity()).getMyLocationMarkers());
            }
            BestViewer.doBestView(this.f4504q, true, (List<IMapElement>) arrayList, this.f4505r, new Padding(DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f)), (BestViewer.IBestViewListener) null);
        }
    }

    public void updateAddStopEnterVisible(WayPoint wayPoint, boolean z) {
        if (this.f4502o.contains(wayPoint)) {
            List<WayPoint> list = this.f4502o;
            list.get(list.indexOf(wayPoint)).setCanAdd(z);
            this.f4494g.clearGuideView();
            this.f4494g.notifyDataSetChanged();
        }
    }

    public void onWayPointsUpdated() {
        logWriter("onWayPointsUpdated start...");
        if (!this.mDestroyed && this.f4504q != null) {
            logWriter("onWayPointsUpdated removeCallbacksAndMessages before");
            this.f4506s.removeCallbacksAndMessages((Object) null);
            logWriter("onWayPointsUpdated removeCallbacksAndMessages after");
            this.f4506s.postDelayed(new Runnable() {
                public final void run() {
                    SugMapWayPointFragment.this.m2901i();
                }
            }, 300);
            logWriter("onWayPointsUpdated removeCallbacksAndMessages postDelayed after");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m2901i() {
        logWriter("onWayPointsUpdated size=" + this.f4502o.size());
        if (!this.f4503p) {
            m2894f();
        }
    }

    /* renamed from: f */
    private void m2894f() {
        m2891d();
        m2886b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m2879a(View view) {
        if (view.getId() == this.f4490c.getId() && !ViewFastDoubleClickInterceptor.isFastClick()) {
            FragmentActivity fragmentActivity = getActivity() != null ? (FragmentActivity) getActivity() : null;
            if (getSugCallback() != null) {
                setSubmitEnable(false);
                this.f4501n.sortWayPoints();
                if (CommonUtils.checkDuplicate((ArrayList) this.f4501n.getValidWayPoints())) {
                    CommonUtils.showDuplicateAlert(getContext());
                    this.f4490c.setEnabled(true);
                    return;
                }
                getSugCallback().onSubmitWayPoints(fragmentActivity, this.f4501n.getValidWayPoints(), this.f4501n.getChangedWayPoints(), new IWayPointsPostCallback() {
                    public void onSuccess() {
                        SugMapWayPointFragment.this.setSubmitEnable(true);
                        SugMapWayPointFragment.this.closeSessionImediately();
                        SugMapWayPointFragment.this.logWriter("wayPoint Submit Success");
                    }

                    public void onFailure(String str) {
                        SugMapWayPointFragment.this.setSubmitEnable(true);
                        SugMapWayPointFragment.this.logWriter("wayPoint Submit Failure");
                    }
                });
                AddressTrack.trackWayPointConfirmCK(this.f4501n.getValidWayPoints());
            }
        }
    }

    public void setSubmitEnable(boolean z) {
        this.f4490c.setEnabled(z);
    }

    public boolean addWayPoint(WayPoint wayPoint) {
        logWriter("addWayPoint");
        if (wayPoint == null) {
            return false;
        }
        int a = m2873a(wayPoint);
        if (a >= 0) {
            this.f4494g.setItemAnimFlag(true);
            this.f4494g.notifyItemInserted(a);
        }
        if (getmParam() != null && wayPoint.getWayPointType() == 2 && !CommonUtils.isValidLocation(wayPoint.getAddress())) {
            AddressTrack.trackWayPointAddCK(getmParam().wayPointParam);
        }
        return true;
    }

    public boolean removeWayPoint(WayPoint wayPoint) {
        logWriter("removeWayPoint");
        if (wayPoint == null || !this.f4502o.contains(wayPoint) || !this.f4502o.contains(wayPoint)) {
            return false;
        }
        this.f4502o.remove(wayPoint);
        this.f4494g.setItemAnimFlag(false);
        onWayPointsUpdated();
        return true;
    }

    public void resetWayPointList() {
        this.f4494g.clearGuideView();
        this.f4494g.updateDataType();
    }

    /* renamed from: a */
    private int m2873a(WayPoint wayPoint) {
        int i;
        logWriter("insertWayPoint");
        if (wayPoint != null) {
            boolean z = false;
            boolean z2 = false;
            for (WayPoint next : this.f4502o) {
                if (next.getWayPointType() == 1) {
                    z = true;
                } else if (next.getWayPointType() == 3) {
                    z2 = true;
                }
            }
            int wayPointType = wayPoint.getWayPointType();
            if (wayPointType == 1) {
                if (z) {
                    this.f4502o.remove(0);
                }
                this.f4502o.add(0, wayPoint);
                return 0;
            } else if (wayPointType == 2) {
                if (z2) {
                    i = this.f4502o.size() - 1;
                } else {
                    i = this.f4502o.size();
                }
                this.f4502o.add(i, wayPoint);
                return i;
            } else if (wayPointType == 3) {
                if (z2) {
                    List<WayPoint> list = this.f4502o;
                    list.remove(list.size() - 1);
                }
                int size = this.f4502o.size();
                List<WayPoint> list2 = this.f4502o;
                list2.add(list2.size(), wayPoint);
                return size;
            }
        }
        return -1;
    }

    public boolean updateWayPoint(WayPoint wayPoint) {
        logWriter("updateWayPoint");
        if (wayPoint != null && this.f4502o.contains(wayPoint)) {
            if (!CommonUtils.checkDuplicate((ArrayList) this.f4502o)) {
                this.f4494g.clearGuideView();
                this.f4494g.notifyDataSetChanged();
                return true;
            }
            CommonUtils.showDuplicateAlert(getContext());
        }
        return false;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.WAYPOINT;
    }

    public Context getPageContext() {
        return getActivity();
    }

    public View getFallbackView() {
        return this.f4495h;
    }

    /* renamed from: g */
    private void m2897g() {
        CommonLineManager commonLineManager = this.f4498k;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f4498k = null;
        }
    }

    /* renamed from: h */
    private void m2899h() {
        IMarkersCompContract iMarkersCompContract = this.f4499l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f4499l = null;
        }
    }

    public void onDestroyView() {
        logWriter("onDestroyView");
        this.f4503p = true;
        Handler handler = this.f4506s;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        SugWayPointListViewAdapter sugWayPointListViewAdapter = this.f4494g;
        if (sugWayPointListViewAdapter != null) {
            sugWayPointListViewAdapter.clearGuideView();
        }
        m2899h();
        m2897g();
        View view = this.f4489b;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4508u);
        }
        SugSharedMapView.getInstance(getActivity()).onRemove(this.f4493f);
        super.onDestroyView();
    }

    public boolean onBackPressed() {
        if (getActivity().isFinishing()) {
            return false;
        }
        closeSessionImediately();
        return false;
    }

    /* renamed from: a */
    private void m2880a(WayPointParam wayPointParam) {
        if (wayPointParam != null && wayPointParam.getWayPoints() != null && wayPointParam.getWayPoints().size() == 2 && wayPointParam.getWayPoints().get(0) != null && wayPointParam.getWayPoints().get(1) != null && wayPointParam.getWayPoints().get(0).getWayPointType() == 1 && wayPointParam.getWayPoints().get(1).getWayPointType() == 3) {
            wayPointParam.getWayPoints().add(1, new WayPoint(2, new Address()));
        }
    }
}
