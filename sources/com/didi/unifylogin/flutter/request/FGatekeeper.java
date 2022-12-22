package com.didi.unifylogin.flutter.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.GateKeeperParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/FGatekeeper;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "loginType", "", "usertype", "request", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FGatekeeper.kt */
public final class FGatekeeper extends BaseFlutterRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f44787a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f44788b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FGatekeeper(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    public void request() {
        String str = (String) getCall().argument("cell");
        getMessenger().setCell(str);
        Object argument = getCall().argument("scene");
        if (argument == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(argument, "call.argument<Int>(\"scene\")!!");
        int intValue = ((Number) argument).intValue();
        Map map = (Map) getCall().argument("thirdparty_channels_available");
        Object obj = map != null ? map.get("whats_app") : null;
        if (obj != null) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            GateKeeperParam.ThirdPartyChannel thirdPartyChannel = new GateKeeperParam.ThirdPartyChannel();
            thirdPartyChannel.whatsApp = booleanValue;
            GateKeeperParam cell = new GateKeeperParam(getContext(), intValue).setCell(str);
            cell.thirdPartyChannelsAvailable = thirdPartyChannel;
            LoginModel.getFlutterNet(getContext()).gatekeeper(cell, new FGatekeeper$request$1(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
