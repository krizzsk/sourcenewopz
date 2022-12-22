package com.didiglobal.p205sa.biz.component.homemsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didiglobal.p205sa.biz.util.BaseEventKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/homemsg/MsgSettingRouter;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "mContext", "Landroid/content/Context;", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.homemsg.MsgSettingRouter */
/* compiled from: MsgSettingRouter.kt */
public final class MsgSettingRouter implements IRouterHandler {

    /* renamed from: a */
    private Context f51008a;

    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Uri uri = request.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "request.uri");
        this.f51008a = request.getContext();
        if (uri.getQueryParameter("type") != null) {
            String queryParameter = uri.getQueryParameter("type");
            if (Intrinsics.areEqual((Object) queryParameter, (Object) "1")) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.MSG_CARD.EVENT_OPEN_SYS_LOCATION_SETTING);
            } else if (Intrinsics.areEqual((Object) queryParameter, (Object) "2") && this.f51008a != null) {
                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                if (!(this.f51008a instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                Context context = this.f51008a;
                Intrinsics.checkNotNull(context);
                intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
                Context context2 = this.f51008a;
                Intrinsics.checkNotNull(context2);
                context2.startActivity(intent);
            }
        } else if (this.f51008a != null) {
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            if (!(this.f51008a instanceof Activity)) {
                intent2.setFlags(268435456);
            }
            Context context3 = this.f51008a;
            Intrinsics.checkNotNull(context3);
            intent2.setData(Uri.fromParts("package", context3.getPackageName(), (String) null));
            Context context4 = this.f51008a;
            Intrinsics.checkNotNull(context4);
            context4.startActivity(intent2);
        }
    }
}
