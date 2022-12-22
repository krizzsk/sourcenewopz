package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.Footer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.IBottomView;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.DensityUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.Footer.BallPulseView */
public class BallPulseView extends View implements IBottomView {
    public static final int DEFAULT_SIZE = 50;

    /* renamed from: a */
    private float f51270a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public float[] f51271b;

    /* renamed from: c */
    private ArrayList<ValueAnimator> f51272c;

    /* renamed from: d */
    private Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f51273d;

    /* renamed from: e */
    private Paint f51274e;

    /* renamed from: f */
    private int f51275f;

    /* renamed from: g */
    private int f51276g;

    public View getView() {
        return this;
    }

    public BallPulseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BallPulseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f51271b = new float[]{1.0f, 1.0f, 1.0f};
        this.f51273d = new HashMap();
        this.f51275f = -1118482;
        this.f51276g = -1615546;
        int dp2px = DensityUtil.dp2px(context, 50.0f);
        setLayoutParams(new FrameLayout.LayoutParams(dp2px, dp2px, 17));
        this.f51270a = (float) DensityUtil.dp2px(context, 4.0f);
        Paint paint = new Paint();
        this.f51274e = paint;
        paint.setColor(-1);
        this.f51274e.setStyle(Paint.Style.FILL);
        this.f51274e.setAntiAlias(true);
    }

    public void setIndicatorColor(int i) {
        this.f51274e.setColor(i);
    }

    public void setNormalColor(int i) {
        this.f51275f = i;
    }

    public void setAnimatingColor(int i) {
        this.f51276g = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float min = (((float) Math.min(getWidth(), getHeight())) - (this.f51270a * 2.0f)) / 6.0f;
        float f = 2.0f * min;
        float width = ((float) (getWidth() / 2)) - (this.f51270a + f);
        float height = (float) (getHeight() / 2);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f2 = (float) i;
            canvas.translate((f * f2) + width + (this.f51270a * f2), height);
            float[] fArr = this.f51271b;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, min, this.f51274e);
            canvas.restore();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f51272c != null) {
            for (int i = 0; i < this.f51272c.size(); i++) {
                this.f51272c.get(i).cancel();
            }
        }
    }

    public void startAnim() {
        if (this.f51272c == null) {
            m36716b();
        }
        if (this.f51272c != null && !m36714a()) {
            for (int i = 0; i < this.f51272c.size(); i++) {
                ValueAnimator valueAnimator = this.f51272c.get(i);
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f51273d.get(valueAnimator);
                if (animatorUpdateListener != null) {
                    valueAnimator.addUpdateListener(animatorUpdateListener);
                }
                valueAnimator.start();
            }
            setIndicatorColor(this.f51276g);
        }
    }

    public void stopAnim() {
        ArrayList<ValueAnimator> arrayList = this.f51272c;
        if (arrayList != null) {
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null && next.isStarted()) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
        setIndicatorColor(this.f51275f);
    }

    /* renamed from: a */
    private boolean m36714a() {
        Iterator<ValueAnimator> it = this.f51272c.iterator();
        if (it.hasNext()) {
            return it.next().isStarted();
        }
        return false;
    }

    /* renamed from: b */
    private void m36716b() {
        this.f51272c = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (final int i = 0; i < 3; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.3f, 1.0f});
            ofFloat.setDuration(750);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay((long) iArr[i]);
            this.f51273d.put(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseView.this.f51271b[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    BallPulseView.this.postInvalidate();
                }
            });
            this.f51272c.add(ofFloat);
        }
    }

    public void onPullingUp(float f, float f2, float f3) {
        stopAnim();
    }

    public void startAnim(float f, float f2) {
        startAnim();
    }

    public void onPullReleasing(float f, float f2, float f3) {
        stopAnim();
    }

    public void onFinish() {
        stopAnim();
    }

    public void reset() {
        stopAnim();
    }
}
