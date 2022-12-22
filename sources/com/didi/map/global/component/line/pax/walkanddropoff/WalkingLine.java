package com.didi.map.global.component.line.pax.walkanddropoff;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J6\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aJ,\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180 2\u0006\u0010\u001b\u001a\u00020\u001cJ<\u0010!\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180 2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$J\b\u0010&\u001a\u00020\u0013H\u0002J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/didi/map/global/component/line/pax/walkanddropoff/WalkingLine;", "", "()V", "mContext", "Landroid/content/Context;", "mLineA", "Lcom/didi/map/global/component/line/excomponent/GuideLine;", "mLineB", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "mLineC", "mLocListener", "Lcom/didichuxing/bigdata/dp/locsdk/DIDILocationListener;", "mMap", "Lcom/didi/common/map/Map;", "mVisible", "", "tag", "", "addLocListener", "", "createA", "context", "map", "pickup", "Lcom/didi/common/map/model/LatLng;", "width", "", "spacing", "", "color", "createB", "routes", "", "createC", "destroy", "getWalkLine", "", "Lcom/didi/common/map/internal/IMapElement;", "remoteLocListener", "setVisible", "visible", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalkingLine.kt */
public final class WalkingLine {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f25919a = "WalkingLine";

    /* renamed from: b */
    private Map f25920b;

    /* renamed from: c */
    private Context f25921c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public GuideLine f25922d;

    /* renamed from: e */
    private ICompLineContract f25923e;

    /* renamed from: f */
    private ICompLineContract f25924f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f25925g = true;

    /* renamed from: h */
    private DIDILocationListener f25926h;

    public final void createA(Context context, Map map, LatLng latLng, int i, float f, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(latLng, "pickup");
        DLog.m7384d(this.f25919a, "createA ", new Object[0]);
        this.f25920b = map;
        this.f25921c = context;
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            this.f25922d = new GuideLine();
            GuideLineParam guideLineParam = new GuideLineParam(i2, 5, i, f, new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), latLng);
            GuideLine guideLine = this.f25922d;
            if (guideLine != null) {
                guideLine.setConfigParam(guideLineParam);
            }
            GuideLine guideLine2 = this.f25922d;
            if (guideLine2 != null) {
                guideLine2.create(context, map);
            }
            GuideLine guideLine3 = this.f25922d;
            if (guideLine3 != null) {
                guideLine3.setVisible(this.f25925g);
            }
            m18407a();
        }
    }

    public final void createB(Context context, Map map, List<LatLng> list, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(list, "routes");
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m7384d(this.f25919a, "createB param error: routes is null", new Object[0]);
            return;
        }
        DLog.m7384d(this.f25919a, "createB ", new Object[0]);
        this.f25920b = map;
        this.f25921c = context;
        LineParams lineParams = new LineParams(list, 0, 0);
        lineParams.setDotSpace(f);
        lineParams.setDottedIconRes(R.drawable.blue_dot);
        LineExParam lineExParam = new LineExParam();
        lineExParam.setHasDotLineZoomListener(true);
        lineExParam.setPulseAnimDuration(1000);
        lineParams.setExParam(lineExParam);
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT_PULSE, this.f25920b, this.f25921c, lineParams);
        this.f25923e = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setLineVisible(this.f25925g);
        }
        ICompLineContract iCompLineContract = this.f25923e;
        if (iCompLineContract != null) {
            iCompLineContract.start();
        }
    }

    public final void createC(Context context, Map map, List<LatLng> list, int i, float f, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(list, "routes");
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m7384d(this.f25919a, "createC param error: routes is null", new Object[0]);
            return;
        }
        DLog.m7384d(this.f25919a, "createC ", new Object[0]);
        this.f25920b = map;
        this.f25921c = context;
        LineParams lineParams = new LineParams(list, i2, i);
        lineParams.setDotSpace(f);
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f25920b, this.f25921c, lineParams);
        this.f25924f = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setLineVisible(this.f25925g);
        }
        ICompLineContract iCompLineContract = this.f25924f;
        if (iCompLineContract != null) {
            iCompLineContract.start();
        }
    }

    public final void destroy() {
        DLog.m7384d(this.f25919a, "destroy ", new Object[0]);
        m18408b();
        GuideLine guideLine = this.f25922d;
        if (guideLine != null) {
            guideLine.destroy();
        }
        this.f25922d = null;
        ICompLineContract iCompLineContract = this.f25923e;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f25923e = null;
        ICompLineContract iCompLineContract2 = this.f25924f;
        if (iCompLineContract2 != null) {
            iCompLineContract2.destroy();
        }
        this.f25924f = null;
        this.f25920b = null;
        this.f25924f = null;
        this.f25925g = true;
    }

    public final void setVisible(boolean z) {
        String str = this.f25919a;
        DLog.m7384d(str, "setVisible visible=" + z + ' ', new Object[0]);
        GuideLine guideLine = this.f25922d;
        if (guideLine != null) {
            guideLine.setVisible(z);
        }
        ICompLineContract iCompLineContract = this.f25923e;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
        ICompLineContract iCompLineContract2 = this.f25924f;
        if (iCompLineContract2 != null) {
            iCompLineContract2.setLineVisible(z);
        }
        this.f25925g = z;
    }

    public final List<IMapElement> getWalkLine() {
        DLog.m7384d(this.f25919a, "getWalkLine", new Object[0]);
        GuideLine guideLine = this.f25922d;
        if (guideLine == null) {
            ICompLineContract iCompLineContract = this.f25923e;
            if (iCompLineContract == null) {
                ICompLineContract iCompLineContract2 = this.f25924f;
                if (iCompLineContract2 == null) {
                    DLog.m7384d(this.f25919a, "getWalkLine null", new Object[0]);
                    return null;
                } else if (iCompLineContract2 == null) {
                    return null;
                } else {
                    return iCompLineContract2.getBestViewElements();
                }
            } else if (iCompLineContract == null) {
                return null;
            } else {
                return iCompLineContract.getBestViewElements();
            }
        } else if (guideLine == null) {
            return null;
        } else {
            return guideLine.getBestViewElements();
        }
    }

    /* renamed from: a */
    private final void m18407a() {
        DLog.m7384d(this.f25919a, "addLocListener ", new Object[0]);
        this.f25926h = new WalkingLine$addLocListener$1(this);
        LocationHelper.registerListener(this.f25921c, DIDILocationUpdateOption.IntervalMode.NORMAL, this.f25926h);
    }

    /* renamed from: b */
    private final void m18408b() {
        DLog.m7384d(this.f25919a, "remoteLocListener ", new Object[0]);
        LocationHelper.unRegisterListener(this.f25921c, this.f25926h);
        this.f25926h = null;
    }
}
