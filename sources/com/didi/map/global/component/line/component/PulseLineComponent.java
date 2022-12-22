package com.didi.map.global.component.line.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.ICompLineContract;
import java.util.ArrayList;
import java.util.List;

public class PulseLineComponent implements ICompLineContract {
    public static final String TAG = "PulseLineComponent";

    /* renamed from: a */
    private LineParams f25690a;

    /* renamed from: b */
    private LineExParam f25691b;

    /* renamed from: c */
    private Context f25692c;

    /* renamed from: d */
    private Map f25693d;

    /* renamed from: e */
    private ValueAnimator f25694e;

    /* renamed from: f */
    private Interpolator f25695f;

    /* renamed from: g */
    private Line f25696g;

    /* renamed from: h */
    private LineOptions f25697h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnLineDrawStatusListener f25698i;

    /* renamed from: j */
    private List<LatLng> f25699j = new ArrayList();

    /* renamed from: k */
    private int f25700k = 0;

    public void onMapVisible(boolean z) {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f25692c = context;
        this.f25693d = map;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null) {
            this.f25690a = lineParams;
            LineExParam exParam = lineParams.getExParam();
            this.f25691b = exParam;
            this.f25700k = exParam.getPulseAnimDuration() > 0 ? this.f25691b.getPulseAnimDuration() : 1500;
            this.f25699j = this.f25690a.getLinePoints();
            if (this.f25690a.getLineColorWithArgb() == 0) {
                this.f25690a.setLineColorWithArgb(Color.parseColor("#66ffffff"));
            }
            if (this.f25690a.getLineWidth() == 0) {
                this.f25690a.setLineWidth(3);
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        Line line = this.f25696g;
        if (line != null) {
            arrayList.add(line);
        }
        return arrayList;
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25698i = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        Map map = this.f25693d;
        if (map != null && onLineClickListener != null) {
            map.addOnLineClickListener(new OnLineClickListener(onLineClickListener) {
                public final /* synthetic */ OnLineClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onLineClick(Line line) {
                    PulseLineComponent.this.m18331a(this.f$1, line);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18331a(OnLineClickListener onLineClickListener, Line line) {
        if (line == this.f25696g) {
            onLineClickListener.onLineClick(this);
        }
    }

    public void start() {
        m18329a();
        ValueAnimator valueAnimator = this.f25694e;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void stop() {
        ValueAnimator valueAnimator = this.f25694e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void destroy() {
        stop();
        Line line = this.f25696g;
        if (line != null) {
            this.f25693d.remove(line);
            this.f25696g.remove();
            this.f25696g = null;
        }
        this.f25695f = null;
        this.f25692c = null;
        this.f25694e = null;
        this.f25690a = null;
        this.f25697h = null;
        this.f25693d = null;
    }

    public void setLineVisible(boolean z) {
        Line line = this.f25696g;
        if (line != null) {
            line.setVisible(z);
        }
    }

    /* renamed from: a */
    private void m18332a(List<LatLng> list) {
        if (this.f25692c != null && this.f25693d != null && this.f25690a != null) {
            if (this.f25697h == null) {
                LineOptions lineOptions = new LineOptions();
                this.f25697h = lineOptions;
                lineOptions.color(this.f25690a.getLineColorWithArgb());
                this.f25697h.width((double) DisplayUtils.dp2px(this.f25692c, (float) this.f25690a.getLineWidth()));
                this.f25697h.lineEndType(1);
                if (this.f25690a.getZIndex() != 0) {
                    this.f25697h.zIndex(this.f25690a.getZIndex());
                }
                if (this.f25690a.isClickable()) {
                    this.f25697h.clickable(this.f25690a.isClickable());
                }
            }
            Line line = this.f25696g;
            if (line == null) {
                this.f25697h.setPoints(list);
                this.f25696g = this.f25693d.addLine(this.f25697h);
                return;
            }
            line.setPoints(list);
        }
    }

    /* renamed from: a */
    private void m18329a() {
        List<LatLng> list;
        if (this.f25690a != null && (list = this.f25699j) != null && !list.isEmpty() && this.f25693d != null) {
            if (this.f25694e == null) {
                this.f25694e = ValueAnimator.ofInt(new int[]{0, this.f25699j.size()});
            }
            if (this.f25695f == null) {
                this.f25695f = PathInterpolatorCompat.create(0.6f, 0.0f, 0.4f, 1.0f);
            }
            this.f25694e.setInterpolator(this.f25695f);
            this.f25694e.setDuration((long) this.f25700k);
            this.f25694e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PulseLineComponent.this.m18330a(valueAnimator);
                }
            });
            this.f25694e.setRepeatMode(1);
            this.f25694e.setRepeatCount(-1);
            this.f25694e.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (PulseLineComponent.this.f25698i != null) {
                        PulseLineComponent.this.f25698i.onLineDrawFinished();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18330a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        List<LatLng> list = this.f25699j;
        if (list != null && intValue < list.size()) {
            m18332a(this.f25699j.subList(0, intValue));
        }
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25699j;
    }
}
