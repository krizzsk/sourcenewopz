package com.didi.map.global.flow.scene.minibus.scene.service;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavConfirmDialog;
import com.didi.map.global.flow.scene.minibus.dialog.JumpNavErrorHintDialog;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.BaseMiniBusScene;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.LaunchExternalMapUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 3002)
public class MiniBusAppointScene extends BaseMiniBusScene<MiniBusAppointParam> implements ISceneController {

    /* renamed from: a */
    private String f26397a = "MiniBusAppointScene";

    /* renamed from: b */
    private MarkersComponent f26398b;

    /* renamed from: c */
    private MiniBusLineGroupComponent f26399c;

    /* renamed from: d */
    private IconLabelMarker f26400d;

    /* renamed from: e */
    private JumpNavConfirmDialog f26401e;

    /* renamed from: f */
    private JumpNavErrorHintDialog f26402f;

    /* renamed from: g */
    private List<CommonLineParam> f26403g;

    /* renamed from: h */
    private List<CommonMarkerParam> f26404h;

    /* renamed from: i */
    private MiniBusTripSceneState f26405i;

    public MiniBusAppointScene(MiniBusAppointParam miniBusAppointParam, MapViewHolder mapViewHolder) {
        super(miniBusAppointParam, mapViewHolder);
        if (miniBusAppointParam != null) {
            miniBusAppointParam.systemOutLog();
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (this.mParam != null) {
            MiniBusParamInterface miniBusParamInterface = ((MiniBusAppointParam) this.mParam).getMiniBusParamInterface();
            this.f26405i = ((MiniBusAppointParam) this.mParam).getSceneState();
            this.f26403g = miniBusParamInterface.getMiniBusLineParam();
            this.f26404h = miniBusParamInterface.getMiniBusMarkerParam();
            if (this.f26405i == MiniBusTripSceneState.STATE_ETA_BELOW_25) {
                m18739a(this.f26403g);
                initMarkerComponentForETALessThen25(this.f26404h);
                this.f26400d = m18744c();
                return;
            }
            m18743b(this.f26403g);
            initMarkerComponentForETAMoreThen25(this.f26404h);
        }
    }

    /* renamed from: a */
    private void m18737a() {
        boolean isInstallGoogleMap = LaunchExternalMapUtil.isInstallGoogleMap(getContext());
        if (this.mParam == null || ((MiniBusAppointParam) this.mParam).getContext() == null) {
            DLog.m7384d(this.f26397a, "弹窗依赖context 为null", new Object[0]);
        } else if (isInstallGoogleMap) {
            if (this.f26401e == null) {
                JumpNavConfirmDialog jumpNavConfirmDialog = new JumpNavConfirmDialog(((MiniBusAppointParam) this.mParam).getContext());
                this.f26401e = jumpNavConfirmDialog;
                jumpNavConfirmDialog.setOnConfirmClickListener(new JumpNavConfirmDialog.OnConfirmClickListener() {
                    public final void onConfirm() {
                        MiniBusAppointScene.this.m18746e();
                    }
                });
            }
            SystemUtils.showDialog(this.f26401e);
        } else {
            if (this.f26401e == null) {
                this.f26402f = new JumpNavErrorHintDialog(((MiniBusAppointParam) this.mParam).getContext());
            }
            SystemUtils.showDialog(this.f26402f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m18746e() {
        List<CommonMarkerParam> list = this.f26404h;
        LatLng latLng = null;
        if (list != null) {
            for (CommonMarkerParam next : list) {
                if (next != null && MapElementId.ID_MARKER_PICK_UP == next.getId()) {
                    latLng = next.getPoint();
                }
            }
        }
        if (LatLngUtils.locateCorrect(latLng)) {
            LaunchExternalMapUtil.launchGoogleMapWithWalkNav(getContext(), latLng, LaunchExternalMapUtil.NavMode.WALKING);
        } else {
            DLog.m7384d(this.f26397a, "导航目标点坐标异常", new Object[0]);
        }
        LaunchExternalMapUtil.launchGoogleMapWithWalkNav(getContext(), latLng, LaunchExternalMapUtil.NavMode.WALKING);
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f26401e;
        if (jumpNavConfirmDialog != null) {
            jumpNavConfirmDialog.dismiss();
        }
    }

    public void leave() {
        super.leave();
        MarkersComponent markersComponent = this.f26398b;
        if (markersComponent != null) {
            markersComponent.destroy();
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26399c;
        if (miniBusLineGroupComponent != null) {
            miniBusLineGroupComponent.destroy();
        }
        IconLabelMarker iconLabelMarker = this.f26400d;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
        }
        JumpNavConfirmDialog jumpNavConfirmDialog = this.f26401e;
        if (jumpNavConfirmDialog != null) {
            if (jumpNavConfirmDialog.isShowing()) {
                this.f26401e.dismiss();
            }
            this.f26401e = null;
        }
        JumpNavErrorHintDialog jumpNavErrorHintDialog = this.f26402f;
        if (jumpNavErrorHintDialog != null) {
            if (jumpNavErrorHintDialog.isShowing()) {
                this.f26402f.dismiss();
            }
            this.f26402f = null;
        }
    }

    public void initMarkerComponentForETALessThen25(List<CommonMarkerParam> list) {
        MarkerModel paramConvertToMarkerModel;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f26398b = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam next : list) {
                if (!(next == null || MapElementId.ID_MARKER_PICK_UP != next.getId() || (paramConvertToMarkerModel = paramConvertToMarkerModel(next)) == null)) {
                    arrayList.add(paramConvertToMarkerModel);
                }
            }
            this.f26398b.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f26398b.create(getContext(), getMap());
        }
    }

    public void initMarkerComponentForETAMoreThen25(List<CommonMarkerParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f26398b = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam paramConvertToMarkerModel : list) {
                MarkerModel paramConvertToMarkerModel2 = paramConvertToMarkerModel(paramConvertToMarkerModel);
                if (paramConvertToMarkerModel2 != null) {
                    arrayList.add(paramConvertToMarkerModel2);
                }
            }
            this.f26398b.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f26398b.create(getContext(), getMap());
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.f26405i == MiniBusTripSceneState.STATE_ETA_BELOW_25) {
            m18742b(padding);
        } else {
            m18738a(padding);
        }
    }

