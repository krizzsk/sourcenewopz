package com.didi.map.global.flow.scene.order.waiting.p123v2.component;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.pax.commonline.CommonLineManager;
import com.didi.map.global.component.line.pax.commonline.CommonLineParam;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.BreathAnimMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.order.waiting.p123v2.WaitingStartEndParam;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.component.WaitingStartEndComponent */
public class WaitingStartEndComponent implements IBaseComponent<WaitingStartEndParam> {

    /* renamed from: a */
    private static final String f27006a = "WaitingSceneStartEndComponent";

    /* renamed from: b */
    private Context f27007b;

    /* renamed from: c */
    private Map f27008c;

    /* renamed from: d */
    private CommonLineManager f27009d;

    /* renamed from: e */
    private ICompLineContract f27010e;

    /* renamed from: f */
    private BreathAnimMarker f27011f;

    /* renamed from: g */
    private MarkerModel f27012g;

    /* renamed from: h */
    private MarkerModel f27013h;

    /* renamed from: i */
    private List<MarkerModel> f27014i;

    /* renamed from: j */
    private WaitingStartEndParam.WaitingStartEndLineParam f27015j;

    /* renamed from: k */
    private MarkersComponent f27016k;

    public void create(Context context, Map map) {
        this.f27007b = context;
        this.f27008c = map;
    }

    public void destroy() {
        removeLine();
        m19053a();
        this.f27007b = null;
        this.f27008c = null;
    }

