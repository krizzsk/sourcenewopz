package com.didi.map.sdk.nav.line;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Deprecated
public final class SctxLine {

    /* renamed from: a */
    private Map f28478a;

    /* renamed from: b */
    private String f28479b;

    /* renamed from: c */
    private LineOptions f28480c;

    /* renamed from: d */
    private List<LatLng> f28481d;

    /* renamed from: e */
    private List<LatLng> f28482e;

    /* renamed from: f */
    private List<LatLng> f28483f;

    /* renamed from: g */
    private Line f28484g;

    /* renamed from: h */
    private Line f28485h;

    public SctxLine(Map map, LineOptions lineOptions, int i) {
        this(map, (String) null, lineOptions, i);
    }

    public SctxLine(Map map, String str, LineOptions lineOptions, int i) {
        this.f28481d = new ArrayList();
        this.f28482e = new ArrayList();
        this.f28483f = new ArrayList();
        this.f28478a = map;
        this.f28479b = str;
        this.f28480c = lineOptions;
        if (lineOptions.getPoints() != null) {
            this.f28481d.addAll(lineOptions.getPoints());
        }
        m20143a(i);
    }

    public void updateNewLine(List<LatLng> list, int i) {
        this.f28481d.clear();
        if (list != null) {
            this.f28481d.addAll(list);
        }
        m20143a(i);
    }

    /* renamed from: a */
    private void m20143a(int i) {
        int i2;
        if (i <= this.f28481d.size() - 2 && i >= 0) {
            this.f28482e.clear();
            this.f28483f.clear();
            int i3 = 0;
            while (true) {
                i2 = i + 1;
                if (i3 > i2) {
                    break;
                }
                this.f28482e.add(this.f28481d.get(i3));
                i3++;
            }
            this.f28483f.add(new LatLng(this.f28481d.get(i2).latitude, this.f28481d.get(i2).longitude));
            for (int i4 = i + 2; i4 < this.f28481d.size(); i4++) {
                this.f28483f.add(this.f28481d.get(i4));
            }
            Line line = this.f28484g;
            if (line == null) {
                this.f28484g = this.f28478a.addLine(this.f28479b, new LineOptions().color(this.f28480c.getColor()).width(this.f28480c.getWidth()).setPoints(this.f28482e));
            } else {
                line.setPoints(this.f28482e);
            }
            Line line2 = this.f28485h;
            if (line2 == null) {
                this.f28485h = this.f28478a.addLine(this.f28479b, new LineOptions().color(this.f28480c.getColor()).width(this.f28480c.getWidth()).setPoints(this.f28483f));
            } else {
                line2.setPoints(this.f28483f);
            }
        }
    }

    public void onUpdateAllLine(List<LatLng> list, List<LatLng> list2) {
        if (list != null) {
            this.f28482e.clear();
            this.f28482e.addAll(list);
            Line line = this.f28484g;
            if (line != null) {
                line.setPoints(this.f28482e);
            }
        }
        if (list2 != null) {
            this.f28483f.clear();
            this.f28483f.addAll(list2);
            Line line2 = this.f28485h;
            if (line2 != null) {
                line2.setPoints(this.f28483f);
            }
        }
    }

    public void onErase(List<LatLng> list) {
        if (list == null) {
            return;
        }
        if (list.size() <= 0 || this.f28482e.size() <= 0 || !list.get(0).equals(this.f28482e.get(0))) {
            this.f28482e.clear();
            this.f28482e.addAll(list);
            Line line = this.f28484g;
            if (line != null) {
                line.setPoints(this.f28482e);
            }
        }
    }

    @Deprecated
    public void onRecvNextDriverMatchIndex(List<LatLng> list, int i) {
        if (this.f28484g != null && this.f28485h != null && list != null && list.size() >= 1 && i <= list.size() - 2 && i >= 0) {
            int i2 = i + 1;
            this.f28482e.clear();
            for (int i3 = 0; i3 <= i2; i3++) {
                this.f28482e.add(list.get(i3));
            }
            this.f28484g.setPoints(this.f28482e);
            this.f28483f.clear();
            while (i2 < list.size()) {
                this.f28483f.add(list.get(i2));
                i2++;
            }
            this.f28485h.setPoints(this.f28483f);
        }
    }

    @Deprecated
    public void onFirstLinePointsUpdated(List<LatLng> list) {
        Line line = this.f28484g;
        if (line != null) {
            line.setPoints(list);
        }
    }

    public List<LatLng> getCurrLinePoints() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f28482e);
        arrayList.addAll(this.f28483f);
        return arrayList;
    }

    public void remove() {
        this.f28478a.remove(this.f28484g);
        this.f28478a.remove(this.f28485h);
    }

    /* renamed from: a */
    private String m20142a(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(m20141a("(%d)[%f,%f]", Integer.valueOf(i), Double.valueOf(list.get(i).longitude), Double.valueOf(list.get(i).latitude)));
            if (i < list.size() - 1) {
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m20141a(String str, Object... objArr) {
        return String.format(Locale.CHINA, str, objArr);
    }
}
