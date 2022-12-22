package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import java.util.List;

public class GuideRouteLine {

    /* renamed from: a */
    private Map f28640a;

    /* renamed from: b */
    private LineOptions f28641b;

    /* renamed from: c */
    private Line f28642c;

    public GuideRouteLine(Map map) {
        this.f28640a = map;
        this.f28641b = new LineOptions().color(-12430085).width(16.0d).type(2);
    }

    public GuideRouteLine(Map map, LineOptions lineOptions) {
        this.f28640a = map;
        this.f28641b = lineOptions;
    }

    public void setLineOpt(LineOptions lineOptions) {
        this.f28641b = lineOptions;
    }

    public Line add(List<LatLng> list) {
        if (this.f28642c != null) {
            remove();
        }
        this.f28641b.setPoints(list);
        Line addLine = this.f28640a.addLine(this.f28641b);
        this.f28642c = addLine;
        return addLine;
    }

    public void setVisible(boolean z) {
        LineOptions lineOptions = this.f28641b;
        if (lineOptions != null) {
            lineOptions.visible(z);
        }
        Line line = this.f28642c;
        if (line != null) {
            line.setVisible(z);
        }
    }

    public boolean isVisible() {
        Line line = this.f28642c;
        return line != null && line.isVisible();
    }

    public void remove() {
        Line line;
        Map map = this.f28640a;
        if (map != null && (line = this.f28642c) != null) {
            map.remove(line);
            this.f28642c = null;
        }
    }
}
