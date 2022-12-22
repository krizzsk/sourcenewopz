package com.didi.dimina.container.secondparty.bundle.chain;

import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.UnzipManager;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.util.InterceptorConfigHelper;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.LogUtil;

public class SubPreUnzipInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM SubPreUnzipInterceptor";

    /* renamed from: a */
    private int f17079a = 0;

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> \t config=" + this.config + "\tthis@" + hashCode());
        if (this.config.subPreErrCode != -9999) {
            return true;
        }
        m12632a();
        return true;
    }

    /* renamed from: a */
    private void m12632a() {
        this.f17079a++;
        DebugExceptionUtil.dottingPmTime(TAG, " 分包前置下载 开始 unzip, mUnzipRetryCount -> " + this.f17079a);
        UnzipManager.unzip(this.config.subPreDownloadModuleList, new IDMCommonAction() {
            public final void callback(Object obj) {
                SubPreUnzipInterceptor.this.m12633a((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12633a(Boolean bool) {
        LogUtil.iRelease(TAG, "分包前置下载 解压结果 -> " + bool);
        if (!bool.booleanValue()) {
            LogUtil.eRelease(TAG, "分包前置下载 解压失败 mUnzipRetryCount -> " + this.f17079a);
            InterceptorConfigHelper.deleteDownloadInFilesdir(this.config);
            if (this.f17079a < 3) {
                DebugExceptionUtil.dottingPmTime(TAG, "分包前置下载 解压失败，重试, mUnzipRetryCount -> " + this.f17079a);
                m12632a();
                return;
            }
            DebugExceptionUtil.dottingPmTime(TAG, "分包前置下载 解压失败，已达最大次数:" + this.f17079a + " 不再重试 ");
            this.config.subPreErrCode = PckErrCode.SUB_PRE_UNZIP_ERROR;
            for (InstallModuleFileDescribe cacheAbsolutePath : this.config.subPreDownloadModuleList) {
                PmFileUtil.deleteFile(cacheAbsolutePath.getCacheAbsolutePath());
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubPreUnzipInterceptor{, App:'");
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
