package com.didi.dimina.container.secondparty.bundle.chain;

import com.didi.dimina.container.secondparty.bundle.PmCallback;
import com.didi.dimina.container.secondparty.bundle.download.PmDownloadTask;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "isSuccess", "", "onResult"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DownloadInterceptor.kt */
final class DownloadInterceptor$startLoad$1<T> implements PmCallback<Boolean> {
    final /* synthetic */ DownloadInterceptor this$0;

    DownloadInterceptor$startLoad$1(DownloadInterceptor downloadInterceptor) {
        this.this$0 = downloadInterceptor;
    }

    public /* synthetic */ void onResult(Object obj) {
        onResult(((Boolean) obj).booleanValue());
    }

    public final void onResult(boolean z) {
        LogUtil.iRelease(DownloadInterceptor.TAG, "------------------  最终的下载结果 ->" + z);
        if (!z) {
            LogUtil.eRelease(DownloadInterceptor.TAG, "App启动时install过程, 下载任务失败,删除cache中的目录");
            this.this$0.config.remoteErrCode = PckErrCode.DOWNLOAD_ERROR;
            for (PmDownloadTask pmDownloadTask : this.this$0.f17066a) {
                if (pmDownloadTask == null) {
                    Intrinsics.throwNpe();
                }
                PmFileUtil.deleteFile(pmDownloadTask.saveFilePath);
            }
        }
        int i = this.this$0.config.remoteErrCode == -9999 ? 1 : -1;
        DownloadInterceptor downloadInterceptor = this.this$0;
        InterceptorConfig interceptorConfig = downloadInterceptor.config;
        Intrinsics.checkExpressionValueIsNotNull(interceptorConfig, "config");
        String str = "";
        if (i != 1) {
            str = str + this.this$0.config.remoteErrCode;
        }
        downloadInterceptor.traceRemoteInstallEnd(i, interceptorConfig, str);
        this.this$0.m12613f();
    }
}
