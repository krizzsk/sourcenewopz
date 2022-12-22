package com.didi.map.global.component.line.component.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateInterpolator;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineClickListener;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GoogleTrafficLine implements ITrafficLine {

    /* renamed from: a */
    private static final String f25746a = "GoogleTrafficLine";

    /* renamed from: b */
    private static final int f25747b = 10;

    /* renamed from: c */
    private static final int f25748c = Color.parseColor("#FFAF38");

    /* renamed from: d */
    private static final long f25749d = 500;

    /* renamed from: e */
    private static final int f25750e = 30;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public OnLineDrawStatusListener f25751A;

    /* renamed from: B */
    private boolean f25752B = false;

    /* renamed from: C */
    private List<MultiColorLine> f25753C = new ArrayList();

    /* renamed from: f */
    private Map f25754f;

    /* renamed from: g */
    private Context f25755g;

    /* renamed from: h */
    private ValueAnimator f25756h = null;

    /* renamed from: i */
    private int f25757i = 10;

    /* renamed from: j */
    private int f25758j = f25748c;

    /* renamed from: k */
    private int f25759k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f25760l;

    /* renamed from: m */
    private int f25761m;

    /* renamed from: n */
    private TrafficData f25762n;

    /* renamed from: o */
    private int f25763o = 0;

    /* renamed from: p */
    private int f25764p = 0;

    /* renamed from: q */
    private int f25765q = 0;

    /* renamed from: r */
    private int f25766r = 0;

    /* renamed from: s */
    private Integer f25767s = 1;

    /* renamed from: t */
    private List<LatLng> f25768t = new ArrayList();

    /* renamed from: u */
    private List<TrafficData> f25769u = new ArrayList();

    /* renamed from: v */
    private List<Line> f25770v = new ArrayList();

    /* renamed from: w */
    private LineParams f25771w;

    /* renamed from: x */
    private LineExParam f25772x;

    /* renamed from: y */
    private List<TrafficData> f25773y = new ArrayList();

    /* renamed from: z */
    private List<LatLng> f25774z = new ArrayList();

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f25754f = map;
        this.f25755g = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f25771w = lineParams;
            this.f25772x = lineParams.getExParam();
            this.f25774z = lineParams.getLinePoints();
            this.f25773y = lineParams.getTrafficData();
            this.f25763o = CollectionUtil.isEmpty((Collection<?>) this.f25774z) ? 0 : this.f25774z.size();
            if (lineParams.getLineWidth() > 0) {
                this.f25757i = lineParams.getLineWidth();
            }
            if (lineParams.getLineColorWithArgb() != 0) {
                this.f25758j = lineParams.getLineColorWithArgb();
            }
            LineExParam lineExParam = this.f25772x;
            if (lineExParam != null) {
                this.f25752B = lineExParam.isHasLineExtensionAnim();
                if (this.f25772x.getLineMinorColor() != 0) {
                    this.f25759k = this.f25772x.getLineMinorColor();
                } else {
                    this.f25759k = this.f25758j;
                }
            }
        }
    }

    public void start() {
        if (this.f25754f != null && !CollectionUtil.isEmpty((Collection<?>) this.f25774z)) {
            this.f25760l = true;
            m18373g();
            m18374h();
            if (this.f25771w == null || !this.f25752B) {
                m18362a();
                return;
            }
            MapLineSegmentUtil.insertPoints(this.f25774z, this.f25768t, this.f25773y, this.f25769u);
            m18366b();
        }
    }

    /* renamed from: a */
    private void m18362a() {
        Line a;
        this.f25760l = true;
        for (TrafficData next : this.f25773y) {
            List<LatLng> list = this.f25774z;
            if (!(list == null || list.size() <= next.toIndex || (a = m18358a(this.f25774z.subList(next.fromIndex, next.toIndex + 1), next.color, this.f25757i)) == null)) {
                this.f25770v.add(a);
                this.f25753C.add(new MultiColorLine(a, next.color, next.minorColor));
            }
        }
        this.f25764p = this.f25770v.size();
        m18372f();
    }

    public void erase(int i, LatLng latLng) {
        List<Line> list;
        List<Line> list2;
        int i2;
        int i3;
        List<Line> list3;
        if (latLng != null && i >= 0 && i >= this.f25766r && i <= this.f25763o - 1 && this.f25764p >= 1 && !this.f25760l) {
            this.f25766r = i;
            TrafficData trafficData = this.f25762n;
            if (trafficData == null || i < trafficData.fromIndex || i >= this.f25762n.toIndex) {
                int i4 = 0;
                this.f25762n = null;
                Iterator<TrafficData> it = this.f25773y.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrafficData next = it.next();
                    if (i4 >= this.f25761m && i >= next.fromIndex && i < next.toIndex) {
                        this.f25762n = next;
                        this.f25761m = i4;
                        break;
                    }
                    i4++;
                }
            }
            if (this.f25762n != null) {
                int i5 = this.f25761m;
                if (i5 > 0 && i5 > (i3 = this.f25765q)) {
                    while (i3 < this.f25764p && i3 < this.f25761m) {
                        Map map = this.f25754f;
                        if (!(map == null || (list3 = this.f25770v) == null)) {
                            map.remove(list3.get(i3));
                        }
                        this.f25765q = i3;
                        i3++;
                    }
                }
                int i6 = this.f25761m;
                if (i6 < this.f25764p) {
                    Line line = this.f25770v.get(i6);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(latLng);
                    if (this.f25774z.size() > this.f25762n.toIndex) {
                        arrayList.addAll(this.f25774z.subList(i + 1, this.f25762n.toIndex + 1));
                    }
                    line.setPoints(arrayList);
                }
            } else if (this.f25761m != this.f25764p - 1) {
                for (int i7 = this.f25765q; i7 < this.f25764p; i7++) {
                    if (!(this.f25754f == null || (list = this.f25770v) == null || list.size() <= i7)) {
                        this.f25754f.remove(this.f25770v.get(i7));
                    }
                }
            } else if (this.f25754f != null && (list2 = this.f25770v) != null && list2.size() > (i2 = this.f25761m)) {
                this.f25754f.remove(this.f25770v.get(i2));
            }
        }
    }

    public List<Line> getLines() {
        List<Line> list = this.f25770v;
        return list == null ? new ArrayList() : list;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        List<Line> list = this.f25770v;
        if (list != null) {
            for (Line next : list) {
                if (next != null) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25751A = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f25754f;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new com.didi.common.map.listener.OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    GoogleTrafficLine.this.m18364a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18364a(OnLineClickListener onLineClickListener, Line line) {
        List<Line> list = this.f25770v;
        if (list != null) {
            for (Line line2 : list) {
                if (line2 == line) {
                    onLineClickListener.onLineClick(this);
                    return;
                }
            }
        }
    }

    public void setLineVisible(boolean z) {
        for (Line next : this.f25770v) {
            if (next != null) {
                next.setVisible(z);
            }
        }
    }

    public void highLight(boolean z) {
        List<MultiColorLine> list = this.f25753C;
        if (list != null) {
            for (MultiColorLine showHighLightColor : list) {
                showHighLightColor.showHighLightColor(z);
            }
        }
    }

    public void destroy() {
        List<Line> list;
        m18370d();
        if (this.f25754f != null && (list = this.f25770v) != null) {
            for (Line remove : list) {
                this.f25754f.remove(remove);
            }
            this.f25770v.clear();
            this.f25764p = 0;
        }
    }

    /* renamed from: a */
    private Line m18358a(List<LatLng> list, int i, int i2) {
        if (this.f25754f == null) {
            return null;
        }
        LineOptions lineOptions = new LineOptions();
        lineOptions.color(i);
        lineOptions.width((double) DisplayUtils.dp2px(this.f25755g, (float) i2));
        lineOptions.setPoints(list);
        if (this.f25771w.isClickable()) {
            lineOptions.clickable(this.f25771w.isClickable());
        }
        Line addLine = this.f25754f.addLine(lineOptions);
        if (addLine != null) {
            addLine.setLineEndType(0);
        }
        return addLine;
    }

    /* renamed from: b */
    private void m18366b() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f25768t) || CollectionUtil.isEmpty((Collection<?>) this.f25769u)) {
            m18362a();
            return;
        }
        this.f25756h = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        long j = 0;
        LineExParam lineExParam = this.f25772x;
        if (lineExParam != null) {
            j = ((long) lineExParam.getLineExtensionAnimDuration()) >= 500 ? (long) this.f25772x.getLineExtensionAnimDuration() : 500;
        }
        this.f25756h.setDuration(j);
        this.f25756h.addUpdateListener(m18368c());
        this.f25756h.setInterpolator(new AccelerateInterpolator());
        this.f25756h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                boolean unused = GoogleTrafficLine.this.f25760l = true;
                if (GoogleTrafficLine.this.f25751A != null) {
                    GoogleTrafficLine.this.f25751A.onLineDrawStart();
                }
            }

            public void onAnimationEnd(Animator animator) {
                GoogleTrafficLine.this.m18371e();
                GoogleTrafficLine.this.m18372f();
                if (GoogleTrafficLine.this.f25751A != null) {
                    GoogleTrafficLine.this.f25751A.onLineDrawFinished();
                }
            }
        });
        this.f25756h.start();
    }

    /* renamed from: c */
    private ValueAnimator.AnimatorUpdateListener m18368c() {
        List<LatLng> list = this.f25768t;
        return new ValueAnimator.AnimatorUpdateListener(list.size() - 1, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GoogleTrafficLine.this.m18363a(this.f$1, this.f$2, valueAnimator);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18363a(int i, List list, ValueAnimator valueAnimator) {
        List subList;
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) i));
        int intValue = this.f25767s.intValue();
        while (intValue < floatValue && intValue <= i) {
            TrafficData trafficData = this.f25762n;
            if (trafficData == null || intValue < trafficData.fromIndex || intValue > this.f25762n.toIndex) {
                TrafficData a = m18360a(intValue);
                this.f25762n = a;
                if (a == null) {
                    intValue++;
                }
            }
            int i2 = this.f25762n.fromIndex;
            int i3 = intValue + 1;
            if (i3 > i2 && (subList = list.subList(i2, i3)) != null && subList.size() > 1) {
                this.f25770v.get(this.f25761m).setPoints(subList);
            }
            intValue++;
        }
        this.f25767s = Integer.valueOf(floatValue);
    }

    /* renamed from: d */
    private void m18370d() {
        ValueAnimator valueAnimator = this.f25756h;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f25756h.removeAllListeners();
            this.f25756h.cancel();
            this.f25756h = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m18371e() {
        List<Line> list = this.f25770v;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f25770v.size(); i++) {
                TrafficData trafficData = this.f25773y.get(i);
                if (this.f25774z.size() > trafficData.toIndex) {
                    this.f25770v.get(i).setPoints(this.f25774z.subList(trafficData.fromIndex, trafficData.toIndex + 1));
                }
            }
        }
        this.f25768t.clear();
        this.f25769u.clear();
        this.f25764p = this.f25770v.size();
    }

    /* renamed from: a */
    private TrafficData m18360a(int i) {
        int size = this.f25769u.size();
        int i2 = this.f25761m;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TrafficData trafficData = this.f25769u.get(i2);
            if (i < trafficData.fromIndex || i > trafficData.toIndex) {
                this.f25761m++;
                i2++;
            } else {
                Line a = m18358a(this.f25768t.subList(trafficData.fromIndex, trafficData.fromIndex + 2), trafficData.color, this.f25757i);
                if (a != null) {
                    this.f25770v.add(a);
                    this.f25753C.add(new MultiColorLine(a, trafficData.color, trafficData.minorColor));
                    if (this.f25761m < this.f25770v.size()) {
                        return trafficData;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m18372f() {
        this.f25760l = false;
        this.f25762n = null;
        this.f25761m = 0;
    }

    /* renamed from: g */
    private void m18373g() {
        ArrayList arrayList = new ArrayList();
        int i = this.f25763o - 1;
        int i2 = 0;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25773y)) {
            for (TrafficData next : this.f25773y) {
                if (next != null) {
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
                                TrafficData a = m18361a(i2, next.fromIndex, this.f25758j, this.f25759k);
                                arrayList.add(a);
                                i2 = a.toIndex;
                            }
                        }
                        if (next.toIndex - next.fromIndex >= 1) {
                            arrayList.add(next);
                            i2 = next.toIndex;
                        }
                    }
                }
            }
            if (i > i2) {
                if (i - i2 > 1) {
                    arrayList.add(m18361a(i2, i, this.f25758j, this.f25759k));
                } else if (!arrayList.isEmpty()) {
                    ((TrafficData) arrayList.get(arrayList.size() - 1)).toIndex = i;
                }
            }
        } else {
            arrayList.add(m18361a(0, i, this.f25758j, this.f25759k));
        }
        this.f25773y = arrayList;
    }

    /* renamed from: a */
    private TrafficData m18361a(int i, int i2, int i3, int i4) {
        TrafficData trafficData = new TrafficData();
        trafficData.fromIndex = i;
        trafficData.toIndex = i2;
        trafficData.color = i3;
        trafficData.minorColor = i4;
        return trafficData;
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25774z;
    }

    /* renamed from: h */
    private void m18374h() {
        ArrayList arrayList = new ArrayList();
        TrafficData trafficData = null;
        for (TrafficData next : this.f25773y) {
            if (next != null) {
                int i = next.toIndex - next.fromIndex;
                if (i > 30) {
                    int i2 = i / 30;
                    int i3 = i % 30;
                    int i4 = next.toIndex;
                    for (int i5 = 0; i5 < i2; i5++) {
                        int i6 = next.fromIndex + (i5 * 30);
                        i4 = i6 + 30;
                        trafficData = m18361a(i6, i4, next.color, next.minorColor);
                        arrayList.add(trafficData);
                    }
                    if (i3 > 0) {
                        if (i3 >= 10) {
                            trafficData = m18361a(i4, i3 + i4, next.color, next.minorColor);
                            arrayList.add(trafficData);
                        } else if (trafficData != null) {
                            trafficData.toIndex += i3;
                        }
                    }
                } else {
                    arrayList.add(next);
                }
            }
        }
        this.f25764p = arrayList.size();
        this.f25773y = arrayList;
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
