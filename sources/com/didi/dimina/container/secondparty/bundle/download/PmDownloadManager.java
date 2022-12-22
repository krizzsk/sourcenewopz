package com.didi.dimina.container.secondparty.bundle.download;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.PmCallback;
import com.didi.dimina.container.secondparty.bundle.http.PmDownloadCallback;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PmDownloadManager {

    /* renamed from: a */
    private static final String f17080a = "Dimina-PM PmDownloadManager";

    /* renamed from: b */
    private static final int f17081b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final List<PmDownloadTask> f17082c = new ArrayList();

    public void download(List<PmDownloadTask> list, PmCallback<Boolean> pmCallback) {
        LogUtil.iRelease(f17080a, "download, tasks: " + list);
        if (!CollectionsUtil.isEmpty((Collection) list)) {
            f17082c.addAll(list);
            AtomicInteger[] atomicIntegerArr = {new AtomicInteger(), new AtomicInteger()};
            int size = list.size();
            for (PmDownloadTask next : list) {
                final AtomicInteger[] atomicIntegerArr2 = atomicIntegerArr;
                final int i = size;
                final PmCallback<Boolean> pmCallback2 = pmCallback;
                final PmDownloadTask pmDownloadTask = next;
                m12638a(next, new PmDownloadCallback() {
                    private int retryCount = 0;

                    public void onStart() {
                    }

                    public void onSucceed(File file) {
                        atomicIntegerArr2[0].getAndIncrement();
                        PmDownloadManager.this.m12635a(i, atomicIntegerArr2, (PmCallback<Boolean>) pmCallback2);
                        PmDownloadManager.f17082c.remove(pmDownloadTask);
                    }

                    public void onFailed(Exception exc) {
                        int i;
                        if (pmDownloadTask.getStatus() == 4 || (i = this.retryCount) >= 2) {
                            atomicIntegerArr2[1].getAndIncrement();
                            PmDownloadManager.this.m12635a(i, atomicIntegerArr2, (PmCallback<Boolean>) pmCallback2);
                            PmDownloadManager.f17082c.remove(pmDownloadTask);
                            return;
                        }
                        this.retryCount = i + 1;
                        PmDownloadManager.this.m12638a(pmDownloadTask, (PmDownloadCallback) null);
                    }
                });
            }
        }
    }

    public static void cancelDownloadTask(String str, int i) {
        for (PmDownloadTask next : f17082c) {
            if (next.getModuleId() == ((long) i) && TextUtils.equals(next.getAppId(), str) && next.getStatus() == 0) {
                next.cancel();
                LogUtil.iRelease(f17080a, "下载被取消 - " + next);
                return;
            }
        }
    }

    public static void cancelPreDownloadTask(String str) {
        Iterator it = new ArrayList(f17082c).iterator();
        while (it.hasNext()) {
            PmDownloadTask pmDownloadTask = (PmDownloadTask) it.next();
            if (pmDownloadTask.isPreload() && TextUtils.equals(pmDownloadTask.getAppId(), str)) {
                pmDownloadTask.cancel();
                LogUtil.iRelease(f17080a, "预下载被取消 - " + pmDownloadTask.getAppId() + "/" + pmDownloadTask.getModuleName());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12638a(PmDownloadTask pmDownloadTask, PmDownloadCallback pmDownloadCallback) {
        if (pmDownloadCallback != null) {
            pmDownloadTask.addDownloadCallback(pmDownloadCallback);
        }
        pmDownloadTask.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12635a(int i, AtomicInteger[] atomicIntegerArr, PmCallback<Boolean> pmCallback) {
        boolean z = false;
        if (atomicIntegerArr[0].get() + atomicIntegerArr[1].get() == i) {
            if (pmCallback != null) {
                if (atomicIntegerArr[1].get() == 0) {
                    z = true;
                }
                LogUtil.iRelease(f17080a, "** checkDownloadResult, isSuccess: " + z);
                pmCallback.onResult(Boolean.valueOf(z));
            }
        } else if (atomicIntegerArr[0].get() + atomicIntegerArr[1].get() > i) {
            LogUtil.iRelease(f17080a, "** checkDownloadResult, isSuccess: >");
        }
    }
}
