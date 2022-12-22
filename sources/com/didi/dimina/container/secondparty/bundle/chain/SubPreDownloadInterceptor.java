package com.didi.dimina.container.secondparty.bundle.chain;

import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.bundle.PmCallback;
import com.didi.dimina.container.secondparty.bundle.PmIOQueueManager;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadHelper;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadManager;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadTask;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmBundleUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubPreDownloadInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM SubPreDownloadInterceptor";

    /* renamed from: a */
    private final List<PmDownloadTask> f17078a = new ArrayList();

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> \t config=" + this.config + "\tthis@" + hashCode());
        if (this.config.subPreErrCode != -9999) {
            m12630b();
            return true;
        } else if (this.config.httpDmConfigBean == null) {
            LogUtil.eRelease(TAG, "分包前置下载 返回结果的转化结果为null");
            this.config.subPreErrCode = PckErrCode.SUB_PRE_HTTP_DM_CONFIG_NULL;
            m12630b();
            return true;
        } else {
            this.config.subPreDownloadModuleList.clear();
            m12631c();
            if (CollectionsUtil.isEmpty((Collection) this.f17078a)) {
                LogUtil.iRelease(TAG, "分包前置下载 没有下载任务 ");
                this.config.subPreErrCode = 0;
                m12630b();
                return true;
            }
            m12627a();
            return false;
        }
    }

    /* renamed from: a */
    private void m12627a() {
        new PmDownloadManager().download(this.f17078a, new PmCallback() {
            public final void onResult(Object obj) {
                SubPreDownloadInterceptor.this.m12629a((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12629a(Boolean bool) {
        LogUtil.iRelease(TAG, "分包前置下载 ------------------  最终的下载结果 ->" + bool);
        if (!bool.booleanValue()) {
            LogUtil.eRelease(TAG, "分包前置下载任务失败,删除cache中的目录");
            this.config.subPreErrCode = PckErrCode.SUB_PRE_DOWNLOAD_ERROR;
            for (PmDownloadTask pmDownloadTask : this.f17078a) {
                PmFileUtil.deleteFile(pmDownloadTask.saveFilePath);
            }
        }
        m12630b();
    }

    /* renamed from: b */
    private void m12630b() {
        IPckInterceptor subPreIOChain = ChainManager.getSubPreIOChain();
        subPreIOChain.setValue(this.mina, this.config);
        PmIOQueueManager.getInstance().enqueue(subPreIOChain);
    }

    /* renamed from: c */
    private void m12631c() {
        if (!CollectionsUtil.isEmpty((Collection) this.config.httpDmConfigBean.getAppModules()) && PmBundleUtil.compareVersion(this.config.httpDmConfigBean.getAppVersionCode(), this.config.localDmConfigBean.getAppVersionCode()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (DMConfigBean.AppModulesBean next : this.config.httpDmConfigBean.getAppModules()) {
                if (next.getLazyDownload() == 2) {
                    arrayList.add(next);
                }
            }
            m12628a(this.config.httpDmConfigBean, arrayList);
        }
    }

    /* renamed from: a */
    private void m12628a(DMConfigBean dMConfigBean, List<DMConfigBean.AppModulesBean> list) {
        for (DMConfigBean.AppModulesBean next : list) {
            String zipModuleCacheUniquFilePath = PmFileHelper.getZipModuleCacheUniquFilePath(Dimina.getConfig().getApp(), next.getModuleName(), dMConfigBean.getAppId(), TextUtils.isEmpty(dMConfigBean.getAppVersionCode()) ? next.getVersion() : dMConfigBean.getAppVersionCode());
            LogUtil.iRelease(TAG, "分包前置下载 jsApp的 cache存储路径 =" + zipModuleCacheUniquFilePath);
            PmDownloadTask pmDownloadTask = new PmDownloadTask(this.jsAppId, (long) next.getModuleId(), next.getMd5(), next.getUrl(), zipModuleCacheUniquFilePath, next.getModuleName());
            this.f17078a.add(pmDownloadTask);
            this.config.subPreDownloadModuleList.add(PmDownloadHelper.appModulesBean2InstallModuleFileDescribe(next, pmDownloadTask.saveFilePath));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubPreDownloadInterceptor{, App:'");
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
