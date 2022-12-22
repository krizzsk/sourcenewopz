package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C10448R;
import com.didiglobal.font.DIDIFontUtils;

public class RoundRctProgress extends View {
    public static final int PI_RADIUS = 180;

    /* renamed from: a */
    private float f14313a;

    /* renamed from: b */
    private int f14314b;

    /* renamed from: c */
    private int f14315c;

    /* renamed from: d */
    private int f14316d;

    /* renamed from: e */
    private int f14317e;

    /* renamed from: f */
    private int f14318f;

    /* renamed from: g */
    private int f14319g;

    /* renamed from: h */
    private int f14320h;

    /* renamed from: i */
    private PointF f14321i;

    /* renamed from: j */
    private PointF f14322j;

    /* renamed from: k */
    private float f14323k;

    /* renamed from: l */
    private RectF f14324l;

    /* renamed from: m */
    private RectF f14325m;

    /* renamed from: n */
    private Path f14326n = new Path();

    /* renamed from: o */
    private Path f14327o = new Path();

    /* renamed from: p */
    private RectF f14328p;

    /* renamed from: q */
    private RectF f14329q;

    /* renamed from: r */
    private Paint f14330r = new Paint();

    /* renamed from: s */
    private Paint f14331s = new Paint();

    /* renamed from: t */
    private Paint f14332t = new Paint();

    /* renamed from: u */
    private CharSequence f14333u;

    /* renamed from: v */
    private int f14334v;

    /* renamed from: w */
    private int f14335w;

    public void setProgress(int i) {
        this.f14313a = (float) i;
    }

    public RoundRctProgress(Context context) {
        super(context);
    }

