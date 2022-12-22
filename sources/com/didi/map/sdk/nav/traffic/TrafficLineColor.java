package com.didi.map.sdk.nav.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.animation.AccelerateInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import com.didi.map.sdk.nav.util.MapLineSegmentorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TrafficLineColor implements ITrafficLine {

    /* renamed from: a */
    private static final String f28492a = "TrafficLine";

    /* renamed from: j */
    private static final int f28493j = 10;

    /* renamed from: k */
    private static final int f28494k = Color.parseColor("#FFAF38");

    /* renamed from: l */
    private static final long f28495l = 500;

    /* renamed from: m */
    private static final int f28496m = 30;

    /* renamed from: b */
    private Map f28497b;

    /* renamed from: c */
    private List<Line> f28498c;

    /* renamed from: d */
    private List<MultiColorLine> f28499d;

    /* renamed from: e */
    private TrafficOptions f28500e;

    /* renamed from: f */
    private TrafficLineAnimatorOptions f28501f;

    /* renamed from: g */
    private List<LatLng> f28502g;

    /* renamed from: h */
    private List<TrafficData> f28503h;

    /* renamed from: i */
    private ValueAnimator f28504i = null;

    /* renamed from: n */
    private int f28505n = 10;

    /* renamed from: o */
    private int f28506o;

    /* renamed from: p */
    private int f28507p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f28508q;

    /* renamed from: r */
    private int f28509r;

    /* renamed from: s */
    private TrafficData f28510s;

    /* renamed from: t */
    private int f28511t;

    /* renamed from: u */
    private int f28512u;

    /* renamed from: v */
    private int f28513v;

    /* renamed from: w */
    private int f28514w;

    /* renamed from: x */
    private Integer f28515x;

    /* renamed from: y */
    private boolean f28516y;

    public TrafficLineColor() {
        int i = f28494k;
        this.f28506o = i;
        this.f28507p = i;
        this.f28511t = 0;
        this.f28512u = 0;
        this.f28513v = 0;
        this.f28514w = 0;
        this.f28515x = 1;
    }

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        if (this.f28500e == null && m20152a(trafficOptions)) {
            this.f28500e = trafficOptions;
            this.f28511t = trafficOptions.points.size();
            if (this.f28500e.lineWidth > 0) {
                this.f28505n = this.f28500e.lineWidth;
            }
            if (this.f28500e.lineColor != 0) {
                this.f28506o = this.f28500e.lineColor;
            }
            if (this.f28500e.lineMinorColor != 0) {
                this.f28507p = this.f28500e.lineMinorColor;
            } else {
                this.f28507p = this.f28506o;
            }
            this.f28516y = trafficOptions.clickable;
        }
    }

    public void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        if (map != null && this.f28498c == null && m20152a(this.f28500e)) {
            this.f28497b = map;
            this.f28498c = new ArrayList();
            this.f28499d = new ArrayList();
            m20153b();
            m20155c();
            if (trafficLineAnimatorOptions == null || trafficLineAnimatorOptions.duration <= 0) {
                m20148a();
                return;
            }
            this.f28501f = trafficLineAnimatorOptions;
            m20157d();
            m20159e();
        }
    }

    /* renamed from: a */
    private void m20148a() {
        this.f28508q = true;
        for (TrafficData next : this.f28500e.trafficDatas) {
            Line a = m20146a(this.f28500e.points.subList(next.fromIndex, next.toIndex + 1), next.color, this.f28505n);
            if (a != null) {
                this.f28498c.add(a);
                this.f28499d.add(new MultiColorLine(a, next.color, next.minorColor));
            }
        }
        this.f28512u = this.f28498c.size();
        m20165k();
    }

    /* renamed from: b */
    private void m20153b() {
        ArrayList arrayList = new ArrayList();
        int i = this.f28511t - 1;
        int i2 = 0;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28500e.trafficDatas)) {
            for (TrafficData next : this.f28500e.trafficDatas) {
                if (next.toIndex < next.fromIndex) {
                    int i3 = next.fromIndex;
                    next.fromIndex = next.toIndex;
                    next.toIndex = i3;
                }
                if (next.toIndex > i2 && next.fromIndex != next.toIndex && next.fromIndex < i) {
                    if (next.toIndex > i) {
                        next.toIndex = i;
                    }
                    if (next.fromIndex != i2) {
                        if (next.fromIndex < i2) {
                            next.fromIndex = i2;
                            if (next.toIndex - next.fromIndex < 1) {
                            }
                        } else if (next.fromIndex - i2 < 1) {
                            next.fromIndex = i2;
                        } else {
                            TrafficData trafficData = new TrafficData();
                            trafficData.fromIndex = i2;
                            trafficData.toIndex = next.fromIndex;
                            trafficData.color = this.f28506o;
                            trafficData.minorColor = this.f28507p;
                            arrayList.add(trafficData);
                            i2 = trafficData.toIndex;
                        }
                    }
                    if (next.toIndex - next.fromIndex >= 1) {
                        arrayList.add(next);
                        i2 = next.toIndex;
                    }
                }
            }
            if (i > i2) {
                if (i - i2 > 1) {
                    TrafficData trafficData2 = new TrafficData();
                    trafficData2.fromIndex = i2;
                    trafficData2.toIndex = i;
                    trafficData2.color = this.f28506o;
                    trafficData2.minorColor = this.f28507p;
                    arrayList.add(trafficData2);
                } else if (!arrayList.isEmpty()) {
                    ((TrafficData) arrayList.get(arrayList.size() - 1)).toIndex = i;
                }
            }
        } else {
            TrafficData trafficData3 = new TrafficData();
            trafficData3.fromIndex = 0;
            trafficData3.toIndex = i;
            trafficData3.color = this.f28506o;
            trafficData3.minorColor = this.f28507p;
            arrayList.add(trafficData3);
        }
        this.f28500e.trafficDatas = arrayList;
    }

    /* renamed from: c */
    private void m20155c() {
        ArrayList arrayList = new ArrayList();
        TrafficData trafficData = null;
        for (TrafficData next : this.f28500e.trafficDatas) {
            int i = next.toIndex - next.fromIndex;
            if (i > 30) {
                int i2 = i / 30;
                int i3 = i % 30;
                int i4 = next.toIndex;
                for (int i5 = 0; i5 < i2; i5++) {
                    trafficData = new TrafficData();
                    trafficData.fromIndex = next.fromIndex + (i5 * 30);
                    trafficData.toIndex = trafficData.fromIndex + 30;
                    trafficData.color = next.color;
                    trafficData.minorColor = next.minorColor;
                    arrayList.add(trafficData);
                    i4 = trafficData.toIndex;
                }
                if (i3 > 0) {
                    if (i3 < 10) {
                        trafficData.toIndex += i3;
                    } else {
                        trafficData = new TrafficData();
                        trafficData.fromIndex = i4;
                        trafficData.toIndex = trafficData.fromIndex + i3;
                        trafficData.color = next.color;
                        trafficData.minorColor = next.minorColor;
                        arrayList.add(trafficData);
                    }
                }
            } else {
                arrayList.add(next);
            }
        }
        this.f28512u = arrayList.size();
        this.f28500e.trafficDatas = arrayList;
    }

    /* renamed from: d */
    private void m20157d() {
        this.f28502g = new ArrayList();
        this.f28503h = new ArrayList();
        MapLineSegmentorUtil.insertPoints(this.f28500e.points, this.f28502g, this.f28500e.trafficDatas, this.f28503h);
    }

    /* renamed from: a */
    private Line m20146a(List<LatLng> list, int i, int i2) {
        LineOptions lineOptions = new LineOptions();
        lineOptions.color(i);
        lineOptions.width((double) i2);
        lineOptions.setPoints(list);
        lineOptions.clickable(this.f28516y);
        Line addLine = this.f28497b.addLine(lineOptions);
        if (addLine != null) {
            addLine.setLineEndType(0);
        }
        return addLine;
    }

    /* renamed from: e */
    private void m20159e() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f28502g) || CollectionUtil.isEmpty((Collection<?>) this.f28503h)) {
            m20148a();
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f28502g.size()});
        this.f28504i = ofInt;
        long j = 500;
        if (this.f28501f.duration >= 500) {
            j = this.f28501f.duration;
        }
        ofInt.setDuration(j);
        this.f28504i.addUpdateListener(m20160f());
        this.f28504i.setInterpolator(new AccelerateInterpolator());
        this.f28504i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                boolean unused = TrafficLineColor.this.f28508q = true;
                TrafficLineColor.this.m20163i();
            }

            public void onAnimationEnd(Animator animator) {
                TrafficLineColor.this.m20162h();
                TrafficLineColor.this.m20165k();
                TrafficLineColor.this.m20164j();
            }
        });
        this.f28504i.start();
    }

    /* renamed from: f */
    private ValueAnimator.AnimatorUpdateListener m20160f() {
        List<LatLng> list = this.f28502g;
        return new ValueAnimator.AnimatorUpdateListener(list.size() - 1, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TrafficLineColor.this.m20149a(this.f$1, this.f$2, valueAnimator);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20149a(int i, List list, ValueAnimator valueAnimator) {
        List subList;
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        int intValue = this.f28515x.intValue();
        while (intValue < num.intValue() && intValue <= i) {
            TrafficData trafficData = this.f28510s;
            if (trafficData == null || intValue < trafficData.fromIndex || intValue > this.f28510s.toIndex) {
                TrafficData a = m20147a(intValue);
                this.f28510s = a;
                if (a == null) {
                    intValue++;
                }
            }
            int i2 = this.f28510s.fromIndex;
            int i3 = intValue + 1;
            if (i3 > i2 && (subList = list.subList(i2, i3)) != null && subList.size() > 1) {
                this.f28498c.get(this.f28509r).setPoints(subList);
            }
            intValue++;
        }
        this.f28515x = num;
    }

    /* renamed from: g */
    private void m20161g() {
        ValueAnimator valueAnimator = this.f28504i;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f28504i.removeAllListeners();
            this.f28504i.cancel();
            this.f28504i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m20162h() {
        List<Line> list = this.f28498c;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f28498c.size(); i++) {
                TrafficData trafficData = this.f28500e.trafficDatas.get(i);
                this.f28498c.get(i).setPoints(this.f28500e.points.subList(trafficData.fromIndex, trafficData.toIndex + 1));
            }
        }
        this.f28502g.clear();
        this.f28503h.clear();
        this.f28512u = this.f28498c.size();
    }

    /* renamed from: a */
    private TrafficData m20147a(int i) {
        int size = this.f28503h.size();
        int i2 = this.f28509r;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TrafficData trafficData = this.f28503h.get(i2);
            if (i < trafficData.fromIndex || i > trafficData.toIndex) {
                this.f28509r++;
                i2++;
            } else {
                Line a = m20146a(this.f28502g.subList(trafficData.fromIndex, trafficData.fromIndex + 2), trafficData.color, this.f28505n);
                if (a != null) {
                    this.f28498c.add(a);
                    this.f28499d.add(new MultiColorLine(a, trafficData.color, trafficData.minorColor));
                    if (this.f28509r < this.f28498c.size()) {
                        return trafficData;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    public void erase(int i, LatLng latLng) {
        int i2;
        if (latLng != null && i >= 0 && i >= this.f28514w && i <= this.f28511t - 1 && this.f28512u >= 1 && !this.f28508q) {
            this.f28514w = i;
            TrafficData trafficData = this.f28510s;
            if (trafficData == null || i < trafficData.fromIndex || i >= this.f28510s.toIndex) {
                int i3 = 0;
                this.f28510s = null;
                Iterator<TrafficData> it = this.f28500e.trafficDatas.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrafficData next = it.next();
                    if (i3 >= this.f28509r && i >= next.fromIndex && i < next.toIndex) {
                        this.f28510s = next;
                        this.f28509r = i3;
                        break;
                    }
                    i3++;
                }
            }
            if (this.f28510s != null) {
                int i4 = this.f28509r;
                if (i4 > 0 && i4 > (i2 = this.f28513v)) {
                    while (i2 < this.f28512u && i2 < this.f28509r) {
                        this.f28497b.remove(this.f28498c.get(i2));
                        this.f28513v = i2;
                        i2++;
                    }
                }
                int i5 = this.f28509r;
                if (i5 < this.f28512u) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(latLng);
                    arrayList.addAll(this.f28500e.points.subList(i + 1, this.f28510s.toIndex + 1));
                    this.f28498c.get(i5).setPoints(arrayList);
                    return;
                }
                return;
            }
            int i6 = this.f28509r;
            if (i6 == this.f28512u - 1) {
                this.f28497b.remove(this.f28498c.get(i6));
                return;
            }
            for (int i7 = this.f28513v; i7 < this.f28512u; i7++) {
                this.f28497b.remove(this.f28498c.get(i7));
            }
        }
    }

    public List<Line> getLines() {
        return this.f28498c;
    }

    /* renamed from: a */
    private boolean m20152a(TrafficOptions trafficOptions) {
        return trafficOptions != null && trafficOptions.available();
    }

    public void remove() {
        List<Line> list;
        m20161g();
        if (this.f28497b != null && (list = this.f28498c) != null) {
            for (Line remove : list) {
                this.f28497b.remove(remove);
            }
            this.f28498c.clear();
            this.f28512u = 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m20163i() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f28501f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f28501f.animatorListener.onStart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m20164j() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f28501f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f28501f.animatorListener.onEnd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m20165k() {
        this.f28508q = false;
        this.f28510s = null;
        this.f28509r = 0;
    }

    public void highLight(boolean z) {
        List<MultiColorLine> list = this.f28499d;
        if (list != null) {
            for (MultiColorLine showHighLightColor : list) {
                showHighLightColor.showHighLightColor(z);
            }
        }
    }

    class MultiColorLine {
        int mHighLightColor;
        Line mLine;
        int mMinorColor;

        public MultiColorLine(Line line, int i, int i2) {
            this.mLine = line;
            this.mHighLightColor = i;
            this.mMinorColor = i2;
        }

        public void showHighLightColor(boolean z) {
            if (z) {
                this.mLine.setColor(this.mHighLightColor);
            } else {
                this.mLine.setColor(this.mMinorColor);
            }
        }

        public void setVisible(boolean z) {
            this.mLine.setVisible(z);
        }

        public void setColor(int i) {
            this.mLine.setColor(i);
        }

        public void setZIndex(int i) {
            this.mLine.setZIndex(i);
        }

        public int getZIndex() {
            return this.mLine.getZIndex();
        }
    }
}
