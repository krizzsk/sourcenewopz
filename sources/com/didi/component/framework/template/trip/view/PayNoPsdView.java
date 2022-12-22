package com.didi.component.framework.template.trip.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class PayNoPsdView extends LinearLayout {

    /* renamed from: a */
    private LinearLayout f13994a;

    /* renamed from: b */
    private Path f13995b;

    /* renamed from: c */
    private int f13996c;

    /* renamed from: d */
    private int f13997d;

    /* renamed from: e */
    private int f13998e;

    /* renamed from: f */
    private int f13999f;

    public PayNoPsdView(Context context) {
        super(context);
        m9764a(context);
    }

    /* renamed from: a */
    private void m9764a(Context context) {
        inflate(context, R.layout.global_pay_no_psd_processing_layout, this);
        this.f13994a = (LinearLayout) findViewById(R.id.pay_no_psd_real_layout);
        this.f13996c = UIUtils.dip2px(context, 25.0f);
    }

    public ViewGroup getInnerLayout() {
        return this.f13994a;
    }

    /* renamed from: a */
    private void m9763a() {
        if (getWidth() != this.f13997d || getHeight() != this.f13998e || this.f13999f != this.f13996c) {
            this.f13997d = getWidth();
            this.f13998e = getHeight();
            this.f13999f = this.f13996c;
            this.f13995b.reset();
            Path path = this.f13995b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.f13997d, (float) this.f13998e);
            int i = this.f13996c;
            path.addRoundRect(rectF, new float[]{(float) i, (float) i, (float) i, (float) i, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        }
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        m9763a();
        canvas.clipPath(this.f13995b);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }
}
