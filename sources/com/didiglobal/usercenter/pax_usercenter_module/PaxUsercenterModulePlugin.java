package com.didiglobal.usercenter.pax_usercenter_module;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.api.ILoginActionApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.usercenter.api.IUserCenterFacade;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didiglobal/usercenter/pax_usercenter_module/PaxUsercenterModulePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "accountData", "Lcom/didi/sdk/sidebar/model/SidebarPage;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "getChannel", "()Lio/flutter/plugin/common/MethodChannel;", "setChannel", "(Lio/flutter/plugin/common/MethodChannel;)V", "context", "Landroid/content/Context;", "settingData", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "pax_usercenter_module_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaxUsercenterModulePlugin.kt */
public final class PaxUsercenterModulePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private Context f51457a;

    /* renamed from: b */
    private SidebarPage f51458b = new SidebarPage();

    /* renamed from: c */
    private SidebarPage f51459c = new SidebarPage();
    public MethodChannel channel;

    public final MethodChannel getChannel() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            return methodChannel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channel");
        return null;
    }

    public final void setChannel(MethodChannel methodChannel) {
        Intrinsics.checkNotNullParameter(methodChannel, "<set-?>");
        this.channel = methodChannel;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
        this.f51457a = applicationContext;
        setChannel(new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.didi.global.pax_usercenter_module.PaxUsercenterModulePlugin"));
        getChannel().setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        getChannel().setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "updateSettingData")) {
            SystemUtils.log(6, "UserCenterHandler", "call.method", (Throwable) null, "com.didiglobal.usercenter.pax_usercenter_module.PaxUsercenterModulePlugin", 42);
            Object obj = methodCall.arguments;
            if (obj != null) {
                Object fromJson = new Gson().fromJson(new JSONObject((Map) obj).toString(), SidebarPage.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(\n       …:class.java\n            )");
                this.f51458b = (SidebarPage) fromJson;
                UserCenterStore.getInstance().setSettingData(this.f51458b);
                SystemUtils.log(6, "UserCenterHandler", this.f51458b.toString(), (Throwable) null, "com.didiglobal.usercenter.pax_usercenter_module.PaxUsercenterModulePlugin", 50);
                result.success((Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        } else if (Intrinsics.areEqual((Object) methodCall.method, (Object) "updateAccountData")) {
            Object obj2 = methodCall.arguments;
            if (obj2 != null) {
                JSONObject jSONObject = new JSONObject((Map) obj2);
                jSONObject.toString();
                Object fromJson2 = new Gson().fromJson(jSONObject.toString(), SidebarPage.class);
                Intrinsics.checkNotNullExpressionValue(fromJson2, "Gson().fromJson(\n       …:class.java\n            )");
                this.f51459c = (SidebarPage) fromJson2;
                UserCenterStore.getInstance().setAccountData(this.f51459c);
                result.success((Object) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        } else if (Intrinsics.areEqual((Object) methodCall.method, (Object) "isLogin")) {
            UIThreadHandler.post(new Runnable() {
                public final void run() {
                    PaxUsercenterModulePlugin.m36841a(MethodChannel.Result.this);
                }
            });
        } else if (Intrinsics.areEqual((Object) methodCall.method, (Object) "getUserProfile")) {
            UIThreadHandler.post(new Runnable(result) {
                public final /* synthetic */ MethodChannel.Result f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PaxUsercenterModulePlugin.m36840a(PaxUsercenterModulePlugin.this, this.f$1);
                }
            });
        } else if (Intrinsics.areEqual((Object) methodCall.method, (Object) "forceLogin")) {
            ILoginActionApi action = OneLoginFacade.getAction();
            Context context = this.f51457a;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            action.go2Login(context);
            result.success((Object) null);
        } else if (Intrinsics.areEqual((Object) methodCall.method, (Object) "updateRedPoint")) {
            Object obj3 = methodCall.arguments;
            if (obj3 != null) {
                Map map = (Map) obj3;
                Object obj4 = map.get("type");
                if (obj4 != null) {
                    int intValue = ((Integer) obj4).intValue();
                    String valueOf = String.valueOf(map.get("text"));
                    if (intValue == 0) {
                        SaBusinessManager.Companion.getIns().notifyTabRedPoint("tab_user", false);
                        SaBusinessManager.Companion.getIns().notifyTabTip("tab_user", "");
                    } else if (intValue == 1) {
                        SaBusinessManager.Companion.getIns().notifyTabTip("tab_user", "");
                        SaBusinessManager.Companion.getIns().notifyTabRedPoint("tab_user", true);
                    } else if (intValue == 2) {
                        SaBusinessManager.Companion.getIns().notifyTabRedPoint("tab_user", false);
                        SaBusinessManager.Companion.getIns().notifyTabTip("tab_user", valueOf);
                    }
                    result.success((Object) null);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        } else if (Intrinsics.areEqual((Object) methodCall.method, (Object) "updateMessagePoint")) {
            IMEngine.getAllUnreadMessageCount(new IMSessionUnreadCallback() {
                public final void unReadCount(int i) {
                    PaxUsercenterModulePlugin.m36839a(PaxUsercenterModulePlugin.this, i);
                }
            });
            result.success((Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36841a(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(Boolean.valueOf(OneLoginFacade.getStore().isLoginNow()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36840a(PaxUsercenterModulePlugin paxUsercenterModulePlugin, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(paxUsercenterModulePlugin, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        IUserCenterFacade ins = UserCenterFacade.getIns();
        Context context = paxUsercenterModulePlugin.f51457a;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        UserInfo userInfo = ins.getUserInfo(context);
        HashMap hashMap = new HashMap();
        if (userInfo != null) {
            Map map = hashMap;
            String nick = userInfo.getNick();
            Intrinsics.checkNotNullExpressionValue(nick, "info.nick");
            map.put("nick", nick);
            String head_url = userInfo.getHead_url();
            Intrinsics.checkNotNullExpressionValue(head_url, "info.head_url");
            map.put("head_url", head_url);
            String first_name = userInfo.getFirst_name();
            Intrinsics.checkNotNullExpressionValue(first_name, "info.first_name");
            map.put(ParamConst.PARAM_FIRST_NAME, first_name);
            String last_name = userInfo.getLast_name();
            Intrinsics.checkNotNullExpressionValue(last_name, "info.last_name");
            map.put(ParamConst.PARAM_LAST_NAME, last_name);
            String phone = userInfo.getPhone();
            Intrinsics.checkNotNullExpressionValue(phone, "info.phone");
            map.put("phone", phone);
        }
        result.success(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36839a(PaxUsercenterModulePlugin paxUsercenterModulePlugin, int i) {
        Intrinsics.checkNotNullParameter(paxUsercenterModulePlugin, "this$0");
        paxUsercenterModulePlugin.getChannel().invokeMethod("updateIMRedPoint", Integer.valueOf(i));
    }
}
