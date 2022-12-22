package com.didi.map.global.component.line.pax.dropoffline;

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
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u001c\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/map/global/component/line/pax/dropoffline/SingleWalkLine;", "", "mContext", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "(Landroid/content/Context;Lcom/didi/common/map/Map;)V", "TAG", "", "mLineA", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "mLineB", "mVisible", "", "createA", "", "routes", "", "Lcom/didi/common/map/model/LatLng;", "width", "", "spacing", "", "color", "createB", "destroy", "getWalkLineElemets", "", "Lcom/didi/common/map/internal/IMapElement;", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SingleWalkLine.kt */
public final class SingleWalkLine {

    /* renamed from: a */
    private final String f25853a = "SingleWalkLine";

    /* renamed from: b */
    private Context f25854b;

    /* renamed from: c */
    private Map f25855c;

    /* renamed from: d */
    private ICompLineContract f25856d;

    /* renamed from: e */
    private ICompLineContract f25857e;

    /* renamed from: f */
    private boolean f25858f;

    public SingleWalkLine(Context context, Map map) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(map, "mMap");
        this.f25854b = context;
        this.f25855c = map;
        this.f25858f = true;
    }

    public final void createA(List<LatLng> list, int i, float f, int i2) {
        Intrinsics.checkNotNullParameter(list, "routes");
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m7384d(this.f25853a, "createA param error: routes is null", new Object[0]);
            return;
        }
        DLog.m7384d(this.f25853a, "createA ", new Object[0]);
        LineParams lineParams = new LineParams(list, i2, i);
        lineParams.setDotSpace(f);
        lineParams.setDottedIconRes(5);
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f25855c, this.f25854b, lineParams);
        this.f25856d = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setLineVisible(this.f25858f);
        }
        ICompLineContract iCompLineContract = this.f25856d;
        if (iCompLineContract != null) {
            iCompLineContract.start();
        }
    }

    public final void createB(List<LatLng> list, float f) {
        Intrinsics.checkNotNullParameter(list, "routes");
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m7384d(this.f25853a, "createB param error: routes is null", new Object[0]);
            return;
        }
        DLog.m7384d(this.f25853a, "createB ", new Object[0]);
        LineParams lineParams = new LineParams(list, 0, 0);
        lineParams.setDotSpace(f);
        lineParams.setDottedIconRes(R.drawable.blue_dot);
        LineExParam lineExParam = new LineExParam();
        lineExParam.setHasDotLineZoomListener(true);
        lineExParam.setPulseAnimDuration(1000);
        lineParams.setExParam(lineExParam);
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT_PULSE, this.f25855c, this.f25854b, lineParams);
        this.f25857e = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setLineVisible(this.f25858f);
        }
        ICompLineContract iCompLineContract = this.f25857e;
        if (iCompLineContract != null) {
            iCompLineContract.start();
        }
    }

    public final List<IMapElement> getWalkLineElemets() {
        DLog.m7384d(this.f25853a, "getWalkLine elements ", new Object[0]);
        ICompLineContract iCompLineContract = this.f25856d;
        if (iCompLineContract == null) {
            ICompLineContract iCompLineContract2 = this.f25857e;
            if (iCompLineContract2 == null) {
                DLog.m7384d(this.f25853a, "getWalkLine null", new Object[0]);
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
    }

    public final void destroy() {
        ICompLineContract iCompLineContract = this.f25856d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f25856d = null;
        ICompLineContract iCompLineContract2 = this.f25857e;
        if (iCompLineContract2 != null) {
            iCompLineContract2.destroy();
        }
        this.f25857e = null;
        this.f25854b = null;
        this.f25855c = null;
    }
}
