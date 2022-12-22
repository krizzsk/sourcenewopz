package com.didi.drouter.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.RouterCallback;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.utils.ReflectUtil;
import com.didi.drouter.utils.RouterLogger;

/* renamed from: com.didi.drouter.router.d */
/* compiled from: RouterDispatcher */
class C7944d {
    C7944d() {
    }

    /* renamed from: a */
    static void m14378a(Request request, RouterMeta routerMeta, Result result, RouterCallback routerCallback) {
        RouterLogger coreLogger = RouterLogger.getCoreLogger();
        Object[] objArr = new Object[2];
        objArr[0] = request.getNumber();
        objArr[1] = routerMeta.getTargetClass() != null ? routerMeta.getTargetClass().getSimpleName() : routerMeta.getHandler();
        coreLogger.mo59000d("request \"%s\", class \"%s\" start execute", objArr);
        int routerType = routerMeta.getRouterType();
        if (routerType == 1) {
            m14380b(request, routerMeta, result, routerCallback);
        } else if (routerType == 2) {
            m14377a(request, routerMeta, result);
        } else if (routerType == 3) {
            m14379b(request, routerMeta, result);
        } else if (routerType == 4) {
            m14381c(request, routerMeta, result);
        }
    }

    /* renamed from: b */
    private static void m14380b(Request request, RouterMeta routerMeta, Result result, RouterCallback routerCallback) {
        Context context = request.getContext();
        Intent intent = routerMeta.getIntent();
        if (intent == null) {
            intent = new Intent();
            intent.setClassName(context, routerMeta.getActivityClassName());
        }
        if (request.getExtra().containsKey(Extend.START_ACTIVITY_FLAGS)) {
            intent.setFlags(request.getInt(Extend.START_ACTIVITY_FLAGS));
        }
        boolean z = context instanceof Activity;
        if (!z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("DRouter_start_activity_request_number", request.getNumber());
        intent.putExtras(request.getExtra());
        if ((context instanceof FragmentActivity) && (routerCallback instanceof RouterCallback.ActivityCallback)) {
            HolderFragment.start((FragmentActivity) context, intent, 1024, (RouterCallback.ActivityCallback) routerCallback);
        } else if (!z || !request.getExtra().containsKey(Extend.START_ACTIVITY_REQUEST_CODE)) {
            ActivityCompat.startActivity(context, intent, intent.getBundleExtra(Extend.START_ACTIVITY_OPTIONS));
        } else {
            ActivityCompat.startActivityForResult((Activity) context, intent, request.getInt(Extend.START_ACTIVITY_REQUEST_CODE), intent.getBundleExtra(Extend.START_ACTIVITY_OPTIONS));
        }
        int[] intArray = request.getIntArray(Extend.START_ACTIVITY_ANIMATION);
        if (z && intArray != null && intArray.length == 2) {
            ((Activity) context).overridePendingTransition(intArray[0], intArray[1]);
        }
        result.f19190c = true;
        if (!routerMeta.isHold()) {
            C7943c.m14370a(request, "complete");
            return;
        }
        RouterLogger.getCoreLogger().mo59002w("request \"%s\" will be held", request.getNumber());
        C7942b.m14366a(request, result);
    }

    /* renamed from: a */
    private static void m14377a(Request request, RouterMeta routerMeta, Result result) {
        Class<?> targetClass = routerMeta.getTargetClass();
        result.f19189b = targetClass;
        if (request.getExtra().getBoolean(Extend.START_FRAGMENT_NEW_INSTANCE, true)) {
            Object instance = ReflectUtil.getInstance(targetClass, new Object[0]);
            if (instance instanceof Fragment) {
                result.f19191d = (Fragment) instance;
                result.f19191d.setArguments(request.getExtra());
            }
        }
        C7943c.m14370a(request, "complete");
    }

    /* renamed from: b */
    private static void m14379b(Request request, RouterMeta routerMeta, Result result) {
        Class<?> targetClass = routerMeta.getTargetClass();
        result.f19189b = targetClass;
        if (request.getExtra().getBoolean(Extend.START_VIEW_NEW_INSTANCE, true)) {
            Object instance = ReflectUtil.getInstance(targetClass, request.getContext());
            if (instance instanceof View) {
                result.f19192e = (View) instance;
                result.f19192e.setTag(request.getExtra());
            }
        }
        C7943c.m14370a(request, "complete");
    }

    /* renamed from: c */
    private static void m14381c(Request request, RouterMeta routerMeta, Result result) {
        IRouterHandler handler = routerMeta.getHandler();
        if (handler == null) {
            handler = (IRouterHandler) ReflectUtil.getInstance(routerMeta.getTargetClass(), new Object[0]);
        }
        if (handler != null) {
            if (routerMeta.isHold()) {
                RouterLogger.getCoreLogger().mo59002w("request \"%s\" will hold", request.getNumber());
            }
            handler.handle(request, result);
            if (!routerMeta.isHold()) {
                C7943c.m14370a(request, "complete");
            } else {
                C7942b.m14366a(request, result);
            }
        } else {
            C7943c.m14370a(request, "error");
        }
    }
}
