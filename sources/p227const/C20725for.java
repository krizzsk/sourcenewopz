package p227const;

import android.graphics.Color;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.cameray.Orientation;
import p238goto.C20993if;

/* renamed from: const.for */
/* compiled from: RendererUtils */
public class C20725for {
    /* renamed from: do */
    public static float[] m40544do(int i) {
        return new float[]{((float) Color.red(i)) / 255.0f, ((float) Color.green(i)) / 255.0f, ((float) Color.blue(i)) / 255.0f};
    }

    /* renamed from: if */
    public static int m40545if(int i) {
        return Color.rgb((Color.red(i) + 153) % 255, (Color.green(i) + 153) % 255, (Color.blue(i) + 153) % 255);
    }

    /* renamed from: do */
    public static C20993if m40543do(C19792try tryR, int i, int i2, Orientation orientation) {
        int i3;
        int i4;
        int i5;
        if (orientation.isPortrait()) {
            i3 = tryR.m47474new().mo161911if().mo170632if();
            i4 = tryR.m47474new().mo161911if().mo170629do();
        } else {
            i3 = tryR.m47474new().mo161911if().mo170629do();
            i4 = tryR.m47474new().mo161911if().mo170632if();
        }
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        double d = ((double) i4) / ((double) i3);
        int i6 = (int) (((double) abs) * d);
        if (abs2 > i6) {
            i5 = abs;
        } else {
            i5 = (int) (((double) abs2) / d);
            i6 = abs2;
        }
        return new C20993if(i5, i6, (abs - i5) / 2, (abs2 - i6) / 2);
    }
}
