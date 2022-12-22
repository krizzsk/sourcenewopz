package com.didi.payment.base.screenshot;

import android.graphics.Point;
import android.view.WindowManager;
import com.didi.payment.base.exts.ApplicationContextProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroid/graphics/Point;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ScreenShotListenManager.kt */
final class ScreenShotListenManager$sScreenRealSize$2 extends Lambda implements Function0<Point> {
    public static final ScreenShotListenManager$sScreenRealSize$2 INSTANCE = new ScreenShotListenManager$sScreenRealSize$2();

    ScreenShotListenManager$sScreenRealSize$2() {
        super(0);
    }

    public final Point invoke() {
        Point point = new Point();
        try {
            Object systemService = ApplicationContextProvider.Companion.getContext().getSystemService("window");
            if (systemService != null) {
                ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
                return point;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
