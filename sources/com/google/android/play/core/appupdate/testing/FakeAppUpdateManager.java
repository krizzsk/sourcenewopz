package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.C18265a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeAppUpdateManager implements AppUpdateManager {

    /* renamed from: a */
    private final C18265a f52668a;

    /* renamed from: b */
    private final Context f52669b;

    /* renamed from: c */
    private int f52670c = 0;

    /* renamed from: d */
    private int f52671d = 0;

    /* renamed from: e */
    private boolean f52672e = false;

    /* renamed from: f */
    private int f52673f = 0;

    /* renamed from: g */
    private Integer f52674g = null;

    /* renamed from: h */
    private int f52675h = 0;

    /* renamed from: i */
    private long f52676i = 0;

    /* renamed from: j */
    private long f52677j = 0;

    /* renamed from: k */
    private boolean f52678k = false;

    /* renamed from: l */
    private boolean f52679l = false;

    /* renamed from: m */
    private boolean f52680m = false;

    /* renamed from: n */
    private Integer f52681n;

    public FakeAppUpdateManager(Context context) {
        this.f52668a = new C18265a(context);
        this.f52669b = context;
    }

    /* renamed from: a */
    private final int m37413a() {
        if (!this.f52672e) {
            return 1;
        }
        int i = this.f52670c;
        return (i == 0 || i == 4 || i == 5 || i == 6) ? 2 : 3;
    }

    /* renamed from: a */
    private final boolean m37414a(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        int i;
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.f52679l = true;
            i = 1;
        } else {
            this.f52678k = true;
            i = 0;
        }
        this.f52681n = i;
        return true;
    }

    /* renamed from: b */
    private final void m37415b() {
        this.f52668a.mo149189a(InstallState.m37742a(this.f52670c, this.f52676i, this.f52677j, this.f52671d, this.f52669b.getPackageName()));
    }

    public Task<Void> completeUpdate() {
        int i = this.f52671d;
        if (i != 0) {
            return Tasks.m38220a((Exception) new InstallException(i));
        }
        int i2 = this.f52670c;
        if (i2 != 11) {
            return i2 == 3 ? Tasks.m38220a((Exception) new InstallException(-8)) : Tasks.m38220a((Exception) new InstallException(-7));
        }
        this.f52670c = 3;
        this.f52680m = true;
        Integer num = 0;
        if (num.equals(this.f52681n)) {
            m37415b();
        }
        return Tasks.m38221a(null);
    }

    public void downloadCompletes() {
        int i = this.f52670c;
        if (i == 2 || i == 1) {
            this.f52670c = 11;
            this.f52676i = 0;
            this.f52677j = 0;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.f52681n)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i = this.f52670c;
        if (i == 1 || i == 2) {
            this.f52670c = 5;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
            this.f52681n = null;
            this.f52679l = false;
            this.f52670c = 0;
        }
    }

    public void downloadStarts() {
        if (this.f52670c == 1) {
            this.f52670c = 2;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
        }
    }

    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        PendingIntent pendingIntent4;
        int i = this.f52671d;
        if (i != 0) {
            return Tasks.m38220a((Exception) new InstallException(i));
        }
        if (m37413a() == 2 && this.f52671d == 0) {
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f52669b, 0, new Intent(), 0);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(this.f52669b, 0, new Intent(), 0);
            PendingIntent broadcast3 = PendingIntent.getBroadcast(this.f52669b, 0, new Intent(), 0);
            pendingIntent3 = broadcast;
            pendingIntent4 = broadcast2;
            pendingIntent2 = PendingIntent.getBroadcast(this.f52669b, 0, new Intent(), 0);
            pendingIntent = broadcast3;
        } else {
            pendingIntent4 = null;
            pendingIntent3 = null;
            pendingIntent2 = null;
            pendingIntent = null;
        }
        return Tasks.m38221a(AppUpdateInfo.m37370a(this.f52669b.getPackageName(), this.f52673f, m37413a(), this.f52670c, this.f52674g, this.f52675h, this.f52676i, this.f52677j, 0, 0, pendingIntent4, pendingIntent3, pendingIntent2, pendingIntent));
    }

    public Integer getTypeForUpdateInProgress() {
        return this.f52681n;
    }

    public void installCompletes() {
        if (this.f52670c == 3) {
            this.f52670c = 4;
            this.f52672e = false;
            this.f52673f = 0;
            this.f52674g = null;
            this.f52675h = 0;
            this.f52676i = 0;
            this.f52677j = 0;
            this.f52679l = false;
            this.f52680m = false;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
            this.f52681n = null;
            this.f52670c = 0;
        }
    }

    public void installFails() {
        if (this.f52670c == 3) {
            this.f52670c = 5;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
            this.f52681n = null;
            this.f52680m = false;
            this.f52679l = false;
            this.f52670c = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.f52678k;
    }

    public boolean isImmediateFlowVisible() {
        return this.f52679l;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.f52680m;
    }

    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f52668a.mo149188a(installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j) {
        if (this.f52670c == 2 && j <= this.f52677j) {
            this.f52676i = j;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
        }
    }

    public void setClientVersionStalenessDays(Integer num) {
        if (this.f52672e) {
            this.f52674g = num;
        }
    }

    public void setInstallErrorCode(int i) {
        this.f52671d = i;
    }

    public void setTotalBytesToDownload(long j) {
        if (this.f52670c == 2) {
            this.f52677j = j;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
        }
    }

    public void setUpdateAvailable(int i) {
        this.f52672e = true;
        this.f52673f = i;
    }

    public void setUpdateNotAvailable() {
        this.f52672e = false;
        this.f52674g = null;
    }

    public void setUpdatePriority(int i) {
        if (this.f52672e) {
            this.f52675h = i;
        }
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        return m37414a(appUpdateInfo, appUpdateOptions) ? Tasks.m38221a(-1) : Tasks.m38220a((Exception) new InstallException(-6));
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, Activity activity, int i2) {
        return m37414a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        return m37414a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) {
        return m37414a(appUpdateInfo, appUpdateOptions);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) {
        return m37414a(appUpdateInfo, appUpdateOptions);
    }

    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f52668a.mo149191b(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.f52678k || this.f52679l) {
            this.f52678k = false;
            this.f52670c = 1;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
        }
    }

    public void userCancelsDownload() {
        int i = this.f52670c;
        if (i == 1 || i == 2) {
            this.f52670c = 6;
            Integer num = 0;
            if (num.equals(this.f52681n)) {
                m37415b();
            }
            this.f52681n = null;
            this.f52679l = false;
            this.f52670c = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.f52678k || this.f52679l) {
            this.f52678k = false;
            this.f52679l = false;
            this.f52681n = null;
            this.f52670c = 0;
        }
    }
}
