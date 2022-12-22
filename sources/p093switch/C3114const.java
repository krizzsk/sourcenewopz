package p093switch;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.iproov.sdk.logging.IPLog;

/* renamed from: switch.const */
/* compiled from: TypefaceUtils */
public class C3114const {

    /* renamed from: a */
    private static final String f6944a = "const";

    /* renamed from: do */
    public static Typeface m4021do(Context context, String str) {
        try {
            return Typeface.createFromAsset(context.getAssets(), str);
        } catch (RuntimeException unused) {
            String str2 = f6944a;
            IPLog.m39305w(str2, "Font asset not found " + str);
            throw new RuntimeException("Font asset not found " + str);
        }
    }

    /* renamed from: do */
    public static Typeface m4020do(Context context, int i) {
        try {
            return ResourcesCompat.getFont(context, i);
        } catch (RuntimeException unused) {
            IPLog.m39305w(f6944a, "Font resource not found");
            throw new RuntimeException("Font resource not found");
        }
    }

    /* renamed from: do */
    public static void m4022do(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
    }
}
