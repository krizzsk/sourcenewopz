package com.didi.dimina.container.secondparty.bundle.chain;

import android.text.TextUtils;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.secondparty.bundle.PmIOQueueManager;
import com.didi.dimina.container.secondparty.bundle.PmInstallManager;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmJsonUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;

public class RemoteCbInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM RemoteCbInterceptor";

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> config=" + this.config);
        if (this.config.remoteErrCode == -9999) {
            this.config.remoteErrCode = 0;
        }
        if (this.config.remoteErrCode != 0 || (!this.config.isJsAppNeedDownload && !this.config.isJsSdkNeedDownload)) {
            LogUtil.iRelease(TAG, "没有下载过程, 所以不需要重新接入配置文件");
        } else {
            if (!this.config.isJsAppNeedDownload) {
                DMConfigBean dMConfigBean = this.config.localDmConfigBean;
                DMConfigBean dMConfigBean2 = this.config.httpDmConfigBean;
                dMConfigBean2.setAppId(dMConfigBean.getAppId());
                dMConfigBean2.setAppVersionCode(dMConfigBean.getAppVersionCode());
                dMConfigBean2.setAppVersionName(dMConfigBean.getAppVersionName());
                dMConfigBean2.setAppModules(dMConfigBean.getAppModules());
            }
            if (!this.config.isJsSdkNeedDownload) {
                DMConfigBean dMConfigBean3 = this.config.localDmConfigBean;
                DMConfigBean dMConfigBean4 = this.config.httpDmConfigBean;
                dMConfigBean4.setSdkId(dMConfigBean3.getSdkId(this.mina));
                dMConfigBean4.setSdkVersionCode(dMConfigBean3.getSdkVersionCode());
                dMConfigBean4.setSdkVersionName(dMConfigBean3.getSdkVersionName());
                dMConfigBean4.setSdkModule(dMConfigBean3.getSdkModule());
            }
            String pmJsonUtil = PmJsonUtil.toString(this.config.httpDmConfigBean);
            LogUtil.iRelease(TAG, "写入dm_config 长度: " + CollectionsUtil.getSize(pmJsonUtil) + "\t 写入内容:" + this.config.httpDmConfigBean);
            if (!TextUtils.isEmpty(pmJsonUtil)) {
                PmFileHelper.writeDmConfig2MMKV(this.jsAppId, pmJsonUtil, this.mina);
            }
        }
        LogUtil.iRelease(TAG, "处理remote安装结果, errorCode=" + this.config.remoteErrCode);
        if (this.config.installCb != null) {
            DMThreadPool.getExecutor().execute(new Runnable() {
                public final void run() {
                    RemoteCbInterceptor.this.m12619b();
                }
            });
        }
        DebugExceptionUtil.dottingPmTime(TAG, "--------------------------- 全流程结束 errCode=" + PckErrCode.code2Msg(this.config.remoteErrCode));
        this.mina.getPerformance().setRemoteInstallEndTime();
        m12618a();
        PmIOQueueManager.getInstance().setRunningStatusOver();
        PmIOQueueManager.getInstance().exec();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12619b() {
        if (this.config.localErrCode != 0) {
            if (this.config.remoteErrCode != 0) {
                LogUtil.eRelease(TAG, "local fail, remote 也fail。 所以回调本地也是之前的fail");
                this.config.installCb.onLocalInstall(this.config.localErrCode, this.config.localDmConfigBean, (PmInstallManager.InstallExtraInfo) null);
            } else if (this.config.isJsSdkNeedDownload || this.config.isJsAppNeedDownload) {
                LogUtil.iRelease(TAG, "local fail, remote succ。 所以回调本地也成功");
                this.config.installCb.onLocalInstall(0, this.config.httpDmConfigBean, (PmInstallManager.InstallExtraInfo) null);
            } else {
                LogUtil.eRelease(TAG, "local fail, remote succ, 但是没有下载过程, 所以回调本地也是之前的fail");
                this.config.installCb.onLocalInstall(this.config.localErrCode, this.config.localDmConfigBean, (PmInstallManager.InstallExtraInfo) null);
            }
        }
        this.config.installCb.onRemoteInstall(this.config.remoteErrCode, this.config.httpDmConfigBean, new PmInstallManager.InstallExtraInfo());
    }

    /* renamed from: a */
    private void m12618a() {
        SubPreDownloadInterceptor subPreDownloadInterceptor = new SubPreDownloadInterceptor();
        subPreDownloadInterceptor.setValue(this.mina, this.config);
        DMThreadPool.DmThreadPoolExecutor executor = DMThreadPool.getExecutor();
        subPreDownloadInterceptor.getClass();
        executor.execute(new Runnable() {
            public final void run() {
                SubPreDownloadInterceptor.this.intercept();
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoteCbInterceptor{, App:'");
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
