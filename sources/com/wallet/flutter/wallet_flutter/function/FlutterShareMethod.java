package com.wallet.flutter.wallet_flutter.function;

import androidx.core.app.NotificationCompat;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.FileUtil;
import com.wallet.flutter.wallet_flutter.base.FlutterHelper;
import com.wallet.flutter.wallet_flutter.base.IActivityAwareOwner;
import com.wallet.flutter.wallet_flutter.base.IFlutterMethodCall;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0011"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterShareMethod;", "Lcom/wallet/flutter/wallet_flutter/base/IFlutterMethodCall;", "()V", "onCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "bindingOwner", "Lcom/wallet/flutter/wallet_flutter/base/IActivityAwareOwner;", "pluginBindingId", "", "performShareAction", "byte", "", "Companion", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FlutterShareMethod.kt */
public final class FlutterShareMethod implements IFlutterMethodCall {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String filePathKey = "filePath";
    public static final int requestShareCode = 10000;
    public static final int shareStatusCancel = 2;
    public static final int shareStatusComplete = 0;
    public static final int shareStatusError = 1;
    public static final String shareStatusKey = "shareStatusKey";

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/wallet/flutter/wallet_flutter/function/FlutterShareMethod$Companion;", "", "()V", "filePathKey", "", "requestShareCode", "", "shareStatusCancel", "shareStatusComplete", "shareStatusError", "shareStatusKey", "wallet_flutter_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FlutterShareMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final void m40371a(byte[] bArr, MethodCall methodCall, MethodChannel.Result result, IActivityAwareOwner iActivityAwareOwner, String str) {
        String stringPlus = Intrinsics.stringPlus(UUID.randomUUID().toString(), "_share_pic.png");
        String byteToFile = FileUtil.byteToFile(bArr, stringPlus, ApplicationContextProvider.Companion.getContext());
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("fileName", stringPlus);
        JSONObject putOpt = jSONObject.putOpt(filePathKey, byteToFile);
        ActivityPluginBinding activityPluginBinding = iActivityAwareOwner.getActivityPluginBinding();
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(new C20640xe9efc581(activityPluginBinding, result, byteToFile));
        }
        if (!FlutterHelper.Companion.proxyByActivity(methodCall, iActivityAwareOwner, str, false, putOpt, true, 10000)) {
            result.success((Object) null);
        }
    }

    public void onCall(MethodCall methodCall, MethodChannel.Result result, IActivityAwareOwner iActivityAwareOwner, String str) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(iActivityAwareOwner, "bindingOwner");
        Intrinsics.checkNotNullParameter(str, "pluginBindingId");
        Object obj = methodCall.arguments;
        Map map = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map == null ? null : map.get("data");
        if (!(obj2 instanceof byte[])) {
            obj2 = null;
        }
        byte[] bArr = (byte[]) obj2;
        if (bArr == null) {
            result.success((Object) null);
        } else {
            m40371a(bArr, methodCall, result, iActivityAwareOwner, str);
        }
    }
}
