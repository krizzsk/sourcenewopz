package com.didi.entrega.order.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.didi.common.map.util.DisplayUtils;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SpreadView extends View {

    /* renamed from: w */
    private static final int f20939w = 16;

    /* renamed from: a */
    private Paint f20940a;

    /* renamed from: b */
    private int f20941b;

    /* renamed from: c */
    private float f20942c;

    /* renamed from: d */
    private float f20943d;

    /* renamed from: e */
    private int f20944e;

    /* renamed from: f */
    private int f20945f;

    /* renamed from: g */
    private int f20946g;

    /* renamed from: h */
    private int f20947h;

    /* renamed from: i */
    private int f20948i;

    /* renamed from: j */
    private int f20949j;

    /* renamed from: k */
    private int f20950k;

    /* renamed from: l */
    private List<Integer> f20951l;

    /* renamed from: m */
    private List<Integer> f20952m;

    /* renamed from: n */
    private boolean f20953n;

    /* renamed from: o */
    private boolean f20954o;

    /* renamed from: p */
    private int f20955p;

    /* renamed from: q */
    private Paint f20956q;

    /* renamed from: r */
    private Paint f20957r;

    /* renamed from: s */
    private int f20958s;

    /* renamed from: t */
    private int f20959t;

    /* renamed from: u */
    private Bitmap f20960u;

    /* renamed from: v */
    private SpreadViewType f20961v;

    /* renamed from: x */
    private String f20962x;

    /* renamed from: y */
    private Boolean f20963y;

    /* renamed from: z */
    private PaintFlagsDrawFilter f20964z;

    public enum SpreadViewType {
        SENDER_CENTER
    }

    public void setCountDownTimeStr(String str, Boolean bool) {
        this.f20962x = str;
        this.f20963y = bool;
    }

    public SpreadView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SpreadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20941b = 2;
        this.f20944e = 2;
        this.f20945f = 5;
        this.f20946g = 300;
        this.f20947h = 76;
        this.f20948i = 10;
        this.f20950k = 16;
        this.f20951l = new ArrayList();
        this.f20952m = new ArrayList();
        this.f20953n = false;
        this.f20954o = false;
        this.f20961v = null;
        this.f20962x = "";
        this.f20963y = false;
        this.f20949j = (CustomerSystemUtil.getScreenWidth(context) * 2) / 3;
        this.f20946g = (CustomerSystemUtil.getScreenWidth(context) / 2) - getResources().getDimensionPixelOffset(R.dimen.rf_dimen_140);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.EntregaSpreadView, i, 0);
        obtainStyledAttributes.getColor(2, ContextCompat.getColor(context, R.color.rf_color_white_100_FFFFFF));
        obtainStyledAttributes.getColor(5, ContextCompat.getColor(context, R.color.rf_color_white_100_FFFFFF));
        obtainStyledAttributes.getColor(1, ContextCompat.getColor(context, R.color.rf_color_jianbian_4_31B77E));
        int color = obtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color.rf_color_white_100_FFFFFF));
        this.f20945f = obtainStyledAttributes.getInt(4, this.f20945f);
        this.f20955p = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_24);
        this.f20950k = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_10);
        obtainStyledAttributes.recycle();
        this.f20952m.add(Integer.valueOf(this.f20947h));
        this.f20951l.add(0);
        Paint paint = new Paint();
        this.f20940a = paint;
        paint.setAlpha(this.f20947h);
        Paint paint2 = new Paint();
        this.f20957r = paint2;
        paint2.setAntiAlias(true);
        this.f20957r.setStyle(Paint.Style.FILL);
        this.f20957r.setTextSize((float) DisplayUtils.sp2px(context, 16.0f));
        this.f20957r.setColor(color);
        this.f20964z = new PaintFlagsDrawFilter(0, 3);
        Paint paint3 = new Paint();
        this.f20956q = paint3;
        paint3.setAntiAlias(true);
        this.f20956q.setFilterBitmap(true);
    }

    public void onResume() {
        this.f20954o = true;
        invalidate();
    }

    public void onPause() {
        this.f20954o = false;
    }

    public void start() {
        this.f20953n = true;
        invalidate();
    }

    public void stop() {
        this.f20953n = false;
    }

    public void onDestroy() {
        this.f20953n = false;
        this.f20951l.clear();
        this.f20952m.clear();
        Bitmap bitmap = this.f20960u;
        if (bitmap != null) {
            bitmap.recycle();
            this.f20960u = null;
        }
        this.f20951l = null;
        this.f20961v = null;
        this.f20952m = null;
        System.gc();
    }

    public void setSpreadType(SpreadViewType spreadViewType) {
        this.f20961v = spreadViewType;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.entrega_count_down_bg);
        this.f20960u = decodeResource;
        if (decodeResource != null) {
            this.f20958s = decodeResource.getWidth();
            this.f20959t = this.f20960u.getHeight();
        }
    }

    public SpreadViewType getSpreadType() {
        return this.f20961v;
    }

    public void updateLocation(float f, float f2) {
        this.f20942c = f;
        this.f20943d = f2 - ((float) this.f20955p);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.f20953n && this.f20954o) {
            for (int i2 = 0; i2 < this.f20951l.size(); i2++) {
                int intValue = this.f20952m.get(i2).intValue();
                this.f20940a.setAlpha(intValue);
                int intValue2 = this.f20951l.get(i2).intValue();
                if (intValue2 > 0) {
                    float f = (float) intValue2;
                    float f2 = f;
                    this.f20940a.setShader(new RadialGradient(this.f20942c, this.f20943d, f2, new int[]{-1, ResourceHelper.getColor(R.color.entrega_spread_gradinet_white), ResourceHelper.getColor(R.color.entrega_spread_gradinet_blue)}, new float[]{0.0f, 0.46f, 1.0f}, Shader.TileMode.CLAMP));
                    canvas.drawCircle(this.f20942c, this.f20943d, f, this.f20940a);
                }
                if (intValue > 0 && intValue2 < (i = this.f20949j)) {
                    this.f20952m.set(i2, Integer.valueOf((this.f20947h * (i - intValue2)) / i));
                    this.f20951l.set(i2, Integer.valueOf(intValue2 + this.f20945f));
                }
            }
            List<Integer> list = this.f20951l;
            if (list.get(list.size() - 1).intValue() > this.f20946g) {
                this.f20951l.add(0);
                this.f20952m.add(Integer.valueOf(this.f20947h));
            }
            if (this.f20951l.size() > this.f20944e) {
                this.f20952m.remove(0);
                this.f20951l.remove(0);
            }
            if (this.f20960u != null && !TextUtils.isEmpty(this.f20962x) && !this.f20963y.booleanValue()) {
                float f3 = this.f20942c - (((float) this.f20958s) * 0.5f);
                float f4 = this.f20943d - (((float) this.f20959t) * 0.5f);
                float measureText = this.f20957r.measureText(this.f20962x);
                Paint.FontMetrics fontMetrics = this.f20957r.getFontMetrics();
                float f5 = ((fontMetrics.bottom - fontMetrics.top) * 0.5f) - fontMetrics.bottom;
                float f6 = (((float) this.f20958s) * 0.5f) - (measureText * 0.5f);
                float f7 = ((((float) this.f20959t) * 0.5f) - (f5 * 0.5f)) + ((float) this.f20950k);
                canvas.drawBitmap(this.f20960u, f3, f4, this.f20956q);
                canvas.setDrawFilter(this.f20964z);
                canvas.drawText(this.f20962x, f3 + f6, f4 + f7, this.f20957r);
            }
            postInvalidateDelayed((long) this.f20948i);
        }
    }
}
