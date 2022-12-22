package com.didi.global.globalgenerickit;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didiglobal.dittoview.impl.DittoViewBinderImpl;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalGenericKit {
    public static final String TEMPLATE_CDN = "_cdn_template";

    /* renamed from: a */
    private static GlobalGenericKit f22042a = new GlobalGenericKit();

    /* renamed from: c */
    private static boolean f22043c = false;

    /* renamed from: b */
    private ConcurrentHashMap<String, GGKViewBinder> f22044b = new ConcurrentHashMap<>();

    public static <T> T getApolloParam(String str, String str2, T t) {
        return t;
    }

    public static boolean isShowDebugView() {
        return f22043c;
    }

    public static void showDebugView(boolean z) {
        f22043c = z;
    }

    private GlobalGenericKit() {
    }

    public static void register(String str, GGKViewBinder gGKViewBinder, boolean z) {
        if (str != null && gGKViewBinder != null) {
            if (z || !f22042a.f22044b.containsKey(str)) {
                f22042a.f22044b.put(str, gGKViewBinder);
                return;
            }
            throw new RuntimeException(str + " already exists,register fail");
        }
    }

    public static void unRegister(String str) {
        f22042a.f22044b.remove(str);
    }

    public static GGKView createTemplateView(Context context, GGKData gGKData) {
        GGKView gGKView;
        if (context == null || gGKData == null) {
            return null;
        }
        if (((Integer) getApolloParam("x_engine_cache_enable", "use_cache", 0)).intValue() == 1) {
            DittoViewBinderImpl dittoViewBinderImpl = new DittoViewBinderImpl();
            gGKView = new GGKView(dittoViewBinderImpl, dittoViewBinderImpl.createView(context, gGKData.parse2DittoData()));
        } else {
            GGKViewBinder gGKViewBinder = f22042a.f22044b.get(m15978a(gGKData));
            if (gGKViewBinder == null) {
                return null;
            }
            View createView = gGKViewBinder.createView(context, gGKData);
            if (isShowDebugView()) {
                createView = KitHelper.wrapperDebugView(createView, gGKData);
            }
            gGKView = new GGKView(gGKViewBinder, createView);
        }
        if (gGKView.getView() != null) {
            return gGKView;
        }
        return null;
    }

    /* renamed from: a */
    private static String m15978a(GGKData gGKData) {
        if (!TextUtils.isEmpty(gGKData.getCdn())) {
            return "_cdn_template";
        }
        return gGKData.getTemplate();
    }

    public static boolean isRegistered(String str) {
        return f22042a.f22044b.containsKey(str);
    }

    public static GGKViewBinder getViewBinder(String str) {
        return f22042a.f22044b.get(str);
    }

    public static GGKViewBinder getViewBinder(GGKData gGKData) {
        return f22042a.f22044b.get(m15978a(gGKData));
    }
}
