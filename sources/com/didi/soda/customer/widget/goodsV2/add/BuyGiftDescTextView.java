package com.didi.soda.customer.widget.goodsV2.add;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.CustomerSkinTextView;
import com.taxis99.R;

public class BuyGiftDescTextView extends CustomerSkinTextView {
    public static final float RIGHT_OVERRIDING_SIZE = 0.5f;

    /* renamed from: a */
    private Paint f41948a;

    /* renamed from: b */
    private Path f41949b = new Path();

    /* renamed from: c */
    private int f41950c;

    /* renamed from: d */
    private int f41951d;

    /* renamed from: e */
    private int f41952e;

    public BuyGiftDescTextView(Context context) {
        super(context);
        m29573b();
    }

    public BuyGiftDescTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29573b();
    }

    public BuyGiftDescTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29573b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m29572a();
        this.f41949b.reset();
        this.f41949b.moveTo((float) (getRight() - DisplayUtils.dip2px(getContext(), 0.5f)), 0.0f);
        this.f41949b.lineTo((float) (getRight() - DisplayUtils.dip2px(getContext(), 10.0f)), (float) getBottom());
        this.f41949b.lineTo((float) getRight(), (float) getBottom());
        this.f41949b.close();
        canvas.drawPath(this.f41949b, this.f41948a);
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m29572a() {
        if (isPressed() && isEnabled()) {
            this.f41948a.setColor(this.f41950c);
        } else if (isEnabled()) {
            this.f41948a.setColor(this.f41951d);
        } else {
            this.f41948a.setColor(this.f41952e);
        }
    }

    /* renamed from: b */
    private void m29573b() {
        setBackgroundResource(R.drawable.customer_skin_selector_buy_gift_desc);
        setGravity(16);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.MEDIUM);
        int dip2px = DisplayUtils.dip2px(getContext(), 19.0f);
        setPadding(dip2px, 0, dip2px, 0);
        this.f41952e = getContext().getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC);
        this.f41951d = getContext().getResources().getColor(R.color.rf_color_jianbian_1);
        this.f41950c = getContext().getResources().getColor(R.color.rf_color_press_2_96);
        Paint paint = new Paint();
        this.f41948a = paint;
        paint.setAntiAlias(true);
        this.f41948a.setColor(this.f41951d);
        this.f41948a.setStyle(Paint.Style.FILL);
    }
}
