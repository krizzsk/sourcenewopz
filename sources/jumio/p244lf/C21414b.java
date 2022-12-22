package jumio.p244lf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.overlay.JVisionOverlay;
import com.taxis99.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.lf.b */
/* compiled from: LineFinderOverlay.kt */
public final class C21414b extends JVisionOverlay {

    /* renamed from: a */
    public final Paint f59772a;

    /* renamed from: b */
    public int f59773b;

    /* renamed from: c */
    public Path f59774c = new Path();

    /* renamed from: d */
    public C21416b f59775d;

    /* renamed from: e */
    public C21416b f59776e;

    /* renamed from: f */
    public C21416b f59777f;

    /* renamed from: g */
    public C21416b f59778g;

    /* renamed from: jumio.lf.b$a */
    /* compiled from: LineFinderOverlay.kt */
    public static final class C21415a {
        public C21415a() {
        }

        public /* synthetic */ C21415a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: jumio.lf.b$b */
    /* compiled from: LineFinderOverlay.kt */
    public final class C21416b {

        /* renamed from: a */
        public final Paint f59779a;

        /* renamed from: b */
        public boolean f59780b;

        /* renamed from: c */
        public final Path f59781c = new Path();

        public C21416b(C21414b bVar, Paint paint) {
            Intrinsics.checkNotNullParameter(bVar, "this$0");
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.f59779a = paint;
        }

        /* renamed from: a */
        public final void mo175947a(boolean z) {
            this.f59780b = z;
        }

        /* renamed from: a */
        public final void mo175945a(int i, int i2, int i3, int i4) {
            this.f59781c.reset();
            this.f59781c.moveTo((float) i, (float) i2);
            this.f59781c.lineTo((float) i3, (float) i4);
            this.f59781c.close();
        }

        /* renamed from: a */
        public final void mo175946a(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.f59780b) {
                canvas.drawPath(this.f59781c, this.f59779a);
            }
        }
    }

