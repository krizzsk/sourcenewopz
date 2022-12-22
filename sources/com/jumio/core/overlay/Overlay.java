package com.jumio.core.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.appcompat.view.ContextThemeWrapper;
import com.jumio.commons.log.Log;
import com.jumio.core.MobileContext;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.models.ScanPartModel;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&R\u0016\u0010\u001a\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, mo175978d2 = {"Lcom/jumio/core/overlay/Overlay;", "", "Landroid/view/ViewGroup;", "rootView", "", "addViews", "Lcom/jumio/core/models/ScanPartModel;", "scanPartModel", "setScanPart", "Landroid/graphics/Rect;", "extractionArea", "calculate", "", "isFrontCamera", "prepareDraw", "Landroid/graphics/Canvas;", "canvas", "doDraw", "Lcom/jumio/core/extraction/ExtractionClient$ExtractionUpdate;", "extractionUpdate", "update", "", "visibility", "setVisible", "getOverlayBounds", "()Landroid/graphics/Rect;", "overlayBounds", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: Overlay.kt */
public interface Overlay {
    public static final int BORDER_STROKE_WIDTH_IN_DP = 2;
    public static final Companion Companion = Companion.f54936a;
    public static final int DETECTED_BORDER_STROKE_WIDTH_IN_DP = 6;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, mo175978d2 = {"Lcom/jumio/core/overlay/Overlay$Companion;", "", "Lcom/jumio/core/MobileContext;", "context", "Ljava/util/HashMap;", "", "getCustomizations$jumio_core_release", "(Lcom/jumio/core/MobileContext;)Ljava/util/HashMap;", "getCustomizations", "BORDER_STROKE_WIDTH_IN_DP", "I", "DETECTED_BORDER_STROKE_WIDTH_IN_DP", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: Overlay.kt */
    public static final class Companion {
        public static final int BORDER_STROKE_WIDTH_IN_DP = 2;
        public static final int DETECTED_BORDER_STROKE_WIDTH_IN_DP = 6;

        /* renamed from: a */
        public static final /* synthetic */ Companion f54936a = new Companion();

        public final HashMap<Integer, Integer> getCustomizations$jumio_core_release(MobileContext mobileContext) {
            Resources.Theme theme;
            Intrinsics.checkNotNullParameter(mobileContext, "context");
            TypedValue typedValue = new TypedValue();
            if (mobileContext.getCustomThemeId() != 0) {
                theme = new ContextThemeWrapper((Context) mobileContext, mobileContext.getCustomThemeId()).getTheme();
                Intrinsics.checkNotNullExpressionValue(theme, "{\n\t\t\t\tContextThemeWrappe…customThemeId).theme\n\t\t\t}");
            } else {
                theme = mobileContext.getTheme();
                Intrinsics.checkNotNullExpressionValue(theme, "{\n\t\t\t\tcontext.theme\n\t\t\t}");
            }
            int[] iArr = {R.attr.jumio_scanOverlay, R.attr.jumio_scanOverlayFill, R.attr.jumio_scanOverlayTransparent, R.attr.jumio_scanBackground};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(2132017575, iArr);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "theme.obtainStyledAttrib…ustomization, attributes)");
            TypedArray typedArray = null;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            try {
                if (theme.resolveAttribute(R.attr.jumio_overlay_customization, typedValue, true)) {
                    typedArray = mobileContext.getTheme().obtainStyledAttributes(typedValue.data, iArr);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    hashMap.put(Integer.valueOf(iArr[i]), Integer.valueOf(obtainStyledAttributes.getColor(i, -1)));
                    if (!(typedArray == null || typedArray.getColor(i, -1) == -1)) {
                        hashMap.put(Integer.valueOf(iArr[i]), Integer.valueOf(typedArray.getColor(i, -1)));
                    }
                    if (i2 > 3) {
                        break;
                    }
                    i = i2;
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
            return hashMap;
        }
    }

    void addViews(ViewGroup viewGroup);

    void calculate(Rect rect);

    void doDraw(Canvas canvas);

    Rect getOverlayBounds();

    void prepareDraw(boolean z);

    void setScanPart(ScanPartModel scanPartModel);

    void setVisible(int i);

    void update(ExtractionClient.ExtractionUpdate<?> extractionUpdate);
}
