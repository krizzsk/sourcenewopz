package com.google.android.play.core.splitinstall;

/* renamed from: com.google.android.play.core.splitinstall.s */
final class C18592s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f53341a;

    /* renamed from: b */
    final /* synthetic */ int f53342b;

    /* renamed from: c */
    final /* synthetic */ int f53343c;

    /* renamed from: d */
    final /* synthetic */ C18593t f53344d;

    C18592s(C18593t tVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.f53344d = tVar;
        this.f53341a = splitInstallSessionState;
        this.f53342b = i;
        this.f53343c = i2;
    }

    public final void run() {
        C18593t tVar = this.f53344d;
        SplitInstallSessionState splitInstallSessionState = this.f53341a;
        tVar.mo149189a(new C18548a(splitInstallSessionState.sessionId(), this.f53342b, this.f53343c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.mo149263a(), splitInstallSessionState.mo149264b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.mo149266c()));
    }
}
