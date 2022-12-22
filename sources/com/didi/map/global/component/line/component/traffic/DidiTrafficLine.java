package com.didi.map.global.component.line.component.traffic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
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
import java.util.List;

public class DidiTrafficLine implements ITrafficLine {
    public static final String TAG = "DidiTrafficLine";

    /* renamed from: a */
    private static final long f25727a = 500;

    /* renamed from: b */
    private static final int f25728b = 10;

    /* renamed from: c */
    private static final int f25729c = Color.parseColor("#FFAF38");

    /* renamed from: d */
    private Context f25730d;

    /* renamed from: e */
    private Map f25731e;

    /* renamed from: f */
    private LineParams f25732f;

    /* renamed from: g */
    private Line f25733g;

    /* renamed from: h */
    private ValueAnimator f25734h;

    /* renamed from: i */
    private List<LatLng> f25735i = new ArrayList();

    /* renamed from: j */
    private List<TrafficData> f25736j = new ArrayList();

    /* renamed from: k */
    private boolean f25737k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OnLineDrawStatusListener f25738l;

    /* renamed from: m */
    private Interpolator f25739m;

    /* renamed from: n */
    private LineExParam f25740n;

    /* renamed from: o */
    private int f25741o = 10;

    /* renamed from: p */
    private int f25742p;

    /* renamed from: q */
    private int f25743q;

    /* renamed from: r */
    private List<Integer> f25744r;

    /* renamed from: s */
    private List<ColorLineOperator> f25745s;

    public void onMapVisible(boolean z) {
    }

    public void stop() {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public DidiTrafficLine() {
        int i = f25729c;
        this.f25742p = i;
        this.f25743q = i;
        this.f25745s = new ArrayList();
    }

    public void create(Context context, Map map) {
        this.f25730d = context;
        this.f25731e = map;
    }

    public void destroy() {
        Map map;
        extensionAnimToggle(false);
        List<TrafficData> list = this.f25736j;
        if (list != null) {
            list.clear();
            this.f25736j = null;
        }
        List<LatLng> list2 = this.f25735i;
        if (list2 != null) {
            list2.clear();
            this.f25735i = null;
        }
        Line line = this.f25733g;
        if (!(line == null || (map = this.f25731e) == null)) {
            map.remove(line);
            this.f25733g = null;
        }
        this.f25739m = null;
        this.f25734h = null;
        this.f25730d = null;
        this.f25731e = null;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f25732f = lineParams;
            this.f25735i = lineParams.getLinePoints();
            this.f25736j = lineParams.getTrafficData();
            if (lineParams.getLineWidth() > 0) {
                this.f25741o = lineParams.getLineWidth();
            }
            if (lineParams.getLineColorWithArgb() != -1) {
                this.f25742p = lineParams.getLineColorWithArgb();
            }
            if (lineParams.getExParam() != null) {
                LineExParam exParam = lineParams.getExParam();
                this.f25740n = exParam;
                this.f25737k = exParam.isHasLineExtensionAnim();
                if (this.f25740n.getLineMinorColor() != -1) {
                    this.f25743q = this.f25740n.getLineMinorColor();
                } else {
                    this.f25743q = this.f25742p;
                }
            }
        }
    }

