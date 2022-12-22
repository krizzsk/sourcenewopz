package com.didi.dimina.container.secondparty.bundle.chain;

import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.secondparty.bundle.PmIOQueueManager;
import com.didi.dimina.container.secondparty.bundle.PmInstallManager;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.util.LogUtil;

public class SubPreCbInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM SubPreCbInterceptor";

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> config=" + this.config);
        if (this.config.subPreErrCode == -9999) {
            this.config.subPreErrCode = 0;
        }
        if (this.config.installCb != null) {
            DMThreadPool.getExecutor().execute(new Runnable() {
                public final void run() {
                    SubPreCbInterceptor.this.m12626a();
                }
            });
        }
        LogUtil.iRelease(TAG, "前置下载结束！" + PckErrCode.code2Msg(this.config.subPreErrCode));
        PmIOQueueManager.getInstance().setRunningStatusOver();
        PmIOQueueManager.getInstance().exec();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12626a() {
        this.config.installCb.onSubPreInstall(this.config.subPreErrCode, this.config.subPreDownloadModuleList, new PmInstallManager.InstallExtraInfo());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubPreCbInterceptor{, App:'");
        sb.append(this.jsAppId);
        sb.append('\'');
        sb.append(", sdk:'");
        sb.append(this.jsSdkId);
        sb.append('\'');
        sb.append(", @");
        sb.append(hashCode());
        sb.append(", DMMina@");
        sb.append(this.mina != null ? Integer.valueOf(this.mina.hashCode()) : "null");
        sb.append('}');
        return sb.toString();
    }
}
