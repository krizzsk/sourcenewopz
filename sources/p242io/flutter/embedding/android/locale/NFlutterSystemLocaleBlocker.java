package p242io.flutter.embedding.android.locale;

import android.content.Context;
import global.didi.pay.newview.pix.IPixView;
import java.lang.reflect.Field;
import p242io.flutter.embedding.android.NSkeletonFlutter;
import p242io.flutter.embedding.engine.FlutterEngine;

/* renamed from: io.flutter.embedding.android.locale.NFlutterSystemLocaleBlocker */
public class NFlutterSystemLocaleBlocker {
    public static void blockSendSystemLocale2Flutter(Context context, FlutterEngine flutterEngine) throws NoSuchFieldException, IllegalAccessException {
        if (!(flutterEngine.getLocalizationPlugin() instanceof NoopLocalizationPlugin)) {
            NSkeletonFlutter.log("NFlutterSystemLocaleBlocker", IPixView.PAGE_STATUS_INIT);
            setFieldValue(flutterEngine, "localizationPlugin", new NoopLocalizationPlugin(context, flutterEngine.getLocalizationChannel()));
        }
    }

    public static Field setFieldValue(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Field a = m41411a(obj.getClass(), str);
        a.setAccessible(true);
        a.set(obj, obj2);
        return a;
    }

    /* renamed from: a */
    private static Field m41411a(Class cls, String str) throws NoSuchFieldException {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Class superclass = cls.getSuperclass();
            if (superclass != null) {
                return m41411a(superclass, str);
            }
            throw e;
        }
    }
}
