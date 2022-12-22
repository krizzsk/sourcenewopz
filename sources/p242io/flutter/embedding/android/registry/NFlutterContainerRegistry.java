package p242io.flutter.embedding.android.registry;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.embedding.android.BaseNachoSkeletonPage;

/* renamed from: io.flutter.embedding.android.registry.NFlutterContainerRegistry */
public class NFlutterContainerRegistry {

    /* renamed from: a */
    private static Map<String, WeakReference<BaseNachoSkeletonPage>> f57557a = new HashMap();

    public static void registerContainer(String str, BaseNachoSkeletonPage baseNachoSkeletonPage) {
        f57557a.put(str, new WeakReference(baseNachoSkeletonPage));
    }

    public static Map<String, WeakReference<BaseNachoSkeletonPage>> getPageRegistry() {
        return f57557a;
    }

    public static BaseNachoSkeletonPage getContainer(String str) {
        if (!f57557a.containsKey(str)) {
            return null;
        }
        return (BaseNachoSkeletonPage) f57557a.get(str).get();
    }

    public static BaseNachoSkeletonPage popContainer(String str) {
        if (!f57557a.containsKey(str)) {
            return null;
        }
        BaseNachoSkeletonPage baseNachoSkeletonPage = (BaseNachoSkeletonPage) f57557a.get(str).get();
        f57557a.remove(str);
        return baseNachoSkeletonPage;
    }

    public static boolean removeContainer(String str) {
        if (!f57557a.containsKey(str)) {
            return false;
        }
        f57557a.remove(str);
        return true;
    }
}
