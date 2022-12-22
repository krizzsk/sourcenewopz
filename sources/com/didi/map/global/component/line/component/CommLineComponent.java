package com.didi.map.global.component.line.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommLineComponent implements ICompLineContract {
    public static final String TAG = "CommLineComponent";

    /* renamed from: a */
    private static final int f25643a = 1500;

    /* renamed from: b */
    private Context f25644b;

    /* renamed from: c */
    private Map f25645c;

    /* renamed from: d */
    private LineParams f25646d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LineExParam f25647e;

    /* renamed from: f */
    private Line f25648f;

    /* renamed from: g */
    private ValueAnimator f25649g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<LatLng> f25650h = new ArrayList();

    /* renamed from: i */
    private int f25651i = 1500;

    /* renamed from: j */
    private boolean f25652j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnLineDrawStatusListener f25653k;

    /* renamed from: l */
    private Interpolator f25654l;

    /* renamed from: m */
    private ICompLineContract f25655m;

    /* renamed from: n */
    private LineOptions f25656n;

    public void onMapVisible(boolean z) {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f25644b = context;
        this.f25645c = map;
    }

    public void setConfigParam(LineParams lineParams) {
        int i;
        if (lineParams != null) {
            this.f25646d = lineParams;
            LineExParam exParam = lineParams.getExParam();
            this.f25647e = exParam;
            if (exParam != null) {
                this.f25652j = exParam.isHasLineExtensionAnim();
                if (this.f25647e.getLineExtensionAnimDuration() == 0) {
                    i = 1500;
                } else {
                    i = this.f25647e.getLineExtensionAnimDuration();
                }
                this.f25651i = i;
            }
            if (this.f25646d.getLineColorWithArgb() == 0) {
                this.f25646d.setLineColorWithArgb(Color.parseColor("#33BBFF"));
            }
            if (this.f25646d.getLineWidth() == 0) {
                this.f25646d.setLineWidth(6);
            }
        }
    }

    public void start() {
        cancelExtensionAnim();
        LineParams lineParams = this.f25646d;
        if (lineParams != null) {
            this.f25650h = lineParams.getLinePoints();
            if (!CollectionUtil.isEmpty((Collection<?>) this.f25646d.getLinePoints())) {
                m18323b();
            }
        }
    }

    public void stop() {
        stopPulseAnim();
    }

    public void destroy() {
        stop();
        cancelExtensionAnim();
        Line line = this.f25648f;
        if (line != null) {
            line.remove();
            this.f25648f = null;
        }
        ICompLineContract iCompLineContract = this.f25655m;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25655m = null;
        }
        this.f25654l = null;
        this.f25649g = null;
        this.f25644b = null;
        this.f25645c = null;
    }

    public void stopPulseAnim() {
        ICompLineContract iCompLineContract = this.f25655m;
        if (iCompLineContract != null) {
            iCompLineContract.stop();
        }
    }

    public void drawPulseLine(List<LatLng> list) {
        if (this.f25644b != null && this.f25645c != null) {
            if (this.f25646d != null || this.f25647e == null) {
                ICompLineContract iCompLineContract = this.f25655m;
                if (iCompLineContract != null) {
                    iCompLineContract.destroy();
                    this.f25655m = null;
                }
                LineParams lineParams = new LineParams(list, this.f25647e.getPulseLineColor() == 0 ? Color.parseColor("#66ffffff") : this.f25647e.getPulseLineColor(), this.f25646d.getLineWidth() + 1);
                lineParams.setZIndex(this.f25646d.getZIndex() + 1);
                lineParams.setExParam(this.f25647e);
                ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_PULSE, this.f25645c, this.f25644b, lineParams);
                this.f25655m = createLineComponent;
                if (createLineComponent != null) {
                    createLineComponent.start();
                }
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f25648f;
        if (line != null) {
            arrayList.add(line);
        }
        ICompLineContract iCompLineContract = this.f25655m;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f25655m.getBestViewElements());
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25653k = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f25645c;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    CommLineComponent.this.m18320a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18320a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f25648f) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void setLineVisible(boolean z) {
        Line line = this.f25648f;
        if (line != null) {
            line.setVisible(z);
        }
        ICompLineContract iCompLineContract = this.f25655m;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    /* renamed from: a */
    private void m18321a(List<LatLng> list) {
        if (this.f25644b != null && this.f25645c != null) {
            if (C95152.$SwitchMap$com$didi$common$map$MapVendor[this.f25645c.getMapVendor().ordinal()] != 1) {
                m18324b(list);
            } else if (this.f25646d.isEnableEarthWormLine()) {
                m18326c(list);
            } else {
                m18324b(list);
            }
        }
    }

    /* renamed from: com.didi.map.global.component.line.component.CommLineComponent$2 */
    static /* synthetic */ class C95152 {
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

    /* renamed from: b */
    private void m18324b(List<LatLng> list) {
        if (this.f25648f != null || this.f25646d == null) {
            this.f25648f.setPoints(list);
            return;
        }
        LineOptions lineOptions = new LineOptions();
        lineOptions.color(this.f25646d.getLineColorWithArgb());
        lineOptions.width((double) DisplayUtils.dp2px(this.f25644b, (float) this.f25646d.getLineWidth()));
        lineOptions.lineEndType(1);
        lineOptions.clickable(true);
        if (this.f25646d.getZIndex() != 0) {
            lineOptions.zIndex(this.f25646d.getZIndex());
        }
        if (!this.f25646d.isEnableDirArrow()) {
            lineOptions.road(false);
        }
        lineOptions.setPoints(list);
        if (this.f25646d.isClickable()) {
            lineOptions.clickable(this.f25646d.isClickable());
        }
        this.f25648f = this.f25645c.addLine(lineOptions);
    }

    /* renamed from: c */
    private void m18326c(List<LatLng> list) {
        LineParams lineParams = this.f25646d;
        if (lineParams != null) {
            if (lineParams.getDidiColor() < 0) {
                this.f25646d.setDidiColor(24);
            }
            if (this.f25656n == null) {
                LineOptions lineOptions = new LineOptions();
                this.f25656n = lineOptions;
                lineOptions.type(0);
                this.f25656n.width((double) DisplayUtils.dp2px(this.f25644b, (float) this.f25646d.getLineWidth()));
                this.f25656n.lineEndType(1);
                if (this.f25646d.getZIndex() != 0) {
                    this.f25656n.zIndex(this.f25646d.getZIndex());
                }
                if (!this.f25646d.isEnableDirArrow()) {
                    this.f25656n.road(false);
                }
                LineOptions.MultiColorLineInfo[] multiColorLineInfoArr = {new LineOptions.MultiColorLineInfo()};
                multiColorLineInfoArr[0].pointIndex = 0;
                multiColorLineInfoArr[0].colorIndex = this.f25646d.getDidiColor();
                this.f25656n.multiColorLineInfo(multiColorLineInfoArr);
                this.f25656n.clickable(true);
            }
            if (this.f25648f == null) {
                this.f25656n.add(list);
                this.f25648f = this.f25645c.addLine(this.f25656n);
                return;
            }
            this.f25656n.setPoints(list);
            this.f25648f.setOptions(this.f25656n);
        }
    }

    /* renamed from: a */
    private void m18318a() {
        if (this.f25646d != null && this.f25645c != null) {
            if (this.f25649g == null) {
                this.f25649g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            }
            if (this.f25654l == null) {
                this.f25654l = PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f);
            }
            this.f25649g.setInterpolator(this.f25654l);
            this.f25649g.setDuration((long) this.f25651i);
            this.f25649g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommLineComponent.this.m18319a(valueAnimator);
                }
            });
            this.f25649g.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (CommLineComponent.this.f25647e != null && CommLineComponent.this.f25647e.isHasPulseAnim()) {
                        CommLineComponent commLineComponent = CommLineComponent.this;
                        commLineComponent.drawPulseLine(commLineComponent.f25650h);
                    }
                    if (CommLineComponent.this.f25653k != null) {
                        CommLineComponent.this.f25653k.onLineDrawFinished();
                    }
                    super.onAnimationEnd(animator);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18319a(ValueAnimator valueAnimator) {
        int size;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        List<LatLng> list = this.f25650h;
        if (list != null && this.f25650h.size() > (size = (int) (((float) list.size()) * floatValue))) {
            m18321a(this.f25650h.subList(0, size));
        }
    }

    public void startExtensionAnim() {
        ValueAnimator valueAnimator = this.f25649g;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void cancelExtensionAnim() {
        ValueAnimator valueAnimator = this.f25649g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* renamed from: b */
    private void m18323b() {
        if (this.f25652j) {
            m18318a();
            startExtensionAnim();
            return;
        }
        m18321a(this.f25650h);
        LineExParam lineExParam = this.f25647e;
        if (lineExParam != null && lineExParam.isHasPulseAnim()) {
            drawPulseLine(this.f25650h);
        }
        OnLineDrawStatusListener onLineDrawStatusListener = this.f25653k;
        if (onLineDrawStatusListener != null) {
            onLineDrawStatusListener.onLineDrawFinished();
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25650h;
    }
}
