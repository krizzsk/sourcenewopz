package com.didi.map.global.flow.scene.minibus.scene.pre;

import android.content.Context;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig;
import com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MiniBusOrderBubbleSceneController {

    /* renamed from: a */
    private Context f26383a;

    /* renamed from: b */
    private Map f26384b;

    /* renamed from: c */
    private MarkersComponent f26385c;

    /* renamed from: d */
    private MiniBusLineGroupComponent f26386d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Padding f26387e;

    public MiniBusOrderBubbleSceneController(Context context, Map map) {
        this.f26383a = context;
        this.f26384b = map;
    }

    public boolean doBestView(Padding padding) {
        this.f26387e = padding;
        DLog.m7384d("MiniBusOrderBubbleSceneController", "小巴最佳视野", new Object[0]);
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f26385c;
        if (markersComponent != null) {
            arrayList.addAll(markersComponent.getMarkers());
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26386d;
        if (miniBusLineGroupComponent != null) {
            arrayList.addAll(miniBusLineGroupComponent.getBestViewElements());
        }
        BestViewer.doBestView(this.f26384b, true, (List<IMapElement>) arrayList, padding, (Padding) null, (BestViewer.IBestViewListener) null);
        return true;
    }

    public void onDestroy() {
        DLog.m7384d("MiniBusOrderBubbleSceneController", "小巴销毁元素", new Object[0]);
        MarkersComponent markersComponent = this.f26385c;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f26385c = null;
        }
        MiniBusLineGroupComponent miniBusLineGroupComponent = this.f26386d;
        if (miniBusLineGroupComponent != null) {
            miniBusLineGroupComponent.destroy();
            this.f26386d = null;
        }
    }

    public void onChangeMiniBusCar(MiniBusParamInterface miniBusParamInterface) {
        systemOutLog(miniBusParamInterface);
        if (miniBusParamInterface != null) {
            List<CommonLineParam> miniBusLineParam = miniBusParamInterface.getMiniBusLineParam();
            List<CommonMarkerParam> configMarkerParam = MiniBusMarkerConfig.getConfigMarkerParam(miniBusParamInterface.getMiniBusMarkerParam());
            m18707b(miniBusLineParam);
            m18706a(configMarkerParam);
        }
    }

    public void systemOutLog(MiniBusParamInterface miniBusParamInterface) {
        if (miniBusParamInterface != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("marker参数内容");
            for (CommonMarkerParam next : miniBusParamInterface.getMiniBusMarkerParam()) {
                if (next != null) {
                    sb.append(next.toString());
                }
            }
            DLog.m7384d("MiniBusOrderBubble->marker->", sb.toString(), new Object[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("line参数内容");
            for (CommonLineParam next2 : miniBusParamInterface.getMiniBusLineParam()) {
                if (next2 != null) {
                    sb2.append(next2.toString());
                }
            }
            DLog.m7384d("MiniBusOrderBubble->line->->", sb2.toString(), new Object[0]);
        }
    }

    /* renamed from: a */
    private void m18706a(List<CommonMarkerParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f26385c = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            for (CommonMarkerParam a : list) {
                MarkerModel a2 = m18705a(a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            this.f26385c.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f26385c.create(this.f26383a, this.f26384b);
        }
    }

    /* renamed from: b */
    private void m18707b(List<CommonLineParam> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            MiniBusLineGroupComponent miniBusLineGroupComponent = new MiniBusLineGroupComponent();
            this.f26386d = miniBusLineGroupComponent;
            miniBusLineGroupComponent.setConfigParam(list, 0);
            this.f26386d.create(this.f26383a, this.f26384b);
            this.f26386d.setLineDateListener(new MiniBusLineGroupComponent.LineDateListener() {
                public void onLineDateRequestSuccess() {
                    if (MiniBusOrderBubbleSceneController.this.f26387e != null) {
                        MiniBusOrderBubbleSceneController miniBusOrderBubbleSceneController = MiniBusOrderBubbleSceneController.this;
                        miniBusOrderBubbleSceneController.doBestView(miniBusOrderBubbleSceneController.f26387e);
                    }
                }
            });
            this.f26386d.start();
        }
    }

    /* renamed from: a */
    private MarkerModel m18705a(CommonMarkerParam commonMarkerParam) {
        if (commonMarkerParam == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        if (commonMarkerParam.getPoint() != null) {
            markerModel.setPoint(new LatLng(commonMarkerParam.getPoint().latitude, commonMarkerParam.getPoint().longitude));
        }
        markerModel.setAnchorU(commonMarkerParam.getAnchorU());
        markerModel.setAnchorV(commonMarkerParam.getAnchorV());
        markerModel.setMarkerIcon(commonMarkerParam.getMarkerIcon());
        markerModel.setId(commonMarkerParam.getId().name());
        markerModel.setZOrder(commonMarkerParam.getZIndex());
        return markerModel;
    }
}