    static {
        new C21415a((DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21414b(MobileContext mobileContext) {
        super(mobileContext);
        Intrinsics.checkNotNullParameter(mobileContext, "context");
        Paint paint = new Paint(1);
        this.f59772a = paint;
        this.f59773b = (int) ScreenUtil.dipToPx(mobileContext, 20.0f);
        this.f59775d = new C21416b(this, paint);
        this.f59776e = new C21416b(this, paint);
        this.f59777f = new C21416b(this, paint);
        this.f59778g = new C21416b(this, paint);
    }

    /* renamed from: a */
    public final Path mo175944a(Rect rect, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        float f = (float) rect.left;
        float f2 = (float) rect.right;
        float f3 = (float) rect.top;
        float f4 = (float) rect.bottom;
        Path path = new Path();
        float f5 = (float) i;
        float f6 = f3 + f5;
        path.moveTo(f, f6);
        if (i2 <= 0) {
            path.lineTo(f, f3);
            path.lineTo(f + f5, f3);
        } else {
            float f7 = (float) i2;
            path.lineTo(f, f3 + f7);
            path.quadTo(f, f3, f7 + f, f3);
            path.lineTo(f + f5, f3);
        }
        float f8 = f2 - f5;
        path.moveTo(f8, f3);
        if (i3 <= 0) {
            path.lineTo(f2, f3);
            path.lineTo(f2, f6);
        } else {
            float f9 = (float) i3;
            path.lineTo(f2 - f9, f3);
            path.quadTo(f2, f3, f2, f9 + f3);
            path.lineTo(f2, f6);
        }
        float f10 = f4 - f5;
        path.moveTo(f2, f10);
        if (i4 <= 0) {
            path.lineTo(f2, f4);
            path.lineTo(f8, f4);
        } else {
            float f11 = (float) i4;
            path.lineTo(f2, f4 - f11);
            path.quadTo(f2, f4, f2 - f11, f4);
            path.lineTo(f8, f4);
        }
        path.moveTo(f5 + f, f4);
        if (i5 <= 0) {
            path.lineTo(f, f4);
            path.lineTo(f, f10);
        } else {
            float f12 = (float) i5;
            path.lineTo(f + f12, f4);
            path.quadTo(f, f4, f, f4 - f12);
            path.lineTo(f, f10);
        }
        path.moveTo(f, f6);
        path.close();
        return path;
    }

    public void calculate(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "extractionArea");
        super.calculate(rect);
        int dpToPx = ScreenUtil.dpToPx((Context) getMobileContext(), 4) / 2;
        Rect rect2 = new Rect(getOverlayBounds().left - dpToPx, getOverlayBounds().top - dpToPx, getOverlayBounds().right + dpToPx, getOverlayBounds().bottom + dpToPx);
        this.f59774c = mo175944a(rect2, this.f59773b + dpToPx, this.topLeftCornerRadius + dpToPx, this.topRightCornerRadius + dpToPx, getBottomLeftCornerRadius() + dpToPx, getBottomRightCornerRadius() + dpToPx);
        C21416b bVar = this.f59775d;
        int i = rect2.left;
        int i2 = rect2.top;
        int i3 = this.f59773b;
        bVar.mo175945a(i, i2 + i3, i, rect2.bottom - i3);
        C21416b bVar2 = this.f59776e;
        int i4 = rect2.left;
        int i5 = this.f59773b;
        int i6 = rect2.top;
        bVar2.mo175945a(i4 + i5, i6, rect2.right - i5, i6);
        C21416b bVar3 = this.f59777f;
        int i7 = rect2.right;
        int i8 = rect2.top;
        int i9 = this.f59773b;
        bVar3.mo175945a(i7, i8 + i9, i7, rect2.bottom - i9);
        C21416b bVar4 = this.f59778g;
        int i10 = rect2.left;
        int i11 = this.f59773b;
        int i12 = rect2.bottom;
        bVar4.mo175945a(i10 + i11, i12, rect2.right - i11, i12);
    }

    public void doDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.doDraw(canvas);
        if (this.visibility.get() == 0) {
            canvas.drawPath(this.f59774c, this.f59772a);
            this.f59775d.mo175946a(canvas);
            this.f59776e.mo175946a(canvas);
            this.f59777f.mo175946a(canvas);
            this.f59778g.mo175946a(canvas);
        }
    }

    public void prepareDraw(boolean z) {
        super.prepareDraw(z);
        Paint largeBorderPaint = getLargeBorderPaint();
        Integer num = getStyleMap().get(Integer.valueOf(R.attr.jumio_scanOverlayTransparent));
        largeBorderPaint.setColor(num == null ? Color.parseColor("#401C2229") : num.intValue());
        this.borderPaint.setAlpha(0);
        this.f59772a.setStyle(Paint.Style.STROKE);
        Paint paint = this.f59772a;
        Integer num2 = getStyleMap().get(Integer.valueOf(R.attr.jumio_scanOverlay));
        paint.setColor(num2 == null ? -1 : num2.intValue());
        this.f59772a.setDither(true);
        this.f59772a.setAntiAlias(true);
        this.f59772a.setStrokeWidth((float) ScreenUtil.dpToPx((Context) getMobileContext(), 6));
    }

    public void update(ExtractionClient.ExtractionUpdate<?> extractionUpdate) {
        if ((extractionUpdate == null ? null : extractionUpdate.getData()) instanceof C21417c) {
            Object data = extractionUpdate.getData();
            if (data != null) {
                C21417c cVar = (C21417c) data;
                this.f59775d.mo175947a(cVar.mo175949b());
                this.f59776e.mo175947a(cVar.mo175951d());
                this.f59777f.mo175947a(cVar.mo175950c());
                this.f59778g.mo175947a(cVar.mo175948a());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.extraction.linefinder.extraction.LineFinderUpdate");
        }
        if (extractionUpdate != null && extractionUpdate.getState() == ExtractionUpdateState.resetOverlay) {
            this.f59775d.mo175947a(false);
            this.f59776e.mo175947a(false);
            this.f59777f.mo175947a(false);
            this.f59778g.mo175947a(false);
        }
    }
}
