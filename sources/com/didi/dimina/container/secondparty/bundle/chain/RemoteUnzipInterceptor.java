package com.didi.dimina.container.secondparty.bundle.chain;

import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.UnzipManager;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.util.InterceptorConfigHelper;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.LogUtil;

public class RemoteUnzipInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM RemoteUnzipInterceptor";

    /* renamed from: a */
    private int f17069a = 0;

    /* access modifiers changed from: protected */
    public boolean process() {
        LogUtil.iRelease(TAG, "process() -> \t config=" + this.config + "\tthis@" + hashCode());
        if (this.config.remoteErrCode != -9999) {
            return true;
        }
        m12620a();
        return true;
    }

    /* renamed from: a */
    private void m12620a() {
        this.f17069a++;
        DebugExceptionUtil.dottingPmTime(TAG, "  开始 unzip, mUnzipRetryCount -> " + this.f17069a);
        UnzipManager.unzip(this.config.downloadModuleList, new IDMCommonAction() {
            public final void callback(Object obj) {
                RemoteUnzipInterceptor.this.m12621a((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12621a(Boolean bool) {
        LogUtil.iRelease(TAG, "解压结果 -> " + bool);
        if (!bool.booleanValue()) {
            LogUtil.eRelease(TAG, "解压失败 mUnzipRetryCount -> " + this.f17069a);
            InterceptorConfigHelper.deleteDownloadInFilesdir(this.config);
            if (this.f17069a < 3) {
                DebugExceptionUtil.dottingPmTime(TAG, " 解压失败，重试, mUnzipRetryCount -> " + this.f17069a);
                m12620a();
                return;
            }
            DebugExceptionUtil.dottingPmTime(TAG, " 解压失败，已达最大次数:" + this.f17069a + " 不再重试 ");
            this.config.remoteErrCode = PckErrCode.UNZIP_ERROR;
            for (InstallModuleFileDescribe cacheAbsolutePath : this.config.downloadModuleList) {
                PmFileUtil.deleteFile(cacheAbsolutePath.getCacheAbsolutePath());
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoteUnzipInterceptor{, App:'");
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