    /* renamed from: a */
    private void m19053a() {
        MarkersComponent markersComponent = this.f27016k;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f27016k = null;
        }
        BreathAnimMarker breathAnimMarker = this.f27011f;
        if (breathAnimMarker != null) {
            breathAnimMarker.destroy();
            this.f27011f = null;
        }
        this.f27012g = null;
        this.f27013h = null;
    }

    public void removeLine() {
        CommonLineManager commonLineManager = this.f27009d;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f27009d = null;
        }
        ICompLineContract iCompLineContract = this.f27010e;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f27010e = null;
        }
    }

    public void setConfigParam(WaitingStartEndParam waitingStartEndParam) {
        if (waitingStartEndParam != null) {
            this.f27012g = waitingStartEndParam.getStartMarkerModel();
            this.f27013h = waitingStartEndParam.getEndMarkerModel();
            this.f27015j = waitingStartEndParam.getLineCompParams();
            this.f27014i = waitingStartEndParam.getWayPointsModels();
        }
    }

    public void onMapVisible(boolean z) {
        CommonLineManager commonLineManager = this.f27009d;
        if (commonLineManager != null) {
            commonLineManager.setLineVisible(z);
        }
        ICompLineContract iCompLineContract = this.f27010e;
        if (iCompLineContract != null) {
            iCompLineContract.onMapVisible(z);
        }
    }

    public void start() {
        if (this.f27007b != null && this.f27008c != null) {
            ArrayList arrayList = new ArrayList();
            MarkerModel markerModel = this.f27012g;
            if (markerModel != null) {
                if (this.f27011f == null && markerModel.getPoint() != null) {
                    this.f27011f = new BreathAnimMarker();
                    this.f27011f.setConfigParam(new BreathAnimMarker.BreathMarkerParam(this.f27012g, 1000, 1.0f, 1.2f));
                    this.f27011f.create(this.f27007b, this.f27008c);
                    DLog.m7384d(f27006a, "startPoint--->lat" + this.f27012g.getPoint().latitude + "long" + this.f27012g.getPoint().longitude, new Object[0]);
                }
                startPointAnimControl(true);
            }
            MarkerModel markerModel2 = this.f27013h;
            if (!(markerModel2 == null || markerModel2.getPoint() == null)) {
                this.f27013h.setAddressName("");
                DLog.m7384d(f27006a, "endPoint--->lat" + this.f27013h.getPoint().latitude + "long" + this.f27013h.getPoint().longitude, new Object[0]);
                arrayList.add(this.f27013h);
            }
            m19054b();
            List<MarkerModel> list = this.f27014i;
            if (list != null) {
                for (MarkerModel next : list) {
                    next.setZOrder(next.getZOrder());
                    if (!(next == null || next.getPoint() == null)) {
                        DLog.m7384d(f27006a, "wayPoint--->lat" + next.getPoint().latitude + "long" + next.getPoint().longitude, new Object[0]);
                        next.setAddressName("");
                        arrayList.add(next);
                    }
                }
            }
            this.f27016k = new MarkersComponent();
            this.f27016k.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f27016k.create(this.f27007b, this.f27008c);
        }
    }

    public void startPointAnimControl(boolean z) {
        BreathAnimMarker breathAnimMarker = this.f27011f;
        if (breathAnimMarker != null) {
            breathAnimMarker.playAnimation(z);
        }
    }

    /* renamed from: b */
    private void m19054b() {
        if (this.f27012g != null && this.f27013h != null && this.f27015j != null && this.f27007b != null && this.f27008c != null) {
            CommonLineManager commonLineManager = this.f27009d;
            if (commonLineManager != null) {
                commonLineManager.destroy();
                this.f27009d = null;
            }
            ArrayList arrayList = new ArrayList();
            List<MarkerModel> list = this.f27014i;
            if (list != null && !list.isEmpty()) {
                for (MarkerModel point : this.f27014i) {
                    arrayList.add(point.getPoint());
                }
            }
            LineParams lineParams = new LineParams((List<LatLng>) null, this.f27015j.getColor(), this.f27015j.getLineWidth());
            lineParams.setZIndex(116);
            LineExParam lineExParam = new LineExParam();
            lineExParam.setHasPulseAnim(true);
            lineExParam.setPulseAnimDuration(this.f27015j.getPulseAnimDuration());
            lineExParam.setHasLineExtensionAnim(false);
            lineExParam.setLineExtensionAnimDuration(this.f27015j.getLineExtensionAnimDuration());
            lineParams.setExParam(lineExParam);
            CommonLineParam commonLineParam = new CommonLineParam();
            commonLineParam.setLineParam(lineParams);
            commonLineParam.setStartPos(this.f27015j.getStartPos());
            commonLineParam.setEndPos(this.f27015j.getEndPos());
            commonLineParam.setCaller(this.f27015j.getCaller());
            commonLineParam.setWayPoints(arrayList);
            CommonLineManager commonLineManager2 = new CommonLineManager(this.f27007b, this.f27008c, commonLineParam);
            this.f27009d = commonLineManager2;
            commonLineManager2.setListener(new OnLineDrawStatusListener() {
                public /* synthetic */ void onLineDrawStart() {
                    OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                }

                public void onLineDrawFinished() {
                    DLog.m7384d(WaitingStartEndComponent.f27006a, "起终点连线成功", new Object[0]);
                }
            });
            this.f27009d.create();
        }
    }

    public void stopPulseAnim() {
        CommonLineManager commonLineManager = this.f27009d;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f27009d = null;
        }
        ICompLineContract iCompLineContract = this.f27010e;
        if (iCompLineContract != null) {
            iCompLineContract.stop();
            this.f27010e.destroy();
        }
    }

    public List<IMapElement> getAllMarkerElement() {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f27016k;
        if (!(markersComponent == null || markersComponent.getMarkers() == null)) {
            arrayList.addAll(this.f27016k.getMarkers());
        }
        BreathAnimMarker breathAnimMarker = this.f27011f;
        if (!(breathAnimMarker == null || breathAnimMarker.getMarker() == null)) {
            arrayList.add(this.f27011f.getMarker());
        }
        CommonLineManager commonLineManager = this.f27009d;
        if (!(commonLineManager == null || commonLineManager.getBestViewElements() == null)) {
            arrayList.addAll(this.f27009d.getBestViewElements());
        }
        ICompLineContract iCompLineContract = this.f27010e;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f27010e.getBestViewElements());
        }
        return arrayList;
    }

    public IMapElement getStartMarkerElement() {
        BreathAnimMarker breathAnimMarker = this.f27011f;
        if (breathAnimMarker != null) {
            return breathAnimMarker.getMarker();
        }
        return null;
    }
}