    /* renamed from: a */
    private void m18738a(Padding padding) {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f26398b;
        if (markersComponent != null) {
            arrayList.addAll(markersComponent.getMarkers());
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26399c;
        if (miniBusLineGroupComponent != null) {
            arrayList.addAll(miniBusLineGroupComponent.getBestViewElements());
        }
        BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, getDefaultPadding(), (BestViewer.IBestViewListener) null);
    }

    /* renamed from: b */
    private void m18742b(Padding padding) {
        ArrayList arrayList = new ArrayList();
        if (this.mMapView != null) {
            List<IMapElement> myLocationMarkers = this.mMapView.getMyLocationMarkers();
            if (!CollectionUtil.isEmpty((Collection<?>) myLocationMarkers)) {
                arrayList.addAll(myLocationMarkers);
            }
        }
        List<IMapElement> a = m18736a(MapElementId.ID_MARKER_PICK_UP.name());
        if (!CollectionUtil.isEmpty((Collection<?>) a)) {
            arrayList.addAll(a);
        }
        IconLabelMarker iconLabelMarker = this.f26400d;
        if (iconLabelMarker != null && !CollectionUtil.isEmpty((Collection<?>) iconLabelMarker.getMarkers())) {
            arrayList.addAll(this.f26400d.getMarkers());
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26399c;
        if (miniBusLineGroupComponent != null) {
            List<IMapElement> bestViewElements = miniBusLineGroupComponent.getBestViewElements(MapElementId.ID_LINE_START_PICKUP.name());
            if (!CollectionUtil.isEmpty((Collection<?>) bestViewElements)) {
                arrayList.addAll(bestViewElements);
            }
        }
        BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, getDefaultPadding(), (BestViewer.IBestViewListener) null);
    }

