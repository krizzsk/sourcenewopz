package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/TaskFactory;", "", "()V", "TASK_ID_API", "", "TASK_ID_BOLETO", "TASK_ID_FIN_SYS", "create", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask;", "taskId", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.TaskFactory */
/* compiled from: TaskFactory.kt */
public final class TaskFactory {
    public static final TaskFactory INSTANCE = new TaskFactory();
    public static final int TASK_ID_API = 100;
    public static final int TASK_ID_BOLETO = 300;
    public static final int TASK_ID_FIN_SYS = 200;

    private TaskFactory() {
    }

    public final PopTask create(int i) {
        if (i == 100) {
            return new PopUpApiTask(i);
        }
        if (i == 200) {
            return new FinSysPopTask(i);
        }
        if (i != 300) {
            return null;
        }
        return new BoletoPopTask(i);
    }
}
