package com.didi.component.expectation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class AnyCarBubbleTipLayout extends LinearLayout {

    /* renamed from: a */
    private Context f13672a;

    /* renamed from: b */
    private int f13673b;

    /* renamed from: c */
    private int f13674c;

    /* renamed from: d */
    private Point f13675d;

    /* renamed from: e */
    private int f13676e;

    /* renamed from: f */
    private int f13677f;

    /* renamed from: g */
    private Paint f13678g;

    /* renamed from: h */
    private Path f13679h;

    /* renamed from: i */
    private RectF f13680i;

    /* renamed from: j */
    private TextView f13681j;

    public AnyCarBubbleTipLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnyCarBubbleTipLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnyCarBubbleTipLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AnyCarBubbleTipLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f13672a = context;
        this.f13673b = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_offset);
        this.f13676e = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_triangle_width);
        this.f13677f = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_triangle_height);
        this.f13674c = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_radius);
        m9418a();
    }

    /* renamed from: a */
    private void m9418a() {
        Paint paint = new Paint();
        this.f13678g = paint;
        paint.setAntiAlias(true);
        this.f13679h = new Path();
        this.f13680i = new RectF();
        this.f13675d = new Point();
        setWillNotDraw(false);
        inflate(this.f13672a, R.layout.anycar_bubble_tip_layout, this);
        this.f13681j = (TextView) findViewById(R.id.center_text);
    }

    /* access modifiers changed from: package-private */
    public void setText(String str) {
        this.f13681j.setText(str);
    }

    /* access modifiers changed from: package-private */
    public void setTypeface(int i) {
        this.f13681j.setTypeface(Typeface.SANS_SERIF, i);
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int i) {
        this.f13681j.setMaxLines(i);
        this.f13681j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }

    public void setBubbleBackgroundColor(int i) {
        this.f13678g.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f13675d.x > 0 && this.f13675d.y > 0) {
            m9419a(canvas);
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m9419a(Canvas canvas) {
        Path path = this.f13679h;
        RectF rectF = this.f13680i;
        int i = this.f13674c;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f13679h.moveTo(((float) this.f13675d.x) + (((float) this.f13677f) / 2.0f), (float) this.f13675d.y);
        this.f13679h.lineTo((float) this.f13675d.x, ((float) this.f13675d.y) + (((float) this.f13676e) / 2.0f));
        this.f13679h.lineTo(((float) this.f13675d.x) - (((float) this.f13677f) / 2.0f), (float) this.f13675d.y);
        this.f13679h.close();
        canvas.drawPath(this.f13679h, this.f13678g);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f13680i.left = (float) getPaddingLeft();
        this.f13680i.top = (float) getPaddingTop();
        this.f13680i.right = (float) (i - getPaddingRight());
        this.f13680i.bottom = (float) (i2 - getPaddingBottom());
        this.f13675d.x = this.f13673b;
        this.f13675d.y = i2 - getPaddingBottom();
    }
}