    /* renamed from: b */
    private LatLng m18740b() {
        try {
            if (this.mParam == null || ((MiniBusAppointParam) this.mParam).getContext() == null) {
                return null;
            }
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(((MiniBusAppointParam) this.mParam).getContext());
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            DLog.m7384d(this.f26397a, "getPassengerLatLng is null", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    private List<IMapElement> m18736a(String str) {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f26398b;
        if (markersComponent != null) {
            List<Marker> markers = markersComponent.getMarkers(str);
            if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
                arrayList.addAll(markers);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m18739a(List<CommonLineParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (CommonLineParam next : list) {
                if (next != null && MapElementId.ID_LINE_START_PICKUP == next.getId()) {
                    LatLng b = m18740b();
                    if (b != null) {
                        next.setStartPoint(b);
                    }
                    next.setAnimate(true);
                    if (!(next.getStartPoint() == null || next.getEndPoint() == null)) {
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(next.getStartPoint(), next.getEndPoint());
                        String str = this.f26397a;
                        DLog.m7384d(str, "乘客位置和上车点之间的距离：" + computeDistanceBetween, new Object[0]);
                    }
                }
            }
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f26399c = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setConfigParam(list, 2);
            this.f26399c.setDidiVersion(PaxEnvironment.getInstance().getAppVersion());
            this.f26399c.setProductId(PaxEnvironment.getInstance().getProductId());
            this.f26399c.setOrderStage(3);
            this.f26399c.create(getContext(), getMap());
            this.f26399c.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    MiniBusAppointScene miniBusAppointScene = MiniBusAppointScene.this;
                    miniBusAppointScene.doBestView(miniBusAppointScene.mPadding);
                }
            });
            this.f26399c.start();
        }
    }

    /* renamed from: b */
    private void m18743b(List<CommonLineParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f26399c = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setConfigParam(list, 2);
            this.f26399c.setProductId(PaxEnvironment.getInstance().getProductId());
            this.f26399c.create(getContext(), getMap());
            this.f26399c.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    MiniBusAppointScene miniBusAppointScene = MiniBusAppointScene.this;
                    miniBusAppointScene.doBestView(miniBusAppointScene.mPadding);
                }
            });
            this.f26399c.start();
        }
    }

    /* renamed from: c */
    private IconLabelMarker m18744c() {
        MarkerModel d = m18745d();
        if (d == null) {
            return null;
        }
        return new IconLabelMarker(getMap(), d.getId(), getContext()).create(new IconLabelMarker.IconLabelMarkerInfo.Builder().latlng(d.getPoint()).markerIcon(d.getMarkerIcon()).markerIconAnchorU(d.getAnchorU()).markerIconAnchorV(d.getAnchorV()).markerIconZIndex(d.getZOrder()).isClickable(true).build());
    }

    /* renamed from: d */
    private MarkerModel m18745d() {
        List<CommonMarkerParam> list;
        if (this.f26398b == null || getContext() == null || getMap() == null || (list = this.f26404h) == null) {
            return null;
        }
        CommonMarkerParam commonMarkerParam = null;
        for (CommonMarkerParam next : list) {
            if (next != null && next.getId() == MapElementId.ID_MARKER_PICK_UP) {
                commonMarkerParam = next;
            }
        }
        if (commonMarkerParam == null) {
            return null;
        }
        View inflate = View.inflate(getContext(), R.layout.map_comp_layout_minibus_appoint_bubble_view, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_content)).setText(TextUtils.isEmpty(commonMarkerParam.getAddressName()) ? "" : commonMarkerParam.getAddressName());
        Bitmap viewBitmap = MapUtils.getViewBitmap(inflate);
        if (viewBitmap == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        markerModel.setId(MapElementId.ID_MARKER_START_NAV.name());
        markerModel.setAnchorU(-0.05f);
        markerModel.setAnchorV(1.1f);
        markerModel.setZOrder(204);
        markerModel.setPoint(commonMarkerParam.getPoint());
        markerModel.setMarkerIcon(viewBitmap);
        markerModel.setClickable(false);
        return markerModel;
    }
}
