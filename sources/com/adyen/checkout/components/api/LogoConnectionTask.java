package com.adyen.checkout.components.api;

import android.graphics.drawable.BitmapDrawable;
import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.adyen.checkout.core.api.ConnectionTask;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0002H\u0002R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/LogoConnectionTask;", "Lcom/adyen/checkout/core/api/ConnectionTask;", "Landroid/graphics/drawable/BitmapDrawable;", "logoApi", "Lcom/adyen/checkout/components/api/LogoApi;", "logoUrl", "", "callback", "Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;", "(Lcom/adyen/checkout/components/api/LogoApi;Ljava/lang/String;Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;)V", "callbacks", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getCallbacks", "()Ljava/util/HashSet;", "setCallbacks", "(Ljava/util/HashSet;)V", "getLogoUrl", "()Ljava/lang/String;", "addCallback", "", "done", "notifyCallbacksFailed", "notifyCallbacksReceived", "drawable", "notifyFailed", "notifyLogo", "Companion", "LogoCallback", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LogoConnectionTask.kt */
public final class LogoConnectionTask extends ConnectionTask<BitmapDrawable> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final String f638d;

    /* renamed from: e */
    private static final int f639e = 100;

    /* renamed from: a */
    private final LogoApi f640a;

    /* renamed from: b */
    private final String f641b;

    /* renamed from: c */
    private HashSet<LogoCallback> f642c;

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/LogoConnectionTask$LogoCallback;", "", "onLogoReceived", "", "drawable", "Landroid/graphics/drawable/BitmapDrawable;", "onReceiveFailed", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogoConnectionTask.kt */
    public interface LogoCallback {
        void onLogoReceived(BitmapDrawable bitmapDrawable);

        void onReceiveFailed();
    }

    public final String getLogoUrl() {
        return this.f641b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogoConnectionTask(LogoApi logoApi, String str, LogoCallback logoCallback) {
        super(new LogoConnection(str));
        Intrinsics.checkNotNullParameter(logoApi, "logoApi");
        Intrinsics.checkNotNullParameter(str, "logoUrl");
        Intrinsics.checkNotNullParameter(logoCallback, "callback");
        this.f640a = logoApi;
        this.f641b = str;
        this.f642c = SetsKt.hashSetOf(logoCallback);
    }

    public final HashSet<LogoCallback> getCallbacks() {
        return this.f642c;
    }

    public final void setCallbacks(HashSet<LogoCallback> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.f642c = hashSet;
    }

    /* access modifiers changed from: protected */
    public void done() {
        Logger.m1082v(f638d, "done");
        if (isCancelled()) {
            Logger.m1076d(f638d, StatusResponseUtils.RESULT_CANCELED);
            m1037a();
            return;
        }
        try {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) get(100, TimeUnit.MILLISECONDS);
            Intrinsics.checkNotNullExpressionValue(bitmapDrawable, "result");
            m1038a(bitmapDrawable);
        } catch (ExecutionException unused) {
            Logger.m1078e(f638d, Intrinsics.stringPlus("Execution failed for logo  - ", this.f641b));
            m1037a();
        } catch (InterruptedException e) {
            Logger.m1079e(f638d, "Execution interrupted.", e);
            m1037a();
        } catch (TimeoutException e2) {
            Logger.m1079e(f638d, "Execution timed out.", e2);
            m1037a();
        }
    }

    public final void addCallback(LogoCallback logoCallback) {
        Intrinsics.checkNotNullParameter(logoCallback, "callback");
        synchronized (this) {
            getCallbacks().add(logoCallback);
        }
    }

    /* renamed from: a */
    private final void m1038a(BitmapDrawable bitmapDrawable) {
        ThreadManager.MAIN_HANDLER.post(new Runnable(bitmapDrawable) {
            public final /* synthetic */ BitmapDrawable f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                LogoConnectionTask.m1040a(LogoConnectionTask.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m1040a(LogoConnectionTask logoConnectionTask, BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(logoConnectionTask, "this$0");
        Intrinsics.checkNotNullParameter(bitmapDrawable, "$drawable");
        logoConnectionTask.f640a.taskFinished(logoConnectionTask.getLogoUrl(), bitmapDrawable);
        logoConnectionTask.m1042b(bitmapDrawable);
    }

    /* renamed from: a */
    private final void m1037a() {
        ThreadManager.MAIN_HANDLER.post(new Runnable() {
            public final void run() {
                LogoConnectionTask.m1039a(LogoConnectionTask.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m1039a(LogoConnectionTask logoConnectionTask) {
        Intrinsics.checkNotNullParameter(logoConnectionTask, "this$0");
        logoConnectionTask.f640a.taskFinished(logoConnectionTask.getLogoUrl(), (BitmapDrawable) null);
        logoConnectionTask.m1041b();
    }

    /* renamed from: b */
    private final void m1042b(BitmapDrawable bitmapDrawable) {
        synchronized (this) {
            for (LogoCallback onLogoReceived : getCallbacks()) {
                onLogoReceived.onLogoReceived(bitmapDrawable);
            }
            getCallbacks().clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: b */
    private final void m1041b() {
        synchronized (this) {
            for (LogoCallback onReceiveFailed : getCallbacks()) {
                onReceiveFailed.onReceiveFailed();
            }
            getCallbacks().clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/adyen/checkout/components/api/LogoConnectionTask$Companion;", "", "()V", "SAFETY_TIMEOUT", "", "TAG", "", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LogoConnectionTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        f638d = tag;
    }
}
