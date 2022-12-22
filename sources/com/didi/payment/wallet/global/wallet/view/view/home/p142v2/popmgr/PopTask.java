package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H&R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask;", "", "taskId", "", "priority", "(II)V", "getPriority", "()I", "setPriority", "(I)V", "status", "getStatus$annotations", "()V", "getStatus", "setStatus", "getTaskId", "setTaskId", "canShow", "", "context", "Landroid/content/Context;", "dismiss", "", "reqData", "onFinish", "Lkotlin/Function0;", "show", "Companion", "ReqCallback", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopTask */
/* compiled from: PopTask.kt */
public abstract class PopTask {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MIDDLE = 2;

    /* renamed from: a */
    private int f32763a;

    /* renamed from: b */
    private int f32764b;

    /* renamed from: c */
    private int f32765c;

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask$ReqCallback;", "", "onFinish", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopTask$ReqCallback */
    /* compiled from: PopTask.kt */
    public interface ReqCallback {
        void onFinish();
    }

    public static /* synthetic */ void getStatus$annotations() {
    }

    public abstract boolean canShow(Context context);

    public abstract void dismiss(Context context);

    public abstract void reqData(Context context, Function0<Unit> function0);

    public abstract void show(Context context);

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask$Companion;", "", "()V", "PRIORITY_HIGH", "", "PRIORITY_LOW", "PRIORITY_MIDDLE", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopTask$Companion */
    /* compiled from: PopTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PopTask(int i, int i2) {
        this.f32763a = i;
        this.f32764b = i2;
    }

    public final int getPriority() {
        return this.f32764b;
    }

    public final int getTaskId() {
        return this.f32763a;
    }

    public final void setPriority(int i) {
        this.f32764b = i;
    }

    public final void setTaskId(int i) {
        this.f32763a = i;
    }

    public final int getStatus() {
        return this.f32765c;
    }

    public final void setStatus(int i) {
        this.f32765c = i;
    }
}
