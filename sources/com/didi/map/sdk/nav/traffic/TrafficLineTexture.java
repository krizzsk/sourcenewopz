package com.didi.map.sdk.nav.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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

public class TrafficLineTexture implements ITrafficLine {

    /* renamed from: a */
    private static final String f28517a = "TrafficLine";

    /* renamed from: j */
    private static final int f28518j = 10;

    /* renamed from: k */
    private static final int f28519k = 1;

    /* renamed from: l */
    private static final long f28520l = 500;

    /* renamed from: b */
    private Map f28521b;

    /* renamed from: c */
    private List<Line> f28522c;

    /* renamed from: d */
    private List<MultiTextureLine> f28523d;

    /* renamed from: e */
    private TrafficOptions f28524e;

    /* renamed from: f */
    private TrafficLineAnimatorOptions f28525f;

    /* renamed from: g */
    private List<LatLng> f28526g;

    /* renamed from: h */
    private List<TrafficData> f28527h;

    /* renamed from: i */
    private ValueAnimator f28528i = null;

    /* renamed from: m */
    private int f28529m = 10;

    /* renamed from: n */
    private int f28530n = 1;

    /* renamed from: o */
    private int f28531o = 1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f28532p;

    /* renamed from: q */
    private int f28533q;

    /* renamed from: r */
    private TrafficData f28534r;

    /* renamed from: s */
    private int f28535s = 0;

    /* renamed from: t */
    private int f28536t = 0;

    /* renamed from: u */
    private int f28537u = 0;

    /* renamed from: v */
    private int f28538v = 0;

    /* renamed from: w */
    private Integer f28539w = 1;

