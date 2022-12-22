package com.didi.beatles.p099im.views.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.passenger.C10448R;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.widget.TriangleView */
public class TriangleView extends View {

    /* renamed from: a */
    private static final Direction f10503a = Direction.LEFT;

    /* renamed from: b */
    private static final int f10504b = IMResource.getColor(R.color.im_color_guide_view_bg);

    /* renamed from: c */
    private Paint f10505c;

    /* renamed from: d */
    private Path f10506d;

    /* renamed from: e */
    private Direction f10507e;

    /* renamed from: f */
    private int f10508f;

    /* renamed from: com.didi.beatles.im.views.widget.TriangleView$Direction */
    public enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

    public TriangleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7136a(attributeSet);
    }

    /* renamed from: a */
    private void m7136a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.TriangleView);
            int i = obtainStyledAttributes.getInt(1, 0);
            if (i == 0) {
                this.f10507e = Direction.LEFT;
            } else if (i == 1) {
                this.f10507e = Direction.UP;
            } else if (i != 2) {
                this.f10507e = Direction.DOWN;
            } else {
                this.f10507e = Direction.RIGHT;
            }
            this.f10508f = obtainStyledAttributes.getColor(0, f10504b);
            obtainStyledAttributes.recycle();
        } else {
            this.f10507e = f10503a;
            this.f10508f = f10504b;
        }
        Paint paint = new Paint();
        this.f10505c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f10505c.setColor(this.f10508f);
        this.f10505c.setAntiAlias(true);
    }

    public void setColor(int i) {
        if (this.f10508f != i) {
            this.f10508f = i;
            Paint paint = this.f10505c;
            if (paint != null) {
                paint.setColor(i);
            }
            this.f10506d = null;
            invalidate();
        }
    }

    public void setDirection(Direction direction) {
        if (direction != this.f10507e) {
            this.f10507e = direction;
            this.f10506d = null;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(getTrianglePath(), this.f10505c);
    }

    private Path getTrianglePath() {
        Point point;
        Point point2;
        Point point3;
        if (this.f10506d == null) {
            this.f10506d = new Path();
            int width = getWidth();
            int height = getHeight();
            int i = C44001.f10509xeb30cb29[this.f10507e.ordinal()];
            if (i == 1) {
                point3 = new Point(width, 0);
                point2 = new Point(width, height);
                point = new Point(0, height / 2);
            } else if (i == 2) {
                point3 = new Point(0, height);
                point2 = new Point(width, height);
                point = new Point(width / 2, 0);
            } else if (i != 3) {
                point3 = new Point(0, 0);
                point2 = new Point(width, 0);
                point = new Point(width / 2, height);
            } else {
                point3 = new Point(0, 0);
                point2 = new Point(0, height);
                point = new Point(width, height / 2);
            }
            this.f10506d.moveTo((float) point3.x, (float) point3.y);
            this.f10506d.lineTo((float) point2.x, (float) point2.y);
            this.f10506d.lineTo((float) point.x, (float) point.y);
        }
        return this.f10506d;
    }

    /* renamed from: com.didi.beatles.im.views.widget.TriangleView$1 */
    static /* synthetic */ class C44001 {

        /* renamed from: $SwitchMap$com$didi$beatles$im$views$widget$TriangleView$Direction */
        static final /* synthetic */ int[] f10509xeb30cb29;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.beatles.im.views.widget.TriangleView$Direction[] r0 = com.didi.beatles.p099im.views.widget.TriangleView.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10509xeb30cb29 = r0
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p099im.views.widget.TriangleView.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10509xeb30cb29     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p099im.views.widget.TriangleView.Direction.UP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10509xeb30cb29     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p099im.views.widget.TriangleView.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10509xeb30cb29     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p099im.views.widget.TriangleView.Direction.DOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.widget.TriangleView.C44001.<clinit>():void");
        }
    }
}