    public void start() {
        extensionAnimToggle(false);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25735i)) {
            m18357b(this.f25735i, this.f25736j);
            if (this.f25737k) {
                m18352a();
                extensionAnimToggle(true);
                return;
            }
            m18355a(this.f25735i, this.f25736j);
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25735i;
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f25733g;
        if (line != null) {
            arrayList.add(line);
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25738l = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f25731e;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new com.didi.common.map.listener.OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    DidiTrafficLine.this.m18354a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18354a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f25733g) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void setLineVisible(boolean z) {
        Line line = this.f25733g;
        if (line != null) {
            line.setVisible(z);
        }
    }

    /* renamed from: a */
    private void m18355a(List<LatLng> list, List<TrafficData> list2) {
        if (this.f25730d != null && this.f25731e != null && !CollectionUtil.isEmpty((Collection<?>) list) && !CollectionUtil.isEmpty((Collection<?>) list2)) {
            this.f25744r = m18356b();
            LineOptions lineOptions = new LineOptions();
            lineOptions.type(8);
            lineOptions.lineEndType(1);
            lineOptions.add(list);
            lineOptions.setCusTextureBitmapColors(this.f25744r);
            if (this.f25732f.getZIndex() != 0) {
                lineOptions.zIndex(this.f25732f.getZIndex());
            }
            lineOptions.width((double) DisplayUtils.dp2px(this.f25730d, (float) this.f25741o));
            if (this.f25732f.isClickable()) {
                lineOptions.clickable(this.f25732f.isClickable());
            }
            int size = list2.size();
            LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = new LineOptions.MultiColorLineInfo[size];
            for (int i = 0; i < list2.size(); i++) {
                TrafficData trafficData = list2.get(i);
                if (trafficData != null) {
                    LineOptions.MultiColorLineInfo multiColorLineInfo = new LineOptions.MultiColorLineInfo();
                    multiColorLineInfo.pointIndex = trafficData.fromIndex;
                    multiColorLineInfo.colorIndex = m18349a(trafficData.color);
                    if (i < size) {
                        multiColorLineInfoArr[i] = multiColorLineInfo;
                        this.f25745s.add(new ColorLineOperator(multiColorLineInfo, m18349a(trafficData.color), m18349a(trafficData.minorColor)));
                    }
                }
            }
            lineOptions.multiColorLineInfo(multiColorLineInfoArr);
            Line line = this.f25733g;
            if (line == null) {
                this.f25733g = this.f25731e.addLine(lineOptions);
            } else {
                line.setOptions(lineOptions);
            }
            Line line2 = this.f25733g;
            if (line2 != null) {
                line2.setNaviRouteLineErase(true);
            }
        }
    }

    /* renamed from: b */
    private void m18357b(List<LatLng> list, List<TrafficData> list2) {
        if (CollectionUtil.isEmpty((Collection<?>) list2)) {
            int size = !CollectionUtil.isEmpty((Collection<?>) list) ? list.size() - 1 : 0;
            ArrayList arrayList = new ArrayList();
            TrafficData trafficData = new TrafficData();
            trafficData.fromIndex = 0;
            trafficData.toIndex = size;
            trafficData.color = m18349a(this.f25742p);
            trafficData.minorColor = m18349a(this.f25743q);
            arrayList.add(trafficData);
            this.f25736j = arrayList;
        }
    }

    /* renamed from: a */
    private void m18352a() {
        if (this.f25732f != null && this.f25731e != null) {
            if (this.f25734h == null) {
                this.f25734h = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            }
            if (this.f25739m == null) {
                this.f25739m = PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f);
            }
            this.f25734h.setInterpolator(new LinearInterpolator());
            LineExParam lineExParam = this.f25740n;
            long j = 500;
            if (lineExParam != null && ((long) lineExParam.getLineExtensionAnimDuration()) >= 500) {
                j = (long) this.f25740n.getLineExtensionAnimDuration();
            }
            this.f25734h.setDuration(j);
            this.f25734h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DidiTrafficLine.this.m18353a(valueAnimator);
                }
            });
            this.f25734h.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (DidiTrafficLine.this.f25738l != null) {
                        DidiTrafficLine.this.f25738l.onLineDrawFinished();
                    }
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (DidiTrafficLine.this.f25738l != null) {
                        DidiTrafficLine.this.f25738l.onLineDrawStart();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18353a(ValueAnimator valueAnimator) {
        int size = (int) (((float) this.f25735i.size()) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
        List<LatLng> list = this.f25735i;
        if (list != null && list.size() >= size) {
            List<LatLng> subList = this.f25735i.subList(0, size);
            m18355a(subList, m18351a(subList));
        }
    }

    /* renamed from: a */
    private List<TrafficData> m18351a(List<LatLng> list) {
        int size = list == null ? 0 : list.size();
        ArrayList arrayList = new ArrayList();
        List<TrafficData> list2 = this.f25736j;
        if (list2 != null && !list2.isEmpty()) {
            for (TrafficData next : this.f25736j) {
                if (next.toIndex <= size) {
                    arrayList.add(next);
                } else if (next.fromIndex > size) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void extensionAnimToggle(boolean z) {
        ValueAnimator valueAnimator = this.f25734h;
        if (valueAnimator == null) {
            return;
        }
        if (z) {
            valueAnimator.start();
            return;
        }
        valueAnimator.removeAllUpdateListeners();
        this.f25734h.removeAllListeners();
        this.f25734h.cancel();
    }

    public void erase(int i, LatLng latLng) {
        Line line = this.f25733g;
        if (line != null) {
            line.insertPoint(i, latLng);
        }
    }

    public List<Line> getLines() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f25733g;
        if (line != null) {
            arrayList.add(line);
        }
        return arrayList;
    }

    public void highLight(boolean z) {
        if (this.f25733g != null && !CollectionUtil.isEmpty((Collection<?>) this.f25745s)) {
            LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = new LineOptions.MultiColorLineInfo[this.f25745s.size()];
            for (int i = 0; i < this.f25745s.size(); i++) {
                ColorLineOperator colorLineOperator = this.f25745s.get(i);
                if (colorLineOperator != null) {
                    colorLineOperator.showHighLightColor(z);
                }
                multiColorLineInfoArr[i] = colorLineOperator.getLineInfo();
            }
            this.f25733g.setMultiColorLineInfo(multiColorLineInfoArr);
        }
    }

    /* renamed from: b */
    private List<Integer> m18356b() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f25736j)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TrafficData next : this.f25736j) {
            if (next != null) {
                if (next.color != 0 && !arrayList.contains(Integer.valueOf(next.color))) {
                    arrayList.add(Integer.valueOf(next.color));
                }
                if (next.minorColor != 0 && !arrayList.contains(Integer.valueOf(next.minorColor))) {
                    arrayList.add(Integer.valueOf(next.minorColor));
                }
            }
        }
        int i = this.f25742p;
        if (i != 0) {
            arrayList.add(Integer.valueOf(i));
        }
        int i2 = this.f25743q;
        if (i2 != 0) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    /* renamed from: a */
    private int m18349a(int i) {
        if (CollectionUtil.isEmpty((Collection<?>) this.f25744r)) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f25744r.size(); i2++) {
            if (i == this.f25744r.get(i2).intValue()) {
                return i2;
            }
        }
        return 0;
    }

    class ColorLineOperator {
        LineOptions.MultiColorLineInfo lineInfo;
        int mHighLightColor;
        int mMinorColor;

        public ColorLineOperator(LineOptions.MultiColorLineInfo multiColorLineInfo, int i, int i2) {
            this.mHighLightColor = i;
            this.mMinorColor = i2;
            this.lineInfo = multiColorLineInfo;
        }

        public void showHighLightColor(boolean z) {
            if (z) {
                this.lineInfo.colorIndex = this.mMinorColor;
                return;
            }
            this.lineInfo.colorIndex = this.mHighLightColor;
        }

        public LineOptions.MultiColorLineInfo getLineInfo() {
            return this.lineInfo;
        }
    }
}
