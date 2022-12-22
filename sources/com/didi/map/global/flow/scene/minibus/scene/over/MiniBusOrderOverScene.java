package com.didi.map.global.flow.scene.minibus.scene.over;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.data.param.OrderTrajLineRequest;
import com.didi.map.global.component.line.pax.over.OrderTrajLineManager;
import com.didi.map.global.component.line.pax.over.OrderTrajParam;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavConfirmDialog;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavErrorHintDialog;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.BaseMiniBusScene;
import com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.LaunchExternalMapUtil;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 3005)
public class MiniBusOrderOverScene extends BaseMiniBusScene<MiniBusOrderOverSceneParam> implements IMiniBusOrderOverSceneController {

    /* renamed from: a */
    private final String f26363a = "MiniBusOrderOverScene";

    /* renamed from: b */
    private MiniBusOrderOverSceneParam.SceneOverType f26364b;

    /* renamed from: c */
    private MarkersComponent f26365c;

    /* renamed from: d */
    private MiniBusLineGroupComponent f26366d;

    /* renamed from: e */
    private IconLabelMarker f26367e;

    /* renamed from: f */
    private List<ICompLineContract> f26368f;

    /* renamed from: g */
    private List<CommonMarkerParam> f26369g;

    /* renamed from: h */
    private List<CommonLineParam> f26370h;

    /* renamed from: i */
    private JumpNavConfirmDialog f26371i;

    /* renamed from: j */
    private JumpNavErrorHintDialog f26372j;

    /* renamed from: k */
    private OrderTrajLineManager f26373k;

    public MiniBusOrderOverScene(MiniBusOrderOverSceneParam miniBusOrderOverSceneParam, MapViewHolder mapViewHolder) {
        super(miniBusOrderOverSceneParam, mapViewHolder);
        if (miniBusOrderOverSceneParam != null) {
            miniBusOrderOverSceneParam.systemOutLog();
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (this.mParam != null) {
            this.f26364b = ((MiniBusOrderOverSceneParam) this.mParam).getSceneType() == null ? MiniBusOrderOverSceneParam.SceneOverType.COMMON_TYPE : ((MiniBusOrderOverSceneParam) this.mParam).getSceneType();
            View endNavView = ((MiniBusOrderOverSceneParam) this.mParam).getEndNavView();
            MiniBusParamInterface miniBusParamInterface = ((MiniBusOrderOverSceneParam) this.mParam).getMiniBusParamInterface();
            if (miniBusParamInterface != null) {
                this.f26370h = miniBusParamInterface.getMiniBusLineParam();
                this.f26369g = miniBusParamInterface.getMiniBusMarkerParam();
            }
            initMarkerComponent(this.f26369g);
            int i = C96513.f26374x356e7dc1[this.f26364b.ordinal()];
            if (i == 1) {
                if (this.mMapView != null) {
                    this.mMapView.setLocationVisible(true);
                }
                m18691a(this.f26370h);
                if (endNavView != null) {
                    this.f26367e = m18688a(endNavView);
                    getMap().addOnMarkerClickListener(new OnMarkerClickListener() {
                        public final boolean onMarkerClick(Marker marker) {
                            return MiniBusOrderOverScene.this.m18692a(marker);
                        }
                    });
                }
            } else if (i == 2) {
                if (this.mMapView != null) {
                    this.mMapView.setLocationVisible(false);
                }
                m18697b(this.f26370h);
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverScene$3 */
    static /* synthetic */ class C96513 {

        /* renamed from: $SwitchMap$com$didi$map$global$flow$scene$minibus$scene$over$MiniBusOrderOverSceneParam$SceneOverType */
        static final /* synthetic */ int[] f26374x356e7dc1;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam$SceneOverType[] r0 = com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam.SceneOverType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26374x356e7dc1 = r0
                com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam$SceneOverType r1 = com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam.SceneOverType.WALKING_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26374x356e7dc1     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam$SceneOverType r1 = com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam.SceneOverType.COMMON_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverScene.C96513.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m18692a(Marker marker) {
        IconLabelMarker iconLabelMarker = this.f26367e;
        if (iconLabelMarker == null || iconLabelMarker.getIconMarker() == null || marker == null || marker != this.f26367e.getIconMarker()) {
            return false;
        }
        m18689a();
        return true;
    }

    public void leave() {
        super.leave();
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f26371i;
        if (jumpNavConfirmDialog != null) {
            if (jumpNavConfirmDialog.isShowing()) {
                this.f26371i.dismiss();
            }
            this.f26371i = null;
        }
        JumpNavErrorHintDialog jumpNavErrorHintDialog = this.f26372j;
        if (jumpNavErrorHintDialog != null) {
            if (jumpNavErrorHintDialog.isShowing()) {
                this.f26372j.dismiss();
            }
            this.f26372j = null;
        }
        MarkersComponent markersComponent = this.f26365c;
        if (markersComponent != null) {
            markersComponent.destroy();
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26366d;
        if (miniBusLineGroupComponent != null) {
            miniBusLineGroupComponent.destroy();
        }
        OrderTrajLineManager orderTrajLineManager = this.f26373k;
        if (orderTrajLineManager != null) {
            orderTrajLineManager.destroy();
            this.f26373k = null;
        }
        if (!CollectionUtil.isEmpty((Collection<?>) this.f26368f)) {
            for (ICompLineContract next : this.f26368f) {
                if (next != null) {
                    next.destroy();
                }
            }
        }
        IconLabelMarker iconLabelMarker = this.f26367e;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
        }
        List<ICompLineContract> list = this.f26368f;
        if (list != null) {
            list.clear();
            this.f26368f = null;
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f26365c;
        if (markersComponent != null) {
            arrayList.addAll(markersComponent.getMarkers());
        }
        int i = C96513.f26374x356e7dc1[this.f26364b.ordinal()];
        if (i == 1) {
            MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26366d;
            if (miniBusLineGroupComponent != null && !CollectionUtil.isEmpty((Collection<?>) miniBusLineGroupComponent.getBestViewElements())) {
                arrayList.addAll(this.f26366d.getBestViewElements());
            }
            IconLabelMarker iconLabelMarker = this.f26367e;
            if (iconLabelMarker != null && !CollectionUtil.isEmpty((Collection<?>) iconLabelMarker.getMarkers())) {
                arrayList.addAll(this.f26367e.getMarkers());
            }
        } else if (i == 2) {
            OrderTrajLineManager orderTrajLineManager = this.f26373k;
            if (orderTrajLineManager != null && !CollectionUtil.isEmpty((Collection<?>) orderTrajLineManager.getBestViewElements())) {
                arrayList.addAll(this.f26373k.getBestViewElements());
            }
            if (!CollectionUtil.isEmpty((Collection<?>) this.f26368f)) {
                for (ICompLineContract next : this.f26368f) {
                    if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.getBestViewElements())) {
                        arrayList.addAll(next.getBestViewElements());
                    }
                }
            }
        }
        BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, getDefaultPadding(), (BestViewer.IBestViewListener) null);
    }

    /* renamed from: a */
    private void m18691a(List<CommonLineParam> list) {
        if (list != null && !list.isEmpty()) {
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f26366d = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setProductId(PaxEnvironment.getInstance().getProductId());
            this.f26366d.setConfigParam(list, 3);
            this.f26366d.create(getContext(), getMap());
            this.f26366d.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    MiniBusOrderOverScene miniBusOrderOverScene = MiniBusOrderOverScene.this;
                    miniBusOrderOverScene.doBestView(miniBusOrderOverScene.mPadding);
                }
            });
            this.f26366d.start();
        }
    }

