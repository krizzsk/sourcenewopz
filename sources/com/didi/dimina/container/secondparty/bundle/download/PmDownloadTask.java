package com.didi.dimina.container.secondparty.bundle.download;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback;
import com.didi.dimina.container.secondparty.bundle.http.PmHttpUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmEncryptUtils;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.util.LogUtil;
import didihttp.Call;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PmDownloadTask {
    public static final int DOWNLOAD_STATE_CANCEL = 4;
    public static final int DOWNLOAD_STATE_DOING = 1;
    public static final int DOWNLOAD_STATE_FAILED = 3;
    public static final int DOWNLOAD_STATE_IDLE = 0;
    public static final int DOWNLOAD_STATE_SUCCEED = 2;

    /* renamed from: a */
    private static final String f17083a = "Dimina-PM PmDownloadTask";
    public String appId;

    /* renamed from: b */
    private Call f17084b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile int f17085c = 0;

    /* renamed from: d */
    private final List<PmDownloadCallback> f17086d = new ArrayList();

    /* renamed from: e */
    private boolean f17087e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f17088f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f17089g;
    public String md5;
    public long moduleId;
    public String moduleName;
    public String saveFilePath;
    public String url;

    public PmDownloadTask(String str, long j, String str2, String str3, String str4, String str5) {
        this.appId = str;
        this.moduleId = j;
        this.md5 = str2;
        this.url = str3;
        this.saveFilePath = str4;
        this.moduleName = str5;
    }

    public String getAppId() {
        return this.appId;
    }

    public long getModuleId() {
        return this.moduleId;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public boolean isPreload() {
        return this.f17087e;
    }

    public void setPreload(boolean z) {
        this.f17087e = z;
    }

    public PmDownloadTask addDownloadCallback(PmDownloadCallback pmDownloadCallback) {
        if (pmDownloadCallback != null) {
            this.f17086d.add(pmDownloadCallback);
        }
        return this;
    }

    public PmDownloadTask start() {
        if (TextUtils.isEmpty(this.url)) {
            throw new RuntimeException("下载参数非法, url不应该为null");
        } else if (this.moduleId <= 0 || TextUtils.isEmpty(this.saveFilePath)) {
            throw new RuntimeException("download task params is invalid, moduleId=" + this.moduleId + "\t saveFilePath=" + this.saveFilePath);
        } else if (this.f17085c == 1) {
            return this;
        } else {
            this.f17085c = 1;
            final long currentTimeMillis = System.currentTimeMillis();
            this.f17084b = PmHttpUtil.download(this.url, this.saveFilePath, new PmDownloadCallback() {
                public void onStart() {
                    LogUtil.iRelease(PmDownloadTask.f17083a, "DownloadTask onStart ~~~~~~~~~~~~~~~~~~~~~ taskId = " + PmDownloadTask.this.moduleId + ", url = " + PmDownloadTask.this.url + ", saveFilePath = " + PmDownloadTask.this.saveFilePath);
                    PmDownloadTask.this.m12641a();
                }

                public void onSucceed(File file) {
                    int unused = PmDownloadTask.this.f17085c = 2;
                    String encryptMD5File2String = PmEncryptUtils.encryptMD5File2String(file);
                    long unused2 = PmDownloadTask.this.f17089g = System.currentTimeMillis() - currentTimeMillis;
                    LogUtil.iRelease(PmDownloadTask.f17083a, "DownloadTask onSucceed, time cost: " + PmDownloadTask.this.f17089g + "\t taskId=" + PmDownloadTask.this.moduleId + "\t url=" + PmDownloadTask.this.url + "\t md5=" + encryptMD5File2String);
                    if (PmDownloadTask.this.m12648a(encryptMD5File2String)) {
                        PmDownloadTask.this.m12645a(file);
                        return;
                    }
                    PmFileUtil.deleteFile(PmDownloadTask.this.saveFilePath);
                    LogUtil.eRelease(PmDownloadTask.f17083a, "下载成功，但是md5 校验失败，删除文件\t md5=" + encryptMD5File2String + "\t taskId=" + PmDownloadTask.this.moduleId + "\t url=" + PmDownloadTask.this.url);
                    PmDownloadTask.this.m12646a((Exception) new RuntimeException("download bundle md5 is invalid"));
                }

                public void onFailed(Exception exc) {
                    if (PmDownloadTask.this.f17085c == 1) {
                        int unused = PmDownloadTask.this.f17085c = 3;
                    }
                    long unused2 = PmDownloadTask.this.f17089g = System.currentTimeMillis() - currentTimeMillis;
                    LogUtil.eRelease(PmDownloadTask.f17083a, "DownloadTask onFailed, time cost: " + PmDownloadTask.this.f17089g + "\t taskId=" + PmDownloadTask.this.moduleId + "\t e=" + exc + "\t url=" + PmDownloadTask.this.url + "\t md5=" + PmDownloadTask.this.md5);
                    exc.printStackTrace();
                    PmFileUtil.deleteFile(PmDownloadTask.this.saveFilePath);
                    PmDownloadTask.this.m12646a(exc);
                    String unused3 = PmDownloadTask.this.f17088f = exc.toString();
                }
            });
            return this;
        }
    }

    public int getStatus() {
        return this.f17085c;
    }

    public void cancel() {
        this.f17085c = 4;
        Call call = this.f17084b;
        if (call != null) {
            call.cancel();
        }
        LogUtil.iRelease(f17083a, "DownloadTask cancel");
    }

    public String getErrMsg() {
        return this.f17088f;
    }

    public long getCostTime() {
        return this.f17089g;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m12648a(String str) {
        boolean z = TextUtils.isEmpty(this.md5) || this.md5.toUpperCase().equals(str);
        LogUtil.iRelease(f17083a, "DownloadTask checkMd5Valid: " + z + "\t id=" + this.moduleId + "\t url=" + this.url);
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12641a() {
        List<PmDownloadCallback> list = this.f17086d;
        if (list != null && !list.isEmpty()) {
            for (PmDownloadCallback next : this.f17086d) {
                if (next != null) {
                    next.onStart();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12645a(File file) {
        List<PmDownloadCallback> list = this.f17086d;
        if (list != null && !list.isEmpty()) {
            for (PmDownloadCallback next : this.f17086d) {
                if (next != null) {
                    next.onSucceed(file);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12646a(Exception exc) {
        for (PmDownloadCallback next : this.f17086d) {
            if (next != null) {
                next.onFailed(exc);
            }
        }
    }

    public String toString() {
        return "PmDownloadTask{moduleId=" + this.moduleId + ", md5='" + this.md5 + '\'' + ", url='" + this.url + '\'' + ", saveFilePath='" + this.saveFilePath + '\'' + ", state=" + this.f17085c + ", callbackList=" + this.f17086d + '}';
    }
}
