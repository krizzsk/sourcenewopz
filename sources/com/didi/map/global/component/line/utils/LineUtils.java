package com.didi.map.global.component.line.utils;

import android.os.Looper;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/map/global/component/line/utils/LineUtils;", "", "()V", "isMainThread", "", "()Z", "getCornerLineDots", "", "Lcom/didi/common/map/model/LatLng;", "start", "end", "compLine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LineUtils.kt */
public final class LineUtils {
    public static final LineUtils INSTANCE = new LineUtils();

    private LineUtils() {
    }

    public final boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final List<LatLng> getCornerLineDots(LatLng latLng, LatLng latLng2) {
        LatLng latLng3;
        double d;
        LatLng latLng4 = latLng;
        LatLng latLng5 = latLng2;
        Intrinsics.checkNotNullParameter(latLng4, "start");
        Intrinsics.checkNotNullParameter(latLng5, "end");
        List<LatLng> arrayList = new ArrayList<>();
        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
        double computeHeading = DDSphericalUtil.computeHeading(latLng, latLng2);
        int i = 500;
        if (computeDistanceBetween < ((double) 500)) {
            i = (int) computeDistanceBetween;
        }
        if (computeDistanceBetween < 500000.0d) {
            if (computeHeading < 0.0d) {
                d = DDSphericalUtil.computeDistanceBetween(latLng5, latLng4);
                computeHeading = DDSphericalUtil.computeHeading(latLng5, latLng4);
                latLng3 = DDSphericalUtil.computeOffset(latLng5, d * 0.5d, computeHeading);
                Intrinsics.checkNotNullExpressionValue(latLng3, "computeOffset(end, d * 0.5, h)");
            } else {
                d = DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
                latLng3 = DDSphericalUtil.computeOffset(latLng4, d * 0.5d, computeHeading);
                Intrinsics.checkNotNullExpressionValue(latLng3, "computeOffset(start, d * 0.5, h)");
            }
            float f = (float) 1;
            double d2 = (double) (((float) 2) * 0.3f);
            double d3 = ((((double) (f + 0.09f)) * d) * 0.5d) / d2;
            LatLng computeOffset = DDSphericalUtil.computeOffset(latLng3, ((((double) (f - 0.09f)) * d) * 0.5d) / d2, computeHeading + 90.0d);
            double computeHeading2 = DDSphericalUtil.computeHeading(computeOffset, latLng4);
            double computeHeading3 = (DDSphericalUtil.computeHeading(computeOffset, latLng5) - computeHeading2) / ((double) i);
            int i2 = 0;
            if (i > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    LatLng computeOffset2 = DDSphericalUtil.computeOffset(computeOffset, d3, (((double) i2) * computeHeading3) + computeHeading2);
                    Intrinsics.checkNotNullExpressionValue(computeOffset2, "pi");
                    arrayList.add(computeOffset2);
                    if (i3 >= i) {
                        break;
                    }
                    i2 = i3;
                }
            }
        } else {
            arrayList.add(latLng4);
            arrayList.add(latLng5);
        }
        return arrayList;
    }
}