    /* renamed from: b */
    private void m18697b(List<CommonLineParam> list) {
        if (list != null && !list.isEmpty() && !CollectionUtil.isEmpty((Collection<?>) list)) {
            for (CommonLineParam next : list) {
                if (next.getLineMode() == 0) {
                    m18690a(next);
                } else {
                    m18696b(next);
                }
            }
        }
    }

    /* renamed from: a */
    private void m18690a(CommonLineParam commonLineParam) {
        if (commonLineParam != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(commonLineParam.getStartPoint());
            arrayList.add(commonLineParam.getEndPoint());
            LineParams lineParams = new LineParams(arrayList, commonLineParam.getLineColor(), commonLineParam.getLineWidth());
            lineParams.setZIndex(10);
            lineParams.setDotSpace(3.0f);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, getMap(), getContext(), lineParams);
            createLineComponent.start();
            if (this.f26368f == null) {
                this.f26368f = new ArrayList();
            }
            this.f26368f.add(createLineComponent);
        }
    }

    public void initMarkerComponent(List<CommonMarkerParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f26365c = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam paramConvertToMarkerModel : list) {
                MarkerModel paramConvertToMarkerModel2 = paramConvertToMarkerModel(paramConvertToMarkerModel);
                if (paramConvertToMarkerModel2 != null) {
                    arrayList.add(paramConvertToMarkerModel2);
                }
            }
            this.f26365c.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f26365c.create(getContext(), getMap());
        }
    }

    /* renamed from: b */
    private void m18696b(CommonLineParam commonLineParam) {
        MiniBusOrderOverSceneParam.OrderOverCommonTypeParam commonTypeParam;
        OrderTrajLineManager orderTrajLineManager = this.f26373k;
        if (orderTrajLineManager != null) {
            orderTrajLineManager.destroy();
            this.f26373k = null;
        }
        if (this.mParam != null && (commonTypeParam = ((MiniBusOrderOverSceneParam) this.mParam).getCommonTypeParam()) != null) {
            OrderTrajLineRequest orderTrajLineRequest = new OrderTrajLineRequest(CallFrom.ORDERROUTEAPI_BUBBLE, PaxEnvironment.getInstance().getProductId());
            orderTrajLineRequest.driverId = commonTypeParam.getDriverId();
            orderTrajLineRequest.biztype = commonTypeParam.getBizType();
            orderTrajLineRequest.startTime = commonTypeParam.getStartTime();
            orderTrajLineRequest.endTime = commonTypeParam.getEndTime();
            orderTrajLineRequest.passengerPhoneNumber = "";
            orderTrajLineRequest.imei = "";
            orderTrajLineRequest.clientVersion = commonTypeParam.getClientVersion();
            OrderTrajParam orderTrajParam = new OrderTrajParam(orderTrajLineRequest, commonLineParam != null ? commonLineParam.getLineColor() : Color.parseColor("#33BBFF"), commonLineParam != null ? commonLineParam.getLineWidth() : 6, new OnLineDrawStatusListener() {
                public /* synthetic */ void onLineDrawStart() {
                    OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                }

                public void onLineDrawFinished() {
                    if (MiniBusOrderOverScene.this.getMap() != null) {
                        MiniBusOrderOverScene miniBusOrderOverScene = MiniBusOrderOverScene.this;
                        miniBusOrderOverScene.doBestView(miniBusOrderOverScene.mPadding);
                    }
                }
            });
            OrderTrajLineManager orderTrajLineManager2 = new OrderTrajLineManager();
            this.f26373k = orderTrajLineManager2;
            orderTrajLineManager2.create(getContext(), getMap(), orderTrajParam);
        }
    }

    /* renamed from: a */
    private IconLabelMarker m18688a(View view) {
        MarkerModel b;
        if (view == null || (b = m18694b(view)) == null) {
            return null;
        }
        return new IconLabelMarker(getMap(), b.getId(), getContext()).create(new IconLabelMarker.IconLabelMarkerInfo.Builder().latlng(b.getPoint()).markerIcon(b.getMarkerIcon()).markerIconAnchorU(b.getAnchorU()).markerIconAnchorV(b.getAnchorV()).markerIconZIndex(b.getZOrder()).isClickable(true).build());
    }

    /* renamed from: b */
    private MarkerModel m18694b(View view) {
        Bitmap viewBitmap;
        if (this.f26365c == null || view == null || (viewBitmap = MapUtils.getViewBitmap(view)) == null) {
            return null;
        }
        LatLng position = this.f26365c.getPosition(MapElementId.ID_MARKER_END.name());
        if (!LatLngUtils.locateCorrect(position)) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        markerModel.setId(MapElementId.ID_MARKER_END_NAV.name());
        markerModel.setAnchorU(0.5f);
        markerModel.setAnchorV(1.0f);
        markerModel.setZOrder(202);
        markerModel.setPoint(position);
        markerModel.setMarkerIcon(viewBitmap);
        return markerModel;
    }

    /* renamed from: a */
    private void m18689a() {
        boolean isInstallGoogleMap = LaunchExternalMapUtil.isInstallGoogleMap(getContext());
        if (this.mParam == null || ((MiniBusOrderOverSceneParam) this.mParam).getContext() == null) {
            DLog.m7384d("MiniBusOrderOverScene", "弹窗依赖context 为null", new Object[0]);
        } else if (isInstallGoogleMap) {
            if (this.f26371i == null) {
                JumpNavConfirmDialog jumpNavConfirmDialog = new JumpNavConfirmDialog(((MiniBusOrderOverSceneParam) this.mParam).getContext());
                this.f26371i = jumpNavConfirmDialog;
                jumpNavConfirmDialog.setOnConfirmClickListener(new JumpNavConfirmDialog.OnConfirmClickListener() {
                    public final void onConfirm() {
                        MiniBusOrderOverScene.this.m18695b();
                    }
                });
            }
            SystemUtils.showDialog(this.f26371i);
        } else {
            if (this.f26372j == null) {
                this.f26372j = new JumpNavErrorHintDialog(((MiniBusOrderOverSceneParam) this.mParam).getContext());
            }
            SystemUtils.showDialog(this.f26372j);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18695b() {
        List<CommonMarkerParam> list = this.f26369g;
        LatLng latLng = null;
        if (list != null) {
            for (CommonMarkerParam next : list) {
                if (next != null && MapElementId.ID_MARKER_END == next.getId()) {
                    latLng = next.getPoint();
                }
            }
        }
        if (LatLngUtils.locateCorrect(latLng)) {
            LaunchExternalMapUtil.launchGoogleMapWithWalkNav(getContext(), latLng, LaunchExternalMapUtil.NavMode.WALKING);
        } else {
            DLog.m7384d("MiniBusOrderOverScene", "导航目标点坐标异常", new Object[0]);
        }
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f26371i;
        if (jumpNavConfirmDialog != null) {
            jumpNavConfirmDialog.dismiss();
        }
    }
}
