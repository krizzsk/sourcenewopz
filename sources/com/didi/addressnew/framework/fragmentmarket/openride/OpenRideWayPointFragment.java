package com.didi.addressnew.framework.fragmentmarket.openride;

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
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.fragmentmarket.map.ISugWayPointPageView;
import com.didi.addressnew.framework.fragmentmarket.map.SugMapBaseFragment;
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
import com.didi.common.map.util.CollectionUtil;
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
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OpenRideWayPointFragment extends SugMapBaseFragment implements ISugWayPointPageView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f7303a = OpenRideWayPointFragment.class.getSimpleName();

    /* renamed from: b */
    private View f7304b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f7305c;

    /* renamed from: d */
    private ImageView f7306d;

    /* renamed from: e */
    private RecyclerView f7307e;

    /* renamed from: f */
    private FrameLayout f7308f;

    /* renamed from: g */
    private SugWayPointListViewAdapter f7309g;

    /* renamed from: h */
    private FrameLayout f7310h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f7311i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f7312j;

    /* renamed from: k */
    private CommonLineManager f7313k;

    /* renamed from: l */
    private IMarkersCompContract f7314l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ItemTouchHelper f7315m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SugMapWayPointPagePresenter f7316n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public List<WayPoint> f7317o = new ArrayList();

    /* renamed from: p */
    private boolean f7318p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Map f7319q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Padding f7320r = new Padding();

    /* renamed from: s */
    private Handler f7321s = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ArrayList<Boolean> f7322t = new ArrayList<>(4);

    /* renamed from: u */
    private Runnable f7323u = new Runnable() {
        public void run() {
            OpenRideWayPointFragment.this.m4563g();
        }
    };

    /* renamed from: v */
    private ViewTreeObserver.OnGlobalLayoutListener f7324v = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (OpenRideWayPointFragment.this.f7320r != null && OpenRideWayPointFragment.this.f7312j != null && OpenRideWayPointFragment.this.f7305c != null) {
                Padding padding = new Padding(0, OpenRideWayPointFragment.this.f7312j.getHeight(), 0, OpenRideWayPointFragment.this.f7305c.getHeight() + DisplayUtils.dp2px(OpenRideWayPointFragment.this.getActivity(), 20.0f));
                if (!OpenRideWayPointFragment.this.f7320r.equals(padding)) {
                    Padding unused = OpenRideWayPointFragment.this.f7320r = padding;
                    OpenRideWayPointFragment.this.m4550b();
                }
            }
        }
    };

    /* renamed from: w */
    private View.OnClickListener f7325w = new View.OnClickListener() {
        public final void onClick(View view) {
            OpenRideWayPointFragment.this.m4542a(view);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x */
    public WayPoint f7326x;

    /* renamed from: y */
    private SugWayPointListViewAdapter.WayPointRecyclerAdapterCallback f7327y = new SugWayPointListViewAdapter.WayPointRecyclerAdapterCallback() {
        public void onDragStart(RecyclerView.ViewHolder viewHolder) {
            OpenRideWayPointFragment.this.f7315m.startDrag(viewHolder);
            for (WayPoint draging : OpenRideWayPointFragment.this.f7317o) {
                draging.setDraging(true);
            }
            OpenRideWayPointFragment.this.setSubmitEnable(false);
        }

        public void onDradEnd() {
            for (WayPoint draging : OpenRideWayPointFragment.this.f7317o) {
                draging.setDraging(false);
            }
            if (OpenRideWayPointFragment.this.f7316n != null) {
                OpenRideWayPointFragment.this.f7316n.updateSubmitStatus(OpenRideWayPointFragment.this.f7317o);
            }
            OpenRideWayPointFragment.this.onWayPointsUpdated();
        }

        public void addToStopPoints(WayPoint wayPoint) {
            if (OpenRideWayPointFragment.this.f7316n != null) {
                OpenRideWayPointFragment.this.f7316n.addToStopPoints(wayPoint);
            }
        }

        public void clearStopPoints() {
            if (OpenRideWayPointFragment.this.f7316n != null) {
                OpenRideWayPointFragment.this.f7316n.clearStopPoints();
            }
        }

        public boolean addStopAble() {
            return OpenRideWayPointFragment.this.f7316n.canAddStop();
        }
    };

    /* renamed from: z */
    private SugWayPointEditView.OnActionListener f7328z = new SugWayPointEditView.OnActionListener() {
        public void onSelectAddress(WayPoint wayPoint, int i) {
            if (OpenRideWayPointFragment.this.f7322t == null || i >= OpenRideWayPointFragment.this.f7322t.size() || ((Boolean) OpenRideWayPointFragment.this.f7322t.get(i)).booleanValue()) {
                WayPoint unused = OpenRideWayPointFragment.this.f7326x = wayPoint;
                SugParams clone = OpenRideWayPointFragment.this.getmParam().clone();
                if (OpenRideWayPointFragment.this.getmParam().fromType == FromType.HOME) {
                    clone.fromType = FromType.FROM_HOME_ROUTE_EDITOR;
                } else if (OpenRideWayPointFragment.this.getmParam().fromType == FromType.CONFIRM_NEW || OpenRideWayPointFragment.this.getmParam().fromType == FromType.CONFIRM) {
                    clone.fromType = FromType.FROM_CONFIRM_ROUTE_EDITOR;
                } else {
                    clone.fromType = FromType.ROUTE_EDITOR;
                }
                if (wayPoint.getWayPointType() == 2) {
                    int i2 = i == 1 ? 101 : 102;
                    clone.addressParam.addressType = i2;
                    OpenRideWayPointFragment.this.getmParam().addressParam.addressType = i2;
                    Address address = wayPoint.getAddress();
                    if (TextUtils.isEmpty(address.displayName) || address.getLatitude() == 0.0d || address.getLongitude() == 0.0d) {
                        OpenRideWayPointFragment.this.getmResult().setResultAllowNull(i2, (Address) null);
                    } else {
                        OpenRideWayPointFragment.this.getmResult().setCommon(wayPoint.getAddress());
                    }
                    AddressTrack.trackWayPointViewCK(clone);
                    OpenRideWayPointFragment openRideWayPointFragment = OpenRideWayPointFragment.this;
                    openRideWayPointFragment.onConfirm(clone, openRideWayPointFragment.getmResult());
                    OpenRideWayPointFragment openRideWayPointFragment2 = OpenRideWayPointFragment.this;
                    openRideWayPointFragment2.switchSingle(clone, openRideWayPointFragment2.getmResult(), i2);
                    return;
                }
                Address address2 = wayPoint.getAddress();
                if (wayPoint.getWayPointType() == 1) {
                    clone.addressParam.addressType = 1;
                    OpenRideWayPointFragment.this.getmParam().addressParam.addressType = 1;
                    if (TextUtils.isEmpty(address2.displayName) || address2.getLatitude() == 0.0d || address2.getLongitude() == 0.0d) {
                        OpenRideWayPointFragment.this.getmResult().setResultAllowNull(1, (Address) null);
                    } else {
                        OpenRideWayPointFragment.this.getmResult().setStart(wayPoint.getAddress());
                    }
                    OpenRideWayPointFragment openRideWayPointFragment3 = OpenRideWayPointFragment.this;
                    openRideWayPointFragment3.onConfirm(clone, openRideWayPointFragment3.getmResult());
                } else if (wayPoint.getWayPointType() == 3) {
                    clone.addressParam.addressType = 2;
                    OpenRideWayPointFragment.this.getmParam().addressParam.addressType = 2;
                    if (TextUtils.isEmpty(address2.displayName) || address2.getLatitude() == 0.0d || address2.getLongitude() == 0.0d) {
                        OpenRideWayPointFragment.this.getmResult().setResultAllowNull(2, (Address) null);
                    } else {
                        OpenRideWayPointFragment.this.getmResult().setEnd(wayPoint.getAddress());
                    }
                    OpenRideWayPointFragment openRideWayPointFragment4 = OpenRideWayPointFragment.this;
                    openRideWayPointFragment4.onConfirm(clone, openRideWayPointFragment4.getmResult());
                }
                OpenRideWayPointFragment openRideWayPointFragment5 = OpenRideWayPointFragment.this;
                openRideWayPointFragment5.switchFull(clone, openRideWayPointFragment5.getmResult());
            }
        }

        public void addToChangedWayPoints(WayPoint wayPoint) {
            if (OpenRideWayPointFragment.this.f7316n != null) {
                OpenRideWayPointFragment.this.f7316n.addToChangedWayPoints(wayPoint);
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
    public void m4550b() {
        Handler handler = this.f7321s;
        if (handler != null) {
            handler.removeCallbacks(this.f7323u);
            this.f7321s.postDelayed(this.f7323u, 300);
        }
    }

    /* access modifiers changed from: protected */
    public void onInit(View view) {
        this.f7304b = view;
        this.f7312j = view.findViewById(R.id.cardView);
        this.f7307e = (RecyclerView) view.findViewById(R.id.rvWayPointList);
        this.f7310h = (FrameLayout) view.findViewById(R.id.progressbarView);
        this.f7311i = view.findViewById(R.id.mapViewOverLayer);
        this.f7308f = (FrameLayout) view.findViewById(R.id.mapContainer);
        TextView textView = (TextView) view.findViewById(R.id.tvWayPointSubmit);
        this.f7305c = textView;
        textView.setOnClickListener(this.f7325w);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgMapReset);
        this.f7306d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OpenRideWayPointFragment.this.m4551b(view);
            }
        });
        try {
            this.f7305c.setTextColor(ContextCompat.getColorStateList(getActivity(), DidiThemeManager.getIns().getResPicker(getActivity()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f7305c.setBackground(DidiThemeManager.getIns().getResPicker(getActivity()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        m4555c();
        m4557d();
        SugWayPointListViewAdapter sugWayPointListViewAdapter = new SugWayPointListViewAdapter(getContext());
        this.f7309g = sugWayPointListViewAdapter;
        sugWayPointListViewAdapter.setOnActionListener(this.f7328z);
        this.f7309g.setWayPointRecyclerAdapterCallback(this.f7327y);
        this.f7309g.setDataList(this.f7317o);
        this.f7307e.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.f7307e.addItemDecoration(new WayPointRcyViewSpacesItemDecoration(DisplayUtils.dp2px(getActivity(), 2.0f)));
        this.f7307e.setAdapter(this.f7309g);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SugWayPointItemViewTouchCallback(this.f7309g));
        this.f7315m = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.f7307e);
        SugMapWayPointPagePresenter sugMapWayPointPagePresenter = new SugMapWayPointPagePresenter(this, this.mWayPointParam);
        this.f7316n = sugMapWayPointPagePresenter;
        this.f7309g.setWayPointEditPagePresenter(sugMapWayPointPagePresenter);
        this.f7309g.notifyDataSetChanged();
        this.f7318p = false;
        this.f7304b.getViewTreeObserver().addOnGlobalLayoutListener(this.f7324v);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m4551b(View view) {
        m4550b();
    }

    /* renamed from: c */
    private void m4555c() {
        this.f7322t.clear();
        for (int i = 0; i < 4; i++) {
            this.f7322t.add(i, true);
        }
        this.f7322t.set(0, false);
    }

    /* renamed from: d */
    private void m4557d() {
        List<WayPoint> list = this.f7317o;
        if (list != null) {
            for (WayPoint next : list) {
                if (next != null && next.getWayPointType() == 1) {
                    next.setUIEnable(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m4558e() {
        logWriter("refreshComponents start...");
        onWayPointsUpdated();
    }

    /* access modifiers changed from: protected */
    public void onShowMapReset() {
        ImageView imageView = this.f7306d;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void onPageEnter() {
        super.onPageEnter();
        logWriter("onPageEnter");
        this.f7318p = false;
        SugParams sugParams = getmParam();
        Address result = getmResult().getResult(sugParams.addressParam.addressType);
        if (getView() != null) {
            getView().requestFocus();
        }
        if (!(isFirstEnter() || sugParams.addressParam.addressType == 1 || sugParams.addressParam.addressType == 2)) {
            delSwitcherResultAddress(sugParams.addressParam.addressType);
        }
        boolean z = getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel;
        if (!(result == null || this.f7326x == null || z)) {
            logWriter("onPageEnter onAddressResult");
            this.f7316n.onAddressResult(result, this.f7326x);
        }
        AddressTrack.trackWayPointSW(sugParams.wayPointParam);
        if (isFirstEnter()) {
            AddressTrack.trackSugPageSW(1, 1, 0);
        }
        SugSharedMapView.getInstance(getActivity()).onAdd(this.f7308f);
        MapView mapView = SugSharedMapView.getInstance(getActivity()).getMapView();
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    Map unused = OpenRideWayPointFragment.this.f7319q = map;
                    OpenRideWayPointFragment.this.addOnMapGestureListener(map);
                    OpenRideWayPointFragment.this.m4558e();
                    OpenRideWayPointFragment openRideWayPointFragment = OpenRideWayPointFragment.this;
                    openRideWayPointFragment.playAnimationMapLayer(openRideWayPointFragment.f7311i);
                    OpenRideWayPointFragment.this.m4550b();
                }
            });
        }
    }

    public void onPageExit() {
        logWriter("onPageExit...");
        this.f7318p = true;
        m4569j();
        m4567i();
        removeOnMapGestureListener(this.f7319q);
        this.f7319q = null;
        super.onPageExit();
    }

    /* renamed from: a */
    private LatLng m4539a(Address address) {
        if (address.getLongitude() == 0.0d || address.getLongitude() == 0.0d) {
            return null;
        }
        return new LatLng(address.getLatitude(), address.getLongitude());
    }

    /* renamed from: f */
    private void m4560f() {
        LatLng latLng;
        logWriter("addLineComponent");
        if (!this.mDestroyed && this.f7319q != null) {
            m4569j();
            m4567i();
            if (this.f7317o.isEmpty()) {
                logWriter("addLineComponent mWayPointList.isEmpty()");
                return;
            }
            ArrayList arrayList = new ArrayList();
            LatLng a = m4539a(this.f7317o.get(0).getAddress());
            if (a != null) {
                arrayList.add(a);
            }
            ArrayList arrayList2 = new ArrayList();
            int size = this.f7317o.size();
            if (size > 1) {
                if (size > 2) {
                    for (int i = 1; i < size - 1; i++) {
                        LatLng a2 = m4539a(this.f7317o.get(i).getAddress());
                        if (a2 != null) {
                            arrayList2.add(a2);
                        }
                    }
                }
                latLng = m4539a(this.f7317o.get(size - 1).getAddress());
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
                CommonLineManager commonLineManager = new CommonLineManager(getContext(), this.f7319q, commonLineParam);
                this.f7313k = commonLineManager;
                commonLineManager.setListener(new OnLineDrawStatusListener() {
                    public /* synthetic */ void onLineDrawStart() {
                        OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                    }

                    public void onLineDrawFinished() {
                        SystemUtils.log(4, OpenRideWayPointFragment.f7303a, "mLineComponent line onRefresh", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideWayPointFragment$4", 336);
                        OpenRideWayPointFragment.this.m4550b();
                    }
                });
                this.f7313k.create();
            }
            m4547a((List<LatLng>) arrayList);
        }
    }

    /* renamed from: a */
    private void m4547a(List<LatLng> list) {
        if (!this.mDestroyed) {
            m4569j();
            int size = this.f7317o.size();
            if (size != 0) {
                ArrayList arrayList = new ArrayList();
                if (size > 0) {
                    m4548a(arrayList, this.f7317o.get(0).getAddress(), "marker_0", R.drawable.waypoint_map_icon_pickup, 10);
                }
                if (size > 2) {
                    for (int i = 1; i < size - 1; i++) {
                        Address address = this.f7317o.get(i).getAddress();
                        m4548a(arrayList, address, "marker_" + i, R.drawable.waypoint_map_icon_stop_point, 8);
                    }
                }
                if (size > 1) {
                    int i2 = size - 1;
                    Address address2 = this.f7317o.get(i2).getAddress();
                    m4548a(arrayList, address2, "marker_" + i2, R.drawable.waypoint_map_icon_dest, 9);
                }
                if (!arrayList.isEmpty()) {
                    MarkersCompParams build = new MarkersCompParams.Builder().markerModels(arrayList).build();
                    MarkersComponent markersComponent = new MarkersComponent();
                    this.f7314l = markersComponent;
                    markersComponent.setConfigParam(build);
                    this.f7314l.create(getActivity(), this.f7319q);
                    if (this.f7317o.size() > 2) {
                        for (int i3 = 1; i3 < this.f7317o.size() - 1; i3++) {
                            m4546a(this.f7317o.get(i3).getAddress(), i3);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m4546a(Address address, int i) {
        if (this.f7314l != null && address != null && m4539a(address) != null) {
            TextView textView = new TextView(getActivity());
            int dp2px = DisplayUtils.dp2px(getActivity(), 5.0f);
            int dp2px2 = DisplayUtils.dp2px(getActivity(), 8.0f);
            textView.setPadding(dp2px2, dp2px, dp2px2, dp2px);
            textView.setBackgroundResource(R.drawable.waypoint_map_bubble_bg_shape);
            String str = "STOP " + i;
            if (i == 1) {
                str = getString(R.string.GRider_Sug_2020_stop1_bubble);
            } else if (i == 2) {
                str = getString(R.string.GRider_Sug_2020_stop2_bubble);
            }
            textView.setText(str);
            textView.setTextColor(-16777216);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(11.0f);
            this.f7314l.showMarkerInfoWindow("marker_" + i, textView);
        }
    }

    /* renamed from: a */
    private void m4548a(List<MarkerModel> list, Address address, String str, int i, int i2) {
        LatLng a = m4539a(address);
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
    /* renamed from: g */
    public void m4563g() {
        ImageView imageView;
        if (this.f7319q != null && (imageView = this.f7306d) != null) {
            imageView.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            CommonLineManager commonLineManager = this.f7313k;
            if (!(commonLineManager == null || commonLineManager.getBestViewElements() == null)) {
                arrayList.addAll(this.f7313k.getBestViewElements());
            }
            IMarkersCompContract iMarkersCompContract = this.f7314l;
            if (!(iMarkersCompContract == null || iMarkersCompContract.getMarkers() == null)) {
                arrayList.addAll(this.f7314l.getMarkers());
            }
            if (SugSharedMapView.getInstance(getActivity()).getMyLocationMarkers() != null) {
                arrayList.addAll(SugSharedMapView.getInstance(getActivity()).getMyLocationMarkers());
            }
            if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                BestViewer.doBestView(this.f7319q, true, (List<IMapElement>) arrayList, this.f7320r, new Padding(DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f)), (BestViewer.IBestViewListener) null);
            }
        }
    }

    public void updateAddStopEnterVisible(WayPoint wayPoint, boolean z) {
        if (this.f7317o.contains(wayPoint)) {
            List<WayPoint> list = this.f7317o;
            list.get(list.indexOf(wayPoint)).setCanAdd(z);
            this.f7309g.clearGuideView();
            m4557d();
            this.f7309g.notifyDataSetChanged();
        }
    }

    public void onWayPointsUpdated() {
        logWriter("onWayPointsUpdated start...");
        if (!this.mDestroyed && this.f7319q != null) {
            logWriter("onWayPointsUpdated removeCallbacksAndMessages before");
            this.f7321s.removeCallbacksAndMessages((Object) null);
            logWriter("onWayPointsUpdated removeCallbacksAndMessages after");
            this.f7321s.postDelayed(new Runnable() {
                public final void run() {
                    OpenRideWayPointFragment.this.m4571k();
                }
            }, 300);
            logWriter("onWayPointsUpdated removeCallbacksAndMessages postDelayed after");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void m4571k() {
        logWriter("onWayPointsUpdated size=" + this.f7317o.size());
        if (!this.f7318p) {
            m4565h();
        }
    }

    /* renamed from: h */
    private void m4565h() {
        m4560f();
        m4550b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4542a(View view) {
        if (view.getId() == this.f7305c.getId() && !ViewFastDoubleClickInterceptor.isFastClick()) {
            FragmentActivity fragmentActivity = getActivity() != null ? (FragmentActivity) getActivity() : null;
            if (getSugCallback() != null) {
                setSubmitEnable(false);
                this.f7316n.sortWayPoints();
                if (CommonUtils.checkDuplicate((ArrayList) this.f7316n.getValidWayPoints())) {
                    CommonUtils.showDuplicateAlert(getContext());
                    this.f7305c.setEnabled(true);
                    return;
                }
                getSugCallback().onSubmitWayPoints(fragmentActivity, this.f7316n.getValidWayPoints(), this.f7316n.getChangedWayPoints(), new IWayPointsPostCallback() {
                    public void onSuccess() {
                        OpenRideWayPointFragment.this.setSubmitEnable(true);
                        OpenRideWayPointFragment.this.closeSessionImediately();
                        OpenRideWayPointFragment.this.logWriter("wayPoint Submit Success");
                    }

                    public void onFailure(String str) {
                        OpenRideWayPointFragment.this.setSubmitEnable(true);
                        OpenRideWayPointFragment.this.logWriter("wayPoint Submit Failure");
                    }
                });
                AddressTrack.trackWayPointConfirmCK(this.f7316n.getValidWayPoints());
            }
        }
    }

    public void setSubmitEnable(boolean z) {
        this.f7305c.setEnabled(z);
    }

    public boolean addWayPoint(WayPoint wayPoint) {
        logWriter("addWayPoint");
        if (wayPoint == null) {
            return false;
        }
        m4557d();
        int a = m4536a(wayPoint);
        if (a >= 0) {
            this.f7309g.setItemAnimFlag(true);
            this.f7309g.notifyItemInserted(a);
        }
        return true;
    }

    public boolean removeWayPoint(WayPoint wayPoint) {
        logWriter("removeWayPoint");
        if (wayPoint == null || !this.f7317o.contains(wayPoint) || !this.f7317o.contains(wayPoint)) {
            return false;
        }
        this.f7317o.remove(wayPoint);
        this.f7309g.setItemAnimFlag(false);
        onWayPointsUpdated();
        return true;
    }

    public void resetWayPointList() {
        this.f7309g.clearGuideView();
        this.f7309g.updateDataType();
    }

    /* renamed from: a */
    private int m4536a(WayPoint wayPoint) {
        int i;
        logWriter("insertWayPoint");
        if (wayPoint != null) {
            boolean z = false;
            boolean z2 = false;
            for (WayPoint next : this.f7317o) {
                if (next.getWayPointType() == 1) {
                    z = true;
                } else if (next.getWayPointType() == 3) {
                    z2 = true;
                }
            }
            int wayPointType = wayPoint.getWayPointType();
            if (wayPointType == 1) {
                if (z) {
                    this.f7317o.remove(0);
                }
                this.f7317o.add(0, wayPoint);
                return 0;
            } else if (wayPointType == 2) {
                if (z2) {
                    i = this.f7317o.size() - 1;
                } else {
                    i = this.f7317o.size();
                }
                this.f7317o.add(i, wayPoint);
                return i;
            } else if (wayPointType == 3) {
                if (z2) {
                    List<WayPoint> list = this.f7317o;
                    list.remove(list.size() - 1);
                }
                int size = this.f7317o.size();
                List<WayPoint> list2 = this.f7317o;
                list2.add(list2.size(), wayPoint);
                return size;
            }
        }
        return -1;
    }

    public boolean updateWayPoint(WayPoint wayPoint) {
        logWriter("updateWayPoint");
        if (wayPoint == null) {
            return false;
        }
        m4557d();
        if (this.f7317o.contains(wayPoint)) {
            if (!CommonUtils.checkDuplicate((ArrayList) this.f7317o)) {
                this.f7309g.clearGuideView();
                this.f7309g.notifyDataSetChanged();
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
        return this.f7310h;
    }

    /* renamed from: i */
    private void m4567i() {
        CommonLineManager commonLineManager = this.f7313k;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f7313k = null;
        }
    }

    /* renamed from: j */
    private void m4569j() {
        IMarkersCompContract iMarkersCompContract = this.f7314l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f7314l = null;
        }
    }

    public void onDestroyView() {
        logWriter("onDestroyView");
        this.f7318p = true;
        Handler handler = this.f7321s;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        SugWayPointListViewAdapter sugWayPointListViewAdapter = this.f7309g;
        if (sugWayPointListViewAdapter != null) {
            sugWayPointListViewAdapter.clearGuideView();
        }
        m4569j();
        m4567i();
        View view = this.f7304b;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f7324v);
        }
        SugSharedMapView.getInstance(getActivity()).onRemove(this.f7308f);
        super.onDestroyView();
    }

    public boolean onBackPressed() {
        if (getActivity().isFinishing()) {
            return false;
        }
        getActivity().finish();
        return false;
    }

    public IFragment.ParentNode getNodeType() {
        return IFragment.ParentNode.WAYPOINT;
    }
}
