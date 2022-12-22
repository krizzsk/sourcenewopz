package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.global.globalgenerickit.utils.UIThreadHandler;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.sdk.apm.SystemUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/BoletoPopTask;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask;", "taskId", "", "(I)V", "bizData", "", "canShow", "", "context", "Landroid/content/Context;", "checkBoletoTypableLength", "codeText", "dismiss", "", "removeNonNumber", "s", "reqData", "onFinish", "Lkotlin/Function0;", "show", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.BoletoPopTask */
/* compiled from: BoletoPopTask.kt */
public final class BoletoPopTask extends PopTask {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f32755b = "DDF-BoletoPopTask";

    /* renamed from: c */
    private static final String f32756c = "[^0-9]";

    /* renamed from: d */
    private static final int f32757d = 47;

    /* renamed from: e */
    private static final int f32758e = 48;

    /* renamed from: a */
    private String f32759a;

    public BoletoPopTask(int i) {
        super(i, 2);
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/BoletoPopTask$Companion;", "", "()V", "REGEX_NON_NUMBER", "", "TAG", "TYPABLE_MAX_LENGTH", "", "TYPABLE_MIN_LENGTH", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.BoletoPopTask$Companion */
    /* compiled from: BoletoPopTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean canShow(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.f32759a;
        boolean z = str != null && m23145b(str);
        SystemUtils.log(6, f32755b, Intrinsics.stringPlus("canShow = ", Boolean.valueOf(z)), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.BoletoPopTask", 33);
        return z;
    }

    public void show(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SystemUtils.log(6, f32755b, "show", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.BoletoPopTask", 38);
        if (context instanceof Activity) {
            WalletRouter.postClipboardChecker((Activity) context, 3);
        }
    }

    public void reqData(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "onFinish");
        SystemUtils.log(6, f32755b, "reqData start", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.BoletoPopTask", 45);
        setStatus(1);
        this.f32759a = null;
        UIThreadHandler.post(new Runnable(context, this, function0) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ BoletoPopTask f$1;
            public final /* synthetic */ Function0 f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                BoletoPopTask.m23144a(this.f$0, this.f$1, this.f$2);
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23144a(Context context, BoletoPopTask boletoPopTask, Function0 function0) {
        Context context2 = context;
        BoletoPopTask boletoPopTask2 = boletoPopTask;
        Intrinsics.checkNotNullParameter(context2, "$context");
        Intrinsics.checkNotNullParameter(boletoPopTask2, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$onFinish");
        String clipboardText = NClipBoardUtil.Companion.getClipboardText(context2);
        CharSequence charSequence = clipboardText;
        if (!TextUtils.isEmpty(charSequence) && !StringsKt.contains$default(charSequence, (CharSequence) "BR.GOV.BCB.PIX", false, 2, (Object) null)) {
            String lowerCase = "BR.GOV.BCB.PIX".toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            if (!StringsKt.contains$default(charSequence, (CharSequence) lowerCase, false, 2, (Object) null)) {
                boletoPopTask2.f32759a = boletoPopTask2.m23143a(clipboardText);
                boletoPopTask2.setStatus(2);
                SystemUtils.log(6, f32755b, "reqData end", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.BoletoPopTask", 62);
                function0.invoke();
                return;
            }
        }
        boletoPopTask2.setStatus(2);
        SystemUtils.log(6, f32755b, "reqData end", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.BoletoPopTask", 56);
        function0.invoke();
    }

    /* renamed from: a */
    private final String m23143a(String str) {
        if (str == null) {
            return null;
        }
        return new Regex(f32756c).replace((CharSequence) str, "");
    }

    /* renamed from: b */
    private final boolean m23145b(String str) {
        return str != null && str.length() >= 47 && str.length() <= 48;
    }

    public void dismiss(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            WalletRouter.removeClipboardChecker((Activity) context, 3);
        }
    }
}
