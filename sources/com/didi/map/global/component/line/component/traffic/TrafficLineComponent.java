package com.didi.map.global.component.line.component.traffic;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineConstant;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrafficLineComponent implements ITrafficLine {
    public static final String TAG = "TrafficLineComponent";

    /* renamed from: a */
    private Context f25779a;

    /* renamed from: b */
    private Map f25780b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LineParams f25781c;

    /* renamed from: d */
    private ITrafficLine f25782d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<LatLng> f25783e = new ArrayList();

    /* renamed from: f */
    private ICompLineContract f25784f;

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f25779a = context;
        this.f25780b = map;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f25781c = lineParams;
            if (lineParams.getLineWidth() == 0) {
                lineParams.setLineWidth(6);
            }
            this.f25783e = lineParams.getLinePoints();
            if (this.f25780b != null && this.f25779a != null) {
                if (C95242.$SwitchMap$com$didi$common$map$MapVendor[this.f25780b.getMapVendor().ordinal()] != 1) {
                    this.f25782d = new GoogleTrafficLine();
                } else if (lineParams.isEnableEarthWormLine()) {
                    this.f25782d = new DidiTrafficLine();
                } else {
                    this.f25782d = new GoogleTrafficLine();
                }
                this.f25782d.setConfigParam(lineParams);
                this.f25782d.create(this.f25779a, this.f25780b);
            }
        }
    }

    /* renamed from: com.didi.map.global.component.line.component.traffic.TrafficLineComponent$2 */
    static /* synthetic */ class C95242 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        static {
            int[] iArr = new int[MapVendor.values().length];
            $SwitchMap$com$didi$common$map$MapVendor = iArr;
            try {
                iArr[MapVendor.DIDI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void destroy() {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.destroy();
            this.f25782d = null;
        }
        ICompLineContract iCompLineContract = this.f25784f;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25784f = null;
        }
        List<LatLng> list = this.f25783e;
        if (list != null) {
            list.clear();
            this.f25783e = null;
        }
        this.f25779a = null;
        this.f25780b = null;
    }

    public void onMapVisible(boolean z) {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.onMapVisible(z);
        }
    }

    public void start() {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.start();
        }
    }

    public void stop() {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.stop();
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25782d.getAllLinePoints();
    }

    public void drawPulseLine(List<LatLng> list) {
        if (this.f25779a != null && this.f25780b != null && this.f25781c != null) {
            ICompLineContract iCompLineContract = this.f25784f;
            if (iCompLineContract != null) {
                iCompLineContract.destroy();
                this.f25784f = null;
            }
            LineExParam exParam = this.f25781c.getExParam();
            if (exParam != null) {
                LineParams lineParams = new LineParams(list, exParam.getPulseLineColor() == 0 ? LineConstant.DEFAULT_PULSE_LINE_COLOR : exParam.getPulseLineColor(), this.f25781c.getLineWidth() + 1);
                lineParams.setZIndex(this.f25781c.getZIndex() + 1);
                lineParams.setExParam(exParam);
                ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_PULSE, this.f25780b, this.f25779a, lineParams);
                this.f25784f = createLineComponent;
                createLineComponent.start();
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            arrayList.addAll(iTrafficLine.getBestViewElements());
        }
        ICompLineContract iCompLineContract = this.f25784f;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f25784f.getBestViewElements());
        }
        return arrayList;
    }

    public void setListener(final OnLineDrawStatusListener onLineDrawStatusListener) {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.setListener(new OnLineDrawStatusListener() {
                public void onLineDrawStart() {
                }

                public void onLineDrawFinished() {
                    if (TrafficLineComponent.this.f25781c != null && TrafficLineComponent.this.f25781c.getExParam() != null && TrafficLineComponent.this.f25781c.getExParam().isHasPulseAnim() && !CollectionUtil.isEmpty((Collection<?>) TrafficLineComponent.this.f25783e)) {
                        TrafficLineComponent trafficLineComponent = TrafficLineComponent.this;
                        trafficLineComponent.drawPulseLine(trafficLineComponent.f25783e);
                    }
                    OnLineDrawStatusListener onLineDrawStatusListener = onLineDrawStatusListener;
                    if (onLineDrawStatusListener != null) {
                        onLineDrawStatusListener.onLineDrawFinished();
                    }
                }
            });
        }
    }

    public void setLineVisible(boolean z) {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.setLineVisible(z);
        }
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.setLineClickListener(onLineClickListener);
        }
    }

    public void erase(int i, LatLng latLng) {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.erase(i, latLng);
        }
    }

    public List<Line> getLines() {
        ITrafficLine iTrafficLine = this.f25782d;
        return iTrafficLine != null ? iTrafficLine.getLines() : new ArrayList();
    }

    public void highLight(boolean z) {
        ITrafficLine iTrafficLine = this.f25782d;
        if (iTrafficLine != null) {
            iTrafficLine.highLight(z);
        }
    }
}
