package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/WHomePopChain;", "", "()V", "TAG", "", "isHomeVisible", "", "()Z", "setHomeVisible", "(Z)V", "tasks", "Ljava/util/ArrayList;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask;", "Lkotlin/collections/ArrayList;", "addTask", "taskId", "", "dismiss", "", "context", "Landroid/content/Context;", "getTaskById", "getTaskName", "process", "start", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain */
/* compiled from: WHomePopChain.kt */
public final class WHomePopChain {
    public static final WHomePopChain INSTANCE = new WHomePopChain();

    /* renamed from: a */
    private static final String f32769a = "DDF-WHomePopChain";

    /* renamed from: b */
    private static final ArrayList<PopTask> f32770b = new ArrayList<>();

    /* renamed from: c */
    private static boolean f32771c;

    public final String getTaskName(int i) {
        return i != 100 ? i != 200 ? i != 300 ? "null" : "BoletoPopTask" : "FinSysPopTask" : "PopUpApiTask";
    }

    private WHomePopChain() {
    }

    public final boolean isHomeVisible() {
        return f32771c;
    }

    public final void setHomeVisible(boolean z) {
        f32771c = z;
    }

    public final WHomePopChain addTask(int i) {
        String str = f32769a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("addTask %s ", Arrays.copyOf(new Object[]{getTaskName(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        SystemUtils.log(6, str, format, (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 21);
        for (PopTask taskId : f32770b) {
            if (taskId.getTaskId() == i) {
                return this;
            }
        }
        PopTask create = TaskFactory.INSTANCE.create(i);
        if (create == null) {
            return this;
        }
        int priority = create.getPriority();
        if (f32770b.isEmpty()) {
            f32770b.add(create);
            return this;
        }
        int lastIndex = CollectionsKt.getLastIndex(f32770b);
        if (lastIndex >= 0) {
            while (true) {
                int i2 = lastIndex - 1;
                if (f32770b.get(lastIndex).getPriority() < priority) {
                    if (i2 < 0) {
                        break;
                    }
                    lastIndex = i2;
                } else if (lastIndex == CollectionsKt.getLastIndex(f32770b)) {
                    f32770b.add(create);
                } else {
                    f32770b.add(lastIndex + 1, create);
                }
            }
        }
        f32770b.add(create);
        return this;
    }

    public final void start(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        PopTask taskById = getTaskById(i);
        if (taskById != null) {
            String str = f32769a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("startTask %s ", Arrays.copyOf(new Object[]{getTaskName(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            SystemUtils.log(6, str, format, (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 51);
            taskById.reqData(context, new WHomePopChain$start$1(context));
        }
    }

    public final PopTask getTaskById(int i) {
        for (PopTask popTask : f32770b) {
            if (popTask.getTaskId() == i) {
                return popTask;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m23151a(Context context) {
        Context context2 = context;
        Iterator<PopTask> it = f32770b.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "tasks.iterator()");
        while (it.hasNext()) {
            PopTask next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            PopTask popTask = next;
            if (popTask.getStatus() != 2) {
                SystemUtils.log(6, f32769a, Intrinsics.stringPlus("process: task not ready:  ", getTaskName(popTask.getTaskId())), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 72);
                return;
            }
            SystemUtils.log(6, f32769a, Intrinsics.stringPlus("process: taskid = ", getTaskName(popTask.getTaskId())), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 75);
            if (popTask.canShow(context2)) {
                if (f32771c) {
                    popTask.show(context2);
                } else {
                    SystemUtils.log(6, f32769a, "process: isHomeVisible = false", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 80);
                }
                f32770b.clear();
                SystemUtils.log(6, f32769a, "process: clear tasks", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 83);
                return;
            }
            it.remove();
            SystemUtils.log(6, f32769a, Intrinsics.stringPlus("process: remove taskid = ", getTaskName(popTask.getTaskId())), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 87);
        }
    }

    public final void dismiss(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        PopTask taskById = getTaskById(i);
        if (taskById != null) {
            taskById.dismiss(context);
        }
    }
}
