package com.didi.map.global.component.dropoff.controller;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.map.global.component.dropoff.card.RichTextInfo;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.global.component.line.pax.dropoffline.SingleWalkLineManager;
import com.didi.map.global.component.line.pax.dropoffline.SingleWalkLineParam;
import com.didi.map.global.component.line.pax.dropoffline.WalkLineCallback;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.sdk.proto.driver_gl.SingleRouteRes;
import com.didichuxing.routesearchsdk.CallFrom;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscountPoiController {

    /* renamed from: a */
    private Context f25452a;

    /* renamed from: b */
    private Map f25453b;

    /* renamed from: c */
    private DropOffLocationInfo f25454c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SingleWalkLineParam f25455d;

    /* renamed from: e */
    private SingleWalkLineManager f25456e;

    /* renamed from: f */
    private IMarkersCompContract f25457f;

    /* renamed from: g */
    private String f25458g = "DiscountPoiController_child";

    /* renamed from: h */
    private String f25459h = "DiscountPoiController_parent";

    /* renamed from: i */
    private final float f25460i = 1.4f;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WalkLineResultListener f25461j;

    /* renamed from: k */
    private WalkLineCallback f25462k = new WalkLineCallback() {
        public void onFinishToSearch(boolean z, SingleRouteRes singleRouteRes) {
            int i;
            int i2;
            if (z) {
                i2 = singleRouteRes.eta.intValue();
                i = singleRouteRes.distance.intValue();
            } else {
                i = (int) DDSphericalUtil.computeDistanceBetween(DiscountPoiController.this.f25455d.getStartPos(), DiscountPoiController.this.f25455d.getEndPos());
                i2 = (int) ((((float) i) / 1.4f) / 60.0f);
            }
            if (DiscountPoiController.this.f25461j != null) {
                DiscountPoiController.this.f25461j.onGetEtaEda(z, i2, i);
            }
        }
    };

    public interface WalkLineResultListener {
        void onGetEtaEda(boolean z, int i, int i2);
    }

    public DiscountPoiController(Context context, Map map, DropOffLocationInfo dropOffLocationInfo) {
        this.f25452a = context;
        this.f25453b = map;
        this.f25454c = dropOffLocationInfo;
    }

    public void start() {
        m18198a();
        m18201c();
    }

    /* renamed from: a */
    private void m18198a() {
        if (this.f25454c != null && this.f25453b != null && this.f25452a != null) {
            this.f25457f = new MarkersComponent();
            ArrayList arrayList = new ArrayList();
            if (this.f25454c.sugPoi != null) {
                MarkerModel markerModel = new MarkerModel();
                LatLng latLng = new LatLng(this.f25454c.sugPoi.latitude, this.f25454c.sugPoi.longitude);
                markerModel.setZOrder(99);
                markerModel.setPoint(latLng);
                markerModel.setMarkerIcon(BitmapFactory.decodeResource(this.f25452a.getResources(), R.drawable.map_input_icon_destination));
                markerModel.setLabelZIndex(99);
                markerModel.setAnchorU(0.5f);
                markerModel.setAnchorV(0.5f);
                markerModel.setClickable(false);
                markerModel.setId(this.f25458g);
                arrayList.add(markerModel);
                DropOffUtils.LOGD(" add Discount Poi Marker");
            }
            if (this.f25454c.parentPoi != null) {
                MarkerModel markerModel2 = new MarkerModel();
                LatLng latLng2 = new LatLng(this.f25454c.parentPoi.latitude, this.f25454c.parentPoi.longitude);
                markerModel2.setZOrder(99);
                markerModel2.setPoint(latLng2);
                markerModel2.setMarkerIcon(BitmapFactory.decodeResource(this.f25452a.getResources(), R.drawable.map_discount_parent_icon));
                markerModel2.setLabelZIndex(99);
                markerModel2.setAnchorU(0.5f);
                markerModel2.setAnchorV(0.5f);
                markerModel2.setClickable(false);
                markerModel2.setId(this.f25459h);
                arrayList.add(markerModel2);
                DropOffUtils.LOGD(" add Parent Poi Marker = ");
            }
            MarkersCompParams.Builder builder = new MarkersCompParams.Builder();
            builder.markerModels(arrayList);
            this.f25457f.setConfigParam(builder.build());
            this.f25457f.create(this.f25452a, this.f25453b);
            m18200b();
        }
    }

    /* renamed from: b */
    private void m18200b() {
        if (!TextUtils.isEmpty(this.f25454c.parentPoi.displayName) && this.f25457f != null) {
            this.f25457f.showMarkerInfoWindow(this.f25459h, new DropOffInfoWindow().getView(this.f25452a, this.f25454c.parentPoi.displayName), InfoWindow.Position.TOP);
            DropOffUtils.LOGD(" add Parent Poi Bubble");
        }
    }

    /* renamed from: c */
    private void m18201c() {
        DropOffLocationInfo dropOffLocationInfo = this.f25454c;
        if (dropOffLocationInfo != null && dropOffLocationInfo.sugPoi != null && this.f25454c.parentPoi != null) {
            if (this.f25456e == null) {
                LatLng latLng = new LatLng(this.f25454c.sugPoi.latitude, this.f25454c.sugPoi.longitude);
                LatLng latLng2 = new LatLng(this.f25454c.parentPoi.latitude, this.f25454c.parentPoi.longitude);
                SingleWalkLineParam singleWalkLineParam = new SingleWalkLineParam();
                this.f25455d = singleWalkLineParam;
                singleWalkLineParam.setStartPos(latLng);
                this.f25455d.setEndPos(latLng2);
                this.f25455d.setLineAColor(Color.parseColor("#33BBFF"));
                this.f25455d.setLineAWidth(4);
                this.f25455d.setLineASpace(5.0f);
                this.f25455d.setLineBSpace(20.0f);
                this.f25455d.setCaller(CallFrom.ORDERROUTEAPI_BUBBLE);
                this.f25456e = new SingleWalkLineManager(this.f25452a, this.f25453b, this.f25455d, this.f25462k);
            }
            this.f25456e.requestLine();
        }
    }

    public List<IMapElement> getMapElements() {
        ArrayList arrayList = new ArrayList();
        IMarkersCompContract iMarkersCompContract = this.f25457f;
        if (iMarkersCompContract != null) {
            arrayList.addAll(iMarkersCompContract.getMarkers());
        }
        SingleWalkLineManager singleWalkLineManager = this.f25456e;
        if (singleWalkLineManager != null) {
            List<IMapElement> mapElements = singleWalkLineManager.getMapElements();
            if (!CollectionUtil.isEmpty((Collection<?>) mapElements)) {
                arrayList.addAll(mapElements);
            }
        }
        return arrayList;
    }

    public String generateSubTitleRichJson(String str) {
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(str);
        Matcher matcher = Pattern.compile("[\\d.]+[ ]*%").matcher(richTextInfo.getContent());
        int start = matcher.find() ? matcher.start() : -1;
        if (start != -1) {
            List<RichTextInfo.RichInfo> infoList = richTextInfo.getInfoList();
            if (!CollectionUtil.isEmpty((Collection<?>) infoList)) {
                infoList.get(infoList.size() - 1).start = start;
            }
        }
        String json = new Gson().toJson((Object) richTextInfo);
        DropOffUtils.LOGD("discountXXX Transform = " + start);
        return json;
    }

    public void destroy() {
        IMarkersCompContract iMarkersCompContract = this.f25457f;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f25457f = null;
        }
        SingleWalkLineManager singleWalkLineManager = this.f25456e;
        if (singleWalkLineManager != null) {
            singleWalkLineManager.destroy();
        }
        this.f25456e = null;
        this.f25455d = null;
        this.f25453b = null;
        this.f25452a = null;
    }

    public void setWalkLineResultListener(WalkLineResultListener walkLineResultListener) {
        this.f25461j = walkLineResultListener;
    }
}
