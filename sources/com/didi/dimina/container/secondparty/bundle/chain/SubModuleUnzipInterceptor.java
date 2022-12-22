package com.didi.dimina.container.secondparty.bundle.chain;

import android.content.Context;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.PmIOQueueManager;
import com.didi.dimina.container.secondparty.bundle.PmSubModuleReadManager;
import com.didi.dimina.container.secondparty.bundle.UnzipManager;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.util.PckErrCode;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.List;

public class SubModuleUnzipInterceptor extends IPckInterceptor {
    public static final String TAG = "Dimina-PM SubModuleUnzipInterceptor";

    /* renamed from: a */
    private final String f17070a;

    /* renamed from: b */
    private final String f17071b;

    /* renamed from: c */
    private final String f17072c;

    /* renamed from: d */
    private final String f17073d;

    /* renamed from: e */
    private final PmSubModuleReadManager.SubModuleInstallCallBack f17074e;

    /* renamed from: f */
    private PmSubModuleReadManager.SubModuleInstallCbConfig f17075f;

    /* renamed from: g */
    private int f17076g = 0;

    /* renamed from: h */
    private final List<InstallModuleFileDescribe> f17077h;

    public SubModuleUnzipInterceptor(String str, String str2, String str3, String str4, PmSubModuleReadManager.SubModuleInstallCallBack subModuleInstallCallBack, PmSubModuleReadManager.SubModuleInstallCbConfig subModuleInstallCbConfig, List<InstallModuleFileDescribe> list) {
        this.f17070a = str;
        this.f17071b = str2;
        this.f17072c = str3;
        this.f17073d = str4;
        this.f17074e = subModuleInstallCallBack;
        this.f17075f = subModuleInstallCbConfig;
        this.f17077h = list;
    }

    /* access modifiers changed from: protected */
    public boolean process() {
        List<InstallModuleFileDescribe> list = this.f17077h;
        if (list == null || list.size() <= 0) {
            m12623a(PckErrCode.SUB_INSTALL_LIST_EMPTY, (String) null);
        } else {
            m12622a();
        }
        PmIOQueueManager.getInstance().setRunningStatusOver();
        PmIOQueueManager.getInstance().exec();
        return false;
    }

    /* renamed from: a */
    private void m12622a() {
        this.f17076g++;
        DebugExceptionUtil.dottingPmTime("processDownloadResultThenOperate()", "  开始 unzip 子module mSubUnzipRetryCount=" + this.f17076g);
        UnzipManager.unzip(this.f17077h, new IDMCommonAction() {
            public final void callback(Object obj) {
                SubModuleUnzipInterceptor.this.m12624a((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12624a(Boolean bool) {
        DebugExceptionUtil.dottingPmTime("processDownloadResultThenOperate()", "  unzip 子module 结束 -> 结果:" + bool + " mSubUnzipRetryCount= + mSubUnzipRetryCount");
        if (bool.booleanValue()) {
            String read = PmFileUtil.read(m12625b());
            DebugExceptionUtil.dottingPmTime("processDownloadResultThenOperate()", "  解压成功后，读取文件耗时");
            m12623a(0, read);
            return;
        }
        LogUtil.eRelease(TAG, "解压操作失败 mSubUnzipRetryCount=" + this.f17076g);
        for (InstallModuleFileDescribe next : this.f17077h) {
            LogUtil.iRelease(TAG, "需要删除的文件列表 = " + PmFileHelper.filePath2fileDir(next.getFilesAbsolutePath()));
            PmFileUtil.deleteFile(PmFileHelper.filePath2fileDir(next.getFilesAbsolutePath()), false);
        }
        if (this.f17076g > 3) {
            LogUtil.m13412i(TAG, "解压失败的重试超过限定次数了, 放弃 回调失败 mSubUnzipRetryCount=" + this.f17076g);
            m12623a(PckErrCode.SUB_UNZIP_FAILED, (String) null);
            return;
        }
        LogUtil.m13412i(TAG, "解压失败了, 继续重试 mSubUnzipRetryCount=" + this.f17076g);
        m12622a();
    }

    /* renamed from: b */
    private String m12625b() {
        return PmFileHelper.getFilesModuleFilePath((Context) Dimina.getConfig().getApp(), this.f17070a, this.f17073d, this.f17071b, this.f17072c);
    }

    /* renamed from: a */
    private void m12623a(int i, String str) {
        if (this.f17074e != null) {
            if (this.f17075f == null) {
                this.f17075f = new PmSubModuleReadManager.SubModuleInstallCbConfig();
            }
            this.f17075f.content = str;
            this.f17075f.moduleName = this.f17071b;
            this.f17075f.finalFileName = this.f17072c;
            this.f17075f.jsVersion = this.f17073d;
            this.f17074e.onModuleInstall(i, this.f17075f);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubModuleUnzipInterceptor{, jsId:'");
        sb.append(this.f17070a);
        sb.append('\'');
        sb.append(", jsVersion:'");
        sb.append(this.f17073d);
        sb.append('\'');
        sb.append(", moduleName:'");
        sb.append(this.f17071b);
        sb.append('\'');
        sb.append(", @");
        sb.append(hashCode());
        sb.append(", DMMina@");
        sb.append(this.mina != null ? Integer.valueOf(this.mina.hashCode()) : "null");
        sb.append('}');
        return sb.toString();
    }
}