    public RoundRctProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9957a(context, attributeSet);
    }

    public RoundRctProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9957a(context, attributeSet);
    }

    /* renamed from: a */
    private void m9957a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RoundRctProgress);
        this.f14313a = (float) obtainStyledAttributes.getInt(2, 0);
        this.f14314b = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f14315c = obtainStyledAttributes.getDimensionPixelOffset(0, 1);
        this.f14316d = obtainStyledAttributes.getInt(7, 315);
        this.f14317e = obtainStyledAttributes.getColor(3, Color.argb(90, 90, 90, 90));
        this.f14318f = obtainStyledAttributes.getColor(4, Color.argb(90, 90, 90, 90));
        this.f14334v = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.f14335w = obtainStyledAttributes.getColor(5, Color.argb(90, 90, 90, 90));
        obtainStyledAttributes.recycle();
        this.f14330r.setStyle(Paint.Style.STROKE);
        this.f14330r.setStrokeWidth((float) this.f14315c);
        this.f14330r.setAntiAlias(true);
        this.f14330r.setColor(this.f14317e);
        this.f14331s.setStyle(Paint.Style.STROKE);
        this.f14331s.setStrokeWidth((float) this.f14315c);
        this.f14331s.setAntiAlias(true);
        this.f14331s.setColor(this.f14318f);
        this.f14332t.setTextSize((float) this.f14334v);
        this.f14332t.setTypeface(Typeface.DEFAULT_BOLD);
        DIDIFontUtils.Companion.setPaintTypeface(getContext(), this.f14332t);
        this.f14332t.setColor(this.f14335w);
        this.f14332t.setStyle(Paint.Style.FILL);
        this.f14332t.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f14319g = i;
        this.f14320h = i2;
        float paddingStart = ((float) ((i - getPaddingStart()) - getPaddingEnd())) / 2.0f;
        float paddingTop = ((float) ((this.f14320h - getPaddingTop()) - getPaddingBottom())) / 2.0f;
        this.f14323k = (float) Math.sqrt((double) ((paddingStart * paddingStart) + (paddingTop * paddingTop)));
        this.f14321i = new PointF(((float) getPaddingStart()) + paddingStart, ((float) getPaddingTop()) + paddingTop);
        this.f14322j = new PointF((float) (((double) this.f14321i.x) + (((double) this.f14323k) * Math.cos((((double) this.f14316d) * 3.141592653589793d) / 180.0d))), (float) (((double) this.f14321i.y) + (((double) this.f14323k) * Math.sin((((double) this.f14316d) * 3.141592653589793d) / 180.0d))));
        this.f14324l = new RectF((float) getPaddingStart(), (float) getPaddingTop(), (float) (this.f14319g - getPaddingEnd()), (float) (this.f14320h - getPaddingBottom()));
        this.f14325m = new RectF((float) getPaddingStart(), (float) getPaddingTop(), (float) (this.f14319g - getPaddingEnd()), (float) (this.f14320h - getPaddingBottom()));
        this.f14328p = new RectF(this.f14321i.x - this.f14323k, this.f14321i.y - this.f14323k, this.f14321i.x + this.f14323k, this.f14321i.y + this.f14323k);
        this.f14329q = new RectF(this.f14321i.x - this.f14323k, this.f14321i.y - this.f14323k, this.f14321i.x + this.f14323k, this.f14321i.y + this.f14323k);
        this.f14326n.reset();
        this.f14327o.reset();
        Path path = this.f14326n;
        RectF rectF = this.f14324l;
        int i5 = this.f14314b;
        path.addRoundRect(rectF, (float) i5, (float) i5, Path.Direction.CW);
        Path path2 = this.f14327o;
        RectF rectF2 = this.f14325m;
        int i6 = this.f14314b;
        path2.addRoundRect(rectF2, (float) i6, (float) i6, Path.Direction.CW);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (!TextUtils.isEmpty(this.f14333u)) {
            CharSequence charSequence = this.f14333u;
            canvas.drawText((String) charSequence, (((float) this.f14319g) - this.f14332t.measureText(charSequence, 0, charSequence.length())) / 2.0f, (float) (((this.f14320h / 2) + (this.f14334v / 2)) - 2), this.f14332t);
        }
        this.f14326n.reset();
        this.f14327o.reset();
        Path path = this.f14326n;
        RectF rectF = this.f14324l;
        int i = this.f14314b;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
        Path path2 = this.f14327o;
        RectF rectF2 = this.f14325m;
        int i2 = this.f14314b;
        path2.addRoundRect(rectF2, (float) i2, (float) i2, Path.Direction.CW);
        canvas.clipPath(this.f14327o);
        canvas.clipPath(m9956a((float) this.f14316d, this.f14327o, this.f14329q), Region.Op.DIFFERENCE);
        RectF rectF3 = this.f14325m;
        int i3 = this.f14314b;
        canvas.drawRoundRect(rectF3, (float) i3, (float) i3, this.f14331s);
        canvas.clipPath(this.f14326n);
        canvas.clipPath(m9956a(((this.f14313a * 360.0f) / 100.0f) + ((float) this.f14316d), this.f14326n, this.f14328p), Region.Op.DIFFERENCE);
        RectF rectF4 = this.f14324l;
        int i4 = this.f14314b;
        canvas.drawRoundRect(rectF4, (float) i4, (float) i4, this.f14330r);
        canvas.restore();
    }

    /* renamed from: a */
    private Path m9956a(float f, Path path, RectF rectF) {
        path.reset();
        path.moveTo(this.f14321i.x, this.f14321i.y);
        path.lineTo(this.f14322j.x, this.f14322j.y);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        path.lineTo((float) (((double) this.f14321i.x) + (((double) this.f14323k) * Math.cos(d))), (float) (((double) this.f14321i.y) + (((double) this.f14323k) * Math.sin(d))));
        path.close();
        int i = this.f14316d;
        path.addArc(rectF, (float) i, f - ((float) i));
        return path;
    }

    public RoundRctProgress setProgress(float f) {
        this.f14313a = f;
        return this;
    }

    public RoundRctProgress setText(CharSequence charSequence) {
        this.f14333u = charSequence;
        return this;
    }

    public void update() {
        invalidate();
    }
}
