package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C18490ck;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.i */
final class C18581i implements SplitInstallManager {

    /* renamed from: a */
    private final C18490ck<C18607w> f53321a;

    /* renamed from: b */
    private final C18490ck<FakeSplitInstallManager> f53322b;

    /* renamed from: c */
    private final C18490ck<File> f53323c;

    C18581i(C18490ck<C18607w> ckVar, C18490ck<FakeSplitInstallManager> ckVar2, C18490ck<File> ckVar3) {
        this.f53321a = ckVar;
        this.f53322b = ckVar2;
        this.f53323c = ckVar3;
    }

    /* renamed from: a */
    private final SplitInstallManager m38152a() {
        return (SplitInstallManager) (this.f53323c.mo149139a() == null ? this.f53321a : this.f53322b).mo149139a();
    }

    public final Task<Void> cancelInstall(int i) {
        return m38152a().cancelInstall(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return m38152a().deferredInstall(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return m38152a().deferredLanguageInstall(list);
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return m38152a().deferredLanguageUninstall(list);
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return m38152a().deferredUninstall(list);
    }

    public final Set<String> getInstalledLanguages() {
        return m38152a().getInstalledLanguages();
    }

    public final Set<String> getInstalledModules() {
        return m38152a().getInstalledModules();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return m38152a().getSessionState(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return m38152a().getSessionStates();
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m38152a().registerListener(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return m38152a().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return m38152a().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }

    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        return m38152a().startInstall(splitInstallRequest);
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m38152a().unregisterListener(splitInstallStateUpdatedListener);
    }
}
