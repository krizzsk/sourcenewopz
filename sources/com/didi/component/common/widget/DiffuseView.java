package com.didi.component.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DiffuseView extends View {

    /* renamed from: a */
    private static final int f12009a = 3;

    /* renamed from: b */
    private int f12010b;

    /* renamed from: c */
    private int f12011c;

    /* renamed from: d */
    private Bitmap f12012d;

    /* renamed from: e */
    private int f12013e;

    /* renamed from: f */
    private int f12014f;

    /* renamed from: g */
    private Integer f12015g;

    /* renamed from: h */
    private boolean f12016h;

    /* renamed from: i */
    private List<Integer> f12017i;

    /* renamed from: j */
    private List<Integer> f12018j;

    /* renamed from: k */
    private Paint f12019k;

    /* renamed from: l */
    private int f12020l;

    public DiffuseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12010b = getResources().getColor(R.color.colorAccent);
        this.f12011c = getResources().getColor(R.color.colorPrimary);
        this.f12013e = 150;
        this.f12014f = 3;
        this.f12015g = 255;
        this.f12016h = false;
        this.f12017i = new ArrayList();
        this.f12018j = new ArrayList();
        m8101a();
        m8103b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.DiffuseView, i, 0);
        this.f12010b = obtainStyledAttributes.getColor(0, this.f12010b);
        this.f12011c = obtainStyledAttributes.getColor(1, this.f12011c);
        this.f12013e = obtainStyledAttributes.getDimensionPixelSize(3, this.f12013e);
        this.f12014f = obtainStyledAttributes.getInt(5, this.f12014f);
        this.f12015g = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(4, this.f12015g.intValue()));
        int resourceId = obtainStyledAttributes.getResourceId(2, -1);
        if (resourceId != -1) {
            this.f12012d = BitmapFactory.decodeResource(getResources(), resourceId);
        }
        obtainStyledAttributes.recycle();
        this.f12020l = this.f12015g.intValue() / this.f12014f;
    }

    /* renamed from: a */
    private void m8101a() {
        Paint paint = new Paint();
        this.f12019k = paint;
        paint.setAntiAlias(true);
    }

    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.f12016h) {
            this.f12019k.setColor(this.f12010b);
            for (int i = 0; i < this.f12017i.size(); i++) {
                Integer num = this.f12017i.get(i);
                this.f12019k.setAlpha(num.intValue());
                Integer num2 = this.f12018j.get(i);
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (this.f12013e + num2.intValue()), this.f12019k);
                if (num.intValue() > 0 && num2.intValue() < this.f12015g.intValue()) {
                    this.f12017i.set(i, Integer.valueOf(num.intValue() - (255 / this.f12020l)));
                    this.f12018j.set(i, Integer.valueOf(num2.intValue() + 1));
                }
            }
            List<Integer> list = this.f12018j;
            if (list.get(list.size() - 1).intValue() == this.f12020l) {
                this.f12017i.add(255);
                this.f12018j.add(0);
            }
            if (this.f12018j.size() >= 3) {
                this.f12018j.remove(0);
                this.f12017i.remove(0);
            }
            m8102a(canvas);
            if (this.f12016h) {
                invalidate();
                return;
            }
            return;
        }
        m8102a(canvas);
    }

    /* renamed from: a */
    private void m8102a(Canvas canvas) {
        this.f12019k.setAlpha(255);
        this.f12019k.setColor(this.f12011c);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.f12013e, this.f12019k);
        Bitmap bitmap = this.f12012d;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (float) ((getWidth() / 2) - (this.f12012d.getWidth() / 2)), (float) ((getHeight() / 2) - (this.f12012d.getHeight() / 2)), this.f12019k);
        }
    }

    public void start() {
        this.f12016h = true;
        invalidate();
    }

    /* renamed from: b */
    private void m8103b() {
        this.f12017i.clear();
        this.f12018j.clear();
        this.f12017i.add(255);
        this.f12018j.add(0);
    }

    public void clear() {
        stop();
        m8103b();
        invalidate();
    }

    public void stop() {
        this.f12016h = false;
    }

    public boolean isDiffuse() {
        return this.f12016h;
    }

    public void setColor(int i) {
        this.f12010b = i;
    }

    public void setCoreColor(int i) {
        this.f12011c = i;
    }

    public void setCoreImage(int i) {
        this.f12012d = BitmapFactory.decodeResource(getResources(), i);
    }

    public void setCoreRadius(int i) {
        this.f12013e = i;
    }

    public void setDiffuseWidth(int i) {
        this.f12014f = i;
        this.f12020l = this.f12015g.intValue() / this.f12014f;
    }

    public void setMaxWidth(int i) {
        Integer valueOf = Integer.valueOf(i);
        this.f12015g = valueOf;
        this.f12020l = valueOf.intValue() / this.f12014f;
    }
}
