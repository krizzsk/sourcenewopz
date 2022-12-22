package com.didi.unifylogin.flutter.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/FCodeMT;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "request", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FCodeMT.kt */
public final class FCodeMT extends BaseFlutterRequest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FCodeMT(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if ((r1.length() == 0) != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request() {
        /*
            r4 = this;
            io.flutter.plugin.common.MethodCall r0 = r4.getCall()
            java.lang.String r1 = "codeType"
            java.lang.Object r0 = r0.argument(r1)
            if (r0 != 0) goto L_0x000f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x000f:
            java.lang.String r1 = "call.argument<Int>(\"codeType\")!!"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            com.didi.unifylogin.base.model.FragmentMessenger r1 = r4.getMessenger()
            java.lang.String r1 = r1.getCell()
            if (r1 == 0) goto L_0x003e
            com.didi.unifylogin.base.model.FragmentMessenger r1 = r4.getMessenger()
            java.lang.String r1 = r1.getCell()
            java.lang.String r2 = "messenger.cell"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            if (r1 == 0) goto L_0x0052
        L_0x003e:
            com.didi.unifylogin.base.model.FragmentMessenger r1 = r4.getMessenger()
            com.didi.unifylogin.store.LoginStore r2 = com.didi.unifylogin.store.LoginStore.getInstance()
            java.lang.String r3 = "LoginStore.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            java.lang.String r2 = r2.getPhone()
            r1.setCell(r2)
        L_0x0052:
            com.didi.unifylogin.base.net.pojo.request.CodeMtParam r1 = new com.didi.unifylogin.base.net.pojo.request.CodeMtParam
            android.content.Context r2 = r4.getContext()
            com.didi.unifylogin.base.model.FragmentMessenger r3 = r4.getMessenger()
            int r3 = r3.getSceneNum()
            r1.<init>(r2, r3)
            com.didi.unifylogin.base.model.FragmentMessenger r2 = r4.getMessenger()
            java.lang.String r2 = r2.getCell()
            com.didi.unifylogin.base.net.pojo.request.CodeMtParam r1 = r1.setCell(r2)
            com.didi.unifylogin.base.net.pojo.request.CodeMtParam r0 = r1.setCodeType(r0)
            com.didi.unifylogin.base.model.FragmentMessenger r1 = r4.getMessenger()
            long r2 = android.os.SystemClock.uptimeMillis()
            r1.setLastCodeMTTime(r2)
            android.content.Context r1 = r4.getContext()
            com.didi.unifylogin.base.net.LoginNet r1 = com.didi.unifylogin.base.model.LoginModel.getFlutterNet(r1)
            com.didi.unifylogin.flutter.request.FCodeMT$request$1 r2 = new com.didi.unifylogin.flutter.request.FCodeMT$request$1
            r2.<init>(r4)
            com.didichuxing.foundation.rpc.RpcService$CallbackV2 r2 = (com.didichuxing.foundation.rpc.RpcService.CallbackV2) r2
            r1.codeMt(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.flutter.request.FCodeMT.request():void");
    }
}