    /* renamed from: x */
    private boolean f28540x;

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        if (this.f28524e == null && m20172a(trafficOptions)) {
            this.f28524e = trafficOptions;
            this.f28535s = trafficOptions.points.size();
            if (this.f28524e.lineWidth > 0) {
                this.f28529m = this.f28524e.lineWidth;
            }
            if (this.f28524e.lineTextureIndex != -1) {
                this.f28530n = this.f28524e.lineTextureIndex;
            }
            if (this.f28524e.lineMinorTextureIndex != -1) {
                this.f28531o = this.f28524e.lineMinorTextureIndex;
            } else {
                this.f28531o = this.f28530n;
            }
            this.f28540x = trafficOptions.clickable;
        }
    }

    public void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        if (map != null && this.f28522c == null && m20172a(this.f28524e)) {
            this.f28521b = map;
            this.f28522c = new ArrayList();
            this.f28523d = new ArrayList();
            m20173b();
            if (trafficLineAnimatorOptions == null || trafficLineAnimatorOptions.duration <= 0) {
                m20168a();
                return;
            }
            this.f28525f = trafficLineAnimatorOptions;
            m20175c();
            m20177d();
        }
    }

    /* renamed from: a */
    private void m20168a() {
        this.f28532p = true;
        for (TrafficData next : this.f28524e.trafficDatas) {
            Line a = m20166a(this.f28524e.points.subList(next.fromIndex, next.toIndex + 1), next.textureIndex, this.f28529m);
            if (a != null) {
                this.f28522c.add(a);
                this.f28523d.add(new MultiTextureLine(a, next.textureIndex, next.minorTextureIndex));
            }
        }
        this.f28536t = this.f28522c.size();
        m20184j();
    }

    /* renamed from: b */
    private void m20173b() {
        ArrayList arrayList = new ArrayList();
        TrafficData trafficData = new TrafficData();
        trafficData.fromIndex = 0;
        trafficData.toIndex = this.f28535s - 1;
        trafficData.textureIndex = this.f28530n;
        trafficData.minorTextureIndex = this.f28531o;
        arrayList.add(trafficData);
        this.f28524e.trafficDatas = arrayList;
    }

    /* renamed from: c */
    private void m20175c() {
        this.f28526g = new ArrayList();
        this.f28527h = new ArrayList();
        MapLineSegmentorUtil.insertPoints(this.f28524e.points, this.f28526g, this.f28524e.trafficDatas, this.f28527h);
    }

    /* renamed from: a */
    private Line m20166a(List<LatLng> list, int i, int i2) {
        LineOptions lineOptions = new LineOptions();
        lineOptions.type(7);
        lineOptions.add(list);
        lineOptions.width((double) i2);
        lineOptions.lineEndType(1);
        lineOptions.clickable(this.f28540x);
        LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = {new LineOptions.MultiColorLineInfo()};
        multiColorLineInfoArr[0].pointIndex = 0;
        multiColorLineInfoArr[0].colorIndex = i;
        lineOptions.multiColorLineInfo(multiColorLineInfoArr);
        Line addLine = this.f28521b.addLine(lineOptions);
        addLine.setNaviRouteLineErase(true);
        return addLine;
    }

    /* renamed from: d */
    private void m20177d() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f28526g) || CollectionUtil.isEmpty((Collection<?>) this.f28527h)) {
            m20168a();
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f28526g.size()});
        this.f28528i = ofInt;
        long j = 500;
        if (this.f28525f.duration >= 500) {
            j = this.f28525f.duration;
        }
        ofInt.setDuration(j);
        this.f28528i.addUpdateListener(m20179e());
        this.f28528i.setInterpolator(new AccelerateInterpolator());
        this.f28528i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                boolean unused = TrafficLineTexture.this.f28532p = true;
                TrafficLineTexture.this.m20182h();
            }

            public void onAnimationEnd(Animator animator) {
                TrafficLineTexture.this.m20181g();
                TrafficLineTexture.this.m20184j();
                TrafficLineTexture.this.m20183i();
            }
        });
        this.f28528i.start();
    }

    /* renamed from: e */
    private ValueAnimator.AnimatorUpdateListener m20179e() {
        List<LatLng> list = this.f28526g;
        return new ValueAnimator.AnimatorUpdateListener(list.size() - 1, list) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TrafficLineTexture.this.m20169a(this.f$1, this.f$2, valueAnimator);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m20169a(int i, List list, ValueAnimator valueAnimator) {
        List subList;
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        int intValue = this.f28539w.intValue();
        while (intValue < num.intValue() && intValue <= i) {
            TrafficData trafficData = this.f28534r;
            if (trafficData == null || intValue < trafficData.fromIndex || intValue > this.f28534r.toIndex) {
                TrafficData a = m20167a(intValue);
                this.f28534r = a;
                if (a == null) {
                    intValue++;
                }
            }
            int i2 = this.f28534r.fromIndex;
            int i3 = intValue + 1;
            if (i3 > i2 && (subList = list.subList(i2, i3)) != null && subList.size() > 1) {
                this.f28522c.get(this.f28533q).setPoints(subList);
            }
            intValue++;
        }
        this.f28539w = num;
    }

    /* renamed from: f */
    private void m20180f() {
        ValueAnimator valueAnimator = this.f28528i;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f28528i.removeAllListeners();
            this.f28528i.cancel();
            this.f28528i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m20181g() {
        List<Line> list = this.f28522c;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f28522c.size(); i++) {
                TrafficData trafficData = this.f28524e.trafficDatas.get(i);
                this.f28522c.get(i).setPoints(this.f28524e.points.subList(trafficData.fromIndex, trafficData.toIndex + 1));
            }
        }
        this.f28526g.clear();
        this.f28527h.clear();
        this.f28536t = this.f28522c.size();
    }

    /* renamed from: a */
    private TrafficData m20167a(int i) {
        int size = this.f28527h.size();
        int i2 = this.f28533q;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TrafficData trafficData = this.f28527h.get(i2);
            if (i < trafficData.fromIndex || i > trafficData.toIndex) {
                this.f28533q++;
                i2++;
            } else {
                Line a = m20166a(this.f28526g.subList(trafficData.fromIndex, trafficData.fromIndex + 2), trafficData.textureIndex, this.f28529m);
                if (a != null) {
                    this.f28522c.add(a);
                    this.f28523d.add(new MultiTextureLine(a, trafficData.textureIndex, trafficData.minorTextureIndex));
                    if (this.f28533q < this.f28522c.size()) {
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
        if (latLng != null && i >= 0 && i >= this.f28538v && i <= this.f28535s - 1 && this.f28536t >= 1 && !this.f28532p) {
            this.f28538v = i;
            TrafficData trafficData = this.f28534r;
            if (trafficData == null || i < trafficData.fromIndex || i >= this.f28534r.toIndex) {
                int i3 = 0;
                this.f28534r = null;
                Iterator<TrafficData> it = this.f28524e.trafficDatas.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrafficData next = it.next();
                    if (i3 >= this.f28533q && i >= next.fromIndex && i < next.toIndex) {
                        this.f28534r = next;
                        this.f28533q = i3;
                        break;
                    }
                    i3++;
                }
            }
            if (this.f28534r != null) {
                int i4 = this.f28533q;
                if (i4 > 0 && i4 > (i2 = this.f28537u)) {
                    while (i2 < this.f28536t && i2 < this.f28533q) {
                        this.f28521b.remove(this.f28522c.get(i2));
                        this.f28537u = i2;
                        i2++;
                    }
                }
                int i5 = this.f28533q;
                if (i5 < this.f28536t) {
                    Line line = this.f28522c.get(i5);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(latLng);
                    arrayList.addAll(this.f28524e.points.subList(i + 1, this.f28534r.toIndex + 1));
                    line.setPoints(arrayList);
                    line.setMultiColorLineInfo(line.getMultiColorLineInfo());
                    return;
                }
                return;
            }
            int i6 = this.f28533q;
            if (i6 == this.f28536t - 1) {
                this.f28521b.remove(this.f28522c.get(i6));
                return;
            }
            for (int i7 = this.f28537u; i7 < this.f28536t; i7++) {
                this.f28521b.remove(this.f28522c.get(i7));
            }
        }
    }

    public List<Line> getLines() {
        return this.f28522c;
    }

    /* renamed from: a */
    private boolean m20172a(TrafficOptions trafficOptions) {
        return trafficOptions != null && trafficOptions.available();
    }

    public void remove() {
        List<Line> list;
        m20180f();
        if (this.f28521b != null && (list = this.f28522c) != null) {
            for (Line remove : list) {
                this.f28521b.remove(remove);
            }
            this.f28522c.clear();
            this.f28536t = 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m20182h() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f28525f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f28525f.animatorListener.onStart();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m20183i() {
        TrafficLineAnimatorOptions trafficLineAnimatorOptions = this.f28525f;
        if (trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.animatorListener != null) {
            this.f28525f.animatorListener.onEnd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m20184j() {
        this.f28532p = false;
        this.f28534r = null;
        this.f28533q = 0;
    }

    public void highLight(boolean z) {
        List<MultiTextureLine> list = this.f28523d;
        if (list != null) {
            for (MultiTextureLine highLight : list) {
                highLight.highLight(z);
            }
        }
    }

    class MultiTextureLine {
        int mCurTextureIndex;
        Line mLine;
        int mMinorTextureIndex;
        int mTextureIndex;

        public MultiTextureLine(Line line, int i, int i2) {
            this.mLine = line;
            this.mTextureIndex = i;
            this.mMinorTextureIndex = i2;
            this.mCurTextureIndex = i;
        }

        public void transparent(boolean z) {
            LineOptions.MultiColorLineInfo[] multiColorLineInfo = this.mLine.getMultiColorLineInfo();
            if (multiColorLineInfo != null) {
                for (LineOptions.MultiColorLineInfo multiColorLineInfo2 : multiColorLineInfo) {
                    if (multiColorLineInfo2 != null) {
                        if (z) {
                            multiColorLineInfo2.colorIndex = 0;
                        } else {
                            multiColorLineInfo2.colorIndex = this.mMinorTextureIndex;
                        }
                    }
                }
                this.mLine.setMultiColorLineInfo(multiColorLineInfo);
            }
        }

        public void highLight(boolean z) {
            LineOptions.MultiColorLineInfo[] multiColorLineInfo = this.mLine.getMultiColorLineInfo();
            if (multiColorLineInfo != null) {
                for (LineOptions.MultiColorLineInfo multiColorLineInfo2 : multiColorLineInfo) {
                    if (multiColorLineInfo2 != null) {
                        if (z) {
                            multiColorLineInfo2.colorIndex = this.mTextureIndex;
                            this.mCurTextureIndex = this.mTextureIndex;
                        } else {
                            multiColorLineInfo2.colorIndex = this.mMinorTextureIndex;
                            this.mCurTextureIndex = this.mMinorTextureIndex;
                        }
                    }
                }
                this.mLine.setMultiColorLineInfo(multiColorLineInfo);
            }
        }

        public void setVisible(boolean z) {
            this.mLine.setVisible(z);
        }

        public void setZIndex(int i) {
            this.mLine.setZIndex(i);
        }

        public int getZIndex() {
            return this.mLine.getZIndex();
        }
    }
}
