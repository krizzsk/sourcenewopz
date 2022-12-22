package com.didi.soda.home.feedback;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.nova.assembly.country.CountryListDialog;
import com.didi.nova.assembly.country.OnCountrySelectListener;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.flutter.plugin.CustomerBasePlugin;
import com.didi.soda.customer.foundation.util.CipherUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.JSONMethodCodec;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/home/feedback/UserInfoPlugin;", "Lcom/didi/soda/customer/flutter/plugin/CustomerBasePlugin;", "()V", "mChannel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UserInfoPlugin.kt */
public final class UserInfoPlugin extends CustomerBasePlugin {

    /* renamed from: a */
    private MethodChannel f42640a;

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        Context context = GlobalContext.getContext();
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) "getCallingCode")) {
            CountryListDialog.show(context, (OnCountrySelectListener) new OnCountrySelectListener() {
                public final void onSelect(String str, int i) {
                    UserInfoPlugin.m30115a(MethodChannel.Result.this, str, i);
                }
            }, 0, ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag(), CustomerSystemUtil.getImmersiveStatusBarHeight(context), GlobalContext.isBrazil() ? R.style.NovaAssemblyCountryStyleYellow : R.style.NovaAssemblyCountryStyleOrange);
        } else if (Intrinsics.areEqual((Object) str, (Object) "crypPhoneNumber")) {
            String str2 = (String) methodCall.argument(Const.PageParams.PHONE_NUMBER);
            if (str2 == null) {
                str2 = "";
            }
            result.success(CipherUtil.encrypt(str2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30115a(MethodChannel.Result result, String str, int i) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(str);
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.rlab/get_user_info_plugin", JSONMethodCodec.INSTANCE);
        this.f42640a = methodChannel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(this);
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.f42640a;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.f42640a = null;
    }
}
