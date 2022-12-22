package com.didi.map.global.component.line.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.listener.OnPolygonClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.utils.LineUtils;
import com.didi.sdk.util.ToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArcLineComponent implements ICompLineContract {
    public static final String TAG = "Arc_line_component";

    /* renamed from: a */
    private Map f25628a;

    /* renamed from: b */
    private Context f25629b;

    /* renamed from: c */
    private LineParams f25630c;

    /* renamed from: d */
    private LineExParam f25631d;

    /* renamed from: e */
    private List<LatLng> f25632e;

    /* renamed from: f */
    private Polygon f25633f;

    /* renamed from: g */
    private Line f25634g;

    /* renamed from: h */
    private OnLineDrawStatusListener f25635h;

    /* renamed from: i */
    private ICompLineContract f25636i;

    /* renamed from: j */
    private ICompLineContract f25637j;

    /* renamed from: k */
    private ValueAnimator f25638k = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});

    /* renamed from: l */
    private DrawLineMode f25639l;

    /* renamed from: m */
    private LatLng f25640m;

    /* renamed from: n */
    private LatLng f25641n;

    public enum DrawLineMode {
        TYPE_LINE,
        TYPE_POLYGON
    }

    public void onMapVisible(boolean z) {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f25628a = map;
        this.f25629b = context;
    }

    public void setConfigParam(LineParams lineParams) {
        LineExParam lineExParam;
        if (lineParams != null && !CollectionUtil.isEmpty((Collection<?>) lineParams.getLinePoints())) {
            if (lineParams.getLinePoints().size() != 2) {
                try {
                    throw new Exception("弧线绘制点集必须为两个");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f25630c = lineParams;
            this.f25631d = lineParams.getExParam();
            if (this.f25630c.getLineColorWithArgb() == 0) {
                this.f25630c.setLineColorWithArgb(Color.parseColor("#262B2E"));
            }
            if (this.f25630c.getLineWidth() == 0) {
                this.f25630c.setLineWidth(6);
            }
            Map map = this.f25628a;
            if (map != null) {
                if (map.getMapVendor() != MapVendor.DIDI || (lineExParam = this.f25631d) == null || !lineExParam.isHasPulseAnim()) {
                    this.f25639l = DrawLineMode.TYPE_POLYGON;
                } else {
                    this.f25639l = DrawLineMode.TYPE_LINE;
                }
            }
            this.f25640m = lineParams.getLinePoints().get(0);
            this.f25641n = lineParams.getLinePoints().get(1);
            this.f25632e = LineUtils.INSTANCE.getCornerLineDots(this.f25640m, this.f25641n);
        }
    }

    public void start() {
        List<LatLng> list = this.f25632e;
        if (list != null && this.f25639l != null) {
            if (list.size() <= 2) {
                this.f25639l = DrawLineMode.TYPE_LINE;
            }
            int i = C95131.f25642xacffd67a[this.f25639l.ordinal()];
            if (i == 1) {
                m18316d();
            } else if (i == 2) {
                m18315c();
            }
            LineExParam lineExParam = this.f25631d;
            if (lineExParam != null) {
                if (lineExParam.isHasPulseAnim()) {
                    starPulseAnim();
                }
                if (this.f25631d.isHasArcLineShadow()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f25640m);
                    arrayList.add(this.f25641n);
                    m18313a((List<LatLng>) arrayList);
                }
            }
        }
    }

    /* renamed from: com.didi.map.global.component.line.component.ArcLineComponent$1 */
    static /* synthetic */ class C95131 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$line$component$ArcLineComponent$DrawLineMode */
        static final /* synthetic */ int[] f25642xacffd67a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.map.global.component.line.component.ArcLineComponent$DrawLineMode[] r0 = com.didi.map.global.component.line.component.ArcLineComponent.DrawLineMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25642xacffd67a = r0
                com.didi.map.global.component.line.component.ArcLineComponent$DrawLineMode r1 = com.didi.map.global.component.line.component.ArcLineComponent.DrawLineMode.TYPE_LINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25642xacffd67a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.line.component.ArcLineComponent$DrawLineMode r1 = com.didi.map.global.component.line.component.ArcLineComponent.DrawLineMode.TYPE_POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.line.component.ArcLineComponent.C95131.<clinit>():void");
        }
    }

    public void stop() {
        stopPulseAnim();
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25632e;
    }

    public void destroy() {
        Polygon polygon = this.f25633f;
        if (polygon != null) {
            this.f25628a.remove(polygon);
            this.f25633f.remove();
            this.f25633f = null;
        }
        Line line = this.f25634g;
        if (line != null) {
            this.f25628a.remove(line);
            this.f25634g.remove();
            this.f25634g = null;
        }
        ICompLineContract iCompLineContract = this.f25636i;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25636i = null;
        }
        List<LatLng> list = this.f25632e;
        if (list != null) {
            list.clear();
            this.f25632e = null;
        }
        ICompLineContract iCompLineContract2 = this.f25637j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.destroy();
            this.f25637j = null;
        }
        this.f25630c = null;
        this.f25629b = null;
        this.f25628a = null;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25635h = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        if (this.f25628a != null && onLineClickListener != null) {
            if (this.f25639l == DrawLineMode.TYPE_LINE) {
                this.f25628a.addOnLineClickListener(new OnLineClickListener(onLineClickListener) {
                    public final /* synthetic */ OnLineClickListener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onLineClick(Line line) {
                        ArcLineComponent.this.m18311a(this.f$1, line);
                    }
                });
            } else {
                this.f25628a.addOnPolygonClickListener(new OnPolygonClickListener(onLineClickListener) {
                    public final /* synthetic */ OnLineClickListener f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onPolygonClick(Polygon polygon) {
                        ArcLineComponent.this.m18312a(this.f$1, polygon);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18311a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f25634g) {
            onLineClickListener.onLineClick(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18312a(OnLineClickListener onLineClickListener, Polygon polygon) {
        if (polygon == this.f25633f) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void setLineVisible(boolean z) {
        Polygon polygon = this.f25633f;
        if (polygon != null) {
            polygon.setVisible(z);
        }
        Line line = this.f25634g;
        if (line != null) {
            line.setVisible(z);
        }
        ICompLineContract iCompLineContract = this.f25636i;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
        ICompLineContract iCompLineContract2 = this.f25637j;
        if (iCompLineContract2 != null) {
            iCompLineContract2.setLineVisible(z);
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Polygon polygon = this.f25633f;
        if (polygon != null) {
            arrayList.add(polygon);
        }
        Line line = this.f25634g;
        if (line != null) {
            arrayList.add(line);
        }
        ICompLineContract iCompLineContract = this.f25636i;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f25636i.getBestViewElements());
        }
        ICompLineContract iCompLineContract2 = this.f25637j;
        if (!(iCompLineContract2 == null || iCompLineContract2.getBestViewElements() == null)) {
            arrayList.addAll(this.f25637j.getBestViewElements());
        }
        return arrayList;
    }

    public void starPulseAnim() {
        int i = C95131.f25642xacffd67a[this.f25639l.ordinal()];
        if (i == 1) {
            m18314b();
        } else if (i == 2) {
            m18309a();
        }
    }

    public void stopPulseAnim() {
        ICompLineContract iCompLineContract = this.f25637j;
        if (iCompLineContract != null) {
            iCompLineContract.stop();
        }
        ValueAnimator valueAnimator = this.f25638k;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* renamed from: a */
    private void m18313a(List<LatLng> list) {
        LineExParam lineExParam;
        if (this.f25629b != null && this.f25628a != null && this.f25630c != null && (lineExParam = this.f25631d) != null) {
            LineParams lineParams = new LineParams(list, lineExParam.getShadowLineColor() == 0 ? Color.parseColor("#1A294766") : this.f25631d.getShadowLineColor(), this.f25631d.getShadowLineWidth() == 0 ? 6 : this.f25631d.getShadowLineWidth());
            lineParams.setZIndex(this.f25630c.getZIndex());
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f25628a, this.f25629b, lineParams);
            this.f25636i = createLineComponent;
            createLineComponent.start();
        }
    }

    /* renamed from: a */
    private void m18309a() {
        if (this.f25629b != null && this.f25628a != null && this.f25630c != null && this.f25632e != null) {
            LineParams lineParams = new LineParams(this.f25632e, this.f25631d.getPulseLineColor() == 0 ? Color.parseColor("#66ffffff") : this.f25631d.getPulseLineColor(), this.f25630c.getLineWidth() + 1);
            lineParams.setExParam(this.f25631d);
            lineParams.setZIndex(this.f25630c.getZIndex() + 1);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_PULSE, this.f25628a, this.f25629b, lineParams);
            this.f25637j = createLineComponent;
            createLineComponent.start();
        }
    }

    /* renamed from: b */
    private void m18314b() {
        if (this.f25638k == null) {
            this.f25638k = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        }
        LineExParam lineExParam = this.f25631d;
        if (lineExParam == null || lineExParam.getPulseAnimDuration() == 0) {
            this.f25638k.setDuration(2000);
        } else {
            this.f25638k.setDuration((long) this.f25631d.getPulseAnimDuration());
        }
        this.f25638k.setInterpolator(PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f));
        this.f25638k.setRepeatMode(1);
        this.f25638k.setRepeatCount(-1);
        this.f25638k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ArcLineComponent.this.m18310a(valueAnimator);
            }
        });
        this.f25638k.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18310a(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Line line = this.f25634g;
            if (line != null) {
                line.setPulsePercent(floatValue);
            }
        }
    }

    /* renamed from: c */
    private void m18315c() {
        List<LatLng> list = this.f25632e;
        if (list != null && !list.isEmpty()) {
            Polygon polygon = this.f25633f;
            if (polygon != null) {
                polygon.remove();
                this.f25633f = null;
            }
            if (this.f25630c == null) {
                ToastUtil.show(this.f25629b, (CharSequence) "请先添加参数");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f25632e);
            for (int size = this.f25632e.size() - 1; size >= 0; size--) {
                arrayList.add(this.f25632e.get(size));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.strokeColor(this.f25630c.getLineColorWithArgb());
            polygonOptions.strokeWidth((float) DisplayUtils.dp2px(this.f25629b, (float) this.f25630c.getLineWidth()));
            polygonOptions.fillColor(0);
            polygonOptions.geodesic(false);
            polygonOptions.setPolygonPatternType(2);
            polygonOptions.addAll(arrayList);
            if (this.f25630c.getZIndex() != 0) {
                polygonOptions.zIndex(this.f25630c.getZIndex());
            }
            this.f25633f = this.f25628a.addPolygon(polygonOptions);
            OnLineDrawStatusListener onLineDrawStatusListener = this.f25635h;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    /* renamed from: d */
    private void m18316d() {
        List<LatLng> list = this.f25632e;
        if (list != null && !list.isEmpty()) {
            Line line = this.f25634g;
            if (line != null) {
                line.remove();
                this.f25634g = null;
            }
            if (this.f25630c == null) {
                ToastUtil.show(this.f25629b, (CharSequence) "请先添加参数");
                return;
            }
            LineOptions lineOptions = new LineOptions();
            lineOptions.color(this.f25630c.getLineColorWithArgb());
            lineOptions.width((double) DisplayUtils.dp2px(this.f25629b, (float) this.f25630c.getLineWidth()));
            lineOptions.type(6);
            lineOptions.add(this.f25632e);
            if (this.f25630c.getZIndex() != 0) {
                lineOptions.zIndex(this.f25630c.getZIndex());
            }
            if (this.f25630c.isClickable()) {
                lineOptions.clickable(this.f25630c.isClickable());
            }
            if (!this.f25630c.isEnableDirArrow()) {
                lineOptions.road(false);
            }
            Line addLine = this.f25628a.addLine(lineOptions);
            this.f25634g = addLine;
            addLine.modLineColor(this.f25630c.getLineColorWithArgb());
            LineExParam lineExParam = this.f25631d;
            if (!(lineExParam == null || lineExParam.getPulseBitmap() == null)) {
                this.f25634g.setPulseBitmap(this.f25631d.getPulseBitmap());
            }
            OnLineDrawStatusListener onLineDrawStatusListener = this.f25635h;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    public LatLng getArcLineCenter() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f25632e)) {
            return null;
        }
        if (this.f25632e.size() > 2) {
            List<LatLng> list = this.f25632e;
            return list.get(list.size() / 2);
        } else if (!LatLngUtils.locateCorrect(this.f25640m) || !LatLngUtils.locateCorrect(this.f25641n)) {
            return null;
        } else {
            double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(this.f25640m, this.f25641n);
            return DDSphericalUtil.computeOffset(this.f25641n, computeDistanceBetween * 0.5d, DDSphericalUtil.computeHeading(this.f25640m, this.f25641n));
        }
    }
}
