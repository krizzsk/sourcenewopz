package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.flow.toolkit.walkdrop.WalkParam;
import com.didi.map.global.flow.toolkit.walkdrop.WalkingLineManager;
import com.didi.map.google.util.DUtils;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WalkingLineCompose {

    /* renamed from: a */
    private WalkingLineManager f26831a;

    /* renamed from: b */
    private RecommendPointWalkingLineManager f26832b;

    /* renamed from: c */
    private boolean f26833c = false;

    public WalkingLineCompose(Context context, Map map, WalkParam walkParam) {
        this.f26831a = new WalkingLineManager(context, map, walkParam);
        this.f26832b = new RecommendPointWalkingLineManager(context, map);
    }

    public void updateWalkingLine(LatLng latLng) {
        if (this.f26833c) {
            this.f26832b.updateGuideLine(latLng);
        } else {
            this.f26831a.updateWalkingLine(latLng);
        }
    }

    public List<IMapElement> getWalkLine() {
        if (this.f26833c) {
            return this.f26832b.getWalkLine();
        }
        return this.f26831a.getWalkLine();
    }

    public void setRecommendStyle(boolean z) {
        this.f26833c = z;
        if (z) {
            this.f26831a.setVisible(false);
            this.f26832b.setVisible(true);
            return;
        }
        this.f26831a.setVisible(true);
        this.f26832b.setVisible(false);
    }

    public void setVisible(boolean z) {
        if (this.f26833c) {
            this.f26832b.setVisible(z);
        } else {
            this.f26831a.setVisible(z);
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        WalkingLineManager walkingLineManager = this.f26831a;
        if (walkingLineManager != null && !CollectionUtil.isEmpty((Collection<?>) walkingLineManager.getBestViewElements())) {
            arrayList.addAll(this.f26831a.getBestViewElements());
        }
        RecommendPointWalkingLineManager recommendPointWalkingLineManager = this.f26832b;
        if (recommendPointWalkingLineManager != null && !CollectionUtil.isEmpty((Collection<?>) recommendPointWalkingLineManager.getWalkLine())) {
            arrayList.addAll(this.f26832b.getWalkLine());
        }
        return arrayList;
    }

    public void destroy() {
        this.f26832b.destroyGuideLine();
        this.f26831a.destroy();
    }

    public static class RecommendPointWalkingLineManager {
        private Context mContext;
        private ICompLineContract mGuideLine;
        private Map mMap;

        private RecommendPointWalkingLineManager(Context context, Map map) {
            this.mContext = context;
            this.mMap = map;
        }

        /* access modifiers changed from: private */
        public void updateGuideLine(LatLng latLng) {
            destroyGuideLine();
            DoublePoint location = DUtils.getLocation(this.mContext);
            if (location != null && DDSphericalUtil.computeDistanceBetween(convert2LatLng(location), latLng) <= 5000.0d) {
                LatLng latLng2 = new LatLng((double) location.lat.floatValue(), (double) location.lng.floatValue());
                if (LatLngUtils.locateCorrect(latLng2)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(latLng2);
                    arrayList.add(latLng);
                    LineParams lineParams = new LineParams(arrayList, 0, 0);
                    LineExParam lineExParam = new LineExParam();
                    lineExParam.setPulseAnimDuration(1000);
                    lineExParam.setHasDotLineZoomListener(true);
                    lineParams.setDottedIconRes(5);
                    lineParams.setZIndex(100);
                    lineParams.setExParam(lineExParam);
                    lineParams.setDotSpace(20.0f);
                    ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT_PULSE, this.mMap, this.mContext, lineParams);
                    this.mGuideLine = createLineComponent;
                    createLineComponent.start();
                }
            }
        }

        public List<IMapElement> getWalkLine() {
            ICompLineContract iCompLineContract = this.mGuideLine;
            if (iCompLineContract != null) {
                return iCompLineContract.getBestViewElements();
            }
            return null;
        }

        /* access modifiers changed from: private */
        public void destroyGuideLine() {
            ICompLineContract iCompLineContract = this.mGuideLine;
            if (iCompLineContract != null) {
                iCompLineContract.destroy();
                this.mGuideLine = null;
            }
        }

        /* access modifiers changed from: private */
        public void setVisible(boolean z) {
            ICompLineContract iCompLineContract = this.mGuideLine;
            if (iCompLineContract != null) {
                iCompLineContract.setLineVisible(z);
            }
        }

        private LatLng convert2LatLng(DoublePoint doublePoint) {
            if (doublePoint != null) {
                return new LatLng((double) doublePoint.lat.floatValue(), (double) doublePoint.lng.floatValue());
            }
            return null;
        }
    }
}
