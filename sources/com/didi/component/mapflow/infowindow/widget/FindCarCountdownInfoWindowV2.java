package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.component.business.util.FormatUtils;
import com.didi.component.mapflow.infowindow.callback.CountDownCallback;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;

public final class FindCarCountdownInfoWindowV2 extends RelativeLayout implements ICountDownInfoWindow {
    public static final int DEFALUT_COUNT_DOWN_INTERVAL = 1;

    /* renamed from: a */
    private int f14289a;

    /* renamed from: b */
    private int f14290b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f14291c;

    /* renamed from: d */
    private boolean f14292d = false;

    /* renamed from: e */
    private RoundRctProgress f14293e;

    /* renamed from: f */
    private Context f14294f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CountDownCallback f14295g;

    /* renamed from: h */
    private CountDownTimer f14296h;

    public FindCarCountdownInfoWindowV2(Context context) {
        super(context);
        m9943a(context);
    }

    public FindCarCountdownInfoWindowV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9943a(context);
    }

    public FindCarCountdownInfoWindowV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9943a(context);
    }

    public FindCarCountdownInfoWindowV2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m9943a(context);
    }

    /* renamed from: a */
    private void m9943a(Context context) {
        inflate(context, R.layout.global_iw_find_car_count_down_v2, this);
        this.f14294f = context;
        this.f14293e = (RoundRctProgress) findViewById(R.id.count_down);
    }

    public void init(int i, int i2, int i3, CountDownCallback countDownCallback) {
        if (i > 0) {
            this.f14289a = i;
            this.f14290b = i3;
            this.f14295g = countDownCallback;
            this.f14291c = i2;
            this.f14296h = new CountDownTimer((long) (this.f14291c * 1000), (long) (i3 * 1000)) {
                public void onTick(long j) {
                    int unused = FindCarCountdownInfoWindowV2.this.f14291c = (int) (j / 1000);
                    FindCarCountdownInfoWindowV2.this.m9942a();
                    if (FindCarCountdownInfoWindowV2.this.f14295g != null) {
                        FindCarCountdownInfoWindowV2.this.f14295g.onTick((long) FindCarCountdownInfoWindowV2.this.f14291c);
                    }
                }

                public void onFinish() {
                    int unused = FindCarCountdownInfoWindowV2.this.f14291c = 0;
                    if (FindCarCountdownInfoWindowV2.this.f14295g != null) {
                        FindCarCountdownInfoWindowV2.this.f14295g.onTick((long) FindCarCountdownInfoWindowV2.this.f14291c);
                    }
                    FindCarCountdownInfoWindowV2.this.stop(true);
                }
            };
            this.f14292d = true;
            return;
        }
        throw new RuntimeException("Count must be bigger than 0");
    }

    public void start() {
        m9942a();
        this.f14296h.start();
    }

    public void stop(boolean z) {
        CountDownCallback countDownCallback;
        m9942a();
        CountDownTimer countDownTimer = this.f14296h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (z && (countDownCallback = this.f14295g) != null) {
            countDownCallback.onFinish();
        }
        this.f14292d = false;
    }

    public void restart(int i, int i2, int i3) {
        stop(false);
        this.f14292d = false;
        init(i, i2, i3, this.f14295g);
        start();
    }

    public RoundRctProgress getCountDownProgressBar() {
        return this.f14293e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9942a() {
        if (this.f14292d) {
            int i = this.f14291c;
            int i2 = i / 60;
            int i3 = i % 60;
            this.f14293e.setProgress(100.0f - (((((float) i) * 100.0f) / ((float) this.f14289a)) % 101.0f));
            RoundRctProgress roundRctProgress = this.f14293e;
            roundRctProgress.setText(FormatUtils.formatZeroWhenLessThan10(i2) + "'" + FormatUtils.formatZeroWhenLessThan10(i3) + Const.jsQuote);
            this.f14293e.update();
        }
    }
}
