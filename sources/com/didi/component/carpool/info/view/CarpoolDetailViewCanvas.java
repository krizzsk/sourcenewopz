package com.didi.component.carpool.info.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.didi.component.carpool.info.model.CarpoolInfoItem;
import com.taxis99.R;
import java.util.List;

public class CarpoolDetailViewCanvas extends View {
    public static final int ITEM_STATUS_CURRENT = 0;
    public static final int ITEM_STATUS_HISTORY = 1;
    public static final int ITEM_STATUS_NORMAL = 2;
    public static final int ITEM_TYPE_END_POINT = 3;
    public static final int ITEM_TYPE_PICKUP_POINT = 1;
    public static final int ITEM_TYPE_START_POINT = 0;
    public static final int ITEM_TYPE_VIA_POINT = 2;

    /* renamed from: m */
    private static final int f11443m = Color.parseColor("#33BBFF");

    /* renamed from: n */
    private static final int f11444n = Color.parseColor("#919599");

    /* renamed from: o */
    private static final int f11445o = Color.parseColor("#D4D7D9");

    /* renamed from: p */
    private static final float f11446p = 37.0f;

    /* renamed from: q */
    private static final float f11447q = 31.0f;

    /* renamed from: r */
    private static final float f11448r = 23.0f;

    /* renamed from: s */
    private static final float f11449s = 31.0f;

    /* renamed from: a */
    private Context f11450a;

    /* renamed from: b */
    private int f11451b;

    /* renamed from: c */
    private List<CarpoolInfoItem> f11452c;

    /* renamed from: d */
    private boolean f11453d;

    /* renamed from: e */
    private boolean f11454e = false;

    /* renamed from: f */
    private int f11455f;

    /* renamed from: g */
    private int f11456g;

    /* renamed from: h */
    private int f11457h;

    /* renamed from: i */
    private Paint f11458i = new Paint(1);

    /* renamed from: j */
    private Paint f11459j;

    /* renamed from: k */
    private Paint f11460k;

    /* renamed from: l */
    private Paint f11461l;

    public CarpoolDetailViewCanvas(Context context) {
        super(context);
        m7751a();
    }

    public CarpoolDetailViewCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7751a();
    }

    public CarpoolDetailViewCanvas(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7751a();
    }

    /* renamed from: a */
    private void m7751a() {
        this.f11450a = getContext();
        this.f11455f = m7750a(20.0f);
        this.f11456g = m7750a(53.0f);
        this.f11457h = m7750a(27.0f);
        Paint paint = new Paint(1);
        this.f11459j = paint;
        paint.setColor(-3355444);
        Paint paint2 = new Paint(1);
        this.f11460k = paint2;
        paint2.setStrokeWidth((float) m7750a(2.0f));
        int a = m7750a(3.5f);
        Paint paint3 = new Paint(1);
        this.f11461l = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f11461l.setStrokeWidth((float) a);
        this.f11461l.setColor(f11443m);
        float a2 = (float) m7750a(6.0f);
        this.f11461l.setPathEffect(new DashPathEffect(new float[]{1.0f, a2, 1.0f, a2}, 0.0f));
        this.f11461l.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setTravelDetailData(List<CarpoolInfoItem> list, int i) {
        this.f11452c = list;
        this.f11451b = i;
        this.f11454e = false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f11453d = false;
        for (int i = 0; i < this.f11452c.size(); i++) {
            CarpoolInfoItem carpoolInfoItem = this.f11452c.get(i);
            int a = m7750a(f11446p) * i;
            int a2 = m7750a(31.0f) + a;
            int a3 = a + m7750a(f11448r);
            if (i == 0) {
                int i2 = this.f11451b;
                if (i2 == 1 || i2 == 2) {
                    this.f11453d = true;
                    this.f11454e = true;
                    m7752a(canvas, carpoolInfoItem.status, this.f11455f, a2);
                } else if (i2 == 1 || i2 == 3) {
                    this.f11454e = true;
                    m7754b(canvas, carpoolInfoItem.status, this.f11455f, (m7750a(f11446p) * i) + m7750a(31.0f));
                }
            }
            if (i == 1 && this.f11453d) {
                m7754b(canvas, carpoolInfoItem.status, this.f11455f, (m7750a(f11446p) * i) + m7750a(31.0f) + m7750a(15.5f));
            }
            if (carpoolInfoItem.viewType == 0 && carpoolInfoItem.showDotLine == 1) {
                m7756d(canvas, carpoolInfoItem.status, a3, m7750a(f11446p));
            } else if (carpoolInfoItem.viewType != 3) {
                int a4 = m7750a(f11446p);
                if (i == 1 && this.f11453d) {
                    a4 += m7750a(31.0f);
                }
                if (this.f11453d) {
                    a3 = (int) (((float) a3) + 31.0f);
                }
                m7755c(canvas, carpoolInfoItem.status, a3, a4);
            }
        }
    }

    /* renamed from: a */
    private void m7752a(Canvas canvas, int i, int i2, int i3) {
        Bitmap bitmap;
        if (i == 1) {
            bitmap = BitmapFactory.decodeResource(this.f11450a.getResources(), R.drawable.global_travel_detail_people_dis);
        } else {
            bitmap = BitmapFactory.decodeResource(this.f11450a.getResources(), R.drawable.global_travel_detail_people_nor);
        }
        canvas.drawBitmap(bitmap, (float) i2, (float) i3, this.f11458i);
        bitmap.recycle();
    }

    /* renamed from: b */
    private void m7754b(Canvas canvas, int i, int i2, int i3) {
        Bitmap bitmap;
        if (i == 1) {
            bitmap = BitmapFactory.decodeResource(this.f11450a.getResources(), R.drawable.global_travel_detail_car_icon_dis);
        } else {
            bitmap = BitmapFactory.decodeResource(this.f11450a.getResources(), R.drawable.global_travel_detail_car_icon_nor);
        }
        canvas.drawBitmap(bitmap, (float) i2, (float) i3, this.f11458i);
        bitmap.recycle();
    }

    /* renamed from: c */
    private void m7755c(Canvas canvas, int i, int i2, int i3) {
        if (i == 1) {
            this.f11460k.setColor(f11445o);
        } else {
            this.f11460k.setColor(f11444n);
        }
        canvas.drawLine((float) getLineStartX(), (float) i2, (float) getLineStartX(), (float) (i2 + i3), this.f11460k);
    }

    /* renamed from: d */
    private void m7756d(Canvas canvas, int i, int i2, int i3) {
        Path path = new Path();
        path.moveTo((float) getLineStartX(), (float) i2);
        path.lineTo((float) getLineStartX(), (float) (i2 + i3));
        m7753a(canvas, i == 1 ? f11445o : f11443m, path);
    }

    /* renamed from: a */
    private void m7753a(Canvas canvas, int i, Path path) {
        this.f11461l.setColor(i);
        canvas.drawPath(path, this.f11461l);
    }

    /* renamed from: a */
    private int m7750a(float f) {
        return (int) ((f * this.f11450a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int getLineStartX() {
        return !this.f11454e ? this.f11457h : this.f11456g + m7750a(0.5f);
    }
}
