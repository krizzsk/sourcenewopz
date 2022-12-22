package com.didi.soda.home.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/home/widget/TrapezoidDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "topPercent", "", "bottomPercent", "rightColor", "roundCorner", "(IIII)V", "rightPaint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "Builder", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TrapezoidDrawable.kt */
public final class TrapezoidDrawable extends GradientDrawable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f43345a;

    /* renamed from: b */
    private int f43346b;

    /* renamed from: c */
    private int f43347c;

    /* renamed from: d */
    private int f43348d;

    /* renamed from: e */
    private final Paint f43349e;

    public int getOpacity() {
        return -3;
    }

    public TrapezoidDrawable(int i, int i2, int i3, int i4) {
        this.f43345a = i;
        this.f43346b = i2;
        this.f43347c = i3;
        this.f43348d = i4;
        setAlpha(0);
        Paint paint = new Paint();
        this.f43349e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f43349e.setAntiAlias(true);
        this.f43349e.setColor(this.f43347c);
    }

    public void draw(Canvas canvas) {
        int i;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        int i2 = this.f43345a;
        if (i2 > 0 && (i = this.f43346b) > 0 && i2 < 100 && i < 100) {
            Path path = new Path();
            path.lineTo((float) bounds.right, (float) bounds.top);
            path.lineTo((float) bounds.right, (float) bounds.bottom);
            path.lineTo((float) ((int) (((double) (bounds.right * (100 - this.f43346b))) * 0.01d)), (float) bounds.bottom);
            path.lineTo((float) ((int) (((double) (bounds.right * (100 - this.f43345a))) * 0.01d)), (float) bounds.top);
            if (this.f43348d > 0) {
                Path path2 = new Path();
                RectF rectF = new RectF(bounds);
                int i3 = this.f43348d;
                path2.addRoundRect(rectF, (float) i3, (float) i3, Path.Direction.CCW);
                path.op(path2, Path.Op.INTERSECT);
            }
            canvas.drawPath(path, this.f43349e);
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/home/widget/TrapezoidDrawable$Companion;", "", "()V", "build", "Lcom/didi/soda/home/widget/TrapezoidDrawable;", "block", "Lkotlin/Function1;", "Lcom/didi/soda/home/widget/TrapezoidDrawable$Builder;", "", "Lkotlin/ExtensionFunctionType;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TrapezoidDrawable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrapezoidDrawable build(Function1<? super Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Builder builder = new Builder();
            function1.invoke(builder);
            return builder.build();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/home/widget/TrapezoidDrawable$Builder;", "", "()V", "bottomPercent", "", "getBottomPercent", "()I", "setBottomPercent", "(I)V", "rightColor", "getRightColor", "setRightColor", "roundCorner", "getRoundCorner", "setRoundCorner", "topPercent", "getTopPercent", "setTopPercent", "build", "Lcom/didi/soda/home/widget/TrapezoidDrawable;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TrapezoidDrawable.kt */
    public static final class Builder {
        private int bottomPercent = 50;
        private int rightColor;
        private int roundCorner;
        private int topPercent = 20;

        public final int getRightColor() {
            return this.rightColor;
        }

        public final void setRightColor(int i) {
            this.rightColor = i;
        }

        public final int getTopPercent() {
            return this.topPercent;
        }

        public final void setTopPercent(int i) {
            this.topPercent = i;
        }

        public final int getBottomPercent() {
            return this.bottomPercent;
        }

        public final void setBottomPercent(int i) {
            this.bottomPercent = i;
        }

        public final int getRoundCorner() {
            return this.roundCorner;
        }

        public final void setRoundCorner(int i) {
            this.roundCorner = i;
        }

        public final TrapezoidDrawable build() {
            return new TrapezoidDrawable(this.topPercent, this.bottomPercent, this.rightColor, this.roundCorner);
        }
    }
}
