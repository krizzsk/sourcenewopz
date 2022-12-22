package com.didi.dimina.container.mina;

import android.util.Log;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DMThreadPool.kt */
final class DMThreadPool$DmThreadPoolExecutor$execute$1 implements Runnable {
    final /* synthetic */ Runnable $command;

    DMThreadPool$DmThreadPoolExecutor$execute$1(Runnable runnable) {
        this.$command = runnable;
    }

    public final void run() {
        try {
            this.$command.run();
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("线程执行 发生异常");
            Throwable th = e;
            sb.append(Log.getStackTraceString(th));
            LogUtil.eRelease(DMThreadPool.TAG, sb.toString());
            TraceUtil.tracePmException(th, PckErrCode.THREAD_EXEC_EXCEPTION, "线程执行时发生异常");
        }
    }
}
