package com.didi.payment.base.web;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.core.util.Consumer;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.service.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/base/web/WalletDiminaUtil;", "", "()V", "DIMINA_NATIVE_H5_CALLBACK", "", "walletDiminaService", "Landroidx/core/util/Consumer;", "getWalletDiminaService", "()Landroidx/core/util/Consumer;", "setWalletDiminaService", "(Landroidx/core/util/Consumer;)V", "callback", "", "activity", "Landroid/app/Activity;", "json", "Lorg/json/JSONObject;", "callbackFromH5", "init", "application", "Landroid/app/Application;", "openDebugModel", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaService.kt */
public final class WalletDiminaUtil {
    public static final String DIMINA_NATIVE_H5_CALLBACK = "DIMINA_NATIVE_H5_CALLBACK";
    public static final WalletDiminaUtil INSTANCE = new WalletDiminaUtil();

    /* renamed from: a */
    private static Consumer<Object> f30110a;

    private WalletDiminaUtil() {
    }

    public final Consumer<Object> getWalletDiminaService() {
        return f30110a;
    }

    public final void setWalletDiminaService(Consumer<Object> consumer) {
        f30110a = consumer;
    }

    public final void init(Application application) {
        ServiceLoader<Consumer> alias;
        Consumer service;
        Intrinsics.checkNotNullParameter(application, "application");
        if (f30110a == null && (alias = DRouter.build(Consumer.class).setAlias("WalletDiminaImpl")) != null && (service = alias.getService(new Object[0])) != null) {
            WalletDiminaUtil walletDiminaUtil = INSTANCE;
            if (!(service instanceof Consumer)) {
                service = null;
            }
            walletDiminaUtil.setWalletDiminaService(service);
            Consumer<Object> walletDiminaService = INSTANCE.getWalletDiminaService();
            if (walletDiminaService != null) {
                walletDiminaService.accept(application);
            }
        }
    }

    public final void openDebugModel() {
        Consumer<Object> consumer = f30110a;
        if (consumer != null) {
            consumer.accept(1);
        }
    }

    public final void callbackFromH5(Activity activity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Consumer<Object> consumer = f30110a;
        if (consumer != null) {
            consumer.accept(jSONObject);
        }
        callback(activity, jSONObject);
    }

    public final void callback(Activity activity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!activity.isFinishing()) {
            Intent intent = new Intent();
            intent.putExtra(DIMINA_NATIVE_H5_CALLBACK, String.valueOf(jSONObject));
            activity.setResult(-1, intent);
            activity.finish();
        }
    }
}
