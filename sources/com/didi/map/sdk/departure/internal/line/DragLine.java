package com.didi.map.sdk.departure.internal.line;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.map.sdk.departure.internal.util.DimenUtil;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import java.util.ArrayList;
import java.util.List;

public class DragLine implements IDragLine {

    /* renamed from: a */
    private Map f28157a;

    /* renamed from: b */
    private DragLineParam f28158b;

    /* renamed from: c */
    private Line f28159c;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28157a = map;
    }

    public void destroy() {
        remove();
        this.f28157a = null;
        this.f28158b = null;
    }

    public void setConfigParam(DragLineParam dragLineParam) {
        this.f28158b = dragLineParam;
    }

    public void add() {
        DragLineParam dragLineParam;
        int dip2px;
        if (this.f28157a != null && (dragLineParam = this.f28158b) != null && dragLineParam.start != null && this.f28158b.end != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28158b.start);
            arrayList.add(this.f28158b.end);
            double distance = LatLngUtil.getDistance(this.f28158b.start.longitude, this.f28158b.start.latitude, this.f28158b.end.longitude, this.f28158b.end.latitude);
            if (distance > 120.0d) {
                dip2px = DimenUtil.dip2px(this.f28157a.getContext(), 0.5f);
            } else if (distance < 80.0d) {
                dip2px = DimenUtil.dip2px(this.f28157a.getContext(), 2.0f);
            } else {
                dip2px = DimenUtil.dip2px(this.f28157a.getContext(), 2.0f - ((float) (((distance - 80.0d) * 1.5d) / 40.0d)));
            }
            double d = (double) dip2px;
            Line line = this.f28159c;
            if (line == null) {
                LineOptions lineOptions = new LineOptions();
                lineOptions.type(4);
                lineOptions.color(Color.parseColor("#3CBCA3"));
                lineOptions.add((List<LatLng>) arrayList);
                lineOptions.width(d);
                this.f28159c = this.f28157a.addLine(lineOptions);
                return;
            }
            line.setWidth(d);
            this.f28159c.setPoints(arrayList);
        }
    }

    public void remove() {
        Map map;
        Line line = this.f28159c;
        if (line != null && (map = this.f28157a) != null) {
            if (map != null) {
                map.remove(line);
            }
            this.f28159c = null;
        }
    }

    public void visible(boolean z) {
        Line line = this.f28159c;
        if (line != null) {
            line.setVisible(z);
        }
    }

    public boolean isVisible() {
        Line line = this.f28159c;
        if (line != null) {
            return line.isVisible();
        }
        return false;
    }

    public void update(DragLineParam dragLineParam) {
        this.f28158b = dragLineParam;
        add();
    }
}
