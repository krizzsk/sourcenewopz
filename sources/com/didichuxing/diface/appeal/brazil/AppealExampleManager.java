package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import com.didichuxing.diface.appeal.video.p179M.fetch_demo.FetchDemoModel;
import com.didichuxing.diface.appeal.video.p179M.fetch_demo.FetchDemoResult;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import java.io.File;
import java.io.IOException;

public class AppealExampleManager {

    /* renamed from: a */
    private static volatile AppealExampleManager f47009a;

    /* renamed from: b */
    private Context f47010b;

    /* renamed from: c */
    private String f47011c;

    /* renamed from: d */
    private String f47012d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f47013e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f47014f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IDownloadCallback f47015g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f47016h = false;

    public interface IDownloadCallback {
        void onPhotoDownload(boolean z);

        void onVideoDownload(boolean z);
    }

    public static AppealExampleManager getInstance() {
        if (f47009a == null) {
            synchronized (AppealExampleManager.class) {
                if (f47009a == null) {
                    f47009a = new AppealExampleManager();
                }
            }
        }
        return f47009a;
    }

    public void init(Context context) {
        this.f47010b = context.getApplicationContext();
        String absolutePath = FileUtils.getDir(this.f47010b.getFilesDir() + File.separator + "diface").getAbsolutePath();
        this.f47011c = absolutePath + File.separator + "videoDemo.mp4";
        this.f47012d = absolutePath + File.separator + "photoDemo.jpg";
    }

    public void setDownloadCallback(IDownloadCallback iDownloadCallback) {
        this.f47015g = iDownloadCallback;
    }

    public void downloadExample() {
        if (!this.f47016h) {
            if (new File(this.f47011c).exists()) {
                this.f47013e = true;
            } else {
                this.f47013e = false;
            }
            if (new File(this.f47012d).exists()) {
                this.f47014f = true;
            } else {
                this.f47014f = false;
            }
            if (!this.f47013e || !this.f47014f) {
                this.f47016h = true;
                new FetchDemoModel(this.f47010b).fetch(new AbsHttpCallback<FetchDemoResult>() {
                    public void onSuccess(FetchDemoResult fetchDemoResult) {
                        int i = fetchDemoResult.data.code;
                        String str = fetchDemoResult.data.message;
                        if (i == 100000) {
                            AppealExampleManager.this.m33690a(fetchDemoResult);
                        } else {
                            onFailed(i, str);
                        }
                    }

                    public void onFailed(int i, String str) {
                        boolean unused = AppealExampleManager.this.f47016h = false;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33690a(FetchDemoResult fetchDemoResult) {
        String str = fetchDemoResult.data.result.teachVideoUrl;
        String str2 = fetchDemoResult.data.result.demoPhotoUrl;
        m33691a(str);
        m33693b(str2);
    }

    /* renamed from: a */
    private void m33691a(String str) {
        if (!this.f47013e) {
            HttpUtils.download(this.f47010b, str, new File(this.f47011c), new HttpUtils.IDownloadListener() {
                public void onSuccess() {
                    boolean unused = AppealExampleManager.this.f47013e = true;
                    if (AppealExampleManager.this.f47015g != null) {
                        AppealExampleManager.this.f47015g.onVideoDownload(true);
                    }
                }

                public void onFailed(IOException iOException) {
                    boolean unused = AppealExampleManager.this.f47013e = false;
                    if (AppealExampleManager.this.f47015g != null) {
                        AppealExampleManager.this.f47015g.onVideoDownload(false);
                    }
                }
            });
            return;
        }
        IDownloadCallback iDownloadCallback = this.f47015g;
        if (iDownloadCallback != null) {
            iDownloadCallback.onVideoDownload(true);
        }
    }

    /* renamed from: b */
    private void m33693b(String str) {
        if (!this.f47014f) {
            HttpUtils.download(this.f47010b, str, new File(this.f47012d), new HttpUtils.IDownloadListener() {
                public void onSuccess() {
                    boolean unused = AppealExampleManager.this.f47014f = true;
                    if (AppealExampleManager.this.f47015g != null) {
                        AppealExampleManager.this.f47015g.onPhotoDownload(true);
                    }
                }

                public void onFailed(IOException iOException) {
                    boolean unused = AppealExampleManager.this.f47014f = false;
                    if (AppealExampleManager.this.f47015g != null) {
                        AppealExampleManager.this.f47015g.onPhotoDownload(false);
                    }
                }
            });
            return;
        }
        IDownloadCallback iDownloadCallback = this.f47015g;
        if (iDownloadCallback != null) {
            iDownloadCallback.onPhotoDownload(true);
        }
    }

    public boolean isVideoDemoExist() {
        return this.f47013e;
    }

    public String getVideoPath() {
        return this.f47011c;
    }

    public boolean isPhotoDemoExist() {
        return this.f47014f;
    }

    public String getPhotoPath() {
        return this.f47012d;
    }

    public boolean isDownloading() {
        return this.f47016h;
    }
}
