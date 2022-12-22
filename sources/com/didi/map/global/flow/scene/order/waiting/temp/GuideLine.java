package com.didi.map.global.flow.scene.order.waiting.temp;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import java.util.ArrayList;
import java.util.List;

public class GuideLine {

    /* renamed from: a */
    private Context f26959a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f26960b;

    /* renamed from: c */
    private DIDILocationListener f26961c = m19025a();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LatLng f26962d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GuideLineParam f26963e;

    /* renamed from: f */
    private Line f26964f;

    /* renamed from: g */
    private boolean f26965g;

    public GuideLine(Context context, Map map) {
        this.f26959a = context.getApplicationContext();
        this.f26960b = map;
    }

    public void setParam(GuideLineParam guideLineParam) {
        this.f26963e = guideLineParam;
    }

    /* renamed from: a */
    private DIDILocationListener m19025a() {
        DIDILocationListener dIDILocationListener = this.f26961c;
        if (dIDILocationListener != null) {
            return dIDILocationListener;
        }
        C96991 r0 = new DIDILocationListener() {
            public void onLocationError(int i, ErrInfo errInfo) {
            }

            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                if (dIDILocation == null) {
                    return;
                }
                if (GuideLine.this.f26962d == null) {
                    LatLng unused = GuideLine.this.f26962d = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (GuideLine.this.f26960b.getCameraPosition() != null) {
                        GuideLine guideLine = GuideLine.this;
                        guideLine.m19026a(guideLine.f26962d, GuideLine.this.f26963e.f26967b);
                    }
                } else if (dIDILocation.getLatitude() != GuideLine.this.f26962d.latitude && dIDILocation.getLongitude() != GuideLine.this.f26962d.longitude) {
                    GuideLine.this.f26962d.latitude = dIDILocation.getLatitude();
                    GuideLine.this.f26962d.longitude = dIDILocation.getLongitude();
                    GuideLine guideLine2 = GuideLine.this;
                    guideLine2.m19026a(guideLine2.f26962d, GuideLine.this.f26963e.f26967b);
                }
            }
        };
        this.f26961c = r0;
        return r0;
    }

    public boolean isVisible() {
        return this.f26965g;
    }

    public void show() {
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f26959a);
        if (lastKnownLocation != null) {
            LatLng latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            this.f26962d = latLng;
            m19026a(latLng, this.f26963e.f26967b);
        }
        LocationHelper.registerListener(this.f26959a, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f26961c);
    }

    public void hide() {
        LocationHelper.unRegisterListener(this.f26959a, this.f26961c);
    }

    public void updateTarget(LatLng latLng) {
        this.f26963e.f26967b = latLng;
        m19026a(this.f26962d, this.f26963e.f26967b);
    }

    public void destroy() {
        hide();
        m19029b();
    }

    /* renamed from: b */
    private void m19029b() {
        this.f26965g = false;
        Line line = this.f26964f;
        if (line != null) {
            this.f26960b.remove(line);
            this.f26964f = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19026a(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            this.f26965g = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(latLng);
            arrayList.add(latLng2);
            Line line = this.f26964f;
            if (line == null) {
                LineOptions lineOptions = new LineOptions();
                lineOptions.type(2);
                lineOptions.add((List<LatLng>) arrayList);
                lineOptions.lineEndType(1);
                lineOptions.width((double) DisplayUtils.dp2px(this.f26959a, 4.0f));
                lineOptions.spacing((float) DisplayUtils.dp2px(this.f26959a, 5.0f));
                if (this.f26963e.f26966a != 0) {
                    lineOptions.color(this.f26963e.f26966a);
                } else {
                    lineOptions.color(Color.parseColor("#279CFD"));
                }
                this.f26964f = this.f26960b.addLine(lineOptions);
                return;
            }
            line.setPoints(arrayList);
        }
    }
}
