package com.didiglobal.dittoview;

import android.content.Context;
import android.text.TextUtils;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.dittoview.mvvm.DittoView;
import com.didiglobal.dittoview.mvvm.DittoViewBinder;
import java.util.concurrent.ConcurrentHashMap;

public class DittoKit {
    public static final String TEMPLATE_CDN = "_cdn_template";

    /* renamed from: a */
    private static DittoKit f49879a = new DittoKit();

    /* renamed from: b */
    private ConcurrentHashMap<String, DittoViewBinder> f49880b = new ConcurrentHashMap<>();

    private DittoKit() {
    }

    public static void register(String str, DittoViewBinder dittoViewBinder, boolean z) {
        if (str != null && dittoViewBinder != null) {
            if (z || !f49879a.f49880b.containsKey(str)) {
                f49879a.f49880b.put(str, dittoViewBinder);
                return;
            }
            throw new RuntimeException(str + " already exists,register fail");
        }
    }

    public static void unRegister(String str) {
        f49879a.f49880b.remove(str);
    }

    public static DittoView createTemplateView(Context context, DittoData dittoData) {
        DittoViewBinder dittoViewBinder;
        if (context == null || dittoData == null || (dittoViewBinder = f49879a.f49880b.get(m35990a(dittoData))) == null) {
            return null;
        }
        DittoView dittoView = new DittoView(dittoViewBinder, dittoViewBinder.createView(context, dittoData));
        if (dittoView.getView() != null) {
            return dittoView;
        }
        return null;
    }

    /* renamed from: a */
    private static String m35990a(DittoData dittoData) {
        if (!TextUtils.isEmpty(dittoData.getCdn())) {
            return "_cdn_template";
        }
        return dittoData.getTemplate();
    }

    public static boolean isRegistered(String str) {
        return f49879a.f49880b.containsKey(str);
    }

    public static DittoViewBinder getViewBinder(String str) {
        return f49879a.f49880b.get(str);
    }

    public static DittoViewBinder getViewBinder(DittoData dittoData) {
        return f49879a.f49880b.get(m35990a(dittoData));
    }
}
