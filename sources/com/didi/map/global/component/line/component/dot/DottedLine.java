package com.didi.map.global.component.line.component.dot;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.utils.LineUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DottedLine implements ICompLineContract {

    /* renamed from: a */
    private static final String f25701a = "DottedLine";

    /* renamed from: b */
    private LineParams f25702b;

    /* renamed from: c */
    private Map f25703c;

    /* renamed from: d */
    private Context f25704d;

    /* renamed from: e */
    private Line f25705e;

    /* renamed from: f */
    private List<LatLng> f25706f;

    /* renamed from: g */
    private OnLineDrawStatusListener f25707g;

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public void create(Context context, Map map) {
        this.f25703c = map;
        this.f25704d = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f25702b = lineParams;
            this.f25706f = lineParams.getLinePoints();
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f25705e;
        if (line != null && line.isVisible()) {
            arrayList.add(this.f25705e);
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25707g = onLineDrawStatusListener;
    }

    public void setLineVisible(boolean z) {
        Line line = this.f25705e;
        if (line != null) {
            line.setVisible(z);
        }
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f25703c;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new com.didi.common.map.listener.OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    DottedLine.this.m18333a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18333a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f25705e) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void start() {
        if (!LineUtils.INSTANCE.isMainThread()) {
            throw new RuntimeException("don't run main thread.");
        } else if (this.f25703c != null && this.f25704d != null && !CollectionUtil.isEmpty((Collection<?>) this.f25706f) && this.f25702b != null) {
            clear();
            LineOptions lineOptions = new LineOptions();
            lineOptions.add(this.f25706f);
            lineOptions.type(2);
            lineOptions.lineEndType(1);
            lineOptions.width((double) DisplayUtils.dp2px(this.f25704d, (float) this.f25702b.getLineWidth()));
            lineOptions.spacing((float) DisplayUtils.dp2px(this.f25704d, this.f25702b.getDotSpace()));
            lineOptions.color(this.f25702b.getLineColorWithArgb());
            lineOptions.zIndex(this.f25702b.getZIndex());
            if (this.f25702b.isClickable()) {
                lineOptions.clickable(this.f25702b.isClickable());
            }
            if (this.f25702b.getDottedIconRes() != 0) {
                lineOptions.dottedResType(this.f25702b.getDottedIconRes());
            } else {
                lineOptions.dottedResType(5);
            }
            this.f25705e = this.f25703c.addLine(lineOptions);
            OnLineDrawStatusListener onLineDrawStatusListener = this.f25707g;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25706f;
    }

    public void updateLinePoints(List<LatLng> list) {
        this.f25706f = list;
        Line line = this.f25705e;
        if (line != null) {
            line.setPoints(list);
        } else {
            start();
        }
    }

    public void clear() {
        Map map;
        Line line = this.f25705e;
        if (line != null && (map = this.f25703c) != null) {
            map.remove(line);
            this.f25705e = null;
        }
    }

    public void destroy() {
        clear();
    }
}
