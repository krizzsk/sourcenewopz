package com.didi.map.global.flow.scene.minibus.component;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.global.component.line.data.param.MultiRouteLineRequest;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkingLine;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.SingleRouteRes;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MiniBusLineGroupComponent {

    /* renamed from: a */
    private static final int f26345a = 5;

    /* renamed from: b */
    private static final int f26346b = 3;

    /* renamed from: c */
    private Context f26347c;

    /* renamed from: d */
    private Map f26348d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<CommonLineParam> f26349e;

    /* renamed from: f */
    private HashMap<String, ICompLineContract> f26350f;

    /* renamed from: g */
    private HashMap<String, WalkingLine> f26351g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LineDateListener f26352h;

    /* renamed from: i */
    private BaseLineRoute f26353i;

    /* renamed from: j */
    private int f26354j;

    /* renamed from: k */
    private Integer f26355k = null;

    /* renamed from: l */
    private String f26356l = null;

    /* renamed from: m */
    private String f26357m = null;

    /* renamed from: n */
    private String f26358n = null;

    public interface LineDateListener {
        void onLineDateRequestSuccess();
    }

    public void create(Context context, Map map) {
        this.f26347c = context;
        this.f26348d = map;
        this.f26353i = LineDataFactory.createLineRoute(context, LineDataFactory.LineDataType.ROUTE_MULTI_PLAN);
    }

    public void setConfigParam(List<CommonLineParam> list, int i) {
        this.f26349e = list;
        this.f26354j = i;
    }

    public void setDidiVersion(String str) {
        this.f26356l = str;
    }

    public void setOrderStage(int i) {
        this.f26355k = Integer.valueOf(i);
    }

    public void setProductId(String str) {
        this.f26357m = str;
    }

    public void setOrderId(String str) {
        this.f26358n = str;
    }

    public void setLineDateListener(LineDateListener lineDateListener) {
        this.f26352h = lineDateListener;
    }

    public void destroy() {
        BaseLineRoute baseLineRoute = this.f26353i;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
            this.f26353i = null;
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26350f)) {
            for (ICompLineContract next : this.f26350f.values()) {
                if (next != null) {
                    next.destroy();
                }
            }
            this.f26350f.clear();
            this.f26350f = null;
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26351g)) {
            for (WalkingLine next2 : this.f26351g.values()) {
                if (next2 != null) {
                    next2.destroy();
                }
            }
            this.f26351g.clear();
            this.f26351g = null;
        }
        this.f26349e = null;
        this.f26347c = null;
        this.f26348d = null;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26350f)) {
            for (ICompLineContract next : this.f26350f.values()) {
                if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.getBestViewElements())) {
                    arrayList.addAll(next.getBestViewElements());
                }
            }
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26351g)) {
            for (WalkingLine next2 : this.f26351g.values()) {
                if (next2 != null && !CollectionUtil.isEmpty((Collection<?>) next2.getWalkLine())) {
                    arrayList.addAll(next2.getWalkLine());
                }
            }
        }
        return arrayList;
    }

    public List<IMapElement> getBestViewElements(String str) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26350f)) {
            for (Map.Entry next : this.f26350f.entrySet()) {
                String str2 = (String) next.getKey();
                ICompLineContract iCompLineContract = (ICompLineContract) next.getValue();
                if (!(next == null || str2 == null || iCompLineContract == null || !str2.equals(str))) {
                    z = true;
                    if (!CollectionUtil.isEmpty((Collection<?>) iCompLineContract.getBestViewElements())) {
                        arrayList.addAll(iCompLineContract.getBestViewElements());
                        return arrayList;
                    }
                }
            }
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26351g) && !z) {
            Iterator<Map.Entry<String, WalkingLine>> it = this.f26351g.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next2 = it.next();
                String str3 = (String) next2.getKey();
                WalkingLine walkingLine = (WalkingLine) next2.getValue();
                if (next2 != null && str3 != null && walkingLine != null && str3.equals(str) && !CollectionUtil.isEmpty((Collection<?>) walkingLine.getWalkLine())) {
                    arrayList.addAll(walkingLine.getWalkLine());
                    break;
                }
            }
        }
        return arrayList;
    }

    public void setLineVisible(boolean z) {
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26350f)) {
            for (ICompLineContract next : this.f26350f.values()) {
                if (next != null) {
                    next.setLineVisible(z);
                }
            }
        }
        if (!CollectionUtil.isEmpty((java.util.Map<?, ?>) this.f26351g)) {
            for (WalkingLine next2 : this.f26351g.values()) {
                if (next2 != null) {
                    next2.setVisible(z);
                }
            }
        }
    }

    public void start() {
        CallFrom callFrom;
        if (this.f26353i != null && this.f26349e != null) {
            ArrayList arrayList = new ArrayList();
            for (CommonLineParam next : this.f26349e) {
                if (next != null) {
                    arrayList.add(new SingleRouteReqParam(convertToDoublePoint(next.getStartPoint()), convertToDoublePoint(next.getEndPoint()), convertToOdPoints(next.getWayPoints()), next.getLineMode() == 0 ? TravelMode.WALKING : TravelMode.DRIVING));
                }
            }
            if (this.f26354j != 2) {
                callFrom = CallFrom.ORDERROUTEAPI_MINBUS_BUBBULE;
            } else {
                callFrom = CallFrom.ORDERROUTEAPI;
            }
            if (TextUtils.isEmpty(this.f26357m)) {
                this.f26357m = PaxEnvironment.getInstance().getProductId();
            }
            MultiRouteLineRequest multiRouteLineRequest = new MultiRouteLineRequest(callFrom, this.f26357m);
            Integer num = this.f26355k;
            if (num != null) {
                multiRouteLineRequest.setOrderStage(num.intValue());
            }
            if (!TextUtils.isEmpty(this.f26356l)) {
                multiRouteLineRequest.setDidiVersion(this.f26356l);
            }
            multiRouteLineRequest.setLineParams(arrayList);
            if (!TextUtils.isEmpty(this.f26358n)) {
                multiRouteLineRequest.setOrderId(this.f26358n);
            }
            BaseLineRoute baseLineRoute = this.f26353i;
            if (baseLineRoute != null) {
                baseLineRoute.start(multiRouteLineRequest, new IRouteSearchResultCallback() {
                    public void onGetRouteResultError(String str) {
                    }

                    public void onGetRouteResult(LineDataResponse lineDataResponse) {
                        if (lineDataResponse != null && lineDataResponse.getMultiRoutePlanRes() != null) {
                            List<SingleRouteRes> list = lineDataResponse.getMultiRoutePlanRes().routeRes;
                            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                                for (int i = 0; i < list.size(); i++) {
                                    SingleRouteRes singleRouteRes = list.get(i);
                                    CommonLineParam commonLineParam = null;
                                    String str = "";
                                    if (MiniBusLineGroupComponent.this.f26349e != null && i < MiniBusLineGroupComponent.this.f26349e.size()) {
                                        commonLineParam = (CommonLineParam) MiniBusLineGroupComponent.this.f26349e.get(i);
                                        if (MiniBusLineGroupComponent.this.f26349e.get(i) != null) {
                                            str = ((CommonLineParam) MiniBusLineGroupComponent.this.f26349e.get(i)).getId().name();
                                        }
                                    }
                                    if (!(singleRouteRes == null || singleRouteRes.routeGeos == null)) {
                                        List<LatLng> latLngListFromDiffGeoPoints = MiniBusLineGroupComponent.this.getLatLngListFromDiffGeoPoints(singleRouteRes.routeGeos);
                                        int i2 = C96482.$SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode[singleRouteRes.travelMode.ordinal()];
                                        if (i2 == 1) {
                                            MiniBusLineGroupComponent.this.m18683a(latLngListFromDiffGeoPoints, commonLineParam, str);
                                        } else if (i2 == 2) {
                                            MiniBusLineGroupComponent.this.m18680a(singleRouteRes.style == null ? -1 : singleRouteRes.style.intValue(), latLngListFromDiffGeoPoints, commonLineParam, str);
                                        }
                                    }
                                    if (MiniBusLineGroupComponent.this.f26352h != null) {
                                        MiniBusLineGroupComponent.this.f26352h.onLineDateRequestSuccess();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent$2 */
    static /* synthetic */ class C96482 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.map.sdk.proto.driver_gl.TravelMode[] r0 = com.didi.map.sdk.proto.driver_gl.TravelMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode = r0
                com.didi.map.sdk.proto.driver_gl.TravelMode r1 = com.didi.map.sdk.proto.driver_gl.TravelMode.DRIVING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$sdk$proto$driver_gl$TravelMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.sdk.proto.driver_gl.TravelMode r1 = com.didi.map.sdk.proto.driver_gl.TravelMode.WALKING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.minibus.component.MiniBusLineGroupComponent.C96482.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18680a(int i, List<LatLng> list, CommonLineParam commonLineParam, String str) {
        if (commonLineParam != null) {
            WalkingLine walkingLine = new WalkingLine();
            int lineSpace = commonLineParam.getLineSpace() <= 0 ? 3 : commonLineParam.getLineSpace();
            int lineWidth = commonLineParam.getLineSpace() <= 0 ? 5 : commonLineParam.getLineWidth();
            if (i != 0) {
                if (i == 2) {
                    if (list.size() >= 1) {
                        walkingLine.createA(this.f26347c, this.f26348d, list.get(0), lineWidth, (float) lineSpace, commonLineParam.getLineColor());
                    } else {
                        return;
                    }
                }
            } else if (list.size() >= 2) {
                if (commonLineParam.getAnimate()) {
                    walkingLine.createB(this.f26347c, this.f26348d, list, 10.0f);
                } else {
                    walkingLine.createC(this.f26347c, this.f26348d, list, lineWidth, (float) lineSpace, commonLineParam.getLineColor());
                }
            } else {
                return;
            }
            if (this.f26351g == null) {
                this.f26351g = new HashMap<>();
            }
            this.f26351g.put(str, walkingLine);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18683a(List<LatLng> list, CommonLineParam commonLineParam, String str) {
        if (commonLineParam != null) {
            LineParams lineParams = new LineParams(list, commonLineParam.getLineColor(), commonLineParam.getLineWidth() == 0 ? 6 : commonLineParam.getLineWidth());
            lineParams.setZIndex(11);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f26348d, this.f26347c, lineParams);
            createLineComponent.start();
            if (this.f26350f == null) {
                this.f26350f = new HashMap<>();
            }
            this.f26350f.put(str, createLineComponent);
        }
    }

    public List<LatLng> getLatLngListFromDiffGeoPoints(DiffGeoPoints diffGeoPoints) {
        ArrayList arrayList = new ArrayList();
        if (!(diffGeoPoints == null || diffGeoPoints.base == null)) {
            double floatValue = (double) diffGeoPoints.base.lat.floatValue();
            double floatValue2 = (double) diffGeoPoints.base.lng.floatValue();
            arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
            if (diffGeoPoints.dlats.size() == diffGeoPoints.dlngs.size()) {
                for (int i = 0; i < diffGeoPoints.dlats.size(); i++) {
                    floatValue += ((double) diffGeoPoints.dlats.get(i).intValue()) / 100.0d;
                    floatValue2 += ((double) diffGeoPoints.dlngs.get(i).intValue()) / 100.0d;
                    arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
                }
            }
        }
        return arrayList;
    }

    public List<OdPoint> convertToOdPoints(List<LatLng> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng next : list) {
            arrayList.add(new OdPoint(0L, 0, new DoublePoint.Builder().lat(Float.valueOf((float) next.latitude)).lng(Float.valueOf((float) next.longitude)).build(), "", 0, Float.valueOf(0.0f), 0, (DoublePoint) null, (String) null));
        }
        return arrayList;
    }

    public DoublePoint convertToDoublePoint(LatLng latLng) {
        if (latLng != null) {
            return new DoublePoint.Builder().lat(Float.valueOf((float) latLng.latitude)).lng(Float.valueOf((float) latLng.longitude)).build();
        }
        return null;
    }
}
