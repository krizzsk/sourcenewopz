package com.didi.map.global.flow.scene.minibus.scene.pre;

import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.minibus.scene.BaseMiniBusScene;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.env.PaxEnvironment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 3001)
public class MiniBusConfirmScene extends BaseMiniBusScene<MiniBusConfirmSceneParam> implements IMiniBusConfirmSceneController {

    /* renamed from: a */
    private MarkersComponent f26379a;

    /* renamed from: b */
    private MiniBusLineGroupComponent f26380b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f26381c = 0;

    public MiniBusConfirmScene(MiniBusConfirmSceneParam miniBusConfirmSceneParam, MapViewHolder mapViewHolder) {
        super(miniBusConfirmSceneParam, mapViewHolder);
        if (miniBusConfirmSceneParam != null) {
            miniBusConfirmSceneParam.systemOutLog();
        }
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (this.mParam != null) {
            MiniBusParamInterface miniBusParamInterface = ((MiniBusConfirmSceneParam) this.mParam).getMiniBusParamInterface();
            List<CommonLineParam> miniBusLineParam = miniBusParamInterface.getMiniBusLineParam();
            List<CommonMarkerParam> miniBusMarkerParam = miniBusParamInterface.getMiniBusMarkerParam();
            m18701a(miniBusLineParam);
            initMarkerComponent(miniBusMarkerParam);
        }
    }

    public void leave() {
        super.leave();
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26380b;
        if (miniBusLineGroupComponent != null) {
            miniBusLineGroupComponent.destroy();
        }
        MarkersComponent markersComponent = this.f26379a;
        if (markersComponent != null) {
            markersComponent.destroy();
        }
    }

    public void doBestView(Padding padding, int i) {
        doBestView(padding);
        this.f26381c = i;
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            if (this.f26379a != null) {
                arrayList.addAll(m18700a(MapElementId.ID_MARKER_PICK_UP));
                arrayList.addAll(m18700a(MapElementId.ID_MARKER_START));
            }
            MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26380b;
            if (miniBusLineGroupComponent != null) {
                arrayList.addAll(miniBusLineGroupComponent.getBestViewElements(MapElementId.ID_LINE_START_PICKUP.name()));
            }
        } else if (i == 1) {
            if (this.f26379a != null) {
                arrayList.addAll(m18700a(MapElementId.ID_MARKER_DROP_OFF));
                arrayList.addAll(m18700a(MapElementId.ID_MARKER_END));
            }
            MiniBusLineGroupComponent miniBusLineGroupComponent2 = this.f26380b;
            if (miniBusLineGroupComponent2 != null) {
                arrayList.addAll(miniBusLineGroupComponent2.getBestViewElements(MapElementId.ID_LINE_DROPOFF_END.name()));
            }
        }
        BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, getDefaultPadding(), (BestViewer.IBestViewListener) null);
    }

    /* renamed from: a */
    private List<IMapElement> m18700a(MapElementId mapElementId) {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f26379a;
        if (!(markersComponent == null || mapElementId == null)) {
            List<Marker> markers = markersComponent.getMarkers(mapElementId.name());
            if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
                arrayList.addAll(markers);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m18701a(List<CommonLineParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f26380b = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setConfigParam(list, 1);
            this.f26380b.setProductId(PaxEnvironment.getInstance().getProductId());
            this.f26380b.create(getContext(), getMap());
            this.f26380b.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    MiniBusConfirmScene miniBusConfirmScene = MiniBusConfirmScene.this;
                    miniBusConfirmScene.doBestView(miniBusConfirmScene.mPadding, MiniBusConfirmScene.this.f26381c);
                }
            });
            this.f26380b.start();
        }
    }

    public void initMarkerComponent(List<CommonMarkerParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f26379a = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam paramConvertToMarkerModel : list) {
                MarkerModel paramConvertToMarkerModel2 = paramConvertToMarkerModel(paramConvertToMarkerModel);
                if (paramConvertToMarkerModel2 != null) {
                    arrayList.add(paramConvertToMarkerModel2);
                }
            }
            this.f26379a.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f26379a.create(getContext(), getMap());
        }
    }
}
