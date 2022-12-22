package com.didiglobal.pay.paysecure;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didiglobal.pay.paysecure.p204ui.PaySecureActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001bJ\u0016\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010&\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001bJ.\u0010'\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006*"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/PaySecure;", "", "()V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "config", "Lcom/didiglobal/pay/paysecure/PaySecureConfig;", "getConfig", "()Lcom/didiglobal/pay/paysecure/PaySecureConfig;", "setConfig", "(Lcom/didiglobal/pay/paysecure/PaySecureConfig;)V", "openCertificationListener", "Lcom/didiglobal/pay/paysecure/OpenCertificationListener;", "getOpenCertificationListener", "()Lcom/didiglobal/pay/paysecure/OpenCertificationListener;", "setOpenCertificationListener", "(Lcom/didiglobal/pay/paysecure/OpenCertificationListener;)V", "pwdResultListener", "Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "getPwdResultListener", "()Lcom/didiglobal/pay/paysecure/PayPwdResultListener;", "setPwdResultListener", "(Lcom/didiglobal/pay/paysecure/PayPwdResultListener;)V", "Lcom/didiglobal/pay/paysecure/SetPwdResultListener;", "getSetPwdResultListener", "()Lcom/didiglobal/pay/paysecure/SetPwdResultListener;", "setSetPwdResultListener", "(Lcom/didiglobal/pay/paysecure/SetPwdResultListener;)V", "createPayPassword", "", "scene", "", "init", "context", "resetPayPassword", "verifyPayPassword", "paySessionId", "amount", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PaySecure.kt */
public final class PaySecure {
    public static final PaySecure INSTANCE = new PaySecure();

    /* renamed from: a */
    private static OpenCertificationListener f50304a;
    public static Context appContext;

    /* renamed from: b */
    private static SetPwdResultListener f50305b;

    /* renamed from: c */
    private static PayPwdResultListener f50306c;
    public static PaySecureConfig config;

    private PaySecure() {
    }

    public final PaySecureConfig getConfig() {
        PaySecureConfig paySecureConfig = config;
        if (paySecureConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        return paySecureConfig;
    }

    public final void setConfig(PaySecureConfig paySecureConfig) {
        Intrinsics.checkParameterIsNotNull(paySecureConfig, "<set-?>");
        config = paySecureConfig;
    }

    public final Context getAppContext() {
        Context context = appContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        return context;
    }

    public final void setAppContext(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        appContext = context;
    }

    public final OpenCertificationListener getOpenCertificationListener() {
        return f50304a;
    }

    public final void setOpenCertificationListener(OpenCertificationListener openCertificationListener) {
        f50304a = openCertificationListener;
    }

    public final SetPwdResultListener getSetPwdResultListener() {
        return f50305b;
    }

    public final void setSetPwdResultListener(SetPwdResultListener setPwdResultListener) {
        f50305b = setPwdResultListener;
    }

    public final PayPwdResultListener getPwdResultListener() {
        return f50306c;
    }

    public final void setPwdResultListener(PayPwdResultListener payPwdResultListener) {
        f50306c = payPwdResultListener;
    }

    public final void init(Context context, PaySecureConfig paySecureConfig) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(paySecureConfig, "config");
        appContext = context;
        config = paySecureConfig;
    }

    public final void createPayPassword(String str, OpenCertificationListener openCertificationListener, SetPwdResultListener setPwdResultListener) {
        Intrinsics.checkParameterIsNotNull(str, "scene");
        Intrinsics.checkParameterIsNotNull(openCertificationListener, "openCertificationListener");
        Intrinsics.checkParameterIsNotNull(setPwdResultListener, "setPwdResultListener");
        f50304a = openCertificationListener;
        f50305b = setPwdResultListener;
        Context context = appContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        Intent intent = new Intent(context, PaySecureActivity.class);
        intent.putExtra("scene", str);
        intent.putExtra("scene_type", 0);
        Context context2 = appContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        if (!(context2 instanceof Activity)) {
            intent.addFlags(268435456);
        }
        Context context3 = appContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        context3.startActivity(intent);
    }

    public final void resetPayPassword(String str, OpenCertificationListener openCertificationListener, SetPwdResultListener setPwdResultListener) {
        Intrinsics.checkParameterIsNotNull(str, "scene");
        Intrinsics.checkParameterIsNotNull(openCertificationListener, "openCertificationListener");
        Intrinsics.checkParameterIsNotNull(setPwdResultListener, "setPwdResultListener");
        f50304a = openCertificationListener;
        f50305b = setPwdResultListener;
        Context context = appContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        Intent intent = new Intent(context, PaySecureActivity.class);
        intent.putExtra("scene", str);
        intent.putExtra("scene_type", 1);
        Context context2 = appContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        if (!(context2 instanceof Activity)) {
            intent.addFlags(268435456);
        }
        Context context3 = appContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        context3.startActivity(intent);
    }

    public final void verifyPayPassword(String str, String str2, String str3, PayPwdResultListener payPwdResultListener, OpenCertificationListener openCertificationListener) {
        Intrinsics.checkParameterIsNotNull(str, "scene");
        Intrinsics.checkParameterIsNotNull(str2, "paySessionId");
        Intrinsics.checkParameterIsNotNull(str3, "amount");
        Intrinsics.checkParameterIsNotNull(payPwdResultListener, "pwdResultListener");
        Intrinsics.checkParameterIsNotNull(openCertificationListener, "openCertificationListener");
        f50306c = payPwdResultListener;
        f50304a = openCertificationListener;
        Context context = appContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        Intent intent = new Intent(context, PaySecureActivity.class);
        intent.putExtra("paySessionId", str2);
        intent.putExtra("scene", str);
        intent.putExtra("amount", str3);
        intent.putExtra("scene_type", 2);
        Context context2 = appContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        if (!(context2 instanceof Activity)) {
            intent.addFlags(268435456);
        }
        Context context3 = appContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
        }
        context3.startActivity(intent);
    }
}
