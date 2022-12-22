package com.didi.dimina.container.secondparty.bundle.chain;

import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.secondparty.bundle.PmIOQueueManager;
import com.didi.dimina.container.secondparty.bundle.PmInstallManager;
import com.didi.dimina.container.secondparty.bundle.util.InterceptorConfigHelper;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.util.LogUtil;

public class LocalCbInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM LocalCbInterceptor";

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> \t config=" + this.config + "\tthis@" + hashCode());
        if (this.config.localErrCode == -9999) {
            this.config.localErrCode = 0;
        }
        if (this.config.installCb == null || this.config.localErrCode != 0) {
            LogUtil.eRelease(TAG, "不进行本地回调，localCb为null，或者 结果错误:" + PckErrCode.code2Msg(this.config.localErrCode));
        } else {
            this.config.installCb.onLocalInstall(this.config.localErrCode, this.config.localDmConfigBean, (PmInstallManager.InstallExtraInfo) null);
        }
        InterceptorConfigHelper.dealProcessCallBack(this.config, 1);
        m12615a();
        PmIOQueueManager.getInstance().setRunningStatusOver();
        PmIOQueueManager.getInstance().exec();
        return true;
    }

    /* renamed from: a */
    private void m12615a() {
        LogUtil.iRelease(TAG, " 本地io执行完毕, 本地执行errCode:" + PckErrCode.code2Msg(this.config.localErrCode) + " 准备启动新线程, 执行耗时任务(api/config接口， 下载)");
        IPckInterceptor consumeHttpChain = ChainManager.getConsumeHttpChain();
        consumeHttpChain.setValue(this.mina, this.config);
        DMThreadPool.getExecutor().execute(new Runnable() {
            public final void run() {
                IPckInterceptor.this.intercept();
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocalCbInterceptor{, App:'");
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
