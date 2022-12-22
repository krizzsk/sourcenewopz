package com.didi.rfusion.widget.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.taxis99.R;

class RFBadgeV2 extends View implements C11527a {

    /* renamed from: b */
    private static final int f33333b = 99;

    /* renamed from: c */
    private static final int f33334c = 8;

    /* renamed from: d */
    private static final String f33335d = "+";

    /* renamed from: a */
    protected Paint.FontMetrics f33336a;

    /* renamed from: e */
    private int f33337e;

    /* renamed from: f */
    private int f33338f;

    /* renamed from: g */
    private String f33339g;

    /* renamed from: h */
    private Rect f33340h;

    /* renamed from: i */
    private TextPaint f33341i;

    /* renamed from: j */
    private float f33342j;

    /* renamed from: k */
    private int f33343k;

    /* renamed from: l */
    private RectF f33344l;

    /* renamed from: m */
    private Paint f33345m;

    /* renamed from: n */
    private int f33346n;

    /* renamed from: o */
    private int f33347o;

    /* renamed from: p */
    private int f33348p;

    /* renamed from: q */
    private int f33349q;

    /* renamed from: r */
    private int f33350r;

    public void hide() {
    }

    public void hideStock() {
    }

    public void show() {
    }

    public void showStock() {
    }

    public void showStock(int i) {
    }

    public RFBadgeV2(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFBadgeV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFBadgeV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33337e = 99;
        this.f33339g = "";
        m23445a(context);
    }

    /* renamed from: a */
    private void m23445a(Context context) {
        Resources resources = context.getResources();
        m23448b(resources);
        m23446a(resources);
        this.f33349q = resources.getDimensionPixelSize(R.dimen.rf_dimen_12);
        this.f33350r = resources.getDimensionPixelSize(R.dimen.rf_dimen_6);
    }

    /* renamed from: a */
    private void m23446a(Resources resources) {
        this.f33344l = new RectF();
        Paint paint = new Paint();
        this.f33345m = paint;
        paint.setAntiAlias(true);
        this.f33345m.setStyle(Paint.Style.FILL);
        this.f33347o = resources.getDimensionPixelSize(R.dimen.rf_dimen_8);
        this.f33348p = resources.getDimensionPixelSize(R.dimen.rf_dimen_20);
        int color = resources.getColor(R.color.rf_color_alert_red_100_FF4E45);
        this.f33346n = color;
        this.f33345m.setColor(color);
    }

    /* renamed from: b */
    private void m23448b(Resources resources) {
        this.f33340h = new Rect();
        TextPaint textPaint = new TextPaint();
        this.f33341i = textPaint;
        textPaint.setAntiAlias(true);
        this.f33341i.setSubpixelText(true);
        this.f33341i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.f33341i.setTextAlign(Paint.Align.CENTER);
        float dimensionPixelSize = (float) resources.getDimensionPixelSize(R.dimen.f_11_app_24_pad_14);
        this.f33342j = dimensionPixelSize;
        this.f33341i.setTextSize(dimensionPixelSize);
        int color = resources.getColor(R.color.rf_color_white_100_FFFFFF);
        this.f33343k = color;
        this.f33341i.setColor(color);
        this.f33336a = this.f33341i.getFontMetrics();
    }

    /* renamed from: a */
    private void m23447a(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.f33341i.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        if (TextUtils.isEmpty(this.f33339g)) {
            canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (float) this.f33347o, this.f33345m);
        } else if (this.f33339g.length() == 1) {
            canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (float) this.f33348p, this.f33345m);
            canvas.drawText(this.f33339g, ((float) getMeasuredWidth()) / 2.0f, (((float) getMeasuredHeight()) / 2.0f) + ((f / 2.0f) - fontMetrics.descent), this.f33341i);
        } else {
            this.f33341i.measureText(this.f33339g);
            this.f33344l.left = ((((float) getMeasuredWidth()) / 2.0f) - (((float) this.f33340h.width()) / 2.0f)) - ((float) this.f33349q);
            this.f33344l.top = ((((float) getMeasuredHeight()) / 2.0f) - (((float) this.f33340h.height()) / 2.0f)) - ((float) this.f33350r);
            this.f33344l.right = (float) getMeasuredWidth();
            this.f33344l.bottom = (float) getMeasuredHeight();
            RectF rectF = this.f33344l;
            int i = this.f33348p;
            canvas.drawRoundRect(rectF, (float) i, (float) i, this.f33345m);
            canvas.drawText(this.f33339g, this.f33344l.left + (this.f33344l.width() / 2.0f), (((this.f33344l.bottom + this.f33344l.top) - this.f33336a.bottom) - this.f33336a.top) / 2.0f, this.f33341i);
        }
    }

    /* renamed from: a */
    private void m23444a() {
        this.f33340h.left = 0;
        this.f33340h.top = 0;
        if (TextUtils.isEmpty(this.f33339g)) {
            this.f33340h.right = 0;
            this.f33340h.bottom = 0;
            return;
        }
        TextPaint textPaint = this.f33341i;
        String str = this.f33339g;
        textPaint.getTextBounds(str, 0, str.length(), this.f33340h);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m23447a(canvas);
    }

    public void setMaxBadgeNumber(int i) {
        this.f33337e = i;
    }

    public int getMaxBadgeNumber() {
        return this.f33337e;
    }

    public void setBadgeNumber(int i) {
        this.f33338f = i;
        int i2 = this.f33337e;
        if (i <= i2) {
            this.f33339g = String.valueOf(i);
        } else if (i > i2) {
            this.f33339g = this.f33337e + "+";
        }
        m23444a();
        invalidate();
    }

    public int getBadgeNumber() {
        return this.f33338f;
    }

    public void setBadgeText(String str) {
        if (str.length() > 8) {
            this.f33339g = str.substring(0, 8);
        } else {
            this.f33339g = str;
        }
        m23444a();
        invalidate();
    }

    public String getBadgeText() {
        return this.f33339g;
    }

    public void clearContent() {
        this.f33339g = "";
        m23444a();
        invalidate();
    }
}
