package com.jumio.core.extraction.liveness.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.overlay.Overlay;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import jumio.core.C21366l0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\b\b\b\u0016\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b6\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\u00158\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020\u00158\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R(\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015008\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, mo175978d2 = {"Lcom/jumio/core/extraction/liveness/overlay/LivenessOverlay;", "Lcom/jumio/core/overlay/Overlay;", "Landroid/graphics/Rect;", "extractionArea", "", "calculate", "Landroid/view/ViewGroup;", "rootView", "addViews", "Lcom/jumio/core/models/ScanPartModel;", "scanPartModel", "setScanPart", "", "isFrontCamera", "prepareDraw", "Landroid/graphics/Canvas;", "canvas", "doDraw", "Lcom/jumio/core/extraction/ExtractionClient$ExtractionUpdate;", "extractionUpdate", "update", "", "invisible", "setVisible", "Lcom/jumio/core/MobileContext;", "a", "Lcom/jumio/core/MobileContext;", "getContext", "()Lcom/jumio/core/MobileContext;", "setContext", "(Lcom/jumio/core/MobileContext;)V", "context", "b", "Landroid/graphics/Rect;", "getOverlayBounds", "()Landroid/graphics/Rect;", "overlayBounds", "c", "I", "getWidth", "()I", "setWidth", "(I)V", "width", "d", "getHeight", "setHeight", "height", "", "k", "Ljava/util/Map;", "getStyleMap", "()Ljava/util/Map;", "styleMap", "<init>", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: LivenessOverlay.kt */
public class LivenessOverlay implements Overlay {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public MobileContext f54780a;

    /* renamed from: b */
    public final Rect f54781b = new Rect();

    /* renamed from: c */
    public int f54782c;

    /* renamed from: d */
    public int f54783d;

    /* renamed from: e */
    public boolean f54784e = true;

    /* renamed from: f */
    public final Paint f54785f;

    /* renamed from: g */
    public final Paint f54786g;

    /* renamed from: h */
    public final Paint f54787h;

    /* renamed from: i */
    public Path f54788i;

    /* renamed from: j */
    public Path f54789j;

    /* renamed from: k */
    public final Map<Integer, Integer> f54790k;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo175978d2 = {"Lcom/jumio/core/extraction/liveness/overlay/LivenessOverlay$Companion;", "", "", "SVG_LIVENESS_FACE_SILOUETTE", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: LivenessOverlay.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LivenessOverlay(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "context");
        this.f54780a = mobileContext;
        Paint paint = new Paint();
        this.f54785f = paint;
        Paint paint2 = new Paint();
        this.f54786g = paint2;
        Paint paint3 = new Paint();
        this.f54787h = paint3;
        this.f54788i = new Path();
        this.f54789j = new Path();
        HashMap<Integer, Integer> customizations$jumio_core_release = Overlay.Companion.getCustomizations$jumio_core_release(this.f54780a);
        this.f54790k = customizations$jumio_core_release;
        new TypedValue();
        Integer num = customizations$jumio_core_release.get(Integer.valueOf(R.attr.jumio_scanOverlay));
        paint.setColor(num == null ? -1 : num.intValue());
        paint.setStyle(Paint.Style.STROKE);
        paint.setDither(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setStrokeWidth((float) ScreenUtil.dpToPx((Context) this.f54780a, 2));
        paint2.setColor(0);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setDither(true);
        paint2.setAntiAlias(true);
        Integer num2 = customizations$jumio_core_release.get(Integer.valueOf(R.attr.jumio_scanBackground));
        paint3.setColor(num2 == null ? Color.parseColor("#80000000") : num2.intValue());
        paint3.setStyle(Paint.Style.FILL);
        paint3.setDither(true);
        paint3.setStrokeJoin(Paint.Join.ROUND);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setAntiAlias(true);
    }

    public void addViews(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
    }

    public void calculate(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "extractionArea");
        this.f54782c = rect.width();
        this.f54783d = rect.height();
        int height = (int) (((float) rect.height()) * 0.7f);
        int i = (int) ((((float) height) * 2.0f) / 3.0f);
        if (i > ((int) (((float) rect.width()) * 0.65f))) {
            i = (int) (((float) rect.width()) * 0.6f);
            height = (int) (((float) i) * 1.5f);
        }
        getOverlayBounds().left = (rect.width() - i) / 2;
        getOverlayBounds().right = getOverlayBounds().left + i;
        getOverlayBounds().top = (int) (((float) rect.height()) * 0.2f);
        getOverlayBounds().bottom = getOverlayBounds().top + height;
    }

    public void doDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.f54784e) {
            canvas.drawPath(this.f54788i, this.f54785f);
            canvas.drawPath(this.f54788i, this.f54786g);
            canvas.drawPath(this.f54789j, this.f54787h);
        }
    }

    public final MobileContext getContext() {
        return this.f54780a;
    }

    public final int getHeight() {
        return this.f54783d;
    }

    public Rect getOverlayBounds() {
        return this.f54781b;
    }

    public final Map<Integer, Integer> getStyleMap() {
        return this.f54790k;
    }

    public final int getWidth() {
        return this.f54782c;
    }

    public void prepareDraw(boolean z) {
        Path path = new Path();
        this.f54789j = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f54789j.addRect(0.0f, 0.0f, (float) this.f54782c, (float) this.f54783d, Path.Direction.CW);
        RectF rectF = new RectF();
        Path a = C21366l0.m42143a("M129.750958,0.857667941 C129.668068,0.856927808 129.585054,0.856557377 129.501916,0.856557377 C44.9277868,0.856557377 3.03365272e-15,76.7295082 0,120.864754 C0,165 1.49425287,217.565574 3.48659004,241.864754 C4.26227615,251.32527 6.47509579,278.065574 23.4099617,303.356557 C40.2303881,328.476634 89.7830524,383.439256 129.196952,384.180942 C129.298651,384.185993 129.4003,384.188525 129.501916,384.188525 C129.584883,384.188525 129.667898,384.18828 129.750958,384.187792 C129.834018,384.18828 129.917032,384.188525 130,384.188525 C130.101615,384.188525 130.203263,384.185993 130.304942,384.180943 C169.718853,383.439267 219.271526,328.476637 236.091954,303.356557 C253.02682,278.065574 255.23964,251.32527 256.015326,241.864754 C258.007663,217.565574 259.501916,165 259.501916,120.864754 C259.501916,76.7295082 214.574129,0.856557377 130,0.856557377 C129.916861,0.856557377 129.833847,0.856927808 129.750958,0.857667941 Z");
        Intrinsics.checkNotNullExpressionValue(a, "createPathFromSvgString(…_LIVENESS_FACE_SILOUETTE)");
        this.f54788i = a;
        a.computeBounds(rectF, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, new RectF(getOverlayBounds()), Matrix.ScaleToFit.CENTER);
        this.f54788i.transform(matrix);
        this.f54789j.addPath(this.f54788i);
    }

    public final void setContext(MobileContext mobileContext) {
        Intrinsics.checkNotNullParameter(mobileContext, "<set-?>");
        this.f54780a = mobileContext;
    }

    public final void setHeight(int i) {
        this.f54783d = i;
    }

    public void setScanPart(ScanPartModel scanPartModel) {
        Intrinsics.checkNotNullParameter(scanPartModel, "scanPartModel");
    }

    public void setVisible(int i) {
        this.f54784e = i == 0;
    }

    public final void setWidth(int i) {
        this.f54782c = i;
    }

    public void update(ExtractionClient.ExtractionUpdate<?> extractionUpdate) {
    }
}
